package Japangi;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Orange extends JFrame{
	private Container con = this.getContentPane();
	private ImageIcon colaImage = new ImageIcon("orange.jpg");
	private JButton jb = new JButton(colaImage);

	public Orange(){

		this.componentLayout();
		this.setSize(100,100);
		this.setVisible(true);
	
	}
	public void componentLayout(){
		con.setLayout(new BorderLayout());
		con.add("Center",jb);
	}

}