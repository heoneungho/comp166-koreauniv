# Introduction #

여러가지 운동을 영상을 보면서 단계별로 배우고 즐길 수 있습니다.

꼭 헬스장을 가지 않더라도 집에서도 쉽게 할 수 있는 운동을 많이 담았습니다.
영상과 그림을 통해 가장 중요한 운동 자세를 알 수 있도록 하였으며

부가적으로 일정앱과 연동시켜 운동계획을 짜게 하였고, 필요시 음악을 들으며 할 수 있도록 음악앱과도 연동시켜 사용자의 편의를 생각하였습니다.



# Details #

총 6가지 분야의 운동을 배울 수 있습니다.
5가지의 무산소 운동과 1가지의 유산소 운동으로 구성되어있습니다.

<무산소 운동>
1.가슴
2.팔
3.복부
4.엉덩이
5.등

<유산소 운동>
1.달리기(런닝머신)

무산소 운동의 각 영역은 초급자,중급자,숙련자 3단계로 나누어져있습니다.

사용자는 자신의 몸 상태에 맞게 단계를 선택하면 됩니다.

영상은 무한반복되게 설정하여 운동하면서 지속적으로 볼 수 있게 설정하였습니다.

메뉴 버튼을 누르면 Information과 More Apps 두 개의 메뉴를 볼 수 있습니다.

Information에는 앱에 대한 간략한 정보가 들어있습니다.

More Apps에는 일정앱과 음악앱을 연동시켜서 일정앱은 운동 계획을 쉽게 세울 수 있도록 하였고 음악앱은 음악을 들으면서 운동을 할 수 있도록 하였습니다.

## 클래스 소개 ##

http://comp166-koreauniv.googlecode.com/files/blllllllll.PNG/

Health Care 앱의 특성상 많은 화면을 사용하기 때문에 상당히 많은 클래스들이 필요합니다.

**1.메인클래스**

