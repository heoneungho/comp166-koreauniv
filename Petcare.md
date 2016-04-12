# Introduction #

![http://comp166-koreauniv.googlecode.com/files/cat.jpg](http://comp166-koreauniv.googlecode.com/files/cat.jpg)

애완동물을 키우는 사람들을 위한 앱이다. 보통 사람들은 애완동물을 키우다 보면 자신의 할 일 때문에 자신의 애완동물에 소홀해질 때가 있다. 이것을 대비한 아주 간단하지만 매우 간편하고 편리한 어플이다.


# Details #

1. 애완동물에는 여러가지의 종류가 있다. 고양이, 개, 토끼, 금붕어, 햄스터, 기니피그, 고슴도치, 이구아나, 거북이 등이 대표적이다. 이 중에 대표적인 6가지 애완동물 즉, 고양이, 개, 햄스터, 물고기, 거북이, 새 중에 1마리를 선택을 하여 사진을 누른다.

2. 적은 애완동물의 필요한 정보들이나 유익한 정보들을 알려준다. 예를 들어 개들에게는 어떠한 사료가 좋은지, 기니피그들은 어떠한 우리을 만드는 것이 좋은지 등이다.

3. 또한 알람 기능도 갖추고 있다. 그 애완동물이 인간의 손길이 필요할 때를 맞춰 알람을 울려준다. 예를 들어 애완동물들이 사료를 필요할 때를 맞춰 알람이 울리거나, 개들이 산책이 필요할 때나, 애완동물들이 대소변을 봐야할 때 등이다.

# Project #


# Main #


메인 화면에서 'Welcome!'이라는 버튼을 누르고 어플으로 들어간다!
위에 'A pet can change your life. Adopt one.'이라는 문구가 있다. 이처럼 애완동물들을 기르라는 메세지를 담긴 어플이라는 것을 확인할 수 있다.


http://comp166-koreauniv.googlecode.com/files/nakmain.PNG


● xml


```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:scaleType="fitXY"
        android:src="@drawable/back" />

    <TextView
        android:id="@+id/txt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="99dp"
        android:text="@string/txt"
        android:textAppearance="?android:attr/textAppearanceLarge" />

    <Button
        android:id="@+id/main"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="111dp"
        android:text="@string/main" />

</RelativeLayout>
```


● java

```
package com.example.petworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button1 = (Button)findViewById(R.id.main);
        button1.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), ListActivity.class);
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


# List #


6가지 동물들의 사진들이 있다(고양이, 강아지, 햄스터, 물고기, 거북이, 새). 가장 대표적인 6가지 애완동물들이다. 이 6가지 애완동물 중 자신이 기르는 애완동물의 사진을 누르면 그 애완동물에 관한 정보들이 있는 화면으로 갈 수 있다.


http://comp166-koreauniv.googlecode.com/files/naklist.PNG


● xml

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".ListActivity" >

    <ImageView
        android:id="@+id/Cat"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentTop="true"
        android:layout_marginLeft="30dp"
        android:layout_marginTop="45dp"
        android:src="@drawable/a" />

    <ImageView
        android:id="@+id/Dog"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/Cat"
        android:layout_alignRight="@+id/Cat"
        android:layout_below="@+id/Cat"
        android:src="@drawable/b" />

    <ImageView
        android:id="@+id/Hamster"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/Dog"
        android:layout_alignRight="@+id/Dog"
        android:layout_below="@+id/Dog"
        android:src="@drawable/c" />

    <ImageView
        android:id="@+id/Fish"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_marginTop="33dp"
        android:layout_toRightOf="@+id/Cat"
        android:src="@drawable/d" />

    <ImageView
        android:id="@+id/Turtle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/Fish"
        android:layout_below="@+id/Fish"
        android:src="@drawable/e" />

    <ImageView
        android:id="@+id/Bird"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/Turtle"
        android:layout_below="@+id/Turtle"
        android:layout_marginTop="15dp"
        android:src="@drawable/f" />

</RelativeLayout>
```


● java

```
package com.example.petworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
	
		ImageView button1 = (ImageView)findViewById(R.id.Cat);
        button1.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Cat.class);
        		startActivity(intent);        	
        	}
        });
        
        ImageView button2 = (ImageView)findViewById(R.id.Dog);
        button2.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Dog.class);
        		startActivity(intent);        	
        	}
        });
        
        ImageView button3 = (ImageView)findViewById(R.id.Hamster);
        button3.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Hamster.class);
        		startActivity(intent);        	
        	}
        });
        
        ImageView button4 = (ImageView)findViewById(R.id.Fish);
        button4.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Fish.class);
        		startActivity(intent);        	
        	}
        });
        
        ImageView button5 = (ImageView)findViewById(R.id.Turtle);
        button5.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Turtle.class);
        		startActivity(intent);        	
        	}
        });
        
        ImageView button6 = (ImageView)findViewById(R.id.Bird);
        button6.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Bird.class);
        		startActivity(intent);        	
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

}
```



이제 List 페이지에서 동물들의 사진을 누르게 되면 그 동물에 관한 정보들이 써져 있는 화면으로 가게 된다.


예를 들어 고양이를 눌렀을 때를 보여주겠다.


# Cat #

http://comp166-koreauniv.googlecode.com/files/catpage.PNG


● xml

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Cat" >

   
	<EditText
        android:id="@+id/cattxt1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/cattxt2"
        android:layout_centerHorizontal="true"
        android:ems="10"
        android:inputType=""
        android:text="@string/cattxt1" >
        
       
    </EditText>
    
   
   <EditText
        android:id="@+id/cattxt2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/cattxt3"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_alignRight="@+id/imageView1"
        android:ems="10"
        android:inputType=""
        android:text="@string/cattxt2" />
   
    <EditText
        android:id="@+id/cattxt3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/cattxt4"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_alignRight="@+id/imageView1"
        android:ems="10"
        android:inputType=""
        android:text="@string/cattxt3" />
   
    <EditText
        android:id="@+id/cattxt4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/cattxt5"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_alignRight="@+id/imageView1"
        android:ems="10"
        android:inputType=""
        android:text="@string/cattxt4" />
 
    <EditText
        android:id="@+id/cattxt5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/cattxt6"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_alignRight="@+id/imageView1"
        android:ems="10"
        android:inputType=""
        android:text="@string/cattxt5" />
        
    <EditText
        android:id="@+id/cattxt6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/cattxt7"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_alignRight="@+id/imageView1"
        android:ems="10"
        android:inputType=""
        android:text="@string/cattxt6" />

   <EditText
        android:id="@+id/cattxt7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/Catinfo"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_alignRight="@+id/imageView1"
        android:layout_marginBottom="32dp"
        android:ems="10"
        android:inputType=""
        android:text="@string/cattxt7" />



    <Button
        android:id="@+id/Catinfo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="34dp"
        android:text="@string/catinfo" />

 
 	<ImageView
        android:id="@+id/imageView1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:alpha="0.5"
        android:scaleType="fitXY"
        android:src="@drawable/cat" />
 

    

</RelativeLayout>
```


● java

```
package com.example.petworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Cat extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cat);
	
		ImageView button1 = (ImageView)findViewById(R.id.Catinfo);
        button1.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Catinfo.class);
        		startActivity(intent);        	
        	}
        });
       
        ImageView button2 = (ImageView)findViewById(R.id.cattxt1);
        button2.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(getApplicationContext(), Textcat.class);
        		startActivity(intent);        	
        	}
        });  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cat, menu);
		return true;
	}

}
```


이러한 화면이 뜨게된다. 그 후 자세한 내용을 알아보기 위해서는 텍스트 중 가장 위에 있는 텍스트를 누르면 그 동물에 관한 더 자세한 내용이 나온다. 또한 밥 먹는 시간을 알고 알람을 맞추기 위해서는 밑에 있는 'Feeding Time'이라는 버튼을 누르면 된다. 그 버튼을 누르면 새로운 화면이 나오고 시간을 입력하면 각각 동물에 알맞게 몇시간 뒤에 알람이 울리게 된다.


# 출처 #

버튼 등의 대부분 소스는 이 사이트에서 알게 되었다.

http://blog.naver.com/sks6624?Redirect=Log&logNo=150175324199