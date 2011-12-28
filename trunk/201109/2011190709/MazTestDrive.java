import java.io.IOException;

public class MazTestDrive {
	public static char userinput;
	static char chooser;
	
	public static void main(String [] args) throws ArrayIndexOutOfBoundsException	{
		Maze mazing = new Maze();
		Character player1 = new Character();
		Boss player2 = new Boss();
		 int tempA = 0;
		 int tempB = 0;
			
			for(tempA = 0; tempA < 17; tempA++)	{
				for(tempB= 0;tempB < 23; tempB++)	{
					if(mazing.rooms[tempA][tempB] == 1)
						mazing.rooms[tempA][tempB] = 32;
					if(mazing.rooms[tempA][tempB] == 2)
						mazing.rooms[tempA][tempB] =43;
				}
			}
			tempA = (int)(Math.random() * 10);
			System.out.println("This is Maze game. You have to figure out how to get out of here\n"+tempA);
			System.out.println("Empty space is the path, and '+' is the wall, and you are 'P'. You cannot go through the wall");
			System.out.println("If you want to play this game on script, input 'y', if you want play this game on gui, input 'n'\n");
			try	{
			chooser = (char)System.in.read();
			System.in.read();
			System.in.read();
			} catch (IOException chooser)	{
				System.out.println("FATAL ERROR, PLEASE RUN THIS PROGRAM AGAIN");
			}
			
			if(chooser == 'y')	{
   while(mazing.rooms[mazing.locationA][mazing.locationB] != 71)	{
	   System.out.println("_____________________________________________________________________________");
	   mazing.Maze_limit();
	   System.out.println("if you want to go up, press 'w', down 's', left 'a', and right 'd'");
	  
	   try	{
	   userinput = (char)System.in.read();
	   System.in.read();
	   System.in.read();
	   } catch (IOException userinput)	{
		   System.out.println("Please type ENTER.");
		   System.out.println("ERROR!! You TYPED WRONG!!!");  }
	   mazing.Maze_alter(userinput);
	   Sounder.Sound_pro();
	 
	   if(mazing.rooms[mazing.locationA][mazing.locationB]== 77)	{
	   player1.Monster();
	   if(player1.battle_definer == true)
	   mazing.rooms[mazing.locationA][mazing.locationB]= 32;
	   else
		   mazing.Maze_reseter();
	   }
	   
	   if(mazing.rooms[mazing.locationA][mazing.locationB]== 66 )	{
	   player2.BossMon();
	   if(player1.battle_definer == true)
	   mazing.rooms[mazing.locationA][mazing.locationB]= 32;
	   else
		   mazing.Maze_reseter();
	   }
	   
	   if(mazing.rooms[mazing.locationA][mazing.locationB]== 84 )	{
	   player1.Trapcard();
	   mazing.rooms[mazing.locationA][mazing.locationB] = 32;
	   mazing.Maze_reseter();
	   }
   	}
			}
			if(chooser == 'n')	{
				Maze_Gui gogo = new Maze_Gui();
				gogo.go();
			}
			if(chooser == 'y')
   System.out.println("Congratulations!! You have cleared the game");
}

}

