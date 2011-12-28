import javax.sound.midi.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class FunctionGui {

	JFrame frame;
	JFrame frame1;
	
	Year A = new Year();
	public void start(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button1 = new JButton(" 종료 ");
		button1.addActionListener(new Listener1());
		JButton button2 = new JButton(" 일정 입력 하기 ");
		button2.addActionListener(new Listener2());
		JButton button3 = new JButton(" 메모 하기 ");
		button3.addActionListener(new Listener3());
		JButton button4 = new JButton(" 일정 보기 (일) ");
		button4.addActionListener(new Listener5());
		JButton button5 = new JButton(" 일정 보기(월) ");
		button5.addActionListener(new Listener6());
		JPanel panel = new JPanel();
		panel.add(button2);
		panel.add(button4);
		panel.add(button5);
		panel.add(button3);
		panel.add(button1);
		frame.getContentPane().add(panel);
		frame.setSize(300,110);
		frame.setVisible(true);
		
		frame1 = new JFrame();
		JPanel panel1 = new JPanel();
		JTextArea text = new JTextArea(15,30);
		text.setText(" 작성하세요. ");
		panel1.add(text);
		frame1.getContentPane().add(panel1);
		frame1.setSize(400,350);
		JButton button6 = new JButton(" 이전 ");
		button6.addActionListener(new Listener4());
		panel1.add(button6);
		
	}
	class Listener1 implements ActionListener {
	   public void actionPerformed(ActionEvent event){
		  
		   try {
			Sequencer sori = MidiSystem.getSequencer();
			 sori.open();
			 Sequence seq = new Sequence(Sequence.PPQ,4);
			 Track track = seq.createTrack();
			 
			 ShortMessage a = new ShortMessage();
			 a.setMessage(144,1,10,100);
			 MidiEvent SoriOn = new MidiEvent(a,1);
             track.add(SoriOn);
             
             ShortMessage b = new ShortMessage();
             b.setMessage(128,1,10,100);
             MidiEvent SoriOff = new MidiEvent(b,16);
             track.add(SoriOff);
             
             sori.setSequence(seq);
             sori.start();
		   }
		   catch( Exception ex ) {
			   ex.printStackTrace();
		   }
		  
		frame.setVisible(false);
	   }
	}
	class Listener2 implements ActionListener {
	   public void actionPerformed(ActionEvent event){
		   
		   	try {
				Sequencer sori = MidiSystem.getSequencer();
				 sori.open();
				 Sequence seq = new Sequence(Sequence.PPQ,4);
				 Track track = seq.createTrack();
				 
				 ShortMessage a = new ShortMessage();
				 a.setMessage(144,1,23,100);
				 MidiEvent SoriOn = new MidiEvent(a,1);
	             track.add(SoriOn);
	             
	             ShortMessage b = new ShortMessage();
	             b.setMessage(128,1,23,100);
	             MidiEvent SoriOff = new MidiEvent(b,16);
	             track.add(SoriOff);
	             
	             sori.setSequence(seq);
	             sori.start();
			   }
			   catch( Exception ex ) {
				   ex.printStackTrace();
			   }
		   	frame.setVisible(false);
		   	Month B = (Month) A.go();
			Day C = (Day) B.go();
			C.GetMemo();
				
			frame.setVisible(true);
		   	
		   	
	   }
	}
	class Listener3 implements ActionListener {
		public void actionPerformed(ActionEvent event){
		
			try{
			Sequencer sori = MidiSystem.getSequencer();
			 sori.open();
			 Sequence seq = new Sequence(Sequence.PPQ,4);
			 Track track = seq.createTrack();
			 
			 ShortMessage a = new ShortMessage();
			 a.setMessage(144,1,2,100);
			 MidiEvent SoriOn = new MidiEvent(a,1);
            track.add(SoriOn);
            
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,2,100);
            MidiEvent SoriOff = new MidiEvent(b,16);
            track.add(SoriOff);
            
            sori.setSequence(seq);
            sori.start();
		   }
		   catch( Exception ex ) {
			   ex.printStackTrace();
		   }
			frame.setVisible(false);
			frame1.setVisible(true);
			
		}
	}
	class Listener4 implements ActionListener {
        public void actionPerformed(ActionEvent event){
        	try{
    			Sequencer sori = MidiSystem.getSequencer();
    			 sori.open();
    			 Sequence seq = new Sequence(Sequence.PPQ,4);
    			 Track track = seq.createTrack();
    			 
    			 ShortMessage a = new ShortMessage();
    			 a.setMessage(144,1,1,100);
    			 MidiEvent SoriOn = new MidiEvent(a,1);
                track.add(SoriOn);
                
                ShortMessage b = new ShortMessage();
                b.setMessage(128,1,1,100);
                MidiEvent SoriOff = new MidiEvent(b,16);
                track.add(SoriOff);
                
                sori.setSequence(seq);
                sori.start();
    		   }
    		   catch( Exception ex ) {
    			   ex.printStackTrace();
    		   }
        	frame1.setVisible(false);
        	frame.setVisible(true);
        	
        }
		
	}
	class Listener5 implements ActionListener {
		public void actionPerformed(ActionEvent event){
        	try{
    			Sequencer sori = MidiSystem.getSequencer();
    			 sori.open();
    			 Sequence seq = new Sequence(Sequence.PPQ,4);
    			 Track track = seq.createTrack();
    			 
    			 ShortMessage a = new ShortMessage();
    			 a.setMessage(144,1,4,100);
    			 MidiEvent SoriOn = new MidiEvent(a,1);
                track.add(SoriOn);
                
                ShortMessage b = new ShortMessage();
                b.setMessage(128,1,4,100);
                MidiEvent SoriOff = new MidiEvent(b,16);
                track.add(SoriOff);
                
                sori.setSequence(seq);
                sori.start();
    		   }
    		   catch( Exception ex ) {
    			   ex.printStackTrace();
    		   }
        	frame.setVisible(false);
		   	Month B = (Month) A.go();
			Day C = (Day) B.go();
			C.PrintMemo();
			frame.setVisible(true);
        	
	        }
    }
	class Listener6 implements ActionListener {
		public void actionPerformed(ActionEvent event){
			try{
    			Sequencer sori = MidiSystem.getSequencer();
    			 sori.open();
    			 Sequence seq = new Sequence(Sequence.PPQ,4);
    			 Track track = seq.createTrack();
    			 
    			 ShortMessage a = new ShortMessage();
    			 a.setMessage(144,1,3,100);
    			 MidiEvent SoriOn = new MidiEvent(a,1);
                track.add(SoriOn);
                
                ShortMessage b = new ShortMessage();
                b.setMessage(128,1,3,100);
                MidiEvent SoriOff = new MidiEvent(b,16);
                track.add(SoriOff);
                
                sori.setSequence(seq);
                sori.start();
    		   }
    		   catch( Exception ex ) {
    			   ex.printStackTrace();
    		   }
			   frame.setVisible(false);
			   System.out.println("달을 입력하세요:");
			   Scanner s1 = new Scanner(System.in);
		       int b = s1.nextInt();
		       Month B = A.Month1[b-1];
		       
		       for( int c = 0; c<31; c++){
		    	   for(int d = 0;  B.Day1[c].i[d] != null ; d++){
		    	   
		    		   System.out.printf("%d일 : %s",c+1,B.Day1[c].i[d]);
		    		   System.out.println(" ");
		    	   }
		    	   
		    	   }
		       frame.setVisible(true);
		       }
		       
		}
	}


