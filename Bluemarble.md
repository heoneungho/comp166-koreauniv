# Introduction #

어렸을 적에, 누구나 해봤을만한,

꼭 누군가는 빈정상해서 항상 마지막은 치고박고 싸우게 만들었던

브루마불 게임입니다.

http://postfiles3.naver.net/20121026_226/cbj5210_1351181577837rLOSp_JPEG/bluemarble.jpg?type=w3

# 개발 스케치 #

http://postfiles6.naver.net/20121026_37/cbj5210_1351181859048BrBfL_JPEG/20121026_011411.jpg?type=w3


# Details #

2인에서 4인 사이의 사용자를 선택하고 초기 자본을 이용하여

기본적으로 제공되는 40개의 땅을 구매하고 건물을 세워 가치를 높인 뒤

타인이 방문할 시 일정량의 돈을 받을 수 있도록 하는 게임입니다.

(찬스와 무인도 또한 구현할 예정 입니다.)

생각보다 일찍 구현할 수 있게 된다면, 이클립스에서 제공하는

안드로이드 개발 환경을 이용하여 안드로이드로도 구현해 볼 생각입니다.

# class #

1.
```
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class mainFrame extends JFrame {

	private int FRAME_WIDTH=1000;
	private int FRAME_HEIGHT=600;
		    boolean exit = true;
		    int button=0;
		    int turn=0;

	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem start;
	private JMenuItem help;
	private JMenuItem quit;

	private JPanel statusPanel;
	private JPanel messagePanel;
	
	private JLabel messagename;
	private JLabel messagenametwo;
	private JTextField messageField;
	private JTextField messageFieldtwo;

	private JPanel buttonPanel;
	private JPanel playerOnePanel;
	private JPanel playerTwoPanel;
	private JTextField playerOneMoney;
	private JTextField playerTwoMoney;

	private JButton modeButton;
	private JLabel playerOne;
	private JLabel playerTwo;
	
	
	JPanel leftstatePanel;
	
	JPanel pOnestatePanel;
	JPanel pTwostatePanel;
	JTextField pOneStateLabel;
	JTextField pTwoStateLabel;
	
	JPanel rightranPanel;
	
	JPanel ranNumOnePanel;
	JPanel ranNumTwoPanel;
	JTextField ranNumOneLabel;
	JTextField ranNumTwoLabel;
	
	JPanel where;
	JLabel[] whereplayer;
	JLabel[] wherep1;
	JLabel[] wherep2;
	

	//private MainComponent component;

	
	boolean wait=true;

    public mainFrame() {
    	setSize(FRAME_WIDTH, FRAME_HEIGHT);
    	setTitle("Blue marble");

    	//component = new MainComponent();
/*
    	Timer t = new Timer(1000, new TimeListener());
    	t.start();
*/
		createMenuBar();
		createStatusPanel();

    	//add(component, BorderLayout.CENTER);
    }

    private void createStatusPanel(){
    	statusPanel = new JPanel();
    	messagePanel = new JPanel();
    	messagename = new JLabel();
    	messagenametwo = new JLabel();
    	messageField = new JTextField();
    	messageFieldtwo = new JTextField();
    	
    	messagename.setText("차례 : ");
    	messagenametwo.setText("최근 이벤트 : ");
    	messageField.setText("게임을 시작합니다");
    	
    	
		buttonPanel = new JPanel();
		playerOnePanel = new JPanel();
		playerTwoPanel = new JPanel();

		modeButton = new JButton("주사위 던지기");
		modeButton.addActionListener(new ChangeModeListener());
		playerOne = new JLabel("");
		playerTwo = new JLabel("");
	
		leftstatePanel = new JPanel();
		
		pOnestatePanel = new JPanel();
		pTwostatePanel = new JPanel();
		pOneStateLabel = new JTextField("                                   ");
		pTwoStateLabel = new JTextField("                                   ");
		
		rightranPanel = new JPanel();
		
		ranNumOnePanel = new JPanel();
		ranNumTwoPanel = new JPanel();
		ranNumOneLabel = new JTextField("                                    ");
		ranNumTwoLabel = new JTextField("                                    ");
		
		where = new JPanel();
		where.setLayout(new GridLayout(20, 6));

		whereplayer = new JLabel[40];
		wherep1 = new JLabel[40];
		wherep2 = new JLabel[40];
		
		
		for(int whereis=0; whereis<20; whereis++){
			whereplayer[whereis] = new JLabel();
			whereplayer[whereis+20] = new JLabel();
			
			wherep1[whereis] = new JLabel();
			wherep1[whereis+20] = new JLabel();
			
			wherep2[whereis] = new JLabel();
			wherep2[whereis+20] = new JLabel();
			
			where.add(whereplayer[whereis]);
			where.add(wherep1[whereis]);
			where.add(wherep2[whereis]);
			where.add(whereplayer[whereis+20]);
			where.add(wherep1[whereis+20]);
			where.add(wherep2[whereis+20]);
		}
		 
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
		buttonPanel.add(modeButton);
		playerOnePanel.setBorder(new TitledBorder(new EtchedBorder(), "Player1 Money"));
		playerOnePanel.add(playerOne);
		playerTwoPanel.setBorder(new TitledBorder(new EtchedBorder(), "Player2 Money"));
		playerTwoPanel.add(playerTwo);

		statusPanel.setLayout(new GridLayout(1,3));
		statusPanel.add(playerOnePanel);
		statusPanel.add(playerTwoPanel);
		statusPanel.add(buttonPanel);
		
		messagePanel.setLayout(new GridLayout(2,2));
		messagePanel.add(messagename);
		messagePanel.add(messageField);
		messagePanel.add(messagenametwo);
		messagePanel.add(messageFieldtwo);
		
		leftstatePanel.setLayout(new GridLayout(2, 1));
		
		pOnestatePanel.setBorder(new TitledBorder(new EtchedBorder(), "Player1 현재위치"));
		pOnestatePanel.add(pOneStateLabel);
		pTwostatePanel.setBorder(new TitledBorder(new EtchedBorder(), "Player2 현재위치"));
		pTwostatePanel.add(pTwoStateLabel);
		
		leftstatePanel.add(pOnestatePanel);
		leftstatePanel.add(pTwostatePanel);
		//leftstatePanel.setSize(100, 100);
		
		rightranPanel.setLayout(new GridLayout(2,1));
		
		ranNumOnePanel.setBorder(new TitledBorder(new EtchedBorder(), "첫번째 주사위"));
		ranNumOnePanel.add(ranNumOneLabel);
		ranNumTwoPanel.setBorder(new TitledBorder(new EtchedBorder(), "두번째 주사위"));
		ranNumTwoPanel.add(ranNumTwoLabel);
		
		rightranPanel.add(ranNumOnePanel);
		rightranPanel.add(ranNumTwoPanel);
		//rightranPanel.setSize(100, 100);
		
		add(statusPanel, BorderLayout.SOUTH);
		add(messagePanel, BorderLayout.NORTH);
		add(leftstatePanel, BorderLayout.WEST);
		add(rightranPanel, BorderLayout.EAST);
		add(where, BorderLayout.CENTER);
		
    }

    private void createMenuBar(){
    	menuBar = new JMenuBar();
		file = new JMenu("File");
    	start = new JMenuItem("새 게임");
    	start.addActionListener(new NewListener());
    	
    	quit = new JMenuItem("종료");
    	quit.addActionListener(new QuitListener());
    	file.add(start);
    	//file.add(help);
    	file.add(quit);
    	menuBar.add(file);
    	setJMenuBar(menuBar);
    }
    
    
	public static void main(String arg[]){

		mainFrame frame = new mainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			
		secondFrame sframe = new secondFrame();
		sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sframe.setVisible(false);
		
		
		int i;
		
		int randomOne = 0;
		int randomTwo = 0;
		int goldenKey = 0;
		int goldbbb = 0;
		int statecolor=0;
		
		player[] p = new player[3]; // 플레이어 배열객체 선언
		
		p[1] = new player(); // 플레이어 객체 생성자 호출
		p[2] = new player();

		toji d[] = new toji[40];
		  // 땅들의 배열객체 선언
		
		for(i=0;i<40;i++){
		d[i] = new toji();
		d[i].tojiPrice = 10000+i*500;
		d[i].homePrice = d[i].tojiPrice+1000;
		d[i].byulPrice = d[i].homePrice+1000;
		d[i].hotelPrice = d[i].byulPrice+1000;
		d[i].soyu = 0;
		} // 생성자 호출 및 초기화
		
		 d[0].name = "출발지";
		 d[1].name = "타이페이";
		 d[2].name = "황금열쇠1";
		 d[3].name = "홍콩";
		 d[4].name = "마닐라";
		 d[5].name = "제주도";
		 d[6].name = "싱가폴";
		 d[7].name = "황금열쇠2";
		 d[8].name = "카이로";
		 d[9].name = "이스탄불";
		d[10].name = "무인도";
		d[11].name = "아테네";
		d[12].name = "황금열쇠3";
		d[13].name = "코펜하겐";
		d[14].name = "스톡홀롬";
		d[15].name = "콩코드여객기";
		d[16].name = "취리히";
		d[17].name = "황금열쇠4";
		d[18].name = "베를린";
		d[19].name = "몬트리올";
		d[20].name = "강남";
		d[21].name = "부에노스 아이레스";
		d[22].name = "황금열쇠5";
		d[23].name = "상파울로";
		d[24].name = "시드니";
		d[25].name = "부산";
		d[26].name = "하와이";
		d[27].name = "리스본";
		d[28].name = "퀸 엘리자베스호";
		d[29].name = "마드리드";
		d[30].name = "우주여행";
		d[31].name = "도쿄";
		d[32].name = "콜럼비아호";
		d[33].name = "파리";
		d[34].name = "로마";
		d[35].name = "황금열쇠6";
		d[36].name = "런던";
		d[37].name = "뉴욕";
		d[38].name = "사회복지기금";
		d[39].name = "서울";
		
		

		for(int initwhere=0;initwhere<40;initwhere++){
		
			frame.whereplayer[initwhere].setText(initwhere +". " + d[initwhere].name );
		}


		
		
		
		p[1].reset(); //플레이어 초기화
		p[2].reset(); 
		
		gameHelper game = new gameHelper(); // 게임헬퍼 객체 생성
		goldKey goldKey = new goldKey();
		
		d[2].soyu = -1;
		d[7].soyu = -1;
		d[12].soyu = -1;
		d[17].soyu = -1;
		d[22].soyu = -1;
		d[35].soyu = -1;
		d[38].soyu = -1;
		
		frame.turn = 0;
		
		frame.playerOne.setText(  ((Integer)p[1].money).toString()    );
		frame.playerTwo.setText(  ((Integer)p[2].money).toString()    );
		
		
		while((frame.turn<80)&&(p[1].money>=0)&&(p[2].money>=0) ){
		//주사위 던지기 버튼 눌렀을 때	
			
			frame.messageField.setText("Player 1의 차례입니다.");
			
			sframe.init();
			
			if(frame.button==1){
				
			p[1].state = p[1].move(p[1].state);
			if (p[1].round==1)
			{
				p[1].money += 50000;
				p[1].round = 0;
			}
			
			for(statecolor=0;statecolor<40;statecolor++){
				frame.wherep1[statecolor].setBackground(null);
				frame.wherep1[statecolor].setOpaque(false);
			}
			
			frame.wherep1[p[1].state].setOpaque(true);
			frame.wherep1[p[1].state].setBackground(Color.black);
			
			
			frame.ranNumOneLabel.setText( "                 " +  ((Integer)p[1].randomOne).toString() +"                 "  );
			frame.ranNumTwoLabel.setText( "                 " +  ((Integer)p[1].randomTwo).toString() +"                 "  );
			frame.pOneStateLabel.setText( "       " +   ((Integer)p[1].state).toString() +". "+ d[p[1].state].name + "             "   );
			
			sframe.dText.setText( ((Integer)d[p[1].state].tojiPrice).toString()   );
			sframe.hText.setText( ((Integer)d[p[1].state].homePrice).toString()   );
			sframe.bText.setText( ((Integer)d[p[1].state].byulPrice).toString()   );
			sframe.htText.setText( ((Integer)d[p[1].state].hotelPrice).toString()   );
			
			if((d[p[1].state].soyu==0)||(d[p[1].state].soyu==1)){
				sframe.setVisible(true);
			}
			
			else if(d[p[1].state].soyu==2)
			{
			frame.messageFieldtwo.setText("player2의 땅에 걸리셨습니다 벌금으로 : " + d[p[1].state].penalty + "를 지불합니다.");
			p[1].money -= d[p[1].state].penalty;
			p[2].money += d[p[1].state].penalty;
			sframe.wait=false;
			}
			

			else if((p[1].state==2)||(p[1].state==7)||(p[1].state==12)||(p[1].state==17)||(p[1].state==22)||(p[1].state==35))
			{
				
			goldenKey = goldKey.exe();	
			
				if(goldenKey==1){
					p[1].money += 40000;
					frame.messageFieldtwo.setText("황금열쇠! 복권에 당첨되어 4만원을 받습니다.");
				}
				else if(goldenKey==2){
					p[1].money = p[1].money - 30000;
					frame.messageFieldtwo.setText("황금열쇠! 교통사고로 병원에 입원하여 3만원을 병원비로 냅니다.");
				}
				else if(goldenKey==3){
					p[1].state = 39;
					
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep1[statecolor].setBackground(null);
						frame.wherep1[statecolor].setOpaque(false);
					}
					
					frame.wherep1[p[1].state].setOpaque(true);
					frame.wherep1[p[1].state].setBackground(Color.black);
					
					
					frame.messageFieldtwo.setText("황금열쇠! 서울로 관광여행을 떠납니다.");
				}
				else if(goldenKey==4){
					p[1].state = 25;
					
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep1[statecolor].setBackground(null);
						frame.wherep1[statecolor].setOpaque(false);
					}
					
					frame.wherep1[p[1].state].setOpaque(true);
					frame.wherep1[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 부산으로 관광여행을 떠납니다.");
				}
				else if(goldenKey==5){
					p[1].state = 5;
					
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep1[statecolor].setBackground(null);
						frame.wherep1[statecolor].setOpaque(false);
					}
					
					frame.wherep1[p[1].state].setOpaque(true);
					frame.wherep1[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 제주도로 관광여행을 떠납니다.");
				}
				else if(goldenKey==6){
					p[1].state = p[1].state - 2;
					
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep1[statecolor].setBackground(null);
						frame.wherep1[statecolor].setOpaque(false);
					}
					
					frame.wherep1[p[1].state].setOpaque(true);
					frame.wherep1[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 이사를 갑니다. 뒤로 두칸 가세요.");
				}
				else if(goldenKey==7){
					p[1].state = 0;
					
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep1[statecolor].setBackground(null);
						frame.wherep1[statecolor].setOpaque(false);
					}
					
					frame.wherep1[p[1].state].setOpaque(true);
					frame.wherep1[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 고속도로를 타고 바로 출발지로 갑니다.");
				}
				else if(goldenKey==8){
					goldbbb = 0;
					for(int bbb=0;bbb<40;bbb++){
						
						if(d[bbb].soyu==1)
							goldbbb ++;
					}
					
					p[1].money = p[1].money -  goldbbb*(5000);
					frame.messageFieldtwo.setText("황금열쇠! 가진 땅 갯수당 5천원씩 방범비를 냅니다.");
				}
				
			
			sframe.wait=false;	
			}
			
			else if(p[1].state==38){
				p[1].money = p[1].money - 50000;
				frame.messageFieldtwo.setText("사회복지기금으로 5만원을 기부합니다.");
				sframe.wait=false;
			}
			
			while(sframe.wait){
				
			}
			
			if((sframe.ddangcheck==1)&&(p[1].money >= d[p[1].state].tojiPrice)){
				p[1].money -= d[p[1].state].tojiPrice;
				d[p[1].state].buytoji(1);
				frame.whereplayer[p[1].state].setOpaque(true);
				frame.whereplayer[p[1].state].setBackground(Color.red);
			}
			if((sframe.homecheck==1)&&(p[1].money >= d[p[1].state].homePrice)){
				p[1].money -= d[p[1].state].homePrice;
				d[p[1].state].buyhome();
			}
			if((sframe.byulcheck==1)&&(p[1].money >= d[p[1].state].byulPrice)){
				p[1].money -= d[p[1].state].byulPrice;
				d[p[1].state].buybyul();
			}
			if((sframe.hotelcheck==1)&&(p[1].money >= d[p[1].state].hotelPrice)){
				p[1].money -= d[p[1].state].hotelPrice;
				d[p[1].state].buyhotel();
			}
			
			frame.playerOne.setText(  ((Integer)p[1].money).toString()    );
			frame.playerTwo.setText(  ((Integer)p[2].money).toString()    );
			
			sframe.wait = true;
			frame.messageField.setText("Player 2의 차례입니다.");
			sframe.init();
			//d[p[1].state].event(d[p[1].state].soyu,1);
			
			
			}			
			else if(frame.button==2){
				
			p[2].state = p[2].move(p[2].state);
			if (p[2].round==1)
			{
				p[2].money += 50000;
				p[2].round = 0;
			}
			
			for(statecolor=0;statecolor<40;statecolor++){
				frame.wherep2[statecolor].setOpaque(false);
				frame.wherep2[statecolor].setBackground(null);
				
			}
			
			frame.wherep2[p[2].state].setOpaque(true);
			frame.wherep2[p[2].state].setBackground(Color.black);
			
			
			
			frame.ranNumOneLabel.setText( "                 " +  ((Integer)p[2].randomOne).toString() + "                 " );
			frame.ranNumTwoLabel.setText( "                 " +  ((Integer)p[2].randomTwo).toString() + "                 " );
			frame.pTwoStateLabel.setText( "       " +   ((Integer)p[2].state).toString() +". "+ d[p[2].state].name + "             "   );
			
			//d[p[2].state].event(d[p[2].state].soyu,2);
			
			
			sframe.dText.setText( ((Integer)d[p[2].state].tojiPrice).toString()   );
			sframe.hText.setText( ((Integer)d[p[2].state].homePrice).toString()   );
			sframe.bText.setText( ((Integer)d[p[2].state].byulPrice).toString()   );
			sframe.htText.setText( ((Integer)d[p[2].state].hotelPrice).toString()   );
			
			if((d[p[2].state].soyu==0)||(d[p[2].state].soyu==2))
			{	sframe.setVisible(true);
				
			}
			
			else if(d[p[2].state].soyu==1)
			{
			frame.messageFieldtwo.setText("player1의 땅에 걸리셨습니다 벌금으로 : " + d[p[2].state].penalty + "를 지불합니다.");
			p[2].money -= d[p[2].state].penalty;
			p[1].money += d[p[2].state].penalty;
			sframe.wait = false;
			}
			
			else if((p[2].state==2)||(p[2].state==7)||(p[2].state==12)||(p[2].state==17)||(p[2].state==22)||(p[2].state==35))
			{
				
			goldenKey = goldKey.exe();	
			
				if(goldenKey==1){
					p[2].money += 40000;
					frame.messageFieldtwo.setText("황금열쇠! 복권에 당첨되어 4만원을 받습니다.");
				}
				else if(goldenKey==2){
					p[2].money -= 30000;
					frame.messageFieldtwo.setText("황금열쇠! 교통사고로 병원에 입원하여 3만원을 병원비로 냅니다.");
				}
				else if(goldenKey==3){
					p[2].state = 39;
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep2[statecolor].setBackground(null);
						frame.wherep2[statecolor].setOpaque(false);
					}
					
					frame.wherep2[p[1].state].setOpaque(true);
					frame.wherep2[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 서울로 관광여행을 떠납니다.");
				}
				else if(goldenKey==4){
					p[2].state = 25;
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep2[statecolor].setBackground(null);
						frame.wherep2[statecolor].setOpaque(false);
					}
					
					frame.wherep2[p[1].state].setOpaque(true);
					frame.wherep2[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 부산으로 관광여행을 떠납니다.");
				}
				else if(goldenKey==5){
					p[2].state = 5;
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep2[statecolor].setBackground(null);
						frame.wherep2[statecolor].setOpaque(false);
					}
					
					frame.wherep2[p[1].state].setOpaque(true);
					frame.wherep2[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 제주도로 관광여행을 떠납니다.");
				}
				else if(goldenKey==6){
					p[2].state = p[2].state - 2;
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep2[statecolor].setBackground(null);
						frame.wherep2[statecolor].setOpaque(false);
					}
					
					frame.wherep2[p[1].state].setOpaque(true);
					frame.wherep2[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 이사를 갑니다. 뒤로 두칸 가세요.");
				}
				else if(goldenKey==7){
					p[2].state = 0;
					for(statecolor=0;statecolor<40;statecolor++){
						frame.wherep2[statecolor].setBackground(null);
						frame.wherep2[statecolor].setOpaque(false);
					}
					
					frame.wherep2[p[1].state].setOpaque(true);
					frame.wherep2[p[1].state].setBackground(Color.black);
					
					frame.messageFieldtwo.setText("황금열쇠! 고속도로를 타고 바로 출발지로 갑니다.");
				}
				else if(goldenKey==8){
					goldbbb = 0;
					for(int bbbb=0;bbbb<40;bbbb++){
						
						if(d[bbbb].soyu==2)
							goldbbb ++;
					}
					
					p[2].money -= goldbbb*(5000);
					frame.messageFieldtwo.setText("황금열쇠! 가진 땅 갯수당 5천원씩 방범비를 냅니다.");
				}
				
			
			sframe.wait=false;	
			}

			else if(p[2].state==38){
				p[2].money -= 50000;
				frame.messageFieldtwo.setText("사회복지기금으로 5만원을 기부합니다.");
				sframe.wait=false;
			}
			
			while(sframe.wait){
				
			}
			
			if((sframe.ddangcheck==1)&&(p[2].money >= d[p[2].state].tojiPrice)){
				p[2].money -= d[p[2].state].tojiPrice;
				d[p[2].state].buytoji(2);
				frame.whereplayer[p[2].state].setOpaque(true);
				frame.whereplayer[p[2].state].setBackground(Color.blue);
			}
			if((sframe.homecheck==1)&&(p[2].money >= d[p[2].state].homePrice)){
				p[2].money -= d[p[2].state].homePrice;
				d[p[2].state].buyhome();
			}
			if((sframe.byulcheck==1)&&(p[2].money >= d[p[2].state].byulPrice)){
				p[2].money -= d[p[2].state].byulPrice;
				d[p[2].state].buybyul();
			}
			if((sframe.hotelcheck==1)&&(p[2].money >= d[p[2].state].hotelPrice)){
				p[2].money -= d[p[2].state].hotelPrice;
				d[p[2].state].buyhotel();
			}
			
			
			
			frame.playerOne.setText(  ((Integer)p[1].money).toString()    );
			frame.playerTwo.setText(  ((Integer)p[2].money).toString()    );
			
			sframe.wait = true;
			
			}	
		// 주사위 끝
			

			//제한 40턴 이내에 주사위를 굴리고 걸리는 땅마다 이벤트 발생
			frame.wait = true;	
			while(frame.wait){
				
			}
			
		}
		
		if(p[1].money>p[2].money)
		frame.messageField.setText("게임이 종료되었습니다. Player1이 승리하였습니다.");
		else
		frame.messageField.setText("게임이 종료되었습니다. Player2이 승리하였습니다.");
		

	}    
    

    class ChangeModeListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    	
    		if (turn%2==0)
    		button=1;
    		else if(turn%2==1)
    		button=2;
    		
    		turn++; //턴 증가
    		wait = false;
    		
    		
    	}
    }

    class TimeListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    	//	time++;
    	}
    }

    class NewListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		setVisible(false);
    		JFrame frame = new mainFrame();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setVisible(true);
    	}
    }

    class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.exit(0);
		}
	}

	class HelpFrameListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		JFrame helpFrame = new JFrame();
    		helpFrame.setSize(300, 300);
    		helpFrame.setTitle("Help");
			helpFrame.setVisible(true);
    	}
    }
}
```

