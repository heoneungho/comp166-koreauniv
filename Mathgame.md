# Introduction #

![http://comp166-koreauniv.googlecode.com/files/wikiimg.jpg](http://comp166-koreauniv.googlecode.com/files/wikiimg.jpg)

렉 걸리고 어려운 게임은 그만! Simple is the best에 입각하여 말그대로 심플한 게임을 소개합니다.


# Details #

1. 누가누가 더 많이 맞추나~제한시간 설정 가능

2. 난이도 조절 가능~누구나 할 수 있는 게임

3. 문제가 넘어갈 때 마다 정답 여부 확인창을 띄어주어 긴장감 조성

4. 게임이 끝나면 채점 결과 확인 가능


# 자바 파일 #

![http://comp166-koreauniv.googlecode.com/files/jfjf.jpg](http://comp166-koreauniv.googlecode.com/files/jfjf.jpg)

크게 게임 설정 화면(1)과 플레이 화면(2), 그리고 결과 화면(3)으로 이루어져 있습니다.

1. MainActivity.Java

```
package comp.fin.comedu16;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import comp.fin.comedu16.constants.Constants;
import comp.fin.comedu16.listener.SeekBarListener;

public class MainActivity extends Activity {
	
	MediaPlayer mp;
	
	private int gameTime;
	private SeekBarListener seekBarListener;
	private int gameLevel = 2;		// 1:Easy, 2:Normal, 3:Hard 로 일단 2의 값을 주었습니다.

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mp = MediaPlayer.create(getApplicationContext(), R.raw.bgm);
		mp.setLooping(true);
		mp.start();
		
		SeekBar  timeSeekBar = (SeekBar)  findViewById(R.id.seekBar);			// 게임 시간을 설정하는 SeekBar
		TextView selectTime  = (TextView) findViewById(R.id.selectTime);		// 설정된 시간을 보여주는 TextView
		
		seekBarListener = new SeekBarListener(timeSeekBar, selectTime);			// SeekBar Listener 등록
		
	}
	
	public void mOnClick(View v) throws InterruptedException		// Start Button이 눌렸을 때
	{
		gameTime  = seekBarListener.getProgressVal();		// 게임 play 시간
		System.out.println("게임시작(Play 시간 : " + gameTime + ", Level : " + gameLevel + ")");		// 게임 start 버튼이 눌렸을 때 호출
		
		// Intent Class 이용해서 게임 화면 Activity로 이동
		Intent intent = new Intent(this, GameStartActivity.class);
		intent.putExtra(Constants.GAMETIME, gameTime);
		intent.putExtra(Constants.GAMELEVEL, gameLevel);
		startActivity(intent);
	}
	
	public void rOnSelect(View v)		// 난이도를 정하는 Radio Button
	{
		if(v.getId() == R.id.radioBtn1){
			gameLevel = 1;		// Easy
		} else if(v.getId() == R.id.radioBtn2) {
			gameLevel = 2;		// Normal
		} else if(v.getId() == R.id.radioBtn3) {
			gameLevel = 3;		// Hard
		}
	}
}
```

2. GameStartActivity.Java

```
package comp.fin.comedu16;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import comp.fin.comedu16.constants.Constants;
import comp.fin.comedu16.game.GameGenerator;

@SuppressLint("HandlerLeak")
public class GameStartActivity extends Activity
{	
	private int gameTime;
	private int gameLevel;
	private int rightCount = 0;
	private int wrongCount = 0;
	
	private long realAnswer;
	
	private TextView remainTimeView;
	private TextView gameEquation;
	private TextView answerView;
	
	private Toast toast;
	
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		Intent intent = getIntent();
		gameTime = intent.getExtras().getInt(Constants.GAMETIME);
		gameLevel = intent.getExtras().getInt(Constants.GAMELEVEL);
		
		System.out.println("gameTime : " + gameTime);		// MainActivity에서 받아온 게임 시간
		System.out.println("gameLevel : " + gameLevel);		// MainActivity에서 받아온 게임 레벨
	
		remainTimeView = (TextView) findViewById(R.id.gameTime);		// 게임의 남은 시간 보여주는 TextView
		gameEquation = (TextView) findViewById(R.id.gameEquation);		// 게임 식
		answerView = (TextView) findViewById(R.id.answerView);			// 답 입력
		
		remainTimeView.setTextColor(Color.RED);
		answerView.setText(Constants.ANSWER);
		answerView.setBackgroundColor(color.holo_blue_bright);
		
		generate();		// 문제 생성 및 화면에 출력
		
		new Counter().start();						// 카운터 시작
		System.out.println(Constants.COUNTSTART);
	}
    private void generate() 
    {
		GameGenerator gg = new GameGenerator(gameLevel);
		
		gg.gameProblems();							// 문제 생성
		gameEquation.setText(gg.getEquation());		// 생성한 문제 화면에 Set
		realAnswer = gg.getAnswer();					// 생성한 문제의 답
	}
	class Counter extends Thread 
    {
        @Override
        public void run()		// 핸들러로 카운터를 보낸다.
        { 
            while(true) {
            	mHandler.sendEmptyMessage(gameTime);
            	System.out.println("" + gameTime);
                gameTime--;		// 1초 마다 1씩 작아진다.
                if ( gameTime == -1) 
                    break;
                SystemClock.sleep(1000L);
            }
        }
    }
    
	private final Handler mHandler = new Handler() 		 //핸들러를 통해 UI스레드에 접근한다.
    {
        public void handleMessage(Message msg) 
        {
            super.handleMessage(msg);
            System.out.println(Constants.CALLHANDLER);
            remainTimeView.setText(msg.what + "");
            if(msg.what == 0) 
            {
            	remainTimeView.setText("Game Over!!!");
            	// 게임 시간이 끝나면 결과 화면으로 이동
        		intent = new Intent(getApplicationContext(), ResultActivity.class);
        		intent.putExtra(Constants.RIGHT, rightCount);		// 맞은 개수
        		intent.putExtra(Constants.WRONG, wrongCount);		// 틀린 개수
        		startActivity(intent);								// 결과 화면으로 이동
            }
        }
    };
    
	public void mOnClick(View v) {
		if( answerView.getText().toString().equals(Constants.ANSWER) )
		{
			answerView.setText("");		// 값을 최초로 입력하면 TextView에 입력된 글자를 없앤다
		}
		switch(v.getId()){
		case R.string.btn0:
			answerView.append(Constants.btn0);
			break;
		case R.string.btn1:
			answerView.append(Constants.btn1);
			break;
		case R.string.btn2:
			answerView.append(Constants.btn2);
			break;
		case R.string.btn3:
			answerView.append(Constants.btn3);
			break;
		case R.string.btn4:
			answerView.append(Constants.btn4);
			break;
		case R.string.btn5:
			answerView.append(Constants.btn5);
			break;
		case R.string.btn6:
			answerView.append(Constants.btn6);
			break;
		case R.string.btn7:
			answerView.append(Constants.btn7);
			break;
		case R.string.btn8:
			answerView.append(Constants.btn8);
			break;
		case R.string.btn9:
			answerView.append(Constants.btn9);
			break;
		case R.string.restart:
			intent = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			break;
		case R.string.del:
			String beforeDelStr = answerView.getText().toString();
			if(beforeDelStr.equals(Constants.BLANK)) break;
			int answerLen = beforeDelStr.length();
			String afterDelStr = beforeDelStr.substring(0, (answerLen-1));
			answerView.setText(afterDelStr);
			break;
		case R.string.enter:
			long chkAns;
			try 
			{
				chkAns = Integer.parseInt(answerView.getText().toString());
			} 
			catch(Exception e)
			{
				// String 값으로 답을 입력한 경우
				toast = Toast.makeText(getApplicationContext(), Constants.NORESULT, Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.RIGHT, 0, 0);
				toast.show();
				break;		
			}
			if(chkAns == realAnswer)				// 정답이면
			{
				rightCount++;						// 맞은 개수 1 증가
				dispResult(Constants.RIGHT);		// 결과 Toast
			} else {								// 오답이면
				wrongCount++;						// 틀린 개수 1 증가
				dispResult(Constants.WRONG);		// 결과 Toast
			}
			break;
		}
	}
	private void dispResult(String result) 
	{
		toast = Toast.makeText(getApplication(), result, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.RIGHT, 0, 0);
		toast.show();
		answerView.setText(Constants.BLANK);
		generate();			// 새로운 문제 생성	
	}
}
```

3. ResultActivity.Java

```
package comp.fin.comedu16;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import comp.fin.comedu16.constants.Constants;

public class ResultActivity extends Activity
{	
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		TextView rightCountView = (TextView) findViewById(R.id.Right);
		TextView wrongCountView = (TextView) findViewById(R.id.wrong);
		
		intent = getIntent();
		
		int rightCount = intent.getExtras().getInt(Constants.RIGHT);		// 맞은 개수
		int wrongCount = intent.getExtras().getInt(Constants.WRONG);		// 틀린 개수
		
		rightCountView.setText("맞은 개수 : " + rightCount);
		wrongCountView.setText("틀린 개수 : " + wrongCount);
	}
	
	public void mOnClick(View v) {
		switch(v.getId()){
	
		case R.string.restart:
			intent = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			break;
		}
	}
}
```

4. Constants.java

```
package comp.fin.comedu16.constants;

public class Constants 
{
	public static final String GAMETIME = "GAMETIME";
	public static final String GAMELEVEL = "GAMELEVEL";
	public static final String RIGHT = "딩동댕!! 정답! 정답!";
	public static final String WRONG = "땡!!! 틀렸습니다.";
	public static final String BLANK = "";
	public static final String NORESULT = "값을 입력하세요!";
	public static final String COUNTSTART = "카운터 시작...";
	public static final String CALLHANDLER = "Handler 호출";
	public static String ANSWER = "답 입력!";
	public static String btn0 = "0";
	public static String btn1 = "1";
	public static String btn2 = "2";
	public static String btn3 = "3";
	public static String btn4 = "4";
	public static String btn5 = "5";
	public static String btn6 = "6";
	public static String btn7 = "7";
	public static String btn8 = "8";
	public static String btn9 = "9";
	
}
```

5. GameGenerator.java

문제를 냅니다.

```
package comp.fin.comedu16.game;

import java.util.Random;

public class GameGenerator 
{
	public int gameLevel;		// Game 난이도
	public int num1;
	public int num2;
	public int answer;
	
	public String operator;		// 연산자(0:+, 1:-, 2:*)
	public String equation;		// 문제로 낼 수학 식
	
	
	public Random ran;			// 계산할 숫자와 연산자를 생성할 Random Class
	
	public GameGenerator(int gameLevel)
	{
		this.gameLevel = gameLevel;
	}
	
	public void gameLevel(int gameLevel){}		// 1:Easy, 2:Normal, 3:Hard (게임 난이도 Default 는 Normal) 
	
	public void setGameTitle(){}				// 레벨에 따른 Title 
	
	public void gameProblems() 					// 레벨에 따른 문제 생성
	{
		ran = new Random();			// Level에 따른 난수 크기 조절
		num1 = ran.nextInt(pow(10, gameLevel));
		num2 = ran.nextInt(pow(10, gameLevel));
		int operInt = (ran.nextInt(10) % 2);
		
		solveProbles(num1, num2, operInt);
	
		operator = determinOper(operInt);	// 연산자 결정
		if(num1 > num2)
		{
			equation = num1 + " " + operator + " " + num2 + " = ";		// 화면에 띄울 식
		}
		else 
		{
			equation = num2 + " " + operator + " " + num1 + " = ";		
		}
	}
	public String getEquation()
	{
		return equation;		// 문제로 낼 식 
	}
	
	public int getAnswer()
	{
		return answer;			// 문제의 답
	}
	
	private void solveProbles(int num1, int num2, int operator) 
	{
		switch (operator) {
		case 0 : answer = num1 + num2;
			break;
		case 1 : 
			// 큰 수에서 작은 수를 빼게합니다.
			if(num1 > num2)
			{
				answer = num1 - num2;
			} else 
			{
				answer = num2 - num1;
			}
			break;
		case 2 : answer = num1 * num2;
			break;
		}
	}

	private String determinOper(int oper)			// int형의 값을 비교해 String형의 연산자로 변환합니다.
	{
		String retStr = null;
		switch (oper) 
		{
			case 0 : retStr = "+";
			break;
			case 1 : retStr = "-";
			break;
			case 2 : retStr = "*";
			break;
		}
		return retStr;
	}

	public int pow(int lowerNum, int upperNum)			// Easy : 한자리수, Normal : 한 자리수, 두자리수, Hard : 한자리수, 두자리수, 세자리수 계산
	{
		int retVal = 1;
		for (int i = 0; i < upperNum; i++) 
		{
			retVal *= lowerNum;
		}
		return retVal;
	}
}
```

6. seekbarlistener.java

게임 시간을 설정합니다.

```
package comp.fin.comedu16.listener;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarListener 
{
	private int progressVal = 90; 		// 초기값은 90초
	
	public int getProgressVal()		// 게임 시간 Getter 
	{
		return progressVal;
	}

	public SeekBarListener(SeekBar timeSeekBar, final TextView selectTime) 
	{
		timeSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			@Override
			// SeekBar에서 Touch 떼었을 때 호출
			public void onStopTrackingTouch(SeekBar seekBar) {}
			
			@Override
			// SeekBar에서 Touch 했을 때 호출
			public void onStartTrackingTouch(SeekBar seekBar) {}
			
			@Override
			// SeekBar 의 값이 바뀔 때마다 호출
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
			{
				selectTime.setText("" + progress);
				progressVal = progress;		// 게임 시간
			}
		});
	}
}
```


# 레이아웃 #

인터페이스를 꾸미는 데 편리한 relative layout을 이용했습니다.


# 실행 화면 #

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-41-36.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-41-36.png)

시작화면입니다.

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-41-47.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-41-47.png)

easy 난이도는 한자리 숫자의 계산입니다.

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-41-57.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-41-57.png)

normal 난이도는 두자리 숫자의 계산입니다.

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-05.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-05.png)

hard 난이도는 세자리 숫자의 계산입니다.

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-16.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-16.png)

정답 여부는 토스트를 띄워 알려줍니다.(오답)

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-28.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-28.png)

정답 여부는 토스트를 띄워 알려줍니다.(정답)

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-45.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-42-45.png)

제한 시간이 끝나면 결과를 알려줍니다.

<<apk 파일 다운>>

http://comp166-koreauniv.googlecode.com/files/origin.rar

<<출처>>

배경음악 넣기

http://blog.naver.com/kalsnim1?Redirect=Log&logNo=90155484278

기본 아이디어(계산기)

http://blog.naver.com/rudwnflwkd?Redirect=Log&logNo=40188147643

seekbarlistener

http://mainia.tistory.com/713