# Introduction #

이 코드는 현악기사용자를 위해 만들었습니다.

튜닝기와 연습 시 필수품인 메트로놈을 사용할 수 있습니다.

튜닝으로는 베이스,첼로,기타,바이올린이 있고

각각 개방현에서의 음에 해당하는 피아노 음을 내도록했습니다.

각 현악기에 해당하는 음색으로 바꾸고 싶었지만

책하고 인터넷 다 찾아봣는데 못찾아서 그냥 피아노음으로 놔뒀습니다.

메트로놈은 자신이 숫자를 입력해서 속도를 조절할 수 있고

멈출 때는 스탑버튼을 누르면 됩니다.

## Analysis ##

클래스를 소개하겠습니다.

CJtuner class : 클래스 이름은 원래 튜너기능만 할려고 했다가

메트로놈을 추가했기에 이렇습니다.

여기에는 라벨을 통해 여러 문구가 쓰여있고

시작하자마자 인트로 음악이 켜집니다.

그리고 버튼이 두개가 있는데

하나는 튜닝 다른 하나는 메트로놈입니다.

클릭하시면 새창이 뜹니다.

BGM class : 이 클래스는 BGM 담당입니다. 즉 인트로 음악,

튜닝기 시작시 나오는 음악을 구현하는 클래스입니다.

tuner class : 이 클래스에서는 튜닝하고 싶은 현악기를

클릭할 수 있는 버튼 네개를 넣었습니다. 클릭하면

해당 클래스가 실행되면서 새 창이 뜹니다.

BassTuner, GuitarTuner, ChelloTuner, Vioilin Tuner class :

이클래스는 각각 개방현음을 구현하기위해 버튼이 줄 개수 만큼있고

버튼을 누르면 해당 음이 나오도록 만들었습니다.

Instrument 클래스를 상속받습니다.

Instrument class : 상속해주는 클래스로

makeevent 메소드를 가지고 있습니다.

metronome class : 숫자입력 텍스트 필드와

스타트, 스탑 버튼이 있습니다.

첫 박자에 엑센트를 주고 나머지 3박은 그냥 메트로놈형식으로

만들어 4박이 한묶음으로 사용자가 용이하게 만들었습니다.

Instrument 클래스를 상속받습니다.

```




import javax.swing.*;
import javax.sound.midi.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;

public class CJtuner implements ActionListener {
	Font bigFont =  new Font("serif",Font.BOLD, 28);
	Font BIGFont = new Font("serif",Font.BOLD,40);//폰트 설정
	static BGM intro;
	static BGM start;
	public static void main(String[] args){
		
		CJtuner gui = new CJtuner();
	
		gui.start();
		intro = new BGM();
		
		intro.introplay();//BGM 실행
		
	}
	public void start(){
		JFrame starting = new JFrame();
		JPanel spanel = new JPanel();
		JPanel spanel2 = new JPanel();
		spanel.setBackground(Color.BLACK);
		spanel.setLayout(new BoxLayout(spanel, BoxLayout.Y_AXIS)); // 패널1 설정
		
		JLabel start1 = new JLabel("              WELCOME!");
		JLabel start2 = new JLabel("                     This application is ");
		JLabel start22 = new JLabel("                 the tuner & metronome");
		JLabel start3 = new JLabel("                   You can use it easily!");
		JLabel start4 = new JLabel("                     It is very fantastic!");
		JLabel start5 = new JLabel("                                                        ");
		JLabel start6 = new JLabel("                                                                    ");
		JLabel null1 = new JLabel("  k                   "); //공백을위해 설정
		
		JButton sbutton = new JButton("                            Tuner                          ");
		sbutton.setFont(bigFont);
		sbutton.setForeground(Color.WHITE);
		sbutton.setBackground(Color.black);
		sbutton.addActionListener(new sbuttonL());
		
		JButton sbutton2 = new JButton("                        Metronome                     ");
		sbutton2.setFont(bigFont);
		sbutton2.setForeground(Color.WHITE);
		sbutton2.setBackground(Color.black);
		sbutton2.addActionListener(new sbuttonL2());//버튼 설정
		
		
		
		start1.setFont(BIGFont);
		start2.setFont(bigFont);
		start22.setFont(bigFont);
		start3.setFont(bigFont);
		start4.setFont(bigFont);
		null1.setFont(BIGFont);//폰트 설정
		
		
		start1.setForeground(Color.white);
		start2.setForeground(Color.white);
		start22.setForeground(Color.white);
		start3.setForeground(Color.white);
		start4.setForeground(Color.white);
		start5.setForeground(Color.white);
		start6.setForeground(Color.white);
		null1.setForeground(Color.black);
		
		
		
		spanel.add(start1);
		spanel.add(null1);
		spanel.add(start2);
		spanel.add(start22);
		spanel.add(start3);
		spanel.add(start4);		
		spanel.add(start5);
		spanel.add(start6);

		spanel2.setBackground(Color.black);
		spanel2.setLayout(new BoxLayout(spanel2, BoxLayout.Y_AXIS));
		spanel2.add(sbutton);
		spanel2.add(sbutton2);//패널에 추가
		
		starting.getContentPane().add(BorderLayout.CENTER,spanel);
		starting.getContentPane().add(BorderLayout.SOUTH,spanel2);
		starting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		starting.setSize(500,695);
		starting.setVisible(true);
		starting.setTitle("CJtuner");//프레임설정
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	class sbuttonL implements ActionListener{
		public void actionPerformed(ActionEvent event){
			intro.sequencer.stop();
			start = new BGM();
			start.JK();
			
			tuner starter = new tuner();
			starter.go();//튜너 실행
		}
	}

	class sbuttonL2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			intro.sequencer.stop();
			metronome starter = new metronome();
			starter.go();//메트로놈 실행
		}
	}
	
	
}





```





