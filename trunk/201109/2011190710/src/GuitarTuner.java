import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.sound.midi.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class GuitarTuner extends Instrument implements ActionListener{
	JButton buttonE,buttonA,buttonD,buttonG,buttonB,buttonE2;
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
		
		buttonD = new JButton("D sound   ");
		buttonD.addActionListener(new DListener());
		buttonD.setBackground(Color.black);
		buttonD.setForeground(Color.white);
		buttonD.setFont(bigFont);

		buttonG = new JButton("G sound   ");
		buttonG.addActionListener(new GListener());
		buttonG.setBackground(Color.black);
		buttonG.setForeground(Color.white);
		buttonG.setFont(bigFont);

		buttonB = new JButton("B sound   ");
		buttonB.addActionListener(new BListener());
		buttonB.setBackground(Color.black);
		buttonB.setForeground(Color.white);
		buttonB.setFont(bigFont);
		
		buttonE2 = new JButton("E sound   ");
		buttonE2.addActionListener(new E2Listener());
		buttonE2.setBackground(Color.black);
		buttonE2.setForeground(Color.white);
		buttonE2.setFont(bigFont);//버튼설정
		
		JPanel Tunerpanel = new JPanel();
		
		Tunerpanel.setBackground(Color.BLACK);
		Tunerpanel.setLayout(new BoxLayout(Tunerpanel, BoxLayout.Y_AXIS));
		Tunerpanel.add(label);
		Tunerpanel.add(buttonE);
		Tunerpanel.add(buttonA);
		Tunerpanel.add(buttonD);
		Tunerpanel.add(buttonG);
		Tunerpanel.add(buttonB);
		Tunerpanel.add(buttonE2);		//패널에 추가
		
		frame.getContentPane().add(BorderLayout.WEST,Tunerpanel);
		frame.setSize(140,375);
		frame.setVisible(true);
		frame.setTitle("GuitarTuner");//프레임 설정
	}//이 아래것들은 해당 음에 대한 설정입니다.
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
	
	class BListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			track.add(makeEvent(144,1,59,100,1));
			track.add(makeEvent(128,1,59,100,50));
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}
		}
	}
	
	class E2Listener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			track.add(makeEvent(144,4,64,100,1));
			track.add(makeEvent(128,4,64,100,50));
			
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




