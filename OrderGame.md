# Introduction #

제가 만들고자 하는 게임은
이야기 순서, 요리 순서, 그림 순서, 노래가사 순서, 역사적 사건의 순서 등 여러가지 것들의 순서를 맞추는 게임입니다.


# Details #

  * 문제 형식은 순서를 맞추는 것이다.

  * 게임player가 원하는 문제 분야를 선택하면 해당 문제가 나오고, 그 문제를 푸는 게임이다.

  * 순서를 맞추면 다른 분야의 문제를 더 풀거나 게임을 끝낼 수 있다.

  * 답을 맞추지 못해도 게임을 중도 포기 할 수 있다.


# Strong Points #

게임의 원리가 '순서 맞추기'로서 매우 쉽기 때문에 게임에 대한 특별한 지식이나 능력없이도 누구나 참여할 수 있다.

따라서 주변의 친구들이나 가족들과 함께 할 수 있다는 장점이 있다.

또 문제 유형이 다양하기 때문에 지루하지 않게 계속 할 수 있다.

이 밖에도 역사순서 맞추기 게임을 통해 외우기 힘든 역사적 사건들의 시간순서를 학습할 수도 있고

요리의 조리순서 게임을 통해 레시피를 쉽게 익힐 수 있고,

노래가사 순서 게임을 통해 헷갈리는 노래가사를 외울 수 있다.

게임을 하면서 시를 외워 지적이고 교양있어 보일 수 있게 되는 등 각 게임마다 게임 이용자들에게 유익함을 제공한다.

게임의 또 다른 장점은 문제 소재의 한계가 없다는 것이다.

사람들이 쉽게 외우고 싶은 것들이 있다면 무엇이든지 게임으로 개발하여 새로운 게임을 제공할 수 있다.

# Outline #
**개략적인 class구성**
```
①orderGame.class
     메인클래스
     게임을 시작시키거나 게임에 대한 설명을 볼 수 있다.

②SelectGame.class
     player가 문제 유형 선택

③Game.class

     - StoryGame.class 
          이야기의 순서 맞추기 게임
     - LyricGame.class
          노래 가사/시 등의 순서 맞추기 게임
     - RecipeGame.class
          요리 순서 맞추기 게임
     - HistoryOrderGame.class
          역사적 사건의 순서 맞추기 게임

④Result.class
     정답과 오답을 판단.
     정답일 경우 다른 유형의 게임을 계속할 건지 게임을 그만둘 건지 묻고,
     오답일 경우 재도전 할 건지 포기할 것인지 player에게 물음.
     -RightResult.class
          정답임을 알려주는 화면.
          Exit / Another
     -WrongResult.class
          오답임을 알려주는 화면
          Give Up / Retry
 
⑤About.class
     게임에 대한 설명을 보여주는 화면.
```


# Code #
**orderGame.java**

