# Introduction #

> <노인 분들의 치매예방에도 도움이 되고, 심심할 때 무료함을 달래 줄 수 있는 정사각형 퍼즐 맞추기 게임!>

  * 정사각형 모양을 여러가지 모양의 퍼즐들로 임의로 자른다(테트리스 블럭 모양).
  * 잘라진 모양의 퍼즐들을 다시 원래대로 정사각형 모양으로 만들면 끝나는 게임
  * 치매 예방 및 노인분들이 고민하며 재미있게 할 수 있는 게임

# Modification #

  * 노인분들이 하시기에 6\*6 퍼즐은 어려운 감이 있어서 level을 선택 할 수 있게 수정하였습니다. Easy모드는 5\*5 정사각형 퍼즐, Hard모드는 6\*6 정사각형 퍼즐로 만들었습니다.

# Details #

![http://comp166-koreauniv.googlecode.com/files/mainback.png](http://comp166-koreauniv.googlecode.com/files/mainback.png)
  * 메인 화면 모습입니다. GameStart 버튼과 HowToPlay 버튼이 있습니다.

![http://comp166-koreauniv.googlecode.com/files/HowToback.png](http://comp166-koreauniv.googlecode.com/files/HowToback.png)
  * HowToPlay 버튼을 눌렀을 때의 화면입니다. 게임 방법에 대한 설명이 있습니다.

![http://comp166-koreauniv.googlecode.com/files/Levelback.png](http://comp166-koreauniv.googlecode.com/files/Levelback.png)
  * GameStart 버튼을 눌렀을 때 나오는 화면입니다. 새롭게 추가된 화면으로 게임의 레벨을 결정할 수 있습니다.

![http://comp166-koreauniv.googlecode.com/files/Easymode.png](http://comp166-koreauniv.googlecode.com/files/Easymode.png)
  * Easymode 버튼을 눌렀을 때 나오는 게임 화면입니다. 5\*5크기의 정사각형이 여러가지 퍼즐모양으로 잘라진 것을 볼 수 있습니다.

![http://comp166-koreauniv.googlecode.com/files/Hardmode.png](http://comp166-koreauniv.googlecode.com/files/Hardmode.png)
  * Hardmode 버튼을 눌렀을 때 나오는 게임 화면입니다. 6\*6크기의 정사각형이 여러가지 퍼즐모양으로 잘라진 것을 볼 수 있습니다.

# Code #

  * 저는 이 게임을 만들면서 Project를 총 3개 만들었습니다. 먼저 맨 처음 메인 화면과 HowToPlay 화면, Level선택화면을 연결해 주는 project인 FastGameJH (전에 만들던 순발력 게임 프로젝트를 사용하여 이름이 FastGameJH입니다.) 와 TetrisPuzzle 프로젝트, TetrisPuzzle2 프로젝트 입니다.
  * Easymode,Hardmode 버튼을 눌렀을 때 이클립스 내에 있는 다른 프로젝트의 package로 바로 연결될 수 있게 만들었습니다.

# APK file #
1. apk 압축 파일 : http://comp166-koreauniv.googlecode.com/files/APK.zip
> - 제가 게임을 구현할 때 어플 내에서 다른 어플을 구동하도록 만들었기 때문에 3가지 파일을 다 다운받으셔야 할 거 같아요.

2. 소스 코드 파일 : http://comp166-koreauniv.googlecode.com/files/PuzzleJH


---


1. FastGameJH 코드
  * 그럼 맨 처음으로 각각의 화면을 연결 시켜주는 프로젝트인 FastGameJH를 살펴보겠습니다.
![http://comp166-koreauniv.googlecode.com/files/fastgame.png](http://comp166-koreauniv.googlecode.com/files/fastgame.png)

1.MainActivity 코드
```
package com.example.fastgamejh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private ImageButton StartGame_btn;
	private ImageButton HowToPlay_btn;
//이미지 버튼 변수를 설정해 줍니다.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StartGame_btn=(ImageButton)findViewById(R.id.imageButton1);
		HowToPlay_btn=(ImageButton)findViewById(R.id.imageButton2);
		
		//버튼에 대한 리스너를 설정합니다.

		StartGame_btn.setOnClickListener(new OnClickListener() {
//마우스 입력을 받는 함수를 실행합니다.			
			@Override
			public void onClick(View v)
			{
				Log.i("onClick","Food");
				Intent intentLevel = new Intent(MainActivity.this, Level.class);
				startActivity(intentLevel);
//클릭시 levelActivity로 이동을 합니다.
			}
		});
		
		HowToPlay_btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v)
			{
				Log.i("onClick","Food");
				Intent intentHowToPlay = new Intent(MainActivity.this, HowToPlay.class);
				startActivity(intentHowToPlay);
//클릭시 HowToPlayActivity로 이동을 합니다.
			}
		});
		
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
```
2. HowToPlay 코드
```
package com.example.fastgamejh;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HowToPlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_how_to_play);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.how_to_play, menu);
		return true;
	}

}
```
3. Level 코드
```
package com.example.fastgamejh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Level extends Activity {
	
	private Button EasyMode_btn;
	private Button HardMode_btn;
//버튼형 변수를 설정해 줍니다.
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

		EasyMode_btn=(Button)findViewById(R.id.button1);
		HardMode_btn=(Button)findViewById(R.id.button2);

		EasyMode_btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v)
			{
				Intent intent = getPackageManager().getLaunchIntentForPackage("app.mainjh");
//다른 프로젝트의 패키지를 가져올 수 있게 해줍니다. 버튼을 누르면 TetrisPuzzle2 프로젝트의 app.mainjh 패키지를 불러옵니다.
				startActivity(intent);

			}
		});
		
		HardMode_btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v)
			{
				Intent intent = getPackageManager().getLaunchIntentForPackage("app.main");
//다른 프로젝트의 패키지를 가져올 수 있게 해줍니다. 버튼을 누르면 TetrisPuzzle 프로젝트의 app.main 패키지를 불러옵니다.
				startActivity(intent);

				
			}
		});
    }



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level, menu);
		return true;
	}

}
```

---

  * TetrisPuzzle 프로젝트와 TetrisPuzzle2 프로젝트의 코드는 사이즈 조절에만 차이가 있으므로 TetrisPuzzle의 코드를 설명하겠습니다.

![http://comp166-koreauniv.googlecode.com/files/tetrispuzzle1.png](http://comp166-koreauniv.googlecode.com/files/tetrispuzzle1.png)
![http://comp166-koreauniv.googlecode.com/files/tetrispuzzle2.png](http://comp166-koreauniv.googlecode.com/files/tetrispuzzle2.png)

1. app.main패키지
  1. Block 코드
```
package app.main;

import ryulib.graphic.Boundary;
import android.graphics.Point;

public class Block {
	
	public Block(int x, int y) {
		super();
		
		_Point.set(x, y);
		updateBoundary();
	}
	
	private Point _Point = new Point();
	private Boundary _Boundary = new Boundary(1, 1, Global.blockSize-2, Global.blockSize-2);
	
	public Point getPoint() {
		return _Point;
	}
	
	public int getX() {
		return _Point.x;
	}
	
	public int getY() {
		return _Point.y;
	}
	
	private void updateBoundary() {
		_Boundary.setBoundary(
			(_Point.x * Global.blockSize) + 1,
			(_Point.y * Global.blockSize) + 1,
			((_Point.x+1) * Global.blockSize) - 2,
			((_Point.y+1) * Global.blockSize) - 2
		);
	}
        //위치가 변경될 때마다 실제 좌표를 계산하게 된다.

	public void decX(int value) {
		_Point.x = _Point.x - value;
		updateBoundary();
	}

	public void decY(int value) {
		_Point.y = _Point.y - value;
		updateBoundary();
	}

	public Boundary getBoundary() {
		return _Boundary;
	}

	private Boundary _BoundaryCopy = new Boundary(_Boundary);
	
	public Boundary getBoundary(int x, int y) {
		_BoundaryCopy.setBoundary(_Boundary);
		_BoundaryCopy.incLeft(x * Global.blockSize);
		_BoundaryCopy.incTop (y * Global.blockSize);
		
		return _BoundaryCopy;
	}

//blockSize는 퍼즐만들때 조각들을 이루는 작은 정사각형의 변의 크기이고, boardSize는 처음의 사각형이 배열될때 전체 정사각형의 
}
```

> 2) Global 코드
```
package app.main;

import java.util.Random;

public class Global {
	
	public static void setScreenSize(int width, int height) {
		screenWidth = width;
		screenHeight = height;
		
		blockSize = screenHeight / boardSize;
	}//화면 크기 설정

	public static int screenWidth = 480;

	public static int screenHeight = 320;
	
	public static int blockSize = 24;

	// BoardSize*BoardSize 크기의 배열
	public static int boardSize  = 6;
	
	private static final Random _Random = new Random();
	
	public static int getRandom(int n) {
		return _Random.nextInt(n);
	}//랜덤을 사용하기 위해 객체를 생성하는 번거로움 피하기 위해 미리 만들어 둔다.

}
```

> 3) Main 코드
```
package app.main;

import ryulib.game.GamePlatform;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Main extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _GamePlatform = new GamePlatform(this);
        _GamePlatform.setUseMotionEvent(true);
        _GamePlatform.setLayoutParams(
        		new LinearLayout.LayoutParams(
        				ViewGroup.LayoutParams.FILL_PARENT,
        				ViewGroup.LayoutParams.FILL_PARENT,
        				0.0F
        		)
        );
        setContentView(_GamePlatform);
        
        _TetrisBoard = new TetrisBoard(_GamePlatform.getGameControlGroup());
    }
        
	private GamePlatform _GamePlatform = null;
	private TetrisBoard _TetrisBoard = null;
	
}
```

> 4)Piece 코드
```
package app.main;

import java.util.ArrayList;

import ryulib.OnNotifyEventListener;
import ryulib.game.GameControl;
import ryulib.game.GameControlGroup;
import ryulib.game.GamePlatformInfo;
import ryulib.game.HitArea;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

public class Piece extends GameControl {

	public Piece(GameControlGroup gameControlGroup) {
		super(gameControlGroup);
		
		gameControlGroup.addControl(this);

	}//모든 GameControl은 GameControlGroup에 addControl()메소드로 등록이 되어야만 화면에 표시되거나 동작이 이루어 질 수 있다.
	
	private HitArea _HitArea = new HitArea();
	//HitArea 객체가 자신의 영역을 알리는 역할을 한다.

	@Override
	protected HitArea getHitArea() {
		return _HitArea;
	}//GameControlBase에 선언되어 있는 getHitArea()메소드를 재정의하고 있다.

	private int _X = 0;
	private int _Y = 0;
        //Piece의 현재 위치를 나타낸다.화면을 블록 크기로 나누어진 바둑판 모양으로 보았다.
	private int _MinLeft = 0xFFFF;
	private int _MinTop = 0xFFFF;
	private int _MaxLeft = -1;
	private int _MaxTop = -1;

	ArrayList<Block> _Blocks = new ArrayList<Block>();
	
	public int getWidth() {
		return _MaxLeft - _MinLeft + 1;
	}
		
	public int getHeight() {
		return _MaxTop - _MinTop + 1;
	}
		
	public void clearBlocks() {
		_MinLeft = 0xFFFF;
		_MinTop = 0xFFFF;
		
		_Blocks.clear();
	}

	public void addBlock(int x, int y) {
		if (x < _MinLeft) _MinLeft = x;
		if (y < _MinTop ) _MinTop  = y;
		
		if (x > _MaxLeft) _MaxLeft = x;
		if (y > _MaxTop ) _MaxTop  = y;
		
		Block block = new Block(x, y);
		_Blocks.add(block);
	}//PieceFactory를 통해 묶어 사용할 Block의 좌표를 입력받으면, 실제 Block 객체를 생성해서 묶어주는 역할을 담당한다.

	public void arrange() {
		for (Block block : _Blocks) {
			block.decX(_MinLeft);
			block.decY(_MinTop);
		}

		afterMoved();
	}// arrange() 메소드를 통해서 좌측 상단의 블록의 좌표가 (0,0)이 되도록 모든 블록들의 좌표를 줄여 나간다.

	private int _A = 255;
	private int _R = (int) (Math.random() * 100) + 155;
	private int _G = (int) (Math.random() * 100) + 155;
	private int _B = (int) (Math.random() * 100) + 155;
	// Piece의 색상을 랜덤하게 결정한다.
        
	@Override
	protected void onDraw(GamePlatformInfo platformInfo) {
		Paint paint  = platformInfo.getPaint();
		
		if (_isMoving) {
                // 움직이는 도중인지 확인한다.
			paint.setARGB(100, _R, _G, _B);
		} else {
			if ((checkCollision(this) != null)) {
                        //다른 Piece들과 충돌하는 가를 파악한다.
				paint.setARGB(100, _R, _G, _B);
			} else {
				paint.setARGB(_A, _R, _G, _B);
			}
		}

		int left = _X*Global.blockSize + _TouchMove.x-_TouchDown.x;
		int top  = _Y*Global.blockSize + _TouchMove.y-_TouchDown.y;
			
		for (Block block : _Blocks) {
			platformInfo.getCanvas().drawRect(
					block.getBoundary().getRect(left, top), 
					paint
			);
		}
	}//Piece에 포함된 블록 전체를 그린다.
	
	// Action Down, Move 일 때, event 발생 위치
	private Point _TouchDown = new Point();
	private Point _TouchMove = new Point();
	
    private void doActionDown(int x, int y) {
    	_TouchDown.set(x, y);
    	_TouchMove.set(x, y);
    }//터치가 되었을 때 실행된다. 최초에 터치된 곳을 _TouchDown에 저장한다. _TouchMove는 터치 이후에 이동 이벤트가 발생할 때마다 해당 위치를 저장한다.

    
    private void doActionUp(int x, int y) {
    	int cx = (_X*Global.blockSize) + (x - _TouchDown.x) + (Global.blockSize / 2);
    	int cy = (_Y*Global.blockSize) + (y - _TouchDown.y) + (Global.blockSize / 2);
        //내려진 Piece의 픽셀 단위의 좌표 (cx, cy)를 구한다. 이때, (Global.blockSize/2)만큼 더해서 바둑판 모양의 격자에서 중앙을 표시하도록 한다. 

    	_TouchDown.set(0, 0);
    	_TouchMove.set(0, 0);
        //최초의 터치 위치와 이동 중 위치를 초기화 한다.

    	cx = (cx / Global.blockSize);
    	cy = (cy / Global.blockSize);
   

    	if (cx < 0) cx = 0;
    	if (cy < 0) cy = 0;
        //화면의 범위를 못넘어가게 한다.
    	
    	if (cx > (Global.screenWidth  - getWidth()))  cx = Global.screenWidth  - getWidth(); 
    	if (cy > (Global.screenHeight - getHeight())) cy = Global.screenHeight - getHeight(); 

    	setPoint(cx, cy);
        //실제 위치를 변경한다.
    }
    
	private void doActionMove(int x, int y) {
		_TouchMove.set(x, y);
    }//터치 이후에 이동 이벤트가 발생할 때마다 그 위치를 _TouchMove에 저장한다. TouchMove의 좌표를 기준으로 Piece가 그려지게 된다. 이동 중에 Piece의 좌표는 그대로 두고 _TouchMove를 통해 현재 이동 중인 곳의 좌표를 이용한다.
  
     // Piece를 이동하다가 내려 놓게 되는 동작이다.
   
	private boolean _isMoving = false;
	
    @Override
    protected boolean onTouchEvent(GamePlatformInfo platformInfo, MotionEvent event) {
    	boolean result = false;
    	
    	int x = (int) event.getX();
    	int y = (int) event.getY();
    	
    	switch (event.getAction()) {
	    	case MotionEvent.ACTION_DOWN: 
	    		if (getIsMyArea(x, y))	{
		    		doActionDown(x, y);
	    	    	_isMoving = true;
		    		result = true;
	    		    bringToFront();
	    		}
	    		break;
	    		
	    	case MotionEvent.ACTION_UP: 
	    		if (_isMoving) {
		    		doActionUp(x, y); 
	    			_isMoving = false;
		    		result = true;
	    		}
	    		break;
	    		
	    	default: 
	    		if (_isMoving) {
	    			doActionMove(x, y); 
		    		result = true;
	    		}
	    		break;
    	}
    	
    	return result;
    }//실제 터치 이벤트를 처리하는 부분이다. 상황에 따라 doActionDown, doActionUp, doActionMove를 실행한다.

	private boolean getIsMyArea(int x, int y) {
		for (Block block : _Blocks) {
			if (block.getBoundary(_X, _Y).isMyArea(x, y)) return true;
		}
		return false;
	}//지정한 좌표가 Piece 영역인지 확인한다.
	
	private OnNotifyEventListener _OnMoved = null;
	
	public OnNotifyEventListener getOnMoved() {
		return _OnMoved;
	}

	public void setOnMoved(OnNotifyEventListener _OnMoved) {
		this._OnMoved = _OnMoved;
	}

	private void afterMoved() {
		_HitArea.clear();
		for (Block block : _Blocks) {			
			_HitArea.add(block.getBoundary(_X, _Y));
		}//block.getBoundary(_X,_Y)에서 (_X, _Y)는 모든 Boundary가 상대 좌표를 사용하고 있어 Piece의 현재 좌표를 더해주어야지만 실제 좌표가 된다.
		
		if (_OnMoved != null) _OnMoved.onNotify(this);
	}//Piece가 이동되면 HitArea 안의 Boundary 위치를 다시 지정한다. OnMoved 이벤트 발생하여 외부 리스너에게 알려준다.
	
	public void setPoint(int x, int y) {		
		_X = x;
		_Y = y;
		afterMoved();
	}

	public void setX(int _X) {
		this._X = _X;
		afterMoved();
	}

	public int getX() {
		return _X;
	}

	public void setY(int _Y) {
		this._Y = _Y;
		afterMoved();
	}

	public int getY() {
		return _Y;
	}
    
}
```

> 5)PieceFactory 코드
```
package app.main;

import java.util.ArrayList;

import ryulib.OnNotifyEventListener;
import ryulib.game.GameControl;
import ryulib.game.GameControlGroup;
import ryulib.graphic.Boundary;
import android.graphics.Point;

public class PieceFactory extends GameControl {
	
	public PieceFactory(GameControlGroup gameControlGroup) {
		super(gameControlGroup);

	}

	private Boundary[][] _Boundaries = null;
	private int _BoundriesCount;
	
	public void slice() {
		createCells();
		makePieces();
	}//사각형 조각내기

	private void makePieces() {
		_BoundriesCount = Global.boardSize * Global.boardSize;
		while (_BoundriesCount > 0) {
			makePiece();
		}
	}//정사각형의 조각 개수만큼 반복하면서 이것들을 랜덤한 모양과 랜덤한 개수로 묶어준다. 이 묶음을 Piece라 부른다.
	
	private void makePiece() {
		int pieceSize  = getRandomPieceSize();
		Piece piece = new Piece(getGameControlGroup());
		Point point = getRandomPointChoice();
		
		addBoundaryToPiece(point, piece);
		pieceSize--;
		_BoundriesCount--;

		while ((pieceSize > 0) && (_BoundriesCount > 0)) {
			point = getNextRandomPoint(point);
			if (point == null) break;
			
			addBoundaryToPiece(point, piece);
			pieceSize--;
			_BoundriesCount--;
		}
		
		piece.arrange();
		
		// 랜덤하게 배치하면서 서로 겹치지 않도록 100번 정도 노력 한다.
		int x, y;
		for (int i=0; i<100; i++) {
			x = Global.getRandom((Global.screenWidth  / Global.blockSize) - piece.getWidth()); 
			y = Global.getRandom((Global.screenHeight / Global.blockSize) - piece.getHeight()); 

			piece.setPoint(x, y);
			if (checkCollision(piece) == null) break;
		}
		
		if (_OnNewPiece != null) _OnNewPiece.onNotify(piece);
	}//실제 조각을 Piece로 묶어 준다. 묶어진 Piece를 이벤트를 발생시켜 리스너에게 알려준다.

	private void createCells() {
		_Boundaries = new Boundary[Global.boardSize][Global.boardSize];
		
		for (int y=0; y<Global.boardSize; y++) {
			for (int x=0; x<Global.boardSize; x++) {
				_Boundaries[x][y] = new Boundary(x*Global.blockSize, y*Global.blockSize, (x+1)*Global.blockSize, (y+1)*Global.blockSize);
			}
		}
	}//조각 내기 전에 Global.boardSize의 2차원 배열로 Boundary 객체를 생성한다. 최초의 사각형을 boardSize*boardSize 개수만큼의 정사각형으로 조각 낸다.
	
	private void addBoundaryToPiece(Point point, Piece piece) {
		_Boundaries[point.x][point.y] = null;//Piece로 구성될 위치의 정사각형이 이미 사용되었음을 선언한다. null로 표시하여 더 이상 사용할 수 없음을 알린다.
		piece.addBlock(point.x, point.y);//해당 블록을 Piece에 구성시킨다.
	}//Piece는 복수 개의 Block들로 구성되어 있다. 
	
	private Point getRandomPointChoice() {
		int x = Global.getRandom(Global.boardSize);
		int y = Global.getRandom(Global.boardSize);
		
		while (_Boundaries[x][y] == null) {
			x = Global.getRandom(Global.boardSize);
			y = Global.getRandom(Global.boardSize);
		}
		
		return new Point(x, y);
	}//Boundaries에서 아무 정사각형이나 선택한다.
	
	// 해당 좌표에 Boundary를 가져 올 수 있는 가?  있으면 좌표를 리턴한 
	private Point getPoint(int x, int y) {
		if ((x < 0) || (x >= Global.boardSize)) return null;
		if ((y < 0) || (y >= Global.boardSize)) return null;
		
		if (_Boundaries[x][y] != null) {
			return new Point(x, y);
		} else {
			return null;
		}
	}

	private Point getNextRandomPoint(Point basePoint) {
		ArrayList<Point> points = new ArrayList<Point>();
		
		Point point;
		
		point = getPoint(basePoint.x-1, basePoint.y);
		if (point != null) points.add(point); 
		
		point = getPoint(basePoint.x+1, basePoint.y);
		if (point != null) points.add(point); 
		
		point = getPoint(basePoint.x, basePoint.y-1);
		if (point != null) points.add(point); 
		
		point = getPoint(basePoint.x, basePoint.y+1);
		if (point != null) points.add(point); 
		
		if (points.size() == 0) {
			return null;
		} else {
			int index = Global.getRandom(points.size());
			return points.get(index);
		}
	}//전후/좌우에 있는 정사각형 중 null이 아닌 하나를 선별하여 Piece에 묶어 준다.

	private int getRandomPieceSize() {
		// TODO Auto-generated method stub
		return 5;
	}//Piece에 묶여 질 수 있는 정사각형의 최대 개수를 나타낸다. 

	public void setOnNewPiece(OnNotifyEventListener _OnNewPiece) {
		this._OnNewPiece = _OnNewPiece;
	}

	public OnNotifyEventListener getOnNewPiece() {
		return _OnNewPiece;
	}

	private OnNotifyEventListener _OnNewPiece = null;

}
```

> 6)PieceList 코드
```
package app.main;

import java.util.ArrayList;

import ryulib.OnNotifyEventListener;

public class PieceList {
	
	private ArrayList<Piece> _List = new ArrayList<Piece>();
	
	public void clear() {
		_List.clear();
	}
	
	private OnNotifyEventListener _OnPieceMoved = new OnNotifyEventListener() {
		@Override
		public void onNotify(Object sender) {
			checkGameEnd();//각 Piece들이 움직일 때 마다 실행되어 소스가 생략된다.
		}
	};
	
	public void add(Piece piece) {
		_List.add(piece);
		piece.setOnMoved(_OnPieceMoved);
	}//PieceFactory에 의해 만들어진 조각들을 _List 목록에 포함시키면서 이벤트 리스너를 지정한다.
	
	private void checkGameEnd() {
		Block[][] blocks = new Block[Global.boardSize][Global.boardSize];
		
		for (int y=0; y<Global.boardSize; y++) {
			for (int x=0; x<Global.boardSize; x++) {
				blocks[x][y] = null;
			}
		}
		
		for (Piece piece : _List) {
			for (Block block : piece._Blocks) {
				int x = piece.getX() + block.getX();
				int y = piece.getY() + block.getY();
				boolean isInRange =
					(x >= 0) && (x < Global.boardSize) &&
					(y >= 0) && (y < Global.boardSize);
					
				if (isInRange) blocks[x][y] = block;
			}
		}
		
		for (int y=0; y<Global.boardSize; y++) {
			for (int x=0; x<Global.boardSize; x++) {
				if (blocks[x][y] == null) return; 
			}
		}
		
		if (_OnGameEnd != null) _OnGameEnd.onNotify(this);//리스너를 호출한다.
	}//모든 조각들이 제 위치에 있는 지를 확인한다.
	
	private OnNotifyEventListener _OnGameEnd = null;
	
	public void setOnGameEnd(OnNotifyEventListener _OnGameEnd) {
		this._OnGameEnd = _OnGameEnd;
	}

	public OnNotifyEventListener getOnGameEnd() {
		return _OnGameEnd;
	}

}
```

> 7) TetrisBoard 코드
```
package app.main;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import ryulib.OnNotifyEventListener;
import ryulib.game.GameControl;
import ryulib.game.GameControlGroup;
import ryulib.game.GamePlatformInfo;

public class TetrisBoard extends GameControl {

	public TetrisBoard(GameControlGroup gameControlGroup) {
		super(gameControlGroup);
		
		gameControlGroup.addControl(this);
		
        _PieceFactory = new PieceFactory(gameControlGroup);
        _PieceFactory.setOnNewPiece(_OnNewPiece);
        //PieceFactory 객체를 생성하고 OnnewPiece 이벤트를 처리할 리스너를 지정한다.        

        _PieceList.setOnGameEnd(_OnGameEnd);//OngameEnd 이벤트를 처리할 리스너를 지정한다.
	}
	
	private PieceFactory _PieceFactory = null;
	private PieceList _PieceList = new PieceList();//PieceList는 객체를 생성한다.

	private OnNotifyEventListener _OnNewPiece = new OnNotifyEventListener() {
		@Override
		public void onNotify(Object sender) {
			getGameControlGroup().addControl((Piece) sender);
			_PieceList.add((Piece) sender);
		}
	};//PieceFactory가 처음의 사각형을 조각 내어 조각 객체를 생성할 때마다 발생하는 OnNewPiece 이벤트를 처리할 리스너를 구현하고 있다.
	
	private OnNotifyEventListener _OnGameEnd = new OnNotifyEventListener() {
		@Override
		public void onNotify(Object sender) {
			System.exit(0);//모든 조각들이 제 위치에 있을 경우 프로그램 종료한다.
		}
	};//Piece들이 이동할 때마다 모든 조각들이 제 위치에 있는 지 확인하고 모두 제 위치에 있을 경우 발생하는 OnGameEnd 이벤트를 처리할 리스너이다.
	
	private Bitmap _BoardBitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
	private Canvas _BoardCanvas = new Canvas();

	private Canvas _Canvas = null;
	private Paint _Paint = new Paint();
	
	public void startGame() {
		_PieceList.clear();
		_PieceFactory.slice();
	}//게임이 시작되면 PieceList를 초기화 하고 PieceFactory를 통해서 처음의 사각형을 조각 낸다.
	
	@Override
	protected void onStart(GamePlatformInfo platformInfo) {
		_Canvas = platformInfo.getCanvas();

        Global.setScreenSize(_Canvas.getWidth(), _Canvas.getHeight());
               //프로그램이 시작되면 Global.setScreenSize() 메소드를 호출하여 게임 엔진의 화면 크기를 지정한다. 이 때 필요한 모든 변수들이 초기화 된다.

		setBoardSize(Global.blockSize * Global.boardSize);
		
		startGame();//게임을 시작한다.
	}
	
	@Override
	protected void onDraw(GamePlatformInfo platformInfo) {
		_Paint.setARGB(255, 0, 0, 0);
		_Canvas.drawRect(platformInfo.getRect(), _Paint);
		
		_Canvas.drawBitmap(_BoardBitmap, 0, 0, _Paint);		
	}
	
	private int _BoardSize = 0;

	public int getBoardSize() {
		return _BoardSize;
	}

	public void setBoardSize(int _BoardSize) {
		this._BoardSize = _BoardSize;
		doPrepareBoardBitmap(_BoardSize);		
	}

	private void doPrepareBoardBitmap(int boardSize) {
		_BoardBitmap = Bitmap.createBitmap(boardSize+1, boardSize+1, Config.ARGB_8888);
		_BoardCanvas.setBitmap(_BoardBitmap);		
		
		_Paint.setARGB(255, 55, 55, 55);

		for (int x=0; x<=Global.boardSize; x++) {
			_BoardCanvas.drawLine(x*Global.blockSize, 0, x*Global.blockSize, boardSize, _Paint);
		}
		
		for (int y=0; y<=Global.boardSize; y++) {
			_BoardCanvas.drawLine(0, y*Global.blockSize, boardSize, y*Global.blockSize, _Paint);
		}
	}

}//배경에 쓰일 Bitmap이미지를 작성한다. 
```

2. ryulib 패키지
  1. Direction 코드
```
package ryulib;

public enum Direction {
	NoWhere,
	Left, Right,
	Up, Down
}
```

> 2) OnHandlerMessageListener 코드
```
package ryulib;

import android.os.Message;

public interface OnHandlerMessageListener {

	public void onReceived(Message msg);
	
}
```

> 3) OnNotifyEventListener 코드
```
package ryulib;

public interface OnNotifyEventListener {

	public void onNotify(Object sender);
	
}
```

