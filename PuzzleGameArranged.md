# Introduction #

Add your content here.

자 그림 퍼즐을 완성시켜봅시다.

# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages

우선, 그림을 준비합니다. 그리고 칸을 나눔니다 ...

4x4로 설정하겠습니다.

그리고 x축 y축 대각선 / 방향으로 클릭 기능을 설정합니다.

클릭을 하면 그 라인은 뒤집히구요 ..

그래서 임의로 뒤집힌 퍼즐조각을 완성시키면 되는 게임!

ex.)
그림 원본 ○●
(row1)●●●●●
(row2)●●●●●
(row3)●●●●●
(row4)●●●●●
(row5)●●●●●
> 5x5입니다.

그럼 게임을 시작하면 임의로 퍼즐조각을 뒤집습니다.

(row1)●○○●○
(row2)●○●●○
(row3)●○○○○
(row4)○●●●○
(row5)●○●○○

이렇게 되겠죠 .
row 1 을 클릭하면

(row1)○●●○● <<< 이렇게 뒤집어 지네요
(row2)●○●●○
(row3)●○○○○
(row4)○●●●○
(row5)●○●○○

버튼 설명.

뒤집는 버튼에 대해서 설명해보겠습니다.

크게 row, column, diagonal이 있습니다.

1. row클릭 시 그 row의 모든 퍼즐 조각을 뒤집습니다.

2. column 클릭 시 그 column의 모든 퍼즐 조각을 뒤집습니다.

3. diagonal 클릭 시 그 diagonal 상의 모든 퍼즐 조각을 뒤집습니다.

머리를 써서 이리 클릭 ! 저리 클릭 !

해서 완성된 그림을 만들면 됩니다 ! Success!!


So Simple.
1. 실행을 해봅시다.

