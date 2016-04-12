# Introduction #

대학생이라면 누구나 가지고 있는 시간표, 하지만 새로운 일정이 생길때마다 기존의 시간표 사진과 대조하면서 시간표를 짜는것은 불편하기만 합니다. 또한 kutime에서 시간표를 만들고 이를 사진으로 저장하며 핸드폰으로 보내는것 또한 불편합니다. 이러한 점을 개선하기 위하여 시간표와 달력을 한개의 어플로 만들 계획입니다.

# Details #

**기능 1** 캘린더의 기본화면을 시간표처럼 구성,kutime에서의 디자인을 채택

**기능 2** 일정을 짤때 [9월 첫째주 부터 12월 말까지의 월요일 1교시]같이 일정을 만들 수 있어 시간표 같은 캘린더를 만듬

**기능 3** 힘들겠지만 가능하다면 kutime과의 연동하여 자동으로 시간표를 받음

**기능 4** 시간표 마다 색을 지정할 수 있게 하여 중요한일과 덜중요한일 등등을 구분 할 수 있게 함
고대생이 사용하는 시간표
http://comp166-koreauniv.googlecode.com/files/2%EC%B0%A8%20-%20%EB%B3%B5%EC%82%AC%EB%B3%B8.JPG

이 시간표를 깔끔하게 하여 기본 ui를 만들고
![http://comp166-koreauniv.googlecode.com/files/%EA%B8%B0%EB%B3%B8%20%ED%8F%AC%EB%A7%B7.png](http://comp166-koreauniv.googlecode.com/files/%EA%B8%B0%EB%B3%B8%20%ED%8F%AC%EB%A7%B7.png)

이런식으로 시간표 말고도 일정을 만들수도 있음
![http://comp166-koreauniv.googlecode.com/files/%EC%A0%9C%EB%AA%A9%20%EC%97%86%EC%9D%8C.png](http://comp166-koreauniv.googlecode.com/files/%EC%A0%9C%EB%AA%A9%20%EC%97%86%EC%9D%8C.png)

# 소스코드 #

저는 이번 텀과제를 하면서 만든 모든 소스는 제가 직접 코드하나하나 써가면서 공부하고 모르는것은 질문하면서 하였는데요.
공부한 책은 교수님이 추천해주신

Do it안드로이드 프로그래밍이라는 책과

안드로이드 프로그래밍 정복 1,2입니다.

출처랄것까지는 없겠지만 책을보면서 공부했기때문에 출처는 책이 되겠네요.

책에 나온 코드를 찾아보니 인터넷에 올려놓았더군요.

http://147.46.109.56:9090/town/projects.jsp?sort=1&dir=%5Cbook04%5CSampleListView

저도 처음에는 너무 힘들어서 다른애들처럼 배낄까도 생각해봣는데 한번해보니까 그대로 복사 붙여넣기 하면 전체에서 오류가 뜨고 오류를 하나하나 지우려해도 결국은 다시 써야하더군요. 그리고 복사를 하게되면 gen폴더에 있는 R.java라는 데이터공간을 할당해주는 클래스파일이 있는것같은데 이게 바로바로 반응을 해주지 않더군요. 그렇다고 제가 직접 데이터를 할당해준다고하면 치명적인 오류가 뜰수있을것 같아서 무섭고도해서 그냥 공부하는겸 해서 직접 책을보면서 하였습니다.

# 클래스 소개 #

![https://comp166-koreauniv.googlecode.com/files/%E3%85%8B%E3%85%8B%E3%85%8B%E3%85%8B.png](https://comp166-koreauniv.googlecode.com/files/%E3%85%8B%E3%85%8B%E3%85%8B%E3%85%8B.png)

제 캘린더에 사용되는 클래스는 그리드뷰와 리스트뷰를 사용합니다.

그리드뷰와 리스트뷰에대한 설명은 밑에서 하기로 하겠습니다.

이 두가지 뷰의 특성상 많은 클래스를 사용하게 됩니다.

그리고 캘린더의 정보를 저장할 전역 객체로 사용되는 Schedule클래스가 존재합니다.

**1.메인클래스**

![https://comp166-koreauniv.googlecode.com/files/%E3%85%81%E3%85%81%E3%85%81%E3%85%81%E3%85%81.png](https://comp166-koreauniv.googlecode.com/files/%E3%85%81%E3%85%81%E3%85%81%E3%85%81%E3%85%81.png)

그림을 보면 메인클래스에서 많은 전역 변수들을 사용하고 있는데요.

캘린더를 사용하는 메인클래스의 특성상 많은 정보들이 오가고 그리드뷰를 사용하는 캘린더 객체를 만들어야하는 특성상 많은 전역 변수들을 사용하게 되었습니다.

```

package com.example.hi;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import android.util.Log;

public class MainActivity extends Activity implements OnItemClickListener,
		OnClickListener {
	public int pos;
	public int y;
	public int m;
	public String d;
	public static int p1 = -1;
	public static int y1;
	public static int m1;
	public static String d1;
	public static int SUNDAY = 1;
	public static int MONDAT = 2;
	public static int TUESDAY = 3;
	public static int WEDNSETAY = 4;
	public static int THURSDAY = 5;
	public static int FRIDAY = 6;
	public static int SATURDAY = 7;

	private TextView CalendarTitle;
	private GridView GridViewCalendar;

	private ArrayList<Day> DayList;
	private CalendarAdapter CalendarAdapter;
	Calendar ThisMonth;
/*onCreate메소드는 이 클래스가 실행되었을때 바로 실행되는 메소드를 말합니다. 초기
에 필요한 값들을 초기화시켜주고 레이아웃을 설정해줍니다. 이때 잘못설정하면 앱이 실
행되지 않습니다.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent3 = getIntent();
		p1 = intent3.getIntExtra("pos", -1);
		d1 = intent3.getStringExtra("d");
		y1 = intent3.getIntExtra("y", 0);
		m1 = intent3.getIntExtra("m", 0);
/*p1=-1이라는 뜻은 p1이 초기화되고 한번도 사용되지 않은상태를 말하는것으로 맨처음
클래스가 실행될때를 뜻합니다. 그때에 전역 객체 클래스인 ScheduleList의 Load를 실행
하여 객체를 생성합니다.*/
		if (p1 == -1) {
			ScheduleList.Load();
		}

		pos = p1;
		d = d1;
		y = y1;
		m = m1;

		Button bLastMonth = (Button) findViewById(R.id.b_last);
		Button bNextMonth = (Button) findViewById(R.id.b_next);

		CalendarTitle = (TextView) findViewById(R.id.tv_title);
		CalendarTitle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), List.class);
				intent.putExtra("pos", pos);
				intent.putExtra("d", d);
				intent.putExtra("y", y);
				intent.putExtra("m", m);
				startActivity(intent);
			}

		});
		GridViewCalendar = (GridView) findViewById(R.id.gv_calendar);

		bLastMonth.setOnClickListener(this);
		bNextMonth.setOnClickListener(this);
		GridViewCalendar.setOnItemClickListener(this);
		DayList = new ArrayList<Day>();
	}
/*onResume메소드는 onCreate메소드와 유사합니다. 앞의 메소드는 새롭게 실행할때 사용
되는 메소드라면 뒤의 메소드는 이 메소드를 만들어주면 onCreate가 실행된후 다시 해당
클래스에 접근을 하게되면 onCreate가 아닌 onResume메소드가 실행됩니다.*/
	protected void onResume() {
		super.onResume();
/*이 메소드의 기능은 다른 액티비티에 들어가서 기존의 사라진 그리드뷰의 포맷을 다시
지정해주는 역할을 합니다.*/
		ThisMonth = Calendar.getInstance();
		ThisMonth.set(Calendar.DAY_OF_MONTH, 1);
		getCalendar(ThisMonth);
	}


/*가장 긴 메소드인 getCalendar입니다.
getCalendar의 중요한 목적은 그리드뷰에 Calendar객체를 보여주기 위함입니다.
return값이 Calendar가 아닌 이유는 이 메소드로 새로운 객체를 생성하는것이 아니라  
받은 Calendar객체를 그리드뷰에 생성하기 위함이기 때문입니다.*/
	private void getCalendar(Calendar calendar) {
		int lastMonthStartDay;
		int dayOfMonth;
		int thisMonthLastDay;

		DayList.clear();

		dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
		thisMonthLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		calendar.add(Calendar.MONTH, -1);
		Log.e("지난달 마지막일", calendar.get(Calendar.DAY_OF_MONTH) + "");

		lastMonthStartDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		calendar.add(Calendar.MONTH, 1);
		Log.e("이번달 시작일", calendar.get(Calendar.DAY_OF_MONTH) + "");

		if (dayOfMonth == SUNDAY) {
			dayOfMonth += 7;
		}

		lastMonthStartDay -= (dayOfMonth - 1) - 1;
/*캘린더의 타이틀을 바꾸는 메소드를 호출*/
		CalendarTitle.setText(ThisMonth.get(Calendar.YEAR) + "년 "
				+ (ThisMonth.get(Calendar.MONTH) + 1) + "월");

		Day day;

		Log.e("DayOfMOnth", dayOfMonth + "");

		for (int i = 0; i < dayOfMonth - 1; i++) {
			int date = lastMonthStartDay + i;
			day = new Day();
			day.setDay(Integer.toString(date));
			day.setInMonth(false);

			DayList.add(day);
		}
		for (int i = 1; i <= thisMonthLastDay; i++) {
			day = new Day();
			day.setDay(Integer.toString(i));
			day.setInMonth(true);

			DayList.add(day);
		}
		for (int i = 1; i < 42 - (thisMonthLastDay + dayOfMonth - 1) + 1; i++) {
			day = new Day();
			day.setDay(Integer.toString(i));
			day.setInMonth(false);
			DayList.add(day);
		}

		initCalendarAdapter();
	}

/*getLastMonth메소드는 새로운 이전 달 캘린더 객체를 만드는 메소드입니다.
현재의 캘린더 객체를 받아와서 그를 바탕으로 이전 달의 캘린더 객체를 가져옵니다.
그 후 그 객체를 리턴합니다.*/

	private Calendar getLastMonth(Calendar calendar) {
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				1);
		calendar.add(Calendar.MONTH, -1);
/*캘린더의 타이틀을 바꾸는 메소드를 호출*/
		CalendarTitle.setText(ThisMonth.get(Calendar.YEAR) + "년 "
				+ (ThisMonth.get(Calendar.MONTH) + 1) + "월");
		return calendar;
	}

/*getNextMonth메소드는 새로운 다음달 캘린더 객체를 만드는 메소드입니다.
현재의 캘린더 객체를 받아와서 그를 바탕으로 다음달의 캘린더 객체를 가져옵니다.
그 후 그 객체를 리턴합니다.*/

	private Calendar getNextMonth(Calendar calendar) {
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				1);
		calendar.add(Calendar.MONTH, +1);
/*캘린더의 타이틀을 바꾸는 메소드를 호출*/
		CalendarTitle.setText(ThisMonth.get(Calendar.YEAR) + "년 "
				+ (ThisMonth.get(Calendar.MONTH) + 1) + "월");
		return calendar;
	}
/*onClick메소드는 화면에 있는 아이템이 클릭되면 실행되는 메소드입니다. 이 메소드에서는 클릭된 정보를 R.java를 통해서 할당한 id정보를 통해서 받아옵니다.*/
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_last:
/*b_last라는 id는 이전 달로 이동하는 버튼입니다. 따라서 현재의 캘린더 객체정보를 받아서 이전 캘린더 객체를 만들고 그를 다시 현재캘린더 객체로 만들어야합니다.*/
			ThisMonth = getLastMonth(ThisMonth);
			getCalendar(ThisMonth);
			break;
		case R.id.b_next:
/*b_next라는 id는 다음 달로 이동하는 버튼입니다. 따라서 현재의 캘린더 객체정보를 받아서 다음 캘린더 객체를 만들고 그를 다시 현재캘린더 객체로 만들어야합니다.*/
			ThisMonth = getNextMonth(ThisMonth);
			getCalendar(ThisMonth);
			break;
		}
	}
/*initCalendarAdapter메소드입니다.
이 메소드에서는 새로운 캘린더 객체를 만들때에 day라는 레이아웃에 새로운 객체들을 
집어넣는 기능을 합니다.*/
	private void initCalendarAdapter() {
		CalendarAdapter = new CalendarAdapter(this, R.layout.day, DayList);
		GridViewCalendar.setAdapter(CalendarAdapter);
	}
/*onItemClick메소드는 그리드뷰나 리스트뷰를 사용하는 클래스에서 사용되는 메소드입니다. 
해당 뷰를 통해서 만든 객체가 클릭되었을때 발생하는 이벤트를 정의해주는 메소드로
만들지 않았다면 해당 객체를 클릭하여도 아무런 반응을 주지 않습니다.*/
	public void onItemClick(AdapterView<?> parent, View v, int position,
			long arg3) {
/*게터 메소드를 통해서 해당 정보를 받아옵니다.*/
		Day day = DayList.get(position);
		String j = day.getDay();
/*토스트를 사용한 이유는 해당날짜가 올바르게 클릭되었는지 확인해주기 위해서입니다.*/
		Toast.makeText(
				this,
				ThisMonth.get(Calendar.YEAR) + "년"
						+ (ThisMonth.get(Calendar.MONTH) + 1) + "월"
						+ j + "일" + position, Toast.LENGTH_LONG).show();
/*클릭을 한후 그 클릭정보를 저장하는 부분입니다.
이 정보는 이 메소드에서만 사용하는것이 아니므로 전역 변수를 사용합니다.*/
		pos = position;
		d = day.getDay();
		y = ThisMonth.get(Calendar.YEAR);
		m = ThisMonth.get(Calendar.MONTH);

	}
/*onOptionsItemSelected메소드는 onCreateOptionMenu를 통해서 만든 메뉴를 클릭했을때 실행되는 메소드입니다.
이 메소드를 만들지 않으면 메뉴를 클릭하여도 아무런 반응이 뜨질 않습니다.*/
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:/*case1은 일이라는 메뉴를 클릭한 결과로 List라는 클래스로 정보를 가지고 intent를 합니다.*/
			Intent intent = new Intent(this, List.class);
			intent.putExtra("pos", pos);
			intent.putExtra("d", d);
			intent.putExtra("y", y);
			intent.putExtra("m", m);
			startActivity(intent);
			break;
		case 2:/*case2는 새로만들기라는 메뉴를 클릭한 결과로 Make라는 클래스로 정보를 가지고 intent를 합니다.*/
			Intent intent1 = new Intent(this, Make.class);
			intent1.putExtra("pos", pos);
			intent1.putExtra("d", d);
			intent1.putExtra("y", y);
			intent1.putExtra("m", m);
			startActivity(intent1);
			break;
		}
		return true;
	}


/*onCreateOptionMenu 메소드는 클래스가 실행될때 메뉴를 생기게하는 메소드입니다.
클래스를 생성하면 기본적으로 생기는 디폴드값인 메소드입니다.
제 앱에서는 2개의 메뉴를 사용하는데 기본적으로 한 화면에 최대 6가지의 메뉴화면을
보일수 있고 그 메뉴마다 또 다른 메뉴를 내포하여 2차원 배열처럼 메뉴를 만들수 있습니다. 
메뉴의 내용은 onOptionsItemSelected라는 메소드를 통해서 실행시킬수 있습니다.*/
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		menu.add(0, 1, 2, "일");
		menu.add(0, 2, 2, "새로만들기");

		return true;
	}

}


```

**2.그리드뷰 클래스**

**CalendarAdapter.java**

그리드 뷰에는 어댑터 클래스가 필요합니다.

이 어댑터 클래스에서는 그리드뷰의 아이템 각각의 속성을 부여해주는 역할을 합니다.

![https://comp166-koreauniv.googlecode.com/files/CalendarAdapter.png](https://comp166-koreauniv.googlecode.com/files/CalendarAdapter.png)

```

package com.example.hi;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalendarAdapter extends BaseAdapter {
	private ArrayList<Day> DayList;
	private Context Cont;
	private int Resource;
	private LayoutInflater LiInflater;

	public CalendarAdapter(Context context, int textResource,
			ArrayList<Day> dayList) {
		this.Cont = context;
		this.DayList = dayList;
		this.Resource = textResource;
		this.LiInflater = (LayoutInflater) Cont
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
/*꼭 있어야하는 getCount메소드
이 메소드에서는 크기를 측정합니다.*/
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return DayList.size();
	}
/*꼭 있어야하는 getItem메소드
이 메소드에서는 아이템의 갯수를 측정합니다.*/
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return DayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
/*getView 메소드에서는 아이템 하나하나를 만드는 역할을 합니다.
본 메소드에서는 Day라는 클래스를 이용하여 정보를 저장하고 날짜에 따른 색을 부여해
주고 각 아이템의 크기를 부여해줍니다.*/
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Day day = DayList.get(position);

		DayViewHolde ViewHolder;

		if (convertView == null) {
			convertView = LiInflater.inflate(Resource, null);

			if (position % 7 == 6) {
				convertView.setLayoutParams(new GridView.LayoutParams(
						getCellWidthDP() + getRestCellWidthDP(),
						getCellHeightDP()));
			} else {
				convertView.setLayoutParams(new GridView.LayoutParams(
						getCellWidthDP(), getCellHeightDP()));
			}

			ViewHolder = new DayViewHolde();

			ViewHolder.llBackground = (LinearLayout) convertView
					.findViewById(R.id.day_cell_background);
			ViewHolder.tvDay = (TextView) convertView
					.findViewById(R.id.day_cell);

			convertView.setTag(ViewHolder);
		} else {
			ViewHolder = (DayViewHolde) convertView.getTag();
		}

		if (day != null) {
			ViewHolder.tvDay.setText(day.getDay());

			if (day.isInMonth()) {
				if (position % 7 == 0) {
					ViewHolder.tvDay.setTextColor(Color.RED);
				} else if (position % 7 == 6) {
					ViewHolder.tvDay.setTextColor(Color.BLUE);
				} else {
					ViewHolder.tvDay.setTextColor(Color.BLACK);
				}
			} else {
				ViewHolder.tvDay.setTextColor(Color.GRAY);
			}

		}

		return convertView;
	}



	public class DayViewHolde {
		public LinearLayout llBackground;
		public TextView tvDay;

	}
/*이 밑의 3개의 메소드는 그리드뷰에 표시되는 아이템의 크기를 결정해준다.*/
	private int getCellWidthDP() {

		int cellWidth = 480 / 7;

		return cellWidth;
	}

	private int getRestCellWidthDP() {

		int cellWidth = 480 % 7;

		return cellWidth;
	}

	private int getCellHeightDP() {
		int cellHeight = 480 / 6;

		return cellHeight;
	}



```

**Day.java**

![https://comp166-koreauniv.googlecode.com/files/Day.png](https://comp166-koreauniv.googlecode.com/files/Day.png)

Day클래스에서는 어댑터에 사용되는 정보드를 지니고 있습니다.

따라서 그리드뷰에 있는 모든 아이템 하나하나가 Day라는 객체를 가지게 됩니다.

```

package com.example.hi;

public class Day
{
	private String day;
	private boolean inMonth;
/*날짜를 리턴해주는 게터 메소드*/
	public String getDay()
	{
		return day;
	}
/*날짜를 세팅해주는 세터 메소드*/
	public void setDay(String day)
	{
		this.day = day;
	}
/*맞는 달인지 답을 리턴해주는 메소드*/
	public boolean isInMonth()
	{
		return inMonth;
	}
/*달을 세팅해주는 세터 메소드*/
	public void setInMonth(boolean inMonth)
	{
		this.inMonth = inMonth;
	}

}


```

**3.리스트뷰 클래스**

**List.java**

![https://comp166-koreauniv.googlecode.com/files/sss.png](https://comp166-koreauniv.googlecode.com/files/sss.png)

이 클래스에서는 전역 객체 ScheduleList의 정보를 받아와 그 정보들을 리스트뷰의 형식
으로 표시해줍니다.


```

package com.example.hi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class List extends Activity {
	DataListView list;
	public static int yy = 5;
	public static int mm = 5;
	public static int dd = 31;
	public static int tt = 24;
	public static int pp = 5;

	/**
	 * 어댑터 객체
	 */
	IconTextListAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int ttt = 0;
		Intent intent = getIntent();
		int pos = intent.getIntExtra("pos", 0);
		String d = intent.getStringExtra("d");
		int y = intent.getIntExtra("y", 0);
		int m = intent.getIntExtra("m", 0);
		String k = y + "년" + (m + 1) + "월" + d + "일";
		// 타이틀 없애기
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// 리스트뷰 객체 생성
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,
				ViewGroup.LayoutParams.FILL_PARENT);
		list = new DataListView(this);

		// 어댑터 객체 생성
		adapter = new IconTextListAdapter(this);

		// 아이템 데이터 만들기

		adapter.addItem(new IconTextItem(k, "일정목록", ""));

		// 리스트뷰에 어댑터 설정
		list.setAdapter(adapter);

		// 새로 정의한 리스너로 객체를 만들어 설정
		list.setOnDataSelectionListener(new OnDataSelectionListener() {
			public void onDataSelected(AdapterView parent, View v,
					int position, long id) {
				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();

				Toast.makeText(getApplicationContext(),
						"Selected : " + curData[0], 2000).show();
			}
		});

/*화면을 리스트뷰로 채우는 곳입니다.
for문을 사용하여 해당날짜의 모든 데이터를 표시합니다.*/
		setContentView(list, params);
		for (ttt = 0; ttt < 24; ttt++) {
			adapter.addItem(new IconTextItem(ScheduleList.Sch[y - 2013][m][pos]
					.gettitle(ttt), ScheduleList.Sch[y - 2013][m][pos]
					.getmessage(ttt), (ttt + 1) + "시"));
		}

	}
/*밑의 두 메소드는 메인 클래스에서도 설명을 하였습니다.*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.list, menu);
		menu.add(0, 1, 2, "일");
		menu.add(0, 2, 2, "새로만들기");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Intent intent = new Intent(getBaseContext(), ListView.class);
			startActivity(intent);
			break;
		case 2:
			Intent intent1 = new Intent(getBaseContext(), Make.class);
			startActivity(intent1);
			break;
		}
		return true;
	}
}

```

**IconTextListAdapter.java**

![https://comp166-koreauniv.googlecode.com/files/xxx.png](https://comp166-koreauniv.googlecode.com/files/xxx.png)

그리드뷰와 마찬가지로 리스트뷰에서도 어댑터를 사용합니다.

어댑터를 사용하여 뷰의 각 아이템의 속성을 부여해줍니다.

```

package com.example.hi;

import java.util.ArrayList;
import java.util.List;
 
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
 

public class IconTextListAdapter extends BaseAdapter {
 
    private Context Cont;
 
    private List<IconTextItem> Items = new ArrayList<IconTextItem>();
 
    public IconTextListAdapter(Context context) {
        Cont = context;
    }
 
    public void addItem(IconTextItem it) {
        Items.add(it);
    }
 
    public void setListItems(List<IconTextItem> lit) {
        Items = lit;
    }
 
    public int getCount() {
        return Items.size();
    }
 
    public Object getItem(int position) {
        return Items.get(position);
    }
 
    public boolean areAllItemsSelectable() {
        return false;
    }
 
    public boolean isSelectable(int position) {
        try {
            return Items.get(position).isSelectable();
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }
 
    public long getItemId(int position) {
        return position;
    }
/*뷰의 아이템 하나하나의 옵션을 주는 메소드입니다. 이 리스트 뷰에서는 총 3개의 텍
스트뷰를 사용하므로 3개의 텍스트를 주는 옵션을 사용합니다.*/
    public View getView(int position, View convertView, ViewGroup parent) {
        IconTextView itemView;
        if (convertView == null) {
            itemView = new IconTextView(Cont, Items.get(position));
        } else {
            itemView = (IconTextView) convertView;
             
          
            itemView.setText(0, Items.get(position).getData(0));
            itemView.setText(1, Items.get(position).getData(1));
            itemView.setText(2, Items.get(position).getData(2));
        }
 
        return itemView;
    }
 
}

```

**IconTextView**

![https://comp166-koreauniv.googlecode.com/files/%E3%85%94%E3%85%94%E3%85%94.png](https://comp166-koreauniv.googlecode.com/files/%E3%85%94%E3%85%94%E3%85%94.png)

이곳에서는 레이아웃을 사용하여 한 아이템으로 보여줄 뷰를 정의하는 역할을 합니다.
XML 레이아웃을 이용하여 뷰의 모양을 결정합니다.

```

package com.example.hi;

import android.content.Context;

import android.view.LayoutInflater;

import android.widget.LinearLayout;
import android.widget.TextView;

/*이 클래스는 리니어 레이아웃을 상속합니다. 따라서 다른 뷰들을 포함할수 있습니다.*/

public class IconTextView extends LinearLayout {

	private TextView mText01;

	private TextView mText02;

	private TextView mText03;

	public IconTextView(Context context, IconTextItem aItem) {
		super(context);
/*이곳에서는 메모리를 객체화 시킵니다.
xml 레이아웃을 레이아웃 인플레이터를 이용하여 객체화를 시킵니다.*/
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.listitem, this, true);
/*이 부분에서는 레이아웃에 정의된 텍스트 뷰르 객체를 참조합니다.*/
		mText01 = (TextView) findViewById(R.id.dataItem01);
		mText01.setText(aItem.getData(0));

		mText02 = (TextView) findViewById(R.id.dataItem02);
		mText02.setText(aItem.getData(1));

		mText03 = (TextView) findViewById(R.id.dataItem03);
		mText03.setText(aItem.getData(2));

	}
/*전달받은 데이터를 각 테스트뷰에 설정하는 부분입니다.*/
	public void setText(int index, String data) {
		if (index == 0) {
			mText01.setText(data);
		} else if (index == 1) {
			mText02.setText(data);
		} else if (index == 2) {
			mText03.setText(data);
		} else {
/*이 경우에는 그 어떤 부분도 속하지 않은 부분으로 에러를 표시합니다.*/
			throw new IllegalArgumentException();
		}
	}

}

```

**onDataSelectionListener**

![https://comp166-koreauniv.googlecode.com/files/onDataSelectionListener.png](https://comp166-koreauniv.googlecode.com/files/onDataSelectionListener.png)

onDataSelectionListener클래스는 리스트뷰의 객체를 클릭할때 나타날 이벤트를 만들기
위한 클래스입니다.

```

package com.example.hi;

import android.view.View;
import android.widget.AdapterView;

public interface OnDataSelectionListener {

/*본 앱에서는 사용할만한 이벤트가 없어서 그냥 빈 메소드로 두었습니다.*/

	public void onDataSelected(AdapterView parent, View v, int position, long id);

}

```

**IconTextItem**

![https://comp166-koreauniv.googlecode.com/files/IconTextItem.png](https://comp166-koreauniv.googlecode.com/files/IconTextItem.png)

이 클래스에서는 리스트의 각 개체가 가지고 있을 데이터등을 정합니다.
이미지를 사용하지는 않기 때문에 Drawable 변수는 필요가 없습니다.
세개의 텍스트가 지정되어있지만 필요에 따라 그 수를 늘릴수 있습니다.

```

package com.example.hi;

import android.graphics.drawable.Drawable;

public class IconTextItem {
 
/*각 타입의 변수를 선언합니다.*/
    private Drawable mIcon;
     
    private String[] mData;

    private boolean mSelectable = true;
/*각 변수들을 전달받는 생성자입니다.*/
    public IconTextItem(Drawable icon, String[] obj) {
        mIcon = icon;
        mData = obj;
    }

    public IconTextItem(String obj01, String obj02, String obj03) {
       
         
        mData = new String[3];
        mData[0] = obj01;
        mData[1] = obj02;
        mData[2] = obj03;
    }

    public boolean isSelectable() {
        return mSelectable;
    }

    public void setSelectable(boolean selectable) {
        mSelectable = selectable;
    }

    public String[] getData() {
        return mData;
    }
 

    public String getData(int index) {
        if (mData == null || index >= mData.length) {
            return null;
        }
         
        return mData[index];
    }
/*데이터를 설정하는 메소드입니다.*/
    public void setData(String[] obj) {
        mData = obj;
    }

    public void setIcon(Drawable icon) {
        mIcon = icon;
    }

    public Drawable getIcon() {
        return mIcon;
    }
 
    public int compareTo(IconTextItem other) {
        if (mData != null) {
            String[] otherData = other.getData();
            if (mData.length == otherData.length) {
                for (int i = 0; i < mData.length; i++) {
                    if (!mData[i].equals(otherData[i])) {
                        return -1;
                    }
                }
            } else {
                return -1;
            }
        } else {
            throw new IllegalArgumentException();
        }
         
        return 0;
    }}

```

**DataListView**

![https://comp166-koreauniv.googlecode.com/files/DataListView.png](https://comp166-koreauniv.googlecode.com/files/DataListView.png)

DataListView클래스는 ListView클래스를 상속받습니다.

```

package com.example.hi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class DataListView extends ListView {

	private IconTextListAdapter adapter;

	private OnDataSelectionListener selectionListener;

	public DataListView(Context context) {
		super(context);

		init();
	}

	public DataListView(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}
/*아이템을 클릭했을 때의 리스너로 하단에서 새로 정의한 클래스의 객체를 설정합니
다.*/
	private void init() {
		setOnItemClickListener(new OnItemClickAdapter());
	}

	public void setAdapter(BaseAdapter adapter) {
		super.setAdapter(adapter);

	}

	public BaseAdapter getAdapter() {
		return (BaseAdapter) super.getAdapter();
	}
/*새로 정의한 리스너 클래스 객체를 설정합니다.*/
	public void setOnDataSelectionListener(OnDataSelectionListener listener) {
		this.selectionListener = listener;
	}

	public OnDataSelectionListener getOnDataSelectionListener() {
		return selectionListener;
	}
/*OnItemClickListenter를 임플리먼트하여 구현합니다. 이를 통하여 기존의 기능과 새로
운 기능을 합하여 훨씬 높은 확장성을 보여줍니다.*/
	class OnItemClickAdapter implements OnItemClickListener {

		public OnItemClickAdapter() {

		}

		public void onItemClick(AdapterView parent, View v, int position,
				long id) {

			if (selectionListener == null) {
				return;
			}

			// 이벤트 전달
			selectionListener.onDataSelected(parent, v, position, id);

		}

	}

}

```
**4.Make 클래스**

![https://comp166-koreauniv.googlecode.com/files/make.png](https://comp166-koreauniv.googlecode.com/files/make.png)

Make 클래스입니다.

Make 클래스는 이름과 같이 캘린더에서의 일정을 만드는 클래스입니다.

따라서 이 클래스에서는 메인 클래스에서의 정보를 받아와서 이 정보를 가지고

새로운 일정을 만들고 그 정보를 Schedule객체에 저장합니다.

```

package com.example.hi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
/*andoid.widget.*라는 것을 import함으로서 얻는 이득으로는 해당 클래스에서 사용되는 
위젯들을 일일히 하나씩 import하지 않아도 됩니다.*/
import android.widget.*;

public class Make extends Activity {
	public static int yy = 10;
	public static int mm = 12;
	public static int dd = 31;
	public static int tt = 24;
	public static int pp = 42;
/*DatePicker,TimePicker,EditText라는 데이터 형은 레이아웃에서 생성할수있는 위젯입니다.
따라서 이를 선언해주어야 해당되는 위젯의 메소드와 기능들을 사용할수 있습니다.*/
	private DatePicker datePicker;
	private TimePicker timePicker;
	private EditText listname;
	private EditText schedule;
	int m;
	int y;
	int pos;
	String d;
	String list;
	String sche;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make);
		Intent intent = getIntent();
		pos = intent.getIntExtra("pos", 0);
		d = intent.getStringExtra("d");
		y = intent.getIntExtra("y", 0);
		m = intent.getIntExtra("m", 0);
		Button finish = (Button) findViewById(R.id.finish);
		datePicker = (DatePicker) findViewById(R.id.datePicker);
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		listname = (EditText) findViewById(R.id.edittext1);
		schedule = (EditText) findViewById(R.id.editText4);

		timePicker.setIs24HourView(true);
		finish.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent(getBaseContext(), MainActivity.class);

/*Toast를 import한 메소드를 사용하지 않고 새로 메소드를 지정해주어 한 이유는 
onCreate메소드에서는 toast를 사용할수 없다는 에러가 뜨기 때문입니다.*/
				Toast();
				m = datePicker.getMonth();
				y = datePicker.getYear();
				d = datePicker.getDayOfMonth() + "";
				list = listname.getText().toString();
				sche = schedule.getText().toString();
				intent.putExtra("pos", pos);
				intent.putExtra("d", d);
				intent.putExtra("y", y);
				intent.putExtra("m", m);
				intent.putExtra("list", list);
				intent.putExtra("sche", sche);
				ScheduleList.Sch[y - 2013][m][pos].Sch(list,
						timePicker.getCurrentHour(), sche);
				startActivity(intent);

			}
		});
	}
/*Toast메소드는 화면에 메시지를 출력해주는 메소드입니다. 
이 토스트 메소드를 통하여 만든 정보를 출력해주는 기능을 합니다.*/
	public void Toast() {
		Toast.makeText(
				this,
				+datePicker.getYear() + "년 " + (datePicker.getMonth() + 1)
						+ "월 " + datePicker.getDayOfMonth() + " 일 "
						+ timePicker.getCurrentHour() + "시 "
						+ timePicker.getCurrentMinute() + "분의 일정을 만들었습니다.",
				Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.make, menu);
		return true;
	}
}

```

**5.전역 객체 클래스 Schedule**

![https://comp166-koreauniv.googlecode.com/files/Schedule.png](https://comp166-koreauniv.googlecode.com/files/Schedule.png)

이 클래스에서는 전역 객체인 ScheduleList를 선언하고 거기서 사용되는 Sch라는 객체의
내용인 Schedule 클래스가 존재한다. 이러한 클래스를 통하여 다른 클래스 모두가 사용 할수있는 개체를 만들수 있다.

```

package com.example.hi;

import java.io.Serializable;

/*static의 객체를 선언한 ScheduleList 메소드
이렇게 선언을 해주면 모든 클래스에서 ScheduleList.Sch[][][]을 통하여 전역 객
체에 접근할수 있다.
클래스 전체를 통틀어서 사용해야할 데이터가있다면 일일히 intent하기 보다는 이런식으
로 하는것이 더욱 효과적이다.*/

class ScheduleList {
	public static int yy = 10;
	public static int mm = 12;
	public static int dd = 5;
	public static int tt = 24;
	public static int pp = 42;
	public static String[] title = new String[24];
	public static String[] Message = new String[24];

	public static Schedule[][][] Sch;

/*Load메소드는 딱 한번 실행되는 메소드로 새로운 Sch라는 객체를 생성한다.*/
	public static void Load() {
		Sch = new Schedule[yy][mm][pp];
		for (int yyy = 0; yyy < yy; yyy++) {
			for (int mmm = 0; mmm < mm; mmm++) {
				for (int ppp = 0; ppp < pp; ppp++) {
					for (int ttt = 0; ttt < tt; ttt++) {
						Sch[yyy][mmm][ppp] = new Schedule();
						Sch[yyy][mmm][ppp].Sch("", ttt, "");
					}
				}
			}
		}
	}
}

public class Schedule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
/*스케쥴은 24시간이 있고 그에대한 타이틀과 내용이 있으므로 이렇게 만듬*/
	public String time;
	private String[] tt = new String[24];
	private String[] me = new String[24];
/*이 객체의 변수를 세팅해주는 세터 메소드의 역할*/
	public void Sch(String title, int time, String message) {
		this.me[time] = message;
		this.tt[time] = title;

	}
/*String의 tt[time]을 return해주는 게터 메소드*/
	public String gettitle(int time) {
		return tt[time];
	}
/*String의 me[time]을 return해주는 게터 메소드*/
	public String getmessage(int time) {
		return me[time];
	}

	public Schedule() {

	}

	

	

}


```



# 레이아웃 소개 #

![https://comp166-koreauniv.googlecode.com/files/%E3%84%B4%E3%84%B4.png](https://comp166-koreauniv.googlecode.com/files/%E3%84%B4%E3%84%B4.png)

레이아웃입니다. 해당 앱에서는 크게 3개의 레이아웃을 사용해서 3개만 존재하면 되지
않냐고 생각할수 있지만 그리드뷰와 리스트뷰에서 각각 객체에 대한 레이아웃을 사용하
므로 2개씩의 레이아웃을 사용하게 됩니다.

**activity\_main.xml**

![https://comp166-koreauniv.googlecode.com/files/mainactivity.png](https://comp166-koreauniv.googlecode.com/files/mainactivity.png)

그림에는 포맷만 존재할뿐 캘린더처럼은 생기지 않았다.
이러한 부분은 메인 클래스의 메소드를 통해서 진짜 클래스처럼 바뀌게 된다.

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    >
/*2011년 몇월이라고 적혀있는 텍스트뷰 저렇게 적혀있다고 해서 진짜로 저렇게 나오는
것이 아니라 메소드를 통하여 텍스트의 내용이 바뀐다.*/
    <TextView
        android:id="@+id/tv_title"
        android:layout_width="143dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:gravity="center"
        android:text="2011년 몇월"
        android:textColor="#000"
        android:textSize="20sp"
        android:textStyle="bold" />
/*대망의 그리드뷰가 생성되는 공간 사진에는 이상하게 나와있지만 클래스를 통해서 객
체가 할당되면 저렇게 나오지 않는다.*/

    <GridView
        android:id="@+id/gv_calendar"
        android:layout_width="320dp"
        android:layout_height="320dp"
        android:layout_marginTop="30dp"
        android:numColumns="7"
        android:stretchMode="columnWidth"/>
         
    <LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:orientation="horizontal"
        android:gravity="center">
/*지난달로 가게하는 버튼*/
        <Button
            android:id="@+id/b_last"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="지난달"  />
/*다음달로 가게하는 버튼*/
        <Button
            android:id="@+id/b_next"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="다음달"  />
         
    </LinearLayout>
</LinearLayout>

```

**day.xml**

그리드뷰에 사용되는 각 아이템에 속성을 부여하는 레이아웃

텍스트뷰를 사용해서 날짜를 나타나게 한다.

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
	android:id="@+id/day_cell_background"
	xmlns:android="http://schemas.android.com/apk/res/android"
	android:layout_width="45dp" 
	android:layout_height="53dp"
	>
	
	<TextView
		android:id="@+id/day_cell"
		android:layout_width="fill_parent"
		android:layout_height="fill_parent"
		android:paddingLeft="3dp"
		android:paddingTop="2dp"
		android:gravity="center"
		android:textSize="18sp"/>
	
</LinearLayout>

```
**listitem.xml**

이 레이아웃은 리스트뷰의 한 아이템을 위해 만들어진 XML 레이아웃입니다.

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >
/*이부분은 책에 있길래 일단 적어본 이미지뷰 부분이지만 사용하지 않으므로 주석처리 하겠습니다.*/
/*   <ImageView
 		android:id="@+id/iconItem"  
  		android:layout_width="wrap_content" 
  		android:layout_height="wrap_content"
  		android:padding="8dp"
  		android:layout_gravity="center_vertical"
  		/>
*/ 	
  	<LinearLayout
		android:layout_width="wrap_content" 
		android:layout_height="wrap_content"  
 		android:orientation="vertical"
 		>
/*이 부분은 첫번째 줄에있는 텍스트뷰를 나타냅니다.*/
	 	<TextView  
	 		android:id="@+id/dataItem01"  
		    android:layout_width="wrap_content" 
		    android:layout_height="wrap_content"
		    android:textStyle="bold"
		    android:textSize="16dp"
		    android:padding="4dp"
		    />
/*RelativeLayout을 통하여 레이아웃을 위와 아래로 구분을 짓습니다.*/
		<RelativeLayout
			android:layout_width="wrap_content" 
			android:layout_height="wrap_content"
			android:padding="4dp"
 			>
/*이 부분은 리스트뷰의 왼쪽 밑에있는 텍스트 뷰를 나타냅니다.*/
 			<TextView  
		 		android:id="@+id/dataItem02"  
			    android:layout_width="wrap_content" 
			    android:layout_height="wrap_content"
			    />
/*이 부분은 리스트뷰의 오른쪽 밑에있는 텍스트 뷰를 나타냅니다.*/
			<TextView  
		 		android:id="@+id/dataItem03"  
			    android:layout_width="wrap_content" 
			    android:layout_height="wrap_content"
			    android:layout_alignParentRight="true"
			    android:textColor="#ccf88107"
				android:textSize="16dp"
				android:textStyle="bold"
				android:paddingRight="4dp"
			    />    
 		</RelativeLayout>   
	</LinearLayout>    
    

</LinearLayout>


```

**activity\_make.xml**

![https://comp166-koreauniv.googlecode.com/files/fff.png](https://comp166-koreauniv.googlecode.com/files/fff.png)

**Make부분**

```

<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Make" >
/*스크롤 뷰를 사용하면 부족한 화면은 스크롤을 통해서 볼수있다. 
스크롤 뷰의 단점으로는 스크롤 뷰 안의 모든 위젯들의 y축 좌표를 임으로 지정해줄수가 
없다.*/
	<ScrollView
	    android:orientation="vertical"
	    android:layout_width="fill_parent"
	    android:layout_height="fill_parent"
	    >
	    
	    <LinearLayout
	        android:orientation="vertical"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content" 
	        >
	        
    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="16dp"
        android:text="내용" />
/*해당 일정에 대한 타이틀을 적어주는 부분*/
    <EditText
        android:id="@+id/edittext1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="41dp"
        android:ems="10"
        android:text="일정 이름" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="100dp"
        android:text="시작" />
/*DatePicker부분은 XML 레이아웃에서는 글자로만 표현되지만 실제 앱 안에서는 실제 달
력처럼 표시된다.*/
    <DatePicker
        android:id="@+id/datePicker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
/*TimePicker는 시간을 맞추는 위젯으로 초기값은 현재 시간으로 주어진다.*/
    <TimePicker
        android:id="@+id/timePicker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />


    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="270dp"
        android:text="설명" />
/*해당 일정에 대한 내용을 적어주는 부분*/
    <EditText
        android:id="@+id/editText4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="308dp"
        android:ems="10"
        android:text="일정 설명" />
/*완료 버튼을 누르면 모든 정보를 ScheduleList에 set한다.*/
    <Button
        android:id="@+id/finish"
        android:layout_width="90dp"
        android:layout_height="wrap_content"
        android:layout_x="48dp"
        android:layout_y="382dp"
        android:text="완료" />


		</LinearLayout>
	</ScrollView>	
</AbsoluteLayout>

```

**activity\_list.xml**

![https://comp166-koreauniv.googlecode.com/files/xxzzz.png](https://comp166-koreauniv.googlecode.com/files/xxzzz.png)

리스트 뷰에 사용되는 XML 레이아웃

Item이라고 적힌 부분에 리스트뷰 객체가 하나씩 부여된다.

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#ff888888"
    >
    <RelativeLayout
	    android:layout_width="fill_parent"
	    android:layout_height="wrap_content"
	    android:background="#ffffffff"
	    >

		<TextView
		    android:id="@+id/monthText"
		    android:layout_width="200dp"
		    android:layout_height="wrap_content"
		    android:layout_centerHorizontal="true"
		    android:gravity="center_horizontal"
		    android:text="몇년 몇월 몇일" />

	</RelativeLayout>
	<RelativeLayout
    	android:id="@+id/scheduleLayout"
	    android:layout_width="fill_parent"
	    android:layout_height="wrap_content"
	    android:padding="4dp"
	    android:background="#aaaaaaaa"
	    >
/*대망의 리스트뷰의 위젯 본 클래스에서는 24개의 리스트뷰 객체를 부여한다.*/
	    <ListView
			android:id="@+id/scheduleList"
			android:layout_width="fill_parent"
			android:layout_height="fill_parent"
			
			android:cacheColorHint="#00000000"
			android:divider="#00000000"
			/>
	</RelativeLayout>
</LinearLayout>

```

**구동 사진**

![https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%20%EC%82%AC%EC%A7%84.png](https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%20%EC%82%AC%EC%A7%84.png)

기본 캘린더 입니다. 실행시 뜨는 화면으로 각 칸을 누르면 정보를 intent하게 됩니다.

![https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%20%EC%82%AC%EC%A7%84%202.png](https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%20%EC%82%AC%EC%A7%84%202.png)

2일을 눌러서 해당 날짜의 리스트뷰를 클릭한것인데요 아직 만든 스케줄이 없어서 아무것도 안뜹니다.

![https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%20%EC%82%AC%EC%A7%84%203.png](https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%20%EC%82%AC%EC%A7%84%203.png)

make를 통해서 새로운 일정을 만드는 사진입니다.

![https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%EC%82%AC%EC%A7%84%204.png](https://comp166-koreauniv.googlecode.com/files/%EA%B5%AC%EB%8F%99%EC%82%AC%EC%A7%84%204.png)

해당 날짜의 2시의 스케줄을 만든후 다시 해당 날짜에 들어가서 확인한 사진입니다.


**소스코드 제출**

https://comp166-koreauniv.googlecode.com/files/Hi.zip

**apk 파일 제출**

https://comp166-koreauniv.googlecode.com/files/Hi.apk