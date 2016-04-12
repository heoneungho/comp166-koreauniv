# Introduction #

첫번째 목표는 자동 수강신청 프로그램을 만드는 것이었는데 이것은 너무 어려워서
두번째로 생각한 프로그램이 전화번호부였습니다.
그런데 전화번호부를 어느정도 만들고보니 전화번호만 관리하는 것 보다는 개인 프로필을 관리하는 프로그램을 만드는 것이 좋겠다 싶어서 마지막으로 개인 프로필 관리 프로그램을 만들게 되었습니다.

또한 12월 3일에 발표할 때의 전화번호관리 프로그램은 입력은 콘솔창으로 했었는데
이 부분을 보완했고, 수정을 하려면 불가피하게 데이터를 삭제하고 다시 입력했어야 하는 번거로움이 있었는데 이 부분 또한 보완 했습니다. 보완을 위해 코드의 구성과 GUI창의 모양을 수정 할 수 밖에 없었습니다. 또한 데이터를 저장하고 저장된 파일이 시연 당시에 메모장으로 열었을때 깨져서 보였는데, 그것은 제가 '난 정말 JAVA를 공부한 적이 없다구요'라는 책에서 파일 입출력을 공부하고 응용하는 과정에서 확장자에 대한 생각을 대수롭지 않게 생각하고 책에 작은 예제에 써져 있는대로 .dat 확장자로 만들어서 그랬던것 같습니다. 이 부분도 보완되어서 연결프로그램으로 메모장을 선택해서 보면 깨지지 않고 나옵니다.

1. 프로그램을 실행하게 되면 왼편에는 프로필을 추가할수 있는 영역이 위치하고 오른쪽은 추가된 프로필을 삭제 수정 검색등등 관리할수 있는 영역이 위치해 있습니다.

2. 왼쪽 프로필 추가 영역에 이름과 소속 주소 연락처 이메일 메모를 작성하고 오른쪽 영역의 '추가'버튼을 누르면 오른쪽 영역에 프로필이 추가됩니다. 대신 이름을 작성하지 않으면 나머지 항목을 모두 작성해도 목록에 추가되지 않습니다.

3. 파일을 저장할 수 있도록 했고, 저장한 파일을 불러올 수 있도록 만들었습니다.

