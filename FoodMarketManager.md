# Introduction #

음식점에서 그날 판매되지 않은 값싼 상품에 대해 광고할 수 있는 공간을 마련해 준다. 소비자는 지도를 통해 주변 상품 정보를 획득할 수 있다.(단, 소외계층을 도울 수 있도록 상점은 일정량의 기부 상품을 등록해야 한다.)

# Background #

음식은 유통기한이라는 한계점이 있다. 따라서 일정 기한 내에 판매가 되야 하지만 그렇지 못하는 경우 새 음식이라도 버릴 수 밖에 없다. 이런 점에 착안하여 음식점들은 기한내에 팔아야 하는 남은 상품들을 광고하여 판매하고, 소비자들은 값 싸게 상품을 획득할 수 있는 공간을 마련해 준다면 모두에게 이득일 것이라고 생각하였다. 단, 돈이 부족한 소외계층에도 혜택이 돌아갈 수 있도록 일정량의 기부 음식을 제공하도록 하여 남을 돕는 기부문화에 대해 재고해 볼 수 있도록 추가적으로 마련해 보려고 한다.

# 요구사항 #

1. 업체의 상품 관리를 위해 회원유지가 필요하다.

2. 업체의 상품 정보는 지도에 표시 되어야 한다.

3. 일반 사용자는 회원가입 필요없이 상품 검색이 가능해야한다.

4. 일반 사용자는 자신의 위치에 해당하는 주변에 위치한 상품에 대한 정보를 획득할 수 있어야 한다.

5. 사용자들은 소통을 위한 공간이 필요하다.

6. 주소를 편하게 입력하기 위해 GPS기능을 요구한다.

7. 업체가 상품등록한다면 지도에 표시되어야 한다.

# 세부사항 & 개발환경 #

**Version : 안드로이드 어플로 개발.(최하 android 2.1버젼으로)**

1. Java Develoment Kit(JDK) 6.0 다운로드 및 설치
: 자바 라이브러리를 통해 클래스 파일의 원활환 작업을 위해 필요

http://java.sun.com/javase/downloads/index.jsp (다운로드 링크)

