# Introduction #

포켓몬에도 있는 이동모션조차 없는 단순한 게임(GUI)이었으나... GUI완성본이 바이러스먹어서 날아가는 바람에 백업된 발표당시 프로그램임

# Background #

만들고 싶은 게임의 수준에 도달하기위한 준비단계

# Details #

class GamePlay, class Player와 class Enemy, class Battle 등으로 구성

Player, Enemy 클래스 안에 스테이터스를 변수로 입력

난이도 선택 가능(적 스테이터스의 변화)
캐릭터는 성장가능

save불가

# Using the Code #
1. GameCharacter.java
```
abstract class GameCharacter	{ ///추상클래스, 선언 간소화
	public static String name_p;
	public static int HP_p;
	public static int Cards_p;
	public static int ATK_p;
	public static int DEF_p;
	public static int EVA_p;
	public static String[] Spells_p;
	public static int TeaCount = 10;
	
	public static String name_e;
	public static int HP_e;
	public static int Cards_e;
	public static int ATK_e;
	public static int DEF_e;
	public static int EVA_e;
	public static String[] Spells_e;

}
```
2. Player.java
```
public class Player extends GameCharacter {
	public Player(int Level, int Selection)	{
		if(Selection == 1)	{
			name_p = "히지리 뱌쿠렌";
			HP_p = 1000 + (300 * Level);
			Cards_p = 6;
			ATK_p = 200 + (50 * Level);
			DEF_p = 100 + (50 * Level);
			EVA_p = 10;
			Spells_p = new String[] {"길조 [극락의 보라색 구름길]","광마 [스타 마엘스트롬]","대마법 [마신복송]","비발[전설의 비공원반]","법의 세계에는 빛이 가득해"};
		}	else if(Selection == 2)	{
			name_p = "호라이산 카구야";
			HP_p = 800 + (150 * Level);
			Cards_p = 8;
			ATK_p = 160 + (40 * Level);
			DEF_p = 80 + (20 * Level);
			EVA_p = 30;
			Spells_p = new String[] {"신보 [부디스트 다이아몬드]","난제 [제비의 자안패]","신난제 [불멸하는 겨울의 검]","영야 되돌리기","달의 니트공주"};
		}	else if(Selection == 3)	{
			name_p = "시키에이키 야마자나두";
			HP_p = 900 + (200 * Level);
			Cards_p = 7;
			ATK_p = 180 + (45 * Level);
			DEF_p = 90 + (30 * Level);
			EVA_p = 20;
			Spells_p = new String[] {"죄부[방황하는 대죄]","심판 [길티 오어 낫 길티]","허언 [텅 오브 울프]","심판 [라스트 저지먼트]","낙원의 최고재판관"};
		}
	}
}
```
3. Enemy.java
```
public class Enemy extends GameCharacter {
	public Enemy(int Stage, int Difficulty)	{
		if(Stage == 1)	{
			name_e = "나즈린";
			HP_e = 300 + (100 * Difficulty);
			Cards_e = 2;
			ATK_e = 100 + (10 * Difficulty);
			DEF_e = 50 + (10 * Difficulty);
			EVA_e = 10;
			Spells_e = new String[] {"수부[레어 메탈 디텍터]","옥탑[그레이티스트 트레져}","시부[펜듈럼 가드]","물건 좀 작작 흘려"};
		}	else if(Stage == 2)	{
			name_e = "이자요이 사쿠야";
			HP_e = 500 + (200 * Difficulty);
			Cards_e = 3;
			ATK_e = 150 + (20 * Difficulty);
			DEF_e = 70 + (10 * Difficulty);
			EVA_e = 20;
			Spells_e = new String[] {"시계[루나 다이얼]","속부[루미너스 리코셰]","","이 망할 요정메이드들"};
		}	else if(Stage == 3)	{
			name_e = "콘파쿠 요유무";
			HP_e = 700 + (300 * Difficulty);
			Cards_e = 4;
			ATK_e = 200 + (30 * Difficulty);
			DEF_e = 90 + (10 * Difficulty);
			EVA_e = 30;
			Spells_e = new String[] {"인부[현세참]","인귀[미래영겁참]","단명검[명상참]","적당히 먹어라 이 잉여망령아"};
		}	else if(Stage == 4)	{
			name_e = "레이센 우동게인 이나바";
			HP_e = 900 + (400 * Difficulty);
			Cards_e = 5;
			ATK_e = 250 + (40 * Difficulty);
			DEF_e = 110 + (10 * Difficulty);
			EVA_e = 40;
			Spells_e = new String[] {"환파[적안최면]","산부[진실의 달]","월안[월토원격최면술]","난 장난감이 아니야"};
		}	else if(Stage == 5)	{
			name_e = "야쿠모 란";
			HP_e = 1100 + (500 * Difficulty);
			Cards_e = 6;
			ATK_e = 300 + (50 * Difficulty);
			DEF_e = 130 + (10 * Difficulty);
			EVA_e = 50;
			Spells_e = new String[] {"식신[첸]","식신[선호사념]","밀부[대사님의 비밀열쇠]","그만 자고 일어나라 주잉양반"};
		}	else if(Stage == 6)	{
			name_e = "야고코로 에이린";
			HP_e = 1300 + (600 * Difficulty);
			Cards_e = 7;
			ATK_e = 350 + (60 * Difficulty);
			DEF_e = 150;
			EVA_e = 60;
			Spells_e = new String[] {"신뇌[오모이카네 브레인]","천주[아폴로 13]","연단[수은의 바다]","일해라 니트!"};
		}
	}
}
```
4. Battle.java
```
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

		System.out.println("파업을 정지합니다. 어, 안되잖아?");
		
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
```
5. GamePlay.java
```
import java.util.*;
import java.io.*;
public class GamePlay	{
	public static int Level = 1;
	public static int Selection;
	public static int Difficulty;
	public GamePlay() throws IOException	{
		Scanner sc = new Scanner();
		Difficulty = sc.nextInt();
		while((Difficulty > 4) || (Difficulty < 1))	{
			System.out.println("난이도 선택");
			System.out.print("1 = Easy, 2 = Normal, 3 = Hard, 4 = Lunatic");
			if(Difficulty == 1)	{
				System.out.println("쉬운 난이도입니다.");
			}	else if(Difficulty == 2)	{
				System.out.println("보통 난이도입니다.");
			}	else if(Difficulty == 3)	{
				System.out.println("어려운 난이도입니다.");
			}	else if(Difficulty == 4)	{
				System.out.println("미칠듯한 난이도입니다 .");
			}	else	{
				System.out.println("장난하냐? 다시 골라!");
			}
		}
		System.out.println("캐릭터 선택");
		System.out.println("1. 히지리 뱌쿠렌, 2. 호라이산 카구야, 3. 시키에이키 야마자나두");
		Scanner sc = new Scanner();
		Selection = sc.nextInt();
		Battle b = new Battle();
	}
}
```