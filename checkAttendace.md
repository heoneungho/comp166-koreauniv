<font size='7'><b>Attendance book</b></font>

매번 명단을 들고 다녀야 해서 불편한 출석체크를 위해!

# Introduction #

출석체크를 핸드폰에 하여 휴대성을 용이하게 함

맨처음 어느 그룹의 출석체크를 할 것인지 선택하는 항목을 넣음 (ex. 선형대수, 컴퓨터프로그래밍 ...)

선택시 다이어리가 뜸. 기본적으로 오늘의 날짜가 설정되어 있으며 변경가능.

다이어리에서 날짜를 선택하면 학생들의 명단이 뜸.

출석/지각/결석 으로 표기.

<br>


<h1>Details</h1>

<h2>Screenshot</h2>

<h3>메인화면</h3>


<img src='http://comp166-koreauniv.googlecode.com/files/sangmimain.jpg' />

앱을 실행하자마자 뜨는 메인화면이다.<br>
과목을 선택해서 들어갈 수 있으며 원하는 과목을 새로 추가할 수도 있다.<br>
추가된 과목은 sdcard0/AttendanceBook/lecture.txt 에 저장된다.<br>


<h3>출결관리</h3>

<img src='http://comp166-koreauniv.googlecode.com/files/sangmiattendance.jpg' />  <img src='http://comp166-koreauniv.googlecode.com/files/sangmidate.jpg' />

과목 선택후 맨 첫번째 탭이 선택된 상태에서 들어온다.<br>
순서대로 [출석 - 결과 - 과제]이다.<br>
<br>
첫번째 버튼을 누르면 날짜를 바꿀 수 있다.<br>
원하는 날짜에 출결을 한 후 Save버튼을 누르면 저장된다.<br>
출결 목록은 Attendance.txt에 저장된다.<br>
<br>

<img src='http://comp166-koreauniv.googlecode.com/files/sangmistdadd.jpg' />
<br>
오른쪽 상단에 보면 학생추가버튼이 있다.<br>
이 버튼을 누르면 학생추가 화면이 뜨며 과목추가와 동일한 방법으로 학생을 추가할 수 있다.<br>


<h3>과제</h3>

<img src='http://comp166-koreauniv.googlecode.com/files/sangmiassignment.jpg' />


과제란에 과제를 입력시 과제가 추가된다.<br>
추가된 과제는 sdcard0/Attendancebook/assignment.txt 에 추가되며 과목별로 분류된다.<br>



<h2>class</h2>

<img src='http://comp166-koreauniv.googlecode.com/files/상미클래스.png' />

<h3>LectureList.java</h3>