```

package com.example.healthcare;

import com.example.healthcare.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv1 = (TextView) findViewById (R.id.textView1);
        tv1.setText("Health Care!!! 단계적이고 체계적인 이 앱을 통해서 당신의 몸을 가꾸세요!!!");
		((TextView) findViewById(R.id.textView1)).setSelected(true);

/*onCreate메소드는 이 클래스가 실행되었을때 바로 실행되는 메소드를 말합니다. 
뒤에 TextVIiew 에 대한 코드 설명은 뒤에서 하겠습니다.
지금은 marquee를 쓰기 위해, 즉 문자열이 흐르는 기능을 보여주기 위해 써놓은 
코드라고 간략하게 설명하고 넘어가겠습니다.*/ 

		
		ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);
		
		ImageButton bt2 = (ImageButton) findViewById(R.id.imageButton2);
		
		ImageButton bt3 = (ImageButton) findViewById(R.id.imageButton3);
		
		ImageButton bt4 = (ImageButton) findViewById(R.id.imageButton4);
		
		ImageButton bt5 = (ImageButton) findViewById(R.id.imageButton5);
		
		ImageButton bt6 = (ImageButton) findViewById(R.id.imageButton6);
		
/*메인 화면에서는 총 6개의 화면 이동이 필요하기 때문에 새로운 이미지 버튼 객체 6개를 보기 좋게 생성합니다.*/ 		
		
bt1.setOnClickListener(new OnClickListener()
{
			
	@Override
	public void onClick(View v){
		    	
		    	
	Intent intetn1 = new Intent(MainActivity.this, breast.class);
	startActivity(intetn1);

					
			}

			
		});
/* setonClickListener을 이용해서 이 버튼이 클릭이 발생했을 때 
어떤 사건이 발생할 지 알려주는 코드입니다. 
여기서는 Intent를 이용해서 새로운 Intent객체를 만들고 클릭이 발생했을 때 
Intent를 이용해서 메인화면에서 breast라는 클래스로 화면이 이동하게 합니다. 
밑에 나와있는 다른 5개의 코드도 같은 원리입니다.*/ 		
			
bt2.setOnClickListener(new OnClickListener()
{
				
        @Override
	public void onClick(View v){
			    	
			    	
						
	Intent intetn2 = new Intent(MainActivity.this, heap.class);
	startActivity(intetn2);

					

	}
				
});
		
				
bt3.setOnClickListener(new OnClickListener()
{
					
	@Override
	public void onClick(View v){
				    	
				    	
							
	Intent intetn3 = new Intent(MainActivity.this, below.class);
	startActivity(intetn3);

							

	}
});
		
					
bt4.setOnClickListener(new OnClickListener()
{
						
	@Override
	public void onClick(View v)
        {
					    	
					    	
								
	Intent intetn4 = new Intent(MainActivity.this, arm.class);
	startActivity(intetn4);

							
        }
});
					
bt5.setOnClickListener(new OnClickListener()
{
							
	@Override
	public void onClick(View v)
        {
						    	
						    	
	Intent intetn5 = new Intent(MainActivity.this, back.class);
	startActivity(intetn5);

	}
							
});
bt6.setOnClickListener(new OnClickListener()
{
								
	@Override
	public void onClick(View v)
	{
					                    
        Intent intetn6 = new Intent(MainActivity.this, run.class);
        startActivity(intetn6);
										
	}
});
	

}
/*지금까지는 메인 화면에서 다른 화면 6개로 넘어가기 위한 코드 설명이었습니다.
다음 볼 살펴볼 내용은 옵션 메뉴를 위한 코드입니다.*/	
	
	
	@Override 
	public boolean onCreateOptionsMenu(Menu menu1){
	        menu1.clear();
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu1, menu1);
		return true;
	}
	/*먼저 OnCreateOptionsMenu를 통해 메뉴를 생성함을 알려줍니다.
 이 메소드에는 메뉴 생성에 가장 기본적인 inflater를 사용합니다. 
MenuInflater란 레이아수인프레이터와 같이 XML기반의 즉 (\res\menu\menu1\)에 저장되어있는 메뉴를 기술하고, 
프로그램에서 XML파일을 Inflate하여 메뉴를 구성하는 방법입니다.
여기서 inflate란 XML 에 씌여져 있는 view 의 정의를 실제 view 객체로 만드는 것으로 '부풀리다' 라는 뜻입니다.
*/	
       @Override
       public boolean onOptionsItemSelected(MenuItem item){
			
		switch (item.getItemId())
                {
	        case R.id.item1:
		Intent intetn1 = new Intent(this, information.class);
		startActivity(intetn1);

		break;
			
		case R.id.item2:
		Intent intetn2 = new Intent(this, word.class);
		startActivity(intetn2);
				
		break;
                }
/* 다음은 사용자가 옵션을 선택했을 때 어떤 사건이 발생될지를 알려주는 코드입니다.
switch 구문을 이용하여 XML파일에 등록되어있는 item1이나 2를 클릭하면 Intent를 통해
information 혹은 word 라는 클래스로 화면이 이동하게 됩니다.*/			
		
	

		return true;
	}

}
 
```

다음은 메인 화면에서 넘어가 다음 화면을 맡게 될 클래스들입니다.

먼저 비슷한 5개의 클래스(Breast,Arm.Below,Heap,Back class)를 살펴보겠습니다.

