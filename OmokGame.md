# Introduction #

많은 사람들이 흔히 아는 오목게임 어플이다.


# Details #

![http://comp166-koreauniv.googlecode.com/files/main_page.jpg](http://comp166-koreauniv.googlecode.com/files/main_page.jpg)

**위는 먼저 앱을 실행했을 때 가장 먼저 나오는 main화면이다. 이 화면에는 버튼이 2개 있는데, Newgame버튼을 누르면 게임화면으로 넘어가고, Exit버튼을 누르면 앱이 종료된다.**

![http://comp166-koreauniv.googlecode.com/files/game_page.jpg](http://comp166-koreauniv.googlecode.com/files/game_page.jpg)

위는 게임화면이다. main화면에서 Newgame버튼을 누르면 나오는 화면이다. 하단의 6개의 버튼은 게임실행할 때 도움을 주는 버튼들이다. 먼저 MoveFirst는 게임 시작 첫 화면으로 돌아가고, Undo버튼은 가장 마지막 바둑돌을 놓기 전 화면으로 돌아가는 것이고, Redo는 Undo버튼을 누른 화면에서 가장 마지막 바둑돌이 놓인 화면으로 가는 것이고 MoveLast버튼은 가장 마지막 화면으로 돌아가는 것이다. 그리고 그 밑의 Newgame버튼은 새게임 시작, Exit은 이 게임페이지를 벗어나 다시 main화면으로 가는 버튼이다.


이 앱의 코드는 다음과 같다.


먼저 무슨 파일들이 있는지 살펴보면 다음 화면과 같다.

![http://comp166-koreauniv.googlecode.com/files/Omok_list.jpg](http://comp166-koreauniv.googlecode.com/files/Omok_list.jpg)

Omok\_list.jpg

**위의 사진에서 알 수 있듯이 총 6개의 파일이 있다. 그를 차근차근 살펴보면 다음과 같다.**

MainActivity.java 메인 화면에 대한 코드이다. 두개의 버튼이 있는데, 하나는 게임페이지로 넘어가고, 다른 하나는 앱을 종료시킨다.


```
package com.example.game;


import android.os.Bundle;
import java.util.Stack;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        Button newgame_btn = (Button)findViewById(R.id.Button_newgame);
	        Button exit_btn = (Button)findViewById(R.id.Button_exit);
	        
	        newgame_btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {

					Intent i = new Intent(MainActivity.this,NewGame.class);
					startActivity(i);
					
				}
			}); // button(newgame)을 누르면 NewGame.class로 넘어간다.

	        
	        exit_btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
				}
			}); // button(exit)을 누르면 끝난다.
	    }
	 @Override
	 protected void onResume(){
		 super.onResume();
		 Music.play(this,R.raw.main);
	 } //main에서 main이라는 노래가 나온다.
	 @Override
	 protected void onPause(){
		 super.onPause();
		 Music.stop(this);
	 }
}

```


NewGame.java 이는 게임실행과 관련된 파일이다.

```
package com.example.game;

import android.os.Bundle;
import java.util.Stack;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NewGame extends Activity implements OnClickListener {

	public static final int LINE_NUM = 9; 
	public Dol[][] dolArr = null;
	public TurnThread tThread = null; 

	private Stack<Dol> back = null;
	private Stack<Dol> forward = null;
	private Dol lastDol = null;
	private OmokView ov = null;
	private Button mBtnMoveFirst = null;
	private Button mBtnUndo = null;
	private Button mBtnRedo = null;
	private Button mBtnMoveLast = null;
	private Button mBtnNewGame = null;
	private Button mBtnExit = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);

		mBtnUndo = (Button) findViewById(R.id.btnUndo);
		mBtnRedo = (Button) findViewById(R.id.btnRedo);
		mBtnNewGame = (Button) findViewById(R.id.btnNewGame);
		mBtnMoveFirst = (Button) findViewById(R.id.btnFirst);
		mBtnMoveLast = (Button) findViewById(R.id.btnLast);
		mBtnExit = (Button) findViewById(R.id.btnExit);

		mBtnUndo.setOnClickListener(this);
		mBtnRedo.setOnClickListener(this);
		mBtnMoveFirst.setOnClickListener(this);
		mBtnMoveLast.setOnClickListener(this);
		mBtnNewGame.setOnClickListener(this);
		mBtnExit.setOnClickListener(this);

		dolArr = new Dol[LINE_NUM][LINE_NUM]; //9X9의 배열을 만든다.

		LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout01);

		for (int i = 0; i < dolArr.length; i++) {
			for (int j = 0; j < dolArr[0].length; j++) {
				dolArr[i][j] = new Dol(); // 만들어진 배열에 Dol객체를 만든다.
			}
		}

		back = new Stack<Dol>();
		forward = new Stack<Dol>();
		lastDol = new Dol(); 
		tThread = new TurnThread(this); 
		ov = new OmokView(this); //게임 화면을 부른다.
		layout.addView(ov,0);
		tThread.start();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		tThread.stopThread(); 
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnUndo) {
			goBack(); // btnUndo를 누르면 goBack메소드를 부른다.
		} else if (v.getId() == R.id.btnRedo) {
			goForward(); // btnRedo를 누르면 goForward메소드를 부른다.
		} else if (v.getId() == R.id.btnNewGame) {
			newGame(); // btnNewGame을 누르면 newGame메소드를 부른다.
		} else if (v.getId() == R.id.btnFirst) {
			goFirst(); // btnFirst를 누르면 goFirst메소드를 부른다.
		} else if (v.getId() == R.id.btnLast) {
			goLast(); //btnLast를 누르면 goLast메소드를 부른다.
		} else if (v.getId() == R.id.btnExit) {
			finish(); //btnExit을 누르면 끝낸다.
		}
		ov.invalidate();
	}

	public void viewMsg(String str) {
		Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
	} // 오목 수를 놓을 때 마다 메세지를 띄운다.

	
	public void newGame() {
		while (!getBack().isEmpty()) {
			getBack().pop().isPlace = false;
		} //getBack이 비어있지 않으면 비도록 한다.

		
		forward.clear();
		tThread.initSecond();
		if (!tThread.isBlackTurn) {
			tThread.turnChange();
		} // 전에 놓은 수가 흑색이면 색을 바꾼다.
		tThread = new TurnThread(this);
		tThread.start();
	}

	
	public void goFirst() {
		Dol tmp = new Dol();
		for (int i = getBack().size(); i > 0; i--) {
			if (!getBack().empty()) {
				tmp = getBack().pop();
				tmp.isPlace = false;
				forward.push(tmp);
			}
		} // 가장 첫화면으로 돌아오는 것 (xml 파일의 MoveFirst 버튼과 연동)
	} 

	public void goLast() { 

		Dol tmp = new Dol();

		while (!forward.empty()) {
			tmp = forward.pop();
			tmp.isPlace = true;
			getBack().push(tmp);
		}
		if (!getBack().empty()) {
			getLastDol().x = getBack().peek().x;
			getLastDol().y = getBack().peek().y;
		}
	} // 마지막 화면으로 돌아가는 것. (xml 파일의 MoveLast 버튼과 연동)

	public void goForward() { 
		if (!forward.empty()) {
			Dol tmp = new Dol();
			tmp = forward.pop();
			tmp.isPlace = true;
			getBack().push(tmp);
			if (!getBack().empty()) {
				getLastDol().x = getBack().peek().x;
				getLastDol().y = getBack().peek().y;
			}
		}
	} // 전 화면으로 돌려 놓은 화면을 다시 제자리로 돌리는 것. (xml파일의 Redo 버튼과 연동)

	public void goBack() { 
		if (!getBack().empty()) {
			Dol tmp = new Dol();
			tmp = getBack().pop();
			tmp.isPlace = false;
			forward.push(tmp);
			if (!getBack().empty()) {
				getLastDol().x = getBack().peek().x;
				getLastDol().y = getBack().peek().y;

			}
		} // 방금의 돌을 놓기 전 화면으로 돌아감(xml파일의 Undo버튼과 연동)
	}

	public void putDol(Dol dol) { 
		getBack().push(dol);
		if (!forward.empty()) {
			forward.clear();
		}
	} 

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
		dialog.setTitle(getBack().peek().isBlack ? "Black Win!!"
				: "White Win!!");
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 1:
			tThread.stopThread();
			return new AlertDialog.Builder(this)
					.setTitle(
							getBack().peek().isBlack ? "Black Win!!"
									: "White Win!!")
					.setMessage("")
					.setNeutralButton("NewGame",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									newGame();
									ov.invalidate();
								}
							}).show();
		default:
			break;
		}
		return super.onCreateDialog(id);
	} // 검은색이 이겼는지 흰 색이 이겼는지 메세지를 띠워준다. 그리고 새로운 게임 시작버튼도 함께 띄어준다.

	boolean checkVictory(Dol dol) {

		if (countStone(dol, 1, 0) + countStone(dol, -1, 0) == 6) {
			return true;
		} else if (countStone(dol, 0, 1) + countStone(dol, 0, -1) == 6) {
			return true;
		} else if (countStone(dol, 1, 1) + countStone(dol, -1, -1) == 6) {
			return true;
		} else if (countStone(dol, 1, -1) + countStone(dol, -1, 1) == 6) {
			return true;
		}
		return false;
	} // 가로, 세로, 대각선까지 모두 고려하여 연속 5개가 같은 색일 경우 그 승패를 넘겨준다.

	int countStone(Dol dol, int dx, int dy) {
		int i = dol.x; 
		int j = dol.y; 
		boolean color = dol.isBlack; // x,y의 좌표와 놓을 바둑돌의 색을 가져온다.

		int count = 0;

		while ((i >= 0 && i <= NewGame.LINE_NUM - 1)
				&& (j >= 0 && j <= NewGame.LINE_NUM - 1)) {

			
			if (dolArr[i][j].isBlack == color && dolArr[i][j].isPlace == true)
				count++; // 연속된 x,y 좌표에 대하여 같은 색이 몇개인지 센다.
			else
				break; 
			i += dx;
			j += dy;
		}
		return count; //그리고 몇개의 색이 같은지 넘겨준다.
	}

	public Stack<Dol> getBack() {
		return back;
	} //다시 돌아가는 메소드(전 단계로)

	public Dol getLastDol() {
		return lastDol;
	} // 전단계의 좌표를 가져오는 메소드

	@Override
	 protected void onResume(){
		 super.onResume();
		 Music.play(this,R.raw.game);
	 } // 게임 실행시 음악 재생
	
	 @Override
	 protected void onPause(){
		 super.onPause();
		 Music.stop(this);
	 } // 게임이 멈추면 음악 멈춤.

}

```

OmokView.java 이는 게임 화면 구현에 관한 것이다.
```
package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class OmokView extends View {
	private Context context;
	private int LINE_WIDTH = 0;
	private int STONE_SIZE = 0;
	private int X0;
	private int Y0;
	private NewGame newGame = null;

	public void init() {
		Display display = ((WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		int width = display.getWidth();

		LINE_WIDTH = width / NewGame.LINE_NUM;
		STONE_SIZE = (int) (LINE_WIDTH * 0.8);

	} // 이는 화면의 너비를 구하여 그를 그려줄 줄 수로 나눠서 한 칸의 간격을 정하고, 놓을 바둑돌의 크기도 정하는 것이다.

	public OmokView(Context context) {
		super(context);
		this.context = context;
		newGame = (NewGame) context;
		init();
	} // 새로운 게임을 시작할 때 마다 init메소드를 실행시킨다.

	public void onDraw(Canvas canvas) {
		X0 = getWidth() / 2 - NewGame.LINE_NUM / 2 * LINE_WIDTH; //(0,0)의 x좌표

		Y0 = getWidth() / 2 - NewGame.LINE_NUM / 2 * LINE_WIDTH; //(0,0)의 y좌표

		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.puzzle_background)); // 배경색을 칠한다.

		canvas.drawRect(0, 0, getWidth(), getHeight(), background);

		for (int i = 0; i < 9; i++) {
			canvas.drawLine(X0, i * LINE_WIDTH + Y0, (NewGame.LINE_NUM - 1)
					* LINE_WIDTH + X0, i * LINE_WIDTH + Y0, new Paint());
			canvas.drawLine(i * LINE_WIDTH + X0, Y0, i * LINE_WIDTH + X0,
					(NewGame.LINE_NUM - 1) * LINE_WIDTH + Y0, new Paint());
		} // 바둑판을 그린다.

		Paint selected = new Paint();

		for (int i = 0; i < ((NewGame) context).getBack().size(); i++) {
			if (newGame.getBack().get(i).isBlack == true)
				selected.setColor(Color.BLACK);

			else
				selected.setColor(Color.WHITE); // 검은색차례가 맞으면 검은색을 그리고, 아니면 흰색으로 설정

			canvas.drawCircle(newGame.getBack().get(i).x * LINE_WIDTH + X0,
					newGame.getBack().get(i).y * LINE_WIDTH + Y0,
					STONE_SIZE / 2, selected); // 선택된 좌표에 바둑돌을 그린다.

		}
		selected.setColor(Color.RED);

		if (!newGame.getBack().isEmpty())
			canvas.drawCircle(newGame.getLastDol().x * LINE_WIDTH + X0,
					newGame.getLastDol().y * LINE_WIDTH + Y0, 5, selected);
	}

	public boolean onTouchEvent(MotionEvent e) {
		int x = (int) e.getX(); // 화면을 터치했을 때 터치한 점의 x좌표를 가져온다.
		int y = (int) e.getY(); // 화면을 터치했을 때 터치한 점의 y좌표를 가져온다.

		if (x < X0 - LINE_WIDTH / 2
				|| x > X0 + (NewGame.LINE_NUM - 1) * LINE_WIDTH + LINE_WIDTH
						/ 2)
			return false; 
		if (y < Y0 - LINE_WIDTH / 2
				|| y > Y0 + (NewGame.LINE_NUM - 1) * LINE_WIDTH + LINE_WIDTH
						/ 2)
			return false; // 그린 바둑판의 밖을 터치했을 경우 false를 넘겨준다.

		x = (x - X0 + LINE_WIDTH / 2) / LINE_WIDTH * LINE_WIDTH + X0;
		y = (y - Y0 + LINE_WIDTH / 2) / LINE_WIDTH * LINE_WIDTH + Y0;

		int ArrX = (x - X0) / LINE_WIDTH;
		int ArrY = (y - Y0) / LINE_WIDTH; // 배열로 표현하기 위해 화면의 좌표값을 바둑판의 좌표값으로 바꾼다.

		if (!newGame.dolArr[ArrX][ArrY].isPlace) {
			invalidate();

			newGame.dolArr[ArrX][ArrY].x = ArrX;
			newGame.dolArr[ArrX][ArrY].y = ArrY;

			if (((NewGame) context).tThread.isBlack())
				newGame.dolArr[ArrX][ArrY].isBlack = true;

			else
				((NewGame) context).dolArr[ArrX][ArrY].isBlack = false; // 화면에 그릴 바둑돌의 색이 검은색차례인지 아닌지 넘겨준다.

			((NewGame) context).tThread.turnChange(); // 색을 바꾼다.
			((NewGame) context).tThread.initSecond(); // 다음 차례를 위해 시간도 다시 세팅한다.

			newGame.dolArr[ArrX][ArrY].isPlace = true; // 놓은 자리에 바둑돌이 놓였다고 표시한다.

			newGame.putDol(newGame.dolArr[ArrX][ArrY]);

			newGame.getLastDol().x = ArrX;
			newGame.getLastDol().y = ArrY; // 가장 최근에 놓았던 자리의 좌표를 저장한다(Undo버튼 이용하기 위해)

			boolean isVictory = newGame
					.checkVictory(newGame.dolArr[ArrX][ArrY]); // 이겼으면 어느 색이 이겼는지 넘긴다.

			if (isVictory) {
				((NewGame) context).showDialog(1);
			}

			invalidate();

		}
		return super.onTouchEvent(e);
	}

} // 이 클래스는 게임 화면을 그려주는 클래스이다.

```


TurnThread.java 여기서는 바둑돌 색을 바꿔준다.

```
package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Toast;

public class TurnThread extends Thread {

	boolean isBlackTurn = true; // 기준을 검정색으로 잡는다.
	private final int INIT_SECOND = 10; // 10초 안에 수를 놓도록 한다.
	private int second; 
	Context context;
	private boolean interruption = false; 

	public TurnThread(Context context) {
		this.context = context;
	}

	boolean isBlack() { 
		return isBlackTurn;
	} // 검정색 차례이면 검정색차례라고 넘겨준다.

	void initSecond() { 
		second = INIT_SECOND;
	}

	void turnChange() {
		isBlackTurn = !isBlackTurn;
	} //검정색을 놓아서 흰색차례라면 검정색 차례가 아니라고 넘겨준다. 

	public void run() {
		while (!interruption) {
			((Activity) context).runOnUiThread(new Runnable() {
				@Override
				public void run() {
					try {
						if (second == 0) 
						{
							turnChange(); 
							initSecond(); 

							Toast.makeText(context,
									isBlackTurn ? "Black Turn" : "White Turn",
									Toast.LENGTH_SHORT).show();

						} else {
							second--; 
						} // 정해진 시간(10초)안에 바둑돌을 놓도록 하는데, 10초가 지났을 경우 다른 색 차례라는 메세지를 띄운다.

					} catch (NullPointerException e) {
					}
				}
			});

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopThread() {
		interruption = true;
	} // 오류가나면 멈춘다.

	public void restartThread() {
		interruption = false;
	} // 아니면 다시 시작한다.
	
} // 이 클래스는 자동으로 바둑돌의 색을 바꿔주는 것이다. 흑색다음은 백색차례이므로 그를 바꿔 줄 필요가 있기 때문이다.
```

Dol.java 여기서는 바둑판 위에서 찍은 점의 좌표를 구해준다.

```
package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

class Dol {

	int x;
	int y;
	boolean isBlack; 
	boolean isPlace; 

	Dol() 
	{
		this.x = 0;
		this.y = 0;
	}

	Dol(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
} // 이 클래스는 찍은 점의 좌표를 구해주는 클래스이다. 

```

Music.java 마지막으로, 여기서는 게임실행할 때 자동으로 배경음악을 재생해 준다.

```
package com.example.game;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Music {
	private static MediaPlayer mp = null;
	
	public static void play(Context context, int resource){
		stop(context);
		
		mp = MediaPlayer.create(context, resource);
		mp.setLooping(true);
		mp.start();
	}
	
	public static void stop(Context context) {
		if(mp!=null){
			mp.stop();
			mp.release();
			mp = null;
		}
	}
	
} // 이 클래스는 앱을 실행하였을때 설정된 음악을 재생해주는 클래스이다.
```

activity\_main.xml
```

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <Button
        android:id="@+id/Button_exit"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentLeft="true"
        android:layout_marginBottom="22dp"
        android:text="Exit" />

    <Button
        android:id="@+id/Button_newgame"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_above="@+id/Button_exit"
        android:layout_alignLeft="@+id/Button_exit"
        android:layout_marginBottom="19dp"
        android:text="NewGame" />

</RelativeLayout>

```


newgame.xml

```
<?xml version="1.0" encoding="utf-8"?>

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	android:layout_width="fill_parent" 
	android:layout_height="fill_parent"
	android:orientation="vertical"
	android:background="@color/puzzle_background"
	>
	<LinearLayout 
		android:id="@+id/LinearLayout01"
		android:layout_width="fill_parent" 
		android:layout_height="0dp" 
		android:layout_weight="8"
		android:orientation="horizontal"
		/>
	<LinearLayout 
		android:layout_width="fill_parent" 
		android:layout_height="0dp"
		android:orientation="horizontal"
		android:layout_weight="2" 
	>
		<Button 
			android:id="@+id/btnFirst" 
			android:layout_width="0dp"
			android:layout_height="fill_parent" 
			android:text="MoveFirst" 
			android:textSize="10sp"
			android:layout_weight="1"
			/>
		<Button 
			android:id="@+id/btnUndo" 
			android:layout_width="0dp"
			android:layout_height="fill_parent" 
			android:text="Undo" 
			android:textSize="10sp"
			android:layout_weight="1"
			/>
		<Button 
			android:id="@+id/btnRedo" 
			android:layout_width="0dp"
			android:layout_height="fill_parent" 
			android:text="Redo" 
			android:textSize="10sp"
			android:layout_weight="1"
			/>
		<Button 
			android:id="@+id/btnLast" 
			android:layout_width="0dp"
			android:layout_height="fill_parent" 
			android:text="MoveLast" 
			android:textSize="10sp"
			android:layout_weight="1"
			/>
	</LinearLayout>
	<LinearLayout 
		android:layout_width="fill_parent" 
		android:layout_height="0dp"
		android:orientation="horizontal"
		android:layout_weight="2" 
	>
		<Button 
			android:id="@+id/btnNewGame" 
			android:layout_width="0dp"
			android:layout_height="fill_parent" 
			android:text="NewGame" 
			android:textSize="10sp"
			android:layout_weight="1"
			/>
		<Button 
			android:id="@+id/btnExit" 
			android:layout_width="0dp"
			android:layout_height="fill_parent" 
			android:text="Exit" 
			android:textSize="10sp"
			android:layout_weight="1"
			/>
	</LinearLayout>
</LinearLayout>
```
참고
-만들면서 배우는 Android Game Programming<한빛미디어>-황동윤지음 에서 가장 많이 참고하였고,


오목게임에 대한 전체적인 아이디어는

-http://blog.naver.com/rkddusgns?Redirect=Log&logNo=172773988

-http://blog.naver.com/PostView.nhn?blogId=hataekyong&logNo=10067068403


에서 참고하였고,

오목게임 화면 구현 아이디어는

-http://blog.naver.com/PostView.nhn?blogId=ehdcks2491&logNo=100065005653

에서 참고하였다.