import javax.swing.*;

public class LMainFrame extends JFrame {
  LView m_view = new LView();

     public LMainFrame()
     {
         add(m_view);

         setTitle("molegame");
         setSize(500, 500);
         setVisible(true);

         this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
     }
}