**2.Breast,Arm.Below,Heap,Back class**
```
//Breast class

package com.example.healthcare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ImageButton;


public class breast extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.breast);
      
              
    ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);
    ImageButton bt2 = (ImageButton) findViewById(R.id.imageButton2);
    ImageButton bt3 = (ImageButton) findViewById(R.id.imageButton3);
    
    
    bt1.setOnClickListener(new OnClickListener()
    {
	@Override
	public void onClick(View v){
        Intent intetn1 = new Intent(breast.this, breast_1.class);
	startActivity(intetn1);

	}

			
    });
		
    bt2.setOnClickListener(new OnClickListener(){
	
        @Override
        public void onClick(View v){
	
         Intent intetn2 = new Intent(breast.this, breast_2.class);
        startActivity(intetn2);

	}
				
      });
		
				
    bt3.setOnClickListener(new OnClickListener(){
					
	@Override
	public void onClick(View v){
		
	Intent intetn3 = new Intent(breast.this, breast_3.class);
        startActivity(intetn3);

	}
       });
}
}
/** 메인 클래스와 상당히 흡사합니다. 이 클래스는 단순히 사용자가 버튼 3개로 자신의 운동 단계를 선택하는 것을 목적으로 합니다. 
따라서 이 클래스는 메인과 비슷하게 이미지 버튼을 설정해 주고 그 버튼이 클릭 될 때 Intent를 이용한 화면전환 사건이 일어나게 합니다.*/

```

나머지 동일한 4개의 코드는 주석을 생략합니다.

```
//Arm class

package com.example.healthcare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class arm extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
        setContentView(R.layout.breast);
        
        
      
    
        ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton bt2 = (ImageButton) findViewById(R.id.imageButton2);
	ImageButton bt3 = (ImageButton) findViewById(R.id.imageButton3);
    
    
   bt1.setOnClickListener(new OnClickListener()
{
			
	@Override
	public void onClick(View v){
        Intent intetn1 = new Intent(arm.this, arm1.class);
	startActivity(intetn1);

					
}

			
});
		
			
   bt2.setOnClickListener(new OnClickListener(){
				
	@Override
	public void onClick(View v){
        Intent intetn2 = new Intent(arm.this, arm2.class);
	startActivity(intetn2);

					

}
});
		
				
   bt3.setOnClickListener(new OnClickListener(){
					
	@Override
	public void onClick(View v){
        Intent intetn3 = new Intent(arm.this, arm3.class);
	startActivity(intetn3);

							

}
});
}
}

```

```
//Below class

package com.example.healthcare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;




public class below extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.below);
        
        
    ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);
    ImageButton bt2 = (ImageButton) findViewById(R.id.imageButton2);
    ImageButton bt3 = (ImageButton) findViewById(R.id.imageButton3);
    
    
    bt1.setOnClickListener(new OnClickListener()
{
			
    @Override
    public void onClick(View v){
    Intent intetn1 = new Intent(below.this, below1.class);
    startActivity(intetn1);

}
});
		
			
    bt2.setOnClickListener(new OnClickListener(){
				
    @Override
    public void onClick(View v){
    Intent intetn2 = new Intent(below.this, below2.class);
    startActivity(intetn2);

}
});
		
				
    bt3.setOnClickListener(new OnClickListener(){
					
    @Override
    public void onClick(View v){
    Intent intetn3 = new Intent(below.this, below3.class);
    startActivity(intetn3);

							

}
});
}
}

```

```
//Heap Class

public class heap extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.heap);
        
        
    ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);
    ImageButton bt2 = (ImageButton) findViewById(R.id.imageButton2);
    ImageButton bt3 = (ImageButton) findViewById(R.id.imageButton3);
    
    
    bt1.setOnClickListener(new OnClickListener()
{
			
    @Override
    public void onClick(View v){
    Intent intetn1 = new Intent(heap.this, heap1.class);
    startActivity(intetn1);

}
});
		
			
    bt2.setOnClickListener(new OnClickListener(){
				
    @Override
    public void onClick(View v){
    Intent intetn2 = new Intent(heap.this, heap2.class);
    startActivity(intetn2);

}
});
		
				
    bt3.setOnClickListener(new OnClickListener(){
					
    @Override
    public void onClick(View v){
    Intent intetn3 = new Intent(heap.this, heap3.class);
    startActivity(intetn3);

							

}
});
}
}

```

