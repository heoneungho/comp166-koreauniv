# Introduction #

> 베이스볼 게임
> 베이스볼 게임은 상대방이 생각하고 있는 숫자를 맞추는 일종의 추리게임이다. 번갈아 가면서 상대방이 생각하고 있을 것 같은 숫자를 말하면, 상대방은 그 숫자가 자신이 생각한 숫자와 얼마나 일치하는지를 '볼', '스트라이크', '아웃' 세 가지로 알려준다.
숫자와 위치가 정확히 맞으면 스트라이크, 위치는 틀리고 숫자만 맞으면 볼, 두 가지가 다 틀리면 아웃으로 알려주어서, 상대방보다 먼저 상대방의 숫자와 위치를 정확하게 맞추는 게임이다.


# Background #

> 친구들과 이면지 한장과 볼펜만 있으면 재미있게 즐길 수 있는 베이스볼게임을 컴퓨터를 통해 컴퓨터가 내주는 문제로 즐길 수 있도록 하겠다.

# Details #
컴퓨터가 문제를 만들어서 사용자가 그 문제를 맞추는 방식의 게임을 만든다.
> A. 컴퓨터가 난수를 만들어서 임의의 3개의 숫자 조합을 만든다.
> B. 사용자가 숫자조합을 입력한다.
> C. 스트라이크, 볼, 아웃, 시도 횟수를 알려준다.
> D. A~D과정이 반복되다가 3스트라이크가 나오면 congraturation을 출력하며 게임이 종료된다.

# Using code #

```
package baseball;

public class Baseball {
    
    
     int Question[]; // 문제
     int UserInput[]; // 유저의 입력
     int StrikeCount; // 스트라이크
     int BallCount;  // 볼
     int TryCount=1;   //trial 
     int OutCount=1;  //아웃
     
     Baseball()  
     {

     }

     Baseball(int arr[]) // 배열값을 받는 생성자
     {
      Question = new int[3];

      for(int i = 0 ; i < Question.length ; i++) 
      {
       Question[i] = (int)(Math.random()*9)+1; // 랜덤함수 사용1~9까지
       for(int j = 0 ; j < i ; j++)
       {
        if(Question[i]==Question[j])  // 중복을 제거 하기위해 비교
        {
         i--;       // 중복이 되면 다시 난수 생성
         break;
        }
       }
      }
     
      UserInput = new int[3];  // 유저의 입력부분도 같이 초기화시켜야 한다.

     }

     void SetUserInput(int UserInput[])
     {
      for(int i=0 ; i < UserInput.length ; i++)
       this.UserInput[i] = UserInput[i];

      TryCount++;
    
     }

     int CountStrike()
     {
      StrikeCount=0;
      for(int i = 0; i<Question.length ; i++)
      {
       if( Question[i] == UserInput[i])
        StrikeCount++;    
      }

      return StrikeCount;
     }

     int CountBall()
     {
      BallCount=0;
      for(int i = 0 ; i < Question.length ; i++)
      {
       for(int j = 0 ; j < Question.length ; j++)
       {
        if(Question[i] == UserInput[j] && i !=j )
         BallCount++;
       }
      }

      return BallCount;
     }


     boolean isRun() // 반복 작동
     {
     
      if( StrikeCount ==  3)
       return false;
      else
       return true;

     }

     void disPlay()
     {
    	 if(StrikeCount == 0 && BallCount == 0) {
    		 System.out.println(OutCount + " Out");
    		 OutCount++;
    	 }
    	 else {
      System.out.print(StrikeCount +"S " + BallCount +"B \n\n");
     }
    }
}
package baseball;

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
```