![http://comp166-koreauniv.googlecode.com/files/OrderGame_main.jpg](http://comp166-koreauniv.googlecode.com/files/OrderGame_main.jpg)

```

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings({ "unused", "serial" })
public class orderGame extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrderGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderGame frame = new orderGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public orderGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtOrderGame = new JTextField();
		txtOrderGame.setForeground(Color.WHITE);
		txtOrderGame.setBounds(0, 0, 442, 123);
		txtOrderGame.setEditable(false);
		txtOrderGame.setBackground(Color.PINK);
		txtOrderGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtOrderGame.setFont(new Font("굴림", Font.BOLD, 50));
		txtOrderGame.setText("ORDER GAME");
		contentPane.add(txtOrderGame);
		txtOrderGame.setColumns(10);
		
		JButton btnStart = new JButton("START");	//게임시작 버튼  생성
		btnStart.setForeground(Color.BLUE);
		btnStart.setFont(new Font("굴림", Font.PLAIN, 40));
		btnStart.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				SelectGame select = new SelectGame();
				select.show();
			}
		});
		btnStart.setBounds(130, 147, 201, 44);
		contentPane.add(btnStart);
		
		JButton btnAbout = new JButton("ABOUT");	//게임설명버튼 생성
		btnAbout.setForeground(Color.GRAY);
		btnAbout.setFont(new Font("굴림", Font.PLAIN, 40));
		btnAbout.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				about ab = new about();
				ab.show();
			}
		});
		btnAbout.setBounds(130, 201, 201, 44);
		contentPane.add(btnAbout);
	}
}

```

**about.java**

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;


@SuppressWarnings("serial")
public class about extends JFrame {

	private JPanel contentPane;
	private JTextField txtAboutOrderGame;

	/**
	 * Create the frame.
	 */
	public about() {
		setTitle("About Order Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBack = new JButton("BACK");	//메인화면으로 되돌아가는 버튼 생성
		btnBack.setBounds(5, 238, 432, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		
		JTextArea txtrOrderGame = new JTextArea();
		txtrOrderGame.setText("Order Game\uC740 \uC21C\uC11C \uB9DE\uCD94\uAE30 \uAC8C\uC784\uC774\uB2E4.\r\n\uC5ED\uC0AC \uC21C\uC11C, \uC774\uC57C\uAE30 \uC21C\uC11C, \uC870\uB9AC \uC21C\uC11C, \uB178\uB798\uAC00\uC0AC \uC21C\uC11C \uB4F1 \uB2E4\uC591\uD55C \uC885\uB958\uC758 \uBB38\uC81C\uAC00 \uC788\uB2E4. \r\n\uAC8C\uC784 \uBC29\uBC95\uC740 \uD558\uB2E8\uC5D0 \uC788\uB294 Answer Sheet\uC5D0 \uB2F5\uC744 \uC785\uB825\uD55C \uD6C4 DONE \uBC84\uD2BC\uC744 \uB204\uB974\uBA74 \r\n\uC815\uB2F5 \uC5EC\uBD80\uAC00 \uB098\uC624\uB294 \uAC83\uC73C\uB85C \uB0A8\uB140\uB178\uC18C \uB204\uAD6C\uB098 \uD560 \uC218 \uC788\uB294 \uC26C\uC6B4 \uAC8C\uC784\uC774\uB2E4.\r\n\uC55E\uC73C\uB85C \uC5C5\uB370\uC774\uD2B8\uB97C \uD1B5\uD574 \uAC8C\uC784\uC758 \uC885\uB958\uB97C \uB298\uB824\uAC08 \uACC4\uD68D\uC774\uB2E4.\r\n\r\n\uAC1C\uBC1C\uC790 : \uACE0\uB824\uB300\uD559\uAD50 \uCEF4\uD4E8\uD130\uAD50\uC721\uACFC \uCC44\uC720\uC5F0");
		txtrOrderGame.setBackground(Color.LIGHT_GRAY);
		txtrOrderGame.setBounds(5, 78, 432, 156);
		contentPane.add(txtrOrderGame);
		
		txtAboutOrderGame = new JTextField();
		txtAboutOrderGame.setEditable(false);
		txtAboutOrderGame.setForeground(Color.YELLOW);
		txtAboutOrderGame.setBackground(Color.GRAY);
		txtAboutOrderGame.setFont(new Font("굴림", Font.BOLD, 30));
		txtAboutOrderGame.setBounds(5, 5, 432, 63);
		txtAboutOrderGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtAboutOrderGame.setText("ABOUT Order Game");
		contentPane.add(txtAboutOrderGame);
		txtAboutOrderGame.setColumns(10);
	}

}
```

**SelectGame.java**

![http://comp166-koreauniv.googlecode.com/files/OrderGame_select.jpg](http://comp166-koreauniv.googlecode.com/files/OrderGame_select.jpg)

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;


@SuppressWarnings("serial")
public class SelectGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SelectGame() {
		setTitle("Select Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblHistory = new JLabel("HISTORY");	//역사순서 게임선택 라벨
		lblHistory.setForeground(Color.BLUE);
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("굴림", Font.BOLD, 40));
		lblHistory.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				historyGame hg = new historyGame();
				hg.show();
			}
		});
		contentPane.add(lblHistory);
		
		JLabel lblRecipe = new JLabel("RECIPE");	//조리순서 게임선택 라벨
		lblRecipe.setForeground(Color.PINK);
		lblRecipe.setFont(new Font("굴림", Font.BOLD, 40));
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				recipeGame rg = new recipeGame();
				rg.show();
			}
		});
		contentPane.add(lblRecipe);
		
		JLabel lblStory = new JLabel("STORY");	//이야기순서 게임선택 라벨
		lblStory.setForeground(Color.ORANGE);
		lblStory.setFont(new Font("굴림", Font.BOLD, 40));
		lblStory.setHorizontalAlignment(SwingConstants.CENTER);
		lblStory.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				storyGame sg = new storyGame();
				sg.show();
			}
		});
		contentPane.add(lblStory);
		
		JLabel lblLyric = new JLabel("LYRIC");	//노래가사순서 게임선택 라벨
		lblLyric.setForeground(Color.GREEN);
		lblLyric.setFont(new Font("굴림", Font.BOLD, 40));
		lblLyric.setHorizontalAlignment(SwingConstants.CENTER);
		lblLyric.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lyricGame lg = new lyricGame();
				lg.show();
			}
		});
		contentPane.add(lblLyric);
	}

}
```

**Game.java**

```
//전체 게임의 상위 클래스
public interface Game {

	public int[] makeAnswer(int[] answer);	//정답 랜덤 생성 메소드
	public String theAnswer (int[] answer);	//int로 저장된 정답 String으로 변환하는 메소드
}
```

**historyGame.java**

![http://comp166-koreauniv.googlecode.com/files/OrderGame_history.jpg](http://comp166-koreauniv.googlecode.com/files/OrderGame_history.jpg)

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;


@SuppressWarnings("serial")
public class historyGame extends JFrame implements Game{

	private JPanel contentPane;
	private JTextField txtHistoryOrderGame;
	private JButton btnDone;
	private Panel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textAnswer;
	private int[] ansList = {1,2,3,4,5};

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public historyGame() {
		setTitle("History Order Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHistoryOrderGame = new JTextField();
		txtHistoryOrderGame.setForeground(SystemColor.text);
		txtHistoryOrderGame.setBackground(SystemColor.inactiveCaption);
		txtHistoryOrderGame.setFont(new Font("굴림", Font.BOLD, 17));
		txtHistoryOrderGame.setEditable(false);
		txtHistoryOrderGame.setBounds(5, 5, 432, 27);
		txtHistoryOrderGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtHistoryOrderGame.setText("\uD55C\uAD6D\uC0AC");
		contentPane.add(txtHistoryOrderGame);
		txtHistoryOrderGame.setColumns(10);
		
		
		panel = new Panel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(5, 33, 432, 205);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ansList = makeAnswer(ansList);	//정답생성
		
		//문제생성
		label = new JLabel(ansList[1]+". \uADE0\uC5ED\uBC95 \uC2E4\uC2DC");
		label.setForeground(new Color(128, 128, 0));
		panel.add(label);
		
		label_1 = new JLabel(ansList[0]+". \uBCD1\uC790\uD638\uB780");
		label_1.setForeground(new Color(0, 206, 209));
		panel.add(label_1);
		
		label_2 = new JLabel(ansList[3]+". \uBC15\uC815\uD76C \uC815\uBD80 \uC131\uB9BD");
		label_2.setForeground(new Color(128, 0, 128));
		panel.add(label_2);
		
		label_3 = new JLabel(ansList[4]+". 6\uC6D4 \uBBFC\uC8FC \uD56D\uC7C1");
		label_3.setForeground(new Color(128, 0, 0));
		panel.add(label_3);
		
		label_4 = new JLabel(ansList[2]+". \uB300\uD55C\uBBFC\uAD6D \uC784\uC2DC\uC815\uBD80 \uC218\uB9BD");
		label_4.setForeground(new Color(25, 25, 112));
		panel.add(label_4);
		
		textAnswer = new JTextField();	//답안작성란
		textAnswer.setFont(new Font("굴림", Font.PLAIN, 15));
		textAnswer.setBounds(15, 239, 240, 27);
		contentPane.add(textAnswer);
		textAnswer.setColumns(10);
		
		btnDone = new JButton("DONE");	//정답제출 버튼
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textAnswer.getText().equals(theAnswer(ansList))){
					RightResult rr = new RightResult();
					rr.show();
				}
				else {
					WrongResult wr = new WrongResult();
					wr.show();
				}

			}
		});
		btnDone.setBounds(282, 239, 148, 27);
		contentPane.add(btnDone);
	}

	@Override
	public int[] makeAnswer(int[] answer) {
		for(int i = 0; i < answer.length; i++){
			answer[i]=((int)(Math.random()*answer.length)+1);
			for(int j=0;j<i;j++){
				if(answer[i]==answer[j]){
					i--;
					break;
				}
			}
		}
		return answer;
	}

	@Override
	public String theAnswer(int[] answer) {
		String Ans = Integer.toString(answer[0]);
		for(int i=1;i<answer.length;i++){
			Ans = Ans+ Integer.toString(answer[i]);
		}
		return Ans;
	}
}
```

**recipeGame.java**

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class recipeGame extends JFrame implements Game{

	private JPanel contentPane;
	private JTextField txtRecipeOrderGame;
	private JTextField textAnswer;
	private int[] ansList = {1,2,3,4,5,6};

	/**
	 * Create the frame.
	 */
	public recipeGame() {
		setTitle("Recipe Order Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRecipeOrderGame = new JTextField();
		txtRecipeOrderGame.setEditable(false);
		txtRecipeOrderGame.setForeground(new Color(255, 165, 0));
		txtRecipeOrderGame.setBackground(new Color(173, 255, 47));
		txtRecipeOrderGame.setFont(new Font("굴림", Font.BOLD, 17));
		txtRecipeOrderGame.setBounds(5, 5, 488, 27);
		txtRecipeOrderGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecipeOrderGame.setText("\uC5D0\uADF8\uD0C0\uB974\uD2B8");
		contentPane.add(txtRecipeOrderGame);
		txtRecipeOrderGame.setColumns(10);
		
		textAnswer = new JTextField();
		textAnswer.setFont(new Font("굴림", Font.PLAIN, 15));
		textAnswer.setBounds(15, 239, 240, 27);
		contentPane.add(textAnswer);
		textAnswer.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(5, 33, 488, 205);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ansList = makeAnswer(ansList);
		
		JLabel label = new JLabel(ansList[2]+". \uAC15\uB825\uBD84, \uBC15\uB825\uBD84, \uBD84\uC720\uB97C \uCCB4\uC5D0 \uB0B4\uB9B0 \uD6C4 \uBC84\uD130\uB97C \uB123\uACE0 \uC798\uAC8C \uBD80\uC21C\uB2E4.");
		label.setForeground(new Color(255, 99, 71));
		panel.add(label);
		
		JLabel label_1 = new JLabel(ansList[0]+". \uC6B0\uC720,\uBC14\uB2D0\uB77C\uBE48,\uB2EC\uAC40\uB178\uB978\uC790,\uC124\uD0D5,\uBC15\uB825\uBD84,\uBC84\uD130,\uB7FC\uC744 \uC0AC\uC6A9\uD558\uC5EC \uCEE4\uC2A4\uD130\uB4DC \uD06C\uB9BC\uC744 \uB9CC\uB4E0\uB2E4.");
		label_1.setForeground(new Color(30, 144, 255));
		panel.add(label_1);
		
		JLabel label_2 = new JLabel(ansList[4]+". \uCC2C\uBB3C\uC5D0 \uC18C\uAE08\uACFC \uC124\uD0D5\uC744 \uB179\uC778\uB2E4.");
		label_2.setForeground(new Color(50, 205, 50));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(ansList[1]+". \uCEE4\uC2A4\uD0C0\uB4DC \uD06C\uB9BC\uC744 3/4\uC815\uB3C4 \uB2F4\uACE0 \uC608\uC5F4\uB41C \uC624\uBE10\uC628\uB3C4 180\uB3C4\uC5D0\uC11C 25\uBD84 \uAC00\uB7C9 \uAD7D\uB294\uB2E4.");
		label_3.setForeground(new Color(255, 99, 71));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel(ansList[5]+". \uAC00\uC6B4\uB370\uB97C \uC6C0\uD479\uD558\uAC8C \uB9CC\uB4E0 \uB4A4 \uCC2C\uBB3C\uC744 \uC870\uAE08\uC529 \uBD93\uACE0 \uBC18\uC8FD\uD558\uC5EC \uB0C9\uC7A5\uACE0\uC5D0\uC11C 20~30\uBD84 \uD734\uC9C0.");
		label_4.setForeground(new Color(30, 144, 255));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel(ansList[3]+". \uBC18\uC8FD\uC744 \uB450\uAED8 3mm\uC815\uB3C4\uB85C \uBC00\uC5B4 \uBAA8\uC591\uD2C0\uB85C \uBAA8\uC591\uC744 \uB9CC\uB4E4\uACE0 \uB0C9\uC7A5\uACE0\uC5D0 20\uBD84 \uC815\uB3C4 \uD734\uC9C0.");
		label_5.setForeground(new Color(50, 205, 50));
		panel.add(label_5);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textAnswer.getText().equals(theAnswer(ansList))) {
					RightResult rr = new RightResult();
					rr.show();
				}
				else {
					WrongResult wr = new WrongResult();
					wr.show();
				}
			}
		});
		btnDone.setBounds(282, 239, 148, 27);
		contentPane.add(btnDone);
	}

	@Override
	public int[] makeAnswer(int[] answer) {
		for(int i = 0; i < answer.length; i++){
			answer[i]=((int)(Math.random()*answer.length)+1);
			for(int j=0;j<i;j++){
				if(answer[i]==answer[j]){
					i--;
					break;
				}
			}
		}
		return answer;
	}

	@Override
	public String theAnswer(int[] answer) {
		String Ans = Integer.toString(answer[0]);
		for(int i=1;i<answer.length;i++){
			Ans = Ans+ Integer.toString(answer[i]);
		}
		return Ans;
	}
}
```

**storyGame.java**

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class storyGame extends JFrame implements Game{

	private JPanel contentPane;
	private JTextField txtStoryOrderGame;
	private JTextField textAnswer;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private int[] ansList = {1,2,3,4,5,6,7};

	/**
	 * Create the frame.
	 */
	public storyGame() {
		setTitle("Story Order Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtStoryOrderGame = new JTextField();
		txtStoryOrderGame.setForeground(new Color(0, 0, 255));
		txtStoryOrderGame.setBackground(new Color(255, 0, 0));
		txtStoryOrderGame.setEditable(false);
		txtStoryOrderGame.setFont(new Font("굴림", Font.BOLD, 17));
		txtStoryOrderGame.setBounds(5, 5, 445, 27);
		txtStoryOrderGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtStoryOrderGame.setText("\uBBF8\uC548\uD558\uB2E4 \uC0AC\uB791\uD55C\uB2E4");
		contentPane.add(txtStoryOrderGame);
		txtStoryOrderGame.setColumns(10);
		
		textAnswer = new JTextField();
		textAnswer.setFont(new Font("굴림", Font.PLAIN, 15));
		textAnswer.setBounds(15, 239, 240, 27);
		contentPane.add(textAnswer);
		textAnswer.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(153, 50, 204));
		panel.setBounds(5, 33, 445, 205);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ansList = makeAnswer(ansList);
		
		label = new JLabel(ansList[3]+". \uBB34\uD601\uC740 \uC790\uC2E0\uC758 \uC2EC\uC7A5\uC744 \uC724\uC5D0\uAC8C \uAE30\uC99D\uD558\uACE0 \uC138\uC0C1\uC744 \uB5A0\uB09C\uB2E4.");
		label.setForeground(new Color(253, 245, 230));
		label.setBackground(new Color(128, 0, 128));
		panel.add(label);
		
		label_1 = new JLabel(ansList[4]+". \uD654\uB824\uD558\uAC8C \uC0AC\uB294 \uC0DD\uBAA8\uB97C \uBCF4\uC790 \uBCF5\uC218\uB97C \uACB0\uC2EC.");
		label_1.setForeground(new Color(255, 182, 193));
		panel.add(label_1);
		
		JLabel label_2 = new JLabel(ansList[1]+". 1\uB144 \uD6C4 \uC2DC\uB4DC\uB2C8\uC5D0 \uC788\uB294 \uBB34\uD601\uC5D0 \uBE44\uC11D \uC55E\uC5D0\uC11C \uC740\uCC44\uB294 \uC138\uC0C1\uACFC \uC774\uBCC4\uD568.");
		label_2.setForeground(new Color(253, 245, 230));
		label_2.setBackground(new Color(128, 0, 128));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(ansList[5]+". \uD0DC\uC5B4\uB098\uC790\uB9C8\uC790 \uC0DD\uBAA8\uC5D0\uAC8C, \uD638\uC8FC\uB85C \uC785\uC591\uB41C \uD6C4 \uC591\uBD80\uBAA8\uC5D0\uAC8C \uBC84\uB9BC \uBC1B\uC740 \uBB34\uD601.");
		label_3.setForeground(new Color(255, 182, 193));
		panel.add(label_3);
		
		label_4 = new JLabel(ansList[6]+". \uC9C0\uC601\uC744 \uAD6C\uD558\uB2E4\uAC00 \uB9DE\uC740 \uC720\uD0C4 \uC911 \uC81C\uAC70 \uD558\uC9C0 \uBABB\uD55C 1\uBC1C\uC774 \uBA38\uB9AC\uC5D0 \uBC15\uD78C \uCC44 \uD55C\uAD6D\uD589.");
		label_4.setForeground(new Color(253, 245, 230));
		label_4.setBackground(new Color(128, 0, 128));
		panel.add(label_4);
		
		label_5 = new JLabel(ansList[0]+". \uD638\uC8FC\uC5D0\uC11C \uC6B0\uC5F0\uD788 \uB9CC\uB0AC\uB358 \uC740\uCC44\uB97C \uB2E4\uC2DC \uB9CC\uB098\uACE0 \uC0AC\uB791\uD558\uAC8C \uB428.");
		label_5.setForeground(new Color(255, 182, 193));
		panel.add(label_5);
		
		label_6 = new JLabel(ansList[2]+". \uC740\uCC44\uB294 \uAD50\uD1B5\uC0AC\uACE0\uB85C \uBCD1\uC6D0\uC5D0 \uC788\uB294 \uC724\uC758 \uACC1\uC744 \uB5A0\uB0A0 \uC218 \uC5C6\uC5B4 \uD798\uB4E4\uC5B4 \uD568.");
		label_6.setForeground(new Color(253, 245, 230));
		label_6.setBackground(new Color(128, 0, 128));
		panel.add(label_6);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textAnswer.getText().equals(theAnswer(ansList))) {
					RightResult rr  = new RightResult();
					rr.show();
				}
				else {
					WrongResult wr = new WrongResult();
					wr.show();
				}
			}
		});
		btnDone.setBounds(282, 239, 148, 27);
		contentPane.add(btnDone);
	}

	@Override
	public int[] makeAnswer(int[] answer) {
		for(int i = 0; i < answer.length; i++){
			answer[i]=((int)(Math.random()*answer.length)+1);
			for(int j=0;j<i;j++){
				if(answer[i]==answer[j]){
					i--;
					break;
				}
			}
		}
		return answer;
	}

	@Override
	public String theAnswer(int[] answer) {
		String Ans = Integer.toString(answer[0]);
		for(int i=1;i<answer.length;i++){
			Ans = Ans+ Integer.toString(answer[i]);
		}
		return Ans;
	}
}
```

**lyricGame.java**

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class lyricGame extends JFrame implements Game{

	private JPanel contentPane;
	private JTextField txtLyricOrderGame;
	private JTextField textAnswer;
	private JButton btnDone;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private int[] ansList = {1,2,3,4,5,6};

	/**
	 * Create the frame.
	 */
	public lyricGame() {
		setTitle("Lyric Order Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLyricOrderGame = new JTextField();
		txtLyricOrderGame.setEditable(false);
		txtLyricOrderGame.setBackground(new Color(127, 255, 212));
		txtLyricOrderGame.setBounds(5, 5, 432, 27);
		txtLyricOrderGame.setFont(new Font("굴림", Font.BOLD, 17));
		txtLyricOrderGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtLyricOrderGame.setText("Sherlock\u00B7\uC15C\uB85D(Clue+Note)");
		contentPane.add(txtLyricOrderGame);
		txtLyricOrderGame.setColumns(10);
		
		textAnswer = new JTextField();
		textAnswer.setFont(new Font("굴림", Font.PLAIN, 15));
		textAnswer.setBounds(15, 239, 240, 27);
		contentPane.add(textAnswer);
		textAnswer.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(34, 139, 34));
		panel.setBounds(5, 33, 432, 205);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ansList = makeAnswer(ansList);
		
		label = new JLabel(ansList[0]+". \uC774 \uD604\uC7A5\uC744 \uBC97\uC5B4\uB098\uC120 \uC548 \uB3FC / \uBA85\uBC31\uD55C \uC774 \uC0AC\uAC74 \uC18D\uC5D0 \uAE34\uC7A5\uD558\uC9C0 \uB9C8");
		label.setForeground(new Color(224, 255, 255));
		panel.add(label);
		
		label_1 = new JLabel(ansList[3]+". \uC9C0\uAE08 \uB0B4 \uC55E\uC5D0 \uB108\uB294 \uC2E4\uC7AC \uD558\uC9C0 \uC54A\uC544 / \uBD84\uBA85 \uC54C\uC9C0\uB9CC \uB108\uB97C \uC2EC\uBB38\uD558\uACA0\uC5B4");
		label_1.setForeground(new Color(224, 255, 255));
		panel.add(label_1);
		
		label_2 = new JLabel(ansList[2]+". \uC6A9\uC758\uC120\uC0C1\uC758 \uB110 \uCC3E\uC544\uB0C8\uC5B4 \uB09C Freeze!");
		label_2.setForeground(new Color(224, 255, 255));
		panel.add(label_2);
		
		label_3 = new JLabel(ansList[4]+". \uB108\uC758 \uB5A8\uB9B0 \uC228\uACB0 \uD558\uB098\uAE4C\uC9C0 \uB193\uCE58\uC9C0 \uC54A\uC544");
		label_3.setForeground(new Color(224, 255, 255));
		panel.add(label_3);
		
		label_4 = new JLabel(ansList[1]+". \uC544\uBB34\uAC83\uB3C4 \uBAA8\uB978\uB2E8 \uC5BC\uAD74\uB85C \uB10C");
		label_4.setForeground(new Color(224, 255, 255));
		panel.add(label_4);
		
		label_5 = new JLabel(ansList[5]+". \uBC94\uC778\uC740 \uC774 \uC548\uC5D0 \uC788\uC5B4 \uC544\uBB34\uB3C4 \uB098\uAC08 \uC218 \uC5C6\uC5B4");
		label_5.setForeground(new Color(224, 255, 255));
		panel.add(label_5);
		
		btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textAnswer.getText().equals(theAnswer(ansList))) {
					RightResult rr = new RightResult();
					rr.show();
				}
				else {
					WrongResult wr = new WrongResult();
					wr.show();
				}
			}
		});

		btnDone.setBounds(282, 239, 148, 27);
		contentPane.add(btnDone);
		
	}

	@Override
	public int[] makeAnswer(int[] answer) {
		for(int i = 0; i < answer.length; i++){
			answer[i]=((int)(Math.random()*answer.length)+1);
			for(int j=0;j<i;j++){
				if(answer[i]==answer[j]){
					i--;
					break;
				}
			}
		}
		return answer;
	}

	@Override
	public String theAnswer(int[] answer) {
		String Ans = Integer.toString(answer[0]);
		for(int i=1;i<answer.length;i++){
			Ans = Ans+ Integer.toString(answer[i]);
		}
		return Ans;
	}
}
```

