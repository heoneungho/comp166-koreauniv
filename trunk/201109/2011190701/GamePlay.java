import java.util.*;
import java.io.*;
public class GamePlay	{
	public static int Level = 1;
	public static int Selection;
	public static int Difficulty;
	public GamePlay() throws IOException	{
		Scanner sc = new Scanner();
		Difficulty = sc.nextInt();
		while((Difficulty > 4) || (Difficulty < 1))	{
			System.out.println("���̵� ����");
			System.out.print("1 = Easy, 2 = Normal, 3 = Hard, 4 = Lunatic");
			if(Difficulty == 1)	{
				System.out.println("���� ���̵��Դϴ�.");
			}	else if(Difficulty == 2)	{
				System.out.println("���� ���̵��Դϴ�.");
			}	else if(Difficulty == 3)	{
				System.out.println("����� ���̵��Դϴ�.");
			}	else if(Difficulty == 4)	{
				System.out.println("��ĥ���� ���̵��Դϴ� .");
			}	else	{
				System.out.println("�峭�ϳ�? �ٽ� ���!");
			}
		}
		System.out.println("ĳ���� ����");
		System.out.println("1. ������ ����, 2. ȣ���̻� ī����, 3. ��Ű����Ű �߸��ڳ���");
		Scanner sc = new Scanner();
		Selection = sc.nextInt();
		Battle b = new Battle();
	}
}