# Details #
```

/*개인 프로필 관리 프로그램 입니다.*/

import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;


class ProfileManager extends JFrame implements ActionListener {
	DefaultTableCellRenderer dtcr =new DefaultTableCellRenderer() {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (value instanceof String) {
				String amount = value.toString();
				this.setText(amount);
				this.setHorizontalAlignment(this.CENTER);
				if(row%2==0 ) this.setBackground(Color.LIGHT_GRAY);
				else this.setBackground(Color.white);
			}
	return this;
	}
};


Container c, d, e;
JScrollPane jsp;
DefaultTableModel model;
JMenuItem Open=new JMenuItem("파일 불러오기");
JMenuItem Save=new JMenuItem("파일 저장하기");
JMenuItem Close=new JMenuItem("프로그램 종료");
JMenu M_File;
JMenuBar Base;
JTable table;
JPanel p_All,p_Top,p_Left;
JButton btn_Add,btn_Del,btn_Ins,btn_Clr,btn_Find;
JTextField tf_Name,tf_Com,tf_Add,tf_Call,tf_Email,tf_Etc, tf_Find;

String column[]={"이　　름","소　　속","주　　소","연  락  처","이  메  일","메　　모"};

int i,x;
String temp="";


//프로그램 시작 설정
public ProfileManager(String title){
	super(title); // super로 타이틀 받아오고
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(300,100);
	setSize(800,500);
	setDesign(); //디자인 함수 불러오고
	setEvent(); //이벤트 함수 불러오고
	setResizable(false);
	setVisible(true);
}


public void setDesign(){
	c=getContentPane();

	//메뉴구성
	M_File=new JMenu("파일");
	M_File.add(Open);
	M_File.add(Save);
	M_File.addSeparator();
	M_File.add(Close);
	Base=new JMenuBar();
	Base.add(M_File);
	

	//패널 
	p_All = new JPanel(); // TOP패널 + Table패널
	p_All.setLayout(new BorderLayout());
	p_All.setBorder(new TitledBorder(new LineBorder(Color.black,  1), "관리도구")); // 테이블과 상단을 보더로 디자인 묶기
	p_Top = new JPanel();
	p_Left = new JPanel();
	model=new DefaultTableModel(column,0);
	table=new JTable(model);
	table.setRowHeight(30);
	jsp = new JScrollPane(table);

	//위쪽 구성
	//p_Top.setBorder(new TitledBorder(new LineBorder(Color.black,  1), "세부도구")); //위쪽 패널만 묶을 경우
	btn_Add=new JButton("　추 가　");
	btn_Del=new JButton("　삭 제　");
	btn_Ins=new JButton("　수 정　");
	btn_Find=new JButton("　검 색　");
	tf_Find=new JTextField(10);
	
	p_Top.add(btn_Add);
	p_Top.add(btn_Del);
	p_Top.add(btn_Ins);
	p_Top.add(new JLabel("       "));
	p_Top.add(new JLabel("이 름"));
	p_Top.add(tf_Find);
	p_Top.add(btn_Find);
	
	//왼쪽 패널 구성하기
	p_Left.setLayout(new GridLayout(10,1,3,3));
	p_Left.setBorder(new TitledBorder(new LineBorder(Color.black,  1), "프로필추가"));
	tf_Name=new JTextField(10);
	tf_Com=new JTextField(10);
	tf_Add=new JTextField(10);
	tf_Call=new JTextField(10);
	tf_Email=new JTextField(10);
	tf_Etc=new JTextField(10);

	JPanel p, p0,p1,p2,p3,p4,p5,p6;

	p1=new JPanel();
	p1.add(new JLabel("이　　름"));
	p1.add(tf_Name);
	p2=new JPanel();
	p2.add(new JLabel("소　　속"));
	p2.add(tf_Com);
	p3=new JPanel();
	p3.add(new JLabel("주　　소"));
	p3.add(tf_Add);
	p4=new JPanel();
	p4.add(new JLabel("연  락  처"));
	p4.add(tf_Call);
	p5=new JPanel();
	p5.add(new JLabel("이  메  일"));
	p5.add(tf_Email);
	p6=new JPanel();
	p6.add(new JLabel("메　　모"));
	p6.add(tf_Etc);
	btn_Clr=new JButton("다 시 입 력");
	
	p_Left.add(new JLabel(""));
	p_Left.add(p1);
	p_Left.add(p2);
	p_Left.add(p3);
	p_Left.add(p4);
	p_Left.add(p5);
	p_Left.add(p6);
	p_Left.add(new JLabel(" 프로필을 추가하실 경우 입력 후"));
	p_Left.add(new JLabel(" 관리도구에 [추가]를 눌러주세요"));
	p_Left.add(btn_Clr);
	
	//전체 패널 구성하기
	setJMenuBar(Base);
	p_All.add("North",p_Top);
	p_All.add("West",p_Left);
	p_All.add("Center",jsp);
	c.add("West",p_Left);
	c.add("Center",p_All);
}

//이벤트 처림 함수 (모든 이벤트들을 모아서 관리)
public void setEvent(){
	Open.addActionListener(this);
	Save.addActionListener(this);  
	Close.addActionListener(this);
	btn_Add.addActionListener(this);
	btn_Del.addActionListener(this);
	btn_Ins.addActionListener(this);
	btn_Find.addActionListener(this);
	btn_Clr.addActionListener(this);
	table.addMouseListener(new Mouse());
}

//Table 마우스 이벤트시 왼쪽 메뉴로 받아오기
class Mouse extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		i=table.getSelectedRow();
		tf_Name.setText(table.getValueAt(i,0)+"");
		tf_Com.setText(table.getValueAt(i,1)+"");
		tf_Add.setText(table.getValueAt(i,2)+"");
		tf_Call.setText(table.getValueAt(i,3)+"");
		tf_Email.setText(table.getValueAt(i,4)+"");
		tf_Etc.setText(table.getValueAt(i,5)+"");
	}
}


//텍스트필드 내용 지우기 함수
public void Clear_tf() {
	tf_Name.setText("");
	tf_Com.setText("");
	tf_Add.setText("");
	tf_Call.setText("");
	tf_Email.setText("");
	tf_Etc.setText("");
	tf_Name.requestFocus(); //포커스는 이름 텍스트로 넣습니다.
}


// 검색 텍스트 필드 내용 지우기 함수
public void Clear_tf2() {
	tf_Find.setText("");
	tf_Find.requestFocus();
}


//이름을 담당하는 텍스트필드 체크 함수 (tf_Name 공백값 확인)
public boolean Check_tf(){
	if(tf_Name.getText().equals("")){
		JOptionPane.showMessageDialog(ProfileManager.this,"이름을 꼭 입력하셔야 추가가 가능 합니다.","추가오류", JOptionPane.ERROR_MESSAGE );
		Clear_tf();
		return true;
		}
	else return false;
}


//검색할때 이름을 담당하는 텍스트필드 체크 함수 (tf_Find 공백값 확인)
public boolean Check2_tf(){
	if(tf_Find.getText().equals("")){
		JOptionPane.showMessageDialog(ProfileManager.this,"이름을 꼭 입력하셔야 검색이 가능 합니다.","검색오류", JOptionPane.ERROR_MESSAGE );
		Clear_tf2(); //tf_Find만 지우고 포커스를 넣는 함수 호출
		return true;
		}
	else return false;
}


//데이터 추가함수
public void Add(){
	if(Check_tf()!=true){
		String a[]=new String[6];
		a[0]=tf_Name.getText();
		a[1]=tf_Com.getText();
		a[2]=tf_Add.getText();
		a[3]=tf_Call.getText();
		a[4]=tf_Email.getText();
		a[5]=tf_Etc.getText();
		model.addRow(a);
		for(i=0;i<6;i++){
			table.getColumnModel().getColumn(i).setCellRenderer(dtcr);
		}
		Clear_tf();
	} else {
		Clear_tf();
	}
}


//데이터 수정 함수
//Table에 이름과 텍스트필드에 이름이 같을경우 수정이 가능한 루틴 입니다.

public void Ins(){
	for (i=0; i < x ;i++ ){
		if(table.getValueAt(i,0).equals(tf_Name.getText())) {
			table.setValueAt(tf_Com.getText(),i,1);
			table.setValueAt(tf_Add.getText(),i,2);
			table.setValueAt(tf_Call.getText(),i,3);
			table.setValueAt(tf_Email.getText(),i,4);
			table.setValueAt(tf_Etc.getText(),i,5);
			}
	}
	Clear_tf();
}


//데이터 삭제 함수
public void Del()
	{
	int result=JOptionPane.showConfirmDialog(ProfileManager.this,"해당 데이터를 삭제하시겠습니까?", "삭제확인", JOptionPane.YES_NO_OPTION);
	if(result== JOptionPane.YES_OPTION){
		for (i=0;i<x;i++ )
			//데이터를 삭제 할때 현재 테이블에서 선택한 데이터의 전화번호와 테이블 데이터들 중에서 전화번호가 일치하는 항목 삭제
			//이는 동명이인은 있을수 있지만, 전화번호는 다 틀리기 때문이다.
			if(table.getValueAt(i,3).equals(tf_Call.getText()))
			model.removeRow(i);
		}
		else {
			JOptionPane.showMessageDialog(ProfileManager.this,"삭제를 취소하였습니다.", "삭제취소", JOptionPane.INFORMATION_MESSAGE);
		}
	Clear_tf();
}


//검색 함수
public void Find() {
	if(Check2_tf()!=true){
		JFrame jf=new JFrame("검색결과");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		jf.setLocation(800,300);
		jf.setSize(600,300);
		//검색결과를 출력하기 위한 새로운 테이블 생성
		DefaultTableModel model2=new DefaultTableModel(column,0);
		JTable table2=new JTable(model2);
		JScrollPane jsp2 = new JScrollPane(table2);
		table2.setRowHeight(30);
		
		//검색을 위한 텏스트 값 받아오기
		String value2="";
		try {
		value2 = tf_Find.getText();
		}
		catch (NumberFormatException n) {
			Clear_tf();
			return;
		}
		
		//검색 결과를 출력하기 위한 스트링 배열 선언
		String tmp[]=new String[10];
		int j=0;
		for(i=0;i<x;i++) {
			String value= table.getValueAt(i,0)+"";
			// 테이블
			if(table.getValueAt(i,0).equals(tf_Find.getText())) {
				
				tmp[0]=table.getValueAt(i,0)+""; // 0 = 이름
				tmp[1]=table.getValueAt(i,1)+""; // 1 = 소속
				tmp[2]=table.getValueAt(i,2)+""; // 2 = 주소
				tmp[3]=table.getValueAt(i,3)+""; // 3 = 연락처
				tmp[4]=table.getValueAt(i,4)+""; // 4 = 이메일
				tmp[5]=table.getValueAt(i,5)+""; // 5 = 메모
				model2.addRow(tmp); // 열에 추가 합니다
				
				for(j=0;j<6;j++) {
					table2.getColumnModel().getColumn(j).setCellRenderer(dtcr);
				}
			}
		}
		
		jf.add(jsp2);
		jf.setResizable(false); //최대화 버튼을 사용금지
		jf.setVisible(true);
		JDialog jd =new JDialog(jf);

		tf_Find.setText("");

	} else {
		Clear_tf2();
	}
}


//파일에 저장
public void save(){
	try {
		FileDialog fds=new FileDialog(ProfileManager.this, "파일저장",FileDialog.SAVE);
		fds.show();
		String save=fds.getDirectory()+fds.getFile();
		FileWriter fw=new FileWriter(save);
		BufferedWriter bw=new BufferedWriter(fw);
		
		//데이타를 넣기
		for(i=0;i<x;i++) {
			for( int j=0;j<6;j++) {
				bw.write(table.getValueAt(i,j)+"");
				bw.newLine();
				}
			}
		bw.close();
		fw.close();
		}
		
	catch (IOException i){}
}


//파일 열기
public void open(){
	try { 
		FileDialog fdo=new FileDialog(ProfileManager.this, "파일열기",FileDialog.LOAD);
		fdo.show(); //다이얼로그 출력
		String open=fdo.getDirectory()+fdo.getFile();
		FileReader fr=new FileReader(open);
		BufferedReader br=new BufferedReader(fr);
		temp="";
		String str[]=new String[6];
		while(true){
			temp=br.readLine();
			if(temp==null) break;
			//한줄씩 읽어들어와서 테이블 열에 저장
			str[0]=temp;
			temp=br.readLine();
			str[1]=temp;
			temp=br.readLine();
			str[2]=temp;
			temp=br.readLine();
			str[3]=temp;
			temp=br.readLine();
			str[4]=temp;
			temp=br.readLine();
			str[5]=temp;
			model.addRow(str);
			
			for(i=0;i<6;i++){
				table.getColumnModel().getColumn(i).setCellRenderer(dtcr);
			}
		}
		
		temp="";
		Clear_tf();
		br.close();
		fr.close();
	}
	catch (IOException i){}
}


//이벤트 발생 처리 부분(버튼이나 메뉴 호출)
public void actionPerformed(ActionEvent e){
	Object ob=e.getSource();
	x=table.getRowCount();
	if (ob==btn_Add) Add();
	else if (ob==btn_Ins) Ins();
	else if (ob==btn_Del) Del();
	else if (ob==btn_Find) Find();
	else if (ob==btn_Clr) Clear_tf();
	else if(ob==Save) save();
	else if(ob==Open) open();
	else if(ob==Close)dispose();
	
}


// 메인메소드
public static void main(String[] args){
	new ProfileManager("Profile Manager");
	}
}

```

