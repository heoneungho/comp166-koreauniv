# Introduction #

4x4 칸의 카드들(8쌍)이 랜덤으로 뒤집은 채로 배치한 뒤, 게임 시작과 동시에 타이머가 작동합니다. 같은 그림의 카드를 연속으로 눌러서 모든 쌍을 찾아내는 게임입니다. 옵션 변경을 통해서 원하시는 그림 이미지로도 게임을 하실 수 있습니다.

저는 게임도 게임이지만 어플리케이션 내의 부가적인 기능들에 초점을 맞추어 보았습니다. 실제 마켓에서 게임을 받게 되면 여러가지 옵션들이 게임 내에 존재하며, 각 옵션들은 단순 게임자체가 주는 재미에 버금가는 추가적인 흥미를 더해줍니다. 바로 이러한 점에 저의 이번 어플리케이션 개발 의도가 담겨있습니다.
<br><br><br><br>
<h1>개발의 목적 및 필요성</h1>

<img src='http://comp166-koreauniv.googlecode.com/files/잉여.png' />


<blockquote>귀가 시간이나 애매하게 남은 공강시간 참으로 따분하셨죠?</blockquote>

<blockquote>그래서 제가 여러분을 위해 준비했습니다. 정답은 바로 같은 그림 맞추기 게임!!</blockquote>

<blockquote>요즘 스마트폰 게임의 추세에 맞게 <b>재미*와 더불어</b>조작의 단순함<b>,</b>짧은 진행시간*을 모두 갖춘 게임입니다.</blockquote>

<blockquote>게다가 기억력 강화에 도움을 줄 수 있기 때문에 치매를 예방하고자하시는 어르신들이나 갱년기를 앞두고 기억력 감퇴가 걱정되시는 부모님들께 상당히 유용한 게임입니다. 물론 유아들의 기억력 강화에도 도움이 되겠죠?</blockquote>

<blockquote>이와 같은 장점들만 모았습니다. "모두의 매칭"을 여러분께 소개합니다.<br>
<br><br><br><br>
<h1>Requirment</h1></blockquote>

<ul><li>Start Game 버튼 :</li></ul>

1. Game Activity로 이동한다.<br>
<br>
2. 4x4의 게임이 만들어짐과 동시에 타이머가 작동한다.<br>
<br>
3. Game Activity 내의 Resume, Stop 버튼으로 게임을 멈추기, 재개하기가 가능하다.<br>
<br>
4. 7위내의 기록 경신 시 랭킹 닉네임 작성화면이 나타난다.<br>
<br>
<br>
<br>
<ul><li>Option 버튼 :</li></ul>

1. Option Activity로 이동한다.<br>
<br>
2. BGM on&off 기능, 카드 Image 변경 기능, 랭킹 초기화 기능 제공한다.<br>
<br>
<br>
<br>
<ul><li>Ranking 버튼 :</li></ul>

1. Ranking Activity로 이동한다.<br>
<br>
2. 1위부터 7위까지의 랭커들의 닉네임을 순서대로 제공한다.<br>
<br><br><br><br>




<h1>게임의 구성(각 화면 구성 설명 및 버튼들의 기능 설명)</h1>


자! 이제 본격적으로 본인이 만든 게임의 화면 구성 살펴보도록 하겠다.<br>
<br>
<br><br><br>

<h2>메인 화면(Main Activity)</h2>


<img src='http://comp166-koreauniv.googlecode.com/files/메인화면1.png' />


<img src='http://comp166-koreauniv.googlecode.com/files/메인화면2.png' />


<ul><li>첫 화면인 메인화면은 메인 로고와 3개의 버튼으로 구성되어 있다.</li></ul>

<ul><li>메인로고는 가로와 세로 방향으로 80%~ 120%로 축소와 증가를 반복하도록 구성하였고, 반짝이는 것 같은 모습을 연출하기 위해 투명도의 변화를 그에 맞게 설정하였다.</li></ul>

<ul><li>각 버튼은 각 화면으로 이동하게 해주는 기능을 담당한다.</li></ul>

<ul><li>추가적으로 좋아하는 배경음악을 BGM으로 설정해보았다. 노래 정보 : Better Together-Jack Johnson</li></ul>


<br><br><br>
<h2>옵션 화면(Option Activity)</h2>


<img src='http://comp166-koreauniv.googlecode.com/files/옵화.png' />


<ul><li>옵션 화면은 사운드 on&off toggle 버튼, 카드 교체 radio 버튼, 랭킹 리셋 버튼으로 구성되어 있다.</li></ul>

<ul><li>사운드 on&off toggle 버튼은 처음에 사운드가 on의 상태로 실행되며 클릭 시 off로 바뀌면서 사운드가 멈춘다.</li></ul>

<ul><li>사운드의 재생방식은 모든 Activity에서 연결되도록 설정하였다. 따라서 모든 클래스에 onResume 메소드와 onPause 메소드를 동일하게 구성함으로써 사운드가 어디서나 연결되어 들리도록 하였다.</li></ul>

<ul><li>각 카드의 종류에 따라 게임 화면의 카드가 변경된다.</li></ul>

<ul><li>랭킹 리셋 버튼을 누르면 랭킹에 있던 목록이 모두 설정된 초기값으로 초기화된다.<br>
<br><br><br></li></ul>


<h2>카드의 종류별 게임 화면</h2>

<ul><li>교수님카드</li></ul>

<img src='http://comp166-koreauniv.googlecode.com/files/교수님카드.png' />

<ul><li>동물카드</li></ul>

<img src='http://comp166-koreauniv.googlecode.com/files/동물카드.png' />

<ul><li>숫자카드</li></ul>

<img src='http://comp166-koreauniv.googlecode.com/files/숫자카드.png' />

<br><br><br>

<h2>랭킹화면과 랭킹 리셋 버튼의 동작 확인</h2>


<ul><li>랭킹화면</li></ul>


<img src='http://comp166-koreauniv.googlecode.com/files/랭킹화면.png' />


<ul><li>랭킹 초기화화면</li></ul>


<img src='http://comp166-koreauniv.googlecode.com/files/랭초화.png' />
<br><br><br>


<h2>게임 화면(Game Activity)</h2>


<img src='http://comp166-koreauniv.googlecode.com/files/동물카드.png' />


<ul><li>게임 화면은 타이머, 카드, 버튼들로 구성되어 있다.</li></ul>

<ul><li>타이머는 게임 시작과 동시에 작동하고, 모든 8쌍의 카드를 맞추면 바로 정지하도록 설정되어 있다.</li></ul>

<ul><li>각 버튼들에 의해 급한 일이 생긴 경우 정지할 수 있고, 일이 마무리되고 나면 다시 재개가 가능하며, 패가 좋지 않다고 생각되면 새 게임을 진행할 수 있다.<br>
<br><br><br></li></ul>


<h2>게임 화면 내에서 랭킹 진입 성공과 실패 시 결과 화면</h2>


<ul><li>랭킹 진입 성공 화면</li></ul>

<ul><li>닉네임을 작성하고 Save 버튼을 누르면 랭킹화면으로 넘어가서 랭킹을 확인할 수 있다.</li></ul>


<img src='http://comp166-koreauniv.googlecode.com/files/성공화면.png' />



<ul><li>랭킹 진입 실패 화면</li></ul>

<ul><li>실패 화면을 누르면 메인 화면으로 넘어간다.</li></ul>


<img src='http://comp166-koreauniv.googlecode.com/files/실패화면.png' />

<br><br><br><br>



<h1>패키지와 클래스 그리고 레이아웃</h1>

<br><br><br>

<h2>패키지와 클래스</h2>


<img src='http://comp166-koreauniv.googlecode.com/files/패키지클래스.png' />


<blockquote>패키지는 게임 화면을 구성하는 클래스들이 담긴 기본 패키지, 게임 화면 내의 동작과 관련된 패키지, 그리고 그 밖의 기능을 담당하는 유틸리티 패키지로 구성되어 있다.</blockquote>