2.
```

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;




public class secondFrame extends JFrame{

	private int FRAME_WIDTH=350;
	private int FRAME_HEIGHT=455;
	
	private JPanel totalPanel;
	private JPanel dPanel;
	private JPanel hPanel;
	private JPanel bPanel;
	private JPanel htPanel;
	
	JCheckBox dBox;
	JCheckBox hBox;
	JCheckBox bBox;
	JCheckBox htBox;
	
	JTextField dText;
	JTextField hText;
	JTextField bText;
	JTextField htText;
	
	JButton aButton;
	JButton bButton;
	private JPanel buttonPanel;
	
	boolean wait=true;
	
	int ddangcheck=0;
	int homecheck=0;
	int byulcheck=0;
	int hotelcheck=0;
	
	
	public secondFrame(){
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("땅 구입");
	
		totalPanel = new JPanel();
		dPanel = new JPanel();
		hPanel = new JPanel();
		bPanel = new JPanel();
		htPanel = new JPanel();
		
		dBox = new JCheckBox();
		hBox = new JCheckBox();
		bBox = new JCheckBox();
		htBox = new JCheckBox();		
		
		dPanel.setBorder(new TitledBorder(new EtchedBorder(), "땅 구입비용"));
		hPanel.setBorder(new TitledBorder(new EtchedBorder(), "집 구입비용"));
		bPanel.setBorder(new TitledBorder(new EtchedBorder(), "별장 구입비용"));
		htPanel.setBorder(new TitledBorder(new EtchedBorder(), "호텔 구입비용"));
		
		dText = new JTextField();
		hText = new JTextField();
		bText = new JTextField();
		htText = new JTextField();
		
		aButton = new JButton();
		bButton = new JButton();
		
		aButton.setText("확인");
		aButton.addActionListener(new aListener());
		bButton.setText("취소");
		bButton.addActionListener(new bListener());
		
		buttonPanel = new JPanel();
		
		dPanel.add(dBox);
		dPanel.add(dText);
		hPanel.add(hBox);
		hPanel.add(hText);
		bPanel.add(bBox);
		bPanel.add(bText);
		htPanel.add(htBox);
		htPanel.add(htText);
		
		totalPanel.setLayout(new GridLayout(4,1));
		totalPanel.add(dPanel);
		totalPanel.add(hPanel);
		totalPanel.add(bPanel);
		totalPanel.add(htPanel);
		
		add(totalPanel, BorderLayout.CENTER);
		
		buttonPanel.add(aButton);
		buttonPanel.add(bButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
	
	}
	
	public void init(){
		
		ddangcheck = 0;
		homecheck = 0;
		byulcheck = 0;
		hotelcheck = 0;
		dBox.setSelected(true);
		hBox.setSelected(false);
		bBox.setSelected(false);
		htBox.setSelected(false);
	}
	
	
    class aListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    	
    		if(dBox.isSelected())
    			ddangcheck = 1;
    		else ddangcheck = 0;
    		
    		if(hBox.isSelected())
    			homecheck = 1;
    		else homecheck = 0;
    		
    		if(bBox.isSelected())
    			byulcheck = 1;
    		else byulcheck = 0;
    		
    		if(htBox.isSelected())
    			hotelcheck = 1;
    		else hotelcheck = 0;
    		
    		
    		setVisible(false);
    		wait = false;
    		
    	}
    }

    class bListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    	
    		setVisible(false);
    		wait = false;
    		
    	}
    }
	

    
	//플레이어가 땅에 도착했을때 땅 구매 여부를 물어보는 창의 그래픽을 나타내는 클래스 입니다.
	
}


	//플레이어가 땅에 도착했을때 땅 구매 여부를 물어보는 창의 그래픽을 나타내는 클래스 입니다.
	
```

