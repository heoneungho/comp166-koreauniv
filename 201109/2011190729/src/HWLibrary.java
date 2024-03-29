import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;

class Node {
	public Object data;
	public Node next;
	Node (Object data, Node next){
		this.data = data;
		this.next = next;
	}
}
class MylinkedList {
	public Node head;
	public int size;
	MylinkedList(){
		size = 0;
		head = null;
	}
	public boolean isEmpty(){
		if (size == 0) return true;
		else return false;
	}
	public int indexOf(Object node){
		int index = 0;
		Node bufnode = head;
		while(bufnode != null){
			if (bufnode.data.equals(node)) break;
			bufnode = bufnode.next;
			index++;
		}
		if (index == size) return -1;
		else return index;
	}
	public void add(Object node) {
		Node newNode = new Node(node, null);
		newNode.next = head;
		head = newNode;
		size++;
	}
	public void remove(Object node){
		int index = indexOf(node);
		Node bufnode = head;
		if(index == 0){
			head = head.next;
			size--;
			return;
		}
		for(int i = 0; i < index-1; i++) bufnode = bufnode.next;
		if (bufnode.next != null) bufnode.next = bufnode.next.next;
		else bufnode.next = null;
	}
	public Object get(int i){
		Node bufnode = head;
		for (int k = 0; k < i; k++) bufnode = bufnode.next;
		return bufnode.data;
	}
	public Object getFirst(){
		return head.data;
	}
}

class BookList extends MylinkedList{
	public BookList(){
		super();
	}
	public Book[] display() {				// 저자가 가지고 있는 책의 이름을 모두 리턴
		Book[] books = new Book[size];
		Node bufnode = head;
		for (int i = 0; i < size; i++) {
			books[i] = (Book)bufnode.data;
			bufnode = bufnode.next;
		}
		return books;
	}
}
class AuthorAndBook {
	public String name;
	public Book[] books;
	AuthorAndBook(){}
	AuthorAndBook(String name, Book[] books){
		this.name = name;
		this.books = books;
	}
}
class Author {							// 저자 : 저자의 이름과 저자의 책을을 담고 있다.
	public String name;
	public BookList books = new BookList();
	public Author(){}
	public boolean equals(Object node){
		return name.equalsIgnoreCase(((Author)node).name);
	}
	public AuthorAndBook display(){		// 각 알파벳에 해당하는 저자와, 그 저자가 가지고 있는 모든 책을
										// 임의의 AuthorAndBook 이라는 객체에 저장해서 이를 리턴
		AuthorAndBook returnlist = new AuthorAndBook(name, books.display());;
		return returnlist;
	}
}
class AuthorList extends MylinkedList {
	public AuthorList(){
		super();
	}
	public AuthorAndBook[] display(){
		AuthorAndBook[] AuthorAndBooks = new AuthorAndBook[size];
		Node bufnode = head;
		for(int i = 0; i < size; i++) {
			AuthorAndBooks[i] = ((Author)bufnode.data).display();
			bufnode = bufnode.next;
		}
		return AuthorAndBooks;
	}
}

class PatronList extends MylinkedList {
	public PatronList(){
		super();
	}
}
class Book {
	public float BookId;
	public int NumOfSameBook;
	public String title;
	public Patron patron = null;
	public Author author = null;
	public static int idNum = 0;
	public Book(){
		NumOfSameBook = 1;
		BookId = idNum++;
	}
	public boolean equals(Object node){
		return title.equalsIgnoreCase(((Book)node).title);
	}
}
class Patron{
	public String name;
	public BookList books = new BookList();
	public Patron(){}
	public boolean equals(Object node){
		return name.equalsIgnoreCase(((Patron)node).name);
	}
	public void display(){
		
	}
}
class CheckedOutBook {
	public Author author = null;
	public Book book = null;
	public CheckedOutBook(){}
	public boolean equals(Object node){
		return book.title.equalsIgnoreCase(((CheckedOutBook)node).book.title)
		&& author.name.equalsIgnoreCase(((CheckedOutBook)node).author.name);
	}
}
public class HWLibrary implements ActionListener {
	private static final int Inserting = 0;
	private static final int Renting = 1;
	private static final int Returning = 2;
	private static final int SearchWithAuthor = 3;
	private static final int SearchWithBook = 4;
	private static final int Print = 5;
	private static final boolean save = true;
	private static final boolean print = false;
	static  Main_Frame displays = new Main_Frame("HW#3 도서관리 프로그램");
	private String OutputText = "";
	private JOption OptionWindow;
	private JFileChooser files;							// 파일 대화상자
	private File modelFile;
	private boolean fileopen = false;
	private BufferedReader FileStream;
	private AuthorList[] Catalog= new AuthorList[(int)('Z' + 1)];	// 저자의 리스트
	private BookList[] Books = new BookList[(int)('Z' + 1)];
	private PatronList[] Peoples= new PatronList[(int)('Z' + 1)];	// 저자의 리스트

