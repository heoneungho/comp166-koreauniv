import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

public class hangman {
	final int t_max = 5;
	final int maxlen = 20;
	char d_word[] = new char[maxlen];
	int d_len;
	char m_word[] = new char[maxlen];
	int m_len;
	char t_word[] = new char[t_max];
	int t_count;
	public int pic;
	String t_str;

	String words[] = { "boolean", "byte", "enum", "class", "hashcode",
			"constuctor" };

	JFrame frame = new JFrame();
	JPanel panel1;
	JPanel panel2;

	Font font;

	final ImageIcon icon[] = new ImageIcon[6];

	public void game() {
		choose_d_word();
		ini();
		setpanel1_1();

		setpanel2();

		checkuserinput();
		return;
	}

	public void ini() {

		int i;

		for (i = 0; i < maxlen; i++) {
			m_word[i] = 0;
		}

		m_len = 0;

		for (i = 0; i < t_max; i++) {
			t_word[i] = 0;
		}

		t_count = 0;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 700);

		icon[0] = new ImageIcon("d:\\panel1_0.jpg");
		icon[1] = new ImageIcon("d:\\panel1_1.jpg");
		icon[2] = new ImageIcon("d:\\panel1_2.jpg");
		icon[3] = new ImageIcon("d:\\panel1_3.jpg");
		icon[4] = new ImageIcon("d:\\panel1_4.jpg");
		icon[5] = new ImageIcon("d:\\panel1_5.jpg");

	}

	public void choose_d_word() {

		int i;
		String d = new String();
		i = (int) (Math.random()) * (words.length);
		d = words[i];

		d_len = d.length();
		for (i = 0; i < d_len; i++) {
			d_word[i] = (char) d.charAt(i);
		}

		System.out.println(d);

	}

	public char getuserinput() {

		String c;
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner input = new Scanner(System.in);
		c = input.next();
		System.out.println(c.charAt(0));
		return c.charAt(0);
	}

	public void checkuserinput() {

		int i;
		char letter;
		boolean found;
		found = false;

		letter = getuserinput();

		while (letter < 'a' || letter > 'z') {

			System.out.println("���ڸ� �Է��Ͻÿ�!!!!!");
			letter = getuserinput();
		}

		// �̹� ���� ���ڿ� �ִ� ���
		if (!found) {
			for (i = 0; i < m_len; i++) {
				if (letter == m_word[i]) {
					System.out.println("�̸̹����");
					checkuserinput();
					return;
				}
			}
		}

		// �̹� Ʋ�� ���ڿ� �ִ� ���
		if (!found) {
			for (i = 0; i < t_count; i++) {
				if (t_word[i] == letter) {
					System.out.println("�̹� Ʋ�Ⱦ�");
					checkuserinput();
					return;

				}
			}
		}

		// ������
		if (!found) {
			for (i = 0; i < d_len; i++) {
				if (letter == d_word[i]) {
					found = true;
					m_word[i] = d_word[i];
					m_len++;
					System.out.println("�� ����µ�");
				}

			}
			for (i = 0; i < d_len; i++) {
				if (m_word[i] == 0)
					System.out.print(" _ ");
				else
					System.out.print(" " + m_word[i] + " ");
			}
			System.out.println("");

		}
		// ������ ���
		if (!found) {
			System.out.println("Ʋ�Ǵ��");
			t_word[t_count] = letter;
			t_count++;
			frame.repaint();
			System.out.println("Ʋ�� ���ڿ� : ");
			System.out.println(t_word);

			if (t_count < t_max) {
				checkuserinput();
				return;
			} else {
				endgame(found);
			}

		}

		if (found) {
			if (d_len == m_len) {
				endgame(found);
				return;
			}

			checkuserinput();
			return;

		}

	}

	public void endgame(boolean success) {

		if (success)
			System.out.println("�ʶȶ��ϴ�");
		else
			System.out.println("you mungchung");

	}

	public void setpanel1_1() {

		JPanel panel1_1 = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(icon[t_count].getImage(), 0, 0, 500, 500, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel1_1.setLayout(new BoxLayout(panel1_1, BoxLayout.Y_AXIS));
		panel1_1.setSize(500, 500);
		frame.getContentPane().add(BorderLayout.CENTER, panel1_1);
	}

	public void setpanel2() {
		JPanel panel2 = new JPanel();

		TextArea ta1 = new TextArea();
		font = new java.awt.Font("BOLD", 20, 20);
		ta1.setFont(font);

		ta1.setText("FATMAN START" + "\n" + "�ټ����� ������ ������ �˴ϴ�");
		panel2.add(ta1);

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.setBackground(Color.white);
		frame.getContentPane().add(BorderLayout.SOUTH, panel2);

		frame.setVisible(true);

	}

}
