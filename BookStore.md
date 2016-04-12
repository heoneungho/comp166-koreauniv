# Introduction #
서점에서 책을 판매하는 프로그램입니다.
서점에 재고가 있지만 그 책이 어디있는지 몰라서 팔지를 못하는 동네서점 아주머니를 위한 프로그램!

책의 제목,저자,출판사,가격,분야,서점에서 위치정보 등을 다룸

기본화면에서 검색,판매,새책추가,종료 4가지 메뉴를 선택할수있다.

프로그램이 시작되면 그전에 저장된 정보를 불러들임

1.검색메뉴 : 제목,저자,출판사,분야 4가지 조건으로 검색할수있다.

2. 판매메뉴 : 책의 이름과 구매수량을 입력 하게 함
> 입력된 책이 없을경우, 구매수량보다 재고가 적을경우 각각에 에러메세지 출력

3. 새책추가 메뉴 : 기존에 있던 책의경우 재고만 늘림
> 처음 들어온 책은 제목,저자,등등 기본정보를 새로입력

4.종료메뉴 : 프로그램종료

# Details #

```

import java.util.Scanner;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class BookInfo implements Serializable
	 {	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//책의 정보가 담긴 클래스 
		String bookName;
		String bookAuthor;
		String bookPublisher;
		String bookField;
		int bookPrice;
		int bookCount;
		 
		public BookInfo(String bookName,String bookAuthor, String bookPublisher,String bookField,int bookPrice,int bookCount)  //생성자
		 {
			 this.bookName = bookName;
			 this.bookAuthor = bookAuthor;
			 this.bookPublisher = bookPublisher;
			 this.bookField = bookField;
			 this.bookPrice = bookPrice;
			 this.bookCount = bookCount;
			 
		 }
		public int hashCode()//해시코드
		{
			return bookField.hashCode();
		}
		public boolean equals(Object ob)//비교를 위한 메소드  책이름과 저자가 같으면 같은책으로 간주
		{
			BookInfo bi = (BookInfo)ob;
			if( (this.bookName.equals(bi.bookName)) &&(this.bookAuthor.equals(bi.bookAuthor)) )
				return true;
			else
				return false;
		}
		public String showData()//데이터의 출력을 위한 메소드
		{
			String showdata = String.format("제목 : %-15s	저자 :%-10s출판사 : %-6s  분야 : %-6s  재고 : %d  가격 : %d",bookName,bookAuthor,bookPublisher,bookField,bookCount,bookPrice);
			return showdata;
		}
}
```


BookField 클래스
```
class BookField//검색시 책분야를 선택하기위해 사용되는 클래스
{
	String field;
	public BookField(String field)
	{
		this.field = field;
	}
	public String toString()
	{
		return field;
	}
	
}
```

bookFrame 클래스
```
class bookFrame extends JFrame{
	//프로그램시작과 동시에 기본적은 gui를 구축하는 클래스
	public bookFrame(String str)
	{
		super(str);
		this.setBounds(50,50,800,400);
		this.setLayout(new BorderLayout());
		
		JPanel pan1 = new JPanel();        
		pan1.setLayout(new FlowLayout());
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(0,3,100,0));
		
		JLabel combolabel = new JLabel("분야"); // 분야선택을 위한 콤보박스
		JComboBox<BookField> combobox = new JComboBox<BookField>();
		combobox.addItem(new BookField("전체"));	combobox.addItem(new BookField("인문"));	combobox.addItem(new BookField("사회"));	combobox.addItem(new BookField("문학"));
		combobox.addItem(new BookField("자연과학"));	combobox.addItem(new BookField("컴퓨터와 인터넷"));	combobox.addItem(new BookField("만화"));
		
		JTextField searchText = new JTextField(50); // 검색기능을위한 텍스트필드를 만들고 기능을 구현하는 코드를 액션리스너로 추가
		JButton btn_search = new JButton("검색");
		pan1.add(combolabel);	pan1.add(combobox);	pan1.add(searchText);	pan1.add(btn_search);
		btn_search.addActionListener(new SearchHandler(searchText,combobox));
		
		JButton btn_add = new JButton("추가");	JButton btn_sell = new JButton("판매");	JButton btn_save = new JButton("저장"); //추가,판매,저장의 기능을위한 버튼
		btn_add.addActionListener(new addHandler());		btn_save.addActionListener(new SaveHandler());   btn_sell.addActionListener(new SellHandler());
		pan2.add(btn_add);		pan2.add(btn_sell);		pan2.add(btn_save); 
		

		
		this.add(pan1,BorderLayout.NORTH);
		this.add(pan2,BorderLayout.SOUTH);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
	}
}
```
Bookstore 클래스 메인함수가있음
```
class BookStore {
	
	
	public static void main(String[] args)
	{
		BookManage.makeBookManage(); // BookManage클래스가 생성되면서 BookStore.dat로부터 자료를 불러들임
		bookFrame bframe = new bookFrame("Book Store!!!");//bookFrame클래스를 형성하면서 기본적인 gui가 구축됨
	}
}
```



