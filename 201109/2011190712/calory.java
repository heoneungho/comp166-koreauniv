import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

 public class calory implements ItemListener, ActionListener {
     static JFrame f;
     Font f1;
     Font f2;
     JCheckBox male;
     JCheckBox female;
     Label s, a, t, h, w, r, rr, l, total;
     Choice style;     
     TextField a2, h2, w2, r2, l2, rr2, total2;
     

     public void go() {
    	 // 권장 칼로리 계산 프레임
    	 JFrame f = new JFrame("Calory Calculator");
         f.setSize(465, 380);
         f.setLayout(new FlowLayout());
         //폰트 설정
         f1 = new Font("DialogInput", Font.BOLD, 20);
         f2 = new Font("SansSerif", Font.PLAIN, 15);
         // 패널 생성
         JPanel panel0 = new JPanel();           
         JPanel panel1 = new JPanel(); 
         JPanel panel2 = new JPanel();                
         JPanel panel3 = new JPanel();
         JPanel panel4 = new JPanel();
         JPanel panel5 = new JPanel();
         JPanel panel6 = new JPanel();
         JPanel panel7 = new JPanel();
         // 패널의 색상 결정
         panel0.setBackground(Color.yellow);
         panel1.setBackground(Color.yellow);
         panel2.setBackground(Color.green);
         panel3.setBackground(Color.green);
         panel4.setBackground(Color.white);
         panel5.setBackground(Color.yellow);
         panel6.setBackground(Color.white);
         panel7.setBackground(Color.white);
         // 라벨 생성
         s = new Label("Sex : ");
         a = new Label("Age : ");
         h = new Label("Height  : ");
         w = new Label("Weight  : ");
         l = new Label("Life Activity Style :");
         r = new Label("Result  : ");
         rr = new Label("Result  : ");
         total = new Label("Total   : ");
         s.setBounds(50,50,30,10);
         a.setBounds(50,50,30,10);
         h.setBounds(50,50,30,10);
         w.setBounds(50,50,30,10);
                 
        l.setBounds(50,50,30,10);
        r.setBounds(50,50,30,10);
        rr.setBounds(50,50,30,10);
        total.setBounds(50,50,30,10);
        // 폰트 적용
        s.setFont(f1);
        a.setFont(f1);
        h.setFont(f1);
        w.setFont(f1);
        r.setFont(f1);
        rr.setFont(f1);
        l.setFont(f1);
        total.setFont(f1);
        // 패널에 라벨 첨가       
        panel0.add(s);
        panel1.add(a);
        panel2.add(h);
        panel3.add(w); 
        panel5.add(l);
        panel4.add(r);
        panel7.add(rr);
        panel6.add(total);
        // 텍스트 필드 생성         
        a2 = new TextField(5);
        h2 = new TextField(5);
        w2 = new TextField(5);
        r2 = new TextField(35);
        rr2 = new TextField(35);
        l2 = new TextField(35);
        total2 = new TextField(35);
        w2.setEchoChar('*');
        // 패널에 텍스트 필드 첨가       
        panel1.add(a2);
        panel2.add(h2);
        panel3.add(w2);
        panel7.add(l2);
        panel4.add(r2);
        panel6.add(total2);
        // 체크박스 생성                    
        male = new JCheckBox("MALE");
        female = new JCheckBox("FEMALE");
        panel0.add(male);
        panel0.add(female);
        male.setFont(f2);
        female.setFont(f2);
        // 4가지 선택 구문 생성
        style = new Choice();
        style.add("    아주 가벼운 활동");
        style.add("      가벼운 활동");
        style.add("         중등 활동");
        style.add("     아주 심한 활동");
        style.setSize(100, 50);
        style.setFont(f2);
                 
        panel5.add(style);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 프레임에 패널 첨가      
        ((JFrame) f).getContentPane().add(panel0); 
        ((JFrame) f).getContentPane().add(panel1); 
        ((JFrame) f).getContentPane().add(panel2);      
        ((JFrame) f).getContentPane().add(panel3);
        ((JFrame) f).getContentPane().add(panel5);
        // 버튼을 클릭하면 계산!
        JButton button = new JButton("            기초 대사량 + 활동 대사량 = 일일 권장 칼로리             "); 
        button.setFont(f2);       
        button.addActionListener(this);
        ((JFrame) f).getContentPane().add(BorderLayout.SOUTH, button);
        ((JFrame) f).getContentPane().add(panel4);     
        ((JFrame) f).getContentPane().add(panel7);  
        ((JFrame) f).getContentPane().add(panel6);  
        a2.addActionListener(new calory());
        h2.addActionListener(new calory());
        w2.addActionListener(new calory());
        l2.addActionListener(new calory());
        r2.addActionListener(new calory());
              
        f.setVisible(true);

        }
        
        public void actionPerformed(ActionEvent e){
        	// 더블로 변경
        	double weight = Double.parseDouble(this.w2.getText());
        	double height = Double.parseDouble(this.h2.getText());
        	double age = Double.parseDouble(this.a2.getText());
    
        	height /= 100;
        	double fd = 0;
        	double ffd = 0;

            // 남자와 여자에 따라서 다른 수식
        	if(male.isSelected())
        	{
        		fd=66+(13.7*weight)+(5*height)-(6.8*age);
                r2.setText("당신의 기초대사량은  "+fd+" kcal 입니다.");
        	}
        	else if(female.isSelected())
        	{
        		fd=655+(9.6*weight)+(1.8*height)-(4.7*age);
                r2.setText("당신의 기초대사량은  "+fd+" kcal 입니다.");
        	}
         
            // 활동 정도에 따라 다른 수식      
        	if(style.getSelectedIndex()==0) {
        		ffd = (double)fd*0.4;
        		l2.setText("당신의 활동대사량은  "+ffd+" kcal 입니다.");
        	}
        	else if(style.getSelectedIndex()==1) {
        		ffd = (double)fd*0.65;
        		l2.setText("당신의 활동대사량은  "+ffd+" kcal 입니다.");
        	}
        	else if(style.getSelectedIndex()==2) {
        		ffd = (double)fd*0.75;
        		l2.setText("당신의 활동대사량은  "+ffd+" kcal 입니다.");
        	}
        	else if(style.getSelectedIndex()==3) {
        		ffd = (double)fd*1;
        		l2.setText("당신의 활동대사량은  "+ffd+" kcal 입니다.");
        	}
         
        	double calory = (double)fd +ffd;
        	total2.setText("일일 권장 칼로리는 "+calory+" kcal 입니다.");
      
            f.repaint();

        }

  @Override
  			public void itemStateChanged(ItemEvent e) {
   // TODO Auto-generated method stub
   
  			}


}
 


 