> 4) OnTimerListener 코드
```
package ryulib;

public interface OnTimerListener {

	public void onTime(long ATick);
	
}
```

> 5) ThreadRepeater 코드
```
package ryulib;

import android.util.Log;

public class ThreadRepeater implements Runnable {
	
	private Boolean _Active = false; 
	private Boolean _Pause = false; 
	private Thread _Thread = null;
	
	// Property
	private long _Interval = 0;
	
	// Event
	private OnNotifyEventListener _OnNotifyEvent = null;

	public final void start() {
		_Active = true;
		_Thread = new Thread(this);
		_Thread.start();
	}
	
	public final void pause() {
		_Pause = true;
	}
	
	public final void resume() {
		_Pause = false;
	}
	
	public final void stop() {
        _Active = false;
        if (_Thread == null) return;

        boolean retry = true;
        while (retry) {
            try {
            	_Thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
	}

	public final void run() {
		while (_Active) {
			if ((_Pause == false) && (_OnNotifyEvent != null)) {
				_OnNotifyEvent.onNotify(this);
				
        		if (_Interval > 0)  {
        			try {
		        		Thread.sleep(_Interval);
					} catch (InterruptedException e) {
						Log.w("GamePlatform Class", "Thread.sleep Exception.");
					}       		
        		}
			}				
		}		
	}
	
	public final void setOnNotifyEvent(OnNotifyEventListener value) {
		_OnNotifyEvent = value;
	}

	public final void setInterval(long value) {
		_Interval = value;
	}

	public final long getInterval() {
		return _Interval;
	}

}
```

