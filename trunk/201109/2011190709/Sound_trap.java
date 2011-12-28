import javax.sound.midi.*;

public class Sound_trap extends Sounder {
	
		static void Sound_pro()	{
		Sound_trap minim = new Sound_trap();
		int counter;
		for(counter = 40;counter<80;counter++)
		minim.play(counter);
	}
	void play(int changer)	{
		try	{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 9, changer, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
		}catch (Exception ex)	{
			ex.printStackTrace();
		}
	}
}
