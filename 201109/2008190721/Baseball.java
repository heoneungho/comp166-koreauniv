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