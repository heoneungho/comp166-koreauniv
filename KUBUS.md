

# Introduction #

학교 셔틀이 언제 올지 알려주는 아주 혁신적인 어플입니다.

![http://comp166-koreauniv.googlecode.com/files/KUBUSicon.png](http://comp166-koreauniv.googlecode.com/files/KUBUSicon.png)

어플 아이콘

다운로드 : http://comp166-koreauniv.googlecode.com/files/KUBUS.apk

# Details #


  * 정류장을 선택하면 잠시 후에 도착하는 버스를 알려줌
  * 도착하고 싶은 때에 도착하려면 몇 시에 차를 타야 되는지 알려줌
  * 셔틀 버스 노선도를 활용하여 직관적인 사용 가능

# 출발역 설정 #
![http://comp166-koreauniv.googlecode.com/files/Main.jpg](http://comp166-koreauniv.googlecode.com/files/Main.jpg)

  * xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/prebg2"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:focusable="false"
        android:focusableInTouchMode="true"
        android:src="@drawable/circle1" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="37dp"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/button1"
        android:layout_marginBottom="32dp"
        android:layout_marginRight="15dp"
        android:layout_toLeftOf="@+id/button1"
        android:background="#00000000" //그냥 냅두면 버튼이 회색이여서 투명하게 만들었음 
        android:text="		" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_centerVertical="true"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/button3"
        android:layout_alignRight="@+id/button2"
        android:layout_marginBottom="30dp"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button4"
        android:layout_alignBottom="@+id/button4"
        android:layout_marginLeft="23dp"
        android:layout_toRightOf="@+id/button5"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button3"
        android:layout_alignBottom="@+id/button3"
        android:layout_alignRight="@+id/imageView1"
		android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button8"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button2"
        android:layout_alignBottom="@+id/button2"
        android:layout_alignLeft="@+id/button6"
        android:background="#00000000"
        android:text="		" />

    <EditText
        android:id="@+id/editText1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button7"
        android:layout_alignBottom="@+id/button7"
        android:layout_centerHorizontal="true"
        android:ems="4"
        android:text="출발역" />

    <Button
        android:id="@+id/button5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/button6"
        android:layout_alignRight="@+id/editText1"
        android:layout_marginBottom="28dp"
        android:background="#00000000"
        android:text="		" />

</RelativeLayout>
```

  * java
```
package com.example.kubus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
/* 각 역마다 번호를 부여하고 activity 전환할 때 그 값들이 넘어가게끔 설정 했음 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=1;
		        	intent.putExtra("start", start);
		        	startActivity(intent); //출처는 교수님이 올려주신 코드조각
		        }
		});
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=2;
		        	intent.putExtra("start", start);
		        	startActivity(intent);
		        }
		});

		Button button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=3;
		        	intent.putExtra("start", start);
		        	startActivity(intent);
		        }
		});

		Button button4 = (Button)findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=4;
		        	intent.putExtra("start", start);
		        	startActivity(intent);
		        }
		});
		
		Button button5 = (Button)findViewById(R.id.button5);
		button5.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=5;
		        	intent.putExtra("start", start);
		        	startActivity(intent);
		        }
		});

		Button button6 = (Button)findViewById(R.id.button6);
		button6.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=6;
		        	intent.putExtra("start", start);
		        	startActivity(intent);
		        }
		});

		Button button7 = (Button)findViewById(R.id.button7);
		button7.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=7;
		        	intent.putExtra("start", start);
		        	startActivity(intent);
		        }
		});

		Button button8 = (Button)findViewById(R.id.button8);
		button8.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StopActivity.class);
		        	int start=8;
		        	intent.putExtra("start", start);
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

# 도착역 설정 #
![http://comp166-koreauniv.googlecode.com/files/Stop.jpg](http://comp166-koreauniv.googlecode.com/files/Stop.jpg)

  * xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/prebg2"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".StopActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:focusable="false"
        android:focusableInTouchMode="true"
        android:src="@drawable/circle1" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="37dp"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/button1"
        android:layout_marginBottom="32dp"
        android:layout_marginRight="15dp"
        android:layout_toLeftOf="@+id/button1"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_centerVertical="true"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/button3"
        android:layout_alignRight="@+id/button2"
        android:layout_marginBottom="30dp"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/button4"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="28dp"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button4"
        android:layout_alignBottom="@+id/button4"
        android:layout_marginLeft="23dp"
        android:layout_toRightOf="@+id/button5"
        android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button3"
        android:layout_alignBottom="@+id/button3"
        android:layout_alignRight="@+id/imageView1"
		android:background="#00000000"
        android:text="		" />

    <Button
        android:id="@+id/button8"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button2"
        android:layout_alignBottom="@+id/button2"
        android:layout_alignLeft="@+id/button6"
        android:background="#00000000"
        android:text="		" />
    
        <EditText
        android:id="@+id/editText1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button7"
        android:layout_alignBottom="@+id/button7"
        android:layout_centerHorizontal="true"
        android:ems="4"
        android:text="도착역" />

</RelativeLayout>
```

  * java
```
package com.example.kubus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class StopActivity extends Activity {

/* 출발역에서는 출발역에 대한 정보를 넘겨 줬다면 이번엔 출발역뿐만 아니라 도착역에 대한 정보도 같이 넘겨줌 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stop);
		
		Intent intent = getIntent();
		final int start = intent.getIntExtra("start", 0); // 출발역에 대한 정보를 받음
		
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=1;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=2;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});

		Button button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=3;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});


		Button button4 = (Button)findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=4;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});
		
		Button button5 = (Button)findViewById(R.id.button5);
		button5.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=5;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});

		Button button6 = (Button)findViewById(R.id.button6);
		button6.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=6;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});

		Button button7 = (Button)findViewById(R.id.button7);
		button7.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=7;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});

		Button button8 = (Button)findViewById(R.id.button8);
		button8.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),SetTimeActivity.class);
		        	int end=8;
		        	intent.putExtra("start", start);
		        	intent.putExtra("end", end);
		        	startActivity(intent);
		        }
		});
		        	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stop, menu);
		return true;
	}

}
```

# 시간설정 #
![http://comp166-koreauniv.googlecode.com/files/SetTime.jpg](http://comp166-koreauniv.googlecode.com/files/SetTime.jpg)

  * xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/prebg2"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".SetTimeActivity" >

    <TimePicker
        android:id="@+id/timePicker1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="113dp" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/timePicker1"
        android:layout_marginLeft="16dp"
        android:layout_toRightOf="@+id/button1"
        android:text="도착" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/timePicker1"
        android:layout_below="@+id/timePicker1"
        android:text="출발" />

</RelativeLayout>
```

  * java
```
package com.example.kubus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class SetTimeActivity extends Activity {
	
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_time);
		Intent intent = getIntent();
		final int start = intent.getIntExtra("start", -1);
		final int end = intent.getIntExtra("end", -1);
		//출발역과 도착역에 대한 정보를 받음
		final TimePicker tp = (TimePicker)findViewById(R.id.timePicker1); 
/* 이클립스 옆에 느낌표? 그거 누르니까 final 쓰라고 떠서 final 써줌 */
		

		/* 출발시각 지정 했을 때 */
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
		        @SuppressLint("ShowToast")
				public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),StartTimeActivity.class);
		        	intent.putExtra("start", start);
		        	intent.putExtra("end",end) ;
		        	
		        	int h = tp.getCurrentHour();
		        	int m = tp.getCurrentMinute(); 
