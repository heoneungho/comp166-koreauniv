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
			System.out.println("ȯ���⿡�� ����, Ȥ�� ����� �ΰ� �ִ� ������� ���������� �ľ��� �����ߴ�");
			System.out.println("�� �̺��� �ľ��̺��̶� ���ǰ� ������ ���̹��� �ľ��� �ο���� ���ε鿡�� ���ϱ⸦,");
			System.out.println("'�ϵ� �����ϱ� ������ ���ϱ� ���� IYAGI�� �ؼ� �ذ��϶��!!!'");
			System.out.println("�׸��Ͽ� ���ε��� �ڱ� �ֵ��� ������(������) �������� �����ϰ� ���ƴٴϰ� �Ǵµ�...");
		}
		System.out.println("�̸� : " + Player.name_p);
		System.out.println("ü�� : " + Player.HP_p);
		System.out.println("���ݷ� : " + Player.ATK_p);
		System.out.println("���� : " + Player.DEF_p);
		System.out.println("ȸ���� : " + Player.EVA_p);
		for(int x = 0; x < Player.Spells_p.length; x++)
			System.out.println("����ī�� ��� : " + Player.Spells_p[x]);
		
		System.out.println(Stage);
		System.out.println(Enemy.name_e);
		System.out.println(hp2);

		System.out.println("���� ����");
		
		while(hp1 > 0 && hp2 > 0)	{
			new Player(Level, Selection);
			new Enemy(Stage, Difficulty);
			
			D1 = Player.DEF_p;
			D2 = Enemy.DEF_e; 
			
			int Graze = (int)(Math.random() * 100) + 1;
			System.out.println(Graze);
			int CS;
			System.out.println("HP : " + hp1);
			System.out.println("����ī�� �ܷ� : " + C1);
			System.out.println("���� ������ : " + Player.TeaCount);
			System.out.println("��: " + Enemy.name_e);
			System.out.println("HP : " + hp2);
			System.out.println("����ī�� ���� : " + C2);
			if(turn % 2 == 0)	{
				System.out.println("Player Turn");
				System.out.println("�ൿ��ħ�� ���Ͻʽÿ�");
				System.out.println("1. ��Ÿ, 2. ���, 3. ����, 4. ����");
				Behavior = sc.nextInt();
				if(Behavior == 1)	{
					if(E2 > Graze)	{
						System.out.println("���� ����!");
						if(D2 > A1)	{
							System.out.println("���� 0 ���ظ� �Ծ���!");
						}
						else	{
							System.out.println("���� " + (A1 - D2) + " ���ظ� �Ծ���!");
							hp2 -= (A1 - D2);
						}
					}	else
						System.out.println("���� Graze!!");
				}	else if(Behavior == 2)	{
					D1 *= 2;
				}	else if(Behavior == 3)	{
					Player.TeaCount--;
					hp1 = Player.HP_p;
				}	else if(Behavior == 4)	{
					for(int x = 0; x < 3; x++)
						System.out.println(S1[x]);
					CS = sc.nextInt();
					System.out.println("���� " + S1[CS - 1]);
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
							System.out.println("��� ����!!");
						}	else	{							
							System.out.println("���� ������ �����Ͽ���");
							System.out.println((A2 - D1) + " �� ���ظ� �Ծ���!");
							hp1 -= (A2 - D1);
						}
					}	else
						System.out.println("Graze!!");
				}	else if(Behavior == 2)	{
					D2 *= 2;
				}	else if(Behavior == 3 && C2 != 0)	{
					C2--;
					CS = (int)Math.random() * 3 + 1;
					System.out.println("���� " + S2[CS]);
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
			System.out.println("�¸��Ͽ����ϴ�." + Enemy.name + "�� �ľ��� �ػ���׽��ϴ�. ���� ���������� �����մϴ�");
			Stage++;
			Level++;
			C1++;
		}	else if(hp2 < 0 && Stage == 6)	{
			System.out.println("�̺��� �ذ��ϼ̽��ϴ�!!");
			System.exit(0);
		}
	}
}