<pre><code><br>
package com.example.attendancebook;<br>
<br>
import java.io.BufferedReader;<br>
import java.io.BufferedWriter;<br>
import java.io.File;<br>
import java.io.FileReader;<br>
import java.io.FileWriter;<br>
import java.io.IOException;<br>
import java.util.ArrayList;<br>
import java.util.Hashtable;<br>
import java.util.Map.Entry;<br>
<br>
import android.os.Environment;<br>
<br>
public class LectureList {<br>
	public static LectureStatus curLectureStatus = null;<br>
	// public static DailyAttendance curDailyAttendance = null;<br>
<br>
	public static Hashtable&lt;String, LectureStatus&gt; list = new Hashtable&lt;String, LectureStatus&gt;();<br>
<br>
	public static String dataDir; //디렉토리의 경로를 써준다<br>
<br>
	public static void InitDirectory() {<br>
		File path = Environment.getExternalStorageDirectory(); //<br>
		dataDir = path.getAbsolutePath() + "/AttendanceBook/"; <br>
		File file = new File(dataDir);<br>
		if (!file.exists()) // 원하는 경로에 폴더가 있는지 확인<br>
			file.mkdirs(); //없으면 새로 생성<br>
	}<br>
<br>
	public static void LoadLecture() throws IOException {<br>
		list.clear();<br>
<br>
		BufferedReader br = new BufferedReader(new FileReader(dataDir<br>
				+ "lecture.txt"));// 지정해준 디렉토리에 lecture.txt 파일을 만든다<br>
<br>
		String readLine = "";<br>
		while ((readLine = br.readLine()) != null) {<br>
			String[] items = readLine.split("\t"); //\t을 경계로 아이템들을 읽어낸다<br>
<br>
			curLectureStatus = new LectureStatus();<br>
			curLectureStatus.title = items[0];<br>
			list.put(items[0], curLectureStatus);<br>
		}<br>
<br>
		br.close();<br>
<br>
	}<br>
<br>
	public static void LoadStudent() throws Exception {<br>
<br>
		BufferedReader br = new BufferedReader(new FileReader(dataDir<br>
				+ "student.txt")); // 해당 경로에 있는 디렉토리에 student.txt를 만듦<br>
<br>
		String lec = "";<br>
		String std = "";<br>
<br>
		String readLine = "";<br>
<br>
		while ((readLine = br.readLine()) != null) {<br>
			String[] items = readLine.split("\t");<br>
<br>
			lec = items[0];<br>
			std = items[1];<br>
<br>
			if (list.containsKey(lec)) {<br>
				curLectureStatus = list.get(lec); //과목 받고 \t 뛴 후<br>
			} else {<br>
				continue;<br>
			}<br>
			curLectureStatus.studentList.add(std); //학생이름 받는다<br>
		}<br>
<br>
		br.close();<br>
<br>
	}<br>
<br>
	public static void LoadAttendance() throws Exception {<br>
		// 파일로 부터 읽기<br>
<br>
		BufferedReader br = new BufferedReader(new FileReader(dataDir<br>
				+ "attendance.txt")); // 해당 경로에 attendance.txt 만듦. 학생들의 출결을 관리<br>
<br>
		DailyAttendance curDailyAttendance = null;<br>
<br>
		String lec = "";<br>
		String date = "";<br>
		String std = "";<br>
		String status = "";<br>
<br>
		String readLine = "";<br>
		while ((readLine = br.readLine()) != null) {<br>
			String[] items = readLine.split("\t");<br>
			if (items.length &lt; 3)<br>
				continue;<br>
<br>
			lec = items[0];<br>
			date = items[1];<br>
			std = items[2];<br>
			status = items[3];<br>
<br>
			if (list.containsKey(lec)) {<br>
				curLectureStatus = list.get(lec);<br>
			} else {<br>
				continue;<br>
			}<br>
<br>
			if (curLectureStatus.dailyAttendanceList.containsKey(date)) {<br>
				//현재 과목에서 해당 date의 출석부가 있으면 그 출석부를 가져온다.<br>
				curDailyAttendance = curLectureStatus.dailyAttendanceList<br>
						.get(date);<br>
			} else {<br>
				// 없다면 새로 생성한다.<br>
				curDailyAttendance = new DailyAttendance();<br>
				curLectureStatus.dailyAttendanceList.put(date,<br>
						curDailyAttendance);<br>
			}<br>
<br>
			curDailyAttendance.studentList.add(new DailyAttendanceStudent(std,<br>
					status));//학생 리스트에 학생이름과 상태를 추가한다<br>
		}<br>
	}<br>
<br>
	public static void LoadAssignment() throws IOException {<br>
<br>
		BufferedReader br = new BufferedReader(new FileReader(dataDir<br>
				+ "assignment.txt")); // 해당 경로에 assignment.txt 를 생성<br>
		String lec = "";<br>
		String ass = "";<br>
<br>
		String readLine = "";<br>
		while ((readLine = br.readLine()) != null) {<br>
			String[] items = readLine.split("\t");<br>
<br>
			lec = items[0];<br>
			ass = items[1];<br>
<br>
			if (list.containsKey(lec)) {<br>
				curLectureStatus = list.get(lec); <br>
			} else {<br>
				continue;<br>
			}<br>
<br>
			curLectureStatus.dailyAssignmentList.put(ass, new DailyAssignment(<br>
					ass));<br>
		}<br>
	}<br>
<br>
	public static void SaveStudent() throws IOException {<br>
		<br>
		BufferedWriter writer = new BufferedWriter(new FileWriter(dataDir<br>
				+ "student.txt")); // studenet.txt에 쓸 것<br>
<br>
		for (Entry&lt;String, LectureStatus&gt; entry : LectureList.list.entrySet()) {<br>
// <br>
			String lec = entry.getKey();<br>
			for (String std : entry.getValue().studentList) {<br>
				// 인자를 받아서 "과목명 	학생이름\n" 이런식으로 입력함<br>
				// for문을 돌면서 모든 학생들의 list를 받아옴<br>
				writer.write(lec+"\t"+std+ "\n"); <br>
			}<br>
		}<br>
		writer.close();<br>
<br>
	}<br>
<br>
	public static void SaveLecture() throws IOException {<br>
<br>
		BufferedWriter writer = new BufferedWriter(new FileWriter(dataDir<br>
				+ "lecture.txt"));<br>
		//lecture.txt에 씀<br>
<br>
		for (Entry&lt;String, LectureStatus&gt; entry : LectureList.list.entrySet()) {<br>
			writer.write(entry.getKey() + "\n");<br>
			//list의 항목들을 \n으로 끊으면서 받는다<br>
		}<br>
		writer.close();<br>
	}<br>
<br>
	public static void SaveAttendance() {<br>
/*		BufferedWriter writer = new BufferedWriter(new FileWriter(dataDir<br>
				+ "attendance.txt"));<br>
<br>
<br>
			for (Entry&lt;String, LectureStatus&gt; entry : LectureList.list.entrySet()) {<br>
				<br>
			String lec = entry.getKey();<br>
			for (String std : entry.getValue().studentList) {<br>
				writer.write(lec+"\t"+Student.curDate+"\t"+std++ "\n");<br>
			}<br>
		}<br>
			writer.close();	<br>
*/<br>
<br>
	}<br>
<br>
	public static void SaveAssignment(BufferedReader bufferReader) {<br>
/*<br>
		BufferedWriter writer = new BufferedWriter(new FileWriter(dataDir<br>
				+ "assignment.txt")); // 해당 경로에 assignment.txt 를 생성<br>
<br>
		for (Entry&lt;String, LectureStatus&gt; entry : LectureList.list.entrySet()) {<br>
			<br>
		String lec = entry.getKey();<br>
		for(Entry&lt;String, DailyAssignment &gt; : LectureList.curLectureStatus.dailyAssignmentList.entrySet()){<br>
			writer.write(lec+"\t"+entry.getKey() + "\n");<br>
			//list의 항목들을 \n으로 끊으면서 받는다<br>
			<br>
		}<br>
		}		<br>
	<br>
	writer.close();<br>
*/<br>
}<br>
<br>
}<br>
<br>
class LectureStatus {<br>
	public String title;<br>
	public ArrayList&lt;String&gt; studentList = new ArrayList&lt;String&gt;();<br>
	public Hashtable&lt;String, DailyAttendance&gt; dailyAttendanceList = new Hashtable&lt;String, DailyAttendance&gt;();<br>
	public Hashtable&lt;String, DailyAssignment&gt; dailyAssignmentList = new Hashtable&lt;String, DailyAssignment&gt;();<br>
	<br>
	//Load나 Save등을 할 때 기존의 리스트에서 Hashtable로 과목별로 분류할 때 쓰인다.<br>
}<br>
<br>
class DailyAttendance {<br>
	public ArrayList&lt;DailyAttendanceStudent&gt; studentList = new ArrayList&lt;DailyAttendanceStudent&gt;();<br>
}<br>
<br>
class DailyAttendanceStudent {<br>
	public String name;<br>
	public String status;<br>
<br>
	public DailyAttendanceStudent() {<br>
	}<br>
<br>
	public DailyAttendanceStudent(String n, String s) {<br>
		this.name = n;<br>
		this.status = s;<br>
	}<br>
}<br>
<br>
class DailyAssignment {<br>
	public String assignmentTitle;<br>
<br>
	// public ArrayList&lt;DailyAssignmentStudent&gt; studentList = new<br>
	// ArrayList&lt;DailyAssignmentStudent&gt;();<br>
<br>
	public DailyAssignment() {<br>
	}<br>
<br>
	public DailyAssignment(String n) {<br>
		this.assignmentTitle = n;<br>
	}<br>
}<br>
/*<br>
class DailyAssignmentStudent {<br>
	public String name;<br>
	public String status;<br>
}<br>
*/<br>
<br>
<br>
</code></pre>