/* http://www.androidside.com/plugin/mobile/board.php?bo_table=B49&wr_id=66095 여기서 가져옴 */
		        	intent.putExtra("h",h);
		        	intent.putExtra("m",m);
		        	
		        	startActivity(intent);
		    		// 출발역, 도착역, 출발 시각을 넘겨줌
		        }
		});
		

                /* 도착시각 지정 했을 때 */
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	Intent intent = new Intent(getBaseContext(),EndTimeActivity.class);
		        	intent.putExtra("start", start);
		        	intent.putExtra("end",end);
		       
		        	int h = tp.getCurrentHour();
		        	int m = tp.getCurrentMinute(); 
		        	intent.putExtra("h",h);
		        	intent.putExtra("m",m);
		       
		        	startActivity(intent);
                                //출발역, 도착역, 도착 시각을 넘겨줌
		        }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set_time, menu);
		return true;
	}

}
```

# 결과 1 (출발시각이 궁금한 경우) #

![http://comp166-koreauniv.googlecode.com/files/StartTime.jpg](http://comp166-koreauniv.googlecode.com/files/StartTime.jpg)
```
 * xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/prebg2"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".StartTimeActivity" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="160dp"
        android:text="Medium Text"
        android:textAppearance="?android:attr/textAppearanceMedium" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView1"
        android:layout_centerHorizontal="true"
        android:text="Medium Text"
        android:textAppearance="?android:attr/textAppearanceMedium" />

</RelativeLayout>
```

  * java
```
package com.example.kubus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

