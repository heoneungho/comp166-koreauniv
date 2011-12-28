import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class health implements ActionListener {
     static JFrame frame;
     Font f1;
     Font f2;
     Label t;
     Label h;
     Label w;
     Label r;
     Label s;
     Label n;
     TextField h2;
     TextField w2;
     TextField r2;
     TextField r3;
     TextField n2;
     

        
        public void go() {
              JFrame frame = new JFrame("BMI Calculator");
              frame.setSize(450, 300);
              frame.setLayout(new FlowLayout());
              // 폰트 설정
              Font f1 = new Font("DialogInput", Font.BOLD, 20);
              Font f2 = new Font("SansSerif", Font.PLAIN, 15);
              JPanel panel2 = new JPanel();                
              JPanel panel3 = new JPanel();
              JPanel panel4 = new JPanel();
              JPanel panel5 = new JPanel();
              JPanel panel6 = new JPanel();
              // 패널 색상 결정
              panel2.setBackground(Color.pink);
              panel3.setBackground(Color.pink);
              panel4.setBackground(Color.white);
              panel5.setBackground(Color.white);
              panel6.setBackground(Color.white);
              // 라벨 생성   
                 h = new Label("Height : ");
                 w = new Label("Weight : ");
                 r = new Label("Result : ");
                 s = new Label("State  : ");
                 n = new Label("Weight : ");
                 h.setBounds(50,50,30,10);
                 w.setBounds(50,50,30,10);
                 r.setBounds(50,45,100,10);
                 s.setBounds(50,45,100,10);
                 n.setBounds(50,45,100,10);
                 // 폰트 적용
                 s.setFont(f1);
                 h.setFont(f1);
                 w.setFont(f1);
                 r.setFont(f1);
                 n.setFont(f1);
                 // 패널에 라벨 첨가
                 panel2.add(h);
                 panel3.add(w);
                 panel4.add(r);
                 panel5.add(s);
                 panel6.add(n);
                 // 텍스트 필드 생성
                 h2 = new TextField(5);
                 w2 = new TextField(5);
                 r2 = new TextField(35);
                 r3 = new TextField(35);
                 n2 = new TextField(35);
                 w2.setEchoChar('*');
                 panel2.add(h2);
                 panel3.add(w2);
                 panel4.add(r2);
                 panel5.add(r3);
                 panel6.add(n2);
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
                 ((JFrame) frame).getContentPane().add(panel2);      
            	 ((JFrame) frame).getContentPane().add(panel3);
            	 // 버튼 생성 클릭 시 BMI 지수 계산!
                 JButton button = new JButton("                         BMI(비만도)를 측정해보자                         "); 
                 button.setFont(f2);
                 button.addActionListener(this);
                 ((JFrame) frame).getContentPane().add(BorderLayout.CENTER, button);                       
                 ((JFrame) frame).getContentPane().add(panel4);     
                 ((JFrame) frame).getContentPane().add(panel5);        
                 ((JFrame) frame).getContentPane().add(panel6);  
              
                 h2.addActionListener(new health());
                 w2.addActionListener(new health());
                 r2.addActionListener(new health());
                 r3.addActionListener(new health());
                 n2.addActionListener(new health());
                 frame.setVisible(true);

        }
        public void actionPerformed(ActionEvent e){

        	double weight = Double.parseDouble(this.w2.getText());
        	double height = Double.parseDouble(this.h2.getText());
        	double nomal = (double) ((height-100) * 0.9);
        	double bmi = (double) weight / ((height * 0.01) * (height * 0.01));

    
            r2.setText("당신의 BMI지수는 "+bmi+"입니다.");
            // BMI 지수에 따라서 판단
            if(bmi<15.0) 
                r3.setText("당신의 비만도는 '병적인 저체중'입니다.");
            
            else if(15.0<bmi&&bmi<18.5) 
                r3.setText("당신의 비만도는 '저체중'입니다.");
            
            else if(18.5<bmi&&bmi<23.0) 
                r3.setText("당신의 비만도는 '정상'입니다.");
            
            else if(23.0<bmi&&bmi<27.5) 
                r3.setText("당신의 비만도는 '과체중'입니다.");

            else if(27.5<bmi&&bmi<40.0) 
                r3.setText("당신의 비만도는 '비만'입니다.");
            
            else if(40.0<bmi) 
                r3.setText("당신의 비만도는 '병적인 비만'입니다.");
            
            
            n2.setText("당신의 표준체중은 "+nomal+" 입니다. ");
            
            frame.repaint();

        }

}

