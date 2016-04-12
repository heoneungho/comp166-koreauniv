# Introduction #

용자의 마왕을 잡기 위한 최후의 발악을 간단하게 만들어 봤습니다.
에서 그냥 미로탈출+잡다한 게임으로 바꾸었습니다.

# Background #

항상 만들고 싶었던 이상적인 게임을 만들기 위한 준비단계

# Details #

여러 방들을 뒤져가면서 방안에 있는 몬스터와 싸워가면서 마왕을 찾는 게임입니다.
에서 미로탈출이 궁극적인 목표입니다.

save기능 없음

# Using the Code #
```


public class Maze {
	public char rooms[][] = 
		{	{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'M',2},
			{2,2,2,1,2,1,2,1,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2},
			{2,2,2,1,2,1,2,1,1,1,1,1,1,2,1,2,2,2,1,2,2,1,2},
			{2,1,1,'T',2,1,1,2,2,2,2,2,1,2,1,1,1,2,1,2,2,1,2},
			{2,1,2,1,2,2,1,1,1,1,1,2,1,2,1,2,1,2,1,2,2,2,2},
			{2,1,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,'M',1,1,1,2},
			{2,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,1,1,'M',1,2,1,2,1,1,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,2,2,1,2,2,1,2,2,2,2,2,1,2,2,2,1,2,2,1,2},
			{2,1,'T',1,1,1,2,2,1,1,1,1,1,1,1,2,2,2,1,2,2,1,2},
			{2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2},
			{2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,2,'B','G'},
			{2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
		

		
	   public int locationA = 1;
	   public int locationB = 1;
	   
	  

	   public void Maze_limit() {
	  
	                 System.out.println(rooms[locationA-1][locationB-1]+ " " +rooms[locationA][locationB-1]+ " " +rooms[locationA+1][locationB-1]);
	                 System.out.println(rooms[locationA-1][locationB]+ " P " +rooms[locationA+1][locationB]);
	                 System.out.println(rooms[locationA-1][locationB+1]+ " " +rooms[locationA][locationB+1]+ " " +rooms[locationA+1][locationB+1]);
	            										}
	         							
	   public void Maze_alter(char userinput) {
	
		   if(userinput == 'a')
			   		locationA--;
		   	if(userinput == 's')
		   		  	locationB++;
		   	if(userinput == 'd')
		   			locationA++;
		   	if(userinput == 'w')
		   			locationB--;
		   	
		   	if(rooms[locationA][locationB] == 43)	{
		   			System.out.println("Error, you cannot go there");
		   					if(userinput == 'a')
		   						locationA++;
		   					if(userinput == 's')
		   			   		  	locationB--;
		   					if(userinput == 'd')
		   			   			locationA--;
		   					if(userinput == 'w')
		   			   			locationB++;
		   	}
		   	if((userinput != 'a')&&(userinput != 's') &&(userinput != 'd')&&(userinput != 'w'))
		   		System.out.println("ERROR!! YOU TYPED WRONG!!!");
	   			}
	   public void Maze_reseter()	{
		   locationA = 1;
		   locationB = 1;
	   }

}


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Character implements ActionListener {

	Battle caller = new Battle();
	int level;
	boolean battle_definer;
	JTextArea text;
	public void Monster(){
		level = 10;
			battle_definer = caller.callBattle(level);
	}
	
	public void Trapcard() {
			System.out.println("You fall in to the trap!! You go to the start line.");
			JFrame frame = new JFrame();
			JButton button = new JButton("You Fell into Trap!! Click this to close this frame");
			button.addActionListener(this);
			frame.getContentPane().add(BorderLayout.SOUTH,button);
			text = new JTextArea(40,40);
			text.setLineWrap(true);
			text.setText("You Just Activated My Trap Card!!!!!!!!!!!\nTrap Card!!!!!!!!!!!!!!!!!!!!\nTrap!!!!!!!!!\nCard!!!!!!!!!!!\n");
			frame.getContentPane().add(BorderLayout.CENTER,text);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(350,300);
			frame.setVisible(true);
			Sound_trap.Sound_pro();
	}
			public void actionPerformed(ActionEvent ev)	{
				text.append("\n\nYou Just Activated My Trap Card!!!\n\nNow that You have clicked this, you cannot run this game anymore. GameOver!!");
				Sound_trap.Sound_pro();
			}
}


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





public class Boss extends Character {
	public void BossMon(){
		level = 25;
			battle_definer = caller.callBattle(level);
	}
}


import java.io.IOException;

public class MazTestDrive {
	public static char userinput;
	static char chooser;
	
	public static void main(String [] args) throws ArrayIndexOutOfBoundsException	{
		Maze mazing = new Maze();
		Character player1 = new Character();
		Boss player2 = new Boss();
		 int tempA = 0;
		 int tempB = 0;
			
			for(tempA = 0; tempA < 17; tempA++)	{
				for(tempB= 0;tempB < 23; tempB++)	{
					if(mazing.rooms[tempA][tempB] == 1)
						mazing.rooms[tempA][tempB] = 32;
					if(mazing.rooms[tempA][tempB] == 2)
						mazing.rooms[tempA][tempB] =43;
				}
			}
			tempA = (int)(Math.random() * 10);
			System.out.println("This is Maze game. You have to figure out how to get out of here\n"+tempA);
			System.out.println("Empty space is the path, and '+' is the wall, and you are 'P'. You cannot go through the wall");
			System.out.println("If you want to play this game on script, input 'y', if you want play this game on gui, input 'n'\n");
			try	{
			chooser = (char)System.in.read();
			System.in.read();
			System.in.read();
			} catch (IOException chooser)	{
				System.out.println("FATAL ERROR, PLEASE RUN THIS PROGRAM AGAIN");
			}
			
			if(chooser == 'y')	{
   while(mazing.rooms[mazing.locationA][mazing.locationB] != 71)	{
	   System.out.println("_____________________________________________________________________________");
	   mazing.Maze_limit();
	   System.out.println("if you want to go up, press 'w', down 's', left 'a', and right 'd'");
	  
	   try	{
	   userinput = (char)System.in.read();
	   System.in.read();
	   System.in.read();
	   } catch (IOException userinput)	{
		   System.out.println("Please type ENTER.");
		   System.out.println("ERROR!! You TYPED WRONG!!!");  }
	   mazing.Maze_alter(userinput);
	   Sounder.Sound_pro();
	 
	   if(mazing.rooms[mazing.locationA][mazing.locationB]== 77)	{
	   player1.Monster();
	   if(player1.battle_definer == true)
	   mazing.rooms[mazing.locationA][mazing.locationB]= 32;
	   else
		   mazing.Maze_reseter();
	   }
	   
	   if(mazing.rooms[mazing.locationA][mazing.locationB]== 66 )	{
	   player2.BossMon();
	   if(player1.battle_definer == true)
	   mazing.rooms[mazing.locationA][mazing.locationB]= 32;
	   else
		   mazing.Maze_reseter();
	   }
	   
	   if(mazing.rooms[mazing.locationA][mazing.locationB]== 84 )	{
	   player1.Trapcard();
	   mazing.rooms[mazing.locationA][mazing.locationB] = 32;
	   mazing.Maze_reseter();
	   }
   	}
			}
			if(chooser == 'n')	{
				Maze_Gui gogo = new Maze_Gui();
				gogo.go();
			}
			if(chooser == 'y')
   System.out.println("Congratulations!! You have cleared the game");
}

}


import javax.sound.midi.*;

public class Sounder {
		static int definer = 60;
		static void Sound_pro()	{
		Sounder mini = new Sounder();
		mini.play(definer);
	}
	
	void play(int definer)	{
		try	{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 9, definer, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
		}catch (Exception ex)	{
			ex.printStackTrace();
		}
	}
}


import javax.sound.midi.*;

public class Sound_trap extends Sounder {
	
		static void Sound_pro()	{
		Sound_trap minim = new Sound_trap();
		int counter;
		for(counter = 40;counter<80;counter++)
		minim.play(counter);
	}
	void play(int changer)	{
		try	{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 9, changer, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
		}catch (Exception ex)	{
			ex.printStackTrace();
		}
	}
}


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Maze_Gui {
	public char room[][] = 
		{	{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,2,2,1,2,1,2,1,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2},
			{2,2,2,1,2,1,2,1,1,1,1,1,1,2,1,2,2,2,1,2,2,1,2},
			{2,1,1,1,2,1,1,2,2,2,2,2,1,2,1,1,1,2,1,2,2,1,2},
			{2,1,2,1,2,2,1,1,1,1,1,2,1,2,1,2,1,2,1,2,2,2,2},
			{2,1,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,1,1,1,2},
			{2,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,1,1,1,1,2,1,2,1,1,1,2,1,2,1,2,1,2,2,1,2},
			{2,2,2,2,2,1,2,2,1,2,2,2,2,2,1,2,2,2,1,2,2,1,2},
			{2,1,1,1,1,1,2,2,1,1,1,1,1,1,1,2,2,2,1,2,2,1,2},
			{2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2},
			{2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,'G'},
			{2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
	int roww = 1, coll = 1;
	JTextArea text;
	void ender()	{
		text.setText("You Have cleared the game!! Congratulations!\nPlease Close this frame.");
		System.out.println("GameOver");
	}
	public void go()	{
		maze_random_maker();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		JButton button1 = new JButton("Left");
		button1.addActionListener(new MyButtonLeft());
		JButton button2 = new JButton("Right");
		button2.addActionListener(new MyButtonRight());
		JButton button3 = new JButton("Up");
		button3.addActionListener(new MyButtonUp());
		JButton button4 = new JButton("Down");
		button4.addActionListener(new MyButtonDown());
		frame.getContentPane().add(BorderLayout.EAST,button1);
		frame.getContentPane().add(BorderLayout.WEST,button2);
		frame.getContentPane().add(BorderLayout.NORTH,button3);
		frame.getContentPane().add(BorderLayout.SOUTH,button4);
		
		
		JTextArea text_ender;
		
		text = new JTextArea(10,10);
		text.setLineWrap(true);
		text.setText("'+' is the wall and '5'is the path.\n"+room[roww-1][coll-1]+" "+room[roww][coll-1]+" "+room[roww+1][coll-1]+"\n"+room[roww-1][coll]+" P "
				+room[roww+1][coll]+"\n"+room[roww-1][coll+1]+" "+room[roww][coll+1]+" "+room[roww+1][coll+1]);
		
		frame.getContentPane().add(BorderLayout.CENTER,text);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,300);
		frame.setVisible(true);
		
		if(room[roww][coll] != 71)	{
			text_ender = new JTextArea(40,40);
			text_ender.setLineWrap(true);
			text_ender.append("Game Cleared!!!!!\n");
		}
	}
	public class MyButtonDown implements ActionListener	{
		public void actionPerformed(ActionEvent a)	{
			coll++;
			if(room[roww][coll]==43)
				coll--;
			text.setText(room[roww-1][coll-1]+" "+room[roww][coll-1]+" "+room[roww+1][coll-1]+"\n"+room[roww-1][coll]+" P "
					+room[roww+1][coll]+"\n"+room[roww-1][coll+1]+" "+room[roww][coll+1]+" "+room[roww+1][coll+1]);
			Sounder.Sound_pro();
			if(room[roww][coll]=='G')
				ender();
		}
	}
	public class MyButtonUp implements ActionListener	{
		public void actionPerformed(ActionEvent a)	{
			coll--;
			if(room[roww][coll]==43)
				coll++;
			text.setText(room[roww-1][coll-1]+" "+room[roww][coll-1]+" "+room[roww+1][coll-1]+"\n"+room[roww-1][coll]+" P "
					+room[roww+1][coll]+"\n"+room[roww-1][coll+1]+" "+room[roww][coll+1]+" "+room[roww+1][coll+1]);
			Sounder.Sound_pro();
			if(room[roww][coll]=='G')
				ender();
		}
	}
	public class MyButtonLeft implements ActionListener	{
		public void actionPerformed(ActionEvent a)	{
			roww++;;
			if(room[roww][coll]==43)
				roww--;
			text.setText(room[roww-1][coll-1]+" "+room[roww][coll-1]+" "+room[roww+1][coll-1]+"\n"+room[roww-1][coll]+" P "
					+room[roww+1][coll]+"\n"+room[roww-1][coll+1]+" "+room[roww][coll+1]+" "+room[roww+1][coll+1]);
			Sounder.Sound_pro();
			if(room[roww][coll]=='G')
				ender();
		}
	}
	public class MyButtonRight implements ActionListener	{
		public void actionPerformed(ActionEvent a)	{
			roww--;
			if(room[roww][coll]==43)
				roww++;
			text.setText(room[roww-1][coll-1]+" "+room[roww][coll-1]+" "+room[roww+1][coll-1]+"\n"+room[roww-1][coll]+" P "
					+room[roww+1][coll]+"\n"+room[roww-1][coll+1]+" "+room[roww][coll+1]+" "+room[roww+1][coll+1]);
			Sounder.Sound_pro();
			if(room[roww][coll]=='G')
				ender();
		}
	}
	public void maze_random_maker()	{
		int tempA = 0;
		 int tempB = 0;
			
			for(tempA = 0; tempA < 17; tempA++)	{
				for(tempB= 0;tempB < 23; tempB++)	{
					if(room[tempA][tempB] == 1)
						room[tempA][tempB] = 53;
					if(room[tempA][tempB] == 2)
						room[tempA][tempB] =43;
				}
			}
	}
}

```