**Result.java**

```
//RightResult.class와 WrongResult.class의 상위 클래스
public interface Result {
	}
```

**RightResult.java**

![http://comp166-koreauniv.googlecode.com/files/OrderGame_right.jpg](http://comp166-koreauniv.googlecode.com/files/OrderGame_right.jpg)

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


@SuppressWarnings("serial")
public class RightResult extends JFrame implements Result{

	private JPanel contentPane;
	private JTextField txtGoodJob;

	/**
	 * Create the frame.
	 */
	public RightResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGoodJob = new JTextField();
		txtGoodJob.setForeground(Color.RED);
		txtGoodJob.setBackground(Color.CYAN);
		txtGoodJob.setEditable(false);
		txtGoodJob.setBounds(0, 10, 442, 75);
		txtGoodJob.setFont(new Font("굴림", Font.PLAIN, 60));
		txtGoodJob.setHorizontalAlignment(SwingConstants.CENTER);
		txtGoodJob.setText("Good Job~!");
		contentPane.add(txtGoodJob);
		txtGoodJob.setColumns(10);
		
		JButton btnExit = new JButton("EXIT");	//나가기버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(getDefaultCloseOperation());
			}
		});
		btnExit.setBounds(0, 194, 214, 62);
		contentPane.add(btnExit);
		
		JButton btnAnother = new JButton("ANOTHER");	//다른문제 선택버튼
		btnAnother.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				SelectGame sg = new SelectGame();
				sg.show();
			}
		});
		btnAnother.setBounds(228, 194, 214, 62);
		contentPane.add(btnAnother);
	}
}
```

**WrongResult.java**

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class WrongResult extends JFrame implements Result{

	private JPanel contentPane;
	private JTextField txtWrong;


	/**
	 * Create the frame.
	 */
	public WrongResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWrong = new JTextField();
		txtWrong.setBackground(Color.GRAY);
		txtWrong.setEditable(false);
		txtWrong.setBounds(0, 10, 442, 75);
		txtWrong.setFont(new Font("굴림", Font.PLAIN, 60));
		txtWrong.setHorizontalAlignment(SwingConstants.CENTER);
		txtWrong.setText("Wrong...");
		contentPane.add(txtWrong);
		txtWrong.setColumns(10);
		
		JButton btnRetry = new JButton("RETRY");	//재시도 버튼
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnRetry.setBounds(0, 194, 214, 62);
		contentPane.add(btnRetry);
		
		JButton btnGiveUp = new JButton("GIVE UP");	//포기 버튼
		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(getDefaultCloseOperation());
			}
		});
		btnGiveUp.setBounds(228, 194, 214, 62);
		contentPane.add(btnGiveUp);
	}

}
```

# Downloads #

http://comp166-koreauniv.googlecode.com/files/2012190704_채유연.zip


Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages