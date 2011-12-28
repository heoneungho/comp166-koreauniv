import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


class Game extends Frame implements ActionListener{
 Button leftB, upB, downB, rightB, End;
 Label la1;
 
 int[] x = {0,0,0,0,0,0,0,0,0,0,0};
 int[] y = {0,0,0,0,0,0,0,0,0,0,0};
 
 int i=1;
 int j=2;

 public Game(){
   super("BoxEscape");
  Panel p = new Panel(); 
  p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
  Panel p1 = new Panel(); 
  p1.setLayout(new GridLayout()); 
  
  leftB = new Button("←");
  upB =new Button("↑");
  downB =new Button("↓");
  rightB =new Button("→");
  la1 = new Label("Gaming");
  End = new Button("종료");
  JComboBox x = new JComboBox();
  JComboBox y = new JComboBox();
  
  
  x.addItem("Target"); //x[1]
  x.addItem("1"); //x[6]
  x.addItem("2"); //x[4]
  x.addItem("3"); //x[0]
  x.addItem("4"); //x[3]
  x.addItem("5"); //x[2]
  x.addItem("6"); //x[5]
  
  y.addItem("1"); //y[0]
  y.addItem("2"); //y[1]
  y.addItem("3"); //y[2]
  
  p.add(x);
  p.add(rightB);
  p.add(leftB);
  p.add(y);
  p.add(upB);
  p.add(downB);
  p1.add(la1);
  p1.add(End);


 
  this.add("South", p1); 
  this.add("East", p);
  
       
  setBounds(400,400,400,370); 
  setVisible(true); 
 
  leftB.addActionListener(this);  
  upB.addActionListener(this);  
  downB.addActionListener(this);
  rightB.addActionListener(this);
  End.addActionListener(this);
  x.addActionListener(new xListener());
  y.addActionListener(new yListener());
 
 
 }

 public void paint(Graphics g){ //콜백 메소드    
	 	g.setColor(Color.white);
		g.fillRect(0,  0,this.getWidth(), this.getHeight());
	
		g.setColor(Color.gray);
		g.fillRect(10, 20, 314, 314);
		
		g.setColor(Color.blue);
		g.fillRect(12+x[0], 74, 100, 50);
		
		g.setColor(Color.green);
		g.fillRect(116+x[1],126,100,50);
		
		g.setColor(Color.blue);
		g.fillRect(12+x[2],280,100,50);	
		
		g.setColor(Color.blue);
		g.fillRect(12+x[3],228,100,50);	
		
		g.setColor(Color.blue);
		g.fillRect(168+x[4],22,100,50);	
		
		g.setColor(Color.blue);
		g.fillRect(168+x[5],282,150,50);	
		
		g.setColor(Color.red);
		g.fillRect(116,178 + y[0],50,150);	
		
		g.setColor(Color.red);
		g.fillRect(168,178 + y[1],50,100);	
		
		g.setColor(Color.red);
		g.fillRect(272,25 + y[2],50,150);	
		
		g.setColor(Color.blue);
		g.fillRect(12+x[6],22,150,50);	
		
 }

