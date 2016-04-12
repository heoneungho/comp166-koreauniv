# Introduction #
두더지잡기게임입니다. 네모가 움직이고 네모를 클릭하면 점수가 올라갑니다. 네모가 움직이는 시간은 정해져있고 게임이 끝나면 game over~!!라는 메시지가 뜹니다.

# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages


CODE

LView 클래스

package molecatch;

import javax.swing.**;**

import javax.swing.Timer;

import java.awt.**;**

import java.awt.event.**;**

import java.util.**;**

public class LView extends JPanel implements MouseListener,
> ActionListener
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


> t1 = new Timer(1000, this);

> t1.start();

> t2 = new Timer(500, this);

> t2.start();

> }

> public void paint(Graphics g)
> {
> > this.paintComponent(g);


> //g.drawString("Mole", 10, 10);

> g.drawRect(m\_x, m\_y, 50, 50);

> g.drawString("score : "+m\_score+ "    time : "+m\_timer, 10, 10);
> }

> public void mouseClicked(MouseEvent e) {
> > // new UnsupportedOperationException("Not supported yet.");

> }

> public void mousePressed(MouseEvent e) {
> > //throw new UnsupportedOperationException("Not supported yet.");
> > int x, y;


> x = e.getX();

> y = e.getY();

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
> > //throw new UnsupportedOperationException("Not supported yet.");

> }

> public void mouseEntered(MouseEvent e) {
> > //throw new UnsupportedOperationException("Not supported yet.");

> }

> public void mouseExited(MouseEvent e) {
> > //throw new UnsupportedOperationException("Not supported yet.");

> }

> public void actionPerformed(ActionEvent e) {
> > //throw new UnsupportedOperationException("Not supported yet.");
> > if(t1 == e.getSource())
> > {
> > > if(0 < m\_timer )
> > > {
> > > > m\_timer --;

> > > }
> > > else if(m\_timer <= 0)
> > > {
> > > > t1.stop();


> t2.stop();

> JOptionPane.showMessageDialog(this, "game over ~~!!", "molecatch", JOptionPane.INFORMATION\_MESSAGE);
> }
> repaint();
> }
> else if(t2 == e.getSource())
> {
> > m\_x = m\_rand.nextInt(400);
> > m\_y = m\_rand.nextInt(400);
> > repaint();

> }
> }
}~~



LMainFrame 클래스
package molecatch;

import javax.swing.**;**

public class LMainFrame extends JFrame
{
> LView m\_view = new LView();

> public LMainFrame()
> {
> > add(m\_view);


> setTitle("molecatch");
> setSize(500, 500);
> setVisible(true);

> this.setDefaultCloseOperation(this.EXIT\_ON\_CLOSE);
> }
}

main클래스

package molecatch;

import molecatch.LMainFrame;

public class main {

> /
    * @param args the command line arguments
    * 
> public static void main(String[.md](.md) args)
> {
> > LMainFrame the = new LMainFrame();
> > // TODO code application logic here

> }

> }

네모에다가 사진이나 두더지 그림을 넣으려고 하는데 그건아직 시도중이에요ㅜㅋㅋ