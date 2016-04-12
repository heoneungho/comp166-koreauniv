# Introduction #

> 처음 목적으로는 손님이 레스토랑에 들어오면 손님 수를 입력받고 손님수와 추가로 올 사람, 어린아이와 어른의 수를 각각 입력받아 적절한 테이블로 안내한 다음, 에피타이저와 메인디쉬, 디저트와 음료 등을 손님이 직접 선택을 통해 주문하는 프로그램을 만드려고 했습니다. 아이디어는 아이패드를 사용한 메뉴판을 통해 주문을 받는 카페가 있다는 것을 듣고 그것에 착안하여 계획을 세웠었습니다.
> 그런데 저의 능력이 부족하여 손님에게 주어지는 메뉴판이 아닌 주문 받는 입장에서 주문을 받고 총액을 계산해주는 프로그램으로 수정하였습니다.

# Details #

- 프로그램을 실행시 메뉴판이 뜹니다. 원하는 메뉴를 선택하고 수량도 정할 수 있습니다.
- 메뉴를 모두 정했으면 정한 메뉴와 총합을 알려주는 프로그램입니다.
- 단점은 원래로 돌아갈 수 없어 다음 손님이 오면 다시 프로그램을 재시작해야합니다.
- 메뉴에 해당하는 키보드 숫자를 누르는 것을 통해 수량을 증가시킬수 있습니다.
- 메뉴에 따른 수량을 일일이 입력받기 어려워 http://blog.naver.com/mmc2210?Redirect=Log&logNo=5012614975 를 참조하였습니다. 그런데 이후 다시 들어가보니 참고한 게시물이 사라지는 사태가 발생하였습니다. 검색창에 java keylistener이라고 치면 사용방법을 쉽게 알 수 있습니다.

# 수정사항 #
> 처음에는 하나의 class에 모든 코드를 집어 넣었었는데 중간고사 이후로 cashier class와 menu class, subtoal class로 나누었습니다.

# Code #

