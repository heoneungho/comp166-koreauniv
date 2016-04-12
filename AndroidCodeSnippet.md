

# 유용한 단축키 #

  * F3 : 함수와 변수 정의로 가기
  * Ctrl+Shift+F : 자동 포맷팅
  * Ctrl+Shift+O : 필요한 import 자동으로 수행하기
  * Ctrl+F : 찾기 (Ctrl+K: 다음찾기)
  * Ctrl+Shift+B : Break point만들기
  * Ctrl+PgUp : 이전문서
  * Ctrl+PgDn : 다음문서

# Main Thread에서 인터넷을 사용하기 #

안드로이드앱은 Main Thread 에서는 인터넷을 사용할 수 없게 되어 있습니다. 아래 코드는 Main Thread에서 인터넷을 사용할 수 있게 해주는 코드입니다.

```
StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
StrictMode.setThreadPolicy(policy); 
```

또한 AndroidManifest.xml에 인터넷 사용허가가 필요하다고 남겨야 합니다.
```
<uses-permission android:name="android.permission.INTERNET" />
```

# Activity Layout을 편집하기 #

Activity Layout을 Vertical Layout으로 변경하는 순서 입니다.

  1. Activity의 모든 control을 지운다
  1. 마우스 오른쪽버튼 -> Change Layout을 선택
  1. Linear Layout (Vertical) 을 선택

# Actionbar에 home button 활성화시키고 제목설정하기 #

메인화면에서는 Home으로 가는 Button없이 제목만 보이면 됩니다

```
getActionBar().setTitle("기본 화면");
```

세부화면에서는 Home으로 가는 Button과 제목이 보여야 합니다

```
getActionBar().setHomeButtonEnabled(true);			
getActionBar().setDisplayHomeAsUpEnabled(true);
getActionBar().setTitle("행사 정보");
```

# List를 화면에 보여주기 #

listView1에 showList를 보여주는 방법입니다.

```
ArrayList<String> showList = new ArrayList<String>();
showList.add("1");
showList.add("2");
showList.add("3");

ArrayAdapter<String> Adapter;
Adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, showList);

ListView listView = (ListView) findViewById(R.id.listView1);
listView.setAdapter(Adapter);
```

# 자동완성에 데이터 채우기 #

자동완성TextView에 보여줄 데이터를 채워넣는 방법입니다.

```
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	android.R.layout.simple_list_item_1, StationList.fullNameList);

AutoCompleteTextView textView1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
textView1.setAdapter(adapter);
```

# 다음 화면으로 이동하기 #

버튼이 눌렸을때 다음 화면으로 이동하는 방법입니다

```
Button button = (Button) findViewById(R.id.button1);
button.setOnClickListener(new View.OnClickListener() {
	public void onClick(View v) {
		Intent intent = new Intent(getBaseContext(), PathActivity.class);
		startActivity(intent);
	}
});		
```

다음 화면에 데이터도 같이 넘기고 싶으면 Intent 부분을 다음과 같이 고치시면 됩니다.

```
Intent intent = new Intent(getBaseContext(),PathActivity.class);
String arg1 = "a";
int arg2 = 1;
intent.putExtra("arg1", arg1);
intent.putExtra("arg2", arg2);
startActivity(intent);
```

리스트의 Item이 클릭되었을때 다음 화면으로 이동하는 방법입니다.

```
listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int pos, long id) {
		Intent intent = new Intent(getBaseContext(), PathActivity.class);
		intent.putExtra("pos", pos);
		startActivity(intent);
    }
});
```

# 이전 화면에서 넘져준 데이터 받기 #

이전화면에서 pos와 str이 넘어왔을때 이를 받는 방법입니다.

```
Intent intent = getIntent();
int pos = intent.getIntExtra("pos", 0);
String str = intent.getStringExtra("str");
```

# Arraylist와 Hashtable 사용하기 #

2가지 인스턴스 변수를 가지는 SampleItem 클래스가 있습니다.

```
class SampleItem {
    public String name;
    public String val;
    public SampleItem(String n, String v) {
    	name = n;
    	val = v;
    }
}
```

ArrayList 사용하기

```
ArrayList<SampleItem> itemList = new ArrayList<SampleItem>();
itemList.add(new SampleItem("name1", "val1"));
itemList.add(new SampleItem("name2", "val2"));
itemList.add(new SampleItem("name3", "val3"));

// 두번째 아이템 가져오기
SampleItem item2 = itemList.get(1);

// 모든 아이템에서 val만 모으기
ArrayList<String> valList = new ArrayList<String>();
for (SampleItem item : itemList) {
    valList.add(item.val);
}
```

