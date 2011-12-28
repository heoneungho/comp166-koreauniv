package Japangi;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Milk extends JFrame{
	private Container con = this.getContentPane();
	private ImageIcon milkImage = new ImageIcon("milk.jpg");
	private JButton jb = new JButton(milkImage);

	public Milk(){

		this.componentLayout();
		this.setSize(100,100);
		this.setVisible(true);
	
	}
	public void componentLayout(){
		con.setLayout(new BorderLayout());
		con.add("Center",jb);
	}

}