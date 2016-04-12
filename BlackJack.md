# Introduction #

BlackJack 게임입니다.

# Download #
http://code.google.com/p/comp166-koreauniv/downloads/detail?name=BlackJack.zip&can=2&q=#makechanges

# Details #

**컴퓨터와 블랙잭 게임을 합니다.
처음 주어진 돈이 다 떨어지면 지고, 컴퓨터의 돈을 모두 따면 승리합니다.**

**블랙잭 규칙**

1.컴퓨터가 딜러를 하고 플레이어는 컴퓨터와 대결한다

2.플레이어는 처음에 카드를 두장 받고 그 다음엔 딜러가 두장을 받는다

3.플레이어의 카드는 공개되나 딜러의 카드는 두장 중 한장만 공개하고 진행한다

4.카드를 더받을지 아니면 여기서 끝낼지를 결정한다

카드를 더받을경우 히트 라고 한다.

카드를 그만 받고 넘어가고자 할경우 스테이라고한다

5.그렇게 딜러와 숫자를 비교해서 21에 더가까운 사람이 승리

**단 21을 넘으면 버스트라 하여 무조건 진다 실격 물론 딜러도 버스트는 적용된다**


카드는 그림카드와 10은 모조리 10으로 취급하며(J,Q,K이 세가지)

에이스는 1또는 11로 계산된다

예를들어 10에서 에이스를 받으면 11로 계산해서 21이지만
18에서 에이스를 받으면 1로 계산되어 19가 된다

하지만 귀찮아서 J, Q, K는 소멸시키고 에이스는 무조건 1이다
족보는 21에 가까울수록 강하다.

베팅은 없이 이기면 돈을따고 지면 돈을 잃는것으로 한다.

**사실 더 다양한 규칙들이 많지만 제가 가지고 있는 지식으로는 모두 구현하기 어렵기 때문에 생략합니다.**


# 출처 #
어레이를 임의로 섞는부분은 인터넷에서 구했고
http://blog.naver.com/eohyun?Redirect=Log&logNo=110135801822
임의로 섞은것을 미리 플레이어에게 나눠주고 나중에 하나씩 보여주는것은 김근영님의 아이디어 입니다.
시간을 지연시켜서 텍스트를 출력시키는 것도 인터넷에서 구했습니다.
http://www.plusblog.co.kr/874
기타 등등은 '헤드퍼스트 자바'와 '난 정말 자바를 공부한적이 없다구요'를 참조했습니다.

# Code #

```
import java.util.Scanner;

public class BlackJack 
{
	public static void main(String[] args)
	{

		Gamemaster gm = new Gamemaster();
		System.out.println("블랙잭 게임에 오신것을 환영합니다!!");
		
		 try {
		      Thread.sleep(1000);
		      System.out.println("시작하기 =1, 종료하기 =2");
		     } catch(Exception ee) {}
		 try {
		      Thread.sleep(1000);
		      System.out.println("뭐 할꺼에요?");
		     } catch(Exception ee) {}
		 
		 int num = 0, z=1;
	
		 while(z==1)
		 {
			 Scanner sc = new Scanner(System.in);
			 num = sc.nextInt();
			 
			 if(num==1)
			 {		
				 gm.start();
				 break;
			 }
			 else if(num==2)
			 { 
				 System.out.println("끝!");
				 break;
			 }
			 else
			 {
				 System.out.println("잘못 입력하셨습니다! 다시 입력해주세요!");
				 continue;
			 }
		 }

	}
}

```

```

public class Gamemaster 
{
	CardAdmin ca = new CardAdmin();
	Player p1 = new Player();
	Game g = new Game();
	public void start()
	{
		System.out.println("시작하기를 선택하셨습니다!!");
		 try {
		      Thread.sleep(1000);
		      System.out.println("게임을 시작하겠습니다");
		      
		     } catch(Exception ee) {}
		 
		 
		ca.makecard();	
		ca.mixcard(ca.c1);
		p1.receivecard(ca.c1);
		g.real(p1);
	}

}

```

```

import java.util.ArrayList;

public class Player extends CardAdmin
{
	ArrayList<Card> you = new ArrayList<Card>();
	ArrayList<Card> com = new ArrayList<Card>();
	
	
	//Card i = new Card();
	
	void receivecard(ArrayList<Card> c1)
	{
		for(int n = 0 ; n < 10 ; n++)
		{
			you.add(c1.get(n));
			com.add(c1.get(n+10));
		}

		/*플레이어에게 카드가 잘 들어갔는지 확인
		for(int i=0; i<10; i++)
		{
			System.out.println(c2.get(i).shape);
			System.out.println(c2.get(i).cardnum);
		}
		*/
	}
}

```

