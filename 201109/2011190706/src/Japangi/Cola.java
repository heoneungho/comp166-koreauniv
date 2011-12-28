package Japangi;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Cola extends JFrame{
	private Container con = this.getContentPane();
	private ImageIcon colaImage = new ImageIcon("cola.jpg");
	private JButton jb = new JButton(colaImage);

	public Cola(){

		this.componentLayout();
		this.setSize(100,100);
		this.setVisible(true);
	
	}
	public void componentLayout(){
		con.setLayout(new BorderLayout());
		con.add("Center",jb);
	}

}