BookManage 클래스
```
class BookManage//책정보를 관리하기위한 클래스
{
	HashSet<BookInfo> bookStore = new HashSet<BookInfo>();//책의 정보는 해쉬셋으로 관리
	private final File filestr = new File("../BookStore/BookStore.dat");//책의 정보가 담긴 데이터파일에 파일스트림연결
	static BookManage bm = null;                 //
	Scanner in = new Scanner(System.in); 
	
	public static BookManage makeBookManage()//BookManage 클래스를 생성하기위한 static메소드 어디서 BookManage객체를 생성해도 처음에 생성된 하나의 BookManage객체를 반환하게됨
	{
		if(bm == null)
			return bm = new BookManage();
		else 
			return bm;
	}
	
	private BookManage()//생성자를 private로 설정하여  new BookManage();의 방법으로는 객체를생성할수없게 제한함
	{
		readData();
	}
	
	void readData()//BookStore.dat로부터 책정보를 읽어들임
	{
		try
		{
			ObjectInputStream inStr = new ObjectInputStream(new FileInputStream(filestr));
			while(true)//정보를 계속읽어오다가 더이상 없으면 멈춤
			{
				BookInfo bi = (BookInfo)inStr.readObject();
				if(bi == null)
					break;
				bookStore.add(bi);
			}
			inStr.close();//입력스트림을 닫음
		}
		catch(IOException e)
		{
			return;
		}
		catch(ClassNotFoundException e)
		{
			return;
		}
	}
	
	public void saveData()//BookStore.dat에 책정보를 저장함
	{
		try
		{
			ObjectOutputStream outStr = new ObjectOutputStream(new FileOutputStream(filestr));
			Iterator<BookInfo> itr = bookStore.iterator();
			while(itr.hasNext())//iterator를 이용해서 전부저장
			{
				outStr.writeObject(itr.next());
			}
			outStr.close();//출력스트림을 닫음
		}
		catch(IOException e)
		{
			return ;
		}
	}
	
	private void addData(BookInfo bi)
	{
		//inputData 메소드에 의해서 호출되며, 새로 생성된 BookInfo객체와 현재 HashSet내부의 자료들과 비교해서 이미 존재하면 권수만큼 늘리고 없으면 추가한다.
		BookInfo bi_inset;
		Iterator<BookInfo> itr = bookStore.iterator();
		if(bookStore.add(bi)== false)
			while(itr.hasNext())
			{
				bi_inset = itr.next();
				if(bi_inset.equals(bi))
					bi_inset.bookCount += bi.bookCount;
				
			}
			
		System.out.printf("현재 등록된 책은 %d 개입니다",bookStore.size());	
	}
	
	public void inputData()
	{
		//새로운 BookInfo객체를 만들고 addData메소드를 호출한다.
		BookInfo bi;  String bookName;  String bookAuthor;
		String bookPublisher;   String bookField;  int bookPrice;  int bookCount;
		System.out.println("책추가를 시작합니다."); 
		System.out.println("제목을 입력. :"); bookName = in.nextLine();
		System.out.println("저자를 입력. :"); bookAuthor = in.nextLine();
		System.out.println("출판사를 입력. :");   bookPublisher = in.nextLine();
		System.out.println("분야를 입력. :"); 	bookField = in.nextLine();
		System.out.println("권수를 입력. :");   bookCount = in.nextInt(); 
		System.out.println("가격을 입력. :");   bookPrice = in.nextInt(); in.nextLine();
	
		bi = new BookInfo(bookName,bookAuthor,bookPublisher,bookField,bookPrice,bookCount);
		addData(bi);
		System.out.println("입력완료!");
	
	}
	
}
```

