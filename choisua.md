# Introduction #

베스킨라빈스31(업그레이드)
![http://comp166-koreauniv.googlecode.com/files/baskin.png](http://comp166-koreauniv.googlecode.com/files/baskin.png)

1부터31까지 숫자를 순서대로 말하고 마지막에 31을 말하는사람이 지는것
단,숫자는 1개부터 3개까지 말할 수 있고 전 사람이 말한 갯수만큼은 못 말한다

# Details #

1. 메인화면

![https://comp166-koreauniv.googlecode.com/files/KakaoTalk_21607b04cbc79e24.jpg](https://comp166-koreauniv.googlecode.com/files/KakaoTalk_21607b04cbc79e24.jpg)

MainActivity.java
```
package com.example.baskinrabbins31;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setTitle("Menu");
		
		ImageView button1 = (ImageView)findViewById(R.id.imageView3);
	    button1.setOnClickListener(new OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v){
	    		Toast.makeText(getApplicationContext(),  "선택화면으로 ", Toast.LENGTH_LONG).show();
	    		
	    		Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
	    		startActivity(intent);
	}
 });
	    
	    ImageView button2 = (ImageView)findViewById(R.id.imageView4);
	    button2.setOnClickListener(new OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v){
	    		Toast.makeText(getApplicationContext(),  "선택화면으로 ", Toast.LENGTH_LONG).show();
	    		
	    		Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
	    		startActivity(intent);
	    	}
	    });
	    
	    ImageView button3 = (ImageView)findViewById(R.id.imageView2);
	    button3.setOnClickListener(new OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v){
	    		Toast.makeText(getApplicationContext(),  "설명화면으로 ", Toast.LENGTH_LONG).show();
	    		
	    		Intent intent = new Intent(getApplicationContext(),IntroActivity.class);
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

activity\_main.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/LinearLayout1"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#A5D2E7"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="318dp"
        android:layout_height="120dp"
        android:src="@drawable/a" />

    <ImageView
        android:id="@+id/imageView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/kakao" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="272dp"
        android:layout_height="78dp"
        android:src="@drawable/b" />

    <ImageView
        android:id="@+id/imageView4"
        android:layout_width="272dp"
        android:layout_height="78dp"
        android:src="@drawable/c" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="272dp"
        android:layout_height="78dp"
        android:src="@drawable/e" />

    <ImageView
        android:id="@+id/imageView5"
        android:layout_width="272dp"
        android:layout_height="78dp"
        android:src="@drawable/d" />

</LinearLayout>
```

2. 게임 설명 화면

![https://comp166-koreauniv.googlecode.com/files/KakaoTalk_21fe31ca0264a707.jpg](https://comp166-koreauniv.googlecode.com/files/KakaoTalk_21fe31ca0264a707.jpg)

IntroActivity.java
```
package com.example.baskinrabbins31;

import android.os.Bundle;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		getActionBar().setTitle("Intro");
		
		ImageView button = (ImageView)findViewById(R.id.imageView1);
		button.setOnClickListener(new OnClickListener(){

	      @Override
	      public void onClick(View v){
	    	  Toast.makeText(getApplicationContext(),"홈으로.",Toast.LENGTH_LONG).show();
	    	  
	    	  finish();
	      }
		});
	}

	      }
```

activity\_intro.xml
```
<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#A5D2E7"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".IntroActivity" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="match_parent"
        android:layout_height="68dp"
        android:text="How to do Baskinrabbins31 game"
        android:textSize="30sp" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="186dp"
        android:layout_height="60dp"
        android:layout_x="54dp"
        android:layout_y="371dp"
        android:src="@drawable/back" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="103dp"
        android:layout_height="62dp"
        android:layout_x="91dp"
        android:layout_y="93dp"
        android:src="@drawable/eee" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="92dp"
        android:layout_height="58dp"
        android:layout_x="96dp"
        android:layout_y="240dp"
        android:src="@drawable/hh" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="0dp"
        android:layout_y="152dp"
        android:text="번갈아가면서 순서대로 3개 이하의 숫자를 말한다. 마지막 숫자인 31을 말하는 사람이 지게 된다."
        android:textSize="20sp" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="match_parent"
        android:layout_height="76dp"
        android:layout_x="10dp"
        android:layout_y="308dp"
        android:text="위와 방법이 비슷하지만 전 사람이 말한 숫자 갯수와 다르게 말한다."
        android:textSize="20sp" />

</AbsoluteLayout>
```

3. 레벨선택화면

![https://comp166-koreauniv.googlecode.com/files/KakaoTalk_51d7df1d393a4b28.jpg](https://comp166-koreauniv.googlecode.com/files/KakaoTalk_51d7df1d393a4b28.jpg)

SelectActivity.java
```
package com.example.baskinrabbins31;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

public class SelectActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		getActionBar().setTitle("Select");
		
		ImageView button1 = (ImageView)findViewById(R.id.imageView2);
	    button1.setOnClickListener(new OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v){
	    		Toast.makeText(getApplicationContext(),  "게임 시작 ", Toast.LENGTH_LONG).show();
	    		
	    		Intent intent = new Intent(getApplicationContext(),Baskin31Main.class);
	    		startActivity(intent);
	}
 });
	    
	    ImageView button2 = (ImageView)findViewById(R.id.imageView3);
	    button2.setOnClickListener(new OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v){
	    		Toast.makeText(getApplicationContext(),  "게임 시작 ", Toast.LENGTH_LONG).show();
	    		
	    		Intent intent = new Intent(getApplicationContext(),BaskinMain.class);
	    		startActivity(intent);
	    	}
	    });
	    
	    ImageView button = (ImageView)findViewById(R.id.imageView4);
		button.setOnClickListener(new OnClickListener(){

	      @Override
	      public void onClick(View v){
	    	  Toast.makeText(getApplicationContext(),"홈으로 돌아갑니다.",Toast.LENGTH_LONG).show();
	    	  
	    	  finish();
	      }
		});
	}

	      }
```

activity\_select.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/LinearLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#A5D2E7"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".SelectActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="318dp"
        android:layout_height="80dp"
        android:src="@drawable/aa" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="match_parent"
        android:layout_height="150dp"
        android:src="@drawable/easy" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="match_parent"
        android:layout_height="150dp"
        android:src="@drawable/hard" />

    <ImageView
        android:id="@+id/imageView4"
        android:layout_width="271dp"
        android:layout_height="50dp"
        android:src="@drawable/back" />

</LinearLayout>
```

4. 게임 중 화면

![https://comp166-koreauniv.googlecode.com/files/KakaoTalk_b9a8b896fca2832a.jpg](https://comp166-koreauniv.googlecode.com/files/KakaoTalk_b9a8b896fca2832a.jpg)

Baskin31.java
```
package com.example.baskinrabbins31;


	public class Baskin31 {
		public static int game_go_on=0;
		private int user;
		private int com; 
		private int game_cnt; 

		public int user(int input){
			do{
				try{
					user = input;
					}catch(Exception e){
						user = -1;
					}
				}while(user < 0 || user > 3); 
					
						game_cnt += user; 
						isUserCheck(); 
						return game_cnt;					
			}
			
		//컴퓨터의 선택함수. 리턴값은 컴퓨터의 선택.
		public int computer(){
				if(game_cnt == 27)
					com =3;
				else if(game_cnt == 28)
					com =2;
				else if(game_cnt == 29)
					com =1;
				else{ 
					com = (int)(Math.random() *3)+1;
				}
				game_cnt +=com;
				isComCheck(); 
				return com;
			}
			//컴퓨터가 이기면 game_go_on=1;
			public void isUserCheck(){
				if(game_cnt >= 30){
					game_go_on = 1;
				}
				else
					game_go_on = 0;
			}
			//유저가 이기면 game_go_on = 2;
			public void isComCheck(){
				if(game_cnt >= 30){
					game_go_on = 2;
				}
				else
					game_go_on = 0;
			}
			
			public int Getgame_cnt(){
					return game_cnt;
			}
			


	}
```

Baskin31Main.java
```
package com.example.baskinrabbins31;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Baskin31Main extends Activity {

	Button button01;
	EditText output;
	TextView textview;
	int input;
	int computer_input;
	int sum;
	Baskin31 b;
	Hard h;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baskin31_main);

		button01 = (Button) findViewById(R.id.button1);
		textview = (TextView) findViewById(R.id.textView1);
		output = (EditText) findViewById(R.id.editText1);
		b = new Baskin31();
		

		button01.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				input = Integer.parseInt(output.getText().toString());
				b.user(input);
				// if(b.Getgame_cnt()!=1) // 유저가 이겼을 때 게임 계속하기를 할 경우 실행되지 않게 하기
				// 위함
				computer_input=b.computer();
				textview.setText("컴퓨터의 선택 : " + computer_input + "\n합계 : "
						+ b.Getgame_cnt());
				
					
				if(Baskin31.game_go_on == 1)
				{
					Intent i = new Intent(getBaseContext(),Gameresult.class);
					i.putExtra("result",Baskin31.game_go_on);
					startActivity(i);
					 
				}else if(Baskin31.game_go_on == 2)
				{
					Intent i = new Intent(getBaseContext(),Result.class);
					i.putExtra("result",Baskin31.game_go_on);
					startActivity(i);
				}
					
					
			}
			// textview.setText(output.getText());
		});

	}
}
```

activity\_baskin31\_main\_xml
```
<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bb"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".BaskinMain" >

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="204dp"
        android:layout_height="44dp"
        android:layout_x="55dp"
        android:layout_y="246dp"
        android:src="@drawable/enter" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="272dp"
        android:layout_height="118dp"
        android:layout_x="14dp"
        android:layout_y="127dp"
        android:textColor="#ffffff"
        android:textSize="30sp" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="236dp"
        android:layout_height="122dp"
        android:layout_x="34dp"
        android:layout_y="34dp"
        android:src="@drawable/start" />

    <EditText
        android:id="@+id/editText1"
        android:layout_width="69dp"
        android:layout_height="52dp"
        android:layout_x="68dp"
        android:layout_y="318dp"
        android:ems="10" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="176dp"
        android:layout_y="326dp"
        android:text="ok" />

</AbsoluteLayout>
```

5, 게임결과 화면

![https://comp166-koreauniv.googlecode.com/files/KakaoTalk_5175c4ec89e57e3b.jpg](https://comp166-koreauniv.googlecode.com/files/KakaoTalk_5175c4ec89e57e3b.jpg)

Result.java
```
package com.example.baskinrabbins31;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Result extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
```

activity\_result.xml
```
<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/l"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Result" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="312dp"
        android:layout_height="154dp"
        android:layout_x="4dp"
        android:layout_y="134dp"
        android:src="@drawable/lose" />

</AbsoluteLayout>
```


# 소스코드 #

코드 출처 : http://blog.naver.com/PostList.nhn?from=postList&blogId=nobless_05&categoryNo=28&currentPage=2
참고해서 안드로이드 앱에서 쓸 수 있는 코드로 수정했습니다.

apk 파일입니다.
https://comp166-koreauniv.googlecode.com/files/Baskinrabbins31.apk