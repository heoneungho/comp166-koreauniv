# Introduction #

계산기



# Details #

계산을 할수 있는 계산기입니다.

**EmptyListException.java**

```

/** 클래스 EmptyListException 
      용도 : stack이 비어있을 경우에 pop등의 명령 수행시 예외처리를 위한 클래스
*/
package com.example.calculator_v2;
class EmptyListException extends RuntimeException
{
	public EmptyListException()
	{
		this("List");
	}

	public EmptyListException(String name)
	{
		super(name + " is empty");
	}
}


```

**ListNode.java**

```

/** 클래스 ListNode
      용도 : Stack에 쓰일 각 노드들의 정의.
*/
package com.example.calculator_v2;

class ListNode
{
	// 각 노드에는 내용과 그다음 노드의 위치를 기억시킨다.
	String data;
	ListNode nextNode;

	ListNode(String object)
	{
		this(object, null);
	}

	ListNode(String object, ListNode Node)  // 생성자
	{
		data = object;
		nextNode = Node;
	}

	Object getObject()
	{
		return data;
	}

	ListNode getnextNode()
	{
		return nextNode;
	}

}

```

**StackInheritanca.jaca**

```

/** 클래스 StackInheritance 
      용도 : stack자료구조를 클래스로 구현. 
*/
package com.example.calculator_v2;
public class StackInheritance 
{
	private ListNode firstNode;    // 첫 노드
	private ListNode lastNode;    // 마지막 노드
	private String name;
	
	public StackInheritance()
	{
		this("stack");
	}

	public StackInheritance(String listName)		// 생성자
	{
		name = listName;											// 스택의 이름과
		firstNode = lastNode = null;						// 초기의 첫노드와 마지막노드는 null값으로
	}

	/* 메소드 : public void push(String)
	    스택의 push를 구현. 
	 */
	public void push(String insertItem) 
	{
		if (isEmpty()) 
			firstNode = lastNode = new ListNode(insertItem);
		else
			firstNode = new ListNode(insertItem, firstNode);
	}

	/* 메소드 : public String pop()
	    스택의 pop를 구현. 호출시 스택의 맨 위 내용을 pop해주고 스택에서 삭제한다.
	 */
	public String pop() throws EmptyListException
	{
		if (isEmpty()) 
			throw new EmptyListException(name);

		String removedItem = firstNode.data;

		if (firstNode == lastNode)		//	첫노드와 마지막노드가 같으면 pop해주는 동시에 비어있게 되므로
			firstNode = lastNode = null;	// 전부 null로 처리
		else
			firstNode = firstNode.nextNode;

		return removedItem;
	}	

	/* 메소드 : public String stackTop()
	    스택의 맨 위의 값을 보여줌.
	 */
	public String stackTop() 
	{
		return firstNode.data;
	}
	
	/* 메소드 : public boolean isEmpty()
	    스택이 비어있는지 알려주는 메소드. 비어있으면 true 반환.
	 */
	public boolean isEmpty()
	{
		return firstNode == null;
	}
}

```

**Constants.java**

```

package com.example.calculator_v2;;=
public class Constants {
	public static final String plus 	= "+";
	public static final String minus	= "-";
	public static final String multiple = "x";
	public static final String divide 	= "/";
	public static final String rest 	= "%";
	public static final String square 	= "^";
	public static final String bracket1 = "(";
	public static final String bracket2 = ")";
	public static final String comma 	= ".";
	public static final String btn0 	= "0";
	public static final String btn1 	= "1";
	public static final String btn2 	= "2";
	public static final String btn3 	= "3";
	public static final String btn4 	= "4";
	public static final String btn5 	= "5";
	public static final String btn6 	= "6";
	public static final String btn7 	= "7";
	public static final String btn8		= "8";
	public static final String btn9		= "9";
	
}


```

**InfixToPostfixConvert.java**