SearchHandler 클래스
```
class SearchHandler implements ActionListener//검색 버튼이 눌렸을때 실행될 부분
{
	JTextField Search_field;
	JComboBox<BookField> combobox_field;
	
	public SearchHandler(JTextField sf, JComboBox<BookField> combobox_field)
	{
		this.Search_field = sf;
		this.combobox_field = combobox_field;
	}
	
	public void actionPerformed(ActionEvent e)//검색해서 검색결과를 보여준다.
	{
		
		String book_field = combobox_field.getSelectedItem().toString();
		String search_field = Search_field.getText();
		Search_field.setText("");
		
		JFrame search_frm = new JFrame(" 검색 ");
		search_frm.setBounds(130, 130, 800, 600);
		search_frm.setLayout(new BorderLayout());
		
		JPanel search_pan1 = new JPanel();
		JLabel search_result_label =new JLabel(book_field+" 에서 \" "+search_field+ " \"를 검색");
		search_pan1.add(search_result_label);
		search_frm.add(search_pan1,BorderLayout.NORTH);
		
		//검색결과를 위한 panel을 만듬 
		JPanel search_pan2 = new JPanel();
		JTextArea search_result = new JTextArea(30,65);
		JScrollPane search_scroll = new JScrollPane(search_result,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		search_pan2.add(search_scroll);
		search_frm.add(search_pan2,BorderLayout.CENTER);
	
		BookManage bm = BookManage.makeBookManage();
		Iterator<BookInfo> itr = bm.bookStore.iterator();
		//검색시 책의 분야에 따라 검색하여서 결과를 출력함 
		switch(book_field)
		{
		case("전체") :
			while(itr.hasNext())
			{
				BookInfo bi = itr.next();
				if(bi.bookName.contains(search_field) || bi.bookAuthor.contains(search_field) || bi.bookPublisher.contains(search_field))
				{
					search_result.append(bi.showData());
					search_result.append("\n");
				}		 
			}
		break;
		
		default :
			while(itr.hasNext())
			{
				BookInfo bi = itr.next();
				if(bi.bookField.equals(book_field))
					if( bi.bookName.contains(search_field) || bi.bookAuthor.contains(search_field) || bi.bookPublisher.contains(search_field) )
					{
						search_result.append(bi.showData());
						search_result.append("\n");			
					}
			}
		
		}
		search_frm.setVisible(true);
		search_frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
}
```
addHandler 클래스
```
class addHandler implements ActionListener//추가버튼이 눌렸을때 시행될부분
{
	//추가버튼이 눌리면 inputData메소드가 실행됨
	public void actionPerformed(ActionEvent e)
	{
		BookManage bm = BookManage.makeBookManage();
		bm.inputData();
	}
	
}
```
SaveHandler 클래스
```
class SaveHandler implements ActionListener//저장 버튼이 눌렸을때 실행될부분
{
	public void actionPerformed(ActionEvent e)
	{
		//저장버튼이 눌리면 saveData메소드가 실행되면서 자료를 저장함.
		BookManage bm = BookManage.makeBookManage();
		bm.saveData();
		
	}	
}
```
SellFrame 클래스
```
class SellFrame extends JFrame
{
	public SellFrame(String str)
	{
		//판매를 위해 제목,권수 등을 입력받는 부분
		super(str);
		this.setBounds(130, 130, 600, 100);
		JPanel pan1 = new JPanel();
		JLabel jl1 = new JLabel("제목");
		JTextField searchText = new JTextField(30); 
		pan1.add(jl1); pan1.add(searchText); 
		JLabel jl2 = new JLabel("권수"); 
		JComboBox<Integer> count = new JComboBox<Integer>();
		count.addItem(1); count.addItem(2); count.addItem(3);count.addItem(4);count.addItem(5);
		pan1.add(jl2); pan1.add(count);
		
		JButton btn_search = new JButton("검색"); pan1.add(btn_search);
		btn_search.addActionListener(new SellResultHandler(searchText,count));
		
		this.add(pan1);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
```
SellHandler 클래스
```
class SellHandler implements ActionListener//판매 버튼이 눌리면 실행되는 부분
{
	public void actionPerformed(ActionEvent e)
	{
		JFrame sell_frm = new SellFrame("판매");

	}
}
```
SellResultHandler클래스
```
class SellResultHandler implements ActionListener
{
	JTextField sf;
	JComboBox<Integer> cnt;

	public SellResultHandler(JTextField sf, JComboBox<Integer> cnt)
	{
		this.sf =sf;
		this.cnt = cnt;
	}
	public void actionPerformed(ActionEvent e)
	{
		//판매창에서 검색버튼이 눌리면 실제로 판매가 이루어지는 부분
		JFrame rst = new JFrame("결과"); 
		boolean exist =false;	String srch = sf.getText();	int count = (int)cnt.getSelectedItem();
		rst.setBounds(200,200,80,120);
		JLabel lbl = new JLabel();
	//검색을 통해 입력된책을찾고 권수만큼 판매한다.
		BookManage bm = BookManage.makeBookManage();
		Iterator<BookInfo> itr = bm.bookStore.iterator();
		while(itr.hasNext())
		{
			BookInfo bi = itr.next();
			if(bi.bookName.equals(srch))
			{
				if(count<=bi.bookCount)
				{
					bi.bookCount -=count;
					lbl.setText("판매 완료");
					exist = true;
					break;
				}
				else
				{
					lbl.setText(String.format("재고가 부족합니다. %d권밖에 없어ㅠ",bi.bookCount));//책은 있지만 판매권수에 비해 재고가 부족한경우
					exist = true;
					break;
				}	
			}	
		}	
		if( exist== false)
			lbl.setText("그런 책이 없어ㅠ");//검색해서 해당 책이없는경우 판매가종료됨
	
		
		rst.add(lbl);
		rst.setVisible(true);
		rst.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	
}
```
![http://comp166-koreauniv.googlecode.com/files/bst1.png](http://comp166-koreauniv.googlecode.com/files/bst1.png)
![http://comp166-koreauniv.googlecode.com/files/bst2.png](http://comp166-koreauniv.googlecode.com/files/bst2.png)
![http://comp166-koreauniv.googlecode.com/files/bst3.png](http://comp166-koreauniv.googlecode.com/files/bst3.png)

자바API문서를 참조하였습니다.
http://docs.oracle.com/javase/7/docs/api/

http://comp166-koreauniv.googlecode.com/files/BookStore.zip