![http://comp166-koreauniv.googlecode.com/files/mainfinish.jpg](http://comp166-koreauniv.googlecode.com/files/mainfinish.jpg)

이렇게 나옵니다. 스타트를 누르면!?

2. 짠 ~

![http://comp166-koreauniv.googlecode.com/files/before.jpg](http://comp166-koreauniv.googlecode.com/files/before.jpg)

랜덤으로 색칠된 별과 색칠이 되지 않은 별들이 나옵니다. 우리의 목표는?!
그렇죠 모든 별을 색칠해봅시다.

3. 이해를 돕기 위해 왼쪽 상단의 버튼을 눌러봅시다.

![http://comp166-koreauniv.googlecode.com/files/after.jpg](http://comp166-koreauniv.googlecode.com/files/after.jpg)

짜잔! 그랬더니 그 쪽 row가 전부 반전이 되었군요 !! 아하 ! 버튼은 그런 의미구나 ...good!

4. 이거저거 누르다 완성이 되면 ? ( 종료 창 넘어가기 전의 순간을 찍은 사진 ! 놀라운 순발력 )

![http://comp166-koreauniv.googlecode.com/files/complete.jpg](http://comp166-koreauniv.googlecode.com/files/complete.jpg)

5. 님 이김 ㅋ

![http://comp166-koreauniv.googlecode.com/files/end.jpg](http://comp166-koreauniv.googlecode.com/files/end.jpg)

버튼을 누르면 다시 메인으로 넘어갑니다.

6. 요로케

![http://comp166-koreauniv.googlecode.com/files/mainfinish.jpg](http://comp166-koreauniv.googlecode.com/files/mainfinish.jpg)


-------코드--------------------

1. MainActivity :: 시작 화면

package com.example.pjh3390;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

> @Override
> protected void onCreate(Bundle savedInstanceState) {
> > super.onCreate(savedInstanceState);
> > setContentView(R.layout.activity\_main);


> StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
> StrictMode.setThreadPolicy(policy);


> Button button = (Button) findViewById(R.id.button1);
> button.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > Intent intent = new Intent(getBaseContext(), GameActivity.class);
> > > startActivity(intent);

> > }

> });
> }

> @Override
> public boolean onCreateOptionsMenu(Menu menu) {
> > // Inflate the menu; this adds items to the action bar if it is present.
> > getMenuInflater().inflate(R.menu.main, menu);
> > return true;

> }

}

2. GameActivity :: 게임 설정 // 각각의 칸에 랜덤으로 배치해서 row column diagonal 버튼을 만들어서 문제 해결할 수 있게 설정

package com.example.pjh3390;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class GameActivity extends Activity {

> Button button1;
> Button button2;
> Button button3;
> Button button4;
> Button button5;
> Button button6;
> Button button7;
> Button button8;
> Button button9;

> ToggleButton tbutton1;
> ToggleButton tbutton2;
> ToggleButton tbutton3;
> ToggleButton tbutton4;
> ToggleButton tbutton5;
> ToggleButton tbutton6;
> ToggleButton tbutton7;
> ToggleButton tbutton8;
> ToggleButton tbutton9;
> ToggleButton tbutton10;
> ToggleButton tbutton11;
> ToggleButton tbutton12;
> ToggleButton tbutton13;
> ToggleButton tbutton14;
> ToggleButton tbutton15;
> ToggleButton tbutton16;
> @Override
> protected void onCreate(Bundle savedInstanceState) {
> > super.onCreate(savedInstanceState);
> > setContentView(R.layout.activity\_game);


> button1 = (Button) findViewById(R.id.button1);
> button2 = (Button) findViewById(R.id.button2);
> button3 = (Button) findViewById(R.id.button3);
> button4 = (Button) findViewById(R.id.button4);
> button5 = (Button) findViewById(R.id.button5);
> button6 = (Button) findViewById(R.id.button6);
> button7 = (Button) findViewById(R.id.button7);
> button8 = (Button) findViewById(R.id.button8);
> button9 = (Button) findViewById(R.id.button9);

> tbutton1 = (ToggleButton) findViewById(R.id.toggleButton1);
> tbutton2 = (ToggleButton) findViewById(R.id.toggleButton2);
> tbutton3 = (ToggleButton) findViewById(R.id.toggleButton3);
> tbutton4 = (ToggleButton) findViewById(R.id.toggleButton4);
> tbutton5 = (ToggleButton) findViewById(R.id.toggleButton5);
> tbutton6 = (ToggleButton) findViewById(R.id.toggleButton6);
> tbutton7 = (ToggleButton) findViewById(R.id.toggleButton7);
> tbutton8 = (ToggleButton) findViewById(R.id.toggleButton8);
> tbutton9 = (ToggleButton) findViewById(R.id.toggleButton9);
> tbutton10 = (ToggleButton) findViewById(R.id.toggleButton10);
> tbutton11 = (ToggleButton) findViewById(R.id.toggleButton11);
> tbutton12 = (ToggleButton) findViewById(R.id.toggleButton12);
> tbutton13 = (ToggleButton) findViewById(R.id.toggleButton13);
> tbutton14 = (ToggleButton) findViewById(R.id.toggleButton14);
> tbutton15 = (ToggleButton) findViewById(R.id.toggleButton15);
> tbutton16 = (ToggleButton) findViewById(R.id.toggleButton16);


> StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
> > .permitAll().build();

> StrictMode.setThreadPolicy(policy);



> // 총 5번안에 해결가능 한 10문제를 제시.
> button1.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton4.performClick();
> > > tbutton8.performClick();
> > > tbutton12.performClick();
> > > tbutton16.performClick();


> check();

> }
> }); // column 4를 클릭시킨다.

> button2.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton3.performClick();
> > > tbutton7.performClick();
> > > tbutton11.performClick();
> > > tbutton15.performClick();


> check();

> }
> }); // column 3을 클릭시킨다.

> button3.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton2.performClick();
> > > tbutton6.performClick();
> > > tbutton10.performClick();
> > > tbutton14.performClick();


> check();

> }
> }); // column 2를 클릭시킨다.

> button4.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton1.performClick();
> > > tbutton5.performClick();
> > > tbutton9.performClick();
> > > tbutton13.performClick();


> check();
> }
> }); // column 1을 클릭시킨다.

> button5.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton1.performClick();
> > > tbutton6.performClick();
> > > tbutton11.performClick();
> > > tbutton16.performClick();


> check();
> }
> }); // 대각선을 클릭시킨다.

> button6.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton1.performClick();
> > > tbutton2.performClick();
> > > tbutton3.performClick();
> > > tbutton4.performClick();


> check();
> }
> }); // row 4를 클릭시킨다.