```

import java.util.ArrayList;
import java.util.Collections;

public class CardAdmin 
{
		ArrayList<Card> c1 = new ArrayList<Card>();
	int i;
	void makecard()
	{
	
		 try {
		      Thread.sleep(1000);
		      System.out.println("카드를 만드는 중입니다!!");
		     } catch(Exception ee) {}
		for( i=0; i<40;i++)
		{
			final Card c;
			if(i<10)
			{
				c = new Card(i+1,"Spade");
				c1.add(c);
			}else if((i<20)&&(i>9)){
				c = new Card(i-9,"Clover");
				c1.add(c);
			}else if((i<30)&&(i>19)){
				c = new Card(i-19,"Heart");
				c1.add(c);
			}else{
				c = new Card(i-29,"Diamond");
				c1.add(c);
			}
			
		}

		/*for(int i=0; i<40; i++)
		{
			System.out.println(c1.get(i).shape);
			System.out.println(c1.get(i).cardnum);
		}*/
		
		 try {
		      Thread.sleep(500);
		      System.out.println("카드 생성 완료!");
		     } catch(Exception ee) {}
	}	
		void mixcard(ArrayList<Card> c1)
	{
		Collections.shuffle(c1);
		Collections.shuffle(c1);
		Collections.shuffle(c1);
		 try {
		      Thread.sleep(500);
		      System.out.println("카드 섞기 완료!");	
		     } catch(Exception ee) {}
		/*for(int i=0; i<40; i++)
		{
			System.out.println(c1.get(i).shape);
			System.out.println(c1.get(i).cardnum);
		}*/
	}
		
		void whoiswinner(int player, int com)
		{
			 try {
			      Thread.sleep(1000);
			      System.out.println("당신의 숫자 합 = "+ player);
			     } catch(Exception ee) {}
			 try {
			      Thread.sleep(1000);
			      System.out.println("컴퓨터의 숫자 합 = "+ com);
			     } catch(Exception ee) {}
			if((player<22)&&(com<22))
			{
				if(player == com)
				{
					 try {
					      Thread.sleep(1000);
					      System.out.println("비겼습니다!!");
					     } catch(Exception ee) {}
				}else if(player>com)
				{
					 try {
					      Thread.sleep(1000);
					      System.out.println("당신이 승리하였습니다!!올ㅋ");
					     } catch(Exception ee) {}
				}else{
					 try {
					      Thread.sleep(1000);
					      System.out.println("당신이 패배하였습니다ㅉㅉ!!");
					     } catch(Exception ee) {}
				}
				
			}else if((player>21)&&(com<22))
			{
				 try {
				      Thread.sleep(1000);
				      System.out.println("당신이 패배하였습니다ㅉㅉ!! 님 눈깔 리신");
				     } catch(Exception ee) {}
			}else if((player<22)&&(com>21))
			{
				try {
				      Thread.sleep(1000);
				      System.out.println("당신이 승리하였습니다!!올ㅋ");
				     } catch(Exception ee) {}
			}else
				try {
				      Thread.sleep(1000);
				      System.out.println("비겼습니다!! 둘다 찌질이 ㅋ");
				     } catch(Exception ee) {}
			
			 try {
			      Thread.sleep(1000);
			      System.out.println("게임이 끝났습니다 수고염");
			     } catch(Exception ee) {}
		}
		

}

```

```

public class Card 
{
	
	int cardnum;
	String shape;

	Card(){}
	/*Card(String num)
	{
		this.cardnum = num;
	}
	Card(String shape)
	{
		this.shape = shape;
	}*/
	Card(int num, String shape)
	{
		this.cardnum = num;
		this.shape = shape;
	}
}

```

