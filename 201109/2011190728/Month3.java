import java.util.Scanner;
public class Month3 extends Month{
	
	public Diary go()
	{
		Day[] Days;
		Days = new Day[32];
		Days[1] = one;
		Days[2] = two;
		Days[3] = three;
		Days[4] = four;
		Days[5] = five;
		Days[6] = six;
		Days[7] = seven;
		Days[8] = eight;
		Days[9] = nine;
		Days[10] = ten;
		Days[11]= eleven;
		Days[12]= twelve;
		Days[13]= thirteen;
		Days[14]= fourteen;
		Days[15]= fifteen;
		Days[16]= sixteen;
		Days[17]= seventeen;
		Days[18]= eighteen;
		Days[19]= ninteen;
		Days[20]= twenty;
		Days[21]= twentyone;
		Days[22]= twentytwo;
		Days[23]= twentythree;
		Days[24]= twentyfour;
		Days[25]= twentyfive;
		Days[26]= twentysix;
		Days[27]= twentyseven;
		Days[28]= twentyeight;
		Days[29]= twentynine;
		Days[30]= thirty;
		Days[31]= thirtyone;
		System.out.println("일을 입력하세요:");
		Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Day a = Days[b];
        return a;
	}
	
	
	}
