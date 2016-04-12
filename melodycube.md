#2011190713 정한결

# Introduction #

java로 쓰여진 멜로디큐브입니다.
이백여개의 사각형을 사용자가 아무렇게나 클릭하면 그에 따라 새로운 멜로디를 창조할 수 있는 툴입니다.

# Background #

무작위한 입력으로 만들어진 멜로디가 작곡을 하는데에 새로운 영감이 될 수도 있습니다. 새로운 소리를 만들어보고 싶어 고안했습니다.

# Details #

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;
import java.util.*;


public class melodyCube
{
	JFrame frame;
	JPanel panel;
	ArrayList<JCheckBox> cubeList;
	Sequence seq;
	Sequencer player;
	Track track;
	boolean Rand = false;
	int tool=1;
	int[] noteKey = {80,78,76,74, 72,70,68,66, 64,62,60,58, 56,54,52,50 }; //연주 시의 각각 음의 높낮이에 대한 정보입니다.
	
	public static void main(String[] args) {
		new melodyCube().melodyCubeGUI();	

	}
	
	public void melodyCubeGUI() 
	{
		frame = new JFrame("MELODY CUBE!");
		
		cubeList = new ArrayList<JCheckBox>();
		
		
		
		
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		
		JButton start = new JButton("START!");//연주를 시작하는 버튼
		start.addActionListener(new startListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("STOP!");//연주를 정지하는 버튼
		stop.addActionListener(new stopListener());
		buttonBox.add(stop);
		
		JButton random = new JButton("RANDOM!");//무작위로 노트를 배열하여 새로운 창을 여는 버튼
		random.addActionListener(new randomListener());
		buttonBox.add(random);
		
		JButton change = new JButton("CHANGE TOOL!");//악기를 무작위로 변경하는 버튼
		change.addActionListener(new changeListener());
		buttonBox.add(change);
		
		JButton slower = new JButton("<<<");
		slower.addActionListener(new slowerListener());
		buttonBox.add(slower);
		
		JButton faster = new JButton(">>>");//연주 속도를 조절하는 버튼
		faster.addActionListener(new fasterListener());
		buttonBox.add(faster);
		
		background.add(BorderLayout.SOUTH, buttonBox);
			
		frame.getContentPane().add(background);
		
		GridLayout grid = new GridLayout(16, 16);
		panel = new JPanel(grid);
		background.add(BorderLayout.CENTER, panel);
					

		for(int i = 0; i < 256; i++)
		{
			JCheckBox cube = new JCheckBox();
			if(Rand == true)
			{
				if((Math.random() * 2) > 0.2)//1/5의 확률로 노트가 선택됩니다.
					cube.setSelected(false);
					else
						cube.setSelected(true);
			}
			else
			{
				cube.setSelected(false);
			}
			cubeList.add(cube);
			panel.add(cube);
		}
	
	
		Midi();	
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void Midi() 
	{
		try {
			
			player = MidiSystem.getSequencer(); 
			player.open();
			
			seq = new Sequence(Sequence.PPQ, 4);
			track = seq.createTrack();
			
			player.setTempoInBPM(220);
			
		} catch (Exception ex) { ex.printStackTrace(); }
	}
	
	public void buildTrackAndStart() 
	{
		int [] note = null;
		seq.deleteTrack(track);
		track = seq.createTrack();
		
		for(int i = 0; i<16; i++)
		{
			note = new int [16];
			int key = noteKey[i];
			
			for(int j = 0; j < 16; j++)
			{
				JCheckBox c = (JCheckBox) cubeList.get(j + (16*i));
				if(c.isSelected()) {
					note[j] = key;
				} else {
					note[j] = 0;
				}
			}
			makeTracks(note);
		track.add(makeEvent(176, 1, 127, 0, 16));
			
		}
		
		track.add(makeEvent(192, 9, 1, 0, 15));
		try{
			
			player.setSequence(seq);
			player.setLoopCount(player.LOOP_CONTINUOUSLY);
			player.start();
			player.setTempoInBPM(120);
		} catch(Exception e) {e.printStackTrace();}
	}
		
	public void makeTracks(int [] list) {
		
		for(int i = 0; i < 16; i++)
		{
			int key = list[i];
			
			if(key != 0) {
				track.add(makeEvent(192, 1, tool, 0, i));
				track.add(makeEvent(144, 1, key, 100, i));
				track.add(makeEvent(128, 1, key, 100, i+1));
				
			}
		}
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
	{
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
			
		}catch(Exception e) {e.printStackTrace(); }
		return event;
	}
	
	
	public class startListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			buildTrackAndStart();
		}
	}

	public class stopListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			player.stop();
		}
	}
	
	public class randomListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Rand = true;
			melodyCubeGUI();
		}
	}
	
	public class changeListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			tool = (int) (Math.random() * 124);//124종류의 악기가 무작위로 선택됩니다.
			
		}
	}
	
	public class fasterListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float)(tempoFactor * 1.03));
		
		}
	}
	public class slowerListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float)(tempoFactor * .97));
		
		}
	}
}
```