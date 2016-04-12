#Summery 2011190731 조승희




# Introduction #

제가 만든 프로그램은 'Scheduler'입니다. 첫화면은 달력이고 달력의 날짜를 클릭하면 스케줄을 입력하는 창이 나옵니다. 스케줄은 제목, 시간, 장소, 세부내용들을 적을 수 있습니다.

# Details #
```

// 달력
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calendar extends JFrame implements ItemListener{
    JFrame frame;
    JButton day[][];
   
    public Calendar(){
       
        Container ct = getContentPane();
        ct.setLayout(new FlowLayout(FlowLayout.CENTER));
        JComboBox yearChoice = new JComboBox(); 
        JComboBox monthChoice = new JComboBox();   
       
        yearChoice.addItem("2011"); 
        monthChoice.addItem("12"); 
       
        ct.add(yearChoice);
        ct.add(monthChoice);
       
        yearChoice.addItemListener(this);
        monthChoice.addItemListener(this);
       
        JPanel jp = new JPanel();
       
        jp.setLayout(new GridLayout(7,7));
        day = new JButton[7][7]; 
         jp.add(day[0][0] = new JButton("SUN")); 
        jp.add(day[0][1] = new JButton("MON"));
        jp.add(day[0][2] = new JButton("TUE"));
        jp.add(day[0][3] = new JButton("WED"));
        jp.add(day[0][4] = new JButton("THU"));
        jp.add(day[0][5] = new JButton("FRI"));
        jp.add(day[0][6] = new JButton("SAT"));
   
        ActionListener dateSetter = new ActionListener()    {
            public void actionPerformed(ActionEvent f)    {
                Schedule dia = new Schedule();
                dia.setTitle("Diary");
                dia.setSize(400, 500);
                dia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dia.setVisible(true);
            }
        };
       
        int b = 1;

        for(int i = 1; i <= 6; i++)		{
        	for(int j = 0; j <= 6; j++)	{
        		if(i == 1 && j <4)
        			jp.add(day[i][j] = new JButton());
        		else if(i == 6)	
        			jp.add(day[i][j] = new JButton());
                else    {
                    jp.add(day[i][j] = new JButton(b +""));
                    b++;
                    day[i][j].addActionListener(dateSetter);
		   
                }
        	}
        }
        
        
        ct.add(jp,BorderLayout.SOUTH);
    }
    public void itemStateChanged(ItemEvent ie)    {
    }
   
    public static void main(String[] args)    {
        Calendar main = new Calendar();
        main.setTitle("Calendar");
        main.setSize(550,280);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}

// 스케줄

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Schedule extends JFrame implements ActionListener{
    JTextField title; 
    JTextField place; 
    JTextArea content;
   
    public Schedule()    {
       
        JButton delete, end, save, check; 
        JComboBox hour, minute, times; 

 

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
        time.setLayout(new FlowLayout(FlowLayout.CENTER)); 
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

        JScrollPane scroller = new JScrollPane(content);  
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
```