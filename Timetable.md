# Introduction #

# 개요 #

- 시간표짜는 프로그램은 파일 불러오기가 필요한데 입력하는 과정에서 복잡할것 같아서 주

차관리 프로그램으로 바꾸겠습니다. GUI구현 프로그램 Netbeans를 사용하였습니다. 코딩

엔 익숙치 않아서 그런지 객체지향의 장점을 살리지 못했고, GUI 쓰는부분이 미숙해서 코

드가 지저분하게 나왔습니다. 졸업하기 전까지 마스터 하겠습니다.

  * 프로그램 압축파일

http://comp166-koreauniv.googlecode.com/files/2012190712_lsh.zip


---


# 만들게 된 동기 #

- 피씨방이나 책방같은 경우는 시간과 돈을 계산해주는 프로그램이 있습니다.

하지만 주차관리 프로그램은 대부분 노트에 쓰는식으로 돌아가고 있어서 주차관리하시는 분

들의 노고를 덜어드리기 위해 만들었습니다. 참조한 소스코드는 없습니다.


---


# 참고문헌 #

1) Head First JAVA(한빛미디어) - 케이시 시에라, 버트 베이츠 저

2) Java foundation(Addison Wesley) - John Lewis, Peter DePasQuale

3) 자료 구조와 JAVA(정익사) - 이석호 저

4) JAVA의 정석(도우출판) – 남궁성


---


# 레이아웃 구성 #

**1. 버튼**

| **in버튼** |
|:---------|

1) in버튼을 누르면 차량 번호를 입력하는 창이 뜹니다.

2) 확인버튼을 누르고 나면 선불하시겠습니까? 라고 물어보는 창이 뜹니다.

3) 선불을 선택하고 싶으면, 선택화면에서 예를 누릅니다.

4) 선불을 선택했을 경우, 낼 금액을 입력하면 차가 화면에 주차됩니다.

5) 후불을 선택하고 싶으면, 선택화면에서 아니오를 누릅니다.

| **out버튼** |
|:----------|

1) out버튼을 누르고 나면 주차되어 있는 차량번호중 하나를 입력해야 합니다.

2) 주차되어 있지 않은 차량번호를 입력하면 에러메세지가 뜹니다.

3) 차량번호를 입력하면 주차시간, 이용금액을 출력합니다.


**2. 레이아웃**

1) 왼쪽엔 상황판과 주차장 이미지가있습니다. out버튼을 누르고 나가면 그 상황에 따른 메

세지가 출력됩니다. 가격은 1초에 10원입니다. 추가된 시간에서 선불로 낸 금액만큼의

시간을 빼서 가격을 청구합니다.

2) 오른쪽엔 자동차의 주차현황이 나와있습니다. 총 8대의 자동차를 주차할 수 있습니다.


---


# CLASS 구성 #

**1. Dnode 클래스**

1) 행위의 시작과 끝을 알려주는 클래스입니다.

**2. mainForm 클래스**

1) 변수선언, 레이아웃 구성

2) in버튼 클릭시 실행되는 메소드

3) out버튼 클릭시 실행되는 메소드

4) 주차장에 차량을 추가하는 메소드

5) 주차장의 차량을 제거하는 메소드

6) main문

**3. parking 클래스**

1) 주차공간 하나에 대한 객체, 번호판, 시간, 요금정보

2) 주차공간에서 자동차 추가

3) 주차공간에서 자동차 삭제


---


# 실행화면 #

| **시작화면** |
|:---------|


