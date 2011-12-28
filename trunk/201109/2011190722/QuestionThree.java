import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class QuestionThree extends Frame implements ActionListener, KeyListener
{
	final int PREV_PUSH_NUMBER = 0;
	final int PREV_PUSH_OPERATOR = 1;
	final int PREV_PUSH_EQUAL = 2;
	JTextField resultBox, memoryState;
	Button[] calcButton;
	boolean isBelowZero;
	double number, result;
	double memory;
	int zeroLocation;
	char preOperator;
	int checkStatus;
	final Color BACKGROUND = new Color(192, 192, 192);
	public QuestionThree(String title)
	{
		super(title);
		setSize(300, 200);
		setBackground(BACKGROUND);
		setLayout(new BorderLayout());
		resultBox = new JTextField("0.");
		resultBox.setHorizontalAlignment(JTextField.RIGHT);
		resultBox.setEnabled(false);
		resultBox.addKeyListener(this);
		add(resultBox, BorderLayout.NORTH);
		memoryState = new JTextField();
		memoryState.setEnabled(false);
		memoryState.setHorizontalAlignment(JTextField.CENTER);
		calcButton = new Button[20];
		for (int i = 0; i < 20; i++)
		{
			calcButton[i] = new Button();
			calcButton[i].addActionListener(this);
			calcButton[i].addKeyListener(this);
		}
		calcButton[0].setLabel("+");
		calcButton[1].setLabel("-");
		calcButton[2].setLabel("*");
		calcButton[3].setLabel("/");
		calcButton[4].setLabel("7");
		calcButton[5].setLabel("8");
		calcButton[6].setLabel("9");
		calcButton[7].setLabel("+/-");
		calcButton[8].setLabel("BACK");
		calcButton[9].setLabel("4");
		calcButton[10].setLabel("5");
		calcButton[11].setLabel("6");
		calcButton[12].setLabel(".");
		calcButton[13].setLabel("CE");
		calcButton[14].setLabel("1");
		calcButton[15].setLabel("2");
		calcButton[16].setLabel("3");
		calcButton[17].setLabel("=");
		calcButton[18].setLabel("C");
		calcButton[19].setLabel("0");
		addKeyListener(this);
		Panel p = new Panel();
		p.setLayout(new GridLayout(5, 5, 5, 5));
		p.addKeyListener(this);
		p.add(memoryState);
		for (int i = 0; i < 20; i++)
		{
			p.add(calcButton[i]);
		}
		add(p, BorderLayout.CENTER);
		addWindowListener(new windowAdapter());
		buttonC();
		calcButton[2].requestFocus();
	}
	class windowAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	};
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e)
	{
		int pushKey = (int) e.getKeyChar();
		char pushChar = e.getKeyChar();
		if (pushKey >= 0x30 && pushKey <= 0x39)
		{
			buttonNumber(pushKey - 0x30);
		}
		else
		{
			switch (pushChar)
			{
			case '+':
				calculate("+");
				break;
			case '-':
				calculate("-");
				break;
			case '*':
				calculate("*");
				break;
			case '/':
				calculate("/");
				break;
			case '=':
				calculate("=");
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
	public void buttonNumber(int pushNumber)
	{
		switch (checkStatus)
		{
		case PREV_PUSH_OPERATOR:
			buttonCE();
			break;
		case PREV_PUSH_EQUAL:
			buttonC();
			break;
		}
		String prevString = resultBox.getText();
		if (isBelowZero)
			resultBox.setText(prevString + String.valueOf(pushNumber));
		else
		{
			if (prevString.charAt(0) == '0')
			{
				resultBox.setText(
				String.valueOf(pushNumber) +
				prevString.substring(1)
				);
			}
			else
			{
				String before = prevString.substring(0, zeroLocation);
				String after = prevString.substring(zeroLocation);
				resultBox.setText(before + String.valueOf(pushNumber) +
				after);
				zeroLocation++;
			}
		}
		checkStatus = PREV_PUSH_NUMBER;
	}
	public void calculate(String strPushOperator)
	{
		char pushOperator = strPushOperator.charAt(0);
		number = Double.parseDouble(resultBox.getText());
		switch (preOperator)
		{
		case '+':
			result += number;
			break;
		case '-':
			result -= number;
			break;
		case '*':
			result *= number;
			break;
		case '/':
			result /= number;
			break;
		default:
			result = number;
			break;
		}
		String resultText = String.valueOf(result);
		if ((resultText.length() - 2) == resultText.indexOf("."))
		{
			if (resultText.charAt(resultText.length() - 1) == '0')
			{
				resultText = resultText.substring(0, resultText.length() - 1);
			}
		}
		resultBox.setText(resultText);
		preOperator = pushOperator;
		if (pushOperator == '=')
			checkStatus = PREV_PUSH_EQUAL;
		else
			checkStatus = PREV_PUSH_OPERATOR;
	}
	public void buttonC()
	{
		isBelowZero = false;
		number = 0;
		result = 0;
		preOperator = ' ';
		zeroLocation = 1;
		resultBox.setText("0.");
		checkStatus = PREV_PUSH_NUMBER;
	}
	public void buttonCE()
	{
		resultBox.setText("0.");
		isBelowZero = false;
		zeroLocation = 1;
	}
	public void memoryProcess(char delimeter)
	{
		switch (delimeter)
		{
		case 'S':
			memory = Double.parseDouble(resultBox.getText());
			memoryState.setText("M");
			break;
		case 'R':
			resultBox.setText(String.valueOf(memory));
			String resultText = resultBox.getText();
			if ((resultText.length() - 2) == resultText.indexOf("."))
			{
				if (resultText.charAt(resultText.length() - 1) == '0')
				{
					resultBox.setText(resultText.substring(0,
							resultText.length() - 1));
				}
			}
			break;
		case 'C':
			memory = 0;
			memoryState.setText("");
			break;
		case '+':
			memory += Double.parseDouble(resultBox.getText());
			memoryState.setText("M");
			break;
		}
	}
	public void backSpace()
	{
		String resultText = resultBox.getText();
		if (checkStatus == PREV_PUSH_NUMBER)
		{
			if (isBelowZero)
			{
				int len = resultText.length();
				resultText = resultText.substring(0, len - 1);
				resultBox.setText(resultText);
				if (resultText.charAt(len - 2) == '.')
					isBelowZero = false;
			}
			else
			{
				int len = resultText.length();
				resultText = resultText.substring(0, len - 2) + ".";
				zeroLocation--;
				resultBox.setText(resultText);
			}
			if (resultText.length() == 1)
			{
				buttonCE();
			}
		}
	}
	public void changeAbs()
	{
		String resultText = resultBox.getText();
		if (checkStatus == PREV_PUSH_NUMBER)
		{
			if (resultText.charAt(0) == '-')
			{
				resultText = resultText.substring(1);
			}
			else
			{
				resultText = "-" + resultText;
			}
			resultBox.setText(resultText);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		String targetLabel = ((Button) e.getSource()).getLabel();
		try {
			if (Integer.parseInt(targetLabel) > 0 || targetLabel.equals("0"))
			{
				buttonNumber(Integer.parseInt(targetLabel));
				return;
			}
		} catch (NumberFormatException ne) {
		}
		;
		if (targetLabel.equals("CE"))
			buttonCE();
		if (targetLabel.equals("C"))
			buttonC();
		if (targetLabel.equals("."))
			isBelowZero = true;
		if (targetLabel.equals("+") || targetLabel.equals("-") ||
		targetLabel.equals("*") || targetLabel.equals("/") ||
		targetLabel.equals("="))
			calculate(targetLabel);
		if (targetLabel.charAt(0) == 'M')
			memoryProcess(targetLabel.charAt(1));
		if (targetLabel.charAt(0) == 'B')
			backSpace();
		if (targetLabel.equals("+/-"))
			changeAbs();
	}
	public static void main(String[] args)
	{
		QuestionThree qt = new QuestionThree("Question Three");
		;
		qt.show();
	}
}