<br><br><br>

<h2>res 폴더 내의 구성</h2>


<img src='http://comp166-koreauniv.googlecode.com/files/리쏘쓰.png' />


<ul><li>제일 위에 보이는 anim 폴더는 메인 로고의 동작을 정의해주는 xml 파일이 들어 있다.</li></ul>

<ul><li>drawable-xhdpi 내에 어플리케이션 내과 관련된 이미지들을 모두 저장하였다.</li></ul>

<ul><li>layout 폴더 내에는 기본 패키지내의 클래스를 구성하는 화면에 대한 xml 파일이 들어 있다.</li></ul>

<ul><li>마지막으로 raw 폴더에는 BGM으로 재생되는 음악 파일이 담겨 있다.</li></ul>

<br><br><br><br>



<h1>각 클래스에 대한 설명</h1>
<br><br><br>

<h2>게임 클래스와 xml</h2>

<pre><code>&lt;게임 클래스&gt;<br>
package com.example.matchinggame;<br>
<br>
import android.app.Activity;<br>
import android.content.Intent;<br>
import android.os.Bundle;<br>
import android.os.Handler;<br>
import android.os.Message;<br>
import android.view.View;<br>
import android.view.View.OnClickListener;<br>
import android.widget.EditText;<br>
import android.widget.ImageView;<br>
import android.widget.TextView;<br>
<br>
import com.example.matchinggame.game.CardManager;<br>
import com.example.matchinggame.game.GameManager;<br>
import com.example.matchinggame.game.GenerateRandom;<br>
import com.example.matchinggame.game.TimeManager;<br>
import com.example.matchinggame.utils.ManagerPreference;<br>
import com.example.matchinggame.utils.ManagerSound;<br>
<br>
public class GameActivity extends Activity implements OnClickListener{<br>
	public static final String mPackage="com.example.matchinggame";<br>
	public static final int CARD_SIZE=16;<br>
	<br>
	public CardManager[] Card; <br>
	<br>
	public static final int IN_GAME=1; // 현재 게임의 진행 상태를 나타내는 변수들<br>
	public static final int PAUSE_GAME=2;<br>
	public static final int FINISH_GAME=3;<br>
	public static final int TIME_INTERVEL=90; // 시간 정보 호출 간격<br>
	public int NowGameStatus;<br>
	<br>
	<br>
	TimeManager tm;<br>
	TextView tv_time;<br>
<br>
	public static final int MSG_FIRST_CARD_TURN=0; // 맨 처음 게임 시작 시 카드들을 전체적으로 보여주기 위한 변수<br>
	public static final int FIRST_CARD_TURN_TIME=1500; // 카드 넘어가는데 걸리는 시간으로 보여주는 시간을 설정 : 1.5초<br>
	public static final int MSG_TURN_CARD=1; // 게임 진행 과정에서의 2장의 카드가 서로 다른 경우 뒤집기 위한 변수<br>
	public static final int TURN_CARD_TIME=1500;<br>
	<br>
	GameManager GM;<br>
<br>
	@Override<br>
	protected void onCreate(Bundle savedInstanceState) {<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.activity_game);<br>
		<br>
		mInitLayout(); <br>
		<br>
		tm=new TimeManager();<br>
		GM=new GameManager();<br>
		<br>
		NowGameStatus=IN_GAME;<br>
		tm.startGame();<br>
		<br>
		mTimeHandler.sendEmptyMessageDelayed(NowGameStatus, TIME_INTERVEL);<br>
		mGameHandler.sendEmptyMessageDelayed(MSG_FIRST_CARD_TURN, FIRST_CARD_TURN_TIME);<br>
		<br>
		findViewById(R.id.restart_btn).setOnClickListener(this);<br>
		findViewById(R.id.pause_btn).setOnClickListener(this);<br>
		findViewById(R.id.resume_btn).setOnClickListener(this);<br>
		findViewById(R.id.resume_btn).setClickable(false);<br>
	}<br>
	<br>
	/**<br>
	 * xml에서 만든 값들을 소스랑 연결시켜주는 부분<br>
	 * onCreate에 들어가면서 바로 실행되는 부분<br>
	 */<br>
	private void mInitLayout(){<br>
		tv_time=(TextView)findViewById(R.id.tv_time);<br>
		<br>
		Card=new CardManager[CARD_SIZE]; <br>
		int[] randList=GenerateRandom.getRandom(CARD_SIZE); // 카드에 0~7까지의 값을 랜덤하게 생성 <br>
		<br>
		for(int i=0;i&lt;CARD_SIZE;i++){<br>
			<br>
			int resource=0; //카드의 종류에 해당하는 변수<br>
			<br>
			switch (ManagerPreference.getCard()) { //옵션에서 카드를 변경하면 그것을 반영해주는 switch문<br>
			case 0:<br>
				resource=getResources().getIdentifier("card"+randList[i]%(CARD_SIZE/2)+randList[i]%(CARD_SIZE/2)+randList[i]%(CARD_SIZE/2),"drawable",mPackage);<br>
				break; <br>
			case 1:<br>
				resource=getResources().getIdentifier("card"+randList[i]%(CARD_SIZE/2)+randList[i]%(CARD_SIZE/2),"drawable",mPackage);<br>
				break;<br>
			case 2:<br>
				resource=getResources().getIdentifier("card"+randList[i]%(CARD_SIZE/2),"drawable",mPackage);<br>
				break;<br>
			}<br>
			<br>
			Card[i]=new CardManager(<br>
					i,<br>
					randList[i]%(CARD_SIZE/2), <br>
					(ImageView)findViewById(getResources().getIdentifier("btn"+i,"id",mPackage)),<br>
					resource);<br>
			<br>
			Card[i].getImageView().setOnClickListener(this);<br>
			<br>
			Card[i].setImage(true); // 처음에는 모든 카드가 앞면(가리개 카드)으로 나온다.<br>
		}<br>
		<br>
	}<br>
	@Override<br>
	public void onResume(){<br>
		super.onResume();<br>
		NowGameStatus=IN_GAME;<br>
		if(ManagerPreference.getSound()){<br>
            ManagerSound.playSound(this);<br>
        }<br>
	}<br>
	@Override<br>
	public void onPause(){<br>
		super.onPause();<br>
		NowGameStatus=PAUSE_GAME;<br>
		ManagerSound.pauseSound();<br>
	}<br>
	<br>
	/**<br>
	 * 게임에서 필요한 핸들러로<br>
	 * 카드를 뒤집는 동작을 제어한다.<br>
	 */<br>
	Handler mGameHandler=new Handler(){<br>
		@Override<br>
		public void handleMessage(Message msg){<br>
			switch (msg.what) {<br>
			case MSG_FIRST_CARD_TURN:<br>
				for(int i=0;i&lt;CARD_SIZE;i++){<br>
					Card[i].setImage(false); // 모두 뒤집어서 뒷면을 전부 보여줌.<br>
				}<br>
				break;<br>
			case MSG_TURN_CARD:<br>
				Card[GM.getTurnCardNum()[0]].setImage(false); // 터치시 카드가 넘어가는 효과<br>
				Card[GM.getTurnCardNum()[1]].setImage(false);<br>
				GM.canTouchCard();<br>
				break;<br>
			<br>
			}<br>
		}<br>
	};<br>
	/**<br>
	 * 시간관련 부분을 제어하는 함수<br>
	 * handleMessage에서 <br>
	 * IN_GAME일 때,<br>
	 * 재귀되는 내용을 받는다.<br>
	 */<br>
	Handler mTimeHandler=new Handler(){<br>
		<br>
		@Override<br>
		public void handleMessage(Message msg){<br>
			switch (msg.what) {<br>
			case IN_GAME:<br>
				tv_time.setText(tm.getNowTime());<br>
				mTimeHandler.sendEmptyMessageDelayed(NowGameStatus, TIME_INTERVEL);<br>
				<br>
				break;<br>
			case PAUSE_GAME:<br>
				<br>
				break;<br>
			case FINISH_GAME:<br>
				setResult();<br>
				break;<br>
			default:<br>
			}<br>
		}<br>
	};<br>