```


public class InfixToPostfixConvert
{
	
    private StackInheritance stk;						// 스택 정의
	protected StringBuffer infix;						// 중위표기법 
	protected StringBuffer Postfix;					// 후위표기법 저장 공간
	protected String[] Operator = {"x","/","+","-","^","%"};		// 쓰이는 연산자들
	protected int[] OperRank = {2,2,1,1,3,2};								// 연산자들에 해당하는 우선순위. 높을수록 먼저 계산된다.
	protected final int OperLength = 6;										// 연산자들의 총 개수
	
	/* 생성자
	    스택을 정의하고, 인스턴스 생성시 파라메터로 받는 중위표기법을 저장.
		convertToPostfix 메소드를 통해 후위표기법을 저장하고 
		PostfixEvaluator 클래스에 내려줌.
	*/
	public InfixToPostfixConvert(StringBuffer infix) {				
		stk = new StackInheritance();
		this.infix = infix;
		this.Postfix = convertToPostfix();
	}

	/* 메소드 : public boolean isOperator(String)
	    연산자인지 아닌지 판단해줌.
	 */
	public boolean isOperator(String c)
	{
		for (int i=0; i<OperLength; i++)
			if (c.equals(Operator[i])) return true;
		return false;
	}

	/* 메소드 : public boolean precedence(String, String)
	    연산자 두개를 파라메터로 받고 
		앞의 연산자의 우선순위가 크다면 false.
		아니면 True.
	 */
	public boolean precedence(String oper1, String oper2)
	{
		int OperRank1 = 0;		// 각 연산자의 우선순위 저장 변수
		int OperRank2 = 0;
		
		for (int i=0; i<OperLength; i++) {
			if (oper1.equals(Operator[i])) OperRank1 = OperRank[i];
			if (oper2.equals(Operator[i])) OperRank2 = OperRank[i];
		}
		if (OperRank1 <= OperRank2)
			return true;
		else
			return false;	
	}

	/* 메소드 : public StringBuffer convertToPostfix()
	    중위표기법을 후위표기법으로 바꾸어주는 실질적인 메소드
		반환값은 후위표기법(StringBuffer형)이다.
	 */
	public StringBuffer convertToPostfix()
	{
		StringBuffer Postfix = new StringBuffer();	// 반환값(후위표기법) 저장장소
		String ch;	//	중위표기법 StringBuffer의 한글자씩 저장
		String stkch;	// 스택에서 pop한 값 저장
		int index;		

		stk.push("(");						// 먼저 스택에 왼쪽괄호를 넣어주고
		infix.append(")");				// 중위표기법String에 오른쪽괄호를 넣어준다. (전부 끝을 판단하기 위함이다.)
		index = 0;							

		while(!stk.isEmpty()) 
		{
			ch = infix.substring(index, index+1);    // 중위표기법String의 한글자씩 불러온다.
			if (ch.equals("(")) {								 // 왼쪽괄호면
				stk.push(ch);										 // 스택에 push
			}else if (ch.equals(")")){						 // 오른쪽괄호면
				stkch = stk.pop();								 
				while(!stkch.equals("(")) {				 // 왼쪽 괄호가 나올때까지 스택의 값을 pop하여
					Postfix.append(" " + stkch);		 // 반환값에 저장한다.
					stkch = stk.pop();
				}
			}else if (isOperator(ch)){						// 연산자이면
				stkch = stk.stackTop();
				while((isOperator(stkch)) && (precedence(ch,stkch))) {		// 연산자가 아니거나 맨 위에 있는 스택연산자가 자기보다 낮은게 나올때까지
					stkch = stk.pop();																		// 스택에서 pop하여
					Postfix.append(" " + stkch);													// 반환값에 저장한다.
					stkch = stk.stackTop();
				}	
				stk.push(ch);										// 그리고 자기자신은 push한다.
				Postfix.append(" ");							// 9이상의 숫자를 판단하기 위해 모든 연산자 및 숫자들은 빈칸으로 구분한다.
			}else {
				Postfix.append(ch);							// 숫자면 스택에 push. 
																			// 9이상의 숫자일수 있으므로 연산자나 괄호를 만날때까지는 빈칸을 넣지 않는다.
			}
			index++;													// 다음글자로 이동
		}
		
		return Postfix;											// 끝나면 저장된 후위표기법값을 반환
	}
}

```

**MainActivity.java**

