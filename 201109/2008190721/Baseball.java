public class Baseball { 
     
     
     int Question[]; // ���� 
     int UserInput[]; // ������ �Է� 
     int StrikeCount; // ��Ʈ����ũ 
     int BallCount;  // �� 
     int TryCount=1;   //trial  
     int OutCount=1;  //�ƿ� 
      
     Baseball()   
     { 
 
     } 
 
     Baseball(int arr[]) // �迭���� �޴� ������ 
     { 
      Question = new int[3]; 
 
      for(int i = 0 ; i < Question.length ; i++)  
      { 
       Question[i] = (int)(Math.random()*9)+1; // �����Լ� ���1~9���� 
       for(int j = 0 ; j < i ; j++) 
       { 
        if(Question[i]==Question[j])  // �ߺ��� ���� �ϱ����� �� 
        { 
         i--;       // �ߺ��� �Ǹ� �ٽ� ���� ���� 
         break; 
        } 
       } 
      } 
      
      UserInput = new int[3];  // ������ �Էºκе� ���� �ʱ�ȭ���Ѿ� �Ѵ�. 
 
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
 
 
     boolean isRun() // �ݺ� �۵� 
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