<h3>MainActiviy.java</h3>

<pre><code><br>
package com.example.attendancebook;<br>
<br>
import java.io.BufferedReader;<br>
import java.io.InputStream;<br>
import java.util.ArrayList;<br>
import java.util.Map.Entry;<br>
<br>
import android.app.Activity;<br>
import android.content.Intent;<br>
import android.os.Bundle;<br>
import android.view.View;<br>
import android.widget.AdapterView;<br>
import android.widget.AdapterView.OnItemClickListener;<br>
import android.widget.ArrayAdapter;<br>
import android.widget.Button;<br>
import android.widget.EditText;<br>
import android.widget.ListView;<br>
<br>
public class MainActivity extends Activity {<br>
<br>
	ArrayList&lt;String&gt; list;<br>
	ArrayAdapter&lt;String&gt; adapter;<br>
<br>
	@Override<br>
	protected void onCreate(Bundle savedInstanceState) {<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.activity_main);<br>
<br>
		InputStream isStation;<br>
		BufferedReader reader;<br>
<br>
		try {<br>
// 프로그램을 실행하자마자 다음 함수들이 실행됨.<br>
// Lecture, Student, Attendance, Assignment 정보들을 Load함<br>
			<br>
			LectureList.InitDirectory();<br>
<br>
			LectureList.LoadLecture();<br>
			LectureList.LoadStudent();<br>
			LectureList.LoadAttendance();<br>
			LectureList.LoadAssignment();<br>
<br>
		} catch (Exception e) {<br>
			// TODO Auto-generated catch block<br>
			e.printStackTrace();<br>
		}<br>
<br>
		list = new ArrayList&lt;String&gt;();<br>
		for (Entry&lt;String, LectureStatus&gt; entry : LectureList.list.entrySet()) {<br>
			list.add(entry.getKey());<br>
		}//Lecture 목록들을 불러옴<br>
<br>
		adapter = new ArrayAdapter&lt;String&gt;(this,<br>
				android.R.layout.simple_list_item_1, list);//어댑터 생성<br>
<br>
		ListView listView = (ListView) findViewById(R.id.listView1);<br>
		listView.setAdapter(adapter);//리스트에 어댑터를 지정해준다<br>
<br>
		listView.setOnItemClickListener(new OnItemClickListener() {<br>
			//리스트에 있는 항목을 클릭하면 해당 lecture로 이동한다<br>
			@Override<br>
			public void onItemClick(AdapterView&lt;?&gt; parent, View view,<br>
					final int pos, long id) {//위치를 받고<br>
				String lec = list.get(pos);//그 위치의 리스트에 있는 lecture<br>
				LectureList.curLectureStatus = LectureList.list.get(lec); <br>
				//앞으로 curLectureStatus 즉 현재 과목상태를 리스트에서 선택한 것으로 지정해준다!<br>
<br>
				Intent intent = new Intent(getBaseContext(), Wth.class);//화면이동<br>
				intent.putExtra("pos", pos);<br>
				startActivity(intent);<br>
			}<br>
		});<br>
<br>
		//<br>
		Button button = (Button) findViewById(R.id.btn1);<br>
<br>
		button.setOnClickListener(new View.OnClickListener() {<br>
			public void onClick(View v) {<br>
				EditText et = (EditText) findViewById(R.id.et);<br>
				String lecName;<br>
				if (v.getId() == R.id.btn1) {<br>
					// 추가 버튼<br>
					if (et.getText().length() != 0) {<br>
						lecName = et.getText().toString();<br>
						list.add(lecName);//입력한 문자열, 즉 과목을 리스트에 추가한다<br>
<br>
						et.setText("");<br>
						adapter.notifyDataSetChanged();<br>
						try {//추가한 것을 txt파일에 저장함. 앞으로 껐다키면 수정한 사항이 반영됨<br>
							LectureList.list.put(lecName,new LectureStatus()); <br>
							LectureList.SaveLecture();<br>
						} catch (Exception e) {<br>
<br>
							e.printStackTrace();<br>
<br>
						}<br>
					}<br>
				}<br>
			}<br>
		});<br>
<br>
	}<br>
}<br>
</code></pre>

<h3>Wth.java</h3>

<pre><code><br>
package com.example.attendancebook;<br>
<br>
import java.util.Locale;<br>
<br>
import android.app.ActionBar;<br>
import android.app.FragmentTransaction;<br>
import android.content.Context;<br>
import android.content.Intent;<br>
import android.os.Bundle;<br>
import android.support.v4.app.Fragment;<br>
import android.support.v4.app.FragmentActivity;<br>
import android.support.v4.app.FragmentManager;<br>
import android.support.v4.app.FragmentPagerAdapter;<br>
import android.support.v4.view.ViewPager;<br>
import android.view.Menu;<br>
import android.view.MenuItem;<br>
<br>
public class Wth extends FragmentActivity implements ActionBar.TabListener {<br>
<br>
	/**<br>
	 * The {@link android.support.v4.view.PagerAdapter} that will provide<br>
	 * fragments for each of the sections. We use a<br>
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which<br>
	 * will keep every loaded fragment in memory. If this becomes too memory<br>
	 * intensive, it may be best to switch to a<br>
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.<br>
	 */<br>
	SectionsPagerAdapter mSectionsPagerAdapter;<br>
<br>
	/**<br>
	 * The {@link ViewPager} that will host the section contents.<br>
	 */<br>
	ViewPager mViewPager; <br>
<br>
	@Override<br>
	protected void onCreate(Bundle savedInstanceState) {<br>
		super.onCreate(savedInstanceState);<br>
		setContentView(R.layout.activity_wth);<br>
<br>
		// Set up the action bar.<br>
		final ActionBar actionBar = getActionBar();<br>
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); //Tab을 사용한다!<br>
<br>
		getActionBar().setHomeButtonEnabled(true);<br>
		getActionBar().setDisplayHomeAsUpEnabled(true);<br>
		getActionBar().setTitle("Check Attendance");<br>
<br>
		// Create the adapter that will return a fragment for each of the three<br>
		// primary sections of the app.<br>
		mSectionsPagerAdapter = new SectionsPagerAdapter(getApplicationContext(), <br>
				getSupportFragmentManager());<br>
<br>
		// Set up the ViewPager with the sections adapter.<br>
		mViewPager = (ViewPager) findViewById(R.id.pager);<br>
		mViewPager.setAdapter(mSectionsPagerAdapter);<br>
<br>
		// When swiping between different sections, select the corresponding<br>
		// tab. We can also use ActionBar.Tab#select() to do this if we have<br>
		// a reference to the Tab.<br>
		mViewPager<br>
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {<br>
					@Override<br>
					public void onPageSelected(int position) {<br>
						actionBar.setSelectedNavigationItem(position);<br>
					}<br>
				});<br>
