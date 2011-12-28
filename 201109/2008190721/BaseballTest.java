import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
 
 
 
public class BaseballTest { 
    public static void main(String[] args) throws IOException 
     {  
 
      // 키보드로부터 입력받기 위한 객체 선언 및 생성 
 
      BufferedReader stdin = new BufferedReader( 
              new InputStreamReader(System.in)); 
 
      String strLine = null; 
 
 
      Baseball baseball;  // 객체 선언 
 
      int number[] = new int[3]; 
 
      baseball = new Baseball(); // 객체 생성 (내부적으로 생성자 작동) 
 
      baseball = new Baseball( number ); // 인자가 1개(일차원배열)인 생성자 작동 
 
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
        
       // 키보드로 3개 숫자를 입력받는다. 
        
       strLine = stdin.readLine();  
 
       //문자를 10진수 숫자로 바꾸기 위해 사용 
        
       for (int i=0; i<UserInput.length; i++) 
       { 
           //main에 있는 UserInput에 값 집어넣는다. 
        UserInput[i]=Character.digit(strLine.charAt(i),10); 
       } 
       
       baseball.SetUserInput(UserInput); 
 
       baseball.CountStrike(); 
       baseball.CountBall(); 
 
       baseball.disPlay(); 
      } 
    //  if(baseball.StrikeCount ==3) 
          System.out.println("Congratulations^ㅡ^!!!!"); 
     } 
     
}