```

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		tView = (TextView) findViewById(R.string.resultview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public void mOnClick(View v) {
		if(tView.getText().toString().equals("0")) {
			tView.setText("");
		}
		switch(v.getId()){
		case R.string.btn0:
			tView.append(Constants.btn0);
			break;
		case R.string.btn1:
			tView.append(Constants.btn1);
			break;
		case R.string.btn2:
			tView.append(Constants.btn2);
			break;
		case R.string.btn3:
			tView.append(Constants.btn3);
			break;
		case R.string.btn4:
			tView.append(Constants.btn4);
			break;
		case R.string.btn5:
			tView.append(Constants.btn5);
			break;
		case R.string.btn6:
			tView.append(Constants.btn6);
			break;
		case R.string.btn7:
			tView.append(Constants.btn7);
			break;
		case R.string.btn8:
			tView.append(Constants.btn8);
			break;
		case R.string.btn9:
			tView.append(Constants.btn9);
			break;
		case R.string.bracket1:
			tView.append(Constants.bracket1);
			break;
		case R.string.bracket2:
			tView.append(Constants.bracket2);
			break;
		case R.string.comma:
			CheckOper(tView, Constants.comma);
			break;
		case R.string.plus:
			CheckOper(tView, Constants.plus);
			break;
		case R.string.minus:
			CheckOper(tView, Constants.minus);
			break;
		case R.string.multiple:
			CheckOper(tView, Constants.multiple);
			break;
		case R.string.divide:
			CheckOper(tView, Constants.divide);
			break;
		case R.string.rest:
			CheckOper(tView, Constants.rest);
			break;
		case R.string.square:
			CheckOper(tView, Constants.square);
			break;
		case R.string.reset:
			tView.setText("0");
			break;
		case R.string.delete:
			DelLastVal(tView);
			break;
		case R.string.equal:
			String recvVal 	= tView.getText().toString();

			// 식의 정합성 체크
			if ( Check(recvVal) ) {		// 입력된 식이 연산자로 끝나는지 여부 판단.
				// 계산 시작
				
				//TODO
				StringBuffer infix = new StringBuffer(recvVal); 
				PostfixEvaluator PE = new PostfixEvaluator(infix);
//				CalcResult cr = new CalcResult(recvVal);
				String result = PE.evaluatePostfixExpression();
				
				tView.setText(result);
//				System.out.println("result = " + result);
			} 
//			else if( !(recvVal.contains(Constants.plus) && recvVal.contains(Constants.minus) && recvVal.contains(Constants.multiple) && recvVal.contains(Constants.divide)) ) {
//				String currentVal = tView.getText().toString();
//				tView.setText(currentVal);
//			} 
			else {
				Toast.makeText(getApplicationContext(), "식을 끝까지 입력하세요!", Toast.LENGTH_SHORT).show();
			}
			break; 
		}
	}

	private boolean Check(String recvVal) {
		// 식이 연산자로 끝나면 False
		if( recvVal.endsWith(Constants.plus) || recvVal.endsWith(Constants.minus) || recvVal.endsWith(Constants.multiple) || recvVal.endsWith(Constants.divide)) {
			return false;	
			
//		} else if(  !(recvVal.contains(Constants.plus) && recvVal.contains(Constants.minus) && recvVal.contains(Constants.multiple) && recvVal.contains(Constants.divide)) ) {
//			return false;
		} else {
			return true;
		}
	}

	private void CheckOper(TextView tView, String calcOper) {
		String chkVal	= null;
		String recvVal 	= tView.getText().toString();
		System.out.println("recvVal : " + recvVal);
		try {
			// 최초 입력 시 숫자 값보다 연산기호가 먼저 나오면 예외 처리...
			// 글자가 아닌 값이 나온 상태에서 subString을 하면 예외가 발생하는 듯...
			chkVal = recvVal.substring( (recvVal.length()-1), (recvVal.length()) );
		} catch(StringIndexOutOfBoundsException e) {
			Toast.makeText(getApplicationContext(), "값부터 입력하세요!!", Toast.LENGTH_SHORT).show();
		}
		
		if (!recvVal.equals("")) {
			// 연산 기호가 연속으로 나오지 않으면 연산 기호를 화면에 뿌린다.
			System.out.println("chkVal : " + chkVal);
			if (!(chkVal.equals(Constants.plus))
					&& !(chkVal.equals(Constants.minus))
					&& !(chkVal.equals(Constants.multiple))
					&& !(chkVal.equals(Constants.divide))) {
				tView.append(calcOper);
			} else {
				//연산 기호가 연속으로 나오면 예외 처리를 한다.
				Toast.makeText(getApplicationContext(), "연산 중복 사용 불가!", Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void DelLastVal(TextView tView) {
		String recvVal = tView.getText().toString();
		if(recvVal.equals("") || recvVal == null) {
			Toast.makeText(getApplicationContext(), "지울 값이 없습니다.", Toast.LENGTH_SHORT).show();
		} else {
			recvVal = recvVal.substring(0, (recvVal.length() - 1));
			tView.setText(recvVal);
		}
	}


```