> 6) Timer 코드
```
package ryulib;

import android.os.Handler;

public class Timer {
	
	public void start() {
		_OldTick = System.currentTimeMillis();
		_Active = true;
		_Handler.postDelayed(_Runnable, _Interval);
	}
	
	public void stop() {
		_Active = false;
	}

	// Interval Property
	private int _Interval = 1000;
	public int getInterval() {
		return _Interval;
	}
	public void setInterval(int AValue) {
		_Interval = AValue;
	}
	
	// Active Property
	private boolean _Active = false;
	public boolean getActive() {
		return _Active;
	}

	// OnTimer Event
	private OnTimerListener _OnTimer = null;
	public void setOnTimer(OnTimerListener AValue) {
		_OnTimer = AValue;
	}
	
    private long _OldTick = System.currentTimeMillis();
    
    private Handler _Handler = new Handler();
    private Runnable _Runnable = new Runnable() {
    	public void run() {
    		if (getActive() == false) return;

    		long _Tick = System.currentTimeMillis();
  			if (_OnTimer != null) _OnTimer.onTime(_Tick-_OldTick);
    		_OldTick = _Tick;

  			if (_Interval > 0) _Handler.postDelayed(this, _Interval);
  			else _Handler.post(this);
    	}
    };
    
}
```

> 7)ValueList 소스
```
package ryulib;

import java.util.HashMap;

public class ValueList extends HashMap<String, String> {

	private static final long serialVersionUID = 1065478499595139080L;
	
	public void put(String AKey, int AValue) {
		put(AKey, Integer.toString(AValue));
	}
	
	public int getInt(String AKey) {
		return Integer.parseInt(get(AKey));
	}
}
```

3. ryulib.dialogs 패키지
  1. FileList 소스