<br>
		// For each of the sections in the app, add a tab to the action bar.<br>
		for (int i = 0; i &lt; mSectionsPagerAdapter.getCount(); i++) {<br>
			// Create a tab with text corresponding to the page title defined by<br>
			// the adapter. Also specify this Activity object, which implements<br>
			// the TabListener interface, as the callback (listener) for when<br>
			// this tab is selected.<br>
			actionBar.addTab(actionBar.newTab()<br>
					.setText(mSectionsPagerAdapter.getPageTitle(i))<br>
					.setTabListener(this));<br>
		}<br>
<br>
	}<br>
<br>
<br>
	<br>
	<br>
	@Override<br>
	public boolean onOptionsItemSelected(MenuItem item) {<br>
		//actionbar 부분<br>
		<br>
		Intent intent;<br>
		switch (item.getItemId()) {<br>
		case android.R.id.home:<br>
			finish();<br>
			break;<br>
		case R.id.Home: //Home버튼을 누르면 MainActivity로 이동한다<br>
			intent = new Intent(getBaseContext(), MainActivity.class);		<br>
			startActivity(intent);	<br>
			break;<br>
		case R.id.Add_stu: //Add_stu버튼을 누르면 학생추가화면(AddStudent)으로 이동한다<br>
			intent = new Intent(getBaseContext(), AddStudent.class);		<br>
			startActivity(intent);	<br>
			break;<br>
<br>
		}<br>
		return super.onOptionsItemSelected(item);<br>
	}<br>
<br>
<br>
	@Override<br>
	public boolean onCreateOptionsMenu(Menu menu) {<br>
		// Inflate the menu; this adds items to the action bar if it is present.<br>
		getMenuInflater().inflate(R.menu.wth, menu);//버튼들은 res/menu/wth에 있다<br>
		return true;<br>
	}<br>
<br>
	@Override<br>
	public void onTabSelected(ActionBar.Tab tab,<br>
			FragmentTransaction fragmentTransaction) {<br>
		// When the given tab is selected, switch to the corresponding page in<br>
		// the ViewPager.<br>
		mViewPager.setCurrentItem(tab.getPosition());<br>
	}<br>
<br>
	@Override<br>
	public void onTabUnselected(ActionBar.Tab tab,<br>
			FragmentTransaction fragmentTransaction) {<br>
	}<br>
<br>
	@Override<br>
	public void onTabReselected(ActionBar.Tab tab,<br>
			FragmentTransaction fragmentTransaction) {<br>
	}<br>
<br>
	/**<br>
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to<br>
	 * one of the sections/tabs/pages.<br>
	 */<br>
	public class SectionsPagerAdapter extends FragmentPagerAdapter {<br>
		Context mContext; //Tab형식이라 기존의 액티비티와는 좀 다름<br>
<br>
		public SectionsPagerAdapter(Context context, FragmentManager fm) {<br>
			super(fm);<br>
			mContext = context;<br>
		}<br>
<br>
		@Override<br>
		public Fragment getItem(int position) {<br>
			switch (position) {<br>
			case 0:<br>
				return new Student(mContext); //첫번째 탭은 Student 액티비티를 보여줌<br>
			case 1:<br>
				return new Student(mContext); //두번쨰 탭은 Result 액티비티를 보여줌. 현재 약간 오류가있어 임시적으로 Student에 연결함<br>
			case 2:<br>
				return new Assignment(mContext);//마지막 탭은 Assignment 액티비티를 보여줌<br>
			}<br>
			return null;<br>
		}<br>
		<br>
		@Override<br>
		public int getCount() {<br>
			// Show 3 total pages.<br>
			return 3;<br>
		}<br>
<br>
		@Override<br>
		public CharSequence getPageTitle(int position) {<br>
			//Tab의 이름 지정<br>
			Locale l = Locale.getDefault();<br>
			switch (position) {<br>
			case 0:<br>
				return "Attendance";<br>
			case 1:<br>
				return "Result";<br>
			case 2:<br>
				return "Assignment";<br>
			}<br>
			return null;<br>
		}<br>
<br>
	}<br>
<br>
<br>
}<br>
<br>
</code></pre>

<h3>Student.java (출결관리)</h3>

