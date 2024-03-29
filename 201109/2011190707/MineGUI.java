import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MineGUI extends JPanel implements ActionListener {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  private Level		level		= Level.MIDDLE;
  private Game		game		= Game.READY;
  private int		ROWS		= 16;
  private int		COLS		= 16;
  private int		CELL_SIZE	= 20;
  private int		MINE		= 40;
  private int		checkMine	= 40;
  private int		flagCount	= 0;
  private JLabel[]	mineLabel	= null;

  private Tile[][] 	tile		= null;
  private File		file		= null;
  private JPanel progressPanel	        = null;
  private JPanel gamePanel		= null;

  // ImageIcon 필드

  private ImageIcon[]	numImgList	= null; 
  private ImageIcon[]	mineImgList	= null;
  private ImageIcon[] tileNumImgList	= null;
  private ImageIcon	defaultImage	= null;
  private ImageIcon	closeImage	= null;
  private ImageIcon	pressedImage	= null;
  private ImageIcon	wildcardImage	= null;
  private ImageIcon	flagImage	= null; 

  // Listener 내부 클래스 
  private TileActionListener[][] tileActionListener	= null;
  private TileMouseListener[][] tileMouseListener	= null;

  // MineGUI 생성자. 레벨에 맞게 크기설정하고 게임패널 만든다
  public MineGUI(Level lv) {
	if (lv == Level.ROW) {
		ROWS = 9;	COLS = 9;	MINE = 9;	checkMine = 9;
	} else if (lv == Level.MIDDLE) {
		ROWS = 16;	COLS = 16;	MINE = 40;	checkMine = 40;
	} else {
		ROWS = 16;	COLS = 30;	MINE = 99;	checkMine = 99;
	}
	level = lv;
	this.setLayout(new BorderLayout());
	setImageLoading();
	setProgressPane();
	setGamePane();
  }

  // image 받는 메소드. 이미지의 위치는 변경하면 됩니다
   public void setImageLoading() {
	numImgList = new ImageIcon[10];
	for ( int i = 0; i < 10; i++ )
		numImgList[i] = new ImageIcon("D:/java/" + i + "n.png");
		
	mineImgList = new ImageIcon[3];
	for (int i = 0; i < 3; i++)
		mineImgList[i] = new ImageIcon("D:/java/mine" +(i + 1) + ".gif");
		
	tileNumImgList = new ImageIcon[7];
	for (int i = 0; i < 7; i++)
		tileNumImgList[i] = new ImageIcon("D:/java/" +(i + 1) + ".png");
		
	defaultImage	= new ImageIcon("D:/java/default.gif");
	closeImage	= new ImageIcon("D:/java/close.gif");
	pressedImage	= new ImageIcon("D:/java/pressed.gif");
	wildcardImage	= new ImageIcon("D:/java/wildcard.gif");
	flagImage	= new ImageIcon("D:/java/flag.gif");
   }

  // 남은 지뢰, 버튼 초기화하는 메소드 

   public void setProgressPane() {
	progressPanel = new JPanel();
	progressPanel.setLayout( new GridLayout(1, 3) );

	JPanel Panel = new JPanel();
	JPanel minePanel = new JPanel();
		
	minePanel.setLayout( new GridLayout( 1, 3 ) );
	mineLabel = new JLabel[3];
	
	if ( MINE == 9 ) {
		mineLabel[0] = new JLabel( numImgList[0] ); 
		mineLabel[1] = new JLabel( numImgList[0] ); 
		mineLabel[2] = new JLabel( numImgList[9] );
	} else if ( MINE == 40 ) {
		mineLabel[0] = new JLabel( numImgList[0] ); 
		mineLabel[1] = new JLabel( numImgList[4] ); 
		mineLabel[2] = new JLabel( numImgList[0] );
	} else if ( MINE == 99 ) {
		mineLabel[0] = new JLabel( numImgList[0] ); 
		mineLabel[1] = new JLabel( numImgList[9] ); 
		mineLabel[2] = new JLabel( numImgList[9] );
	}
		
	minePanel.add( mineLabel[0] ); 
	minePanel.add( mineLabel[1] ); 
	minePanel.add( mineLabel[2] );
	Panel.add( minePanel );
		
	progressPanel.add ( Panel );
	this.add( progressPanel, BorderLayout.NORTH );
   }

   public void setGamePane() {
	gamePanel = new JPanel();
	gamePanel.setLayout(new GridLayout(ROWS, COLS));
	gamePanel.setPreferredSize(new Dimension(CELL_SIZE * COLS, CELL_SIZE * ROWS));
	setButtonTile();
	this.add( gamePanel, BorderLayout.CENTER );
	game = Game.READY;
   }

  public void setButtonTile() {
		
	int[][] map = configureMine();
		
	tile = new Tile[ROWS][COLS];
	tileActionListener = new TileActionListener[ROWS][COLS];
	tileMouseListener  = new TileMouseListener[ROWS][COLS];

	for (int r = 0; r < ROWS; r++) {
		for (int c = 0; c < COLS; c++) {
			tile[r][c] = new Tile( map[r][c], r, c, closeImage );
			
			tileActionListener[r][c] = new TileActionListener();
			tile[r][c].addActionListener( tileActionListener[r][c] );
			tileMouseListener[r][c] = new TileMouseListener();
			tile[r][c].addMouseListener( tileMouseListener[r][c] );
			
			tile[r][c].setPressedIcon( pressedImage );
			tile[r][c].setDisabledIcon( defaultImage );
			tile[r][c].setRolloverEnabled( false );
			gamePanel.add( tile[r][c] );
		}
	}
}

  // 지뢰를 랜덤으로 배치하고 지뢰주위 숫자 세팅.
   public int[][] configureMine() { 		
	int count = 0;
	int[][] map = new int[ROWS][COLS];
	for (int r = 0; r < ROWS; r++)
		for (int c = 0; c < COLS; c++)
			map[r][c] = 0;

	int [] dx = {-1,-1,-1,0,0,0,1,1,1};
	int [] dy = {-1,0,1,-1,0,1,-1,0,1};

	while(true) {
		int x = (int)(Math.random() * ROWS);
		int y = (int)(Math.random() * COLS);
		if (map[x][y] != 0) 
			continue;
		else {
			map[x][y] = -1;
			count++;
		}

		if (count == MINE) 
			break;
	}

	for (int r = 0; r < ROWS; r++) {
	  for (int c = 0; c < COLS; c++) {
	     if (map[r][c] == -1) {
		for (int i = 0; i < 9; i++) { 
			try {
				if (!(dx[i] == 0 && dy[i] == 0) && map[r+dx[i]][c+dy[i]] != -1)
					map[r+dx[i]][c+dy[i]]++;
			} catch(IndexOutOfBoundsException e){}
		}
	      }
	  }
	}
	return map;
  }

   public void spaceTileOpen(int r, int c) {
	if ( !validRange(r, c) ) return;
	if ( tile[r][c].getState() == State.OPEN ) return;
	if ( tile[r][c].getFace() == -1 ) return;
	if ( tile[r][c].getState() != State.FLAG ) {
		tile[r][c].setState( State.OPEN );
	} else return;
	if ( tile[r][c].getFace() != 0 && tile[r][c].getFace() != -1 ) {
		tile[r][c].setState( State.OPEN );
		return;
	}
	
	spaceTileOpen( r-1, c);
	spaceTileOpen( r+1, c);
	spaceTileOpen( r, c-1);
	spaceTileOpen( r, c+1);
	spaceTileOpen( r-1, c-1);
	spaceTileOpen( r-1, c+1);
	spaceTileOpen( r+1, c-1);
	spaceTileOpen( r+1, c+1);
   }

 //넘어온 좌표값의 범위가 벗어났는지 담당.(true, false)
   public boolean validRange(int r, int c) { 		
	return ( (r >= 0 && r < ROWS) && (c >= 0 && c < COLS) );
   }
   public void replaceTile() {
	for (int r = 0; r < ROWS; r++) {
		for (int c = 0; c < COLS; c++) {
			if ( tile[r][c].getState() == State.OPEN ) {
				if ( tile[r][c].getFace() != 0 && tile[r][c].getFace() != -1 ) {
					tile[r][c].setDisabledIcon( tileNumImgList[tile[r][c].getFace() -1] );
				}
				tile[r][c].setEnabled(false);
			}
		}
	}
  }

   public void GameOver() {
	for (int r = 0; r < ROWS; r++) {
		for (int c = 0; c < COLS; c++) {
			tile[r][c].removeActionListener(tileActionListener[r][c]);
			tile[r][c].removeMouseListener(tileMouseListener[r][c]);
			if ( tile[r][c].getFace() == -1 ) {
				tile[r][c].setDisabledIcon( mineImgList[0] );
				tile[r][c].setEnabled( false );
				if ( tile[r][c].getState() == State.FLAG )
					tile[r][c].setDisabledIcon( mineImgList[2] );
			}
		}
	}
	game = Game.END;
   }

   public void reStartGame() {
		this.remove(progressPanel);
		this.remove(gamePanel);
		this.setVisible(false);
		setProgressPane();
		setGamePane();
		this.setVisible(true);
	}

   public void diplayMineCount() {
		int one = checkMine % 10;
		int ten = checkMine / 10;
		if ( checkMine < 0 ) {
			one = Math.abs( checkMine % 10 );
			ten = Math.abs( checkMine / 10 );
			mineLabel[0].setIcon ( new ImageIcon( "D:/java/minus.gif" ) );
			if ( checkMine <= 100 ) {
				one = checkMine % 100;
				ten = Math.abs( one / 10 );
				one = Math.abs( one % 10 );
			}
		}
		mineLabel[1].setIcon( numImgList[ten] );
		mineLabel[2].setIcon( numImgList[one] );
   }

   public boolean isAllCheckFlagMine() {
	if ( game != Game.READY ) {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if ( tile[r][c].getFace() != -1 && tile[r][c].getState() == State.FLAG ) { 
				return false; }
				
				if ( tile[r][c].getFace() != -1 && tile[r][c].getState() != State.OPEN ) { 
				return false; }
			}
		}
		return ( flagCount == MINE );
	} else return false;
   }

  //이겼을 때
   public void GameWin() {
	for (int r = 0; r < ROWS; r++) {
		for (int c = 0; c < COLS; c++) {
			tile[r][c].removeActionListener(tileActionListener[r][c]);
			tile[r][c].removeMouseListener(tileMouseListener[r][c]);
			}
		}
        if ( level == Level.ROW ) {
		file = new File("rowscore.dat");
	} else if ( level == Level.MIDDLE ) {
		file = new File("middlescore.dat");
	} else {
		file = new File("highscore.dat");
	}

	String text = null;
	String score = null;	
	if ( file.exists() ) {
		try {
			BufferedReader reader = new BufferedReader( new FileReader(file) );
			text = reader.readLine();
			reader.close();
			if (text != null) {
			   String name = JOptionPane.showInputDialog( this, "지뢰를 모두 찾았습니다! 이름을 입력해주세요.", "ㅋㅇㅋ", JOptionPane.OK_CANCEL_OPTION );
			   FileWriter writer = new FileWriter( file );
			   score = name;
			   writer.write( score );
			   writer.close();
			   text = score + "님 추카추카!";
			   JOptionPane.showMessageDialog( this, text, "End", JOptionPane.OK_OPTION );			
			}
		}catch (IOException ex) { System.err.println("파일을 읽던 중 오류 발생");}
	} 
	game = Game.END;
   }

  //타일 눌렀을 때
   public void aroundTilePressed(int r, int c) {
	int [] dx = {-1,-1,-1,0,0,1,1,1};
	int [] dy = {-1,0,1,-1,1,-1,0,1};
		
	for (int i = 0; i < 8; i++) { 
		try {
			if ( tile[r+dx[i]][c+dy[i]].getState() != State.FLAG && tile[r+dx[i]][c+dy[i]].getState() != State.OPEN )
				tile[r+dx[i]][c+dy[i]].setIcon(pressedImage);
		} catch(IndexOutOfBoundsException e){}
	}
   }

   public void aroundTileReleased(int r, int c) {
	int flagCnt = 0;
	int [] dx = {-1,-1,-1,0,0,1,1,1};
	int [] dy = {-1,0,1,-1,1,-1,0,1};
		
	for (int i = 0; i < 8; i++) {
		try {
			if ( tile[r+dx[i]][c+dy[i]].getState() == State.FLAG ) flagCnt++;
		} catch(IndexOutOfBoundsException e){}
	}
	if ( tile[r][c].getFace() == flagCnt ) {
		for (int i = 0; i < 8; i++) {
			try {
				if ( tile[r+dx[i]][c+dy[i]].getState() == State.CLOSE | tile[r+dx[i]][c+dy[i]].getState() == State.WILDCARD ) {
					Tile t = tile[r+dx[i]][c+dy[i]];
					if ( t.getFace() == -1 ) {
						game = Game.END;
						t.setDisabledIcon( mineImgList[1] );;
						game = Game.END;
						GameOver();
						return;
					} else if ( t.getFace() != 0 && t.getFace() != -1 ) {
						t.setState( State.OPEN );
						t.setDisabledIcon( tileNumImgList[t.getFace() - 1] );
						t.setEnabled( false );
					} else {
						spaceTileOpen( t.getRow(), t.getCol() );
						replaceTile();
					}
				}
			} catch(IndexOutOfBoundsException e){}
		}
	} else {
		for (int i = 0; i < 8; i++) { 
			try {
				if ( tile[r+dx[i]][c+dy[i]].getState() != State.FLAG && tile[r+dx[i]][c+dy[i]].getState() != State.OPEN )
					tile[r+dx[i]][c+dy[i]].setIcon(closeImage);
			} catch(IndexOutOfBoundsException e){}
		}
	}
}	

  //내부 클래스
  //새 게임으로 바꿀 때 수행하는 클래스
   class NewButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		checkMine = MINE;
		flagCount = 0;
		reStartGame();
	}
   }

  // 게임상태를 받는 클래스
   class TileActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if ( game == Game.READY ) { 		
			game = Game.START;
		}
		Tile t = (Tile)e.getSource();
		if ( t.getState() == State.CLOSE | t.getState() == State.WILDCARD ) {
			if ( t.getFace() == -1 ) {
				game = Game.END;
				t.setDisabledIcon( mineImgList[1] );
				game = Game.END;
				GameOver();
				return;
			} else if ( t.getFace() != 0 && t.getFace() != -1 ) {
				t.setState( State.OPEN );
				t.setDisabledIcon( tileNumImgList[t.getFace() - 1] );
				t.setEnabled( false );
			} else {
				spaceTileOpen( t.getRow(), t.getCol() );
				replaceTile();
			}
		}
		if ( isAllCheckFlagMine() ) { 		// 지뢰를 모두 다 찾았는지 검사
				GameWin();
		}			
	}
   }

   // 마우스의 클릭으로 이벤트를 받는 클래스
  class TileMouseListener extends MouseAdapter {
	private boolean bothLeft = false;
	private boolean bothRight = false;
		
	public void mousePressed(MouseEvent e) {
		Tile t = (Tile)e.getSource();
		if ( SwingUtilities.isLeftMouseButton(e) ) {
			if ( t.getState() == State.OPEN ) {
				bothLeft = true;
			}
		}
		if ( SwingUtilities.isRightMouseButton(e) ) {
			if ( t.getState() != State.OPEN ) {
				if ( t.getState() == State.CLOSE ) {
					t.setIcon(flagImage);
					t.setState(State.FLAG);
					checkMine -= 1;
					if ( t.getFace() == -1 ) 
					   flagCount++;
					diplayMineCount();
				} else if ( t.getState() == State.FLAG ) {
					t.setIcon(wildcardImage);
					t.setState(State.WILDCARD);
					checkMine += 1;
					if ( t.getFace() == -1 )
					   flagCount--;
					diplayMineCount();
				} else {
					t.setIcon(closeImage);
					t.setState(State.CLOSE);
				}
			}
			if ( isAllCheckFlagMine() ) { 
				// 지뢰를 모두 다 찾았는지 검사
					GameWin();
			}
			  // 마우스 체크
			if ( t.getState() == State.OPEN ) {
					bothRight = true;
				}
		}
		if ( t.getState() == State.OPEN ) {
			if ( bothLeft == true && bothRight == true ) {
				aroundTilePressed( t.getRow(), t.getCol() );
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		Tile t = (Tile)e.getSource();
		if ( SwingUtilities.isLeftMouseButton(e) ) {
			if ( t.getState() == State.OPEN ) {
				bothLeft = false;
			}
		}
		if ( SwingUtilities.isRightMouseButton(e) ) {
			if ( t.getState() == State.OPEN ) {
				bothRight = false;
			}
		}
		if ( t.getState() == State.OPEN ) {
			if ( bothLeft == false && bothRight == false) {
				aroundTileReleased( t.getRow(), t.getCol() );
			}
		}
	}
   }	

   public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
   }
}