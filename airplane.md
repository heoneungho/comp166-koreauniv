# Introduction #

영화를 예매하는 프로그램 입니다.

원래는 비행기를 예매하는 프로그램이었지만, 국가와 도시가 너무 많은 관계로 비슷한 것으로 변경 했습니다.


# Details #
```

// 1. Start : 시작하는 함수이고, 지점을 묻습니다.

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1. \uC9C0\uC810");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(183, 10, 73, 32);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 79, 127, 21);
		contentPane.add(comboBox);
		
		comboBox.addItem("강남CGV");
		comboBox.addItem("왕십리CGV");
		comboBox.addItem("명동CGV");
		comboBox.addItem("강변CGV");
		comboBox.addItem("구로CGV");
		comboBox.addItem("대학로CGV");
		comboBox.addItem("강동CGV");
		comboBox.addItem("군자CGV");
		comboBox.addItem("송파CGV");
		comboBox.addItem("압구정CGV");
		comboBox.addItem("공항CGV");
		comboBox.addItem("상암CGV");
		comboBox.addItem("목동CGV");
		comboBox.addItem("미아CGV");
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Age a = new Age();
				a.show();
			
			}
		});
		btnNewButton.setBounds(325, 195, 97, 23);
		contentPane.add(btnNewButton);
	}

}
// 2. Age: 영화 이용등급을 묻습니다.
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Age extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Age frame = new Age();
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
	public Age() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2. \uC774\uC6A9 \uB4F1\uAE09");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(153, 32, 108, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("18\uC138 \uC774\uC0C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OverNT n = new OverNT();
				n.show();
				
			}
		});
		btnNewButton.setBounds(75, 88, 108, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("15\uC138 \uC774\uC6A9\uAC00");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OverFi o = new OverFi();
				o.show();
			}
		});
		btnNewButton_1.setBounds(236, 88, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC804\uCCB4 \uC774\uC6A9\uAC00");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllUse q = new AllUse();
				q.show();
			}
		});
		btnNewButton_2.setBounds(236, 155, 108, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("12\uC138 \uC774\uC6A9\uAC00");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OverTw l = new OverTw();
				l.show();
			}
		});
		btnNewButton_3.setBounds(75, 155, 108, 23);
		contentPane.add(btnNewButton_3);
	}

}


//3. 2번에서 이용 등급에 따라 이동합니다.

// 3-1. 18세 이상 영화

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OverNT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OverNT frame = new OverNT();
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
	public OverNT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("3. \uC601\uD654 \uC120\uD0DD (18+)");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(125, 25, 169, 32);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(125, 85, 169, 21);
		contentPane.add(comboBox);
		
		comboBox.addItem("내가 살인범이다.");
		comboBox.addItem("아워 이디엇 브라더");
		comboBox.addItem("우리도 사랑일까");
		comboBox.addItem("개들의 전쟁");
		comboBox.addItem("지난 여름, 갑자기/ 남쪽으로 간다.");
		comboBox.addItem("백야");
		comboBox.addItem("피에타");
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time t = new Time();
				t.show();
			}
		});
		btnNewButton.setBounds(325, 229, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Age age = new Age();
				age.show();
			}
		});
		btnNewButton_1.setBounds(216, 229, 97, 23);
		contentPane.add(btnNewButton_1);
	
	}

}
 
//3-2. 15세 이상 영화

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OverFi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OverFi frame = new OverFi();
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
	public OverFi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("3. \uC601\uD654 \uC120\uD0DD (15+)");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(137, 10, 175, 33);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(137, 96, 175, 21);
		contentPane.add(comboBox);
		comboBox.addItem("늑대소년");
		comboBox.addItem("26년");
		comboBox.addItem("브레이킹 던 part 2");
		comboBox.addItem("광해, 왕이 된 남자");
		comboBox.addItem("돈 크라이 마미");
		comboBox.addItem("나우 이즈 굿");
		comboBox.addItem("남영동 1985");
		comboBox.addItem("내가 고백을 하면");
		comboBox.addItem("자칼이 온다.");
		comboBox.addItem("당신은 아직 아무것도 보지 못했다.");
		comboBox.addItem("더블");
		comboBox.addItem("볼케이노 : 삶의 전환점에 선 남자");
		comboBox.addItem("범죄 소년");
		comboBox.addItem("퍼스트 포지션");
		comboBox.addItem("007 스카이폴");
		comboBox.addItem("가족시네마");
		comboBox.addItem("용의자X");
		comboBox.addItem("아르고");
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time t = new Time();
				t.show();
			}
		});
		btnNewButton.setBounds(325, 229, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Age age = new Age();
				age.show();
			}
		});
		btnNewButton_1.setBounds(215, 229, 97, 23);
		contentPane.add(btnNewButton_1);
	
	}

}

//3-3. 12세 이용가

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OverTw extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OverTw frame = new OverTw();
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
	public OverTw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("3. \uC601\uD654 \uC120\uD0DD (12+)");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(131, 10, 161, 21);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 93, 161, 21);
		contentPane.add(comboBox);
		
		comboBox.addItem("음치클리닉");
		comboBox.addItem("내 인생의 마지막 변화구");
		comboBox.addItem("철가방 우수氏");
		comboBox.addItem("업사이드 다운");
		comboBox.addItem("지저스 크라이스트 슈퍼스타");
		comboBox.addItem("반드시 크게 들을 것 2: Wild Days");
	
		
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time t = new Time();
				t.show();
			}
		});
		btnNewButton.setBounds(325, 229, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Age a = new Age();
				a.show();
			}
		});
		btnNewButton_1.setBounds(216, 229, 97, 23);
		contentPane.add(btnNewButton_1);
	}

}


//3-4 전체 이용가

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AllUse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllUse frame = new AllUse();
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
	public AllUse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("3. \uC601\uD654 \uC120\uD0DD (\uC804\uCCB4 \uC774\uC6A9\uAC00)");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(99, 10, 237, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time t = new Time();
				t.show();
			}
		});
		btnNewButton.setBounds(325, 229, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Age a = new Age();
				a.show();
			}
		});
		btnNewButton_1.setBounds(216, 229, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(99, 101, 237, 21);
		contentPane.add(comboBox);
		
		comboBox.addItem("가디언즈");
		comboBox.addItem("밤의 이야기");
		comboBox.addItem("2000 - 2001 서태지 밴드 라이브 콘서트 태지의 화");
		comboBox.addItem("2004 서태지 밴드 라이브 투어 제로");
		comboBox.addItem("엔딩노트");
		comboBox.addItem("서태지 밴드 라이브 투어 더 뫼비우스");
		comboBox.addItem("2008 서태지 심포니 위드 톨가 카쉬프 로열 필하모닉");
		comboBox.addItem("심플라이프");
		comboBox.addItem("메리다와 마법의 숲");
		comboBox.addItem("퍼스트 포지션");
		comboBox.addItem("점박이 : 한반도의 공룡 3D");
		comboBox.addItem("밀림의 왕자 레오2");
		
		
	}

}

//4. Time : 영화 시간대를 선택합니다.

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Time extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Time frame = new Time();
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
	public Time() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("4. \uC2DC\uAC04\uB300 \uC120\uD0DD");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(139, 10, 140, 28);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(129, 112, 184, 21);
		contentPane.add(comboBox);
		
		comboBox.addItem("8:00");
		comboBox.addItem("10:30");
		comboBox.addItem("13:00");
		comboBox.addItem("15:30");
		comboBox.addItem("18:00");
		comboBox.addItem("20:30");
		comboBox.addItem("23:00");
		comboBox.addItem("01:30");
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People p = new People();
				p.show();
			}
		});
		btnNewButton.setBounds(325, 229, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Age a = new Age();
				a.show();
			}
		});
		btnNewButton_1.setBounds(216, 229, 97, 23);
		contentPane.add(btnNewButton_1);
	}

}

//5. People : 인원수를 택합니다.

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class People extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					People frame = new People();
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
	public People() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("5. \uC778\uC6D0\uC218");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(167, 10, 122, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date d = new Date();
				d.show();
			}
		});
		btnNewButton.setBounds(325, 229, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time t = new Time();
				t.show();
			}
		});
		btnNewButton_1.setBounds(216, 229, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 102, 193, 21);
		contentPane.add(comboBox);
		comboBox.addItem("1명");
		comboBox.addItem("2명");
		comboBox.addItem("3명");
		comboBox.addItem("4명");
		comboBox.addItem("5명");
		comboBox.addItem("6명");
		comboBox.addItem("7명");
		comboBox.addItem("8명");
		comboBox.addItem("9명");
		comboBox.addItem("10명");
		comboBox.addItem("11명");
		comboBox.addItem("12명");
		comboBox.addItem("13명");
		comboBox.addItem("14명");
		comboBox.addItem("15명");
		comboBox.addItem("16명");
		comboBox.addItem("17명");
		comboBox.addItem("18명");
		comboBox.addItem("19명");
		comboBox.addItem("20명");
	
		
		textField = new JTextField();
		textField.setText("\uC601\uD654\uD45C\uB294 1\uC778\uB2F9 8000\uC6D0 \uC785\uB2C8\uB2E4.");
		textField.setBounds(130, 133, 175, 86);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}


//6.Date: 날짜 선택

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Date extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date frame = new Date();
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
	public Date() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("6. \uB0A0\uC9DC");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(179, 10, 89, 45);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(151, 113, 50, 21);
		contentPane.add(comboBox);
		
		comboBox.addItem("1월");
		comboBox.addItem("2월");
		comboBox.addItem("3월");
		comboBox.addItem("4월");
		comboBox.addItem("5월");
		comboBox.addItem("6월");
		comboBox.addItem("7월");
		comboBox.addItem("8월");
		comboBox.addItem("9월");
		comboBox.addItem("10월");
		comboBox.addItem("11월");
		comboBox.addItem("12월");
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(213, 113, 55, 21);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItem("1일");
		comboBox_1.addItem("2일");
		comboBox_1.addItem("3일");
		comboBox_1.addItem("4일");
		comboBox_1.addItem("5일");
		comboBox_1.addItem("6일");
		comboBox_1.addItem("7일");
		comboBox_1.addItem("8일");
		comboBox_1.addItem("9일");
		comboBox_1.addItem("10일");
		comboBox_1.addItem("11알");
		comboBox_1.addItem("12일");
		comboBox_1.addItem("13일");
		comboBox_1.addItem("14일");
		comboBox_1.addItem("15일");
		comboBox_1.addItem("16일");
		comboBox_1.addItem("17일");
		comboBox_1.addItem("18일");
		comboBox_1.addItem("19일");
		comboBox_1.addItem("20일");
		comboBox_1.addItem("21일");
		comboBox_1.addItem("22일");
		comboBox_1.addItem("23일");
		comboBox_1.addItem("24일");
		comboBox_1.addItem("25일");
		comboBox_1.addItem("26일");
		comboBox_1.addItem("27일");
		comboBox_1.addItem("28일");
		comboBox_1.addItem("29일");
		comboBox_1.addItem("30알");
		comboBox_1.addItem("31일");
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seat s = new Seat();
				s.show();
			}
		});
		btnNewButton.setBounds(325, 229, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People p = new People();
				p.show();
			}
		});
		btnNewButton_1.setBounds(216, 229, 97, 23);
		contentPane.add(btnNewButton_1);
	}

}

//7. Seat: 자리 선택

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Seat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat frame = new Seat();
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
	public Seat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("7.\uC790\uB9AC");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(173, 10, 87, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("CENTER");
		textField.setText("         \uC2A4\uD06C\uB9B0");
		textField.setBounds(150, 60, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxA = new JCheckBox("A1");
		chckbxA.setBounds(72, 100, 40, 23);
		contentPane.add(chckbxA);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("A2");
		chckbxNewCheckBox.setBounds(115, 100, 40, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("A3");
		chckbxNewCheckBox_1.setBounds(158, 100, 40, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("A4");
		chckbxNewCheckBox_2.setBounds(201, 100, 40, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("A5");
		chckbxNewCheckBox_3.setBounds(244, 100, 40, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("A6");
		chckbxNewCheckBox_4.setBounds(287, 100, 40, 23);
		contentPane.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("B1");
		chckbxNewCheckBox_5.setBounds(8, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("B2");
		chckbxNewCheckBox_6.setBounds(51, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("C1");
		chckbxNewCheckBox_7.setBounds(8, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("D1");
		chckbxNewCheckBox_8.setBounds(8, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("E1");
		chckbxNewCheckBox_9.setBounds(8, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("F1");
		chckbxNewCheckBox_10.setBounds(8, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("B3");
		chckbxNewCheckBox_11.setBounds(94, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_11);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("B4");
		chckbxNewCheckBox_12.setBounds(137, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_12);
		
		JCheckBox chckbxNewCheckBox_13 = new JCheckBox("B5");
		chckbxNewCheckBox_13.setBounds(180, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_13);
		
		JCheckBox chckbxNewCheckBox_14 = new JCheckBox("B6");
		chckbxNewCheckBox_14.setBounds(223, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_14);
		
		JCheckBox chckbxNewCheckBox_15 = new JCheckBox("B7");
		chckbxNewCheckBox_15.setBounds(266, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_15);
		
		JCheckBox chckbxNewCheckBox_16 = new JCheckBox("B8");
		chckbxNewCheckBox_16.setBounds(309, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_16);
		
		JCheckBox chckbxNewCheckBox_17 = new JCheckBox("B9");
		chckbxNewCheckBox_17.setBounds(352, 125, 40, 23);
		contentPane.add(chckbxNewCheckBox_17);
		
		JCheckBox chckbxNewCheckBox_18 = new JCheckBox("C2");
		chckbxNewCheckBox_18.setBounds(51, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_18);
		
		JCheckBox chckbxNewCheckBox_19 = new JCheckBox("C3");
		chckbxNewCheckBox_19.setBounds(94, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_19);
		
		JCheckBox chckbxNewCheckBox_20 = new JCheckBox("D2");
		chckbxNewCheckBox_20.setBounds(51, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_20);
		
		JCheckBox chckbxNewCheckBox_21 = new JCheckBox("E2");
		chckbxNewCheckBox_21.setBounds(51, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_21);
		
		JCheckBox chckbxNewCheckBox_22 = new JCheckBox("F2");
		chckbxNewCheckBox_22.setBounds(51, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_22);
		
		JCheckBox chckbxNewCheckBox_23 = new JCheckBox("D3");
		chckbxNewCheckBox_23.setBounds(94, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_23);
		
		JCheckBox chckbxNewCheckBox_24 = new JCheckBox("E3");
		chckbxNewCheckBox_24.setBounds(94, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_24);
		
		JCheckBox chckbxNewCheckBox_25 = new JCheckBox("F3");
		chckbxNewCheckBox_25.setBounds(94, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_25);
		
		JCheckBox chckbxNewCheckBox_26 = new JCheckBox("F4");
		chckbxNewCheckBox_26.setBounds(137, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_26);
		
		JCheckBox chckbxNewCheckBox_27 = new JCheckBox("F5");
		chckbxNewCheckBox_27.setBounds(180, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_27);
		
		JCheckBox chckbxNewCheckBox_28 = new JCheckBox("F6");
		chckbxNewCheckBox_28.setBounds(223, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_28);
		
		JCheckBox chckbxNewCheckBox_29 = new JCheckBox("E4");
		chckbxNewCheckBox_29.setBounds(137, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_29);
		
		JCheckBox chckbxNewCheckBox_30 = new JCheckBox("D4");
		chckbxNewCheckBox_30.setBounds(137, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_30);
		
		JCheckBox chckbxNewCheckBox_31 = new JCheckBox("C4");
		chckbxNewCheckBox_31.setBounds(137, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_31);
		
		JCheckBox chckbxNewCheckBox_32 = new JCheckBox("C9");
		chckbxNewCheckBox_32.setBounds(352, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_32);
		
		JCheckBox chckbxNewCheckBox_33 = new JCheckBox("C8");
		chckbxNewCheckBox_33.setBounds(309, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_33);
		
		JCheckBox chckbxNewCheckBox_34 = new JCheckBox("C7");
		chckbxNewCheckBox_34.setBounds(266, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_34);
		
		JCheckBox chckbxC = new JCheckBox("C6");
		chckbxC.setBounds(222, 148, 40, 23);
		contentPane.add(chckbxC);
		
		JCheckBox chckbxNewCheckBox_35 = new JCheckBox("D5");
		chckbxNewCheckBox_35.setBounds(180, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_35);
		
		JCheckBox chckbxNewCheckBox_36 = new JCheckBox("D6");
		chckbxNewCheckBox_36.setBounds(223, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_36);
		
		JCheckBox chckbxNewCheckBox_37 = new JCheckBox("D7");
		chckbxNewCheckBox_37.setBounds(266, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_37);
		
		JCheckBox chckbxNewCheckBox_38 = new JCheckBox("D8");
		chckbxNewCheckBox_38.setBounds(309, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_38);
		
		JCheckBox chckbxNewCheckBox_39 = new JCheckBox("D9");
		chckbxNewCheckBox_39.setBounds(352, 173, 40, 23);
		contentPane.add(chckbxNewCheckBox_39);
		
		JCheckBox chckbxNewCheckBox_40 = new JCheckBox("E9");
		chckbxNewCheckBox_40.setBounds(352, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_40);
		
		JCheckBox chckbxNewCheckBox_41 = new JCheckBox("E8");
		chckbxNewCheckBox_41.setBounds(309, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_41);
		
		JCheckBox chckbxNewCheckBox_42 = new JCheckBox("F9");
		chckbxNewCheckBox_42.setBounds(352, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_42);
		
		JCheckBox chckbxNewCheckBox_43 = new JCheckBox("F8");
		chckbxNewCheckBox_43.setBounds(309, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_43);
		
		JCheckBox chckbxNewCheckBox_44 = new JCheckBox("F7");
		chckbxNewCheckBox_44.setBounds(266, 223, 40, 23);
		contentPane.add(chckbxNewCheckBox_44);
		
		JCheckBox chckbxNewCheckBox_45 = new JCheckBox("E6");
		chckbxNewCheckBox_45.setBounds(223, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_45);
		
		JCheckBox chckbxNewCheckBox_46 = new JCheckBox("E5");
		chckbxNewCheckBox_46.setBounds(180, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_46);
		
		JCheckBox chckbxNewCheckBox_47 = new JCheckBox("E7");
		chckbxNewCheckBox_47.setBounds(266, 198, 40, 23);
		contentPane.add(chckbxNewCheckBox_47);
		
		JCheckBox chckbxNewCheckBox_48 = new JCheckBox("C5");
		chckbxNewCheckBox_48.setBounds(180, 148, 40, 23);
		contentPane.add(chckbxNewCheckBox_48);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date d = new Date();
				d.show();
			}
		});
		btnNewButton.setBounds(325, 11, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				End a = new End();
				a.show();
			}
		});
		btnNext.setBounds(325, 44, 97, 23);
		contentPane.add(btnNext);
	}

}

//8. 종료

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class End extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					End frame = new End();
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
	public End() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC608\uC57D\uC774 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(113, 69, 225, 109);
		contentPane.add(lblNewLabel);
	}

}

```

