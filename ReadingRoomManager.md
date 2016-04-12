# Links for contents #

> 

# Introduction #

http://comp166-koreauniv.googlecode.com/files/Intro1.JPG

독서실의 빈 좌석과 이용 중인 좌석을 보여주고,
이용 중인 좌석의 요금을 계산해주는 **독서실 좌석 관리 프로그램\*입니다.**

| **개발환경** |
|:---------|

> - Intel(R) Core(TM)2 DUO CPU E7200 @ 2.53GHz

> - 2.53GHz, 2.00GB RAM

> - OS: Microsoft Windows XP Professional KN SP3 (32-bit)

> - Eclipse IDE for Java Developers ( Version: 1.5.1 )

| **개발기간** |
|:---------|

> - 2012년 9월 24일(월)  ~  2012년 12월 2일(일)

> - 총 70일 소요

# Background&Details&Outline #



**1) Background(배경)**



http://comp166-koreauniv.googlecode.com/files/Reading1.JPG



> 고등학생 시절, 야간 자율 학습을 마치고 곧 바로 집 앞 독서실에 들러 추가로 공부를 하곤했었는데,

> 그 당시 독서실 주인 아주머니께서는 독서실 회원들을 컴퓨터를 이용하여 관리하셨었습니다.

> 자바를 공부하는 지금, 독서실 관리를 좀 더 효율적으로 할 수 있는 프로그램을 만들어보자는 취지로

> "독서실 좌석 관리 프로그램"을 기획했습니다.

> PC방과 당구장에서 사람들이 있는 자리를 체크하고 시간과 요금을 측정하는 것에착안하여,

> 독서실의 빈 좌석과 이용 중인 좌석을 보여주고 요금을 계산하는 **『독서실 좌석 관리 프로그램』**을 만들 것입니다.


**2) Requirement(요구사항)**

  * 독서실의 **빈 좌석\*과**이용 중 좌석\*을 나타냅니다.
- 독서실의 현재 상황을 한눈에 볼 수 있도록 제작되어야합니다.

  * 이용 중 좌석 중 기간제 좌석과 시간별 좌석의 **요금\*을 나타냅니다.
- 요금의 계산은 기간제, 시간제 좌석을 구분하여 계산합니다.**

  * 기록 및 관리
- 사용 여부 내역을 저장 및 열람이 가능해야합니다.

- 요금 합계 및 통계 기능이 가능해야합니다.

  * 독서실에 온 학생의 **ID카드 넘버\*와**이름\*을 각 좌석에 표시해줍니다.

  * 좌석 표시 화면에는 현재 시간, 좌석 관리, 통계, 요금 설정 등의 기능이 있어야합니다.


**3) Program Structure(프로그램 구조)**

**[도식화]**

| **독서실 관리자** | ↔ | **프로그램** | ↔ | **입실, 퇴실, 이용 내역** | ↔ | **파일** |
|:------------|:--|:---------|:--|:------------------|:--|:-------|


http://comp166-koreauniv.googlecode.com/files/diagram.JPG


**4) UI구상**

- 프로그램은 총 4개의 화면으로 구성됩니다.

- 메인화면, 요금 설정 화면, 입실 및 퇴실 화면, 이용내역 화면

**①메인화면**

http://comp166-koreauniv.googlecode.com/files/main.JPG

- 자리가 비어있으면 자리 번호로 표시됩니다.

- 입실자가 자리를 사용 중인 경우 개인 ID가 붉은 색으로 표시됩니다.

- 자리 번호 클릭시 입실 화면으로 넘어갑니다.

- 입실자 ID 클릭시 퇴실 화면으로 넘어갑니다.

- 메인화면 아래에 텍스트 박스를 설정해 입실, 퇴실 내역을 보여줍니다.

**②요금 설정화면**

http://comp166-koreauniv.googlecode.com/files/price.JPG

- 기간제, 시간제 회원별 요금 설정이 가능합니다.

**③입실, 퇴실화면**

http://comp166-koreauniv.googlecode.com/files/enterWindow.JPG

- 입실 화면에서는 기간제, 시간제 회원을 선택하고 회원 ID를 적은 후 확인 버튼을 누르면 입실 처리됩니다.

- 퇴실 화면에서는 자동으로 사용 요금이 계산되며, 확인 버튼을 누르면 퇴실 처리됩니다.

**④이용내역화면**

http://comp166-koreauniv.googlecode.com/files/이용내역.JPG

- 현재까지 기록을 보여주며 회원 ID, 날짜별로 검색이 가능합니다.

**5)클래스/인터페이스 설정**

**계승다이어그램**

