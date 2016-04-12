# Introduction #
벽돌깨기 게임

양옆으로 드래그할 수 있는 패널을 가지고 사방팔방튀는
공을 패널에 반사시킴으로써 쌓여진 벽돌을 전부 없애는
간단한 국민게임이다.

벽돌이 바닥에 떨어질때마다 5개의 life중에 하나씩 줄며
5개의 life를 전부소모햇으면 Game Over


# Details #

## UI ##


메인화면은 다음과 같다.


실제 게임을 실행하는 화면은 다음과 같다

## 메인화면 ##
![https://comp166-koreauniv.googlecode.com/files/BrixBreak1.jpg](https://comp166-koreauniv.googlecode.com/files/BrixBreak1.jpg)


## 스테이지 0 ##
![https://comp166-koreauniv.googlecode.com/files/BrixBreak2.jpg](https://comp166-koreauniv.googlecode.com/files/BrixBreak2.jpg)

## 스테이지 1 ##
![https://comp166-koreauniv.googlecode.com/files/BrixBreak3.jpg](https://comp166-koreauniv.googlecode.com/files/BrixBreak3.jpg)

## 스테이지 2 ##
![https://comp166-koreauniv.googlecode.com/files/BrixBreak4.jpg](https://comp166-koreauniv.googlecode.com/files/BrixBreak4.jpg)

## 스테이지 3 ##
![https://comp166-koreauniv.googlecode.com/files/BrixBreak5.jpg](https://comp166-koreauniv.googlecode.com/files/BrixBreak5.jpg)


## About ##
![https://comp166-koreauniv.googlecode.com/files/BrixBreak6.jpg](https://comp166-koreauniv.googlecode.com/files/BrixBreak6.jpg)



---


# Source Code #

이 게임은 Surface View를 이용해 만들었습니다.
View는 GDI 쓰레드를 통해 Surface에 그려지게 되는데
View에 동영상이나 카메라 프리뷰처럼 그려지는 양이 매우 많거나
빠른 화면 변화가 있다면 Surface View를 사용해야 합니다.

SurfaceView의 내용은 GDI 쓰레드를 통해서 Surface에 그려지지 않고
다른 쓰레드를 이용해서 그려집니다. View와 Window의 아래쪽에 위치합니다.

이 SurfaceView의 장점은 View의 일부분으로 UI의 View와 함께 사용될 수도 있고
움직이는 부분(애니메이션처리)에 대한 고속처리가 가능하다는 것입니다.

이런 고속처리 작업을 하는 함수는 SurfaceHolder라고 하는 콜백함수 입니다.
콜백함수는 작성만 해놓으면 os에서 알아서 호출하기 때문에 이곳에서 그리기,
터치햇을때의 이벤트 핸들러 등을 처리할 수 있습니다.

또, 게임을 구성하는 클래스는 크게 5가지 입니다.

일단 하나하나씩 소스코드를 올려보겠습니다.

# MainActivity.java #
```

package com.brixbreak3;

import com.brixbreak3.*;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	// MyGameView를 변수로 만든다
	MyGameView mGameView; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
    	mGameView = (MyGameView) findViewById(R.id.mGameView); 
    }
    
    @Override
    protected void onPause() {
        super.onPause();
    	mGameView.PauseGame();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
    	mGameView.ResumeGame();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
    	mGameView.PauseGame();
    }
    
	//-------------------------------------
	//  Option Menu
	//-------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 0, "게임종료");
		menu.add(0, 2, 0, "일시정지");
		menu.add(0, 3, 0, "계속진행");
		menu.add(0, 4, 0, "게임초기화");
		return true;
	}

	//-------------------------------------
	//  onOptions ItemSelected
	//-------------------------------------
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        case 1:    // 종료
        	mGameView.StopGame();
        	finish();
             break;
        case 2:    // 일시 정지
        	mGameView.PauseGame();
             break;
        case 3:    // 계속 진행
        	mGameView.ResumeGame();
            break;
        case 4:    // 게임 재시작
        	mGameView.RestartGame();
        }
        return true;
	}
	
	
	OnClickListener ButtonClick = new Button.OnClickListener() {
		public void onClick(View view) {
			finish();
		}
	};

}

```

# StartGame.java #
```

package com.brixbreak3;


import com.brixbreak3.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class StartGame extends Activity  {
	
	MediaPlayer mPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_game);
		
        mPlayer = MediaPlayer.create(this, R.raw.rondo);   	
  	  	mPlayer.setVolume(0.7f, 0.7f); 			      		
  	  	mPlayer.setLooping(true);              				
 	  	mPlayer.start();
		
		findViewById(R.id.imageView1).setOnClickListener(ButtonClick);
        findViewById(R.id.imageView2).setOnClickListener(ButtonClick);
        findViewById(R.id.imageView3).setOnClickListener(ButtonClick);
	}

	Button.OnClickListener ButtonClick = new Button.OnClickListener() {
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.imageView1: // New Game
				startActivity(new Intent(StartGame.this, MainActivity.class));
				mPlayer.stop();
				break;
	
			case R.id.imageView2: // About
				startActivity(new Intent(StartGame.this, About.class));
				mPlayer.stop();
				break;
				
				
			case R.id.imageView3: // Quit	
				mPlayer.stop();
				finish();
			}
		}
    };
    
}

```


# MyGameView.java #
```

package com.brixbreak3;

import java.util.*;

import com.brixbreak3.R;

import android.content.*;
import android.graphics.*;
import android.util.*;
import android.view.*;
import android.view.SurfaceHolder.Callback;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
public class MyGameView extends SurfaceView implements Callback {
	GameThread 	  mThread;
	SurfaceHolder mHolder;
	Context 	  mContext;

	final int LEFT = 1;
	final int RIGHT = 2;
	final int STOP = 3;
	
	static int B_width;		// 블록의 폭
	static int B_height;	// 블록의 높이
	static int M_left;		// 좌측 여백
	static int M_top;		// 상단 여백
	
	//메인 메뉴용 변수
	static boolean isMusic = true;
	static boolean isSound = true;
	
	//효과음
	static SoundPool sdPool;
	static int sdBreak;
	static MediaPlayer player;
	
	
	
	//-------------------------------------
	//  생성자
	//-------------------------------------
	public MyGameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
		mHolder = holder;		// holder와 Context 보존
		mContext = context;
		mThread = new GameThread(holder, context);
		
		setFocusable(true);
	}

	//-------------------------------------
    //  SurfaceView가 생성될 때 실행되는 부분
    //-------------------------------------
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mThread.start();
	}

	//-------------------------------------
    //  SurfaceView가 바뀔 때 실행되는 부분
    //-------------------------------------
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int format, int width, int height) {

	}

	//-------------------------------------
    //  SurfaceView가 해제될 때 실행되는 부분
    //-------------------------------------
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean done = true;
	    while (done) {
	    	try {
	    		mThread.join();        			// 스레드가 현재 step을 끝낼 때 까지 대기
	    		done = false;
	 		} catch (InterruptedException e) {  // 인터럽트 신호가 오면?   
	 			// 그 신호 무시 - 아무것도 않음
	 		} 
	    } // while
	}
	
	//-------------------------------------
	//  스레드 완전 정지
	//-------------------------------------
	public void StopGame() {
		mThread.StopThread(); 
	}

	//-------------------------------------
	//  스레드 일시 정지
	//-------------------------------------
	public void PauseGame() {
		mThread.PauseNResume(true); 
	}

	//-------------------------------------
	//  스레드 재기동
	//-------------------------------------
	public void ResumeGame() {
		mThread.PauseNResume(false); 
	}

	//-------------------------------------
	//  게임 초기화
	//-------------------------------------
	public void RestartGame() {
		mThread.StopThread();		// 스레드 중지

		// 현재의 스레드를 비우고 다시 생성
	    mThread = null;	  
		mThread = new GameThread(mHolder, mContext); 
		mThread.start(); 
	}

//----------------------------------------------------------------
	
	//-------------------------------------
	//  GameThread Class
	//-------------------------------------
	class GameThread extends Thread {
		SurfaceHolder mHolder;			// SurfaceHolder를 저장할 변수
		Context mContext;
		boolean canRun = true;			// 스레드 제어용
		boolean isWait = false;
		int width, height;				// 화면의 크기
		
		final int STAGE_COUNTER = 4;	// 전체 스테이지 갯수
		int ballCnt = 4;				// 볼의 갯수(0~5)
		int stgNum = 0;					// 스테이지 번호
		int tot = 0;					// 득점 합계
		int score = 0;					// 격파한 블록 갯수
		int sx[] = {-3, -2, 2, 3};		// 패들에 충돌 후의 볼의 반사 방향을 바꿈
		Random rnd = new Random();		// 위의 처리를 하기 위한 난수
		Paint paint = new Paint();		// 점수 표시용
		Bitmap imgBack;					// 배경
		Bitmap imgSball;				// 남은 공 갯수 표시용
		
		ArrayList<Block> mBlock = new ArrayList<Block>();	// 블록
		ArrayList<SBlock> mSBlock = new ArrayList<SBlock>(); // 이펙트블록
		
		Ball   mBall;		// 볼
		Paddle mPaddle;		// 패들							
		  
		float Stage[][][] = {		// x, y, 블록번호
		{ 	
			           {1, 0, 0}, {2, 0, 0}, {3, 0, 0}, 
			{0, 1, 0}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}, {4, 1, 0},
			{0, 2, 0}, {1, 2, 1}, {2, 2, 2}, {3, 2, 1}, {4, 2, 0},
			{0, 3, 0}, {1, 3, 1}, {2, 3, 2}, {3, 3, 1}, {4, 3, 0},
			{0, 4, 0}, {1, 4, 1}, {2, 4, 1}, {3, 4, 1}, {4, 4, 0},
						{1, 5, 0}, {2, 5, 0}, {3, 5, 0}
		},	
		
		{	{1.5f, 0, 0}, {2.5f, 0, 0}, 
			{1, 1, 0},    {2, 1, 1},    {3, 1, 0},
			{0.5f, 2, 0}, {1.5f, 2, 1}, {2.5f, 2, 1}, {3.5f, 2, 0},
			{0, 3, 0},    {1, 3, 1},    {2, 3, 2},    {3, 3, 1},    {4, 3, 0},
			{0.5f, 4, 0}, {1.5f, 4, 1}, {2.5f, 4, 1}, {3.5f, 4, 0},
			{1, 5, 0},    {2, 5, 1},    {3, 5, 0},
			{1.5f, 6, 0}, {2.5f, 6, 0}  
  		},	

  		{	{-0.5f, 0, 0}, {0.5f, 0, 0}, {1.5f, 0, 0}, {2.5f, 0, 0}, {3.5f, 0, 0}, {4.5f, 0, 0},
  			{-0.5f, 1, 0}, {4.5f, 1, 0},
  			{-0.5f, 2, 0}, {1, 2, 1}, {2, 2, 1}, {3, 2, 1}, {4.5f, 2, 0},
  			{-0.5f, 3, 0}, {1, 3, 1}, {2, 3, 2}, {3, 3, 1}, {4.5f, 3, 0},
  			{-0.5f, 4, 0}, {1, 4, 1}, {2, 4, 1}, {3, 4, 1}, {4.5f, 4, 0},
  			{-0.5f, 5, 0}, {4.5f, 5, 0},
 	  		{-0.5f, 6, 0}, {0.5f, 6, 0}, {1.5f, 6, 0}, {2.5f, 6, 0}, {3.5f, 6, 0}, {4.5f, 6, 0},
  		},
  		
  		{	{-0.5f, 0, 0}, {0.5f, 0, 0}, {1.5f, 0, 0}, {2.5f, 0, 0}, {3.5f, 0, 0}, {4.5f, 0, 0},
			{0, 1, 0},     {1, 1, 1},    {2, 1, 1},    {3, 1, 1},    {4, 1, 0},
			{0.5f, 2, 0}, {1.5f, 2, 1}, {2.5f, 2, 1},  {3.5f, 2, 0},
			{1, 3, 0},    {2, 3, 0},    {3, 3, 0},
			{1.5f, 4, 2}, {2.5f, 4, 2}, 
			{1, 5, 0},    {2, 5, 0},    {3, 5, 0},
			{0.5f, 6, 0}, {1.5f, 6, 1}, {2.5f, 6, 1},  {3.5f, 6, 0},
			{0, 7, 0},     {1, 7, 1},    {2, 7, 1},    {3, 7, 1},    {4, 7, 0},
			{-0.5f, 8, 0}, {0.5f, 8, 0}, {1.5f, 8, 0}, {2.5f, 8, 0}, {3.5f, 8, 0}, {4.5f, 8, 0},
  		}	
		};
			
		//-------------------------------------
		//  생성자 
		//-------------------------------------
		public GameThread(SurfaceHolder holder, Context context) {
			mHolder = holder;					// SurfaceHolder 보존
			mContext = context;
			
			Display display = ((WindowManager) context.getSystemService (Context.WINDOW_SERVICE)).getDefaultDisplay();
			width = display.getWidth();			// View의 가로 폭
			height = display.getHeight() - 50;  // View의 세로 높이

			InitGame();
			MakeStage();
		}
		
		//-------------------------------------
		//  게임 초기화 
		//-------------------------------------
		public void InitGame() {
			B_width = width / 6;					// 블록의 폭
			B_height = B_width / 2;					// 블록의 폭
			M_left = (width - B_width * 5) / 2;		// 왼쪽 여백
			M_top = B_width * 4 / 5;				// 상단 여백 
			
			
			//효과음
			sdPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
			sdBreak = sdPool.load(mContext, R.raw.pung, 1);
			

			mPaddle = new Paddle(mContext, width / 2, height - B_height, width);
			mBall = new Ball(mContext, width / 2, mPaddle.y - 17, width, height);
			
			paint.setAntiAlias(true);
			paint.setColor(Color.WHITE);
			paint.setTextSize(15);
			
			// 남은 볼 갯수 표시용
			imgSball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
			imgSball = Bitmap.createScaledBitmap(imgSball, 10, 14, false);
		}
		//-------------------------------------
		//  Stage 만들기 
		//-------------------------------------
		public void MakeStage() {
			for (int i = 0; i < Stage[stgNum].length; i++)
				mBlock.add(new Block(mContext, Stage[stgNum][i][0], Stage[stgNum][i][1], Stage[stgNum][i][2]));
			// mSBlock.add(new SBlock(mContext, 0, 0, 0));
			
			ResetPosition();			// 패들과 볼을 화면 중심으로 이동
			mBall.sy = -(12 +  1 * stgNum);	// 스테이지마다 1씩 속도 증가		 
			
			// 배경
			imgBack = BitmapFactory.decodeResource(getResources(), R.drawable.back0 + stgNum);
			imgBack = Bitmap.createScaledBitmap(imgBack, width, height, false);
		}

		//-------------------------------------
		//  공과 패들을 초기 위치로 이동 - 공을 잃은 후 
		//-------------------------------------
		public void ResetPosition() {
			mPaddle.x = width / 2;
			mPaddle.y = height - B_height;
			mPaddle.sx = 0;

			mBall.x = width / 2;
			mBall.y = mPaddle.y - 17;
			mBall.sy = -Math.abs(mBall.sy); 
			mBall.isMove = false;
		}

		//-------------------------------------
		//  패들 이동 - Key Event에서 호출
		//-------------------------------------
		public void MovePaddle(int x) {
			mPaddle.x = x;
				
			
			
			
		}

		//-------------------------------------
		//  패들 크기 조절
		//-------------------------------------
		public void ResizePaddle() {
			
		}
		
		
		//-------------------------------------
		//  Ball 발사  - Key Event에서 호출
		//-------------------------------------
		public void ShootBall() {
			mBall.isMove = true;
		}
		
		//-------------------------------------
		//  Ball과 패들 이동 - run()에서 호출
		//-------------------------------------
		public void MoveBall() {
			mPaddle.Move();
			if (mBall.isMove == false)	// 초기 모드는
				mBall.x = mPaddle.x;	// 패들과 볼이 같이 이동
			if (mBall.Move() == false) {
				ballCnt--;
				if (ballCnt < 0) {		// 볼을 모두 잃으면 게임 오버
					GameOver();
					return;
				}
				ResetPosition();		// 패들, 공 초기 위치로
			}
		}
		//-------------------------------------
		//  충돌 판정 - run()에서 호출 
		//-------------------------------------
		public void CheckCollision() {
			if (mBlock.size() == 0) {			// 이 판을 클리어 했으면
				stgNum++;						// 다음 스테이지로
				if (stgNum >= STAGE_COUNTER)	// 스테이지 끝은 처음 스테이지 
					stgNum = 0;
				MakeStage();					// 새로운 스테이지 만들기
				return;
			}

			// 패들과 충돌
			if (Math.abs(mBall.x - mPaddle.x) <= mPaddle.pw 
					&& mBall.y >= (mPaddle.y - 17) && mBall.y < mPaddle.y) {
				mBall.sx = 3 * sx[rnd.nextInt(4)];		// 난수로 각도 지정
				mBall.sy = -Math.abs(mBall.sy);		// 무조건 반사 
			}
			
			// 블록과 충돌
			for (Block tmp : mBlock) {
				// 충돌 없음
				if (mBall.x + mBall.bw < tmp.x1 || mBall.x - mBall.bw > tmp.x2		 
						|| mBall.y + mBall.bw < tmp.y1 || mBall.y - mBall.bw > tmp.y2) {
					continue;
				}	
				// 양쪽 벽과의 충돌인지 판정
				if (tmp.x1 - mBall.x >= mBall.bw || mBall.x - tmp.x2 >= mBall.bw)
					mBall.sx = - mBall.sx;
				else											// 상하 충돌
					mBall.sy = - mBall.sy;
				tot += tmp.score;								// 득점
				score++;
				mBlock.remove(tmp);								// 블록 제거
				sdPool.play(sdBreak, 1, 1, 0, 0, 1);
				break;
			}
		}

		//-------------------------------------
		//  Canvas에 그리기 - run()에서 호출
		//-------------------------------------
		public void DrawCharacters(Canvas canvas) {
			// 배경
			canvas.drawBitmap(imgBack, 0, 0, null);
			// 남은 공 수
			for (int i = 0; i <= ballCnt; i++) 
				canvas.drawBitmap(imgSball, i * 12 + 5, 25, null); 
			// 블록
			for (Block tmp : mBlock) 
				canvas.drawBitmap(tmp.imgBlk, tmp.x1, tmp.y1, null);
			
			//for(SBlock tmp : mSBlock)
			//	canvas.drawBitmap(tmp.imgBlk, tmp.x1, tmp.y1, null);
			
			// Ball
			canvas.drawBitmap(mBall.imgBall, mBall.x - mBall.bw, mBall.y- mBall.bh, null);
			// Paddle
			canvas.drawBitmap(mPaddle.imgPdl, mPaddle.x - mPaddle.pw , mPaddle.y - mPaddle.ph, null);
			// 점수
			canvas.drawText("Stage" + stgNum, 5, 18, paint);
			canvas.drawText("블록 : " + score, width / 2 - 40, 18, paint);
			canvas.drawText("득점 : " + tot, width - 80, 18, paint);
		}
		
		//-------------------------------------
		//  Game Over
		//-------------------------------------
		private void GameOver() {
			// 게임 오버는 여기에서 처리힌다
			// 아직 게임 오버 없음
			ballCnt = 4;	// 볼의 갯수를 다시 4개로...
		}
		
		//-------------------------------------
		//  스레드 본체
		//-------------------------------------
		public void run() {
			Canvas canvas = null; 					// canvas를 만든다
			while (canRun) {
				canvas = mHolder.lockCanvas();		// canvas를 잠그고 버퍼 할당
				try {
					synchronized (mHolder) {		// 동기화 유지
						MoveBall();					// 볼 이동하고
						CheckCollision();			// 충돌 판정 후
						DrawCharacters(canvas);		// Canvas에 그리기
					}
				} finally {							// 버퍼 작업이 끝나면 
					if (canvas != null)				// 버퍼의 내용을 View에 전송
						mHolder.unlockCanvasAndPost(canvas);
				} // try

				// 스레드 일시 정지 
				synchronized (this) {
            		if (isWait)				// Pause 모드이면
            			try {
            				wait();			// 스레드 대기
            			} catch (Exception e) {
							// nothing
						}
    			} // sync
				
			} // while
		} // run
	
		//-------------------------------------
		//  스레드 완전 정지
		//-------------------------------------
		public void StopThread() {
			canRun = false;
        	synchronized (this) {
        		this.notify();
			}
		}
		
		//-------------------------------------
		//  스레드 일시정지 / 재기동
		//-------------------------------------
		public void PauseNResume(boolean wait) { 
			isWait = wait;
        	synchronized (this) {
        		this.notify();
			}
		}
		
	} // GameThread 끝

	//-------------------------------------
	//  onKeyDown
	//-------------------------------------
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		synchronized (mHolder) {
			if (event.getAction() == KeyEvent.ACTION_DOWN) {
				switch (keyCode) {
				case KeyEvent.KEYCODE_DPAD_LEFT:
					mThread.MovePaddle(LEFT);		// 패들을 왼쪽으로
					break;
				case KeyEvent.KEYCODE_DPAD_RIGHT:
					mThread.MovePaddle(RIGHT);		// 패들을 오른쪽으로
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN:
					mThread.MovePaddle(STOP);		// 패들 정지
					break;
				case KeyEvent.KEYCODE_DPAD_UP:		// 볼 발사
					mThread.ShootBall();
				}
			}		
			return super.onKeyDown(keyCode, event);
		} // sync
	} // onKeyDown 
// SurfaceView 


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_MOVE){
			
			
			int x = (int) event.getX();
			mThread.MovePaddle(x);
			
			
			if(mThread.mPaddle.x - mThread.mPaddle.pw < x && x < mThread.mPaddle.x + mThread.mPaddle.pw)
			mThread.ShootBall();
		}
	
			// TODO Auto-generated method stub
		return true;
	}

	
	} // SurfaceView 


		
		

```

# Block.java #

```

package com.brixbreak3;

import com.brixbreak3.R;

import android.content.*;
import android.graphics.*;

//-----------------------------
// Block 
//-----------------------------
class Block {
	public int x1, y1, x2, y2, score;	// 블록 좌표, 점수
	public Bitmap imgBlk;				// 이미지
	
	//-----------------------------
	// 생성자 (Constructor) 
	//-----------------------------
	public Block(Context context, float x, float y, float num) {
		x1 = (int) (MyGameView.M_left + x * MyGameView.B_width);
		y1 = (int) (MyGameView.M_top + y * MyGameView.B_height);

		x2 = x1 + MyGameView.B_width - 3;
		y2 = y1 + MyGameView.B_height - 3;
		score = (int) (num + 1) * 50;
		imgBlk = BitmapFactory.decodeResource(context.getResources(), R.drawable.k0 + (int) num);
		imgBlk = Bitmap.createScaledBitmap(imgBlk, MyGameView.B_width, MyGameView.B_height, true);
	}
}

//-----------------------------
//	Speceial Block 
//-----------------------------

class SBlock {
	public int x1, y1, x2, y2, score;	// 블록 좌표, 점수
	public Bitmap imgBlk;				// 이미지
	
	//-----------------------------
	// 생성자 (Constructor) 
	//-----------------------------
	public SBlock(Context context, float x, float y, float num) {
		x1 = (int) (MyGameView.M_left + x * MyGameView.B_width);
		y1 = (int) (MyGameView.M_top + y * MyGameView.B_height);

		x2 = x1 + MyGameView.B_width - 3;
		y2 = y1 + MyGameView.B_height - 3;
		score = (int) (num + 1) * 50;
		imgBlk = BitmapFactory.decodeResource(context.getResources(), R.drawable.k0 + (int) num);
		imgBlk = Bitmap.createScaledBitmap(imgBlk, MyGameView.B_width, MyGameView.B_height, true);
	}
}
//-----------------------------------------------------




//-----------------------------
// Ball 
//-----------------------------
class Ball {
	public int x, y, bw, bh;		// 공의 위치, 크기
	public int sx, sy;				// 공의 속도
	public boolean isMove = false;	// 이동중인가
	public Bitmap imgBall;			// 이미지

	private int width, height;
	
	//-----------------------------
	// 생성자 (Constructor) 
	//-----------------------------
	public Ball(Context context, int _x, int _y, int _width, int _height) {
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		sx = 9;			// 초기 속도
		sy = -12;
		imgBall = BitmapFactory.decodeResource(context.getResources(), R.drawable.ball);
		bw = imgBall.getWidth() / 2;
		bh = bw;
	}
	
	//-----------------------------
	// Move 
	//-----------------------------
	public boolean Move() {
		if (isMove == false) return true;
		x += sx;
		if (x < bw || x > width - bw) {		// 좌우 벽
			sx = -sx;
			x += sx;
		}
		
		y += sy;
		if (y >= height + bh) return false;	// 바닥	
		if (y < bh) {						// 천정
			sy = -sy;				
			y += sy;
		}
		return true;
	}
}

//-----------------------------------------------------

//-----------------------------
// 패들 
//-----------------------------
class Paddle {
	public int x, y, pw, ph;	// 좌표
	public Bitmap imgPdl;		// 이미지
	
	
	
	public int sx; 

	private int width;
	
	//-----------------------------
	// 생성자 (Constructor) 
	//-----------------------------
	public Paddle(Context context, int _x, int _y, int _width) {
		x = _x;			// 패들 현재 좌표
		y = _y;
		width = _width;
		pw = MyGameView.B_width * 4 / 6;	// 패들 폭 - 블록의 4/3크기
		ph = MyGameView.B_width / 6;		// 패들 높이 - 블록 높이 1/3

		imgPdl = BitmapFactory.decodeResource(context.getResources(), R.drawable.paddle);
		imgPdl = Bitmap.createScaledBitmap(imgPdl, pw * 2, ph * 2, true);
		
/*
		imgPdl[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.paddle);
		imgPdl[0] = Bitmap.createScaledBitmap(imgPdl[0], pw , ph * 2, true);
		
		imgPdl[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.paddle);
		imgPdl[1] = Bitmap.createScaledBitmap(imgPdl[1], pw * 2 , ph * 2, true);
		
		imgPdl[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.paddle);
		imgPdl[2] = Bitmap.createScaledBitmap(imgPdl[2], pw * 3, ph * 2, true);
*/
		
	
	}
	
	//-----------------------------
	//  Move 
	//-----------------------------
	public void Move() {
		x += sx;
		if (x < pw || x > width - pw ) sx = 0;
	}
}


```

# About.java #
```
package com.brixbreak3;


import com.brixbreak3.R;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class About extends Activity {
	
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.about);
   
  }

  //------------------------------------
  // Button Click
  //------------------------------------

}
```