```
package ryulib.dialogs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FileList extends ListView {

	public FileList(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		init(context);
	}

	public FileList(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(context);
	}

	public FileList(Context context) {
		super(context);

		init(context);
	}
	
	private void init(Context context) {
		_Context = context;
        setOnItemClickListener(_OnItemClick);
	}
	
	private Context _Context = null;
	private ArrayList<String> _List = new ArrayList<String>();
    private ArrayList<String> _FolderList = new ArrayList<String>();
    private ArrayList<String> _FileList = new ArrayList<String>();
	private ArrayAdapter<String> _Adapter = null; 
	
	// Property 
	private String _Path = "";
	
	// Event
	private OnPathChangedListener _OnPathChangedListener = null;
	private OnFileSelectedListener _OnFileSelectedListener = null;
	
	private boolean openPath(String path) {
		_FolderList.clear();
		_FileList.clear();
		
        File file = new File(path);
        File[] files = file.listFiles();
        if (files == null) return false;
        
        for (int i=0; i<files.length; i++) {
        	if (files[i].isDirectory()) {
        		_FolderList.add("<" + files[i].getName() + ">");
        	} else {
        		_FileList.add(files[i].getName());
        	}
        }
        
        Collections.sort(_FolderList);
        Collections.sort(_FileList);
        
        _FolderList.add(0, "<..>");
        
        return true;
	}
	
	private void updateAdapter() {
		_List.clear();
        _List.addAll(_FolderList);
        _List.addAll(_FileList);
        
		_Adapter = new ArrayAdapter<String>(_Context, android.R.layout.simple_list_item_1, _List);
        setAdapter(_Adapter);
	}

	public void setPath(String value) {
		if (value.length() == 0) {
			value = "/";
		} else {
			String lastChar = value.substring(value.length()-1, value.length());
			if (lastChar.matches("/") == false) value = value + "/"; 
		}
		
		if (openPath(value)) {
			_Path = value;
			updateAdapter();	        
			if (_OnPathChangedListener != null) _OnPathChangedListener.onChanged(value);
		}
	}

	public String getPath() {
		return _Path;
	}
	
	public void setOnPathChangedListener(OnPathChangedListener value) {
		_OnPathChangedListener = value;
	}

	public OnPathChangedListener getOnPathChangedListener() {
		return _OnPathChangedListener;
	}

	public void setOnFileSelected(OnFileSelectedListener value) {
		_OnFileSelectedListener = value;
	}

	public OnFileSelectedListener getOnFileSelected() {
		return _OnFileSelectedListener;
	}
	
	private String delteLastFolder(String value) {
		String list[] = value.split("/");

		String result = "";
		
		for (int i=0; i<list.length-1; i++) {
			result = result + list[i] + "/"; 
		}
		
		return result;
	}
	
	private String getRealPathName(String newPath) {
		String path = newPath.substring(1, newPath.length()-1);
		
		if (path.matches("..")) {
			return delteLastFolder(_Path);
		} else {
			return _Path + path + "/";
		}
	}

	private AdapterView.OnItemClickListener _OnItemClick = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {
			String fileName = getItemAtPosition(position).toString();
			if (fileName.matches("<.*>")) {
				setPath(getRealPathName(fileName));
			} else {
				if (_OnFileSelectedListener != null) _OnFileSelectedListener.onSelected(_Path, fileName);
			}
		}
	};

}
```

> 2) OnFileSelectedListener 소스
```
package ryulib.dialogs;

public interface OnFileSelectedListener {
	
	public void onSelected(String path, String fileName);

}
```

> 3) OnPathChangedListener 소스
```
package ryulib.dialogs;

public interface OnPathChangedListener {
	
	public void onChanged(String path);

}
```

> 4) OnNotifyEventListener 소스
```
package ryulib.dialogs;

import ryulib.OnNotifyEventListener;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;

public class OpenDialog {

	public OpenDialog(Context context) {
        _OpenDialogLayout = new OpenDialogLayout(context);
        
        _Dialog = new AlertDialog.Builder(context);
        _Dialog.setTitle("Open Dialog");
        _Dialog.setView(_OpenDialogLayout);
        _Dialog.setPositiveButton("Ok", _OnPositiveClick);
        _Dialog.setNegativeButton("Cancel", _OnNegativeClick);
	}
	
	private Builder _Dialog = null;
    private OpenDialogLayout _OpenDialogLayout = null;
    
    // Event
    private OnFileSelectedListener _OnFileSelected = null;
    private OnNotifyEventListener _OnCanceled = null;
    
    public void show() {
    	_Dialog.show();
    }
    
	public void setOnFileSelected(OnFileSelectedListener value) {
		_OnFileSelected = value;
	}

	public OnFileSelectedListener getOnFileSelected() {
		return _OnFileSelected;
	}

	public void setOnCanceled(OnNotifyEventListener value) {
		_OnCanceled = value;
	}

	public OnNotifyEventListener getOnCanceled() {
		return _OnCanceled;
	}

	private DialogInterface.OnClickListener _OnPositiveClick = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (_OnFileSelected != null) {
				_OnFileSelected.onSelected(_OpenDialogLayout.getPath(), _OpenDialogLayout.getFileName());
			}
		}
	};

    private DialogInterface.OnClickListener _OnNegativeClick = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (_OnCanceled != null) {
				_OnCanceled.onNotify(OpenDialog.this);
			}
		}
	};

}
```

> 5) OpenDialogLayout 소스
```
package ryulib.dialogs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OpenDialogLayout extends LinearLayout {

	public OpenDialogLayout(Context context) {
		super(context);
		
		init(context);
	}

	public OpenDialogLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(context);
	}
	
	private void setItemLayout(View view) {
		view.setLayoutParams(
				new LinearLayout.LayoutParams(
			      	ViewGroup.LayoutParams.FILL_PARENT, 
			    	ViewGroup.LayoutParams.WRAP_CONTENT, 
			        0.0F
			    )
			);
	}
	
	private void setListLayout(View view) {
		view.setLayoutParams(
				new LinearLayout.LayoutParams(
			      	ViewGroup.LayoutParams.FILL_PARENT, 
			    	ViewGroup.LayoutParams.FILL_PARENT, 
			        0.0F
			    )
			);
	}
	
	private void init(Context context) {
		setOrientation(LinearLayout.VERTICAL);
		setListLayout(this);
		
		_tvPath = new TextView(context);
		setItemLayout(_tvPath);
		_tvPath.setText("Path: ");
		
		_etFile = new EditText(context);
		setItemLayout(_etFile);
		_etFile.setEnabled(false);
		_etFile.setFocusable(false);
		
        _FileList = new FileList(context);
		setListLayout(_FileList);
        _FileList.setPath("/");
        _FileList.setFocusable(true);
        _FileList.setOnPathChangedListener(_OnPathChanged);
        _FileList.setOnFileSelected(_OnFileSelected);
        
		addView(_tvPath);
		addView(_etFile);
		addView(_FileList);
		
		setFocusable(true);
		setFocusableInTouchMode(true);
	}
	
	private TextView _tvPath = null;
	private EditText _etFile = null;
    private FileList _FileList = null;
    
    public String getPath() {
    	return _tvPath.getText().toString();
    }
    
    public String getFileName() {
    	return _etFile.getText().toString();
    }
    
    private OnPathChangedListener _OnPathChanged = new OnPathChangedListener() {
		@Override
		public void onChanged(String path) {
			_tvPath.setText("Path: " + path);
			_etFile.setText("");
		}
	};
	
	private OnFileSelectedListener _OnFileSelected = new OnFileSelectedListener() {
		@Override
		public void onSelected(String path, String fileName) {
			_etFile.setText(fileName);
		}
	};
	
}
```

4. ryulib.game 패키지
  1. BackgroundImage 소스
```
package ryulib.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class BackgroundImage {

	private int _X01 = 0;
	private int _X02 = 0;
	private Scroll _Scroll = new Scroll();

	// Property 
	private Bitmap _Bitmap = null;
	
	public void draw(Canvas canvas, Paint paint, long tick) {
		// 현재 위치에 먼 거리 배경 이미지 그리기
		if ((_Bitmap.getWidth()+_X01) > 0) {
			canvas.drawBitmap(_Bitmap, _X01, 0, paint);
		}
		
		// 첫 번째 이미지가 화면을 꽉 채우지 못할 경우, 나머지 공간에 두 번째 이미지를 그린다.
		if ((_Bitmap.getWidth()+_X01) <= canvas.getWidth()) {
			canvas.drawBitmap(_Bitmap, _X02, 0, paint);
		}
		
		// 초당 _Scroll.getSpeed() 만큼의 속도로 운석을 이동 한다.
		_X01 = _X01 - _Scroll.move(tick);
		
		// 뒤에 따라와야하는 이미지의 좌표
		_X02 = _X01 + _Bitmap.getWidth();
		
		// 두 번째 이미지가 화면을 꽉 채우지 못하면, 지나간 첫 번째 이미지를 재 활용한다.
		if (_X02+(_Bitmap.getWidth()) <= canvas.getWidth()) {
			int temp = _X01;
			_X01 = _X02;
			_X02 = temp + _Bitmap.getWidth();
		}
	}
	
	public void setBitmap(Bitmap value) {
		_Bitmap = value;
	}
	public Bitmap getBitmap() {
		return _Bitmap;
	}

	public void setSpeed(int value) {
		_Scroll.setSpeed(value);
	}

	public int getSpeed() {
		return _Scroll.getSpeed();
	}

}
```

> 2) GameControl 소스
```
package ryulib.game;

import ryulib.OnNotifyEventListener;

public class GameControl extends GameControlBase {
	
	public GameControl(GameControlGroup gameControlGroup) {
		super(gameControlGroup);	
		
	}
	
	public GameControl checkCollision(GameControl target) {
		if (_GameControlGroup != null) {
			return _GameControlGroup.checkCollision(target);
		} else {
			return null;
		}		
	}
	
	public void checkCollision(GameControl target, OnNotifyEventListener event) {
		if (_GameControlGroup != null) 
			_GameControlGroup.checkCollision(target, event);
	}
	
}
```

> 3) GameControlBase 소스
```
package ryulib.game;

import android.view.KeyEvent;
import android.view.MotionEvent;
import ryulib.graphic.Boundary;

public class GameControlBase {
	
	public GameControlBase(GameControlGroup gameControlGroup) {
		super();
		
		setGameControlGroup(gameControlGroup);
	}

	GameControlGroup _GameControlGroup = null;
	
	final void setGameControlGroup(GameControlGroup value) {
		onGameControlGroupChanged(value);
		_GameControlGroup = value;
	}
	
	// GameControlList에서 바로 삭제 할 수 없고, 
	// 플래그를 세팅하면 GameControlList가 적당한 시기에 삭제한다. 
	boolean _Deleted = false;

	// MotionEvent.ACTION_DOWN으로 선택된  객체일 때 true
	boolean _Focused = false;
	
	// 최초로 onRepeate가 실행되는 순간을 따로 처리하기 위함 (초기화)
	boolean _IsStarted = false;
	
	private Boundary _Boundary = new Boundary(0, 0, 0, 0);
	private boolean _Visible = true;
	private boolean _Enabled = true;
	
	void onRepeate(GamePlatformInfo platformInfo) {
		if (getDeleted()) return; 

		if (_IsStarted == false) {
			_IsStarted = true;
			onStart(platformInfo);
		}
		
		if ((_Deleted == false) && _Enabled && _Visible) onTick(platformInfo);
		if ((_Deleted == false) && _Visible) onDraw(platformInfo);
	}
	
	// 충돌 테스트를 위한 영역.  
	// 컨트롤의 크기보다 작은 영역에서만 충돌을 감지해야 할 경우가 많기 때문에 _Boundary와 따로 처리한다.
	// 예를 들어서 비행기와 같은 이미지는 정확히 사각형이 아니기 때문에 가장자리 빈공간에서 부디치는 어색함이 생길 수 있다.
	// null로 지정되어 있으면 충돌 테스트를 하지 않게 되며, 충돌 테스트가 필요한 경우 객체를 할당하면 된다. 
	protected HitArea getHitArea() {
		return null;
	}
	
	protected void onGameControlGroupChanged(GameControlGroup gameControlGroup) {
		// Override 해서 사용
	}
	
	protected void onStart(GamePlatformInfo platformInfo) {
		// Override 해서 사용
	}
	
	protected void onTick(GamePlatformInfo platformInfo) {
		// Override 해서 사용
	}
	
	protected void onDraw(GamePlatformInfo platformInfo) {
		// Override 해서 사용
	}
	
	protected boolean onKeyDown(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		// Override 해서 사용
		return false;
    }

    protected boolean onKeyUp(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		// Override 해서 사용
		return false;
    }

    protected boolean onTouchEvent(GamePlatformInfo platformInfo, MotionEvent event) {
		// Override 해서 사용
		return false;
    }
    
	public final void bringToFront() {
		if (_GameControlGroup != null)
			_GameControlGroup.bringToFront(this);
	}
	
	public final void sendToBack() {
		if (_GameControlGroup != null)
			_GameControlGroup.sendToBack(this);
	}
	
	public final GameControlGroup getGameControlGroup() {
		return _GameControlGroup;
	}

	public final Boundary getBoundary() {
		return _Boundary;
	}

	public final void setBoundary(Boundary value) {
		_Boundary = value;
	}
    
    public final boolean getVisible() {
    	return _Visible;
    }
    
    public final void setVisible(boolean value) {
    	_Visible = value;
    }
    
    public final boolean getEnabled() {
    	return _Enabled;
    }
    
    public final void setEnabled(boolean value) {
    	_Enabled = value;
    }

	public boolean isStarted() {
		return _IsStarted;
	}

	public boolean getFocused() {
		return _Focused;
	}
	
	public boolean getDeleted() {
		return _Deleted;
	}
	
	public void delete() {
		setVisible(false);
		setEnabled(false);		
		_Deleted = true;
	}

}
```