```




import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;


public class BGM {
	Sequencer sequencer;
	public void introplay(){//BGM관련 설정입니다.
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

	
	public void JK(){//조율프로그램을 짤때 이노래를 듣고 영감이 떠올랐습니다.그래서 집어넣기로 했습니다. 
		

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
		track.add(makeEvent(128,1,73,100,i+1));//잠
		i+=1;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//자
		i+=1;

		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+2));//는
		
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
		track.add(makeEvent(128,1,66,100,i+1));//하
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//늘
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//님
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//이
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
		track.add(makeEvent(128,1,69,100,i+2));//여
		
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
		track.add(makeEvent(128,1,73,100,i+1));//이
		i+=1;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//제
		i+=1;


		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i));//그

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));

		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+2));
		
		i+=1;

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));//만
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
		track.add(makeEvent(128,1,66,100,i+1));//일
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//어
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//나
		i++;
		track.add(makeEvent(144,1,69,100,i));
		track.add(makeEvent(128,1,69,100,i+2));//요
		
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
		track.add(makeEvent(128,1,73,100,i+1));//그
		i++;
		track.add(makeEvent(144,1,76,100,i));
		track.add(makeEvent(128,1,76,100,i+1));//옛
		i++;
		track.add(makeEvent(144,1,78,100,i));
		track.add(makeEvent(128,1,78,100,i+1));//날
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
		track.add(makeEvent(128,1,66,100,i+1));//하
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//늘
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//빛
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//처
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
		track.add(makeEvent(128,1,69,100,i+2));//럼
		

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
		track.add(makeEvent(128,1,73,100,i+1));//조
		i+=1;

		track.add(makeEvent(144,1,73,100,i));
		track.add(makeEvent(128,1,73,100,i+1));//율
		i+=1;


		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i));//한

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+2));

		track.add(makeEvent(144,1,59,100,i));
		track.add(makeEvent(128,1,59,100,i+2));
		
		i+=1;

		track.add(makeEvent(144,1,64,100,i));
		track.add(makeEvent(128,1,64,100,i+1));//번
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
		track.add(makeEvent(128,1,66,100,i+1));//해
		i++;
		track.add(makeEvent(144,1,68,100,i));
		track.add(makeEvent(128,1,68,100,i+1));//주
		i++;
		track.add(makeEvent(144,1,71,100,i));
		track.add(makeEvent(128,1,71,100,i+1));//세
		i++;
		track.add(makeEvent(144,1,69,100,i));
		track.add(makeEvent(128,1,69,100,i+4));//요
		
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



```