<pre><code><br>
package com.example.attendancebook;<br>
<br>
import java.util.ArrayList;<br>
import java.util.Calendar;<br>
<br>
import android.annotation.SuppressLint;<br>
import android.app.DatePickerDialog;<br>
import android.content.Context;<br>
import android.os.Bundle;<br>
import android.support.v4.app.Fragment;<br>
import android.view.LayoutInflater;<br>
import android.view.View;<br>
import android.view.ViewGroup;<br>
import android.view.inputmethod.InputMethodManager;<br>
import android.widget.ArrayAdapter;<br>
import android.widget.Button;<br>
import android.widget.DatePicker;<br>
import android.widget.ListView;<br>
import android.widget.TextView;<br>
<br>
@SuppressLint("ValidFragment")<br>
public class Student extends Fragment {<br>
<br>
	private TextView mDateDisplay;<br>
	private Button mPickDate;<br>
	public String curDate;<br>
	private int mYear;<br>
	private int mMonth;<br>
	private int mDay;<br>
	static final int DATE_DIALOG_ID = 0;<br>
<br>
	ArrayList&lt;String&gt; list;<br>
	ArrayAdapter&lt;String&gt; adapter;<br>
	ListView lv;<br>
	InputMethodManager imm;<br>
<br>
	Context mContext;<br>
	View mView;<br>
<br>
	public Student(Context context) {<br>
		mContext = context;<br>
<br>
	}<br>
<br>
	public Student() {<br>
	}<br>
<br>
	@Override<br>
	public View onCreateView(LayoutInflater inflater, ViewGroup container,<br>
			Bundle savedInstanceState) {<br>
		//DatePicker 함수이다.<br>
<br>
		mView = inflater.inflate(R.layout.activity_student, null);<br>
<br>
		mDateDisplay = (TextView) mView.findViewById(R.id.dateDisplay);<br>
		mPickDate = (Button) mView.findViewById(R.id.pickDate);<br>
		mPickDate.setOnClickListener(new View.OnClickListener() {<br>
<br>
			@Override<br>
			public void onClick(View v) {<br>
				// TODO Auto-generated method stub<br>
				new DatePickerDialog(getActivity(), mDateSetListener, mYear,<br>
						mMonth, mDay).show();<br>
			}<br>
		});<br>
<br>
		final Calendar c = Calendar.getInstance();<br>
<br>
		mYear = c.get(Calendar.YEAR);<br>
		mMonth = c.get(Calendar.MONTH);<br>
		mDay = c.get(Calendar.DAY_OF_MONTH);<br>
		curDate = String.format("%04d-%02d-%02d", mYear, mMonth, mDay);//연,월,일을 슬래시(-)를 붙여서 curDate에 저장<br>
<br>
		updateDisplay(); // 보여줌<br>
<br>
		MakeStudent(curDate);//현재의 날짜를 넣어 기존에 명단에 있으면 불러오고 없으면 새로 쓴다<br>
<br>
<br>
		Button button = (Button)mView.findViewById(R.id.button1);<br>
		button.setOnClickListener(new View.OnClickListener() {<br>
			public void onClick(View v) {<br>
				PutStudent(curDate);<br>
			}<br>
		});<br>
<br>
		// arrayadapter에 설정하기<br>
<br>
		MyAdapter adapter = new MyAdapter(mContext, studentList);<br>
		//MyAdapter는 기존의 어댑터가 아니다. 나는 이름 + 라디오버튼 세개(지각,출석,결석)이 필요했다. 라디오버튼은 원칙적으로 한개만 붙일 수 있기 때문에 새로운 어댑터(MyAdapter.class와 row.xml)를 만들어 항목을 추가할 때 마다 지정된 양식으로 추가되도록 하였다.<br>
<br>
		lv = (ListView) mView.findViewById(R.id.lv);<br>
		lv.setAdapter(adapter);//리스트에 어댑터를 지정해준다<br>
<br>
		return mView;//Tab이라 mView로 바꿔줌<br>
<br>
	}<br>
<br>
	private void updateDisplay() {<br>
		mDateDisplay.setText(new StringBuilder().append(mMonth + 1).append("-")<br>
				.append(mDay).append("-").append(mYear).append(" "));<br>
	}<br>
<br>
	private ArrayList&lt;DailyAttendanceStudent&gt; studentList;<br>
<br>
	private void MakeStudent(String date) {<br>
		if (LectureList.curLectureStatus.dailyAttendanceList.containsKey(date)) {<br>
			studentList = LectureList.curLectureStatus.dailyAttendanceList<br>
					.get(date).studentList;<br>
		} else {<br>
			studentList = new ArrayList&lt;DailyAttendanceStudent&gt;();<br>
<br>
			for (String stdName : LectureList.curLectureStatus.studentList) {<br>
				//현재 강의를 수강하는 학생들의 출석부를 만들어준다.<br>
				DailyAttendanceStudent std = new DailyAttendanceStudent();<br>
<br>
				std.name = stdName;<br>
				std.status = "출석"; //처음에는 "출석"으로 디폴트되어있다.<br>
<br>
				studentList.add(std);//추가<br>
			}<br>
		}<br>
	}<br>
<br>
	private void PutStudent(String date) {<br>
		//dailyAttendanceList에 해당 날짜와 출결 상태를 넣어준다.(임시)<br>
		//후에 이것들은 파일로 저장할 것<br>
		DailyAttendance da = new DailyAttendance();<br>
		da.studentList = studentList;<br>
		LectureList.curLectureStatus.dailyAttendanceList.put(date, da);<br>
<br>
		//DailyAttendanceStudent(이름, 상태)<br>
		//LectureList.SaveAttendance();<br>
		<br>
	}<br>
<br>
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {<br>
<br>
		@Override<br>
		public void onDateSet(DatePicker view, int year, int monthOfYear,<br>
				int dayOfMonth) {<br>
			// TODO Auto-generated method stub<br>
			mYear = year;<br>
			mMonth = monthOfYear;<br>
			mDay = dayOfMonth;<br>
<br>
			curDate = String.format("%04d-%02d-%02d", mYear, mMonth, mDay);<br>
			//년,월,일을 슬래쉬로 끊어서 curDate에 저장<br>
<br>
			updateDisplay();<br>
			<br>
<br>
		}<br>
	};<br>
		<br>
<br>
	/*<br>
	 * private void writeToFile(String data) { try { OutputStreamWriter<br>
	 * outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME,<br>
	 * Context.MODE_PRIVATE)); outputStreamWriter.write(data);<br>
	 * outputStreamWriter.close(); } catch (IOException e) { Log.e(TAG,<br>
	 * "File write failed: " + e.toString()); }<br>
	 * <br>
	 * }<br>
	 */<br>
}<br>
<br>
<br>
</code></pre>

<h3>MyAdapter.java</h3>

