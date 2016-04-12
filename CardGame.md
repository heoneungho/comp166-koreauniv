# Introduction #

뒷면인 카드들을 두장씩 뒤집어서 앞면을보고 맞추는 게임입니다.

# Details #

가장쉬운 2x2 와 중간단계인 4x4 그리고 어려운 6x6 세가지 게임을 선택해서 할수 있게 만들었습니다.


## 코드 소개 ##

이 어플의 클래스는 이러한 것들이 있습니다.

https://comp166-koreauniv.googlecode.com/files/%ED%81%B4%EB%9E%98%EC%8A%A4.PNG

맨 첫화면인 First.java <br>
게임의 난이도를 설정하는 두번째 화면인 Second.java <br>
세가지 난이도의 HomeWork6.java/ HomeWork6_1.java/ HomeWork6_2.java <br>

첫화면인 First.java의 코드는 다음과 같습니다.<br>
<br>
<pre><code><br>
package exam.HomeWork6;<br>
<br>
<br>
import android.app.Activity;<br>
import android.content.Intent;<br>
import android.os.Bundle;<br>
import android.view.Menu;<br>
import android.view.View;<br>
import android.widget.ImageView;<br>
<br>
public class First extends Activity {<br>
<br>
	@Override<br>
	protected void onCreate(Bundle savedInstanceState) {<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.activity_first);<br>
		<br>
		ImageView button3 = (ImageView) findViewById(R.id.ImageView02); <br>
                       // 다음 화면으로 넘어가는 버튼 생성<br>
		button3.setOnClickListener(new View.OnClickListener() {<br>
		        public void onClick(View v) {<br>
		                Intent intent = new Intent(getBaseContext(), Second.class);<br>
		                startActivity(intent);<br>
		        }<br>
		});<br>
	}<br>
<br>
	@Override<br>
	public boolean onCreateOptionsMenu(Menu menu) {<br>
		// Inflate the menu; this adds items to the action bar if it is present.<br>
		getMenuInflater().inflate(R.menu.first, menu);<br>
		return true;<br>
	}<br>
<br>
}<br>
<br>
</code></pre>

난이도를 설정하는 Second.java 의 코드는 다음과 같습니다.<br>
<br>
<pre><code><br>
package exam.HomeWork6;<br>
<br>
import android.os.Bundle;<br>
import android.app.Activity;<br>
import android.content.Intent;<br>
import android.view.Menu;<br>
import android.view.View;<br>
import android.widget.ImageView;<br>
<br>
public class Second extends Activity {<br>
<br>
	@Override<br>
	protected void onCreate(Bundle savedInstanceState) {<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.activity_second);<br>
		<br>
		ImageView button01 = (ImageView) findViewById(R.id.imageView2);<br>
                            // 가장 쉬운난이도로 가는 버튼 생성<br>
		button01.setOnClickListener(new View.OnClickListener() {<br>
		        public void onClick(View v) {<br>
		                Intent intent = new Intent(getBaseContext(), HomeWork6.class);<br>
		                startActivity(intent);<br>
		        }<br>
		});<br>
		<br>
		ImageView button02 = (ImageView) findViewById(R.id.imageView3);<br>
                             // 중간 난이도로 가는 버튼 생성<br>
		button02.setOnClickListener(new View.OnClickListener() {<br>
		        public void onClick(View v) {<br>
		                Intent intent = new Intent(getBaseContext(), HomeWork6_1.class);<br>
		                startActivity(intent);<br>
		        }<br>
		});<br>
		<br>
		ImageView button03 = (ImageView) findViewById(R.id.imageView1);<br>
                             // 가장 어려운 난니도로 가는 버튼 생성<br>
		button03.setOnClickListener(new View.OnClickListener() {<br>
		        public void onClick(View v) {<br>
		                Intent intent = new Intent(getBaseContext(), HomeWork6_2.class);<br>
		                startActivity(intent);<br>
		        }<br>
		});<br>
	}<br>
<br>
	@Override<br>
	public boolean onCreateOptionsMenu(Menu menu) {<br>
		// Inflate the menu; this adds items to the action bar if it is present.<br>
		getMenuInflater().inflate(R.menu.second, menu);<br>
		return true;<br>
	}<br>
