import java.util.Scanner;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.image.*;

public class Fatman extends java.applet.Applet {
	final int t_max = 7;
	final int maxlen = 20;
	char d_word[] = new char[maxlen];
	int d_len;
	char m_word[] = new char[maxlen];
	int m_len;
	char t_word[] = new char[t_max];
	int t_count;

	MediaTracker tracker;
	Image ima[];

	String words[] = { "boolean", "byte", "enum", "class", "hashcode",
			"constuctor" };

	public void game() {
		choose_d_word();
		ini();
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

		ima = new Image[t_max];

		for (i = 0; i < t_max; i++) {
			Image im = getImage(getDocumentBase(), "panel1_" + i + ".jpg");
			tracker.addImage(im, 0);
			ima[i] = im;

		}
	}

	public void paint(Graphics g) {
		int width = 500;
		int height = 700;

		Font font;
		font = new java.awt.Font("Godic", Font.ITALIC, 20);

		int i;
		int x = 20;

		g.setFont(font);
		g.setColor(Color.pink);

		for (i = 0; i < t_max; i++) {
			g.drawChars(t_word, i, 1, x, 20);
			x = x + 7;
		}

		if (d_len > 0) {

			g.setColor(Color.darkGray);
			x = 30;
			for (i = 0; i < d_len; i++) {
				if (d_word[i] != 0)
					g.drawChars(m_word, i, 1, x, 50);
				x = x + 7;
			}

		}

		if (m_len < d_len && t_count > 0) {

			g.drawImage(ima[t_count], 500, 500, this);
		}

	}

	public void updata(Graphics g) {
		paint(g);

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
		System.out.println("문자를 입력하세요");
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

			System.out.println("문자를 입력하시오!!!!!");
			letter = getuserinput();
		}

		// 이미 맞춘 문자에 있는 경우
		if (!found) {
			for (i = 0; i < m_len; i++) {
				if (letter == m_word[i]) {
					System.out.println("이미맞췄어");
					checkuserinput();
					return;
				}
			}
		}

		// 이미 틀린 문자에 있는 경우
		if (!found) {
			for (i = 0; i < t_count; i++) {
				if (t_word[i] == letter) {
					System.out.println("이미 틀렸어");
					checkuserinput();
					return;

				}
			}
		}

		// 맞춘경우
		if (!found) {
			for (i = 0; i < d_len; i++) {
				if (letter == d_word[i]) {
					found = true;
					m_word[i] = d_word[i];
					m_len++;
					System.out.println("오 맞췄는데");
				}
			}

		}
		// 못맞춘 경우
		if (!found) {
			System.out.println("틀렷대요");
			t_word[t_count] = letter;
			t_count++;
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
			System.out.println("너똑똑하다");
		else
			System.out.println("you mungchung");

		System.out.println("더 할래?");

	}

}