3.
```

public class player {

	int money; // 플레이어가 가진돈
	int state; // 플레이어의 현재위치
	int desertIsland; // 무인도에서의 턴을 체크
	int worldTravel; // 전 턴에서 세계여행 칸에 도착했는지 체크
	int sanghwang;
	
	int randomOne=0;
	int randomTwo=0;
	int round=0;

	public void reset(){
		// 초기화
		money = 300000;
		state = 0;
		desertIsland = 0;
		worldTravel = 0;
		
	}
	
	public int move(int a){
	

	
		randomOne = (int) ((Math.random()*6)+1);
		randomTwo = (int) ((Math.random()*6)+1);
		

		for(int loop=0;loop<(randomOne+randomTwo);loop++){
			a += 1;
			if(a==40){ 
				a=0;
			round = 1;
			}	
				
			//////////////////////////////////////////////////
			}
		
		return a;
		
/*		
		while(randomOne==randomTwo){
			//더블
			randomOne = (int) (Math.random()*6+1);
			randomTwo = (int) (Math.random()*6+1);
			for(int looop=0;looop<(randomOne+randomTwo);looop++){
				a += 1;
				if(a==40) a=0;
				///////////////////////위치이동 실행///////////////////
				if(playerNumber==1){
					return a;
				}
				else if(playerNumber==2){
					return a;
				}
				
				//////////////////////////////////////////////////
				}
		}
		
	*/
		
		//return a;
	}
	
	

}


```

