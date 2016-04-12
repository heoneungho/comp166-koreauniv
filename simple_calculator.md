간단한 계산기

# Introduction #

키보드 사용 불가, 오직 마우스로 버튼을 찍어 입력하며

한번에 한가지 계산만 가능,  a + b + c 형태 불가

부호를 누르면 이미 눌렀던 수와 부호가 사라지는 단점

정수를 입력해도 소수화 시켜, 소수점 1자리 까지 계산

# Background #

그리드 레이아웃이나 윈도우 창 종료 등은 계산기에 흔히 쓰이는 기법


# Details #

하나의 클래스에서 크게 4가지 부분

초기 설정, GUI 설정 생성자, 액션 이벤트 메서드, 설정한 객체를 생성하는 메인 메서드


GUI는  그리드 레이아웃을 이용해 4X4 행렬 형태의 버튼 위치 시키기.


0~9  버튼: 텍스트필드에 숫자 적기

사칙연산 버튼: 입력시 텍스트필드에 존재하는 수를 첫번재 수로 인식,
> 다시 텍스트 필드 공백화

= 버튼:    입력시 텍스트 필드에 존재하는 수를 두번째 수로 인식,
> 부호를 입력하며 텍스트필드가 공백됬으므로 두번째 수만 존재,
> 부호에 따라 계산해 결과 출력

. 버튼:    입력시 텍스트 필드에 단지 소수점을 추가할뿐

C 버튼: 텍스트필드 강제 공백화



# Using the Code #


클래스 내부에서 가장 초기 설정, 주로 GUI를 무엇으로 할지 결정 하는 부분

```
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class calculate extends Frame implements ActionListener{
	//기본적으로 계산기 GUI와 버튼을 눌렀을때 액션수행

	
	private Button btn[ ]; // 계산기의 버튼들
	private Panel pan; //버튼이 위치할 판
	private double num1, num2, num3; //입력한 두 숫자, 계산값
	private TextField text; // 숫자가 적힐 공간
	private String symbol; // 부호에 따른 매개변수
```


GUI를 설정하고 버튼 위치 정하는 부분으로 모두 생성자 속에 위치

```
	public calculate( ){ //생성자인데 GUI 설정

		btn = new Button[17]; //10개 숫자, 4개 연산, =, 소수점, c
		pan=new Panel(new GridLayout(4,4));
		// GUI 위해 설정, 그리드레이아웃은 행렬이나 바둑판 모양 버튼
		text = new TextField(20); // 괄호안은 입력가능길이 
		num1=0.0; num2=0.0; num3=0.0; //초기화
		
		text.setText(""); // 숫자가 적히는 공간 초기화
		
		
		for(int i=0; i<=9; i++)
        {
            btn[i] = new Button(String.valueOf(i));
        } //버튼 0번에는 숫자0 표시, 버튼 9번에는 숫자 9 표시
		
		btn[10] = new Button("+");
        btn[11] = new Button("-");
        btn[12] = new Button("*");
        btn[13] = new Button("/");
        btn[14] = new Button("=");
        btn[15] = new Button(".");
		btn[16] = new Button("c");
	
		pan.add(btn[1]); //pan 은 4x4 형태의 행렬 모양
		pan.add(btn[2]);
		pan.add(btn[3]);  //맨 위행은 1,2,3이 위치
		pan.add(btn[10]); //맨 위행 4번째 버튼은  +
		pan.add(btn[4]);
		pan.add(btn[5]);
		pan.add(btn[6]);
		pan.add(btn[11]); //두번째 행의 4번재 버튼은 -
		pan.add(btn[7]);
		pan.add(btn[8]);
		pan.add(btn[9]);
		pan.add(btn[12]); //세번째 행의 4번째 버튼은 *
		pan.add(btn[0]);
		pan.add(btn[15]); //소수점이 맨 밑행에 위치
		pan.add(btn[14]); //= 행이 맨 밑행에 위치
		pan.add(btn[13]); //네번째 행의 4번째 버튼은 / 
		
		setLayout(new BorderLayout());
		add(pan, BorderLayout.CENTER); //4x4 사각형이 중심
		add(btn[16], BorderLayout.EAST); //클리어는 오른쪽에
        add(text, BorderLayout.NORTH); //텍스트필드는 위쪽
        
     for(int i=0; i<=16; i++)
        {			// 버튼누르면이벤트일어난다고 GUI에 이벤트 선언
          btn[i].addActionListener(this);
        }
    }


```

> 생성자가 종료되고 버튼에 대한 액션 이벤트 설정하는 메서드

