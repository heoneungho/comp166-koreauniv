





import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.sound.midi.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class ChelloTuner extends Instrument implements ActionListener {
	JButton buttonE,buttonA,buttonD,buttonG;
	JFrame frame;
	JLabel label;

	public void go(){
		
		JFrame frame = new JFrame();
		Font bigFont =  new Font("serif",Font.BOLD, 28);
		

		label = new JLabel("    Sound");
		label.setForeground(Color.WHITE);
		label.setFont(bigFont);
		
		
		buttonE = new JButton("E sound   ");
		buttonE.addActionListener(new EListener());
		buttonE.setBackground(Color.black);
		buttonE.setForeground(Color.white);
		buttonE.setFont(bigFont);

		buttonA = new JButton("A sound   ");
		buttonA.addActionListener(new AListener());
		buttonA.setBackground(Color.black);
		buttonA.setForeground(Color.white);
		buttonA.setFont(bigFont);

		buttonD = new JButton("D sound ");
		buttonD.addActionListener(new DListener());
		buttonD.setBackground(Color.black);
		buttonD.setForeground(Color.white);
		buttonD.setFont(bigFont);
		
		buttonG = new JButton("G sound   ");
		buttonG.addActionListener(new GListener());
		buttonG.setBackground(Color.black);
		buttonG.setForeground(Color.white);
		buttonG.setFont(bigFont);//버튼설정

		JPanel Tunerpanel = new JPanel();
		Tunerpanel.setBackground(Color.BLACK);
		Tunerpanel.setLayout(new BoxLayout(Tunerpanel, BoxLayout.Y_AXIS));
		Tunerpanel.add(label);
		Tunerpanel.add(buttonE);
		Tunerpanel.add(buttonA);
		Tunerpanel.add(buttonD);
		Tunerpanel.add(buttonG);//패널설정
		
		
		frame.getContentPane().add(BorderLayout.WEST,Tunerpanel);
		frame.setSize(150,300);
		frame.setVisible(true);
		frame.setTitle("ChelloTuner");//프레임설정
	}//이 아래것들은 해당음에 대한 설정입니다.
	class EListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			track.add(makeEvent(144,1,40,100,1));
			track.add(makeEvent(128,1,40,100,50));
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}
		}
	}

	class AListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			track.add(makeEvent(144,1,45,100,1));
			track.add(makeEvent(128,1,45,100,50));
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}
		}
	}
	

	class DListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			track.add(makeEvent(144,1,50,100,1));
			track.add(makeEvent(128,1,50,100,50));
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}
		}
	}
	
	class GListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			track.add(makeEvent(144,1,55,100,1));
			track.add(makeEvent(128,1,55,100,50));
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
	}
}





