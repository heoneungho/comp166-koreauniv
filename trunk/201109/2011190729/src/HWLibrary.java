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
	public Book[] display() {				// ���ڰ� ������ �ִ� å�� �̸��� ��� ����
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
class Author {							// ���� : ������ �̸��� ������ å���� ��� �ִ�.
	public String name;
	public BookList books = new BookList();
	public Author(){}
	public boolean equals(Object node){
		return name.equalsIgnoreCase(((Author)node).name);
	}
	public AuthorAndBook display(){		// �� ���ĺ��� �ش��ϴ� ���ڿ�, �� ���ڰ� ������ �ִ� ��� å��
										// ������ AuthorAndBook �̶�� ��ü�� �����ؼ� �̸� ����
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
	static  Main_Frame displays = new Main_Frame("HW#3 �������� ���α׷�");
	private String OutputText = "";
	private JOption OptionWindow;
	private JFileChooser files;							// ���� ��ȭ����
	private File modelFile;
	private boolean fileopen = false;
	private BufferedReader FileStream;
	private AuthorList[] Catalog= new AuthorList[(int)('Z' + 1)];	// ������ ����Ʈ
	private BookList[] Books = new BookList[(int)('Z' + 1)];
	private PatronList[] Peoples= new PatronList[(int)('Z' + 1)];	// ������ ����Ʈ

	HWLibrary(){
		files = new JFileChooser();			// ����Ʈ �巺�丮�� C ����̺�� ����
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

		for (int i = (int)'A'; i <=(int)'Z' ; i++){			// ��ü ��� �Ǵ� ��� �̸����� ã�°��
			if(!Catalog[i].isEmpty() && book == "") {		// Suppliment �� Display�Լ��� �ִ��� �����Ͽ�, ���.
				int AuthorSize = Catalog[i].display().length;
				for(int j = 0; j < AuthorSize; j++){		// �� ���ĺ��� ����ִ� ������ �� ��ŭ ���ڸ� ���
					int BookSize = Catalog[i].display()[j].books.length;
					for(int m = 0; m < BookSize; m ++){		// �� ���ڰ� ������ å�� ����ŭ ���
						String[] outstring = new String[4];
						outstring[2] = Catalog[i].display()[j].name;
						if (!outstring[2].toUpperCase().contains(author.toUpperCase()) && author != "") continue;
						outstring[0] = Catalog[i].display()[j].books[m].title;	// å �̸��� ���
						outstring[1] = padding(Float.toString(Catalog[i].display()[j].books[m].BookId), 5); // å ������ ���.
						if(save) OutputText += outstring[2] + "," + outstring[0];
						if(Catalog[i].display()[j].books[m].patron != null){
							outstring[3] = Catalog[i].display()[j].books[m].patron.name;
							if(save) OutputText += "," + outstring[3] + "\n";
							if (author == "") outstring[3] = "������";	// ��ü ����� �Ҷ����� �������� �̸��� ������� �ʴ´�.
															// ��, ���ڷ� �˻��� ���� �������� �̸��� ��µȴ�. ���� ���� ���� ��µȴ�.
						}
						else {
							if(save) OutputText += "\n";
							outstring[3] = "";
						}
						displays.myModel.addRow(outstring);
					}					
				}
			}												// å �������� ã�°��
			else if (!Books[i].isEmpty() && book != ""){	// ������ ��ũ�� ����Ʈ�� ������� �����ͼ� ���
				int BookSize = Books[i].display().length;
				for(int j = 0; j < BookSize; j++){
					Book GetBook = null;
					String[] outstring = new String[4];
					GetBook = (Book)Books[i].get(j);
					outstring[0] = GetBook.title; 
					outstring[1] = padding(Float.toString(GetBook.BookId), 5);
					if(!outstring[0].toUpperCase().contains(book.toUpperCase())) continue;
					outstring[2] = ((Book)Books[i].get(j)).author.name;
					if(GetBook.patron != null)	outstring[3] = "������";					// å ������� ����� �� ���� �������� �̸��� ������� �ʰ� �ٸ� ���� ���¸� ���� ǥ���Ѵ�.
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
		if (authorIndex == -1) {	// �켱 ���� ã�� å�� �������� �����ϴ��� �˻��Ѵ�.
			print("������ ö�ڰ� �߸� �ԷµǾ����ϴ�.");
			return;
		}
		authorRef = (Author)(Catalog[(int)author.name.toUpperCase().charAt(0)].get(authorIndex));
		bookIndex = authorRef.books.indexOf(book);
		if(bookIndex == -1) {		// ������ �� ���ڰ� �� å�� �����ϴ��� �˻��Ѵ�.
			print("å ������ ö�ڰ� �߸� �ԷµǾ����ϴ�.");
			return;
		}
		Book bookRef = (Book)authorRef.books.get(bookIndex);
		if(bookRef.patron != null) {
			print("���Բ����� ���Ͻô� " + book.title + "�� ���� ���Դϴ�.");
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
		else {					// ���� ��ϵ� ���̶��,
			PatronList patrons = Peoples[(int)patron.name.toUpperCase().charAt(0)];
			patronRef = (Patron)patrons.get(patronIndex);
			int patronsbookindex = -1;

			if ((patronsbookindex = patronRef.books.indexOf(bookToCheckOut)) != -1){
				print(patronRef.name+ " ���Բ����� �̹� " + book.title + "�� "+ "������ ���̽��ϴ�.");
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
		String[] InputString = new String[3];			// �̸�, ���ڸ�, å ���� ��
		OptionWindow = new JOption(displays, "", 2);
		InputString = OptionWindow.GetData();
		patron.name = InputString[0];
		author.name = InputString[1];		
		book.title = InputString[2];
		patronIndex = Peoples[(int)patron.name.toUpperCase().charAt(0)].indexOf(patron);
		if(patronIndex == -1) {
			print("�������� �̸��� �߸� �Է��Ͽ����ϴ�.");
			return;
		}
		authorIndex = Catalog[(int)author.name.toUpperCase().charAt(0)].indexOf(author);
		if(authorIndex == -1) {
			print("������ �̸��� �߸� �Է��Ͽ����ϴ�.");
			return;
		}
		authorRef = (Author)Catalog[(int)author.name.toUpperCase().charAt(0)].get(authorIndex);
		bookIndex = authorRef.books.indexOf(book);
		if(bookIndex == -1) {
			print("å ������ �߸� �Է��Ͽ����ϴ�.");
			return;
		}
		CheckedOutBook checkedOutBook = new CheckedOutBook();
		checkedOutBook.author = authorRef;
		checkedOutBook.book = (Book) authorRef.books.get(bookIndex);
		((Book)authorRef.books.get(bookIndex)).patron = null;
		((Patron)Peoples[(int)patron.name.toUpperCase().charAt(0)].get(patronIndex)).books.remove(checkedOutBook);
	}
	private void includeBook(String name, String title){
		Author newAuthor = new Author();				// ���ο� ���ڰ� ����� ��ü
		Author oldAuthor = null;
		int oldAuthorIndex;								// �̹� ���ڰ� �����Ѵٸ�, ���� ������ ��ġ�� ����ħ
		Book newBook = new Book();						// ���ο� å�� ����� ��ü
		newAuthor.name = name;				// ���ο� ������ �̸��� 
		newBook.title = title;					// ���ο� å�� �̸��� �����Ѵ�.
		
		BookList bookList = Books[(int)newBook.title.toUpperCase().toUpperCase().charAt(0)];
		int bookindex = bookList.indexOf(newBook);		// ���ڰ� �ٸ��� å�̸��� ���� ���. BOOK�� ID�� �ο� �Ѵ�.
		if(bookindex != -1){
			Book.idNum--;
			Book BookRef = (Book)bookList.get(bookindex);
			newBook.BookId = (int)BookRef.BookId+ ((float)BookRef.NumOfSameBook / (float)10.0);
			BookRef.NumOfSameBook++;
			newBook.NumOfSameBook  = BookRef.NumOfSameBook;
		}
		// �̹� ������ ���ڰ� �ִٸ� �� ������ ��ġ�� �˻��Ѵ�.
		oldAuthorIndex = Catalog[(int)newAuthor.name.toUpperCase().toUpperCase().charAt(0)].indexOf(newAuthor);
		if(oldAuthorIndex == -1){						// �Էµ� ���� �̸��� ���ο� ���ڶ��,
			newAuthor.books.add(newBook);				// ���ο� ���ڿ� å�� ���ÿ� �����Ͽ� �����Ѵ�.
			Catalog[(int)newAuthor.name.toUpperCase().toUpperCase().charAt(0)].add(newAuthor);
			newBook.author = newAuthor;
		}
		else {
			oldAuthor = (Author)Catalog[(int)newAuthor.name.toUpperCase().toUpperCase().charAt(0)].get(oldAuthorIndex);
			if((oldAuthor.books.indexOf(newBook)) != -1) {
				print("���� :" + newAuthor.name + "���� �̹� " + newBook.title + "�� �������ϴ�.");
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
		int result = files.showDialog(null, null);						// ��ȭ���ڸ� ��Ÿ����.
		return (result == files.APPROVE_OPTION) ? files.getSelectedFile() : null;	// ������ ���õǸ� �� ������ ���� �ƴϸ�, NULL
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
			displays.setTitle(displays.frameTitle + " <" + modelFile.getPath() + "> ");		// �����ӿ� ����� ������ �̸��� ǥ���Ѵ�.
		}
	}

	private void saveOperation(){
		if(!fileopen) return;
		File file = modelFile;
		file = showDialog("Save Text", "Save", "Save the Library DateBase", 's', null);
		if(file.exists() && JOptionPane.NO_OPTION ==		 			// ������ ������ �̹� �����Ұ��.
			JOptionPane.showConfirmDialog(null, file.getName()+
					"�� �̹������մϴ�. ���� ���ðڽ��ϱ�?", "Confirm Save As",
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
	private void ReadFile(File inFile){								// ������ �д´�.
		try {
			FileStream = new BufferedReader(new FileReader(inFile.getAbsolutePath()));
		}catch(IOException ei){
			JOptionPane.showMessageDialog(null, "������ ���� ���߽��ϴ�.", "File Input Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	private void openOperation(File inFile){
		String strLine;
		ReadFile(inFile);
		try {
			for(int cnt = 0;((strLine=FileStream.readLine())!=null); cnt++){	// ���� �ڵ� ���
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
			JOptionPane.showMessageDialog(null, "������ ���� ���߽��ϴ�.", "File Input Error", JOptionPane.ERROR_MESSAGE);
        }
		DisplayStatus("", "", print);
	}
	public void actionPerformed (ActionEvent e) {				// ��ư�� ������ �̺�Ʈ�� �߻��Ͽ� ����Ǵ� ��ƾ
		if(e.getSource() == displays.Button(Inserting)){		// �� å�� ����
			String[] InputString = new String[3];			// �Էµ� �̸�, ����, å ������ ����� ���ڿ�
			OptionWindow = new JOption(displays, "", 0);
			InputString = OptionWindow.GetData();
			includeBook(InputString[1], InputString[2]);
		}
		else if(e.getSource() == displays.Button(Renting)){		// ����
			String[] InputString = new String[3];			// �̸�, ���ڸ�, å ���� ��
			OptionWindow = new JOption(displays, "", 1);
			InputString = OptionWindow.GetData();
			checkOutBook(InputString[0], InputString[1], InputString[2]);
		}
		else if(e.getSource() == displays.Button(Returning)){	// �ݳ�
			returnBook();
		}
		else if(e.getSource() == displays.Button(SearchWithAuthor)){
			String AuthorName = JOptionPane.showInputDialog("���ڸ���  �Է��ϼ���");
			DisplayStatus(AuthorName, "", print);
		}
		else if(e.getSource() == displays.Button(SearchWithBook)){
			String BookName = JOptionPane.showInputDialog("å ������ �Է��ϼ���");
			DisplayStatus("", BookName, print);
		}
		else if(e.getSource() == displays.Button(Print)){
			DisplayStatus("", "", print);
		}		
		else if(e.getSource() == displays.LoadItem){				// �޴��� �ε� ��ư�� ������ ��
			File inFile = showDialog("������ ������ ���̽� �о����", "Open", "���Ϸκ��� �������� ����� ���� �´�.", 'B', null);
			if(inFile != null) {
				fileopen = true;
				Initialize();
				openOperation(inFile);
			}
		}
		else if(e.getSource() == displays.SaveItem){				// �޴��� ���� ��ư�� ������ ��
			saveOperation();
		}	
		else if(e.getSource() == displays.ExitItem){				// �޴��� ���� ��ư�� ������ ��
			System.exit(1);
		}	
	}		
	public static void main(String[] args) {
		(new HWLibrary()).run();
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ��� ���� ������, JOption JFrame�� ��, ����, å�̸��� �ޱ� ���� â�̴�. �̺κ� ���ϴ� ��� ��¿� ���� �����̴�.////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class JOption extends JDialog implements ActionListener{
	private Font myFont = new Font("self", Font.BOLD, 14);// ī���� ��Ʈ ����
	private JTextArea[] Texts = new JTextArea[3];
	private String ReturnString[] = {"", "", "", ""};
	private JLabel[] Labels = new JLabel[4];
	private String LabelString[] = {"��  ��  :", "���ڸ�  :", "å����  :", ""};
	private JPanel[] SubPanel = new JPanel[5];
	private JButton Check = new JButton("Ȯ��");
	private JButton Cancel = new JButton("���");
	private JPanel RootPanel = new JPanel();
	JOption(Frame parent, String title, int OptionNumber){
		super(parent, title, true);
		int index = 0;
		switch (OptionNumber) {
		case 0:
			setTitle("���ο� å �߰�");
			LabelString[3] = "���ο� å�� ���ڸ�� å�� ������ �Է��Ͻÿ�!!";
			index = 1;
			Texts[0] = new JTextArea();
			break;
		case 1:
			setTitle("��  ��");
			LabelString[3] = "������ �̸��� å�� ���ڸ�, ������ �Է��Ͻÿ�!!";
			break;
		case 2:
			setTitle("��  ��");
			LabelString[3] = "������ �̸��� å�� ���ڸ�, ������ �Է��Ͻÿ�!!";
			break;
		}
		Toolkit theKit = getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		setBounds(wndSize.width/16, wndSize.width/16, 400, 300);	// â�� ��ġ �� ũ�� ����
		Check.addActionListener(this);
		Cancel.addActionListener(this);
		
		RootPanel.setLayout(new BoxLayout(RootPanel, BoxLayout.Y_AXIS));	// ���̾ƿ� �Ŵ��� ����
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
	private Font myFont = new Font("self", Font.BOLD, 12);// ī���� ��Ʈ ����
	private JPanel RootPanel = new JPanel();			// �ΰ��� �гε��� �θ��г�
	private JPanel topPanel, CenterPanel;				// ��ư�� �ް��ִ� �г�
	public JTable LibraryBooks = new JTable();							// The Table for showing Indexed List
	public DefaultTableModel myModel;					// Table model for display all data
	public MyRender myrender = new MyRender();
	public String frameTitle;
	private Color BackgroundColor = new Color(10, 10, 70);						// �� ����� ������ ����
	private JButton[] FunctionButton = new JButton[6];				// �÷��̾� ��ư ����
	private String ButtonName[] = {"���� ���� å �Է�","��   ��", "��   ��", "���ڸ����� �˻�", "å �������� �˻�", "��ü���"};
	
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
		setBounds(wndSize.height/32, wndSize.width/32,  WindowWidthSize, WindowHeightSize);	// â�� ��ġ �� ũ�� ����

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');		
		menuBar.add(fileMenu);
		
		LoadItem = fileMenu.add("������ ���̽� �ҷ�����");
		SaveItem = fileMenu.add("�����ϱ�");
		fileMenu.addSeparator();
		ExitItem = fileMenu.add("����");
		
		LoadItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
		SaveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));	
		ExitItem.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK));	
		
		
		CenterPanel = new JPanel();
		topPanel = new JPanel();
		RootPanel.setLayout(new BoxLayout(RootPanel, BoxLayout.Y_AXIS));	// ���̾ƿ� �Ŵ��� ����
		RootPanel.add(topPanel);
		RootPanel.add(CenterPanel);
		
		String str_table[] = {"å ����","Book ID", "����", "������"};						// Table  ����
		myModel = new DefaultTableModel(str_table, 0);
		LibraryBooks.setModel(myModel);
		LibraryBooks.setAutoResizeMode(LibraryBooks.AUTO_RESIZE_ALL_COLUMNS);
		LibraryBooks.doLayout();	
		LibraryBooks.getColumnModel().getColumn(3).setCellRenderer(myrender);
		
		for(int i = 0; i < NumberOfButton; i++){
			FunctionButton[i] = new JButton(ButtonName[i]);
			FunctionButton[i].setPreferredSize(new Dimension(Size[i], 35));	// �ؽ�Ʈ �������� ũ��
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
		setVisible(true);										// �������� â�� �����ش�.
	}	
	public JButton Button(int i){ return FunctionButton[i]; }
	public int GetNumberOfButton(){ return 	NumberOfButton;}
}
class ExtensionFilter extends FileFilter {				// The class for filtering every Extension
	private String description;							// except for *.txt
	private String extension;
	public ExtensionFilter(String ext, String descr){
		extension = ext.toLowerCase(); 					// ���� Ȯ���ڸ� �ҹ��ڷ� ����
		description = descr;
	}
	public boolean accept(File file){
		return(file.isDirectory() || file.getName().toLowerCase().endsWith(extension));
	}
	public String getDescription() { return description; }
}
