# 소개 #

![http://comp166-koreauniv.googlecode.com/files/GiveItToMe.png](http://comp166-koreauniv.googlecode.com/files/GiveItToMe.png)

_돈을 빌리거나 빌려줬을 때 이름, 전화번호, 시간, 가격을 기록한 뒤 안내 문자나 전화를 보내는 어플리케이션_

어플리케이션의 이름은 '돈 내놔!'의 느낌으로 'Give it to me'를 생각했고, 마침 씨스타의 노래 중 똑같은 제목의 노래가 있어 아이콘을 앨범 자켓에서 차용해옴

## 다운로드 ##

http://code.google.com/p/comp166-koreauniv/downloads/detail?name=GiveItToMe.apk&can=2&q=#makechanges

# 세부내용 #

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-26-51.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-26-51.png)

**빌려주기** : 돈을 빌려준 사람의 연락처를 주소록에서 불러오거나 새로 입력하여 빌려준 시간과 가격을 기록

**빌리기** : 돈을 빌린 사람의 연락처를 주소록에서 불러오거나 새로 입력하여 빌린 시간과 가격을 기록

**목록보기** : 돈을 빌려준 사람과 빌린 사람의 이름, 전화번호, 시간, 가격을 목록으로 보여주고 터치를 하면 '전화하기', '문자하기', '취소'를 할 수 있음

**종료하기** : 앱 종료

**도움말** : 앱에 대한 간단한 설명



## Class 소개 ##

