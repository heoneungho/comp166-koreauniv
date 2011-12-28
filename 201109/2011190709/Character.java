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