	HWLibrary(){
		files = new JFileChooser();			// 디폴트 드렉토리를 C 드라이브로 설정
		ExtensionFilter filter = new ExtensionFilter(".txt", "Text file (*.txt)");
		files.addChoosableFileFilter(filter);
		files.setFileFilter(filter);
		Initialize();
	}
	private void Initialize(){
		Book.idNum = 0;

		for (int i = 0; i<= (int)'Z'; i++) {
			Catalog[i] = new AuthorList();
			Peoples[i] = new PatronList();
			Books[i] = new BookList();
		}		
	}
	private void DisplayStatus(String author, String book, boolean save) {
		displays.myModel.setRowCount(0);
		OutputText = "";

		for (int i = (int)'A'; i <=(int)'Z' ; i++){			// 전체 출력 또는 사람 이름으로 찾는경우
			if(!Catalog[i].isEmpty() && book == "") {		// Suppliment 의 Display함수를 최대한 유지하여, 출력.
				int AuthorSize = Catalog[i].display().length;
				for(int j = 0; j < AuthorSize; j++){		// 각 알파벳에 들어있는 저자의 수 만큼 저자를 출력
					int BookSize = Catalog[i].display()[j].books.length;
					for(int m = 0; m < BookSize; m ++){		// 한 저자가 가지는 책의 수만큼 출력
						String[] outstring = new String[4];
						outstring[2] = Catalog[i].display()[j].name;
						if (!outstring[2].toUpperCase().contains(author.toUpperCase()) && author != "") continue;
						outstring[0] = Catalog[i].display()[j].books[m].title;	// 책 이름을 출력
						outstring[1] = padding(Float.toString(Catalog[i].display()[j].books[m].BookId), 5); // 책 제목을 출력.
						if(save) OutputText += outstring[2] + "," + outstring[0];
						if(Catalog[i].display()[j].books[m].patron != null){
							outstring[3] = Catalog[i].display()[j].books[m].patron.name;
							if(save) OutputText += "," + outstring[3] + "\n";
							if (author == "") outstring[3] = "대출중";	// 전체 출력을 할때에는 대출자의 이름을 출력하지 않는다.
															// 즉, 저자로 검색할 때는 대출자의 이름이 출력된다. 물론 상태 역시 출력된다.
						}
						else {
							if(save) OutputText += "\n";
							outstring[3] = "";
						}
						displays.myModel.addRow(outstring);
					}					
				}
			}												// 책 제목으로 찾는경우
			else if (!Books[i].isEmpty() && book != ""){	// 간단히 링크드 리스트를 순서대로 꺼내와서 출력
				int BookSize = Books[i].display().length;
				for(int j = 0; j < BookSize; j++){
					Book GetBook = null;
					String[] outstring = new String[4];
					GetBook = (Book)Books[i].get(j);
					outstring[0] = GetBook.title; 
					outstring[1] = padding(Float.toString(GetBook.BookId), 5);
					if(!outstring[0].toUpperCase().contains(book.toUpperCase())) continue;
					outstring[2] = ((Book)Books[i].get(j)).author.name;
					if(GetBook.patron != null)	outstring[3] = "대출중";					// 책 목록으로 출력할 때 역시 대출자의 이름을 출력하지 않고 다만 대출 상태만 쎌을 표시한다.
					else outstring[3] = "";
					displays.myModel.addRow(outstring);
				}				
			}
		}
	}
	private String padding(String number, int max){
		int length = number.length();
		if(length >= max) return number;
		else {
			String output = "";
			for(int i = 0; i < max - length; i++){
				output += "0";
			}
			output += number;
			return output;
		}
	}
	private void print(String message){
		JOptionPane.showMessageDialog(null, message);
	}
	private void checkOutBook(String PatronName, String AuthorName, String BookTitle) {
		Patron patron = new Patron(), patronRef;
		Author author = new Author(), authorRef = new Author();
		Book book = new Book();
		Book.idNum--;
		int patronIndex, bookIndex = -1, authorIndex = -1;
		patron.name = PatronName;
		author.name = AuthorName;
		book.title = BookTitle;
		authorIndex = Catalog[(int)author.name.toUpperCase().charAt(0)].indexOf(author);
		if (authorIndex == -1) {	// 우선 고객이 찾는 책이 도서관에 존재하는지 검사한다.
			print("저자의 철자가 잘못 입력되었습니다.");
			return;
		}
		authorRef = (Author)(Catalog[(int)author.name.toUpperCase().charAt(0)].get(authorIndex));
		bookIndex = authorRef.books.indexOf(book);
		if(bookIndex == -1) {		// 다음에 그 저자가 쓴 책이 존재하는지 검사한다.
			print("책 제목의 철자가 잘못 입력되었습니다.");
			return;
		}
		Book bookRef = (Book)authorRef.books.get(bookIndex);
		if(bookRef.patron != null) {
			print("고객님께서는 원하시는 " + book.title + "은 대출 중입니다.");
			return;			
		}
		CheckedOutBook bookToCheckOut = new CheckedOutBook();
		bookToCheckOut.author = authorRef;
		bookToCheckOut.book = bookRef;
		patronIndex = Peoples[(int)patron.name.toUpperCase().charAt(0)].indexOf(patron);
		if(patronIndex == -1){
			patron.books.add(bookToCheckOut);
			Peoples[(int)patron.name.toUpperCase().charAt(0)].add(patron);
			bookRef.patron = (Patron)(Peoples[(int)patron.name.toUpperCase().charAt(0)].getFirst());
		}
		else {					// 원래 등록된 고객이라면,
			PatronList patrons = Peoples[(int)patron.name.toUpperCase().charAt(0)];
			patronRef = (Patron)patrons.get(patronIndex);
			int patronsbookindex = -1;

			if ((patronsbookindex = patronRef.books.indexOf(bookToCheckOut)) != -1){
				print(patronRef.name+ " 고객님께서는 이미 " + book.title + "을 "+ "대출해 가셨습니다.");
				return;
			}

			patronRef.books.add(bookToCheckOut);
			bookRef.patron = patronRef;
		}
	}
	private void returnBook(){
		Patron patron = new Patron();
		Book book = new Book();
		Author author = new Author(), authorRef = new Author();
		int patronIndex = -1, bookIndex = -1, authorIndex = -1;
		String[] InputString = new String[3];			// 이름, 저자명, 책 제목 순
		OptionWindow = new JOption(displays, "", 2);
		InputString = OptionWindow.GetData();
		patron.name = InputString[0];
		author.name = InputString[1];		
		book.title = InputString[2];
		patronIndex = Peoples[(int)patron.name.toUpperCase().charAt(0)].indexOf(patron);
		if(patronIndex == -1) {
			print("대출자의 이름을 잘못 입력하였습니다.");
			return;
		}
		authorIndex = Catalog[(int)author.name.toUpperCase().charAt(0)].indexOf(author);
		if(authorIndex == -1) {
			print("저자의 이름을 잘못 입력하엿습니다.");
			return;
		}
		authorRef = (Author)Catalog[(int)author.name.toUpperCase().charAt(0)].get(authorIndex);
		bookIndex = authorRef.books.indexOf(book);
		if(bookIndex == -1) {
			print("책 제목을 잘못 입력하였습니다.");
			return;
		}
		CheckedOutBook checkedOutBook = new CheckedOutBook();
		checkedOutBook.author = authorRef;
		checkedOutBook.book = (Book) authorRef.books.get(bookIndex);
		((Book)authorRef.books.get(bookIndex)).patron = null;
		((Patron)Peoples[(int)patron.name.toUpperCase().charAt(0)].get(patronIndex)).books.remove(checkedOutBook);
	}
	private void includeBook(String name, String title){
		Author newAuthor = new Author();				// 새로운 저자가 저장될 객체
		Author oldAuthor = null;
		int oldAuthorIndex;								// 이미 저자가 존재한다면, 이전 저자의 위치를 가리침
		Book newBook = new Book();						// 새로운 책이 저장될 객체
		newAuthor.name = name;				// 새로운 저자의 이름과 
		newBook.title = title;					// 새로운 책의 이름을 저장한다.
		
		BookList bookList = Books[(int)newBook.title.toUpperCase().toUpperCase().charAt(0)];
		int bookindex = bookList.indexOf(newBook);		// 저자가 다르고 책이름은 같을 경우. BOOK에 ID를 부여 한다.
		if(bookindex != -1){
			Book.idNum--;
			Book BookRef = (Book)bookList.get(bookindex);
			newBook.BookId = (int)BookRef.BookId+ ((float)BookRef.NumOfSameBook / (float)10.0);
			BookRef.NumOfSameBook++;
			newBook.NumOfSameBook  = BookRef.NumOfSameBook;
		}
		// 이미 동일한 저자가 있다면 그 저자의 위치를 검색한다.
		oldAuthorIndex = Catalog[(int)newAuthor.name.toUpperCase().toUpperCase().charAt(0)].indexOf(newAuthor);
		if(oldAuthorIndex == -1){						// 입력된 저자 이름이 새로운 저자라면,
			newAuthor.books.add(newBook);				// 새로운 저자와 책을 동시에 연결하여 저장한다.
			Catalog[(int)newAuthor.name.toUpperCase().toUpperCase().charAt(0)].add(newAuthor);
			newBook.author = newAuthor;
		}
		else {
			oldAuthor = (Author)Catalog[(int)newAuthor.name.toUpperCase().toUpperCase().charAt(0)].get(oldAuthorIndex);
			if((oldAuthor.books.indexOf(newBook)) != -1) {
				print("저자 :" + newAuthor.name + "님은 이미 " + newBook.title + "을 지었습니다.");
				return;
			}
			oldAuthor.books.add(newBook);
			newBook.author = newAuthor;
		}
		Books[(int)newBook.title.toUpperCase().toUpperCase().charAt(0)].add(newBook);
	}
	private File showDialog(String Title, String ButtonText, String ButtonTooltip, char Mnemonic, File file){
		files.setDialogTitle(Title);
		files.setApproveButtonText(ButtonText);
		files.setApproveButtonToolTipText(ButtonTooltip);
		files.setApproveButtonMnemonic(Mnemonic);
		files.setFileSelectionMode(files.FILES_ONLY);
		files.rescanCurrentDirectory();
		files.setSelectedFile(file);
		int result = files.showDialog(null, null);						// 대화상자를 나타낸다.
		return (result == files.APPROVE_OPTION) ? files.getSelectedFile() : null;	// 파일이 선택되면 그 파일을 리턴 아니면, NULL
	}
	private void saveSketch(File outFile, String DisplayText) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
			byte[] ByteString = new byte[DisplayText.length()];
			ByteString = DisplayText.getBytes();
			for (int cnt = 0; cnt < ByteString.length; cnt++){
				if(ByteString[cnt] == '\n') out.newLine();
				else out.write(ByteString[cnt]);
			}
			out.close();
		} catch(IOException e){
			JOptionPane.showMessageDialog(null, 
				"Error writing a Text file.", "File Output Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(outFile != modelFile){
			modelFile = outFile;
			displays.setTitle(displays.frameTitle + " <" + modelFile.getPath() + "> ");		// 프레임에 저장된 파일의 이름을 표시한다.
		}
	}

	private void saveOperation(){
		if(!fileopen) return;
		File file = modelFile;
		file = showDialog("Save Text", "Save", "Save the Library DateBase", 's', null);
		if(file.exists() && JOptionPane.NO_OPTION ==		 			// 동일한 파일이 이미 존재할경우.
			JOptionPane.showConfirmDialog(null, file.getName()+
					"이 이미존재합니다. 덮어 쓰시겠습니까?", "Confirm Save As",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE )) return;
		DisplayStatus("", "", save);
		saveSketch(file, OutputText);
	}

	public void run(){
		for (int i = 0; i < displays.GetNumberOfButton(); i++){
			(displays.Button(i)).addActionListener(this);
		}
		displays.LoadItem.addActionListener(this);
		displays.SaveItem.addActionListener(this);
		displays.ExitItem.addActionListener(this);
	}
	private void ReadFile(File inFile){								// 파일을 읽는다.
		try {
			FileStream = new BufferedReader(new FileReader(inFile.getAbsolutePath()));
		}catch(IOException ei){
			JOptionPane.showMessageDialog(null, "파일을 읽지 못했습니다.", "File Input Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	private void openOperation(File inFile){
		String strLine;
		ReadFile(inFile);
		try {
			for(int cnt = 0;((strLine=FileStream.readLine())!=null); cnt++){	// 원본 코드 출력
				StringTokenizer input =  new StringTokenizer(strLine, ",");
				if(input.hasMoreTokens()){
					String name = input.nextToken();
					String title = input.nextToken();
					includeBook(name, title);
					if(input.hasMoreTokens()){
						String patron = input.nextToken();
						checkOutBook(patron, name, title);
					}
				}
			}
		}catch(IOException ei){
			JOptionPane.showMessageDialog(null, "파일을 읽지 못했습니다.", "File Input Error", JOptionPane.ERROR_MESSAGE);
        }
		DisplayStatus("", "", print);
	}
	public void actionPerformed (ActionEvent e) {				// 버튼을 누르면 이벤트가 발생하여 실행되는 루틴
		if(e.getSource() == displays.Button(Inserting)){		// 새 책을 삽입
			String[] InputString = new String[3];			// 입력된 이름, 저자, 책 제목이 저장될 문자열
			OptionWindow = new JOption(displays, "", 0);
			InputString = OptionWindow.GetData();
			includeBook(InputString[1], InputString[2]);
		}
		else if(e.getSource() == displays.Button(Renting)){		// 대출
			String[] InputString = new String[3];			// 이름, 저자명, 책 제목 순
			OptionWindow = new JOption(displays, "", 1);
			InputString = OptionWindow.GetData();
			checkOutBook(InputString[0], InputString[1], InputString[2]);
		}
		else if(e.getSource() == displays.Button(Returning)){	// 반납
			returnBook();
		}
		else if(e.getSource() == displays.Button(SearchWithAuthor)){
			String AuthorName = JOptionPane.showInputDialog("저자명을  입력하세요");
			DisplayStatus(AuthorName, "", print);
		}
		else if(e.getSource() == displays.Button(SearchWithBook)){
			String BookName = JOptionPane.showInputDialog("책 제목을 입력하세요");
			DisplayStatus("", BookName, print);
		}
		else if(e.getSource() == displays.Button(Print)){
			DisplayStatus("", "", print);
		}		
		else if(e.getSource() == displays.LoadItem){				// 메뉴의 로드 버튼을 눌렀을 때
			File inFile = showDialog("도서관 데이터 베이스 읽어오기", "Open", "파일로부터 도서관의 목록을 가져 온다.", 'B', null);
			if(inFile != null) {
				fileopen = true;
				Initialize();
				openOperation(inFile);
			}
		}
		else if(e.getSource() == displays.SaveItem){				// 메뉴의 저장 버튼을 눌렀을 때
			saveOperation();
		}	
		else if(e.getSource() == displays.ExitItem){				// 메뉴의 종료 버튼을 눌렀을 때
			System.exit(1);
		}	
	}		
	public static void main(String[] args) {
		(new HWLibrary()).run();
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 출력 관련 윈도우, JOption JFrame은 고객, 저자, 책이름을 받기 위한 창이다. 이부분 이하는 모두 출력에 관한 내용이다.////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class JOption extends JDialog implements ActionListener{
	private Font myFont = new Font("self", Font.BOLD, 14);// 카드의 폰트 설정
	private JTextArea[] Texts = new JTextArea[3];
	private String ReturnString[] = {"", "", "", ""};
	private JLabel[] Labels = new JLabel[4];
	private String LabelString[] = {"이  름  :", "저자명  :", "책제목  :", ""};
	private JPanel[] SubPanel = new JPanel[5];
	private JButton Check = new JButton("확인");
	private JButton Cancel = new JButton("취소");
	private JPanel RootPanel = new JPanel();
	JOption(Frame parent, String title, int OptionNumber){
		super(parent, title, true);
		int index = 0;
		switch (OptionNumber) {
		case 0:
			setTitle("새로운 책 추가");
			LabelString[3] = "새로운 책의 저자명과 책의 제목을 입력하시오!!";
			index = 1;
			Texts[0] = new JTextArea();
			break;
		case 1:
			setTitle("대  출");
			LabelString[3] = "본인의 이름과 책의 저자명, 제목을 입력하시오!!";
			break;
		case 2:
			setTitle("반  납");
			LabelString[3] = "본인의 이름과 책의 저자명, 제목을 입력하시오!!";
			break;
		}
		Toolkit theKit = getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		setBounds(wndSize.width/16, wndSize.width/16, 400, 300);	// 창의 위치 및 크기 설정
		Check.addActionListener(this);
		Cancel.addActionListener(this);
		
		RootPanel.setLayout(new BoxLayout(RootPanel, BoxLayout.Y_AXIS));	// 레이아웃 매니저 생성
		SubPanel[4] = new JPanel();
		Labels[3] = new JLabel(LabelString[3]);
		Labels[3].setPreferredSize(new Dimension(350, 30));
		Labels[3].setFont(myFont);
		SubPanel[4].add(Labels[3]);
		RootPanel.add(SubPanel[4]);
		for(; index < 4; index++){
			SubPanel[index] = new JPanel();
			if (index < 3){
				Labels[index] = new JLabel(LabelString[index]);
				Labels[index].setPreferredSize(new Dimension(60, 30));
				SubPanel[index].add(Labels[index]);
				Texts[index] = new JTextArea();
				Texts[index].setPreferredSize(new Dimension(100, 30));
				SubPanel[index].add(Texts[index]);
			}
			if (index == 3) {
				Check.setPreferredSize(new Dimension(80, 40));
				Cancel.setPreferredSize(new Dimension(80, 40));
				SubPanel[index].add(Check);		
				SubPanel[index].add(Cancel);	
			}
			RootPanel.add(SubPanel[index]);
		}
		getContentPane().add(RootPanel);
		setVisible(true);			
	}
	public void actionPerformed (ActionEvent e) {	
		if(e.getSource() == Check){
			for(int i = 0; i < 3; i++) ReturnString[i] = Texts[i].getText();
			setVisible(false);
		}
		else if(e.getSource() == Cancel){
			for(int i = 0; i < 3; i++) ReturnString[i] = "NULL";
			setVisible(false);
		}
	}
	public String[] GetData (){
		return ReturnString;
	}
}
class MyRender extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	private Color SelecteColor = new Color(255, 220, 220);	
	MyRender(){}
	public void setValue(Object Value){
		if ((String)Value != ""){
			setBackground(SelecteColor);
			setText((String)Value);
		}
		else {
			setBackground(Color.white);
			setText("");
		}
	}
}	

class Main_Frame extends JFrame {
	private static final int NumberOfButton = 6;
	private static final long serialVersionUID = 1L;
	public JMenuBar menuBar = new JMenuBar();
	public JMenuItem LoadItem, SaveItem, ExitItem;
	private Font myFont = new Font("self", Font.BOLD, 12);// 카드의 폰트 설정
	private JPanel RootPanel = new JPanel();			// 두개의 패널들의 부모패널
	private JPanel topPanel, CenterPanel;				// 버튼을 달고있는 패널
	public JTable LibraryBooks = new JTable();							// The Table for showing Indexed List
	public DefaultTableModel myModel;					// Table model for display all data
	public MyRender myrender = new MyRender();
	public String frameTitle;
	private Color BackgroundColor = new Color(10, 10, 70);						// 각 페널의 색깔을 지정
	private JButton[] FunctionButton = new JButton[6];				// 플레이어 버튼 설정
	private String ButtonName[] = {"새로 들어온 책 입력","대   출", "반   납", "저자명으로 검색", "책 제목으로 검색", "전체출력"};
	
	Main_Frame(String title){
		setTitle(title);
		frameTitle = title;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(menuBar);
		Toolkit theKit = getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		int WindowHeightSize = wndSize.height - 300;
		int WindowWidthSize = wndSize.width - 400;
		int Size[] = {WindowWidthSize / 5, WindowWidthSize / 9, WindowWidthSize / 9, WindowWidthSize / 6, WindowWidthSize / 5, WindowWidthSize / 8};
		setBounds(wndSize.height/32, wndSize.width/32,  WindowWidthSize, WindowHeightSize);	// 창의 위치 및 크기 설정

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');		
		menuBar.add(fileMenu);
		
		LoadItem = fileMenu.add("데이터 베이스 불러오기");
		SaveItem = fileMenu.add("저장하기");
		fileMenu.addSeparator();
		ExitItem = fileMenu.add("종료");
		
		LoadItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
		SaveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));	
		ExitItem.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK));	
		
		
		CenterPanel = new JPanel();
		topPanel = new JPanel();
		RootPanel.setLayout(new BoxLayout(RootPanel, BoxLayout.Y_AXIS));	// 레이아웃 매니저 생성
		RootPanel.add(topPanel);
		RootPanel.add(CenterPanel);
		
		String str_table[] = {"책 제목","Book ID", "저자", "대출자"};						// Table  셋팅
		myModel = new DefaultTableModel(str_table, 0);
		LibraryBooks.setModel(myModel);
		LibraryBooks.setAutoResizeMode(LibraryBooks.AUTO_RESIZE_ALL_COLUMNS);
		LibraryBooks.doLayout();	
		LibraryBooks.getColumnModel().getColumn(3).setCellRenderer(myrender);
		
		for(int i = 0; i < NumberOfButton; i++){
			FunctionButton[i] = new JButton(ButtonName[i]);
			FunctionButton[i].setPreferredSize(new Dimension(Size[i], 35));	// 텍스트 윈도우의 크기
			FunctionButton[i].setFont(myFont);
			FunctionButton[i].setForeground(BackgroundColor);
			topPanel.add(FunctionButton[i]);
		}		
		
		JScrollPane scrollPanes = new JScrollPane();
		scrollPanes.setPreferredSize(new Dimension(WindowWidthSize - 50, WindowHeightSize - 120));
		CenterPanel.add(scrollPanes);
		scrollPanes.setViewportView(LibraryBooks);

		topPanel.setBackground(BackgroundColor);
		CenterPanel.setBackground(BackgroundColor);
		
		getContentPane().add(RootPanel);	
		setVisible(true);										// 만들어놓은 창을 보여준다.
	}	
	public JButton Button(int i){ return FunctionButton[i]; }
	public int GetNumberOfButton(){ return 	NumberOfButton;}
}
class ExtensionFilter extends FileFilter {				// The class for filtering every Extension
	private String description;							// except for *.txt
	private String extension;
	public ExtensionFilter(String ext, String descr){
		extension = ext.toLowerCase(); 					// 파일 확장자를 소문자로 저장
		description = descr;
	}
	public boolean accept(File file){
		return(file.isDirectory() || file.getName().toLowerCase().endsWith(extension));
	}
	public String getDescription() { return description; }
}