```
//Back class
public class back extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.back);
        
        
    ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);
    ImageButton bt2 = (ImageButton) findViewById(R.id.imageButton2);
    ImageButton bt3 = (ImageButton) findViewById(R.id.imageButton3);
    
    
    bt1.setOnClickListener(new OnClickListener()
{
			
    @Override
    public void onClick(View v){
    Intent intetn1 = new Intent(back.this, back1.class);
    startActivity(intetn1);

}
});
		
			
    bt2.setOnClickListener(new OnClickListener(){
				
    @Override
    public void onClick(View v){
    Intent intetn2 = new Intent(back.this, back2.class);
    startActivity(intetn2);

}
});
		
				
    bt3.setOnClickListener(new OnClickListener(){
					
    @Override
    public void onClick(View v){
    Intent intetn3 = new Intent(back.this, back3.class);
    startActivity(intetn3);

							

}
});
}
}

```

다음은 이 클래스들을 통해 다른 화면으로 넘어가게 되는데
그 화면에 대한 클래스들을 살펴보겠습니다.

**2.1 breast\_1,2,3 arm,below,heap,back 1,2,3 class, run class**
```
//동영상을 위한 특별한 Class
//breast_2 class

package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class breast_2 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.breast_2);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/breast2");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        
    /*VideoView에 대한 새로운 객체를 생성합니다. 
비디오 재생을 위해서 URI 라는 개념을 사용하게 되는데 URI란 Uniform Resource Identifier의 약자이며 텍스트의 한 페이지나 비디오 또는
 동영상 등을 인식하기 위한 수단입니다. 
이 URI를 이용해서 \res\raw\파일에 저장되어 있는 동영상을 
인식하게 되고 이 과정을 거쳐야만 동영상을 재생할 수 있습니다. */

    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}
/*다음은 동영상을 무한 반복하게 하기 위한 코드입니다. 위에 코드가 없다면 동영상은
한 번 재생되고 멈추게 됩니다. 위에 코드를 살펴보면 미디어 플레이어가 종료되었을 때 
다시한번 객체를 생성해주고 그 것을 다시 재생해줍니다. 이 과정을 통해 동영상은 화면이
켜져있으면 무한반복하게 됩니다.*/ 

```

다음은 breast\_2와 거의 동일한 소스를 가진 class들입니다.
```
//breast_3
package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class breast_3 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.breast_3);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/breast3");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

```
///arm1 class

package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class arm1 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.arm1);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/arm");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

```
//below1 class


package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class below1 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.below1);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/below");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

```
//below3 class

package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class below3 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.below3);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/below3");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

```
//heap1 class

package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class heap1 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.heap1);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/heap");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

```
//heap3 class
package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class heap3 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.heap3);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/heap2");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

```
///back1 class

package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class back1 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.back1);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/back");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

```
//back3 class

package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class back3 extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.back3);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/kukiroutine");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}
```

```
//run class

package com.example.healthcare;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class run extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.run);
        
    VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
    Uri videoUri = Uri.parse("android.resource://"+getPackageName()   + "/raw/run");
    videoView1.setVideoURI(videoUri);
    videoView1.start();
        


    videoView1.setOnCompletionListener(new   MediaPlayer.OnCompletionListener(){

      public void onCompletion(MediaPlayer mp){

      VideoView videoView1 = (VideoView) findViewById (R.id.videoView1);
      videoView1.start();

        }

   });
}
}

```

다음은 **나는 class다 고로 존재한다\*는 class들입니다.
즉 말그대로 존재를 위한 class들입니다.**

```
//breast_1 class

package com.example.healthcare;

import android.app.Activity;
import android.os.Bundle;


public class breast_1 extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.breast_1);
        
}
}

