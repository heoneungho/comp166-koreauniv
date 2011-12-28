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
	private Sequencer sequencer = null; //음악 파일이고
	
	private Sequence sequence = null; //플레이어이다.
	 
	MidiPlayer(String fname) {
		try {
		sequence = MidiSystem.getSequence(new File(fname));
		
		sequencer = MidiSystem.getSequencer(); //기본 시퀀서를 얻어 온다.
		
		sequencer.open(); // 시퀀서를 연다.
		sequencer.setSequence(sequence); //시퀀서에 시퀀스를 설정한다.
		} catch (Exception e) {
			System.out.println();
		}
	}
	 
	public void start() {
		sequencer.start();
	}
}