![http://comp166-koreauniv.googlecode.com/files/class.png](http://comp166-koreauniv.googlecode.com/files/class.png)


### Database.java ###

어플케이션의 기본이 되는 DB 관련 class

```

package com.apk.GiveItToMe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class Database extends SQLiteOpenHelper{
	static final String DB = "DBgiveittome.db";
	static final String TABLE_GIVEITTOME = "giveittome";
	static final int DB_VERSION = 1;
	
	// 테이블 생성 SQL
	static final String CREATE_TABLE_GIVEITTOME =
		"create table giveittome (" +
		"_id integer primary key autoincrement, " +
		"giveorget text not null, " +
		"name text not null, " +
		"phoneNum text not null, " +
		"time text not null, " +
		"money text not null);";
	
	// 테이블 삭제 SQL
	static final String DROP_TABLE_GIVEITTOME = "drop table giveittome;";
	
	// 참고 열 이름 (giveittome)
	static final String giveorget = "giveorget";
	static final String name = "name";
	static final String phoneNum = "phoneNum";
	static final String time = "time";
	static final String money = "money";
	
	public Database(Context context) {
		super(context, DB, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	// 데이터베이스를 새로 만든 다음 호출
	public void onCreate(SQLiteDatabase db){
		// 내부에 테이블 만들기
		db.execSQL(CREATE_TABLE_GIVEITTOME);
	}
	
	// 존재하는 데이터베이스로 정의하고 있는 버전이 다를 때
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL(DROP_TABLE_GIVEITTOME);
		onCreate(db);
	}
	
	/*giveittome에 쓰이는 테이블에 접근하는 메서드*/
	
	// 추가
	public void DBAdd(SQLiteDatabase db, String a, String b, String c, String d, String e){
		ContentValues values = new ContentValues();
		values.put(giveorget, a);
		values.put(name, b);
		values.put(phoneNum, c);
		values.put(time, d);
		values.put(money, e);
		db.insert(TABLE_GIVEITTOME, null, values);
	}
	
	// 수정
	public void DBUpdate(SQLiteDatabase db, int a, String b, String c, String d, String e, String f){
		db.execSQL("update giveittome set giveorget = '" + b + "', " +
				"name = '" + c + "', " +
				"phoneNum = '" + d + "', " +
				"time = '" + e + "'" +
				"money = '" + f + "'" +
				"where _id = " + a + ";");
	}
	
	// 모두 삭제
	public void DBDel(SQLiteDatabase db){
		db.execSQL("delete from giveittome;");
	}
	
	// 삭제
	public void DBDel(SQLiteDatabase db, int a){
		db.execSQL("delete from giveittome where _id = " + a + ";");
	}
	
	// 전체 행 커서 ID의 내림차순으로 호출
	public Cursor fetchAll(SQLiteDatabase db){
		return db.query(TABLE_GIVEITTOME, new String[] {BaseColumns._ID, 
				giveorget, name, phoneNum, time, money},
				null, null, null, null, "_id DESC");
	}
	
}

```


## Main.java ##

메인 화면 구동을 위한 class

```

package com.apk.GiveItToMe;

import com.apk.giveittome.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Main extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	ImageView main_give, main_get, main_list, main_help, main_exit;
	String putString = "";
	AlertDialog.Builder ad;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giveittome_main);
        
        init();
        setEvent();
	}

	private void init() {
		// TODO Auto-generated method stub
		main_give = (ImageView)findViewById(R.id.main_give);
		main_get = (ImageView)findViewById(R.id.main_get);
		main_list = (ImageView)findViewById(R.id.main_list);
		main_help = (ImageView)findViewById(R.id.main_help);
		main_exit = (ImageView)findViewById(R.id.main_exit);
	}
	
	private void setEvent() {
		// TODO Auto-generated method stub
		main_give.setOnClickListener(this);
		main_get.setOnClickListener(this);
		main_list.setOnClickListener(this); 
		main_help.setOnClickListener(this);
		main_exit.setOnClickListener(this);
	}
	
	private void startIntent(String a, String b){
		Intent intent = new Intent();
		intent.setClassName(Main.this, "com.apk.giveittome." + a);
		intent.putExtra("giveorget", b);
		startActivity(intent);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view == main_give){
			ad = new AlertDialog.Builder(this);
			ad.setTitle("불러오기");
			ad.setIcon(R.drawable.giveittomeicon);
			ad.setMessage("어떻게 불러오시겠습니까?");
			ad.setPositiveButton("주소록에서 불러오기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					startIntent("MoneyContacts", "give");
				}
			});
			ad.setNegativeButton("새로 입력하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					startIntent("MoneyActivity", "give");
				}
			});
			ad.show();
		}
		else if(view == main_get){
			ad = new AlertDialog.Builder(this);
			ad.setTitle("불러오기");
			ad.setIcon(R.drawable.giveitomeicon);
			ad.setMessage("어떻게 불러오시겠습니까?");
			ad.setPositiveButton("주소록에서 불러오기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					startIntent("MoneyContacts", "get");
				}
			});
			ad.setNegativeButton("새로 입력하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					startIntent("MoneyActivity", "get");
				}
			});
			ad.show();
		}
		else if(view == main_list){
			startIntent("List","");
		}
		else if(view == main_help){
			startIntent("Help","");
		}
		else if(view == main_exit){ 
			ad = new AlertDialog.Builder(this);
			ad.setTitle("종료하기");
			ad.setIcon(R.drawable.giveittomeicon);
			ad.setMessage("종료하시겠습니까?");
			ad.setPositiveButton("네", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					java.lang.System.exit(0);
				}
			});
			ad.setNegativeButton("아니오", null);
			ad.show();
		}
	}
	
	@Override // '종료하기' 버튼을 누르지 않고 '뒤로가기' 버튼을 눌러서 종료할 수 있음
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode){
		case KeyEvent.KEYCODE_BACK:
			ad = new AlertDialog.Builder(this);
			ad.setTitle("종료하기");
			ad.setIcon(R.drawable.giveittomeicon);
			ad.setMessage("종료하시겠습니까?");
			ad.setPositiveButton("네", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					java.lang.System.exit(0);
				}
			});
			ad.setNegativeButton("아니오", null);
			ad.show();
			break;
		}
		return true;
	}
}

```


## MoneyActivity.java ##

돈을 빌려준 & 빌린 사람의 정보를 입력하기 위한 class

```

package com.apk.GiveItToMe;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import com.apk.giveittome.R;

import android.R.integer;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TimePicker;
import android.widget.Toast;

public class MoneyActivity extends Activity implements OnClickListener{

	TextView text_name, text_phoneNum, text_time, text_money;
	EditText edit_name, edit_phoneNum, edit_time, edit_money;
	ImageView submit, nosubmit;

	Intent getIntent;
	Typeface font;
	DatePickerDialog.OnDateSetListener setDate;
	TimePickerDialog.OnTimeSetListener setTime;

	DateFormat dateformat = DateFormat.getDateTimeInstance();
	Calendar dateAndtime = Calendar.getInstance();
	String name, phoneNum;
	public static int year, month, day, hour, minute;
	public static String AMPM = "오전";

	SQLiteDatabase db;
	Database con = null;
	Cursor c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giveittome_moneyactivity);

		init();
		setFont();

		if(name != null)
			GetIntent();

		setEvent();
	}

	private void GetIntent() {
		// TODO Auto-generated method stub
		edit_name.setText(name);
		edit_name.setEnabled(false);
		edit_phoneNum.setText(phoneNum);
		edit_phoneNum.setEnabled(false);
	}

	private void init() {
		// TODO Auto-generated method stub
		text_name = (TextView)findViewById(R.id.text_name);
		text_phoneNum = (TextView)findViewById(R.id.text_phoneNum);
		text_time = (TextView)findViewById(R.id.text_time);
		text_money = (TextView)findViewById(R.id.text_money);
		edit_name = (EditText)findViewById(R.id.edit_name);
		edit_phoneNum = (EditText)findViewById(R.id.edit_phoneNum);
		edit_time = (EditText)findViewById(R.id.edit_time);
		edit_money = (EditText)findViewById(R.id.edit_money);
		submit = (ImageView)findViewById(R.id.submit);
		nosubmit = (ImageView)findViewById(R.id.nosubmit);

		getIntent = getIntent();
		font = Typeface.createFromAsset(getAssets(), "MOM.otf");

		name = getIntent.getStringExtra("name");
		phoneNum = getIntent.getStringExtra("phoneNum");

		setDate = new DatePickerDialog.OnDateSetListener() { // 날짜 설정
			@Override
			public void onDateSet(DatePicker view, int year, int month, int day) {
				// TODO Auto-generated method stub
				month++;
				MoneyActivity.year = year;
				MoneyActivity.month = month;
				MoneyActivity.day = day;

				setDialog("Time");
			}
		};

		setTime = new TimePickerDialog.OnTimeSetListener() { // 시간 설정
			@Override
			public void onTimeSet(TimePicker view, int hour, int minute) {
				// TODO Auto-generated method stub
				hour = setAMPM(hour);
				MoneyActivity.hour = hour;
				MoneyActivity.minute = minute;
				edit_time.setText(year+"."+month+"."+day+"\n"+AMPM+" "+hour+":"+setMinute(minute));
			}

			private int setAMPM(int hour) {
				// TODO Auto-generated method stub
				if(hour < 12){
					if(hour == 0)
						hour = 12;
				}
				else if(hour >= 12){
					if(hour > 12)
						hour -= 12;
				}
				return hour;
			}

			private String setMinute(int minute) {
				// TODO Auto-generated method stub
				if(minute < 10)
					return "0"+minute;
				else
					return ""+minute;
			}
		};
	}

	private void setFont() {
		// TODO Auto-generated method stub
		text_name.setTypeface(font);
		text_phoneNum.setTypeface(font);
		text_time.setTypeface(font);
		text_money.setTypeface(font);

		edit_name.setTypeface(font);
		edit_phoneNum.setTypeface(font);
		edit_time.setTypeface(font);
		edit_money.setTypeface(font);
	}

	private void setEvent() {
		// TODO Auto-generated method stub
		edit_time.setOnClickListener(this);
		submit.setOnClickListener(this);
		nosubmit.setOnClickListener(this);
	}

	private void setDialog(String a){
		if(a.equals("Date"))
			new DatePickerDialog(this, setDate, dateAndtime.get(Calendar.YEAR), 
					dateAndtime.get(Calendar.MONTH), 
					dateAndtime.get(Calendar.DAY_OF_MONTH)).show();
		else if(a.equals("Time")){
			if(dateAndtime.get(Calendar.AM_PM) == 0)
				AMPM = "오전";
			else
				AMPM = "오후";
			new TimePickerDialog(this, setTime, dateAndtime.get(Calendar.HOUR_OF_DAY), 
					dateAndtime.get(Calendar.MINUTE), 
					false).show();
		}
	}

	@Override // *새로 입력*
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view == edit_time){
			setDialog("Date");
		}
		else if(view == submit){
			if(edit_name.getText().toString().equals(""))
				Toast.makeText(this, "이름이 뭐에요?", 100).show(); // 4minute의 '이름이 뭐에요?'
			else if(edit_phoneNum.getText().toString().equals(""))
				Toast.makeText(this, "전화번호 뭐에요?", 100).show(); // 4minute의 '이름이 뭐에요?'
			else if(edit_time.getText().toString().equals(""))
				Toast.makeText(this, "시간 좀 적어줘요", 100).show(); // 4minute의 '이름이 뭐에요?'
			else if(edit_money.getText().toString().equals(""))
				Toast.makeText(this, "Show Me The Money", 100).show(); // 스타 치트키
			else{ // 데이터베이스를 쓰기 위한 열
				con = new Database(getApplicationContext());

				try{
					db = con.getWritableDatabase();
				}catch (Exception e) {
					// TODO: handle exception
					db = con.getReadableDatabase();
				}

				NumberFormat nf = new DecimalFormat("##,###,###,###,###");
				double num = Double.parseDouble(edit_money.getText().toString());
				
				if(dateAndtime.get(Calendar.AM_PM) != 0)
					hour += 12;

				con.DBAdd(db, getIntent().getStringExtra("giveorget"),
						edit_name.getText().toString(),
						edit_phoneNum.getText().toString(),
						year+"."+month+"."+day+"."+hour+"."+minute,
						nf.format(num));

				Toast.makeText(this, "저장 완료", 100).show();
				finish();
				Intent intent = new Intent(this, List.class);
				startActivity(intent);
			}
		}
		else if(view == nosubmit){
			finish();
		}
	}
}

```



### List.java ###

**목록보기\*를 구동하기 위한 class**

```

package com.apk.GiveItToMe;

import java.util.ArrayList;
import java.util.StringTokenizer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class List extends Activity implements AdapterView.OnItemSelectedListener, OnItemClickListener {
	static Spinner spinner_list;
	LinearLayout linear;
	TextView select_mode, nocontent;
	private ArrayAdapter spinner_adapter;
	ArrayList<Value> list;
	Typeface font;
	SQLiteDatabase db;
	Database con = null;
	Cursor c;
	Value value;
	ListView lv;
	ValueAdapter va;
	AlertDialog.Builder ad;
	public static int posion = 0;
	boolean deleteMode = false; 	// false : 일반모드             true : 삭제모드
	String giveorget = "";			// 빌렸거나 or 빌려주었거나
	String giveorget_ = "";			// 값을게요 or 갚아주세요

	@Override 
	protected void onCreate(Bundle savedInstanceState) { 		//http://unikys.tistory.com/276 참고
		//TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giveittomelist);

		// DataBase를 쓰기 위해서
		con = new Database(getApplicationContext());

		try{
			db = con.getWritableDatabase();
		}catch (Exception e) {
			// TODO: handle exception
			db = con.getReadableDatabase();
		}
		
		init();
		
		lv.setOnItemClickListener(this);
		spinner_list.setOnItemSelectedListener(this);
	}

	private void rootin(){
		getValue();
		va = new ValueAdapter(this, R.layout.giveittomelist_list, list);
		lv.setAdapter(va);
	}
	private void init() { // *목록 보기*에서 빌려준 돈, 빌린 돈, 모두를 선택해서 볼 수 있음
		// TODO Auto-generated method stub
		linear = (LinearLayout)findViewById(R.id.linear);
		select_mode = (TextView)findViewById(R.id.select_mode);
		nocontent = (TextView)findViewById(R.id.nocontent);
		spinner_list = (Spinner)findViewById(R.id.spinner);
		spinner_list.setPrompt("항목 선택");
		spinner_adapter = ArrayAdapter.createFromResource(this, 
				R.array.spinner_list, 
				android.R.layout.simple_spinner_item);
		spinner_adapter.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
		spinner_list.setAdapter(spinner_adapter);
		lv = (ListView)findViewById(R.id.listview);
		font = Typeface.createFromAsset(getAssets(), "MOM.otf");
		select_mode.setTypeface(font);
		rootin();
	}

	private void getValue() { // *목록 보기*에서 빌려준 돈, 빌린 돈, 모두를 선택해서 볼 수 있음
		// TODO Auto-generated method stub 
		linear.setVisibility(View.VISIBLE);
		nocontent.setVisibility(View.GONE);

		list = new ArrayList<Value>();
		boolean content = true;
		String mode = "";

		c = con.fetchAll(db);	// DB쿼리 수행
		startManagingCursor(c); 

		c.moveToFirst();
		while(!c.isAfterLast()){
			value = new Value();

			if(c.getString(1).equals("get"))
				mode = "빌린 돈";
			else if(c.getString(1).equals("give"))
				mode = "빌려준 돈";

			if(spinner_list.getSelectedItem().toString().equals("모두") ||
					spinner_list.getSelectedItem().toString().equals(mode))
			{
				content = false;
				value.setId(c.getInt(0));
				value.setGiveOrGet(c.getString(1));
				value.setName(c.getString(2));
				value.setPhoneNum(c.getString(3));
				value.setTime(c.getString(4));
				value.setMoney(c.getString(5));
				list.add(value);
				c.moveToNext();
			}
			else
				c.moveToNext();
		}

		if(content){
			linear.setVisibility(View.GONE);
			nocontent.setTypeface(font);
			nocontent.setVisibility(View.VISIBLE);
		}
	}

	private class ValueAdapter extends ArrayAdapter<Value> {
		private ArrayList<Value> lists;

		public ValueAdapter(Context cxt, int resourceID, ArrayList<Value> lists){
			super(cxt,resourceID, lists);
			this.lists=lists;
		}

		public View getView(int position, View v, ViewGroup parent){
			// View를 넘기기 위해서 layout 파일을 초기화 시켜야 함
			LayoutInflater li=
				(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v=li.inflate(R.layout.giveittomelist_list, null);
			// 초기화 된 View에 적절한 데이터를 설정
			Value value=lists.get(position);
			if(value != null){
				// 위에서 inflate 시켰다면 layout xml 파일에 있는 객체가 생성되어 계층구조로 연결되어 있을 것이기 때문에 계층 최상위에게 필요한 View 객체를 달라고 함
				TextView tv1 = (TextView)v.findViewById(R.id.list_giveorget);
				TextView tv2 = (TextView)v.findViewById(R.id.list_name);
				TextView tv3 = (TextView)v.findViewById(R.id.list_phoneNum);
				TextView tv4 = (TextView)v.findViewById(R.id.list_time);
				TextView tv5 = (TextView)v.findViewById(R.id.list_money);

				tv1.setTypeface(font);
				tv2.setTypeface(font);
				tv3.setTypeface(font);
				tv4.setTypeface(font);
				tv5.setTypeface(font);

				if(tv1 != null){
					tv1.setText("종류 : "+value.getGiveOrGet());
				}
				if(tv2 != null){
					tv2.setText("누구 : "+value.getName());
				}    	
				if(tv3 != null){
					tv3.setText("전화번호 : "+value.getPhoneNum());
				}
				if(tv4 != null){
					tv4.setText("시간 : "+value.getTime());
				}
				if(tv5 != null){
					tv5.setText("금액 : "+value.getMoney());
				}
			}    		
			return v;
		}
	}

	private void sendMessage(String a, String b) throws Exception{ // *문자하기* 기능
		// TODO Auto-generated method stub
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(a, null, b, null, null);
	}

	// 옵션 메뉴
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	// 메뉴 옵션은 두 개를 만듬
		menu.add(1, 1, 1, "삭제하기");
		menu.add(2, 2, 2, "모두삭제");
		menu.add(3, 3, 3, "삭제취소");
		return true;
	}

	// 옵션 메뉴 호출
	@Override
	public boolean onOptionsItemSelected(MenuItem item){ // 목록 삭제 기능
		if(item.getItemId() == 1){
			Toast.makeText(this, "touch touch.", 1000).show();
			deleteMode = true;
		}
		else if(item.getItemId() == 2){
			ad = new AlertDialog.Builder(this);
			ad.setTitle("삭제하기");
			ad.setIcon(R.drawable.giveittomeicon);
			ad.setMessage("모두 삭제하시겠습니까?");
			ad.setPositiveButton("삭제하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					con.DBDel(db);
					Toast.makeText(List.this, "삭제완료", 100).show();
					getValue();
					va = new ValueAdapter(List.this, R.layout.giveittomelist_list, list);
					lv.setAdapter(va);
				}
			});
			ad.setNegativeButton("취소하기", null);
			ad.show();
		}
		else if(item.getItemId() == 3){
			Toast.makeText(this, "삭제 취소", 1000).show();
			deleteMode = false;
		}
		rootin();
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int posion, long posion_) {
		// TODO Auto-generated method stub
		rootin();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int posion, long posion_) { // 문자 내용 설정
		// TODO Auto-generated method stub
		List.posion = posion;
		
		if(list.get(List.posion).getGiveOrGet().equals("빌려준 돈")){
			giveorget = "저에게 빌리셨으니, ";
			giveorget_ = "갚아주세요";
		}
		else{
			giveorget = "제가 빌렸으니, ";
			giveorget_ = "갚을게요";
		}
		if(!deleteMode){ // 일반모드일 때
			ad = new AlertDialog.Builder(this);
			ad.setTitle("연락하기");
			ad.setIcon(R.drawable.giveittomeicon);
			ad.setMessage(list.get(posion).getName()+"에게 연락을 취하시겠습니까?");
			ad.setPositiveButton("전화하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + list.get(List.posion).getPhoneNum()));
					startActivity(intent);
				}
			});
			ad.setNeutralButton("문자하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					try{
						sendMessage(list.get(List.posion).getPhoneNum(), 
								list.get(List.posion).getName()+"님, " +
								list.get(List.posion).getTime()+"에 " +
								list.get(List.posion).getMoney()+"을 " + 
								giveorget + giveorget_);
						Toast.makeText(List.this, "전송 성공", 100).show();
					}catch(Exception e){
						Toast.makeText(List.this, "전송 실패", 100).show();
					}
				}
			});
			ad.setNegativeButton("취소", null);
			ad.show();
		}
		else{ // 삭제모드일 때
			ad = new AlertDialog.Builder(this);
			ad.setTitle("삭제하기");
			ad.setIcon(R.drawable.giveittomeicon);
			ad.setMessage("해당 항목을 삭제하시겠습니까?");
			ad.setPositiveButton("삭제하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					con.DBDel(db, list.get(List.posion).getId());
					Toast.makeText(List.this, "삭제완료", 100).show();
					rootin();
				}
			});
			ad.setNegativeButton("취소하기", null);
			ad.show();
		}
	}
}

class Value{
	private int id;
	private String giveorget;
	private String name;
	private String phoneNum;
	private String time;
	private String money;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getGiveOrGet(){
		return giveorget;
	}
	public void setGiveOrGet(String giveorget){
		if(giveorget.equals("give"))
			giveorget = "빌려준 돈";
		else if(giveorget.equals("get"))
			giveorget = "빌린 돈";
		this.giveorget = giveorget;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPhoneNum(){
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}

	public String getTime(){
		return time;
	}
	public void setTime(String time){
		StringTokenizer st = new StringTokenizer(time, ".");
		String AMPM = "";
		time = "";
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		time = year+"년 "+month+"월 "+day+"일　";

		if(hour < 12){
			AMPM = "오전"; 
			if(hour == 0)
				hour = 12;
		}
		else if(hour >= 12){
			AMPM = "오후";
			if(hour > 12)
				hour -= 12;
		}
		time += AMPM + " " + hour + "시 ";
		if(minute < 10)
			time += "0"+minute+"분";
		else
			time += ""+minute+"분";
		this.time = time;
	}

	public String getMoney(){
		return money;
	}
	public void setMoney(String money){
		this.money = money + "원";
	}
}

```


## MoneyContacts.java ##

```

package com.apk.GiveItToMe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import com.apk.giveittome.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MoneyContacts extends Activity implements OnItemClickListener {

	ArrayList<Values> list;
	Typeface font;
	Values value;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giveittome_money);

		ListView lv = (ListView)findViewById(R.id.listview);
		font = Typeface.createFromAsset(getAssets(), "MOM.otf");
		getValue();
		ValueAdapter va = new ValueAdapter(this, R.layout.giveittomelist_list, list);
		lv.setAdapter(va);
		lv.setOnItemClickListener(this);
	}

	private void getValue() {
		// TODO Auto-generated method stub 
		list = new ArrayList<Values>();
		Cursor phoneCursor = null;

		try{
			// 주소록이 저장된 URI
			Uri uContacUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

			// 주소록의 이름과 전화번호의 열 이름
			String strProjection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;

			// 주소록을 얻기 위한 쿼리문을 날리고 커서를 리턴
			phoneCursor = getContentResolver().query(uContacUri, null, null, null, strProjection);
			phoneCursor.moveToFirst();

			// 주소록의 이름
			int nameColumn = phoneCursor.getColumnIndex(Phone.DISPLAY_NAME);
			// 주소록의 전화번호
			int phoneColumn = phoneCursor.getColumnIndex(Phone.NUMBER);

			while(!phoneCursor.isAfterLast()){
				value = new Values();
				value.setName(phoneCursor.getString(nameColumn));
				value.setPhoneNum(phoneCursor.getString(phoneColumn));
				list.add(value);
				phoneCursor.moveToNext();
			}
		} catch (Exception e){
			Toast.makeText(this, "오류", 100).show();
		} finally {
			if(phoneCursor != null){
				phoneCursor.close();
				phoneCursor = null;
			}
		}
	}

	private class ValueAdapter extends ArrayAdapter<Values>{
		private ArrayList<Values> lists;

		public ValueAdapter(Context cxt, int resourceID, ArrayList<Values> lists){
			super(cxt,resourceID, lists);
			this.lists=lists;
		}

		public View getView(int position, View v, ViewGroup parent){
			//View를 넘기기 위해서 layout 파일을 초기화 시켜야 함
			LayoutInflater li=
				(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v=li.inflate(R.layout.giveittomelist_list, null);
			// 초기화된 View에 적절한 데이터를 셋팅..
			Values value=lists.get(position);
			if(value != null){
				// 위에서 inflate 시켰다면 layout xml 파일에 있는 객체가 생성되어 계층구조로 연결되어 있을것임. 계층 최상위에게 내가 필요한 View 객체를 달라고 함.
				TextView tv1 = (TextView)v.findViewById(R.id.list_name);
				TextView tv2 = (TextView)v.findViewById(R.id.list_phoneNum);

				tv1.setTypeface(font);
				tv2.setTypeface(font);

				if(tv1 != null){
					tv1.setText("이름 : "+value.getName());
				}
				if(tv2 != null){
					tv2.setText("전화번호 : "+value.getPhoneNum());
				}    	
			}    		
			return v;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int posion, long posion_) {
		// TODO Auto-generated method stub
		String phoneNum = "";
		StringTokenizer st = new StringTokenizer(list.get(posion).getPhoneNum(), "-");
		while(st.hasMoreElements())
			phoneNum += st.nextToken();
		
		Toast.makeText(this, list.get(posion).getName()+"을 선택", 100).show();
		finish();
		Intent intent = new Intent(this, MoneyActivity.class);
		intent.putExtra("name", list.get(posion).getName());
		if(phoneNum.equals(""))
			intent.putExtra("phoneNum", list.get(posion).getPhoneNum());
		else
			intent.putExtra("phoneNum", phoneNum);
		intent.putExtra("giveorget", getIntent().getStringExtra("giveorget"));
		startActivity(intent);
	}
}

class Values{
	private String name;
	private String phoneNum;

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPhoneNum(){
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}
}

```


### Help.java ###

```

package com.apk.GiveItToMe;

import com.apk.giveittome.R;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Help extends Activity{
	
	Typeface font;
	TextView help_text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giveittome_help);
		
		init();
		
		help_text.setText("Give It To Me\n\n" +
				"돈을 빌리거나 빌려줬을 때 이름, 전화번호, 시간, 가격을 기록한 뒤 안내 문자나 전화를 보내는 어플\n\n" + 
				"Show Me The Money");
	}

	private void init() {
		// TODO Auto-generated method stub
		help_text = (TextView)findViewById(R.id.help_help_text);
		font = Typeface.createFromAsset(getAssets(), "MOM.otf");
		help_text.setTypeface(font);
	}
}

```



## Layout 소개 ##

![http://comp166-koreauniv.googlecode.com/files/layout.png](http://comp166-koreauniv.googlecode.com/files/layout.png)


### giveittome\_main.xml ###

Main.java와 관련

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#ffffff"
    >
    <LinearLayout
    	android:orientation="horizontal"
    	android:layout_width="fill_parent"
    	android:layout_height="wrap_content"
    	android:gravity="center"
    	android:layout_marginTop="20px"
    	android:layout_weight="1">
	    <ImageView
			android:src="@drawable/main_give"
			android:id="@+id/main_give"
			android:layout_width="wrap_content"
	    	android:layout_height="wrap_content"/>
	    <ImageView
			android:src="@drawable/main_get"
			android:id="@+id/main_get"
			android:layout_width="wrap_content"
	    	android:layout_height="wrap_content" />
	</LinearLayout>

    <ImageView
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5px"
        android:layout_weight="7"
        android:src="@drawable/giveittome" />

	<LinearLayout
    	android:orientation="horizontal"
    	android:layout_width="fill_parent"
    	android:layout_height="wrap_content"
    	android:gravity="center"
    	android:layout_weight="1">
    	<ImageView
    		android:src="@drawable/main_list"
			android:id="@+id/main_list"
			android:layout_width="wrap_content"
	    	android:layout_height="wrap_content"/>
    	<ImageView
    	    android:id="@+id/main_exit"
    	    android:layout_width="wrap_content"
    	    android:layout_height="wrap_content"
    	    android:src="@drawable/main_exit" />
	</LinearLayout>
	<LinearLayout
    	android:orientation="horizontal"
    	android:layout_width="fill_parent"
    	android:layout_height="wrap_content"
    	android:gravity="center"
    	android:layout_weight="1">
		<ImageView
		    android:id="@+id/main_help"
		    android:layout_width="wrap_content"
		    android:layout_height="wrap_content"
		    android:layout_marginLeft="10px"
		    android:src="@drawable/main_help" />
</LinearLayout>
</LinearLayout>

```


### giveittome\_moneyactivity.xml ###

MoneyActivity.java와 관련

```

<?xml version="1.0" encoding="utf-8" ?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	android:orientation="vertical" 
	android:layout_width="fill_parent"
	android:layout_height="fill_parent"
	android:background="#ffffff"
	android:gravity="center">
	<LinearLayout
		android:orientation="horizontal" 
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:gravity="center"
		android:layout_weight="1">
		<TextView
			android:id="@+id/text_name"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:text="이름　"
			android:textSize="18px"
			android:textColor="#000000"/>
		<EditText
			android:id="@+id/edit_name"
			android:layout_width="150px"
			android:layout_height="wrap_content"
			android:layout_marginLeft="35px"/>
	</LinearLayout>
	<LinearLayout
		android:orientation="horizontal" 
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:gravity="center"
		android:layout_weight="1">
		<TextView
			android:id="@+id/text_phoneNum"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:text="전화번호　"
			android:textSize="18px"
			android:textColor="#000000"/>
		<EditText
			android:id="@+id/edit_phoneNum"
			android:layout_width="150px"
			android:layout_height="wrap_content"
			android:numeric="integer"/>
	</LinearLayout>
	<LinearLayout
		android:orientation="horizontal" 
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:gravity="center"
		android:layout_weight="1">
		<TextView
			android:id="@+id/text_time"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:text="시간　"
			android:textSize="18px"
			android:textColor="#000000"/>
		<EditText
			android:id="@+id/edit_time"
			android:layout_width="150px"
			android:layout_height="wrap_content"
			android:editable="false"
			android:focusable="false"
			android:layout_marginLeft="32px"/>
	</LinearLayout>
	<LinearLayout
		android:orientation="horizontal" 
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:gravity="center"
		android:layout_weight="1">
		<TextView
			android:id="@+id/text_money"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:text="가격　"
			android:textSize="18px"
			android:textColor="#000000"/>
		<EditText
			android:id="@+id/edit_money"
			android:layout_width="150px"
			android:layout_height="wrap_content"
			android:numeric="integer"
			android:layout_marginLeft="34px"/>
	</LinearLayout>
	<LinearLayout
		android:orientation="horizontal" 
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:gravity="center"
		android:layout_marginTop="50px"
		android:layout_weight="5">
		<ImageView
			android:id="@+id/submit"
			android:src="@drawable/submit"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"/>
		<ImageView
			android:id="@+id/nosubmit"
			android:src="@drawable/nosubmit"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:layout_marginLeft="50px"/>
	</LinearLayout>
</LinearLayout>

```


### giveittomelist.xml ###

List.java와 관련

```

<?xml version="1.0" encoding="utf-8" ?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	android:orientation="vertical" 
	android:layout_width="fill_parent"
	android:layout_height="fill_parent"
	android:background="#ffffff">
		<TextView 
			android:id="@+id/list_giveorget"
			android:layout_width="wrap_content" 
			android:layout_height="wrap_content"
			android:textSize="18px"
			android:textColor="#000000"/>
		<TextView 
			android:id="@+id/list_name"
			android:layout_width="wrap_content" 
			android:layout_height="wrap_content"
			android:textSize="18px"
			android:textColor="#000000"/>
		<TextView 
			android:id="@+id/list_phoneNum"
			android:layout_width="wrap_content" 
			android:layout_height="wrap_content"
			android:textSize="18px"
			android:textColor="#000000"/>
		<TextView 
			android:id="@+id/list_time"
			android:layout_width="wrap_content" 
			android:layout_height="wrap_content"
			android:textSize="18px"
			android:textColor="#000000"/>
		<TextView 
			android:id="@+id/list_money"
			android:layout_width="wrap_content" 
			android:layout_height="wrap_content"
			android:textSize="18px"
			android:textColor="#000000"/>
</LinearLayout>

```


### giveittomelist\_list.xml ###

List.java와 관련

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#ffffff" android:orientation="vertical">
    <LinearLayout
    	android:orientation="horizontal"
    	android:layout_width="fill_parent"
    	android:layout_height="wrap_content"
    	android:background="#ffffff" 
    	android:layout_weight="0">
    	<TextView
    		android:id="@+id/select_mode"
    		android:layout_height="wrap_content"
			android:layout_width="wrap_content"
			android:text="선택하세요   "
			android:textSize="20px"
    		android:textColor="#000000"/>
	    <Spinner
			android:id="@+id/spinner"
			android:layout_height="wrap_content"
			android:layout_width="fill_parent"/>
	</LinearLayout>
	<LinearLayout
    	android:orientation="horizontal"
    	android:id="@+id/linear"
    	android:layout_width="fill_parent"
    	android:layout_height="wrap_content"
    	android:background="#ffffff" 
    	android:layout_weight="100">
		<ListView 
			android:id="@+id/listview" 
			android:layout_width="fill_parent" 
			android:layout_height="wrap_content"/>
	</LinearLayout>
	<TextView
	    android:id="@+id/nocontent"
	    android:visibility="gone"
	    android:layout_width="fill_parent"
	    android:layout_height="wrap_content"
		android:gravity="center"
	    android:text="저장된 내용이 없습니다."
	    android:textSize="20px"
	    android:textColor="#000000" 
	    android:layout_weight="100"/>
	<Button
	    android:id="@+id/delete"
	    android:visibility="gone"
	    android:layout_width="fill_parent"
	    android:layout_height="wrap_content"
	    android:fitsSystemWindows="true"
	    android:text="삭제" 
	    android:layout_weight="0"/>
</LinearLayout>

```


### giveittome\_help.xml ###

Help.java와 관련

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#ffffff"
    >
	<TextView
		android:id="@+id/help_help_text"
		android:layout_width="fill_parent"
    	android:layout_height="fill_parent"
    	android:gravity="center"
    	android:textSize="20px"
		android:textColor="#000000"
		android:layout_weight="10"/>
</LinearLayout>

```



## 구동 Screen Shots ##

**빌려주기** & **빌리기**

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-00.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-00.png)

빌려준 & 빌린 사람의 연락처를 주소록에서 불러올지, 새로 입력할지를 선택

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-17.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-17.png)

_주소록에서 불러오기_

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-29.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-29.png)

_새로 입력_

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-40.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-27-40.png)

_새로 입력_ 이름이 뭐에요?

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-28-17.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-28-17.png)

_새로 입력_ '이름' 입력

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-22.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-22.png)

_새로 입력_ 전화번호 뭐에요?

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-28.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-28.png)

_새로 입력_ '전화번호' 입력

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-35.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-35.png)

_새로 입력_ 시간을 적어줘요

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-59.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-29-59.png)

_새로 입력_ '년, 월, 일' 입력

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-09.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-09.png)

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-22.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-22.png)

_새로 입력_ '시, 분, '오전&오후' 입력

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-34.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-34.png)

_새로 입력_ Show me the money

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-54.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-30-54.png)

_새로 입력_ '가격' 입력

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-31-02.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-31-02.png)

_새로 입력_ '저장 완료'


**목록보기** true : 일반모드

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-19.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-19.png)

_모두_

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-32.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-32.png)

_빌린 돈_

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-38.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-38.png)

_빌려준 돈_

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-55.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-32-55.png)

빌려준 & 빌린 사람에게 전화하기 & 문자하기 & 취소하기를 선택

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-33-48.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-33-48.png)

_전화하기_

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-34-39.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-34-39.png)

_문자하기_ '전송성공'

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-34-50.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-34-50.png)

_문자하기_ '제가 빌렸으니, 갚을게요 & 저에게 빌리셨으니, 갚아주세요'


**목록보기** false : 삭제모드

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-18.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-18.png)

_삭제하기_ 삭제하기 & 모두삭제 & 취소하기 중 선택

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-25.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-25.png)

_삭제하기_ 삭제할 항목을 'touch touch'

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-29.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-29.png)

_삭제하기_ '해당 항목을 삭제하시겠습니까?'

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-37.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-37.png)

_모두삭제_ '모두 삭제하시겠습니까?'

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-54.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-01-17-35-54.png)

_삭제하기_ '삭제완료'


**종료하기**

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-09-22-28-16.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-09-22-28-16.png)

'종료하시겠습니까?'


**도움말**

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-09-22-28-19.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-09-22-28-19.png)

'Give It To Me

돈을 빌리거나 빌려줬을 때 이름, 전화번호, 시간, 가격을 기록한 뒤 안내 문자나 전화를 보내는 어플리케이션

Show Me The Money'