> button7.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton5.performClick();
> > > tbutton6.performClick();
> > > tbutton7.performClick();
> > > tbutton8.performClick();


> check();
> }
> }); // row 3을 클릭시킨다.

> button8.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton9.performClick();
> > > tbutton10.performClick();
> > > tbutton11.performClick();
> > > tbutton12.performClick();


> check();
> }
> }); // row 2를 클릭시킨다.

> button9.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > tbutton13.performClick();
> > > tbutton14.performClick();
> > > tbutton15.performClick();
> > > tbutton16.performClick();


> check();
> }
> }); // row 1을 클릭시킨다.

> int k = (int) (Math.random() **10); // 5번의 클릭으로 생성된 난수**

> switch (k) { // 10번 클릭으로 만글 수 있는 난수들 중 배열 - 즉, 5번안에 해결가능한 문제

> case 0:
> > button1.performClick();
> > button2.performClick();
> > button3.performClick();
> > button5.performClick();
> > button6.performClick();
> > button7.performClick();
> > button9.performClick();



> break;

> case 1:
> > button1.performClick();
> > button2.performClick();
> > button4.performClick();
> > button5.performClick();
> > button6.performClick();
> > button7.performClick();
> > button8.performClick();


> break;

> case 2:
> > button1.performClick();
> > button2.performClick();
> > button5.performClick();
> > button8.performClick();


> break;

> case 3:
> > button3.performClick();
> > button5.performClick();


> button1.performClick();



> button2.performClick();
> button9.performClick();

> break;

> case 4:
> > button8.performClick();
> > button3.performClick();


> button2.performClick();


> button4.performClick();
> button7.performClick();

> break;

> case 5:
> > button3.performClick();
> > button9.performClick();


> button5.performClick();



> button1.performClick();
> button6.performClick();

> break;

> case 6:
> > button7.performClick();
> > button2.performClick();
> > button9.performClick();




> button5.performClick();
> button8.performClick();

> break;

> case 7:
> > button8.performClick();
> > button3.performClick();
> > button4.performClick();




> button5.performClick();
> button6.performClick();

> break;

> case 8:
> > button1.performClick();
> > button9.performClick();
> > button8.performClick();




> button5.performClick();
> button7.performClick();

> break;

> case 9:
> > button8.performClick();
> > button6.performClick();


> button6.performClick();


> button4.performClick();
> button5.performClick();

> break;

> default:
> > button2.performClick();
> > button3.performClick();


> button6.performClick();


> button5.performClick();
> button3.performClick();

> break;

> }


> }

> public void check()	{
> > boolean f; // 게임의 종료를 위한 조건 f선언


> f = tbutton1.isChecked() & tbutton2.isChecked() & tbutton3.isChecked()
> > & tbutton4.isChecked() & tbutton5.isChecked()
> > & tbutton6.isChecked() & tbutton7.isChecked()
> > & tbutton8.isChecked() & tbutton9.isChecked()
> > & tbutton10.isChecked() & tbutton11.isChecked()
> > & tbutton12.isChecked() & tbutton13.isChecked()
> > & tbutton14.isChecked() & tbutton15.isChecked()
> > & tbutton16.isChecked();

> // f는 토글버튼의 황성화 여부의 값을 저장 (1부터 16까지의 모든 토글버튼에 대해서)

> if (f == true) {
> > Intent intent = new Intent(getBaseContext(), FinishActivity.class);
> > startActivity(intent);

> }

> }
> @Override
> public boolean onCreateOptionsMenu(Menu menu) {
> > // Inflate the menu; this adds items to the action bar if it is present.
> > getMenuInflater().inflate(R.menu.game, menu);
> > return true;

> }

}

3. FinishActivity :: GameActivity에서 승리 조건을 만족하면 넘어감.

package com.example.pjh3390;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class FinishActivity extends Activity {

> @Override
> protected void onCreate(Bundle savedInstanceState) {
> > super.onCreate(savedInstanceState);
> > setContentView(R.layout.activity\_finish);


> StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
> StrictMode.setThreadPolicy(policy);

> Button button = (Button) findViewById(R.id.button1);
> button.setOnClickListener(new View.OnClickListener() {
> > public void onClick(View v) {
> > > Intent intent = new Intent(getBaseContext(), MainActivity.class);
> > > startActivity(intent);

> > }

> });
> }



> @Override
> public boolean onCreateOptionsMenu(Menu menu) {
> > // Inflate the menu; this adds items to the action bar if it is present.
> > getMenuInflater().inflate(R.menu.finish, menu);
> > return true;

> }

}

- xml
1. Main
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
> xmlns:tools="http://schemas.android.com/tools"
> android:id="@+id/LinearLayout1"
> android:layout\_width="match\_parent"
> android:layout\_height="match\_parent"
> android:orientation="vertical"
> android:paddingBottom="@dimen/activity\_vertical\_margin"
> android:paddingLeft="@dimen/activity\_horizontal\_margin"
> android:paddingRight="@dimen/activity\_horizontal\_margin"
> android:paddingTop="@dimen/activity\_vertical\_margin"
> tools:context=".MainActivity" >


> <ImageView
> > android:id="@+id/imageView2"
> > android:layout\_width="match\_parent"
> > android:layout\_height="match\_parent"
> > android:layout\_weight="1.15"
> > android:scaleType="fitXY"
> > android:src="@drawable/background" />


> <Button
> > android:id="@+id/button1"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignTop="@+id/imageView2"
> > android:layout\_centerHorizontal="true"
> > android:layout\_marginTop="119dp"
> > android:text="Start" />



Unknown end tag for &lt;/RelativeLayout&gt;



2. Game
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"

> xmlns:tools="http://schemas.android.com/tools"
> android:id="@+id/LinearLayout1"
> android:layout\_width="match\_parent"
> android:layout\_height="match\_parent"
> android:orientation="vertical"
> android:paddingBottom="@dimen/activity\_vertical\_margin"
> android:paddingLeft="@dimen/activity\_horizontal\_margin"
> android:paddingRight="@dimen/activity\_horizontal\_margin"
> android:paddingTop="@dimen/activity\_vertical\_margin"
> tools:context=".GameActivity" >

> <ImageView
> > android:id="@+id/imageView1"
> > android:layout\_width="312dp"
> > android:layout\_height="match\_parent"
> > android:scaleType="fitXY"
> > android:src="@drawable/background" />


> <Button
> > android:id="@+id/button1"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBottom="@+id/imageView1"
> > android:layout\_alignRight="@+id/imageView1"
> > android:text="▲"  />


> <Button
> > android:id="@+id/button2"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignTop="@+id/button1"
> > android:layout\_toLeftOf="@+id/button1"
> > android:text="▲" />


> <Button
> > android:id="@+id/button3"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignTop="@+id/button2"
> > android:layout\_toLeftOf="@+id/button2"
> > android:text="▲" />


> <Button
> > android:id="@+id/button4"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBaseline="@+id/button3"
> > android:layout\_alignBottom="@+id/button3"
> > android:layout\_toLeftOf="@+id/button3"
> > android:text="▲" />


> <Button
> > android:id="@+id/button5"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBaseline="@+id/button4"
> > android:layout\_alignBottom="@+id/button4"
> > android:layout\_toLeftOf="@+id/button4"
> > android:text="↗" />


> <Button
> > android:id="@+id/button8"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/button7"
> > android:layout\_toLeftOf="@+id/button4"
> > android:text="▶" />


> <Button
> > android:id="@+id/button9"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/button8"
> > android:layout\_alignRight="@+id/button8"
> > android:text="▶" />


> <Button
> > android:id="@+id/button6"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/button5"
> > android:layout\_alignLeft="@+id/button5"
> > android:text="▶" />


> <Button
> > android:id="@+id/button7"
> > style="?android:attr/buttonStyleSmall"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/button6"
> > android:layout\_toLeftOf="@+id/button4"
> > android:text="▶" />


