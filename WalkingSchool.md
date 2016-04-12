# Introduction #

모자 그림을 바탕으로 슬라이딩 게임을 구현했습니다.
총 16개 조각으로 이루어진 모자를 원래 상태로 만드는 게임입니다.

# Details #

  * 기존에 있는 게임을 프로그램을 만든 것입니다

  * 게임실행화면 입니다
<a href='http://www.youtube.com/watch?feature=player_embedded&v=yCKyuNZo51s' target='_blank'><img src='http://img.youtube.com/vi/yCKyuNZo51s/0.jpg' width='425' height=344 /></a>

  * 게임의 메인페이지입니다

http://comp166-koreauniv.googlecode.com/files/main.png/

  * start를 누르면 사진이 섞이고 순서대로 모자 그림을 맞추면 됩니다

http://comp166-koreauniv.googlecode.com/files/play.png/



  * 게임의 메인페이지

package com.example.lastgame;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

> @Override
> protected void onCreate(Bundle savedInstanceState) {
> > super.onCreate(savedInstanceState);
> > setContentView(R.layout.activity\_main);


> ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);

> bt1.setOnClickListener(new OnClickListener()
> {

> @Override
> public void onClick(View v){

> Intent intetn1 = new Intent (MainActivity.this, Puzzleactivity.class); // 게임으로 넘김.
> startActivity(intetn1);
> > }

> });

> }
> > //메인 페이지에서 게임 페이지로 넘기는 버튼입니다.







> @Override
> public boolean onCreateOptionsMenu(Menu menu) {
> > // 아이템 을 액션바에 추가합니다.
> > getMenuInflater().inflate(R.menu.main, menu);
> > return true;

> }

}

  * 메인의 XML

<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
> xmlns:tools="http://schemas.android.com/tools"
> android:id="@+id/AbsoluteLayout1"
> android:layout\_width="match\_parent"
> android:layout\_height="match\_parent"
> android:paddingBottom="@dimen/activity\_vertical\_margin"
> android:paddingLeft="@dimen/activity\_horizontal\_margin"
> android:paddingRight="@dimen/activity\_horizontal\_margin"
> android:background="@drawable/hat"
> android:paddingTop="@dimen/activity\_vertical\_margin"
> tools:context=".MainActivity" >

> <ImageButton
> > android:id="@+id/imageButton1"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_x="77dp"
> > android:layout\_y="310dp"
> > android:src="@drawable/start" />

> // 이미지 버튼을 넣어줍니다.


Unknown end tag for &lt;/AbsoluteLayout&gt;



  * 게임화면의 페이지입니다.

package com.example.lastgame;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
> // android.app.Activity와 android.os.Bundle와 android.view.View와 android.widget.Button를 import합니다.
public class Puzzleactivity extends Activity {

> / Called when the activity is first created. **/
> > @Override
> > public void onCreate(Bundle savedInstanceState) {
> > > super.onCreate(savedInstanceState);
> > > setContentView(R.layout.activity\_puzzleactivity);**


> _buttons[0](0.md)=(Button)findViewById(R.id.Btn01);
>_buttons[1](1.md)=(Button)findViewById(R.id.Btn02);
> _buttons[2](2.md)=(Button)findViewById(R.id.Btn03);
>_buttons[3](3.md)=(Button)findViewById(R.id.Btn04);
> _buttons[4](4.md)=(Button)findViewById(R.id.Btn05);
>_buttons[5](5.md)=(Button)findViewById(R.id.Btn06);
> _buttons[6](6.md)=(Button)findViewById(R.id.Btn07);
>_buttons[7](7.md)=(Button)findViewById(R.id.Btn08);
> _buttons[8](8.md)=(Button)findViewById(R.id.Btn09);
>_buttons[9](9.md)=(Button)findViewById(R.id.Btn10);
> _buttons[10](10.md)=(Button)findViewById(R.id.Btn11);
>_buttons[11](11.md)=(Button)findViewById(R.id.Btn12);
> _buttons[12](12.md)=(Button)findViewById(R.id.Btn13);
>_buttons[13](13.md)=(Button)findViewById(R.id.Btn14);
> _buttons[14](14.md)=(Button)findViewById(R.id.Btn15);
>_buttons[15](15.md)=(Button)findViewById(R.id.Blank);
> //버튼들을 16개 만듭니다.

> for(int i=0;i<15;i++)_buttons[i](i.md).setOnClickListener(On\_Click);_

> ((Button)findViewById(R.id.start)).setOnClickListener(On\_Start);
> }

> private Button[.md](.md)_buttons=new Button[16](16.md);_

> private void do\_swap(Button A, Button B){
> > int Aleft=A.getLeft(); //Aleft를 왼쪽으로 이동하게 지정
> > int Atop=A.getTop(); //Atop를 위쪽으로 이동하게 지정
> > int Aright=A.getRight(); //Aright를 오른쪽으로 이동하게 지정
> > int Abottom=A.getBottom(); //Abottom을 아래로 이동하게 지정
> > A.layout(B.getLeft(), B.getTop(), B.getRight(), B.getBottom());
> > B.layout(Aleft,Atop,Aright,Abottom);

> }

> private boolean do\_width(Button A, Button B){
> > return (A.getLeft()==B.getLeft())&&(Math.abs(A.getTop()-B.getTop())<102);

> }
> private boolean do\_high(Button A, Button B){
> > return (A.getTop()==B.getTop())&&(Math.abs(A.getLeft()-B.getLeft())<102);

> }
> //자리를 바꿉니다.
> private View.OnClickListener On\_Click = new View.OnClickListener() {

> public void onClick(View v) {
> Button Blank = (Button)findViewById(R.id.Blank);
> if(do\_high((Button)v,Blank)||do\_width((Button)v,Blank))do\_swap((Button)v,Blank);

> }
> }; //blank와 위치를 바꿉니다.

> private View.OnClickListener On\_Start = new View.OnClickListener() {

> public void onClick(View v) {
> int x,y;
> for(y=0;y<4;y++){
> > for(x=0;x<4;x++){
> > > _buttons[y\*4+x].layout((x\*100)+40,(y\*100)+50,x\*100+140,y\*100+150);

> > }

> }
> Random_Random = new Random();// 랜덤으로 배열을 하게 합니다.
> for(int i=0;i<1000;i++)On\_Click.onClick(_buttons[_Random.nextInt(15)]);
> }
> };

}

  * 퍼즐액티비티의 XML

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
> android:orientation="vertical"
> android:layout\_width="fill\_parent"
> android:layout\_height="fill\_parent">

