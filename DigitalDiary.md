# Introduction #

다이어리를 사야겠다고 생각했지만 매번 미루게 되어서 이참에 앱으로 만들어서 써야겠다고 생각하였습니다.

# Details #

제 다이어리에는 일정입력/ 일정보기(일) / 일정보기(월) / 메모장 / 종료  5개의 메뉴가 있습니다.

1.일정입력 : 사용자가 월,일을 입력후 일정을 직접 입력합니다.
만약 해당 날짜에 추가적인 일정을 입력하고 싶을 시 해당 날짜를 한번 더 치면
기존의 일정에다 추가로 일정을 추가할 것인지, 일정을 삭제하고 새로 일정을 추가 할 것인지 물어봅니다.

2.일정보기(일) :  사용자에게 입력받은 날짜(월,일) 에 쓰여진 스케쥴을 출력해줍니다.

3.일정보기(월) :  사용자에게 월을 입력받고, 해당 월에 있는 모든 스케쥴을 출력해줍니다.
(ex - 5일  : 10시 기상   13일 : 2시 친구와 밥약속)

4.메모장  : 간단한 메모장을 띄웁니다.

5.종료    : 다이어리를 닫습니다.

또한 각 메뉴를 활성시킬때마다 사운드가 들리도록 해봤습니다. 사운드의 주제는 호러입니다.

클래스목록 : Diary,DiaryStart,Year,Month,Month1,Month2,Month3,Day,Memo,FunctionGui





```


public abstract class Diary {
	public abstract Diary go(); 
}


import java.util.Scanner;
public class Year extends Diary{
	
		Month1 Feb = new Month1();
		Month2 Apr = new Month2();
		Month2 Jun = new Month2();
		Month2 Sep = new Month2();
		Month2 Nov = new Month2();
		Month3 Jan = new Month3();
		Month3 Mar = new Month3();
		Month3 May = new Month3();
		Month3 Jul = new Month3();
		Month3 Aug = new Month3();
		Month3 Oct = new Month3();
		Month3 Dec = new Month3();
		Month[] Month1 = {Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec}; // Month들 만들고 배열또한 선언해줍니다(월별 일정보기에 이용)
	
	public Diary go()
	{
		
		Month[] Months = new Month[13];
		
		Months[1] = Jan;
		Months[2] = Feb;
		Months[3] = Mar;
		Months[4] = Apr;
		Months[5] = May;
		Months[6] = Jun;
		Months[7] = Jul;
		Months[8] = Aug;
		Months[9] = Sep;
		Months[10]= Oct;
		Months[11]= Nov;
		Months[12]= Dec;
		System.out.println("달을 입력하세요:");
		Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Month a = Months[b];
        return a;
	}
	
	
	
}



public abstract class Month extends Diary {
	    
		Day one = new Day();
		Day two = new Day();
		Day three = new Day();
		Day four = new Day();
		Day five = new Day();
		Day six = new Day();
		Day seven = new Day();
		Day eight = new Day();
		Day nine = new Day();
		Day ten = new Day();
		Day eleven = new Day();
		Day twelve = new Day();
		Day thirteen = new Day();
		Day fourteen = new Day();
		Day fifteen = new Day();
		Day sixteen = new Day();
		Day seventeen = new Day();
		Day eighteen = new Day();
		Day ninteen = new Day();
		Day twenty = new Day();
		Day twentyone = new Day();
		Day twentytwo = new Day();
		Day twentythree = new Day();
		Day twentyfour = new Day();
		Day twentyfive = new Day();
		Day twentysix = new Day();
		Day twentyseven = new Day();
		Day twentyeight = new Day();
		Day twentynine = new Day();
		Day thirty = new Day();
		Day thirtyone = new Day();
		Day[] Day1 = {one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,ninteen,twenty,twentyone,twentytwo,twentythree,twentyfour,twentyfive,twentysix,twentyseven,twentyeight,twentynine,thirty,thirtyone};
		// 역시 월별 일정보기에 이용하기 위해 배열로 묶어줍니다.
		public abstract Diary go();
		
}





import java.util.Scanner;
public class Month1 extends Month {
	
	public Diary go()
	{
		Day[] Days;
		Days = new Day[30];
		Days[1] = one;
		Days[2] = two;
		Days[3] = three;
		Days[4] = four;
		Days[5] = five;
		Days[6] = six;
		Days[7] = seven;
		Days[8] = eight;
		Days[9] = nine;
		Days[10] = ten;
		Days[11]= eleven;
		Days[12]= twelve;
		Days[13]= thirteen;
		Days[14]= fourteen;
		Days[15]= fifteen;
		Days[16]= sixteen;
		Days[17]= seventeen;
		Days[18]= eighteen;
		Days[19]= ninteen;
		Days[20]= twenty;
		Days[21]= twentyone;
		Days[22]= twentytwo;
		Days[23]= twentythree;
		Days[24]= twentyfour;
		Days[25]= twentyfive;
		Days[26]= twentysix;
		Days[27]= twentyseven;
		Days[28]= twentyeight;
		Days[29]= twentynine;
		System.out.println("일을 입력하세요:");
		Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Day a = Days[b];
        return a;
	}
	
	
}

import java.util.Scanner;
public class Month2 extends Month {
	
	public Diary go()
	{
		Day[] Days;
		Days = new Day[31];
		Days[1] = one;
		Days[2] = two;
		Days[3] = three;
		Days[4] = four;
		Days[5] = five;
		Days[6] = six;
		Days[7] = seven;
		Days[8] = eight;
		Days[9] = nine;
		Days[10] = ten;
		Days[11]= eleven;
		Days[12]= twelve;
		Days[13]= thirteen;
		Days[14]= fourteen;
		Days[15]= fifteen;
		Days[16]= sixteen;
		Days[17]= seventeen;
		Days[18]= eighteen;
		Days[19]= ninteen;
		Days[20]= twenty;
		Days[21]= twentyone;
		Days[22]= twentytwo;
		Days[23]= twentythree;
		Days[24]= twentyfour;
		Days[25]= twentyfive;
		Days[26]= twentysix;
		Days[27]= twentyseven;
		Days[28]= twentyeight;
		Days[29]= twentynine;
		Days[30]= thirty;
		System.out.println("일을 입력하세요:");
		Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Day a = Days[b];
        return a;
	}
	
	
}



import java.util.Scanner;
public class Month3 extends Month{
	
	public Diary go()
	{
		Day[] Days;
		Days = new Day[32];
		Days[1] = one;
		Days[2] = two;
		Days[3] = three;
		Days[4] = four;
		Days[5] = five;
		Days[6] = six;
		Days[7] = seven;
		Days[8] = eight;
		Days[9] = nine;
		Days[10] = ten;
		Days[11]= eleven;
		Days[12]= twelve;
		Days[13]= thirteen;
		Days[14]= fourteen;
		Days[15]= fifteen;
		Days[16]= sixteen;
		Days[17]= seventeen;
		Days[18]= eighteen;
		Days[19]= ninteen;
		Days[20]= twenty;
		Days[21]= twentyone;
		Days[22]= twentytwo;
		Days[23]= twentythree;
		Days[24]= twentyfour;
		Days[25]= twentyfive;
		Days[26]= twentysix;
		Days[27]= twentyseven;
		Days[28]= twentyeight;
		Days[29]= twentynine;
		Days[30]= thirty;
		Days[31]= thirtyone;
		System.out.println("일을 입력하세요:");
		Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Day a = Days[b];
        return a;
	}
	
	
	}



import java.io.*;
import java.util.Scanner;


public class Day extends Diary implements Memo {

	String[] i = new String[100]; //충분한 공간확보를 위해 배열의 size를 100으로 지정해줍니다.
	int d = 0;
	
	
	public Diary go() {
		return null;
	}
	public void GetMemo() {
		if( i[d]!=null ){  //현재 배열의 값에 일정이 있을 경우
			System.out.println("이미 일정이 있습니다. 일정추가-1 / 일정 모두 삭제 및 수정-2 : ");
			char c;
			try {
				c = (char) System.in.read();
				if( c == '2'){
					   for( int q = 0; i[q] != null; q++){
					   i[q] = null;	   
					   }
					   d = 0;	// i[0]부터 null 값이 아닌 모든 값을 리셋해줍니다.그리고 배열은 다시 i[0]으로 위치시킵니다.			
					   System.out.print("새로운 일정을 입력하세요: ");
					   Scanner  scan  =  new  Scanner (System.in);
				       i[d] = scan.next();
			           
				}
				else if( c == '1'){
				d++;
				System.out.print("추가 일정을 입력하세요: ");
			    Scanner  scan  =  new  Scanner (System.in);
			    i[d] = scan.next(); // 기존 일정을 그대로 두고 다음 스트링인 i[d]에 일정을 입력받습니다.
					
				}
				else{
				       System.out.print(" Error ! ");  //1이나 2가 아닌 값을 받았을 시 error 메세지를 출력합니다.
				}
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}	
		}  
		else{                // i[d]가 null일 경우. 즉 일정이 없을 경우.
		   System.out.print("일정을 입력하세요: ");
	           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   try {
			i[d] = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	       
		}
		}
		
	       		
	

	public void PrintMemo() {
		for(int a=0; i[a] != null ; a++){   // i[0] 부터 쭉  null이 나오기 전까지 print시켜줍니다.
		System.out.printf("%s",i[a]);
		System.out.println(" ");
		}
	}
	
	
	

}



public interface Memo {
	public abstract void GetMemo();
	public abstract void PrintMemo();
}




public class DiaryStart {

	public static void main(String[] args){
		  
			FunctionGui gui = new FunctionGui();
			gui.start();	
	    }
}

import javax.sound.midi.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class FunctionGui {

	JFrame frame;        // 메인 프레임
	JFrame frame1;       // 메모장 용 프레임1
	
	Year A = new Year();  // 다이어리에 사용할 Year 객체 생성
	public void start(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button1 = new JButton(" 종료 ");    // 버튼 5개 만들고 리스너와 연결
		button1.addActionListener(new Listener1());
		JButton button2 = new JButton(" 일정 입력 하기 ");
		button2.addActionListener(new Listener2());
		JButton button3 = new JButton(" 메모 하기 ");
		button3.addActionListener(new Listener3());
		JButton button4 = new JButton(" 일정 보기 (일) ");
		button4.addActionListener(new Listener5());
		JButton button5 = new JButton(" 일정 보기(월) ");
		button5.addActionListener(new Listener6());
		JPanel panel = new JPanel();
		panel.add(button2);
		panel.add(button4);
		panel.add(button5);
		panel.add(button3);
		panel.add(button1);
		frame.getContentPane().add(panel);
		frame.setSize(300,110);
		frame.setVisible(true);
		
		frame1 = new JFrame();         // 메모장 생성
		JPanel panel1 = new JPanel();
		JTextArea text = new JTextArea(15,30);
		text.setText(" 작성하세요. ");
		panel1.add(text);
		frame1.getContentPane().add(panel1);
		frame1.setSize(400,350);
		JButton button6 = new JButton(" 이전 ");
		button6.addActionListener(new Listener4());
		panel1.add(button6);
		
	}
	class Listener1 implements ActionListener {   // 종료 버튼에 대한 콜백 함수
	   public void actionPerformed(ActionEvent event){
		  
		   try {                              // 버튼 클릭시 소리 나게 설정
			Sequencer sori = MidiSystem.getSequencer();
			 sori.open();
			 Sequence seq = new Sequence(Sequence.PPQ,4);
			 Track track = seq.createTrack();
			 
			 ShortMessage a = new ShortMessage();
			 a.setMessage(144,1,10,100);
			 MidiEvent SoriOn = new MidiEvent(a,1);
             track.add(SoriOn);
             
             ShortMessage b = new ShortMessage();
             b.setMessage(128,1,10,100);
             MidiEvent SoriOff = new MidiEvent(b,16);
             track.add(SoriOff);
             
             sori.setSequence(seq);
             sori.start();
		   }
		   catch( Exception ex ) {
			   ex.printStackTrace();
		   }
		  
		frame.setVisible(false);           // 프레임을 닫습니다.
	   }
	}
	class Listener2 implements ActionListener {  // 일정 입력버튼에 대한 콜백함수
	   public void actionPerformed(ActionEvent event){ 
		   
		   	try {                     // 소리 설정해줍니다.
				Sequencer sori = MidiSystem.getSequencer();
				 sori.open();
				 Sequence seq = new Sequence(Sequence.PPQ,4);
				 Track track = seq.createTrack();
				 
				 ShortMessage a = new ShortMessage();
				 a.setMessage(144,1,23,100);
				 MidiEvent SoriOn = new MidiEvent(a,1);
	             track.add(SoriOn);
	             
	             ShortMessage b = new ShortMessage();
	             b.setMessage(128,1,23,100);
	             MidiEvent SoriOff = new MidiEvent(b,16);
	             track.add(SoriOff);
	             
	             sori.setSequence(seq);
	             sori.start();
			   }
			   catch( Exception ex ) {
				   ex.printStackTrace();
			   }
		   	frame.setVisible(false); // 메인 프레임을 닫고 콘솔 화면으로 넘어갑니다.
		   	Month B = (Month) A.go(); 
			Day C = (Day) B.go();
			C.GetMemo();             // 월,일을 입력받고 일정을 입력합니다. 다형성이 성립되있기 때문에 입력한 일정은 계속 유지됩니다.
				
			frame.setVisible(true);  // 입력을 마쳤으니 다시 메인 프레임을 불러옵니다.
		   	
		   	
	   }
	}
	class Listener3 implements ActionListener {   // 메모 버튼에 대한 콜백 함수
		public void actionPerformed(ActionEvent event){
		
			try{                     // 소리 설정
			Sequencer sori = MidiSystem.getSequencer();
			 sori.open();
			 Sequence seq = new Sequence(Sequence.PPQ,4);
			 Track track = seq.createTrack();
			 
			 ShortMessage a = new ShortMessage();
			 a.setMessage(144,1,2,100);
			 MidiEvent SoriOn = new MidiEvent(a,1);
            track.add(SoriOn);
            
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,2,100);
            MidiEvent SoriOff = new MidiEvent(b,16);
            track.add(SoriOff);
            
            sori.setSequence(seq);
            sori.start();
		   }
		   catch( Exception ex ) {
			   ex.printStackTrace();
		   }
			frame.setVisible(false);      // 메인 프레임을 닫고
			frame1.setVisible(true);      // 메모장 프레임을 띄웁니다.
			
		}
	}
	class Listener4 implements ActionListener {   // 메모장 내 '이전' 버튼에 대한 콜백함수
        public void actionPerformed(ActionEvent event){
        	try{                                  // 소리 설정해줍니다.
    			Sequencer sori = MidiSystem.getSequencer();
    			 sori.open();
    			 Sequence seq = new Sequence(Sequence.PPQ,4);
    			 Track track = seq.createTrack();
    			 
    			 ShortMessage a = new ShortMessage();
    			 a.setMessage(144,1,1,100);
    			 MidiEvent SoriOn = new MidiEvent(a,1);
                track.add(SoriOn);
                
                ShortMessage b = new ShortMessage();
                b.setMessage(128,1,1,100);
                MidiEvent SoriOff = new MidiEvent(b,16);
                track.add(SoriOff);
                
                sori.setSequence(seq);
                sori.start();
    		   }
    		   catch( Exception ex ) {
    			   ex.printStackTrace();
    		   }
        	frame1.setVisible(false);           // 메모장을 닫습니다.       
        	frame.setVisible(true);             // 메인 프레임을 엽니다.
        	
        }
		
	}
	class Listener5 implements ActionListener {   // 일정보기(일) 에 대한 콜백함수
		public void actionPerformed(ActionEvent event){ 
        	try{                                     // 소리 설정
    			Sequencer sori = MidiSystem.getSequencer();
    			 sori.open();
    			 Sequence seq = new Sequence(Sequence.PPQ,4);
    			 Track track = seq.createTrack();
    			 
    			 ShortMessage a = new ShortMessage();
    			 a.setMessage(144,1,4,100);
    			 MidiEvent SoriOn = new MidiEvent(a,1);
                track.add(SoriOn);
                
                ShortMessage b = new ShortMessage();
                b.setMessage(128,1,4,100);
                MidiEvent SoriOff = new MidiEvent(b,16);
                track.add(SoriOff);
                
                sori.setSequence(seq);
                sori.start();
    		   }
    		   catch( Exception ex ) {
    			   ex.printStackTrace();
    		   }
        	frame.setVisible(false);           // 메인 프레임을 닫고 콘솔화면을 띄웁니다.
		   	Month B = (Month) A.go();        
			Day C = (Day) B.go();
			C.PrintMemo();              // 월,일 입력받고 일정을 출력합니다.
			frame.setVisible(true);     // 입력이 끝났으니 메인 프레임을 불러옵니다.
        	
	        }
    }
	class Listener6 implements ActionListener {  // 일정보기(월) 버튼에 대한 콜백함수
		public void actionPerformed(ActionEvent event){ //소리설정
			try{
    			Sequencer sori = MidiSystem.getSequencer();
    			 sori.open();
    			 Sequence seq = new Sequence(Sequence.PPQ,4);
    			 Track track = seq.createTrack();
    			 
    			 ShortMessage a = new ShortMessage();
    			 a.setMessage(144,1,3,100);
    			 MidiEvent SoriOn = new MidiEvent(a,1);
                track.add(SoriOn);
                
                ShortMessage b = new ShortMessage();
                b.setMessage(128,1,3,100);
                MidiEvent SoriOff = new MidiEvent(b,16);
                track.add(SoriOff);
                
                sori.setSequence(seq);
                sori.start();
    		   }
    		   catch( Exception ex ) {
    			   ex.printStackTrace();
    		   }
			   frame.setVisible(false);     // 메인 프레임을 닫고 콘솔화면으로 넘어갑니다.
			   System.out.println("달을 입력하세요:");  // 일정을 볼 달을 입력받습니다.
			   Scanner s1 = new Scanner(System.in);
		       int b = s1.nextInt();
		       Month B = A.Month1[b-1];             // Year객체 A안에서 입력받은 달을 지정합니다.
		       
		       for( int c = 0; c<31; c++){         // 입력받은 달의 1일부터 마지막 일 까지 일정을 출력합니다.
		    	   for(int d = 0;  B.Day1[c].i[d] != null ; d++){
		    	   
		    		   System.out.printf("%d일 : %s",c+1,B.Day1[c].i[d]);
		    		   System.out.println(" ");
		    	   }
		    	   
		    	   }
		       frame.setVisible(true);           // 다시 메인 프레임을 띄웁니다.
		       }
		       
		}
	}





```