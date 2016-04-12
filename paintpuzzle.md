> 그림 맞추기 - 2011년 2학기 자바 프로젝트 소개 페이지

# Introduction #

명화 검색 프로그램에서 명화를 로드해서 조각을 나눠 맞추는 간단한 게임으로 계획을 수정했습니다. 단순한 명화 감상이 아닌 명화의 조각과 큰 그림을 제대로 감상할 수 있는 유익한 게임이었으면 하는 바람에서 만들게 되었습니다.

# Details #

전체적인 알고리즘입니다.

시작 → 메뉴를 띄운다

메뉴에는

1. 게임 시작

2. 게임 설정 ( 명화추가, 명화삭제)

3. 게임 종료

사용자가 게임 시작을 선택하면(생성자로 나눌 조각수를 입력받는다)
게임 보조 클래스(Game Helper Class)

1. 그림 업로드

2. 몇 칸**몇 칸으로 조각을 낸다.**

3. 조각을 섞는다.

while(사용자가 완성하지 못하는 동안, 즉, (result != complete!))
사용자에게 display한다.

1. 사용자가 마우스로 움직인다(ActionListener Class가 필요)

2. 사용자가 마우스를 한번 움직여서 그림조각을 옮길때마다 완성했는지 확인한다.
(Checkyourself method) - 움직인 횟수 count가 필요하다.

3. 다 맞았다면 while문을 나간다.

4. finishGame()메소드를 호출한다. - finishGame에서는 축하메시지, 횟수에 따른 성적을 알려주는 기능이 있다.

# CODE #
> ◆ 필요할 것으로 예상되는 패키지 - Head First Java GUI 부분 12, 13, 14장 공부중입니다.

```
import java.awt.*;//GUI 관련 
import javax.swing.*;//GUI 관련 
import java.util.*;
import java.io.*;//입출력 관련

```

> ◆ 클래스 목록
1. 실제로 main이 실행되는 클래스 PuzzleGame

2. 게임을 도와주는 보조클래스 GameHelper

> ◆ 필요한 변수들

```
     ArrayList<String> // 사용자가 파일 제목(String)을 저장하는 것을 저장할 ArrayList

     int level; //사용자가 그림을 level*level으로 조각낼 수 있게 입력을 받는다. 조각이 많을 수록 어려우므로 level의 의미를 부여함.
     int numOfMoves;//사용자가 몇번이나 조각을 옮겼는지 확인
      String grade;//사용자의 numOfmMoves에 따라 grade를 부여
      String result;//현재 결과 - 다 맞추었는지 아직 완성이 덜되었는지를 저장해두는 문자열.
      
```


```

public class GameHelper{
//조각을 섞고, 사용자의 입력을 받아서, 그림이 완성되면 finishgame()을 호출.

  int level;
  int lev = helper.getUserInput("레벨 입력");
  public void shuffle(){
 }//조각 섞는 메쏘드 - api에 있음.

  public void getLevel(){
    return level;
  } 
  
  public void setLevel(int lev){
    level = helper.lev;
  }


public String checkYourself(){
//check한다    

return result;

}
}//end of GameHelper
```

```

public class PuzzleGame{

  private GameHelper helper = new GameHelper();
  private ArrayList<String> artTitleList = new ArrayList<String>();
  int level;
  
public void menu(){


//메뉴의 번호를 입력받는다.
int choice = Integer.parseInt(String [] args);

if( choice ==1){
  startGame(); // 
}else if(choice ==2 ){
  setList();
}else if(choice ==3){
  return ;
}
}//end of menu

public void setList(){
}//명화를 추가/삭제하는 게임 설정 기능을 담당한다

public void startGame(){

  public startGame(){ 
    level = hp.getLevel();
    helper.shuffle(level);
  }
  
  if(result == "Complete!"){
  finishGame();
 }//조각이 다 맞춰졌는지 확인하고 맞춰졌다면, finishGame()호출
}

public void finishGame(){

//축하메시지 출력, grade 알려주기

}


}//end of puzzle game 
```