**PostfixEvaluator.java**

```

public class PostfixEvaluator extends InfixToPostfixConvert
{
	
	private StackInheritance Numberstack;		// 스택 정의.
	
	/* 생성자
	   InfixToPostfixConvert클래스를 상속받으므로 처음 이 클래스를 인스턴스로 선언할 때
	   중위표기법을 파라메터로 받아, 상위 클래스로 전달해주면
	   InfixToPostfixConvert클래스의 StringBuffer Postfix로 저장이 되므로 
	   그 값을 그대로 이 클래스에서 사용할 수 있다.
	*/
	public PostfixEvaluator(StringBuffer infix) {
		super(infix);
		Numberstack = new StackInheritance();	// 스택 선언.
	}
    
	/* 메소드 : public int calculate(int, int, String)
	    숫자 두개와 연산자를 받아 계산하여 값을 반환.
	 */
	public double calculate(double op1, double op2, String oper)
	{
		if (oper.equals("+"))
			return op1 + op2;
		else if (oper.equals("-"))
			return op1 - op2;
		else if (oper.equals("x"))
			return op1 * op2;
		else if (oper.equals("/"))
			return op1 / op2;
		else if (oper.equals("%"))
			return op1 % op2;
		else if (oper.equals("^")) {
			double ans = 1;
			for(int i=0; i<op2; i++) {	
				ans *= op1;
			}
			return ans;
		}
		else	
			return 0;
	}

	/* 메소드 : public int evaluatePostfixExpression()
	    후위표기법을 실제 계산해주는 메소드. 계산된 값을 반환해준다.
	 */
	public String evaluatePostfixExpression()
	{
		String Post = "";				// 후위표기법값의 한글자씩 저장하는 장소
		String ch = "";					// 숫자가 두자리이상일 경우 글자들을 누적시키는 장소
		int index = 0;
		double x, y;							// 스택에서 pop한 두수를 저장					
		double _result;						// 계산된 값을 저장

		Postfix.append(" )");									// 후위표기법의 뒤에 오른쪽 괄호를 저장(끝을 판단하기 위함.)
		Post = Postfix.substring(index, index+1);	 
		while(!Post.equals(")")) {							// 후위표기법의 한글자를 가져와, 그 글자가 오른쪽 괄호일 때까지 실행
			if (Post.equals(" "))									// 빈칸이면 한 토큰이 완료됨. 이 때부터 여러가지 판단 시작
			{	
				if (isOperator(ch))								// 연산자이면
				{
					
					x = Double.parseDouble(Numberstack.pop());		// 스택에서 두 숫자를 pop하여
					y = Double.parseDouble(Numberstack.pop());

					_result = calculate(y, x, ch);									// 두수와 연산자를 이용 계산하여
					double result = Double.parseDouble(String.format("%.6f", _result));
					Numberstack.push(String.valueOf(result));   // 계산된 값을 스택에 push해줌
				} else {
					Numberstack.push(ch);										// 숫자면 바로 스택에 push.
				}
				ch = "";																		// 한 토큰이 끝났으므로 누적 값은 초기화.
			} else {
				ch += Post;																	// 빈칸이 나올 때까지는 계속 문자열을 누적시킴.
			}
			index++;
			Post = Postfix.substring(index, index+1);
		}
		return ""+Numberstack.pop();			// 결과값을 반환해줌.
	}
}

```

