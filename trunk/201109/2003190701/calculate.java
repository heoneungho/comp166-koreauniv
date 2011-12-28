/*�ѹ��� �Ѱ��� ��길 ����, a + b * c ���� �Ұ�,
��ȣ�� ������ �̹� ������ ���ڿ� ��ȣ�� ������� ����, 
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class calculate extends Frame implements ActionListener{
	//�⺻������ ���� GUI�� ��ư�� �������� �׼Ǽ���
	private Frame frm; 
	private Button btn[]; // ������ ��ư��
	private Panel pan; //��ư�� ��ġ�� ��
	private double num1, num2, num3; //�Է��� �� ����, ��갪
	private TextField text; // ���ڰ� ���� ����
	private String symbol; // ��ȣ�� ���� �Ű�����
	
	
	public calculate( ){ //�������ε� GUI ����

		btn = new Button[17]; //10�� ����, 4�� ����, =, �Ҽ���, c
		pan=new Panel(new GridLayout(4,4));
		// GUI ���� ����, �׸��巹�̾ƿ��� ����̳� �ٵ��� ��� ��ư
		text = new TextField(20); // ��ȣ���� �Է°��ɱ��� 
		num1=0.0; num2=0.0; num3=0.0; //�ʱ�ȭ
		
		text.setText(""); // ���ڰ� ������ ���� �ʱ�ȭ
		
		
		for(int i=0; i<=9; i++)
        {
            btn[i] = new Button(String.valueOf(i));
        } //��ư 0������ ����0 ǥ��, ��ư 9������ ���� 9 ǥ��
		
		btn[10] = new Button("+");
        btn[11] = new Button("-");
        btn[12] = new Button("*");
        btn[13] = new Button("/");
        btn[14] = new Button("=");
        btn[15] = new Button(".");
		btn[16] = new Button("c");
	
		pan.add(btn[1]); //pan �� 4x4 ������ ��� ���
		pan.add(btn[2]);
		pan.add(btn[3]);  //�� ������ 1,2,3�� ��ġ
		pan.add(btn[10]); //�� ���� 4��° ��ư��  +
		pan.add(btn[4]);
		pan.add(btn[5]);
		pan.add(btn[6]);
		pan.add(btn[11]); //�ι�° ���� 4���� ��ư�� -
		pan.add(btn[7]);
		pan.add(btn[8]);
		pan.add(btn[9]);
		pan.add(btn[12]); //����° ���� 4��° ��ư�� *
		pan.add(btn[0]);
		pan.add(btn[15]); //�Ҽ����� �� ���࿡ ��ġ
		pan.add(btn[14]); //= ���� �� ���࿡ ��ġ
		pan.add(btn[13]); //�׹�° ���� 4��° ��ư�� / 
		
		setLayout(new BorderLayout());
		add(pan, BorderLayout.CENTER); //4x4 �簢���� �߽�
		add(btn[16], BorderLayout.EAST); //Ŭ����� �����ʿ�
        add(text, BorderLayout.NORTH); //�ؽ�Ʈ�ʵ�� ����
        
        for(int i=0; i<=16; i++)
        {			//��ư�������̺�Ʈ�Ͼ�� ����
          btn[i].addActionListener(this);
        }
                
	 }
		 
	 	
	public void actionPerformed(ActionEvent ae) {
		//�׼ǿ� ���� �̺�Ʈ�� �Ͼ�� �Ķ���͸� ae�� �״�.
		for(int i=0; i<=16; i++)
		{
			if(ae.getSource() == btn[i])
			{// ���� ��ư�� �ҽ��� �ش� ��ư�϶�
				switch(i)
                {	
                case 0: //0�� �������� ���� �ؽ�Ʈ�ʵ忡 0�� �߰�
                	text.setText(text.getText() + "0");
				break;
                case 1: //1�� �������� ���� �ؽ�Ʈ�ʵ忡 1�� �߰�
                	text.setText(text.getText() + "1");
				break;
                case 2: //2�� �������� ���� �ؽ�Ʈ�ʵ忡 2�� �߰�
                	text.setText(text.getText() + "2");
				break;
                case 3: //3�� �������� ���� �ؽ�Ʈ�ʵ忡 3�� �߰�
                	text.setText(text.getText() + "3");
				break;
                case 4: //4�� �������� ���� �ؽ�Ʈ�ʵ忡 4�� �߰�
                	text.setText(text.getText() + "4");
				break;
                case 5: //5�� �������� ���� �ؽ�Ʈ�ʵ忡 5�� �߰�
                	text.setText(text.getText() + "5");
				break;
                case 6: //6�� �������� ���� �ؽ�Ʈ�ʵ忡 0�� �߰�
                	text.setText(text.getText() + "6");
				break;
                case 7: //7�� �������� ���� �ؽ�Ʈ�ʵ忡 7�� �߰�
                	text.setText(text.getText() + "7");
				break;
                case 8: //8�� �������� ���� �ؽ�Ʈ�ʵ忡 8�� �߰�
                	text.setText(text.getText() + "8");
				break;
                case 9: //9�� �������� ���� �ؽ�Ʈ�ʵ忡 9�� �߰�
                	text.setText(text.getText() + "9");
				break;
				
                case 10://btn[10]�� �����̹Ƿ�
                 //��ȣ�� ������ �������� �Է��� ���ڸ� num1�� ����
                	symbol="+";
                    num1 = Double.parseDouble(text.getText());
                    text.setText(""); //�Է��� ���ڸ� �Ҽ���ȯ
               /*
                text.setText(text.getText() + "+");
               ���ڸ� ���ܵΰ� ������ num2 �ν� ������ ��¿�� ���� ��ĭȭ
                */
                    break;  
                case 11://btn[11]�� �����̹Ƿ�
                    symbol="-";
                    num1 = Double.parseDouble(text.getText());
                    text.setText("");
                    break;
                case 12://btn[12]�� �����̹Ƿ�
                	symbol="*";
                    num1 = Double.parseDouble(text.getText());
                    text.setText("");
                    break;
                case 13://btn[13]�� �������̹Ƿ�
                	symbol="/";
                    num1= Double.parseDouble(text.getText());
                    text.setText("");
                    break;
                case 14:// = ���� �� ���ڴ� �ι�° ���� num2�� ����
                    num2 = Double.parseDouble(text.getText());
                   /* ��ȣ �Է��� ������¸� ������� ������ 
                                                    �ٽ� ���ڸ� �Է��ϰ� =�� �Է��ϸ� num2�� �ν�*/
                   
                    switch(symbol) //case 14�ȿ��� case��
                    {
                    case "+":
                    	num3= num1+num2; //num3�� ������ ����
                    	Double answer1= new Double(num3);
                    	text.setText(answer1.toString());
                    break; /*num3�� toString���� ��ȯ�� �ȵǴµ�,
                      answer�� num3�� ���� �� ������
     toString�� ���� setText���� �䱸�ϴ�  ��Ʈ�����·� ��ȯ*/
                               
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
                   
                    }  //case 14�ȿ��� case�� ����
                    break; // case14�� �극��ũ
                    
                case 15: // �Ҽ���
                	text.setText(text.getText() + ".");
                    break;
                    //num1�� num2�� ��ȣ�� =�� �ν��ϱ� ������
				
                case 16: // Ŭ����
                	text.setText("");
                	break;
			}// ����ġ�� ����
		}//if �� ����
	  }// for �� ����
	}// actionPerformed ����

	public static void main(String args[])
	{
		calculate cal = new calculate(); //���� ��ü ����
		cal.setBounds(100, 100, 300, 300);
		 //������ 100,100, ���μ��� 300,300
		cal.setVisible(true);
		cal.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
            	System.out.println("Window Closing");
                System.exit(0); 
            } //addWindowListener�� ����â �����ư Ȱ��ȭ		
	    }); //addWindowListener����
	}
}