4.
```

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class gameHelper {
	// 초기화를 진행하고 게임이 시작되는 메인이 존재 하는 클래스
	
	int turn;  // 제한턴 체크
	

	
}
```

5.

http://postfiles7.naver.net/20121026_150/cbj5210_1351178763393RnMbJ_JPEG/class.jpg?type=w3

> 5-1.
```


public class toji {

	String name; // 토지 이름

	int tojiPrice; //토지 가격
	int homePrice; //집 가격
	int byulPrice; //빌딩 가격
	int hotelPrice;//호텔 가격

	int penalty=0; //상대방이 걸렸을 시 벌금
	int soyu=0;    //소유권자
	/*
	public void event(int playerNumber){
		
		//플레이어가 땅에 도착했을 시 secondFrame을 띄우고 땅 구입 여부 확인하고
		//상대유저 도착시 벌금을 내게 함.
		
		if( (soyu==playerNumber) || (soyu==0) ){
			
			//땅구입
			
			
		}
		else{
			
			//벌금
			
		}
		
		
	}
	*/
	public void buytoji(int i){
		penalty += tojiPrice;
		soyu = i;
		tojiPrice = 0;
		
		//땅 구입시 구입가격만큼 상대편이 지불해야 할 패널티를 증가시키고 소유권을 가짐
		//다시 땅에 도착하여 재 클릭 했을시 패널티가 증가하면 안되므로 0으로 값을 바꿔줌
	}
	
	public void buyhome(){
		
		if(tojiPrice==0) //땅을 가진 후에만 건물을 지을 수 있음
			{
				penalty += homePrice; // 집 구매시 벌금을 증가시키고
				homePrice = 0; //다시 땅에 돌아와 구매하려 해도 패널티가 증가하지 않게끔 초기화
			}
		
	}
	
	public void buybyul(){

		if(tojiPrice==0) //땅을 가진 후에만 건물을 지을 수 있음
			{
				penalty += byulPrice; // 빌딩 구매시 벌금을 증가시키고
				byulPrice = 0; //다시 땅에 돌아와 구매하려 해도 패널티가 증가하지 않게끔 초기화
			}
		
	}
	
	public void buyhotel(){

		if(tojiPrice==0) //땅을 가진 후에만 건물을 지을 수 있음
			{
				penalty += hotelPrice; // 호텔 구매시 벌금을 증가시키고
				hotelPrice = 0; //다시 땅에 돌아와 구매하려 해도 패널티가 증가하지 않게끔 초기화
			}
		
	}
	
}
```