![http://comp166-koreauniv.googlecode.com/files/chart.jpg](http://comp166-koreauniv.googlecode.com/files/chart.jpg)


**1. 메인 클래스(mainYoungHoon)**

![http://comp166-koreauniv.googlecode.com/files/mY.jpg](http://comp166-koreauniv.googlecode.com/files/mY.jpg)

```
public class mainYoungHoon{

public static void main(String[] args) {

		mainWindow cl = new mainWindow();// 메인윈도우 객체 생성

	}

}

```
- mainWindow클래스를 실행
```
mainWindow cl = new mainWindow();// 메인윈도우 객체 생성
```

**2. 메인 화면 클래스(mainWindow)**

![http://comp166-koreauniv.googlecode.com/files/mW.jpg](http://comp166-koreauniv.googlecode.com/files/mW.jpg)

```
class mainWindow extends JFrame {

	JTextField blank; // 상단의 시계표시를 위해 공백을 만드는 텍스트필드

	int jariNumber; // 자리번호

	public mainWindow() {
	}

	public void actionPerformed() {
	}

	// 버튼을 생성하는 메소드
	public void gridInit() {
	}

	// 상단 판넬
	public void pan1() {
	}

	// 중앙 버튼 부분 판넬
	public void pan2() {	
	}

	// 하단 상황판 부분 판넬
	public void pan3() {
	}

	// 스레드 실행 부분
	public void run() {	
	}

}

```
**[메소드 설명]**

- mainWindow() : 생성자, 기본적인 틀을 만듭니다.
```
setTitle("독서실 관리 프로그램");// 제목표시줄

setSize();// 사이즈 설정

pan1();// 메소드 호출

pan2();// 메소드 호출

pan3();// 메소드 호출

gridInit();// 메소드 호출

setVisible(true);// 창을 보여줌

```

- pan1() : 상단의 판넬 생성
```
pan1 = new JPanel();// 판넬1 생성

pan1.add(blank = new JTextField());// 상단의 시계표시를 위해 공백을 만드는 텍스트필드
```
- pan2() : 독서실 화면 부분의 판넬 생성
```
pan2 = new JPanel();// 패널 생성
```
- pan3() : 상황판 등 하단의 판넬 생성
```
pan3 = new JPanel();// 패널 생성

pan3.add(condition = new JTextArea());// 상황판을 생성

pan3.add(history = new JButton("내역보기"));// 버튼 부착

pan3.add(configBtn = new JButton("요금설정"));// 버튼 부착
```
- gridInit() : 독서실 부분에 버튼을 부착

- run() : 상단에 시계를 표시하기 위해 쓰레드를 실행
```
Date d = new Date();// 날짜 객체 생성
```

- actionPerformed() : 버튼이벤트 설정
```
jariNumber = Integer.parseInt();// 자리번호 변수에 저장하고

new enterWindow(jariNumber);// 그것을 매개변수로 입실 창 띄우기
```

**3. 입실 화면 클래스(enterWindow)**

![http://comp166-koreauniv.googlecode.com/files/eW.jpg](http://comp166-koreauniv.googlecode.com/files/eW.jpg)

```
class enterWindow{

enterWindow() {} // 생성자, 기본적인 틀을 만듬

pan1(){} // 판넬 생성 및 윈도우 구성

layout(){} // 그리드백 레이아웃에 객체 부착

actionPerformed(){} // 버튼 이벤트 설정

itemStateChanged(){} // 기간제, 시간제 선택 설정

}

```
**[메소드 설명]**

- enterWindow() :　생성자, 기본적인 틀을 만듬
```
setTitle("입실");// 제목표시줄
```

- pan1() : 판넬을 생성하고 윈도우를 구성

- layout() : 그리드백 레이아웃에 객체를 부착하는 메소드

- actionPerformed() : 버튼이벤트 설정
```
IDNumber = tf1.getText();// 손님 ID 번호를 텍스트박스에서 받음

jariNumber = tf2.getText();// 자리 번호를 텍스트박스에서 받음
```
- itemStateChanged() : 체크박스 이벤트 설정(기간제, 시간제 선택)


**4. 퇴실 화면 클래스(leaveWindow)**

![http://comp166-koreauniv.googlecode.com/files/lW.jpg](http://comp166-koreauniv.googlecode.com/files/lW.jpg)

```
public class leaveWindow extends JFrame{

leaveWindow() {} // 생성자,기본적인 틀을 만듬

pan1(){} // 판넬, 윈도우 구성

layout(){} // 레이아웃에 객체 부착

intime(){} // 좌석 이용 시간 계산

charge(){} // 독서실 이용 요금 계산

actionPerformed(){} // 버튼 작동 설정

}

```
**[메소드 설명]**

- leaveWindow() : 생성자,기본적인 틀을 만듬

- pan1() : 판넬을 생성하고 윈도우를 구성

- layout() : 그리드백 레이아웃에 객체를 부착하는 메소드

- intime() : 좌석 이용 시간을 계산하는 메소드

- charge() : 독서실 이용 요금을 계산하는 메소드

- actionPerformed() : 버튼이벤트 설정



**5. 내역 화면 클래스(logWindow)**

![http://comp166-koreauniv.googlecode.com/files/fhrm.jpg](http://comp166-koreauniv.googlecode.com/files/fhrm.jpg)

```
public class logWindow{

logWindow() {} // 생성자

pan1(){} // 상단 판넬

pan3(){} // 하단 검색 판넬

defaultTable(){} // 기본 테이블

IDNumberSearch(){} // 사용자 ID 번호로 검색

dataSearch(){} // 날짜로 검색

remove table(){} // 테이블 내용 삭제

total(){} // 통계 계산

actionPerformed(){} // 버튼 설정

}

```
**[메소드 설명]**

- logWindow() : 생성자

- pan1() : 상단의 테이블부분 판넬 생성

- pan3() : 하단의 검색부분 판넬 생성

- defaultTable() : 기본 테이블을 불러오는 메소드

- IDNumberSearch() : 사용자 ID번호로 검색하는 메소드

- dateSearch() : 날짜로 검색하는 메소드

- remove table() : 테이블의 내용을 지우는 메소드

- total() : 통계부분을 계산하는 메소드

- actionPerformed() : 버튼이벤트 설정


**6. 환경 설정 클래스(config)**

![http://comp166-koreauniv.googlecode.com/files/cf.jpg](http://comp166-koreauniv.googlecode.com/files/cf.jpg)

```
public class config{

config() {} // 생성자

pan1() {} // 판넬 생성

layout() {} // 객체 부착

actionPerformed() {} // 버튼 설정

}

```
**[메소드 설명]**

- config() : 생성자

- pan1() : 판넬을 생성하고 윈도우를 구성

- layout() : 그리드백 레이아웃에 객체를 부착하는 메소드

- actionPerformed() : 버튼이벤트 설정


**7. 데이터를 파일로부터 읽는 클래스(readFile)**

![http://comp166-koreauniv.googlecode.com/files/rF.jpg](http://comp166-koreauniv.googlecode.com/files/rF.jpg)

```
public class readFile{

readFile(){} // 생성자

readconfig(){} // 설정된 요금을 읽어옴

readdata(){}// 독서실의 상황 및 내역을 읽어옴

}

```
**[메소드 설명]**

- readFile() : 생성자

- readconfig() : 설정된 요금을 읽어옴

- readdata() : 독서실의 상황과 현재까지의 내역을 읽어옴


**8. 데이터를 파일에 저장하는 클래스(writeFile)**

![http://comp166-koreauniv.googlecode.com/files/wF.jpg](http://comp166-koreauniv.googlecode.com/files/wF.jpg)

```
public class writeFile {

write() {} // 생성자

writeFile() {} // 파일에 독서실의 상황 및 내역을 써 넣음

}

```
**[메소드 설명]**

- write() : 생성자

- writeFile() : 파일에 독서실의 상황 및 내역을 써 넣음


**9. 현재까지 기록을 읽는 클래스(readLog)**

![http://comp166-koreauniv.googlecode.com/files/rL.jpg](http://comp166-koreauniv.googlecode.com/files/rL.jpg)

```
public class readLog {

readLog(){} // 생성자

}

```
**[메소드 설명]**

- readLog() : 생성자


**10. 상황을 출력하는 클래스(message)**

![http://comp166-koreauniv.googlecode.com/files/me.jpg](http://comp166-koreauniv.googlecode.com/files/me.jpg)

```
public class message{

message() {} 

}

```
**[메소드 설명]**

- message() :

2개의 생성자를 가지고 있음.

매개변수가 4개가 들어오면 입실,

7개가 들어오면 퇴실에 메세지를 저장


**11. 시스템 시간을 저장하는 인터페이스**

![http://comp166-koreauniv.googlecode.com/files/aa.jpg](http://comp166-koreauniv.googlecode.com/files/aa.jpg)

```

import java.util.Calendar;

//시스템으로 부터 시간을 받아와 저장하는 인터페이스
public interface time {

	Calendar present = Calendar.getInstance();

	int day = present.get(Calendar.DATE);

	int hour = present.get(Calendar.HOUR_OF_DAY);

	int min = present.get(Calendar.MINUTE);

	int month = present.get(Calendar.MONTH) + 1;

	int sec = present.get(Calendar.SECOND);

	int year = present.get(Calendar.YEAR);

}

```

- day, hour, min, month, present, sec, year

# Project-Start #

http://comp166-koreauniv.googlecode.com/files/start.JPG


```
/* 독서실을 관리하는 프로그램인 ReadingRoomManager입니다. */

// mainYoungHoon 클래스입니다.
public class mainYoungHoon {

	public static void main(String[] args) {
		mainWindow cl = new mainWindow();// 메인 윈도우 객체를 생성합니다.
		Thread th = new Thread(cl);// 객체를 스레드로 생성합니다.
		th.start();// 스레드를 실행합니다.
	}
}
===============================================================================================================

/* mainWindow 클래스입니다. 여기가 메인 창입니다. */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
class mainWindow extends JFrame implements Runnable, ActionListener {
	JTextField blank;// 상단의 시계표시를 위해 공백을 만드는 텍스트필드입니다.
	public JButton Btn[] = new JButton[150];// 자리 버튼입니다. 
	JTextArea condition;// 상황판의 텍스트 영역입니다.
	JButton configBtn;// 요금 설정 버튼입니다.
	String currentDate = "";// 현재 날짜를 저장
	String currentTime = "";// 현재 시간을 저장
	JButton history;// 내역보기 버튼입니다.
	int jariNumber;// 자리번호입니다.
	JButton notUseBtn[] = new JButton[100];// 사용하지 않는 버튼(자리 사이 사이의 버튼)
	readFile obj = new readFile();// 파일을 읽어들입니다.
	JPanel pan1;// 판넬1
	JPanel pan2;// 판넬2
	JPanel pan3;// 판넬3

	// 생성자
	public mainWindow() {
		setTitle("[독서실 관리 프로그램(ReadingRoomManager)]");// 제목 표시줄입니다.
		setSize(1000, 700); // 사이즈를 설정합니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 클릭시 종료합니다.
		pan1();// 메소드 호출
		pan2();// 메소드 호출
		pan3();// 메소드 호출
		gridInit();// 메소드 호출
		setVisible(true);// 창을 보여줌
		setResizable(false);// 크기변경 불가
	}

	@SuppressWarnings("deprecation")
	// 버튼 이벤트를 설정합니다.
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == configBtn) {// 요금설정 버튼
			new config();// 요금설정 클래스 실행
		} else if (e.getSource() == history) {// 내역보기 버튼
			new logWindow();// 내역보기 클래스 실행
		} else if (Integer.parseInt(e.getActionCommand()) >= 0// 버튼의 이름을 정수형태로
				// 변환하여
				&& Integer.parseInt(e.getActionCommand()) <= Btn.length) {// 0~150사이의
			// 숫자면
			jariNumber = Integer.parseInt(e.getActionCommand());// 자리번호 변수에 저장하고
			new enterWindow(jariNumber);// 그것을 매개변수로 입실자 창 띄우기
			dispose();// 창을 닫음
		} else {// 0~150사이의 숫자가 아닐시에는
			for (int i = 1; i < Btn.length; i++) {// 버튼을 처음부터 끝까지 검색
				String temp = Btn[i].getLabel();// temp에 버튼의 라벨을 저장
				int temp2 = Integer.parseInt(temp);// temp1에 저장한 라벨을 정수형태로 변환하여
				// 저장해 둠
				if (temp2 == Integer.parseInt(e.getActionCommand())) {
					// temp2에 저장해둔 라벨과 액션이벤트로 들어온 매개변수가 같다면
					// 사람이 사용하는 자리가 바로 그 자리 이므로
					jariNumber = i;// 자리번호는 i
					break;// 루프를 나옴
				}
			}
			new leaveWindow(jariNumber);// 자리번호를 매개변수로 퇴실 창을 띄움
			dispose();// 창을 닫음
		}
	}

	@SuppressWarnings("deprecation")
	// 버튼을 생성하는 메소드
	public void gridInit() {
		for (int i = 1; i <= 15; i++) {
			pan2.add(Btn[i] = new JButton(i + ""));
			Btn[i].addActionListener(this);
		}
		for (int i = 1; i <= 15; i++) {
			pan2.add(notUseBtn[i] = new JButton(""));
			notUseBtn[i].setEnabled(false);
		}
		for (int i = 16; i <= 45; i++) {
			pan2.add(Btn[i] = new JButton(i + ""));
			Btn[i].addActionListener(this);
		}
		for (int i = 16; i <= 30; i++) {
			pan2.add(notUseBtn[i] = new JButton(""));
			notUseBtn[i].setEnabled(false);
		}
		for (int i = 46; i <= 75; i++) {
			pan2.add(Btn[i] = new JButton(i + ""));
			Btn[i].addActionListener(this);
		}
		for (int i = 31; i <= 45; i++) {
			pan2.add(notUseBtn[i] = new JButton(""));
			notUseBtn[i].setEnabled(false);
		}
		for (int i = 76; i <= 90; i++) {
			pan2.add(Btn[i] = new JButton(i + ""));
			Btn[i].addActionListener(this);
		}
		// 여기까지 버튼 생성
		int i = 0;
		// 회원이 입실한 자리의 라벨과 색깔을 바꿈
		while (i < obj.length) {// 객체의 length 변수만큼 loop
			int temp = Integer.parseInt(obj.jariNumber[i]);// 파일에 저장된 자리번호를
			// temp에 정수형태로 저장
			Btn[temp].setLabel(obj.idNumber[i]);// 자리번호의 버튼의 라벨을 회원번호로 바꿈
			Btn[temp].setForeground(new Color(255, 0, 0));// 색깔을 붉은색으로 바꿈
			i++;
		}
	}

	@Override
	// 상단의 시계를 그리는 메소드
	public void paint(Graphics g) {
		g.setColor(Color.blue);// 사각형색 파란색
		g.fillRect(0, 0, 1500, 100);// 0,0을 기준으로 1500,100 만큼 사각형을 채움
		g.setColor(Color.white);// 글자색 흰색
		Font f1 = new Font("맑은 고딕", Font.BOLD, 24);// 폰트 생성
		g.setFont(f1);// 폰트 설정
		g.drawString(currentDate, 400, 50);// 날짜를 띄움
		g.drawString(currentTime, 410, 90);// 시간을 띄움

	}

	// 상단 판넬
	public void pan1() {
		pan1 = new JPanel();// 판넬1 생성
		pan1.add(blank = new JTextField());// 상단의 시계표시를 위해 공백을 만드는 텍스트필드
		blank.setPreferredSize(new Dimension(900, 70));// 공백 사이즈
		blank.setEnabled(false);// 비활성화
		add(pan1, "North");// 판넬1 부착
	}

	// 중앙 버튼부분 판넬
	public void pan2() {
		pan2 = new JPanel();// 패널 생성
		GridLayout layout = new GridLayout(9, 1);// 그리드 레이아웃 생성
		pan2.setLayout(layout);// 레이아웃 설정
		add(pan2);// 판넬2 부착
	}

	// 하단 상황판 부분 판넬
	public void pan3() {
		pan3 = new JPanel();// 패널 생성
		pan3.add(condition = new JTextArea());// 상황판을 생성
		for (int i = 0; i < 11; i++) {// 상황판에 message 클래스에 저장된 메세지를 출력함
			condition.append(message.message[i]);
		}
		condition.setPreferredSize(new Dimension(700, 200));// 상황판 사이즈
		condition.setEditable(false);// 편집 불가
		pan3.add(history = new JButton("독서실 이용내역보기"));// 버튼 부착
		pan3.add(configBtn = new JButton("요금설정"));// 버튼 부착
		history.addActionListener(this);// 액션리스너 추가
		configBtn.addActionListener(this);// 액션리스터 추가
		add(pan3, "South");// 판넬3 부착
	}

	// 스레드 실행 부분
	public void run() {
		while (true) {// 반복문
			Date d = new Date();// 날짜 객체 생성
			SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일");// 형식
			// 지정
			SimpleDateFormat time = new SimpleDateFormat("hh시 mm분 ss초");// 형식 지정
			currentDate = date.format(d);// 현재 날짜를 위에 저장해둔 형식으로 문자열 저장
			currentTime = time.format(d);// 현재 시간을 위에 저장해둔 형식으로 문자열 저장
			try {
				Thread.sleep(500);// 0.5초 텀을 두고
				repaint();// 다시그리기를 반복
			} catch (InterruptedException e) {
			}
		}
	}
}

===============================================================================================================

/* 입실 창입니다 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.StringTokenizer;

import javax.swing.*;

@SuppressWarnings("serial")
public class enterWindow extends JFrame implements ActionListener, ItemListener,
time {
	GridBagConstraints c;
	JButton cancel;
	String idNumber = ""; // 회원번호
	String deskSelect = ""; // 이용 요금제 선택
	CheckboxGroup cbg;
	JButton confirm;
	String jariNumber = ""; // 자리번호
	Label label1;
	Label label2;
	Label label3;
	Checkbox termprice; // 기간제 이용자
	Checkbox hourprice; // 시간제 이용자
	readFile obj = new readFile();
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	String enterTime = ""; // 입실 시간
	String printenterTime = ""; // 출력용 입실 시간	
	String[] temp = new String[5];
	JTextField tf1;
	JTextField tf2;

	// 생성자
	public enterWindow(int jariNumber) {
		this.jariNumber = "" + jariNumber;
		setTitle("입실자");// 제목표시줄
		setSize(400, 250);// 사이즈
		setLocation(350, 250);// 창이 뜨는 위치
		setVisible(true);// 창을 보이도록 설정
		setResizable(false);// 크기 변경 불가
		pan1();

	}

	// 액션이벤트
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == confirm) {// 확인버튼
			idNumber = tf1.getText();// 회원 번호를 텍스트박스에서 받음
			jariNumber = tf2.getText();// 자리번호를 텍스트박스에서 받음
			try {// 회원번호가 숫자가 아닐시 다이얼로그 창 띄우서 메세지 출력
				Integer.parseInt(idNumber);
			} catch (java.lang.NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "회원번호는 4자리 이상의 숫자여야 합니다.");
				return;
			}
			if (deskSelect.equals("")) {// 요금제 선택이 비어있을시 메세지 출력
				JOptionPane.showMessageDialog(null, "요금제를 선택하세요.");
				return;
			} else if (idNumber.length() < 4) {// 회원번호가 4자리보다 적을시 메세지 출력
				JOptionPane.showMessageDialog(null, "회원번호는 4자리 이상의 숫자여야 합니다.");
				return;
			} else {// 입실
				for (int i = 0; i < 120; i++) {// 자리가 이미 입실되어있는지 검색하고 입실되어 있으면
					try { // 메세지 출력
						if (idNumber.equals(obj.idNumber[i])) {
							JOptionPane.showMessageDialog(null,
									"이미 입실되어 있는 자리입니다.");
							return;
						}
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					} catch (java.lang.NullPointerException e1) {
					}
				}
			}
			// 회원님 입실
			enterTime = "" + year + "/" + month + "/" + day + "/" + hour + "/"
					+ min;// 입실 시간을 저장
			printenterTime = ConvertTime(enterTime);// 화면 출력용 입실시간을 저장
			new writeFile(jariNumber, deskSelect, idNumber, enterTime, "-", "-",
					"-");// 파일에 쓰는 클래스로 매개변수롤 넘겨줌
			new message(jariNumber, deskSelect, idNumber, printenterTime);// 메세지
			// 출력
			// 클래스로
			// 매개변수를
			// 넘겨줌
			dispose();// 창 닫음
		} else if (ae.getSource() == cancel) {// 취소 버튼
			dispose();// 창 닫음
		}
		mainWindow cl = new mainWindow();
		Thread th = new Thread(cl);
		th.start();// 스레드를 재실행
	}

	// 저장된 시간을 화면출력용 시간으로 바꾸는 메소드
	private String ConvertTime(String time) {
		StringTokenizer parse = new StringTokenizer(time, "/");// 토크나이저로 저장된 시간을
		// 나눈후
		temp[0] = parse.nextToken();// 배열에 각각 저장
		temp[1] = parse.nextToken();
		temp[2] = parse.nextToken();
		temp[3] = parse.nextToken();
		temp[4] = parse.nextToken();
		String printTime = temp[0] + "년 " + temp[1] + "월 " + temp[2] + "일 "
				+ temp[3] + "시 " + temp[4] + "분";// 다시 출력용 시간으로 합침
		return printTime;
	}

	@Override
	// 체크박스 이벤트
	public void itemStateChanged(ItemEvent ie) {
		// 독서실 사용자 요금제 선택함.
		if (ie.getSource() == hourprice) {
			deskSelect = "시간제 사용자";
		} else if (ie.getSource() == termprice) {
			deskSelect = "기간제 사용자";
		}

	}

	// 그리드백 레이아웃을 손쉽게 사용하기위해 만듬
	public void layout(Component obj, int x, int y, int width, int height) {
		c.gridx = x; // 시작위치 x
		c.gridy = y; // 시작위치 y
		c.gridwidth = width; // 컨테이너 너비
		c.gridheight = height; // 컨테이너 높이
		add(obj, c);
	}

	// 판넬
	public void pan1() {
		GridBagLayout gridbag = new GridBagLayout();// 그리드백 레이아웃 생성
		setLayout(gridbag);// 레이아웃 설정
		c = new GridBagConstraints();// 그리드백 레이아웃을 제어하는 객체
		c.fill = GridBagConstraints.BOTH; // 전체를 채움
		CheckboxGroup cbg = new CheckboxGroup();// 체크박스 그룹
		hourprice = new Checkbox("시간제 사용자", cbg, false);
		termprice = new Checkbox("기간제 사용자", cbg, false);
		tf1 = new JTextField();// 회원번호 텍스트필드
		tf2 = new JTextField(jariNumber);// 자리번호 텍스트필드
		confirm = new JButton("확인");// 확인버튼
		cancel = new JButton("취소");// 취소버튼
		confirm.addActionListener(this);// 액션리스너 등록
		cancel.addActionListener(this);// 액션리스너 등록
		layout(new Label("요금제"), 0, 0, 1, 2); // 라벨 부착
		layout(hourprice, 1, 1, 1, 1);
		layout(termprice, 2, 1, 1, 1);

		// 아이템 리스너 등록
		hourprice.addItemListener(this);
		termprice.addItemListener(this);

		layout(new Label("회원번호"), 0, 2, 1, 1);// 라벨 부착
		layout(tf1, 1, 2, 4, 1);// 텍스트필드 부착
		layout(new Label("자리번호"), 0, 3, 1, 1);// 라벨 부착
		layout(tf2, 1, 3, 4, 1);// 텍스트필드 부착
		layout(new Label(""), 1, 4, 1, 1);// 한칸 공백
		layout(new Label("입실하시겠습니까?"), 1, 5, 4, 1);// 라벨 부착
		layout(confirm, 1, 6, 2, 1);// 확인버튼 부착
		layout(cancel, 3, 6, 2, 1);// 취소버튼 부착
		tf2.setEditable(false);// 자리번호 텍스트필드 편집 불가

	}
}

===============================================================================================================

// 퇴실 창입니다
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.*;

@SuppressWarnings("serial")
public class leaveWindow extends JFrame implements ActionListener, time {
	GridBagConstraints c;
	JButton cancel;
	String idNumber; // 회원 번호
	String deskSelect; // 독서실 요금제 선택
	CheckboxGroup cbg;
	String charge; // 요금
	JButton confirm;
	String inTime;
	String jariNumber; // 자리 번호
	Checkbox hourprice; // 시간제 이용
	Checkbox termprice; // 기간제 이용
	readFile obj = new readFile();
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	String enterTime; // 입실 시간
	StringTokenizer parse;
	String printenterTime; // 입실시간 출력
	String printleaveTime; // 떠난시간 출력
	String pt[];
	int ptInt[];
	String temp[] = new String[5];
	int temp1;
	int temp2;
	int temp3;
	JTextField tf0;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	String leaveTime; // 떠난시간
	String upt[];
	int uptInt[];

	// 생성자
	public leaveWindow(int jariNumber) {
		for (int i = 0; i < obj.length; i++) {// 매개변수로 들어온 자리번호를 저장된 파일에서 검색
			if (jariNumber == Integer.parseInt(obj.jariNumber[i])) {// 자리번호가 같다면
				temp1 = i;// 그 배열의 번호를 temp1에 저장해둠
				break;
			}
		}
		this.deskSelect = obj.deskSelect[temp1];// 위에서 찾은 배열의 번호를 이용하여 변수 설정
		this.idNumber = obj.idNumber[temp1];// 위에서 찾은 배열의 번호를 이용하여 변수 설정
		this.jariNumber = "" + jariNumber;// 자리번호
		this.enterTime = obj.enterTime[temp1];// 위에서 찾은 배열의 번호를 이용하여 변수 설정
		this.printenterTime = ConvertTime(enterTime);// 위에서 찾은 배열의 번호를 이용하여 변수 설정
		this.leaveTime = "" + year + "/" + month + "/" + day + "/" + hour
				+ "/" + min;// 현재 시간을 퇴실시간으로 저장
		this.printleaveTime = ConvertTime(leaveTime);// 저장한 퇴실시간을 출력용 퇴실시간으로
		// 변환
		this.inTime = "" + intime();// 독서실 이용 시간을 계산
		this.charge = "" + charge();//  독서실 이용 요금을 계산
		setTitle("퇴실");// 타이틀
		setSize(250, 300);// 사이즈
		setLocation(350, 250);// 창이 뜬느 위치
		setVisible(true);// 보이도록함
		setResizable(false);// 크기 변경 불가
		pan1();// 메소드 호출
	}

	@Override
	// 버튼이벤트
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == confirm) {// 확인 버튼
			new writeFile(jariNumber, deskSelect, idNumber, enterTime,
					leaveTime, inTime, charge);// 위에서 저장한 변수들을 매개변수로 하여 파일에 쓰는
			// 클래스로 넘겨줌
			new message(jariNumber, deskSelect, idNumber, printenterTime,
					printleaveTime, inTime, charge);// 상황판에 메세지를 출력
			dispose();// 창을 닫음
		} else if (ae.getSource() == cancel) {// 취소 버튼
			dispose();// 창을 닫음
		}
		mainWindow cl = new mainWindow();
		Thread th = new Thread(cl);
		th.start();// 스레드를 새로 실행
	}

	// 요금 설정
	// c[0]~c[12]==요금을 저장해 둔 변수
	public int charge() {

		// 회원이 시간제 사용 회원
		if (deskSelect.equals("시간제 사용자")) {
			// 입실되어 있는 시간이 60분 미만일시
			if (intime() < 60) {
				return obj.c[0];// 저장된 요금 리턴
			} // 60분 이상일시	
			else if (intime() >= 60) {		
				// 계산된 요금이 최대요금보다 작으면
				if ((((intime() - 60) / 30 + 1) * obj.c[1]) + obj.c[0] < obj.c[2]) {
					return (((intime() - 60) / 30 + 1) * obj.c[1]) + obj.c[0];// 계산된 요금 리턴

				} else if ((((intime() - 60) / 30 + 1) * obj.c[1]) + obj.c[0] > obj.c[2]) {
					// 계산된 요금이 최대요금보다 크면
					return obj.c[2];// 최대요금 리턴
				}
			}
		}
		// 아래는 위의 계산방법과 동일함
		else if (deskSelect.equals("기간제 사용자")) {
			if (intime() < 60) {
				return obj.c[3];
			} else if (intime() >= 60) {
				if ((((intime() - 60) / 30 + 1) * obj.c[4]) + obj.c[3] < obj.c[5]) {
					return (((intime() - 60) / 30 + 1) * obj.c[4]) + obj.c[3];
				} else if ((((intime() - 60) / 30 + 1) * obj.c[4]) + obj.c[3] > obj.c[5]) {
					return obj.c[5];
				}
			}
		} 
		return 0;
	}

	// 저장된 시간을 화면출력용 시간으로 바꾸는 메소드
	private String ConvertTime(String time) {
		StringTokenizer parse = new StringTokenizer(time, "/");// 토크나이저로 저장된 시간을
		// 나눈후
		temp[0] = parse.nextToken();// 배열에 각각 저장
		temp[1] = parse.nextToken();
		temp[2] = parse.nextToken();
		temp[3] = parse.nextToken();
		temp[4] = parse.nextToken();
		String printTime = temp[0] + "년 " + temp[1] + "월 " + temp[2] + "일 "
				+ temp[3] + "시 " + temp[4] + "분";// 다시 출력용 시간으로 합침
		return printTime;
	}

	// 독서실 이용 시간을 계산
	public int intime() {
		pt = new String[5];
		ptInt = new int[5];
		upt = new String[5];
		uptInt = new int[5];
		StringTokenizer parse1 = new StringTokenizer(enterTime, "/");// 입실 시간을
		// 토크나이저로 나눔
		StringTokenizer parse2 = new StringTokenizer(leaveTime, "/");// 퇴실 시간을
		// 토크나이저로
		// 나눔
		for (int i = 0; i < 5; i++) {
			pt[i] = parse1.nextToken();// 입실시간 토큰 저장
			ptInt[i] = Integer.parseInt(pt[i]);// 토큰을 정수형태로 변환
			upt[i] = parse2.nextToken();// 퇴실 시간토큰 저장
			uptInt[i] = Integer.parseInt(upt[i]);// 토큰을 정수형태로 변환
		}
		temp2 = (ptInt[2] * 1440) + (ptInt[3] * 60) + (ptInt[4]);// 입실시간을 분 단위로
		// 저장
		temp3 = (uptInt[2] * 1440) + (uptInt[3] * 60) + (uptInt[4]);// 퇴실시간을 분
		// 단위로 저장
		return temp3 - temp2;// 퇴실시간-입실시간=이용시간 리턴
	}

	// 그리드백 레이아웃을 손쉽게 사용하기위해 만듬
	public void layout(Component obj, int x, int y, int width, int height) {
		c.gridx = x; // 시작위치 x
		c.gridy = y; // 시작위치 y
		c.gridwidth = width; // 컨테이너 너비
		c.gridheight = height; // 컨테이너 높이
		add(obj, c);
	}

	// 판넬
	public void pan1() {
		GridBagLayout gridbag = new GridBagLayout();// 그리드백 레이아웃 생성
		setLayout(gridbag);// 레이아웃 설정
		c = new GridBagConstraints();// 그리드백 레이아웃을 제어하는 객체
		c.fill = GridBagConstraints.BOTH; // 전체를 채움
		tf0 = new JTextField(deskSelect);// 요금제 텍스트필드
		tf1 = new JTextField(idNumber);// 회원번호 텍스트필드
		tf2 = new JTextField(jariNumber);// 자리번호 텍스트필드
		tf3 = new JTextField(printenterTime);// 입실시간
		tf4 = new JTextField(printleaveTime);// 퇴실시간
		tf5 = new JTextField(inTime);// 이용시간
		tf6 = new JTextField(charge);// 요금
		confirm = new JButton("확인");// 확인버튼
		cancel = new JButton("취소");// 취소버튼
		confirm.addActionListener(this);
		cancel.addActionListener(this);// 액션리스너 등록
		layout(new Label("요금제"), 0, 0, 1, 2); // 라벨 부착
		layout(tf0, 1, 1, 4, 1);// 요금제 텍스트필드 부착
		layout(new Label("회원번호"), 0, 2, 1, 1);// 라벨부착
		layout(tf1, 1, 2, 4, 1);// 회원번호 텍스트필드 부착
		layout(new Label("자리번호"), 0, 3, 1, 1);// 라벨부착
		layout(tf2, 1, 3, 4, 1);// 자리번호 텍스트필드 부착
		layout(new Label("입실시간"), 0, 4, 1, 1);// 라벨 부착
		layout(tf3, 1, 4, 4, 1);// 입실시간 텍스트필드 부착
		layout(new Label("퇴실시간"), 0, 5, 1, 1);// 라벨부착
		layout(tf4, 1, 5, 4, 1);// 퇴실시간 텍스트필드 부착
		layout(new Label("이용시간(분)"), 0, 6, 1, 1);// 라벨 부착
		layout(tf5, 1, 6, 4, 1);// 이용시간 텍스트필드 부착
		layout(new Label("요금"), 0, 7, 1, 1);// 라벨부착
		layout(tf6, 1, 7, 4, 1);// 요금 텍스트필드 부착
		layout(new Label(""), 1, 8, 1, 1);// 한칸 공백
		layout(new Label("퇴실하시겠습니까?"), 1, 9, 4, 1);// 라벨 부착
		layout(confirm, 1, 10, 2, 1);// 확인버튼 부착
		layout(cancel, 3, 10, 2, 1);// 취소버튼 부착
		tf0.setEditable(false);
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);// 텍스트 필드 편집이 불가

	}
}

===============================================================================================================

/* 이용 내역을 보여주는  Log 창입니다. */

// 멋있어보이기 위해 java.awt.* 와  javax.swing.*를 안 하고 다 썼습니다ㅋㅋ
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class logWindow extends JFrame implements ActionListener, ItemListener {
	static int hourpriceCnt = 0; // 시간제 사용자를 세기 위한 정적 변수입니다.
	static int termpriceCnt = 0; // 기간제 사용자를 세기 위한 정적 변수입니다.
	static int totalclient = 0; // 총 이용자 수입니다.
	static int totalCharge = 0; // 총 이용 요금입니다.

	Checkbox cb0;
	Checkbox cb1;
	Checkbox cb2;
	DefaultTableColumnModel cModel;
	String[] historyCol = { "자리번호", "요금제", "회원번호", "입실시간", "퇴실시간", "이용시간(분)",
	"요금(원)" };
	Label label1;
	Label label10;
	Label label11;
	Label label12;
	Label label13;
	Label label14;
	Label label15;
	Label label16;
	Label label2;
	Label label3;
	Label label4;
	Label label5;
	Label label6;
	Label label7;
	Label label8;
	Label label9;
	DefaultTableModel model;
	DefaultTableModel model2;
	readLog obj = new readLog();
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	JPanel pan4;
	JPanel pan5;
	JScrollPane scrollpane;
	JScrollPane scrollpane2;
	JButton search;
	JTable table;
	JTable table2;
	String[] temp = new String[7];
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	String[] totalCol = { "통계", "시간제 사용자", "기간제 사용자", "이용자 수", "요금합계(원)" };

	// 생성자
	public logWindow() {
		setTitle("독서실 내역");// 제목표시줄
		setSize(1000, 700);// 사이즈
		model = new DefaultTableModel(historyCol, 0);// 독서실 내역 테이블 모델
		table = new JTable(model);// 테이블
		model2 = new DefaultTableModel(totalCol, 0);// 통계 테이블 모델
		table2 = new JTable(model2);// 테이블
		pan1 = new JPanel();// 패널 생성
		pan2 = new JPanel();// 패널 생성
		pan3 = new JPanel();// 패널 생성
		defaultTable();// 메소드 호출
		pan1();// 메소드 호출
		pan3();// 메소드 호출
		setVisible(true);// 보이게 함
		setResizable(false);// 크기 조절 불가
	}

	// 액션이벤트
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == search) {// 검색 버튼
			String temp1 = tf1.getText();// 회원 번호
			String temp2 = tf2.getText();// 년
			String temp3 = tf3.getText();// 월
			String temp4 = tf4.getText();// 일 //텍스트 박스로부터 값을 받아옴
			removeTable();// 테이블을 지움
			// 검색 부분
			// 회원 번호로 검색
			if (!temp1.isEmpty() && temp2.isEmpty() && temp3.isEmpty()
					&& temp4.isEmpty()) {
				idNumberSearch(tf1.getText());
			}
			// 날짜로 검색
			else if (temp1.isEmpty() && !temp2.isEmpty() && !temp3.isEmpty()
					&& !temp4.isEmpty()) {
				dateSearch(tf2.getText(), tf3.getText(), tf4.getText());
			} else {// 칸이 모두 비어있을 경우
				defaultTable();// 기본 내역 출력
			}
		}
	}

	// 회원번호로 검색하는 메소드
	public void idNumberSearch(String idNumber) {
		totalclient = 0;// 총 이용자 수 초기화
		hourpriceCnt = 0;// 시간제 사용자 수 초기화
		termpriceCnt = 0;// 기간제 사용자 수 초기화

		totalCharge = 0;// 통계 값 초기화
		for (int i = 0; i < obj.length; i++) {// 파일에서 검색
			if (obj.idNumber[i].equals(idNumber)) {// 파일에 저장된 회원번호가 현재 칸에 입력한
				// 회원번호와 같을 경우

				// 그 사용자의 내용을 temp 배열에 저장
				temp[0] = obj.jariNumber[i];
				temp[1] = obj.deskSelect[i];
				temp[2] = obj.idNumber[i];
				temp[3] = obj.printenterTime[i];
				temp[4] = obj.printleaveTime[i];
				temp[5] = obj.inTime[i];
				temp[6] = obj.charge[i];
				model.addRow(temp);// 테이블에 추가
				total(obj.deskSelect[i], obj.inTime[i], obj.charge[i]);// 통계 계산
				totalclient++;// 총 사용자 수 +1
			}
		}
		// 통계 테이블
		temp[0] = "";// 공백
		temp[1] = Integer.toString(hourpriceCnt);// 시간제 사용자 카운트
		temp[2] = Integer.toString(termpriceCnt);// 기간제 사용자 카운트

		temp[3] = Integer.toString(totalclient);// 총 사용자 수 카운트
		temp[4] = Integer.toString(totalCharge);// 총 요금
		model2.addRow(temp);// 테이블에 추가
	}

	// 날짜로 검색하는 메소드
	public void dateSearch(String year, String month, String day) {
		totalclient = 0;
		hourpriceCnt = 0;
		termpriceCnt = 0;

		totalCharge = 0;// 통계 값 초기화
		for (int i = 0; i < obj.length; i++) {// 파일에서 검색
			String s = obj.printleaveTime[i];// 날짜를 기준으로 검색
			if (s.matches(year + "년.*"))// 년 텍스트필드 + "년"과 같은 문자열이 있는지 검색함
				if (s.matches(".*" + month + "월.*"))// 월 텍스트필드 + "월"과 같은 문자열이
					// 있는지 검색함
					if (s.matches(".*" + day + "일.*")) {// 일 텍스트필드 + "일"과 같은
						// 문자열이 있는지 검색함
						temp[0] = obj.jariNumber[i];
						temp[1] = obj.deskSelect[i];
						temp[2] = obj.idNumber[i];
						temp[3] = obj.printenterTime[i];
						temp[4] = obj.printleaveTime[i];
						temp[5] = obj.inTime[i];
						temp[6] = obj.charge[i];// 내용을 temp배열에 추가
						model.addRow(temp);// 테이블에 추가
						total(obj.deskSelect[i], obj.inTime[i], obj.charge[i]);
						// 통계 계산

						totalclient++;// 총 사용자 수 계산
					}

		}

		// 통계 테이블
		temp[0] = "";
		temp[1] = Integer.toString(hourpriceCnt);// 시간제 사용자 카운트
		temp[2] = Integer.toString(termpriceCnt);// 기간제 사용자

		temp[3] = Integer.toString(totalclient);// 총 사용자 수 카운트
		temp[4] = Integer.toString(totalCharge);// 총 요금
		model2.addRow(temp);// 테이블에 추가
	}

	// 기본 테이블
	public void defaultTable() {
		totalclient = 0;
		hourpriceCnt = 0;
		termpriceCnt = 0;


		totalCharge = 0;// 통계 값 초기화
		for (int i = 0; i < obj.length; i++) {// 파일의 내용을 temp에 저장
			temp[0] = obj.jariNumber[i];
			temp[1] = obj.deskSelect[i];
			temp[2] = obj.idNumber[i];
			temp[3] = obj.printenterTime[i];
			temp[4] = obj.printleaveTime[i];
			temp[5] = obj.inTime[i];
			temp[6] = obj.charge[i];
			model.addRow(temp);// 테이블에 추가
			total(obj.deskSelect[i], obj.inTime[i], obj.charge[i]);// 통계 계산
			totalclient++;// 총 사용자 수 계산
		}

		// 통계 테이블
		temp[0] = "";
		temp[1] = Integer.toString(hourpriceCnt);
		temp[2] = Integer.toString(termpriceCnt);

		temp[3] = Integer.toString(totalclient);
		temp[4] = Integer.toString(totalCharge);
		model2.addRow(temp);// 테이블에 추가
	}

	@Override
	// 체크박스 이벤트
	public void itemStateChanged(ItemEvent ie) {
		if (ie.getSource() == cb1) {// 회원 체크박스 체크시
			tf2.setEnabled(false);//
			tf3.setEnabled(false);//
			tf4.setEnabled(false);// 날짜부분 비활성화
			tf2.setText("");//
			tf3.setText("");//
			tf4.setText("");// 날짜부분 텍스트필드 초기화
			tf1.setEnabled(true);// 회원 텍스트필드 활성화

		} else if (ie.getSource() == cb2) {// 날짜 체크박스 체크시
			tf1.setEnabled(false);// 회원 텍스트필드 비활성화
			tf1.setText("");// 텍스트필드 초기화
			tf2.setEnabled(true);//
			tf3.setEnabled(true);//
			tf4.setEnabled(true);// 날짜부분 활성화

		}
	}

	// 테이블 부분 판넬
	public void pan1() {
		Font f1 = new Font("맑은 고딕", Font.BOLD, 24);// 폰트 생성
		BoxLayout blayout = new BoxLayout(pan1, BoxLayout.Y_AXIS);// 박스레이아웃 생성
		pan1.setLayout(blayout);// 레이아웃 설정
		label1 = new Label("독서실 내역");// 라벨 생성
		label1.setFont(f1);// 폰트설정
		pan1.add(label1);// 라벨 부착
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 테이블 자동 리사이즈를 off

		// 각각의 colomn의 길이를 정해줌		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollpane = new JScrollPane(table);// 스크롤바가 생기는 판넬에 테이블 부착
		pan1.add(scrollpane);// 스크롤판넬을 판넬1에 부착
		label2 = new Label("통계");// 라벨 생성
		label2.setFont(f1);// 폰트설정
		pan1.add(label2);// 라벨 부착
		scrollpane2 = new JScrollPane(table2);// 스크롤바가 생기는 판넬에 테이블 부착
		pan1.add(scrollpane2);// 스크롤판넬을 판넬1에 부착
		table2.setPreferredScrollableViewportSize(new Dimension(300, 30));// 크기 설정
		add(pan1, "North");// 판넬1 부착
		table.setEnabled(false);//
		table2.setEnabled(false);// 테이블을 비활성화
	}

	// 검색 부분 판넬
	public void pan3() {
		CheckboxGroup cbg = new CheckboxGroup();// 체크박스 그룹화
		cb1 = new Checkbox("회원번호", cbg, true);// 체크박스 생성
		cb2 = new Checkbox("날짜", cbg, false);// 체크박스 생성
		label3 = new Label("               ");// 공백
		label4 = new Label("년");//
		label5 = new Label("월");//
		label6 = new Label("일");// 라벨 생성
		tf1 = new JTextField(10);//
		tf2 = new JTextField(10);//
		tf3 = new JTextField(10);//
		tf4 = new JTextField(10);// 텍스트필드 생성
		pan3.add(label3);// 라벨 부착
		pan3.add(cb1);// 체크박스 부착
		pan3.add(tf1);// 텍스트필드 부착
		label7 = new Label("               ");// 공백
		pan3.add(label7);// 라벨 부착
		pan3.add(cb2);// 체크박스 부착
		pan3.add(tf2);// 텍스트필드 부착
		pan3.add(label4);// 라벨 부착
		pan3.add(tf3);// 텍스트필드 부착
		pan3.add(label5);// 라벨 부착
		pan3.add(tf4);// 텍스트필드 부착
		pan3.add(label6);// 라벨 부착
		cb1.addItemListener(this);//
		cb2.addItemListener(this);// 아이템리스너 등록
		search = new JButton("검색");// 검색버튼
		search.addActionListener(this);// 액션리스너 등록
		pan3.add(search);// //검색버튼 부착
		tf2.setEnabled(false);//
		tf3.setEnabled(false);//
		tf4.setEnabled(false);// 날짜 검색부분은 비활성화 되도록 함
		add(pan3, "South");// 판넬 부착

	}

	// 테이블을 지우는 메소드
	public void removeTable() {
		int temp = table.getRowCount();// 테이블을 줄 수를 받아와서
		for (int i = 0; i < temp; i++) {
			model.removeRow(0);// 제거
		}
		temp = table2.getRowCount();// 테이블의 줄 수를 받아와서
		for (int i = 0; i < temp; i++) {
			model2.removeRow(0);// 제거
		}
	}

	// 통계를 내는 메소드
	public void total(String deskSelect, String inTime, String charge) {

		if (deskSelect.equals("시간제 사용자"))// 사용자가 시간제라면
			hourpriceCnt++;// 카운트 증가
		else if (deskSelect.equals("기간제 사용자"))// 마찬가지
			termpriceCnt++;

		totalCharge += Integer.parseInt(charge);// 요금을 정수형태로 변환하여 변수에 더해서 저장
	}
}


===============================================================================================================


/* 환경 설정을 위한 config 클래스입니다. */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class config extends JFrame implements ActionListener {
	GridBagConstraints c;
	JButton cancel;
	CheckboxGroup cbg;
	JButton confirm;
	Label label1;
	Label label2;
	Label label3;
	Checkbox hourprice; // 시간제 사용자
	Checkbox termprice; // 기간제 사용자
	readFile obj = new readFile();
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;

	// TextField가 여러개 쓰일 것에 대비해 12개 생성했습니다.
	JTextField tf0;
	JTextField tf1;
	JTextField tf10;
	JTextField tf11;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	JTextField tf7;
	JTextField tf8;
	JTextField tf9;

	// 생성자
	public config() {
		setTitle("요금 설정");// 제목표시줄
		setSize(350, 180);// 사이즈
		setLocation(350, 250);// 창이 뜨는 위치
		pan1();// 메소드 호출
		setVisible(true);// 보이로독 함
		setResizable(false);// 크기변경 불가

	}

	@Override
	// 액션리스너
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == confirm) {// 확인 버튼
			// temp에 텍스트필드에서 값을 얻어와서 저장함
			String temp = tf0.getText() + "," + tf1.getText() + ","
					+ tf2.getText() + "," + tf3.getText() + "," + tf4.getText()
					+ "," + tf5.getText() + "," + tf6.getText() + ","
					+ tf7.getText() + "," + tf8.getText() + "," + tf9.getText()
					+ "," + tf10.getText() + "," + tf11.getText();
			try {
				// 파일을 열어서 값을 저장함
				FileWriter w = new FileWriter("config.cfg");
				w.write(temp);
				w.close();
			} catch (IOException e) {
			}
			dispose();// 창 닫음
		} else if (ae.getSource() == cancel) {// 취소버튼
			dispose();// 창닫음
		}
	}

	// 그리드백 레이아웃을 손쉽게 사용하기위해 만듬
	public void layout(Component obj, int x, int y, int width, int height) {
		c.gridx = x; // 시작위치 x
		c.gridy = y; // 시작위치 y
		c.gridwidth = width; // 컨테이너 너비
		c.gridheight = height; // 컨테이너 높이
		add(obj, c);
	}

	// 판넬1
	public void pan1() {
		GridBagLayout gridbag = new GridBagLayout();// 그리드백 레이아웃 생성
		setLayout(gridbag);// 레이아웃 설정
		c = new GridBagConstraints();// 그리드백 레이아웃을 제어하는 객체
		c.fill = GridBagConstraints.BOTH; // 전체를 채움
		tf0 = new JTextField("" + obj.c[0]);
		tf1 = new JTextField("" + obj.c[1]);
		tf2 = new JTextField("" + obj.c[2]);
		tf3 = new JTextField("" + obj.c[3]);
		tf4 = new JTextField("" + obj.c[4]);
		tf5 = new JTextField("" + obj.c[5]);
		tf6 = new JTextField("" + obj.c[6]);
		tf7 = new JTextField("" + obj.c[7]);
		tf8 = new JTextField("" + obj.c[8]);
		tf9 = new JTextField("" + obj.c[9]);
		tf10 = new JTextField("" + obj.c[10]);
		tf11 = new JTextField("" + obj.c[11]);// 텍스트필드에 파일에서 읽어온 값을 띄움
		confirm = new JButton("확인");// 버튼
		cancel = new JButton("취소");// 버튼
		confirm.addActionListener(this);//
		cancel.addActionListener(this);// 액션이벤트 등록
		layout(new Label("시간제 사용자"), 1, 0, 2, 1);
		layout(new Label("기간제 사용자"), 3, 0, 2, 1);
		layout(new Label("1시간 기본요금"), 0, 1, 1, 1);// 라벨 부착
		layout(tf0, 1, 1, 2, 1);
		layout(tf3, 3, 1, 2, 1); // 텍스트 필드 부착

		layout(new Label("이후 30분당 요금"), 0, 2, 1, 1);// 라벨 부착
		layout(tf1, 1, 2, 2, 1);
		layout(tf4, 3, 2, 2, 1); // 텍스트 필드 부착

		layout(new Label("최대요금"), 0, 3, 1, 1);// 라벨 부착
		layout(tf2, 1, 3, 2, 1);
		layout(tf5, 3, 3, 2, 1); // 텍스트 필드 부착

		layout(confirm, 1, 6, 2, 1);// 확인 버튼 부착
		layout(cancel, 3, 6, 2, 1);// 취소 버튼 부착

	}
}


===============================================================================================================


/* 파일을 읽어오는 readFile 클래스입니다. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class readFile {
	public int c[];// 기본요금,단위요금,최대요금
	public String idNumber[]; // 회원 번호
	public String deskSelect[]; // 요금제 선택
	public String charge[]; // 요금
	public String inTime[];
	public String jariNumber[]; // 자리 번호
	public int length;
	public String enterTime[]; // 입실 시간
	public String printenterTime[];
	public String printleaveTime[];
	public String temp[] = new String[5];
	public String temp1 = "";
	public String leaveTime[]; // 퇴실 시간
	private BufferedReader r;
	private BufferedReader r2;

	// 생성자
	public readFile() {
		readdata();
		readconfig();
	}

	// 설정파일을 읽는 부분
	public void readconfig() {
		try {
			FileReader file = new FileReader(new File("config.cfg"));// 파일리더를 열음
			r = new BufferedReader(file);
			temp1 = r.readLine();// 라인을 읽음
			c = new int[12];// 배열 생성
			StringTokenizer parse = new StringTokenizer(temp1, ",");// 토크나이저로
			// 문자열을 나눔
			String temp[] = new String[15];// 토큰을 배열에 저장
			for (int i = 0; i < 12; i++) {// 배열에 저장한 토큰을 정수형으로 변환해서 저장
				temp[i] = parse.nextToken();
				c[i] = Integer.parseInt(temp[i]);
			}
		} catch (IOException e) {// 만약 위의 부분을 실행중 io익셉션이 발생할 경우에는
			// temp에 아래 기본 가격을 저장하고
			String temp = "1000,500,10000,2000,1000,15000,3000,1000,20000,5000,2500,30000";
			try {// 파일을 생성하여 써 넣음
				FileWriter w = new FileWriter("config.cfg");
				w.write(temp);
				w.close();
			} catch (IOException e1) {
			}
		}
	}

	// 현재 독서실의 회원 정보를 읽는 부분
	public void readdata() {
		try {
			FileReader file = new FileReader(new File("data.csv"));// 파일을 열음
			r2 = new BufferedReader(file);
			String csvStr = "";
			String tmpStr = "";
			while (tmpStr != null) {
				tmpStr = r2.readLine();// 변수에 라인단위로 읽어서 저장
				if (tmpStr != null) {
					csvStr = csvStr + tmpStr + ",";// 라인단위로 읽어들인 것을 다른 변수에 계속
					// 추가함
				}
			}
			// 파일을 끝까지 읽은 후
			StringTokenizer parse = new StringTokenizer(csvStr, ",");
			// 토크나이저로 파일로부터 전부 읽어들인 변수를 나눔
			length = (parse.countTokens() / 7);// length의 길이는 토큰숫자/7 이렇게하면 배열을
			// 미리 생성할 필요가 없이 딱 맞는 크기로 생성
			jariNumber = new String[length];
			deskSelect = new String[length];
			idNumber = new String[length];
			enterTime = new String[length];
			leaveTime = new String[length];
			inTime = new String[length];
			charge = new String[length];// 배열 생성
			for (int i = 0; i < length; i++) {
				jariNumber[i] = parse.nextToken();
				deskSelect[i] = parse.nextToken();
				idNumber[i] = parse.nextToken();
				enterTime[i] = parse.nextToken();
				leaveTime[i] = parse.nextToken();
				inTime[i] = parse.nextToken();
				charge[i] = parse.nextToken();// 생성된 배열에 토큰을 차례대로 저장
			}
		} catch (IOException e) {
		}
	}

}



===============================================================================================================

/* 파일에 저장하는 writeFile 클래스입니다. */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile {

	public String idNumber; // 회원번호
	public String deskSelect; // 요금제 선택
	public String charge; // 요금
	public String inTime;
	public String jariNumber; // 자리 번호
	readFile obj = new readFile();
	public String enterTime; // 입실 시간
	public String leaveTime; // 퇴실 시간

	// 생성자
	public writeFile(String jariNumber, String deskSelect, String idNumber,
			String enterTime, String leaveTime, String inTime, String charge) {
		this.deskSelect = deskSelect;
		this.jariNumber = jariNumber;
		this.idNumber = idNumber;
		this.enterTime = enterTime;
		this.leaveTime = leaveTime;
		this.inTime = inTime;
		this.charge = charge;
		write();// 메소드 호출
	}

	public void write() {
		try {
			if (charge == "-") {// 요금 부분의 매개변수가 "-" 일시에는 입실화면에서 들어온 것임
				// 입실 부분
				BufferedWriter w = new BufferedWriter(new FileWriter(
						"data.csv", true));// 파일을 열음
				w.write(jariNumber);
				w.write(",");
				w.write(deskSelect);
				w.write(",");
				w.write(idNumber);
				w.write(",");
				w.write(enterTime);
				w.write(",");
				w.write(leaveTime);
				w.write(",");
				w.write(inTime);
				w.write(",");
				w.write(charge);
				w.newLine();// 파일에 차례대로 써 넣음
				w.close();// 파일을 닫음
			} else {// 요금부분의 매개변수가 "-"가 아닐시에는 퇴실화면에서 들어온 것임
				// 퇴실 부분
				FileWriter w = new FileWriter("data.csv");// 현재 독서실의 회원정보를 저장하는
				// 파일
				BufferedWriter w1 = new BufferedWriter(new FileWriter(
						"log.csv", true));// 독서실 내역 파일
				int temp1, temp2;
				temp1 = Integer.parseInt(jariNumber);// temp 변수에 매개변수로 들어온 자리번호를
				// 정수형으로 변환하여 저장
				int temp = -1;
				// log 파일 부분(내역 저장)
				for (int i = 0; i < obj.length; i++) {// 파일에서 읽어들인 것을 검색
					temp2 = Integer.parseInt(obj.jariNumber[i]);// 파일의 자리번호를
					// 정수형으로 변환
					if (temp1 == temp2) {// 매개변수로 들어온것과 파일의 자리번호가 같다면
						temp = i;// temp에 그 배열번호를 저장해둠
						w1.write(jariNumber);
						w1.write(",");
						w1.write(deskSelect);
						w1.write(",");
						w1.write(idNumber);
						w1.write(",");
						w1.write(enterTime);
						w1.write(",");
						w1.write(leaveTime);
						w1.write(",");
						w1.write(inTime);
						w1.write(",");
						w1.write(charge);
						w1.newLine();//로그파일에 차례대로 써 넣음
						break;
					}
				}
				// data 파일 부분(독서실의 정보 저장)
				for (int i = 0; i < obj.length; i++) {// 파일에서 읽어들인 것을 검색
					if (i == temp)// 배열에서 하나씩 검색하면서 파일에 써 넣는데
						continue;// 만약 위에서 저장해둔 temp와 i가 같다면 그 회원은 퇴실한 회원이므로 파일에
					// 쓰지 않고 continue 함.
					w.write(obj.jariNumber[i]);
					w.write(",");
					w.write(obj.deskSelect[i]);
					w.write(",");
					w.write(obj.idNumber[i]);
					w.write(",");
					w.write(obj.enterTime[i]);
					w.write(",");
					w.write(obj.leaveTime[i]);
					w.write(",");
					w.write(obj.inTime[i]);
					w.write(",");
					w.write(obj.charge[i]);
					w.write("\r\n");
				}
				w.close();//
				w1.close();// 파일을 닫음
			}

		} catch (IOException e) {
		}
	}
}

===============================================================================================================

/* 현재까지의 로그를 읽는 readLog 클래스입니다. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class readLog {
	public String idNumber[]; // 회원 번호
	public String deskSelect[]; // 요금제 선택
	public String charge[];
	public String inTime[];
	public String jariNumber[]; // 자리 번호
	public int length;
	public String enterTime[]; // 입실 시간
	StringTokenizer parse;
	public String printenterTime[]; 
	public String printleaveTime[];
	public String temp[] = new String[5];
	public String leaveTime[]; // 퇴실 시간
	private BufferedReader r;

	public readLog() {
		try {
			FileReader file = new FileReader(new File("log.csv"));// 로그 파일을 열음
			r = new BufferedReader(file);
			String csvStr = "";
			String tmpStr = "";
			while (tmpStr != null) {
				tmpStr = r.readLine();// 변수에 라인단위로 읽어서 저장
				if (tmpStr != null) {
					csvStr = csvStr + tmpStr + ",";// 라인단위로 읽어들인 것을 다른 변수에 계속 추가
				}
			}
			parse = new StringTokenizer(csvStr, ",");
			;// 토크나이저로 파일로부터 전부 읽어들인 변수를 나눔
			length = (parse.countTokens() / 7);// length의 길이는 토큰숫자/7 이렇게하면 배열을
			// 미리 생성할 필요가 없이 딱 맞는 크기로 생성
			jariNumber = new String[length];
			deskSelect = new String[length];
			idNumber = new String[length];
			enterTime = new String[length];
			leaveTime = new String[length];
			printenterTime = new String[length];
			printleaveTime = new String[length];
			inTime = new String[length];
			charge = new String[length];// 배열 생성
			for (int i = 0; i < length; i++) {
				// 생성된 배열에 토큰을 차례대로 저장
				jariNumber[i] = parse.nextToken();
				deskSelect[i] = parse.nextToken();
				idNumber[i] = parse.nextToken();
				enterTime[i] = parse.nextToken();
				leaveTime[i] = parse.nextToken();
				inTime[i] = parse.nextToken();
				charge[i] = parse.nextToken();
			}
			for (int i = 0; i < length; i++) {
				// 출력용 시간을 저장
				printenterTime[i] = ConvertTime(enterTime[i]);
				printleaveTime[i] = ConvertTime(leaveTime[i]);
			}
		} catch (IOException e) {
		}
	}

	// 저장된 시간을 화면출력용 시간으로 바꾸는 메소드
	private String ConvertTime(String time) {
		StringTokenizer parse = new StringTokenizer(time, "/");// 토크나이저로 저장된 시간을
		// 나눈후
		temp[0] = parse.nextToken();// 배열에 각각 저장
		temp[1] = parse.nextToken();
		temp[2] = parse.nextToken();
		temp[3] = parse.nextToken();
		temp[4] = parse.nextToken();
		String printTime = temp[0] + "년 " + temp[1] + "월 " + temp[2] + "일 "
				+ temp[3] + "시 " + temp[4] + "분";// 다시 출력용 시간으로 합침
		return printTime;
	}
}


===============================================================================================================

/* 상황을 출력하는 message클래스입니다. */

public class message {
	static int i = 0;
	public static String message[] = new String[12];

	// 매개변수가 4개인 경우
	public message(String jariNumber, String deskSelect, String idNumber,
			String enterTime) {
		// 배열크기 이상의 메세지가 들어오는 경우 메세지가 한칸씩 밀리도록 함
		if (i > 10) {
			for (int j = 0; j < 10; j++) {
				message[j] = message[j + 1];
			}
			i = 10;
		}
		// 메세지 저장
		message[i] = jariNumber + "번 자리로 " + idNumber + "번 회원이 " + enterTime
				+ "에 입실하셨습니다.\n";
		i++;
	}

	// 매개변수가 6개인 경우
	public message(String jariNumber, String deskSelect, String idNumber,
			String enterTime, String leaveTime, String inTime, String charge) {
		// 배열크기 이상의 메세지가 들어오는 경우 메세지가 한칸씩 밀리도록 함
		if (i > 10) {
			for (int j = 0; j < 10; j++) {
				message[j] = message[j + 1];
			}
			i = 10;
		}
		// 메세지 저장
		message[i] = jariNumber + "번 자리에서 " + idNumber + "번 회원이 " + leaveTime
				+ "에 퇴실하셨습니다.\n";
		i++;
	}
}

===============================================================================================================

/* 시스템으로부터 시간을 받아오는 time클래스입니다. */

import java.util.Calendar;

//시스템으로 부터 시간을 받아와 저장하는 인터페이스
public interface time {
	Calendar present = Calendar.getInstance();
	int day = present.get(Calendar.DATE);
	int hour = present.get(Calendar.HOUR_OF_DAY);
	int min = present.get(Calendar.MINUTE);
	int month = present.get(Calendar.MONTH) + 1;
	int sec = present.get(Calendar.SECOND);
	int year = present.get(Calendar.YEAR);
}

```

# Result(실행화면) #

![http://comp166-koreauniv.googlecode.com/files/result.jpg](http://comp166-koreauniv.googlecode.com/files/result.jpg)

1) **메인 창 실행 화면입니다.**

- 프로그램 첫 실행하면 보이는 화면입니다.

- 여기서 각 자리를 클릭하면 입실 창이 뜹니다.

**1 - 1. 실습실에서 실행 화면**

![http://comp166-koreauniv.googlecode.com/files/메인화면.jpg](http://comp166-koreauniv.googlecode.com/files/메인화면.jpg)

**1 - 2. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/aaa.JPG

2) **입실 창 실행 화면입니다.**

- 메인 창에서 자리를 클릭하면 입실 창이 뜹니다.

- 여기서는 요금제 선택, 회원 번호 입력을 할 수 있습니다.


**2 - 1. 실습실에서 실행 화면**

![http://comp166-koreauniv.googlecode.com/files/enter.jpg](http://comp166-koreauniv.googlecode.com/files/enter.jpg)

**2 - 2. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/bbb.JPG

3) **입실 이후 메인 창입니다.**

- 입실자가 자리에 앉았으므로 자리에는 회원 번호가 빨간색으로 표시됩니다.

- 밑에 독서실 이용 내역 칸에는 회원이 언제 몇 번 자리에 입실했는지 표시됩니다.

**3 - 1. 실습실에서 실행 화면**

![http://comp166-koreauniv.googlecode.com/files/afe.jpg](http://comp166-koreauniv.googlecode.com/files/afe.jpg)

**3 - 2. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/ccc.JPG

4) **독서실 이용내역입니다.**

- 이용내역 창에서는 과거 기록까지 전부 볼 수 있습니다.

- 회원 정보, 입실 시간, 퇴실 시간, 이용 요금 등 볼 수 있습니다.

- 통계 기능도 있으며, 회원 번호와 날짜로 검색 할 수 있습니다.

**4 - 1. 실습실에서 실행 화면**

![http://comp166-koreauniv.googlecode.com/files/log.jpg](http://comp166-koreauniv.googlecode.com/files/log.jpg)

**4 - 2. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/ddd.JPG

5) **요금 설정 창입니다.**

- 요금 설정 창에는 시간제 이용자와 기간제 이용자의 기본 요금이 설정되어있습니다.

- 각 독서실 주인의 입맛에 맞게 가격을 변경할 수 있습니다.


**5 - 1. 요금 설정 창 기본값**

- 여기서는 기간제가 시간제보다 기본 요금이 비쌉니다. 이런 독서실은 이용하지
않는 것이 좋습니다.

http://comp166-koreauniv.googlecode.com/files/c1.JPG


**5 - 2. 요금 설정 창 변경값**

- 따라서 시간제는 하루 최대 6천원을 받는다고 가정하여 1시간 800원 30분씩 400원
하루 최대 요금 6천원으로 하였고,

- 기간제는 한달(4주) 최대 8만원으로 가정하여 1시간 200원, 30분 100원으로 설정하고 하루 최대 요금 2860원으로 했습니다.

- 여기서 기간제 회원은 미리 선불로 결제하였기 때문에 통계상 1시간, 30분 요금을 설정한 것이지 그날 그날 몇백원씩 받는 것이 아닙니다.

- 이것은 독서실 주인에게 달려있습니다.

http://comp166-koreauniv.googlecode.com/files/c2.JPG

**5 - 3. 요금 설정 확인**

- 요금 설정 되었는지 확인하기 위해 기간제와 시간제 회원 한명씩 더 추가했다가 퇴실 시켰습니다.

- 이용내역 창을 보면 요금이 설정 되었다는 것을 알 수 있습니다.


http://comp166-koreauniv.googlecode.com/files/c3.JPG



6) **퇴실 창입니다.**

- 퇴실 창에는 회원 정보, 입실 시간, 퇴실 시간, 이용 요금 등을 볼 수 있습니다.


**6 - 1. 실습실에서 실행 화면**

![http://comp166-koreauniv.googlecode.com/files/leave.jpg](http://comp166-koreauniv.googlecode.com/files/leave.jpg)

**6 - 2. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/eee.JPG

7) **퇴실이후 메인 창입니다.**

- 독서실 내역 칸에 퇴실 내역이 추가되었습니다.

**7 - 1. 실습실에서 실행 화면**

![http://comp166-koreauniv.googlecode.com/files/amain.jpg](http://comp166-koreauniv.googlecode.com/files/amain.jpg)

**7 - 2. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/fff.JPG

8) **퇴실이후 이용내역 창입니다.**

- 내역에 퇴실 내역이 추가되었습니다.

**8 - 1. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/ggg.JPG


9) **검색 기능입니다.**

- 이용 내역 창에서 회원번호나 날짜로 검색할 수 있습니다.

**9 - 1. 집에서 실행 화면**

http://comp166-koreauniv.googlecode.com/files/hhh.JPG



# Report(통계/느낀점/참고문헌) #

1) **통계**

| 클래스명 | 라인 수 | 객체 및 변수 | 메소드 |
|:-----|:-----|:--------|:----|
| mainYoungHoon | 8    | 0       | 1   |
| mainWindow | 174  | 13      | 8   |
| enterWindow | 167  | 21      | 6   |
| leaveWindow | 222  | 35      | 7   |
| logWindow | 332  | 44      | 10  |
| config | 124  | 25      | 4   |
| readFile | 98   | 15      | 3   |
| writeFile | 112  | 8       | 2   |
| readLog | 81   | 13      | 2   |
| message | 38   | 2       | 2   |
| time | 14   | 7       | 0   |
| 총    | 1370 | 183     | 45  |
| 평균(반올림) | 125  | 17      | 4   |

2) **프로젝트 느낀점**


> 이번 텀과제에서 독서실 관리 프로그램을 구현했다. 총 소요 기간이 70일인 만큼 많은 노력과 시간이 필요했다. GUI 구현, 인터페이스, 상속관계 등 처음엔 어려웠던 개념들을 많은 책들을 통해 개념을 익히며 시도했다. 다행히 강의를 들으며 부족한 개념을 익힐 수 있었다.


> GUI 구현에서 어려웠던 점들은 여러 개의 창들을 만들고 이들 사이의 인터페이스를 구현하는 것, 그리고 메인 창 위에 시계를 구현하는 것이었다. 또한, 레이아웃 설정, 버튼 설정 등 어려웠던 것들이 많았지만 천천히 많은 시도를 하고 클릭해보고 수정하면서 프로젝트를 진행했다.

> 파일 입출력은 학교 강의 진도에 포함 되어있지 않아, 블로그 및 책을 통해 공부하여 구현 할 수 있었다. CSV파일로 저장 및 읽어, 토크나이저로 분할하여 그것을 다시 정수형으로 만들어서 파일과 변수와의 입출력을 통해 프로그램을 작성했다.

> 이 프로그램의 장점은 클릭과 입력을 통해, 독서실 이용자를 자리에 배치하고 요금을 계산할 수 있다는 점이다. 또한, 통계 기능과 더불어 검색 기능으로 이용자의 이용 내역을 검색할 수 있다는 것이 장점이다. 아마 이 프로그램 코드를 적절히 수정하면 다른 사람이 나의 Reading Room Manager를 DVD방 요금 계산이나 PC방 요금 계산 프로그램으로 바꿀 수 있을 것이다.

> 응용프로그램은 쉽게 만들어 지는 것이라는 것을 느꼈다. 여러 객체들과 창을 만들고 그것들을 연결하는데 많은 노력이 필요했다. 앞으로 PHP와 XML 및 JAVA를 더욱 공부 하여 나중에는 최종적으로 내가 원하는 애플리케이션을 만들 수 있는 실력을 갖추도록 할 것이다.



3) **참고문헌**

> - 『Head First Java』, 케이시 시에라, 버트 베이츠 저, 서환수 역, 한빛미디어

> - 『뇌를 자극하는 Java 프로그래밍』, 김윤명 저, 한빛미디어

> - 『자바의 정석(2ND EDITION)』, 남궁성 저, 도우출판

> -  http://blog.naver.com/gdrtlee?Redirect=Log&logNo=100156264113, File Reader와 File Writer에 대한 이해를 위해 본 블로그.

> -  http://blog.naver.com/skykingkjs?Redirect=Log&logNo=150144409872, 스트링 토크나이저에 대한 이해를 위해 본 블로그.

# Download(소스코드제출) #

<컴퓨터교육과 2012190723 유영훈 님의 Reading Room Manager 소스코드>

http://comp166-koreauniv.googlecode.com/files/ReadingRoomManager_2012190723.zip