/*한번에 한가지 계산만 가능, a + b * c 형태 불가,
부호를 누르면 이미 눌렀던 숫자와 부호가 사라지는 단점, 
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class calculate extends Frame implements ActionListener{
	//기본적으로 계산기 GUI와 버튼을 눌렀을때 액션수행
	private Frame frm; 
	private Button btn[]; // 계산기의 버튼들
	private Panel pan; //버튼이 위치할 판
	private double num1, num2, num3; //입력한 두 숫자, 계산값
	private TextField text; // 숫자가 적힐 공간
	private String symbol; // 부호에 따른 매개변수
	
	
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
        {			//버튼누르면이벤트일어난다 선언
          btn[i].addActionListener(this);
        }
                
	 }
		 
	 	
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

	public static void main(String args[])
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