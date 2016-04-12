#스도쿠 퍼즐 게임 어플


# Introduction #



시간 때우기도 좋고 머리도 좋아지는 스도쿠 퍼즐!

# Details #

**스도쿠란?**
가로세로 9칸인 정사각형 빈칸에 1~9까지의 숫자를 넣는 게임입니다.


단, 몇가지 조건이 있는데요 다음과같습니다.



**1.**가로줄,세로줄에 같은 숫자가 겹치면 안된다.


**2.** 작은 단위의 정사각형(3x3) 9칸 안에 같은 숫자가 겹치면 안된다.



결국 모든 숫자가 가로,세로, 작은 단위의 정사각형 안에  겹치치 않게 들어가야 하는 것입니다.










처음엔 용돈기입장어플을 구혆 보려 하였는데 생각보다 굉장히 손 댈 부분도 많고 프로그래밍 책자에서는 용돈기입장 어플에 도움이 많이되는 코드나 정보를 구하는데 어려움이 느껴셔져서 두번째로는 하늘에서 떨어지는 병아리를 사람이 피하는 게임을 구현해보려 하였다. 그런데 거의 다 구현한 과정에서 울퉁불퉁한 병아리와 마찬가지로 울퉁불퉁한 사람이 접할때를 찾는 코드를 만들기가 굉장히 어려워서 결국 굉장히 모든것이 깔끔하게 떨어지는 스도쿠를 구현하게 되었다.