 public void actionPerformed(ActionEvent e){
  if(e.getSource() == leftB){
	  x[i] -= 50;
	  if (i ==1)
	  {
		  if(x[i] == 0)
			  if (y[0] < 0 )
				  x[i] += 50;
		  if(x[i] == 50)
			  if (y[1] == -50 || y[1] == -100 )
				  x[i] += 50;
		  if (x[i] < -100)
			  x[i] += 50;
	  }
	  if ( i == 6)
	  {
		  if(x[i] < 0)
			  x[i] += 50;
	  }
	  if ( i == 4)
	  {
		  if(x[i] < 0)
			  x[i] += 50;
		  if(x[i] == 0)
			  if(x[6] == 50)
				  x[i] += 50;
	  }
	  if (i ==0)
	  {
		  if(x[i] == 100)
			  if (y[0] == -100 )
				  x[i] += 50;
		  if(x[i] == 150)
			  if (y[1] < -50)
				  x[i] += 50;
		  if(x[i] < 0)
			  x[i] += 50;
	  }
	  if (i == 3)
	  {
		  if (x[i] == 100)
			  if (y[0] <150 )
				  x[i] += 50;
		  if (x[i] == 150)
			  if (y[1] ==0 || y[1] == -50 )
				  x[i] += 50;
		  if (x[i] < 0)
			  x[i] += 50;
	  }
	  if (i == 2)
	  {
		  if (x[i] < 0)
			  x[i] += 50;
	  }
	  if (i == 5)
	  {
		  if (x[i] == -50)
			  if(x[2]== 50 || y[0] == 0 )
				  x[i] += 50;
		  if (x[i] < -50)
			  x[i] += 50;
			  
	  }
   repaint();
  }
  else if(e.getSource() == upB){
	  y[j] -= 50; 
	  if (j == 0)
	  {
		if(x[1] ==0 || x[1] == -50)
			y[j] += 50;
		if ( y[j] < -100)
			y[j] += 50;
	  }
	  if (j == 1)
	  {
		  if (x[1] ==0 || x[1] == 50)
			  y[j] += 50;
		  if (y[j] == -150)
			  if (x[4] == 0)
				  y[j] += 50;
		  if (y[j] < -150)
			  y[j] += 50;
		  if (y[j] == -100)
			  if (x[0] ==100 || x[0] ==150 )
				  y[j]+= 50;
	  }
	  if (j == 2)
	  {
		  if(y[j] == 0)
			  if(x[4] == 50)
				  y[j] += 50;
		  if(y[j] < 0)
			  y[j] +=50;
	  }
   repaint();
  }
  else if(e.getSource() == downB){
	  y[j] += 50;
	  if (j ==0 )
	  {
		  if(y[j] >0)
			  y[j] -= 50;
	  }
	  if (j ==1)
	  {
		  if (y[j] > 0)
			  y[j] -=50;
		  if (y[j] ==100)
			  if ( x[1] == 0 || x[1] == 50)
				  y[j] -= 50;
	  }
	  if( j== 2)
	  {
		  if (y[j] == 150)
			  if(x[5] == 0)
				  y[j] -= 50;
		  if (y[j] > 150)
			  y[j] -= 50;
	  }
   repaint();
  }
  else if(e.getSource() == rightB){
	  x[i] += 50;
	  if (i ==1)
	  {
	  if(y[2] <= 100)
		  if (x[i] >50 )
		  x[i] -= 50;
	  if (x [i] == 0)
		  if (y[1] == -50)
			  x[i] -= 50;
	  if (x [i] == -50)
		  if (y[0] == -50)
			  x[i] -= 50;
	  if (x[i]	> 150)
		  x[i] -= 50;
	  }
	  if ( i == 6)
	  {
		  if(x[4] == 0)
			  x[i] -= 50;	
		  if(x[i] > 50)
			  x[i] -= 50;
	  }
	  if ( i == 4)
	  {
		  if(y[2] == 0)
			  x[i] -= 50;
		  if (x[i] > 50)
			  x[i] -= 50;
	  }
	  if (i ==0)
	  {
		  if(x[i]==200)
			  if(y[2] <100 )
				  x[i] -= 50;
		  if (x[i] > 250)
			  x[i] -=50;
	  }
	  if (i == 3)
	  {
		  if(x[i] == 50)
			  if( y[0] >-100 )
				  x[i] -=50;
		  if(x[i] == 100)
			  if( y[1] >-50 )
				  x[i] -=50;
		  if(x[i] > 250)
			  x[i] -= 50;
	  }
	  if (i == 2)
	  {
		  if (x[i] == 50)
			  if (y [0] ==0)
				  x[i] -=50;
		  if (x[i] > 50)
			  x[i] -=50;
	  }
	  if (i == 5)
	  {
		  if( x[i] > 0 )
			  x[i] -=50;
		  if (x[i] == 0 )
			  if(y[2] == 150)
				  x[i] -=50;
	  }
	  if(x[1] > 100 )
		  la1.setText("Clear!!");
   repaint();
  }
  else if(e.getSource() == End) {
	  System.exit(0);

  }
 
 }
 
 
 public static void main(String[] args){
  new Game();
 }
 
 class yListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 JComboBox y = (JComboBox)e.getSource();
		 int index = y.getSelectedIndex();
		 if (index == 1 )
			 j = 0;
		 else if (index == 2)
			 j = 1;
		 else 
			 j = 2;
		
	 }
 }
 
 class xListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 JComboBox x = (JComboBox)e.getSource();
		 if (x.getSelectedIndex() == 1 )
			 i = 6;
		 else if (x.getSelectedIndex() == 2 )
			 i = 4;
		 else if (x.getSelectedIndex() == 3 )
			 i = 0;
		 else if (x.getSelectedIndex() == 4 )
			 i = 3;
		 else if (x.getSelectedIndex() == 5 )
			 i = 2;
		 else if (x.getSelectedIndex() == 6 )
			 i = 5;
		 else
			 i = 1;
		 
	 }
 }

}



