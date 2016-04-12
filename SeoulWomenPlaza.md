

# 소개 #

서울시열린데이터광장의 OpenAPI를 이용한 **서울시 여성가족재단 행사 안내 어플\*입니다.**

아래 예제 프로그램이 정상적으로 작동하기 위해서는 SeoulWomenPlazaList.java 파일의 key 값을 [OpenAPI키](http://data.seoul.go.kr/openinf/develop/developer.jsp)에서 구해서 넣어야 합니다. 어플1에 대한 [PDF](https://code.google.com/p/comp166-koreauniv/downloads/detail?name=01.%20%EB%82%98%EB%A7%8C%EC%9D%98%20%EC%96%B4%ED%94%8C%20%EB%A7%8C%EB%93%A4%EA%B8%B0.pdf)파일도 같이 참조하시길 바랍니다.

API샘플

  * http://openapi.seoul.go.kr:8088/sample/xml/SeoulWomenPlazaEvent/1/5/
  * http://openapi.seoul.go.kr:8088/sample/json/SeoulWomenPlazaEvent/1/5/
  * http://openapi.seoul.go.kr:8088/sample/xml/SeoulWomenPlazaEvent/1/5/


# 샘플어플1 #

**MainActivity.java**

```
package com.example.t01;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Main thread에서 internet 사용하기
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 
        
        // Actionbar에 home button 활성화시키기
        getActionBar().setHomeButtonEnabled(true);

        // 서울시 데이터 로드하기
        SeoulWomenPlazaList.Load();

        // 화면에 보여줄 List만들기
        ArrayList<String> showList = new ArrayList<String>();
        for (SeoulWomenPlazaItem item : SeoulWomenPlazaList.itemList) {
            showList.add(item.TITLE);
        }

        // list를 화면에 보여주기
        ArrayAdapter<String> Adapter;
        Adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, showList);

        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(Adapter);

        // list가 눌렸을때 이벤트 처리기 지정
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        
        // List가 눌렸을때 ItemActivity 띄우기 & 데이터 넘기기
        Intent intent = new Intent(getBaseContext(), ItemActivity.class);
        intent.putExtra("idx", position);
        startActivity(intent);
    }

}

```

**ItemActivity.java**

```
package com.example.t01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        
        // Actionbar에 home button 활성화시키고 제목설정하기
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("행사 정보");
        
        // 앞화면에서 넘어온 데이터받기 
        Intent intent = getIntent();
        int idx = intent.getIntExtra("idx", 0);
        SeoulWomenPlazaItem item = SeoulWomenPlazaList.itemList.get(idx);

        // 가져온 데이터 보여주기       
        ((TextView)findViewById(R.id.textView1)).setText(item.TITLE);
        ((TextView)findViewById(R.id.textView2)).setText(item.EVT_REG_NO);
        ((TextView)findViewById(R.id.textView3)).setText(item.EVT_REG_START_DATE);
        ((TextView)findViewById(R.id.textView4)).setText(item.EVT_REG_END_DATE);
        ((TextView)findViewById(R.id.textView5)).setText(item.EVT_TYPE);
        ((TextView)findViewById(R.id.textView6)).setText(item.EVT_DATE);
        ((TextView)findViewById(R.id.textView7)).setText(item.EVT_PLACE);
        ((TextView)findViewById(R.id.textView8)).setText(item.EVT_TARGET);
        ((TextView)findViewById(R.id.textView9)).setText(item.EVT_REG_METHOD);
        ((TextView)findViewById(R.id.textView10)).setText(item.EVT_SPONSOR);
        ((TextView)findViewById(R.id.textView11)).setText(item.EVT_CONTACT);
        ((TextView)findViewById(R.id.textView12)).setText(item.URL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

}

```

**SeoulWomenPlazaList.java**

```
package com.example.t01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;

class SeoulWomenPlazaItem {
    public String EVT_REG_NO;
    public String TITLE;
    public String EVT_REG_START_DATE;
    public String EVT_REG_END_DATE;
    public String EVT_TYPE;
    public String EVT_DATE;
    public String EVT_PLACE;
    public String EVT_TARGET;
    public String EVT_REG_METHOD;
    public String EVT_SPONSOR;
    public String EVT_CONTACT;
    public String URL;

}

public class SeoulWomenPlazaList {

    public static ArrayList<SeoulWomenPlazaItem> itemList = new ArrayList<SeoulWomenPlazaItem>();
    public static Hashtable<String, SeoulWomenPlazaItem> itemMap = new Hashtable<String, SeoulWomenPlazaItem>();

    public static void Load() {

        itemMap.clear();

        try {
            String key = "";
            String type = "xls";
            String service = "SeoulWomenPlazaEvent";
            String startIndex = "1";
            String endIndex = "999";

            // 서울시 데이터를 가져올 주소 만들기
            String url = String.format(
                    "http://openapi.seoul.go.kr:8088/%s/%s/%s/%s/%s/", key,
                    type, service, startIndex, endIndex);
            URL myUrl = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    myUrl.openStream(), "euc-kr"));

            // 서울시 데이터를 저장하기
            String readLine;
            readLine = reader.readLine();
            while ((readLine = reader.readLine()) != null) {
                String[] items = readLine.split("\t");

                SeoulWomenPlazaItem item = new SeoulWomenPlazaItem();
                item.EVT_REG_NO = items[0];
                item.TITLE = items[1];
                item.EVT_REG_START_DATE = items[2];
                item.EVT_REG_END_DATE = items[3];
                item.EVT_TYPE = items[4];
                item.EVT_DATE = items[5];
                item.EVT_PLACE = items[6];
                item.EVT_TARGET = items[7];
                item.EVT_REG_METHOD = items[8];
                item.EVT_SPONSOR = items[9];
                item.EVT_CONTACT = items[10];
                item.URL = items[11];

                itemList.add(item);
                itemMap.put(item.EVT_REG_NO, item);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
```

**AndroidManifest.xml**

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.t01"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-sdk
        android:minSdkVersion="16"
        android:targetSdkVersion="17" />

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" >
        <activity
            android:name="com.example.t01.MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name="com.example.t01.ItemActivity"
            android:label="@string/title_activity_item" >
        </activity>
    </application>

</manifest>
```

# 샘플어플2 #

**MainActivity.java**

```
package com.example.seoulwomen;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity implements OnItemClickListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 
        
        getActionBar().setHomeButtonEnabled(true);

        SeoulWomenPlazaList.Load();

        // 저장된 Type을 화면에 보여주기
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, SeoulWomenPlazaList.typeArray);

        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent intent = new Intent(getBaseContext(), ListByTypeActivity.class);
        intent.putExtra("EVT_TYPE", SeoulWomenPlazaList.typeArray.get(position));
        startActivity(intent);
    }

}
```

**ListByTypeActivity.java**

```
package com.example.seoulwomen;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListByTypeActivity extends Activity implements OnItemClickListener{

    String EVT_TYPE;
    ArrayList<String> showList = new ArrayList<String>();
    ArrayList<String> regList = new ArrayList<String>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_by_type);

        Intent intent = getIntent();
        EVT_TYPE = intent.getStringExtra("EVT_TYPE");

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(EVT_TYPE);

        // Type에 해당되는 Item만 보여주기
        showList.clear();
        regList.clear();
        for (SeoulWomenPlazaItem item : SeoulWomenPlazaList.itemList) {
            if ( !EVT_TYPE.equals(item.EVT_TYPE) ) continue;
            showList.add(item.TITLE);
            regList.add(item.EVT_REG_NO);
        }

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, showList);

        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_by_type, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
    

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        // List가 눌렸을때 ItemActivity 띄우기 & EVT_REG_NO 넘기기
        Intent intent = new Intent(getBaseContext(), ItemActivity.class);
        intent.putExtra("EVT_REG_NO", regList.get(position));
        startActivity(intent);
    }
    
}
```

**ItemActivity.java**

```
package com.example.seoulwomen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ItemActivity extends Activity {

    String EVT_REG_NO;
    SeoulWomenPlazaItem item;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("행사 정보");

        // 앞화면에서 넘어온 EVT_REG_NO받기 & Item가져오기
        Intent intent = getIntent();
        EVT_REG_NO = intent.getStringExtra("EVT_REG_NO");
        item = SeoulWomenPlazaList.itemMap.get(EVT_REG_NO);
        
        // 화면에 Item보여주기
        ((TextView)findViewById(R.id.textView1)).setText(item.TITLE);
        ((TextView)findViewById(R.id.textView2)).setText(item.EVT_REG_NO);
        ((TextView)findViewById(R.id.textView3)).setText(item.EVT_REG_START_DATE);
        ((TextView)findViewById(R.id.textView4)).setText(item.EVT_REG_END_DATE);
        ((TextView)findViewById(R.id.textView5)).setText(item.EVT_TYPE);
        ((TextView)findViewById(R.id.textView6)).setText(item.EVT_DATE);
        ((TextView)findViewById(R.id.textView7)).setText(item.EVT_PLACE);
        ((TextView)findViewById(R.id.textView8)).setText(item.EVT_TARGET);
        ((TextView)findViewById(R.id.textView9)).setText(item.EVT_REG_METHOD);
        ((TextView)findViewById(R.id.textView10)).setText(item.EVT_SPONSOR);
        ((TextView)findViewById(R.id.textView11)).setText(item.EVT_CONTACT);
        ((TextView)findViewById(R.id.textView12)).setText(item.URL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

}
```

**SeoulWomenPlazaList.java**

```
package com.example.seoulwomen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;

class SeoulWomenPlazaItem {
    public String EVT_REG_NO;
    public String TITLE;
    public String EVT_REG_START_DATE;
    public String EVT_REG_END_DATE;
    public String EVT_TYPE;
    public String EVT_DATE;
    public String EVT_PLACE;
    public String EVT_TARGET;
    public String EVT_REG_METHOD;
    public String EVT_SPONSOR;
    public String EVT_CONTACT;
    public String URL;

}

public class SeoulWomenPlazaList {

    public static ArrayList<SeoulWomenPlazaItem> itemList = new ArrayList<SeoulWomenPlazaItem>();
    public static Hashtable<String, SeoulWomenPlazaItem> itemMap = new Hashtable<String, SeoulWomenPlazaItem>();
    public static ArrayList<String> typeArray = new ArrayList<String>();

    public static void Load() {

        itemMap.clear();

        try {
            String key = "";
            String type = "xls";
            String service = "SeoulWomenPlazaEvent";
            String startIndex = "1";
            String endIndex = "999";

            String url = String.format(
                    "http://openapi.seoul.go.kr:8088/%s/%s/%s/%s/%s/", key,
                    type, service, startIndex, endIndex);
            URL myUrl = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    myUrl.openStream(), "euc-kr"));

            String readLine;
            readLine = reader.readLine();
            while ((readLine = reader.readLine()) != null) {
                String[] items = readLine.split("\t");

                SeoulWomenPlazaItem item = new SeoulWomenPlazaItem();
                item.EVT_REG_NO = items[0];
                item.TITLE = items[1];
                item.EVT_REG_START_DATE = items[2];
                item.EVT_REG_END_DATE = items[3];
                item.EVT_TYPE = items[4];
                item.EVT_DATE = items[5];
                item.EVT_PLACE = items[6];
                item.EVT_TARGET = items[7];
                item.EVT_REG_METHOD = items[8];
                item.EVT_SPONSOR = items[9];
                item.EVT_CONTACT = items[10];
                item.URL = items[11];

                itemList.add(item);
                itemMap.put(item.EVT_REG_NO, item);
                
                // Type만 들어간 ArrayList만들기
                if (!typeArray.contains(item.EVT_TYPE))
                    typeArray.add(item.EVT_TYPE);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
```

**AndroidManifest.xml**

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.t01"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-sdk
        android:minSdkVersion="16"
        android:targetSdkVersion="17" />

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" >
        <activity
            android:name="com.example.t01.MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name="com.example.t01.ItemActivity"
            android:label="@string/title_activity_item" >
        </activity>
    </application>

</manifest>
```