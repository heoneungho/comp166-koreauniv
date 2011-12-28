import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tuner {
	Font bigFont =  new Font("serif",Font.BOLD, 28);
	Font BIGFont = new Font("serif",Font.BOLD,40);

	public void go(){
		JFrame frame = new JFrame();
		JPanel Tunerpanel = new JPanel();
		Tunerpanel.setBackground(Color.BLACK);
		Tunerpanel.setLayout(new BoxLayout(Tunerpanel, BoxLayout.Y_AXIS));
		
		
		
		JLabel Title = new JLabel(" Choose!");
		Title.setFont(bigFont);
		Title.setForeground(Color.red);
		
		
		JButton Bassbutton = new JButton("Bass      ");
		Bassbutton.addActionListener(new BassListener());
		Bassbutton.setBackground(Color.black);
		Bassbutton.setForeground(Color.white);
		Bassbutton.setFont(bigFont);
		
		JButton Guitarbutton = new JButton("Guitar ");
		Guitarbutton.addActionListener(new GuitarListener());
		Guitarbutton.setBackground(Color.black);
		Guitarbutton.setForeground(Color.white);
		Guitarbutton.setFont(bigFont);

		JButton Violinbutton = new JButton("Violin  ");
		Violinbutton.addActionListener(new ViolinListener());
		Violinbutton.setBackground(Color.black);
		Violinbutton.setForeground(Color.white);
		Violinbutton.setFont(bigFont);

		JButton Chellobutton = new JButton("Chello  ");
		Chellobutton.addActionListener(new ChelloListener());
		Chellobutton.setBackground(Color.black);
		Chellobutton.setForeground(Color.white);
		Chellobutton.setFont(bigFont);//버튼설정
		
		JLabel Tunerlabel = new JLabel("                 Choose the tuner~!"); 
		Tunerlabel.setFont(bigFont);
		

		Tunerpanel.add(Title);
		Tunerpanel.add(Bassbutton);
		Tunerpanel.add(Guitarbutton);
		Tunerpanel.add(Violinbutton);
		Tunerpanel.add(Chellobutton);//패널에 추가
		
		frame.getContentPane().add(BorderLayout.WEST,Tunerpanel);
		frame.setSize(120,300);
		frame.setVisible(true);
		frame.setTitle("Tuner");//프레임에 추가
		
		
	}//이 아래 것들은 버튼에 대한 액션입니다.
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	class BassListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Instrument Bass = new BassTuner();
			Bass.go();
		}
	}
	class GuitarListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
				Instrument Guitar = new GuitarTuner();
				Guitar.go();
	
		}
	}

	class ViolinListener implements ActionListener{
		public void actionPerformed(ActionEvent event){

			Instrument Violin = new ViolinTuner();
			Violin.go();
			}
	}

	class ChelloListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Instrument Chello = new ChelloTuner();
			Chello.go();				
		}
	}
			
}