Hashtable 사용하기

```
Hashtable<String, SampleItem> itemMap = new Hashtable<String, SampleItem>();
itemMap.put("name1", new SampleItem("name1", "val1"));
itemMap.put("name2", new SampleItem("name2", "val2"));
itemMap.put("name3", new SampleItem("name3", "val3"));

// name2를 가지는 item가져오기
SampleItem item2 = itemMap.get("name2");

// 모든 아이템에서 val만 모으기
ArrayList<String> valList = new ArrayList<String>();
for(Entry<String, SampleItem> e : itemMap.entrySet()) {
    String key = e.getKey();
    SampleItem item = e.getValue();
    valList.add(item.val);
}
```

# 파일에서 데이터 읽어오기 #

프로그램이 작동하기 위해 필요한 데이터를 파일로부터 읽어들이는 예제입니다. 4개의 지하철역에 대한 정보를 읽어들이는 예을 보여드리도록 하겠습니다.

**station.txt**

읽어들인 데이터파일입니다. 파일 내용은 utf8로 저장되어 있어야 합니다. 아래 내용을 텍스트 파일에 붙여넣고 utf8 형식으로 저장한 다음, eclipse project의 assets폴더에 추가하세요.

```
0329|고속터미널|Express Bus Terminal|3|02-6110-3391|서울특별시 서초구 신반포로 지하188|서울과 지방 주요도시를 고속버스로 연결하는 경부선, 호남선, 영동선등 고속버스터미널이 지상에 위치한 데서 역명 유래
0423|충무로|Chungmuro|4|02-6110-4231|서울특별시 중구 퇴계로 지하199|충무로는 임진왜란때 명장 충무공 이순신의 시호를 붙인 것이다. 이순신 장군이 태어난 곳은 건천동 즉 현재의 인현동1가 였으므로 이를 기념하기 위해 충무로로 지었다. 이곳은 남촌 또는 아랫대로 불리우던 지역으로 사육신의 힌사람인 박팽년 외에 많은 명사들이 살았다.
0424|명동|Myeong-dong|4|02-6110-4241|서울특별시 중구 퇴계로 지하126|명동은 갑오개혁(1894년)때 처음 붙여진 이름으로 이는 조선초부터 이곳을 명례방이라 한데서 유래된 것이다. 유행의 1번지로 일컫는 이곳은 한때 다방을 중심으로 ‘예술의 거리’로 알려져 있다.
0425|회현|Hoehyeon|4|02-6110-4251|서울특별시 중구 퇴계로 지하54|회현동은 조선말 고종때 처음 붙여진 이름으로 이는 전일의 호현동(好賢洞)이 반음되어 유래된 것으로 이곳에는 조선왕조때 정광필,김상헌 형제 등의 어진 사람들이 모여 살았기 때문에 회현동(會賢洞)이라 불리어진 이름이다.
```

**StationList.java**

4개의 Station(지하철역)을 저장할 클래스입니다.

```

class Station {
    public String code;
    public String name;
    public String enName;
    public String line;
    public String tel;
    public String address;
    public String history;

    public Station() {
    }

    public Station(String c, String n, String e, String l, String t, String a,
            String h) {
        code = c;
        name = n;
        enName = e;
        line = l;
        tel = t;
        address = a;
        history = h;
    }

    public String toString() {
        return String.format("%s (%s호선)", name, line);
    }
}

public class StationList {

    public static ArrayList<Station> dataList = new ArrayList<Station>();

    public static void LoadStation(BufferedReader brStation)
            throws Exception {

        dataList.clear();

        String readLine = "";
        while ((readLine = brStation.readLine()) != null) {
            String[] items = readLine.split("|");
            if (items.length < 5)
                continue;

            String code = items[0];
            String name = items[1];
            String enName = items[2];
            String line = items[3];
            String tel = items[4];
            String address = (items.length > 5) ? items[5] : "";
            String history = (items.length > 6) ? items[6] : "";

            Station station = new Station(code, name, enName, line, tel,
                    address, history);

            dataList.add(station);
        }
    }
}
```

**MainActivity.java**

onCreate 함수 내부에 아래 코드를 삽입합니다.

```

try {
    InputStream isStation = getAssets().open("station.txt");
    BufferedReader brStation = new BufferedReader(new InputStreamReader(isStation));
    StationList.LoadStation(brStation);
} catch (Exception e) {
    e.printStackTrace();
}

```