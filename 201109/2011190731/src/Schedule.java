

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Schedule extends JFrame implements ActionListener{
    JTextField title; // 스케줄 제목
    JTextField place; // 장소
    JTextArea content; // 세부내용

   
    public Schedule()    {
       
        JButton delete, end, save, check; // 삭제, 종료, 저장, 스케줄확인 버튼
        JComboBox hour, minute, times;  // 시간

 
// 프레임을 크게 두개로 나누어서 한부분에는 제목, 장소, 시간을 넣고  다른 한 부분에는 내용과 버튼들을 넣는다.
// 패널을 나눌때 크기가 일정하게 되어서 내용부분의 패널이 작아지는 것을 막기 위해서 우선 두부분으로 나누었습니다.
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
        time.setLayout(new FlowLayout(FlowLayout.CENTER)); // 시간은 combobox를 이용해서 선택하도록 지정
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

        JScrollPane scroller = new JScrollPane(content);      // 내용부분에 스크롤 추가  
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
        	
// 제가 시도하고자 했던 것은 save를 하면 적었던 내용과 장소와 시간이 문자열로 전환되어서 
// check 버튼을 누르면 그 문자열들이 차례대로 찍히도록 하고자 했습니다.  
            
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

