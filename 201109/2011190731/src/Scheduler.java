import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.swing.*;
 

class Scheduler extends JFrame implements ActionListener
{
       String [] days = {"��","��","ȭ","��","��","��","��"};
       int year ,month,day,todays,memoday=0;
       
 

       Font f;
       Color bc,fc;
       Calendar today;
       Calendar cal;
 

 

       JButton btnBefore,btnAfter;
       JButton btnAdd,btnDel;
       JButton[] calBtn = new JButton[49];
 

       JLabel thing;
       JLabel time;
 

       JPanel panWest;
       JPanel panSouth;
       JPanel panNorth;
       JPanel panEast;     
       
       JTextField txtMonth,txtYear,txtWrite;
       JTextField txtTime;
       BorderLayout bLayout= new BorderLayout();     
       ////////////////////////////////////////
       Connection con = null;
       Statement stmt = null;
       
       String driver = "org.gjt.mm.mysql.Driver";
       String url = "jdbc:mysql://localhost:3306/bong";
       String user = "root";
       String pwd = "1234";
       ResultSet rs = null;       
 

       String sql,tempmemo ;
       public Scheduler(){
             today = Calendar.getInstance(); //����Ʈ�� Ÿ�� �� �� �������� ����� �޷��� �����ɴϴ�.
             cal = new GregorianCalendar();
             /*
              * GregorianCalendar ��,Calendar �� ���� ���� Ŭ�����̸�,
              * ������ ��κ��� �������� ���Ǵ� ǥ������ �޷� �ý����� �����մϴ�. 
              */
             year = today.get(Calendar.YEAR);
             month = today.get(Calendar.MONTH)+1;//1���� ���� 0 
 

             panNorth = new JPanel();
             panNorth.add(btnBefore = new JButton("Before"));            
             panNorth.add(txtYear = new JTextField(year+"��"));
             panNorth.add(txtMonth = new JTextField( month+"��"));
             txtYear.setEnabled(false);
             txtMonth.setEnabled(false);
             
             
             panNorth.add(btnAfter = new JButton("After"));
             f=new Font("Sherif",Font.BOLD,24);
             txtYear.setFont(f);
             txtMonth.setFont(f);       
             panNorth.add(btnAdd = new JButton("�޸��߰�"));
             panNorth.add(btnDel = new JButton("�޸����"));
             
             add(panNorth,"North");


             // �޷¿� ���� �ش��ϴ� �κ�
 

             panWest = new JPanel(new GridLayout(7,7));//���ڳ�,���������� ��ġ������
             f=new Font("Sherif",Font.BOLD,12);
             
             gridInit();
             calSet();
             hideInit();
             add(panWest,"West");
 

             panEast = new JPanel();          
             panEast.add(time = new JLabel("�޸�"));        
             panEast.add(txtWrite = new JTextField());
             txtWrite.setPreferredSize(new Dimension(200,150));
             //�޸� �Է¹��� �ؽ�Ʈ �ڽ��� ���� 200 ���� 50�� ����
             add(panEast,"East");
             
       
             
             btnBefore.addActionListener(this);
             btnAfter.addActionListener(this);       
             btnAdd.addActionListener(this);
             btnDel.addActionListener(this);
 

             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setTitle("Swing�� �̿��� JDBC �޸���");
             setBounds(100,100,600,300);
             setVisible(true);   
             
       }//end constuctor
       
