import java.util.Scanner;

public class Launcher {
	public static void main(String[] args){
		Analyze [] Questions = new Analyze[7];
		String[] RofQ;
		RofQ = new String[7];
		int i = 0;
		for ( i=0 ; i<7 ; i++ ) {
			Questions[i] = new Analyze();
			Questions[i].Result();
			RofQ[i] = null;
		}
		
		RofQ[0] = Questions[0].result0;
		RofQ[1] = Questions[1].result1;
		RofQ[2] = Questions[2].result2;
		RofQ[3] = Questions[3].result3;
		RofQ[4] = Questions[4].result4;
		RofQ[5] = Questions[5].result5; 
		RofQ[6] = Questions[6].result6;
		
		System.out.println("�Ʒ� �ܾ��߿� ���� ���� ������ �ʹ�� �ܾ��� ��ȣ�� ������");
		System.out.println("1. ����");
		System.out.println("2. ��");
		System.out.println("3. ����");
		System.out.println("4. ģ��");
		System.out.println("5. ��ħ");
		System.out.println("6. ����");
		System.out.println("7. ����");
		
		Scanner scan = new Scanner (System.in);
		int number = scan.nextInt();
		
		
		if ( number==1 )
			System.out.println(RofQ[0]);
		else if ( number==2 )
			System.out.println(RofQ[1]);
		else if ( number==3 )
			System.out.println(RofQ[2]);
		else if ( number==4 )
			System.out.println(RofQ[3]);
		else if ( number==5 )
			System.out.println(RofQ[4]);
		else if ( number==6 )
			System.out.println(RofQ[5]);
		else if ( number==7 )
			System.out.println(RofQ[6]);
		
		MusicPlayer player = new MusicPlayer(number);
		player.start();
	}
}