```
       	 	
	public void actionPerformed(ActionEvent ae) {
		//액션에 의해 이벤트가 일어난다 파라미터를 ae로 뒀다.
		for(int i=0; i<=16; i++)
		{
			if(ae.getSource() == btn[i])
			{// 누른 버튼의 소스가 해당 버튼일때
				switch(i)
                {	
                case 0: //0을 눌렀으면 현재 텍스트필드에 0을 추가
                	text.setText(text.getText() + "0");
				break;
                case 1: //1을 눌렀으면 현재 텍스트필드에 1을 추가
                	text.setText(text.getText() + "1");
				break;
                case 2: //2을 눌렀으면 현재 텍스트필드에 2을 추가
                	text.setText(text.getText() + "2");
				break;
                case 3: //3을 눌렀으면 현재 텍스트필드에 3을 추가
                	text.setText(text.getText() + "3");
				break;
                case 4: //4을 눌렀으면 현재 텍스트필드에 4을 추가
                	text.setText(text.getText() + "4");
				break;
                case 5: //5을 눌렀으면 현재 텍스트필드에 5을 추가
                	text.setText(text.getText() + "5");
				break;
                case 6: //6을 눌렀으면 현재 텍스트필드에 0을 추가
                	text.setText(text.getText() + "6");
				break;
                case 7: //7을 눌렀으면 현재 텍스트필드에 7을 추가
                	text.setText(text.getText() + "7");
				break;
                case 8: //8을 눌렀으면 현재 텍스트필드에 8을 추가
                	text.setText(text.getText() + "8");
				break;
                case 9: //9을 눌렀으면 현재 텍스트필드에 9을 추가
                	text.setText(text.getText() + "9");
				break;
			
                case 10://btn[10]은 덧셈이므로
                 //기호를 누르면 그이전에 입력한 숫자를 num1로 갖자
                	symbol="+";
                    num1 = Double.parseDouble(text.getText());
                    text.setText(""); //입력한 숫자를 소수변환
               /*
                text.setText(text.getText() + "+");
               글자를 남겨두고 싶은데 num2 인식 때문에 어쩔수 없이 빈칸화
                */
                    break;  
                case 11://btn[11]은 뺄셈이므로
                    symbol="-";
                    num1 = Double.parseDouble(text.getText());
                    text.setText("");
                    break;
                case 12://btn[12]은 곱셈이므로
                	symbol="*";
                    num1 = Double.parseDouble(text.getText());
                    text.setText("");
                    break;
                case 13://btn[13]은 나눗셈이므로
                	symbol="/";
                    num1= Double.parseDouble(text.getText());
                    text.setText("");
                    break;

                case 14:// = 이전 쓴 숫자는 두번째 수인 num2로 본다
                    num2 = Double.parseDouble(text.getText());
                   /* 부호 입력후 공백상태를 만들었기 때문에 
                        다시 숫자를 입력하고 =를 입력하면 num2로 인식*/
                   
                    switch(symbol) //case 14안에서 case문
                    {
                    case "+":
                    	num3= num1+num2; //num3은 더블형 고정
                    	Double answer1= new Double(num3);
                    	text.setText(answer1.toString());
                    break; /*num3은 toString직접 변환이 안되는데,
                      answer는 num3와 같은 값 더블형
     toString을 통해 setText에서 요구하는  스트링형태로 변환*/
                               
                	case "-":
                		num3= num1-num2; 
                    	Double answer2= new Double(num3);
                    	text.setText(answer2.toString());
                    break;
                    
                	case "*":
                		num3= num1*num2; 
                    	Double answer3= new Double(num3);
                    	text.setText(answer3.toString());
                    break;
                    
                	case "/":
                		num3= num1/num2; 
                    	Double answer4= new Double(num3);
                    	text.setText(answer4.toString());
                    break;
                   
                    }  //case 14안에서 case문 종료
                    break; // case14의 브레이크
                    
               case 15: // 소수점
                	text.setText(text.getText() + ".");
                    break;
                    //num1과 num2를 부호와 =로 인식하기 때문에
				
                case 16: // 클리어
                	text.setText("");
                	break;
			}// 스위치문 종료
		}//if 문 종료
	  }// for 문 종료
	}// actionPerformed 종료

```
> GUI를 위한 생성자와, 액션이벤트를 위한 메서드가 클래스 내부에 위치,
> 이것으로 계산기 객체를 생성하기 위한 정보 설정은 종료,

> 계산기 객체 생성하라 명령하는 메인 메서드 또한, 이어서 같은 클래스 내부에 위치
```
        public static void main(String args[ ])
	{
		calculate cal = new calculate(); //계산기 객체 생성
		cal.setBounds(100, 100, 300, 300);
		 //시작점 100,100, 가로세로 300,300
		cal.setVisible(true);
		cal.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
            	System.out.println("Window Closing");
                System.exit(0); 
            } //addWindowListener는 윈도창 종료버튼 활성화		
	    }); //addWindowListener종료
	}
}

```

하나의 클래스 안에 초기설정, 생성자 , 이벤트 메서드, 메인 메서드