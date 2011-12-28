import javax.sound.midi.*;

public class Sounder {
		static int definer = 60;
		static void Sound_pro()	{
		Sounder mini = new Sounder();
		mini.play(definer);
	}
	
	void play(int definer)	{
		try	{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 9, definer, 100);
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