<br>
}<br>
<br>
</code></pre>

마지막으로 게임을 하는 클래스인 HomeWork6.java는 다음과 같습니다.<br>
<br>
<pre><code><br>
package exam.HomeWork6;<br>
<br>
import android.app.Activity;<br>
import android.content.res.Resources;<br>
import android.graphics.Bitmap;<br>
import android.graphics.Color;<br>
import android.graphics.drawable.BitmapDrawable;<br>
import android.os.Bundle;<br>
import android.os.Handler;<br>
import android.os.Message;<br>
import android.util.Log;<br>
import android.view.Gravity;<br>
import android.view.Menu;<br>
import android.view.MenuItem;<br>
import android.view.View;<br>
import android.widget.Button;<br>
import android.widget.ImageButton;<br>
import android.widget.LinearLayout;<br>
import android.widget.TextView;<br>
import android.widget.Toast;<br>
<br>
public class HomeWork6 extends Activity {<br>
	/** Called when the activity is first created. */<br>
<br>
	LinearLayout mainLinear; // 전체 레이아웃<br>
	LinearLayout[] linearRows; // 행의 수<br>
<br>
	ImageButton[] buttons; // 이미지 버튼 배열<br>
	BitmapDrawable[] bitmapsDrawables; // drawable 배열<br>
	Bitmap[] bitmaps; // 비트맵 배열<br>
	<br>
	BitmapDrawable bitmapDrawableBack;<br>
	Bitmap bitmapBack;<br>
	<br>
	int[] indexes; // 카드의 고유번호 저장 배열<br>
	<br>
	int[] tempArr = null; // 임시 정수 배열	<br>
	int maximum = 2;<br>
	int start, end;<br>
	<br>
	int[] correctIndexArray;<br>
	int[] selectedIndex;<br>
	int selectedCardIndex;<br>
	<br>
	Resources res;<br>
	boolean bPassible = true;<br>
	<br>
	TextView tv;<br>
<br>
	@Override<br>
	public void onCreate(Bundle savedInstanceState) {<br>
		int temp = 0;<br>
<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.main);<br>
<br>
		tv = (TextView)findViewById( R.id.text );<br>
		mainLinear = (LinearLayout) findViewById(R.id.main_linear); // 전체 리니어<br>
		<br>
		tv.setText( R.string.choice1 ); // 메시지가 출력되는 텍스트 뷰<br>
		tv.setTextColor( Color.BLUE );<br>
		tv.setGravity( Gravity.CENTER_HORIZONTAL );<br>
<br>
		res = getResources(); // 리소스 얻기<br>
		indexes = new int[ maximum * maximum ]; // 이미지의 고유번호를 기억한다.<br>
<br>
		start = 0x7f020002; // 리소스 번호 처음<br>
		end = 0x7f02002f; // 리소스 번호 마지막<br>
 <br>
		// 시작부터 끝까지 카드중 2개의 카드를 뽑아낸다.<br>
		bitmapDrawableBack = (BitmapDrawable)res.getDrawable( R.drawable.back );<br>
		bitmapBack = bitmapDrawableBack.getBitmap();<br>
		<br>
		// 랜덤으로 이미지를 읽어온다.<br>
		getRandomImages();<br>
		// 적당히 섞는다.<br>
		mixIndexes();	<br>
		// 뷰를 배칠한다<br>
		setViews();<br>
		// 카드 뒷면을 보여준다.<br>
		recoverAllCards();<br>
		// 적절한 초기화<br>
		init();		<br>
		<br>
	}<br>
	<br>
	private void mixIndexes(){<br>
		int temp;<br>
		<br>
		// 랜덤으로 중복없이 값을 뽑는다.<br>
		tempArr = getRandomNumbers(0, maximum * maximum - 1, maximum * maximum);<br>
		temp = 0 ;	<br>
		//indexes 배열은 랜덤으로 값들이 들어간다<br>
		for( int i = 0 ; i &lt; indexes.length ; i++ ){<br>
			indexes[ tempArr[ i ] ] = temp;<br>
			temp++;<br>
	<br>
			// 같은 카드가 두 장이 들어가도록 한다.<br>
			if( temp &gt;= maximum * maximum / 2 )<br>
				temp = 0;<br>
		}<br>
	}<br>
	<br>
	private void getRandomImages(){<br>
		<br>
		int temp;<br>
		bitmapsDrawables = null;<br>
		tempArr = null;<br>
		<br>
		// 랜덤으로 중복없이 뽑는다. 총 50여장의 카드중 maximum * maximum / 2 개의 카드를 뽑는다.<br>
		tempArr = getRandomNumbers(start, end, maximum * maximum / 2 );<br>
		bitmapsDrawables = new BitmapDrawable[ maximum * maximum / 2 ];<br>
<br>
		// 랜덤한 이미지를 로드한다.<br>
		temp = 0;<br>
		for (int i = 0; i &lt; bitmapsDrawables.length; i++) {<br>
			bitmapsDrawables[ i ] = (BitmapDrawable) res.getDrawable( tempArr[ temp++ ] 	);<br>
		}<br>
<br>
		// 비트맵을 얻는다.<br>
		bitmaps = new Bitmap[ maximum * maximum / 2 ];<br>
		for (int i = 0; i &lt; bitmaps.length; i++) {<br>
			bitmaps[ i ] = bitmapsDrawables[i].getBitmap();<br>
		}<br>
	}<br>
	<br>
	private void recoverAllCards(){<br>
		// 카드를 모두 뒤집힌 상태로 놓는다.<br>
		for (int i = 0; i &lt; buttons.length; i++){<br>
			buttons[ i ].setImageBitmap( bitmapBack );<br>
		}		<br>
	}<br>
	<br>
	private void recoverCard(){<br>
		<br>
		// 뒤집어본 카드를 다시 돌려놓는다.		<br>
		buttons[ selectedIndex[ 0 ] ].setImageBitmap( bitmapBack );<br>
		buttons[ selectedIndex[ 1 ] ].setImageBitmap( bitmapBack );<br>
		<br>
	}<br>
	<br>
	private void setViews(){		<br>
		int temp;<br>
		<br>
		temp = 0;<br>
		<br>
		mainLinear.removeAllViews();<br>
		<br>
		// 버튼 생성<br>
		buttons = new ImageButton[maximum * maximum];<br>
		for (int i = 0; i &lt; buttons.length; i++)<br>
			buttons[ i ] = new ImageButton(this);<br>
		<br>
		// 행을 생성한다 수평 리니어이다.<br>
		linearRows = new LinearLayout[maximum];<br>
		<br>
		for (int i = 0; i &lt; linearRows.length; i++) {<br>
<br>
			linearRows[i] = new LinearLayout(this);<br>
			linearRows[i].setGravity( Gravity.CENTER_HORIZONTAL ); // 가운데 정렬<br>
			linearRows[i].setOrientation( LinearLayout.HORIZONTAL );			<br>
			<br>
			for (int j = 0; j &lt; maximum; j++) {<br>
				// linearLayout 에 이미지버튼을 배치한다<br>
				linearRows[i].addView(buttons[temp++]);<br>
			}<br>
			// 메인 LinearLayout 에 뷰를 배치한다,.<br>
			mainLinear.addView(linearRows[i]);<br>
		}<br>
	}<br>
	<br>
	private void init(){<br>
<br>
		// 이벤트 리스너 등록<br>
		for( int i = 0 ; i &lt; buttons.length ; i++ ){<br>
			buttons[ i ].setOnClickListener( mClickListener );<br>
		}<br>
		<br>
		<br>
		// selectedindex 는 사용자가 선택한 카드의 index 가 들어있다.<br>
		// 이미 선택된 카드를 다시 선택했는지 판단한다.<br>
		selectedIndex =  new int[ 2 ];		<br>
		for( int i = 0 ; i &lt; selectedIndex.length ; i++ ){<br>
			selectedIndex[ i ] = -1;<br>
		}<br>
		<br>
		// correctindexarray 는 이미 맞춘 카드의 index 가 저장된다.<br>
		correctIndexArray = new int[ maximum * maximum ];<br>
		for( int i = 0 ; i &lt; correctIndexArray.length ; i++ ){<br>
			correctIndexArray[ i ] = -1;<br>
		}<br>
		<br>
		// 선택한 카드의 이미지 index 가 저장된다.<br>
		// 이미지가 서로 일치하는지 판단한다,.<br>
		selectedCardIndex = -1;<br>
		<br>
		// bPassible 이 true 일때만 버튼클릭이 작동한다.<br>
		// 이것은 1 초동안 딜레이상태일때 다른 버튼이 클릭되는것을 막는다.<br>
		bPassible = true;<br>
		<br>
	}<br>
	<br>
	Handler mHandler = new Handler(){<br>
		@Override<br>
		public void handleMessage( Message msg ){<br>
			<br>
			switch( msg.what )<br>
			{<br>
			case 0:				// 틀린경우<br>
				recoverCard();				<br>
			case 1: // 맞은경우<br>
				selectedIndex[ 0 ] = -1;<br>
				selectedIndex[ 1 ] = -1;<br>
				bPassible = true;<br>
				tv.setTextColor( Color.BLUE );<br>
				tv.setText( R.string.choice1 );<br>
				break;<br>
			}<br>
			<br>
		}<br>
		<br>
	};<br>
	<br>
	public boolean onCreateOptionsMenu( Menu menu ){<br>
		super.onCreateOptionsMenu( menu );<br>
		<br>
		// 다시섞기 메뉴 추가<br>
		MenuItem item = menu.add( 0, 1, 0, "다시 섞기"); <br>
		item.setIcon( R.drawable.icon );<br>
		<br>
		return true;<br>
	}<br>
	<br>
	public boolean onOptionsItemSelected( MenuItem item ){<br>
		switch( item.getItemId() )<br>
		{<br>
			case 1:<br>
				<br>
				//초기화<br>
				getRandomImages();<br>
				mixIndexes();					<br>
				setViews();<br>
				recoverAllCards();<br>
				init();<br>
				return true;<br>
		}<br>
		return false;<br>
	}<br>
	<br>
	Button.OnClickListener mClickListener = new View.OnClickListener() {<br>
		// 버튼 클릭시 호출된다.<br>
		@Override		<br>
		public void onClick(View v) {<br>
			if( bPassible == false )<br>
				return ;<br>
			<br>
			for( int i = 0 ; i &lt; buttons.length ; i++ ){<br>
				if( v.equals( buttons[i] ) ){<br>
					<br>
					 // 이미 선택한 카드일경우					<br>
					if( selectedIndex[ 0 ] == i ){<br>
						tv.setTextColor( Color.RED );<br>
						tv.setText( R.string.already_selected );<br>
						return ;<br>
					}<br>
						<br>
					// 이미 정답을 맞춘 카드일 경우<br>
					if( correctIndexArray[ i ] != -1 ){<br>
						tv.setTextColor( Color.RED );<br>
						tv.setText( R.string.already_correct );<br>
						return ;<br>
					}<br>
					<br>
					// 클릭한 이미지를 보여준다.<br>
					buttons[ i ].setImageBitmap( bitmaps[ indexes[ i ] ] );<br>
<br>
					// 처음클릭한 이미지이면<br>
					if( selectedIndex[ 0 ] == -1 ){<br>
						selectedCardIndex = indexes[ i ];<br>
						tv.setTextColor( Color.YELLOW );<br>
						tv.setText( R.string.choice2 ); // 두번째를 클릭해주세요<br>
						selectedIndex[ 0 ] = i;<br>
					}												<br>
					else{<br>
						//두번째 클릭한 이미지이면<br>
						selectedIndex[ 1 ] = i;<br>
						<br>
						// 이미지가 일치하면<br>
						if( selectedCardIndex == indexes[ i ] ){<br>
							<br>
							tv.setTextColor( Color.BLUE );<br>
							tv.setText( R.string.correct ); // 맞췄습니다!<br>
							// 맞춘이미지 index 를 저장한다.<br>
							correctIndexArray[ selectedIndex[ 0 ] ] = 1;<br>
							correctIndexArray[ selectedIndex[ 1 ] ] = 1;<br>
							for( int j = 0 ; j &lt; correctIndexArray.length ; j++ ){<br>
								<br>
								// 맞추지 못한 카드가 있을 경우<br>
								if( correctIndexArray[ j ] == -1 ){<br>
									// 1초후에 핸들러 실행<br>
									mHandler.sendEmptyMessageDelayed( 1 , 1000 );<br>
									return ;									<br>
								}								<br>
							}<br>
							<br>
							tv.setTextColor( Color.BLUE );<br>
							tv.setText( R.string.clear ); // 모두 맞췄을 경우<br>
							<br>
							bPassible = false;<br>
							<br>
							return ;<br>
														<br>
							<br>
						}<br>
						else{<br>
							<br>
							tv.setTextColor( Color.RED );<br>
							tv.setText( R.string.wrong ); // 틀렸습니다.<br>
							mHandler.sendEmptyMessageDelayed( 0 , 1000 );<br>
							bPassible = false;<br>
						}<br>
					}<br>
					break;<br>
				}<br>
			}<br>
		}<br>
	};<br>
	<br>
	<br>
<br>
	public static int[] getRandomNumbers(int start, int end, int num) {<br>
		// 이 메서드는 start ~ end 범위의 정수중 num 갯수만큼의 정수를<br>
		// 랜덤하게 중복없이 뽑아냅니다.<br>
		int size; // 크기입니다<br>
		int temp; // 임시변수입니다.<br>
<br>
		if (start &gt; end || start == end) // 시작위치가 끝 위치보다 크거나 같으면 실패입니다.<br>
			return null;<br>
<br>
		size = end - start + 1; // size 의 크기를 구합니다.<br>
<br>
		if (size &lt; num) // size 의 크기보다 원하는 숫자의 갯수가 많으면 실패입니다.<br>
			return null; <br>
		int[] numbers;<br>
		double[] dRandom;<br>
		int[] result = null;<br>
		<br>
		try {<br>
<br>
			numbers = new int[size];<br>
			dRandom = new double[size];<br>
			result = new int[num];<br>
<br>
			// 랜덤한 수를 size 만큼 생성합니다.<br>
			for (int i = 0; i &lt; dRandom.length; i++) {<br>
				dRandom[i] = Math.random();<br>
			}<br>
			// 차대로 할당 후<br>
			temp = start;<br>
			for (int i = 0; i &lt; numbers.length; i++) {<br>
				numbers[i] = temp++;<br>
			}<br>
<br>
			// 랜덤으로 생성된 숫자를 정렬하여 섞습니다.<br>
			for (int i = 0; i &lt; dRandom.length; i++) {<br>
				for (int j = 0; j &lt; dRandom.length - 1; j++) {<br>
					double tmp = dRandom[j];<br>
					temp = numbers[j];<br>
<br>
					if (dRandom[j] &gt; dRandom[j + 1]) {<br>
						dRandom[j] = dRandom[j + 1];<br>
						dRandom[j + 1] = tmp;<br>
						numbers[j] = numbers[j + 1];<br>
						numbers[j + 1] = temp;<br>
					}<br>
				}<br>
			}<br>
			// 결과를 리턴합니다.<br>
			for (int i = 0; i &lt; result.length; i++) {<br>
				result[i] = numbers[i];<br>
			}<br>
		} catch (Exception e) {<br>
		}<br>
<br>
		return result;<br>
	}<br>
}<br>
<br>
</code></pre>

