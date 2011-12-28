import java.io.IOException;

public class Battle {
	public int hp_p, atk_p, def_p, cri_p;
	int hp_m, atk_m, def_m, cri_m;
	int playerC, tmp;
	public int potionCount = 10;
	Maze reseter = new Maze();
	boolean battle_win;
	
	
	public boolean callBattle(int level){
		System.out.println("You've encountered the Moster!!! You have to fight it off to keep on going!!");
		hp_p = 1000;
		def_p = 70;
		hp_m = 70*level+ (int)(Math.random() * 20 +1);
		def_m = 5*level;
		
		
		while(true)	{
			battle_win = false;
			atk_p = 150 + (int)(Math.random() * 20 +1);
			atk_m = 12*level+ (int)(Math.random() * 20 +1);
			System.out.println("________________________________________________________________________________________");
			System.out.println("Your hp :\nhp_p = " +hp_p+"\n");
			System.out.println("Monster's hp :\nhp_m = " +hp_m+"\n");
			System.out.println("Choose your behavior\nType the number of behavior you want to do\n\n\n1. Attack\n2.Defence Position. \n3. Drink Potion\n");
			
			try	{
			playerC = (int)System.in.read();
			System.in.read();
			System.in.read();
			}	catch(IOException playerC)	{
				System.out.println("ERROR!! YOU TYPED WRONG!!! ");System.out.println("Please type ENTER.");
			}
			Battlepage(playerC ,level);
			Sounder.Sound_pro();
			System.out.println("________________________________________________________________________________________");
			if(hp_p <=0)	{
				return battle_win;
			}
			if(hp_m <=0)	{
			return battle_win = true;	
			}
		}
	}
	
	public void Battlepage(int playerC, int level) {
		if(playerC == 49)	{
			cri_p = 100 *(int)Math.random();
			if(cri_p >= 70)	{
				System.out.println("Critical attack!! You dealt '"+(atk_p*2 - def_m)+"' damage to the monster\n");
				hp_m = hp_m - (atk_p *2 - def_m);
			}
			else {
			System.out.println("You chose to attack! You dealt '"+(atk_p - def_m)+"' damage to the monster\n");
			hp_m = hp_m - (atk_p - def_m);
			}
		}
		if(playerC == 50)	{
			def_p = 70;
			System.out.println("Your defence duobles!");
			def_p *=2;
		}
		if(playerC == 51)	{
			if(potionCount > 0)	{
			System.out.println("You drank potion and you recovered 200 hp!!");
			potionCount--;
			hp_p += 200;
			if(hp_p >1000)
				hp_p = 1000;
			}
			else
				System.out.println("You are out of potions");
		}
		
		System.out.println("Now it's Monster's turn to attack!\n");
		cri_m = 8* level *(int)Math.random();
		if(cri_m >= 70)	{
			System.out.println("Critical attack!! Monster dealt '"+(atk_m*2 - def_p)+"' damage to you\n");
			if(atk_m >= def_p)
			hp_p = hp_p - (atk_m *2 - def_p);
			else
			System.out.println("Defence of player is great! No damage dealt to player\n");
						}
		else	{
			System.out.println("Monster chose to attack! Monster dealt '"+(atk_m - def_p)+"' damage to you\n");
			if(atk_m >= def_p)
			hp_p = hp_p - (atk_m - def_p);
			else
				System.out.println("Defence of player is great! No damage dealt to player\n");
				}
		if(hp_m<0)	{
			System.out.println("You won the battle!! Please proceed\n");
			reseter.rooms[reseter.locationA][reseter.locationB] = 32;
		}
		if(hp_p<0)	{
			System.out.println("You lost the battle!! Your game will be reseted\n");
		}
		}
}