> <ToggleButton
> > android:id="@+id/toggleButton1"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignLeft="@+id/button4"
> > android:layout\_alignRight="@+id/button4"
> > android:layout\_alignTop="@+id/button6"
> > android:text="1-1"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton2"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/button2"
> > android:layout\_alignLeft="@+id/button3"
> > android:layout\_alignRight="@+id/button3"
> > android:layout\_alignTop="@+id/toggleButton1"
> > android:text="2-1"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton3"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignRight="@+id/button2"
> > android:layout\_alignTop="@+id/toggleButton2"
> > android:layout\_toRightOf="@+id/button3"
> > android:text="3-1"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton4"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignRight="@+id/imageView1"
> > android:layout\_alignTop="@+id/toggleButton3"
> > android:layout\_toRightOf="@+id/button2"
> > android:text="4-1"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton5"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/toggleButton1"
> > android:layout\_alignLeft="@+id/toggleButton1"
> > android:layout\_alignRight="@+id/toggleButton1"
> > android:text="1-2"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton6"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/toggleButton2"
> > android:layout\_alignLeft="@+id/toggleButton2"
> > android:layout\_alignRight="@+id/toggleButton2"
> > android:text="2-2"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton7"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/toggleButton3"
> > android:layout\_alignLeft="@+id/toggleButton3"
> > android:layout\_alignRight="@+id/toggleButton3"
> > android:text="3-2"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton8"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBottom="@+id/toggleButton7"
> > android:layout\_alignRight="@+id/imageView1"
> > android:layout\_toRightOf="@+id/toggleButton7"
> > android:text="4-2"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton9"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/toggleButton5"
> > android:layout\_alignLeft="@+id/toggleButton5"
> > android:layout\_alignRight="@+id/toggleButton5"
> > android:text="1-3"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton10"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBottom="@+id/toggleButton9"
> > android:layout\_alignLeft="@+id/toggleButton6"
> > android:layout\_alignRight="@+id/toggleButton6"
> > android:text="2-3"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton11"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBottom="@+id/toggleButton10"
> > android:layout\_alignRight="@+id/toggleButton7"
> > android:layout\_toRightOf="@+id/toggleButton10"
> > android:text="3-3"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton12"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/toggleButton8"
> > android:layout\_alignLeft="@+id/toggleButton8"
> > android:layout\_alignRight="@+id/imageView1"
> > android:text="3-4"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton13"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBottom="@+id/button9"
> > android:layout\_alignLeft="@+id/toggleButton9"
> > android:layout\_alignRight="@+id/toggleButton9"
> > android:text="4-1"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton14"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignBottom="@+id/toggleButton13"
> > android:layout\_toLeftOf="@+id/toggleButton11"
> > android:layout\_toRightOf="@+id/toggleButton13"
> > android:text="4-2"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton15"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/toggleButton11"
> > android:layout\_alignLeft="@+id/toggleButton11"
> > android:layout\_alignRight="@+id/toggleButton11"
> > android:text="4-3"
> > android:textOff="☆"
> > android:textOn="★" />


> <ToggleButton
> > android:id="@+id/toggleButton16"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_above="@+id/toggleButton12"
> > android:layout\_alignLeft="@+id/toggleButton12"
> > android:layout\_alignRight="@+id/imageView1"
> > android:text="4-4"
> > android:textOff="☆"
> > android:textOn="★" />



Unknown end tag for &lt;/RelativeLayout&gt;



3. Finish
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"

> xmlns:tools="http://schemas.android.com/tools"
> android:id="@+id/LinearLayout1"
> android:layout\_width="match\_parent"
> android:layout\_height="match\_parent"
> android:orientation="vertical"
> android:paddingBottom="@dimen/activity\_vertical\_margin"
> android:paddingLeft="@dimen/activity\_horizontal\_margin"
> android:paddingRight="@dimen/activity\_horizontal\_margin"
> android:paddingTop="@dimen/activity\_vertical\_margin"
> tools:context=".FinishActivity" >

> <ImageView
> > android:id="@+id/imageView2"
> > android:layout\_width="match\_parent"
> > android:layout\_height="match\_parent"
> > android:layout\_weight="1.15"
> > android:scaleType="fitXY"
> > android:src="@drawable/background" />


> <Button
> > android:id="@+id/button1"
> > android:layout\_width="wrap\_content"
> > android:layout\_height="wrap\_content"
> > android:layout\_alignTop="@+id/imageView2"
> > android:layout\_centerHorizontal="true"
> > android:layout\_marginTop="105dp"
> > android:text="You Win !" />



Unknown end tag for &lt;/RelativeLayout&gt;




// 출처 : 내 머리~

////// 추가.... 그림이 왜 엔터했는데 붙어있지 ?? ㄷㄷㄷㄷ;;;;

//2012190702 박종하's Project