import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.sound.midi.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public abstract class Instrument implements ActionListener {
	public abstract void actionPerformed(ActionEvent event);
	public abstract void go();
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){//midi ¼³Á¤.
			MidiEvent event = null;
			try{
				ShortMessage a = new ShortMessage();
				a.setMessage(comd,chan,one,two);
				event = new MidiEvent(a,tick);
					
			}catch(Exception e){ }
				return event;
			}
		

	}