# 레이아웃 #

**activity\_main.xml**

```

<RelativeLayout xmlns:a="http://schemas.android.com/apk/res/android" xmlns:tools="http://schemas.android.com/tools" a:layout_width="match_parent" a:layout_height="match_parent" tools:context=".MainActivity" >
    <!-- 입력창 -->
	<LinearLayout a:layout_width="fill_parent" a:layout_height="wrap_content" a:id="@string/tvlayout">
		<TextView a:layout_width="fill_parent" a:layout_height="wrap_content" a:id="@string/resultview" a:textSize="30sp" />
	</LinearLayout>	
	<!-- 계산기 버튼 --> 
	<LinearLayout a:layout_width="fill_parent" a:layout_height="wrap_content" a:id="@string/layout1" a:layout_above="@string/layout2">
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn1" a:onClick="mOnClick" a:text="@string/btn1" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn2" a:onClick="mOnClick" a:text="@string/btn2" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn3" a:onClick="mOnClick" a:text="@string/btn3" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/bracket1" a:onClick="mOnClick" a:text="@string/bracket1" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/bracket2" a:onClick="mOnClick" a:text="@string/bracket2" a:layout_weight="1"/>
	</LinearLayout>	
	
	<LinearLayout a:layout_width="fill_parent" a:layout_height="wrap_content" a:id="@string/layout2" a:layout_above="@string/layout3">
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn4" a:onClick="mOnClick" a:text="@string/btn4" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn5" a:onClick="mOnClick" a:text="@string/btn5" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn6" a:onClick="mOnClick" a:text="@string/btn6" a:layout_weight="1"/>
		<Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/plus" a:onClick="mOnClick" a:text="@string/plus" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/minus" a:onClick="mOnClick" a:text="@string/minus" a:layout_weight="1"/>
	</LinearLayout>    
	
	<LinearLayout a:layout_width="fill_parent" a:layout_height="wrap_content" a:id="@string/layout3" a:layout_above="@string/layout4">
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn7" a:onClick="mOnClick" a:text="@string/btn7" a:layout_weight="1" />
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn8" a:onClick="mOnClick" a:text="@string/btn8" a:layout_weight="1"/>
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn9" a:onClick="mOnClick" a:text="@string/btn9" a:layout_weight="1"/>
	   	<Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/multiple" a:onClick="mOnClick" a:text="@string/multiple" a:layout_weight="1"/>
	   	<Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/divide" a:onClick="mOnClick" a:text="@string/divide" a:layout_weight="1"/>
	</LinearLayout>
	 
	<LinearLayout a:layout_width="fill_parent" a:layout_height="wrap_content" a:id="@string/layout4" a:layout_above="@string/layout5">
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/reset" a:onClick="mOnClick" a:text="@string/reset" a:layout_weight="1"/>
   	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/btn0" a:onClick="mOnClick" a:text="@string/btn0" a:layout_weight="1"/>
   	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/delete" a:onClick="mOnClick" a:text="@string/delete" a:layout_weight="1"/>
        <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/square" a:onClick="mOnClick" a:text="@string/square" a:layout_weight="1"/>
   	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/rest" a:onClick="mOnClick" a:text="@string/rest" a:layout_weight="1"/>
	</LinearLayout>
	
	<LinearLayout a:layout_width="fill_parent" a:layout_height="wrap_content" a:id="@string/layout5" a:layout_alignParentBottom="true">
	    <Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/comma" a:onClick="mOnClick" a:text="@string/comma" a:layout_weight="1"/>
	   	<Button a:layout_width="wrap_content" a:layout_height="wrap_content" a:id="@string/equal" a:onClick="mOnClick" a:text="@string/equal" a:layout_weight="10"/>
	</LinearLayout>
</RelativeLayout>

```

# 소스코드 출처 #
http://blog.naver.com/since201109?Redirect=Log&logNo=150155806387&from=postView