#summary 가장 가까운 숫자를 맞추는 사람이 이기는게임

# Introduction #




# Details #

<a href='http://www.youtube.com/watch?feature=player_embedded&v=YSX1sW-Fdbs' target='_blank'><img src='http://img.youtube.com/vi/YSX1sW-Fdbs/0.jpg' width='425' height=344 /></a>
동영상
http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-19-44-10[1].png/
start버튼을 누르면 게임 메인화면으로 넘어갑니다.
http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-19-44-15[1].png/
플레이어 1부터 5까지 숫자 하나씩을 입력합니다
http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-19-44-28[1].png/
이런식으로
http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-19-44-32[1].png/
정답인 숫자와 가장 가까운 숫자를 선택한 사람이 승리하게 됩니다.


http://comp166-koreauniv.googlecode.com/files/33.PNG/

클래스랑 레이아웃 입니다.


## 클래스 소개 ##

**1.메인 클래스**

```

package com.example.guessinggame_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
		public void onCreate(Bundle saveInstanceState){
			super.onCreate(saveInstanceState);
			setContentView(R.layout.activity_main);
			
			Button button1 = (Button) findViewById(R.id.button1);
			button1.setOnClickListener(new View.OnClickListener() {
			        public void onClick(View v) {
			                Intent intent = new Intent(getBaseContext(), StartActivity.class);
			                startActivity(intent);
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


**2.랜덤한 숫자를 선택후 그랜덤한 숫자에 가장 가까운 숫자를 선택한 사람을 찾는 클래스**

```
package com.example.guessinggame_;

import java.util.Random;

public class Guess {
		
		public static int getWinner(String p1Value, String p2Value, String p3Value, String p4Value, String p5Value, final int rNumber) {
			int p1Number = 0, p2Number = 0, p3Number = 0, p4Number = 0, p5Number=0;
			if (p1Value.length() > 0) {
				p1Number = Integer.parseInt(p1Value);
			}
			if (p2Value.length() > 0) {
				p2Number = Integer.parseInt(p2Value);
			}
			if (p3Value.length() > 0) {
				p3Number = Integer.parseInt(p3Value);
			}
			if (p4Value.length() > 0) {
				p4Number = Integer.parseInt(p4Value);
			}
			
			if( p5Value.length()>0) {
				p5Number= Integer.parseInt(p5Value);
			}
			int winner = 0;
			if (p1Number == rNumber ) {
				winner = 1;
			}
			if (p2Number == rNumber) {
				winner = 2;
			}
			if (p3Number == rNumber) {
				winner = 3;
			}
			if (p4Number == rNumber) {
				winner = 4;
			}
			
			if (p5Number == rNumber) {
				winner =5;
			}
			if (winner == 0) {
				winner = getClosest(p1Number, p2Number, p3Number, p4Number, p5Number, rNumber);
			}
			return winner;
		}
		
		public static int getClosest(int p1Num, int p2Num, int p3Num, int p4Num, int p5Num,final int rNum) {
			int closest = 1;
			int small;
			p1Num = getDifference(p1Num, rNum);
			p2Num = getDifference(p2Num, rNum);
			p3Num = getDifference(p3Num, rNum);
			p4Num = getDifference(p4Num, rNum);
			p5Num = getDifference(p5Num,rNum);
			small = p1Num;
			if (p2Num < small) {
				small = p2Num;
				closest = 2;
			}
			if (p3Num < small) {
				small = p3Num;
				closest = 3;
			}
			if (p4Num < small) {
				small = p4Num;
				closest = 4;
			}
			if (p5Num < small) {
				small = p5Num;
				closest =5;
				
			}
			return closest;
		}
		
		public static int randomInteger(int Start, int End) {
	        Random random = new Random();
			long range = (long)End - (long)Start + 1;
	        long fraction = (long)(range * random.nextDouble());
	        int randomNumber = (int)(fraction + Start);
	        return randomNumber;
	    }
		
		public static int getDifference(int num, final int rNum) {
			if (num != 0) {
				num = Math.abs(num - rNum);
			}else{
				num = 100;
			}
			return num;
		}
		

	}
