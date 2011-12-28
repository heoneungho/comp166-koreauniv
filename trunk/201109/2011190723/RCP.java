import java.util.*;    //Random 클래스이용
import java.io.*;    //나중에readbuffer를쓰기위해

interface game {
	public int getData();
	public void makeNum();
	public void Show();
	public void run();
}

abstract class Player implements game {    //interface를 상속받아 추상클래스

	protected int gbb;		//0,1,2중의값저장
	protected Random rand;		//랜덤객체변수정의
	protected BufferedReader rcp;	//사용자입력값
	protected String line;
}

class StupidEagle extends Player {

	public StupidEagle() {		//생성자정의
		rand = new Random();	//메모리생성
	}


	//Overriding


	public int getData() {
		return gbb;
	}

	public void makeNum() {
		gbb = rand.nextInt(3);	//0~2까지의값이들어감
	}

	public void Show() {
		if (gbb==0) {
			System.out.println("StupidEagle : 가위!\n");
		}

		else if (gbb==1) {
			System.out.println("StupidEagle : 바위!\n");
		}

		else if (gbb==2) {
			System.out.println("StupidEagle : 보!\n");
		}

		else {
			System.out.println("딴 짓 말고 가위바위보 하라고!!\n");
		}
	}

	public void run() {
		makeNum();
		Show();
	}
}

class AngryTiger extends Player { 

	private int temp;	//임시값

	public AngryTiger() {
		rcp = new BufferedReader(new InputStreamReader(System.in));

	//버퍼리더 클래스로 rcp의 공간 확보!

	}

	public int getData() {
		return temp;
	}

	public void makeNum() {
		try {
			line = rcp.readLine();		//사용자입력

			temp = Integer.parseInt(line);	//숫자가 아닌 사용자 입력을 강제형변환
		}

		catch(IOException error) {
			System.out.println("Error!\n");
			System.exit(0);
		}
	}

	public void Show() {
		if (temp==0) {
			System.out.println("===================================");
			System.out.println("Angry Tiger : 가위!\n\n");
		}

		else if (temp==1) {
			System.out.println("===================================");
			System.out.println("Angry Tiger : 바위!\n");
		}

		else if (temp==2) {
			System.out.println("===================================");
			System.out.println("Angry Tiger : 보!\n\n");
		}

		else if (temp==(-1)) {
			System.out.println("===================================");
			System.out.println("프로그램을 종료합니다.!\n\n");
		}

		else {
			System.out.println("===================================");
			System.out.println("Error!\n\n");

			makeNum();	//재입력 받아요
		}
	}

	public void run() {
		makeNum();
		Show();
	}
}

public class RCP {	//실행클래스
	private Player c;
	private Player p;

	//객체변수정의 - 부모클래스로생성

	public static int lose_cnt = 0;
	public static int win_cnt = 0;
	public static int draw_cnt = 0;
	public static int total_cnt = 0;

	//static 변수정의- 이김,짐,비김,합계->static공간에할당
 
	public RCP() {

		c = new StupidEagle();
		p = new AngryTiger(); 

	
	//객체 변수 생성자로 Angry Tiger와 StupidEagle 클래스 공간 할당
 
	//업캐스팅

	}

	public static void main(String[] args) {
		RCP t;

		t = new RCP();

		t.run();
	}

	//메인에서는 실행클래스 공간만 할당하고 런만 호출하고 빠진다
 
	private void run() {
		while(true) {
			int c_temp;
			int p_temp;

			System.out.println("Welcome! 'Angry Tiger!'\n");
			System.out.println("가위 : 0, 바위 : 1, 보 : 2, 종료 : -1 입니다.\n");

			p.run(); 
			p_temp = p.getData();

			if(p_temp==(-1)) {
				print(); 
			}

			c.run(); //가상 메서드로 돌아가서 자식 클래스로 돌아감
			c_temp = c.getData();

			check(c_temp,p_temp);
		}
	}

	//run에서는 일단 public getData를 이용하여 값 받아 할당
 
	//그뒤에 함수 콜만 한다.

	private void check(int c, int p) {
		total_cnt++;				//전체게임횟수증가

		if ((c+1==p) || (0==p && 2==c)) {	//승리하는경우

			System.out.println("Of course Tiger Win!!!:D\n뱃노래 gogo!!!\n");
			System.out.println("===================================");

			win_cnt++;
		}

		else if ((c-1)==p || (0==c && 2 ==p)) {	//지는경우

			System.out.println("헐.\n");
			System.out.println("===================================");

			lose_cnt++;
		}

		else if(c==p) {				//비기는경우
                           
			System.out.println("어쭈");
			System.out.println("===================================");

			draw_cnt++;
		}

		else {

			System.out.println("?!@#$%^&*()_+|\n");
			System.out.println("===================================");

			System.exit(0);
		}
	}

	private void print() {

		System.out.println("===================================");              
		System.out.println(" 지금까지 게임 횟수: "+total_cnt+"\n");
		System.out.println(" 지금까지 이긴 횟수: "+win_cnt+"\n");
		System.out.println(" 지금까지 진 횟수:  "+lose_cnt+"\n");
		System.out.println(" 지금까지 비긴 횟수: "+draw_cnt+"\n");
		System.out.println("===================================");      
		System.exit(0);    //종료

	}
}