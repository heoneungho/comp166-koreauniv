# Introduction #

<Director's Casting Book>
> 연출자가 좋은 작품을 만들기 위해서는 훌륭한 연기자를 섭외하는 것이 필수적이다. 매니저 역시 자신의 연예인을 성공시키기 위해서는 연예인의 일정, 연락처, 희망 출연료, 지금까지 맡았던 역할과 출연 작품 등을 연출자에게 홍보할 필요가 있다. 이 프로그램은 매니저들이 자신이 전담한 연예인의 스케줄을 비롯한 일련의 정보들을 입력함으로써 데이터베이스를 구축한다. 물론 연예인이 직접 자신의 정보를 프로그램에 업로드할 수도 있다. 연출자가 섭외 대상의 이름을 검색창에 입력하면 해당 연예인의 정보를 볼 수 있다. 프로그램의 수입은 매니저들의 베너 광고(연예인 홍보 목적)를 통해 얻는다. 연출자들에게는 무료로 개방한다.

> → 애초 계획은 이것이었으나, 실제 구현된 부분은 연예인의 기본 정보, 출연료, 연락처만을 보여줄 수 있고, 데이터베이스를 연동하지 못하여 매니저들이 직접 입력할 수 있지 않다. 프로그래머에게 말하여 정보를 업데이트할 수 있으며, PD와 매니저들은 회원가입을 통하여 정보를 열람해볼 수 있다. 회원가입도 프로그래머를 통하여만 가능하다.


# Details #

> 처음 프로그램을 시작하면 제한된 아이디와 비밀번호만을 입력하여 이용할 수 있게 된다. 아이디나 비밀번호가 저장되어있지 않은 것이면, 다시 입력할 수 있도록 된다. 그 다음에 검색창에 알아보고자 하는 연예인의 이름을 입력하고 그에 관한 정보가 탑재되어 있다면, 그 사람의 클래스로 연결되어 그에 관한 정보창이 뜬다. 탑재되어 있지 않다면, 다시 입력할 수 있도록 된다. 정보창에는 연예인의 이름, 생년월일, 소속사, 경력, 희망 출연료, 연락처가 적혀있고 여기서 주목할 점은 ‘희망 출연료, 연락처’라는 일반인들이 알 수 없는 고급 정보이다.