![http://comp166-koreauniv.googlecode.com/files/JDK.png](http://comp166-koreauniv.googlecode.com/files/JDK.png)

2. Eclipse 다운로드 및 설치
: 클래스 파일 생성하고 실제 코드작업을 한다. 또한 에뮬레이터로 기기에 작동하는지 테스트를 할 수 있다.

http://www.eclipse.org/downloads/ (다운로드 링크)

![http://comp166-koreauniv.googlecode.com/files/eclipse.png](http://comp166-koreauniv.googlecode.com/files/eclipse.png)

3. Android SDK 다운로드 및 설치
: 안드로이드에서 제공하는 툴킷을 제공받을 수 있다.

http://developer.android.com/sdk/index.html

![http://comp166-koreauniv.googlecode.com/files/SDK.png](http://comp166-koreauniv.googlecode.com/files/SDK.png)

4. APM7Setup
: 데이터를 저장할 수 있는 DB를 자신의 PC로 테스트 할 수 있는 가상의 서버를 제공해 준다.

http://apmsetup.com/

![http://comp166-koreauniv.googlecode.com/files/APM7Setup.png](http://comp166-koreauniv.googlecode.com/files/APM7Setup.png)

# 개발 방법 #

안드로이드 어플을 개발하기 위해선 크게 5가지로 구성된다.

1. 레이아웃
: 레이아웃은 어플의 화면을 구성하는 작업으로 주로 XML코드로 이루어 진다.

http://comp166-koreauniv.googlecode.com/files/layout1.PNG

http://comp166-koreauniv.googlecode.com/files/layout2.PNG

2. 클래스 파일
: 어플에 동작해야 할 모든 기능을 담당하는 부분으로 일반적인 자바코드 작업과 동일하다.

http://comp166-koreauniv.googlecode.com/files/code.PNG

3. PHP파일
: 웹서버에 자료를 넘겨주고 받아오기 위한 것으로 C코드와 SQL언어에 대한 이해가 필요하다.

http://comp166-koreauniv.googlecode.com/files/php.PNG

4. 리소스 파일 관리
: 어플에 들어갈 이미지나 레이아웃 등 부가적인 요소에 대해 폴더를 두고 관리한다.

http://comp166-koreauniv.googlecode.com/files/resource.PNG

5. Database
: 사용자로부터 입력받은 자료를 저장 및 검색하기 위한 공간으로 SQL언어에 대한 이해가 필요하다.

http://comp166-koreauniv.googlecode.com/files/db.PNG

# 클래스 관계 #

사용자의 요구사항에 부합되게 프로그램을 만들기 위해서는 크게 4가지 종류로 작성될 수 있다.

1. 로그인 클래스 : 로그인 회원정보관리

2. 상품 클래스 : 상품 등록 및 검색

3. 게시판 클래스 : 게시판 관리

4. 구글맵 클래스 : 지도에 표시될 소스 관리

**클래스 상속관계는 아래의 그림과 같다.**

http://comp166-koreauniv.googlecode.com/files/class.PNG
# 클래스 상호작용 #
![http://comp166-koreauniv.googlecode.com/files/Class.png](http://comp166-koreauniv.googlecode.com/files/Class.png)
# 화면 전환 과정 #
![http://comp166-koreauniv.googlecode.com/files/Activity.png](http://comp166-koreauniv.googlecode.com/files/Activity.png)
# 클래스에 사용될 메소드 #

자바로 안드로이드 어플을 개발하는데 있어서 기본적으로 onCreate() 와 onClick()메소드를 사용한다.

**onCreate() : 안드로이드 앱을 실행했을 때 처음 보이는 화면을 위해 만들어진**

**onClick() : 사용자가 핸드폰을 터치하였을 때 이벤트를 처리하기 위한 함수**

추가적인 메소드들

**setOnClickListener() : 해당 버튼이 클릭 되었을 때 이벤트 처리**

**JSONObject : 사용자로부터 입력받은 자료 parsing하기 위한 함수**

**DatabaseHandler : 안드로이드 내에 내장된 데이터 베이스 활용하기 위한 핸들러**

**onPreExecute() : 엑티비티 전환시 먼저 처리되는**

**doInBackground() : 엑티비티 전환시 백그라운드에서 작업되는 것 처리**

**onPostExecute() : 전환 완료 후 작업 실행**

Sample Code
```
 public class MainActivity extends Activity implements View.OnClickListener {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_main);
    }

    @Override
    public void onClick(View v) {
	// TODO Auto-generated method stub
	int id = v.getId();
	if(id == button2.getId()){
		Intent intent = new Intent(this, com.example.Map.googleMap.class);
		intent.putExtra("strCurTime", strCurTime);
		startActivity(intent);
	}
    }
}
```


**LoginActivity.java**

```

package com.example.Login;

import java.util.HashMap;



import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.FoodMarketMain.*;
import com.example.LoginLibrary.*;

public class LoginActivity extends Activity{
	Button btnLogin;
	Button btnLinkToRegister;
	Button btnCommonConnection;
	EditText inputID;
	EditText inputPassword;
	TextView loginErrorMsg;

	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "uid";
	private static String KEY_PASSWORD = "password";
	private static String KEY_BUSINESS_NAME = "business_name";
	private static String KEY_BUSINESS_PHONE = "business_phone";
	private static String KEY_BUSINESS_LOCATION = "business_location";
	private static String KEY_BUSINESS_IMAGE = "business_image";
	private static String KEY_CREATED_AT = "created_at";
	private static String KEY_LOCALHOST = "localhost";
	private static String KEY_X_LOCATION = "x_location";
	private static String KEY_Y_LOCATION = "y_location";
		

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);

		
		// Importing all assets like buttons, text fields
		inputID = (EditText) findViewById(R.id.loginID);
		inputPassword = (EditText) findViewById(R.id.loginPassword);
		
		
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
		
		
		loginErrorMsg = (TextView) findViewById(R.id.login_error);
		btnCommonConnection = (Button)findViewById(R.id.btnCommonConnection);

		// Login button Click Event
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				
				String uid = inputID.getText().toString();
				String password = inputPassword.getText().toString();
		
				UserFunctions userFunction = new UserFunctions();
				Log.d("Button", "Login");
				JSONObject json = userFunction.loginUser(uid, password);

				// check for login response
				try {
					if (json.getString(KEY_SUCCESS) != null) {
						loginErrorMsg.setText("");
						String res = json.getString(KEY_SUCCESS); 
						if(Integer.parseInt(res) == 1){
							// user successfully logged in
							// Store user details in SQLite Database
							DatabaseHandler db = new DatabaseHandler(getApplicationContext());
							JSONObject json_user = json.getJSONObject("user");
							
						
							// Clear all previous data in database
							userFunction.logoutUser(getApplicationContext());
							
							String imageURL = "http://"+json_user.getString(KEY_LOCALHOST)+"/android_login/image/"+json_user.getString(KEY_BUSINESS_IMAGE);
							
							
							db.addUser(json_user.getString(KEY_UID), json_user.getString(KEY_PASSWORD), json_user.getString(KEY_BUSINESS_NAME), 
									json_user.getString(KEY_BUSINESS_PHONE), json_user.getString(KEY_BUSINESS_LOCATION),
									imageURL, json_user.getString(KEY_CREATED_AT),
									json_user.getString(KEY_X_LOCATION), json_user.getString(KEY_Y_LOCATION));						
							
							// Launch Dashboard Screen
							Intent main_activity = new Intent(getApplicationContext(), com.example.FoodMarketMain.MainActivity.class);
							
							// Close all views before launching main_activity
							startActivity(main_activity);
							
							// Close Login Screen
							finish();
						}else{
							// Error in login
							loginErrorMsg.setText("Incorrect userID/password");
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});

		
		btnCommonConnection.setOnClickListener(new View.OnClickListener(){
			
			public void onClick(View view){
				
				Intent i = new Intent(getApplicationContext(), com.example.FoodMarketMain.CommonMainActivity.class);
				startActivity(i);
				finish();
			}
			
		});
		
		
		// Link to Register Screen
		btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
}

```

**NewProductActivity.java**

```
package com.example.Products;


import com.example.parse.*;
import com.example.Login.*;
import com.example.parse.*;




import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;


import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.FoodMarketMain.*;
import com.example.Login.Base64;
import com.example.LoginLibrary.DatabaseHandler;
import com.example.parse.JSONParser;

import android.widget.CheckBox;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewProductActivity extends Activity {

	// Progress Dialog
	private ProgressDialog pDialog;

	JSONParser jsonParser = new JSONParser();
	
	
	EditText prodBusinessName, prodBusinessPhone, prodBusinessLocation;
	EditText giveProductName, giveProductNum;
	EditText productName, productPrice, productDesc;
	
	ImageView giveProductImage, productImage;
	String businessImage, giveImage, prodImage;
	
	Button btngiveSendPicture, btnproductSendPicture, btncreateProduct;
	
	static int REQUEST_PICTURE = 2;
	static int REQUEST_PHOTO_ALBUM = 3;
	static int REQUEST_PICTURE1 = 4;
	static int REQUEST_PHOTO_ALBUM1 = 5;
	static String SAMPLEIMG = "photo.png";
	
	static String ImageFilePath;
	static Uri selectedImageURI;
	
	static String ImageFilePath1;
	static Uri selectedImageURI1;
	
	static double x_location, y_location;
	static String x, y;
	
	Context mContext = this;
	ImageView iv;
	Dialog dialog; //button 클릭
    
    
    
	// url to create new product    
	private static String url_create_product = LocalhostAdress.Adress + "/android_connect/create_product.php";

	// JSON Node names
	private static final String TAG_SUCCESS = "success";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_add_products);
		
		
		// Edit Text
		prodBusinessName = (EditText) findViewById(R.id.ProdBusinessName);
		prodBusinessPhone = (EditText) findViewById(R.id.ProdBusinessPhone);
		prodBusinessLocation = (EditText) findViewById(R.id.ProdBusinessLocation);
		
		giveProductName = (EditText) findViewById(R.id.GiveProductName);
		giveProductNum = (EditText) findViewById(R.id.GiveProductNum);
		
		productName = (EditText) findViewById(R.id.ProductName);
		productPrice = (EditText) findViewById(R.id.ProductPrice);
		productDesc = (EditText) findViewById(R.id.ProductDesc);
		
		giveProductImage = (ImageView)findViewById(R.id.GiveProductImgae);
		productImage = (ImageView)findViewById(R.id.ProductImage);
		 
		//check box
		CheckBox check=(CheckBox)findViewById(R.id.checkbox);

		
		Button btncreateProduct = (Button) findViewById(R.id.btnCreateProduct);

		
		//check box event
		check.setOnClickListener(new OnClickListener() {
			   
			@Override
			public void onClick(View view) {
				
				// TODO Auto-generated method stub
				DatabaseHandler db = new DatabaseHandler(mContext);
				HashMap<String,String> user = new HashMap<String,String>();
				user = db.getUserDetails();
				
				prodBusinessName.setText(user.get("BusinessName"));
				prodBusinessPhone.setText(user.get("BusinessPhone"));
				
				GPSTracker gps = new GPSTracker(NewProductActivity.this);
				
				if(gps.canGetLocation()){
					double[] mylocation = new double[2];
			    	x_location = Double.parseDouble(user.get("x_location"));// x좌표
			    	y_location = Double.parseDouble(user.get("y_location")); // y좌표
			    	String serverUrl = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+x_location+","+y_location+"&sensor=true&region=KR";
			    	String ParsedJSON = getUrl(serverUrl);
			    	String Address = jsonParser(ParsedJSON); // 실제주소
			    	prodBusinessLocation.setText(Address);
						
				}
			}
			
		  });


		
		// button click event
		btncreateProduct.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// creating new product in background thread
				new CreateNewProduct().execute();
			}
		});
	}

	/**
	 * Background Async Task to Create new product
	 * */
	class CreateNewProduct extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(NewProductActivity.this);
			pDialog.setMessage("잠시만 기다려주세요..");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		/**
		 * Creating product
		 * */
		protected String doInBackground(String... args) {
			
			DatabaseHandler db = new DatabaseHandler(mContext);
			HashMap<String,String> user = new HashMap<String,String>();
			user = db.getUserDetails();
			
			String ProductBusinessName = prodBusinessName.getText().toString();
			String ProductBusinessPhone = prodBusinessPhone.getText().toString();
			String ProductBusinessLocation = "";//prodBusinessLocation.getText().toString();

			
			String GiveProductName = giveProductName.getText().toString();
			String GiveProductNum = giveProductNum.getText().toString();

			
			String ProductName = productName.getText().toString();
			String ProductPrice = productPrice.getText().toString();
			String ProductDesc = productDesc.getText().toString();
			
			
			
			//String BusinessImageFie = BaseFileToString((user.get("BusinessImage")));
			String GiveImageFile = BaseFileToString(giveImage);
			String ProdImageFile = BaseFileToString(prodImage);
			
			Log.d("Image", (user.get("BusinessImage")));
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("ID", (user.get("ID"))));
			params.add(new BasicNameValuePair("BusinessImageName", (user.get("BusinessImage"))));
			params.add(new BasicNameValuePair("x_location", (user.get("x_location"))));
			params.add(new BasicNameValuePair("y_location", (user.get("y_location"))));
			
			params.add(new BasicNameValuePair("ProductBusinessName", ProductBusinessName));
			params.add(new BasicNameValuePair("ProductBusinessPhone", ProductBusinessPhone));
			params.add(new BasicNameValuePair("ProductBusinessLocation", ProductBusinessLocation));
			
			
			
			params.add(new BasicNameValuePair("GiveProductName", GiveProductName));
			params.add(new BasicNameValuePair("GiveProductNum", GiveProductNum));
			
			params.add(new BasicNameValuePair("ProductName", ProductName));
			params.add(new BasicNameValuePair("ProductPrice", ProductPrice));
			params.add(new BasicNameValuePair("ProductDesc", ProductDesc));
			
			
			params.add(new BasicNameValuePair("GiveImageName", giveImage));
			params.add(new BasicNameValuePair("ProdImageName", prodImage));
			
			
			params.add(new BasicNameValuePair("GiveImageFile", GiveImageFile));
			params.add(new BasicNameValuePair("ProdImageFile", ProdImageFile));
			//params.add(new BasicNameValuePair("BusinessImageFie", ProdImageFile));
			
			// getting JSON Object
			// Note that create product url accepts POST method
			JSONObject json = jsonParser.makeHttpRequest(url_create_product,"POST", params);

			// check log cat fro response
			Log.d("Create Response", json.toString());

			// check for success tag
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// successfully created product
					Intent i = new Intent(getApplicationContext(), AllProductsActivity.class);
					startActivity(i);

					// closing this screen
					finish();
				} else {
					// failed to create product
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			pDialog.dismiss();
		}
		
		
		protected String BaseFileToString(String ImagePath){
			
			Bitmap bitmapOrg= BitmapFactory.decodeFile(ImagePath);				
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bitmapOrg.compress(Bitmap.CompressFormat.PNG, 90, stream); //compress to which format you want. 
			byte [] byte_arr = stream.toByteArray();     
			String image = Base64.encodeBytes(byte_arr);
			return image;
		}

	}
    public void onClickImg(View v) {
    	switch(v.getId()) {
    	case R.id.btnGiveSendPicture:
    		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
    		View customLayout = View.inflate(mContext, R.layout.custom_button, null);
    		builder.setView(customLayout);
    		dialog = builder.create();
    		dialog.show();
    		break;
    	case R.id.camera:
    		dialog.dismiss();
    		takePicture();
    		break;
    	case R.id.photoAlbum:
    		dialog.dismiss();
    		photoAlbum();
    		break;
    	
    	}
    }
    
    
  //사진 촬영
  	void takePicture() {
  		//카메라 호출 intent 생성
  		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
  		File file = new File(Environment.getExternalStorageDirectory(),SAMPLEIMG);
  		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
  		startActivityForResult(intent, REQUEST_PICTURE);
  	}
  	
  	//사진 불러오기
  	void photoAlbum() {
  		//photo Album 호출 intent 생성
  		Intent intent = new Intent(Intent.ACTION_PICK);
  		intent.setType(Images.Media.CONTENT_TYPE);
  		intent.setData(Images.Media.EXTERNAL_CONTENT_URI);
  		startActivityForResult(intent, REQUEST_PHOTO_ALBUM);
  	}
  	
  	
  	//촬영한 사진을 수정하기 위해서
  	Bitmap loadPicture() {
  		File file = new File(Environment.getExternalStorageDirectory(),SAMPLEIMG);
  		BitmapFactory.Options option = new BitmapFactory.Options();
  		option.inSampleSize = 4;
  		return BitmapFactory.decodeFile(file.getAbsolutePath(), option);
  	}
  	
  	
  	@Override
  	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  		// TODO Auto-generated method stub
  		super.onActivityResult(requestCode, resultCode, data);
  		
  		if(resultCode != RESULT_OK)
  			return ;
  		
  		if(requestCode == REQUEST_PICTURE) {
  			iv.setImageBitmap(loadPicture());
  		}
  		
  		if(requestCode == REQUEST_PHOTO_ALBUM) {
  			
  			selectedImageURI = data.getData();
  			giveProductImage.setImageURI(selectedImageURI);
  			ImageFilePath = getRealPathFromURI(selectedImageURI);  
  			giveImage = ImageFilePath;
  			
  		}
  	}
  	
  	
  	private String getRealPathFromURI(Uri contentURI) {     
  		
  		String[] proj = { MediaStore.Images.Media.DATA };
  		Cursor cursor = getContentResolver().query(contentURI, proj, null, null, null);
  		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
  		cursor.moveToFirst();     
  		//int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
  		return cursor.getString(column_index);
  		
  	}
private String jsonParser(String json){
		
		String tmpStr = "";
	     try {
		      //JSON String으로 부터 JSONArray 생성. [](대괄호)
		   JSONObject jobj = new JSONObject(json);
		   JSONArray jarray = jobj.getJSONArray("results");
		   JSONObject subjobj = jarray.getJSONObject(0);
		   JSONArray jarray2 = subjobj.getJSONArray("address_components");
		   String[] tmp = new String[jarray2.length()];
		   
		   /*
		   for(int i = 0; i < jarray.length(); i++){
		   		JSONObject jtmp = jarray.getJSONObject(i);
		   		tmpStr = jtmp.getString("formatted_address");
		   		tmpStr += "\n";
		   		tmpStr += jtmp.getString("long_name");
		   		tmpStr += "\n";
		   }
		   */
		   
		   for(int i = (jarray2.length() - 1); i >= 0; i--){
			     JSONObject jtmp = jarray2.getJSONObject(i);
			     tmp[i] = jtmp.getString("long_name");
			 if(i != 0){
			    tmpStr += tmp[i] + ",";
			 }
			 else{
			    tmpStr += tmp[i];
			  }
		   }

	   
		    
		  } catch (JSONException e) {
		   Toast.makeText(NewProductActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
		  }
		  return tmpStr;
	}
	
	public String getUrl(String str){
		 
		   BufferedReader  br   = null;
		   InputStreamReader isr   = null;
		   StringBuffer   sb   = null;
		 
		  try{
		 
			 URL  url   = new URL(str);
		    URLConnection  uCon  = url.openConnection();
		    isr           = new InputStreamReader(uCon.getInputStream(),"UTF-8");
		    br           = new BufferedReader(isr);
		    sb           = new StringBuffer();
		 
		   String     line;
		    while((line=br.readLine()) != null) sb.append(line).append("\n"); // 본문 코드에 주석이 // 로 되어 있으면 Enter 사용
		 
		  }catch(Exception e){
		   }finally{
		    if(isr!=null){ try{ isr.close(); }catch(Exception e){}finally{ isr=null; } }
		    if(br!=null){ try{ br.close(); }catch(Exception e){}finally{ br=null; } }
		    if(isr!=null){ try{ isr.close(); }catch(Exception e){}finally{ isr=null; } }
		   }
		 
		  return sb.toString();
		 }
}
```

**MainActivity.java**

```
package com.example.FoodMarketMain;

import com.example.Login.*;
import com.example.Map.*;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.graphics.drawable.Drawable;
import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MainActivity extends Activity implements View.OnClickListener {
//main page involving 3bottons and 2setup activity
	private static final int MENU_ITEM0 = 0;
	private static final int MENU_ITEM1 = 1;
	private TextView button1;
	private TextView button2;
	private TextView button3;
	private TextView button4;
	SimpleDateFormat sdf;
	Date CurDate;
	String strCurTime;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button1 = (TextView)findViewById(R.id.textview1);
        button2 = (TextView)findViewById(R.id.textview2);
        button3 = (TextView)findViewById(R.id.textview3);
        button4 = (TextView)findViewById(R.id.textview4);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		CurDate = new Date();
		strCurTime = sdf.format(CurDate);
		Log.d("date", strCurTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuItem item0 = menu.add(0, MENU_ITEM0, 0, "GPSsetting");
    	item0.setIcon(android.R.drawable.ic_dialog_map);
    	MenuItem item1 = menu.add(0, MENU_ITEM1, 0, "menu");
    	item1.setIcon(android.R.drawable.ic_menu_save);
        return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	if (item.getItemId() == MENU_ITEM0) {
		GPSTracker gps = new GPSTracker(MainActivity.this);
		if(gps.canGetLocation()){
			Context mContext = this;
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
			
			alertDialog.setNegativeButton("GPS is alreay working.", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            dialog.cancel();
	            }
	        });
	        alertDialog.show();
		}else{
			gps.showSettingsAlert();
		}
		return true;
	}
	else if(item.getItemId() ==  MENU_ITEM1){
		Intent intent=new Intent(
		"android.settings.SETTINGS");
		startActivity(intent);
		return true;
	}
	return true;
}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id == button1.getId()){
			Intent intent = new Intent(this, com.example.Products.NewProductActivity.class);
			startActivity(intent);			
		}
		else if(id == button2.getId()){
			Intent intent = new Intent(this, com.example.Map.googleMap.class);
			intent.putExtra("strCurTime", strCurTime);
			startActivity(intent);
		}
		
	}

	private static void showDialog(final Activity activity,
			String title,String text) {
			AlertDialog.Builder ad=new AlertDialog.Builder(activity);
			ad.setTitle(title);
			ad.setMessage(text);
			ad.setPositiveButton("OK",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int whichButton) {
					activity.setResult(Activity.RESULT_OK);
				}
			});
			ad.create();
			ad.show();
	}

}

```

**NoticeBoardActivity.java**

```
package com.example.NoticeBoard;


import com.example.parse.*;
import com.example.Login.*;
import com.example.parse.*;




import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;


import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.FoodMarketMain.*;
import com.example.Login.Base64;
import com.example.LoginLibrary.DatabaseHandler;
import com.example.parse.JSONParser;

import android.widget.CheckBox;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewBoardActivity extends Activity {

	// Progress Dialog
	private ProgressDialog pDialog;

	JSONParser jsonParser = new JSONParser();
	
	
	EditText BoardName, BoardDesc;
		
	Button btnCreatedAtBoard;

	
	Context mContext = this;
    
    
	// url to create new product    
	private static String url_create_product = LocalhostAdress.Adress + "/android_board/create_board.php";

	// JSON Node names
	private static final String TAG_SUCCESS = "success";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.board_create);
		
		
		// Edit Text
		BoardName = (EditText) findViewById(R.id.inputBoardName);
		BoardDesc = (EditText) findViewById(R.id.inputBoardDesc);
		
		btnCreatedAtBoard = (Button) findViewById(R.id.btnCreateBoard);
		
		// button click event
		btnCreatedAtBoard.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// creating new product in background thread
				new CreateNewBoard().execute();
			}
		});
	}

	/**
	 * Background Async Task to Create new product
	 * */
	class CreateNewBoard extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(NewBoardActivity.this);
			pDialog.setMessage("잠시만 기다려주세요..");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		/**
		 * Creating product
		 * */
		protected String doInBackground(String... args) {
			
			DatabaseHandler db = new DatabaseHandler(mContext);
			HashMap<String,String> user = new HashMap<String,String>();
			user = db.getUserDetails();
			
			String boardName = BoardName.getText().toString();
			String boardDesc = BoardDesc.getText().toString();
			
		
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			params.add(new BasicNameValuePair("user_id", (user.get("ID"))));
			params.add(new BasicNameValuePair("boardName", boardName));
			params.add(new BasicNameValuePair("boardDesc", boardDesc));
			
			
			// getting JSON Object
			// Note that create product url accepts POST method
			
			JSONObject json = jsonParser.makeHttpRequest(url_create_product,"POST", params);

			// check log cat fro response
			Log.d("Create Response", json.toString());

			// check for success tag
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// successfully created product
					Intent i = new Intent(getApplicationContext(), AllBoardsActivity.class);
					startActivity(i);

					// closing this screen
					finish();
				} else {
					// failed to create product
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			pDialog.dismiss();
		}
		
		
		

	}
  	
}
```
# 출처 #
http://www.androidhive.info/
Androidhive에서 제시된 기능과 책을 참조해 가면서 이 프로젝트에 필요한 것만 선별 하여 연결하였습니다.

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages