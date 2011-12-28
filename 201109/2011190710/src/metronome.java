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
	t1.setFont(bigFont);//�ؽ�Ʈ �ʵ� ����
	
	
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
	stbutton.setFont(bigFont);//��ư����
	
	panel.add(Title);
	panel.add(Title2);
	panel.add(t1);
	panel.add(sbutton);
	panel.add(stbutton);//�г� ����
	
	frame.getContentPane().add(BorderLayout.WEST,panel);
	frame.setSize(200,260);
	frame.setVisible(true);
	frame.setTitle("Metronome");//�����Ӽ���
	
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
			sequencer.setTempoInBPM(Integer.parseInt(t1.getText())/4);//�ؽ�Ʈ�ʵ忡�Է��� ���� ��Ƽ���� �ٲٸ� ���ڰ� �Ǳ⶧���� �׼��ڸ� ���ڷ� �����.
			//�̶� �� BPM�� 16����ǥ�� �ǹ��ϱ⶧���� 4�� �����༭ ����������� ��Ʈ�γ��� ������ 4����ǥ�� �ȴ�.
			sequencer.start();
		}catch(Exception ex){ex.printStackTrace();}
		}
		
	}
	 class stop implements ActionListener {

		 public void actionPerformed(ActionEvent arg0){
		
			sequencer.stop();//��Ʈ�γ� ��ž
		 }
		 
	 
	 }
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