<br>
	/**<br>
	 * 게임이 끝나면 출력되는 결과 메소드<br>
	 * 기록이 랭킹 안에 들면 랭킹 작성 화면 출력<br>
	 * 그렇지 않으면 게임 종료 화면 출력<br>
	 * */<br>
	public void setResult(){<br>
		<br>
		final float nowTime=Float.parseFloat(tv_time.getText().toString()); //게임의 시간 기록에 해당하는 변수<br>
		<br>
		if(ManagerPreference.isInRanking(nowTime)){ <br>
			<br>
			findViewById(R.id.rl_result).setVisibility(View.VISIBLE); //게임 끝남과 동시에 결과 화면을 보여줌.<br>
			<br>
			findViewById(R.id.btn_save).setOnClickListener(new OnClickListener() {<br>
				// save 버튼과 관련된 동작<br>
				@Override<br>
				public void onClick(View v) {<br>
					// TODO Auto-generated method stub<br>
					EditText et=(EditText)findViewById(R.id.et_name);<br>
					ManagerPreference.setRank(et.getText().toString(), nowTime);<br>
					Intent intent4 = new Intent(GameActivity.this,RankingActivity.class);<br>
					startActivity(intent4);<br>
				}<br>
			});<br>
			<br>
		}else{<br>
			findViewById(R.id.rl_result_no).setVisibility(View.VISIBLE);<br>
			findViewById(R.id.btn_close).setOnClickListener(new OnClickListener() {<br>
				@Override<br>
				public void onClick(View v) {<br>
					// TODO Auto-generated method stub<br>
					finish();<br>
				}<br>
			});<br>
		}<br>
	}<br>
	<br>
	/**<br>
	 * 게임 화면의 버튼들을 눌렀을 경우 <br>
	 * 해당 동작들을 설정해놓은 메소드<br>
	 * */<br>
		@Override<br>
	public void onClick(View v) {<br>
		// TODO Auto-generated method stub<br>
		switch (v.getId()) {<br>
		case R.id.restart_btn:<br>
			Intent intent=new Intent(GameActivity.this,GameActivity.class);<br>
			startActivity(intent);<br>
			overridePendingTransition(0, 0); // 바로 딜레이없이 새 게임<br>
			finish();<br>
			break;<br>
		case R.id.resume_btn:<br>
			tm.resumeTime();<br>
			NowGameStatus=IN_GAME;<br>
			mTimeHandler.sendEmptyMessageDelayed(NowGameStatus, 0);<br>
			findViewById(R.id.resume_btn).setClickable(false); //resume 혹은 pause 를 두 번 누르지 못하게 설정<br>
			findViewById(R.id.pause_btn).setClickable(true);<br>
			break;<br>
		case R.id.pause_btn:<br>
			tm.pauseTime();<br>
			NowGameStatus=PAUSE_GAME;<br>
			findViewById(R.id.resume_btn).setClickable(true);<br>
			findViewById(R.id.pause_btn).setClickable(false);<br>
			break;<br>
<br>
		default: //이 부분에서 게임 중 카드 2개씩만 뒤집기, 2개의 카드가 같은 경우와 다른 경우의 동작, 모두 맞춘 경우의 동작 등을 설정   <br>
			if(NowGameStatus==IN_GAME){<br>
				<br>
				if(GM.canTurnCard()){ //카드를 뒤집을 수 있는 경우 터치한 카드의 정보를 저장<br>
					int nowTouchCardNum=Integer.parseInt(v.getTag().toString());<br>
					int nowTouchCardImageValue=Card[nowTouchCardNum].getValue();<br>
					<br>
					if(Card[nowTouchCardNum].turnCard(true)){ //똑같은 카드 혹은 이미 맞춘 카드를 누른경우 누르지 못하게 하기 위함 <br>
						<br>
						GM.turnCard(nowTouchCardNum,nowTouchCardImageValue);<br>
						<br>
						if(GM.needToReturnCard()){<br>
							mGameHandler.sendEmptyMessageDelayed(MSG_TURN_CARD,TURN_CARD_TIME );<br>
<br>
						}<br>
						<br>
						if(GM.isAllCorrect())NowGameStatus=FINISH_GAME;<br>
					}<br>
					<br>
				}<br>
			}<br>
		}<br>
	}<br>
	<br>
	<br>
<br>
}<br>
</code></pre>

<ul><li>마지막에 기재된 참고 사이트에서 카드 게임의 논리를 참고했다. 논리만 참고하고 지난 1학기때 배운 C언어의 기본 개념을 최대한 활용하여 구성하였다. 핸드폰을 연결하여 계속해서 게임을 해보면서 동작을 제어하기 위한 변수를 하나씩 추가하면서 동작의 오류를 하나 하나 수정해나갔다.</li></ul>

<ul><li>일단 각 카드는 버튼으로 구성하여 터치를 인식할 수 있게 구성 하였고, 변수를 만들어 mod 계산을 통해 카드 자체를 난수 배열할 수 있는 구조로 짰다. 카드에 대한 정보는 난수 배열을 통해 얻은 수에 따라서 정보를 넘겨주게 하였다.</li></ul>

