# Introduction #

전형적인 공학용 계산기입니다. 일반 계산기보다 더 추가된 기능이 있습니다.

# Background #

이과생이고 컴퓨터 과학 개론 등을 공부하다 보면 일반 계산기로는 부족하다는 느낌이 많이 들기 때문에 보다 더 편리하고 유용한 공학용 계산기를 생각하게 되었습니다.

# Details #

사칙연산과 같은 여러 간단한 연산들도 가능하고 sin, cos, tan 계산 및 10진법에서  2진법,8진법,12진법 등으로 변환 등을 하도록 만들 예정입니다.

# Using the Code #

import java.awt.**;**

import java.awt.event.**;**

import java.util.**;**

import javax.swing.**;**

class QuestionThree extends Frame implements ActionListener, KeyListener

{

final int PREV\_PUSH\_NUMBER = 0;

final int PREV\_PUSH\_OPERATOR = 1;

final int PREV\_PUSH\_EQUAL = 2;

JTextField resultBox, memoryState;

Button[.md](.md) calcButton;

boolean isBelowZero;

double number, result;

double memory;

int zeroLocation;

char preOperator;

int checkStatus;

final Color BACKGROUND = new Color( 192, 192, 192 );

public QuestionThree( String title )

{

super( title );

setSize( 300, 200 );

setBackground( BACKGROUND );

setLayout( new BorderLayout() );

resultBox = new JTextField( "0." );

resultBox.setHorizontalAlignment( JTextField.RIGHT );

resultBox.setEnabled( false );

resultBox.addKeyListener( this );

add( resultBox, BorderLayout.NORTH );

memoryState = new JTextField();

memoryState.setEnabled( false );

memoryState.setHorizontalAlignment( JTextField.CENTER );

calcButton = new Button[20](20.md);

for (int i=0; i<20 ; i++)

{

calcButton[i](i.md) = new Button();

calcButton[i](i.md).addActionListener( this );

calcButton[i](i.md).addKeyListener( this );

}

calcButton[0](0.md).setLabel( "+" );

calcButton[1](1.md).setLabel( "-" );

calcButton[2](2.md).setLabel( "**" );**

calcButton[3](3.md).setLabel( "/" );

calcButton[4](4.md).setLabel( "7" );

calcButton[5](5.md).setLabel( "8" );

calcButton[6](6.md).setLabel( "9" );

calcButton[7](7.md).setLabel( "+/-" );

calcButton[8](8.md).setLabel( "BACK" );

calcButton[9](9.md).setLabel( "4" );

calcButton[10](10.md).setLabel( "5" );

calcButton[11](11.md).setLabel( "6" );

calcButton[12](12.md).setLabel( "." );

calcButton[13](13.md).setLabel( "CE" );

calcButton[14](14.md).setLabel( "1" );

calcButton[15](15.md).setLabel( "2" );

calcButton[16](16.md).setLabel( "3" );

calcButton[17](17.md).setLabel( "=" );

calcButton[18](18.md).setLabel( "C" );

calcButton[19](19.md).setLabel( "0" );

addKeyListener( this );

Panel p = new Panel();

p.setLayout( new GridLayout( 5, 5, 5, 5 ) );

p.addKeyListener( this );

p.add( memoryState );

for ( int i=0; i<20; i++)

{

p.add( calcButton[i](i.md) );

}

add( p, BorderLayout.CENTER );

addWindowListener( new windowAdapter() );

buttonC();

calcButton[2](2.md).requestFocus();

}

class windowAdapter extends WindowAdapter

{

public void windowClosing( WindowEvent e )

{

System.exit(0);

}

};

public void keyPressed( KeyEvent e ) {}

public void keyReleased( KeyEvent e ) {}

public void keyTyped( KeyEvent e )

{

int pushKey = (int)e.getKeyChar();

char pushChar = e.getKeyChar();

if (pushKey>=0x30 && pushKey<=0x39)

{

buttonNumber( pushKey-0x30 );

}

else

{

switch (pushChar)

{

case '+':

calculate( "+" );

break;

case '-':

calculate( "-" );

break;

case '**':**

calculate( "**" );**

break;

case '/':

calculate( "/" );

break;

case '=':

calculate( "=" );

break;

case '.': // .

isBelowZero = true;

break;

case 'C':

case 'c':

buttonC();

break;

}

}

}

public void buttonNumber( int pushNumber )

{

switch (checkStatus)

{

case PREV\_PUSH\_OPERATOR:

buttonCE();

break;

case PREV\_PUSH\_EQUAL:

buttonC();

break;

}

String prevString = resultBox.getText();

if (isBelowZero)

resultBox.setText( prevString + String.valueOf(pushNumber) );

else

{

if (prevString.charAt(0)=='0')

{

resultBox.setText(

String.valueOf( pushNumber ) +

prevString.substring( 1 )

);

}

else

{

String before = prevString.substring( 0, zeroLocation );

String after = prevString.substring( zeroLocation );

resultBox.setText( before + String.valueOf( pushNumber ) +

after );

zeroLocation++;

}

}

checkStatus = PREV\_PUSH\_NUMBER;

}

public void calculate( String strPushOperator )

{

char pushOperator = strPushOperator.charAt(0);

number = Double.parseDouble( resultBox.getText() );

switch (preOperator)

{

case '+':

result += number;

break;

case '-':

result -= number;

break;

case '**':**

result **= number;**

break;

case '/':

result /= number;

break;

default:

result = number;

break;

}

String resultText = String.valueOf( result );

if ((resultText.length()-2)==resultText.indexOf( "." ))

{

if (resultText.charAt( resultText.length()-1 )=='0')

{

resultText = resultText.substring( 0, resultText.length()-1 );

}

}

resultBox.setText( resultText );

preOperator = pushOperator;

if (pushOperator=='=')

checkStatus = PREV\_PUSH\_EQUAL;

else

checkStatus = PREV\_PUSH\_OPERATOR;

}

public void buttonC()

{

isBelowZero = false;

number = 0;

result = 0;

preOperator = ' ';

zeroLocation = 1;

resultBox.setText( "0." );

checkStatus = PREV\_PUSH\_NUMBER;

}

public void buttonCE()

{

resultBox.setText( "0." );

isBelowZero = false;

zeroLocation = 1;

}

public void memoryProcess( char delimeter )

{

switch (delimeter)

{

case 'S':

memory = Double.parseDouble( resultBox.getText() );

memoryState.setText( "M" );

break;

case 'R':

resultBox.setText( String.valueOf( memory ) );

String resultText = resultBox.getText();

if ((resultText.length()-2)==resultText.indexOf( "." ))

{

if (resultText.charAt( resultText.length()-1 )=='0')

{

resultBox.setText( resultText.substring( 0, resultText.length()-1 ) );

}

}

break;

case 'C':

memory = 0;

memoryState.setText( "" );

break;

case '+':

memory += Double.parseDouble( resultBox.getText() );

memoryState.setText( "M" );

break;

}

}

public void backSpace()

{

String resultText = resultBox.getText();

if (checkStatus==PREV\_PUSH\_NUMBER)

{

if (isBelowZero)

{

int len = resultText.length();

resultText = resultText.substring( 0, len-1 );

resultBox.setText( resultText );

if (resultText.charAt( len-2 )=='.')

isBelowZero = false;

}

else

{

int len = resultText.length();

resultText = resultText.substring( 0, len-2 ) + ".";

zeroLocation--;

resultBox.setText( resultText );

}

if (resultText.length()==1)

{

buttonCE();

}

}

}

public void changeAbs()

{

String resultText = resultBox.getText();

if (checkStatus==PREV\_PUSH\_NUMBER)

{

if (resultText.charAt(0)=='-')

{

resultText = resultText.substring( 1 );

}

else

{

resultText = "-" + resultText;

}

resultBox.setText( resultText );

}

}

public void actionPerformed( ActionEvent e )

{

String targetLabel = ((Button)e.getSource()).getLabel();

try {

if ( Integer.parseInt( targetLabel ) > 0 || targetLabel.equals( "0" ) )

{

buttonNumber( Integer.parseInt( targetLabel ) );

return;

}

} catch( NumberFormatException ne ) {};

if (targetLabel.equals( "CE" ))

buttonCE();

if (targetLabel.equals( "C" ))

buttonC();

if (targetLabel.equals( "." ))

isBelowZero = true;

if (targetLabel.equals( "+" ) | targetLabel.equals( "-" ) |
|:--------------------------|

targetLabel.equals( "**" )**| targetLabel.equals( "/" ) |
|:--------------------------|

targetLabel.equals( "=" ) )

calculate( targetLabel );

if (targetLabel.charAt(0) == 'M')

memoryProcess( targetLabel.charAt(1) );

if (targetLabel.charAt(0) == 'B')

backSpace();

if (targetLabel.equals("+/-"))

changeAbs();

}

public static void main(String[.md](.md) args)

{

QuestionThree qt = new QuestionThree( "Question Three" );
;
qt.show();

}

}


Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages