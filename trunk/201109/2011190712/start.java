
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class start implements ActionListener
{
    static JFrame frame;
    
    public static void main(String[] args) {
        start gui = new start();
        gui.go();    
           
       }
 public void go() {
	 // ù ���� ������
	 JFrame fr = new JFrame("Start"); 
     fr.setSize(250, 100);
     fr.setLayout(new FlowLayout());
     fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JPanel panel = new JPanel();   
     panel.setBackground(Color.pink);
     JButton button = new JButton("BMI ����");
     button.setBackground(Color.white);
     button.setLayout(null);
     button.setBounds(300, 200, 50, 50); //ũ������
     button.setLocation(20, 10); 
     button.setSize(300,300);
  
     JButton button2 = new JButton("����Į�θ� ����");
     button2.setBackground(Color.white);
     button2.setLayout(null);
     button2.setBounds(300, 200, 50, 50); 
     button2.setLocation(20, 10);
     button2.setSize(300,300);


     button.setContentAreaFilled(false); 
     button.setOpaque(true); 

     panel.add(button);
     button.addActionListener(this);
     panel.add(button2);
     button2.addActionListener(this);
  

     fr.add(panel);
     fr.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// ��ư Ŭ���� ���� �ߴ� ȭ��
	if( e.getActionCommand().equals("BMI ����")) {
 
        health gui1 = new health();
        gui1.go();
    }
 
	else if( e.getActionCommand().equals("����Į�θ� ����")) {
   
        calory gui2 = new calory();
        gui2.go();

    }


}
}


 
