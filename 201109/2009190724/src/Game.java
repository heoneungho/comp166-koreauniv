import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class Game {

	/**
	 * @param args
	 */
	
	public static int nUser;
	public static User[] u;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("input the number of users : ");
		
		nUser = scan.nextInt();
		scan.nextLine();
		
		u = new User[nUser];
		String userName = "";
		
		for (int i=0; i< nUser; i++)
		{
			System.out.print("Enter the name of user : ");
			userName = scan.nextLine();
			
			u[i] = new User(userName);
		}
		
		int idx = 0;
		int h_idx = -1;
		while(true)
		{
			h_idx = 0;
			printAll();
			
			YutResult res = Yut.Throw();
			
			System.out.println(u[idx] + " : " + res);
			
			while(true)
			{
				System.out.print("Select your horse : ");
				h_idx = scan.nextInt();
				scan.nextLine();
				
				if (h_idx >= 1 && h_idx <= 4)
				{
					Point p = u[idx].horse[h_idx-1];
					if (p != Point.GOAL_IN)
					{
						break;
					}
				}
			}
			
			Point prevPoint = u[idx].horse[h_idx-1];
			Point nowPoint = Board.Run(prevPoint, res);
			
			u[idx].horse[h_idx-1] = nowPoint;
			
			boolean isChk = true;
			for (int i=0; i<4;i++)
			{
				if (u[idx].horse[i] != Point.GOAL_IN)
				{
					isChk = false;
				}
			}
			
			if (isChk)
			{
				printAll();
				System.out.println("Winner is " + u[idx]);
				break;
			}
			
			boolean isBonus = false;
			
			if (res == YutResult.Yut || res == YutResult.Mo)
			{
				isBonus = true;
			}
			
			for (int i=0;i<nUser;i++)
			{
				if (i != idx)
				{
					for (int j=0;j<4;j++)
					{
						if (u[i].horse[j] == nowPoint)
						{
							u[i].horse[j] = Point.NOT_IN_GAME;
							isBonus = true;
						}
					}
				}
			}
			
			if (!isBonus)
			{
				idx++;
			}
			
			if (idx == nUser)
			{
				idx = 0;
			}
		}
		
		return;
	}
	
	public static void printAll()
	{
		String term = "";
		for (int i=0; i<nUser; i++)
		{
			term += String.format("%15s ", u[i]);
		}
		System.out.println(term);
		
		for (int i=0; i<4; i++)
		{
			term = "";
			for (int j=0; j<nUser;j++)
			{
				term += String.format("%d:%13s ", i+1, u[j].horse[i]);
			}
			System.out.println(term);
		}
	}

}


// 게임이 본격적으로 시작되는 클래스입니다.