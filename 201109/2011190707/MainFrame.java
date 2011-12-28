import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 프레임 생성하는 클래스
public class MainFrame extends JFrame { 

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   private Level		level		= Level.ROW;
   private MineGUI		mineGUI		= null;	

	// 메뉴
   private JMenuBar		menuBar		= null;
   private JMenu		fileMenu	= null;
   private JMenuItem		newItem		= null;
   private JMenuItem		rowLvItem	= null;
   private JMenuItem		midlLvItem	= null;
   private JMenuItem		highLvItem	= null;

   private JMenuItem		exitItem	= null;

   private String		endString	= "종료?";

  // MainFrame의 생성자
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

  // 내부 클래스 [ActionListener]

// 새 게임으로 바꿀 때 이벤트를 받는 클래스
  class newActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		changeGame();
	}
  }

// 레벨 바꾸는 이벤트를 받는 클래스
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

// 종료시 이벤트를 받는 클래스
  class exitActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		int result;
		result = JOptionPane.showConfirmDialog( MainFrame.this, endString, "Game End", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
		if ( result == JOptionPane.YES_OPTION ) System.exit(0);
	}
  }

// 메뉴 바 설정하는 메소드 
   public void initMenu() {
	menuBar		= new JMenuBar();
	fileMenu	= new JMenu( "게임" );
	newItem		= new JMenuItem( "새 게임" );
	rowLvItem	= new JMenuItem( "초급" );
	midlLvItem	= new JMenuItem( "중급" );
	highLvItem	= new JMenuItem( "고급" );
	exitItem	= new JMenuItem( "끝내기" );
	
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

  // 화면과 프레임의 크기를 정하고 화면 중앙에 프레임이 나오도록 설정
   public void setCenterPosition() {
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frm = this.getSize();
	int xpos = (int)( screen.getWidth() / 2 - frm.getWidth() / 2 );
	int ypos = (int)( screen.getHeight() / 2 - frm.getHeight() / 2 );
	this.setLocation( xpos, ypos );
	}

// 레벨 바꾸기
   public void changeLevel(Level lv) {
	this.level = lv;
	changeGame();
	}

// 게임을 다시 세팅 
   public void changeGame() {
	this.remove(this.mineGUI);
	this.mineGUI = new MineGUI(this.level);
	this.setContentPane(this.mineGUI);
	this.pack();
	this.setCenterPosition();
	this.setResizable(false);
	this.setVisible(true);
	}

// 메인 메소드
   public static void main ( String args[] ){
	new MainFrame( "지뢰 찾기" );
	}
}