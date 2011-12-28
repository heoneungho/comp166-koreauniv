package Japangi;

import javax.sound.midi.*;

public class JapangiSound {


    public void play(){
       
        try {
           
            Sequencer player = MidiSystem.getSequencer();
            player.open();
           
            Sequence se = new Sequence(Sequence.PPQ,4);
                
            Track tr = se.createTrack();
           
            ShortMessage me1 = new ShortMessage();
            me1.setMessage(144,1,74,100);
            MidiEvent noteOn = new MidiEvent(me1,1);
            tr.add(noteOn);
               
            ShortMessage me2 = new ShortMessage();
            me2.setMessage(128,1,74,100);
            MidiEvent noteOff = new MidiEvent(me2,16);
            tr.add(noteOff);
               
            player.setSequence(se);
           
            player.start();
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
    }
}