<pre><code>&lt;게임클래스 xml&gt;<br>
<br>
&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".GameActivity" &gt;<br>
    <br>
    &lt;RelativeLayout<br>
        android:id="@+id/top_layout"<br>
        android:layout_width="fill_parent"<br>
        android:layout_height="30dp"<br>
        android:background="#333" &gt;<br>
         <br>
    	&lt;TextView<br>
    	    android:id="@+id/tv_time"<br>
    	    android:layout_width="wrap_content"<br>
    	    android:layout_height="wrap_content"<br>
    	    android:layout_alignParentTop="true"<br>
    	    android:layout_centerHorizontal="true"<br>
    	    android:text="TIMER 00:00:00"<br>
    	    android:textColor="#FFFFFF" <br>
    	    /&gt;<br>
    &lt;/RelativeLayout&gt;<br>
    <br>
	&lt;RelativeLayout<br>
	    android:id="@+id/card_layout"<br>
	    android:layout_width="fill_parent"<br>
	    android:layout_height="280dp"<br>
	    android:layout_below="@id/top_layout" <br>
	    android:background="#808080"<br>
	    &gt;<br>
    	&lt;RelativeLayout <br>
    	    android:layout_width="wrap_content"<br>
    	    android:layout_height="wrap_content"<br>
    	    android:layout_centerInParent="true"&gt;<br>
	    &lt;ImageView<br>
		    android:id="@+id/btn0"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:background="@drawable/ic_launcher"/&gt;<br>
		    <br>
	    <br>
		&lt;ImageView<br>
		    android:id="@+id/btn1"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn0"<br>
		    android:layout_toRightOf="@id/btn0" <br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn2"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn0"<br>
		    android:layout_toRightOf="@id/btn1"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn3"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn0"<br>
		    android:layout_toRightOf="@id/btn2"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn4"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_below="@id/btn0"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn5"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn4"<br>
		    android:layout_toRightOf="@id/btn4"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn6"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn4"<br>
		    android:layout_toRightOf="@id/btn5"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn7"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn4"<br>
		    android:layout_toRightOf="@id/btn6"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn8"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_below="@id/btn4"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn9"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn8"<br>
		    android:layout_toRightOf="@id/btn8"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn10"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn8"<br>
		    android:layout_toRightOf="@id/btn9"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn11"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn8"<br>
		    android:layout_toRightOf="@id/btn10"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn12"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_below="@id/btn8"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn13"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn12"<br>
		    android:layout_toRightOf="@id/btn12"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn14"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn12"<br>
		    android:layout_toRightOf="@id/btn13"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
		<br>
		&lt;ImageView<br>
		    android:id="@+id/btn15"<br>
		    android:layout_width="55dip"<br>
		    android:layout_height="55dip"<br>
		    android:layout_alignTop="@id/btn12"<br>
		    android:layout_toRightOf="@id/btn14"<br>
            android:background="@drawable/ic_launcher"/&gt;<br>
				&lt;/RelativeLayout&gt;<br>
	&lt;/RelativeLayout&gt;<br>
		<br>
	&lt;RelativeLayout<br>
	    android:id="@+id/btn_layout"<br>
	    android:layout_width="fill_parent"<br>
	    android:layout_height="wrap_content"<br>
	    android:layout_below="@id/card_layout"<br>
	    android:background="#333" <br>
	     &gt;<br>
		<br>
	    &lt;Button <br>
	        android:id="@+id/restart_btn"<br>
	        android:layout_width="wrap_content"<br>
	        android:layout_height="wrap_content"<br>
	        android:text="Restart"<br>
	        android:layout_marginLeft="20dp"<br>
	        <br>
	        /&gt;<br>
		&lt;Button <br>
	        android:id="@+id/resume_btn"<br>
	        android:layout_width="wrap_content"<br>
	        android:layout_height="wrap_content"<br>
	        android:layout_toRightOf="@id/restart_btn"<br>
	        android:text="Resume"<br>
	        android:layout_marginLeft="10dp"<br>
	        <br>
	        /&gt;<br>
	    &lt;Button<br>
	        android:id="@+id/pause_btn"<br>
	        android:layout_width="wrap_content"<br>
	        android:layout_height="wrap_content"<br>
	        android:layout_alignParentRight="true"<br>
	        android:layout_alignParentTop="true"<br>
	        android:layout_marginRight="20dp"<br>
	        android:text=" pause " <br>
	        <br>
	        /&gt;<br>
	    <br>
	&lt;/RelativeLayout&gt;<br>
	<br>
	&lt;!-- 랭킹에 들었을때 화면 --&gt;<br>
	&lt;RelativeLayout<br>
	    android:id="@+id/rl_result"<br>
	    android:layout_width="fill_parent"<br>
	    android:layout_height="fill_parent"<br>
	    android:background="@drawable/congrats"<br>
	    android:visibility="gone"<br>
	    &gt;<br>
	    <br>
	    &lt;EditText <br>
	        android:id="@+id/et_name"<br>
	        android:layout_width="match_parent"<br>
	        android:layout_height="wrap_content"<br>
	        android:paddingLeft="15dp"<br>
	        android:layout_marginLeft="15dp"<br>
	        android:layout_marginRight="60dp"<br>
	        android:layout_marginTop="15dp"<br>
	        android:ems="10"<br>
	        android:maxLength="5"<br>
	        android:background="@drawable/round"<br>
	        android:inputType="textMultiLine"<br>
	        /&gt;<br>
	    <br>
	    &lt;Button <br>
	        android:id="@+id/btn_save"<br>
	        android:layout_width="wrap_content"<br>
	        android:layout_height="wrap_content"<br>
	        android:layout_below="@id/et_name"<br>
	        android:layout_marginRight="5dip"<br>
	        android:layout_alignParentRight="true"<br>
	        android:background="@drawable/save_btn"<br>
	        /&gt;<br>
	    <br>
	&lt;/RelativeLayout&gt;<br>
	<br>
	&lt;!-- 랭킹에 못들었을때 화면 --&gt;<br>
	&lt;RelativeLayout<br>
	    android:id="@+id/rl_result_no"<br>
	    android:layout_width="fill_parent"<br>
		android:layout_height="fill_parent"<br>
	    android:background="@drawable/tryag"<br>
	    android:visibility="gone"&gt;<br>
	    <br>
	    &lt;Button <br>
	        android:id="@+id/btn_close"<br>
	        android:layout_width="fill_parent"<br>
		    android:layout_height="fill_parent"<br>
		    /&gt;<br>
	    <br>
	&lt;/RelativeLayout&gt;<br>
&lt;/RelativeLayout&gt;<br>
</code></pre>

<br><br><br>


<h2>메인 클래스와 xml</h2>

<pre><code>&lt;메인클래스&gt;<br>
package com.example.matchinggame;<br>
<br>
import com.example.matchinggame.utils.ManagerPreference;<br>
import com.example.matchinggame.utils.ManagerSound;<br>
<br>
import android.app.Activity;<br>
import android.content.Intent;<br>
import android.os.Bundle;<br>
import android.view.Menu;<br>
import android.view.View;<br>
import android.view.View.OnClickListener;<br>
import android.view.animation.Animation;<br>
import android.view.animation.AnimationUtils;<br>
import android.widget.Button;<br>
<br>
<br>
public class MainActivity extends Activity implements OnClickListener {<br>
<br>
    @Override<br>
    protected void onCreate(Bundle savedInstanceState) {<br>
        super.onCreate(savedInstanceState);<br>
        setContentView(R.layout.activity_main);<br>
        ManagerPreference.make(this);<br>
        Button startbtn = (Button)findViewById(R.id.Startbtn);<br>
        startbtn.setOnClickListener(this); <br>
        <br>
        Button optbtn = (Button)findViewById(R.id.Optbtn);<br>
        optbtn.setOnClickListener(this); <br>
        <br>
        Button rankbtn = (Button)findViewById(R.id.Rankbtn);<br>
        rankbtn.setOnClickListener(this); <br>
        ManagerSound.load(this);<br>
        <br>
        Animation anim_logo=AnimationUtils.loadAnimation(this, R.anim.anim_logo);<br>
        findViewById(R.id.main_logo).startAnimation(anim_logo);<br>
    }<br>
    @Override<br>
    public void onResume(){<br>
    	super.onResume();<br>
    	if(ManagerPreference.getSound()){<br>
            ManagerSound.playSound(this);<br>
        }<br>
    }<br>
    @Override<br>
    public void onPause(){<br>
    	super.onPause();<br>
    	ManagerSound.pauseSound();<br>
    }<br>
<br>
	@Override<br>
	public void onClick(View v) { <br>
		// TODO Auto-generated method stub<br>
		switch(v.getId()){<br>
		<br>
			case R.id.Startbtn : <br>
				Intent intent1 = new Intent(this,GameActivity.class);<br>
				startActivity(intent1);<br>
				break;<br>
				<br>
			case R.id.Optbtn :<br>
				Intent intent2 = new Intent(this,OptionActivity.class);<br>
				startActivity(intent2);<br>
				break;<br>
				<br>
			case R.id.Rankbtn :<br>
				Intent intent3 = new Intent(this,RankingActivity.class);<br>
				startActivity(intent3);<br>
				break;<br>
		}<br>
	}<br>
}<br>
</code></pre>

<pre><code>&lt;메인 클래스 xml&gt;<br>
&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/LinearLayout1"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:orientation="vertical"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".MainActivity"<br>
    &gt;<br>
    <br>
    &lt;ImageView <br>
        android:alpha="0.8"<br>
        android:layout_width="fill_parent"<br>
        android:layout_height="fill_parent"<br>
   		android:background="@drawable/main"<br>
    /&gt;<br>
    <br>
    &lt;ImageView<br>
        android:id="@+id/main_logo"<br>
        android:layout_width="250dp"<br>
        android:layout_height="100dp"<br>
        android:layout_centerHorizontal="true"<br>
        android:layout_marginTop="20dp"<br>
        android:background="@drawable/mainlogo" <br>
        /&gt;<br>
        <br>
    &lt;Button<br>
        android:id="@+id/Startbtn"<br>
        android:layout_width="fill_parent"<br>
        android:layout_height="wrap_content"<br>
        android:background="#00000000"<br>
        android:text="StartGame"<br>
        android:layout_marginTop="200dp"<br>
        /&gt;<br>
    <br>
    &lt;Button<br>
        android:id="@+id/Rankbtn"<br>
        android:layout_width="fill_parent"<br>
        android:layout_height="wrap_content"<br>
        android:background="#00000000"<br>
        android:text="Ranking" <br>
        android:layout_below="@id/Startbtn"<br>
         /&gt;<br>