다른 난이도의 HomeWork6_1.java 와 HomeWork6_2.java 는 카드의 갯수에 관련된 코드를 제외하고는 HomeWork6.java 와 같습니다. <br><br>

다음으로 레이아웃에는 이러한 것들이 있습니다.<br>
<br>
<a href='https://comp166-koreauniv.googlecode.com/files/xml.PNG'>https://comp166-koreauniv.googlecode.com/files/xml.PNG</a>

첫번째 화면인 activity_first.xml은 다음과 같은 화면을 나타내줍니다.<br>
<br>
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-08-59.png' />

코드는 다음과 같습니다.<br>
<br>
<pre><code><br>
&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".First" &gt;<br>
<br>
    &lt;ImageView<br>
        android:id="@+id/imageView1"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_alignParentTop="true"<br>
        android:layout_centerHorizontal="true"<br>
        android:src="@drawable/start" /&gt;<br>
                 // 화투그림<br>
    &lt;ImageView<br>
        android:id="@+id/imageView2"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_below="@+id/imageView1"<br>
        android:layout_centerHorizontal="true"<br>
        android:src="@drawable/title" /&gt;<br>
                 // 카드 뒤집기 게임 타이틀<br>
    &lt;ImageView<br>
        android:id="@+id/ImageView02"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_below="@+id/imageView2"<br>
        android:layout_centerHorizontal="true"<br>
        android:layout_marginTop="94dp"<br>
        android:src="@drawable/startbutton" /&gt;<br>
                 // 시작! 버튼<br>