```

**3.start activity**

```
package com.example.guessinggame_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class StartActivity extends Activity {
	
	private TextView numberText, winnerText;
	private EditText p1Text, p2Text, p3Text, p4Text, p5Text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		numberText = (TextView) findViewById(R.id.numberLabel);
		winnerText = (TextView) findViewById(R.id.winnerLabel);
		p1Text = (EditText) findViewById(R.id.p1Text);
		p2Text = (EditText) findViewById(R.id.p2Text);
		p3Text = (EditText) findViewById(R.id.p3Text);
		p4Text = (EditText) findViewById(R.id.p4Text);
		p5Text = (EditText) findViewById(R.id.p5Text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void gButtonClick(View view) {
		final String p1Value = p1Text.getText().toString();
		final String p2Value = p2Text.getText().toString();
		final String p3Value = p3Text.getText().toString();
		final String p4Value = p4Text.getText().toString();
		final String p5Value = p5Text.getText().toString();
		final int rNumber = Guess.randomInteger(1, 20);
		final int winner = Guess.getWinner(p1Value, p2Value, p3Value, p4Value, p5Value, rNumber);
		numberText.setText(getResources().getString(R.string.numText) + " " + Integer.toString(rNumber));
		winnerText.setText(getWinText(winner) + " " + getResources().getString(R.string.wins));
	}
	
	public String getWinText(int id) {
		String winner = null;
		if (id == 1) {
			winner = getResources().getString(R.string.player1_title);
		}
		if (id == 2) {
			winner = getResources().getString(R.string.player2_title);
		}
		if (id == 3) {
			winner = getResources().getString(R.string.player3_title);
		}
		if (id == 4) {
			winner = getResources().getString(R.string.player4_title);
		}
		if (id == 5) {
			winner = getResources().getString(R.string.player5_title);
		}
		
		
		return winner;
	}

}

```

**4.activity main xml파일**
```
<?xml version="1.0" encoding="utf-8"?>
<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/guess" >

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="126dp"
        android:layout_y="314dp"
        android:text="Start" />

</AbsoluteLayout>

```

**5.activity start xml파일**
```

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".StartActivity" >

    <TextView
        android:id="@+id/p1Title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_aignParentLeft="true"
        android:layout_alignParentTop="true"
        android:layout_marginBottom="28dp"
        android:layout_marginRight="10dp"
        android:text="@string/player1_title"
        android:textSize="24sp" />

    <EditText
        android:id="@+id/p1Text"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_marginBottom="20dp"
        android:layout_toRightOf="@+id/p1Title"
        android:hint="@string/textHint"
        android:inputType="number"
        android:singleLine="true" />

    <TextView
        android:id="@+id/p2Title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/p1Title"
        android:layout_marginBottom="28dp"
        android:layout_marginRight="10dp"
        android:text="@string/player2_title"
        android:textSize="24sp" />

    <EditText
        android:id="@+id/p2Text"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/p1Text"
        android:layout_marginBottom="20dp"
        android:layout_toRightOf="@+id/p2Title"
        android:hint="@string/textHint"
        android:inputType="number"
        android:singleLine="true" />

    <TextView
        android:id="@+id/p3Title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/p2Title"
        android:layout_marginBottom="28dp"
        android:layout_marginRight="10dp"
        android:text="@string/player3_title"
        android:textSize="24sp" />

    <EditText
        android:id="@+id/p3Text"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/p2Text"
        android:layout_marginBottom="20dp"
        android:layout_toRightOf="@+id/p3Title"
        android:hint="@string/textHint"
        android:inputType="number"
        android:singleLine="true" />

    <TextView
        android:id="@+id/p4Title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/p3Title"
        android:layout_marginBottom="28dp"
        android:layout_marginRight="10dp"
        android:text="@string/player4_title"
        android:textSize="24sp" />

    <EditText
        android:id="@+id/p4Text"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/p3Text"
        android:layout_marginBottom="20dp"
        android:layout_toRightOf="@+id/p4Title"
        android:hint="@string/textHint"
        android:inputType="number"
        android:singleLine="true" />

    <TextView
        android:id="@+id/p5Title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/p4Title"
        android:layout_marginBottom="28dp"
        android:layout_marginRight="10dp"
        android:text="@string/player5_title"
        android:textSize="24sp" />

    <EditText
        android:id="@+id/p5Text"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/p4Text"
        android:layout_marginBottom="20dp"
        android:layout_toRightOf="@+id/p5Title"
        android:hint="Enter a number"
        android:inputType="number"
        android:singleLine="true" />

    <TextView
        android:id="@+id/numberLabel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/guessButton"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="20dp"
        android:textSize="24sp" />

    <TextView
        android:id="@+id/winnerLabel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/numberLabel"
        android:layout_centerHorizontal="true"
        android:textSize="24sp" />

    <TextView
        android:id="@+id/ownerLabel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="10dp"
        android:text="@sring/ownerInfo"
        android:textSize="12sp" />

    <TextView
        android:id="@+id/versionLabel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/ownerLabel"
        android:layout_centerHorizontal="true"
        android:text="@string/versionInfo"
        android:textSize="14sp" />

    <Button
        android:id="@+id/guessButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/ownerLabel"
        android:layout_below="@+id/p5Title"
        android:onClick="gButtonClick"
        android:text="@string/guessButton"
        android:textSize="24sp" />

</RelativeLayout>

```

## 참조 ##
http://www.java2s.com/Open-Source/Android_Free_Code/Game_Guess/Download_Free_code_Guessing_Game.htm
코드를 따왔지만 player 5를 더 생성하고 메인 액티비티 전 시작 화면을 만들었습니다.