<br>
    &lt;Button<br>
        android:id="@+id/Optbtn"<br>
        android:layout_width="fill_parent"<br>
        android:layout_height="wrap_content"<br>
        android:background="#00000000"<br>
        android:text="Option"<br>
        android:layout_below="@id/Rankbtn"<br>
        /&gt;<br>
<br>
&lt;/RelativeLayout&gt;<br>
</code></pre>


<br><br><br>

<h2>옵션 클래스와 xml</h2>

<pre><code>&lt;옵션클래스&gt;<br>
package com.example.matchinggame;<br>
<br>
import com.example.matchinggame.utils.ManagerPreference;<br>
import com.example.matchinggame.utils.ManagerSound;<br>
<br>
import android.os.Bundle;<br>
import android.app.Activity;<br>
import android.view.Menu;<br>
import android.view.View;<br>
import android.view.View.OnClickListener;<br>
import android.widget.CompoundButton;<br>
import android.widget.RadioGroup;<br>
import android.widget.ToggleButton;<br>
import android.widget.RadioGroup.OnCheckedChangeListener;<br>
<br>
public class OptionActivity extends Activity implements OnCheckedChangeListener,android.widget.CompoundButton.OnCheckedChangeListener {<br>
<br>
	@Override<br>
	protected void onCreate(Bundle savedInstanceState) {<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.activity_option);<br>
		<br>
		findViewById(R.id.Rankreset_btn).setOnClickListener(new OnClickListener() {<br>
			<br>
			@Override<br>
			public void onClick(View arg0) {<br>
				// TODO Auto-generated method stub<br>
				ManagerPreference.setRankingReset();<br>
			}<br>
		});<br>
		<br>
		RadioGroup rg=(RadioGroup)findViewById(R.id.radio);<br>
		<br>
		switch (ManagerPreference.getCard()) {<br>
		case 0:<br>
			rg.check(R.id.radio_btn1);<br>
			break;<br>
		case 1:<br>
			rg.check(R.id.radio_btn2);<br>
			break;<br>
		case 2:<br>
			rg.check(R.id.radio_btn3);<br>
			break;<br>
		}<br>
		rg.setOnCheckedChangeListener(this);<br>
		<br>
		ToggleButton Sonoff_btn=(ToggleButton)findViewById(R.id.Sonoff_btn);<br>
		Sonoff_btn.setChecked(ManagerPreference.getSound());<br>
		Sonoff_btn.setOnCheckedChangeListener(this);<br>
	}<br>
<br>
	@Override<br>
	public void onCheckedChanged(RadioGroup arg0, int clickBtn) {<br>
		// TODO Auto-generated method stub<br>
		switch (clickBtn) {<br>
		case R.id.radio_btn1:<br>
			ManagerPreference.setCard(0);<br>
			break;<br>
		case R.id.radio_btn2:<br>
			ManagerPreference.setCard(1);<br>
			break;<br>
		case R.id.radio_btn3:<br>
			ManagerPreference.setCard(2);<br>
			break;<br>
		}<br>
	}<br>
	@Override<br>
    public void onResume(){<br>
    	super.onResume();<br>
    	if(ManagerPreference.getSound()){<br>
            ManagerSound.playSound(this);<br>
        }<br>
    }<br>
    @Override<br>
    public void onPause(){<br>
    	super.onPause();<br>
    	ManagerSound.pauseSound();<br>
    }<br>
	@Override<br>
	public void onCheckedChanged(CompoundButton arg0, boolean isClicked) {<br>
		// TODO Auto-generated method stub<br>
		ManagerPreference.setSound(isClicked); // 사용자의 정보를 저장해주는 것<br>
		if(isClicked){<br>
			ManagerSound.playSound(this); // 저장한 정보를 실행시킬지말지를 결정해주는 것<br>
		}else{<br>
			ManagerSound.pauseSound();<br>
		}<br>
	}<br>
<br>
}<br>
</code></pre>

<pre><code>&lt;옵션 클래스 xml&gt;<br>
&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".OptionActivity" <br>
    <br>
    &gt;<br>
    &lt;ImageView <br>
        android:alpha="0.7"<br>
        android:layout_width="fill_parent"<br>
    android:layout_height="fill_parent"<br>
    android:background="@drawable/option"/&gt;<br>
<br>
    &lt;TextView<br>
        android:id="@+id/Sound_btn"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_marginLeft="40dp"<br>
        android:layout_marginTop="40dp"<br>
        android:text="사운드"<br>
        android:textStyle="bold"<br>
        /&gt;<br>
   <br>
    &lt;TextView<br>
        android:id="@+id/Image_btn"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_below="@id/Sound_btn"<br>
        android:layout_marginLeft="40dp"<br>
        android:layout_marginTop="40dp"<br>
        android:text="이미지" <br>
        android:textStyle="bold"<br>
        /&gt;<br>
<br>
    &lt;ToggleButton<br>
        android:id="@+id/Sonoff_btn"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_alignBaseline="@+id/Sound_btn"<br>
        android:layout_alignBottom="@+id/Sound_btn"<br>
        android:layout_marginLeft="55dp"<br>
        android:layout_toRightOf="@+id/Sound_btn"<br>
        android:textOff="OFF"<br>
        android:textOn="ON"<br>
        /&gt;<br>
    &lt;RadioGroup <br>
        android:id="@+id/radio"<br>
        <br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
         android:layout_alignBaseline="@+id/Image_btn"<br>
        android:layout_alignBottom="@+id/Image_btn"<br>
        android:layout_marginLeft="55dp"<br>
        android:layout_toRightOf="@+id/Sound_btn"&gt;<br>
    &lt;RadioButton<br>
        android:id="@+id/radio_btn1"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
       <br>
        android:text="Professor" <br>
        /&gt;<br>
<br>
    &lt;RadioButton<br>
        android:id="@+id/radio_btn2"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_below="@id/radio_btn1"<br>
        android:layout_alignLeft="@id/radio_btn1"<br>
        android:layout_marginTop="10dp"<br>
        android:text="Card" <br>
        /&gt;<br>
<br>
    &lt;RadioButton<br>
        android:id="@+id/radio_btn3"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_below="@id/radio_btn2"<br>
        android:layout_alignLeft="@id/radio_btn2"<br>
        android:layout_marginTop="10dp"<br>
        android:text="Animal" <br>
        /&gt;<br>
    &lt;/RadioGroup&gt;<br>
    &lt;Button <br>
        android:id="@+id/Rankreset_btn"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_centerHorizontal="true"<br>
        android:layout_below="@id/radio"<br>
        android:layout_marginTop="150dp"<br>
        android:text="Ranking Reset"<br>
        /&gt;<br>
    <br>
   <br>
    <br>
 &lt;/RelativeLayout&gt;<br>
</code></pre>

<br><br><br>


<h2>랭킹 클래스와 xml</h2>

<pre><code>package com.example.matchinggame;<br>
<br>
import android.app.Activity;<br>
import android.app.IntentService;<br>
import android.content.Intent;<br>
import android.os.Bundle;<br>
import android.view.View;<br>
import android.view.View.OnClickListener;<br>
import android.widget.TextView;<br>
<br>
import com.example.matchinggame.utils.ManagerPreference;<br>
import com.example.matchinggame.utils.ManagerSound;<br>
<br>
public class RankingActivity extends Activity implements OnClickListener {<br>
	public static final String mPackage="com.example.matchinggame";<br>
	<br>
	@Override<br>
	protected void onCreate(Bundle savedInstanceState) {<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.activity_ranking);<br>
		for(int i=0;i&lt;7;i++){<br>
			//TextView test=(TextView)findViewById(R.id.name_0+i); 자바에선 이런식의 표현 X<br>
			//TextView test=(TextView)findViewById(R.id.name_0);<br>
			// com.example.matchinggame.R.id.name_0  이렇게 일일이 써주지 않기 위해 다음과 같이 표현<br>
			TextView tv=(TextView)findViewById(getResources().getIdentifier("name_"+i,"id",mPackage));<br>
			tv.setText(ManagerPreference.getName(i));<br>
			TextView tv2=(TextView)findViewById(getResources().getIdentifier("time_"+i,"id",mPackage));<br>
			tv2.setText(ManagerPreference.getTime(i));<br>
			<br>
		findViewById(R.id.btn_close2).setOnClickListener(new OnClickListener() {<br>
			<br>
			@Override<br>
			public void onClick(View v) {<br>
				// TODO Auto-generated method stub<br>
				Intent intent5 = new Intent(RankingActivity.this,MainActivity.class);<br>
				startActivity(intent5);<br>
				<br>
			}<br>
		});<br>
		}<br>
	}<br>
