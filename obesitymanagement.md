# INTRODRUCTION #

![http://comp166-koreauniv.googlecode.com/files/obesity1.jpg](http://comp166-koreauniv.googlecode.com/files/obesity1.jpg)

비만도, 체지방율, 복부비만율 등을 계산하여, 본인의 상태를 측정한 후, 그에 따른 운동, 식단 등을 알려주는 **비만 관리 프로그램\*입니다.**

# BACKGROUND #

![http://comp166-koreauniv.googlecode.com/files/obesity2.jpg](http://comp166-koreauniv.googlecode.com/files/obesity2.jpg)

요즈음 남자, 여자 성별 구분 없이 살에 굉장히 민감합니다.
비만은 보는 사람에게 호감도를 떨어뜨릴 뿐만 아니라 다양한 질병을 유발시킵니다.
그래서 우리들의 몸을 건강하게 하고 비만이 얼마나 무서운지 알려줄 수 있는 프로그램을 만들어보자는 취지로 **[비만 관리 프로그램]**을 기획했습니다.
키와 몸무게를 이용하여 비만도와 체지방율 그리고 복부비만율을 계산하여 본인의 비만 정도를 확인시켜주고 그에 따른 발생할 수 있는 질병과 다이어트방법을 알려주는 **[비만 관리 프로그램]**을 만들 것입니다.

# REQUIREMENT #

## 1) 비만도 계산 ##
- 비만도 : (현재 체중/표준 체중)×100(%)


- 표준체중


①남자 : 키(m)×키(m)×22


②여자 : 키(m)×키(m)×21


- 결과


①±10% : 정상


②10~20% : 체중 과다


③20% 이상 : 비만

## 2)체지방율 계산 ##
- 체질량 지수 : 체중(kg) / 신장(cm) **신장(cm)**


- 결과


①보통 남성 : 15~20%


②보통 여성 : 20~25%

## 3)복부비만율 계산 ##
- 복부비만율 : 허리둘레(inch)/엉덩이둘레(inch)


- 결과


①보통 남성 : 0.95 ~ 1


②보통 여성 : 0.7 ~ 0.85

## 4)음식 칼로리 ##
> 계산기를 이용해 사용자가 칼로리를 계산합니다. 계산기 아래편에 있는 help를 통해 음식 칼로리를 참조할 수 있습니다.

## 5)운동 ##
> 복부와 전체적인 몸매에 가장 좋은 운동을 선택하였습니다.


# PROJECT #
![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-29-30.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-29-30.png)

```
/*비만을 관리해주는 비만 관리 프로그램(Diet Partner)입니다.*/

//mainActivity입니다.

package org.androidtown.dietpartner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Button start = (Button)findViewById(R.id.starBtn);
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, NameActivity.class);
				startActivity(intent);
				
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

------------------------------------------------------------------------
//성별과 이름을 입력하는 nameActivity입니다.

package org.androidtown.dietpartner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class NameActivity extends Activity {
	
	public static final int REQUEST_CODE_ANOTHER = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(getBaseContext(), MenuActivity.class);
        		startActivity(intent);
        		//startActivityForResult(intent, REQUEST_CODE_ANOTHER);
        	}
        });
        
        CheckBox man = (CheckBox) findViewById(R.id.man);
        man.setOnCheckedChangeListener(new OnCheckedChangeListener(){
        	
        	public void onCheckedChanged(CompoundButton buttonView,

                    boolean isChecked) {

            /*    if (buttonView.getId() == R.id.man) {

                    if (isChecked) {

                        Toast.makeText(getApplicationContext(), "눌림", 1).show();

                    } else {

                        Toast.makeText(getApplicationContext(), "안눌림", 1).show();

                    }

        } */
        	}
        });
        CheckBox woman = (CheckBox) findViewById(R.id.woman);
        woman.setOnCheckedChangeListener(new OnCheckedChangeListener(){
        	
        	public void onCheckedChanged(CompoundButton buttonView,

                    boolean isChecked) {

            /*    if (buttonView.getId() == R.id.woman) {

                    if (isChecked) {

                        Toast.makeText(getApplicationContext(), "눌림", 1).show();

                    } else {

                        Toast.makeText(getApplicationContext(), "안눌림", 1).show();

                    }

        } */
        	}
        });
        
        
    }

    /* protected void onActivityResult(int requesCode, int resultCode, Intent Data) {
    	super.onActivityResult(requestCode, resultCode, Data);
    	
    	if (requestCode = REQUEST_CODE_ANOTHER) {
    		Toast toast = Toast.makeText(getBaseContext(),
    				"onActivityResult 메소드가 호출됨. 요청 코드 : " + requestCode
    				+ ", 결과 코드 :" + resultCode,
    				Toast.LENGTH_LONG);
    		toast.show();
    		
    		if (resultCode = RESULT_OK) {
    			String name = data.getExtras().getString("name");
    			toast = Toast.makeText(getBaseContext(),
    					"응답으로 전달된 name :" + name, Toast.LENGTH_LONG);
    			toast.show();
    		}
    	}
    } */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

------------------------------------------------------------------------
//체중, 음식, 운동을 선택하는 menuActivity입니다.

package org.androidtown.dietpartner;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuActivity extends Activity {

	protected static final int REQUEST_CODE_ANOTHER = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		LinearLayout menuLayout = (LinearLayout) findViewById(R.id.layout);
		//menuLayout.setOrientation(LinearLayout.VERTICAL);
		
		/*LinearLayout.LayoutParams params =
				new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.FILL_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
		*/
		
		Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(getBaseContext(), WeightActivity.class);
				startActivity(intent);
        	}
        });
		
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent2 = new Intent(MenuActivity.this, FoodActivity.class);
        		startActivity(intent2);
        	}
        });
        
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent3 = new Intent(MenuActivity.this, ExerciseoftwoActivity.class);
        		startActivity(intent3);
        	}
        });
        
        
		
		/* Button button1 = new Button(this);
		button1.setText("체중");
		button1.setLayoutParams(params);
		menuLayout.addView(button1); 
		
		Button button2 = new Button(this);
		button2.setText("음식");
		button2.setLayoutParams(params);
		menuLayout.addView(button2);
		
		Button button3 = new Button(this);
		button3.setText("운동");
		button3.setLayoutParams(params);
		menuLayout.addView(button3); */
		
		//
        
        setContentView(R.layout.activity_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}

------------------------------------------------------------------------
// menuActivity에서 체중을 선택했을 때, weightActivity입니다.
package org.androidtown.dietpartner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeightActivity extends Activity {
	/** Called when the activity is first created. */

	protected static final int REQUEST_CODE_ANOTHER = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(WeightActivity.this, WeightoftwoActivity.class);
				startActivity(intent);
			}
		});
	}

	public void calculateClickHandler(View view) {
		// make sure we handle the click of the calculator button

		if (view.getId() == R.id.button1) {

			// get the references to the widgets
			EditText weightText = (EditText) findViewById(R.id.editText1);
			EditText heightText = (EditText) findViewById(R.id.editText2);

			// get the users values from the widget references

			float weight = Float.parseFloat(weightText.getText().toString());
			float height = Float.parseFloat(heightText.getText().toString());

			// calculate the bmi value

			float bmiValue = calculateBMI(weight, height);
			float bfrValue = calculateBFR(weight, height);

			
			EditText hipsText = (EditText) findViewById(R.id.editText3);
			EditText waistText = (EditText) findViewById(R.id.editText4);


			// get the users values from the widget references
			float hips = Float.parseFloat(hipsText.getText().toString());
			float waist = Float.parseFloat(waistText.getText().toString());

			// calculate the bor value
			float borValue = calculateBOR(hips, waist);
			
			String bmiInterpretation = interpretBMI(bmiValue);
			String bfrInterpretation = interpretBFR(bfrValue);
			String borInterpretation = interpretBOR(bfrValue);

			// now set the value in the result text

		}
	}

	private String interpretBOR(float borValue) {
		// TODO Auto-generated method stub
		if ( 0.95 <= borValue <= 1 ) {
			return "normal";
		} else if (borValue < 0.95) {
			return "abnormal";
		}
	}

	private String interpretBFR(float bfrValue) {
		
		if (15 <= bfrValue <= 20 ) {
			return "normal";
		} else if (bfrValue < 15 && brfValue > 20) {
			return "abnormal";
		}
			
		
	}

	private float calculateBOR(float hips, float waist) {
		// TODO Auto-generated method stub
		return (float) ( waist / hips );
	}

	// the formula to calculate the BMI index

	private float calculateBFR(float weight, float height) {
		// TODO Auto-generated method stub
		return (float) ( weight  / (height * height));
	}

	// check for http://en.wikipedia.org/wiki/Body_mass_index
	private float calculateBMI(float weight, float height) {

		return (float) (weight * 4.88 / (height * height));
	}

	// interpret what BMI means
	private String interpretBMI(float bmiValue) {

		if (bmiValue < 16) {
			return "Severely underweight";
		} else if (bmiValue < 18.5) {

			return "Underweight";
		} else if (bmiValue < 25) {

			return "Normal";
		} else if (bmiValue < 30) {

			return "Overweight";
		} else {
			return "Obese";
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight, menu);
		return true;
	}

}
-----------------------------------------------------------------------
//입력결과를 나타내는 weightofwtwoactivity입니다.

-----------------------------------------------------------------------
//menuactivity에서 음식을 선택했을 때 foodactivity입니다.

 package org.androidtown.dietpartner;

 import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

 public class FoodActivity extends Activity 
 {
	 
	 private boolean first = true;    //최초일때 :true
		private double hap = 0.0;        //초기값
		private char yon = '+';          //초기 연산자의 값
		private boolean jumpress = false;//점 버튼을 누르지 않은 상태 : false
		TextView result;
		/** Called when the activity is first created. */
	 @Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_weightoftwo);
			
			LinearLayout menuLayout = (LinearLayout) findViewById(R.id.layout);
			//menuLayout.setOrientation(LinearLayout.VERTICAL);
			
			/*LinearLayout.LayoutParams params =
					new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.FILL_PARENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
			*/
			
			Button button1 = (Button) findViewById(R.id.help);
	        button1.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View v) {
	        		Intent intent = new Intent(getBaseContext(), FoodoneActivity.class);
					startActivity(intent);
	        	}
	        });
			
	        // 결과값을 표시하는 TextView
	        result = (TextView)findViewById(R.id.result);
	        result.setText("0.");
	        
	        // 버튼의 클릭 이벤트를 받음
	        findViewById(R.id.back).setOnClickListener(mClickListener);
	        findViewById(R.id.help).setOnClickListener(mClickListener);

	        findViewById(R.id.button0).setOnClickListener(mClickListener);
	        findViewById(R.id.button1).setOnClickListener(mClickListener);
	        findViewById(R.id.button2).setOnClickListener(mClickListener);
	        findViewById(R.id.button3).setOnClickListener(mClickListener);
	        findViewById(R.id.button4).setOnClickListener(mClickListener);
	        findViewById(R.id.button5).setOnClickListener(mClickListener);
	        findViewById(R.id.button6).setOnClickListener(mClickListener);
	        findViewById(R.id.button7).setOnClickListener(mClickListener);
	        findViewById(R.id.button8).setOnClickListener(mClickListener);
	        findViewById(R.id.button9).setOnClickListener(mClickListener);
	        findViewById(R.id.plus).setOnClickListener(mClickListener);
	        findViewById(R.id.minus).setOnClickListener(mClickListener);
	        findViewById(R.id.multiple).setOnClickListener(mClickListener);
	        findViewById(R.id.divide).setOnClickListener(mClickListener);
	        findViewById(R.id.equal).setOnClickListener(mClickListener);        
	        findViewById(R.id.dot).setOnClickListener(mClickListener);
	        
	    }

		
	    // 클릭 이벤트 발생시
	    Button.OnClickListener mClickListener = new Button.OnClickListener() {
	    	public void onClick(View v) {
	    		
	    		// 버튼을 누르면 짧은 진동을 발생
	    		Vibrator vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
	    		vibe.vibrate(25);
	   		    		
	    		switch(v.getId()) {
	    		case R.id.back:
	    			backPress();
	    			break;
	    		case R.id.help:
	    			result.setText("0.");
	    			jumpress = false;
	    			first = true;
	    			break;    		
	    		case R.id.button0:
	    			numPress("0");
	    			break;
	    		case R.id.button1:
	    			numPress("1");
	    			break;
	    		case R.id.button2:
	    			numPress("2");
	    			break;
	    		case R.id.button3:
	    			numPress("3");
	    			break;
	    		case R.id.button4:
	    			numPress("4");
	    			break;
	    		case R.id.button5:
	    			numPress("5");
	    			break;
	    		case R.id.button6:
	    			numPress("6");
	    			break;
	    		case R.id.button7:
	    			numPress("7");
	    			break;
	    		case R.id.button8:
	    			numPress("8");
	    			break;
	    		case R.id.button9:
	    			numPress("9");
	    			break;
	    		case R.id.plus:
	    			yonsanPress("+");
	    			break;
	    		case R.id.minus:
	    			yonsanPress("-");
	    			break;
	    		case R.id.multiple:
	    			yonsanPress("*");
	    			break;
	    		case R.id.divide:
	    			yonsanPress("/");
	    			break;
	    		case R.id.equal:
	    			yonsanPress("=");
	    			break;    		
	    		case R.id.dot:
	    			jumpress = true;
	    			first = false;
	    			break;   
	    		}
	    		
	    	}
	    };
	    
	    // BackSpace 버튼이 눌렸을때
	    public void backPress()    {
			String str = ((String)result.getText()).trim();
			if(str.length() == 2){
				result.setText("0.");
				jumpress = false;
				first = true;
				return;
			}
			if(jumpress){
				if(str.charAt(str.length() - 1) == '.'){
					jumpress = false;
					return;
				}
				else{
					str = str.substring(0, str.length() - 1);
					result.setText(str);
					return;
				}
			}
			else{
				str = str.substring(0, str.length() - 2);
				result.setText(str + ".");
				return;
			}    	
	    }
	    
	    // 0~9 숫자버튼이 눌렸을때
	    public void numPress(String btn_str)   {
			if(first){//first : 최초의 상태인지를 체크..
				if(btn_str.equals("0")){
					result.setText(btn_str.trim() + ".");
					return;
				}
				result.setText(btn_str.trim() + ".");
				first = false;
			}
			else{//최초가 아니라면...
				String str = ((String)result.getText()).trim();
				if(jumpress){
					str += btn_str.trim();
					result.setText(str);
				}
				else{
					str = str.substring(0, str.trim().length() - 1);
					str += (btn_str.trim() + ".");
					result.setText(str);
				}
			}
	    }

	    // 연산버튼이 눌렸을때
	    public void yonsanPress(String btn_str) {
			if(first && !btn_str.equals("=")){
				yon = btn_str.charAt(0);
				return;
			}
			double susu = Double.parseDouble(((String)result.getText()).trim());
			switch(yon){
			case '+': hap += susu; break;
			case '-': hap -= susu; break;
			case '*': hap *= susu; break;
			case '/': hap /= susu; break;
			}
			if(!btn_str.equals("=")){
				yon = btn_str.charAt(0);
			}
			double ii = hap - (int)hap;//소수점 이하의 값이 있는지 없는지 체크..
			if(ii == 0){
				result.setText(String.valueOf((int)hap) + ".");
			}
			else{
				result.setText(String.valueOf(hap));
			}
			if(btn_str.equals("=")){
				hap = 0.0;
				yon = '+';
			}    	
			first = true;
			jumpress = false;//점 버튼을 누르지 않은 초기 상태로 바꾼다...
	    }

	    // 부호 버튼이 눌렸을때
	    public void signPress(){
			if(first){
				result.setText("0.");
				return;
			}
			String str = ((String)result.getText()).trim();
			if(str.charAt(0) == '-'){
				str = str.substring(1);
				result.setText(str);
			}
			else{
				str = "-" + str;
				result.setText(str);
			}
		}


		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.weightoftwo, menu);
			return true;
		}

	} 
------------------------------------------------------------------------
//foodactivity에서 help를 눌렀을 때 foodone,two,th activity입니다.

package org.androidtown.dietpartner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FoodoneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodone);
    
        Button start = (Button)findViewById(R.id.starBtn);
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FoodoneActivity.this, FoodtwoActivity.class);
				startActivity(intent);
				
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
package org.androidtown.dietpartner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FoodtwoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodone);
    
        Button start = (Button)findViewById(R.id.starBtn);
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FoodtwoActivity.this, FoodthActivity.class);
				startActivity(intent);
				
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
package org.androidtown.dietpartner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FoodthActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodone);
    
        Button start = (Button)findViewById(R.id.starBtn);
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FoodthActivity.this, FoodActivity.class);
				startActivity(intent);
				
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
------------------------------------------------------------------------
//menuactivity에서 운동을 눌렀을 때 exerciseoftwoactivity입니다.

package org.androidtown.dietpartner;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ExerciseoftwoActivity extends Activity {

	protected static final int REQUEST_CODE_ANOTHER = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exerciseoftwo);
		
		Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(ExerciseoftwoActivity.this, ExercisebasiconeActivity.class);
        		startActivity(intent);
        	}
        });
        
        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(getBaseContext(), ExerciseadvancedActivity.class);
        		startActivity(intent);
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exerciseoftwo, menu);
		return true;
	}

}
------------------------------------------------------------------------
exerciseactivity에서 기본적인 동작을 눌렀을 때 exercisebsiconeactivity입니다.
package org.androidtown.dietpartner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ExercisebasiconeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercisebasicone);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exercisebasicone, menu);
		return true;
	}

}
-----------------------------------------------------------------------
//menuactivity에서 어려운동작을 눌렀을 때 exerciseadvanced two,threeactivity입니다.

package org.androidtown.dietpartner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ExerciseadvancedActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Button start = (Button)findViewById(R.id.starBtn);
        
        start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ExerciseadvancedActivity.this, ExerciseadvancedtwoActivity.class);
				startActivity(intent);
				
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
package org.androidtown.dietpartner;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ExerciseadvancedtwoActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Button start = (Button)findViewById(R.id.starBtn);
        
        start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ExerciseadvancedtwoActivity.this, ExerciseadvancedthreeActivity.class);
				startActivity(intent);
				
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
package org.androidtown.dietpartner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ExerciseadvancedthreeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exerciseadvancedthree);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exerciseadvancedthree, menu);
		return true;
	}

}


```

# RESULT #
## 1. 성별&이름입력하는 화면 ##

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-29-41.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-29-41.png)

## 2. menu 선택 ##

![http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-29-48.png](http://comp166-koreauniv.googlecode.com/files/Screenshot_2013-12-10-00-29-48.png)

## 3. 체중을 선택했을 때 화면 ##
## 4. 체중 결과를 알려주는 화면 ##
## 5. 음식을 선택했을 때 화면 ##
## 6. HELP를 눌렀을 때 화면 ##
![http://comp166-koreauniv.googlecode.com/files/음식칼로리.png](http://comp166-koreauniv.googlecode.com/files/음식칼로리.png)
## 7. 운동을 선택했을 때 화면 ##
![http://comp166-koreauniv.googlecode.com/files/weightmeny.png](http://comp166-koreauniv.googlecode.com/files/weightmeny.png)

-어려운동작-
![http://comp166-koreauniv.googlecode.com/files/어려운동작.png](http://comp166-koreauniv.googlecode.com/files/어려운동작.png)