/*정말 존재만 합니다.*/
```

나머지 클래스들도 모두 동일한 코드를 가지고 있으므로 이 쓸모없는 클래스들은
특별히 생략하겠습니다.


3.word.class

이 class는 다른 class들과 달리 약간 특별한 class입니다.
단순한 화면 넘어가는 식의 버튼을 가지고 있는 것이 아니라
일정앱과 음악앱을 연동시킬 수 있는 class입니다.

```



package com.example.healthcare;



import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class word extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.word);
        
    ImageButton bt1 = (ImageButton) findViewById(R.id.imageButton1);
    ImageButton bt2 = (ImageButton) findViewById(R.id.imageButton2);
        
        
    bt1.setOnClickListener(new OnClickListener()
{
			
    @Override
    public void onClick(View v){ 
    Intent intent = new Intent(Intent.ACTION_EDIT);  
    intent.setType("vnd.android.cursor.item/event");
    intent.putExtra("title", "운동일지 작성");
    intent.putExtra("description", "Some description");
    intent.putExtra("beginTime", new java.util.Date().getTime());
    intent.putExtra("endTime", new java.util.Date().getTime()+36000000);
    startActivity(intent);
}
    });

/*먼저 이미지 버튼 1은 일정 앱과 연동시키기 위한 버튼입니다.
먼저 intent를 이용해서 일정을 만드는 Edit하는 화면으로 이동하게 합니다.
제목은 운동일지 작성으로 Sample처럼 나타나게 되고
설명도 Some description으로 나옵니다.
시작 시간(begintime)과 끝 시간(end time)은 안드로이드의 시간을 따오게
설정하였습니다.*/
        
    bt2.setOnClickListener(new OnClickListener()
{
        
    @Override
    public void onClick(View v){
        	
    Intent intent1 = new Intent("android.intent.action.MUSIC_PLAYER");
    startActivity(intent1);
        }
        
    });
/*그 다음 이미지 버튼2는 음악앱과 연동시키기 위한 버튼입니다.
intent를 이용해서 곧장 music player로 넘어가게 설정하였습니다.*/    
    }
}

```

## 레이아웃 소개 ##

http://comp166-koreauniv.googlecode.com/files/ygyg.PNG/

역시 구현될 화면의 갯수만큼 필요하기 때문에 많은 수의 레이아웃이 등장합니다.

**1.activity\_main.xml**

http://comp166-koreauniv.googlecode.com/files/asdf.PNG/

```
<RelativeLayout 
//확실한 줄맞춤을 위해 Relative 레이아웃을 사용합니다. xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/RelativeLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/black" //배경은 깜댕이로
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="110dp"
        android:layout_height="110dp"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/imageButton1"
        android:layout_marginLeft="18dp"
        android:layout_marginTop="16dp"
        android:layout_x="-7dp"
        android:layout_y="251dp"
        android:src="@drawable/below"
        android:visibility="visible" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="110dp"
        android:layout_height="110dp"
        android:layout_alignLeft="@+id/imageButton3"
        android:layout_below="@+id/imageView1"
        android:layout_marginTop="16dp"
        android:src="@drawable/breast"
        android:visibility="visible" />

    <ImageButton
        android:id="@+id/imageButton6"
        android:layout_width="110dp"
        android:layout_height="110dp"
        android:layout_alignLeft="@+id/imageButton3"
        android:layout_below="@+id/imageButton3"
        android:layout_marginTop="21dp"
        android:src="@drawable/run"
        android:visibility="visible" />

    <ImageButton
        android:id="@+id/imageButton4"
        android:layout_width="110dp"
        android:layout_height="110dp"
        android:layout_alignRight="@+id/imageView1"
        android:layout_alignTop="@+id/imageButton1"
        android:layout_marginRight="21dp"
        android:src="@drawable/arm"
        android:visibility="visible" />

    <ImageButton
        android:id="@+id/imageButton2"
        android:layout_width="110dp"
        android:layout_height="110dp"
        android:layout_above="@+id/imageButton6"
        android:layout_alignLeft="@+id/imageButton4"
        android:src="@drawable/heap"
        android:visibility="visible" />

    <ImageButton
        android:id="@+id/imageButton5"
        android:layout_width="110dp"
        android:layout_height="110dp"
        android:layout_alignLeft="@+id/imageButton2"
        android:layout_alignTop="@+id/imageButton6"
        android:src="@drawable/back"
        android:visibility="visible" />

       //이미지 버튼 6개를 차례로 만듭니다.
    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:src="@drawable/healthcare" />
       //직접 디자인한 제목을 이미지 뷰를 통해 집어 넣습니다.
    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/imageView1"
        android:layout_below="@+id/imageButton6"
        android:ellipsize="marquee"
        android:focusable="true"
        android:focusableInTouchMode="true"
        android:marqueeRepeatLimit="marquee_forever"//무한하게 흐릅니다.
        android:scrollHorizontally="true"
        android:singleLine="true"
        android:text="Health Care!!! 단계적이고 체계적인 이 앱을 통해서 당신의 몸을 가꾸세요!!!"
        android:textAppearance="?android:attr/textAppearanceMedium"
        android:textColor="#FFFFFF"//글자색은 흰색으로 설정
        android:textSize="30dp"//크기는 약간 크게
        android:visibility="visible" />