> 4) GameControlGroup 소스
```
package ryulib.game;

import ryulib.OnNotifyEventListener;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class GameControlGroup extends GameControlBase {

	public GameControlGroup(GameControlGroup gameControlGroup) {
		super(gameControlGroup);

	}

	protected GameControlList _GameControlList = new GameControlList();
	
	public final void clearControls() {
		_GameControlList.clear();
	}
	
	public final void addControl(GameControlBase control) {
		control.setGameControlGroup(this);
		_GameControlList.add(control);
	}

	public final void removeControl(GameControlBase control) {
		_GameControlList.remove(control);
		control.setGameControlGroup(null);
	}
	
	public final void bringToFront(GameControlBase control) {
		_GameControlList.bringToFront(control);
	}
	
	public final void sendToBack(GameControlBase control) {
		_GameControlList.sendToBack(control);
	}

	public final GameControl checkCollision(GameControl target) {
		return _GameControlList.checkCollision(target);
	}
	
	public final void checkCollision(GameControl target, OnNotifyEventListener event) {
		_GameControlList.checkCollision(target, event);
	}
	
	final void arrangeControls() {
		_GameControlList.arrangeControls();
	}
	
	@Override
	final void onRepeate(GamePlatformInfo platformInfo) {
		if (getDeleted()) return; 
			
		if (_IsStarted == false) {
			_IsStarted = true;
			onStart(platformInfo);
		}
			
		if (getEnabled()) {
			onTick(platformInfo);
			
			if (getVisible()) {
				onDraw(platformInfo);
				_GameControlList.onRepeate(platformInfo);
			}
		}
	}
	
	protected boolean doKeyDown(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		return false;
	}
	
	@Override
	protected final boolean onKeyDown(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		if (_GameControlList.onKeyDown(platformInfo, keyCode, msg) == false) return doKeyDown(platformInfo, keyCode, msg);
		return true;
    }

	protected boolean doKeyUp(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		return false;
	}

	@Override
	protected final boolean onKeyUp(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {		
    	if (_GameControlList.onKeyUp(platformInfo, keyCode, msg) == false) return doKeyUp(platformInfo, keyCode, msg);
		return true;
    }

	protected boolean doTouchEvent(GamePlatformInfo platformInfo, MotionEvent event) {
		return false;
	}
	
	@Override
	protected final boolean onTouchEvent(GamePlatformInfo platformInfo, MotionEvent event) {
    	if (_GameControlList.onTouchEvent(platformInfo, event) == false) return doTouchEvent(platformInfo, event);
		return true;
    }
	
}
```

> 5) GameControlList 소스
```
package ryulib.game;

import java.util.ArrayList;

import ryulib.OnNotifyEventListener;

import android.view.KeyEvent;
import android.view.MotionEvent;

public class GameControlList {
	
	private ArrayList<GameControlBase> _List = new ArrayList<GameControlBase>();
	
	// 바로 처리 할 수 없는 것들을 대기 시킨다.  루프 도는 중에 리스트 변경을 방지하기 위해서
	private ArrayList<GameControlBase> _QueAdd = new ArrayList<GameControlBase>();
	private ArrayList<GameControlBase> _QueRemove = new ArrayList<GameControlBase>();
	private ArrayList<GameControlBase> _QueSendToBack = new ArrayList<GameControlBase>();
	private ArrayList<GameControlBase> _QueBringToFront = new ArrayList<GameControlBase>();
	
	public final void clear() {
		synchronized (_List) {
			for (GameControlBase control : _List) {
				_QueRemove.add(control);
			}
		}
	}
	
	public final void add(GameControlBase control) {
		synchronized (_QueAdd) {
			_QueAdd.add(control);
		}
	}
	
	public final void remove(GameControlBase control) {
		synchronized (_QueRemove) {
			_QueRemove.add(control);
		}
	}
	
	public final void bringToFront(GameControlBase control) {
		synchronized (_QueBringToFront) {
			_QueBringToFront.add(control);
		}
	}
	
	public final void sendToBack(GameControlBase control) {
		synchronized (_QueSendToBack) {
			_QueSendToBack.add(control);
		}
	}

	public final GameControl checkCollision(GameControl target) {
		synchronized (_List) {
			for (GameControlBase control : _List) {
				if (control instanceof GameControlGroup) continue;
				
				HitArea _HitArea = control.getHitArea();
				
				if ((isControlVisible(control) == false) || (_HitArea == null) || (control == target)) continue;
				
				if (target.getHitArea().checkCollision(_HitArea)) {
					return (GameControl) control;
				}
			}
		}

		return null;
	}
	
	public final void checkCollision(GameControl target, OnNotifyEventListener event) {
		synchronized (_List) {
			for (GameControlBase control : _List) {
				if (control instanceof GameControlGroup) continue;
				
				HitArea _HitArea = control.getHitArea();
				
				if ((isControlVisible(control) == false) || (_HitArea == null) || (control == target)) continue;
				
				if (target.getHitArea().checkCollision(_HitArea)) {
					event.onNotify(control);
				}
			}
		}
	}
	
	public final void onRepeate(GamePlatformInfo platformInfo) {
		// 반복문 사이에 락이 걸리는 것을 최소화 하기 위하여 
		_GameControlIndex = 0;
		GameControlBase control = getGameControl();
		while (control != null) {
			control.onRepeate(platformInfo);
			control = getGameControl();
		}
	}
	
	public final boolean onKeyDown(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		synchronized (_List) {
			for (int i=_List.size()-1; i>=0; i--) {
				GameControlBase control = _List.get(i);
				if (isControlAvailable(control) == false) continue;

				if (control.onKeyDown(platformInfo, keyCode, msg)) return true;
			}
			
			return false;
		}
    }

	public final boolean onKeyUp(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		synchronized (_List) {
			for (int i=_List.size()-1; i>=0; i--) {
				GameControlBase control = _List.get(i);
				if (isControlAvailable(control) == false) continue;
				
				if (control.onKeyUp(platformInfo, keyCode, msg)) return true;
			}
		}
		
		return false;
    }
    
	public final boolean onTouchEvent(GamePlatformInfo platformInfo, MotionEvent event) {
		boolean result = false;
		
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN: 
				result = do_ActionDown(platformInfo, event);
				break;
				
			case MotionEvent.ACTION_UP: 
				result = do_ActionUp(platformInfo, event);
				break;
				
			default: 
				result = do_ActionOthers(platformInfo, event);
				break;
		}
		
		return result;
	}
	
	// 삭제된 객체를 지우고, 등록대기 객체를 리스트에 추가 그리고 BringToFront, SendToBack을 시행한다.
	public final void arrangeControls() {
		synchronized (_List) {
			for (int i=_List.size()-1; i>=0; i--) {
				GameControlBase control = _List.get(i);

				if (control._Deleted) {
					_List.remove(i);
					continue;
				} 
				
				if (control instanceof GameControlGroup) {
					((GameControlGroup) control).arrangeControls();
				}
			}
			
			synchronized (_QueRemove) {
				for (GameControlBase control : _QueRemove) {
					_List.remove(control);
				}
				_QueRemove.clear();
			}

			synchronized (_QueAdd) {
				for (GameControlBase control : _QueAdd) {
					_List.add(control);
				}
				_QueAdd.clear();
			}

			synchronized (_QueBringToFront) {
				for (GameControlBase control : _QueBringToFront) {
					_List.remove(control);
					_List.add(control);
				}
				_QueBringToFront.clear();
			}

			synchronized (_QueSendToBack) {
				for (GameControlBase control : _QueSendToBack) {
					_List.remove(control);
					_List.add(0, control);
				}
				_QueSendToBack.clear();
			}
		}
	}
	
	private int _GameControlIndex = 0;
	
	private GameControlBase getGameControl() {
		synchronized (_List) {
			if (_List.size() == 0) return null;

			if (_GameControlIndex >= _List.size()) {
				_GameControlIndex = 0;
				return null;
			}
			
			GameControlBase control = _List.get(_GameControlIndex);
			_GameControlIndex++;
			
			return control;
		}		
	}
	
	private GameControlBase _FocusedObject = null;
	
	private boolean canHaveFocus(MotionEvent event, GameControlBase control) {
		int x = (int) event.getX();
		int y = (int) event.getY();

		return 
			((_FocusedObject == null) || ((_FocusedObject != null) && (_FocusedObject._Deleted))) &&
			(control.getBoundary().isMyArea(x, y));
	}
	
	private boolean do_ActionDown(GamePlatformInfo platformInfo, MotionEvent event) {
		synchronized (_List) {		
			for (int i=_List.size()-1; i>=0; i--) {
				GameControlBase control = _List.get(i);
				if (isControlVisible(control) == false) continue;
				
				if (canHaveFocus(event, control)) {
					_FocusedObject = control;
					control._Focused = true;
				}
				
				if (control.onTouchEvent(platformInfo, event)) return true;
			}
			
			return false;
		}		
	}
	
	private boolean do_ActionUp(GamePlatformInfo platformInfo, MotionEvent event) {
		boolean result = false;
		
		synchronized (_List) {		
			for (int i=_List.size()-1; i>=0; i--) {
				GameControlBase control = _List.get(i);
				if (isControlVisible(control) == false) continue;

				if (control.onTouchEvent(platformInfo, event)) {
					result = true;
					break;
				}
			}

			// ACTION_UP이면 오브젝트가 포커스를 가질 수가 없다.
			if (_FocusedObject != null) _FocusedObject._Focused = false;
			_FocusedObject = null;
			
			return result;
		}		
	}
	
	private boolean do_ActionOthers(GamePlatformInfo platformInfo, MotionEvent event) {
		synchronized (_List) {		
			for (int i=_List.size()-1; i>=0; i--) {
				GameControlBase control = _List.get(i);
				if (isControlVisible(control) == false) continue;

				if (control.onTouchEvent(platformInfo, event)) return true;
			}
			
			return false;
		}		
	}
	
	private boolean isControlAvailable(GameControlBase control) {
		return (control._Deleted == false) && (control.getVisible()) && (control.getEnabled());
	}

	private boolean isControlVisible(GameControlBase control) {
		return (control._Deleted == false) && (control.getVisible());
	}
	
}
```

