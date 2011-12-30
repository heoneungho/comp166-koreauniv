

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Schedule extends JFrame implements ActionListener{
    JTextField title; // ������ ����
    JTextField place; // ���
    JTextArea content; // ���γ���

   
    public Schedule()    {
       
        JButton delete, end, save, check; // ����, ����, ����, ������Ȯ�� ��ư
        JComboBox hour, minute, times;  // �ð�

 
// �������� ũ�� �ΰ��� ����� �Ѻκп��� ����, ���, �ð��� �ְ�  �ٸ� �� �κп��� ����� ��ư���� �ִ´�.
// �г��� ������ ũ�Ⱑ �����ϰ� �Ǿ ����κ��� �г��� �۾����� ���� ���� ���ؼ� �켱 �κκ����� ���������ϴ�.
        setLayout(new GridLayout(2, 1));
        JPanel p1 = new JPanel(); 
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        JPanel p2 = new JPanel(); 
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

       
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel middle1 = new JPanel(); 
        middle1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel middle2 = new JPanel();  
        middle2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel middle3 = new JPanel();  
        middle3.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel middle4 = new JPanel();  
        middle4.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
       
        title = new JTextField("", 28);
  
        JPanel time = new JPanel();
        time.setLayout(new FlowLayout(FlowLayout.CENTER)); // �ð��� combobox�� �̿��ؼ� �����ϵ��� ����
        hour = new JComboBox();
        minute = new JComboBox();
        times = new JComboBox();
     
        for(int i = 1; i <= 12; i++)
        	hour.addItem(i);
        for(int j = 00; j <60; j = j+10)
        	minute.addItem(j);
        times.addItem("am");
        times.addItem("pm");
        
        time.add(times);
        time.add(hour);
        time.add(minute);
       

        place = new JTextField("", 28);
        content = new JTextArea(8, 33);
        content.setLineWrap(true);
        delete = new JButton("Delete");
        save = new JButton("Save");
        end = new JButton("Close");
        check = new JButton("Check");


       
        top.add(new JLabel("Write your schedule"));
        middle1.add(new JLabel(" Title: "));
        middle1.add(title);
        middle2.add(new JLabel(" Time: "));
        middle2.add(time);
        middle3.add(new JLabel(" Place: "));
        middle3.add(place);
        middle4.add(new JLabel(" Contents : "));
        middle4.add(content);
        bottom.add(save);
        bottom.add(delete);
        bottom.add(end);
        bottom.add(check);

        JScrollPane scroller = new JScrollPane(content);      // ����κп� ��ũ�� �߰�  
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        middle4.add(scroller);
        
        p1.add(top);
        add(p1, BorderLayout.CENTER);
        p1.add(middle1);
        add(p1, BorderLayout.WEST);
        p1.add(middle2);
        add(p1, BorderLayout.WEST);
        p1.add(middle3);
        add(p1, BorderLayout.WEST);
        p2.add(middle4);
        add(p2, BorderLayout.WEST);
        p2.add(bottom);
        add(p2);
        delete.addActionListener(this);
        save.addActionListener(this);
        end.addActionListener(this);
        check.addActionListener(this);
       
    }
   
    public void actionPerformed(ActionEvent w)    {
        String t_content = null, t_place = null;
        String q = w.getActionCommand();
       
        if(q.equals("Close"))    {
            dispose();
        }
        else if(q.equals("Save"))	{
        	t_content = content.getText();
        	t_place = place.getText();
        	
// ���� �õ��ϰ��� �ߴ� ���� save�� �ϸ� ������ ����� ��ҿ� �ð��� ���ڿ��� ��ȯ�Ǿ 
// check ��ư�� ������ �� ���ڿ����� ���ʴ�� �������� �ϰ��� �߽��ϴ�.  
            
        }
        else if(q.equals("Check"))	{
        	JFrame frame = new JFrame();
        	
            frame.setTitle("ScheduleCheck");
            frame.setSize(400,200);
            setLayout(new GridLayout(2, 1));
            JPanel check = new JPanel();
            check.setLayout(new FlowLayout(FlowLayout.LEFT));
            
            check.add(new Label(t_place +"sdfs " + t_content));
            
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }
        
        else if(q.equals("Delete"))    {


            place.setText("");
            content.setText("");
           
        }

   
    }
}