/*단순한 TextView가 아닙니다. marquee를 이용하여 text가 옆으로 이동하게끔 
설정하였습니다.주의할 점은 text가 화면에 다 들어가는 길이면 이동하지 않습니다.*/
</RelativeLayout>

```

**2.breast,arm,below,heap,back.xml**


http://comp166-koreauniv.googlecode.com/files/asss.PNG/

이 화면을 통해서 사용자는 자신의 몸 상태에 따라 운동단계를 선택할 수 있습니다.
동일한 소스 코드라 한 가지만 코드(breast.xml)로 적겠습니다.

```

<?xml version="1.0" encoding="utf-8"?>

//역시 줄맞춤을 위해 Relative 레이아웃을 사용합니다.

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/RelativeLayout1"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="@drawable/black" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentTop="true"
        android:src="@drawable/level" />
//직접 디자인한 제목을 이미지 뷰를 통해 집어 넣습니다.

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="274dp"
        android:layout_height="100dp"
        android:layout_alignLeft="@+id/imageButton2"
        android:layout_below="@+id/imageButton2"
        android:layout_marginTop="25dp"
        android:src="@drawable/high" />

    <ImageButton
        android:id="@+id/imageButton2"
        android:layout_width="274dp"
        android:layout_height="100dp"
        android:layout_alignLeft="@+id/imageButton1"
        android:layout_below="@+id/imageButton1"
        android:layout_marginTop="28dp"
        android:src="@drawable/middle" />

    <ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="274dp"
        android:layout_height="100dp"
        android:layout_below="@+id/imageView1"
        android:layout_centerHorizontal="true"
        android:src="@drawable/begin" />

//초보자,중급자,숙련자 단계를 이미지 버튼을 통해 구현합니다.
</RelativeLayout>

```

**3.videoview가 있는 레이아웃들**

http://comp166-koreauniv.googlecode.com/files/aaa.PNG/

위에 그림처럼 videoview는 위치만 확인하고 재생상태는 run을 하지 않고는
알 수 없습니다. 그러나 class파일을 통해 받은 정보를 핸드폰 혹은 에뮬레이터에서
구동 되는 것을 확인할 수 있습니다.
대표적인 레이아웃 하나의 코드만을(below3.xml) 적겠습니다.

```

<?xml version="1.0" encoding="utf-8"?>

//위치 조정이 중요하므로 Absolute 레이아웃을 사용합니다.