# Code #
**window builder를 적극 활용하여 만들었기 때문에, 코드에 관련하여 참고한 정보는 없다.
```

-Front 클래스 : 전체 프로그램을 실행시킬 클래스이다.-

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class Front extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front frame = new Front();
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
	public Front() {
		setTitle("\uCD08\uAE30\uCC3D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Director's Casting Book");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(71, 35, 432, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your ID & Password");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(134, 351, 316, 15);
		contentPane.add(lblNewLabel_1);
		

		JLabel lblNewLabel_2 = new JLabel("User ID:");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(52, 119, 103, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("굴림", Font.BOLD, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(52, 194, 103, 34);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(182, 120, 227, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 195, 227, 34);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log-in");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				
				final String my_passwd = 
				new String(passwordField.getPassword());
				final String my_id = new String(textField.getText());
				
				if(my_passwd.equals("1234")
					 && my_id.equals("sn500gogo"))
				//이 아이디와 비밀번호만 프로그램을 이용할 수 있다.
				{	
						Search search = new Search();
						search.show();
			//아이디와 비번이 일치한다면, search클래스의 창이 열린다.
				}
				if(!my_passwd.equals("1234") 
					|| !my_id.equals("sn500gogo"))
				{
					textField.setText("");
					passwordField.setText("");
			//내용 초기화
					Again again = new Again();
					again.show();
			//아이디와 비번이 일치하지 않으면, again클래스의 창이 열린다.
				}
			}
		});
		btnNewButton.setBounds(63, 285, 116, 34);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("굴림", Font.BOLD, 14));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				//닫기 버튼
			}
		});
		btnExit.setBounds(237, 285, 116, 34);
		contentPane.add(btnExit);
		
		JButton btnSignup = new JButton("Register");
		btnSignup.setFont(new Font("굴림", Font.BOLD, 14));
		btnSignup.setBounds(408, 285, 116, 34);
		contentPane.add(btnSignup);
	}
}

-Again 클래스 :　아이디와 비번이 일치하지 않으면, 연결되는 창-

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Again extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Again frame = new Again();
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
	public Again() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgain = new JButton("OK");
		btnAgain.setFont(new Font("굴림", Font.BOLD, 15));
		btnAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			//확인 버튼.
			}
		});
		btnAgain.setBounds(119, 88, 121, 23);
		contentPane.add(btnAgain);
		
		JLabel lblWrong = new JLabel("Wrong!");
			//틀렸음을 보여주는 라벨.
		lblWrong.setFont(new Font("굴림", Font.BOLD, 18));
		lblWrong.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrong.setBounds(131, 34, 95, 23);
		contentPane.add(lblWrong);
	}
}

-Search 클래스 : 연예인 이름을 입력하는 창-

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSearch;
	public String person;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Search(){
		
		setTitle("search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputAnEntertainers 
		= new JLabel("Input an Entertainer's name in English!");
		lblInputAnEntertainers.setBounds(82, 80, 442, 24);
		lblInputAnEntertainers.setFont(new Font("굴림", Font.BOLD, 20));
		lblInputAnEntertainers.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInputAnEntertainers);
		
		textField = new JTextField();
		textField.setBounds(227, 169, 159, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 15));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseClicked(MouseEvent e) {
					
					String person 
					= new String(textField.getText());
					if(person.equals("DongGunJang")){
						One one = new One();
						one.show();
					}
					if(person.equals("JeongHyunPark")){
						Two two = new Two();
						two.show();
					}
					if(person.equals("JiSunPark")){
						Three three = new Three();
						three.show();
					}
		//저장되어 있는 장동건, 박정현, 박지선의 이름을 치면 각각 그 사람의 
		 클래스의 창으로 연결된다.
					if(!person.equals("DongGunJang")
					&&!person.equals("JeongHyunPark")
					&&!person.equals("JiSunPark")){
						textField.setText("");
					//내용 초기화
						Back back = new Back();
						back.show();
			//저장되어 있지 않은 연예인 이름을 치면 back클래스의 창
			 으로 연결된다.(입력했던 내용이 초기화되면서)
					}
			}

		});
		btnSearch.setBounds(172, 275, 97, 23);
		contentPane.add(btnSearch);
		
		JButton btnNewButton = new JButton("Stop");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			//닫기 버튼
			}
		});
		btnNewButton.setBounds(340, 275, 97, 23);
		contentPane.add(btnNewButton);
		
	}
}

-Back 클래스 : 저장되어있지 않은 연예인의 이름을 쳤을 때 뜨는 창-

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
public class Back extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Back frame = new Back();
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
	public Back() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel 
			= new JLabel("There's no information about that!");
		//정보가 없음을 보여주는 라벨
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(37, 52, 278, 15);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\uD655\uC778");
		button.setFont(new Font("굴림", Font.BOLD, 12));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			//닫기 버튼
			}
		});
		button.setBounds(126, 99, 97, 23);
		contentPane.add(button);
	}
}

-Search2 클래스 : 검색된 연예인의 정보를 보여주는 창의 원형.
         	  이 클래스를 상속받아 사용하려 하였으나, GUI 구현이라 한계가 있어서	          실천하지 못했다. 그러나 이것을 이용하여 각 연예인에 해당하는 정보창		  을 만들었다. -

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

	public class Search2 extends JFrame {

		private JPanel contentPane;
		/**
		 * Launch the application.
		 */
		
			public void run() {
					try {
						Search2 apple = new Search2();
						apple.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

		/**
		 * Create the frame.
		 */
		public Search2() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 525);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Name");
		        //이름						  
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 69, 99, 53);
			contentPane.add(lblNewLabel);
			
			JLabel lblBirthDate = new JLabel("Birth Date");
			//생년월일
			lblBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblBirthDate.setBounds(12, 132, 99, 53);
			contentPane.add(lblBirthDate);
			
			JLabel lblAgency = new JLabel("Agency");
			//소속사
			lblAgency.setHorizontalAlignment(SwingConstants.CENTER);
			lblAgency.setBounds(12, 195, 99, 53);
			contentPane.add(lblAgency);
			
			JLabel lblCareer = new JLabel("Career");
			//경력
			lblCareer.setHorizontalAlignment(SwingConstants.CENTER);
			lblCareer.setBounds(12, 258, 99, 53);
			contentPane.add(lblCareer);
			
			JLabel lblPay = new JLabel("Pay");
			//희망 출연료
			lblPay.setHorizontalAlignment(SwingConstants.CENTER);
			lblPay.setBounds(12, 321, 99, 53);
			contentPane.add(lblPay);
			
			JLabel lblPhonenumber = new JLabel("PhoneNumber");
			//연락처			 		
		lblPhonenumber.setHorizontalAlignment(SwingConstants.CENTER);			lblPhonenumber.setBounds(12, 384, 99, 53);
			contentPane.add(lblPhonenumber);
			
			JPanel panel = new JPanel();
			panel.setBounds(396, 158, -94, -103);
			contentPane.add(panel);
			
			JLabel label_5 = new JLabel("");
			label_5.setBounds(169, 88, 57, 15);
			contentPane.add(label_5);
			
			JLabel labelname = new JLabel("");
			labelname.setBounds(123, 88, 126, 15);
			contentPane.add(labelname);
	
			JLabel labelage = new JLabel("");
			labelage.setBounds(123, 151, 103, 15);
			contentPane.add(labelage);
	
			JLabel labelcompany = new JLabel("");
			labelcompany.setBounds(123, 214, 103, 15);
			contentPane.add(labelcompany);
	
			JLabel labelpay = new JLabel("");
			labelpay.setBounds(123, 340, 103, 15);
			contentPane.add(labelpay);
	
			JLabel labelnumber = new JLabel("");
			labelnumber.setBounds(123, 403, 103, 15);
			contentPane.add(labelnumber);
			
			JButton btnClose = new JButton("Close");
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			btnClose.setBounds(169, 442, 97, 23);
			contentPane.add(btnClose);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(123, 258, 239, 64);
			contentPane.add(textArea);

		}
	}

-One 클래스 : 장동건에 관한 정보를 담은 창.
	       각각의 정보에 대응하는 textField의 내용만 채워졌을 뿐, 
	       Search2의 창과 모형은 같다. 그러므로 주석을 생략하겠다.-

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

	public class One extends JFrame {

		private JPanel contentPane;
		/**
		 * Launch the application.
		 */
		
			public void run() {
					try {
						Search2 apple = new Search2();
						apple.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

		/**
		 * Create the frame.
		 */
		public One() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 525);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 69, 99, 53);
			contentPane.add(lblNewLabel);
			
			JLabel lblBirthDate = new JLabel("Birth Date");
			lblBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblBirthDate.setBounds(12, 132, 99, 53);
			contentPane.add(lblBirthDate);
			
			JLabel lblAgency = new JLabel("Agency");
			lblAgency.setHorizontalAlignment(SwingConstants.CENTER);
			lblAgency.setBounds(12, 195, 99, 53);
			contentPane.add(lblAgency);
			
			JLabel lblCareer = new JLabel("Career");
			lblCareer.setHorizontalAlignment(SwingConstants.CENTER);
			lblCareer.setBounds(12, 258, 99, 53);
			contentPane.add(lblCareer);
			
			JLabel lblPay = new JLabel("Pay");
			lblPay.setHorizontalAlignment(SwingConstants.CENTER);
			lblPay.setBounds(12, 333, 99, 53);
			contentPane.add(lblPay);
			
			JLabel lblPhonenumber = new JLabel("PhoneNumber");
			lblPhonenumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblPhonenumber.setBounds(12, 384, 99, 53);
			contentPane.add(lblPhonenumber);
			
			JPanel panel = new JPanel();
			panel.setBounds(396, 158, -94, -103);
			contentPane.add(panel);
			
			JLabel lblDonggunJang = new JLabel("DongGun Jang");
			lblDonggunJang.setFont(new Font("굴림", Font.BOLD, 15));
			lblDonggunJang.setBounds(123, 88, 239, 15);
			contentPane.add(lblDonggunJang);
			
			JLabel labelname = new JLabel("");
			labelname.setBounds(123, 88, 126, 15);
			contentPane.add(labelname);
	
			JLabel labelage = new JLabel("72.03.07");
			labelage.setFont(new Font("굴림", Font.BOLD, 15));
			labelage.setBounds(123, 151, 239, 15);
			contentPane.add(labelage);
	
			JLabel labelcompany = new JLabel("SM C&C");
			labelcompany.setFont(new Font("굴림", Font.BOLD, 15));
			labelcompany.setBounds(123, 214, 239, 15);
			contentPane.add(labelcompany);
	
			JLabel labelpay = new JLabel("5,000,000 won\r\n");
			labelpay.setFont(new Font("굴림", Font.BOLD, 15));
			labelpay.setBounds(123, 352, 239, 15);
			contentPane.add(labelpay);
	
			JLabel labelnumber = new JLabel("010-123-1234");
			labelnumber.setFont(new Font("굴림", Font.BOLD, 15));
			labelnumber.setBounds(123, 403, 239, 15);
			contentPane.add(labelnumber);
			
			JButton btnClose = new JButton("Close");
			btnClose.setFont(new Font("굴림", Font.BOLD, 12));
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			btnClose.setBounds(169, 442, 97, 23);
			contentPane.add(btnClose);
			
			JTextArea txtrAppearance = new JTextArea();
			txtrAppearance.setFont(new Font("Monospaced", Font.BOLD, 13));
			txtrAppearance.setText("2012 <Gentleman's Dignity> \r\n\tLeading actor\r\n2000 <All about Eve> Leading actor");
			txtrAppearance.setBounds(123, 258, 284, 64);
			contentPane.add(txtrAppearance);

		}
	}

-Two 클래스 : 박정현에 관한 정보를 담은 창.
	       각각의 정보에 대응하는 textField의 내용만 채워졌을 뿐, 
	       Search2의 창과 모형은 같다. 그러므로 주석을 생략하겠다.-

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

	public class Two extends JFrame {

		private JPanel contentPane;
		/**
		 * Launch the application.
		 */
		
			public void run() {
					try {
						Search2 apple = new Search2();
						apple.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

		/**
		 * Create the frame.
		 */
		public Two() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 525);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 69, 99, 53);
			contentPane.add(lblNewLabel);
			
			JLabel lblBirthDate = new JLabel("Birth Date");
			lblBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblBirthDate.setBounds(12, 132, 99, 53);
			contentPane.add(lblBirthDate);
			
			JLabel lblAgency = new JLabel("Agency");
			lblAgency.setHorizontalAlignment(SwingConstants.CENTER);
			lblAgency.setBounds(12, 195, 99, 53);
			contentPane.add(lblAgency);
			
			JLabel lblCareer = new JLabel("Career");
			lblCareer.setHorizontalAlignment(SwingConstants.CENTER);
			lblCareer.setBounds(12, 258, 99, 53);
			contentPane.add(lblCareer);
			
			JLabel lblPay = new JLabel("Pay");
			lblPay.setHorizontalAlignment(SwingConstants.CENTER);
			lblPay.setBounds(12, 333, 99, 53);
			contentPane.add(lblPay);
			
			JLabel lblPhonenumber = new JLabel("PhoneNumber");
			lblPhonenumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblPhonenumber.setBounds(12, 384, 99, 53);
			contentPane.add(lblPhonenumber);
			
			JPanel panel = new JPanel();
			panel.setBounds(396, 158, -94, -103);
			contentPane.add(panel);
			
			JLabel labelname = new JLabel("JeongHyun Park");
			labelname.setFont(new Font("굴림", Font.BOLD, 15));
			labelname.setBounds(123, 88, 239, 15);
			contentPane.add(labelname);
	
			JLabel labelage = new JLabel("76.03.23");
			labelage.setFont(new Font("굴림", Font.BOLD, 15));
			labelage.setBounds(123, 151, 239, 15);
			contentPane.add(labelage);
	
			JLabel labelcompany = new JLabel("T Entertainment");
			labelcompany.setFont(new Font("굴림", Font.BOLD, 15));
			labelcompany.setBounds(123, 214, 239, 15);
			contentPane.add(labelcompany);
	
			JLabel labelpay = new JLabel("5,000,000 won");
			labelpay.setFont(new Font("굴림", Font.BOLD, 15));
			labelpay.setBounds(123, 352, 239, 15);
			contentPane.add(labelpay);
	
			JLabel labelnumber = new JLabel("019-554-5555");
			labelnumber.setFont(new Font("굴림", Font.BOLD, 15));
			labelnumber.setBounds(123, 403, 239, 15);
			contentPane.add(labelnumber);
			
			JButton btnClose = new JButton("Close");
			btnClose.setFont(new Font("굴림", Font.BOLD, 12));
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			btnClose.setBounds(169, 442, 97, 23);
			contentPane.add(btnClose);
			
			JTextArea txtrMbcHonorgraduation = new JTextArea();
			txtrMbcHonorgraduation.setFont(new Font("Monospaced", Font.BOLD, 13));
			txtrMbcHonorgraduation.setText("2012 MBC <I'm a singer>\r\n\tHonor-graduation\r\n2002 Mnet MV Festival R&B \t\r\n\t- Grand Prize");
			txtrMbcHonorgraduation.setBounds(123, 251, 286, 91);
			contentPane.add(txtrMbcHonorgraduation);

		}
	}

-Three 클래스 : 박지선에 관한 정보를 담은 창.
	       각각의 정보에 대응하는 textField의 내용만 채워졌을 뿐, 
	       Search2의 창과 모형은 같다. 그러므로 주석을 생략하겠다.-
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

	public class Three extends JFrame {

		private JPanel contentPane;
		/**
		 * Launch the application.
		 */
		
			public void run() {
					try {
						Search2 apple = new Search2();
						apple.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

		/**
		 * Create the frame.
		 */
		public Three() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 525);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 69, 99, 53);
			contentPane.add(lblNewLabel);
			
			JLabel lblBirthDate = new JLabel("Birth Date");
			lblBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblBirthDate.setBounds(12, 132, 99, 53);
			contentPane.add(lblBirthDate);
			
			JLabel lblAgency = new JLabel("Agency");
			lblAgency.setHorizontalAlignment(SwingConstants.CENTER);
			lblAgency.setBounds(12, 195, 99, 53);
			contentPane.add(lblAgency);
			
			JLabel lblCareer = new JLabel("Career");
			lblCareer.setHorizontalAlignment(SwingConstants.CENTER);
			lblCareer.setBounds(12, 258, 99, 53);
			contentPane.add(lblCareer);
			
			JLabel lblPay = new JLabel("Pay");
			lblPay.setHorizontalAlignment(SwingConstants.CENTER);
			lblPay.setBounds(12, 332, 99, 53);
			contentPane.add(lblPay);
			
			JLabel lblPhonenumber = new JLabel("PhoneNumber");
			lblPhonenumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblPhonenumber.setBounds(12, 384, 99, 53);
			contentPane.add(lblPhonenumber);
			
			JPanel panel = new JPanel();
			panel.setBounds(396, 158, -94, -103);
			contentPane.add(panel);
			
			JLabel label_5 = new JLabel("");
			label_5.setBounds(169, 88, 57, 15);
			contentPane.add(label_5);
			
			JLabel labelname = new JLabel("JiSun Park");
			labelname.setFont(new Font("굴림", Font.BOLD, 15));
			labelname.setBounds(123, 88, 239, 15);
			contentPane.add(labelname);
	
			JLabel labelage = new JLabel("84.11.03");
			labelage.setFont(new Font("굴림", Font.BOLD, 15));
			labelage.setBounds(123, 151, 239, 15);
			contentPane.add(labelage);
	
			JLabel labelcompany = new JLabel("Coco Entertainment");
			labelcompany.setFont(new Font("굴림", Font.BOLD, 15));
			labelcompany.setBounds(123, 214, 239, 15);
			contentPane.add(labelcompany);
	
			JLabel labelpay = new JLabel("2,000,000 won");
			labelpay.setFont(new Font("굴림", Font.BOLD, 15));
			labelpay.setBounds(123, 351, 239, 15);
			contentPane.add(labelpay);
	
			JLabel labelnumber = new JLabel("02-456-7890");
			labelnumber.setFont(new Font("굴림", Font.BOLD, 15));
			labelnumber.setBounds(123, 403, 239, 15);
			contentPane.add(labelnumber);
			
			JButton btnClose = new JButton("Close");
			btnClose.setFont(new Font("굴림", Font.BOLD, 12));
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			btnClose.setBounds(169, 442, 97, 23);
			contentPane.add(btnClose);
			
			JTextArea txtrAppearance = new JTextArea();
			txtrAppearance.setFont(new Font("Monospaced", Font.BOLD, 13));
			txtrAppearance.setText("\r\n07~ <Gag Concert> appearance");
			txtrAppearance.setBounds(123, 258, 239, 64);
			contentPane.add(txtrAppearance);
	}
}
```**