> 6) GameMessage 소스
```
package ryulib.game;

public class GameMessage {
	
	public int what = 0;
	public int arg1 = 0;
	public int arg2 = 0;
	public String str = "";
	public Object sender = null;
	public Object obj = null;

}
```

> 7) GameMessageList 소스
```
package ryulib.game;

import java.util.ArrayList;

public class GameMessageList {
	
	private ArrayList<GameMessage> _List = new ArrayList<GameMessage>();
	
	public synchronized void clear() {
		_List.clear();
	}

	public synchronized void add(GameMessage gameMessage) {
		_List.add(gameMessage);
	}

	public synchronized void remove(GameMessage gameMessage) {
		_List.remove(gameMessage);
	}
	
	private GameMessage _NullMessage = new GameMessage();
	
	public synchronized GameMessage get() {
		if (_List.size() == 0) return _NullMessage;
		
		GameMessage gameMessage = _List.get(0);
		_List.remove(0);
		
		return gameMessage;
	}
	
	public synchronized int size() {
		return _List.size();
	}

}
```

> 8) GamePlatform 소스
```
package ryulib.game;

import ryulib.OnHandlerMessageListener;
import ryulib.OnNotifyEventListener;
import ryulib.ThreadRepeater;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePlatform extends SurfaceView implements SurfaceHolder.Callback {

	public GamePlatform(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		init();
	}

	public GamePlatform(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	public GamePlatform(Context context) {
		super(context);

		init();
	}

	private void init() {
	    _SurfaceHolder.addCallback(this);
		_Repeater.setOnNotifyEvent(_OnRepeat);
		
	    // 키보드 이벤트를 받기 위해서는 포커스를 확보
	    setFocusable(true);
	}	

	private GameControlGroup _GameControlGroup = new GameControlGroup(null);
	private GamePlatformInfo _GamePlatformInfo = new GamePlatformInfo(this);
    private SurfaceHolder _SurfaceHolder = getHolder();
	private ThreadRepeater _Repeater = new ThreadRepeater();

	// Property
	private boolean _UseKeyEvent = false;
	private boolean _UseMotionEvent = false;
	private boolean _AutoInvalidate = false;  

	private void start() {
		_OldTick = System.currentTimeMillis();
		_Repeater.start();
	}
	
	private void stop() {
		_Repeater.stop();
	}
	
	public final void clearControls() {
		_GameControlGroup.clearControls();
	}
	
	public final void addControl(GameControlBase control) {
		_GameControlGroup.addControl(control);
	}

	public final void removeControl(GameControlBase control) {
		_GameControlGroup.removeControl(control);
	}
	
	@Override
	public final void surfaceCreated(SurfaceHolder holder) {
		start();
	}

	@Override
	public final void surfaceDestroyed(SurfaceHolder holder) {
		stop();
	}
	
	@Override
    public final void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    	_GamePlatformInfo.setSize(width, height);
    	// TODO : GameControlBase에 OnSurfaceChanged 추가
	}

	@Override
    public final boolean onKeyDown(int keyCode, KeyEvent msg) {
    	if (_UseKeyEvent) {
    		_GameControlGroup.onKeyDown(_GamePlatformInfo, keyCode, msg);
    		if (_AutoInvalidate) _OnRepeat.onNotify(_Repeater);
    	}
        return true;
    }

	@Override
    public final boolean onKeyUp(int keyCode, KeyEvent msg) {
    	if (_UseKeyEvent) {
    		_GameControlGroup.onKeyUp(_GamePlatformInfo, keyCode, msg);
    		if (_AutoInvalidate) _OnRepeat.onNotify(_Repeater);
    	}
        return true;
    }

	@Override
	public final boolean onTouchEvent(MotionEvent event) {
		if (_UseMotionEvent) {
			_GameControlGroup.onTouchEvent(_GamePlatformInfo, event);
    		if (_AutoInvalidate) _OnRepeat.onNotify(_Repeater);
		}
		return true;
	}
	
	private long _OldTick = System.currentTimeMillis();

    private OnNotifyEventListener _OnRepeat = new OnNotifyEventListener() {
    	@Override
		public synchronized void onNotify(Object sender) {
			Canvas canvas = _SurfaceHolder.lockCanvas(null);
            try {
                if (canvas == null) return;
	                
				long tick = System.currentTimeMillis();
				_GamePlatformInfo.setTick(tick - _OldTick);
				_GamePlatformInfo.getNextMessage();

				_GameControlGroup.onRepeate(_GamePlatformInfo);

				_OldTick = tick;

        		_GamePlatformInfo.draw(canvas);
            } finally {
                if (canvas != null) {
                	_SurfaceHolder.unlockCanvasAndPost(canvas);
                }
	    	}
            
            _GameControlGroup.arrangeControls();
		}
	};
	
	public final GameControlGroup getGameControlGroup() {
		return _GameControlGroup;
	}
	
	public final GamePlatformInfo getGamePlatformInfo() {
		return _GamePlatformInfo;
	}

	public final void setOnHandlerMessage(OnHandlerMessageListener value) {
		_GamePlatformInfo.setOnHandlerMessage(value);
	}

	public final void setUseKeyEvent(boolean _UseKeyEvent) {
		this._UseKeyEvent = _UseKeyEvent;
	}

	public final boolean getUseKeyEvent() {
		return _UseKeyEvent;
	}

	public final void setUseMotionEvent(boolean _UseMotionEvent) {
		this._UseMotionEvent = _UseMotionEvent;
	}

	public final boolean getUseMotionEvent() {
		return _UseMotionEvent;
	}

	public final void setRepeatInterval(long value) {
		_Repeater.setInterval(value);
	}

	public final long getRepeatInterval() {
		return _Repeater.getInterval();
	}

	public final void setAutoInvalidate(boolean value) {
		// CPU 효율을 위해서, ThreadRepeater를 느리게 하고, 대신 키보드 메시지 등의 처리 이후 화면 갱신을 한다.
		_AutoInvalidate = value;
	}

	public final boolean isAutoInvalidate() {
		return _AutoInvalidate;
	}

}
```

> 9)GamePlatformInfo 소스
```
package ryulib.game;

import ryulib.OnHandlerMessageListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;

public class GamePlatformInfo {

	public GamePlatformInfo(GamePlatform gamePlatform) {
		super();
		
		_GamePlatform = gamePlatform;
		_Paint.setAntiAlias(true);
	}

	private GamePlatform _GamePlatform = null;
	private Bitmap _Bitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
	private Canvas _Canvas = new Canvas();
	private Paint _Paint = new Paint();
	private long _Tick = 0;
	
	private GameMessageList _GameMessageList = new GameMessageList();
	private GameMessage _GameMessage = null;

	private Handler _Handler = new Handler() {		
		public void handleMessage(Message msg) {
			if (_OnHandlerMessage != null) _OnHandlerMessage.onReceived(msg);
		}
	};
	
	final void setTick(long value) {
		// Tick 간격이 너무 크다면 에러이거나 병목 등의 문제일 수 있다.  
		// 이때, 생각 이외의 동작을 유발 할 수 있으므로 Term의 크기를 제한한다.
		if (value > _TickLimit) value = _TickLimit;

		_Tick = value;
	}

	final void getNextMessage() {
		_GameMessage = _GameMessageList.get();
	}
	
	final synchronized void setSize(int width, int height) {
		  _Bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		  _Canvas.setBitmap(_Bitmap);
	}
	
	final synchronized void draw(Canvas canvas) {
		canvas.drawBitmap(_Bitmap, 0, 0, _Paint);
	}
	
	private static final int _TickLimit = 500;

	private OnHandlerMessageListener _OnHandlerMessage = null;
	
	void setOnHandlerMessage(OnHandlerMessageListener value) {
		_OnHandlerMessage = value;
	}

	public final void addMessage(GameMessage gameMessage) {
		_GameMessageList.add(gameMessage);
	}
	
	public final void addMessage(Object sender, int what) {
		GameMessage gameMessage = new GameMessage();
		gameMessage.sender = sender;
		gameMessage.what = what;
		
		_GameMessageList.add(gameMessage);
	}
	
	public final void addMessage(Object sender, String str) {
		GameMessage gameMessage = new GameMessage();
		gameMessage.sender = sender;
		gameMessage.str = str;
		
		_GameMessageList.add(gameMessage);
	}
	
	public final Bitmap getBitmap() {
		return _Bitmap;
	}

	public final Canvas getCanvas() {
		return _Canvas;
	}
	
	public final Paint getPaint() {
		return _Paint;
	}
	
	public final GameMessage getGameMessage() {
		return _GameMessage;
	}
	
	public final Handler getHandler() {
		return _Handler;
	}
	
	public final long getTick() {
		return _Tick;
	}
	
	private Rect _Rect = new Rect();
	
	public final Rect getRect() {
		_Rect.left = 0;
		_Rect.top = 0;
		_Rect.right = _Canvas.getWidth();
		_Rect.bottom = _Canvas.getHeight();
		
		return _Rect;
	}

	public final GamePlatform getGamePlatform() {
		return _GamePlatform;
	}
	
}
```

  1. ) HitArea 소스
```
package ryulib.game;

import java.util.ArrayList;

import ryulib.graphic.Boundary;

public class HitArea {
	
	private ArrayList<Boundary> _List = new ArrayList<Boundary>();
	
	public boolean checkCollision(HitArea hitArea) {
		// TODO 
		for (Boundary src : _List) {
			for (Boundary dst : hitArea._List) {
				if (src.CheckCollision(dst)) return true;
			}
		}
		
		return false;
	}
	
	public boolean getIsMyArea(int x, int y) {
		for (Boundary block : _List) {
			if (block.isMyArea(x, y)) return true;
		}
		return false;
	}

	public void clear() {
		_List.clear();
	}
	
	public void add(Boundary boundary) {
		_List.add(boundary);
	}
	
	public void remove(Boundary boundary) {
		_List.remove(boundary);
	}
	
	public ArrayList<Boundary> getArrayList() {
		return _List;
	}
	
}
```

  1. ) ImageButton 소스