&lt;/RelativeLayout&gt;<br>
<br>
</code></pre>

난이도 설정하는 두번째 화면인 Second.xml은 다음과 같습니다.<br>
<br>
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-09-04.png' />

코드는 다음과 같습니다.<br>
<br>
<pre><code><br>
&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".Second" &gt;<br>
<br>
    &lt;ImageView<br>
        android:id="@+id/imageView1"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_alignParentBottom="true"<br>
        android:layout_centerHorizontal="true"<br>
        android:layout_marginBottom="146dp"<br>
        android:src="@drawable/u1" /&gt;<br>
           //어린이용 버튼<br>
    &lt;ImageView<br>
        android:id="@+id/imageView3"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_above="@+id/imageView1"<br>
        android:layout_alignLeft="@+id/imageView2"<br>
        android:layout_marginBottom="22dp"<br>
        android:src="@drawable/u3" /&gt;<br>
           //청소년용 버튼<br>
    &lt;ImageView<br>
        android:id="@+id/imageView2"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_above="@+id/imageView3"<br>
        android:layout_centerHorizontal="true"<br>
        android:layout_marginBottom="25dp"<br>
        android:src="@drawable/u2" /&gt;<br>
           //어른용 버튼<br>
&lt;/RelativeLayout&gt;<br>
<br>
</code></pre>

