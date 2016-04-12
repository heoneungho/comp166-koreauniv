### 목차 ###


![http://comp166-koreauniv.googlecode.com/files/unnamed.png](http://comp166-koreauniv.googlecode.com/files/unnamed.png)

### 기숙사 식당을 이용하는 학생들을 위한 어플, ###
## **"안암학사에서 밥먹자" 완성!!** ##



---


# Introduction & Background #
**고려대학교 기숙사 생활에 있어서, 기숙사 식당을 많이 이용하고 있습니다.
한학기 동안 기숙사 식당을 이용하면서 겪었던 불편함들을 개선하는 프로그램을 만들 계획입니다.**

_불편했던 점, 개선하고 싶은 점._
  1. 현재 기숙사 식당 메뉴게시 사이트가 있다고는 하나, 핸드폰이 이상한건지 오류가 나서 이용하지 못했다.   모두가 메뉴를 편리하게 볼 수 있는 프로그램이 필요하다.
  1. 개인마다 한 학기동안 신청한 식사 수가 다르다. (A-200식, B-160식, C-120식)   그렇기 때문에 얼만큼 먹었는지, 앞으로 얼마나 이용 가능한지 조절이 필요하다.   하지만 식당에서 카드를 찍고 들어갈 때에만 이용한 식사수를 알기 때문에 굉장히 불편하다.   항상 어디에서든지 미리 남은 식수를 확인하는 것이 필요하다.
  1. 학생들의 건의사항에 귀기울이고 개선하려는 노력은 만족하고 있으나, 만약 스마트폰으로 건의사항을 보낼 수 있는 기능이 생긴다면 보다 원활한 소통이 이루어 질 것이라 기대한다.



---



# Details #

**기숙사식당 개인관리 프로그램**

![http://comp166-koreauniv.googlecode.com/files/어플ui.png](http://comp166-koreauniv.googlecode.com/files/어플ui.png)

1. 공지사항
  * 기숙사 식당을 이용하는데 필요한 정보들이 담긴 이미지를 보여주는 기능

2. 오늘의 메뉴
  * 한 주 동안의 메뉴와 칼로리를 보여주는 기능

3. 개인 식수 관리
  * 이용한 식사 수, 한 달 동안 남은 식수, 남은 기간을 바로 보여주는 기능

4. 건의사항
  * 학생이 건의사항을 작성하면 바로 관리자에게 이메일을 보내는 기능



---


# UI & Code #

## class ##

![http://comp166-koreauniv.googlecode.com/files/클래스.png](http://comp166-koreauniv.googlecode.com/files/클래스.png)

클래스는 총 6개입니다.

  1. 메인화면 - MainActivity
  1. 메뉴화면 - Information
  1. 공지사항 - Inform
  1. 오늘의메뉴 - Food
  1. 개인식수 - Number
  1. 건의사항 - Talk


---

## 1. 메인화면 ##

메인페이지 전체를 클릭하면 메뉴화면으로 이동합니다.

![http://comp166-koreauniv.googlecode.com/files/main.jpg](http://comp166-koreauniv.googlecode.com/files/main.jpg)

(깨알 만든이 ↑ ®Guni(거니)라고 적어봤는데 짤렸네요..ㅠㅠ 그냥그렇다구요..)

MainActivity.java
```
package com.example.anamdorm_food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView button = (ImageView) findViewById(R.id.imageView1);
                // 배경전체를 이미지뷰로 넣어 다음화면 이동을 위한 버튼으로 설정하였습니다.
		button.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        		Log.i("onClick","Information");
	                Intent intent = new Intent(getBaseContext(), Information.class);
	                startActivity(intent);
	        }
	}); //클릭하면 Information 클래스로 넘어갑니다.
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
    android:layout_height="match_parent"
    android:gravity="top"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1.32"
        android:scaleType="fitXY"
        android:src="@drawable/main" /> //파워포인트를 이용하여 이미지를 만들고, 이미지뷰를 사용하여 넣었습니다.

</LinearLayout>
```



---

## 2. 메뉴화면 ##

각각의 이미지 버튼을 클릭하면 해당하는 기능의 페이지로 이동하게 됩니다.

![http://comp166-koreauniv.googlecode.com/files/두번째메인.jpg](http://comp166-koreauniv.googlecode.com/files/두번째메인.jpg)

Information.java
```
package com.example.anamdorm_food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class Information extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);
		
		ImageButton button1 = (ImageButton) findViewById(R.id.imageButton1);
		button1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	                Intent intent = new Intent(getBaseContext(), Inform.class);
	                startActivity(intent);
	        }}); //button1을 클릭하면 Inform 클래스(공지사항)로 넘어갑니다.
		
		ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
		button2.setOnClickListener(new View.OnClickListener() { 
	        public void onClick(View v) {
	                Intent intent = new Intent(getBaseContext(), Food.class);
	                startActivity(intent);
	        }}); //button2를 클릭하면 Food 클래스(오늘의메뉴)로 넘어갑니다.
		
		ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
		button3.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	                Intent intent = new Intent(getBaseContext(), Number.class);
	                startActivity(intent);
	        }}); //button3을 클릭하면 Number 클래스(개인식수)로 넘어갑니다.
		
		ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
		button4.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	                Intent intent = new Intent(getBaseContext(), Talk.class);
	                startActivity(intent);
	        }}); //button4를 클릭하면 Talk 클래스(건의사항)로 넘어갑니다.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.information, menu);
		return true;
	}

}
```

activity\_information.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="top"
    tools:context=".Information" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scaleType="fitXY"
        android:src="@drawable/information" />

    <ImageButton
        android:id="@+id/imageButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/imageButton1"
        android:layout_marginLeft="30dp"
        android:layout_toRightOf="@+id/imageButton1"
        android:src="@drawable/menu" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_centerVertical="true"
        android:layout_marginLeft="51dp"
        android:src="@drawable/infor" />

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton1"
        android:layout_below="@+id/imageButton1"
        android:layout_marginTop="22dp"
        android:src="@drawable/number" />

    <ImageButton
        android:id="@+id/imageButton4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/imageButton3"
        android:layout_alignLeft="@+id/imageButton2"
        android:src="@drawable/talk" />

</RelativeLayout>
```


---

## 3. 공지사항 ##

기숙사 식당을 이용하는데 필요한 기본 공지사항들이 담긴 이미지를 제공합니다.
(식당위치, 운영시간, 이용방법 등)

![http://comp166-koreauniv.googlecode.com/files/공지사항.jpg](http://comp166-koreauniv.googlecode.com/files/공지사항.jpg)

Inform.java
```
package com.example.anamdorm_food;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Inform extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inform);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inform, menu);
		return true;
	}

}
```

activity\_inform.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:background="#980000"         // 배경화면의 색깔을 자랑스러운 고려대학교의 상징 크림슨 색으로 바꿔줍니다.
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/LinearLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Inform" >

    <TextView
        android:textSize="50sp"      //제목에 걸맞게 글씨의 크기를 아주 크게 바꾸어줍니다.
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="공지사항"
        android:textAppearance="?android:attr/textAppearanceLarge" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scaleType="fitXY"
        android:src="@drawable/ourhome_co_kr_20131202_223707" />

</LinearLayout>
```


---

## 4. 오늘의 메뉴 ##

웹뷰를 이용하여 일주일의 기숙사 식단 메뉴를 보여주는 사이트를 바로 보여줍니다.
또한 확대와 축소가 가능하여 자세히 볼 수 있습니다.

![http://comp166-koreauniv.googlecode.com/files/오늘의메뉴.jpg](http://comp166-koreauniv.googlecode.com/files/오늘의메뉴.jpg)

Food.java

```
package com.example.anamdorm_food;

import android.os.Bundle;
import android.webkit.*;
import android.app.Activity;
import android.view.Menu;

public class Food extends Activity {

	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food);
	
		webView = (WebView)findViewById(R.id.webView1);
		
		WebSettings webSettings = webView.getSettings();
		webSettings.setUseWideViewPort(true);
		webSettings.setSupportZoom(true);
		webSettings.setBuiltInZoomControls(true);
                // 줌 기능이 가능하게 됩니다.
		webSettings.setJavaScriptEnabled(true);
		

		String url = "http://koreadorm.ourhome.co.kr/sub/menu.htm?ptype=view&idx=6497&page=1&code=menu";
		webView.loadUrl(url);
	} // 지정한 사이트의 화면을 보여줍니다.

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food, menu);
		return true;
	}

}

```

activity\_food.xml

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:background="#980000"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Food" >

     <TextView
        android:textSize="50sp"
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="오늘의 메뉴"
        android:textAppearance="?android:attr/textAppearanceLarge" />

     <WebView
         android:id="@+id/webView1"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:layout_alignParentLeft="true"
         android:layout_below="@+id/textView1" />
    
</RelativeLayout>
```

_출처 : 채정님 교수님 도움_


---

## 5. 개인식수 ##

이 어플에서 가장 중요하고 필요하다고 생각하는 기능으로, 자신이 한달동안 먹었던 식사 횟수를 기록할 수 있습니다.

식사를 하고 횟수를 입력하면 내부 저장 공간에 저장이 되고, 개인식수확인 버튼을 클릭하면 가장 최근에 입력하였던 숫자가 출력됩니다.

내부 저장 공간에 저장하기 때문에 어플을 종료하고 다시 실행하여도 최근에 입력하였던 숫자는 계속 출력이 가능하게 됩니다.

즉, 메모장과 비슷하게 사용하시면 됩니다.

![http://comp166-koreauniv.googlecode.com/files/개인식수.jpg](http://comp166-koreauniv.googlecode.com/files/개인식수.jpg)
![http://comp166-koreauniv.googlecode.com/files/개인식수2.jpg](http://comp166-koreauniv.googlecode.com/files/개인식수2.jpg)
![http://comp166-koreauniv.googlecode.com/files/개인식수3.jpg](http://comp166-koreauniv.googlecode.com/files/개인식수3.jpg)

Number.java

```
package com.example.anamdorm_food;

import java.io.FileInputStream;
import java.io.FileOutputStream;
 
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Number extends Activity {
 
	 static final String FILE_NAME = "exam.txt";     // 사용자가 입력을 하면 내부 저장 공간에 exam.txt라는 파일이 생성됩니다.
	    EditText edit1, edit2;
	    Button btnWrite, btnRead;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_number);
	        edit1 = (EditText) findViewById(R.id.text1); // 쓰기용의 EditText 뷰 입니다.
	        edit2 = (EditText) findViewById(R.id.text2); // 읽기용의 EditText 뷰 입니다.
	        btnWrite = (Button) findViewById(R.id.btn1);
	        btnRead = (Button) findViewById(R.id.btn2);
	 
	        btnWrite.setOnClickListener(new OnClickListener() {
	 
	            @Override
	            public void onClick(View v) {
	                try {
	 
	                    FileOutputStream fos = openFileOutput(FILE_NAME,
	                            Context.MODE_PRIVATE); 
         // 혼자만 사용하는 배타적모드의 파일을 생성하는 것으로, 기본으로 설정되있는 파일생성모드입니다.

	                    String str = edit1.getText().toString();
	                    fos.write(str.getBytes()); // //입력받은 내용(text)을 바이트 단위로 파일에 씁니다.
	                    fos.close();
	 
	                } catch (Exception e) {
	                    Log.e("File", "에러=" + e);
	                }
	 
	            }// onClick
	        });
	        btnRead.setOnClickListener(new OnClickListener() {
	 
	            @Override
	            public void onClick(View v) {
	                try {
  // 위에서 설정하였던 파일이름을 인수로 openFileInput()을 호출합니다. 이 메소드는 FileInputStream객체를 반환합니다.
	                    FileInputStream fis = openFileInput(FILE_NAME);
	                    byte[] buffer = new byte[fis.available()];
	                    fis.read(buffer);
	                    String str = new String(buffer);
	                    edit2.setText(str);   // edit2 뷰에 읽어온 값을 출력합니다.
	                    fis.close();   //파일 입력 스트림을 닫습니다.
	                   
	                } catch (Exception e) {
	                    Log.e("File", "에러=" + e);
	                }
	 
	            }
	        });
	 
	    }// onCreate
}