```

import java.util.Scanner;

public class Game extends Player
{
	int sumCom,sumYou;
	void real(Player p)
	{
		
		 try {
		      Thread.sleep(1000);
		      System.out.println("카드 2장을 받았습니다");
		     } catch(Exception ee) {}
		 try {
		      Thread.sleep(1000);
		      System.out.println("당신의 첫번째 카드 = "+ p.you.get(0).shape +" "+ p.you.get(0).cardnum);

		     } catch(Exception ee) {}
		 try {
		      Thread.sleep(1000);
		      System.out.println("당신의 두번째 카드 = "+ p.you.get(1).shape +" "+ p.you.get(1).cardnum);

		      sumYou = p.you.get(0).cardnum + p.you.get(1).cardnum;
		      sumCom = p.com.get(0).cardnum + p.com.get(1).cardnum;
		     } catch(Exception ee) {}
		 try {
		      Thread.sleep(1000);
		      System.out.println("컴퓨터의 첫번째 카드가 공개됩니다");

		     } catch(Exception ee) {}
		 try {
		      Thread.sleep(1000);
		      System.out.println("컴퓨터의 첫번째 카드 = "+ p.com.get(0).shape +" "+ p.com.get(0).cardnum);

		     } catch(Exception ee) {}
		 try {
		      Thread.sleep(1000);
		      System.out.println("카드를 더 받으시려면(HIT) 1, 그만 받으시려면 2(STAY)를 눌러주세요");
		     } catch(Exception ee) {}
		 
		 int num = 0, z=1;
		 
		 while(z==1)
		 {
			 Scanner sc = new Scanner(System.in);
			 num = sc.nextInt();
			 
			 if(num==2)
			 {	
				 try {
				      Thread.sleep(1000);
				      System.out.println("그만받기(STAY)를 선택하셨습니다");

				     } catch(Exception ee) {}
				 try {
				      Thread.sleep(1000);
				      System.out.println("컴퓨터의 두번째 카드 = "+ p.com.get(1).shape +" "+ p.com.get(1).cardnum);

				     } catch(Exception ee) {}
				 
				whoiswinner(sumYou, sumCom);	
			
			 }
			 else if(num==1)
			 { 
				 try {
				      Thread.sleep(1000);
				      System.out.println("더 받기(HIT)를 선택하셨습니다");
				     } catch(Exception ee) {}
				 try {
				      Thread.sleep(1000);
				      System.out.println("당신의 세번째 카드 = "+ p.you.get(2).shape +" "+ p.you.get(2).cardnum);

				      sumYou = p.you.get(0).cardnum + p.you.get(1).cardnum + p.you.get(2).cardnum;
				      sumCom = p.com.get(0).cardnum + p.com.get(1).cardnum + p.com.get(2).cardnum;
				     } catch(Exception ee) {}
				 try {
				      Thread.sleep(1000);
				      System.out.println("카드를 더 받으시려면(HIT) 1, 그만 받으시려면 2(STAY)를 눌러주세요");
				     } catch(Exception ee) {}
				 
				 num = 0; z=1;
				 
				 while(z==1)
				 {
					 Scanner sc2 = new Scanner(System.in);
					 num = sc2.nextInt();
					 
					 if(num==2)
					 {	
						 try {
						      Thread.sleep(1000);
						      System.out.println("그만받기(STAY)를 선택하셨습니다");

						     } catch(Exception ee) {}
						 try {
						      Thread.sleep(1000);
						      System.out.println("컴퓨터의 세번째 카드 = "+ p.com.get(2).shape +" "+ p.com.get(2).cardnum);

						     } catch(Exception ee) {}
						 
						whoiswinner(sumYou, sumCom);	
					
					 }
					 else if(num==1)
					 { 
						 try {
						      Thread.sleep(1000);
						      System.out.println("더 받기(HIT)를 선택하셨습니다");
						     } catch(Exception ee) {}
						 try {
						      Thread.sleep(1000);
						      System.out.println("당신의 네번째 카드 = "+ p.you.get(3).shape +" "+ p.you.get(3).cardnum);

						      sumYou = p.you.get(0).cardnum + p.you.get(1).cardnum + p.you.get(2).cardnum + p.you.get(3).cardnum;
						      sumCom = p.com.get(0).cardnum + p.com.get(1).cardnum + p.com.get(2).cardnum + p.com.get(3).cardnum;
						     } catch(Exception ee) {}
						 try {
						      Thread.sleep(1000);
						      System.out.println("결과를 확인하겠습니다");
						     } catch(Exception ee) {}
						 try {
						      Thread.sleep(1000);
						      System.out.println("컴퓨터의 네번째 카드 = "+ p.com.get(3).shape +" "+ p.com.get(3).cardnum);

						     } catch(Exception ee) {}
						 
						whoiswinner(sumYou, sumCom);	
					
					 }
					 else
					 {
						 System.out.println("잘못 입력하셨습니다! 다시 입력해주세요!");
						 continue;
					 }
			
				 }
			 }else
			 {
				 System.out.println("잘못 입력하셨습니다! 다시 입력해주세요!");
				 continue;
			 }
		 }
	}
}


```