소스코드 파일첨부 http://comp166-koreauniv.googlecode.com/files/CastingBook.zip

# Screenshot #

![http://comp166-koreauniv.googlecode.com/files/Screenshot1.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot1.jpg)

: 처음 실행화면에서 아이디와 비번을 잘못 치면 입력했던 내용이 초기화되면서 잘못되었다는 창이 뜬다.

![http://comp166-koreauniv.googlecode.com/files/Screenshot2.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot2.jpg)

: sn500gogo라는 아이디와 비번 1234를 치고 Log-In 버튼을 누르면, 다음의 검색창으로 연결된다.

![http://comp166-koreauniv.googlecode.com/files/Screenshot3.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot3.jpg)

![http://comp166-koreauniv.googlecode.com/files/Screenshot4.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot4.jpg)

: 정보가 저장되어있지 않은 연예인의 이름을 검색하면,

![http://comp166-koreauniv.googlecode.com/files/Screenshot5.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot5.jpg)

: 검색 내용이 초기화 되면서, 관련 정보가 없음을 알리는 창이 뜬다.


그러나 장동건, 박정현, 박지선의 이름을 치면 저장되어 있던 그들의 정보창이 뜬다.
![http://comp166-koreauniv.googlecode.com/files/Screenshot6.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot6.jpg)
: 장동건의 정보

![http://comp166-koreauniv.googlecode.com/files/Screenshot7.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot7.jpg)
: 박정현의 정보

![http://comp166-koreauniv.googlecode.com/files/Screenshot8.jpg](http://comp166-koreauniv.googlecode.com/files/Screenshot8.jpg)
: 박지선의 정보