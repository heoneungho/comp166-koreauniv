


import javax.swing.*;
import javax.sound.midi.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;

public class CJtuner implements ActionListener {
	Font bigFont =  new Font("serif",Font.BOLD, 28);
	Font BIGFont = new Font("serif",Font.BOLD,40);//폰트 설정
	static BGM intro;
	static BGM start;
	public static void main(String[] args){
		
		CJtuner gui = new CJtuner();
	
		gui.start();
		intro = new BGM();
		
		intro.introplay();//BGM 실행
		
	}
	public void start(){
		JFrame starting = new JFrame();
		JPanel spanel = new JPanel();
		JPanel spanel2 = new JPanel();
		spanel.setBackground(Color.BLACK);
		spanel.setLayout(new BoxLayout(spanel, BoxLayout.Y_AXIS)); // 패널1 설정
		
		JLabel start1 = new JLabel("              WELCOME!");
		JLabel start2 = new JLabel("                     This application is ");
		JLabel start22 = new JLabel("                 the tuner & metronome");
		JLabel start3 = new JLabel("                   You can use it easily!");
		JLabel start4 = new JLabel("                     It is very fantastic!");
		JLabel start5 = new JLabel("                                                        ");
		JLabel start6 = new JLabel("                                                                    ");
		JLabel null1 = new JLabel("  k                   "); //공백을위해 설정
		
		JButton sbutton = new JButton("                            Tuner                          ");
		sbutton.setFont(bigFont);
		sbutton.setForeground(Color.WHITE);
		sbutton.setBackground(Color.black);
		sbutton.addActionListener(new sbuttonL());
		
		JButton sbutton2 = new JButton("                        Metronome                     ");
		sbutton2.setFont(bigFont);
		sbutton2.setForeground(Color.WHITE);
		sbutton2.setBackground(Color.black);
		sbutton2.addActionListener(new sbuttonL2());//버튼 설정
		
		
		
		start1.setFont(BIGFont);
		start2.setFont(bigFont);
		start22.setFont(bigFont);
		start3.setFont(bigFont);
		start4.setFont(bigFont);
		null1.setFont(BIGFont);//폰트 설정
		
		
		start1.setForeground(Color.white);
		start2.setForeground(Color.white);
		start22.setForeground(Color.white);
		start3.setForeground(Color.white);
		start4.setForeground(Color.white);
		start5.setForeground(Color.white);
		start6.setForeground(Color.white);
		null1.setForeground(Color.black);
		
		
		
		spanel.add(start1);
		spanel.add(null1);
		spanel.add(start2);
		spanel.add(start22);
		spanel.add(start3);
		spanel.add(start4);		
		spanel.add(start5);
		spanel.add(start6);

		spanel2.setBackground(Color.black);
		spanel2.setLayout(new BoxLayout(spanel2, BoxLayout.Y_AXIS));
		spanel2.add(sbutton);
		spanel2.add(sbutton2);//패널에 추가
		
		starting.getContentPane().add(BorderLayout.CENTER,spanel);
		starting.getContentPane().add(BorderLayout.SOUTH,spanel2);
		starting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		starting.setSize(500,695);
		starting.setVisible(true);
		starting.setTitle("CJtuner");//프레임설정
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	class sbuttonL implements ActionListener{
		public void actionPerformed(ActionEvent event){
			intro.sequencer.stop();
			start = new BGM();
			start.JK();
			
			tuner starter = new tuner();
			starter.go();//튜너 실행
		}
	}

	class sbuttonL2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			intro.sequencer.stop();
			metronome starter = new metronome();
			starter.go();//메트로놈 실행
		}
	}
	
	
}



