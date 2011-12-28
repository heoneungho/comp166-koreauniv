
public class Maze {
	public char rooms[][] = 
		{	{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'M',2},
			{2,2,2,1,2,1,2,1,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2},
			{2,2,2,1,2,1,2,1,1,1,1,1,1,2,1,2,2,2,1,2,2,1,2},
			{2,1,1,'T',2,1,1,2,2,2,2,2,1,2,1,1,1,2,1,2,2,1,2},
			{2,1,2,1,2,2,1,1,1,1,1,2,1,2,1,2,1,2,1,2,2,2,2},
			{2,1,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,'M',1,1,1,2},
			{2,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,1,1,'M',1,2,1,2,1,1,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,2,2,1,2,2,1,2,2,2,2,2,1,2,2,2,1,2,2,1,2},
			{2,1,'T',1,1,1,2,2,1,1,1,1,1,1,1,2,2,2,1,2,2,1,2},
			{2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2},
			{2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,2,'B','G'},
			{2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
		

		
	   public int locationA = 1;
	   public int locationB = 1;
	   
	  

	   public void Maze_limit() {
	  
	                 System.out.println(rooms[locationA-1][locationB-1]+ " " +rooms[locationA][locationB-1]+ " " +rooms[locationA+1][locationB-1]);
	                 System.out.println(rooms[locationA-1][locationB]+ " P " +rooms[locationA+1][locationB]);
	                 System.out.println(rooms[locationA-1][locationB+1]+ " " +rooms[locationA][locationB+1]+ " " +rooms[locationA+1][locationB+1]);
	            										}
	         							
	   public void Maze_alter(char userinput) {
	
		   if(userinput == 'a')
			   		locationA--;
		   	if(userinput == 's')
		   		  	locationB++;
		   	if(userinput == 'd')
		   			locationA++;
		   	if(userinput == 'w')
		   			locationB--;
		   	
		   	if(rooms[locationA][locationB] == 43)	{
		   			System.out.println("Error, you cannot go there");
		   					if(userinput == 'a')
		   						locationA++;
		   					if(userinput == 's')
		   			   		  	locationB--;
		   					if(userinput == 'd')
		   			   			locationA--;
		   					if(userinput == 'w')
		   			   			locationB++;
		   	}
		   	if((userinput != 'a')&&(userinput != 's') &&(userinput != 'd')&&(userinput != 'w'))
		   		System.out.println("ERROR!! YOU TYPED WRONG!!!");
	   			}
	   public void Maze_reseter()	{
		   locationA = 1;
		   locationB = 1;
	   }

}