<pre><code><br>
package com.example.attendancebook;<br>
<br>
import java.util.ArrayList;<br>
<br>
import android.content.Context;<br>
import android.view.LayoutInflater;<br>
import android.view.View;<br>
import android.view.ViewGroup;<br>
import android.widget.ArrayAdapter;<br>
import android.widget.RadioButton;<br>
import android.widget.TextView;<br>
<br>
public class MyAdapter extends ArrayAdapter&lt;DailyAttendanceStudent&gt; {<br>
<br>
	private final Context context;<br>
	private final ArrayList&lt;DailyAttendanceStudent&gt; itemsArrayList;<br>
<br>
	public MyAdapter(Context context,<br>
			ArrayList&lt;DailyAttendanceStudent&gt; itemsArrayList) {<br>
<br>
		super(context, R.layout.row, itemsArrayList); //layout으로는 row.xml<br>
<br>
		this.context = context;<br>
		this.itemsArrayList = itemsArrayList;<br>
	}<br>
<br>
	@Override<br>
	public View getView(int position, View convertView, ViewGroup parent) {<br>
<br>
		DailyAttendanceStudent item = itemsArrayList.get(position);<br>
		// 1. Create inflater<br>
		LayoutInflater inflater = (LayoutInflater) context<br>
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);<br>
<br>
		// 2. Get rowView from inflater<br>
		View rowView = inflater.inflate(R.layout.row, parent, false);//row.xml을 보여준다<br>
<br>
		// 3. Get the two text view from the rowView<br>
		TextView textView = (TextView) rowView.findViewById(R.id.textView1);<br>
<br>
		// 4. Set the text for textView<br>
		textView.setText(item.name);//학생이름<br>
		<br>
		//라디오 버튼 세 개<br>
		//각각의 버튼은 해당 문자열과 연결됨<br>
		//첫번째 버튼은 "지각", 두번째는 "출석", 세번째는 "결석"<br>
		if (item.status.compareTo("지각") == 0) {<br>
			RadioButton radioButton = (RadioButton) rowView<br>
					.findViewById(R.id.radio0);<br>
			radioButton.setChecked(true);<br>
		}<br>
		if (item.status.compareTo("출석") == 0) {<br>
			RadioButton radioButton = (RadioButton) rowView<br>
					.findViewById(R.id.radio1);<br>
			radioButton.setChecked(true);<br>
		}<br>
		if (item.status.compareTo("결석") == 0) {<br>
			RadioButton radioButton = (RadioButton) rowView<br>
					.findViewById(R.id.radio2);<br>
			radioButton.setChecked(true);<br>
		}<br>
<br>
		// 5. return rowView<br>
		return rowView;<br>
	}<br>
}<br>
<br>
</code></pre>

<h3>Result.java</h3>

<pre><code><br>
package com.example.attendancebook;<br>
<br>
import java.util.ArrayList;<br>
import java.util.Hashtable;<br>
import java.util.Map.Entry;<br>
<br>
import android.annotation.SuppressLint;<br>
import android.content.Context;<br>
import android.os.Bundle;<br>
import android.support.v4.app.Fragment;<br>
import android.view.LayoutInflater;<br>
import android.view.View;<br>
import android.view.ViewGroup;<br>
import android.view.inputmethod.InputMethodManager;<br>
import android.widget.ArrayAdapter;<br>
import android.widget.ListView;<br>
<br>
@SuppressLint("ValidFragment")<br>
public class Result extends Fragment {<br>
<br>
	ArrayList&lt;String&gt; list;<br>
	ArrayAdapter&lt;String&gt; adapter;<br>
	ListView lv;<br>
	InputMethodManager imm;<br>
<br>
	Context mContext;<br>
	View mView;<br>
<br>
	public Result(Context context) {<br>
		mContext = context;<br>
	}<br>
<br>
	@Override<br>
	public View onCreateView(LayoutInflater inflater, ViewGroup container,<br>
			Bundle savedInstanceState) {<br>
		mView = inflater.inflate(R.layout.activity_result, null);<br>
<br>
		Hashtable&lt;String, Integer&gt; lateList = new Hashtable&lt;String, Integer&gt;();<br>
		Hashtable&lt;String, Integer&gt; normalList = new Hashtable&lt;String, Integer&gt;();<br>
		Hashtable&lt;String, Integer&gt; absentList = new Hashtable&lt;String, Integer&gt;();<br>
<br>
		for (Entry&lt;String, DailyAttendance&gt; entry : LectureList.curLectureStatus.dailyAttendanceList<br>
				.entrySet()) {<br>
<br>
			String date = entry.getKey();<br>
			DailyAttendance attendance = entry.getValue();<br>
<br>
			for (DailyAttendanceStudent std : attendance.studentList) {<br>
				if (std.status.compareTo("지각") == 0) {<br>
					if (lateList.containsKey(std.name)) {<br>
						lateList.put(std.name, lateList.get(std.name) + 1);//기존에 데이터가 있으면 +1<br>
					} else {<br>
						lateList.put(std.name, 1);//기존에 데이터가 없으면 1<br>
					}<br>
				} else if (std.status.compareTo("출석") == 0) {<br>
					if (normalList.containsKey(std.name)) {<br>
						normalList.put(std.name, normalList.get(std.name) + 1);<br>
					} else {<br>
						normalList.put(std.name, 1);<br>
					}<br>
				} else if (std.status.compareTo("결석") == 0) {<br>
					if (absentList.containsKey(std.name)) {<br>
						absentList.put(std.name, absentList.get(std.name) + 1);<br>
					} else {<br>
						absentList.put(std.name, 1);<br>
					}<br>
				}<br>
			}<br>
		}<br>
<br>
		adapter = new ArrayAdapter&lt;String&gt;(this.getActivity(),<br>
				android.R.layout.simple_list_item_1, list);<br>
<br>
		ListView listView = (ListView) mView.findViewById(R.id.lv);<br>
		listView.setAdapter(adapter);<br>
		<br>
		for (String std : LectureList.curLectureStatus.studentList) {<br>
<br>
			list.add(std +"\t"+ lateList.get(std) +"\t"+ normalList.get(std) +"\t" + absentList.get(std));<br>
<br>
			//학생이름	지각횟수	출석횟수	결석횟수 를 하나의 배열로 받아 보여준다<br>
		}<br>
<br>
<br>
		return mView;<br>
<br>
	}<br>
}<br>
<br>
</code></pre>

<h3>Assignemnt.java</h3>