# 소스코드 참조 #
[**http://suein1209.tistory.com/573 보조선 그리기]**


[**http://suein1209.tistory.com/565 새게임과 게임 끝내기]**


[**http://suein1209.tistory.com/554 about구현]**


[**http://suein1209.tistory.com/546 가로화면 구현]**


![https://comp166-koreauniv.googlecode.com/files/bookpic.jpg](https://comp166-koreauniv.googlecode.com/files/bookpic.jpg)


헬로 안드로이드 책 참조



![https://comp166-koreauniv.googlecode.com/files/sudokukumain.jpg](https://comp166-koreauniv.googlecode.com/files/sudokukumain.jpg)

메인화면 입니다

![https://comp166-koreauniv.googlecode.com/files/level.jpg](https://comp166-koreauniv.googlecode.com/files/level.jpg)

레벨선택 창 입니다

![https://comp166-koreauniv.googlecode.com/files/board.jpg](https://comp166-koreauniv.googlecode.com/files/board.jpg)
게임화면 입니다



# main.xml #

```
<?xml version="1.0" encoding="utf-8"?>
<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/AbsoluteLayout2"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="@drawable/back"
    android:padding="30dip" >

    <LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical" >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginBottom="25dip"
            android:text="@string/main_title"
            android:textColor="@color/puzzle_selected"
            android:textSize="24.5sp" />

        <Button
            android:id="@+id/continue_button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/continue_label" />

        <Button
            android:id="@+id/new_button"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="@string/new_game_label" />

        <Button
            android:id="@+id/about_button"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="@string/about_label" />

        <Button
            android:id="@+id/exit_button"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="@string/exit_label" />
    </LinearLayout>

</AbsoluteLayout>


//메인화면에 대한 코드입니다. 버튼4개를 정의하였고 각 버튼을 누르면 각자 다른 엑티비티로 전환됩니다. 
```


# about2.xml #

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/sudosudo" />

//스도쿠 게임에대한 설명을 넣은 about화면입니다

</LinearLayout>
```

# keyboard.xml #

```
<?xml version="1.0" encoding="utf-8"?>
<TableLayout
   xmlns:android="http://schemas.android.com/apk/res/android"
   android:id="@+id/keypad"
   android:orientation="vertical"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:stretchColumns="*">
   <TableRow>
      <Button android:id="@+id/keypad_1"
         android:text="1">
      </Button>
      <Button android:id="@+id/keypad_2"
         android:text="2">
      </Button>
      <Button android:id="@+id/keypad_3"
         android:text="3">
      </Button>
//키보드의 첫째줄에 1,2,3
   </TableRow>
   <TableRow>
      <Button android:id="@+id/keypad_4"
         android:text="4">
      </Button>
      <Button android:id="@+id/keypad_5"
         android:text="5">
      </Button>
      <Button android:id="@+id/keypad_6"
         android:text="6">
      </Button>
//키보드의 둘째줄에 4,5,6
   </TableRow>
   <TableRow>
      <Button android:id="@+id/keypad_7"
         android:text="7">
      </Button>
      <Button android:id="@+id/keypad_8"
         android:text="8">
      </Button>
      <Button android:id="@+id/keypad_9"
         android:text="9">
      </Button>
//키보드의 셋째줄에 7,8,9
   </TableRow>
</TableLayout>
```

# about.java #

```

package org.example.sudoku;

import android.app.Activity;
import android.os.Bundle;

public class About extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.about2);
   }
}

//about버튼과 about화면을 연결해주는 코드
```


# game.java #

```
package com.example.sudoku;

import com.example.sudoku.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class Game extends Activity {
   private static final String TAG = "Sudoku";

   public static final String KEY_DIFFICULTY =
      "com.example.sudoku.difficulty";
   
   private static final String PREF_PUZZLE = "puzzle" ;
   
   public static final int DIFFICULTY_EASY = 0;
   public static final int DIFFICULTY_MEDIUM = 1;
   public static final int DIFFICULTY_HARD = 2;
   
   protected static final int DIFFICULTY_CONTINUE = -1;
   

   private int puzzle[] = new int[9 * 9];

   private final String easyPuzzle =
      "360000000004230800000004200" +
      "070460003820000014500013020" +
      "001900000007048300000000045";
   private final String mediumPuzzle =
      "650000070000506000014000005" +
      "007009000002314700000700800" +
      "500000630000201000030000097";
   private final String hardPuzzle =
      "009000000080605020501078000" +
      "000000700706040102004000000" +
      "000720903090301080000000600";

   private PuzzleView puzzleView;

   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      
      super.onCreate(savedInstanceState);
      Log.d(TAG, "onCreate");

      int diff = getIntent().getIntExtra(KEY_DIFFICULTY,
            DIFFICULTY_EASY);
      puzzle = getPuzzle(diff);
      calculateUsedTiles();

      puzzleView = new PuzzleView(this);
      setContentView(puzzleView);
      puzzleView.requestFocus();

      
      
      getIntent().putExtra(KEY_DIFFICULTY, DIFFICULTY_CONTINUE);
   }
   

   @Override
   protected void onResume() {
      super.onResume();
      Music.play(this, R.raw.game);
   }

   
   @Override
   protected void onPause() {
      super.onPause();
      Log.d(TAG, "onPause");
      Music.stop(this);

      
      getPreferences(MODE_PRIVATE).edit().putString(PREF_PUZZLE,
            toPuzzleString(puzzle)).commit();
   }
   
   
   

   private int[] getPuzzle(int diff) {
      String puz;
      switch (diff) {
      case DIFFICULTY_CONTINUE:
         puz = getPreferences(MODE_PRIVATE).getString(PREF_PUZZLE,
               easyPuzzle);
         break;
         // ...
         
      case DIFFICULTY_HARD:
         puz = hardPuzzle;
         break;
      case DIFFICULTY_MEDIUM:
         puz = mediumPuzzle;
         break;
      case DIFFICULTY_EASY:
      default:
         puz = easyPuzzle;
         break;
         
      }
      return fromPuzzleString(puz);
   }
   

   
   static private String toPuzzleString(int[] puz) {
      StringBuilder buf = new StringBuilder();
      for (int element : puz) {
         buf.append(element);
      }
      return buf.toString();
   }

   
   static protected int[] fromPuzzleString(String string) {
      int[] puz = new int[string.length()];
      for (int i = 0; i < puz.length; i++) {
         puz[i] = string.charAt(i) - '0';
      }
      return puz;
   }

      private int getTile(int x, int y) {
      return puzzle[y * 9 + x];
   }


   private void setTile(int x, int y, int value) {
      puzzle[y * 9 + x] = value;
   }

   
   protected String getTileString(int x, int y) {
      int v = getTile(x, y);
      if (v == 0)
         return "";
      else
         return String.valueOf(v);
   }


   protected boolean setTileIfValid(int x, int y, int value) {
      int tiles[] = getUsedTiles(x, y);
      if (value != 0) {
         for (int tile : tiles) {
            if (tile == value)
               return false;
         }
      }
      setTile(x, y, value);
      calculateUsedTiles();
      return true;
   }

   
   protected void showKeypadOrError(int x, int y) {
      int tiles[] = getUsedTiles(x, y);
      if (tiles.length == 9) {
         Toast toast = Toast.makeText(this,
               R.string.no_moves_label, Toast.LENGTH_SHORT);
         toast.setGravity(Gravity.CENTER, 0, 0);
         toast.show();
      } else {
         Log.d(TAG, "showKeypad: used=" + toPuzzleString(tiles));
         Dialog v = new Keypad(this, tiles, puzzleView);
         v.show();
      }
   }

   
   private final int used[][][] = new int[9][9][];

   
   protected int[] getUsedTiles(int x, int y) {
      return used[x][y];
   }

  
   private void calculateUsedTiles() {
      for (int x = 0; x < 9; x++) {
         for (int y = 0; y < 9; y++) {
            used[x][y] = calculateUsedTiles(x, y);
            
         }
      }
   }

   
   private int[] calculateUsedTiles(int x, int y) {
      int c[] = new int[9];
      //수편방향
      for (int i = 0; i < 9; i++) {
         if (i == y)
            continue;
         int t = getTile(x, i);
         if (t != 0)
            c[t - 1] = t;
      }
      // 수직방향
      for (int i = 0; i < 9; i++) {
         if (i == x)
            continue;
         int t = getTile(i, y);
         if (t != 0)
            c[t - 1] = t;
      }
      // same cell block
      int startx = (x / 3) * 3;
      int starty = (y / 3) * 3;
      for (int i = startx; i < startx + 3; i++) {
         for (int j = starty; j < starty + 3; j++) {
            if (i == x && j == y)
               continue;
            int t = getTile(i, j);
            if (t != 0)
               c[t - 1] = t;
         }
      }
      
      int nused = 0;
      for (int t : c) {
         if (t != 0)
            nused++;
      }
      int c1[] = new int[nused];
      nused = 0;
      for (int t : c) {
         if (t != 0)
            c1[nused++] = t;
      }
      return c1;
   }
   
}

```



# keypad.java #

```
package com.example.sudoku;

import org.example.sudoku.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class Keypad extends Dialog {

   protected static final String TAG = "Sudoku";

   private final View keys[] = new View[9];
   private View keypad;

   private final int useds[];
   private final PuzzleView puzzleView;

   public Keypad(Context context, int useds[], PuzzleView puzzleView) {
      super(context);
      this.useds = useds;
      this.puzzleView = puzzleView;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setTitle(R.string.keypad_title);
      setContentView(R.layout.keypad);
      findViews();
      for (int element : useds) {
         if (element != 0)
            keys[element - 1].setVisibility(View.INVISIBLE);
      }
      setListeners();
   }

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
      int tile = 0;
      switch (keyCode) {
      case KeyEvent.KEYCODE_0:
      case KeyEvent.KEYCODE_SPACE: tile = 0; break;
      case KeyEvent.KEYCODE_1:     tile = 1; break;
      case KeyEvent.KEYCODE_2:     tile = 2; break;
      case KeyEvent.KEYCODE_3:     tile = 3; break;
      case KeyEvent.KEYCODE_4:     tile = 4; break;
      case KeyEvent.KEYCODE_5:     tile = 5; break;
      case KeyEvent.KEYCODE_6:     tile = 6; break;
      case KeyEvent.KEYCODE_7:     tile = 7; break;
      case KeyEvent.KEYCODE_8:     tile = 8; break;
      case KeyEvent.KEYCODE_9:     tile = 9; break;
      default:
         return super.onKeyDown(keyCode, event);
      }
      if (isValid(tile)) {
         returnResult(tile);
      }
      return true;

   }

   
   private void returnResult(int tile) {
      puzzleView.setSelectedTile(tile);
      dismiss();
   }

   private boolean isValid(int tile) {
      for (int t : useds) {
         if (tile == t)
            return false;
      }
      return true;
   }

   private void findViews() {
      keypad = findViewById(R.id.keypad);
      keys[0] = findViewById(R.id.keypad_1);
      keys[1] = findViewById(R.id.keypad_2);
      keys[2] = findViewById(R.id.keypad_3);
      keys[3] = findViewById(R.id.keypad_4);
      keys[4] = findViewById(R.id.keypad_5);
      keys[5] = findViewById(R.id.keypad_6);
      keys[6] = findViewById(R.id.keypad_7);
      keys[7] = findViewById(R.id.keypad_8);
      keys[8] = findViewById(R.id.keypad_9);
   }

   private void setListeners() {
      for (int i = 0; i < keys.length; i++) {
         final int t = i + 1;
         keys[i].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               returnResult(t);
            }});
      }
      keypad.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v) {
            returnResult(0);
         }});
   }
}


