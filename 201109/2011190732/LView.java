import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LView extends JPanel implements MouseListener, ActionListener
{
    int m_x = 100;
    int m_y = 100;
    int m_w = 50;
    int m_h = 50;

    int m_score = 0;
    int m_timer = 10;
    Timer t1, t2;

    Random m_rand = new Random();

    public LView()
     {
        this.addMouseListener(this);
        t1 = new Timer(1000, this);
        t1.start();
        t2 = new Timer(500, this);
        t2.start();

    }

    public void paint(Graphics g)
    {
        this.paintComponent(g);

            
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.getImage("mole.jpg");//윈도우에서 내컴퓨터의 c에 넣을경우,mole.jpg는 제가 저장해놓은 이미지에요!
        g.drawImage(image,m_x,m_y,40,40, this);
        g.drawString("score : "+m_score+ "    time : "+m_timer, 10, 10);
   
    }

    public void mouseClicked(MouseEvent e) {
        // new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int x, y;
        x = e.getX();
        y = e.getY();

        if(m_x <= x && x <= m_x+m_w)
        {
            if(m_y <= y && y < m_y+m_h)
            {
                m_score += 100;
                repaint();
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
       }

    public void mouseEntered(MouseEvent e) {  

  }

    public void mouseExited(MouseEvent e) {
        }

    public void actionPerformed(ActionEvent e) {
              if(t1 == e.getSource())
        {
            if(0 < m_timer )
            {
                m_timer --;
            }
            else if(m_timer <= 0)
            {
                t1.stop();
                t2.stop();
                JOptionPane.showMessageDialog(this, "game over ~~!!", "molegame", JOptionPane.INFORMATION_MESSAGE);
            }
            repaint();
        }
        else if(t2 == e.getSource())
        {
            m_x = m_rand.nextInt(400);
            m_y = m_rand.nextInt(400);
            repaint();
        }
    }
}

 