<pre><code><br>
package com.example.attendancebook;<br>
<br>
import java.util.ArrayList;<br>
<br>
import android.annotation.SuppressLint;<br>
import android.content.Context;<br>
import android.os.Bundle;<br>
import android.support.v4.app.Fragment;<br>
import android.view.LayoutInflater;<br>
import android.view.View;<br>
import android.view.ViewGroup;<br>
import android.view.inputmethod.InputMethodManager;<br>
import android.widget.ArrayAdapter;<br>
import android.widget.Button;<br>
import android.widget.EditText;<br>
import android.widget.ListView;<br>
<br>
<br>
<br>
@SuppressLint("ValidFragment")//Tab이라 붙음<br>
public class Assignment extends Fragment {<br>
	ArrayList&lt;String&gt; list;<br>
	ArrayAdapter&lt;String&gt; adapter;<br>
	ListView lv;<br>
	InputMethodManager imm;<br>
<br>
	Context mContext;<br>
	View mView;<br>
<br>
	public Assignment(Context context) {<br>
		mContext = context;<br>
	}<br>
<br>
	@Override<br>
	public View onCreateView(LayoutInflater inflater, ViewGroup container,<br>
			Bundle savedInstanceState) {<br>
		mView = inflater.inflate(R.layout.activity_assignment, null);<br>
<br>
<br>
		list = new ArrayList &lt;String&gt;();<br>
/*		<br>
		for (Entry&lt;String, LectureStatus&gt; entry : LectureList.list.entrySet()) {<br>
			<br>
			list.add(entry.getKey());<br>
		}<br>
*/<br>
		adapter = new ArrayAdapter&lt;String&gt;(this.getActivity(),<br>
				android.R.layout.simple_list_item_1, list);<br>
<br>
		ListView listView = (ListView) mView.findViewById(R.id.lv);<br>
		listView.setAdapter(adapter);<br>
<br>
<br>
		<br>
		Button button = (Button) mView.findViewById(R.id.btn1);<br>
<br>
		button.setOnClickListener(new View.OnClickListener() {<br>
			public void onClick(View v) {<br>
				EditText et = (EditText) mView.findViewById(R.id.et);<br>
				if (v.getId() == R.id.btn1) {<br>
					// 추가 버튼<br>
					if (et.getText().length() != 0) {<br>
						list.add(et.getText().toString());//리스트에 텍스트를 추가한다<br>
						et.setText("");<br>
<br>
						adapter.notifyDataSetChanged();<br>
					}<br>
				}<br>
			}<br>
		});<br>
<br>
		return mView;<br>
	}<br>
<br>
}<br>
<br>
<br>
</code></pre>


<h2>layout</h2>

<img src='http://comp166-koreauniv.googlecode.com/files/상미xml.png' />

<h3>activity_main.xml</h3>

<pre><code><br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/LinearLayout2"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:orientation="vertical"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".MainActivity" &gt;<br>
<br>
    &lt;LinearLayout<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        android:orientation="horizontal" &gt;<br>
<br>
        &lt;EditText<br>
            android:id="@+id/et"<br>
            android:layout_width="match_parent"<br>
            android:layout_height="wrap_content"<br>
            android:layout_weight="1"<br>
            android:hint="과목명"<br>
            android:inputType="text" &gt;<br>
<br>
            &lt;requestFocus /&gt;<br>
        &lt;/EditText&gt;<br>
<br>
        &lt;Button<br>
            android:id="@+id/btn1"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:text="추가" /&gt;<br>
    &lt;/LinearLayout&gt;<br>
<br>
    &lt;ListView<br>
        android:id="@+id/listView1"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="match_parent"<br>
        android:choiceMode="singleChoice" &gt;<br>
    &lt;/ListView&gt;<br>
<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>

<h3>activity_wth.xml</h3>

<pre><code><br>
&lt;android.support.v4.view.ViewPager xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/pager"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    tools:context=".Wth" &gt;<br>
<br>
<br>
&lt;/android.support.v4.view.ViewPager&gt;<br>
<br>
<br>
</code></pre>

<h3>fragment_wth_dummy.xml</h3>

<pre><code><br>
&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".Wth$DummySectionFragment" &gt;<br>
<br>
    &lt;TextView<br>
        android:id="@+id/section_label"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content" /&gt;<br>
<br>
&lt;/RelativeLayout&gt;<br>
<br>
</code></pre>

<h3>activity_student.xml</h3>

<pre><code><br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/LinearLayout1"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:orientation="vertical"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".MainActivity" &gt;<br>
<br>
    &lt;LinearLayout<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        android:orientation="horizontal" &gt;<br>
  &lt;TextView android:id="@+id/dateDisplay"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:text=""/&gt;<br>
    &lt;Button android:id="@+id/pickDate"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:text="Change the date"/&gt;<br>
<br>
    &lt;Button<br>
        android:id="@+id/button1"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:text="Save" /&gt;<br>
<br>
    &lt;/LinearLayout&gt;<br>
<br>
    &lt;TextView<br>
        android:id="@+id/textView1"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:text="               지각      출석      결석"<br>
        android:textAppearance="?android:attr/textAppearanceMedium" /&gt;<br>
<br>
    &lt;ListView<br>
        android:id="@+id/lv"<br>
        android:textColor="@android:color/black"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="match_parent"<br>
        android:choiceMode="singleChoice" &gt;<br>
    &lt;/ListView&gt;<br>
<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>

<h3>activity_student_add.xml</h3>

<pre><code><br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/LinearLayout2"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:orientation="vertical"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".AddStudent" &gt;<br>
<br>
    &lt;LinearLayout<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        android:orientation="horizontal" &gt;<br>
<br>
        &lt;EditText<br>
            android:id="@+id/et"<br>
            android:layout_width="match_parent"<br>
            android:layout_height="wrap_content"<br>
            android:layout_weight="1"<br>
            android:hint="학생 이름"<br>
            android:inputType="text" &gt;<br>
<br>
            &lt;requestFocus /&gt;<br>
        &lt;/EditText&gt;<br>
<br>
        &lt;Button<br>
            android:id="@+id/btn1"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:text="추가" /&gt;<br>
    &lt;/LinearLayout&gt;<br>