<LinearLayout
> android:id="@+id/Layout01"
> android:layout\_width="fill\_parent"
> android:layout\_height="wrap\_content">
<Button
> > android:text="start"

> android:id="@+id/start"
> > android:layout\_width="100px"
> > android:layout\_height="100px"

> android:layout\_weight="1"
> > android:textSize="20sp">

Unknown end tag for &lt;/Button&gt;

 // start버튼입니다. 랜덤으로 그림을 섞어주는 버튼입니다.


Unknown end tag for &lt;/LinearLayout&gt;



<AbsoluteLayout

> android:id="@+id/Layout02"
> android:layout\_height="fill\_parent"
> android:layout\_width="fill\_parent">

<Button
> android:background="@drawable/a1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="40px"
> android:layout\_y="50px"
> android:id="@+id/Btn01">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/b1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="140px"
> android:layout\_y="50px"
> android:id="@+id/Btn02">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/c1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="240px"
> android:layout\_y="50px"
> android:id="@+id/Btn03">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/d1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="340px"
> android:layout\_y="50px"
> android:id="@+id/Btn04">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/e1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="40px"
> android:layout\_y="150px"
> android:id="@+id/Btn05">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/f1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="140px"
> android:layout\_y="150px"
> android:id="@+id/Btn06">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/g1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="240px"
> android:layout\_y="150px"
> android:id="@+id/Btn07">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/h1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="340px"
> android:layout\_y="150px"
> android:id="@+id/Btn08">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/i1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="40px"
> android:layout\_y="250px"
> android:id="@+id/Btn09">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/j1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="140px"
> android:layout\_y="250px"
> android:id="@+id/Btn10">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/k1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="240px"
> android:layout\_y="250px"
> android:id="@+id/Btn11">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/l1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="340px"
> android:layout\_y="250px"
> android:id="@+id/Btn12">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/m1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="40px"
> android:layout\_y="350px"
> android:id="@+id/Blank">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/n1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="140px"
> android:layout\_y="350px"
> android:id="@+id/Btn13">

Unknown end tag for &lt;/Button&gt;


<Button
> android:background="@drawable/o1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="240px"
> android:layout\_y="350px"
> android:id="@+id/Btn14">

Unknown end tag for &lt;/Button&gt;



<Button
> android:background="@drawable/p1"
> android:layout\_height="100px"
> android:layout\_width="100px"
> android:layout\_x="340px"
> android:layout\_y="350px"
> android:id="@+id/Btn15">

Unknown end tag for &lt;/Button&gt;


> // 그림들을 버튼에 맞게 하자씩 지정합니다. 그림의 있는 빈칸도 버튼으로 지정해 줍니다.

## 참조 ##

어플의 양식을 참조했습니다.

http://ryulib.tistory.com/149 - 이해하기 힘들어서 기본적인 개념만 참조
http://ryulib.tistory.com/category/Android
http://www.androidside.com/data/file/422/1889249123_n3GdBwCW_B0D4C0D3C0B8B7CE_B9E8BFECB4C2_BEC8B5E5B7CEC0CCB5E5_232.pdf ( 이해하기 힘들어서 기본적인 개념만 참조)
http://www.happycampus.com/doc/11290987

## 어플의 APK파일입니다 ##
http://comp166-koreauniv.googlecode.com/files/puzzl (2).zip/



Unknown end tag for &lt;/AbsoluteLayout&gt;




Unknown end tag for &lt;/LinearLayout&gt;