<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/black" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/heaphig" />

    <VideoView
        android:id="@+id/videoView1"
        android:layout_width="match_parent"
        android:layout_height="156dp"
        android:layout_x="2dp"
        android:layout_y="67dp" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="4dp"
        android:layout_y="240dp"
        android:src="@drawable/belowhigex" />

</AbsoluteLayout>


```

**4.videoview 없는 단순한 xml들**

http://comp166-koreauniv.googlecode.com/files/aaaa.PNG/


이미지 뷰를 통해 운동정보를 제공하는 xml들입니다.
소스코드는 다 동일하므로 이 역시 대표적인 xml(breast\_1.xml)의 코드만 적었습니다.

```


<?xml version="1.0" encoding="utf-8"?>

//이미지가 많이 있지 않는 한 위치 조정이 쉬운 Absoulute 레이아웃을 사용하는 
것이 좋은 것 같습니다.
<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/AbsoluteLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/black" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/exercise" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="236dp"
        android:layout_x="2dp"
        android:layout_y="99dp"
        android:src="@drawable/breastbigex" />
   
</AbsoluteLayout>

```

## 구동 사진 ##

http://comp166-koreauniv.googlecode.com/files/a6.jpg/

시작 화면입니다. 밑에 textview가 흐르고 있습니다.

http://comp166-koreauniv.googlecode.com/files/a4.jpg/

운동 단계를 선택하는 화면입니다.

http://comp166-koreauniv.googlecode.com/files/a3.jpg/

http://comp166-koreauniv.googlecode.com/files/a5.jpg/

사용자는 동영상을 볼 수 있습니다.

http://comp166-koreauniv.googlecode.com/files/a2.jpg/


## 추가적인 기능 ##

<a href='http://www.youtube.com/watch?feature=player_embedded&v=zgyUbCxToUw' target='_blank'><img src='http://img.youtube.com/vi/zgyUbCxToUw/0.jpg' width='425' height=344 /></a>

옵션 메뉴를 추가하였는데 핸드폰의 옵션 버튼을 누르면

Information과 More Apps 두 개의 선택사항을 선택할 수 있습니다.

Information은 이 앱에 대한 전반적인 설명이고

More Apps는 운동 계획을 빠르고 쉽게 세울 수 있게 일정앱과 연동시켰고

운동하면서 음악을 손쉽게 들을 수 있도록 음악앱과 연동시켰습니다.

## 출처 ##
http://blog.naver.com/PostView.nhn?blogId=space5084&logNo=60137851539&categoryNo=15&viewDate=&currentPage=1&listtype=0 --> marquee효과를 위해 참조함

http://www.wikihow.com/Do-a-Push-Up --> Push up에 대한 내용과 사진을 참조함

http://blog.naver.com/kenji_seo?Redirect=Log&logNo=20146709799
--> 옵션 메뉴에 대한 내용을 참조함

http://stackoverflow.com/questions/6545792/error-in-using-calendar-in-android --> 일정 앱의 연동을 위해 참조함

http://susemi99.tistory.com/1290 --> 음악 앱을 위해 참조함

책: 안드로이드 앱 개발 완벽 가이드 -->전반적인 것은 이 책에서 참조함

## 동영상 라이센스에 대한 부분 ##

이 앱에서 사용하고 있는 동영상 종류는 총 3가지로 나눌 수 있는데

가장 많이 나오는 외국 동영상들은 사실 작년에 체대 입시를 준비하면서 학원에서 받은

동영상입니다. 이에 학원에 문의해서 물어본 결과 미국 헬스 클럽 홍보? 그런 동영상이라

사용해도 무관하다는 답을 받았습니다. 또 이 외에 다른 동영상들 역시 홍보용 동영상으로

찍은 것이라 사용에 큰 지장이 없는 것 같습니다.

## APK 파일 제출 ##
http://comp166-koreauniv.googlecode.com/files/healthcare.apk/

## 소스 코드 제출 ##
http://comp166-koreauniv.googlecode.com/files/healthcare.zip/