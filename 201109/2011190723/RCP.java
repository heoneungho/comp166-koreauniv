import java.util.*;    //Random Ŭ�����̿�
import java.io.*;    //���߿�readbuffer����������

interface game {
	public int getData();
	public void makeNum();
	public void Show();
	public void run();
}

abstract class Player implements game {    //interface�� ��ӹ޾� �߻�Ŭ����

	protected int gbb;		//0,1,2���ǰ�����
	protected Random rand;		//������ü��������
	protected BufferedReader rcp;	//������Է°�
	protected String line;
}

class StupidEagle extends Player {

	public StupidEagle() {		//����������
		rand = new Random();	//�޸𸮻���
	}


	//Overriding


	public int getData() {
		return gbb;
	}

	public void makeNum() {
		gbb = rand.nextInt(3);	//0~2�����ǰ��̵�
	}

	public void Show() {
		if (gbb==0) {
			System.out.println("StupidEagle : ����!\n");
		}

		else if (gbb==1) {
			System.out.println("StupidEagle : ����!\n");
		}

		else if (gbb==2) {
			System.out.println("StupidEagle : ��!\n");
		}

		else {
			System.out.println("�� �� ���� ���������� �϶��!!\n");
		}
	}

	public void run() {
		makeNum();
		Show();
	}
}

class AngryTiger extends Player { 

	private int temp;	//�ӽð�

	public AngryTiger() {
		rcp = new BufferedReader(new InputStreamReader(System.in));

	//���۸��� Ŭ������ rcp�� ���� Ȯ��!

	}

	public int getData() {
		return temp;
	}

	public void makeNum() {
		try {
			line = rcp.readLine();		//������Է�

			temp = Integer.parseInt(line);	//���ڰ� �ƴ� ����� �Է��� ��������ȯ
		}

		catch(IOException error) {
			System.out.println("Error!\n");
			System.exit(0);
		}
	}

	public void Show() {
		if (temp==0) {
			System.out.println("===================================");
			System.out.println("Angry Tiger : ����!\n\n");
		}

		else if (temp==1) {
			System.out.println("===================================");
			System.out.println("Angry Tiger : ����!\n");
		}

		else if (temp==2) {
			System.out.println("===================================");
			System.out.println("Angry Tiger : ��!\n\n");
		}

		else if (temp==(-1)) {
			System.out.println("===================================");
			System.out.println("���α׷��� �����մϴ�.!\n\n");
		}

		else {
			System.out.println("===================================");
			System.out.println("Error!\n\n");

			makeNum();	//���Է� �޾ƿ�
		}
	}

	public void run() {
		makeNum();
		Show();
	}
}

public class RCP {	//����Ŭ����
	private Player c;
	private Player p;

	//��ü�������� - �θ�Ŭ�����λ���

	public static int lose_cnt = 0;
	public static int win_cnt = 0;
	public static int draw_cnt = 0;
	public static int total_cnt = 0;

	//static ��������- �̱�,��,���,�հ�->static�������Ҵ�
 
	public RCP() {

		c = new StupidEagle();
		p = new AngryTiger(); 

	
	//��ü ���� �����ڷ� Angry Tiger�� StupidEagle Ŭ���� ���� �Ҵ�
 
	//��ĳ����

	}

	public static void main(String[] args) {
		RCP t;

		t = new RCP();

		t.run();
	}

	//���ο����� ����Ŭ���� ������ �Ҵ��ϰ� ���� ȣ���ϰ� ������
 
	private void run() {
		while(true) {
			int c_temp;
			int p_temp;

			System.out.println("Welcome! 'Angry Tiger!'\n");
			System.out.println("���� : 0, ���� : 1, �� : 2, ���� : -1 �Դϴ�.\n");

			p.run(); 
			p_temp = p.getData();

			if(p_temp==(-1)) {
				print(); 
			}

			c.run(); //���� �޼���� ���ư��� �ڽ� Ŭ������ ���ư�
			c_temp = c.getData();

			check(c_temp,p_temp);
		}
	}

	//run������ �ϴ� public getData�� �̿��Ͽ� �� �޾� �Ҵ�
 
	//�׵ڿ� �Լ� �ݸ� �Ѵ�.

	private void check(int c, int p) {
		total_cnt++;				//��ü����Ƚ������

		if ((c+1==p) || (0==p && 2==c)) {	//�¸��ϴ°��

			System.out.println("Of course Tiger Win!!!:D\n��뷡 gogo!!!\n");
			System.out.println("===================================");

			win_cnt++;
		}

		else if ((c-1)==p || (0==c && 2 ==p)) {	//���°��

			System.out.println("��.\n");
			System.out.println("===================================");

			lose_cnt++;
		}

		else if(c==p) {				//���°��
                           
			System.out.println("����");
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
		System.out.println(" ���ݱ��� ���� Ƚ��: "+total_cnt+"\n");
		System.out.println(" ���ݱ��� �̱� Ƚ��: "+win_cnt+"\n");
		System.out.println(" ���ݱ��� �� Ƚ��:  "+lose_cnt+"\n");
		System.out.println(" ���ݱ��� ��� Ƚ��: "+draw_cnt+"\n");
		System.out.println("===================================");      
		System.exit(0);    //����

	}
}