```

activity\_number.xml

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#980000"
    android:orientation="vertical" >
   
     <TextView
        android:textSize="50sp"
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="개인식수"
        android:textAppearance="?android:attr/textAppearanceLarge" />
    
 
    <EditText
       android:id="@+id/text1"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:hint="이번달 먹은 횟수를 입력하세요" />
 
    <Button
       android:id="@+id/btn1"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:text="입력하기" />
 
    <Button
       android:id="@+id/btn2"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:text="개인 식수 확인" />
    
    <EditText
       android:id="@+id/text2"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
        />

</LinearLayout>
```

_출처 : [내부저장공간에 파일읽기쓰기 블로그 코드 참조](http://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140179563086&categoryNo=67&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=)_
_/ [파일 스토리지에 대한 이해](http://javaking75.blog.me/140179562089)_
_/ 교수님이 제공하신 안드로이드 코드조각_

---

## 6. 건의사항 ##

기숙사 식당을 이용하면서 불편한 점이나 개선하고 싶은 점을 이메일을 통하여 바로 관리자에게 의견을 보낼 수 있습니다.

(일단은 제이메일을 기본으로 설정하였습니다.)

관리자의 이메일은 기본으로 설정되어 있고, 제목과 내용을 입력하여 보내기를 클릭하면 gmail을 이용하여 보내실 수 있습니다.

![http://comp166-koreauniv.googlecode.com/files/건의사항.jpg](http://comp166-koreauniv.googlecode.com/files/건의사항.jpg)
![http://comp166-koreauniv.googlecode.com/files/건의사항2.jpg](http://comp166-koreauniv.googlecode.com/files/건의사항2.jpg)
![http://comp166-koreauniv.googlecode.com/files/건의사항3.jpg](http://comp166-koreauniv.googlecode.com/files/건의사항3.jpg)

Talk.java
```
package com.example.anamdorm_food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;

public class Talk extends Activity {
 
 Button ButtonSend;
 EditText textTo;
 EditText textSubject;
 EditText textMessage;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_talk);
  
  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
  StrictMode.setThreadPolicy(policy); 
 
  textTo = (EditText) findViewById(R.id.editTextTo);
  textSubject = (EditText) findViewById(R.id.editTextSubject);
  textMessage = (EditText) findViewById(R.id.editTextMessage);
  // 각각 받는이, 제목, 내용을 입력하는 EditText 뷰입니다.
  
  //send button
  ButtonSend = (Button) findViewById(R.id.buttonSend);
  ButtonSend.setOnClickListener(new OnClickListener() {
 
   @Override
   public void onClick(View v) {
 
     String to = textTo.getText().toString();
     String subject = textSubject.getText().toString();
     String message = textMessage.getText().toString();
     // 각각 입력값을 받습니다.
 
     Intent email = new Intent(Intent.ACTION_SEND);
     email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
     //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
     //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
     email.putExtra(Intent.EXTRA_SUBJECT, subject);
     email.putExtra(Intent.EXTRA_TEXT, message);
      
     // 이메일 전송하는 기능을 위해, 이미 존재하는 이메일 클라이언트를 호출하는 Intent.ACTION_SEND 를 사용하였습니다.
 
     //need this to prompts email client only
     email.setType("message/rfc822");
 
     startActivity(Intent.createChooser(email, "Choose an Email client :"));
 
   }
  });
 }
}
```

activity\_talk.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/linearLayout1"
    android:background="#980000"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="vertical" >
    
     <TextView
        android:textSize="50sp"
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="건의사항"
        android:textAppearance="?android:attr/textAppearanceLarge" />
    
 
    <TextView
        android:id="@+id/textViewPhoneNo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="받는이 : "
        android:textAppearance="?android:attr/textAppearanceLarge" />
 
    <EditText
        android:id="@+id/editTextTo"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:hint="k01074467721@gmail.com"    // 관리자의 이메일 주소를 기본으로 설정해 주었습니다.
        android:inputType="textEmailAddress" >
 
        <requestFocus />
 
    </EditText>
 
    <TextView
        android:id="@+id/textViewSubject"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="제목 : "
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
        android:text="내용 : "
        android:textAppearance="?android:attr/textAppearanceLarge" />
 
    <EditText
        android:id="@+id/editTextMessage"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:gravity="top"
        android:inputType="textMultiLine"
        android:lines="5" />
    
   <Button
        android:id="@+id/buttonSend"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="보내기" />

   <TextView
       android:id="@+id/textView2"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="*여러분의 소리에 귀기울입니다."
       android:textAppearance="?android:attr/textAppearanceLarge" />
   
</LinearLayout>
```

_출처 : [안드로이드 이메일보내기 블로그 코드 참조](http://blog.naver.com/PostView.nhn?blogId=junhwen&logNo=130151732452&categoryNo=86&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=&userTopListOpen=true&userTopListCount=5&userTopListManageOpen=false&userTopListCurrentPage=1)_
_/ [구글에서 gmail이용한 메일보내기 블로그 참조](http://mainia.tistory.com/506)_



---

# 출처 #

출처는 각 코드마다 밑에 써놓았습니다. (기울기 글씨체로 적힌 부분)



---

# 동영상 #

저번 최종 발표시간 이후에 추가된 기능(개인식수, 건의사항)이 있어서 동영상을 추가로 촬영하였습니다. 추가된 기능 뿐만 아니라 이 어플리케이션의 전반적인 기능을 모두 소개하는 동영상입니다.

<a href='http://www.youtube.com/watch?feature=player_embedded&v=1It66-jxVtk' target='_blank'><img src='http://img.youtube.com/vi/1It66-jxVtk/0.jpg' width='425' height=344 /></a>


---

# APK 파일 #

최종 완성 어플리케이션입니다.

클릭하시면 apk파일을 다운로드 하실 수 있습니다.

**http://comp166-koreauniv.googlecode.com/files/AnamDorm_food[1].apk**