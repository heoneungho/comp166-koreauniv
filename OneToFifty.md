# Introduction #
![http://comp166-koreauniv.googlecode.com/files/150.jpg](http://comp166-koreauniv.googlecode.com/files/150.jpg)

위의 이미지는 한창 유행하던 1to50의 모바일버젼입니다.

> 원래 구상했던 갤러그 혹은 비행기 슈팅게임은 아직 불가능한 실력!
그러므로 다시 생각해본것이 간단하며 재미있고 중독성까지 겸비한 1to50게임입니다.

# Screen Shots #

http://comp166-koreauniv.googlecode.com/files/1.JPG
http://comp166-koreauniv.googlecode.com/files/2.JPG
http://comp166-koreauniv.googlecode.com/files/3.JPG
# Details #

게임은 간단합니다.
  * 5x5 사각형판이 있습니다.
  * 사각형 안에는 1부터 순서대로 난수출력이 되어있습니다.
  * 1부터 차례대로 눌러가며 누른숫자는 다음 난수출력이 되거나 사라집니다.
  * 게임이 끝나면 시간이 기록되며 최고기록이 나오면 따로 저장됩니다.


OneToFifty 클래스

```

public class OneToFifty {
	
	public static void main(String[] arg) {
		MainC m = new MainC(); //메인클래스를불러와실행
	}
}

```

메인프레임 클래스

```
class MainC extends JFrame implements MouseListener, Runnable { // 메인클라스
	private JLabel title = new JLabel();	//타이틀 표시
	private JLabel time = new JLabel(); //진행시간 표시
	private JLabel top = new JLabel(); //가장 빠른시간
	private JButton start = new JButton("START"); //시작 버튼
	private JButton reset = new JButton("RESET"); //리셋 버튼
	SimpleDateFormat time_format; //시간 값 변환 포맷
	String showtime; //진행시간의 문자 열
	String bestshowtime; //빠른시간의 문자 열
	long starttime, currenttime, actualtime;	//시작 시간, 컴퓨터 시간, 진행 시간
	long temptime, besttime = 99999; //가장 빠른 시간을 기록하기위함(처음 시작할 때 시간기록을 위해 숫자를 크게지정)
	boolean time_run = false;
	Image background_img;
	Thread th; //쓰레드
	ImagePanel scr; //패널 클래스 접근 키
	
	MainC() { //프레임 정의
		opt();
		start();
		setTitle("1부터 50까지!");
		setSize(600, 600);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xps = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int yps = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(xps, yps);
		setResizable(false);
		setVisible(true);
	}

	public void opt() { //라벨,버튼 및 패널설정
		Container con = this.getContentPane();
		con.setLayout(null);
		title.setBounds(230, 10, 300, 30);
		title.setFont(new Font("Default", Font.BOLD, 20));
		con.add(title);
		time.setBounds(380, 50, 150, 30);
		time.setFont(new Font("Default", Font.BOLD, 20));
		con.add(time); 
		top.setBounds(100, 50, 150, 30);
		top.setFont(new Font("Default", Font.BOLD, 20));
		con.add(top); //텍스트 라벨
		start.setBounds(100, 520, 100, 30);
		start.setFont(new Font("Default", Font.BOLD, 20));
		con.add(start);
		reset.setBounds(400, 520, 100, 30);
		reset.setFont(new Font("Default", Font.BOLD, 20));
		con.add(reset); //버튼
		scr = new ImagePanel();
		scr.setBounds(100, 100, 410, 410);
		con.add(scr); //패널

	}

	public void start() { //실행 기본내용
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		start.addMouseListener(this);
		reset.addMouseListener(this);
		th = new Thread(this);
		th.start();	//쓰레드 시작
		time_format = new SimpleDateFormat("mm:ss.SSS");	//시간포맷설정
		time.setText("00:00.000");
		top.setText("00:00.000");
		title.setText("1부터 50까지!"); // 라벨 내용 설정
		scr.gameStart(false); // 대기상태로
	}

	public void run() {
		while (true) {
			try {
				repaint();
				TimeChecker();
				Thread.sleep(15); // 무한 쓰레드
			} catch (Exception e) {
			}
		}
	}
	
	public void TimeChecker() {
		if (time_run) {
			currenttime = System.currentTimeMillis();
			actualtime = currenttime - starttime; 	 // 현재 시간에서 시작 시간을 빼서 진행 시간 계산
			scr.counter((int) actualtime / 1000); //카운트용 시간 전송
			if (!scr.gamestart && scr.checker <= 50) { //게임 시작되면 게임 시간 갱신
				showtime = time_format.format(actualtime - 3000); //시작시간이 거의 0이 되도록만듦
				time.setText(showtime);
			}	
		}
		if ( scr.checker > 50){
			scr.Cleart(time.getText()); // 숫자 50까지 끝나면 클리어 띄울 준비
			if(actualtime <= besttime) {
				besttime = actualtime;
				bestshowtime = showtime;
				top.setText(bestshowtime);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == start) { //게임시작
			if (!time_run && !scr.gamestart ) {
				starttime = System.currentTimeMillis(); //시간값받기
				scr.rect.clear();
				time_run = true;
				scr.gameStart(true);
			}
		} else if (e.getSource() == reset) {	//게임 초기화
			starttime = 0;
			time.setText("00:00.000");
			scr.rect.clear();
			scr.counter(0);
			time_run = false;
			scr.gameStart(false);
			scr.checker = 0;
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

```

ImagePanel 클래스

```
class ImagePanel extends JPanel implements MouseListener { //게임화면 패널
	int count = 3;//Count Down
	int x, y; //좌표설정
	int checker; //숫자 체크용
	String time;//클리어 시간값 표시용
	boolean gamestart = false;
	Random randomnum = new Random(); //랜덤함수
	Vector<SelRect> rect = new Vector<SelRect>(); //1-50 숫자보관용 벡터(객체담음)
	SelRect sr; //숫자 보관용 객체 클래스 접근 키
	ImagePanel() {
		this.addMouseListener(this);
	}

	public void counter(int count) { //게임 시간값을 받아와 카운트다운 표시
		switch (count) {
		case 0:
			this.count = 3;
			break;
		case 1:
			this.count = 2;
			break;
		case 2:
			this.count = 1;
			break;
		case 3:
			this.count = 0;
			gamestart = false;
			break;
		}
	}

	public void gameStart(boolean game_start) { //25개의 사각형과 해당사각형안에
												//난수를 발생시켜 숫자를 입력한다.
		this.gamestart = game_start;
		if ( this.gamestart ){
			checker = 1;
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					int num = 0;
					int xx = 5 + i * 80;
					int yy = 5 + j * 80; // 25개 사각형 좌표 설정
					num = randomnum.nextInt(25) + 1;
					for (int k = 0; k < rect.size(); ++k) {
						sr = (SelRect) rect.get(k);
						if ( sr.number == num ) {
							num = randomnum.nextInt(25) + 1;
							k = -1;
						}
					} //다음의 중복 없는 난수 발생
					sr = new SelRect(xx, yy, num);
					rect.add(sr); //받은 좌표 및 난수값을 객체화시켜 벡터로 저장
				}
			}
		}
	}

	public void paint(Graphics g) {
		g.drawRect(0, 0, 400, 400);	//테두리
		if (gamestart) { //카운트 텍스트
			g.setFont(new Font("Default", Font.BOLD, 50));
			g.drawString("Count Down", 50, 150);
			g.setFont(new Font("Default", Font.BOLD, 100));
			g.drawString("" + count, 160, 250);
		}else if ( !gamestart && count == 0 ){
			for (int i = 0; i < rect.size(); ++i) {
				sr = (SelRect) rect.get(i);
				g.drawRect(sr.x, sr.y, 70, 70);
				g.setFont(new Font("Default", Font.BOLD, 30));
				g.drawString("" + sr.number, sr.x + 22, sr.y + 45); //사각형과 숫자 그리기
			}
			g.setColor(Color.yellow);
			g.drawRect(x * 80 + 5, y * 80 + 5, 70, 70);	//마우스로 선택된 사각박스를 표시
		}
		if ( checker > 50 ){
			g.setColor(Color.blue);
			g.setFont(new Font("Default", Font.BOLD, 50));
			g.drawString("GAME CLEAR!", 30, 150);
			g.setColor(Color.green);
			g.setFont(new Font("Default", Font.BOLD, 40));
			g.drawString("" + time, 70, 250); 	//클리어 화면 표시
		}
	}

	public void Cleart(String time){
		this.time = time;
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		x = e.getX() / 80;
		y = e.getY() / 80;
		if ( count == 0 ){
			for (int i = 0; i < rect.size(); ++i) {
				sr = (SelRect) rect.get(i);
				if (x == sr.x / 80 && y == sr.y / 80) {
					int xx = sr.x;
					int yy = sr.y;
					if ( sr.number - checker == 0 ) {
						checker++;
						rect.remove(i);			 //1-50 숫자 순서대로 클릭되면 제거(벡터)
						if ( checker < 27 ){
							int num = 0;
							num = randomnum.nextInt(25) + 26;
							for (int k = 0; k < rect.size(); ++k) {
								sr = (SelRect) rect.get(k);
								if ( sr.number == num ) {
									num = randomnum.nextInt(25) + 26;
									k = -1;
								}
							}
							sr = new SelRect(xx, yy, num);
							rect.add(sr); 			//제거된 자리에 난수를 발생시켜 추가 (벡터)
						}
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	}

```

사각형 클래스. 숫자 및 위치 보관용(벡터)

```

class SelRect { //숫자 및 위치 보관용
	int x, y;
	int number;
	SelRect(int x, int y, int number) {
		this.x = x;
		this.y = y;
		this.number = number;
	}
}

```

클래스 합본

```

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.*; //import구간

public class OneToFifty {
	
	public static void main(String[] arg) {
		MainC m = new MainC(); //메인클래스를불러와실행
	}
}

class MainC extends JFrame implements MouseListener, Runnable { // 메인클라스
	private JLabel title = new JLabel();	//타이틀 표시
	private JLabel time = new JLabel(); //진행시간 표시
	private JLabel top = new JLabel(); //가장 빠른시간
	private JButton start = new JButton("START"); //시작 버튼
	private JButton reset = new JButton("RESET"); //리셋 버튼
	SimpleDateFormat time_format; //시간 값 변환 포맷
	String showtime; //진행시간의 문자 열
	String bestshowtime; //빠른시간의 문자 열
	long starttime, currenttime, actualtime;	//시작 시간, 컴퓨터 시간, 진행 시간
	long temptime, besttime = 99999; //가장 빠른 시간을 기록하기위함(처음 시작할 때 시간기록을 위해 숫자를 크게지정)
	boolean time_run = false;
	Image background_img;
	Thread th; //쓰레드
	ImagePanel scr; //패널 클래스 접근 키
	
	MainC() { //프레임 정의
		opt();
		start();
		setTitle("1부터 50까지!");
		setSize(600, 600);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xps = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int yps = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(xps, yps);
		setResizable(false);
		setVisible(true);
	}

	public void opt() { //라벨,버튼 및 패널설정
		Container con = this.getContentPane();
		con.setLayout(null);
		title.setBounds(230, 10, 300, 30);
		title.setFont(new Font("Default", Font.BOLD, 20));
		con.add(title);
		time.setBounds(380, 50, 150, 30);
		time.setFont(new Font("Default", Font.BOLD, 20));
		con.add(time); 
		top.setBounds(100, 50, 150, 30);
		top.setFont(new Font("Default", Font.BOLD, 20));
		con.add(top); //텍스트 라벨
		start.setBounds(100, 520, 100, 30);
		start.setFont(new Font("Default", Font.BOLD, 20));
		con.add(start);
		reset.setBounds(400, 520, 100, 30);
		reset.setFont(new Font("Default", Font.BOLD, 20));
		con.add(reset); //버튼
		scr = new ImagePanel();
		scr.setBounds(100, 100, 410, 410);
		con.add(scr); //패널

	}

	public void start() { //실행 기본내용
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		start.addMouseListener(this);
		reset.addMouseListener(this);
		th = new Thread(this);
		th.start();	//쓰레드 시작
		time_format = new SimpleDateFormat("mm:ss.SSS");	//시간포맷설정
		time.setText("00:00.000");
		top.setText("00:00.000");
		title.setText("1부터 50까지!"); // 라벨 내용 설정
		scr.gameStart(false); // 대기상태로
	}

	public void run() {
		while (true) {
			try {
				repaint();
				TimeChecker();
				Thread.sleep(15); // 무한 쓰레드
			} catch (Exception e) {
			}
		}
	}
	
	public void TimeChecker() {
		if (time_run) {
			currenttime = System.currentTimeMillis();
			actualtime = currenttime - starttime; 	 // 현재 시간에서 시작 시간을 빼서 진행 시간 계산
			scr.counter((int) actualtime / 1000); //카운트용 시간 전송
			if (!scr.gamestart && scr.checker <= 50) { //게임 시작되면 게임 시간 갱신
				showtime = time_format.format(actualtime - 3000); //시작시간이 거의 0이 되도록만듦
				time.setText(showtime);
			}	
		}
		if ( scr.checker > 50){
			scr.Cleart(time.getText()); // 숫자 50까지 끝나면 클리어 띄울 준비
			if(actualtime <= besttime) {
				besttime = actualtime;
				bestshowtime = showtime;
				top.setText(bestshowtime);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == start) { //게임시작
			if (!time_run && !scr.gamestart ) {
				starttime = System.currentTimeMillis(); //시간값받기
				scr.rect.clear();
				time_run = true;
				scr.gameStart(true);
			}
		} else if (e.getSource() == reset) {	//게임 초기화
			starttime = 0;
			time.setText("00:00.000");
			scr.rect.clear();
			scr.counter(0);
			time_run = false;
			scr.gameStart(false);
			scr.checker = 0;
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

class ImagePanel extends JPanel implements MouseListener { //게임화면 패널
	int count = 3;//Count Down
	int x, y; //좌표설정
	int checker; //숫자 체크용
	String time;//클리어 시간값 표시용
	boolean gamestart = false;
	Random randomnum = new Random(); //랜덤함수
	Vector<SelRect> rect = new Vector<SelRect>(); //1-50 숫자보관용 벡터(객체담음)
	SelRect sr; //숫자 보관용 객체 클래스 접근 키
	ImagePanel() {
		this.addMouseListener(this);
	}

	public void counter(int count) { //게임 시간값을 받아와 카운트다운 표시
		switch (count) {
		case 0:
			this.count = 3;
			break;
		case 1:
			this.count = 2;
			break;
		case 2:
			this.count = 1;
			break;
		case 3:
			this.count = 0;
			gamestart = false;
			break;
		}
	}

	public void gameStart(boolean game_start) { //25개의 사각형과 해당사각형안에
												//난수를 발생시켜 숫자를 입력한다.
		this.gamestart = game_start;
		if ( this.gamestart ){
			checker = 1;
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					int num = 0;
					int xx = 5 + i * 80;
					int yy = 5 + j * 80; // 25개 사각형 좌표 설정
					num = randomnum.nextInt(25) + 1;
					for (int k = 0; k < rect.size(); ++k) {
						sr = (SelRect) rect.get(k);
						if ( sr.number == num ) {
							num = randomnum.nextInt(25) + 1;
							k = -1;
						}
					} //다음의 중복 없는 난수 발생
					sr = new SelRect(xx, yy, num);
					rect.add(sr); //받은 좌표 및 난수값을 객체화시켜 벡터로 저장
				}
			}
		}
	}

	public void paint(Graphics g) {
		g.drawRect(0, 0, 400, 400);	//테두리
		if (gamestart) { //카운트 텍스트
			g.setFont(new Font("Default", Font.BOLD, 50));
			g.drawString("Count Down", 50, 150);
			g.setFont(new Font("Default", Font.BOLD, 100));
			g.drawString("" + count, 160, 250);
		}else if ( !gamestart && count == 0 ){
			for (int i = 0; i < rect.size(); ++i) {
				sr = (SelRect) rect.get(i);
				g.drawRect(sr.x, sr.y, 70, 70);
				g.setFont(new Font("Default", Font.BOLD, 30));
				g.drawString("" + sr.number, sr.x + 22, sr.y + 45); //사각형과 숫자 그리기
			}
			g.setColor(Color.yellow);
			g.drawRect(x * 80 + 5, y * 80 + 5, 70, 70);	//마우스로 선택된 사각박스를 표시
		}
		if ( checker > 50 ){
			g.setColor(Color.blue);
			g.setFont(new Font("Default", Font.BOLD, 50));
			g.drawString("GAME CLEAR!", 30, 150);
			g.setColor(Color.green);
			g.setFont(new Font("Default", Font.BOLD, 40));
			g.drawString("" + time, 70, 250); 	//클리어 화면 표시
		}
	}

	public void Cleart(String time){
		this.time = time;
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		x = e.getX() / 80;
		y = e.getY() / 80;
		if ( count == 0 ){
			for (int i = 0; i < rect.size(); ++i) {
				sr = (SelRect) rect.get(i);
				if (x == sr.x / 80 && y == sr.y / 80) {
					int xx = sr.x;
					int yy = sr.y;
					if ( sr.number - checker == 0 ) {
						checker++;
						rect.remove(i);			 //1-50 숫자 순서대로 클릭되면 제거(벡터)
						if ( checker < 27 ){
							int num = 0;
							num = randomnum.nextInt(25) + 26;
							for (int k = 0; k < rect.size(); ++k) {
								sr = (SelRect) rect.get(k);
								if ( sr.number == num ) {
									num = randomnum.nextInt(25) + 26;
									k = -1;
								}
							}
							sr = new SelRect(xx, yy, num);
							rect.add(sr); 			//제거된 자리에 난수를 발생시켜 추가 (벡터)
						}
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	}

class SelRect { //숫자 및 위치 보관용
	int x, y;
	int number;
	SelRect(int x, int y, int number) {
		this.x = x;
		this.y = y;
		this.number = number;
	}
}

```

압축파일 다운로드 링크 (.java, .class
http://comp166-koreauniv.googlecode.com/files/2012190711.zip