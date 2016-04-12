# Introduction #

http://prezi.com/nckx1axj-i3z/java/?auth_key=aadd1bf059fbff3141b43111efbf2c18669b94aa&kw=view-nckx1axj-i3z&rc=ref-21579509

자세한 dragonball game설명은 prezi로 만들었습니다.



# 소스코드 #

player class

```


//user와 cpu의 상위클래스
public class player {

	int charge=0; //charge양을 저장해주는 변수
	int choice=-1; //선택(공격 방어 기모으기등)을 지정해주는 변수
	boolean energy = false;//cpu에서 Math.random함수로 choice를 지정할때, charge양이 부족할때에는 cpu가 공격할수 없도록 설정해주는 변수
	int score=0; //몇번 이기고 졌는지 나타내주는 변수
	
}

```

user class

```


//유저의 상태를 지정해주는 클래스
public class user extends player{
	
	public int action(int choice) {
		//0=charge, 1=attack, 2=defense, 3=teleport, 4=power attack		
		switch (choice) {
		case 0:
			charge++;
			return choice;
		case 1:
			charge--;
			return choice;
		case 2:
			return choice;
		case 3:
			charge = charge -2;
			return choice;
		case 4:
			charge = charge -4;
			return choice;	

		default:
			return choice;
		}
		
	}

}


```

cpu class

```


//컴퓨터의 행동을 지정해주는 클래스
public class cpu extends player{

	
	user A;//어그리게이션
	
	public cpu(user A) {
		this.A = A; //같은 이름의 변수을 가졌기 때무에 this notation써줌.
	}
	public int action() {
		
	
		if (A.charge==0&&charge==0) //상식적으로 user의 charge=0이고 cpu의 charge=0이면 컴퓨터가 기모으기 이외에 다른 행동을 할 의미가 없으므로 따로 분리해서 지정 
		{
			choice=0;
			charge++;
			return choice;
		}
		else
		{
			while(!energy) //cpu의 charge양이 부족할때 cpu가 공격하는것을 방지하는부분
			{
				choice=((int)(Math.random()*5));
				
				if(choice==1&&charge<1){}
				else if(choice==3){} //cpu가 teleport를 쓰는것은 게임난이도에 있어 언밸런스한 모습을 보여서 뺌
				else if(choice==4&&charge<4){}
				else
				{
					energy=true;
				}
			}
			energy=false;
	
	
			switch (choice) { //cpu의 선택에 따른 행동을 지정
			case 0:
				charge++;
				return choice;
			case 1:
				charge--;
				return choice;
			case 2:
				return choice;
			case 3:
				charge = charge -2;
				return choice;
			case 4:
				charge = charge -4;
				return choice;	

			default:
				return choice;
			}
		}
	}
}

```


versus class

```

//user와 cpu의 행동(기모으기,공격,방어등)을 비교하여 win 또는 lose 또는 draw를 정해주는 클래스
public class versus {
	
	public int vs(int userC, int cpuC)
	//return 0 = draw, return 1 = win, return 2 = lose;
	{
		//0=charge, 1=attack, 2=defense, 3=teleport, 4=power attack
		if (userC == cpuC){return 0;}
		else if (userC==3 || cpuC==3){return 0;}
		else if (userC==2 && cpuC!=4){return 0;}
		else if (userC!=4 && cpuC==2){return 0;}
		else if (userC==4 && cpuC!=3)
		{
			return 1;
		}
		else if (userC!=3 && cpuC==4)
		{
			return 2;
		}
		else if (userC==0 && cpuC==1)
		{
			return 2;
		}
		else if (userC==1 && cpuC==0)
		{
			return 1;
		}
		return 0;

	}
}


```


main class