```
package ryulib.game;

import ryulib.OnNotifyEventListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

public class ImageButton extends GameControl {

	public ImageButton(GameControlGroup gameControlGroup) {
		super(gameControlGroup);
		
		gameControlGroup.addControl(this);
	}
	
	private boolean _IsDowned = false;
	
	private Bitmap _BitmapUp = null; 
	private Bitmap _BitmapDown = null; 
	
	// Property
	private Point _Position = new Point(0, 0);
	private int _ImageUp = -1;
	private int _ImageDown = -1;
	private OnNotifyEventListener _OnClick = null; 
	
	@Override
	protected void onDraw(GamePlatformInfo platformInfo) {
		Bitmap bitmap = null;
		Resources resources =
			platformInfo.getGamePlatform().getContext().getResources();
		
		if (_IsDowned) {
			if (_BitmapDown == null) _BitmapDown = loadBitmap(resources, _ImageDown);			
			bitmap = _BitmapDown;
		} else {
			if (_BitmapUp == null) _BitmapUp = loadBitmap(resources, _ImageUp);			
			bitmap = _BitmapUp;
		}
		
		if (bitmap != null) {
			Paint paint = platformInfo.getPaint();
			Canvas canvas = platformInfo.getCanvas();
			
			canvas.drawBitmap(bitmap, _Position.x, _Position.y, paint);
		}
	}
	
	@Override
    protected final boolean onTouchEvent(GamePlatformInfo platformInfo, MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		
		boolean isMyArea = getBoundary().isMyArea(x, y); 
		
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN: doActionDown(isMyArea); break;
			case MotionEvent.ACTION_UP: doActionUp(isMyArea); break;
		}

		return isMyArea;
    }
	
	private Bitmap loadBitmap(Resources resources, int id) {
		Bitmap bitmap = null;
		
		if (id > -1) {
			bitmap = BitmapFactory.decodeResource(resources, id);
			getBoundary().setBoundary(
					_Position.x, 
					_Position.y, 
					_Position.x+bitmap.getWidth(), 
					_Position.y+bitmap.getHeight()
			);
		}
		
		return bitmap;
	}

	private void doActionDown(boolean isMyArea) {
		_IsDowned = isMyArea; 
	}
    
	private void doActionUp(boolean isMyArea) {
		if (isMyArea && _IsDowned) {
			if (_OnClick != null) 
				_OnClick.onNotify(this);
		}
		
		_IsDowned = false; 		
	}
    
	public final void setImageUp(int value) {
		_ImageUp = value;
		_BitmapUp = null;
	}
	
	public final int getImageUp() {
		return _ImageUp;
	}

	public final void setImageDown(int value) {
		_ImageDown = value;
		_BitmapDown = null;
	}

	public final int getImageDown() {
		return _ImageDown;
	}

	public void setOnClick(OnNotifyEventListener value) {
		_OnClick = value;
	}

	public OnNotifyEventListener getOnClick() {
		return _OnClick;
	}
	
	private void changeBoundary() {
		getBoundary().setLeft(_Position.x);
		getBoundary().setTop(_Position.y);
	}
	
	public void setPosition(int x, int y) {
		_Position.x = x;
		_Position.y = y;
		changeBoundary();
	}

	public void setX(int value) {
		_Position.x = value;
		changeBoundary();
	}

	public int getX() {
		return _Position.x;
	}

	public void setY(int value) {
		_Position.y = value;
		changeBoundary();
	}

	public int getY() {
		return _Position.y;
	}

}
```

  1. ) IScene 소스
```
package ryulib.game;

import ryulib.ValueList;

public interface IScene {

	public void setSceneManager(SceneManager sceneManager);
	public void actionIn(IScene AOldScene, ValueList AParams);
	public void actionOut(IScene ANewScene);	

}
```

  1. ) JoyStick 소스
```
package ryulib.game;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class JoyStick extends JoyStickInterface implements SensorEventListener {

	public JoyStick() {
		super();
		
	}

	public JoyStick(int speed) {
		super(speed);
		
	}
	
	public void PrepareOrientationSensor(Context context) {
	    SensorManager _SensorManager;
	    Sensor _Sensor;    
	    
		_SensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		_Sensor = _SensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		
        if (_Sensor != null) {
        	_SensorManager.registerListener(this, _Sensor, SensorManager.SENSOR_DELAY_GAME);
        }
    }

	private int _TargetY = 0;
	private boolean _IsMoving = false;
	
	// 기울여진 상태가 아니라고 판단하게 되는 각도, 
	// 즉, 아래에서 설정된 값으로 기울여진 상태는 평평하다고 간주한다.
	private int _DefaultAngle = 0;
	
	// 얼마나 기울여야 반응 할 것 인지.  이 이상 기울여야지만 반응하게 된다.
	private int _AngleLimit = 5;

	
	@Override
	public void tick(long tick) {
		super.tick(tick);
		
		if (_IsMoving) {
			if ((_DY < 0) && (_Y <= _TargetY)) {
				_IsMoving = false;
				_DY = 0;
				_Y = _TargetY;
			}
			
			if ((_DY > 0) && (_Y >= _TargetY)) {
				_IsMoving = false;
				_DY = 0;
				_Y = _TargetY;
			}
		}
	}
	
	public void onKeyDown(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_DPAD_LEFT: _DX = -1; break;
	
			case KeyEvent.KEYCODE_DPAD_RIGHT: _DX = +1; break;
	
			case KeyEvent.KEYCODE_DPAD_UP: 
			case KeyEvent.KEYCODE_Q: _DY = -1; break;
	
			case KeyEvent.KEYCODE_DPAD_DOWN:
			case KeyEvent.KEYCODE_W: _DY = +1; break;
		}
    }

	public void onKeyUp(GamePlatformInfo platformInfo, int keyCode, KeyEvent msg) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_DPAD_LEFT: if (_DX == -1) _DX =0; break;
		
			case KeyEvent.KEYCODE_DPAD_RIGHT: if (_DX == +1) _DX =0; break;
	
			case KeyEvent.KEYCODE_DPAD_UP: 
			case KeyEvent.KEYCODE_Q: if (_DY == -1) _DY =0; break;
			
			case KeyEvent.KEYCODE_DPAD_DOWN:
			case KeyEvent.KEYCODE_W: if (_DY == +1) _DY =0; break;
		}
    }

	public void onTouchEvent(GamePlatformInfo platformInfo, MotionEvent event) {
		_TargetY = (int) event.getY();
		_IsMoving = true;
		
		if (_TargetY > _Y) _DY = 1;
		else if (_TargetY < _Y) _DY = -1;
		else _IsMoving = false;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		int x = (int) event.values[SensorManager.DATA_Y];
		int y = (int) event.values[SensorManager.DATA_Z];
		
		if (x < (- _AngleLimit)) _DX = 1;
		else if (x > (_AngleLimit)) _DX = -1;
		else _DX = 0;
		
		if (y < (_DefaultAngle - _AngleLimit)) _DY = -1;
		else if (y > (_DefaultAngle + _AngleLimit)) _DY = 1;
		else _DY = 0;
	}

	public void setDefaultAngle(int _DefaultAngle) {
		this._DefaultAngle = _DefaultAngle;
	}

	public int getDefaultAngle() {
		return _DefaultAngle;
	}

	public void setAngleLimit(int _AngleLimit) {
		this._AngleLimit = _AngleLimit;
	}

	public int getAngleLimit() {
		return _AngleLimit;
	}
	
}
```

  1. ) JoyStickInterface 소스
```
package ryulib.game;

public abstract class JoyStickInterface {
	
	public JoyStickInterface() {
		super();
	}
	
	public JoyStickInterface(int speed) {
		super();
		
		_Scroll.setSpeed(speed);
	}

	protected int _X = 0;
	protected int _Y = 0;
	
	private int _LeftLimit = 0;  
	private int _TopLimit = 0;  
	private int _RightLimit = 0;  
	private int _BottomLimit = 0;
	
	private int _ObjectWidth = 0;
	private int _ObjectHeight = 0;
	
	private boolean _UseBoundaryLimit = false;
	
	protected int _DX = 0;
	protected int _DY = 0;
	
	private Scroll _Scroll = new Scroll();
	
	public void setBoundaryLimit(boolean useBoundaryLimit, 
			int leftLimit, int topLimit, 
			int rightLimit, int bottomLimit, 
			int objectWidth, int objectHeight) {
		
		_UseBoundaryLimit = useBoundaryLimit;
		_LeftLimit = leftLimit;
		_TopLimit = topLimit;
		_RightLimit = rightLimit;
		_BottomLimit = bottomLimit;
		_ObjectWidth = objectWidth;
		_ObjectHeight = objectHeight;
	}
	
	public void tick(long tick) {
		int temp = _Scroll.move(tick);
		_X = _X + (_DX * temp);
		_Y = _Y + (_DY * temp);
		
		if (_UseBoundaryLimit == false) return;
		
		if (_X < _LeftLimit) {
			_X = _LeftLimit;
		} else if (_X > (_RightLimit-_ObjectWidth)) {
			_X = _RightLimit-_ObjectWidth;
		}
		
		if (_Y < _TopLimit) {
			_Y = _TopLimit;
		} else if (_Y > (_BottomLimit-_ObjectHeight)) {
			_Y = _BottomLimit-_ObjectHeight;
		}
	}
	
	public int getX() {
		return _X;		
	}
	
	public void setX(int value) {
		_X = value;
	}
	
	public int getY() {
		return _Y;
	}

	public void setY(int value) {
		_Y = value;
	}
	
    public int getSpeed() {
    	return _Scroll.getSpeed();
    }
    
    public void setSpeed(int value) {
    	_Scroll.setSpeed(value);
    }

	public void setLeftLimit(int value) {
		this._LeftLimit = value;
	}

	public int getLeftLimit() {
		return _LeftLimit;
	}
    
	public void setTopLimit(int value) {
		this._TopLimit = value;
	}

	public int getTopLimit() {
		return _TopLimit;
	}

	public void setRightLimit(int value) {
		this._RightLimit = value;
	}

	public int getRightLimit() {
		return _RightLimit;
	}

	public void setBottomLimit(int value) {
		this._BottomLimit = value;
	}

	public int getBottomLimit() {
		return _BottomLimit;
	}

	public void setObjectWidth(int value) {
		this._ObjectWidth = value;
	}

	public int getObjectWidth() {
		return _ObjectWidth;
	}

	public void setObjectHeight(int value) {
		this._ObjectHeight = value;
	}

	public int getObjectHeight() {
		return _ObjectHeight;
	}

	public void setUseBoundaryLimit(boolean value) {
		this._UseBoundaryLimit = value;
	}

	public boolean isUseBoundaryLimit() {
		return _UseBoundaryLimit;
	}

}
```

  1. ) SceneManager 소스
```
package ryulib.game;

import java.util.HashMap;

import ryulib.ValueList;

public class SceneManager {
	
	public SceneManager(GamePlatform gamePlatform) {
		super();
		
		_GamePlatform = gamePlatform;
	}
	
	private HashMap<String, IScene> _SceneList = new HashMap<String, IScene>();
	private String _ActiveName = "";
	private IScene _ActiveScene = null;
	
	// Property 
	private GamePlatform _GamePlatform = null;
	
	public synchronized void clear() {
		_SceneList.clear();
	}
	
	public synchronized void add(String name, IScene scene) {
		_SceneList.put(name, scene);
		scene.setSceneManager(this);
	}
	
	public synchronized void remove(String name) {
		_SceneList.remove(name);
	}
	
	public synchronized void setActiveName(String name, ValueList params) {
		IScene scene = _SceneList.get(name);
		// TODO : raise Exception
		if (scene == null) return;
		
		IScene temp = _ActiveScene;
		
		_ActiveName = name;
		_ActiveScene = scene;
		
		if (temp != null) temp.actionOut(scene);
		scene.actionIn(temp, params);
	}
	
	public String getActiveName() {
		return _ActiveName;
	}
	
	public IScene getActiveScene() {
		return _ActiveScene;
	}

	public GamePlatform getGamePlatform() {
		return _GamePlatform;
	}

}
```

  1. ) Scroll 소스