# 실행화면 #
**처음 메인 화면입니다.
http://comp166-koreauniv.googlecode.com/files/캡처1.JPG**

**프로필 입력하는 화면입니다.
http://comp166-koreauniv.googlecode.com/files/캡처2.JPG**

**프로필이 저장된 화면입니다. 2번째 사진에서 프로필을 입력 한 후 화면 상단의
'추가'버튼을 누르면 저장됩니다
http://comp166-koreauniv.googlecode.com/files/캡처3.JPG**

**프로필이 저장된 화면에서 '관리도구' 영역의 '수정' 버튼을 누르면 왼쪽 '프로필 추가' 영역에 저장된 정보가 다시 나타납니다. 여기서 수정하고 싶은 내용을 수정하고 '추가'버튼을 누르면 수정된 정보로 저장됩니다.
http://comp166-koreauniv.googlecode.com/files/캡처4.JPG**

**저장된 프로필을 '관리도구'영역의 '검색'을 이용하여 검색한 모습입니다. 검색결과로 저장되어 있는 정보가 뜹니다.
http://comp166-koreauniv.googlecode.com/files/캡처5.JPG**

**왼쪽 상단의 '파일' 탭을 클릭하면 '파일 저장', '파일 불러오기', '프로그램 종료'세가지의 메뉴를 선택할 수 있습니다. 그 중에 '파일 저장'을 클릭하여 프로필 정보를
'12월연락처'라는 이름의 파일로 저장하는 모습입니다.
![http://comp166-koreauniv.googlecode.com/files/캡쳐10.jpg](http://comp166-koreauniv.googlecode.com/files/캡쳐10.jpg)
http://comp166-koreauniv.googlecode.com/files/캡처6.JPG**

**파일 저장을 마친 후에 저장된 '12월연락처'파일을 메모장을 연결프로그램으로 하여 실행한 모습입니다. 화면 가장 뒤쪽의 프로그램 관리도구 영역에 표시된 정보와 12월연락처 파일에 저장된 정보가 일치합니다.
http://comp166-koreauniv.googlecode.com/files/캡처7.JPG**

**저장한 '12월연락처'파일을 '파일 열기'기능을 통해 불러오는 과정입니다.
http://comp166-koreauniv.googlecode.com/files/캡처8.JPG**

**이름을 입력하지 않은채로 나머지 정보만 입력하고 추가버튼을 누르게 되면 예외처리로 다음과 같은 창이 뜨도록 만들었습니다.
http://comp166-koreauniv.googlecode.com/files/캡처9.JPG**


# 참고문헌 #
**Head First Java 케이시 시에라, 버트 베이츠 저 서환수 역 한빛미디어**

**난 정말 JAVA를 공부한 적이 없다구요 윤성우 저 김문석 감수 오렌지미디어**

**자바의 정석 2ed edition 남궁성 저 도우출판**

**파일 입출력의 이해를 돕기 위해서 참고한 네이버 블로그(이 블로그에서 아래 주소가 가리키는 내용외에 관련된 다른 내용도 참고)
http://blog.naver.com/ksj_7701?Redirect=Log&logNo=130130735056**


# 소스코드 제출 #
http://comp166-koreauniv.googlecode.com/files/2012190724ProfileManagerbinsrc.zip