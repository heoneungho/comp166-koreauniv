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
			System.out.println("난이도 선택");
			System.out.print("1 = Easy, 2 = Normal, 3 = Hard, 4 = Lunatic");
			if(Difficulty == 1)	{
				System.out.println("쉬운 난이도입니다.");
			}	else if(Difficulty == 2)	{
				System.out.println("보통 난이도입니다.");
			}	else if(Difficulty == 3)	{
				System.out.println("어려운 난이도입니다.");
			}	else if(Difficulty == 4)	{
				System.out.println("미칠듯한 난이도입니다 .");
			}	else	{
				System.out.println("장난하냐? 다시 골라!");
			}
		}
		System.out.println("캐릭터 선택");
		System.out.println("1. 히지리 뱌쿠렌, 2. 호라이산 카구야, 3. 시키에이키 야마자나두");
		Scanner sc = new Scanner();
		Selection = sc.nextInt();
		Battle b = new Battle();
	}
}