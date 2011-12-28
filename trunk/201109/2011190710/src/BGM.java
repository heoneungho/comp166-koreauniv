

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;


public class BGM {
	Sequencer sequencer;
	public void introplay(){//BGM���� �����Դϴ�.
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			int i=0,j = 36;
			
			for(;j<96;j++){

				track.add(makeEvent(144,1,j,100,i));
				track.add(makeEvent(128,1,j,100,i+3));
				i++;
			}
				
			for(;j>48;j--){

				track.add(makeEvent(144,1,j,100,i));
				track.add(makeEvent(128,1,j,100,i+3));
				i++;
			}
			
			
			for(;j<72;j++){

				track.add(makeEvent(144,1,j,100,i));
				track.add(makeEvent(128,1,j,100,i+3));
				i++;
			}
			
			for(;j>36;j--){

				track.add(makeEvent(144,1,j,100,i));
				track.add(makeEvent(128,1,j,100,i+3));
				i++;
			}
			
			track.add(makeEvent(144,1,60,100,i));
			track.add(makeEvent(128,1,60,100,i+3));
			

			track.add(makeEvent(144,1,64,100,i));
			track.add(makeEvent(128,1,64,100,i+3));
			

			track.add(makeEvent(144,1,67,100,i));
			track.add(makeEvent(128,1,67,100,i+3));
			
			i+=4;

			track.add(makeEvent(144,1,60,100,i));
			track.add(makeEvent(128,1,60,100,i+3));
			

			track.add(makeEvent(144,1,64,100,i));
			track.add(makeEvent(128,1,64,100,i+3));
			

			track.add(makeEvent(144,1,67,100,i));
			track.add(makeEvent(128,1,67,100,i+3));

			i+=4;
			
			track.add(makeEvent(144,1,60,100,i));
			track.add(makeEvent(128,1,60,100,i+3));
			

			track.add(makeEvent(144,1,64,100,i));
			track.add(makeEvent(128,1,64,100,i+3));
			

			track.add(makeEvent(144,1,67,100,i));
			track.add(makeEvent(128,1,67,100,i+3));
			
			i+=4;
			
			track.add(makeEvent(144,1,60,100,i));
			track.add(makeEvent(128,1,60,100,i+3));
			

			track.add(makeEvent(144,1,64,100,i));
			track.add(makeEvent(128,1,64,100,i+3));
			

			track.add(makeEvent(144,1,67,100,i));
			track.add(makeEvent(128,1,67,100,i+3));
			
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}		
	}

	
	public void JK(){//�������α׷��� ©�� �̳뷡�� ��� ������ ���ö����ϴ�.�׷��� ����ֱ�� �߽��ϴ�. 
		

		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			int i=0;
		
		track.add(makeEvent(144,1,62,100,i));
		track.add(makeEvent(128,1,62,100,i+1));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		track.add(makeEvent(144,1,54,100,i));
		track.add(makeEvent(128,1,54,100,i+1));
		track.add(makeEvent(144,1,47,100,i));
		track.add(makeEvent(128,1,47,100,i+1));
		track.add(makeEvent(144,1,35,100,i));
		track.add(makeEvent(128,1,35,100,i+1));

		i++;
		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(128,1,21,100,i+1));
		track.add(makeEvent(144,1,53,100,i));
		track.add(makeEvent(128,1,53,100,i+1));
		i++;
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+1));
		track.add(makeEvent(144,1,60,100,i));
		track.add(makeEvent(128,1,60,100,i+1));

		i++;
		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(144,1,52,100,i+1));
		track.add(makeEvent(144,1,45,100,i));
		track.add(makeEvent(144,1,32,100,i+1));

		track.add(makeEvent(128,1,61,100,i+4));
		track.add(makeEvent(128,1,52,100,i+4));
		track.add(makeEvent(128,1,45,100,i+4));
		track.add(makeEvent(128,1,32,100,i+4));
		
		i+=2;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//��
		i+=1;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//��
		i+=1;

		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+2));//��
		
		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+2));
		
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+2));
		
		track.add(makeEvent(144,1,43,100,i));
		track.add(makeEvent(128,1,43,100,i+4));
		
		track.add(makeEvent(144,1,31,100,i));
		track.add(makeEvent(128,1,31,100,i+4));
		i++;

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+1));
		
		i++;
		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+1));
		
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+2));
		
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+2));
		i++;

		track.add(makeEvent(144,1,62,100,i));
		track.add(makeEvent(128,1,62,100,i+4));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+4));
		track.add(makeEvent(144,1,42,100,i));
		track.add(makeEvent(128,1,42,100,i+4));
		track.add(makeEvent(144,1,30,100,i));
		track.add(makeEvent(128,1,30,100,i+4));
		i+=2;

		track.add(makeEvent(144,1,66,100,i));
		track.add(makeEvent(128,1,66,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//��
		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+2));
		track.add(makeEvent(144,1,40,100,i));
		track.add(makeEvent(128,1,40,100,i+5));
		track.add(makeEvent(144,1,28,100,i));
		track.add(makeEvent(128,1,28,100,i+5));
		
		i++;
		
		track.add(makeEvent(144,1,69,100,i));
		track.add(makeEvent(128,1,69,100,i+2));//��
		
		i++;
		

		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+1));
		i++;
		

		track.add(makeEvent(144,1,53,100,i));
		track.add(makeEvent(128,1,53,100,i+1));
		i++;
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		i++;
		

		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+4));
		track.add(makeEvent(144,1,53,100,i));
		track.add(makeEvent(128,1,53,100,i+4));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+4));
		i+=2;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//��
		i+=1;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//��
		i+=1;


		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i));//��

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));

		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+2));
		
		i+=1;

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));//��
		i+=1;

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+1));

		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		
		i++;
		

		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+1));
		
		i++;
		track.add(makeEvent(144,1,62,100,i));
		track.add(makeEvent(128,1,62,100,i+4));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+4));
		track.add(makeEvent(144,1,54,100,i));
		track.add(makeEvent(128,1,54,100,i+4));
		i+=2;

		track.add(makeEvent(144,1,66,100,i));
		track.add(makeEvent(128,1,66,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,69,100,i));
		track.add(makeEvent(128,1,69,100,i+2));//��
		
		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(128,1,61,100,i+1));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+1));
		i++;
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+1));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		i++;

		track.add(makeEvent(144,1,62,100,i));
		track.add(makeEvent(128,1,62,100,i+1));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		track.add(makeEvent(144,1,54,100,i));
		track.add(makeEvent(128,1,54,100,i+1));
		i++;
		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+1));
		i++;
		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(128,1,61,100,i+4));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+4));
		i+=2;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,76,100,i));
		track.add(makeEvent(128,1,76,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,78,100,i));
		track.add(makeEvent(128,1,78,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,76,100,i));
		track.add(makeEvent(128,1,76,100,i+1));
		i++;
		track.add(makeEvent(144,1,78,100,i));
		track.add(makeEvent(128,1,78,100,i+1));
		i++;
		track.add(makeEvent(144,1,81,100,i));
		track.add(makeEvent(128,1,81,100,i+4));
		
		i+=2;
		
		track.add(makeEvent(144,1,66,100,i));
		track.add(makeEvent(128,1,66,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//ó
		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+2));
		track.add(makeEvent(144,1,40,100,i));
		track.add(makeEvent(128,1,40,100,i+5));
		track.add(makeEvent(144,1,28,100,i));
		track.add(makeEvent(128,1,28,100,i+5));
		
		i++;
		
		track.add(makeEvent(144,1,69,100,i));
		track.add(makeEvent(128,1,69,100,i+2));//��
		

		i++;
		

		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+1));
		i++;
		

		track.add(makeEvent(144,1,53,100,i));
		track.add(makeEvent(128,1,53,100,i+1));
		i++;
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		i++;
		

		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+4));
		track.add(makeEvent(144,1,53,100,i));
		track.add(makeEvent(128,1,53,100,i+4));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+4));
		i+=2;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//��
		i+=1;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//��
		i+=1;


		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i));//��

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));

		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+2));
		
		i+=1;

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+1));//��
		i+=1;

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+1));

		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+1));
		
		i++;
		

		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+1));
		
		i++;
		track.add(makeEvent(144,1,62,100,i));
		track.add(makeEvent(128,1,62,100,i+4));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+4));
		track.add(makeEvent(144,1,54,100,i));
		track.add(makeEvent(128,1,54,100,i+4));
		i+=2;

		track.add(makeEvent(144,1,66,100,i));
		track.add(makeEvent(128,1,66,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//��
		i++;
		track.add(makeEvent(144,1,69,100,i));
		track.add(makeEvent(128,1,69,100,i+4));//��
		
		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(128,1,61,100,i+3));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+3));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+3));
		
		
		i += 3;
		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+5));
		track.add(makeEvent(144,1,56,100,i));
		track.add(makeEvent(128,1,56,100,i+5));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+5));
		i+=5;

		track.add(makeEvent(144,1,62,100,i));
		track.add(makeEvent(128,1,62,100,i+3));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+3));
		track.add(makeEvent(144,1,54,100,i));
		track.add(makeEvent(128,1,54,100,i+3));

		i+=3;

		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(128,1,61,100,i+5));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+5));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+5));
		
		i+=5;

		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(128,1,61,100,i+3));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+3));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+3));

		i+=3;
		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+5));
		track.add(makeEvent(144,1,56,100,i));
		track.add(makeEvent(128,1,56,100,i+5));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+5));
		
		i+=5;

		track.add(makeEvent(144,1,62,100,i));
		track.add(makeEvent(128,1,62,100,i+3));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+3));
		track.add(makeEvent(144,1,54,100,i));
		track.add(makeEvent(128,1,54,100,i+3));

		i+=3;
		track.add(makeEvent(144,1,61,100,i));
		track.add(makeEvent(128,1,61,100,i+5));
		track.add(makeEvent(144,1,57,100,i));
		track.add(makeEvent(128,1,57,100,i+5));
		track.add(makeEvent(144,1,52,100,i));
		track.add(makeEvent(128,1,52,100,i+5));
		

		sequencer.setSequence(seq);
		sequencer.setTempoInBPM(35);
		sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}	
		
	}
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		}catch(Exception e){ }
		return event;
	}
}

