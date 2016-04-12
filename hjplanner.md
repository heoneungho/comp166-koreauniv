# Introduction #
2012190715 김현주님의 자바프로젝트입니다.


# Details #
- 원래 계획은 용돈관리, 일정관리가 가능한 플래너를 만드는 것이었으나,
날짜별로 저장하고 로딩하는 알고리즘으로 프로그래밍하는게 너무 어려워서 주제를 바꾸게 되었습니다.

![http://comp166-koreauniv.googlecode.com/files/자판기.jpg](http://comp166-koreauniv.googlecode.com/files/자판기.jpg)


──────────────────────────────────────────────────────────────────────────────────────────────


**1. 발상 및 구동 알고리즘(음료수 자판기의 기능)**


- 플래너를 포기하고 새롭게 정한 프로그램들의 후보는 음료수 자판기, 운세 프로그램, 가위바위보 게임이었습니다. 제가 이 세가지 주제 중 음료수 자판기를 선택한 이유는 운세 프로그램의 경우 구현 알고리즘이 너무나 간단하였습니다. 랜덤한 숫자를 생성하여 그 숫자에 해당하는 배열에 저장된 String 내용(운세가 적혀있습니다)을 출력하는 방식이어서 클래스도 한개뿐인 재미없는 프로그램이었습니다. 그리고 가위바위보 게임의 경우엔 이기고 지는 과정을 구현하기가 조금 어렵지만, 그걸로 끝이었기 때문에 전 결과적으로 제가 제 수준에서 최대한 잘 구현할 수 있는 기능들이 담겨 있는 음료수 자판기를 선택하게 되었습니다.


- 제가 넣으려고 계획한 음료수 자판기의 기능들은 다음과 같습니다.

① 넣은 금액을 표시해 줍니다.

② 넣은 금액을 0원으로 만들어주는 반환 레버 기능이 있습니다.

③ 자판기의 음료수 갯수는 정해져 있으며, 정해진 갯수가 다 팔리게 되면 매진되었다는 메시지가 출력됩니다.

④ 음료수의 가격보다 넣은 금액이 더 적은 경우, 돈을 넣어달라는 메시지가 출력된다.

⑤ GUI를 이용합니다.

⑥ 다양한 음료수를 판매합니다.

⑦ 현재 가격 표시 텍스트필드에 \라는 통화 기호와 세자리별로 콤마를 넣어서 구분이 용이하게 했습니다.


- 하지만 제 코딩실력의 한계로 인해 원하는 대로 구현하지 못한 부분도 존재합니다.

① 음료수 별로 가격 차별화를 두지 못했습니다. (모두 1000원으로 고정했습니다.)

② 제가 가지고 있는 돈은 오직 500원들 뿐입니다. 500원 단위로 넣은 금액이 상승하게 됩니다.(물론 전 부자이므로 500원짜리가 무한개 있습니다.)

③ 자판기의 현재 음료수 갯수를 개별적으로 각각 표시 할 수 있는 창을 만들었다면 더 좋았을 것 같습니다.


──────────────────────────────────────────────────────────────────────────────────────────────

**2. 2012년 12월 4일 java project 시연 이후 개선된 기능들**

- 음료수의 갯수에 한계를 두어 실제 자판기 같이 매진 기능을 넣었습니다.

- 매진이 될 경우 매진이라는 메시지 창을 뜨게 했습니다.

- 시연때는 음료수의 개당 가격을 1원으로 두었으나 개선 이후 개당 1000원으로 바꾸었습니다.

──────────────────────────────────────────────────────────────────────────────────────────────


**3. 참고한 사이트 및 문헌**

ⓛ 기본적인 기능 관련 소스코드
- http://www.dynamicdrive.com/forums/showthread.php?46605-Vending-Machine-Simulator


② BorderFactory 관련GUI
- http://javaking75.blog.me/140170600514


③ NumberFormating
- http://cafe.naver.com/javathink/90


④ Gridbag layout , insets
- http://blog.daum.net/question0921/872


⑤ Head First java (뇌회로를 자극하는 자바 학습법) - 케이시 시에라 저


⑥ JAVA의 정석 - 남궁 성 저

──────────────────────────────────────────────────────────────────────────────────────────────


**4. 클래스, 메소드 소개**

① VendingApp 클래스 : 메인 메소드가 존재하는 클래스입니다.

```
import java.awt.*;
import javax.swing.*;

public class VendingApp
{
        int order = 0;
        public static void main(String[] args)
        {
              JFrame frame = new VendingFrame(); VendingFrame 메소드를 불러옵니다.
              frame.setVisible(true); // frame이 보이도록 설정합니다.
        }
}

```


② VendingFrame 클래스 : JFrame로부터 상속받는 하위클래스입니다.

```
import javax.swing.JFrame;
import javax.swing.JPanel;

class VendingFrame extends JFrame
{
        public VendingFrame()
        {
                setTitle("현주의 음료수 자판기"); // 프레임 이름을 지정해줍니다.
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 수 있게합니다.
                JPanel panel = new VendingPanel(); // Frame위를 구성할 Panel 메소드를 불러옵니다.
                this.add(panel); // 불러온 panel을 Frame위에 add해줍니다.
                setSize(230,350); // Frame의 크기를 지정합니다.

        }
}
```


③ VendingPanel 클래스 : JPanel로부터 상속받는 클래스입니다. 또한 ActionListener 인터페이스로부터도 상속받습니다.

```
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

class VendingPanel extends JPanel implements ActionListener

{
        Machine m = new Machine(1000); //Machine class의 cost 값, 즉 음료수의 개당 값들을 1000원으로 지정했습니다.
        private JButton  orangeButton,aloeButton,colaButton,sodaButton,iceteaButton,hotsixButton,wonButton,refundButton;
        private JTextField amount; //현재 얼마가 있는지 표시해 줄 텍스트 필드를 만듭니다.
        NumberFormat showwon = NumberFormat.getCurrencyInstance(); //getCurrencyInstance()라는 메소드는 숫자 포매팅으로, 통화기호와 세자리 마다 콤마 표시를 해주는 메소드이다.
 
        public VendingPanel()
        {
        		JPanel VendingPanel = new JPanel();
        		setLayout(new GridBagLayout());
        		Border mainname = BorderFactory.createBevelBorder(BevelBorder.RAISED); //자판기 밖의 판에 양각 효과를 줬습니다.
        		        		
        	     m.beveragesoption(0, new Beverage("오렌지주스", m.quantity));
                 m.beveragesoption(1, new Beverage("알로에주스", m.quantity));
                 m.beveragesoption(2, new Beverage("콜라", m.quantity));
                 m.beveragesoption(3, new Beverage("사이다" , m.quantity));
                 m.beveragesoption(4, new Beverage("아이스티", m.quantity));
                 m.beveragesoption(5, new Beverage("핫식스", m.quantity));
                            
                VendingPanel.setLayout(new GridBagLayout());
                VendingPanel.setBorder(BorderFactory.createTitledBorder(mainname, "음료수는 세개씩! 개당 1000원!")); // 양각 효과를 준 자판기 판 테두리에 "음료"라고 덧붙였습니다.

                orangeButton = new JButton("오렌지주스"); // 오렌지주스라고 써져있는 버튼을 생성합니다.
                orangeButton.addActionListener(this); // 버튼 클릭 이벤트를 만들어줍니다.
                VendingPanel.add(orangeButton,getConstraints(1,0,1,1, GridBagConstraints.WEST)); // Panel위에 Button을 add하고 오렌지버튼의 위치는 왼쪽에 치우치게 합니다.
        
                aloeButton = new JButton("알로에주스");
                aloeButton.addActionListener(this);
                VendingPanel.add(aloeButton,getConstraints(1,1,1,1, GridBagConstraints.WEST));

                colaButton = new JButton("콜라");
                colaButton.addActionListener(this);
                VendingPanel.add(colaButton,getConstraints(1,2,1,1, GridBagConstraints.WEST));

                sodaButton = new JButton("사이다");
                sodaButton.addActionListener(this);
                VendingPanel.add(sodaButton,getConstraints(1,3,1,1, GridBagConstraints.WEST));

                iceteaButton = new JButton("아이스티");
                iceteaButton.addActionListener(this);
                VendingPanel.add(iceteaButton,getConstraints(1,4,1,1, GridBagConstraints.WEST));

                hotsixButton = new JButton("핫식스");
                hotsixButton.addActionListener(this);
                VendingPanel.add(hotsixButton,getConstraints(1,5,1,1, GridBagConstraints.WEST));

                wonButton = new JButton("원");
                wonButton.addActionListener(this);
                VendingPanel.add(wonButton,getConstraints(0,1,1,1, GridBagConstraints.CENTER));

                refundButton = new JButton("반환");
                refundButton.addActionListener(this);
                VendingPanel.add(refundButton,getConstraints(0,3,1,1, GridBagConstraints.CENTER));

                amount = new JTextField(5); // 현재 금액을 표시해 줄 텍스트 필드의 크기를 5로 지정합니다.
                amount.setEditable(false); // 현재 금액을 나타내는 텍스틒 필드를 수정할 수 없게 설정합니다.
                VendingPanel.add(amount, getConstraints(0,2,1,1, GridBagConstraints.CENTER));

                this.add(VendingPanel); // 지금까지 작업한 Panel을 Frame에 add 해줍니다.
        }

        private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor)
        {
                GridBagConstraints c = new GridBagConstraints();
                c.insets = new Insets(5,5,5,5);
                c.ipadx = 0;
                c.ipady = 0;
                c.gridx = gridx;
                c.gridy = gridy;
                c.gridwidth = gridwidth;
                c.gridheight = gridheight;
                c.anchor = anchor;
                return c;
        } 
        
        public void ordering(int orders)
        {
        	if(m.money >= m.cost) // 현재 가지고 있는 돈이 사려는 음료수 가격(모두 1000원)보다 큰 경우
        		JOptionPane.showMessageDialog(this, m.getName(orders) + "가 나왔습니다. 맛있게 드세요 xD"); //새로운 메시지 창을 띄워서 "음료수명 + 가 나왔습니다. 맛있게 드세요 xD"를 출력합니다.
        	else if(m.money < m.cost) // 현재 가지고 있는 돈이 사려는 음료수 가격(모두 1000원)보다 적은 경우
        		JOptionPane.showMessageDialog(this, "음료수는 모두 1000원 입니다. 돈을 넣어주세요"); // 새로운 메시지 창을 띄워서 "음료수는 모두 1000원 입니다. 돈을 넣어주세요"를 출력합니다.
        }

        public void actionPerformed(ActionEvent evt) // 객체 evt 로부터 눌려진 버튼을 가져옵니다.
        {
        	Object source = evt.getSource();
        	
        	if (source == wonButton) // 만약 눌려진 버튼이 원 버튼이면
        	{
        		m.money +=500; // 가격을 표시해주는 창에 500원을 추가해줍니다.
        		amount.setText(showwon.format(m.money)); // 가격을 표시해주는 창에 숫자포매팅을 적용하여 표시해줍니다. (원 기호와 세자리 당 콤마)
        	}

        	if (source == orangeButton) // 만약 눌려진 버튼이 오렌지주스 버튼이면
        	{
        		ordering(0); // ordering 메소드에 0값을 넣어줍니다.
        		m.getMoney(0); // 오렌지주스에 해당하는 돈 연산을 해주고
        		amount.setText(showwon.format(m.money)); // 현재 금액을 표시해줍니다.
        	}
   
        	if (source == aloeButton) // 만약 눌려진 버튼이 알로에주스 버튼이면
        	{
        		ordering(1); // ordering 메소드에 1값을 넣어줍니다.
        		m.getMoney(1); // 알로에주스에 해당하는 돈 연산을 해주고
        		amount.setText(showwon.format(m.money)); // 현재 금액을 표시해줍니다.
        	}

        	if (source == colaButton) // 만약 눌려진 버튼이 콜라 버튼이면
        	{
        		ordering(2); // ordering 메소드에 2값을 넣어줍니다.
        		m.getMoney(2); // 콜라에 해당하는 돈 연산을 해주고
        		amount.setText(showwon.format(m.money)); // 현재 금액을 표시해줍니다.
        	}
   
        	if (source == sodaButton) // 만약 눌려진 버튼이 사이다 버튼이면
        	{
        		ordering(3); // ordering 메소드에 3값을 넣어줍니다.
        		m.getMoney(3); // 사이다에 해당하는 돈 연산을 해주고
        		amount.setText(showwon.format(m.money)); // 현재 금액을 표시해줍니다.
        	}

        	if (source == iceteaButton) // 만약 눌려진 버튼이 아이스티 버튼이면
        	{
        		ordering(4); // ordering 메소드에 4값을 넣어줍니다.
        		m.getMoney(4); // 아이스티에 해당하는 돈 연산을 해주고
        		amount.setText(showwon.format(m.money)); // 현재 금액을 표시해줍니다.
        	}
   
        	if(source == hotsixButton) // 만약 눌려진 버튼이 핫식스 버튼이면
        	{
        		ordering(5); // ordering 메소드에 5값을 넣어줍니다.
        		m.getMoney(5); // 핫식스에 해당하는 돈 연산을 해주고
        		amount.setText(showwon.format(m.money)); // 현재 금액을 표시해줍니다.
        	}

        	if (source == refundButton) // 만약 눌려진 버튼이 반환 버튼이면
        	{
        		m.refund(); // refund 메소드를 실행시켜주고 money 값을 0으로 초기화해줍니다.
        		amount.setText(showwon.format(m.money)); // 현재 금액을 표시해줍니다.
        	}
        }

}

```


④ Machine 클래스

```
import javax.swing.JOptionPane;

class Machine
{
	public static final int SELECTION=6; // 여섯가지 음료수 선택에 대한 배열 크기를 지정해줍니다.
	public static final int quantity=3; // 음료수 자판기 안에는 음료수가 3개씩 진열되어 있습니다.
	public int money = 0;
	public int cost;

	Beverage[] bev = new Beverage[SELECTION];

	public Machine(int cost) // 가격 표기와 관련된 Machine 메소드입니다.
	{
        this.cost = cost; // 음료수들의 가격을 나타내는 cost 입니다.
	}

	public void beveragesoption (int choice, Beverage option) // 선택한 음료수 정보입니다. 선택한 choice 번호는 6개의 인덱스에서 각각 음료수의 위치를 나타내주며, option 부분에는 각 Beverage의 버튼에 표시될 명칭과 현재 갯수가 표기됩니다.
	{
        bev[choice] = option;
	}

	public void getMoney(int choice)
	{
		if(money < cost){} // 가지고 있는 돈이 음료수값(1000원 보다 작을때)               
		else if(bev[choice].quantity <= 0){ // 선택한 Beverage의 현재양이 0개 일때
			JOptionPane.showMessageDialog(null, "죄송합니다, 선택하신" + getName(choice) + "가 매진되었습니다." ); // 추가적인 메시지창을 띄워 "죄송합니다, 선택하신 (음료수명)가 매진되었습니다."라는 메시지가 출력되게 합니다.
    	}
		else{ // 그 외의 경우
			bev[choice].quantity--; // 음료수를 구입할 때마다 하나씩 그 갯수를 줄여줍니다. (음료수는 각각 총 3개씩 있습니다.)
			money = money - cost; // 가지고 있는 돈은 음료수를 선택할 때마다 음료수의 값만큼 빼줍니다.
		}
	}

	public void refund() // 반환에 관한 메소드입니다.
	{
		money = 0; // 반환레버를 돌리는 것으로 현재 넣은 돈을 0원으로 바꿔줍니다.
	}

	public String getName(int choice) // 각 선택한 음료수에 해당하는 이름을 음료수의 배열에 저장된 이름을 통해 반환하는 메소드입니다.
	{
		return bev[choice].name;
	}

}
```


⑤ Beverage 클래스

```
class Beverage
{
        public String name;
        public int quantity;

        public Beverage(String name, int quantity)
        {
             this.name = name;
             this.quantity = quantity;
        }
}
```


──────────────────────────────────────────────────────────────────────────────────────────────

**5. 스크린샷과 기능 설명**

- 시작화면입니다.
![http://comp166-koreauniv.googlecode.com/files/VendingApp1.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp1.jpg)


- 원 버튼을 눌러 500원씩 넣어줍니다. (1회 실행)
![http://comp166-koreauniv.googlecode.com/files/VendingApp2.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp2.jpg)


- 원 버튼을 눌러 500원씩 넣어줍니다. (2회 실행)
![http://comp166-koreauniv.googlecode.com/files/VendingApp3.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp3.jpg)


- 원 버튼을 눌러 500원씩 넣어줍니다. (10회 실행)
![http://comp166-koreauniv.googlecode.com/files/VendingApp4.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp4.jpg)


- 알로에주스 버튼을 눌러줍니다. (1000원), 그리고 잘 마시라는 메시지 창이 뜹니다.
![http://comp166-koreauniv.googlecode.com/files/VendingApp5.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp5.jpg)


- 알로에주스 버튼을 1회 누른 후 현재 금액 창입니다. (\5000 - \1000)
![http://comp166-koreauniv.googlecode.com/files/VendingApp6.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp6.jpg)


- 알로에주스 버튼을 3회 누른 후 금액은 2000원이 되며, 각 음료들은 3개씩 배치되어있기 때문에, 품절 메시지가 뜹니다.
![http://comp166-koreauniv.googlecode.com/files/VendingApp7.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp7.jpg)


- 반환 버튼을 클릭하여 거스름돈을 받습니다. 그리고 현재 넣은 금액은 0원이 됩니다.
![http://comp166-koreauniv.googlecode.com/files/VendingApp8.jpg](http://comp166-koreauniv.googlecode.com/files/VendingApp8.jpg)


──────────────────────────────────────────────────────────────────────────────────────────────


**6. 소스코드 압축파일(class,java 파일) 링크**

http://comp166-koreauniv.googlecode.com/files/2012190715.zip


──────────────────────────────────────────────────────────────────────────────────────────────

**7. project를 마치며...**

- 아쉬웠던 점은 자판기 안의 음료수들의 각각 가격들을 다르게 설정하지 않았다는 점이다. 조금만 더 공부한다면 클래스를 음료수 종류별로 더 추가적으로 생성하여 각각의 가격별로 넣은 금액이 조절되는 더 똑똑한 음료수 자판기를 만들 수 있을 것 같다.

- 그리고 소리를 넣어서 동전을 넣는 소리나 음료가 자판기에서 나오는 소리를 넣는다면 더 좋을 것 같다.

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages