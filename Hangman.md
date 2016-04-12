Up Down 게임


[INTRODUCTION](INTRODUCTION.md)

1부터 50 까지의 숫자중 임의로 한 숫자( 이하 the number )를 컴퓨터가 지정합니다.
사용자가 그 숫자가 무엇인지 입력해서 맞을경우 맞다, 틀릴경우는
사용자가 말한 숫자보다 the number 가 큰지, 작은지를 알려주어 범위를 좁혀가며
숫자를 맞추는 게임입니다. 횟수에는 5번의 제한이 있습니다.


```
package UpAndDownGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class UpAndDownGameStarter {
     public static void main(String[] args) {

         UpAndDownGameStarter gui = new UpAndDownGameStarter();
                     gui.go();
   
     }
                 public void go(){
  
      
        
          JFrame frame = new JFrame();
          JPanel panel = new JPanel();
          panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
          panel.setBackground(Color.white);
          Font bigFont = new Font("serif",Font.BOLD,28);
        
          JLabel Title = new JLabel("Up & Down Game");
        
          JLabel body1 = new JLabel("Welcome to the Up&Down Game");
          JLabel body2 = new JLabel("Type the Number you guess");
          JLabel body3 = new JLabel(" ");
          JLabel body4 = new JLabel(" ");
          JLabel body5 = new JLabel(" ");
          JLabel body6 = new JLabel(" ");
          JLabel body7 = new JLabel(" ");
          JLabel body8 = new JLabel(" ");
          JLabel body9 = new JLabel(" ");
          JLabel body10 = new JLabel(" ");
        
        
        
              
          Title.setFont(bigFont);
 
              
              
                panel.add(Title);
                panel.add(body1);
                panel.add(body2);
                panel.add(body3);
                panel.add(body4);
                panel.add(body5);
                panel.add(body6);
                panel.add(body7);
                panel.add(body8);
                panel.add(body9);
                panel.add(body10);
                JButton Startbutton = new JButton(" Start ");
                panel.add(Startbutton);
         
             frame.getContentPane().add(BorderLayout.WEST,panel);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setSize(300,300);
              frame.setVisible(true);

         

                Startbutton.addActionListener(new StartListener());
                 
    
                 }

           
               
               
               
               
               
               
               
               
               
               
        class StartListener implements ActionListener{
            public void actionPerformed(ActionEvent event){

                UpAndDownGame udgame = new UpAndDownGame();
                Scanner scanner = new Scanner(System.in);
            
               
                while (true) {

                boolean isOverCount = udgame.checkOverCount();
            
                 if (isOverCount == true) {
                  break;
                 }

                 udgame.startGuessNumber();

                 int guessNumber = scanner.nextInt();

                 boolean isTargetNumber = udgame.checkGuessNumber(guessNumber);
                 if (isTargetNumber == true) {
                  break;
               
                 }
           
               
                }
          
            }
           
       
           
        }

              

}
      
      
   
```


















```

package UpAndDownGame;
import javax.swing.*;

 

 

import java.awt.Font;
import java.util.Random;
public class UpAndDownGame {
     int targetNumber;
     int guessNumber;
     int minNumber = 1;
     int maxNumber = 50;
     private int count = 1;
     Random random;
 
    
     UpAndDownGameSound sound = new UpAndDownGameSound();
    
    
    
     public UpAndDownGame() {
      sound.playlost(); 
      System.out.println("Up&Down Game세상에 오신것을 환영합니다");
      System.out.println("목표 숫자를 5번의 추측만에 맞추는 게임입니다.");
      this.random = new Random();
      this.targetNumber = random.nextInt(49) + 1;
      System.out.println("목표 숫자를 설정하였습니다.");

     }

     public void startGuessNumber() {
      System.out.println(count + "번째 추측을 시작합니다.");
      System.out.println(minNumber + "와" + maxNumber + "사이의 숫자를 입력하여 주세요.");
    
    
    
     }


     public boolean checkGuessNumber(int guessNumber) {
        
      if (targetNumber == guessNumber) {
       winMessage();
       return true;
      }
      else if ((minNumber <= guessNumber) && (guessNumber <= targetNumber)) {
          sound.play();
  
       this.count++;
       System.out.println("---UP---");
       this.minNumber = guessNumber + 1;
       return false;
      }
  
      else if ((maxNumber >= guessNumber) && (guessNumber >= targetNumber)) {
         sound.play();
       
          this.count++;
       System.out.println("--DOWN--");
       this.maxNumber = guessNumber - 1;
       return false;
      }
  
      else {
        sound.play();
       System.out.println("범위내의 숫자가 아닙니다.  다시 입력하세요.");
       return false;
      }
     }

     public boolean checkOverCount() {
      if (count>=6) {
       loseMessage();
       return true;
      } else {
       return false;
      }
     }

     public void winMessage(){
        

      sound.playwin();
         Font bigFont = new Font("serif",Font.BOLD,28);
            JFrame frame = new JFrame();
            JButton button = new    JButton("Correct !!" + "total trial :" + count+ "times" + ",   WIN");
            button.setFont(bigFont);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
            frame.getContentPane().add(button);
          
            frame.setSize(3000,3000);
          
            frame.setVisible(true);
      
        
        
        
         }


     private void loseMessage() {

      sound.playlost();
        System.out.println("5회를 넘겼습니다. GAME OVER.");
      System.out.println("Answer : " + targetNumber);
     }

}

 


```






















```


package UpAndDownGame;



import javax.sound.midi.*;

public class UpAndDownGameSound {

   
    public void play(){
       
        try {
           
            Sequencer player = MidiSystem.getSequencer();
            player.open();
           
            Sequence seq = new Sequence(Sequence.PPQ,4);
           
           
            Track track = seq.createTrack();
           
            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,74,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);
           
          
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,74,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);
           
           
            player.setSequence(seq);
           
            player.start();
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
    }



   
    public void playwin(){
       
        try {

                
                
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();
            
      
         
            
            

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,62,100);
            MidiEvent note1On = new MidiEvent(a,1);
            track.add(note1On);
           
         
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,62,100);
            MidiEvent note1Off = new MidiEvent(b,10);
            track.add(note1Off);
   
          
         
            // 도

            ShortMessage c = new ShortMessage();
            c.setMessage(144,2,66,100);
            MidiEvent note2On = new MidiEvent(c,5);
            track.add(note2On);
           
          
            ShortMessage d = new ShortMessage();
            d.setMessage(128,2,66,100);
            MidiEvent note2Off = new MidiEvent(d,15);
            track.add(note2Off);
           
            // 미
            ShortMessage e = new ShortMessage();
            e.setMessage(144,3,69,100);
            MidiEvent note3On = new MidiEvent(e,10);
            track.add(note3On);
           
          
            ShortMessage f = new ShortMessage();
            f.setMessage(128,3,69,100);
            MidiEvent note3Off = new MidiEvent(f,20);
            track.add(note3Off);
            
            // 솔
            
            ShortMessage g = new ShortMessage();
            g.setMessage(144,4,74,100);
            MidiEvent note4On = new MidiEvent(g,15);
            track.add(note4On);
           
          
            ShortMessage h = new ShortMessage();
            h.setMessage(128,4,74,100);
            MidiEvent note4Off = new MidiEvent(h,25);
            track.add(note4Off);
            
            // ^도

          
            
          player.setSequence(seq);
          player.start();
  

   
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
    }

    
    
    public void playlost(){
       
        try {

                
                
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();
            
      
         
            
            

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,60,100);
            MidiEvent note1On = new MidiEvent(a,1);
            track.add(note1On);
           
         
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,60,100);
            MidiEvent note1Off = new MidiEvent(b,47);
            track.add(note1Off);
            
            
            
            // 솔
            
            


            ShortMessage c = new ShortMessage();
            c.setMessage(144,1,76,100);
            MidiEvent note2On = new MidiEvent(c,7);
            track.add(note2On);
           
         
            ShortMessage d = new ShortMessage();
            d.setMessage(128,1,76,100);
            MidiEvent note2Off = new MidiEvent(d,17);
            track.add(note2Off);
            
            // 시

            ShortMessage e = new ShortMessage();
            e.setMessage(144,1,74,100);
            MidiEvent note3On = new MidiEvent(e,14);
            track.add(note3On);
           
         
            ShortMessage f = new ShortMessage();
            f.setMessage(128,1,74,100);
            MidiEvent note3Off = new MidiEvent(f,24);
            track.add(note3Off);
            
            //라
            
            ShortMessage g = new ShortMessage();
            g.setMessage(144,1,72,100);
            MidiEvent note4On = new MidiEvent(g,19);
            track.add(note4On);
           
         
            ShortMessage h = new ShortMessage();
            h.setMessage(128,1,72,100);
            MidiEvent note5Off = new MidiEvent(h,24);
            track.add(note5Off);
            
            
            ShortMessage z = new ShortMessage();
            z.setMessage(144,1,52,100);
            MidiEvent notez2On = new MidiEvent(z,19);
            track.add(notez2On);
           
         
            ShortMessage y = new ShortMessage();
            y.setMessage(128,1,52,100);
            MidiEvent notez2Off = new MidiEvent(y,47);
            track.add(notez2Off);
            
//솔 (시)
            

            ShortMessage i = new ShortMessage();
            i.setMessage(144,1,70,100);
            MidiEvent note6On = new MidiEvent(i,22);
            track.add(note6On);
           
         
            ShortMessage j = new ShortMessage();
            j.setMessage(128,1,70,100);
            MidiEvent note7Off = new MidiEvent(j,27);
            track.add(note7Off);
           

//파
            
            ShortMessage k = new ShortMessage();
            k.setMessage(144,1,69,100);
            MidiEvent note8On = new MidiEvent(k,25);
            track.add(note8On);
           
         
            ShortMessage l = new ShortMessage();
            l.setMessage(128,1,69,100);
            MidiEvent note8Off = new MidiEvent(l,30);
            track.add(note8Off);
            
//미
            
            ShortMessage m = new ShortMessage();
            m.setMessage(144,1,70,100);
            MidiEvent note9On = new MidiEvent(m,28);
            track.add(note9On);
           
         
            ShortMessage n = new ShortMessage();
            n.setMessage(128,1,70,100);
            MidiEvent note10Off = new MidiEvent(n,30);
            track.add(note10Off);
            
//파
            

            ShortMessage o = new ShortMessage();
            o.setMessage(144,1,62,100);
            MidiEvent note11On = new MidiEvent(o,31);
            track.add(note11On);
           
         
            ShortMessage p = new ShortMessage();
            p.setMessage(128,1,62,100);
            MidiEvent note12Off = new MidiEvent(p,36);
            track.add(note12Off);
            
//라
            

            ShortMessage q = new ShortMessage();
            q.setMessage(144,1,64,100);
            MidiEvent note13On = new MidiEvent(q,34);
            track.add(note13On);
           
         
            ShortMessage r = new ShortMessage();
            r.setMessage(128,1,64,100);
            MidiEvent note14Off = new MidiEvent(r,39);
            track.add(note14Off);
            
//시
            

            ShortMessage s = new ShortMessage();
            s.setMessage(144,1,65,100);
            MidiEvent note15On = new MidiEvent(s,37);
            track.add(note15On);
           
         
            ShortMessage t = new ShortMessage();
            t.setMessage(128,1,65,100);
            MidiEvent note16Off = new MidiEvent(t,50);
            track.add(note16Off);
            

//도
            ShortMessage sa = new ShortMessage();
            sa.setMessage(144,1,60,100);
            MidiEvent notea15On = new MidiEvent(sa,37);
            track.add(notea15On);
           
         
            ShortMessage ta = new ShortMessage();
            ta.setMessage(128,1,60,100);
            MidiEvent notea16Off = new MidiEvent(ta,50);
            track.add(notea16Off);
           
            
            ShortMessage ss = new ShortMessage();
            ss.setMessage(144,1,57,100);
            MidiEvent notes15On = new MidiEvent(ss,37);
            track.add(notes15On);
           
         
            ShortMessage ts = new ShortMessage();
            ts.setMessage(128,1,57,100);
            MidiEvent notes16Off = new MidiEvent(ts,50);
            track.add(notes16Off);
            
            // c코드
           
            
            
            
                      
            
          player.setSequence(seq);
          player.start();
  

   
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
    }


        
}

        





```