> 5-2.

```

public class goldKey {

	int random;
	
	
	public int exe(){
		//플레이어가 도착했을 시 랜덤하게 이벤트 효과 발생 i는 플레이어 번호
		
		int i = (int) (Math.random()*8+1);
		
		return i;
		
	}
	
	
}

```


# Source code #

http://comp166-koreauniv.googlecode.com/files/bluemarble.zip


# Screen shot #

![http://comp166-koreauniv.googlecode.com/files/1.jpg](http://comp166-koreauniv.googlecode.com/files/1.jpg)

1 : 시작 화면

![http://comp166-koreauniv.googlecode.com/files/2.jpg](http://comp166-koreauniv.googlecode.com/files/2.jpg)

2 : player1이 주사위를 던진 후, player1의 위치가 검은색으로 표시되고 도착한 마닐라의 소유권자가 없으므로 땅 구입창이 생성

![http://comp166-koreauniv.googlecode.com/files/3.jpg](http://comp166-koreauniv.googlecode.com/files/3.jpg)

3 : 구입할 땅과 건물을 선택하고 확인을 누르면 땅의 색깔이 소유권자의 색깔로 바뀜
(player1은 빨강 player2는 파랑)

![http://comp166-koreauniv.googlecode.com/files/4.jpg](http://comp166-koreauniv.googlecode.com/files/4.jpg)

4 : 황금열쇠

![http://comp166-koreauniv.googlecode.com/files/5.jpg](http://comp166-koreauniv.googlecode.com/files/5.jpg)

5 : 타인의 땅에 걸렸을 때 위에 2번째 상태표시줄에 벌금을 표시함과 더불어 벌금 지불

![http://comp166-koreauniv.googlecode.com/files/6.jpg](http://comp166-koreauniv.googlecode.com/files/6.jpg)

6 : 랜덤하게 발생하는 또 다른 황금열쇠

![http://comp166-koreauniv.googlecode.com/files/7.jpg](http://comp166-koreauniv.googlecode.com/files/7.jpg)

7 : 또 다른 황금열쇠

![http://comp166-koreauniv.googlecode.com/files/8.jpg](http://comp166-koreauniv.googlecode.com/files/8.jpg)

8 : 땅 구입 메소드 실행시 구입과 더불어 추후에 재 구입하는 쓸데없는 경우를 막기 위해 땅값을 가르키는 인스턴스 변수의 값을 0으로 변경하였기 때문에 위와 같이 땅 값이 0으로 표시 된다.


![http://comp166-koreauniv.googlecode.com/files/9.jpg](http://comp166-koreauniv.googlecode.com/files/9.jpg)

9 : player2의 소지금이 0보다 작아졌기 때문에 게임을 종료, 제한턴 40을 넘겼을 때도 게임은 종료되며 그때의 승자는 소지금이 더 많은 player가 승자로 표시된다.

![http://comp166-koreauniv.googlecode.com/files/10.jpg](http://comp166-koreauniv.googlecode.com/files/10.jpg)

10 : 메뉴창