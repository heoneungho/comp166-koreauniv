# Introduction #

두더지를 잡는게임입니다

# Details #

두더지의 그림이 렌덤으로 이동합니다. 그 두더지를 마우스로 클릭하면
점수가 올라가고 시간은 정해져있습니다.

LMainFrame 클래스


import javax.swing.**;**

public class LMainFrame extends JFrame {

> LView m\_view = new LView();

> public LMainFrame()
> {
> > add(m\_view);


> setTitle("molegame");
> setSize(500, 500);
> setVisible(true);

> this.setDefaultCloseOperation(this.EXIT\_ON\_CLOSE);
> }
}



LView 클래스

import javax.swing.**;**

import javax.swing.Timer;

import javax.swing.JOptionPane;

import java.awt.**;**

import java.awt.event.**;**

import java.util.**;**

public class LView extends JPanel implements MouseListener, ActionListener
{
> int m\_x = 100;
> int m\_y = 100;
> int m\_w = 50;
> int m\_h = 50;

> int m\_score = 0;
> int m\_timer = 10;
> Timer t1, t2;

> Random m\_rand = new Random();

> public LView()
> > {
> > > this.addMouseListener(this);
> > > t1 = new Timer(1000, this);
> > > t1.start();
> > > t2 = new Timer(500, this);
> > > t2.start();


> }

> public void paint(Graphics g)
> {
> > this.paintComponent(g);


> //g.drawString("sdasd", 10, 10);

> Toolkit tk = Toolkit.getDefaultToolkit();
> Image image = tk.getImage("c:/mole.jpg");
> g.drawImage(image,m\_x,m\_y,40,40, this);
> g.drawString("score : "+m\_score+ "    time : "+m\_timer, 10, 10);

> }

> public void mouseClicked(MouseEvent e) {
> > }


> public void mousePressed(MouseEvent e) {
> > int x, y;
> > x = e.getX();
> > y = e.getY();


> if(m\_x <= x && x <= m\_x+m\_w)
> {
> > if(m\_y <= y && y < m\_y+m\_h)
> > {
> > > m\_score += 100;
> > > repaint();

> > }

> }
> }

> public void mouseReleased(MouseEvent e) {
> > }


> public void mouseEntered(MouseEvent e) {
> > }


> public void mouseExited(MouseEvent e) {
> > }


> public void actionPerformed(ActionEvent e) {
> > if(t1 == e.getSource())
> > {
> > > if(0 < m\_timer )
> > > {
> > > > m\_timer --;

> > > }
> > > else if(m\_timer <= 0)
> > > {
> > > > t1.stop();
> > > > t2.stop();
> > > > JOptionPane.showMessageDialog(this, "game over ~~!!", "mole", JOptionPane.INFORMATION\_MESSAGE);

> > > }
> > > repaint();

> > }
> > else if(t2 == e.getSource())
> > {
> > > m\_x = m\_rand.nextInt(400);
> > > m\_y = m\_rand.nextInt(400);
> > > repaint();

> > }

> }
}~~




Main클래스



public class Main {
> public static void main(String[.md](.md) args)
> > {
> > > LMainFrame the = new LMainFrame();


> }
}