# Introduction #

![http://comp166-koreauniv.googlecode.com/files/shoopri.png](http://comp166-koreauniv.googlecode.com/files/shoopri.png)


N 모 포털의 동명의 서비스에서 착안점을 얻은 게임 어플입니다. 자신이 입력한 경매가가 유일한 최저가가 되면 해당 상품을 가져올 수 있습니다. 전자제품, 옷, 화장품, 음식까지 갖고 싶었던 상품을 여기서나마 가져보세요! 덤으로 실패할 경우 남이 가져가는 모습도 볼 수 있습니다!


# Details #

1. 인원 수(10~20)를 설정하고 게임 시작

2. 상품의 사진이 나오면 자신의 경매가를 입력하고 shoot!

3. 자신이 입력한 경매가가 유일한 최저가이면 그 상품을 get!
> 아니라면 다른 플레이어가 가져갑니다.

4. 총 10개의 상품이 랜덤으로 나오고 그 중 획득한 상품을 보여주면서 게임 끝


# Code #

1. Main Activity

```

(java)

package com.example.shootingprice;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {


		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//배경이미지
		RelativeLayout titlelayout = (RelativeLayout)findViewById(R.id.RelativeLayout1);
		titlelayout.setBackgroundResource(R.drawable.background);
		
		//타이틀 로고 애니메이션
		final ImageView Title = (ImageView) findViewById(R.id.title);
		Animation moveTitle = AnimationUtils.loadAnimation(this, R.anim.alpha_title);
				Title.startAnimation(moveTitle);
				
		//총알구멍1 애니메이션
		final ImageView hole1 = (ImageView) findViewById(R.id.hole1);
		Animation shot1 = AnimationUtils.loadAnimation(this, R.anim.be_shot);
		shot1.setStartOffset(1000);//1000ms뒤에 시작
		shot1.setFillAfter(true);//애니메이션 끝난 후 원상태로 복귀하지 않음
		hole1.startAnimation(shot1);		
		
		//총알구멍2 애니메이션. 1과 같음
		final ImageView hole2 = (ImageView) findViewById(R.id.hole2);
		Animation shot2 = AnimationUtils.loadAnimation(this, R.anim.be_shot);
		shot2.setStartOffset(1200);
		shot2.setFillAfter(true);
		hole2.startAnimation(shot2);
		
		//start버튼 애니메이션
		final TextView textStart = (TextView) findViewById(R.id.textStart);
		Animation moveStart = AnimationUtils.loadAnimation(this, R.anim.translate_titletext);
		moveStart.setStartOffset(1500);
		textStart.startAnimation(moveStart);
		//start버튼 클릭하면 경쟁자 수 세팅으로 넘어가기
		textStart.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(getBaseContext(), PlayerSet.class);
                startActivity(intent);
	        }
	 });
		
		//how to play버튼 애니메이션, how to play로 넘어가기
		final TextView textExplain = (TextView) findViewById(R.id.textExplain);
		
		Animation moveExplain = AnimationUtils.loadAnimation(this, R.anim.translate_titletext);
		moveExplain.setStartOffset(1700);
		textExplain.startAnimation(moveExplain);
		
		textExplain.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            Intent intent_second = new Intent(getBaseContext(),HowToPlay.class);
	            startActivity(intent_second);
	        }
	    });
		
		//exit버튼 애니메이션
		final TextView textExit = (TextView) findViewById(R.id.textExit);
		Animation moveExit = AnimationUtils.loadAnimation(this, R.anim.translate_titletext);
		moveExit.setStartOffset(1900);
		textExit.startAnimation(moveExit);
		
		//exit누르면 종료하기. 
                //finish()로 끝내면 게임 1회가 끝나고 메인 화면으로 돌아왔을 때 정상 종료가 안됨
                //(엔딩화면으로 다시 넘어감) -> finish()는 activity를 종료 
		textExit.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	           Intent exitintent = new Intent();
	           exitintent.setAction(Intent.ACTION_MAIN);
	           exitintent.addCategory(Intent.CATEGORY_HOME);
	           startActivity(exitintent);
	        }
	    });
		
		//email 애니메이션, 넘어가기
		final TextView textEmail = (TextView) findViewById(R.id.email);				
		Animation alphaEmail = AnimationUtils.loadAnimation(this, R.anim.alpha_title);
		textEmail.startAnimation(alphaEmail);
		
		textEmail.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            Intent intent_email = new Intent(getBaseContext(),Email.class);
	            startActivity(intent_email);
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


(xml)

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="center_horizontal"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity2" >

    <Space
        android:id="@+id/Space1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="fill_vertical" />

    <TextView
        android:id="@+id/textStart"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:gravity="center_horizontal"
        android:text="START"
        android:textSize="15pt"
        android:textColor="#ffffff"
        android:textAppearance="?android:attr/textAppearanceLarge" />

    <ImageView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/title_final" />

    <TextView
        android:id="@+id/textExit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textExplain"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:gravity="center_horizontal"
        android:text="EXIT"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#ffffff"
        android:textSize="15pt" />

    <TextView
        android:id="@+id/textExplain"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textStart"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:text="HOW TO PLAY"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#ffffff"
        android:textSize="15pt" />

    <ImageView
        android:id="@+id/hole2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/hole1"
        android:layout_alignRight="@+id/title"
        android:src="@drawable/hole" />

    <ImageView
        android:id="@+id/hole1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/textStart"
        android:layout_alignLeft="@+id/textExplain"
        android:src="@drawable/hole" />

    <TextView
        android:id="@+id/email"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:text="I wanna get..."
        android:textColor="#ffffff"
        android:textSize="12pt"
        android:textAppearance="?android:attr/textAppearanceLarge" />

</RelativeLayout>
```

2. Player Set

```
(java)

package com.example.shootingprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

public class PlayerSet extends Activity {
	
	//최대, 최소 경쟁자
	int MAX = 20, MIN = 10;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_set);
		
		//배경이미지
		RelativeLayout playerlayout = (RelativeLayout)findViewById(R.id.RelativeLayout1);
		playerlayout.setBackgroundResource(R.drawable.playerset_background);
		
		//numberPicker 최대최소 설정
		final NumberPicker numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
		numberPicker1.setMaxValue(MAX);
		numberPicker1.setMinValue(MIN);
		numberPicker1.setWrapSelectorWheel(false); //테두리 없애기
		
		//imagebutton start버튼
		ImageButton startbutton = (ImageButton) findViewById(R.id.startbutton);
		startbutton.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		        	final NumberPicker numberPicker1_copy = (NumberPicker) findViewById(R.id.numberPicker1);
		        	int totalPlayer = numberPicker1_copy.getValue();//numberpicker의 값 받기		      
		            Intent intent = new Intent(PlayerSet.this,Item.class);		           
		            intent.putExtra("totalPlayer", totalPlayer);//다음 activity로 경쟁자 수 넘기기
		            startActivity(intent);
		        }
		 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_set, menu);
		return true;
	}
	
	
}


(xml)
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".PlayerSet" >

    <Space
        android:id="@+id/Space1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="56dp"
        android:text="@string/player_select"
        android:textSize="20pt"
        android:textAppearance="?android:attr/textAppearanceLarge" />

    <NumberPicker
        android:id="@+id/numberPicker1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:textColor="#ffffff"
        style="@style/npColor"
        android:textSize="15pt" >

    </NumberPicker>

    <ImageButton
        android:id="@+id/startbutton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/numberPicker1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="28dp"
        android:background="@android:color/transparent"
        android:src="@drawable/golden_ticket" />

</RelativeLayout>
```


3. Playing game
```
(java)
package com.example.shootingprice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Item extends Activity {

	
	static int gameCounter;		//게임 횟수를 세기위한 카운터
	static int[] getItems = new int[10];		//엔딩에 얻은 아이템을 표시하기 위한 배열
	
	//애니메이션이 끝나고 다음 activity로 넘어가기 위한 핸들러
	protected Handler mHandler;
    protected Runnable mRunnable;
	
	//NumberFormatException 처리를 위해
	public int myparseInt(String in, int defvalue)
	{
		try{
			return Integer.parseInt(in);
		} catch (NumberFormatException e)
		{
			return defvalue;
		}
	}
	public int myparseInt(String in){
		return myparseInt(in, 0);
	}
	
	//플레이어, 경쟁자 중 최소값을 찾기 위한 변수
	static int botMin = 0;
	
	//다음 activity로 필요한 값을 넘겨주기위한 변수
	static int m_path=0;
	static int m_min=0, m_max=0;
	static int m_no=0;
	static String m_name=null;
	

			
	//랜덤으로 아이템 갖고오기. 매번 실행되어야 함
	protected void ShuffleMe()
	{
		//배경이미지
		RelativeLayout itemlayout = (RelativeLayout)findViewById(R.id.RelativeLayout1);
		itemlayout.setBackgroundResource(R.drawable.background);
		
		//playerset에서 총 경쟁자 수를 받아온다
		Intent intent = getIntent();
		int totalPlayer = intent.getIntExtra("totalPlayer", 0);
		
		//받아온 총 경쟁자 수 만큼 Player개체 생성
		Player[] players = new Player[totalPlayer];
		for(int i=0;i<totalPlayer;i++){
			players[i] = new Player();			
			players[i].pNum= i;
		}
		
		//아이템 불러오기
		ArrayList<AuctionItem> itemList = new ArrayList<AuctionItem>();
		
		try {
		    InputStream isItem = getAssets().open("itemDB.txt");//asset폴더의 itemDB.txt불러오기
		    BufferedReader brItem = new BufferedReader(new InputStreamReader(isItem));//버퍼리더로 읽기
		    itemList = CreateGame.Load(brItem);//모든 아이템 로드
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		//image view, textview
		final ImageView itemView = (ImageView) findViewById(R.id.itemView);
		final TextView itemMin = (TextView) findViewById(R.id.itemName);
		final TextView itemMax = (TextView) findViewById(R.id.itemMax);
		final TextView itemName = (TextView) findViewById(R.id.itemMin);		
		
		//불러온 아이템의 ArrayList를 셔플해서 index가 0인 아이템만 불러오기
		long seed = System.nanoTime();
		Collections.shuffle(itemList, new Random(seed));
		
		m_no = myparseInt(itemList.get(0).itemNo);
		m_name = itemList.get(0).itemName;
		m_max = Integer.parseInt(itemList.get(0).Max);
		m_min = Integer.parseInt(itemList.get(0).Min);
		String img = itemList.get(0).imgPath;//이미지의 경로를 String으로 불러와서
		//img를 불러와서 drawable에 있는 이름이 같은 변수의 값을 돌려줌 -> int로 변환
		m_path = this.getResources().getIdentifier(img,"drawable","com.example.shootingprice");
		
		//이미지, 최대최소값, 아이템 이름 세팅
		itemView.setImageResource(m_path);
		itemName.setText(m_name);
		itemMax.setText("MAX : "+ m_max);
		itemMin.setText("MIN : "+ m_min);
		
		//경쟁자에게 랜덤으로 값 할당. 난이도 상승을 위해 실제로는 최대값의 1/2가 최대
		for(int j=0;j<totalPlayer;j++){
			players[j].price = randInt(m_max/2,m_min);
		}
		
		//경쟁자의 값을 다른 배열로 복사
		int[] prices = new int[totalPlayer];
		for(int k=0;k<totalPlayer;k++){
			prices[k] = players[k].price;			
		}
		
		//위의 복사한 배열에서 최소값 탐색
		Item.botMin = getMinValue(prices);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);

		//메인이 되는 함수 실행
		ShuffleMe();
		
		//10회를 세기 위해 
		this.gameCounter = 0 ;

		
		//입력값을 넘기기 위해
		final EditText editprice = (EditText) findViewById(R.id.editprice);
		
		//shooting animation
		final ImageButton shootingbutton = (ImageButton) findViewById(R.id.shootingbutton);		
		final Animation gun = AnimationUtils.loadAnimation(this, R.anim.rotate_gun); 
		shootingbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				//플레이어 입력값 받아오기. 기본 parseInt로 하면 오류나서 직접 정의함
				final int userInput = myparseInt(editprice.getText().toString(), -1);
				
				//input errors 처리
				//0이하의 값 입력
				if(userInput <=0)
				{
					Toast.makeText(getApplicationContext(), "You cannot get it for free :)", 1000).show();
					return;	
					
				}
				//10단위로 안 입력
				if(userInput%10 != 0 ){
					Toast.makeText(Item.this, " Please shoot the price in the tens :) ", Toast.LENGTH_LONG).show();
					return;
				}
				//최대값보다 큰 값 입력
				if(userInput>m_max){
					Toast.makeText(Item.this, " That's too expensive :) ", Toast.LENGTH_LONG).show();
					return;
				}
				//최소값보다 작은 값 입력
				if(userInput<m_min){
					Toast.makeText(Item.this, " That's too chip :) ", Toast.LENGTH_LONG).show();
					return;
				}
				
				//이겼을 경우
				if(botMin>userInput){		
					//카운터++
		            Item.gameCounter++;
		            
		            //animation
		            gun.setFillAfter(false);
		            shootingbutton.startAnimation(gun);	
		            //입력값 띄워주기
					Toast.makeText(Item.this, "Your Price : " + editprice.getText().toString(), Toast.LENGTH_LONG).show();
					
					//얻은 아이템의 이미지 경로를 저장
					Item.getItems[gameCounter] = m_path;
					
					//이미지 경로를 다음 activity로 전달
					Intent intentWin = new Intent(getBaseContext(), Win.class);
					intentWin.putExtra("imgPath", m_path);
					
					//일정 시간 뒤에 인텐트를 실행하기 위한 runnabler과
					mRunnable = new Runnable() {
			            @Override
			            public void run() {
			                Intent intentWin = new Intent(getApplicationContext(), Win.class);
			                intentWin.putExtra("imgPath", m_path);
			                startActivityForResult(intentWin, 8);
			            }
			        };
			         
			        //handler. shooting animation을 보여주기 위해 2000ms뒤에 실행
			        mHandler = new Handler();
			        mHandler.postDelayed(mRunnable, 2000);
			         
			   
				}
				
				//졌을 경우
				if(botMin<userInput){
		            Item.gameCounter++;
		            
		            //getItems에 이미지 경로를 추가하지 않는 다는 점을 제외하고 위와 같음
		            gun.setFillAfter(true);
		            shootingbutton.startAnimation(gun);	
		      
					Toast.makeText(Item.this, "Your Price : " + editprice.getText().toString(), Toast.LENGTH_LONG).show();
					
					mRunnable = new Runnable() {
			            @Override
			            public void run() {
			                Intent intentLose = new Intent(getApplicationContext(), Lose.class);
			                intentLose.putExtra("imgPath", m_path);
			                startActivityForResult(intentLose, 8);//request code를 8로 설정. 이 값은 아무 값이나 됨. 
			            }
			        };
			         
			        mHandler = new Handler();
			        mHandler.postDelayed(mRunnable, 2000);        
				}
			}
		});

	}
	
	@Override
    protected void onDestroy() {
        Log.i("test", "onDstory()");
        mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }
	
	//win/lose에서 본 activity로 돌아오기 위해
	protected void onActivityResult(int reqcode, int rescode, Intent Data)
	{
		if (reqcode == 8) //request code가 8이고
			{
			if (Item.gameCounter >= 10)//총 10번을 수행하여 게임이 끝났으면
			{
				//ending으로 넘어감. 얻은 아이템의 이미지를 저장한 getItems를 전달
				Intent intentEnd = new Intent(getBaseContext(), EndGame.class);
				intentEnd.putExtra("getPath", getItems);		
				startActivity(intentEnd);
				finish();
			} else//게임이 아직 안끝났으면
			{
				ShuffleMe();
			}
	
		}
	}
	
	//random generator. max와 min사이의 랜덤값
	int randInt(int max, int min){
	    Random rand = new Random();

	    int randomNum = ((rand.nextInt((max - min) + 1) + min)/10)*10;

	    return randomNum;
	}
	
	//getMinValue
	int getMinValue(int[] numbers){  
		  int minValue = numbers[0];  
		  for(int i=1;i<numbers.length;i++){  
		    if(numbers[i] < minValue){  
		      minValue = numbers[i];  
		    }  
		  }  
		  return minValue;  
		}  
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item, menu);
		return true;
	}

}


(xml)
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Item" >

    <TextView
        android:id="@+id/itemMax"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentTop="true"
        android:textSize="12pt"
        android:textColor="#ffffff" />

    <TextView
        android:id="@+id/itemName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/itemMax"
        android:layout_below="@+id/itemMax"
        android:textColor="#ffffff"
        android:textSize="12pt" />

    <TextView
        android:id="@+id/itemMin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/itemView"
        android:layout_centerHorizontal="true"
        android:textColor="#ffffff"
        android:textSize="12pt" />

    <ImageView
        android:id="@+id/itemView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:gravity="center"
        android:src="@drawable/cheesecake" />

    <EditText
        android:id="@+id/editprice"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:ems="10"
        android:inputType="number" >

        <requestFocus />
    </EditText>

    <ImageButton
        android:id="@+id/shootingbutton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/editprice"
        android:layout_toLeftOf="@+id/editprice"
        android:background="@android:color/transparent"
        android:src="@drawable/gun" />
    
</RelativeLayout>


```

4. If Win
```
(java)

package com.example.shootingprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class Win extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win);
		
		//getIntent
		Intent intent = getIntent();
		int imgPath = intent.getExtras().getInt("imgPath"); 
		
		//배경이미지
		RelativeLayout winlayout = (RelativeLayout)findViewById(R.id.RelativeLayout1);
		winlayout.setBackgroundResource(R.drawable.background);
		
		//얻은 아이템 이미지
		final ImageView winItemView = (ImageView) findViewById(R.id.winItemView);
		winItemView.setImageResource(imgPath);
		//이미지 애니메이션
		Animation rs = AnimationUtils.loadAnimation(this,R.anim.scale_item_win);
		rs.setFillAfter(true);
		winItemView.startAnimation(rs);
		
		//item activity로 돌아가서 StartActivityForReseult를 실행. 화면 아무데나를 클릭하도 넘어가도록 설정
		winItemView.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	setResult(RESULT_OK);
	        	finish();
	        }
	 });
		winlayout.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	setResult(RESULT_OK);
	        	finish();
	        }
	 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.win, menu);
		return true;
	}

}


(xml)

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:columnCount="3"
    android:orientation="horizontal"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Win" >

    <ImageView
        android:id="@+id/winItemView"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:gravity="center"
        android:src="@android:drawable/alert_light_frame" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:text="Congratulation!!"
        android:textSize="20pt"
        android:textColor="#ffffff"
        android:textAppearance="?android:attr/textAppearanceLarge" />

</RelativeLayout>


```

5. If Lose
```
(java)

package com.example.shootingprice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Lose extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lose);
		
		//애니메이션을 제외하고 Win과 동일
		//getIntent
		Intent intent = getIntent();
		int imgPath = intent.getExtras().getInt("imgPath"); 
		
		//create layout, imageview, animation
		RelativeLayout loselayout = (RelativeLayout)findViewById(R.id.RelativeLayout1);
		loselayout.setBackgroundResource(R.drawable.background);
		
		final ImageView loseItemView = (ImageView) findViewById(R.id.loseItemView);
		loseItemView.setImageResource(imgPath);

		
		Animation rs = AnimationUtils.loadAnimation(this,R.anim.scale_item_lost);
		rs.setFillAfter(true);
		loseItemView.startAnimation(rs);
		
		
		//go back to playing game
		loseItemView.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	setResult(RESULT_OK);
	        	finish();
	        }
	 });

		loselayout.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	setResult(RESULT_OK);
	        	finish();
	        }
	 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lose, menu);
		return true;
	}

}


(xml)

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Lose" >

    <ImageView
        android:id="@+id/loseItemView"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:gravity="center"
        android:src="@android:drawable/alert_light_frame" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:gravity="center"
        android:text="That's too bad :)"
        android:textColor="#ffffff"
        android:textSize="20pt"
        android:textAppearance="?android:attr/textAppearanceLarge" />

</RelativeLayout>



```


6. Ending
```
(java)

package com.example.shootingprice;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EndGame extends Activity {

	//갤러리를 위한 변수들
	private ImageView selectedImageView;
    private ImageView leftArrowImageView;
    private ImageView rightArrowImageView;
    private Gallery gallery;
    private int selectedImagePosition = 0;
    private ArrayList<Drawable> drawables;
    private CustomGalleryAdapter galImageAdapter;
    


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_game);
		
		//get intent
		Intent intent = getIntent();
		int[] getPath = intent.getExtras().getIntArray("getPath");
		
		
		//배경이미지
			RelativeLayout titlelayout = (RelativeLayout)findViewById(R.id.endLayout);
			titlelayout.setBackgroundResource(R.drawable.background);
		
		//return home
		final ImageView exit1 = (ImageView) findViewById(R.id.exitButton);
		exit1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent1 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent1);

	        }
		});
		//replay
		final ImageView replay = (ImageView) findViewById(R.id.replayButton);
		replay.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent2 = new Intent(getBaseContext(), PlayerSet.class);
                startActivity(intent2);
	        }
		});
		
		 getDrawablesList(getPath);
	     setupUI();
    }
 
	//이하 코드는 http://sandyandroidtutorials.blogspot.kr/2013_06_01_archive.html 를 참조, 본인에 맞게 변형한 것임.
    //Nothing special about this adapter, just throwing up colored views for demo
	 private void setupUI() {
		 selectedImageView = (ImageView) findViewById(R.id.selected_imageview);
		 leftArrowImageView = (ImageView) findViewById(R.id.left_arrow_imageview);
		 rightArrowImageView = (ImageView) findViewById(R.id.right_arrow_imageview);
		 gallery = (Gallery) findViewById(R.id.gallery);

		 //왼쪽 화살표 클릭
		 leftArrowImageView.setOnClickListener(new OnClickListener() {
			 @Override
			 public void onClick(View v) {

				 if (selectedImagePosition > 0) 
					 --selectedImagePosition;	                

				 gallery.setSelection(selectedImagePosition, false);
			 }
		 });
		 //오른쪽 클릭
		 rightArrowImageView.setOnClickListener(new OnClickListener() {
			 @Override
			 public void onClick(View v) {
				 if (selectedImagePosition < drawables.size() - 1) 
					 ++selectedImagePosition;	                

				 gallery.setSelection(selectedImagePosition, false);
			 }
		 });

		 //선택된 아이템에 따라 화살표 바뀌기...였지만 깔끔한 인터페이스를 위해 통일 
		 gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			 @Override
			 public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				 selectedImagePosition = pos;

				 if (selectedImagePosition > 0 && selectedImagePosition < drawables.size() - 1) {			
					 leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_l));
					 rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_r));					 
				 } 
				 else if (selectedImagePosition == 0) {	 
					 leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_l));			
				 } 
				 else if (selectedImagePosition == drawables.size() - 1) {
					 rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_r));
				 }
				 
				 //선택된 이미지 테두리 바꾸기
				 changeBorderForSelectedImage(selectedImagePosition);
				 //선택된 이미지 크게 보여주기
				 setSelectedImage(selectedImagePosition);
			 }

			 @Override
			 public void onNothingSelected(AdapterView<?> arg0) {
				 
			 }
	        });

		 galImageAdapter = new CustomGalleryAdapter(this, drawables);

		 gallery.setAdapter(galImageAdapter);

		 if (drawables.size() > 0) 
			 gallery.setSelection(selectedImagePosition, false);      

		 if (drawables.size() == 1)
			 rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_r));
	        

	    }	
	 
	 //선택된 이미지 테두리 바꾸는 메소드
	 private void changeBorderForSelectedImage(int selectedItemPos) {
		 int count = gallery.getChildCount();

		 for (int i = 0; i < count; i++) {
			 ImageView imageView = (ImageView) gallery.getChildAt(i);
			 imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.image_border));
			 imageView.setPadding(3, 3, 3, 3);
		 }
		 
		 ImageView imageView = (ImageView) gallery.getSelectedView();
		 imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.selected_item_border));
		 imageView.setPadding(3, 3, 3, 3);
	 }

	 //원본 코드에서 변경한 부분. 획득한 아이템만 표시하도록 변경
	 private void getDrawablesList(int[] pathes) {
		 drawables = new ArrayList<Drawable>();
		 
		 for(int i=0;i<10;i++){
			 if(pathes[i] != 0){
				 drawables.add(getResources().getDrawable(pathes[i]));
			 }		        		      
		 }	      	       
	 }
	 
	
	 //선택한 이미지 확대해서 보여주는 메소드
	 private void setSelectedImage(int selectedImagePosition) {
		 BitmapDrawable bd = (BitmapDrawable) drawables.get(selectedImagePosition);
		 Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(), (int) (bd.getIntrinsicHeight() * 0.9), (int) (bd.getIntrinsicWidth() * 0.7), false);
		 selectedImageView.setImageBitmap(b);
		 selectedImageView.setScaleType(ScaleType.FIT_XY);
		 
		
	 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.end_game, menu);
		return true;
	}

}


(xml)

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/endLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".EndGame" >
    
    <ImageView
        android:id="@+id/selected_imageview"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:layout_below="@+id/gallery_relative_layout"
        android:layout_marginLeft="30dip"
        android:layout_marginRight="30dip"
        android:layout_marginTop="30dip" />

    <ImageView
        android:id="@+id/exitButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentLeft="true"
        android:src="@android:drawable/ic_lock_power_off" />

    <ImageView
        android:id="@+id/replayButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:src="@android:drawable/ic_media_rew" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:text="You've got..."
        android:textColor="#ffffff"
        android:textSize="20pt"
        android:textAppearance="?android:attr/textAppearanceLarge" />

    <RelativeLayout
        android:id="@+id/gallery_relative_layout"
        android:layout_width="fill_parent"
        android:layout_height="150dip"
        android:layout_alignLeft="@+id/exitButton"
        android:layout_below="@+id/textView1"
        android:layout_centerHorizontal="true"
        android:orientation="horizontal" >

        <ImageView
            android:id="@+id/right_arrow_imageview"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentRight="true"
            android:layout_centerVertical="true"
            android:src="@drawable/arrow_r" />

        <ImageView
            android:id="@+id/left_arrow_imageview"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentLeft="true"
            android:layout_alignTop="@+id/right_arrow_imageview"
            android:src="@drawable/arrow_ld" />

        <Gallery
            android:id="@+id/gallery"
            android:layout_width="0dip"
            android:layout_height="150dip"
            android:layout_marginLeft="20dip"
            android:layout_marginRight="20dip"
            android:layout_toLeftOf="@+id/right_arrow_imageview"
            android:layout_toRightOf="@+id/left_arrow_imageview"
            android:spacing="20dip" />
    </RelativeLayout>

</RelativeLayout>



```


7. Email
```
(java)

package com.example.shootingprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
 
public class Email extends Activity {
 
 ImageView buttonSend;
 ImageView returnButton;
 EditText textTo;
 EditText textSubject;
 EditText textMessage;
 LinearLayout linear;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_email);
  
  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
  StrictMode.setThreadPolicy(policy); 
 
  //이하 코드는 http://blog.naver.com/PostView.nhn?blogId=junhwen&logNo=130151732452 참조
  linear = (LinearLayout) findViewById(R.id.linearLayout1);
  linear.setBackgroundResource(R.drawable.playerset_background);
  textTo = (EditText) findViewById(R.id.editTextTo);
  textSubject = (EditText) findViewById(R.id.editTextSubject);
  textMessage = (EditText) findViewById(R.id.editTextMessage);
  
  //return button
  returnButton = (ImageView) findViewById(R.id.buttonReturn); 
  returnButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
      	finish();
      }
});
  
  //send button
  buttonSend = (ImageView) findViewById(R.id.buttonSend);
  buttonSend.setOnClickListener(new OnClickListener() {
 
   @Override
   public void onClick(View v) {
 
     String to = textTo.getText().toString();
     String subject = textSubject.getText().toString();
     String message = textMessage.getText().toString();
 
     Intent email = new Intent(Intent.ACTION_SEND);
     email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
     //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
     //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
     email.putExtra(Intent.EXTRA_SUBJECT, subject);
     email.putExtra(Intent.EXTRA_TEXT, message);
 
     //need this to prompts email client only
     email.setType("message/rfc822");
 
     startActivity(Intent.createChooser(email, "Choose an Email client :"));
 
   }
  });
 }
}


(xml)

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/linearLayout1"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="vertical" >
 
    <TextView
        android:id="@+id/textViewPhoneNo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="To : "
        android:textAppearance="?android:attr/textAppearanceLarge" />
 
    <EditText
        android:id="@+id/editTextTo"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:inputType="textEmailAddress" >
 
        <requestFocus />
 
    </EditText>
 
    <TextView
        android:id="@+id/textViewSubject"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Subject : "
        android:textAppearance="?android:attr/textAppearanceLarge" />
 
    <EditText
        android:id="@+id/editTextSubject"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
         >
    </EditText>
 
    <TextView
        android:id="@+id/textViewMessage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Message : "
        android:textAppearance="?android:attr/textAppearanceLarge" />
 
    <EditText
        android:id="@+id/editTextMessage"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:gravity="top"
        android:inputType="textMultiLine"
        android:lines="5" />

    <ImageView
        android:id="@+id/buttonSend"
        android:layout_width="match_parent"
        android:layout_height="137dp"
        android:src="@drawable/plane" />

    <ImageView
        android:id="@+id/buttonReturn"
        android:layout_width="79dp"
        android:layout_height="match_parent"
        android:src="@android:drawable/ic_media_rew" />
 
</LinearLayout>



```

8. Player 클래스
```
package com.example.shootingprice;

public class Player {
	int pNum;
	int price;
}

```

9. CreateGame 클래스
```
package com.example.shootingprice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

 class AuctionItem{
	String itemNo;
	String itemName;
	String Max, Min;
	String imgPath;

}

public class CreateGame {
	//리터을 위한 ArrayList
	public static ArrayList<AuctionItem> itemList = new ArrayList<AuctionItem>();
	
	//버퍼리더로 받아서 AuctionItem의 리스트를 리턴
    public static ArrayList<AuctionItem> Load(BufferedReader brItem) {
    	itemList.clear();

        try {
			String readLines = "";//한줄 읽어올 변수

            while ((readLines = brItem.readLine()) != null) {
                String[] items = readLines.split("\t");//tab단위로 끊기
                
                AuctionItem item = new AuctionItem();
                item.itemNo = items[0];
                item.itemName = items[1];
                item.Max = items[2];
                item.Min = items[3];
                item.imgPath = items[4];
                
                itemList.add(item);
            
            }
            
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        
        return itemList;
    }
	
}
```

10. CustomGalleryAdapter 클래스
```
package com.example.shootingprice;

import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


//이하 코드는 http://sandyandroidtutorials.blogspot.kr/2013_06_01_archive.html 를 참조, 본인에 맞게 변형한 것임.
public class CustomGalleryAdapter extends BaseAdapter{

	    private Activity context;
	    private static ImageView imageView;
	    private List<Drawable> plotsImages;
	    private static ViewHolder holder;

	    //생성자
	    public CustomGalleryAdapter(Activity context, List<Drawable> plotsImages) {

	        this.context = context;
	        this.plotsImages = plotsImages;

	    }

	    @Override//총 이미지 수 카운트
	    public int getCount() {
	        return plotsImages.size();
	    }

	    @Override
	    public Object getItem(int position) {
	        return null;
	    }

	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }

	    @Override//넘겨지는 갤러리를 보여줌
	    public View getView(int position, View convertView, ViewGroup parent) {

	        if (convertView == null) {

	            holder = new ViewHolder();

	            imageView = new ImageView(this.context);

	            imageView.setPadding(3, 3, 3, 3);

	            convertView = imageView;

	            holder.imageView = imageView;

	            convertView.setTag(holder);

	        } else {

	            holder = (ViewHolder) convertView.getTag();
	        }

	        holder.imageView.setImageDrawable(plotsImages.get(position));

	        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	        holder.imageView.setLayoutParams(new Gallery.LayoutParams(300, 200));

	        return imageView;
	    }

	    //넘겨지는 부분의 작은 이미지를 표현하기 위해서
	    private static class ViewHolder {
	        ImageView imageView;
	    }

	}
```

11. Font(전체 폰트 수정)
```
package com.example.shootingprice;

import java.lang.reflect.Field;
 
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

//이하 코드는 http://app.e-mirim.hs.kr/xe/index.php?mid=board_BTqO41&category=8729&document_srl=8684를 참조. 본인에 맞게 변형한 것.
public class FontApplication extends Application {
    @Override
    public void onCreate() {
        setDefaultFont(this, "DEFAULT", "cosmos.ttf");
        setDefaultFont(this, "SANS_SERIF", "cosmos.ttf");
        setDefaultFont(this, "SERIF", "cosmos.ttf");
    }
     
    public static void setDefaultFont(Context ctx, String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(ctx.getAssets(), fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }
 
    protected static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
        try {
            final Field StaticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);
            StaticField.setAccessible(true);
            StaticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
```


# Resources #
기타 애니메이션 xml, 폰트, 사용된 이미지, apk파일->
http://comp166-koreauniv.googlecode.com/files/resources.zip <br>
인터넷 문제로 못 보여준 PPT -> <a href='http://comp166-koreauniv.googlecode.com/files/Shooting.pptx'>http://comp166-koreauniv.googlecode.com/files/Shooting.pptx</a>


<h1>Screenshot</h1>

<b>Main Title</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_main.png' width='300px' height='450px'><br><br>

<b>How to Play</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_explain.png' width='300px' height='450px'><br><br>

<b>Player Set</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_playerset.png' width='300px' height='450px'><br><br>

<b>Gaming</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_game.png' width='300px' height='450px'><br><br>

<b>Win</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_win.png' width='300px' height='450px'><br><br>

<b>Lose</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_lose.png' width='300px' height='450px'><br><br>

<b>End</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_end.png' width='300px' height='450px'><br><br>

<b>Email</b><br>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_email.png' width='300px' height='450px'>
<img src='http://comp166-koreauniv.googlecode.com/files/sp_selectemail.png' width='300px' height='450px'><br><br>