       public void calSet(){
             cal.set(Calendar.YEAR,year);
             cal.set(Calendar.MONTH,(month-1));
             cal.set(Calendar.DATE,1);
             int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
             /*
              * get �� set �� ���� �ʵ�ġ��, ������ ��Ÿ���ϴ�.
              * �� �ʵ��� ����,SUNDAY,MONDAY,TUESDAY,WEDNESDAY
              * ,THURSDAY,FRIDAY, �� SATURDAY �� �˴ϴ�. 
              * get()�޼ҵ��� ���� ������ ���ڷ� ��ȯ
              */
 

             int j=0;
             int hopping=0;
             calBtn[0].setForeground(new Color(255,0,0));//�Ͽ��� "��"
             calBtn[6].setForeground(new Color(0,0,255));//����� "��"
             for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++){  j++;  }
             /*
              * �Ͽ��Ϻ��� �״��� ù���� ���ϱ��� ��ĭ���� �����ϱ� ���� 
              */
             hopping=j;
             for(int kk=0;kk<hopping;kk++){
                    calBtn[kk+7].setText("");
             }
             for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);
                           i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){
                 cal.set(Calendar.DATE,i);
                    if(cal.get(Calendar.MONTH) !=month-1){
                           break;
                    }
                    dbConnect();
                    todays=i;
                    checkday();
                    if(memoday==1){
                           calBtn[i+6+hopping].setForeground(new Color(0,255,0));                         
                    }
                    else{
                           calBtn[i+6+hopping].setForeground(new Color(0,0,0));
                           if((i+hopping-1)%7==0){//�Ͽ���
                                 calBtn[i+6+hopping].setForeground(new Color(255,0,0));
                           }
                           if((i+hopping)%7==0){//�����
                                 calBtn[i+6+hopping].setForeground(new Color(0,0,255));
                           }
                    }
                    /*
                     * ������ ���� �������� ����ؾ� �ϴ� ������ ���� ��ư�� ������ ���ϰ�
                     * �ε����� 0���� �����̴� -1�� ���� ������ ������ ���ְ�
                     * ��ư�� ������ �������ش�. 
                     */
                    calBtn[i+6+hopping].setText((i)+"");
             }//for
 

       }//end Calset()
       public void actionPerformed(ActionEvent ae){         
             if(ae.getSource() == btnBefore){
                    this.panWest.removeAll();
                    calInput(-1);
                    gridInit();
                    panelInit();               
                    calSet();
                    hideInit();
                    this.txtYear.setText(year+"��");
                    this.txtMonth.setText(month+"��");                   
             }                   
             else if(ae.getSource() == btnAfter){
                    this.panWest.removeAll();
                    calInput(1);
                    gridInit();
                    panelInit();
                    calSet();
                    hideInit();
                    this.txtYear.setText(year+"��");
                    this.txtMonth.setText(month+"��");                                       
             }
             else if(ae.getSource() == btnAdd){
                    dbConnect();
                    add();
                    calSet();
                    txtWrite.setText("");
                    
             }
             else if(ae.getSource() == btnDel){
                    dbConnect();
                    del();
                    calSet();
                    txtWrite.setText("");
             }
 

             else if(Integer.parseInt(ae.getActionCommand()) >= 1 && 
                    Integer.parseInt(ae.getActionCommand()) <=31){
                    day = Integer.parseInt(ae.getActionCommand());
                    //��ư�� ��� �� 1,2,3.... ���ڸ� ���������� ��ȯ�Ͽ� Ŭ���� ��¥�� �ٲ��ش�.
                    System.out.println(day);
                    dbConnect();               
                    searchmemo();
                    calSet();
             }      
       }//end actionperformed()
       public void hideInit(){
             for(int i = 0 ; i < calBtn.length;i++){
                    if((calBtn[i].getText()).equals(""))
                           calBtn[i].setEnabled(false);
                    //���� ������ ���� ������ ��ư�� ��Ȱ��ȭ ��Ų��. 
             }//end for
       }//end hideInit()
//     public void separate(){
 

       public void gridInit(){
         //jPanel3�� ��ư ���̱�
         for(int i = 0 ; i < days.length;i++)
               panWest.add(calBtn[i] = new JButton(days[i]));                   
 

          for(int i = days.length ; i < 49;i++){                
                    panWest.add(calBtn[i] = new JButton(""));                   
                    calBtn[i].addActionListener(this);
             }              
       }//end gridInit()
       
       public void panelInit(){
         GridLayout gridLayout1 = new GridLayout(7,7);
         panWest.setLayout(gridLayout1);   
       }//end panelInit()
       public void calInput(int gap){
             month+=(gap);
             if (month<=0){
                           month = 12;
                           year  =year- 1;
             }else if (month>=13){
                           month = 1;
                           year =year+ 1;
             }
       }//end calInput()
       public void dbConnect(){
             try{
                    Class.forName(driver);
                    con = DriverManager.getConnection(url,user,pwd);
                    stmt = con.createStatement();    
                    
             }catch(Exception ex){
                    ex.printStackTrace();
             }
       }//end dbConnect()
       public void add(){
             try{
                    String temp = txtWrite.getText();
                    if(temp.equals("")){
                           JOptionPane.showMessageDialog(null,"������ �����ϴ�.");
                           return;
                    }                   
                     sql = "insert into memo (memo,year,month,day) values (";                                                              
                     sql += "'"+temp+"',";
                     sql += "" +year +",";
                     sql += "" +month +",";
                     sql += "" +day +");";
                     System.out.println(sql);
                     stmt.executeUpdate(sql);  
                     
                    // txtWrite.setText("defg");
                     stmt.close();
                     con.close();
 

                    
             }catch(Exception e){
                    e.printStackTrace();
             }
       }//end add()
       public void del(){
             try{
                     sql = "delete from memo where year=";                                                              
                     sql += year +" and month=";
                     sql += month +" and day=";
                     sql += +day +";";
                     System.out.println(sql);
                     stmt.executeUpdate(sql);        
                     stmt.close();
                     con.close();              
             }
             catch(Exception e)
             {
                    e.printStackTrace();
             }
       }//end del();
       public void searchmemo(){
             try{
       
                     sql = "select memo from memo where year=";
                     sql += year +" and month=";
                     sql += month +" and day=";
                     sql += "" +day +";";
                     System.out.println(sql);
                     rs=stmt.executeQuery(sql);
                     String gettemp="";
                     while(rs.next()){
                           gettemp+=rs.getString("memo")+"  ";                         
                     }
                           txtWrite.setText(gettemp);
                     
                     stmt.close();
                     con.close();
 

             }catch(Exception e){
                    e.printStackTrace();
             }
       }//end searchmemo()
       public void checkday(){
             sql = "select * from memo where year=";
              sql += year +" and month=";
              sql += month +" and day=";
              sql += "" +todays +";";
       //     System.out.println(sql);
              try{
                     rs=stmt.executeQuery(sql);
                     if(rs.next()){
                            memoday=1;
                     }
                     else memoday=0;
                     
              }
              catch(Exception e)
              {
                     e.printStackTrace();
              }
 }//end checkday()
}//end class