```


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;


public class Cashier extends JFrame {
		
	public static void main(String args[]) {
		
		Menu menu = new Menu();
		menu.launchFrame();  
	}	
}

class Menu extends JFrame implements KeyListener {

	private JFrame menuFrame;
	private JPanel menuNorthPanel,
				   menuSouthPanel,
				   menuCenterPanel,
				   menuTitlePanel,
				   menuDetailPanel,
				   menuChoicePanel;

	private JLabel menuStoreLabel,
				   menuTitleLabel,
				   menuHeaderLabel,
				   menuChoiceLabel[],
				   menuGuideLabel;
	

	public static String choice[] = {" 혜원 수제햄버거        ",
								   	" 혜원 수제치킨버거    ",
					   				" 혜원 수제새우버거    ",
					   				" 혜원 수제불고기버거",
					   				" 혜원 수제야채버거    ",
					   				" 콜라                               ",
					   				" 사이다                           ",
					   				" 아메리카노                  "};	
	
	public static int price[] = {3000,
					  				4000,
					  				3500,
					  				4000,
					  				4500,
					  				1500,
					  				1500,
					  				2000};
	
	public static int ordered[];
				   
	String option[] = {"얼마일까요~?"};
					

	public Menu() {
		menuFrame = new JFrame("어서오세요^^");
		menuFrame.getContentPane().setLayout(new BorderLayout(0,0));
		
		menuNorthPanel = new JPanel();
		menuNorthPanel.setLayout(new FlowLayout());
		menuNorthPanel.getBackground();
		
		menuSouthPanel = new JPanel();
		menuSouthPanel.getBackground();
				
		menuTitlePanel = new JPanel();
		menuTitlePanel.setLayout(new BorderLayout(10,10));
		menuTitlePanel.getBackground();
		
		menuDetailPanel = new JPanel();
		menuDetailPanel.setLayout(new GridLayout(2,1));
		menuDetailPanel.getBackground();
			
		menuCenterPanel = new JPanel();
		menuCenterPanel.setLayout(new BorderLayout(0,0));
		menuCenterPanel.getBackground();
		
		menuStoreLabel = new JLabel(" 혜원이의 행복한 수제버거가게 ");
		menuStoreLabel.getForeground();

		menuTitleLabel = new JLabel(" 어서오세요~", JLabel.CENTER);
		menuTitleLabel.getForeground();


		menuHeaderLabel = new JLabel("             메뉴"
									+"                                 가격"
									+"        수량");
		menuHeaderLabel.getForeground();

		
		menuChoicePanel = new JPanel();
		menuChoicePanel.setLayout(new GridLayout(choice.length+4,1,0,0));
		menuChoicePanel.getBackground();
		menuChoicePanel.add(menuHeaderLabel);

		menuChoiceLabel = new JLabel[choice.length + 2];
		ordered = new int[choice.length];
					
		for (int i = 0; i < choice.length; i++)	{
			
			ordered[i] = 0;
			
			menuChoiceLabel[i] = new JLabel("  [" + (i+1) + "]  " + choice[i]
										   +"      "+ price[i]
										   +"       "+ ordered[i]);
			menuChoiceLabel[i].getForeground();

			menuChoicePanel.add(menuChoiceLabel[i]);
		}
		
		menuChoiceLabel[choice.length] = new JLabel("  [0]  " + option[0]);

		menuChoiceLabel[choice.length].getForeground();

		menuChoicePanel.add(menuChoiceLabel[choice.length]);
		

		menuGuideLabel = new JLabel("");
		menuGuideLabel.getForeground();
	}


	public void launchFrame() {	

		menuFrame.setSize(200,350);
		
		menuTitlePanel.add(menuTitleLabel, BorderLayout.WEST);
		menuTitlePanel.add(menuDetailPanel, BorderLayout.EAST);
		menuNorthPanel.add(menuStoreLabel, BorderLayout.NORTH);
		menuSouthPanel.add(menuGuideLabel, BorderLayout.SOUTH);		
		menuCenterPanel.add(menuTitlePanel, BorderLayout.NORTH);
		menuCenterPanel.add(menuChoicePanel, BorderLayout.CENTER);
		menuFrame.getContentPane().add(menuNorthPanel, BorderLayout.NORTH);
		menuFrame.getContentPane().add(menuCenterPanel, BorderLayout.CENTER);
		menuFrame.getContentPane().add(menuSouthPanel, BorderLayout.SOUTH);
		
		menuFrame.pack();		
	
		menuFrame.addKeyListener(this);
		
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setVisible(true);

	}
	
	private void refresh() {
		for (int i = 0; i < choice.length; i++)	{
						
			menuChoiceLabel[i].setText("  [" + (i+1) + "]  " + choice[i]
										   + "      " + price[i] + "       " + ordered[i]);
		}		
	}
	
	public void keyTyped(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }
	public void keyPressed(KeyEvent e) { 		
		switch(e.getKeyCode()) {
		case 49:
		case 50:
		case 51:
		case 52:
		case 53:
		case 54:
		case 55:
		case 56:
			ordered[e.getKeyCode() - 49]++;
			break;
		
		case 48:
			menuFrame.setVisible(false);
			SubTotal subTotal = new SubTotal();
			subTotal.launchFrame();
			break;
		}
	
		this.refresh();
	}
}


class SubTotal extends JFrame implements KeyListener {
	
	int EachTotal = 0;
	int Total = 0;

	private JFrame subTotalFrame;
	private JPanel subTotalNorthPanel,
				   subTotalSouthPanel,
				   subTotalCenterPanel,
				   subTotalTitlePanel,
				   subTotalDetailPanel,
				   subTotalOrderedPanel;
	
	private JLabel subTotalStoreLabel,
				   subTotalHeaderLabel,
				   subTotalOrderedLabel[],
				   subTotalGrandTotalLabel,
				   subTotalGuideLabel;
							   					
	public SubTotal() {
		subTotalFrame = new JFrame("**총액입니다**");
		subTotalFrame.getContentPane().setLayout(new BorderLayout(0,0));
		
		subTotalNorthPanel = new JPanel();
		subTotalNorthPanel.setLayout(new FlowLayout());
		subTotalNorthPanel.getBackground();
		
		subTotalSouthPanel = new JPanel();
		subTotalSouthPanel.getBackground();
				
		subTotalTitlePanel = new JPanel();
		subTotalTitlePanel.setLayout(new BorderLayout(10,10));
		subTotalTitlePanel.getBackground();
		
		subTotalDetailPanel = new JPanel();
		subTotalDetailPanel.setLayout(new GridLayout(2,1));
		subTotalDetailPanel.getBackground();
			
		subTotalCenterPanel = new JPanel();
		subTotalCenterPanel.setLayout(new BorderLayout(0,0));
		subTotalCenterPanel.getBackground();
		
		subTotalStoreLabel = new JLabel("혜원이의 행복한 레스토랑입니다. ");
		subTotalStoreLabel.getForeground();



		
		subTotalHeaderLabel = new JLabel("    메뉴"
										+"                                  가격"
										+"       수량"
										+"    총액 ");
		subTotalHeaderLabel.getForeground();

		
		subTotalOrderedPanel = new JPanel();
		subTotalOrderedPanel.getBackground();
		subTotalOrderedPanel.add(subTotalHeaderLabel);
		
		subTotalOrderedLabel = new JLabel[Menu.choice.length];
		
		int count = 0;
					
		for (int i = 0; i < Menu.choice.length; i++)	{
			
			if (Menu.ordered[i] > 0) {
			
			EachTotal = Menu.ordered[i] * Menu.price[i];
			Total += EachTotal;
			count++;
			
			subTotalOrderedLabel[i] = new JLabel("  " + Menu.choice[i]
										   	   +"    " + Menu.price[i] 
										       +"        " + Menu.ordered[i]
										       +"       " + EachTotal);
			subTotalOrderedLabel[i].getForeground();
			
			subTotalOrderedPanel.add(subTotalOrderedLabel[i]);
			
			Menu.ordered[i] = 0;
			}
		}
		
		subTotalGrandTotalLabel = new JLabel(" 총액   :  " + Total);
		subTotalGrandTotalLabel.getForeground();	
		
		subTotalOrderedPanel.add(subTotalGrandTotalLabel);
				

		subTotalGuideLabel = new JLabel("");
		subTotalGuideLabel.getForeground();

		subTotalOrderedPanel.setLayout(new GridLayout(count+2,1,0,0));
	}


	public void launchFrame() {	

		subTotalFrame.setSize(200,350);
	
		subTotalTitlePanel.add(subTotalDetailPanel, BorderLayout.EAST);
		subTotalNorthPanel.add(subTotalStoreLabel, BorderLayout.NORTH);
		subTotalSouthPanel.add(subTotalGuideLabel, BorderLayout.SOUTH);		
		subTotalCenterPanel.add(subTotalTitlePanel, BorderLayout.NORTH);
		subTotalCenterPanel.add(subTotalOrderedPanel, BorderLayout.CENTER);
		subTotalFrame.getContentPane().add(subTotalNorthPanel, BorderLayout.NORTH);
		subTotalFrame.getContentPane().add(subTotalCenterPanel, BorderLayout.CENTER);
		subTotalFrame.getContentPane().add(subTotalSouthPanel, BorderLayout.SOUTH);
		
		subTotalFrame.pack();		

		subTotalFrame.addKeyListener(this);
		
		subTotalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		subTotalFrame.setVisible(true);
	}

	public void keyTyped(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }
	
	public void keyPressed(KeyEvent e) { }
}

```

# 스크린샷 #

1. 프로그램을 처음 실행하면 화면 왼쪽에 실행창이 뜹니다.
![http://comp166-koreauniv.googlecode.com/files/haewon1.jpg](http://comp166-koreauniv.googlecode.com/files/haewon1.jpg)

2. 숫자키보드를 누르면 수량이 증가합니다.
![http://comp166-koreauniv.googlecode.com/files/haewon2.jpg](http://comp166-koreauniv.googlecode.com/files/haewon2.jpg)

3. 0을 누르면 주문한 메뉴와 총액이 나옵니다.
![http://comp166-koreauniv.googlecode.com/files/haewon3.jpg](http://comp166-koreauniv.googlecode.com/files/haewon3.jpg)

# 프로젝트를 마치며 #
> 프로그램을 구현하기에 앞서 손님이 메뉴를 주문하는 모습을 생각해보니 한번에 딱딱 말하지 않고 "새우버거하나랑 콜라하나요. 아 새우버거 하나 더주세요"라고 하는 경우가 많았다. 손님이 많은 음식점의 경우 그러한 수정 내용을 일일히 적기에 어려움이 있기에 검색을 통해 키보드로 입력받는 프로그램을 생각해 내었다.