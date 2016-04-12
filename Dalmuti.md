# Introduction #

본격 달무티게임


# Details #

**달무티를 할 수 있도록 도와주는 게임입니다**

**달무티란 1~12까지의 숫자가 적힌 카드가 있고 조커와 1은 1장 2는 2장 3은 3장...12는 12장이 있는 게임입니다.
이를 플레이어들이 나누어 가지고 게임을 시작합니다.
게임의 룰은 간단합니다. 예를 들어 한 사람이 7을 5장을 냈다고 하면 그 다음 차례의 사람은 7보다 낮은 숫자 즉 6이하의 숫자의 카드를 먼저 낸 사람과 같은장수, 여기서는 5장을 내면 되는 것입니다. 이렇게 카드를 내려놓다가 제일 먼저 카드를 다 내려놓은 사람이 왕이 되고 제일 늦게까지 남은 사람은 노예가 되는 게임입니다.**


**컴교에도 달무티가 존재했으니 그것은 바로**

![http://comp166-koreauniv.googlecode.com/files/Comuti.jpg](http://comp166-koreauniv.googlecode.com/files/Comuti.jpg)



/**클래스 이름이나 상속 등이 계속 바뀌기 때문이 바뀌는 대로 업로드할 예정입니다.**/

1.카드를 표시하는 클래스

```
class Card//카드입니다.
{
        private int cardNum;//카드의 번호입니다
        private int numOfCur = 0;//카드의 장수입니다
        private boolean pass;//플레이어가 PASS를 선언했는지 확인하는 변수입니다
        
        Card()//생성자입니다.
        {
        }
        Card(int cardNum)//생성자 오버로딩
        {
                        this.cardNum = cardNum;//카드의 번호 세팅
        }
        public void setCardNum(int cardNum)//set메소드입니다
        {
                this.cardNum = cardNum;//카드의 번호 세팅
        }
        public int getCardNum()//카드의 번호를 얻는 get메소드
        {
                return cardNum;//카드의 번호 리턴
        }
        
        void setNumOfCur(int n)//카드의 장수를 세팅하는 set메소드
        {
                numOfCur = n;//카드의 장수 세팅
        }
        
        int getNumOfCur()//카드의 장수를 얻는 get메소드
        {
                return numOfCur;//카드의 장수 리턴
        }
        
        void setPass(boolean a)//pass변수를 세팅하는 set메소드
        {
                pass = a;//pass의 참 거짓값을 설정
        }
        
        boolean getPass()//pass변수를 리턴하는 get메소드
        {
                return pass;//pass를 리턴
        }
        
}

```

2. 달무티게임을 실행하는 클래스

```

import java.util.*;

public class Dalmuti //달무티!
{

        
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);
        Player p4 = new Player(4);

        ArrayList<Player> rank = new ArrayList<Player>();//플레이어 순위대로 집어넣는 Arraylist입니다. 기말고사 이후 업뎃
        
        //Player 객체를 생성합니다.
        
        GameHelper help = new GameHelper();//GameHelper 객체를 생성합니다.
        
        void startGame()//게임을 진행하는 메소드입니다.
        {

                while(isPlayer(p1,p2,p3,p4))//반복합니다.
                {
                        Turn();              	
                }
                
                System.out.println("---===The End===---");//게임이 끝남을 알리는 출력문
                
                for(int i = 1; i < 5 ; i++)//순위를 출력해줘요.기말고사 이후 구현
                {
                	System.out.println(i+"등 : Player"+ rank.get(i-1).getMyName());
                }
                
        }
                
        void Turn()//플레이어들의 턴을  수행하는 메소드입니다.
        {
                Card tmp;//카드 객체를 생성합니다.
                        
                if(check(p1))//p1이 있다면
                {
                        try
                        {
                                p1.printMyCard("Player1");//카드를 출력해주고
                                tmp = help.getUserInput();//사용자입력을 받습니다.
                                
                                if((!(help.last.getPass()))&& (tmp.getNumOfCur()!= 0) && (p1.canIPut(tmp , tmp.getNumOfCur())))//바로 전 사용자가 PASS하지 않고, 바닥에 카드가 내려져 있는 상황이고 플레이어가 카드를 내려놓을 수 있으면
                                        p1.putDownCard(tmp,tmp.getNumOfCur());//카드를 내려놓습니다.
                                
                                if(!check(p1))//플레이어가 카드를 모두 내려놓았다면
                                        {
                                                p1.theEnd(1);//출력해주고
                                                help.playerNum--;//플레이어 수를 하나 감소시킵니다.
                                                rank.add(p1);
                                        }
                                else//나머지
                                        p1.arrangeMyCard();//카드를 정렬해줍니다.

                        }
                        catch(CardException e)//CardException을 잡습니다.
                        {
                                System.out.println(e.getMessage());//출력하고
                                System.exit(0);//시스템 종료
                        }
                        catch(InputException e)//InputException을 잡습니다.
                        {
                                System.out.println(e.getMessage());//출력하고
                                System.exit(0);//시스템종료
                        }
                }
                
                /* p2, p3 ,p4 도 모두 p1과 같은 내용입니다.*/
                if(check(p2))
                {
                        try
                        {
                                p2.printMyCard("Player2");
                                tmp = help.getUserInput();
                                
                                if((!(help.last.getPass()))&& (tmp.getNumOfCur()!= 0) && (p2.canIPut(tmp, tmp.getNumOfCur())))
                                        p2.putDownCard(tmp,tmp.getNumOfCur());
                        
                                if(!check(p2))
                                        {
                                                p2.theEnd(2);
                                                help.playerNum--;
                                                rank.add(p2);
                                        }
                                else
                                        p2.arrangeMyCard();

                        }
                        catch(CardException e)
                        {
                                System.out.println(e.getMessage());
                                System.exit(0);
                        }
                        catch(InputException e)
                        {
                                System.out.println(e.getMessage());
                                System.exit(0);
                        }
                }
                
                if(check(p3))
                {
                        try
                        {       
                                p3.printMyCard("Player3");
                                tmp = help.getUserInput();
                        
                                if((!(help.last.getPass()))&& (tmp.getNumOfCur()!= 0) && (p3.canIPut(tmp, tmp.getNumOfCur())))
                                        p3.putDownCard(tmp,tmp.getNumOfCur());
                                
                        
                                if(!check(p3))
                                        {
                                                p3.theEnd(3);
                                                help.playerNum--;
                                                rank.add(p3);
                                        }
                                else
                                        p3.arrangeMyCard();

                        }
                        catch(CardException e)
                        {
                                System.out.println(e.getMessage());
                                System.exit(0);
                        }
                        catch(InputException e)
                        {
                                System.out.println(e.getMessage());
                                System.exit(0);
                        }
                }

                if(check(p4))
                {
                        try
                        {
                                p4.printMyCard("Player4");
                                tmp = help.getUserInput();
                
                                if((!(help.last.getPass()))&& (tmp.getNumOfCur()!= 0 )&& (p4.canIPut(tmp, tmp.getNumOfCur())))
                                        p4.putDownCard(tmp,tmp.getNumOfCur());
                                
                                if(!check(p4))
                                        {
                                                p4.theEnd(4);
                                                help.playerNum--;
                                                rank.add(p4);
                                        }
                                else
                                        p4.arrangeMyCard();

                        }
                        catch(CardException e)
                        {
                                System.out.println(e.getMessage());
                                System.exit(0);
                        }
                        catch(InputException e)
                        {
                                System.out.println(e.getMessage());
                                System.exit(0);
                        }
                }
                
        }
        
        
        boolean isPlayer(Player p1,Player p2,Player p3,Player p4)//게임을 하는 플레이어가 있는지 확인하는 메소드
        {
                if(p1.myList.isEmpty()&&p2.myList.isEmpty()&&p3.myList.isEmpty()&&p4.myList.isEmpty())//모두 게임을 마쳤다면 
                        return false;//false 리턴
                
                return true;//아니면 true 리턴
        }
        
        boolean check(Player p)//플레이어가 카드를 모두 내려놓았는지 확인하는 메소드
        {
                if(p.myList.isEmpty())//다 내려놓았다면
                {
                        return false;//false를 리턴합니다.
                }
                return true;//아니면 true
        }

        public static void main(String[] args)//main 메소드입니다.
        {
        		new Screen();

        }
}

@SuppressWarnings("serial")
class InputException extends Exception//InputException을 정의한 클래스
{
        InputException(String s)
        {
                super(s);
        }
}

@SuppressWarnings("serial")
class CardException extends Exception//CardException을 정의한 클래스
{
        CardException(String s)
        {
                super(s);
        }
}

```

3.사용자 입력을 받고 게임 진행을 도와주는 게임헬퍼 클래스

```

import java.util.*;

public class GameHelper//게임을 도와주는 클래스
{
        int passCnt = 0;//플레이어들이 PASS한 횟수를 세기 위한 변수
        int playerNum = 4;//플레이어 숫자
        Card last = new Card();//마지막으로 내려놓은 카드
        private Scanner keyboard = new Scanner(System.in);//사용자 입력을 받기 위한 변수
        int numOfPutCard;//내려놓으려고 하는 카드의 장수
        Card input = new Card();//사용자 입력을 저장하는 Card    
        
        Card getUserInput() throws InputException//첫번째 Player의 입력을 받는 메소드입니다. 리턴타입은 Card 이고, InputException 예외를 던집니다.
        {
                if(last.getCardNum() != 0)//마지막에 내려놓은 카드의 숫자가 0이 아니면
                {
                        System.out.print(last.getCardNum()+"보다 작은 숫자를 가진 카드를 ");
                        System.out.println(last.getNumOfCur()+"장 만큼 내려놓을 수 있습니다.");
                }
                else//0이면
                {
                        System.out.println("아무 카드나 내려놓으실 수 있습니다.");
                        System.out.println("내려 놓고자 하는 카드 번호, 카드의 장 수를 입력하세요");
                }
                
                System.out.println("턴을 넘기려면 0을 입력해주세요.");
                int i = keyboard.nextInt();//사용자 입력을 받습니다.
                int j;//numOfPutCard 를 초기화하는데 쓰이는 변수
                if(i == 0)//사용자 입력이 0이라면
                {
                        passAll();//pass하고
                        last.setPass(true);//사용자가 pass했다고 설정해줍니다.
                        return last;//last를 리턴합니다.
                }

                else if((last.getCardNum()) == 0 && i > 0 && i < 13)//사용자 입력이 0이 아니고 마지막으로 내려놓은 카드의 숫자가 0이면
                {

                        if(i < 1)//만약 1보다 작은 값을 입력하면
                        {
                                throw new InputException("잘못된 카드 번호입니다.");//예외를 던집니다.
                        }
                        else
                        {
                                j = keyboard.nextInt();//카드의 장수를 입력 받습니다
                                if(j <= 0)//0장 이하의 카드를 입력하면
                                {
                                        throw new InputException(j + " 장의 카드를 내려놓을 수 없습니다.");//예외를 던집니다.
                                }
                                else//정상적이면
                                {
                                        input.setCardNum(i);//카드 숫자 설정
                                        numOfPutCard = j;//카드 장수 설정
                                }
                        }
                        
                        if(input.getCardNum() < numOfPutCard)//예를들어 4숫자의 카드를 5장 이상 내려고하면
                        {
                                throw new InputException(input.getCardNum()+" 카드는 "+numOfPutCard+"장 이상 존재하지 않습니다.");//예외를 던집니다.
                        }
                        
                        last.setCardNum(input.getCardNum());//마지막으로 내려놓은 카드의 번호 설정
                        last.setNumOfCur(numOfPutCard);//마지막으로 내려놓은 카드의 장수 설정
                        passCnt = 0;//사용자가 pass하지 않았으므로 0으로 초기화해줍니다.
                        last.setPass(false);//pass를 하지 않았으므로 false로 설정
                        return last;//last를 리턴합니다.
                }
                else if(last.getCardNum() != 0 && i > 0 && i < 13)//마지막에 내려놓은 카드가 0이 아니면
                {
                        if(i < 1)//1보다 작은 값이면
                        {
                                throw new InputException("잘못된 카드 번호입니다.");//예외를 던집니다.
                        }
                        else
                        {
                                j = keyboard.nextInt();//입력을 받습니다.
                                if(j <= 0)//0장 이하의 카드를 내려놓으려고 하면
                                {
                                        throw new InputException(j + " 장의 카드를 내려놓을 수 없습니다.");//예외를 던집니다.
                                }
                                else//나머지는
                                {
                                        input.setCardNum(i);//카드 숫자 설정
                                        numOfPutCard = j;//카드 장수 설정
                                }
                        }
                        
                        if(input.getCardNum() >= last.getCardNum())//마지막에 내려놓은 카드 숫자보다 높거나 같은 숫자의 카드를 내려놓으려고 할 경우
                        {
	                             throw new InputException("카드 숫자가 높거나 같게는 내려놓을 수 없습니다.");
                        }
                        else if(input.getCardNum() < numOfPutCard)//ex> 4장의 카드를 5장이상 내려고 하는 경우
                        {
                                throw new InputException(input.getCardNum()+" 카드는 "+numOfPutCard+"장 이상 존재하지 않습니다.");
                        }
                        
                        last.setCardNum(input.getCardNum());//마지막 카드 숫자 설정
                        last.setNumOfCur(numOfPutCard);//마지막 카드 장수 설정
                        passCnt = 0;//pass하지 않았으므로 0으로 초기화
                        last.setPass(false);//pass하지 않았으므로 false로 설정
                        return last;//last 리턴
                }
                else//나머지의 경우
                {
                        throw new InputException("숫자를 잘못 입력하셨습니다.");
                }

                
        }
      
        void passAll()//pass메소드입니다
        {
        		if(playerNum == 1)//한명만 남으면 계속 내려놓아도되요
        			reset();
        	
                passCnt++;//pass한 횟수를 하나 증가시킵니다.
                if(passCnt == (playerNum - 1))//한 턴 동안 아무도 카드를 내지 않았을 경우
                {
                        System.out.println("모두 PASS했습니다.");
                        System.out.println("아무도 내려놓지 않았으므로 마음대로 카드를 내려놓을 수 있습니다.");
                        reset();//lastCard 초기화
                        passCnt = 0;//pass한 횟수를 0으로 초기화
                }
        }
        
        void reset()//마지막으로 내려놓은 카드를 초기화하는 메소드
        {
                last.setCardNum(0);//숫자를 0으로
                last.setNumOfCur(0);//장수를 0으로
        }
}

```

4.전지전능하신 GameHelper와 Player이 있는 클래스
```

import java.util.*;

class GameMaster//Player들에게 임의로 생성된 카드 덱을 섞어서 나눠주는 클래스입니다
{
        static ArrayList<Card> arrangeList = new ArrayList<Card>();//Card 객체가 들어갈 수 있는 ArrayList선언
        Card c;//Card 객체 생성
        
        protected final void arrangeCard()//카드덱을 만드는 메소드입니다. 오버라이딩이 불가능하도록 final로 선언해줍니다
        {
                for(int i = 0 ; i <12 ; i++)
                {
                        for(int j = 0 ; j < 12 ; j++)
                        {
                                c = new Card(i+1);//i+1의 번호를 가지는 카드 객체를 만듭니다.
                                arrangeList.add(c);//arrayList에 넣습니다.
                                if(i == j)//만약에 카드의 번호와 카드의 장수가 같으면
                                        break;//반복문을 빠져나갑니다.
                        
                        }
                }
        }
        
        protected final void cardMix(ArrayList<Card> c)//카드를 섞어주는 메소드입니다. 역시 오버라이딩이 불가능하도록 final로 선언했습니다.
        {
                Collections.shuffle(c);//카드를 섞어줍니다(자바 API를 참조했습니다.)
        }
}

class Player extends GameMaster//Player은 GameMaster을 확장합니다.
{
        ArrayList<Card> myList = new ArrayList<Card>();//플레이어가 가지는 카드 덱입니다.
        private int myName;//플레이어의 이름을 저장해 줄 int 형 변수 (게임이 끝나고 순위를 출력해 줄 때 사용합니다) 기말고사 이후 업데이트.
        
        public Player(int n)
        {
        		myName = n;//이름 설정
        	
        		switch(n)
                {
                        case 1: for(int i = 0 ; i < 19 ; i++)
                                myList.add(arrangeList.get(i)); break;
                        case 2: for(int i = 19 ; i < 39 ; i++)
                                myList.add(arrangeList.get(i)); break;
                        case 3: for(int i = 39 ; i < 58 ; i++)
                                myList.add(arrangeList.get(i)); break;
                        case 4: for(int i = 58 ; i < 78 ; i++)
                                myList.add(arrangeList.get(i)); break;
                }
                //일정한 카드숫자씩 arrangeList에서부터 나눠가집니다.
                //제 아이디업니다!!

                arrangeMyCard();//사용자가 보기 편하도록 카드를 오름차순으로 정렬해줍니다.
        }
        void putDownCard(Card a,int n)//카드를 내려놓는 메소드입니다.
        {
                for(int cnt = 0 ; cnt < n ; )   //n장과 같아질 때까지
                        for(int j = 0 ; j < myList.size(); j++)//myList의 사이즈 까지
                        {
                                if(myList.get(j).getCardNum() == a.getCardNum())//만약에 입력값으로 받은 카드가 myList안에 있다면
                                {       
                                        myList.remove(j);//그 카드 객체를 제거하고
                                        cnt++;//카운트 개수를 하나 늘려줍니다.
                                        break;//반복문을 빠져나갑니다.
                                }
                        }
                
                System.out.println("카드를 내려 놓았습니다.");//출력문입니다.
        }
        
        void theEnd(int n)//플레이어가 카드를 다 내려놓았음을 알리는 메소드입니다.
        {
                System.out.print("\n\n---===Player"+n+" 가 카드를 모두 내려놓았습니다.===---\n\n");

        }

        void arrangeMyCard()//내 카드 리스트들을 오름차순으로 보기 편하게 정리해줍니다.
        {
                for(int i = 0 ; i < myList.size() ;i ++)
                        for(int j = (myList.size())-1 ; j > 0 ; j--)
                        {
                                if(myList.get(j).getCardNum() < myList.get(j-1).getCardNum())
                                        Collections.swap(myList,j,j-1);//자바API를 참조했습니다.
                        }
        }
        
        void printMyCard(String c)//플레이어의 카드를 출력해주는 메소드입니다.
        {
                System.out.println(c+"의 차례입니다.");
                System.out.println(c+"가 가지고 있는 카드입니다.");
                for (Card i : myList)
                {
                        System.out.print(i.getCardNum()+" ");
                }
                        System.out.print("\n\n");
        }
        
        boolean canIPut(Card c,int n) throws CardException//플레이어가 카드를 내려놓을 수 있는지 확인해주는 메소드입니다. CardException 예외를 던집니다.
        {

                        int cnt = 0;//세기 위한 변수 선언
                        for(Card tmp : myList)
                        {
                                if(tmp.getCardNum()== c.getCardNum())
                                        {
                                                cnt++;
                                        }
                        }

                        if(cnt >= n)//내려놓고자 하는 카드보다 자기가 가지고 있는 카드가 많다면
                        {
                                return true;//참을 리턴합니다.
                        }
                        else if(cnt < n && cnt > 0 )//내려놓고자 하는 카드 수보다 자기가 가진 카드 수가 작다면
                        {
                                throw new CardException("가지고 있는 카드 수가 적으므로 내려놓을 수 없습니다.");//예외를 던집니다
                        }
                        else//자기가 가지고 있지 않은 카드를 사용하려 하면
                        {
                                throw new CardException("가지고 있지 않은 카드를 사용하려합니다.");//예외를 던집니다
                        }
                
        }
        
        int getMyName()//플레이어 이름을 리턴해줍니다.기말고사 이후 구현
        {
        	return myName;
        }
        
}

```

5.풀 텍스트 버전은 허전해서 조그마한 GUI창을 하나 구현한다!Screen 클래스

```

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*Screen 클래스는 기말고사 이후에 구현한 클래스입니다.
 * 모두다 GUI를 사용하기에 무늬만이라도 GUI를 사용한 훼이크 GUI 버전 달무티!
 */
public class Screen
{
	private JFrame frame;//프레임을 만듭니다.
	private JButton button;//버튼을 만듭니다.
	
	
	class buttonAction implements ActionListener//inner 클래스입니다.
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == button)//버튼을 클릭하면
			{
				frame.dispose();//창을 닫고
				
				GameMaster g = new GameMaster();//GameMaster 객체를 생성하고
                g.arrangeCard();//카드덱을 만들고
                g.cardMix(g.arrangeList);//카드덱을 섞습니다.
                
                Dalmuti d = new Dalmuti();//Dalmuti 객체를 만들고
                d.startGame();//게임을 실행합니다.
			}
			
		}

	}

	Screen()
	{
		frame = new JFrame();//프레임 생성
		frame.setTitle("Dalmuti Game!");//타이틀을 입력합니다.
		frame.setBounds(100, 100, 450, 300);//경계 설정
		frame.setResizable(false);//사이즈를 조절하지 못하게 합니다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료 버튼 클릭 시 종료
		frame.setVisible(true);//프레임이 보이게 합니다.
		
		button = new JButton("Game Start!");//버튼을 생성하고 자막을 넣습니다.
		button.setFont(new Font("Rockwell", Font.BOLD, 27));//폰트를 설정합니다.
		button.addActionListener(new buttonAction());//ActionLister을 추가해줍니다.
		frame.getContentPane().add(button, BorderLayout.CENTER);//버튼을 프레임에 추가
		
		JPanel panel = new JPanel();//판넬 생성
		FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();//FlowLayout적용
		flowLayout_3.setVgap(40);//수직 방향 간격을 조정
		panel.setBackground(Color.cyan);//배경색 설정
		frame.getContentPane().add(panel, BorderLayout.NORTH);//북쪽에 판넬을 추가
		
		JPanel panel_1 = new JPanel();//판넬 생성
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();//FlowLayout적용
		flowLayout_1.setHgap(40);//수평 방향 간격을 조정
		panel_1.setBackground(Color.cyan);//배경색 설정
		frame.getContentPane().add(panel_1, BorderLayout.WEST);//서쪽에 판넬을 추가
		
		JPanel panel_2 = new JPanel();//판넬 생성
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();//FlowLayout적용
		flowLayout_2.setVgap(50);//수직 방향 간격을 조정
		panel_2.setBackground(Color.cyan);//배경색 설정
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);//남쪽에 판엘을 추가
		
		JPanel panel_3 = new JPanel();//판넬 생성
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();//FlowLayout적용
		flowLayout.setHgap(40);//수평 방향 간격을 설정
		panel_3.setBackground(Color.cyan);//배경색 설정
		frame.getContentPane().add(panel_3, BorderLayout.EAST);//동쪽에 판넬을 추가
	}
	
	
}

```


# 스크린샷 #

**시작 화면 입니다.
http://comp166-koreauniv.googlecode.com/files/Dal1.JPG**

**게임 진행 화면입니다.
http://comp166-koreauniv.googlecode.com/files/Dal2.JPG**

**음수 장수의 카드를 내려놓을 때
http://comp166-koreauniv.googlecode.com/files/Dal3.JPG**

**이상한 숫자의 카드를 내려놓을 때
http://comp166-koreauniv.googlecode.com/files/Dal4.JPG**

**모든 카드 장수를 합친 그 숫자의 카드보다 많이 내려놓을 때
http://comp166-koreauniv.googlecode.com/files/Dal5.JPG**

**가지고 있는 장수보다 많은 수의 카드를 사용하려 할 때
http://comp166-koreauniv.googlecode.com/files/Dal6.JPG**

**게임 끝날 때 화면
http://comp166-koreauniv.googlecode.com/files/Dal7_1.JPG**


# 참고 #

자바 API 문서를 참조했습니다. Collection.shffle, Collection.swap 이나 dispose 같은 것들은

http://xrath.com/javase/ko/6/docs/ko/api/index.html?overview-summary.html


# DOWNLOAD #

http://comp166-koreauniv.googlecode.com/files/DALMUTI.zip