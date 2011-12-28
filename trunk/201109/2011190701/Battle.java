import java.io.IOException;
import java.util.Scanner;
public class Battle	extends GamePlay{
	
	Player player = new Player(Level, Selection);
	Enemy enemy = new Enemy(Stage, Difficulty);
	
	public static int Stage = 1;
	public int Behavior;
	public int turn = 0;
	public int hp1 = Player.HP_p;
	public int hp2 = Enemy.HP_e;
	public int C1 = Player.Cards_p;
	public int C2 = Enemy.Cards_e;
	public int A1 = Player.ATK_p;
	public int A2 = Enemy.ATK_e;
	public int D1 = Player.DEF_p;
	public int D2 = Enemy.DEF_e;
	public int E1 = Player.EVA_p;
	public int E2 = Enemy.EVA_e;
	public String S1[] = Player.Spells_p;
	public String S2[] = Enemy.Spells_e;
	Scanner sc = new Scanner(System.in);
	
	public Battle() throws IOException	{
		if(Stage == 1){
			System.out.println("환상향에서 주인, 혹은 상관을 두고 있는 존재들이 전면적으로 파업을 선언했다");
			System.out.println("이 이변은 파업이변이라 명명되고 하쿠레이 레이무는 파업한 인요들의 주인들에게 말하기를,");
			System.out.println("'니들 문제니까 나한테 말하기 말고 IYAGI라도 해서 해결하라고!!!'");
			System.out.println("그리하여 주인들은 자기 애들을 데리러(잡으러) 귀찮음을 감수하고 돌아다니게 되는데...");
		}
		System.out.println("이름 : " + Player.name_p);
		System.out.println("체력 : " + Player.HP_p);
		System.out.println("공격력 : " + Player.ATK_p);
		System.out.println("방어력 : " + Player.DEF_p);
		System.out.println("회피율 : " + Player.EVA_p);
		for(int x = 0; x < Player.Spells_p.length; x++)
			System.out.println("스펠카드 목록 : " + Player.Spells_p[x]);
		
		System.out.println(Stage);
		System.out.println(Enemy.name_e);
		System.out.println(hp2);

		System.out.println("전투 개시");
		
		while(hp1 > 0 && hp2 > 0)	{
			new Player(Level, Selection);
			new Enemy(Stage, Difficulty);
			
			D1 = Player.DEF_p;
			D2 = Enemy.DEF_e; 
			
			int Graze = (int)(Math.random() * 100) + 1;
			System.out.println(Graze);
			int CS;
			System.out.println("HP : " + hp1);
			System.out.println("스펠카드 잔량 : " + C1);
			System.out.println("남은 녹차량 : " + Player.TeaCount);
			System.out.println("적: " + Enemy.name_e);
			System.out.println("HP : " + hp2);
			System.out.println("스펠카드 갯수 : " + C2);
			if(turn % 2 == 0)	{
				System.out.println("Player Turn");
				System.out.println("행동방침을 정하십시오");
				System.out.println("1. 평타, 2. 방어, 3. 녹차, 4. 스펠");
				Behavior = sc.nextInt();
				if(Behavior == 1)	{
					if(E2 > Graze)	{
						System.out.println("공격 성공!");
						if(D2 > A1)	{
							System.out.println("적은 0 피해를 입었다!");
						}
						else	{
							System.out.println("적은 " + (A1 - D2) + " 피해를 입었다!");
							hp2 -= (A1 - D2);
						}
					}	else
						System.out.println("적이 Graze!!");
				}	else if(Behavior == 2)	{
					D1 *= 2;
				}	else if(Behavior == 3)	{
					Player.TeaCount--;
					hp1 = Player.HP_p;
				}	else if(Behavior == 4)	{
					for(int x = 0; x < 3; x++)
						System.out.println(S1[x]);
					CS = sc.nextInt();
					System.out.println("선언 " + S1[CS - 1]);
					if(CS == 0)	{
						hp2 -= (A1 * ((int)Math.random() * 2) + 1); 
					} else if(CS == 1)	{
						hp2 -= (A1 * ((int)Math.random() * 3) + 1);
					} else if(CS == 2)	{
						hp2 -= (A1 * ((int)Math.random() * 5) + 1); 
					} else if(CS == 3)	{
						hp2 -= (A1 * ((int)Math.random() * 7) + 1); 
					} else if(CS == 4)	{
						hp2 -= (A1 * ((int)Math.random() * 9) + 1); 
					}
					C1--;
				}
			}	else	{
				System.out.println("Enemy Turn");
				Behavior = (int)(Math.random() * 3) + 1;
				System.out.println(Behavior);
				if(Behavior == 1)	{
					if(E1 > Graze)	{
						if(D1 > A2)	{
							System.out.println("방어 성공!!");
						}	else	{							
							System.out.println("적의 공격이 성공하였다");
							System.out.println((A2 - D1) + " 의 피해를 입었다!");
							hp1 -= (A2 - D1);
						}
					}	else
						System.out.println("Graze!!");
				}	else if(Behavior == 2)	{
					D2 *= 2;
				}	else if(Behavior == 3 && C2 != 0)	{
					C2--;
					CS = (int)Math.random() * 3 + 1;
					System.out.println("선언 " + S2[CS]);
					if(CS == 1)	{
						hp1 -= (A2 * ((int)(Math.random() * 2) + 1)); 
					} else if(CS == 2)	{
						hp1 -= (A2 * ((int)(Math.random() * 4) + 1));
					} else if(CS == 3)	{
						hp1 -= (A2 * ((int)(Math.random() * 6) + 1)); 
					} else if(CS == 4)	{
						hp1 -= (A2 * ((int)(Math.random() * 8) + 1));
					}
				}
			}
			turn++;
		}
		if(hp1 < 0)	{
			System.out.println("Game Over");
			System.exit(0);
		}	else if(hp2 < 0 && Stage < 6)	{
			System.out.println("승리하였습니다." + Enemy.name + "의 파업을 해산시켰습니다. 다음 스테이지로 진행합니다");
			Stage++;
			Level++;
			C1++;
		}	else if(hp2 < 0 && Stage == 6)	{
			System.out.println("이변을 해결하셨습니다!!");
			System.exit(0);
		}
	}
}