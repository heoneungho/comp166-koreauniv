# Introduction #

식사메뉴를 추천해줍니다.

프로젝트 https://drive.google.com/folderview?id=0BzNZQlQUTmZAbTFwWEszOHc2ajg&usp=sharing

apk파일 https://drive.google.com/file/d/0BzNZQlQUTmZATGFNMWVlMFRySWc/edit?usp=sharing

# Details #

![https://comp166-koreauniv.googlecode.com/files/decisionmaking.png](https://comp166-koreauniv.googlecode.com/files/decisionmaking.png)

# Code #

MainActivity.java : 맨 처음 화면. Food, Dice, Exit 버튼이 있다.
```
package com.example.decisionmaking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// db 열기.
		FoodDatabase.createDatabase();

		// 버튼을 위한 변수 생성.
		ImageButton food_btn = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton dice_btn = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton exit_btn = (ImageButton) findViewById(R.id.imageButton3);

		// 애니메이션.
		ImageView title = (ImageView) findViewById(R.id.imageView1);
		Animation ani1 = AnimationUtils.loadAnimation(this, R.anim.move);
		Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani3 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani4 = AnimationUtils.loadAnimation(this, R.anim.move2);
		ani1.setStartOffset(400);
		ani2.setStartOffset(100);
		ani3.setStartOffset(200);
		ani4.setStartOffset(300);
		food_btn.startAnimation(ani2);
		dice_btn.startAnimation(ani3);
		exit_btn.startAnimation(ani4);
		title.startAnimation(ani1);

		// 음식버튼.
		food_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("onClick", "Food");
				Intent intentFoodActivity = new Intent(MainActivity.this,
						FoodActivity.class);
				startActivity(intentFoodActivity);
			}

		});

		// 주사위버튼.
		dice_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("onClick", "Dice");
				Intent intentDiceActivity = new Intent(MainActivity.this,
						DiceActivity.class);
				startActivity(intentDiceActivity);
			}
		});

		// 나가기 버튼.
		exit_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("onClick", "Exit");
				finish();
			}

		});

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
```



FoodActivity.java : Food를 눌렀을 때 나오는 화면. Emotion, Calories, Preference, Upload버튼이 있다.
```
package com.example.decisionmaking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FoodActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food);
		
		//ImageButton, ImageView 선언 및 애니메이션.
		ImageButton feeling_btn = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton calories_btn = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton preference_btn = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton upload_btn = (ImageButton) findViewById(R.id.imageButton4);
        ImageView title=(ImageView)findViewById(R.id.imageView1);
		Animation ani1 = AnimationUtils.loadAnimation(this, R.anim.move);
		Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani3 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani4 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani5 = AnimationUtils.loadAnimation(this, R.anim.move2);
		ani1.setStartOffset(500);
		ani2.setStartOffset(100);
		ani3.setStartOffset(200);
		ani4.setStartOffset(300);
		ani5.setStartOffset(400);
		feeling_btn.startAnimation(ani2);
		calories_btn.startAnimation(ani3);
		upload_btn.startAnimation(ani5);
		preference_btn.setAnimation(ani4);
		title.startAnimation(ani1);
		

		// emotion 버튼.
		feeling_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						FeelingActivity.class);
				startActivity(intent);
			}
		});

		// calories 버튼.
		calories_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						CaloriesActivity.class);
				startActivity(intent);
			}
		});
		
		// preference 버튼.
				preference_btn.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						Intent intent = new Intent(getBaseContext(),
								PreferenceActivity.class);
						startActivity(intent);
					}
				});

		// upload 버튼.
		upload_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						UploadActivity.class);
				startActivity(intent);
			}
		});
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food, menu);
		return true;
	}

}

```



FeelingActivity.java : Emotion버튼을 누르면 나오는 화면, 네 가지 표정 버튼이 있고, ResultActivity에 각각의 옵션값을 넘겨준다.
```
package com.example.decisionmaking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FeelingActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feeling);

		// ImageView, ImageButton 선언 애니메이션.
		ImageView title = (ImageView) findViewById(R.id.imageView1);
		ImageButton happy_btn = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton soso_btn = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton sad_btn = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton angry_btn = (ImageButton) findViewById(R.id.imageButton4);
		Animation ani1 = AnimationUtils.loadAnimation(this, R.anim.move);
		Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani3 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani4 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani5 = AnimationUtils.loadAnimation(this, R.anim.move2);
		ani1.setStartOffset(500);
		ani2.setStartOffset(100);
		ani3.setStartOffset(200);
		ani4.setStartOffset(300);
		ani5.setStartOffset(400);
		soso_btn.startAnimation(ani2);
		angry_btn.startAnimation(ani3);
		happy_btn.startAnimation(ani4);
		sad_btn.startAnimation(ani5);
		title.startAnimation(ani1);

		// happy버튼.
		// Option값으로 int 1을 넘김.
		happy_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 1);
				startActivity(intent);

				finish();
			}
		});

		// soos버튼.
		// Option값으로 int 2을 넘김.
		soso_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 2);
				startActivity(intent);
				finish();
			}
		});

		// sad버튼.
		// Option값으로 int 3을 넘김.
		sad_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 3);
				startActivity(intent);
				finish();
			}
		});

		// angry버튼.
		// Option값으로 int 4을 넘김.
		angry_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 4);
				startActivity(intent);
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feeling, menu);
		return true;
	}
}

```



CaloriesActivity.java : Calories버튼을 누르면 나오는 화면. ~300,~400,~500 버튼이 있고, ResultActivity에 각각의 옵션값을 넘겨준다.
```
package com.example.decisionmaking;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CaloriesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calories);

		// Imagebutton ImageView 선언 및 애니메이션.
		ImageButton cal300_btn = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton cal400_btn = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton cal500_btn = (ImageButton) findViewById(R.id.imageButton3);
		ImageView title = (ImageView) findViewById(R.id.imageView1);
		Animation ani1 = AnimationUtils.loadAnimation(this, R.anim.move);
		Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani3 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani4 = AnimationUtils.loadAnimation(this, R.anim.move2);
		ani1.setStartOffset(400);
		ani2.setStartOffset(100);
		ani3.setStartOffset(200);
		ani4.setStartOffset(300);
		cal300_btn.startAnimation(ani2);
		cal400_btn.startAnimation(ani3);
		cal500_btn.startAnimation(ani4);
		title.startAnimation(ani1);

		// 300버튼.
		// Option값으로 int 300을 넘김.
		cal300_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 300);
				startActivity(intent);
			}
		});

		// 400버튼.
		// Option값으로 int 400을 넘김.

		cal400_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 400);
				startActivity(intent);
			}
		});

		// 500버튼.
		// Option값으로 int 500을 넘김.

		cal500_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 500);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calories, menu);
		return true;
	}

}

```



PreferenceActivity.java : Preference버튼을 누르면 나오는 화면. 버튼을 누르면 각각의 옵션을 ResultActivity에 넘겨준다.
```
package com.example.decisionmaking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PreferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);

		// Imagebutton ImageView 선언 및 애니메이션.
		ImageButton star3_btn = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton star4_btn = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton star5_btn = (ImageButton) findViewById(R.id.imageButton5);
		ImageView title = (ImageView) findViewById(R.id.imageView1);
		Animation ani1 = AnimationUtils.loadAnimation(this, R.anim.move);
		Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani3 = AnimationUtils.loadAnimation(this, R.anim.move2);
		Animation ani4 = AnimationUtils.loadAnimation(this, R.anim.move2);
		ani1.setStartOffset(400);
		ani2.setStartOffset(100);
		ani3.setStartOffset(200);
		ani4.setStartOffset(300);
		star3_btn.startAnimation(ani2);
		star4_btn.startAnimation(ani3);
		star5_btn.startAnimation(ani4);
		title.startAnimation(ani1);

		// star3버튼.
		// Option값으로 int 3000을 넘김.
		star3_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 3000);
				startActivity(intent);
			}
		});
		// star4버튼.
		// Option값으로 int 4000을 넘김.
		star4_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 4000);
				startActivity(intent);
			}
		});
		// star5버튼.
		// Option값으로 int 5000을 넘김.
		star5_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						ResultActivity.class);
				intent.putExtra("Option", 5000);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calories, menu);
		return true;
	}

}

```



UploadActivity.java : Upload버튼을 누르면 나오는 화면. 앨범에서 사진을 선택하고, 음식이름, 칼로리를 입력하고, 음식 카테고리를 선택할 수 있다. 각각은 FoodDatabase.java클래스의 함수로 데이터베이스에 저장된다. 사진은 경로가 저장된다.
```
package com.example.decisionmaking;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class UploadActivity extends Activity implements OnItemSelectedListener {

	private String TEMP_PHOTO_FILE = "";// 저장 파일 이름.
	private String SELECT_ITEM;
	private static final int REQ_CODE_PICK_IMAGE = 0;
	ArrayList<String> arraylist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload);
		ImageView image_btn = (ImageView) findViewById(R.id.imageView1);
		ImageView upload_btn = (ImageView) findViewById(R.id.imageView2);

		/** image입력 받음 */
		image_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (TEMP_PHOTO_FILE != "") {
					// 파일 바꾸면 이전 것은 삭제
					File f = new File(Environment.getExternalStorageDirectory()
							+ "/android/data/com.example.decisionmaking", TEMP_PHOTO_FILE + ".PNG");
					f.delete();
				}

				Intent intent = new Intent(
						Intent.ACTION_GET_CONTENT,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				intent.setType("image/*"); // 모든 이미지
				intent.putExtra("crop", "true"); // Crop기능 활성화
				intent.putExtra(MediaStore.EXTRA_OUTPUT, getTempUri()); // 파일 생성
				intent.putExtra("outputFormat", // 포맷방식
						Bitmap.CompressFormat.PNG.toString());

				startActivityForResult(intent, REQ_CODE_PICK_IMAGE);

			}

		});

		/** 스피너 설정 부 */
		arraylist = new ArrayList<String>();
		arraylist.add("찌개&백반");
		arraylist.add("죽");
		arraylist.add("찜&삶은요리");
		arraylist.add("구이");
		arraylist.add("비빔밥");
		arraylist.add("면류");
		arraylist.add("매운음식");
		arraylist.add("회&초밥");
		arraylist.add("중국음식");
		arraylist.add("스테이크&프랑스음식");
		arraylist.add("피자&파스타");
		arraylist.add("에스닉푸드");
		arraylist.add("분식");
		arraylist.add("햄버거&샌드위치");
		arraylist.add("치킨");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, arraylist);
		Spinner sp = (Spinner) this.findViewById(R.id.spinner1);
		sp.setPrompt("카테고리"); // 스피너 제목
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener(this);

		/** 업로드 버튼 */
		upload_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EditText name_txt = (EditText) findViewById(R.id.editText1);
				EditText calories_txt = (EditText) findViewById(R.id.editText2);
				String name = "" + name_txt.getText().toString();
				String image = TEMP_PHOTO_FILE + ".PNG";
				String group = SelectGroup();
				String calories = "" + calories_txt.getText().toString();
				if (name != "" && image != ".PNG" && group != ""
						&& calories != "") {
					FoodDatabase.InsertData(name, image, group, calories);
					Intent intent = new Intent(getBaseContext(),
							FoodActivity.class);
					startActivity(intent);
					Toast.makeText(UploadActivity.this, "Uploaded!",
							Toast.LENGTH_SHORT).show();
				} else
					Toast.makeText(UploadActivity.this, "Enter the elments!",
							Toast.LENGTH_SHORT).show();
			}
		});

	}

	/** 임시 저장 파일의 경로를 반환 */
	private Uri getTempUri() {
		return Uri.fromFile(getTempFile());
	}

	/**
	 * 외장메모리에 임시 이미지 파일을 생성하여 그 파일의 경로를 반환 
	 * 파일이름은 날짜시간 
	 * 압축 방식은 PNG
	 */
	private File getTempFile() {
		String format = new String("yyyyMMddHHmmss");

		if (isSDCARDMOUNTED()) { // sdcard가 마운트되어있으면.
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.KOREA);
			// 이미지 파일 이름은 날짜시간.
			TEMP_PHOTO_FILE = sdf.format(new Date());
			// 파일생성.
			File f = new File(Environment.getExternalStorageDirectory()
					+ "/android/data/com.example.decisionmaking", TEMP_PHOTO_FILE + ".PNG");
			try {
				f.createNewFile();
			} catch (IOException e) {
			}

			return f;
		} else
			return null;
	}

	/** SD카드가 마운트 되어 있는지 확인 */
	private boolean isSDCARDMOUNTED() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED))
			return true;

		return false;
	}

	/** 다시 액티비티로 복귀하였을때 이미지 셋팅 */
	protected void onActivityResult(int requestCode, int resultCode,
			Intent imageData) {
		super.onActivityResult(requestCode, resultCode, imageData);

		switch (requestCode) {
		case REQ_CODE_PICK_IMAGE:
			if (resultCode == RESULT_OK) {
				if (imageData != null) {
					ImageView image_btn = (ImageView) findViewById(R.id.imageView1);
					String filePath = Environment.getExternalStorageDirectory()
							+ "/android/data/com.example.decisionmaking/" + TEMP_PHOTO_FILE + ".PNG";

					System.out.println("path" + filePath); // logCat으로 경로확인.

					Bitmap selectedImage = BitmapFactory.decodeFile(filePath);
					// Bitmap으로 디코딩한다.

					image_btn.setImageBitmap(selectedImage);
					// 이미지뷰에 씌운다.
				}
			}
			break;
		}
	}

	private String SelectGroup() {
		if (SELECT_ITEM == "찌개&백반")
			return "1";
		else if (SELECT_ITEM == "죽")
			return "2";
		else if (SELECT_ITEM == "찜&삶은요리")
			return "3";
		else if (SELECT_ITEM == "구이")
			return "4";
		else if (SELECT_ITEM == "비빔밥")
			return "5";
		else if (SELECT_ITEM == "면류")
			return "6";
		else if (SELECT_ITEM == "매운음식")
			return "7";
		else if (SELECT_ITEM == "회&초밥")
			return "8";
		else if (SELECT_ITEM == "중국음식")
			return "9";
		else if (SELECT_ITEM == "스테이크&프랑스음식")
			return "10";
		else if (SELECT_ITEM == "피자&파스타")
			return "11";
		else if (SELECT_ITEM == "에스닉푸드")
			return "12";
		else if (SELECT_ITEM == "분식")
			return "13";
		else if (SELECT_ITEM == "햄버거&샌드위치")
			return "14";
		else if (SELECT_ITEM == "치킨")
			return "15";
		else
			return "";
	}

	/** 스피너 목차가 눌렸을때 행동 */
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		SELECT_ITEM = String.valueOf(arraylist.get(arg2));

	}

	/** 스피너와 관련된 것 */
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.upload, menu);
		return true;
	}

}

```



ResultActivity.java : 음식 추천이 나오는 화면. FoodDatabase.java의 함수를 이용해 데이터를 불러오고, 저장한다.
```
package com.example.decisionmaking;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class ResultActivity extends Activity {

	ImageView rec;
	ImageView again_btn;
	TextView name;
	TextView calories;
	int count = 0;
	int id;
	RatingBar rb;
	String image = "";

	public static boolean must_be_recycled = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		name = (TextView) findViewById(R.id.textView1);
		rec = (ImageView) findViewById(R.id.imageView1);
		again_btn = (ImageView) findViewById(R.id.imageView3);

		/**
		 * (*) 이미지를 조건에 맞게 랜덤 추출해서 iamgeView에 보내는 부분. 디폴트 데이터는 내장 메모리에 들어있고, 사용자
		 * 업로드 데이터는 /sdcard//android/data/com.example.decisionmaking에 넣는다.
		 */
		Intent intent = getIntent();
		int option = intent.getIntExtra("Option", 0); // option에 값을 받음.
		image = FoodDatabase.Select_by(option); // image에 랜덤 추출한 데이터값을 넣음.

		//Text view
		Typeface typeFace = Typeface.createFromAsset(getAssets(), "mother.otf");
		name.setText(FoodDatabase.get_name(image) + "("
				+ FoodDatabase.get_calories(image) + "Kcal)");
		name.setTypeface(typeFace);
		//Image View
		if (image.contains(".PNG")) { // ".PNG" 가 이미지 경로에 포함될 경우 SDcard에 있는
										// 이미지임.
			String filePath = Environment.getExternalStorageDirectory()
					+ "/android/data/com.example.decisionmaking/" + image;
			Bitmap selectedImage = BitmapFactory.decodeFile(filePath);
			rec.setImageBitmap(selectedImage);
			must_be_recycled = true; // 이 경우에 bitmap을 리사이클 할 수 있다.
		} else { // 아닐 경우 디폴트 이미지임.
			must_be_recycled = false;// 이 경우 bitmap 리싸이클 안함.
			int redId = getResources().getIdentifier(image, "drawable",
					"com.example.decisionmaking");
			rec.setImageResource(redId);
		}

		/** again버튼을 누르면 일어나는 일. (*)+비트맵 리사이클임 */
		again_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = getIntent();
				int option = intent.getIntExtra("Option", 0);
				image = "";

				// Recycle
				Drawable d = rec.getDrawable();
				if (rec.getDrawable() instanceof BitmapDrawable) {
					BitmapDrawable bd;
					bd = (BitmapDrawable) d;
					if (bd.getBitmap() != null
							&& ResultActivity.must_be_recycled)
						bd.getBitmap().recycle();
				}

				try {
					image = FoodDatabase.Select_by(option);
					// text view
					Typeface typeFace = Typeface.createFromAsset(getAssets(),
							"mother.otf");
					name.setText(FoodDatabase.get_name(image) + "("
							+ FoodDatabase.get_calories(image) + "Kcal)");
					name.setTypeface(typeFace);
					// rating bar
					float rating = FoodDatabase.get_preference(image);
					rb.setRating((float) rating);
					// image view
					if (image.contains(".PNG")) {
						String filePath = Environment
								.getExternalStorageDirectory()
								+ "/android/data/com.example.decisionmaking/"
								+ image;
						System.out.println("path" + filePath);
						must_be_recycled = true;

						Bitmap selectedImage = BitmapFactory
								.decodeFile(filePath);
						rec.setImageBitmap(selectedImage);
					} else {
						must_be_recycled = false;
						int redId = getResources().getIdentifier(image,
								"drawable", "com.example.decisionmaking");
						rec.setImageResource(redId);
					}
				} catch (Exception e) {

				}
			}
		});

		/**
		 * ratingbar 부분.
		 */

		rb = (RatingBar) findViewById(R.id.ratingbar);
		float Rating = FoodDatabase.get_preference(image);
		rb.setRating((float) Rating);

		rb.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
			}
		});

		/** enter_btn이 눌리면 업로드 */
		ImageView enter_btn = (ImageView) findViewById(R.id.imageView4);

		enter_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				float preference = rb.getRating();
				System.out.println(FoodDatabase.get_preference(image));
				FoodDatabase.UpdateData(image, preference);
				Toast.makeText(ResultActivity.this, "Rated!",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}

```



DiceActivity.java : 주사위 부분임.
```
package com.example.decisionmaking;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DiceActivity extends Activity {

	int count = 0;
	ImageView dice;
	ImageButton roll_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dice);

		// ImageView, ImageButton 선언.
		dice = (ImageView) findViewById(R.id.imageView1);
		roll_btn = (ImageButton) findViewById(R.id.imageButton1);

		// (*)1~6까지의 랜덤 수 생성해서 이미지 뿌림.
		int random = (int) (Math.random() * 6 + 1);
		String image = "dice" + random;
		int redId = getResources().getIdentifier(image, "drawable",
				"com.example.decisionmaking");
		dice.setImageResource(redId);

		// roll버튼.(*)과 같음.
		roll_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int random = (int) (Math.random() * 6 + 1);
				String image = "dice" + random;
				int redId = getResources().getIdentifier(image, "drawable",
						"com.example.decisionmaking");
				dice.setImageResource(redId);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dice, menu);
		return true;
	}

}

```


FoodDatabase.java
```

package com.example.decisionmaking;

import java.io.File;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class FoodDatabase {
	private static final String DATABASE_NAME = "/sdcard/android/data/com.example.decisionmaking/food.db";
	private static final String TABLE_NAME = "FoodTable";
	private static final String dbCreateString = "create table IF NOT EXISTS "
			+ TABLE_NAME
			+ " (_id integer primary key autoincrement,"
			+ "name text,image text,foodgroup integer,calories integer,preference float);";

	public static SQLiteDatabase myDatabase;

	public static void createDatabase() {

		File dbfile = new File(DATABASE_NAME);

		// db파일이 없으면 생성함.
		if (!CheckDatabase("/sdcard/android/data/com.example.decisionmaking/food.db")) {
			myDatabase = SQLiteDatabase.openOrCreateDatabase(dbfile, null);

			myDatabase.execSQL(dbCreateString);
			// 찌개 국 탕
			myDatabase
					.execSQL("insert into FoodTable values (null,\"된장찌개\",\"dwinjangjjigae\",1,124,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"김치찌개\",\"gimchijjigae\",1,276,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"곰탕\",\"gomtang\",1,190,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"해장국\",\"haejangguk\",1,254,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"만두국\",\"manduguk\",1,480,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"순대국\",\"sundaeguk\",1,341,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"순두부찌개\",\"sundubujjigae\",1,253,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"비지찌개\",\"bijijjigae\",1,293,0);");
			// 죽.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"죽\",\"juk\",2,348,0);");
			// 찜 삶음 전.
			// myDatabase.execSQL("insert into FoodTable values (null,\"해물파전\",\"haemulpajeon\",3,831,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"파전\",\"pajeon\",3,369,0);");
			// 구이.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"삼겹살\",\"samgyeopsal\",4,662,0);");
			// 비빔밥 볶음밥 오믈렛.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"비빔밥\",\"bibimbap\",5,559,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"오므라이스\",\"omurice\",5,420,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"제육복음\",\"jeyukbokkum\",5,557,0);");
			// 국수, 우동, 냉면
			// myDatabase.execSQL("insert into FoodTable values (null,\"칼국수\",\"kalguksu\",6,422,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"냉면\",\"nangmyeon\",6,542,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"우동\",\"udong\",6,702,0);");
			// 낙지볶음, 불닭, 쭈꾸미 볶음, 불면.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"낚지볶음\",\"nakjibokkum\",7,366,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"불닭\",\"buldak\",7,665,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"쭈꾸미볶음\",\"jukumibokkum\",7,448,0);");
			// 사시미, 롤, 스시.
			// myDatabase.execSQL("insert into FoodTable values (null,\"롤\",\"rollfood\",8,725,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"스시\",\"sushi\",8,725,0);");
			// myDatabase.execSQL("insert into FoodTable values (null,\"물회\",\"mulhoe\",8,335,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"회\",\"hoe\",8,228,0);");
			// 짜장면, 짬뽕, 탕수육, 중국음식.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"짜장면\",\"jjajangmyeon\",9,864,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"짬뽕\",\"jjambbong\",9,788,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"탕수육\",\"tangsuyuk\",9,481,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"류산슬밥\",\"ryusansulbap\",9,600,0);");
			// 스테이크.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"스테이크\",\"steak\",10,897,0);");
			// 피자, 파스타, 이탈리아음식.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"피자\",\"pizza\",11,269,0);");
			// myDatabase.execSQL("insert into FoodTable values (null,\"오일파스타\",\"oilpasta\",11,270,0);");
			// 쌀국수, 카레, 에스닉푸드.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"쌀국수\",\"ssalguksu\",12,565,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"카레\",\"curry\",12,417,0);");
			// 떡볶이, 순대, 김밥, 라면, 만두.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"떡볶이\",\"ddukbbokki\",13,280,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"순대\",\"sundae\",13,517,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"김밥\",\"gimbap\",13,484,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"라면\",\"ramyeon\",13,540,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"만두\",\"mandu\",13,595,0);");
			// 햄버거, 샌드위치, 빵, 패스트푸드.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"햄버거\",\"hamburger\",14,422,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"샌드위치\",\"sandwichi\",14,474,0);");
			myDatabase
					.execSQL("insert into FoodTable values (null,\"핫도그\",\"hotdog\",14,109,0);");
			// 치킨.
			myDatabase
					.execSQL("insert into FoodTable values (null,\"치킨\",\"chicken\",15,269,0);");
		} else {
			myDatabase = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
		}

	}

	/** 음식 선택 메소드 */
	public static String Select_by(int option) {
		String food = "";
		if (option == 1) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE foodgroup=11 OR foodgroup=4 OR foodgroup=8 OR foodgroup=10 OR foodgroup=15 OR foodgroup=1 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		} else if (option == 2) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE foodgroup=1 OR foodgroup=14 OR foodgroup=13 OR foodgroup=3 OR foodgroup=6 OR foodgroup=11 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		}

		else if (option == 3) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE foodgroup=1 OR foodgroup=13 OR foodgroup=3 OR foodgroup=2 OR foodgroup=5 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		}

		else if (option == 4) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE foodgroup=7 OR foodgroup=13 OR foodgroup=3 OR foodgroup=5 OR foodgroup=1 OR foodgroup=15 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		}

		else if (option == 300) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE calories<301 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		}

		else if (option == 400) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE calories<401 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		}

		else if (option == 500) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE calories<501 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		} else if (option == 3000) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE preference>3.0 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		} else if (option == 4000) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE preference>4.0 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		} else if (option == 5000) {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE preference=5.0 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		}

		else {
			Cursor cursor = myDatabase
					.rawQuery(
							"SELECT image FROM FoodTable WHERE foodgroup=1 ORDER BY RANDOM()",
							null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0)
				food = cursor.getString(0);
			cursor.close();
		}
		return food;

	}

	/** image로 name 찾는 함수 */
	public static String get_name(String image) {
		String name = "";
		Cursor cursor = myDatabase.rawQuery(
				"SELECT name FROM FoodTable WHERE image=\"" + image + "\"",
				null);
		cursor.moveToFirst();
		if (cursor.getCount() > 0)
			name = cursor.getString(0);
		cursor.close();
		return name;
	}

	/** image로 calories 찾는 함수 */
	public static String get_calories(String image) {
		String calories = "";
		Cursor cursor = myDatabase.rawQuery(
				"SELECT calories FROM FoodTable WHERE image=\"" + image + "\"",
				null);
		cursor.moveToFirst();
		if (cursor.getCount() > 0)
			calories = cursor.getString(0);
		cursor.close();
		return calories;
	}

	/** image로 preference 찾는 함수 */
	public static float get_preference(String image) {
		float preference = 0;
		Cursor cursor = myDatabase.rawQuery(
				"SELECT preference FROM FoodTable WHERE image=\"" + image
						+ "\"", null);
		cursor.moveToFirst();
		if (cursor.getCount() > 0)
			preference = Float.parseFloat(cursor.getString(0));
		cursor.close();
		return preference;
	}

	/** db파일 있나 체크하는 함수 */
	public static boolean CheckDatabase(String DB_FULL_PATH) {
		SQLiteDatabase checkDB = null;
		try {
			checkDB = SQLiteDatabase.openDatabase(DB_FULL_PATH, null,
					SQLiteDatabase.OPEN_READONLY);
			checkDB.close();
		} catch (SQLiteException e) {
			// database doesn't exist yet.
			return false;
		}
		return checkDB != null ? true : false;
	}

	/** 업로드 함수 */
	public static void InsertData(String name, String image, String group,
			String calories) {
		myDatabase.execSQL("insert into FoodTable values (null,\"" + name
				+ "\",\"" + image + "\"," + group + "," + calories + ",1);");

	}

	/** 업데이트 함수 */
	public static void UpdateData(String image, float preference) {
		myDatabase.execSQL("update FoodTable set preference="
				+ Float.toString(preference) + " where image=\"" + image
				+ "\";");

	}

}

```



activity\_main.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".FeelingActivity"     
    android:background="@drawable/bg" >
    
    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="120dp"
        android:src="@drawable/decisionmaking" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="40dp"
        android:background="#00000000"
        android:src="@drawable/food" />

    <ImageButton
        android:id="@+id/imageButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton1"
        android:layout_below="@+id/imageButton1"
        android:layout_marginTop="25dp"
        android:background="#00000000"
        android:src="@drawable/dice" />

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignRight="@+id/imageButton2"
        android:layout_below="@+id/imageButton2"
        android:layout_marginTop="25dp"
        android:background="#00000000"
        android:src="@drawable/exit" />



</RelativeLayout>

```



activity\_food.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".FoodActivity" 
    android:background="@drawable/bg" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="80dp"
        android:src="@drawable/choosetheoption" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="40dp"
        android:background="#00000000"
        android:src="@drawable/emotion" />
    
    <ImageButton
        android:id="@+id/imageButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton1"
        android:layout_below="@+id/imageButton1"
        android:layout_marginTop="20dp"
        android:background="#00000000"
        android:src="@drawable/calories" />

    <ImageButton
        android:id="@+id/imageButton4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton3"
        android:layout_below="@+id/imageButton3"
        android:layout_marginTop="20dp"
        android:background="#00000000"
        android:src="@drawable/upload" />

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageButton2"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:background="#00000000"
        android:src="@drawable/preference" />

</RelativeLayout>
```



activity\_feeling.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".FeelingActivity"     
    android:background="@drawable/bg" >

    <ImageButton
        android:id="@+id/imageButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/imageButton3"
        android:layout_alignLeft="@+id/imageButton4"
        android:background="#00000000"
        android:src="@drawable/soso" />

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageButton1"
        android:layout_marginTop="20dp"
        android:layout_toLeftOf="@+id/imageButton4"
        android:background="#00000000"
        android:src="@drawable/sad" />

    <ImageButton
        android:id="@+id/imageButton4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/imageButton3"
        android:layout_marginLeft="20dp"
        android:layout_toRightOf="@+id/imageButton1"
        android:background="#00000000"
        android:src="@drawable/angry" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="120dp"
        android:src="@drawable/youremotion" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_below="@+id/imageView1"
        android:layout_marginLeft="90dp"
        android:layout_marginTop="25dp"
        android:background="#00000000"
        android:src="@drawable/happy" />

</RelativeLayout>

```



activity\_calories.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".FoodActivity" 
    android:background="@drawable/bg" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="120dp"
        android:src="@drawable/calorieslowerthan" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="50dp"
        android:background="#00000000"
        android:src="@drawable/cal300" />
    
    <ImageButton
        android:id="@+id/imageButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton1"
        android:layout_below="@+id/imageButton1"
        android:layout_marginTop="25dp"
        android:background="#00000000"
        android:src="@drawable/cal400" />

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton2"
        android:layout_below="@+id/imageButton2"
        android:layout_marginTop="25dp"
        android:background="#00000000"
        android:src="@drawable/cal500" />

</RelativeLayout>
```



activity\_preference.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".FoodActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="120dp"
        android:src="@drawable/starsmorethan" />

    <ImageButton
        android:id="@+id/imageButton4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton3"
        android:layout_below="@+id/imageButton3"
        android:layout_marginTop="25dp"
        android:background="#00000000"
        android:src="@drawable/star4" />

    <ImageButton
        android:id="@+id/imageButton5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageButton4"
        android:layout_below="@+id/imageButton4"
        android:layout_marginTop="25dp"
        android:background="#00000000"
        android:src="@drawable/star5" />

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="50dp"
        android:background="#00000000"
        android:src="@drawable/star3" />

</RelativeLayout>
```



activity\_upload.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".ResultActivity" >

    <Spinner
        android:id="@+id/spinner1"
        android:layout_width="wrap_content"
        android:layout_height="50dp"
        android:layout_alignLeft="@+id/editText2"
        android:layout_alignRight="@+id/editText2"
        android:layout_below="@+id/editText2"
        android:hint="음식 종류" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="240dp"
        android:layout_height="180dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="75dp"
        android:src="@drawable/album" />

    <EditText
        android:id="@+id/editText1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:ems="10"
        android:hint="Food"
        android:inputType="textPersonName" >

        <requestFocus />
    </EditText>

    <EditText
        android:id="@+id/editText2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/editText1"
        android:layout_below="@+id/editText1"
        android:ems="10"
        android:hint="Calories(Kcal)"
        android:inputType="numberDecimal" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/spinner1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="25dp"
        android:src="@drawable/upload" />

</RelativeLayout>
```



activity\_result.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".ResultActivity" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="200dp"
        android:layout_height="35dp"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_alignRight="@+id/imageView1"
        android:layout_below="@+id/ratingbar"
        android:layout_marginTop="10dp"
        android:gravity="center"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#000000"
        android:textSize="30sp"
        android:textStyle="bold" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:src="@drawable/again_g" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="31dp"
        android:src="@drawable/recommendation" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="320dp"
        android:layout_height="240dp"
        android:layout_below="@+id/imageView2"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dp"
        android:src="@drawable/chicken" />

    <RatingBar
        android:id="@+id/ratingbar"
        style="@style/CustomRatingBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="15dp"
        android:gravity="center" />

    <ImageView
        android:id="@+id/imageView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/ratingbar"
        android:layout_marginLeft="16dp"
        android:layout_toRightOf="@+id/ratingbar"
        android:src="@drawable/enter" />

</RelativeLayout>
```



activity\_dice.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".DiceActivity"
    android:background="@drawable/bg" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:src="@drawable/dice5" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="60dp"
        android:background="#00000000"
        android:src="@drawable/roll" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="60dp"
        android:src="@drawable/rollthedice" />

</RelativeLayout>

```