1. Start

어느 지점을 이용할 지 정합니다.

![http://comp166-koreauniv.googlecode.com/files/1.Start.jpg](http://comp166-koreauniv.googlecode.com/files/1.Start.jpg)




2.Age

영화 나이대를 선택합니다.

![http://comp166-koreauniv.googlecode.com/files/2.Age.jpg](http://comp166-koreauniv.googlecode.com/files/2.Age.jpg)




3.OverNT

18세 이상 영화입니다.

![http://comp166-koreauniv.googlecode.com/files/3.OverET.jpg](http://comp166-koreauniv.googlecode.com/files/3.OverET.jpg)






3-2.OverFif

15세 이상 영화입니다.

![http://comp166-koreauniv.googlecode.com/files/3-3.OverFif.jpg](http://comp166-koreauniv.googlecode.com/files/3-3.OverFif.jpg)






3-3.OverTw

12세 이상 영화입니다,

![http://comp166-koreauniv.googlecode.com/files/3-2.OverTwe.jpg](http://comp166-koreauniv.googlecode.com/files/3-2.OverTwe.jpg)





3-4.All

전체 이용가 영화입니다.

![http://comp166-koreauniv.googlecode.com/files/3-4.Allp.jpg](http://comp166-koreauniv.googlecode.com/files/3-4.Allp.jpg)





4.Time

시간대를 선택합니다.

![http://comp166-koreauniv.googlecode.com/files/4.Time.jpg](http://comp166-koreauniv.googlecode.com/files/4.Time.jpg)





5.People

인원수를 선택합니다.

![http://comp166-koreauniv.googlecode.com/files/5.People.jpg](http://comp166-koreauniv.googlecode.com/files/5.People.jpg)





6.Date

날짜를 선택합니다.

![http://comp166-koreauniv.googlecode.com/files/6.Date.jpg](http://comp166-koreauniv.googlecode.com/files/6.Date.jpg)





7.Seat

인원수 만큼 좌석을 선택합니다.

![http://comp166-koreauniv.googlecode.com/files/7.Seat.jpg](http://comp166-koreauniv.googlecode.com/files/7.Seat.jpg)






8.End

종료합니다.

![http://comp166-koreauniv.googlecode.com/files/8.End.jpg](http://comp166-koreauniv.googlecode.com/files/8.End.jpg)