```



# puzzleview.java #

```
package com.example.sudoku;

import org.example.sudoku.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;

import android.os.Bundle;
import android.os.Parcelable;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;


public class PuzzleView extends View {
   
   private static final String TAG = "Sudoku";

   
   private static final String SELX = "selX"; 
   private static final String SELY = "selY";
   private static final String VIEW_STATE = "viewState";
   private static final int ID = 42; 

   
   private float width;    // 타이틀 길이
   private float height;   // 타이틀 높이
   private int selX;       
   private int selY;       
   private final Rect selRect = new Rect();

   private final Game game;
   
   public PuzzleView(Context context) {
      
      super(context);
      this.game = (Game) context;
      setFocusable(true);
      setFocusableInTouchMode(true);
      
     
      setId(ID); 
   }

   @Override
   protected Parcelable onSaveInstanceState() { 
      Parcelable p = super.onSaveInstanceState();
      Log.d(TAG, "onSaveInstanceState");
      Bundle bundle = new Bundle();
      bundle.putInt(SELX, selX);
      bundle.putInt(SELY, selY);
      bundle.putParcelable(VIEW_STATE, p);
      return bundle;
   }
   @Override
   protected void onRestoreInstanceState(Parcelable state) { 
      Log.d(TAG, "onRestoreInstanceState");
      Bundle bundle = (Bundle) state;
      select(bundle.getInt(SELX), bundle.getInt(SELY));
      super.onRestoreInstanceState(bundle.getParcelable(VIEW_STATE));
      return;
   }
   

