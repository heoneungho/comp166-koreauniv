# Introduction #
매장 관리 프로그램
시간을 입력하면 그 시간을 매장 영업 시간과 비교하여 매장의 조명을 on/off하는 프로그램입니다. 또 매장 바닥에 설치된 경비 센서도 on/off되는 프로그램입니다.
GUI를 사용하였고 자바의 장점인 객체지향적 특성을 최대한 사용하려고 노력하였습니다.
참조한 코드는 없고 모르는 부분은 책, 인터넷을 통해 찾아봤고, 이클립스의 도움을 많이 받았습니다.

발표 후
> 실행 창에 back이라는 버튼을 추가하여 편리성을 증가시켰습니다.
> 그리고 단순 if문을 for문으로 바꾸어 간단하게 코드를 구성하였습니다.
> panel같은 경우도 8개의 panel을 배열로 바꾸어 주어 더 코드를 짧게 고쳤습니다.

# 참고문헌 #
1)	Head First JAVA(한빛미디어) - 케이시 시에라, 버트 베이츠 저
2)	JAVA의 정석(도우출판) – 남궁성

# class 구성 #
1.	admini class
  1. main class로 다른 세 개의 class를 이용한다.
> 2)	다른 class에서 gui를 이용하여 만든 코드를 이 main클래스에 옮겨 놓았다.
2.	CurrentTime class
> 현재 설정한 시간을 저장하는 클래스
3.	Floor class
> 각 층의 8개의 매장을 배열로 만든 클래스
4.	Room class
> 매장 조명의 on/off를 설정해주는 클래스
# 실행화면 #
1.초기화면입니다.