```

//windowbuilder를 통해 제작, gui로 화면을 지정해주고 메인메소드가 들어있는 클래스
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;


public class main {
	
	user me = new user();
	cpu enemy = new cpu(me); //me를 인자로 넣어 cpu 객체화
	versus result = new versus();
	int gameover = -1; //versus의 vs메소드에서 0,1,2값을 받아 게임에서 졌는지 비겼는지 이겼는지를 지정해서 저장하는 변수 (0=draw,1=win,2=lose)
	String [] cpustate = {"charge","attack","defense","teleport","power attack"}; //lblNewLabel_3에 컴퓨터의 행동을 나타낼때 사용하는 변수
	int end = -1; //win또는 lose로 승부가 났을때 showConfirmDialog에서 '예'를 누르면 게임을 재시작, '아니오'를 누르면 게임이 종료되도록 하기위한 변수를 저장함
	

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//main frame
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH); 
		
		JLabel lblSelectPosition = new JLabel("Select Position");
		panel.add(lblSelectPosition);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("me.jpg"));
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		final JLabel lblNewLabel_2 = new JLabel("");
		panel_1.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("enemy.jpg"));
		panel_3.add(lblNewLabel_1, BorderLayout.NORTH);
		
		final JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		
		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Vrinda", Font.PLAIN, 24));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4);
		
		
		
		


		//charge 버튼을 눌렀을때
		JButton btnNewButton_3 = new JButton("charge");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameover = result.vs(me.action(0), enemy.action()); //versus클래스의 vs메소드를 사용하여 me.action(0)의값(user가 charge행동을 취했을때)와 enemy.action()(cpu가 랜덤으로 지정된 행동)을 비교한 결과값을 게임오버에 저장
				lblNewLabel_2.setText("charge\n my charge point :"+me.charge); //lblNewLabel_2에 user의 상태창을 표현
				lblNewLabel_3.setText(cpustate[enemy.choice]+"\ncpu's charge point :"+enemy.charge); //lblNewLabel_3에 cpu의 상태창을 표현
				if (gameover==0)
				{
					lblNewLabel_4.setText("draw");
				}
				else if (gameover==1) {} //user가 charge를 할땐 게임조건상 이길수 없으므로 비워둠
				else if (gameover==2)
				{
					lblNewLabel_4.setText("lose");
					enemy.score++;//메뉴에 있는 score창에서 cpu의 score를 올려줌
					
					end = JOptionPane.showConfirmDialog(frame, "다시 시작하시겠습니까", "시작",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); //승부가 났으므로 메세지를 띄워 게임을 계속 진행할것인지 물어봄
					if (end==0) { //'예'를 선택했을때
						//상태 초기화
						me.charge=0;
						enemy.charge=0;
						lblNewLabel_2.setText("");
						lblNewLabel_3.setText("");
						lblNewLabel_4.setText("");					
					}
					else
					{
						System.exit(0);
					}
				}
			}
		});
		panel_2.add(btnNewButton_3);
		
		//attack,defense,teleport,power attack은 위의 charge와 거의 똑같음. 동일한 부분은 주석으로 설명하지 않겠음
		
		JButton btnNewButton_2 = new JButton("attack");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(me.charge<1) //user가 charge=0일때 attack을 하려고하면 error창을 출력하면서 아무일도 일어나지 않도록 설정
				{
					lblNewLabel_4.setText("error");
				}
				else
				{
					gameover = result.vs(me.action(1), enemy.action());
					lblNewLabel_2.setText("attack, my charge point :"+me.charge);
					lblNewLabel_3.setText(cpustate[enemy.choice]+", cpu's charge point :"+enemy.charge);
					if (gameover==0)
					{
						lblNewLabel_4.setText("draw");
					}
					else if (gameover==1)
					{
						lblNewLabel_4.setText("win");
						me.score++;
						
						end = JOptionPane.showConfirmDialog(frame, "다시 시작하시겠습니까", "시작",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (end==0) {
							me.charge=0;
							enemy.charge=0;
							lblNewLabel_2.setText("");
							lblNewLabel_3.setText("");
							lblNewLabel_4.setText("");					
						}
						else
						{
							System.exit(0);
						}
					}
					else if (gameover==2)
					{
						lblNewLabel_4.setText("lose");
						enemy.score++;
						
						end = JOptionPane.showConfirmDialog(frame, "다시 시작하시겠습니까", "시작",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (end==0) {
							me.charge=0;
							enemy.charge=0;
							lblNewLabel_2.setText("");
							lblNewLabel_3.setText("");
							lblNewLabel_4.setText("");					
						}
						else
						{
							System.exit(0);
						}
					}
				}
			}
		});
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("defense");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gameover = result.vs(me.action(2), enemy.action());
				lblNewLabel_2.setText("defense, my charge point :"+me.charge);
				lblNewLabel_3.setText(cpustate[enemy.choice]+", cpu's charge point :"+enemy.charge);
				if (gameover==0)
				{
					lblNewLabel_4.setText("draw");
				}
				else if (gameover==1) {} //게임설정상 defense상태일땐 이길수 없으므로 비워둠
				else if (gameover==2)
				{
					lblNewLabel_4.setText("lose");
					enemy.score++;
					
					end = JOptionPane.showConfirmDialog(frame, "다시 시작하시겠습니까", "시작",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (end==0) {
						me.charge=0;
						enemy.charge=0;
						lblNewLabel_2.setText("");
						lblNewLabel_3.setText("");
						lblNewLabel_4.setText("");					
					}
					else
					{
						System.exit(0);
					}
				}
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("teleport");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(me.charge<2) //charge<2일때 teleport를 사용하려하면 error메세지를 띄우고 아무일도 일어나지 않게 함
				{
					lblNewLabel_4.setText("error");
				}
				else
				{
					gameover = result.vs(me.action(3), enemy.action());
					lblNewLabel_2.setText("teleport, my charge point :"+me.charge);
					lblNewLabel_3.setText(cpustate[enemy.choice]+", cpu's charge point :"+enemy.charge);
					if (gameover==0)
					{
						lblNewLabel_4.setText("draw");
					}
						else if (gameover==1) {} //게임설정상 teleport상태일땐 이길수 없으므로 비워둠
					else if (gameover==2) {} //게임설정상 teleport상태일땐 질수 없으므로 비워둠
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnPowerAttack = new JButton("power attack");
		btnPowerAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(me.charge<4) //charge<4일때 power attack를 사용하려하면 error메세지를 띄우고 아무일도 일어나지 않게 함
				{
					lblNewLabel_4.setText("error");
				}
				else
				{
					gameover = result.vs(me.action(4), enemy.action());
					lblNewLabel_2.setText("power attack, my charge point :"+me.charge);
					lblNewLabel_3.setText(cpustate[enemy.choice]+", cpu's charge point :"+enemy.charge);
					if (gameover==0)
					{
						lblNewLabel_4.setText("draw");
					}
					else if (gameover==1)
					{
						lblNewLabel_4.setText("win");
						me.score++;
						
						end = JOptionPane.showConfirmDialog(frame, "다시 시작하시겠습니까", "시작",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (end==0) {
							me.charge=0;
							enemy.charge=0;
							lblNewLabel_2.setText("");
							lblNewLabel_3.setText("");
							lblNewLabel_4.setText("");					
						}
						else
						{
							System.exit(0);
						}
					}
					else if (gameover==2) {} //게임설정상 power attack상태일땐 질수 없으므로 비워둠
				}
			}
		});
		panel_2.add(btnPowerAttack);
		
		//메뉴설정
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//메뉴 File에서 New버튼을 누르면 모든 상태가 초기화되고 score도 초기화됨
				me.charge=0;
				enemy.charge=0;
				me.score=0;
				enemy.score=0;
				lblNewLabel_2.setText("");
				lblNewLabel_3.setText("");
				lblNewLabel_4.setText("");							
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnInformation = new JMenu("Information");
		menuBar.add(mnInformation);
		
		JMenuItem mntmGuide = new JMenuItem("Guide");
		mntmGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "기모으기 : 공격을 하기위한 필요조건 입니다. 기모은 양에 따라 다양한 공격을 할수 있습니다.\n\n방어하기 : 공격을 방어하는 기술입니다. 강한공격을 제외한 공격기술을 방어할수 있습니다. \n\n공격 : 기모으기 1회가 필요합니다. 상대가 기모으는 순간에 공격을 할경우 승리하게 됩니다. \n\n강한공격 : 기모으기 4회가 필요합니다. 상대가 순간이동을 제외한 어떠한 기술을 사용하더라도 승리하게 됩니다. \n\n순간이동 : 기모으기 2회가 필요합니다. 상대가 어떤 기술을 사용하더라도 살아남을수 있습니다. ");
			}
		});
		mnInformation.add(mntmGuide);
		
		//점수를 표현해주는 메뉴아이템
		JMenuItem mntmScore = new JMenuItem("Score");
		mntmScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "My Score : " +me.score+ " CPU Score : " +enemy.score);
			}
		});
		mnInformation.add(mntmScore);
		
		//version 표현
		JMenuItem mntmVersion = new JMenuItem("Version");
		mntmVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "2009190715 임세현 \nversion 1.00");
			}
		});
		mnInformation.add(mntmVersion);
		
		
		

	}

}


```


dragonball 파일 다운주소 : http://code.google.com/p/comp166-koreauniv/downloads/detail?name=final.zip&can=2&q=#makechanges