```


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tuner {
	Font bigFont =  new Font("serif",Font.BOLD, 28);
	Font BIGFont = new Font("serif",Font.BOLD,40);

	public void go(){
		JFrame frame = new JFrame();
		JPanel Tunerpanel = new JPanel();
		Tunerpanel.setBackground(Color.BLACK);
		Tunerpanel.setLayout(new BoxLayout(Tunerpanel, BoxLayout.Y_AXIS));
		
		
		
		JLabel Title = new JLabel(" Choose!");
		Title.setFont(bigFont);
		Title.setForeground(Color.red);
		
		
		JButton Bassbutton = new JButton("Bass      ");
		Bassbutton.addActionListener(new BassListener());
		Bassbutton.setBackground(Color.black);
		Bassbutton.setForeground(Color.white);
		Bassbutton.setFont(bigFont);
		
		JButton Guitarbutton = new JButton("Guitar ");
		Guitarbutton.addActionListener(new GuitarListener());
		Guitarbutton.setBackground(Color.black);
		Guitarbutton.setForeground(Color.white);
		Guitarbutton.setFont(bigFont);

		JButton Violinbutton = new JButton("Violin  ");
		Violinbutton.addActionListener(new ViolinListener());
		Violinbutton.setBackground(Color.black);
		Violinbutton.setForeground(Color.white);
		Violinbutton.setFont(bigFont);

		JButton Chellobutton = new JButton("Chello  ");
		Chellobutton.addActionListener(new ChelloListener());
		Chellobutton.setBackground(Color.black);
		Chellobutton.setForeground(Color.white);
		Chellobutton.setFont(bigFont);//버튼설정
		
		JLabel Tunerlabel = new JLabel("                 Choose the tuner~!"); 
		Tunerlabel.setFont(bigFont);
		

		Tunerpanel.add(Title);
		Tunerpanel.add(Bassbutton);
		Tunerpanel.add(Guitarbutton);
		Tunerpanel.add(Violinbutton);
		Tunerpanel.add(Chellobutton);//패널에 추가
		
		frame.getContentPane().add(BorderLayout.WEST,Tunerpanel);
		frame.setSize(120,300);
		frame.setVisible(true);
		frame.setTitle("Tuner");//프레임에 추가
		
		
	}//이 아래 것들은 버튼에 대한 액션입니다.
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	class BassListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Instrument Bass = new BassTuner();
			Bass.go();
		}
	}
	class GuitarListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
				Instrument Guitar = new GuitarTuner();
				Guitar.go();
	
		}
	}

	class ViolinListener implements ActionListener{
		public void actionPerformed(ActionEvent event){

			Instrument Violin = new ViolinTuner();
			Violin.go();
			}
	}

	class ChelloListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Instrument Chello = new ChelloTuner();
			Chello.go();				
		}
	}
			
}




```



```



import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.sound.midi.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class BassTuner extends Instrument   {
	JButton buttonE,buttonA,buttonD,buttonG;
	JFrame frame;
	JLabel label;
	int k = 12;

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
		buttonG.setFont(bigFont);//버튼설정

		JPanel Tunerpanel = new JPanel();
		Tunerpanel.setBackground(Color.BLACK);
		Tunerpanel.setLayout(new BoxLayout(Tunerpanel, BoxLayout.Y_AXIS));
		Tunerpanel.add(label);
		Tunerpanel.add(buttonE);
		Tunerpanel.add(buttonA);
		Tunerpanel.add(buttonD);
		Tunerpanel.add(buttonG);//패널에 추가
		
		
		frame.getContentPane().add(BorderLayout.WEST,Tunerpanel);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(150,300);
		frame.setVisible(true);
		frame.setTitle("BassTuner");//프레임 설정
	}
	//이 아래것들은 해당 음에 대한 설정입니다.
	class EListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			
			track.add(makeEvent(144,1,16+k,100,1));
			track.add(makeEvent(128,1,16+k,100,50));
			
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
			
						
			track.add(makeEvent(144,1,21+k,100,1));
			track.add(makeEvent(128,1,21+k,100,50));
			
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
			
						
			track.add(makeEvent(144,1,26+k,100,1));
			track.add(makeEvent(128,1,26+k,100,50));
			
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
			

			track.add(makeEvent(144,1,31+k,100,1));
			track.add(makeEvent(128,1,31+k,100,50));
			
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





```




```







import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.sound.midi.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class ChelloTuner extends Instrument implements ActionListener {
	JButton buttonE,buttonA,buttonD,buttonG;
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

		buttonD = new JButton("D sound ");
		buttonD.addActionListener(new DListener());
		buttonD.setBackground(Color.black);
		buttonD.setForeground(Color.white);
		buttonD.setFont(bigFont);
		
		buttonG = new JButton("G sound   ");
		buttonG.addActionListener(new GListener());
		buttonG.setBackground(Color.black);
		buttonG.setForeground(Color.white);
		buttonG.setFont(bigFont);//버튼설정

		JPanel Tunerpanel = new JPanel();
		Tunerpanel.setBackground(Color.BLACK);
		Tunerpanel.setLayout(new BoxLayout(Tunerpanel, BoxLayout.Y_AXIS));
		Tunerpanel.add(label);
		Tunerpanel.add(buttonE);
		Tunerpanel.add(buttonA);
		Tunerpanel.add(buttonD);
		Tunerpanel.add(buttonG);//패널설정
		
		
		frame.getContentPane().add(BorderLayout.WEST,Tunerpanel);
		frame.setSize(150,300);
		frame.setVisible(true);
		frame.setTitle("ChelloTuner");//프레임설정
	}//이 아래것들은 해당음에 대한 설정입니다.
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

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
	}
}






```




