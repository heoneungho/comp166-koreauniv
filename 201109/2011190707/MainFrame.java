import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ������ �����ϴ� Ŭ����
public class MainFrame extends JFrame { 

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   private Level		level		= Level.ROW;
   private MineGUI		mineGUI		= null;	

	// �޴�
   private JMenuBar		menuBar		= null;
   private JMenu		fileMenu	= null;
   private JMenuItem		newItem		= null;
   private JMenuItem		rowLvItem	= null;
   private JMenuItem		midlLvItem	= null;
   private JMenuItem		highLvItem	= null;

   private JMenuItem		exitItem	= null;

   private String		endString	= "����?";

  // MainFrame�� ������
  public MainFrame( String title ) {
   super( title );
   initMenu();
   setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   this.mineGUI = new MineGUI(this.level);
   this.setContentPane(this.mineGUI);
   this.pack();
   this.setCenterPosition();
   // frame icon 
   this.setResizable(false);
   this.setVisible(true);
	}

  // ���� Ŭ���� [ActionListener]

// �� �������� �ٲ� �� �̺�Ʈ�� �޴� Ŭ����
  class newActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		changeGame();
	}
  }

// ���� �ٲٴ� �̺�Ʈ�� �޴� Ŭ����
  class levelActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == rowLvItem ) {
			changeLevel(Level.ROW);
		} else if (e.getSource() == midlLvItem ) {
			changeLevel(Level.MIDDLE);
		} else {
			changeLevel(Level.HIGH);
		}
	}
  }

// ����� �̺�Ʈ�� �޴� Ŭ����
  class exitActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		int result;
		result = JOptionPane.showConfirmDialog( MainFrame.this, endString, "Game End", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
		if ( result == JOptionPane.YES_OPTION ) System.exit(0);
	}
  }

// �޴� �� �����ϴ� �޼ҵ� 
   public void initMenu() {
	menuBar		= new JMenuBar();
	fileMenu	= new JMenu( "����" );
	newItem		= new JMenuItem( "�� ����" );
	rowLvItem	= new JMenuItem( "�ʱ�" );
	midlLvItem	= new JMenuItem( "�߱�" );
	highLvItem	= new JMenuItem( "���" );
	exitItem	= new JMenuItem( "������" );
	
	newItem.addActionListener( new newActionListener() );
	rowLvItem.addActionListener( new levelActionListener() );
	midlLvItem.addActionListener( new levelActionListener() );
	highLvItem.addActionListener( new levelActionListener() );
	exitItem.addActionListener( new exitActionListener() );
	
	fileMenu.add( newItem );
	fileMenu.addSeparator();
	fileMenu.add( rowLvItem );
	fileMenu.add( midlLvItem );
	fileMenu.add( highLvItem );
	fileMenu.addSeparator();
	fileMenu.add( exitItem );
	
	menuBar.add( fileMenu );
	
	this.setJMenuBar( menuBar );
	}

  // ȭ��� �������� ũ�⸦ ���ϰ� ȭ�� �߾ӿ� �������� �������� ����
   public void setCenterPosition() {
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frm = this.getSize();
	int xpos = (int)( screen.getWidth() / 2 - frm.getWidth() / 2 );
	int ypos = (int)( screen.getHeight() / 2 - frm.getHeight() / 2 );
	this.setLocation( xpos, ypos );
	}

// ���� �ٲٱ�
   public void changeLevel(Level lv) {
	this.level = lv;
	changeGame();
	}

// ������ �ٽ� ���� 
   public void changeGame() {
	this.remove(this.mineGUI);
	this.mineGUI = new MineGUI(this.level);
	this.setContentPane(this.mineGUI);
	this.pack();
	this.setCenterPosition();
	this.setResizable(false);
	this.setVisible(true);
	}

// ���� �޼ҵ�
   public static void main ( String args[] ){
	new MainFrame( "���� ã��" );
	}
}