<br>
	@Override<br>
    public void onResume(){<br>
    	super.onResume();<br>
    	if(ManagerPreference.getSound()){<br>
            ManagerSound.playSound(this);<br>
        }<br>
    }<br>
    @Override<br>
    public void onPause(){<br>
    	super.onPause();<br>
    	ManagerSound.pauseSound();<br>
    }<br>
<br>
	@Override<br>
	public void onClick(View v) {<br>
		// TODO Auto-generated method stub<br>
		<br>
	}<br>
<br>
	<br>
}<br>
</code></pre>

<pre><code>&lt;랭킹 클래스 xml&gt;<br>
&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".RankingActivity" &gt;<br>
<br>
    &lt;Button<br>
        android:id="@+id/btn_close2"<br>
        android:layout_width="fill_parent"<br>
        android:layout_height="fill_parent" /&gt;<br>
<br>
    &lt;ImageView<br>
        android:layout_width="fill_parent"<br>
        android:layout_height="fill_parent"<br>
        android:alpha="0.8"<br>
        android:background="@drawable/rank" /&gt;<br>
<br>
    &lt;RelativeLayout<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:layout_centerInParent="true" &gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/fir"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_marginRight="15dp"<br>
            android:text="1 ."<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/sec"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/fir"<br>
            android:layout_alignTop="@+id/name_1"<br>
            android:layout_marginRight="15dp"<br>
            android:text="2 ."<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/thi"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/fir"<br>
            android:layout_alignTop="@+id/name_2"<br>
            android:layout_marginRight="15dp"<br>
            android:text="3 ."<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/fou"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/fir"<br>
            android:layout_alignTop="@+id/name_3"<br>
            android:layout_marginRight="15dp"<br>
            android:text="4 ."<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/fif"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/fir"<br>
            android:layout_alignTop="@+id/name_4"<br>
            android:layout_marginRight="15dp"<br>
            android:text="5 ."<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/six"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/fir"<br>
            android:layout_alignTop="@+id/name_5"<br>
            android:layout_marginRight="15dp"<br>
            android:text="6 ."<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/sev"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/fir"<br>
            android:layout_alignTop="@+id/name_6"<br>
            android:layout_marginRight="15dp"<br>
            android:text="7 ."<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/name_0"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_toRightOf="@id/fir"<br>
            android:text="임태휘천재"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/name_1"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/name_0"<br>
            android:layout_below="@id/name_0"<br>
            android:layout_marginTop="15dp"<br>
            android:text="Ilovejava"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/name_2"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/name_1"<br>
            android:layout_below="@id/name_1"<br>
            android:layout_marginTop="15dp"<br>
            android:text="자바자바자바"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/name_3"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/name_2"<br>
            android:layout_below="@id/name_2"<br>
            android:layout_marginTop="15dp"<br>
            android:text="잡자자바"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/name_4"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/name_3"<br>
            android:layout_below="@id/name_3"<br>
            android:layout_marginTop="15dp"<br>
            android:text="룰루랄라뛰뛰빵빵"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/name_5"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/name_4"<br>
            android:layout_below="@id/name_4"<br>
            android:layout_marginTop="15dp"<br>
            android:text="정예컴교"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/name_6"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignLeft="@id/name_5"<br>
            android:layout_below="@id/name_5"<br>
            android:layout_marginTop="15dp"<br>
            android:text="청년사대"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/time_0"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignParentRight="true"<br>
            android:layout_marginRight="15dip"<br>
            android:text="00:00:00"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/time_1"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignParentRight="true"<br>
            android:layout_alignTop="@id/name_1"<br>
            android:layout_marginRight="15dip"<br>
            android:text="00:00:00"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/time_2"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignParentRight="true"<br>
            android:layout_alignTop="@id/name_2"<br>
            android:layout_marginRight="15dip"<br>
            android:text="00:00:00"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/time_3"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignParentRight="true"<br>
            android:layout_alignTop="@id/name_3"<br>
            android:layout_marginRight="15dip"<br>
            android:text="00:00:00"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/time_4"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignParentRight="true"<br>
            android:layout_alignTop="@id/name_4"<br>
            android:layout_marginRight="15dip"<br>
            android:text="00:00:00"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/time_5"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignParentRight="true"<br>
            android:layout_alignTop="@id/name_5"<br>
            android:layout_marginRight="15dip"<br>
            android:text="00:00:00"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
<br>
        &lt;TextView<br>
            android:id="@+id/time_6"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:layout_alignParentRight="true"<br>
            android:layout_alignTop="@id/name_6"<br>
            android:layout_marginRight="15dip"<br>
            android:text="00:00:00"<br>
            android:textColor="#FFFFFF"<br>
            android:textSize="20sp"<br>
            android:textStyle="bold" /&gt;<br>
    &lt;/RelativeLayout&gt;<br>
<br>
&lt;/RelativeLayout&gt;<br>
</code></pre>

<br><br><br>


<h2>카드 매니저 클래스</h2>

<pre><code>package com.example.matchinggame.game;<br>
<br>
import com.example.matchinggame.R;<br>
<br>
import android.widget.ImageView;<br>
<br>
public class CardManager {<br>
	private int value;<br>
	private ImageView iv;<br>
	private int ImageSource;<br>
	private boolean canTouch; // 현재 터치한 위치를 다시 터치할 수 없게 하기 위한 변수<br>
<br>
	/**<br>
	 * i 는 GameActivity 내에서의 카드 위치에 해당하는 값<br>
	 * v 카드의 value (양, 소 , 토끼것의 값)<br>
	 * imageView (layout xml의 이미지 뷰의 위치 값)<br>
	 * ImageSource (양, 소 , 토끼 등의 값의 이미지 drawable 내의 카드 그림에 해당하는 값);<br>
	 */<br>
	public CardManager(int i,int v,ImageView imageView,int is){ //카드 매니저의 생성자<br>
		<br>
		value=v;<br>
		iv=imageView;<br>
		iv.setTag(i);<br>
		ImageSource=is;<br>
		canTouch=true;<br>
	}<br>
	<br>
	public ImageView getImageView(){<br>
		return iv;<br>
	}<br>
	<br>
	public int getValue(){<br>
		return value;<br>
	}<br>
	<br>
	/**<br>
	 * 게임 진행 중 동작과 관련된 이미지 설정 메소드<br>
	 * isBack 이 true 면 카드의 뒷면(내용)을 보여주고, false 면 카드의 앞면(가리개 카드)을 보여줌.<br>
	 */<br>
	public void setImage(boolean isBack){<br>
<br>
			if(isBack){<br>
				iv.setBackgroundResource(ImageSource);<br>
<br>
			}else{<br>
				iv.setBackgroundResource(R.drawable.card_back);<br>
				canTouch=true;<br>
			}<br>
	}<br>
	<br>
	/**<br>
	 * 게임 진행 중 터치 시 카드의 동작과 관련된 메소드<br>
	 * isBack 이 true 인 경우 뒷면을 보여주면서 해당 위치의 카드는 터치 불가능하게 설정<br>
	 * isBack 이 false 인 경우 그대로 앞면을 보여주면서 해당 위치의 카드를 터치가 가능한 상태로 설정 <br>
	 * */<br>
	public boolean turnCard(boolean isBack){<br>
		if(canTouch){<br>
			if(isBack){<br>
				iv.setBackgroundResource(ImageSource);<br>
				canTouch=false;<br>
			}else{ <br>
				iv.setBackgroundResource(R.drawable.card_back);<br>
				canTouch=true;<br>
			}<br>
			return true;<br>
		}<br>
		return false;<br>
	}<br>
}<br>
</code></pre>