main.xml은 기본적으로 있었던 파일로 게임의 기본적인 배경화면을 만들어주기만 하는 xml 입니다. 코드는 다음과 같습니다.<br>
<br>
<pre><code><br>
&lt;?xml version="1.0" encoding="utf-8"?&gt;<br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    android:orientation="vertical"<br>
    android:layout_width="fill_parent"<br>
    android:layout_height="fill_parent"<br>
    &gt;<br>
&lt;TextView  <br>
    android:layout_width="fill_parent" <br>
    android:layout_height="wrap_content" <br>
    android:text="@string/hello"<br>
    android:id="@+id/text"<br>
    android:textColor="#ff0000ff"<br>
    android:textSize="12pt"<br>
    /&gt;<br>
    &lt;LinearLayout<br>
	android:id="@+id/main_linear"<br>
    android:orientation="vertical"<br>
    android:layout_width="fill_parent"<br>
    android:layout_height="fill_parent"<br>
    /&gt;<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>

게임 실행 화면은 다음과 같슴니다.<br>
<br>
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-09-07.png' />
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-16-50.png' />
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-16-54.png' />
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-16-57.png' />
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-17-03.png' />
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-17-34.png' />
<img src='https://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-16-17-40.png' />
<br>
어플 실행 영상<br>
<br>
<a href='http://www.youtube.com/watch?feature=player_embedded&v=xmfVIYWfuok' target='_blank'><img src='http://img.youtube.com/vi/xmfVIYWfuok/0.jpg' width='425' height=344 /></a><br>
<br>


어플의 기본적인 소스코드 출처:<br>
<a href='http://blog.naver.com/PostView.nhn?blogId=sukjun40&logNo=100127545341'>http://blog.naver.com/PostView.nhn?blogId=sukjun40&amp;logNo=100127545341</a>