@SuppressLint({ "CutPasteId", "ShowToast" })
public class StartTimeActivity extends Activity {
/* 안암학사 기준으로 버스가 출발하기 때문에 안암학사를 거칠 경우도 계산해 줘야함 */
/* 즉 5 -> 3 로 가고 싶으면 1에서 다시 버스를 타야하는 시간을 계산 해 줘야함 */ 
	public int expt_time(int time, int now, int dest) {
		int i, j;
		
		int[] interval = { 2, 3, 4, 5, 5, 1, 1, 1 };
                //직접 버스타고 스탑워치로 시간 재서 간격 구했음 적당히 정확함

		for (i = now - 2; i >= 0; i--)
                /* 지금 역에서 1번역(안암학사)로 돌아감 */
			time -= interval[i]; 

		for (i = 570, j = 10; i < 1070; i += j) {
                /* 그 시각에 1번역에서 탈 수 있는 버스를 찾음 */
			if (time <= i)
				break;
			if (i == 730)
				j = 20; //점심시간 배차
			if (i == 810)
				j = 10; //다시 원래 배차
		} 		time = i;
		if (now == 1){
		
		/* 버스타는 시간 */	
		TextView Text1 = (TextView)findViewById(R.id.textView1);
		Text1.setText("출발" + time / 60 + "시 " + time % 60 + "분") ;

		}
		for (i = 0; i < dest - 1; i++) {
                /* 버스를 타고 목적지로 출발 */
			time += interval[i];
			if (i + 2 == now){
                

			TextView Text2 = (TextView)findViewById(R.id.textView1);
			Text2.setText("출발" + time / 60 + "시 " + time % 60 + "분") ;

			}
		}
		return time;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_time);
		Intent intent = getIntent();
		final int start = intent.getIntExtra("start", -1);
		final int end = intent.getIntExtra("end", -1);
		final int h = intent.getIntExtra("h", -1);
		final int m = intent.getIntExtra("m", -1);
/* 출발역, 도착역, 설정한 시각에 대한 정보를 받아옴. final은 이클립스의 추천 */
		int time;

		time = 60 * h + m; 
                /* 시간 관리를 보다 쉽게 하기 위해서 시간을 전부 분으로 고침 */
		if (start <= end)
			time = expt_time(time, start, end); // 위의 함수를 이용함
		else
			time = expt_time(expt_time(time, start, 9), 1, end); 
//8에서 1로 가게 되면 처음 출발역에서 1까지오고 다시 1에서 도착역까지가게 계산
	
		TextView Text3 = (TextView)findViewById(R.id.textView2);
		Text3.setText("도착" + time / 60 + "시 " + time % 60 + "분") ;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_time, menu);
		return true;
	}

}
```

# 결과 2 (도착시각이 궁금한 경우) #
![http://comp166-koreauniv.googlecode.com/files/EndTime.jpg](http://comp166-koreauniv.googlecode.com/files/EndTime.jpg)

  * xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/prebg2"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".StartTimeActivity" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="190dp"
        android:text="Medium Text"
        android:textAppearance="?android:attr/textAppearanceMedium" />
/* 분명히 텍스트뷰는 하나만 만들었는데 왜 두개가 나오는지 이유를 모르겠음. */
</RelativeLayout>
```

  * java
```
package com.example.kubus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

@SuppressLint({ "CutPasteId", "ShowToast" })
public class EndTimeActivity extends Activity {
/* 출발시각 설정과 거의 유사함, 중간중간 다른 코드는 도착역에 맞게 바꾼 것. */
	public int expt_time(int time, int dest, int now) {
		int i, j;

		int[] interval = { 2, 3, 4, 5, 5, 1, 1, 1 };

		for (i = now - 2; i >= 0; i--)

			time -= interval[i];
		for (i = 570, j = 10; i < 1070; i += j) {
			if (time <= i)
				break;
			if (i == 730)
				j = 20;
			if (i == 810)
				j = 10;
		}
		time = i-j;
		for (i = 0; i < dest - 1; i++) 
			time += interval[i];
			
		return time;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_time);
		Intent intent = getIntent();
		final int start = intent.getIntExtra("start", -1);
		final int end = intent.getIntExtra("end", -1);
		final int h = intent.getIntExtra("h", -1);
		final int m = intent.getIntExtra("m", -1);

		int time;

		time = 60 * h + m;
		if (start <= end)
			time = expt_time(time, start, end);
		else
			time = expt_time(expt_time(time, 1, end), start, 9);
		TextView Text3 = (TextView)findViewById(R.id.textView1);
		Text3.setText("출발 : " + time / 60 + "시 " + time % 60 + "분") ;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_time, menu);
		return true;
	}

}
```