   @Override
   protected void onSizeChanged(int w, int h, int oldw, int oldh) {
      width = w / 9f;
      height = h / 9f;
      getRect(selX, selY, selRect);
      Log.d(TAG, "onSizeChanged: width " + width + ", height "
            + height);
      super.onSizeChanged(w, h, oldw, oldh);
   }

   @Override
   protected void onDraw(Canvas canvas) {
      // 배경 그리기
      Paint background = new Paint();
      background.setColor(getResources().getColor(
            R.color.puzzle_background));
      canvas.drawRect(0, 0, getWidth(), getHeight(), background);

      
      // 판그리기
      
      //선의 색깔정하기
      Paint dark = new Paint();
      dark.setColor(getResources().getColor(R.color.puzzle_dark));

      Paint hilite = new Paint();
      hilite.setColor(getResources().getColor(R.color.puzzle_hilite));

      Paint light = new Paint();
      light.setColor(getResources().getColor(R.color.puzzle_light));

      // 두번째 선 그리기
      for (int i = 0; i < 9; i++) {
         canvas.drawLine(0, i * height, getWidth(), i * height,
               light);
         canvas.drawLine(0, i * height + 1, getWidth(), i * height
               + 1, hilite);
         canvas.drawLine(i * width, 0, i * width, getHeight(),
               light);
         canvas.drawLine(i * width + 1, 0, i * width + 1,
               getHeight(), hilite);
      }

     
      for (int i = 0; i < 9; i++) {
         if (i % 3 != 0)
            continue;
         canvas.drawLine(0, i * height, getWidth(), i * height,
               dark);
         canvas.drawLine(0, i * height + 1, getWidth(), i * height
               + 1, hilite);
         canvas.drawLine(i * width, 0, i * width, getHeight(), dark);
         canvas.drawLine(i * width + 1, 0, i * width + 1,
               getHeight(), hilite);
      }

     
      Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
      foreground.setColor(getResources().getColor(
            R.color.puzzle_foreground));
      foreground.setStyle(Style.FILL);
      foreground.setTextSize(height * 0.75f);
      foreground.setTextScaleX(width / height);
      foreground.setTextAlign(Paint.Align.CENTER);

     
      FontMetrics fm = foreground.getFontMetrics();
      // Centering in X: use alignment (and X at midpoint)
      float x = width / 2;
      // Centering in Y: measure ascent/descent first
      float y = height / 2 - (fm.ascent + fm.descent) / 2;
      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            canvas.drawText(this.game.getTileString(i, j), i
                  * width + x, j * height + y, foreground);
         }
      }

      
      if (Prefs.getHints(getContext())) {
         // 힌트주기
         
         
         Paint hint = new Paint();
         int c[] = { getResources().getColor(R.color.puzzle_hint_0),
               getResources().getColor(R.color.puzzle_hint_1),
               getResources().getColor(R.color.puzzle_hint_2), };
         Rect r = new Rect();
         for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               int movesleft = 9 - game.getUsedTiles(i, j).length;
               if (movesleft < c.length) {
                  getRect(i, j, r);
                  hint.setColor(c[movesleft]);
                  canvas.drawRect(r, hint);
               }
            }
         }
         
      }
      

      
      Log.d(TAG, "selRect=" + selRect);
      Paint selected = new Paint();
      selected.setColor(getResources().getColor(
            R.color.puzzle_selected));
      canvas.drawRect(selRect, selected);
   }

   @Override
   public boolean onTouchEvent(MotionEvent event) {
      if (event.getAction() != MotionEvent.ACTION_DOWN)
         return super.onTouchEvent(event);

      select((int) (event.getX() / width),
            (int) (event.getY() / height));
      game.showKeypadOrError(selX, selY);
      Log.d(TAG, "onTouchEvent: x " + selX + ", y " + selY);
      return true;
   }

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
      Log.d(TAG, "onKeyDown: keycode=" + keyCode + ", event="
            + event);
      switch (keyCode) {
      case KeyEvent.KEYCODE_DPAD_UP:
         select(selX, selY - 1);
         break;
      case KeyEvent.KEYCODE_DPAD_DOWN:
         select(selX, selY + 1);
         break;
      case KeyEvent.KEYCODE_DPAD_LEFT:
         select(selX - 1, selY);
         break;
      case KeyEvent.KEYCODE_DPAD_RIGHT:
         select(selX + 1, selY);
         break;
      case KeyEvent.KEYCODE_0:
      case KeyEvent.KEYCODE_SPACE: setSelectedTile(0); break;
      case KeyEvent.KEYCODE_1:     setSelectedTile(1); break;
      case KeyEvent.KEYCODE_2:     setSelectedTile(2); break;
      case KeyEvent.KEYCODE_3:     setSelectedTile(3); break;
      case KeyEvent.KEYCODE_4:     setSelectedTile(4); break;
      case KeyEvent.KEYCODE_5:     setSelectedTile(5); break;
      case KeyEvent.KEYCODE_6:     setSelectedTile(6); break;
      case KeyEvent.KEYCODE_7:     setSelectedTile(7); break;
      case KeyEvent.KEYCODE_8:     setSelectedTile(8); break;
      case KeyEvent.KEYCODE_9:     setSelectedTile(9); break;
      case KeyEvent.KEYCODE_ENTER:
      case KeyEvent.KEYCODE_DPAD_CENTER:
         game.showKeypadOrError(selX, selY);
         break;
      default:
         return super.onKeyDown(keyCode, event);
      }
      return true;
   }

   public void setSelectedTile(int tile) {
      if (game.setTileIfValid(selX, selY, tile)) {
         invalidate();// may change hints
      } else {
         
         Log.d(TAG, "setSelectedTile: invalid: " + tile);
         startAnimation(AnimationUtils.loadAnimation(game,
               R.anim.shake));
      }
   }

   private void select(int x, int y) {
      invalidate(selRect);
      selX = Math.min(Math.max(x, 0), 8);
      selY = Math.min(Math.max(y, 0), 8);
      getRect(selX, selY, selRect);
      invalidate(selRect);
   }

   private void getRect(int x, int y, Rect rect) {
      rect.set((int) (x * width), (int) (y * height), (int) (x
            * width + width), (int) (y * height + height));
   }
   
   
}



