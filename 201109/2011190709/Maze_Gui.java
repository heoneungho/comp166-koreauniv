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