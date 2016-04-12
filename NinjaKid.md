닷컴게임과 너무 비슷하여 더 업그레이드를 시켜야하는데 업그레이드 시키는 방법이 너무 어려워서 아예 새로운 프로그램을 만들겠습니다.

새로운 프로그램은 자판기에서 음료수를 뽑는 프로그램입니다.(Japangi)

# Introduction #

실제 자판기와 같이, 여러 음료수가 있는 자판기에 사용자가 하나의 음료수를 고르고 돈을 넣으면 그 음료를 뽑는 프로그램입니다.


# Details #

일단 GUI로 화면을 만듭니다.
자판기 class와, 각 음료수마다 class를 하나씩 만듭니다
자판기에서 어떤음료를 먹을것인지 받은다음에, 그 객체를 하나 만듭니다.


package Japangi;

import java.awt.**;
import java.awt.event.**;


import javax.swing.**;**

class Japangi extends JFrame implements ActionListener{

> private Container container = this.getContentPane();

> private JRadioButton cola,orange,hwanta,milk;
> private ButtonGroup bg;
> private JPanel drinkPanel;

> private JButton colaB,orangeB,hwantaB,milkB;
> private ImageIcon colaImage,orangeImage,hwantaImage,milkImage;
> private JPanel imagePanel;

> private JTextField jtf;
> private JButton mony;
> private JPanel monyPanel;

> private String str;

> public Japangi(){
> > super("자판기");
> > this.componentLayout();
> > this.eventHandling();
> > this.setSize(500,700);
> > this.setVisible(true);

> }

> public void componentLayout(){

> container.setLayout(new BorderLayout());

> drinkPanel = new JPanel(new GridLayout(1,4));
> cola = new JRadioButton("Cola");
> orange = new JRadioButton("Orange");
> hwanta = new JRadioButton("Hwanta");
> milk = new JRadioButton("Milk");

> bg = new ButtonGroup();
> bg.add(cola);
> bg.add(orange);
> bg.add(hwanta);
> bg.add(milk);

> drinkPanel.add(cola);
> drinkPanel.add(orange);
> drinkPanel.add(hwanta);
> drinkPanel.add(milk);

> container.add("North",drinkPanel);

> colaImage = new ImageIcon("cola.jpg");
> orangeImage = new ImageIcon("orange.jpg");
> hwantaImage = new ImageIcon("hwanta.jpg");
> milkImage = new ImageIcon("milk.jpg");


> colaB = new JButton(colaImage);
> orangeB = new JButton(orangeImage);
> hwantaB = new JButton(hwantaImage);
> milkB = new JButton(milkImage);
> imagePanel = new JPanel(new GridLayout(1,4));
> imagePanel.add(colaB);
> imagePanel.add(orangeB);
> imagePanel.add(hwantaB);
> imagePanel.add(milkB);

> container.add("Center",imagePanel);

> jtf = new JTextField();
> mony = new JButton("Bill Injection(1000Won)");
> monyPanel = new JPanel(new GridLayout(1,2));
> monyPanel.add(jtf);
> monyPanel.add(mony);

> container.add("South",monyPanel);


> }

> public void eventHandling(){

> cola.addActionListener(this);
> orange.addActionListener(this);
> hwanta.addActionListener(this);
> milk.addActionListener(this);

> mony.addActionListener(this);
> }

> public void actionPerformed(ActionEvent e){
> > if(e.getSource() == cola){


> str = "Cola";
> jtf.setText(str);

> colaB.setEnabled(true);
> orangeB.setEnabled(false);
> hwantaB.setEnabled(false);
> milkB.setEnabled(false);

> }
> else if(e.getSource() == orange){

> str = "Orange";
> jtf.setText(str);

> orangeB.setEnabled(true);
> colaB.setEnabled(false);
> hwantaB.setEnabled(false);
> milkB.setEnabled(false);

> }
> else if(e.getSource() == hwanta){

> str = "Hwanta";
> jtf.setText(str);

> hwantaB.setEnabled(true);
> orangeB.setEnabled(false);
> colaB.setEnabled(false);
> milkB.setEnabled(false);
> }
> else if(e.getSource() == milk){

> str = "Milk";
> jtf.setText(str);

> milkB.setEnabled(true);
> orangeB.setEnabled(false);
> colaB.setEnabled(false);
> hwantaB.setEnabled(false);
> }
> else if(e.getSource() == mony){



> if(str == null){
> JOptionPane.showMessageDialog(this,"Choose the beverage first.");
> }
> else{
> > drink();

> }

> }
> }

> public void drink(){

> JapangiSound sound = new JapangiSound();


> if(str == "Cola"){
> > new Cola();
> > sound.play();

> }
> else if(str == "Hwanta"){
> > new Hwanta();
> > sound.play();

> }
> else if(str == "Orange"){
> > new Orange();
> > sound.play();

> }
> else if(str == "Milk"){
> > new Milk();
> > sound.play();

> }

> }

}