```


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






```





```

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.sound.midi.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class ViolinTuner extends Instrument implements ActionListener {
	JButton buttonE,buttonA,buttonD,buttonG;
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
		buttonG.setFont(bigFont);//버튼 설정

		JPanel Tunerpanel = new JPanel();
		Tunerpanel.setBackground(Color.BLACK);
		Tunerpanel.setLayout(new BoxLayout(Tunerpanel, BoxLayout.Y_AXIS));
		Tunerpanel.add(label);
		Tunerpanel.add(buttonG);
		Tunerpanel.add(buttonD);
		Tunerpanel.add(buttonA);
		Tunerpanel.add(buttonE);//패널설정
		
		
		frame.getContentPane().add(BorderLayout.WEST,Tunerpanel);
		frame.setSize(150,300);
		frame.setVisible(true);
		frame.setTitle("ViolinTuner");//프레임설정
	}//이 아래것들은 해당음에 대한 설정입니다.
	
	class EListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			
			track.add(makeEvent(144,1,76,100,1));
			track.add(makeEvent(128,1,76,100,50));
			
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
			
						
			track.add(makeEvent(144,1,69,100,1));
			track.add(makeEvent(128,1,69,100,50));
			
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
			
						
			track.add(makeEvent(144,1,62,100,1));
			track.add(makeEvent(128,1,62,100,50));
			
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

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
	}
}



```




```


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
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){//midi 설정.
			MidiEvent event = null;
			try{
				ShortMessage a = new ShortMessage();
				a.setMessage(comd,chan,one,two);
				event = new MidiEvent(a,tick);
					
			}catch(Exception e){ }
				return event;
			}
		

	}



```




```

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class metronome extends Instrument implements ActionListener{

	Font bigFont =  new Font("serif",Font.BOLD, 28);
	Font BIGFont = new Font("serif",Font.BOLD,40);
	static JTextField t1;
	Sequencer sequencer;
	public void go(){
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	panel.setBackground(Color.BLACK);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	t1 = new JTextField("100",20);
	t1.setFont(bigFont);//텍스트 필드 설정
	
	
	JLabel Title = new JLabel("    Set number");
	Title.setFont(bigFont);
	Title.setForeground(Color.red);
	
	JLabel Title2 = new JLabel("     you want!");
	Title2.setFont(bigFont);
	Title2.setForeground(Color.red);
	
	JButton sbutton = new JButton("       Start      ");
	sbutton.addActionListener(new start());
	sbutton.setBackground(Color.black);
	sbutton.setForeground(Color.white);
	sbutton.setFont(bigFont);

	JButton stbutton = new JButton("       Stop       ");
	stbutton.addActionListener(new stop());
	stbutton.setBackground(Color.black);
	stbutton.setForeground(Color.white);
	stbutton.setFont(bigFont);//버튼설정
	
	panel.add(Title);
	panel.add(Title2);
	panel.add(t1);
	panel.add(sbutton);
	panel.add(stbutton);//패널 설정
	
	frame.getContentPane().add(BorderLayout.WEST,panel);
	frame.setSize(200,260);
	frame.setVisible(true);
	frame.setTitle("Metronome");//프레임설정
	
	}
	
	 class start implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			for(int i=0;i<4000;i+=4){
			
			track.add(makeEvent(144,9,34,100,i));
			track.add(makeEvent(144,9,33,100,i+1));
			track.add(makeEvent(144,9,33,100,i+2));
			track.add(makeEvent(144,9,33,100,i+3));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(Integer.parseInt(t1.getText())/4);//텍스트필드에입력한 값을 인티저로 바꾸면 숫자가 되기때문에 그숫자를 박자로 맞춘다.
			//이때 이 BPM은 16분음표를 의미하기때문에 4로 나눠줘서 느리게해줘야 메트로놈의 박자인 4분음표가 된다.
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}
		}
		
	}
	 class stop implements ActionListener {

		 public void actionPerformed(ActionEvent arg0){
		
			sequencer.stop();//메트로놈 스탑
		 }
		 
	 
	 }
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}

```