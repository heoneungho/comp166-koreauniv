import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
 
 
 
public class BaseballTest { 
    public static void main(String[] args) throws IOException 
     {  
 
      // Ű����κ��� �Է¹ޱ� ���� ��ü ���� �� ���� 
 
      BufferedReader stdin = new BufferedReader( 
              new InputStreamReader(System.in)); 
 
      String strLine = null; 
 
 
      Baseball baseball;  // ��ü ���� 
 
      int number[] = new int[3]; 
 
      baseball = new Baseball(); // ��ü ���� (���������� ������ �۵�) 
 
      baseball = new Baseball( number ); // ���ڰ� 1��(�������迭)�� ������ �۵� 
 
      int UserInput[] = new int[3]; 
 
      System.out.println("---------- START BASEBALLGAME ----------"); 
      System.out.println("You have ONLY 7 Trils"); 
      System.out.println("GOOD LUCK\n"); 
      while( baseball.isRun() ) 
      { 
 
          if(baseball.TryCount == 7) { 
                  System.out.println("\n-------It's the LAST trials!!!!!--------"); 
          } 
          if(baseball.TryCount > 7) { 
                  for(int k=0; k<10; k++) 
                          System.out.println("Game over!!!!!!!!!!!!!!!"); 
                          System.exit(0); 
          } 
           System.out.println(baseball.TryCount+"trial"); 
 
          System.out.print("Input 3 integers"); 
        
       // Ű����� 3�� ���ڸ� �Է¹޴´�. 
        
       strLine = stdin.readLine();  
 
       //���ڸ� 10���� ���ڷ� �ٲٱ� ���� ��� 
        
       for (int i=0; i<UserInput.length; i++) 
       { 
           //main�� �ִ� UserInput�� �� ����ִ´�. 
        UserInput[i]=Character.digit(strLine.charAt(i),10); 
       } 
       
       baseball.SetUserInput(UserInput); 
 
       baseball.CountStrike(); 
       baseball.CountBall(); 
 
       baseball.disPlay(); 
      } 
    //  if(baseball.StrikeCount ==3) 
          System.out.println("Congratulations^��^!!!!"); 
     } 
     
}