public class JapangiMain{
> public static void main(String args[.md](.md)){
> > new Japangi();

> }
}






package Japangi;

import java.awt.**;
import java.awt.event.**;

import javax.swing.**;**

public class Cola extends JFrame{
> private Container con = this.getContentPane();
> private ImageIcon colaImage = new ImageIcon("cola.jpg");
> private JButton jb = new JButton(colaImage);

> public Cola(){

> this.componentLayout();
> this.setSize(100,100);
> this.setVisible(true);

> }
> public void componentLayout(){
> > con.setLayout(new BorderLayout());
> > con.add("Center",jb);

> }

}





package Japangi;

import java.awt.**;
import java.awt.event.**;

import javax.swing.**;**

public class Hwanta extends JFrame{
> private Container con = this.getContentPane();
> private ImageIcon colaImage = new ImageIcon("hwanta.jpg");
> private JButton jb = new JButton(colaImage);

> public Hwanta(){

> this.componentLayout();
> this.setSize(100,100);
> this.setVisible(true);

> }
> public void componentLayout(){
> > con.setLayout(new BorderLayout());
> > con.add("Center",jb);

> }

}




package Japangi;

import java.awt.**;
import java.awt.event.**;

import javax.swing.**;**

public class Milk extends JFrame{
> private Container con = this.getContentPane();
> private ImageIcon milkImage = new ImageIcon("milk.jpg");
> private JButton jb = new JButton(milkImage);

> public Milk(){

> this.componentLayout();
> this.setSize(100,100);
> this.setVisible(true);

> }
> public void componentLayout(){
> > con.setLayout(new BorderLayout());
> > con.add("Center",jb);

> }

}





package Japangi;

import java.awt.**;
import java.awt.event.**;

import javax.swing.**;**

public class Orange extends JFrame{
> private Container con = this.getContentPane();
> private ImageIcon colaImage = new ImageIcon("orange.jpg");
> private JButton jb = new JButton(colaImage);

> public Orange(){

> this.componentLayout();
> this.setSize(100,100);
> this.setVisible(true);

> }
> public void componentLayout(){
> > con.setLayout(new BorderLayout());
> > con.add("Center",jb);

> }

}




---------------추후 업그레이드


package Japangi;

import javax.sound.midi.**;**

public class JapangiSound {


> public void play(){

> try {

> Sequencer player = MidiSystem.getSequencer();
> player.open();

> Sequence se = new Sequence(Sequence.PPQ,4);

> Track tr = se.createTrack();

> ShortMessage me1 = new ShortMessage();
> me1.setMessage(144,1,74,100);
> MidiEvent noteOn = new MidiEvent(me1,1);
> tr.add(noteOn);

> ShortMessage me2 = new ShortMessage();
> me2.setMessage(128,1,74,100);
> MidiEvent noteOff = new MidiEvent(me2,16);
> tr.add(noteOff);

> player.setSequence(se);

> player.start();
> } catch (Exception ex) {
> > ex.printStackTrace();

> }
> }
}