```


# sudoku.java #

```
package com.example.sudoku;

import org.example.sudoku.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class Sudoku extends Activity implements OnClickListener {
   private static final String TAG = "Sudoku";
   

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      
      View continueButton = findViewById(R.id.continue_button);
      continueButton.setOnClickListener(this);
      View newButton = findViewById(R.id.new_button);
      newButton.setOnClickListener(this);
      View aboutButton = findViewById(R.id.about_button);
      aboutButton.setOnClickListener(this);
      View exitButton = findViewById(R.id.exit_button);
      exitButton.setOnClickListener(this);
   }

   
   @Override
   protected void onResume() {
      super.onResume();
      Music.play(this, R.raw.main);
   }

   @Override
   protected void onPause() {
      super.onPause();
      Music.stop(this);
   }
   

   
   public void onClick(View v) {
      switch (v.getId()) {
      case R.id.continue_button:
         startGame(Game.DIFFICULTY_CONTINUE);
         break;
         
         
      case R.id.about_button:
         Intent i = new Intent(this, About.class);
         startActivity(i);
         break;
      
      case R.id.new_button:
         openNewGameDialog();
         break;
      case R.id.exit_button:
         finish();
         break;
         
      }
   }
   
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      super.onCreateOptionsMenu(menu);
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      case R.id.settings:
         startActivity(new Intent(this, Prefs.class));
         return true;
      
      return false;
   }

   /** 레벨선택 */
   private void openNewGameDialog() {
      new AlertDialog.Builder(this)
           .setTitle(R.string.new_game_title)
           .setItems(R.array.difficulty,
            new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialoginterface,
                     int i) {
                  startGame(i);
               }
            })
           .show();
   }

   /** 주어진 레벨의 게임 실행*/
   private void startGame(int i) {
      Log.d(TAG, "clicked on " + i);
      Intent intent = new Intent(Sudoku.this, Game.class);
      intent.putExtra(Game.KEY_DIFFICULTY, i);
      startActivity(intent);
   }
}
```

https://comp166-koreauniv.googlecode.com/files/Sudokuku.apk

어플파일입니다.