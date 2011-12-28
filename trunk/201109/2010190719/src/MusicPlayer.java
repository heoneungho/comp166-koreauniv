import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


public class MusicPlayer {
	String fname = null;
	MidiPlayer player;
	
	public MusicPlayer(int number) {
		if(number == 1){
			fname = "Hero.mid";
		}
		else if(number==2){
			fname = "Desperado.mid";	
		}
		else if(number==3){
			fname = "LetItBe.mid";
		}
		else if(number==4){
			fname = "Ill_Be_There.mid";
		}
		else if(number==5){
			fname = "Dancing_Queen.mid";
		}
		else if(number==6){
			fname = "Lucky.mid";
		}
		else if(number==7){
			fname = "TakeABow.mid";
		}
		
		player = new MidiPlayer(fname);
	}
	
	public void start() {
		player.start();
	}
}

class MidiPlayer
{
	private Sequencer sequencer = null; //���� �����̰�
	
	private Sequence sequence = null; //�÷��̾��̴�.
	 
	MidiPlayer(String fname) {
		try {
		sequence = MidiSystem.getSequence(new File(fname));
		
		sequencer = MidiSystem.getSequencer(); //�⺻ �������� ��� �´�.
		
		sequencer.open(); // �������� ����.
		sequencer.setSequence(sequence); //�������� �������� �����Ѵ�.
		} catch (Exception e) {
			System.out.println();
		}
	}
	 
	public void start() {
		sequencer.start();
	}
}