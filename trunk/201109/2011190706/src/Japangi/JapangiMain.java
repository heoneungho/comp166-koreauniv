package Japangi;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

class Japangi extends JFrame implements ActionListener{

	private Container container = this.getContentPane();

	private JRadioButton cola,orange,hwanta,milk;
	private ButtonGroup bg;
	private JPanel drinkPanel;

	private JButton colaB,orangeB,hwantaB,milkB;
	private ImageIcon colaImage,orangeImage,hwantaImage,milkImage;
	private JPanel imagePanel;

	private JTextField jtf;
	private JButton mony;
	private JPanel monyPanel;

	private String str;

	public Japangi(){
		super("aaa");
		this.componentLayout();
		this.eventHandling();
		this.setSize(500,700);
		this.setVisible(true);
	}

	public void componentLayout(){

		container.setLayout(new BorderLayout());

		drinkPanel = new JPanel(new GridLayout(1,4));
		cola = new JRadioButton("Cola");
		orange = new JRadioButton("Orange");
		hwanta = new JRadioButton("Hwanta");
		milk = new JRadioButton("Milk");

		bg = new ButtonGroup();
		bg.add(cola);
		bg.add(orange);
		bg.add(hwanta);
		bg.add(milk);

		drinkPanel.add(cola);
		drinkPanel.add(orange);
		drinkPanel.add(hwanta);
		drinkPanel.add(milk);

		container.add("North",drinkPanel);

		colaImage = new ImageIcon("cola.jpg");
		orangeImage = new ImageIcon("orange.jpg");
		hwantaImage = new ImageIcon("hwanta.jpg");
		milkImage = new ImageIcon("milk.jpg");


		colaB = new JButton(colaImage);
		orangeB = new JButton(orangeImage);
		hwantaB = new JButton(hwantaImage);
		milkB = new JButton(milkImage);
		imagePanel = new JPanel(new GridLayout(1,4));
		imagePanel.add(colaB);
		imagePanel.add(orangeB);
		imagePanel.add(hwantaB);
		imagePanel.add(milkB);

		container.add("Center",imagePanel);

		jtf = new JTextField();
		mony = new JButton("Bill Injection(1000Won)");
		monyPanel = new JPanel(new GridLayout(1,2));
		monyPanel.add(jtf);
		monyPanel.add(mony);

		container.add("South",monyPanel);


	}

	public void eventHandling(){

		cola.addActionListener(this);
		orange.addActionListener(this);
		hwanta.addActionListener(this);
		milk.addActionListener(this);

		mony.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == cola){

			str = "Cola";
			jtf.setText(str);

			colaB.setEnabled(true);
			orangeB.setEnabled(false);
			hwantaB.setEnabled(false);
			milkB.setEnabled(false);

		}
		else if(e.getSource() == orange){
			
			str = "Orange";
			jtf.setText(str);

			orangeB.setEnabled(true);
			colaB.setEnabled(false);
			hwantaB.setEnabled(false);
			milkB.setEnabled(false);

		}
		else if(e.getSource() == hwanta){

			str = "Hwanta";
			jtf.setText(str);

			hwantaB.setEnabled(true);
			orangeB.setEnabled(false);
			colaB.setEnabled(false);
			milkB.setEnabled(false);
		}
		else if(e.getSource() == milk){

			str = "Milk";
			jtf.setText(str);

			milkB.setEnabled(true);
			orangeB.setEnabled(false);
			colaB.setEnabled(false);
			hwantaB.setEnabled(false);
		}
		else if(e.getSource() == mony){

			
			
			if(str == null){
			JOptionPane.showMessageDialog(this,"Choose the beverage first.");
			}
			else{
				drink();
			}
			
		}
	}

	public void drink(){
		
		JapangiSound sound = new JapangiSound();

		
		if(str == "Cola"){
			new Cola();
			sound.play();
		}
		else if(str == "Hwanta"){
			new Hwanta();
			sound.play();
		}
		else if(str == "Orange"){
			new Orange();
			sound.play();
		}
		else if(str == "Milk"){
			new Milk();
			sound.play();
		}

	}

}


public class JapangiMain{
	public static void main(String args[]){
		new Japangi();
	}
}