```
package ryulib.game;

public class Scroll {
	
	public Scroll() {
		super();
	}

	public Scroll(int speed) {
		super();
		
		_Speed = speed;
	}

	private int _Distance = 0;
	private long _DX = 0;
	
	private int _Speed = 0;
	
	public void init() {
		_Distance = 0;
		_DX = 0;
	}
	
	public int move(long tick) {
		int result = 0;
		
		_DX = _DX + (_Speed * tick);
		
		if (_DX >= 1000) {
			 result = (int) _DX / 1000;
			_DX = _DX - (result * 1000);
			
			_Distance = _Distance + result;
		}
		
		return result;
	}
	
	public int getDistance() {
		return _Distance;
	}

	public void setSpeed(int value) {
		_Speed = value;
	}

	public int getSpeed() {
		return _Speed;
	}

}
```

5. ryulib.graphic 패키지
  1. AnimationCounter 소스
```
package ryulib.graphic;

public class AnimationCounter {

	public AnimationCounter() {
		super();
	}

	public AnimationCounter(int interval, int size) {
		super();
		
		_Interval = interval;
		_Size = size;
		
		clear();
	}

	private long _TickCount = 0;
	
	// Property 
	private int _Interval = 0;
	private int _Size = 0;
	private int _Index =0;
	private boolean _AutoRewind = true;
	
	public void clear() {
		_Index = 0;
		_TickCount = 0;
	}

	public void tick(long tick) {
		_TickCount = _TickCount + tick;
		
		if (_TickCount >= _Interval) {
			_TickCount = _TickCount - _Interval;
			_Index++;

			if ((_AutoRewind) && (_Index >= _Size)) {
				_Index = 0;
			}
		}
	}
	
	public void setInterval(int value) {
		_Interval = value;
	}
	
	public int getInterval() {
		return _Interval;
	}
	
	public void setSize(int value) {
		_Size = value;
	}

	public int getSize() {
		return _Size;
	}

	public int getIndex() {
		return _Index;
	}

	public void setAutoRewind(boolean value) {
		_AutoRewind = value;
	}

	public boolean isAutoRewind() {
		return _AutoRewind;
	}

}
```

> 2) BitmapList 소스
```
package ryulib.graphic;

import android.graphics.Bitmap;

public abstract class BitmapList {

	protected Bitmap[] _Bitmaps = null;

	public Bitmap getBitmap(int index) {
    	if (_Bitmaps == null) loadBitmaps();
    	
    	if ((index >= 0) && (index < _Bitmaps.length)) {
    		return _Bitmaps[index];
    	} else {
    		return null;
    	}
    }
    
    public int getCount() {
    	if (_Bitmaps == null) loadBitmaps();
    	return _Bitmaps.length;
    }
    
    abstract protected void loadBitmaps();
    
}
```

> 3) Boundary 소스
```
package ryulib.graphic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Boundary {
	
	public Boundary(int Left, int Top, int Right, int Bottom) {
		setBoundary(Left, Top, Right, Bottom);
	}
	
	public Boundary(Boundary boundary) {
		setBoundary(boundary);
	}
	
	private int _Left;
	private int _Top;
	private int _Right;
	private int _Bottom;
	private Rect _Rect = new Rect();	
	
	// 직선 (S1, E1), (S2, E2)가 서로 교차하는 지 검사한다.
	private boolean check_LineCollision(int S1, int E1, int S2, int E2) {
		boolean A = (S1 <= S2) && (S2 <= E1);
		boolean B = (S1 <= E2) && (E2 <= E1);
		boolean C = (S2 <= S1) && (S1 <= E2);
		boolean D = (S2 <= E1) && (E1 <= E2);
		
		return (A || B || C || D);			
	}
	
	public boolean CheckCollision(Boundary ADest) {
		return 
			check_LineCollision(_Left, _Right, ADest.getLeft(), ADest.getRight()) && 
			check_LineCollision(_Top, _Bottom, ADest.getTop(), ADest.getBottom());
	}
	
	public void setLeft(int ALeft) {
		int Temp = _Left;
		
		_Left = ALeft;
		_Right = _Right + _Left - Temp;
	}
	
	public void incLeft(int value) {
		_Left += value;
		_Right = _Right + value;
	}
	
	public void setTop(int ATop) {
		int Temp = _Top;
		
		_Top = ATop;
		_Bottom = _Bottom + _Top - Temp;
	}
	
	public void incTop(int value) {
		_Top += value;
		_Bottom = _Bottom + value;
	}
	
	public void setRight(int ARight) {
		int Temp = _Right;
		
		_Right = ARight;
		_Left = _Left + _Right - Temp;
	}
	
	public void setBottom(int ABottom) {
		int Temp = _Bottom;
		
		_Bottom = ABottom;
		_Top = _Top + _Bottom - Temp;
	}
	
	public void setBoundary(int ALeft, int ATop, int ARight, int ABottom) {
		_Left   = ALeft;
		_Top    = ATop;
		_Right  = ARight;
		_Bottom = ABottom;
	}
	
	public void setBoundary(Boundary value) {
		_Left   = value._Left;
		_Top    = value._Top;
		_Right  = value._Right;
		_Bottom = value._Bottom;
	}
	
	public int getLeft() {
		return _Left;
	}

	public int getTop() {
		return _Top;
	}

	public int getRight() {
		return _Right;
	}

	public int getBottom() {
		return _Bottom;
	}
	
	public int getWidth() {
		return _Right - _Left;
	}

	public int getHeight() {
		return _Bottom - _Top;
	}
	
	public Rect getRect() {
		_Rect.set(_Left, _Top, _Right, _Bottom);
		return _Rect;
	}
	
	public Rect getRect(int x, int y) {
		_Rect.set(_Left+x, _Top+y, _Right+x, _Bottom+y);
		return _Rect;
	}
	
	public Rect getRect(Point point) {
		return getRect(point.x, point.y);
	}
	
	public int getHorizontalCenter() {
		return _Left + (getWidth() / 2);
	}

	public int getVerticalCenter() {
		return _Top + (getHeight() / 2);
	}

	public void setHorizontalCenter(int value) {
		setLeft(value - (getWidth() / 2));
	}

	public void setVerticalCenter(int value) {
		setTop(value - (getHeight() / 2));
	}

	public void setCenter(int x, int y) {
		setHorizontalCenter(x);	
		setVerticalCenter(y);
	}
	
	public boolean isMyArea(int x, int y) {
		return (x >= _Left) && (x <= _Right) && (y >= _Top) && (y <= _Bottom);
	}
	
	public void drawTextCenter(Canvas canvas, Paint paint, String text) {
		paint.setTextAlign(Paint.Align.CENTER);

		Rect rect = new Rect();
		paint.getTextBounds(text, 0, text.length(), rect);
		
		canvas.drawText(text, getHorizontalCenter(), getVerticalCenter() + ((rect.bottom-rect.top) / 2), paint);
	}

}
```

6. ryulib.internet 패키지
  1. HTTP 소스
```
package ryulib.internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTP {
	
	static public int ConnectTimeout = 5 * 1000;
	
	static public String get(String AAddress) {
		StringBuilder _Result = new StringBuilder();

		try {
			URL _URL = new URL(AAddress);
			
			HttpURLConnection _Connection = (HttpURLConnection) _URL.openConnection();
			if (_Connection != null) {
				_Connection.setConnectTimeout(ConnectTimeout);
				_Connection.setUseCaches(false);
				if (_Connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader _Reader = 
						new BufferedReader(new InputStreamReader(_Connection.getInputStream()));
					while (true) {
						String _Line = _Reader.readLine();
						if (_Line == null) break;
						
						_Result.append(_Line + '\n');
					}
					_Reader.close();
				} else {
					throw new Exception(String.format("ErrorCode = %d", _Connection.getResponseCode()));
				}
					
				_Connection.disconnect();
			}
		} catch (Exception E) {
		}
		
		return _Result.toString();
	}

}
```

7. ryulib.mvc
  1. NotifyPacket 소스
```
package ryulib.mvc;

import java.lang.reflect.Method;
import java.util.ArrayList;

import ryulib.ValueList;

public class NotifyPacket implements Runnable {
	
	private ArrayList<Object> _Observers = null;
	private ValueList _Packet = null;
	
	public NotifyPacket(ArrayList<Object> AObservers, ValueList APacket) {
		_Observers = AObservers;
		_Packet = APacket;
	}
	
	private void do_Notify(Object AObject, ValueList APacket) {
		Class _Class = AObject.getClass();
		Class[] _ParameterType = new Class[] { ValueList.class };
		
		try {
			Method _Method = _Class.getMethod("rp_" + APacket.get("Code"), _ParameterType);
			_Method.invoke(AObject, new Object[] { APacket });
		} catch (Exception e) {
			// Todo : 
		}
	}
	
	public void run() {
		int i;
		for (i=0; i<_Observers.size(); i++) {
			do_Notify(_Observers.get(i), _Packet);
		}
	}
	
}
```

> 2) ObserverList 소스
```
package ryulib.mvc;

import java.lang.reflect.Method;
import java.util.ArrayList;

import ryulib.ValueList;

import android.os.Handler;

public class ObserverList {

	public void clear() {
		_List.clear();
	}
	
	public void add(Object AObject) {
		_List.add(AObject);
	}
	
	public void remove(Object AObject) {
		// 루프 도는 동안 Observer가 삭제되지 않도록 큐에 쌓아서 삭제한다.
		RemoveObserver _RemoveObserver = new RemoveObserver(_List, AObject);
		_Handler.post(_RemoveObserver);
	}
	
	public void asyncBroadcast(ValueList APacket) {
		NotifyPacket _NotifyPacket = new NotifyPacket(_List, APacket);
		_Handler.post(_NotifyPacket);
	}
	
	private void do_Notify(Object AObject, ValueList APacket) {
		Class _Class = AObject.getClass();
		Class[] _ParameterType = new Class[] { ValueList.class };
		
		try {
			Method _Method = _Class.getMethod("rp_" + APacket.get("Code"), _ParameterType);
			_Method.invoke(AObject, new Object[] { APacket });
		} catch (Exception e) {
			// Todo : 
		}
	}

	public void broadcast(ValueList APacket) {
		int i;
		for (i=0; i<_List.size(); i++) {
			do_Notify(_List.get(i), APacket);
		}
	}
	
	private ArrayList<Object> _List = new ArrayList<Object>(); 

	private Handler _Handler = new Handler();

}
```

> 3) RemoveObserver 소스
```
package ryulib.mvc;

import java.util.ArrayList;

public class RemoveObserver implements Runnable {

	private ArrayList<Object> _Observers = null;
	private Object _Object = null;

	public RemoveObserver(ArrayList<Object> AObservers, Object AObject) {
		_Observers = AObservers;
		_Object = AObject;
	}
	
	public void run() {
		_Observers.remove(_Object);
	}
	
}
```

# Reference #
게임 소스 : http://ryulib.tistory.com/121
게임 자체의 소스의 출처입니다. 맨처음 메인화면에서 버튼을 눌러 다른 액티비티로 이동하고 어플 내의 버튼을 누르면 다른 어플이 실행되는 상황은 제가 구현했습니다.<sup>_</sup>
게임 자체의 소스도 변경하여 easy모드와 hard모드로 나누어서 퍼즐의 크기를 다르게 하여 난이도 조절을 했습니다.