![http://comp166-koreauniv.googlecode.com/files/lshstart.jpg](http://comp166-koreauniv.googlecode.com/files/lshstart.jpg)

| **in버튼** |
|:---------|

1. in버튼 클릭시

![http://comp166-koreauniv.googlecode.com/files/lshin1.jpg](http://comp166-koreauniv.googlecode.com/files/lshin1.jpg)

2. in버튼 정상적인 차 번호 입력후

![http://comp166-koreauniv.googlecode.com/files/lshin2.jpg](http://comp166-koreauniv.googlecode.com/files/lshin2.jpg)

3. 기존에 있는 차량번호 입력시

![http://comp166-koreauniv.googlecode.com/files/lshin3.jpg](http://comp166-koreauniv.googlecode.com/files/lshin3.jpg)

4. 4자리가 아닌 차량번호를 입력했을 경우

![http://comp166-koreauniv.googlecode.com/files/lshin4.jpg](http://comp166-koreauniv.googlecode.com/files/lshin4.jpg)

5. in 버튼에서 정상적인 차량번호를 입력 후, 취소버튼을 누르면 바로 주차

![http://comp166-koreauniv.googlecode.com/files/lshin5.jpg](http://comp166-koreauniv.googlecode.com/files/lshin5.jpg)

6. 정상적으로 주차된 화면

![http://comp166-koreauniv.googlecode.com/files/lshin6.jpg](http://comp166-koreauniv.googlecode.com/files/lshin6.jpg)

| **out버튼** |
|:----------|

1. out버튼을 눌렀을 때

![http://comp166-koreauniv.googlecode.com/files/lshout1.jpg](http://comp166-koreauniv.googlecode.com/files/lshout1.jpg)

2. 없는 차 번호를 입력했을 시

![http://comp166-koreauniv.googlecode.com/files/lshout2.jpg](http://comp166-koreauniv.googlecode.com/files/lshout2.jpg)

3. 정상적으로 차 번호를 입력했을 경우

![http://comp166-koreauniv.googlecode.com/files/lshout3.jpg](http://comp166-koreauniv.googlecode.com/files/lshout3.jpg)



---


# Details #


Add your content here.  Format your content with:

**Dnode 클래스 : 행위의 시작과 끝을 알려주는 클래스입니다.**

```
class Dnode { // Dnode 클래스를 선언해줍니다. 같은 클래스 내에서만 접근가능하게 하기위해 private로 선언
	private int number; // 자동차 번호판
	private int time_hour,time_second,time_minute; // 주차 시간
	private int price; // 가격
	
	private Dnode before,next; // 실행시 다음행동 이전행동을 연결해주는것.
	
	Dnode() { // 디노드 자신을 초기화
		this(0,null,null,0,0,0,0);
	}
	
	Dnode(int car_number,Dnode p,Dnode q,int time_hour,int time_minute,int time_second, int price) { // 생성자
		this.number = car_number; // this를 쓰는 이유는 자기 자신의 변수를 호출하기 위해서임
		this.before = p;
		this.next = q;
		this.time_hour = time_hour;
		this.time_minute = time_minute;
		this.time_second = time_second;
		this.setPrice(price);
	}

	
	public void set_number(int car_number ,int time_hour,int time_minute,int time_second, int price) { // 숫자관련된것을 설정하는 메소드
		this.number=car_number; // 자동차 번호
		this.time_hour = time_hour; // 시간중 시
		this.time_minute = time_minute; // 시간중 분
		this.time_second = time_second; // 시간중 초
		this.setPrice(price); // 가격
	}
	
	public void setNext(Dnode newnext) { // 다음 디노드를 설정해준다.
		next=newnext;
	}
	
	public void setBefore(Dnode newprev) { // 이전 디노드를 설정해준다.
		before=newprev;
	}
	
	int time_hour() { // 시간을 리턴한다
		return time_hour;
	}
	int time_minute() { // 분을 리턴한다.
		return time_minute;
	}
	int time_second() { // 초를 리턴한다.
		return time_second;
	}
	
	int car_number() { // 번호판을 리턴한다.
		return number;
	}
	
	public Dnode getNext() { // 다음 노드를 불러온다.
		return next;
	}
	
	public Dnode getBefore() { // 이전노드를 불러온다.
		return before;
	}

	public int getPrice() { // 가격을 불러온다.
		return price;
	}

	public void setPrice(int price) { // 가격을 설정한다.
		this.price = price;
	}
}
```

**MainForm 클래스 :**

```
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;

//  @author 2012190712

public class MainForm extends JFrame { // 변수 선언
	private JButton enterButton; // in 버튼
	private JButton exitButton; // out 버튼
	private JPanel jPanel1; // 자동차 1,2
	private JPanel jPanel2; // 왼쪽화면
	private JPanel jPanel3; // 자동차 3,4
	private JPanel jPanel4; // 자동차 5,6
	private JPanel jPanel5; // 자동차 7,8
	private JPanel parkingArea; // 오른쪽 주차공간 8개

	private JLabel sector1; // 자동차 주차공간 1~8
	private JLabel sector2; 
	private JLabel sector3;
	private JLabel sector4;
	private JLabel sector5;
	private JLabel sector6;
	private JLabel sector7;
	private JLabel sector8;
	private JLabel ticketBox; // 왼쪽 아래 주차장 이미지

	private JTextArea textArea; // 주차장 이미지 위에있는 배너

	Parking park= new Parking(); // 주차공간에 담을 주차공간에 대한 정보 객체를 만든다.
	String car_number = "";  // 자동차번호 변수


	public MainForm() { // 레이아웃 구성
		jPanel1 = new JPanel(); // 패널을 만든다
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		jPanel4 = new JPanel();
		jPanel5 = new JPanel();

		sector1 = new JLabel(); // 섹터를 만든다.
		sector2 = new JLabel();
		sector3 = new JLabel();
		sector4 = new JLabel();
		sector5 = new JLabel();
		sector6 = new JLabel();
		sector7 = new JLabel();
		sector8 = new JLabel();

		parkingArea = new JPanel();

		enterButton = new JButton();
		exitButton = new JButton();

		ticketBox = new JLabel();
		textArea = new JTextArea();

		sector1.setText("1");	// 주차공간에 적는 숫자. 1~8
		sector1.setFont(new Font("Nanum Gothic", 0, 15)); // 폰트를 나눔고딕으로
		sector2.setText("2");		
		sector2.setFont(new Font("Nanum Gothic", 0, 15));
		sector3.setText("3");		
		sector3.setFont(new Font("Nanum Gothic", 0, 15));
		sector4.setText("4");		
		sector4.setFont(new Font("Nanum Gothic", 0, 15));
		sector5.setText("5");		
		sector5.setFont(new Font("Nanum Gothic", 0, 15));
		sector6.setText("6");		
		sector6.setFont(new Font("Nanum Gothic", 0, 15));
		sector7.setText("7");		
		sector7.setFont(new Font("Nanum Gothic", 0, 15));
		sector8.setText("8");		
		sector8.setFont(new Font("Nanum Gothic", 0, 15));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // x버튼을 누르면 창을 꺼지게한다.

		setBackground(new java.awt.Color(234, 234, 234)); // 전체 배경색
		parkingArea.setBackground(new java.awt.Color(234, 234, 234)); // 패널의 이름이 parkingArea. 오른쪽 배경색

		jPanel1.setBackground(new java.awt.Color(234, 234, 234)); // 오른쪽 배경색
		jPanel2.setBackground(new java.awt.Color(234, 234, 234));
		jPanel3.setBackground(new java.awt.Color(234, 234, 234));
		jPanel4.setBackground(new java.awt.Color(234, 234, 234));
		jPanel5.setBackground(new java.awt.Color(234, 234, 234));

		initComponents(); // initComponents 호풀
	}


	private void initComponents() { // 레이아웃 설정 GUI 자동구성입니다.
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1); // 생성
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(sector2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(sector1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
								.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(sector1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sector2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		parkingArea.add(jPanel1);

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(sector4, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(sector3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
								.addContainerGap())
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(sector3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sector4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		parkingArea.add(jPanel3);


		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(sector5, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(sector6, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
								.addContainerGap())
				);
		jPanel4Layout.setVerticalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(sector5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sector6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		parkingArea.add(jPanel4);

		GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(sector8, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(sector7, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
								.addContainerGap())
				);
		jPanel5Layout.setVerticalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(sector7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sector8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		parkingArea.add(jPanel5);

		ticketBox.setBackground(new java.awt.Color(204, 204, 204)); // 왼쪽하면아래 배경색
		ticketBox.setHorizontalAlignment(SwingConstants.CENTER); // 가운데정렬
		ticketBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled2.png"))); // 주차이미지를 불러온다.

		textArea.setText("저희 착한주차장을 이용해주셔서 감사합니다."); // 상황판
		textArea.setEditable(false); // 에디트를 못하게 설정
		textArea.setFocusable(false); // 초점이 맞춰지게 안함
		textArea.setFont(new Font("Nanum Gothic", 0, 24)); // 폰트설정

		exitButton.setFont(new Font("Synchro LET", 0, 13)); // out 설정
		exitButton.setText("OUT");
		exitButton.addActionListener(new ActionListener() { // 버튼을 누르면 실행되는 활동
			public void actionPerformed(ActionEvent evt) {
				exitButtonActionPerformed(evt);
			}
		});

		enterButton.setFont(new Font("Synchro LET", 0, 13)); // in 버튼 설정
		enterButton.setText("IN");
		enterButton.addActionListener(new java.awt.event.ActionListener() { // 버튼을 누르면 실행되는 활동
			public void actionPerformed(ActionEvent evt) {
				enterButtonActionPerformed(evt);
			}
		});

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2); // 레이아웃 설정 자동구성입니다.
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(146, 146, 146)
										.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addGap(145, 145, 145)
										.addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addContainerGap()
												.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(6, 6, 6)
																.addComponent(ticketBox, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)
																.addGap(0, 6, Short.MAX_VALUE))
																.addComponent(textArea))))
																.addContainerGap())
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(ticketBox)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(enterButton)
								.addComponent(exitButton))
								.addGap(76, 76, 76))
				);


		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(parkingArea, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
								.addComponent(parkingArea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
				);

		pack();
	}


	private void enterButtonActionPerformed(ActionEvent evt) { // 엔터버튼 클릭시 실행되는 메소드
		try{ // 예외처리 try-catch 부문
			car_number = JOptionPane.showInputDialog("차량 번호를 입력하세요"); // in버튼 클릭시
			if (car_number.length() != 4) { // 차 번호가 4자리가 아닐때
				JOptionPane.showMessageDialog(null, "차량번호가 잘못되었습니다.");
			} else { // 차 번호가 4자리일때
				if (park.check(Integer.parseInt(car_number))) { // park개체를 만들어서 check메소드 호출, 차량 번호가 중복되일때
					JOptionPane.showMessageDialog(null, "차량 번호가 중복됩니다.");
				} else {
					if (park.isFull()) { // 주차공간이 꽉 찼을때
						JOptionPane.showMessageDialog(null, "주차공간이 없습니다. 잠시만 기다려 주세요.");
					} else { // 차량번호를 제대로 입력하고, 주차공간이 남았을때
						int option = JOptionPane.showConfirmDialog(null, "선불 금액을 내시겠습니까?", null, JOptionPane.YES_NO_OPTION);
						switch (option) {
						case JOptionPane.YES_OPTION: // 예를 선택했을 시
							String price = JOptionPane.showInputDialog("금액을 입력해주십시오.");
							setPosition(car_number, Integer.parseInt(price)); // 예외처리 다 빠져나왔을 때. 주차공간에 차량번호를 넣는다.
							break;
						case JOptionPane.NO_OPTION: case JOptionPane.CLOSED_OPTION: // 아니오를 선택했을시
							setPosition(car_number, 0); // 예외처리 다 빠져나왔을 때. 주차공간에 차량번호를 넣는다.
							break;
						}
					}
				}
			}
		} catch(NumberFormatException e){ // 차량번호가 숫자가 아닐때
			JOptionPane.showMessageDialog(null, "차량번호가 잘못되었습니다.");
		} catch(Exception e) { // 나머지 예외
			JOptionPane.showMessageDialog(null, "차량번호가 잘못되었습니다.");
		}
	}
	


	private void exitButtonActionPerformed(ActionEvent evt) { // out버튼 클릭시 실행되는 메소드
		try{ // 예외처리 try-catch 부문
			car_number = JOptionPane.showInputDialog("차량 번호 4자리를 입력하세요"); // out버튼 클릭시
			if (car_number.length() != 4) { // 차량번호가 4자리가 아닐시
				JOptionPane.showMessageDialog(null, "차량번호가 잘못되었습니다.");
			} else {
				if(park.isEmpty()) // 주차공간이 비었을 시
					JOptionPane.showMessageDialog(null, "더 이상 나갈 차가 없습니다.");
				else {
					if(park.check(Integer.parseInt(car_number))) { // 주차되어있는 차 번호 확인
						removePosition(car_number);	
					} else { // 주차되어 있지 않을때
						JOptionPane.showMessageDialog(null, "그런 차는 주차되어 있지 않습니다");
					}
				}
			}
		} catch (NumberFormatException e) { // 차량번호가 숫자가 아닐 때
			JOptionPane.showMessageDialog(null, "차량번호가 잘못되었습니다.");
		} catch(Exception e) { // 예외처리
			JOptionPane.showMessageDialog(null, "차량번호가 잘못되었습니다.");
		} 
	}


	private void setPosition(String car_number, int price) { // 주차장에 차량을 추가하는 메소드
		park.Add(Integer.parseInt(car_number), price); // 디노드 추가
		textArea.setText("'" + car_number + "' 님 어서오십시오."); // 상황판
		if (sector1.getText() == "1") { // 자동차이미지 추가
			sector1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector1.setText(car_number);
		} else if (sector2.getText() == "2") {
			sector2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector2.setText(car_number);
		} else if (sector3.getText() == "3") {
			sector3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector3.setText(car_number);
		} else if (sector4.getText() == "4") {
			sector4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector4.setText(car_number);
		} else if (sector5.getText() == "5") {
			sector5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector5.setText(car_number);
		} else if (sector6.getText() == "6") {
			sector6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector6.setText(car_number);
		} else if (sector7.getText() == "7") {
			sector7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector7.setText(car_number);
		} else if (sector8.getText() == "8") {
			sector8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car.png")));
			sector8.setText(car_number);
		}
	}


	private void removePosition(String car_number) { // 주차장의 차량을 제거하는 메소드
		textArea.setText("'" + car_number + "' 님 안녕히가십시오.\n"+ park.Delete(Integer.parseInt(car_number))); // 상황판
		if (sector1.getText().equals(car_number)) { // 입력한 차번호와 주차된 차 번호를 비교
			sector1.setIcon(null); // 차를 비운다.
			sector1.setText("1"); // 다시 주차공간을 기존의 숫자 1로 설정
		} else if (sector2.getText().equals(car_number)) {
			sector2.setIcon(null);
			sector2.setText("2");
		} else if (sector3.getText().equals(car_number)) {
			sector3.setIcon(null);
			sector3.setText("3");
		} else if (sector4.getText().equals(car_number)) {
			sector4.setIcon(null);
			sector4.setText("4");
		} else if (sector5.getText().equals(car_number)) {
			sector5.setIcon(null);
			sector5.setText("5");
		} else if (sector6.getText().equals(car_number)) {
			sector6.setIcon(null);
			sector6.setText("6");
		} else if (sector7.getText().equals(car_number)) {
			sector7.setIcon(null);
			sector7.setText("7");
		} else if (sector8.getText().equals(car_number)) {
			sector8.setIcon(null);
			sector8.setText("8");
		}
	}


	public static void main(String args[]) { // 프로그램 main 부분, 프로그램 창 같은걸 깔끔하게 해줌, 트라이캣치부분은 없어도 됩니다.
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() { // 넷빈즈
				new MainForm().setVisible(true); // 보일 수 있게 하는것.
			}
		});
	}
}
```

**Parking 클래스 :**

```
import java.util.Calendar;


public class Parking { // 주차공간 하나에 대한 객체, 번호판, 시간, 요금정보를 담고 있습니다.
	private Dnode header,tailer; // 헤더 테일러 선언
	private Calendar time; // 시간정보
	private int car_count; // 자동차 갯수
	
	public Parking() {
		header=new Dnode(); // 디노드 형성
		tailer = new Dnode();
		header.setNext(tailer); // 헤더다음에 테일러가 온다.
		header.setBefore(null); // 헤더가 맨 처음이다
		tailer.setBefore(header); // 테일러 이전에 헤더가 온다.
		tailer.setNext(null); // 테일러가 맨마지막이다.
		car_count = 0; // 초기화 해주는것
	}

	public boolean isEmpty() { // 자동차가 한대도 없을때, 자동차가 비어있는지 확인하기 위해
		if(header.getNext()==tailer) { // 머리 다음이 꼬리인게 아무것도 없는 상태, 주차공간이 비어있는 상태
			return true;
		}
		return false;
	}
	public boolean isFull() { // 자동차가 8번까지 꽉 차있을때 
		if(car_count == 8) {
			return true;
		}
	return false;
	}
	
	public boolean check(int car_number) {
		Dnode check = header.getNext(); // 머리의 다음노드
		while(check!=tailer) { // 노드가 꼬리가 아닐때
			if(check.car_number()==car_number) { // 노드에 자동차 번호와 체크하려는 차 번호가 같을때, 차번호 중복 확인
				return true;
			}
			check=check.getNext(); // 차번호 중복 처음부터 넘어가면서 확인
		}
		return false;
	}
	

	public void Add(int car_number, int price) { // 주차공간에 자동차 추가
		car_count++; // 자동차갯수 추가
		time = Calendar.getInstance(); // 초기와
		if(header.getNext()==tailer) { // 주차공간이 비었을때
			Dnode start = new Dnode(car_number,header,tailer,time.get(Calendar.HOUR_OF_DAY),time.get(Calendar.MINUTE),time.get(Calendar.SECOND), price);
			// 노드에다가 시간정보 입력
			header.setNext(start); // 머리 다음에 start 를 넣겠다.
			tailer.setBefore(start); // 꼬리 이전에 start 를 넣겠다.
		} else { // 하나라도 차 있을때
			Dnode check = header.getNext(); // 머리의 다음노드
			while(check.getNext()!=tailer) { // 노드가 꼬리가 아닐때
				check = check.getNext(); // 다음의 체크노드를 설정해주고 그것을 꼬리 이전까지 다시 반복, 체크가 결국 꼬리 앞껄로 설정
			}
			Dnode newnode = new Dnode(car_number,check,tailer,time.get(Calendar.HOUR_OF_DAY),time.get(Calendar.MINUTE),time.get(Calendar.SECOND), price);
			// 노드에다가 시간정보 입력
			check.setNext(newnode);  // (체크 - 뉴노드 - 꼬리)
			tailer.setBefore(newnode); // 꼬리 이전에 new node를 넣겠다.
		}
	}


	public String Delete(int car_number) { // 주차공간에서 자동차 삭제
		car_count--; // 자동차갯수 감수
		int minute ,second, def, pre_price, price, remain_price;
		Dnode delete_node = header.getNext(); // 머리의 다음노드
		time = Calendar.getInstance(); // 타임 설정
		while(delete_node != tailer) { // 노드가 꼬리가 아닐때, 안에 차들이 있을때
			if(delete_node.car_number()==car_number) { // 입력한 차 번호의 차가 존재할때.
				minute = time.get(Calendar.MINUTE) - delete_node.time_minute(); // 주차시간
				second = time.get(Calendar.SECOND) - delete_node.time_second(); // 주차시간
				def = minute*60+second; // 초로 환산
				minute = def%3600/60; // 분으로 환산
				second = def%3600%60; // 초로 환산
				price = def*10; // 1초에 10원
				pre_price = delete_node.getPrice(); // 선불
				remain_price = pre_price - price; // 선불금액 - 이용한 금액
				Dnode Prev = delete_node.getBefore(); // 뺄 자동차의 압차
				Dnode Next = delete_node.getNext(); // 뺄 자동차의 뒷차
				Prev.setNext(Next); // 앞차의 다음을 뒷차로 하겠다.
				Next.setBefore(Prev); // 뒷차의 앞을 앞차로 하겠다.
				if (remain_price < 0) { // 선불 요금보다 사용한 금액이 더 많을때
					return "이용시간은 "+ minute + "분 " + second + "초 입니다.\n" +
							"요금은 " + price + "원 입니다.\n" +
							"추가로 내실 금액은 " + -remain_price + "원 입니다.\n" +	
							"저희 주차장을 이용해 주셔서 감사합니다.";
				} else { // 선불 요금이 사용한 금액보다 많을때
					return "이용시간은 "+ minute + "분 " + second + "초 입니다.\n" +
							"요금은 " + price + "원 입니다.\n" +
							"돌려 받으 실 금액은 " + remain_price + "원 입니다.\n" +	
							"저희 주차장을 이용해 주셔서 감사합니다.";
				}
			}
			delete_node=delete_node.getNext(); // 차를 찾지 못하면 다음 섹터로 찾는것 ex) 1번섹터에 업으면 2번섹터로
		}
		 return null;
	}
}
```