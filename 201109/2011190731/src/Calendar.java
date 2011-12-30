import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calendar extends JFrame implements ItemListener{ // 달력
    JFrame frame;
    JButton day[][];
   
    public Calendar(){
       
        Container ct = getContentPane();
        ct.setLayout(new FlowLayout(FlowLayout.CENTER));
        JComboBox yearChoice = new JComboBox(); // 년, 월  ComboBox로 지정
        JComboBox monthChoice = new JComboBox();   
       
        yearChoice.addItem("2011"); 
        monthChoice.addItem("12"); 
       
        ct.add(yearChoice);
        ct.add(monthChoice);
       
        yearChoice.addItemListener(this);
        monthChoice.addItemListener(this);
       
        JPanel jp = new JPanel();
       
        jp.setLayout(new GridLayout(7,7));
        day = new JButton[7][7]; // 달력 배열
        jp.add(day[0][0] = new JButton("SUN")); // 배열에 요일을 저장
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
		    // 버튼을 누르면 스케줄을 쓰는 프레임이 열린다.
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