<br>
    &lt;ListView<br>
        android:id="@+id/listView1"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="match_parent"<br>
        android:choiceMode="singleChoice" &gt;<br>
    &lt;/ListView&gt;<br>
<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>

<h3>activity_result.xml</h3>

<pre><code><br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/LinearLayout1"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:orientation="vertical"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".MainActivity" &gt;<br>
<br>
    &lt;LinearLayout<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        android:orientation="horizontal" &gt;<br>
    &lt;/LinearLayout&gt;<br>
<br>
    &lt;ListView<br>
        android:id="@+id/lv"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="match_parent"<br>
        android:choiceMode="singleChoice" &gt;<br>
    &lt;/ListView&gt;<br>
<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>

<h3>activity_assignment.xml</h3>

<pre><code><br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/LinearLayout1"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:orientation="vertical"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".MainActivity" &gt;<br>
<br>
    &lt;LinearLayout<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        android:orientation="horizontal" &gt;<br>
<br>
        &lt;EditText<br>
            android:id="@+id/et"<br>
            android:layout_width="match_parent"<br>
            android:layout_height="wrap_content"<br>
            android:layout_weight="1"<br>
            android:hint="데이터 입력"<br>
            android:inputType="text" &gt;<br>
<br>
            &lt;requestFocus /&gt;<br>
        &lt;/EditText&gt;<br>
<br>
        &lt;Button<br>
            android:id="@+id/btn1"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:text="추가" /&gt;<br>
    &lt;/LinearLayout&gt;<br>
<br>
    &lt;ListView<br>
        android:id="@+id/lv"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="match_parent"<br>
        android:choiceMode="singleChoice" &gt;<br>
    &lt;/ListView&gt;<br>
<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>

<h3>activity_add_student.xml</h3>

<pre><code><br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:tools="http://schemas.android.com/tools"<br>
    android:id="@+id/LinearLayout2"<br>
    android:layout_width="match_parent"<br>
    android:layout_height="match_parent"<br>
    android:orientation="vertical"<br>
    android:paddingBottom="@dimen/activity_vertical_margin"<br>
    android:paddingLeft="@dimen/activity_horizontal_margin"<br>
    android:paddingRight="@dimen/activity_horizontal_margin"<br>
    android:paddingTop="@dimen/activity_vertical_margin"<br>
    tools:context=".AddStudent" &gt;<br>
<br>
    &lt;LinearLayout<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        android:orientation="horizontal" &gt;<br>
<br>
        &lt;EditText<br>
            android:id="@+id/et"<br>
            android:layout_width="match_parent"<br>
            android:layout_height="wrap_content"<br>
            android:layout_weight="1"<br>
            android:hint="학생 이름"<br>
            android:inputType="text" &gt;<br>
<br>
            &lt;requestFocus /&gt;<br>
        &lt;/EditText&gt;<br>
<br>
        &lt;Button<br>
            android:id="@+id/btn1"<br>
            android:layout_width="wrap_content"<br>
            android:layout_height="wrap_content"<br>
            android:text="추가" /&gt;<br>
    &lt;/LinearLayout&gt;<br>
<br>
    &lt;ListView<br>
        android:id="@+id/listView1"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="match_parent"<br>
        android:choiceMode="singleChoice" &gt;<br>
    &lt;/ListView&gt;<br>
<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>

<h3>row.xml</h3>

<pre><code><br>
&lt;?xml version="1.0" encoding="utf-8"?&gt;<br>
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"<br>
    xmlns:android1="http://schemas.android.com/apk/res/android"<br>
    android1:id="@+id/LinearLayout1"<br>
    android:layout_width="fill_parent"<br>
    android:layout_height="wrap_content" &gt;<br>
<br>
    &lt;TextView<br>
        android:id="@+id/textView1"<br>
        android:layout_width="wrap_content"<br>
        android:layout_height="wrap_content"<br>
        android:text="Medium Text"<br>
        android:textColor="@android:color/black"        <br>
        android:textAppearance="?android:attr/textAppearanceMedium" /&gt;<br>
<br>
    &lt;RadioGroup<br>
        android:id="@+id/radioGroup1"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        android:orientation="horizontal" &gt;<br>
<br>
        &lt;RadioButton<br>
            android1:id="@+id/radio0"<br>
            android1:layout_width="0dp"<br>
            android1:layout_height="wrap_content"<br>
            android1:layout_alignParentTop="true"<br>
            android1:layout_marginLeft="36dp"<br>
            android1:layout_toRightOf="@+id/textView1"<br>
            android1:layout_weight="1"<br>
            android1:checked="true" /&gt;<br>
<br>
        &lt;RadioButton<br>
            android1:id="@+id/radio1"<br>
            android1:layout_width="0dp"<br>
            android1:layout_height="wrap_content"<br>
            android1:layout_weight="1"<br>
            android1:checked="true" /&gt;<br>
<br>
        &lt;RadioButton<br>
            android:id="@+id/radio2"<br>
            android:layout_width="0dp"<br>
            android:layout_height="wrap_content"<br>
            android:layout_weight="1"<br>
            android:text="" /&gt;<br>
    &lt;/RadioGroup&gt;<br>
<br>
&lt;/LinearLayout&gt;<br>
<br>
</code></pre>


<h1>APK download</h1>

<a href='http://comp166-koreauniv.googlecode.com/files/AttendanceBook.apk'>http://comp166-koreauniv.googlecode.com/files/AttendanceBook.apk</a>


<h1>Reference</h1>

안드로이드 코드조각 <a href='https://code.google.com/p/comp166-koreauniv/wiki/AndroidCodeSnippet'>https://code.google.com/p/comp166-koreauniv/wiki/AndroidCodeSnippet</a>

교수님<br>
<br>
구글링(ex. DatePicker)<br>
<br>
프로그램 전체를 따온 것이 아니라 각각의 함수들을 구글링했기때문에 모든 출처를 밝히기는 어렵습니다.<br>
<br>
stackoverflow사이트를 가장 많이 참조했으며 tab형식이라 어차피 그대로 못쓰고 변형했습니다.