![http://comp166-koreauniv.googlecode.com/files/자바실행창1.jpg](http://comp166-koreauniv.googlecode.com/files/자바실행창1.jpg)

2.아무 층을 눌렀을 때 조명은 꺼져있고 바닥은 빨간 센서가 들어와 있습니다.

![http://comp166-koreauniv.googlecode.com/files/자바실행창2.jpg](http://comp166-koreauniv.googlecode.com/files/자바실행창2.jpg)

3.초기화면에서 timeselect버튼을 클릭하면 뜨는 화면입니다.

![http://comp166-koreauniv.googlecode.com/files/자바실행창3.jpg](http://comp166-koreauniv.googlecode.com/files/자바실행창3.jpg)

4.오후 3시3분으로 시간을 설정합니다.

![http://comp166-koreauniv.googlecode.com/files/자바실행창4.jpg](http://comp166-koreauniv.googlecode.com/files/자바실행창4.jpg)

5.set버튼을 누르고 아무 층을 눌렀을 때 조명이 켜지고 빨간 센서가 꺼집니다.

![http://comp166-koreauniv.googlecode.com/files/자바실행창5.jpg](http://comp166-koreauniv.googlecode.com/files/자바실행창5.jpg)

6.back버튼과 다시 timeselect버튼을 누르고 시간을 오전 2시 4분으로 설정합니다.

![http://comp166-koreauniv.googlecode.com/files/자바실행창7.jpg](http://comp166-koreauniv.googlecode.com/files/자바실행창7.jpg)

7.set버튼을 누르고 아무 층이나 누르면 조명이 꺼지고 바닥의 빨간 센서가 들어오는 것을
볼 수 있습니다.

![http://comp166-koreauniv.googlecode.com/files/자바실행창9.jpg](http://comp166-koreauniv.googlecode.com/files/자바실행창9.jpg)



# Details #

1.	admini class
  1. main class로 다른 세 개의 class를 이용한다.
> 2)	다른 class에서 gui를 이용하여 만든 코드를 이 main클래스에 옮겨 놓았다.
```
package com.kjh.depart;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class admini {

	private JFrame frame; //기본 프레임 설정
	
	private JButton btnFloor1; //
	private JButton btnFloor2; //
	private JButton btnFloor3; //
	
	private JButton btntime; //
	
	private static Floor floor1;
	private static Floor floor2;
	private static Floor floor3;
	
	private static CurrentTime currentTime;
	
	private JTextField txtTimeSelect;
	
	//시간 설정 화면 View 객체
	private JComboBox cbMin;
	private JComboBox cbHour;
	private JComboBox cbAP;
	
	//발표 후 pnRoom을 배열로 바꿔줌.
	private static JPanel [] pnRoom = new JPanel[8];
	
	//방 패널 객체(왼쪽부터 1번)
//	private JPanel pnRoom1;
//	private JPanel pnRoom2;
//	private JPanel pnRoom3;
//	private JPanel pnRoom4;
//	private JPanel pmRoom5;
//	private JPanel pnRoom6;
//	private JPanel pnRoom7;
//	private JPanel pnROOM8;
	private JPanel secom;
	private JPanel pnBottom;
	private JTextPane pnAP;
	private JTextPane pnHr;
	private JTextPane pnMn;
	private JTextPane panel_3;
	private JButton btnSet;
	
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admini window = new admini();
					window.frame.setVisible(true);
					
					currentTime = new CurrentTime();
					
					floor1 = new Floor();
					floor2 = new Floor();
					floor3 = new Floor();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public admini() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		drawFirst();
	}
	
	private void drawFirst(){
		btnFloor1 = new JButton("B1");
		btnFloor1.setBackground(SystemColor.window);
		btnFloor1.setForeground(UIManager.getColor("Button.disabledShadow"));
		btnFloor1.setBounds(12, 10, 158, 110);
		frame.getContentPane().add(btnFloor1);
		
		btnFloor2 = new JButton("1F");
		btnFloor2.setBackground(SystemColor.window);
		btnFloor2.setForeground(UIManager.getColor("CheckBox.highlight"));
		btnFloor2.setBounds(264, 10, 158, 110);
		frame.getContentPane().add(btnFloor2);
		
		btnFloor3 = new JButton("2F");
		btnFloor3.setBackground(SystemColor.window);
		btnFloor3.setForeground(SystemColor.desktop);
		btnFloor3.setBounds(133, 142, 158, 110);
		frame.getContentPane().add(btnFloor3);
		
		btntime = new JButton("click");
		btntime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btntime.setBounds(325, 186, 97, 23);
		frame.getContentPane().add(btntime);
		
		txtTimeSelect = new JTextField();
		txtTimeSelect.setText("Time select");
		txtTimeSelect.setBounds(325, 166, 97, 21);
		frame.getContentPane().add(txtTimeSelect);
		txtTimeSelect.setColumns(10);
		
		
		btnFloor1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  removeFirst();
			  drawFloor();
			  drawSensor(floor1);
			  drawSensorColor(floor1);
		  }
		});
		
		btnFloor2.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  removeFirst();
			  drawFloor();
			  drawSensor(floor2);
			  drawSensorColor(floor2);
		  }
		});
		btnFloor3.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  removeFirst();
			  drawFloor();
			  drawSensor(floor3);
			  drawSensorColor(floor3);
		  }
		});


		btntime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFirst();
				drawTime();

			}
		});
	}
	
	private void removeFirst(){
		frame.remove(btnFloor1);
		frame.remove(btnFloor2);
		frame.remove(btnFloor3);
		frame.remove(btntime);
		frame.remove(txtTimeSelect); 
		frame.repaint();
	}
	
	private void removeFloor(){
		//발표 후 pnRoom을 배열로 변환하고 frame.remove메소드를 배열로 리팩트링.
		for(int i=0; i<8; i++){
			frame.remove(pnRoom[i]);
		}
		
//		frame.remove(pnRoom1);
//		frame.remove(pnRoom2);
//		frame.remove(pnRoom3);
//		frame.remove(pnRoom4);
//		frame.remove(pmRoom5); 
//		frame.remove(pnRoom6);
//		frame.remove(pnRoom7);
//		frame.remove(pnROOM8);
		frame.remove(secom);
		frame.remove(pnBottom);
		frame.remove(btnBack);
		frame.repaint();
	}
	
	
	private void drawFloor(){
		
		//발표 후 pnRoom을 배열로 변환한 뒤 각 pnRoom선언과 setBackground 와 setBounds는 따로 묶어서 for문으로 리팩터링함.
		for(int i=0; i<8; i++){
			pnRoom[i] = new JPanel();
			pnRoom[i].setBackground(SystemColor.desktop);
			frame.getContentPane().add(pnRoom[i]);
			
		}
		
		pnRoom[0].setBounds(14, 10, 102, 62);
		pnRoom[1].setBounds(115, 10, 102, 62);
		pnRoom[2].setBounds(218, 10, 102, 62);
		pnRoom[3].setBounds(321, 10, 103, 62);
		pnRoom[4].setBounds(14, 147, 102, 62);
		pnRoom[5].setBounds(117, 146, 102, 62);
		pnRoom[6].setBounds(220, 146, 102, 62);
		pnRoom[7].setBounds(323, 146, 102, 62);
		
//		pnRoom1 = new JPanel();
//		pnRoom1.setBackground(SystemColor.desktop);
//		pnRoom1.setBounds(14, 10, 102, 62);
//		frame.getContentPane().add(pnRoom1);
//		
//		pnRoom2 = new JPanel();
//		pnRoom2.setBackground(SystemColor.desktop);
//		pnRoom2.setBounds(115, 10, 102, 62);
//		frame.getContentPane().add(pnRoom2);
//		
//		pnRoom3 = new JPanel();
//		pnRoom3.setBackground(SystemColor.desktop);
//		pnRoom3.setBounds(218, 10, 102, 62);
//		frame.getContentPane().add(pnRoom3);
//		
//		pnRoom4 = new JPanel();
//		pnRoom4.setBackground(SystemColor.desktop);
//		pnRoom4.setBounds(321, 10, 103, 62);
//		frame.getContentPane().add(pnRoom4);
//		
//		pmRoom5 = new JPanel();
//		pmRoom5.setBackground(SystemColor.desktop);
//		pmRoom5.setBounds(14, 147, 102, 62);
//		frame.getContentPane().add(pmRoom5);
//		
//		pnRoom6 = new JPanel();
//		pnRoom6.setBackground(SystemColor.desktop);
//		pnRoom6.setBounds(117, 146, 102, 62);
//		frame.getContentPane().add(pnRoom6);
//		
//		pnRoom7 = new JPanel();
//		pnRoom7.setBackground(SystemColor.desktop);
//		pnRoom7.setBounds(220, 146, 102, 62);
//		frame.getContentPane().add(pnRoom7);
//		
//		pnROOM8 = new JPanel();
//		pnROOM8.setBackground(SystemColor.desktop);
//		pnROOM8.setBounds(323, 146, 102, 62);
//		frame.getContentPane().add(pnROOM8);
		
		
		
		secom = new JPanel();
		secom.setBackground(SystemColor.window);
		secom.setBounds(14, 70, 411, 78);
		frame.getContentPane().add(secom);
		secom.setLayout(null);
		
		pnBottom = new JPanel();
		pnBottom.setBackground(SystemColor.textHighlight);
		pnBottom.setBounds(17, 10, 379, 59);
		secom.add(pnBottom);
	
		//발표 후 뒤로 가기 버튼을 추가 했습니다. 
		btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.window);
		btnBack.setForeground(UIManager.getColor("CheckBox.highlight"));
		btnBack.setBounds(360, 230, 70, 30);
		frame.getContentPane().add(btnBack);
	
		//발표 후 Back버튼 추가 했습니다. 버튼 눌렀을 때 click 이벤트 
		btnBack.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  removeFloor();
			  drawFirst();
			  
		  }
		});

	}
	
	private void drawSensor(Floor floor){
		//발표 후 store배열을 for문을 통해 리펙터링함
		for(int i=0; i<8; i++){
			floor.store[i] = new Room();
		}
//		floor.store[0] = new Room();
//		floor.store[1] = new Room();
//		floor.store[2] = new Room();
//		floor.store[3] = new Room();
//		floor.store[4] = new Room();
//		floor.store[5] = new Room();
//		floor.store[6] = new Room();
//		floor.store[7] = new Room();
		
		//PM이고 9시보다 작으면 ON
		if(currentTime.isAp() && currentTime.getHour() < 9 ){
			System.out.println("ON");
//			floor.store[0].setLight(true);
//			floor.store[1].setLight(true);
//			floor.store[2].setLight(true);
//			floor.store[3].setLight(true);
//			floor.store[4].setLight(true);
//			floor.store[5].setLight(true);
//			floor.store[6].setLight(true);
//			floor.store[7].setLight(true);
			
			//발표 후 단순 if문으로 했던 것을  for문을 사용하여 효율적으로 리팩토링.
			for(int i=0; i<8; i++){
				floor.store[i].setLight(true);
			}
		//AM이고 9시보다 크면 ON
		}else if(!currentTime.isAp() && currentTime.getHour() > 9){
			System.out.println("ON");
//			floor.store[0].setLight(true);
//			floor.store[1].setLight(true);
//			floor.store[2].setLight(true);
//			floor.store[3].setLight(true);
//			floor.store[4].setLight(true);
//			floor.store[5].setLight(true);
//			floor.store[6].setLight(true);
//			floor.store[7].setLight(true);
			
			//발표 후 단순 if문으로 했던 것을  for문을 사용하여 효율적으로 리팩토링.
			for(int i=0; i<8; i++){
				floor.store[i].setLight(true);
			}
		//그 외의 시간은 OFF
		}else{
			System.out.println("OFF");
//			floor.store[0].setLight(false);
//			floor.store[1].setLight(false);
//			floor.store[2].setLight(false);
//			floor.store[3].setLight(false);
//			floor.store[4].setLight(false);
//			floor.store[5].setLight(false);
//			floor.store[6].setLight(false);
//			floor.store[7].setLight(false);
		
			//발표 후 단순 if문으로 했던 것을  for문을 사용하여 효율적으로 리팩토링.
			for(int i=0; i<8; i++){
				floor.store[i].setLight(false);
			}
		}
	
		if(currentTime.isAp() && currentTime.getHour() > 9){
			System.out.println("secom on");
			secom.setBackground(Color.RED);
		}else if(!currentTime.isAp() && currentTime.getHour() < 9){
			System.out.println("secom on");
			secom.setBackground(Color.RED);
		}else{
			System.out.println("secom OFF");
		}
	}
	
	//바닥의 sensor의 조명을 실행시키는 메소드
	private void drawSensorColor(Floor floor){
		//발표 후 단순 if문을 for문으로 리팩터링함.
		for(int i=0; i<8; i++){
			if(floor.store[i].isLight()){
				// 발표 후 pnRoom을 배열로 리팩러링함.
				//발표 후 단순 if문을 for문으로 리팩터링함.
				for(int j=0; j<8; j++){
				pnRoom[j].setBackground(Color.blue);
			
				}
			}
		}
//		if(floor.store[0].isLight()){
//			pnRoom1.setBackground(Color.blue);
//		}
//		if(floor.store[1].isLight()){
//			pnRoom2.setBackground(Color.blue);
//		}
//		if(floor.store[2].isLight()){
//			pnRoom3.setBackground(Color.blue);
//		}
//		if(floor.store[3].isLight()){
//			pnRoom4.setBackground(Color.blue);
//		}
//		if(floor.store[4].isLight()){
//			pmRoom5.setBackground(Color.blue);
//		}
//		if(floor.store[5].isLight()){
//			pnRoom6.setBackground(Color.blue);
//		}
//		if(floor.store[6].isLight()){
//			pnRoom7.setBackground(Color.blue);
//		}
//		if(floor.store[7].isLight()){
//			pnROOM8.setBackground(Color.blue);
//		}
	}
	
	//시간 설정을 위한 gui메소드
	private void drawTime(){
		cbMin = new JComboBox();
		cbMin.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "00"}));
		cbMin.setBounds(220, 139, 214, 41);
		frame.getContentPane().add(cbMin);
		cbMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTime.setMin(Integer.parseInt(cbMin.getSelectedItem().toString()));
				System.out.println(currentTime.getMin());
			}
		});
		
		cbHour = new JComboBox();
		cbHour.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbHour.setBounds(220, 99, 214, 41);
		frame.getContentPane().add(cbHour);
		cbHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTime.setHour(Integer.parseInt(cbHour.getSelectedItem().toString()));
				System.out.println(currentTime.getHour());
			}
		});
		
		cbAP = new JComboBox();
		cbAP.setModel(new DefaultComboBoxModel(new String[] {"PM", "AM"}));
		cbAP.setBounds(220, 61, 214, 41);
		frame.getContentPane().add(cbAP);
		cbAP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(cbAP.getSelectedIndex() == 0){
					currentTime.setAp(true);
				}else{
					currentTime.setAp(false);
				}
			}
		});
		
		//시간 설정 박스 옆의 메뉴판
		pnAP = new JTextPane();
		pnAP.setBackground(Color.YELLOW);
		pnAP.setBounds(12, 61, 196, 41);
		pnAP.setText("PM/AM");
		frame.getContentPane().add(pnAP);
		
		pnHr = new JTextPane();
		pnHr.setBackground(Color.CYAN);
		pnHr.setBounds(12, 99, 196, 41);
		pnHr.setText("Hour");
		frame.getContentPane().add(pnHr);
		
		pnMn = new JTextPane();
		pnMn.setBackground(Color.GREEN);
		pnMn.setBounds(12, 139, 196, 41);
		pnMn.setText("Minute");
		frame.getContentPane().add(pnMn);
		
		panel_3 = new JTextPane();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 10, 422, 41);
		panel_3.setText("Time select");
		frame.getContentPane().add(panel_3);
		
		btnSet = new JButton("Set");
		btnSet.setBounds(173, 217, 97, 23);
		frame.getContentPane().add(btnSet);
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				removeTime();
				drawFirst();
				String ap = "";
				if(currentTime.isAp()){
					ap = "PM";
				}else{
					ap = "AM";
				}
				txtTimeSelect.setText( ap + "." + currentTime.getHour() + " : "+currentTime.getMin() );
			}
		});
	}
	
	//시간 설정 창에서 set후 다음 창으로 넝어갈 때 시간설정창의 frame을 지우기 위한 메소드
	private void removeTime(){
		frame.remove(cbMin);
		frame.remove(cbHour);
		frame.remove(cbAP);
		frame.remove(pnRoom[1]);
		frame.remove(pnAP);
		frame.remove(pnHr);
		frame.remove(pnMn);
		frame.remove(panel_3);
		frame.remove(btnSet);
		frame.repaint();
	}
}

```

2.	CurrentTime class
> 현재 설정한 시간을 저장하는 클래스

```
package com.kjh.depart;

//현재 설정한 시간을 저장하는 클래스
public class CurrentTime {

	private boolean ap = false;
	private int hour, min;

	public boolean isAp() {
		return ap;
	}

	public void setAp(boolean ap) {
		this.ap = ap;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
}
```

3.	Floor class
> 각 층의 8개의 매장을 배열로 만든 클래스
```
package com.kjh.depart;

public class Floor {
	
	Room [] store = new Room[8];
	
}
```

4.	Room class
> 매장 조명의 on/off를 설정해주는 클래스
```
package com.kjh.depart;

//매장 조명의 on/off를 설정해주는 클래스
public class Room {

	private boolean light = false;

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
			
}
```