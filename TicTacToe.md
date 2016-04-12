# Introduction #

간단한 게임을 통해 승자와 패자를 정할 수 있는 게임! 1분 안에 모든걸 끝낸다!


# Details #

![http://comp166-koreauniv.googlecode.com/files/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4.png](http://comp166-koreauniv.googlecode.com/files/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4.png) 메인화면입니다. ![https://comp166-koreauniv.googlecode.com/files/%ED%94%8C%EB%A0%88%EC%9D%B4%EC%96%B4%EC%84%A4%EC%A0%95.png](https://comp166-koreauniv.googlecode.com/files/%ED%94%8C%EB%A0%88%EC%9D%B4%EC%96%B4%EC%84%A4%EC%A0%95.png) 플레이어설정화면입니다. ![http://comp166-koreauniv.googlecode.com/files/%EB%8F%84%EC%9B%80%EB%A7%90.png](http://comp166-koreauniv.googlecode.com/files/%EB%8F%84%EC%9B%80%EB%A7%90.png) 도움말화면입니다. ![https://comp166-koreauniv.googlecode.com/files/%EA%B2%8C%EC%9E%84%ED%99%94%EB%A9%B4.png](https://comp166-koreauniv.googlecode.com/files/%EA%B2%8C%EC%9E%84%ED%99%94%EB%A9%B4.png) 게임화면입니다.

Player1을 미현. Player2를 수현(동생ㅎ)이라고 하고 게임을 해보았습니다.

![http://comp166-koreauniv.googlecode.com/files/Player1win.png](http://comp166-koreauniv.googlecode.com/files/Player1win.png) Player1이 이길경우. ![http://comp166-koreauniv.googlecode.com/files/Player2win.png](http://comp166-koreauniv.googlecode.com/files/Player2win.png) Player2가 이길경우. ![http://comp166-koreauniv.googlecode.com/files/Gamedraw.png](http://comp166-koreauniv.googlecode.com/files/Gamedraw.png) 게임이 비길경우.

자세히 보면 밑에 scoreboard에 1이 증가되는 것을 볼 수 있다.ㅎㅎ


# 소스코드 #

코드출처 : http://code.google.com/p/tictactoe4android/

이 코드에는 컴퓨터와도 하는 모드가 있으나 그걸 생략했다. 도저히 실행이 안됐다.

생략한 부분을 빼면 거의 같다. 흠.....네..

4X4도 만들어볼까 시도해보았지만 4X4모드는 자체가 게임진행이 되지않아서 없애버렸다.

전체파일 : http://comp166-koreauniv.googlecode.com/files/Linematch.zip

apk파일 : https://comp166-koreauniv.googlecode.com/files/Linematch%5B1%5D.apk

# 클래스 #

http://comp166-koreauniv.googlecode.com/files/%EB%A0%88%EC%9D%B4%EC%95%84%EC%9B%83.PNG

그래서 TicTacToe.java와 연동되는 레이아웃은 main.xml이며 나머지 help, name\_dialog\_2, three xml파일은 따로 추가를 한 것이다. 그래서 클래스 안에서 레이아웃으로 넘어가도록 만들었다.

drawable 폴더에는 O모양 X모양 그림과 scoreboard모양, 아이콘모양, 틱택토간판모양, 도움말그림의 파일이 있다.


액티비티는 처음 메인화면만 만들고 나머지는 xml layout file을 추가하는 형식으로 해서 클래스 파일이 하나밖에 없다.

![http://comp166-koreauniv.googlecode.com/files/%ED%81%B4%EB%9E%98%EC%8A%A4%EC%86%8C%EA%B0%9C.png](http://comp166-koreauniv.googlecode.com/files/%ED%81%B4%EB%9E%98%EC%8A%A4%EC%86%8C%EA%B0%9C.png)


![http://comp166-koreauniv.googlecode.com/files/%EB%A9%94%EC%9D%B8%ED%81%B4%EB%9E%98%EC%8A%A4.png](http://comp166-koreauniv.googlecode.com/files/%EB%A9%94%EC%9D%B8%ED%81%B4%EB%9E%98%EC%8A%A4.png)

메인클래스 안에서 모든 일을 처리하기 때문에 함수도 많고 무엇보다 전역변수를 많이 선언하였다.

OnClickListener 를 이용한 함수가 2개가 있다. Welcome\_listener 와 Button\_listener가 있다.

그리고 다른 함수로는 arr\_isFull, new\_game, after\_move, set\_score, show\_result, result\_check 가 있다.


## Linematch.java ##

```

package com.example.linematch;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Linematch extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        getActionBar().setTitle("TicTacToe"); //위에 액션바 이름을  TicTacToe로 통일하였다.
        final Button iv_new_game = (Button) findViewById(R.id.new_game);
        final Button iv_help = (Button) findViewById(R.id.help);
        final Button iv_quit = (Button) findViewById(R.id.quit);
        
        iv_new_game.setOnClickListener(welcome_listener);
        iv_help.setOnClickListener(welcome_listener);
        iv_quit.setOnClickListener(welcome_listener);
    }
    
    /** 
     * 메인 화면 버튼들 설정
     **/
    OnClickListener welcome_listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		final Button iv = (Button) v;
    		if (iv.getId() == R.id.new_game) {
    			showDialog(NAME_DIALOG_ID);
    		}
    		else if (iv.getId() == R.id.help) {
    			showDialog(HELP_DIALOG_ID);
    		}
    		else if (iv.getId() == R.id.quit) {
    			finish();
    		}
    	}
    };
    
    /**
     * Dialog 인터페이스 설정.
     */
    protected Dialog onCreateDialog(int id) {
        Dialog mdialog = new Dialog(this);
        switch(id) {
        case NAME_DIALOG_ID:
        	mdialog.setContentView(R.layout.name_dialog_2);
    		mdialog.setTitle("Player Names");
    		mdialog.setCancelable(true);
    		
    		final EditText namep1 = (EditText) mdialog.findViewById(R.id.namep1);
    		final EditText namep2 = (EditText) mdialog.findViewById(R.id.namep2);
        
    		Button ok_b = (Button) mdialog.findViewById(R.id.ok);
    		ok_b.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) {
    				player_name_1 = namep1.getText();
    				player_name_2 = namep2.getText();
    				score_player_1 = 0;
    				score_player_2 = 0;
    				new_game(namep1.getText());
    				dismissDialog(1);
    			}
    		});
            break;
            
        case HELP_DIALOG_ID :
        	mdialog.setContentView(R.layout.help);
            mdialog.setTitle("Help");
            mdialog.setCancelable(true);
        	break;
        default:
            mdialog = null;
        }
        return mdialog;
    }   
    
    
    // **************************** 전역변수 선언 시작********************************************
    int count = 0;				//얼마나 움직였는지 세는 변수 count
    int arr[][] = 
    {{0,0,0},{0,0,0},{0,0,0}};	// 3X3 배열
    int player = 1;				// player 번호 1로 지정..
	int game_mode = 0;
	
	int user_symbol = 0;			// O모양은 player1, X모양은 player2.
	
	int skin_cross = R.drawable.system_cross;	
	int skin_dot = R.drawable.system_dot;		
	int skin_layout = R.layout.three;			
	int game_bg = 2;
	
	// 플레이어 이름 초기화.
	CharSequence player_name_1 = "Player 1";
	CharSequence player_name_2 = "Player 2";
	
	// 스코어 0으로 초기화.
	int score_player_1 = 0;
	int score_player_2 = 0;
	
    
    // dialog IDs
    final int NAME_DIALOG_ID = 1;
    final int HELP_DIALOG_ID = 2;
	
	//************************ 전역변수 선언 끝 ********************************** 
	
	/**
	 * 게임 안의 모든 imagebutton에 onclicklistener 설정. 
	 * */
    OnClickListener button_listener = new View.OnClickListener() {
        public void onClick(View v) {
            ImageButton ibutton = (ImageButton) v;
        	
        	// 버튼이 결과를 얻기 전 까지는 비활성화.
        	ibutton.setClickable(false);
        	
        	// 버튼 클릭할 때 마다 count 증가.
        	count++;
        	
            if ((count % 2 != 0) && (game_mode == 0)) { //player1 은 홀수번째 이므로  2로 나누면 나머지가 0이 아니다.
            	player = 1; //여기서  player number 전환. 1로.
                ibutton.setImageResource(skin_cross);
            }
            else if ((count % 2 == 0) &&(game_mode==0)) { //player2 은 짝수번째 이므로  2로 나누면 나머지가 0이다.
            	player = 2;			// 여기서  player number 전환. 2로.
            		ibutton.setImageResource(skin_dot);
            }
            
            // 결과를 확인하기 위해서 after_move 함수 사용.
        	after_move(ibutton);
        }
    };
    
	/**
	 * 배열이 꽉 찼나 확인.
	 **/
    public boolean arr_isFull () {
    	for (int i = 0; i < 3; i++)
    		for (int j = 0; j < 3; j++)
    			if (arr[i][j] == 0)
    				return false;				
    	return true;
    }
    
    /**
     * 게임 시작하는 부분. player_name에 player1, player2 이름 입력.
     */
    public void new_game(CharSequence player_name) {
    	
    	// 게임 뷰 리셋. 반드시 처음에 있어야 함.
		setContentView (skin_layout);
		
    	final ImageButton b3 = (ImageButton) findViewById(R.id.b3);
        final ImageButton b2 = (ImageButton) findViewById(R.id.b2);
        final ImageButton b1 = (ImageButton) findViewById(R.id.b1);

        final ImageButton b6 = (ImageButton) findViewById(R.id.b6);
        final ImageButton b5 = (ImageButton) findViewById(R.id.b5);
        final ImageButton b4 = (ImageButton) findViewById(R.id.b4);
        
        final ImageButton b9 = (ImageButton) findViewById(R.id.b9);
        final ImageButton b8 = (ImageButton) findViewById(R.id.b8);
        final ImageButton b7 = (ImageButton) findViewById(R.id.b7);
        
        // OnClickListenter 설정.
        b1.setOnClickListener(button_listener);
        b2.setOnClickListener(button_listener);
        b3.setOnClickListener(button_listener);
        b4.setOnClickListener(button_listener);
        b5.setOnClickListener(button_listener);
        b6.setOnClickListener(button_listener);
        b7.setOnClickListener(button_listener);
        b8.setOnClickListener(button_listener);
        b9.setOnClickListener(button_listener);
        
        // 버튼 클릭 가능하게 함.
        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);
        b4.setClickable(true);
        b5.setClickable(true);
        b6.setClickable(true);
        b7.setClickable(true);
        b8.setClickable(true);
        b9.setClickable(true);
        
        
        // 이 줄은 플레이어 이름이 설정된 후 와야함.
		set_score(3);	

    	 // 배열 리셋.
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				arr[i][j] = 0; 
    }
    
    /**
     * 결과 확인하고 다음 플레이어를 선택함.
     * @param ib : 유저에 의해 선택된 이미지버튼.
     */
    public void after_move (ImageButton ib) {
    	CharSequence pos_str = "";				// 스트링으로서 위치를 잡음.
    	int pos = 0;
    	boolean result = false;
  
    	pos_str = (CharSequence) ib.getTag();	// 태그를 통해 위치를 인식.
    	pos = (int) pos_str.charAt(0) - 48;		// char를 정수로 전환함.
	
    	// 플레이어 넘버에 따라 값을 배열 안에 저장시킴. (1 또는 2)
    	if (player == 1) {
    		if (pos < 4)				
    			arr[0][pos - 1] = 1;
    		else if (pos < 7) 
    			arr[1][(pos - 1) % 3] = 1;
    		else if (pos < 10)
    			arr[2][(pos - 1) % 3] = 1;
    	}
    	else {
    		if (pos < 4)				
    			arr[0][pos - 1] = 2;
    		else if (pos < 7) 
    			arr[1][(pos - 1) % 3] = 2;
    		else if (pos < 10)
    			arr[2][(pos - 1) % 3] = 2;
    	}
    	
    	// 게임 결과 확인.
    	result = result_check(player);
    		
    	// 결과 확인 부분.
    	if (result == true) {
    		// 	플레이어 넘버 체크.
    		if (player == 1) {
    			set_score(1);
    			if (game_mode == 0) {
    				show_result("Congrats. " + player_name_1 + " wins !!");
    			}
    		}
    		else {
    			set_score(2);
    			if (game_mode == 0) {	
    				show_result("Congrats. " + player_name_2 + " wins !!");
    			}
    		}
    		return;
    	
    	}
    	else if ((result == false) && arr_isFull()) {
    		show_result("    Game Draw !    ");				
    		return;
    	}
    	
    }
    
    /**
     * 스코어판 설정.
     * @param 플레이어 넘버를 확인해서 스코어판에 일치하는 플레이어 점수를 증가시킨다.
     */
    public void set_score(int player_number) {
    	TextView tv = (TextView) findViewById(R.id.scoreboard); // 스코어판  TextView 설정.
    	
    	if (player_number == 1)
    		score_player_1 += 1;
    	else if (player_number == 2)
    		score_player_2 += 1;
    	else ;							
    	
    		
    	CharSequence score_txt = 
    		player_name_1 + " : " + score_player_1 + "                   " + player_name_2 + " : " + score_player_2;
    	
    	tv.setText(score_txt); //텍스트 보냄.
    }
    
    /** 
     * 게임 결과를 나타내고 continue하는 창 띄움.
     * */
    public boolean show_result(CharSequence message)	
    {   
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
        			.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
        				public void onClick(DialogInterface dialog, int id) {
        		    		// 게임환경 리셋.
        						new_game(player_name_1);
        				}
        			});
        AlertDialog alert = builder.create();
        alert.show();
        return true;
    }
    
    
    /**
     * 각각 이동후에 결과확인.
     * @param player_local : 플레이어 넘버. 즉 그 버튼을 누른 플레이어의 고유 숫자.
     * @return True로 반환되면 누구든지 이기긴 이김. False일 때 비기는 것.
     */
    public boolean result_check(int player_local) {
    	boolean win = true;
    	int k = 0;
    	
    	// 수평 조건만 확인. /* [0][0].[0][1].[0][2]/...[2][2]순으로 확인 */
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (arr[i][j] != player_local) {		// 플레이어 넘버 확인.
    				win = false;
    				break;
    			}
    		} // 열 순환시켜 확인.
    		if (win == true) {
				return true;
    		}
    		win = true;
    	} // 행 순환시켜 확인.
    	
    	win = true;			// true로 리턴.
    	
    	// 수직 조건만 확인. /[0][0].[1][0].[2][0]/[1][0]...[2][2]순으로 확인.
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (arr[j][i] != player_local) {
    				win = false;
    				break;
    			}
    		} // 열 순환시켜서 확인.
    		if (win == true) {
				return true;
    		}
    		win = true;
    	} // 행 순환시켜 확인.
    	
    	win = true;			// true로 리셋.
    	
    	// 대각선의 첫번째 조건 검사. 왼쪽위에서 오른쪽 아래 방향.
    	for (int i = 0; i < 3; i++)
    		if (arr[i][k++] != player_local) {
    			win = false;
    			break;
    		}

    	if (win == true) {
    		return true;
    	}
    	
    	k = 2;
    	win = true;			// true 로 리셋하기.
    	
    	// 대각선의 두번째 조건 검사. 오른쪽 위에서 왼쪽 아래 방향.
    	for (int i = 0; i < 3; i++)
    		if (arr[i][k--] != player_local) {
    			win = false;
    			break;
    		}
    	
    	if (win == true) {
    		return true; 
    	} // 결국 마지막에  win이 true이면 result_check를 true로 반환.
    	
       	return false; // win이 true가 아니므로 마지막에 결국 false로 반환.
    }
    
   }

```

java파일 안에 많은 함수들이 있어서 복잡하지만 이것도 일종의 구조가 있다.

우선 처음에 new\_game이라는 함수를 구현시켜 게임환경을 다 리셋시킨다.

( button\_listener > after\_move )는 한 버튼 당 계속 순환된다. ( show\_result 와 rsult\_check는 after\_move 함수 안에서 돌아감 )

그리고 마지막 show\_resulst에서 게임결과를 보여주며 다시 new\_game이 선언된다.


다음은 R.java 파일을 보도록하자. (이거도 올리는거 맞나요..?)

## R.java ##

```
/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package com.example.linematch;

public final class R {
    public static final class attr {
    }
    public static final class dimen {
        /**  Default screen margins, per the Android Design guidelines. 

         Customize dimensions originally defined in res/values/dimens.xml (such as
         screen margins) for sw720dp devices (e.g. 10" tablets) in landscape here.
    
         */
        public static final int activity_horizontal_margin=0x7f040000;
        public static final int activity_vertical_margin=0x7f040001;
    }
    public static final class drawable {
        public static final int g=0x7f020000;
        public static final int help=0x7f020001;
        public static final int ic_launcher=0x7f020002;
        public static final int icon=0x7f020003;
        public static final int scoreboard_bg=0x7f020004;
        public static final int system_cross=0x7f020005;
        public static final int system_dot=0x7f020006;
    }
    public static final class id {
        public static final int LinearLayout01=0x7f080000;
        public static final int action_settings=0x7f080013;
        public static final int b1=0x7f08000f;
        public static final int b2=0x7f080012;
        public static final int b3=0x7f080011;
        public static final int b4=0x7f080010;
        public static final int b5=0x7f08000e;
        public static final int b6=0x7f08000d;
        public static final int b7=0x7f08000b;
        public static final int b8=0x7f08000c;
        public static final int b9=0x7f08000a; //버튼 9개..
        public static final int help=0x7f080002;
        public static final int imageView1=0x7f080001; //제일 위 틱택토 간판.
        public static final int layout_root=0x7f080005;
        public static final int namep1=0x7f080007;
        public static final int namep2=0x7f080006;
        public static final int new_game=0x7f080003;
        public static final int ok=0x7f080008;
        public static final int quit=0x7f080004;
        public static final int scoreboard=0x7f080009;
    }
    public static final class layout {
        public static final int help=0x7f030000;
        public static final int main=0x7f030001;
        public static final int name_dialog_2=0x7f030002;
        public static final int three=0x7f030003;
    }
    public static final class menu {
        public static final int four=0x7f070000; //4X4 하려다가 실패한 흔적ㅠ..
        public static final int linematch=0x7f070001;
    }
    public static final class string {
        public static final int action_settings=0x7f050001;
        public static final int app_name=0x7f050000;
        public static final int by=0x7f050009;
        public static final int created=0x7f050008;
        public static final int hello_world=0x7f050002; //삭제.
        public static final int help=0x7f050005;
        public static final int name=0x7f05000a;
        public static final int new_game=0x7f050003;
        public static final int option=0x7f050004;
        public static final int quit=0x7f050006;
        public static final int title_activity_four=0x7f050007; //4X4 흔적ㅠ...
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.
        

        Base application theme for API 11+. This theme completely replaces
        AppBaseTheme from res/values/styles.xml on API 11+ devices.
    
 API 11 theme customizations can go here. 

        Base application theme for API 14+. This theme completely replaces
        AppBaseTheme from BOTH res/values/styles.xml and
        res/values-v11/styles.xml on API 14+ devices.
    
 API 14 theme customizations can go here. 
         */
        public static final int AppBaseTheme=0x7f060000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f060001;
    }
}
```

여기서 java 파일의 내용은 끝이 났다.

이 다음부터는 layout의 파일 소스를 보도록하자.

## main.xml ##
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#A5E7D0" //색깔은 좋아하는 민트색으로 통일했슴다.
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Linematch" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="100dp"
        android:layout_alignParentLeft="true"
        android:layout_alignParentRight="true"
        android:scaleType="fitXY"
        android:src="@drawable/g" />

    <Button
        android:id="@+id/help"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/new_game"
        android:layout_centerHorizontal="true"
        android:text="@string/help" />

    <Button
        android:id="@+id/quit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/help"
        android:layout_centerHorizontal="true"
        android:text="@string/quit" />

    <Button
        android:id="@+id/new_game"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dp"
        android:text="@string/new_game" />

</RelativeLayout>
```

## name\_dialog\_2.xml ##
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/layout_root"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#A5E7D0"
    android:orientation="horizontal"
    android:padding="10dp" >

    <EditText
        android:id="@+id/namep2"
        android:layout_width="200dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/namep1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="16dp"
        android:ems="10"
        android:text="player2" >

        <requestFocus />
    </EditText>

    <Button
        android:id="@+id/ok"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        android:layout_below="@+id/namep2"
        android:layout_marginRight="18dp"
        android:layout_marginTop="26dp"
        android:text="OK" />

    <EditText
        android:id="@+id/namep1"
        android:layout_width="200dip"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/namep2"
        android:layout_alignParentTop="true"
        android:layout_marginTop="110dp"
        android:ems="10"
        android:text="player1" />

</RelativeLayout>
```


## help.xml ##
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/LinearLayout01"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#A5E7D0" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="fill_parent"
        android:layout_height="300dp"
        android:layout_alignParentLeft="true"
        android:layout_centerVertical="true"
        android:scaleType="fitXY"
        android:src="@drawable/help" />

</RelativeLayout>
```


## three.xml ##
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#A5E7D0" >
       
      <TextView
        android:id="@+id/scoreboard"
        android:layout_width="300dip"
        android:layout_height="50dip"
        android:layout_alignParentBottom="true"
        android:layout_alignRight="@+id/b9"
        android:layout_marginBottom="14dp"
        android:background="@drawable/scoreboard_bg"
        android:padding="15dip" />

    <ImageButton
        android:id="@+id/b7"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_alignTop="@+id/b8"
        android:layout_toLeftOf="@+id/b8"
        android:tag="7" />

    <ImageButton
        android:id="@+id/b6"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_above="@+id/b9"
        android:layout_alignLeft="@+id/b9"
        android:tag="6" />

    <ImageButton
        android:id="@+id/b5"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_below="@+id/b1"
        android:layout_toRightOf="@+id/b7"
        android:tag="5" />

    <ImageButton
        android:id="@+id/b4"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_above="@+id/b8"
        android:layout_toLeftOf="@+id/b8"
        android:tag="4" />

    <ImageButton
        android:id="@+id/b3"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_above="@+id/b6"
        android:layout_toRightOf="@+id/b2"
        android:tag="3" />

    <ImageButton
        android:id="@+id/b1"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_above="@+id/b4"
        android:layout_toLeftOf="@+id/b2"
        android:tag="1" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/b3"
        android:layout_alignLeft="@+id/b1"
        android:layout_alignParentTop="true"
        android:layout_alignRight="@+id/b3"
        android:scaleType="fitXY"
        android:src="@drawable/g" />

    <ImageButton
        android:id="@+id/b2"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_above="@+id/b6"
        android:layout_centerHorizontal="true"
        android:tag="2" />

    <ImageButton
        android:id="@+id/b8"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_above="@+id/scoreboard"
        android:layout_alignLeft="@+id/b2"
        android:tag="8" />

    <ImageButton
        android:id="@+id/b9"
        android:layout_width="100dip"
        android:layout_height="100dip"
        android:layout_above="@+id/scoreboard"
        android:layout_toRightOf="@+id/b8"
        android:tag="9" />

</RelativeLayout>
```

이 4개의 레이아웃이 어플에 구동되는 레이아웃들이다.

다음으로는 string.xml 파일을 보자. 딱히 버튼위에 글을 많이 쓰지 않아도되서 메인화면의 글만 선언을 해주면 되었다.


## string.xml ##
```
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <string name="app_name">TicTacToe</string>
    <string name="action_settings">Settings</string>
    <string name="hello_world">Hello world!</string>
    <string name="new_game">New Game</string>
    <string name="option">Options</string>
    <string name="help">Help</string>
    <string name="quit">Quit</string>
    <string name="title_activity_four">Four</string>
    <string name="created">Created</string>
    <string name="by">by</string>
    <string name="name">Lee Mi Hyeon</string>

</resources>
```

여기서 수정한 것은 원래 나의 안드로이드 프로젝트 이름이 Linematch 이였는데 기본의 원래 게임의 이름은 tictactoe여서 여기서 수정을 하였다. (AndroidManifest.xml에서 쓰임)


그러면 AndroidManifest.xml 파일을 봐보자.

## AndroidManifest.xml ##
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.linematch"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-sdk
        android:minSdkVersion="16"
        android:targetSdkVersion="16" /> //16버전

    <application
        android:allowBackup="true"
        android:icon="@drawable/icon" //아이콘 직접 수정.
        android:label="@string/app_name" //어플 이름도 수정.
        android:theme="@style/AppTheme" >
        <activity
            android:name="com.example.linematch.Linematch"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" /> //첫 구동화면.
            </intent-filter>
        </activity>
        <activity
            android:name="com.example.linematch.Four"
            android:label="@string/title_activity_four" >
        </activity> //여기도 4X4 하려다가 실패한 흔적ㅠㅠ
     </application>

</manifest>
```