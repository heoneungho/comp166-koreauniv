# Introduction #

숫자 야구게임을 하는 앱입니다.
위드캣 엠티때 이 게임을 처음 배웠는데 시간이 없어서 코드는 짜보지를 못했습니다. 이번에 자바로 숫자 야구게임을 하는 앱을 만들어보려고 합니다.

playstore에 나온 기존의 야구게임앱은 '대결 숫자야구', '숫자야구' 2개의 앱이 있는데 이 앱 모두 3자리 숫자만 가능 한 앱입니다.

저는 4자리, 5자리 숫자도 할 수 있도록 개임을 개발하겠습니다.


# 어플 내용 #

1. 처음 시작화면입니다.

![http://comp166-koreauniv.googlecode.com/files/homeeeeemememe.png](http://comp166-koreauniv.googlecode.com/files/homeeeeemememe.png)

2. start를 누르면 stage가 3개가 나타납니다.
stage1는 3자리 숫자, stage2는 4자리 숫자, stage3는 5자리 숫자를 맞추는 게임입니다.

![http://comp166-koreauniv.googlecode.com/files/stageeeeeeeeee.png](http://comp166-koreauniv.googlecode.com/files/stageeeeeeeeee.png)

3.stage1 입니다. 빈칸 3개에 서로 다른 숫자를 입력하면 됩니다.

![http://comp166-koreauniv.googlecode.com/files/threecan.png](http://comp166-koreauniv.googlecode.com/files/threecan.png)

3-2. 입력 한 모양입니다.

![http://comp166-koreauniv.googlecode.com/files/11input.png](http://comp166-koreauniv.googlecode.com/files/11input.png)

3-3. 입력을 했을때 결과를 알려줍니다. 0strike 1ball 2out 이네요

![http://comp166-koreauniv.googlecode.com/files/11회결말.png](http://comp166-koreauniv.googlecode.com/files/11회결말.png)

3-4. 게임은 10번 까지 할수 있고 이 게임에서는 4판만에 이겼습니다.

![http://comp166-koreauniv.googlecode.com/files/gameoverrrrrrr.png](http://comp166-koreauniv.googlecode.com/files/gameoverrrrrrr.png)

3-5. 게임을 이기면 결과가 뜹니다.

![http://comp166-koreauniv.googlecode.com/files/winandresult.png](http://comp166-koreauniv.googlecode.com/files/winandresult.png)

4.stage2 입니다. 빈칸 4개에 서로 다른 숫자를 입력하면 됩니다.

![http://comp166-koreauniv.googlecode.com/files/fourcan.png](http://comp166-koreauniv.googlecode.com/files/fourcan.png)

5.stage3 입니다. 빈칸 5개에 서로 다른 숫자를 입력하면 됩니다.

![http://comp166-koreauniv.googlecode.com/files/fivecan.png](http://comp166-koreauniv.googlecode.com/files/fivecan.png)

6.help 입니다. 게임방법이 소개되어있습니다.

![http://comp166-koreauniv.googlecode.com/files/helppppppppppppppppp.png](http://comp166-koreauniv.googlecode.com/files/helppppppppppppppppp.png)

# class #
1.class는 다음과 같이 6개로 나누어져 있습니다.


# MainActivity.java #

```

package com.example.minsbaseballgame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView button = (ImageView) findViewById(R.id.imageView3);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), START.class);
				startActivity(intent);
			}
		}); // start를누르면 stage가 뜨는 화면으로 넘어가게 하는 버튼생성
		ImageView button1 = (ImageView) findViewById(R.id.imageView2);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), HELP.class);
				startActivity(intent);
			}// help를 누르면 help 화면이 뜨는 화면으로 넘어가게 하는 버튼 생성
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

```
# START.java #

```

package com.example.minsbaseballgame;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class START extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		ImageView button2 = (ImageView) findViewById(R.id.imageView1);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), STAGE1.class);
				startActivity(intent);
			}
		});//stage1 을 누를때 stage1 화면으로 이동하는 버튼 생성

		ImageView button3 = (ImageView) findViewById(R.id.imageView2);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), STAGE2.class);
				startActivity(intent);
			}
		});//stage2 를 누를때 stage2 화면으로 이동하는 버튼 생성
		ImageView button4 = (ImageView) findViewById(R.id.imageView5);
		button4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), STAGE3.class);
				startActivity(intent);
			}
		});//stage3를 누를때 stage3 화면으로 이동하는 버튼 생성
	}

		


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}

```

# Stage1.java #

```
package com.example.minsbaseballgame;

import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class STAGE1 extends Activity {
    private static final int DIALOG_NEW_YES_NO = 1;
    
    TextView tvResult;
    TextView TextViewValue[] = new TextView[3];
    int com_Array[] = new int[3];
    int resut_arr[] = new int[3];
    int play_cnt, inputPos;
    boolean isPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage1);

        TextViewValue[0] = (TextView) findViewById(R.id.TextViewValue1);
        TextViewValue[1] = (TextView) findViewById(R.id.TextViewValue2);
        TextViewValue[2] = (TextView) findViewById(R.id.TextViewValue3);
        tvResult = (TextView) findViewById(R.id.TextViewAttack2);

        // 초기화
        init_com();

    }
    
    
    // <- 백스페이스 버튼이 클릭되었을때 호출되는 메서드
    public void clickBtnDelListener(View target) {

        /*
        * for(int i=2;i>=0;i--){
              if(TextViewValue[i].getText().toString().trim().length()==1){
                  TextViewValue[i].setText(" "); break; 
              } 
          }
         */

        /*
          if(TextViewValue[2].getText().toString().trim().length()==1){
              TextViewValue[2].setText(" "); 
          }else if(TextViewValue[1].getText().toString().trim().length()==1){
              TextViewValue[1].setText(" ");
          }else if(TextViewValue[0].getText().toString().trim().length()==1){
              TextViewValue[0].setText(" ");
          }
         */

        if (inputPos > 0) {
            if (TextViewValue[--inputPos].getText().toString().trim().length() == 1) {
                TextViewValue[inputPos].setText(" ");
            }
        }
    }

    //숫자 버튼을 클릭되었을때 호출되는 메서드
    public void clickBtnNumListener(View target) {

        Button btnNum = ((Button) target);
        String strNum = btnNum.getText().toString();

        /*
        for (TextView v : TextViewValue) {
            if (v.getText().toString().trim().equals(strNum)) {
                return;
            }
        }*/ 

        // TextViewValue[0].setText(strNum);
        
        /*
        if (TextViewValue[0].getText().toString().trim().length() != 1) {
            TextViewValue[0].setText(strNum);
        } else if (TextViewValue[1].getText().toString().trim().length() != 1) {
            TextViewValue[1].setText(strNum);
        } else if (TextViewValue[2].getText().toString().trim().length() != 1) {
            TextViewValue[2].setText(strNum);
            Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
                    Toast.LENGTH_SHORT).show();
        }*/
         

        if (isPlay) {
            if (inputPos < 3) {

                for (TextView v : TextViewValue) {
                    if (v.getText().toString().trim().equals(strNum)) {
                        return;
                    }
                }
                TextViewValue[inputPos].setText(strNum);
                inputPos++;

            } else {
                Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
                    Toast.LENGTH_SHORT).show();
        }

    }

    //새게임 버튼이 클릭되었을때 호출되는 메서드
    public void clickBtnNewListener(View target) {
        init_com();
    }

    
    //게임 초기화
    public void init_com() {

        play_cnt = 0; // 공격횟수 초기화;
        for (TextView v : TextViewValue) {
            v.setText(" ");
        }
        // 중복되지 않는 3개의 난수 저장.
        int i = 0;
        do {
            // int r = (int)(Math.random()*9)+1;
            int r = (int) (Math.random() * 10);
            com_Array[i] = r;

            for (int j = 0; j < i; j++) { // 중복되는 값 검사.
                if (com_Array[i] == com_Array[j]) {
                    i--; // 중복값이 있으면 i변수를 -1.
                    break; // 반복문 종료
                }// if
            }// for

            i++;

        } while (i < 3); // 3회전

        // 기존에 있는 결과값 클리어
        tvResult.setText("");
        // tvResult.append(Arrays.toString(com_Array));
        tvResult.append("\n");
        tvResult.setText("새 게임을 시작합니다.\n");
        tvResult.append("공격할 숫자 3개를 선택하시고 [공격] 버튼을 눌러주세요!\n");
        inputPos = 0;
        play_cnt = 0;
        isPlay = true;

    }
    
    
    //공격버튼을 눌렀을때 호출되는 메서드
    public void attack(View target) {

        resut_arr = new int[3]; // 결과 초기화

        if (isPlay) {
            // 입력값 체크 (입력받은 숫자가 3개가 아니면 메시지창 출력)
            if (inputPos != 3) {
                Toast.makeText(getApplicationContext(), "공격할 숫자 3개를 선택해주세요!",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            
            int user_Array[] = new int[3];            
            for (int i = 0; i < TextViewValue.length; i++) {
                user_Array[i] = Integer.parseInt(TextViewValue[i].getText()
                        .toString());
            }

            // 결과 검사
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (com_Array[i] == user_Array[j]) {
                        if (i == j) { // 서로 같은 숫자가 있고 그 숫자의 자리가 같으면 스트라이크 처리
                            resut_arr[0]++; // 스트라이크
                        } else { // 서로 같은 숫자가 있고 그 숫자의 자리가 다르면 볼 처리
                            resut_arr[1]++; // 볼
                        }// if
                    }// if
                }// for
            }// for

            // 아웃 계산
            resut_arr[2] = 3 - (resut_arr[0] + resut_arr[1]); // 아웃!
            
            // 입력값을 표시하는 텍스트필드 초기화
            for (TextView v : TextViewValue) {
                v.setText(" ");
            }
            inputPos = 0;
            
            play_cnt++;// 플레이 카운트 증가
            
            // 결과값 출력
            String strResult = play_cnt + "회전: " + Arrays.toString(user_Array)
                    + "  " + resut_arr[0] + " Strike!!   " + resut_arr[1]
                    + " Ball!!   " + resut_arr[2] + " Out!! \n";

            //tvResult.append(strResult);
            appendResult(strResult);
            
            
            if (resut_arr[0] == 3) {        
                
                /*
                  Toast.makeText(getApplicationContext(), "You Win!!", 
                  Toast.LENGTH_SHORT).show();
                 */
                //tvResult.append("You Win!!\n\n");
                
                appendResult("You Win!!\n\n");
                isPlay = false;
                dialogNewGame("You Win!!").show();

            }// if

            if (play_cnt == 9) { // 한경기에 9회전까지                
                /*
                 Toast.makeText(getApplicationContext(), "You Lose!!",
                 Toast.LENGTH_SHORT).show();
                 */                
                //tvResult.append("You Lose!!\n\n");
                // showDialog(DIALOG_NEW_YES_NO);
                
                appendResult("You Lose!!\n\n");
                isPlay = false;
                dialogNewGame("You Lose!!").show();

            }// if            

            //ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
            //result_scrollView.scrollTo(0, tvResult.getHeight());
            
        } else {
            Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
                    Toast.LENGTH_SHORT).show();
        }//if
        
        
        
        
    }//attack();
    
    
    
    public void appendResult(String str){
        tvResult.append(str);
        ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
        result_scrollView.scrollTo(0, tvResult.getHeight());
    }//결과 뷰에 결과 출력
    
    
    
   
    public Dialog dialogNewGame(String result) {

        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결과")
                .setMessage(result + "\n게임을 새로 시작하시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("예", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        init_com();

                    }

                })
                .setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
                                result_scrollView.scrollTo(0, tvResult.getHeight());
                                dialog.cancel();
                            }

                        });

        AlertDialog alert = builder.create();

        return alert;
    } //대화상자 생성

}

```

# stage2.java #

```
package com.example.minsbaseballgame;

import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class STAGE2 extends Activity {
	private static final int DIALOG_NEW_YES_NO = 1;

	TextView tvResult;
	TextView TextViewValue[] = new TextView[4];
	int com_Array[] = new int[4];
	int resut_arr[] = new int[4];
	int play_cnt, inputPos;
	boolean isPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stage2);

		TextViewValue[0] = (TextView) findViewById(R.id.TextViewValue1);
		TextViewValue[1] = (TextView) findViewById(R.id.TextViewValue2);
		TextViewValue[2] = (TextView) findViewById(R.id.TextViewValue3);
		TextViewValue[3] = (TextView) findViewById(R.id.TextViewValue4);
		tvResult = (TextView) findViewById(R.id.TextViewAttack2);

		// 초기화
		init_com();

	}

	// <- 백스페이스 버튼이 클릭되었을때 호출되는 메서드
	public void clickBtnDelListener(View target) {

		/*
		 * for(int i=3;i>=0;i--){
		 * if(TextViewValue[i].getText().toString().trim().length()==1){
		 * TextViewValue[i].setText(" "); break; } }
		 */

		/*
		 * if(TextViewValue[3].getText().toString().trim().length()==1{
		 * TextViewValue[3].setText(" "); }else
		 * if(TextViewValue[2].getText().toString().trim().length()==1){
		 * TextViewValue[2].setText(" "); }else
		 * if(TextViewValue[1].getText().toString().trim().length()==1){
		 * TextViewValue[1].setText(" "); }else
		 * if(TextViewValue[0].getText().toString().trim().length()==1){
		 * TextViewValue[0].setText(" "); }
		 */

		if (inputPos > 0) {
			if (TextViewValue[--inputPos].getText().toString().trim().length() == 1) {
				TextViewValue[inputPos].setText(" ");
			}
		}
	}

	// 숫자 버튼을 클릭되었을때 호출되는 메서드
	public void clickBtnNumListener(View target) {

		Button btnNum = ((Button) target);
		String strNum = btnNum.getText().toString();

		/*
		 * for (TextView v : TextViewValue) { if
		 * (v.getText().toString().trim().equals(strNum)) { return; } }
		 */

		// TextViewValue[0].setText(strNum);

		/*
		 * if (TextViewValue[0].getText().toString().trim().length() != 1) {
		 * TextViewValue[0].setText(strNum); } else if
		 * (TextViewValue[1].getText().toString().trim().length() != 1) {
		 * TextViewValue[1].setText(strNum); } else if
		 * (TextViewValue[2].getText().toString().trim().length() != 1) {
		 * TextViewValue[2].setText(strNum); } else if
		 * (TextViewValue[3].getText().toString().trim().length() != 1) {
		 * TextViewValue[3].setText(strNum);
		 * Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
		 * Toast.LENGTH_SHORT).show(); }
		 */

		if (isPlay) {
			if (inputPos < 4) {

				for (TextView v : TextViewValue) {
					if (v.getText().toString().trim().equals(strNum)) {
						return;
					}
				}
				TextViewValue[inputPos].setText(strNum);
				inputPos++;

			} else {
				Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
						Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
					Toast.LENGTH_SHORT).show();
		}

	}

	// 새게임 버튼이 클릭되었을때 호출되는 메서드
	public void clickBtnNewListener(View target) {
		init_com();
	}

	// 게임 초기화
	public void init_com() {

		play_cnt = 0; // 공격횟수 초기화;
		for (TextView v : TextViewValue) {
			v.setText(" ");
		}
		// 중복되지 않는 4개의 난수 저장.
		int i = 0;
		do {
			// int r = (int)(Math.random()*9)+1;
			int r = (int) (Math.random() * 10);
			com_Array[i] = r;

			for (int j = 0; j < i; j++) { // 중복되는 값 검사.
				if (com_Array[i] == com_Array[j]) {
					i--; // 중복값이 있으면 i변수를 -1.
					break; // 반복문 종료
				}// if
			}// for

			i++;

		} while (i < 4); // 4회전

		// 기존에 있는 결과값 클리어
		tvResult.setText("");
		// tvResult.append(Arrays.toString(com_Array));
		tvResult.append("\n");
		tvResult.setText("새 게임을 시작합니다.\n");
		tvResult.append("공격할 숫자 4개를 선택하시고 [공격] 버튼을 눌러주세요!\n");
		inputPos = 0;
		play_cnt = 0;
		isPlay = true;

	}

	// 공격버튼을 눌렀을때 호출되는 메서드
	public void attack(View target) {

		resut_arr = new int[4]; // 결과 초기화

		if (isPlay) {
			// 입력값 체크 (입력받은 숫자가 4개가 아니면 메시지창 출력)
			if (inputPos != 4) {
				Toast.makeText(getApplicationContext(), "공격할 숫자 4개를 선택해주세요!",
						Toast.LENGTH_SHORT).show();
				return;
			}

			int user_Array[] = new int[4];
			for (int i = 0; i < TextViewValue.length; i++) {
				user_Array[i] = Integer.parseInt(TextViewValue[i].getText()
						.toString());
			}

			// 결과 검사
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (com_Array[i] == user_Array[j]) {
						if (i == j) { // 서로 같은 숫자가 있고 그 숫자의 자리가 같으면 스트라이크 처리
							resut_arr[0]++; // 스트라이크
						} else { // 서로 같은 숫자가 있고 그 숫자의 자리가 다르면 볼 처리
							resut_arr[1]++; // 볼
						}// if
					}// if
				}// for
			}// for

			// 아웃 계산
			resut_arr[3] = 4 - (resut_arr[0] + resut_arr[1]+resut_arr[2]); // 아웃!

			// 입력값을 표시하는 텍스트필드 초기화
			for (TextView v : TextViewValue) {
				v.setText(" ");
			}
			inputPos = 0;

			play_cnt++;// 플레이 카운트 증가

			// 결과값 출력
			String strResult = play_cnt + "회전: " + Arrays.toString(user_Array)
					+ "  " + resut_arr[0] + " Strike!!   " + resut_arr[1]
					+ " Ball!!   " + resut_arr[3] + " Out!!\n";

			// tvResult.append(strResult);
			appendResult(strResult);

			if (resut_arr[0] == 4) {

				/*
				 * Toast.makeText(getApplicationContext(), "You Win!!",
				 * Toast.LENGTH_SHORT).show();
				 */
				// tvResult.append("You Win!!\n\n");

				appendResult("You Win!!\n\n");
				isPlay = false;
				dialogNewGame("You Win!!").show();

			}// if

			if (play_cnt == 9) { // 한경기에 9회전까지
				/*
				 * Toast.makeText(getApplicationContext(), "You Lose!!",
				 * Toast.LENGTH_SHORT).show();
				 */
				// tvResult.append("You Lose!!\n\n");
				// showDialog(DIALOG_NEW_YES_NO);

				appendResult("You Lose!!\n\n");
				isPlay = false;
				dialogNewGame("You Lose!!").show();

			}// if

			// ScrollView result_scrollView = (ScrollView)
			// findViewById(R.id.result_scrollView);
			// result_scrollView.scrollTo(0, tvResult.getHeight());

		} else {
			Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
					Toast.LENGTH_SHORT).show();
		}// if

	}// attack();

	// 결과 뷰에 결과 출력
	public void appendResult(String str) {
		tvResult.append(str);
		ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
		result_scrollView.scrollTo(0, tvResult.getHeight());
	}

	// 대화상자 생성
	public Dialog dialogNewGame(String result) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("결과")
				.setMessage(result + "\n게임을 새로 시작하시겠습니까?")
				.setCancelable(false)
				.setPositiveButton("예", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						init_com();

					}

				})
				.setNegativeButton("아니오",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
								result_scrollView.scrollTo(0,
										tvResult.getHeight());
								dialog.cancel();
							}

						});

		AlertDialog alert = builder.create();

		return alert;
	}

}

```

# STAGE3.java #

```
package com.example.minsbaseballgame;

import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class STAGE3 extends Activity {
	private static final int DIALOG_NEW_YES_NO = 1;

	TextView tvResult;
	TextView TextViewValue[] = new TextView[5];
	int com_Array[] = new int[5];
	int resut_arr[] = new int[5];
	int play_cnt, inputPos;
	boolean isPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stage3);

		TextViewValue[0] = (TextView) findViewById(R.id.TextViewValue1);
		TextViewValue[1] = (TextView) findViewById(R.id.TextViewValue2);
		TextViewValue[2] = (TextView) findViewById(R.id.TextViewValue3);
		TextViewValue[3] = (TextView) findViewById(R.id.TextViewValue4);
		TextViewValue[4] = (TextView) findViewById(R.id.TextViewValue5);
		tvResult = (TextView) findViewById(R.id.TextViewAttack2);

		// 초기화
		init_com();

	}

	// <- 백스페이스 버튼이 클릭되었을때 호출되는 메서드
	public void clickBtnDelListener(View target) {

		/*
		 * for(int i=4;i>=0;i--){
		 * if(TextViewValue[i].getText().toString().trim().length()==1){
		 * TextViewValue[i].setText(" "); break; } }
		 */

		/*if(TextViewValue[4].getText().toString().trim().length()==1{
		 * TextViewValue[4].setText(" "); }else
		 * if(TextViewValue[3].getText().toString().trim().length()==1{
		 * TextViewValue[3].setText(" "); }else
		 * if(TextViewValue[2].getText().toString().trim().length()==1){
		 * TextViewValue[2].setText(" "); }else
		 * if(TextViewValue[1].getText().toString().trim().length()==1){
		 * TextViewValue[1].setText(" "); }else
		 * if(TextViewValue[0].getText().toString().trim().length()==1){
		 * TextViewValue[0].setText(" "); }
		 */

		if (inputPos > 0) {
			if (TextViewValue[--inputPos].getText().toString().trim().length() == 1) {
				TextViewValue[inputPos].setText(" ");
			}
		}
	}

	// 숫자 버튼을 클릭되었을때 호출되는 메서드
	public void clickBtnNumListener(View target) {

		Button btnNum = ((Button) target);
		String strNum = btnNum.getText().toString();

		/*
		 * for (TextView v : TextViewValue) { if
		 * (v.getText().toString().trim().equals(strNum)) { return; } }
		 */

		// TextViewValue[0].setText(strNum);

		/*
		 * if (TextViewValue[0].getText().toString().trim().length() != 1) {
		 * TextViewValue[0].setText(strNum); } else if
		 * (TextViewValue[1].getText().toString().trim().length() != 1) {
		 * TextViewValue[1].setText(strNum); } else if
		 * (TextViewValue[2].getText().toString().trim().length() != 1) {
		 * TextViewValue[2].setText(strNum); } else if
		 * (TextViewValue[3].getText().toString().trim().length() != 1) {
		 * TextViewValue[3].setText(strNum);
		 * (TextViewValue[4].getText().toString().trim().length() != 1) {
		 * TextViewValue[4].setText(strNum);
		 * Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
		 * Toast.LENGTH_SHORT).show(); }
		 */

		if (isPlay) {
			if (inputPos < 5) {

				for (TextView v : TextViewValue) {
					if (v.getText().toString().trim().equals(strNum)) {
						return;
					}
				}
				TextViewValue[inputPos].setText(strNum);
				inputPos++;

			} else {
				Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
						Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
					Toast.LENGTH_SHORT).show();
		}

	}

	// 새게임 버튼이 클릭되었을때 호출되는 메서드
	public void clickBtnNewListener(View target) {
		init_com();
	}

	// 게임 초기화
	public void init_com() {

		play_cnt = 0; // 공격횟수 초기화;
		for (TextView v : TextViewValue) {
			v.setText(" ");
		}
		// 중복되지 않는 5개의 난수 저장.
		int i = 0;
		do {
			// int r = (int)(Math.random()*9)+1;
			int r = (int) (Math.random() * 10);
			com_Array[i] = r;

			for (int j = 0; j < i; j++) { // 중복되는 값 검사.
				if (com_Array[i] == com_Array[j]) {
					i--; // 중복값이 있으면 i변수를 -1.
					break; // 반복문 종료
				}// if
			}// for

			i++;

		} while (i < 5); // 5회전

		// 기존에 있는 결과값 클리어
		tvResult.setText("");
		// tvResult.append(Arrays.toString(com_Array));
		tvResult.append("\n");
		tvResult.setText("새 게임을 시작합니다.\n");
		tvResult.append("공격할 숫자 5개를 선택하시고 [공격] 버튼을 눌러주세요!\n");
		inputPos = 0;
		play_cnt = 0;
		isPlay = true;

	}

	// 공격버튼을 눌렀을때 호출되는 메서드
	public void attack(View target) {

		resut_arr = new int[5]; // 결과 초기화

		if (isPlay) {
			// 입력값 체크 (입력받은 숫자가 5개가 아니면 메시지창 출력)
			if (inputPos != 5) {
				Toast.makeText(getApplicationContext(), "공격할 숫자 5개를 선택해주세요!",
						Toast.LENGTH_SHORT).show();
				return;
			}

			int user_Array[] = new int[5];
			for (int i = 0; i < TextViewValue.length; i++) {
				user_Array[i] = Integer.parseInt(TextViewValue[i].getText()
						.toString());
			}

			// 결과 검사
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {

					if (com_Array[i] == user_Array[j]) {
						if (i == j) { // 서로 같은 숫자가 있고 그 숫자의 자리가 같으면 스트라이크 처리
							resut_arr[0]++; // 스트라이크
						} else { // 서로 같은 숫자가 있고 그 숫자의 자리가 다르면 볼 처리
							resut_arr[1]++; // 볼
						}// if
					}// if
				}// for
			}// for

			// 아웃 계산
			resut_arr[4] = 5 - (resut_arr[0] + resut_arr[1]+resut_arr[2]+resut_arr[3]); // 아웃!

			// 입력값을 표시하는 텍스트필드 초기화
			for (TextView v : TextViewValue) {
				v.setText(" ");
			}
			inputPos = 0;

			play_cnt++;// 플레이 카운트 증가

			// 결과값 출력
			String strResult = play_cnt + "회전: " + Arrays.toString(user_Array)
					+ "  " + resut_arr[0] + " Strike!!   " + resut_arr[1]
					+ " Ball!!   " + resut_arr[4]+ "Out!!\n";

			// tvResult.append(strResult);
			appendResult(strResult);

			if (resut_arr[0] == 5) {

				/*
				 * Toast.makeText(getApplicationContext(), "You Win!!",
				 * Toast.LENGTH_SHORT).show();
				 */
				// tvResult.append("You Win!!\n\n");

				appendResult("You Win!!\n\n");
				isPlay = false;
				dialogNewGame("You Win!!").show();

			}// if

			if (play_cnt == 9) { // 한경기에 9회전까지
				/*
				 * Toast.makeText(getApplicationContext(), "You Lose!!",
				 * Toast.LENGTH_SHORT).show();
				 */
				// tvResult.append("You Lose!!\n\n");
				// showDialog(DIALOG_NEW_YES_NO);

				appendResult("You Lose!!\n\n");
				isPlay = false;
				dialogNewGame("You Lose!!").show();

			}// if

			// ScrollView result_scrollView = (ScrollView)
			// findViewById(R.id.result_scrollView);
			// result_scrollView.scrollTo(0, tvResult.getHeight());

		} else {
			Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
					Toast.LENGTH_SHORT).show();
		}// if

	}// attack();

	// 결과 뷰에 결과 출력
	public void appendResult(String str) {
		tvResult.append(str);
		ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
		result_scrollView.scrollTo(0, tvResult.getHeight());
	}

	// 대화상자 생성
	public Dialog dialogNewGame(String result) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("결과")
				.setMessage(result + "\n게임을 새로 시작하시겠습니까?")
				.setCancelable(false)
				.setPositiveButton("예", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						init_com();

					}

				})
				.setNegativeButton("아니오",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
								result_scrollView.scrollTo(0,
										tvResult.getHeight());
								dialog.cancel();
							}

						});

		AlertDialog alert = builder.create();

		return alert;
	}

}

```

# HELP.java #

```
package com.example.minsbaseballgame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HELP extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hel, menu);
		return true;
	}

}//help는 그냥 화면에 그림만 있습니다.

```


# Layout #

# activity\_main.xml #

```

<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="wrap_content"
    android:layout_height="match_parent"
    android:background="@drawable/black" // black 바탕으로 했습니다.
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="373dp"
        android:layout_height="wrap_content"
        android:layout_x="-39dp"
        android:layout_y="58dp"
        android:src="@drawable/titlerrrrrrr" /> // 숫자야구게임이라는 제목을 나타내는 그림

    <ImageView
        android:id="@+id/imageView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="-75dp"
        android:layout_y="-9dp"
        android:src="@drawable/one" /> // 1을 나타내는 그림

    <ImageView
        android:id="@+id/imageView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="14dp"
        android:layout_y="0dp"
        android:src="@drawable/three" /> // 3을 나타내는 그림

    <ImageView
        android:id="@+id/imageView5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="-24dp"
        android:layout_y="-28dp"
        android:src="@drawable/two" /> // 2를 나타내는 그림

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="214dp"
        android:src="@drawable/start1" /> // start 버튼모양을 나타내는그림

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="329dp"
        android:src="@drawable/help1" /> // help 버튼 모양을 나타내는 그림
   
</AbsoluteLayout>

```

# activity\_start.xml #

```

<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/gray" // 검은색에 회색 테두리가 있는 화면을 사진으로 했습니다.
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".START" >

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/lyg" /> // 빨강색 강조표시 그림을 삽입

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="20dp"
        android:src="@drawable/stage111" /> // stage1 버튼을 나타내는 그림

    <ImageView
        android:id="@+id/imageView5"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_x="2dp"
        android:layout_y="326dp"
        android:src="@drawable/stage333" /> // stage3 버튼을 나타내는 그림

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_x="7dp"
        android:layout_y="180dp"
        android:src="@drawable/stage222" /> // stage2 버튼을 나타내는 그림

</AbsoluteLayout>

```

# activity\_stage1.xml #

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="4.0dip" >

    <TextView
        android:id="@+id/TextViewDisplay"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dip"
        android:gravity="center"
        android:text="숫자야구 게임"
        android:textSize="20sp"
        android:textStyle="bold" /> // 맨 위에 "숫자야구 게임" 단어 보이게 하는것

    <LinearLayout
        android:id="@+id/linearLayout1"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical" > 

        <TextView
            android:id="@+id/TextViewAttack"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ff5f0000"
            android:padding="3dip"
            android:text="결과"
            android:textColor="#ffffffff"
            android:textStyle="bold" />

        <ScrollView
            android:id="@+id/result_scrollView"
            android:layout_width="fill_parent"
            android:layout_height="150dp"
            android:background="#ff5f5f00"
            android:fillViewport="true" >

            <TextView
                android:id="@+id/TextViewAttack2"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:background="#000000"
                android:padding="3dip"
                android:textColor="#ffffffff"
                android:textStyle="bold" />
        </ScrollView>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/DummyLayout"
        android:layout_width="fill_parent"
        android:layout_height="2.0px"
        android:orientation="vertical" >

        <TextView
            android:id="@+id/TextViewDummy"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffe0e0e0"
            android:text=""
            android:textColor="#ffb0b0b0"
            android:textSize="10.0sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/linearLayout2"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="3.0dip"
        android:baselineAligned="true"
        android:orientation="horizontal" >

        <LinearLayout
            android:id="@+id/linearLayout2_1"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="7.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue1"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"// 전체적인 바탕은 흰색으로 설정
                android:gravity="center"
                android:text="1"
                android:textColor="#000000" // 검정색 바탕으로 설정
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 1번째 입력버튼 만들기
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linearLayout2_2"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue2"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff" //흰색 바탕
                android:gravity="center"
                android:text="2"
                android:textColor="#000000" // 검정색 글씨 
                android:textSize="30.0sp"
                android:textStyle="bold" />// 2번째 입력버튼 만들기
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linearLayout2_3"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" > 

            <TextView
                android:id="@+id/TextViewValue3"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="3"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 3번째 입력버튼 만들기
        </LinearLayout>
        

        <Button
            android:id="@+id/BtnDel"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="7.0dip"
            android:layout_weight="0.0"
            android:onClick="clickBtnDelListener"
            android:text="←"
            android:textSize="25.0sp" /> // ←모양 버튼만들기

        <Button
            android:id="@+id/BtnAttack"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_marginBottom="3.0dip"
            android:layout_weight="2.0"
            android:onClick="attack"
            android:text="공격"
            android:textSize="25.0sp" /> // 공격 버튼 만들기
    </LinearLayout>

    <LinearLayout
        android:id="@+id/DummyLayout"
        android:layout_width="fill_parent"
        android:layout_height="2.0px"
        android:orientation="vertical" >

        <TextView
            android:id="@+id/TextViewDummy"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffe0e0e0"
            android:text=""
            android:textColor="#ffb0b0b0"
            android:textSize="10.0sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/ButtonLayout"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="3.0dip"
        android:layout_weight="1.0"
        android:orientation="vertical" >

        <LinearLayout
            android:id="@+id/ButtonLine02"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:orientation="horizontal" >

            <Button
                android:id="@+id/Btn01"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="1"
                android:textSize="25.0sp" /> //1 이 써있는 버튼

            <Button
                android:id="@+id/Btn02"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="2"
                android:textSize="25.0sp" /> //2가 써있는 버튼

            <Button
                android:id="@+id/Btn03"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="3"
                android:textSize="25.0sp" /> // 3이 써있는 버튼

            <Button
                android:id="@+id/Btn04"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="4"
                android:textSize="25.0sp" />// 4가 써있는 버튼

            <Button
                android:id="@+id/Btn05"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="5"
                android:textSize="25.0sp" />//5가 써있는 버튼
        </LinearLayout>

        <LinearLayout
            android:id="@+id/ButtonLine03"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:orientation="horizontal" >

            <Button
                android:id="@+id/Btn06"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="6"
                android:textSize="25.0sp" />//6 이 써있는 버튼

            <Button
                android:id="@+id/Btn07"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="7"
                android:textSize="25.0sp" />//7 이 써있는 버튼

            <Button
                android:id="@+id/Btn08"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="8"
                android:textSize="25.0sp" />//8 이 써있는 버튼

            <Button
                android:id="@+id/Btn09"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="9"
                android:textSize="25.0sp" />//9 가 써있는 버튼

            <Button
                android:id="@+id/Btn00"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="0"
                android:textSize="25.0sp" />//0 이 써있는 버튼
        </LinearLayout>

        <Button
            android:id="@+id/BtnNewGame"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:onClick="clickBtnNewListener"
            android:text="새 게임"
            android:textSize="25.0sp" />//새게임 이 써있는 버튼
    </LinearLayout>

</LinearLayout>

```

# activity\_stage2.xml #

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="4.0dip" >

    <TextView
        android:id="@+id/TextViewDisplay"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dip"
        android:gravity="center"
        android:text="숫자야구 게임"
        android:textSize="20sp"
        android:textStyle="bold" /> // 맨 위에 "숫자야구 게임" 단어 보이게 하는것

    <LinearLayout
        android:id="@+id/linearLayout1"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical" > 

        <TextView
            android:id="@+id/TextViewAttack"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ff5f0000"
            android:padding="3dip"
            android:text="결과"
            android:textColor="#ffffffff"
            android:textStyle="bold" />

        <ScrollView
            android:id="@+id/result_scrollView"
            android:layout_width="fill_parent"
            android:layout_height="150dp"
            android:background="#ff5f5f00"
            android:fillViewport="true" >

            <TextView
                android:id="@+id/TextViewAttack2"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:background="#000000"
                android:padding="3dip"
                android:textColor="#ffffffff"
                android:textStyle="bold" />
        </ScrollView>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/DummyLayout"
        android:layout_width="fill_parent"
        android:layout_height="2.0px"
        android:orientation="vertical" >

        <TextView
            android:id="@+id/TextViewDummy"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffe0e0e0"
            android:text=""
            android:textColor="#ffb0b0b0"
            android:textSize="10.0sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/linearLayout2"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="3.0dip"
        android:baselineAligned="true"
        android:orientation="horizontal" >

        <LinearLayout
            android:id="@+id/linearLayout2_1"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="7.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue1"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"// 전체적인 바탕은 흰색으로 설정
                android:gravity="center"
                android:text="1"
                android:textColor="#000000" // 검정색 바탕으로 설정
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 1번째 입력버튼 만들기
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linearLayout2_2"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue2"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="2"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" />// 2번째 입력버튼 만들기
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linearLayout2_3"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" > 

            <TextView
                android:id="@+id/TextViewValue3"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="3"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 3번째 입력버튼 만들기
        </LinearLayout>
        
       <LinearLayout
            android:id="@+id/linearLayout2_4"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue4"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="4"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 4번째 입력버튼 만들기
        </LinearLayout>

        <Button
            android:id="@+id/BtnDel"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="7.0dip"
            android:layout_weight="0.0"
            android:onClick="clickBtnDelListener"
            android:text="←"
            android:textSize="25.0sp" /> // ←모양 버튼만들기

        <Button
            android:id="@+id/BtnAttack"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_marginBottom="3.0dip"
            android:layout_weight="2.0"
            android:onClick="attack"
            android:text="공격"
            android:textSize="25.0sp" /> // 공격 버튼 만들기
    </LinearLayout>

    <LinearLayout
        android:id="@+id/DummyLayout"
        android:layout_width="fill_parent"
        android:layout_height="2.0px"
        android:orientation="vertical" >

        <TextView
            android:id="@+id/TextViewDummy"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffe0e0e0"
            android:text=""
            android:textColor="#ffb0b0b0"
            android:textSize="10.0sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/ButtonLayout"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="3.0dip"
        android:layout_weight="1.0"
        android:orientation="vertical" >

        <LinearLayout
            android:id="@+id/ButtonLine02"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:orientation="horizontal" >

            <Button
                android:id="@+id/Btn01"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="1"
                android:textSize="25.0sp" /> //1 이 써있는 버튼

            <Button
                android:id="@+id/Btn02"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="2"
                android:textSize="25.0sp" /> //2가 써있는 버튼

            <Button
                android:id="@+id/Btn03"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="3"
                android:textSize="25.0sp" /> // 3이 써있는 버튼

            <Button
                android:id="@+id/Btn04"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="4"
                android:textSize="25.0sp" />// 4가 써있는 버튼

            <Button
                android:id="@+id/Btn05"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="5"
                android:textSize="25.0sp" />//5가 써있는 버튼
        </LinearLayout>

        <LinearLayout
            android:id="@+id/ButtonLine03"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:orientation="horizontal" >

            <Button
                android:id="@+id/Btn06"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="6"
                android:textSize="25.0sp" />//6 이 써있는 버튼

            <Button
                android:id="@+id/Btn07"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="7"
                android:textSize="25.0sp" />//7 이 써있는 버튼

            <Button
                android:id="@+id/Btn08"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="8"
                android:textSize="25.0sp" />//8 이 써있는 버튼

            <Button
                android:id="@+id/Btn09"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="9"
                android:textSize="25.0sp" />//9 가 써있는 버튼

            <Button
                android:id="@+id/Btn00"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="0"
                android:textSize="25.0sp" />//0 이 써있는 버튼
        </LinearLayout>

        <Button
            android:id="@+id/BtnNewGame"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:onClick="clickBtnNewListener"
            android:text="새 게임"
            android:textSize="25.0sp" />//새게임 이 써있는 버튼
    </LinearLayout>

</LinearLayout>

```

# activity\_stage3.xml #

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="4.0dip" >

    <TextView
        android:id="@+id/TextViewDisplay"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dip"
        android:gravity="center"
        android:text="숫자야구 게임"
        android:textSize="20sp"
        android:textStyle="bold" /> // 맨 위에 "숫자야구 게임" 단어 보이게 하는것

    <LinearLayout
        android:id="@+id/linearLayout1"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical" > 

        <TextView
            android:id="@+id/TextViewAttack"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ff5f0000"
            android:padding="3dip"
            android:text="결과"
            android:textColor="#ffffffff"
            android:textStyle="bold" />

        <ScrollView
            android:id="@+id/result_scrollView"
            android:layout_width="fill_parent"
            android:layout_height="150dp"
            android:background="#ff5f5f00"
            android:fillViewport="true" >

            <TextView
                android:id="@+id/TextViewAttack2"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:background="#000000"
                android:padding="3dip"
                android:textColor="#ffffffff"
                android:textStyle="bold" />
        </ScrollView>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/DummyLayout"
        android:layout_width="fill_parent"
        android:layout_height="2.0px"
        android:orientation="vertical" >

        <TextView
            android:id="@+id/TextViewDummy"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffe0e0e0"
            android:text=""
            android:textColor="#ffb0b0b0"
            android:textSize="10.0sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/linearLayout2"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="3.0dip"
        android:baselineAligned="true"
        android:orientation="horizontal" >

        <LinearLayout
            android:id="@+id/linearLayout2_1"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="7.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue1"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"// 전체적인 바탕은 흰색으로 설정
                android:gravity="center"
                android:text="1"
                android:textColor="#000000" // 검정색 바탕으로 설정
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 1번째 입력버튼 만들기
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linearLayout2_2"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue2"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="2"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" />// 2번째 입력버튼 만들기
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linearLayout2_3"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" > 

            <TextView
                android:id="@+id/TextViewValue3"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="3"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 3번째 입력버튼 만들기
        </LinearLayout>
        
       <LinearLayout
            android:id="@+id/linearLayout2_4"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue4"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="4"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 4번째 입력버튼 만들기
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linearLayout2_5"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="12.0dip"
            android:layout_weight="3.0" >

            <TextView
                android:id="@+id/TextViewValue5"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_gravity="center"
                android:layout_weight="3.0"
                android:background="#ffffffff"
                android:gravity="center"
                android:text="5"
                android:textColor="#000000"
                android:textSize="30.0sp"
                android:textStyle="bold" /> // 5번째 입력버튼 만들기
        </LinearLayout>

        <Button
            android:id="@+id/BtnDel"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_marginBottom="3.0dip"
            android:layout_marginLeft="7.0dip"
            android:layout_weight="0.0"
            android:onClick="clickBtnDelListener"
            android:text="←"
            android:textSize="25.0sp" /> // ←모양 버튼만들기

        <Button
            android:id="@+id/BtnAttack"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_marginBottom="3.0dip"
            android:layout_weight="2.0"
            android:onClick="attack"
            android:text="공격"
            android:textSize="25.0sp" /> // 공격 버튼 만들기
    </LinearLayout>

    <LinearLayout
        android:id="@+id/DummyLayout"
        android:layout_width="fill_parent"
        android:layout_height="2.0px"
        android:orientation="vertical" >

        <TextView
            android:id="@+id/TextViewDummy"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffe0e0e0"
            android:text=""
            android:textColor="#ffb0b0b0"
            android:textSize="10.0sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/ButtonLayout"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="3.0dip"
        android:layout_weight="1.0"
        android:orientation="vertical" >

        <LinearLayout
            android:id="@+id/ButtonLine02"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:orientation="horizontal" >

            <Button
                android:id="@+id/Btn01"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="1"
                android:textSize="25.0sp" /> //1 이 써있는 버튼

            <Button
                android:id="@+id/Btn02"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="2"
                android:textSize="25.0sp" /> //2가 써있는 버튼

            <Button
                android:id="@+id/Btn03"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="3"
                android:textSize="25.0sp" /> // 3이 써있는 버튼

            <Button
                android:id="@+id/Btn04"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="4"
                android:textSize="25.0sp" />// 4가 써있는 버튼

            <Button
                android:id="@+id/Btn05"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="5"
                android:textSize="25.0sp" />//5가 써있는 버튼
        </LinearLayout>

        <LinearLayout
            android:id="@+id/ButtonLine03"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:orientation="horizontal" >

            <Button
                android:id="@+id/Btn06"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="6"
                android:textSize="25.0sp" />//6 이 써있는 버튼

            <Button
                android:id="@+id/Btn07"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="7"
                android:textSize="25.0sp" />//7 이 써있는 버튼

            <Button
                android:id="@+id/Btn08"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="8"
                android:textSize="25.0sp" />//8 이 써있는 버튼

            <Button
                android:id="@+id/Btn09"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="9"
                android:textSize="25.0sp" />//9 가 써있는 버튼

            <Button
                android:id="@+id/Btn00"
                android:layout_width="wrap_content"
                android:layout_height="fill_parent"
                android:layout_weight="1.0"
                android:onClick="clickBtnNumListener"
                android:text="0"
                android:textSize="25.0sp" />//0 이 써있는 버튼
        </LinearLayout>

        <Button
            android:id="@+id/BtnNewGame"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1.0"
            android:onClick="clickBtnNewListener"
            android:text="새 게임"
            android:textSize="25.0sp" />//새게임 이 써있는 버튼
    </LinearLayout>

</LinearLayout>

```

# activity\_help.xml #
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
    android:background="@drawable/blackk"
    tools:context=".HELP" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="21dp"
        android:layout_y="28dp"
        android:src="@drawable/helpppp" /> //help 제목나타내는 사진

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_x="2dp"
        android:layout_y="126dp"
        android:src="@drawable/stupid" /> //게임 방법 설명하는 사진

</AbsoluteLayout>


```
# 전체 소스코드 #

https://comp166-koreauniv.googlecode.com/files/proguard-project.zip

# apk 파일 #

https://comp166-koreauniv.googlecode.com/files/MINJOO.apk

# 참고 #

http://blog.naver.com/PostView.nhn?blogId=lemons_tree&logNo=10094188206&redirect=Dlog&widgetTypeCall=true

http://blog.naver.com/PostView.nhn?blogId=spiks&logNo=185079758&redirect=Dlog&widgetTypeCall=true