<br><br><br>


<h2>게임 매니저 클래스</h2>

<pre><code>package com.example.matchinggame.game;<br>
<br>
public class GameManager {<br>
	public static final int CORRECT_ALL=8;<br>
	public int nowCorrect=0; // 현재 맞춘 카드 쌍의 개수<br>
	public static final int MAX_TURN_CARD=2;<br>
	private int nowTurnCount=0; // 현재 몇 장의 카드를 넘겼나에 해당하는 변수<br>
	<br>
	private int firstCardValue=-1; //첫 번째 누른 카드와 두 번째 누른 카드의 비교를 위한 변수들<br>
	private int secondCardValue=-1;<br>
	private int firstCardNum=-1;<br>
	private int secondCardNum=-1;<br>
	<br>
	/**<br>
	 * 카드를 넘길 수 있는지에 여부를 알려주는 메소드<br>
	 * 2장 이상을 넘길 수 없다. <br>
	 * */<br>
	public boolean canTurnCard(){<br>
		if(nowTurnCount==MAX_TURN_CARD){<br>
			return false;<br>
		}<br>
		return true;<br>
	}<br>
	<br>
	/**<br>
	 *게임 중 카드를 누르게되면 <br>
	 *누른 카드의 정보를 저장해주는 메소드 <br>
	 * */<br>
	public void turnCard(int nowTouchCardNum,int nowTouchedCardImageValue){<br>
		if(nowTurnCount==0){<br>
			firstCardNum=nowTouchCardNum;<br>
			firstCardValue=nowTouchedCardImageValue;<br>
		}<br>
		if(nowTurnCount==1){<br>
			secondCardNum=nowTouchCardNum;<br>
			secondCardValue=nowTouchedCardImageValue;<br>
		}<br>
		nowTurnCount++;<br>
	}<br>
	<br>
	/**<br>
	 * 모든 카드가 맞춰진 경우를 알려주는 메소드<br>
	 * */<br>
	public boolean isAllCorrect(){<br>
		if(nowCorrect==CORRECT_ALL){<br>
			return true;<br>
		}<br>
		<br>
		return false;<br>
	}<br>
	<br>
	/**<br>
	 * 뒤집은 2장의 카드에 대한 동작을 위한 메소드<br>
	 * 맞춘 경우 : 그대로 놔둠, 틀린 경우 : 카드의 뒷면으로 뒤집기 <br>
	 * */<br>
	public boolean needToReturnCard(){<br>
		if(nowTurnCount==2){<br>
			if(firstCardValue==secondCardValue){<br>
				nowTurnCount=0;<br>
				nowCorrect++;<br>
			}else{<br>
				<br>
				return true;<br>
			}<br>
		}<br>
		return false;<br>
	}<br>
	<br>
	/**<br>
	 * 현재 뒤집은 카드의 위치가 뭔지 알려주는 함수<br>
	 * @return<br>
	 */<br>
	public int[] getTurnCardNum(){<br>
		int[] temp={firstCardNum,secondCardNum};<br>
		return temp;<br>
	}<br>
	<br>
	/**<br>
	 * 터치했을 때 카드의 동작 가능 상태로 변경해주는 메소드<br>
	 * */<br>
	public void canTouchCard() {<br>
		nowTurnCount=0;<br>
		<br>
	}<br>
<br>
}<br>
</code></pre>

<br><br><br>


<h2>난수 생성 클래스</h2>

<pre><code>package com.example.matchinggame.game;<br>
<br>
import java.util.Random;<br>
<br>
public class GenerateRandom {<br>
	<br>
	public static int[] getRandom(int SIZE){<br>
		<br>
		int[] randList=new int[SIZE];<br>
		Random r=new Random();<br>
		<br>
		for(int i=0;i&lt;randList.length;i++){<br>
			<br>
			while(true){<br>
				<br>
				int value=r.nextInt(SIZE); //size 내의 수를 랜덤하게  생성<br>
				boolean inFlag=true; // 랜덤하게 생성시킨  값이 이전의 생성값과 같은 경우 false<br>
				<br>
				for(int j=0;j&lt;i;j++){ // 기존의 randList[i]에 value 를 넣고  randList[j]를 통해  <br>
					if(randList[j]==value){ //앞에서부터 비교하여 현재 randList[i]의 위치에 동일한 값이 들어가지 않도록 해줌. <br>
						inFlag=false;<br>
					}<br>
				}<br>
				if(inFlag){ // 동일한지 여부가 판별되어 이전의 숫자들과 다른 값인 경우 randList[i]에 대입<br>
					randList[i]=value;<br>
					break;<br>
				}<br>
			}<br>
		}<br>
		return randList;<br>
	}<br>
}<br>
</code></pre>

<br><br><br>


<h2>타임 매니저 클래스</h2>

<pre><code>package com.example.matchinggame.game;<br>
<br>
public class TimeManager {<br>
	<br>
	long startTime = 0;<br>
	long pauseTime =0;<br>
	<br>
	/**<br>
	 * 시작 시간을 저장<br>
	 */<br>
	public void startGame() {<br>
		startTime = System.currentTimeMillis(); // 게임이 시작되면 시작시간에 현재시간을 대입<br>
	}<br>
	/**<br>
	 * 현재시간을 가져오는 함수<br>
	 * @return<br>
	 */<br>
	public String getNowTime() {<br>
		return String.format("%.3f",(float)(System.currentTimeMillis() - startTime)/1000); <br>
	} // 현재시간에서 이전에 저장해놓은 시간을 빼서 걸린 시간을 return<br>
	/**<br>
	 * 일시정지 함수<br>
	 */<br>
	public void pauseTime(){<br>
		pauseTime = System.currentTimeMillis(); // pause시 현재 시간을 대입<br>
	}<br>
	/**<br>
	 * 재시작 하는 함수<br>
	 */<br>
	public void resumeTime(){<br>
		startTime+=System.currentTimeMillis()-pauseTime; <br>
	} // pause시 시간과 현재시간의 관계를 이용하여 startTime을 새로 설정<br>
<br>
}<br>
</code></pre>

<br><br><br>


<h2>매니저 프리퍼런스 클래스</h2>

<pre><code>package com.example.matchinggame.utils;<br>
<br>
import android.app.Activity;<br>
import android.content.SharedPreferences;<br>
import android.preference.PreferenceManager;<br>
<br>
public class ManagerPreference {<br>
	private static ManagerPreference singleton = null; <br>
	// Preference 관리자는 하나만  있다는 뜻, 객체가 해당 정보를 가지고<br>
	//있어야 하므로 생성한 뒤 계속 살아있게  한  것이다.<br>
	<br>
	private static SharedPreferences prefs = null; // 실제 관리하는 sharedPreference<br>
	private static final String TEMP_NAME = "나잡아봐라";<br>
<br>
	private ManagerPreference(Activity act) {<br>
		prefs = PreferenceManager.getDefaultSharedPreferences(act); <br>
		// pref의 생성자이며, 기본적으로  선언되는 부분 <br>
	}<br>
<br>
	/**<br>
	 * ManagerPreference를 생성하는 함수 맨 처음 어플 실행 시 한번 호출 생성자<br>
	 */<br>
	public static ManagerPreference make(Activity act) {<br>
		singleton = new ManagerPreference(act);<br>
		return singleton;<br>
	}<br>
<br>
	/**<br>
	 * 결과값이 랭킹에 진입하였는지 여부 확인하는 함수<br>
	 */<br>
	public static boolean isInRanking(float nowTime) { <br>
		// 게임 기록이 랭킹 안에 드는지 알려주는 메소드<br>
		<br>
		if (nowTime &lt; prefs.getFloat("rankTime" + 6, 1000f)) {<br>
			return true;<br>
		}<br>
		return false;<br>
<br>
	}<br>
<br>
	/**<br>
	 * 랭킹을 등록하는 함수<br>
	 */<br>
	public static void setRank(String name, float nowTime) {<br>
		int nowRank = 0;<br>
<br>
		for (int i = 0; i &lt; 7; i++) { // 현재 기록이 랭킹 내에서 몇 번째인지 검사<br>
			if (nowTime &gt;= prefs.getFloat("rankTime" + i, 1000f)) {<br>
				nowRank = i + 1;<br>
			}<br>
		}<br>
		for (int i = 5; i &gt;= nowRank; i--) { <br>
			// 현재 기록이 들어갈 랭킹 번째 수까지 뒤로 복사해서 붙여 넣어주는 역할<br>
			<br>
			SharedPreferences.Editor editor = prefs.edit();<br>
			editor.putString("rankName" + (i + 1),<br>
					prefs.getString("rankName" + i, TEMP_NAME));<br>
			editor.putFloat("rankTime" + (i + 1),<br>
					prefs.getFloat("rankTime" + i, 1000f));<br>
			editor.commit();<br>
		}<br>
<br>
		SharedPreferences.Editor editor = prefs.edit(); <br>
		// 현재 기록의 랭킹 란에 이름과 기록을  넣어줌.<br>
		<br>
		editor.putString("rankName" + nowRank, name);<br>
		editor.putFloat("rankTime" + nowRank, nowTime);<br>
		editor.commit();<br>
<br>
	}<br>
<br>
	/**<br>
	 * num에 해당하는 랭킹의 이름을 갖고오는 함수<br>
	 */<br>
	public static String getName(int num) {<br>
		return prefs.getString("rankName" + num, TEMP_NAME);<br>
	}<br>
<br>
	/**<br>
	 * num에 해당하는 랭킹의 시간을 갖고오는 함수<br>
	 */<br>
	public static String getTime(int num) {<br>
		return Float.toString(prefs.getFloat("rankTime" + num, 1000f));<br>
	}<br>
<br>
	/**<br>
	 * 랭킹을 초기화하는 함수<br>
	 */<br>
	public static void setRankingReset() {<br>
		for (int i = 0; i &lt; 7; i++) {<br>
			SharedPreferences.Editor editor = prefs.edit();<br>
			editor.putString("rankName" + i, TEMP_NAME);<br>
			editor.putFloat("rankTime" + i, 1000f);<br>
			editor.commit();<br>
		}<br>
	}<br>
<br>
	/**<br>
	 * 사용자가 쓸 카드를 지정<br>
	 */<br>
	public static void setCard(int i) {<br>
		SharedPreferences.Editor editor = prefs.edit();<br>
		editor.putInt("card", i);<br>
		editor.commit();<br>
	}<br>
<br>
	/**<br>
	 * 사용자가 쓸 카드 정보를 가져옴<br>
	 * <br>
	 * @return 교수님//카드//동물<br>
	 */<br>
	public static int getCard() {<br>
		return prefs.getInt("card", 0);<br>
	}<br>
<br>
	/**<br>
	 * 사용자가 사운드를 사용할지를 결정<br>
	 */<br>
	public static void setSound(boolean b) {<br>
		SharedPreferences.Editor editor = prefs.edit();<br>
		editor.putBoolean("sound", b);<br>
		editor.commit();<br>
	}<br>
<br>
	/**<br>
	 * 사용자가 사운드를 사용하는지 여부를 판단<br>
	 */<br>
	public static boolean getSound() {<br>
		return prefs.getBoolean("sound", true);<br>
	}<br>
}<br>
</code></pre>

<br><br><br>


<h2>매니저 사운드 클래스</h2>

<pre><code>package com.example.matchinggame.utils;<br>
<br>
import com.example.matchinggame.R;<br>
<br>
import android.content.Context;<br>
import android.media.MediaPlayer;<br>
<br>
public class ManagerSound {<br>
	private static ManagerSound singleton = null; <br>
	// 노래 관리자는 어플에서 단 하나만 써야하기 때문에 싱글톤으로 구현하였음.<br>
	private static MediaPlayer mPlayer = null; // 실제 음악을 재생하는 Media Player<br>
<br>
	/**<br>
	 * 맨 처음 노래를 로드하는 함수 버퍼링<br>
	 */<br>
	public synchronized static void load(Context context) {<br>
		if (singleton == null) {<br>
			singleton = new ManagerSound(context);<br>
		}<br>
	}<br>
<br>
	private ManagerSound(Context context) { // mPlayer의 생성자<br>
		super();<br>
		mPlayer = MediaPlayer.create(context, R.raw.sound);<br>
	}<br>
<br>
	/**<br>
	 * 노래를 재생하는 함수<br>
	 */<br>
	public synchronized static void playSound(Context context) {<br>
		if (mPlayer == null) {<br>
			mPlayer = MediaPlayer.create(context, R.raw.sound); <br>
			<br>
			// mPlayer가 혹시  안 만들어졌을 경우 만들어주는 함수<br>
		}<br>
		mPlayer.start();<br>
	}<br>
<br>
	/**<br>
	 * 노래를 멈추는 함수<br>
	 */<br>
	public synchronized static void pauseSound() {<br>
		mPlayer.pause();<br>
	}<br>
<br>
}<br>
</code></pre>



<br><br><br><br>

<h1>참고 문헌 및 사이트</h1>


<ul><li>카드 게임 논리 참고 : <a href='http://manong.tistory.com/199'>http://manong.tistory.com/199</a></li></ul>

<ul><li>Do it! 안드로이드 앱 프로그래밍(이지스퍼블리싱) - 교수님 추천 도서</li></ul>

<blockquote>- 오디오 재생, 레이아웃 구성, 핸들러 사용, 애니메이션 구현, 카드 눌렀을 때 이미지 변환, 텍스트 상자 띄우기 등을 구성하는데 참고함.(대부분 여기서 내용과 검색 내용을 참조하였다.)</blockquote>

<ul><li>핸들러를 이용한 타이머 참고 : <a href='http://androidmetro.blogspot.kr/2011/06/blog-post_23.html'>http://androidmetro.blogspot.kr/2011/06/blog-post_23.html</a></li></ul>

<ul><li>랭킹 사항 저장, 카드 변경 사항 저장, 사운드 세팅 및 변경 사항 등을 DB를 사용하지 않고 영속적으로 저장하기 위한 Shared Preferences 구성 참고 : <a href='http://blog.naver.com/PostView.nhn?blogId=ljsk139&logNo=30177409995'>http://blog.naver.com/PostView.nhn?blogId=ljsk139&amp;logNo=30177409995</a><br><a href='http://muzesong.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-SharedPreferences-%EA%B9%94%EB%81%94%ED%95%98%EA%B2%8C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0'>http://muzesong.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-SharedPreferences-%EA%B9%94%EB%81%94%ED%95%98%EA%B2%8C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0</a></li></ul>


<br><br><br><br>


<h1>어플리케이션 소스 파일 압축 자료 및 apk파일</h1>


<ul><li>어플리케이션 소스 파일 압축 자료</li></ul>

<a href='http://comp166-koreauniv.googlecode.com/files/MatchingGameTH.zip'>http://comp166-koreauniv.googlecode.com/files/MatchingGameTH.zip</a>


<ul><li>프로그램의 실행만을 원하시면 apk파일을 다운받아주세요.</li></ul>

<a href='http://comp166-koreauniv.googlecode.com/files/MatchingGame.apk'>http://comp166-koreauniv.googlecode.com/files/MatchingGame.apk</a>





