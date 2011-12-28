package pros;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import javax.swing.*;

public class PuzzleGame implements ActionListener, MouseListener, ImageObserver {

	JFrame frame;
	public PuzzleHelper ph = new PuzzleHelper();

	// ����� ����ϱ� ���� ���
	final int menu_size = 0;

	// �ҷ��� ���ڸ��� ��Ÿ���� ���
	final int empty = -1;

	// ����� ���̵��� �����ϴ� ���
	final int blk3 = 3;
	final int blk4 = 4;
	final int blk5 = 5;
	final int blk6 = 6;

	// ������ ����ð��� ���� ���
	String timerBuffer;
	int oldTime;
	boolean start;

	// �̹����� �ҷ����� ���� ���
	Image image;

	// �̹����� ����� ȭ�鿡 ��½�Ű�� ���� 2���� �迭, ������ �迭�� ��ġ�� ������ �ִ�
	int[][] Block;

	// ��µ� ��ũ���� ��� �׷��� �ϴ��� �����Ѵ�
	int[] Result;

	// ������ ���̵��� �����Ѵ�
	int status;

	// ���̵��� ���� ��µ� ���� ���Ѵ�
	int width;

	// �޴���
	JMenuBar mb;
	JMenu menuselect;
	JMenuItem new_game;
	JMenu difficulty;
	JMenuItem dan3;
	JMenuItem dan4;
	JMenuItem dan5;
	JMenuItem dan6;

	public void setUpGame() {

		// �޴��߰�
		frame = new JFrame();
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);

		mb = new JMenuBar();
		menuselect = new JMenu("Menu");
		new_game = new JMenuItem("Start new Game");
		difficulty = new JMenu("Choose Level");
		dan3 = new JMenuItem("3*3");
		dan4 = new JMenuItem("4*4");
		dan5 = new JMenuItem("5*5");
		dan6 = new JMenuItem("6*6");

		start = false;
		difficulty.add(dan3);
		difficulty.add(dan4);
		difficulty.add(dan5);
		difficulty.add(dan6);

		menuselect.add(new_game);
		menuselect.add(difficulty);

		mb.add(menuselect);

		frame.setJMenuBar(mb);

		// actionlistener�� �ܴ�
		new_game.addActionListener(this);
		dan3.addActionListener(this);
		dan4.addActionListener(this);
		dan5.addActionListener(this);
		dan6.addActionListener(this);

		image = new ImageIcon("picture.jpg").getImage();

		// ó�� ���̵��� 3*3
		status = blk3;
		width = 300 / status;

		Block = new int[36][4];
		Result = new int[36];

		// �迭�� ä���ش�
		startPlaying();

		frame.setSize(300, 300 + menu_size);
		frame.setVisible(true);

		frame.addMouseListener(this);
		frame.repaint();
	}// end of setUpGame

	public void startPlaying() {

		// �ð����� �ʱ�ȭ
		start = false;

		// ������ ��ϵ��� ��ġ�� �Ѱ��� ������ ���̵��� ���� �������鼭
		// ������ ����� ��ǥ�� �޾ƿ´�
		for (int i = 0; i < status * status; i++) {

			for (int j = 0; j < 4; j++) {
				if (j == 0)
					Block[i][j] = (i % status) * width;
				else if (j == 1)
					Block[i][j] = (i / status) * width;
				else if (j == 2)
					Block[i][j] = ((i % status) * width) + width;
				else
					Block[i][j] = (i / status) * width + width;
			}

		}

		// ����� ��� �ʱ�ȭ

		for (int k = 0; k < status * status; k++)
			Result[0] = empty;

		// �����ϰ� ����� ���´�
		ph.rand_board(status, Result);

		// ���� �Ѱ��� �ȼ��� ���
		while (ph.end_check(status, Result) == true)
			ph.rand_board(status, Result); // �ٽ� ���´�
	}// end of startPlaying

	class MyDrawPanel extends JPanel {

		public void paint(Graphics g) {

			// �޴��ٸ� ���
			frame.setJMenuBar(mb);

			super.paint(g);

			for (int i = 0; i < status * status; i++) {

				// ������ �н�
				if (Result[i] == empty)
					continue;

				// ��������� �����ġ�� �����Ͽ� �׸���
				drawbox(Block[Result[i]], Block[i], g);
			}
		} // end of paint

		// ��ǥ4������ �����ͼ� �׸��� ����Ѵ�. input�� �Է���ǥ, output�� �����ǥ
		public void drawbox(int[] input, int[] output, Graphics g) {

			g.drawImage(image, output[0], output[1] + menu_size, output[2],
					output[3] + menu_size,

					input[0], input[1], input[2], input[3], this);
		}// end of drawbox

	}// end of MDP

	// �޴�ó��
	public void actionPerformed(ActionEvent ae) {

		String name;
		name = ae.getActionCommand();

		// ���ΰ����� ������ ���
		if (name.equals("�� ����"))
			startPlaying();
		else if (name.equals("3*3")) // ���̵��� ���� ������� �Է�
			status = blk3;
		else if (name.equals("4*4"))
			status = blk4;
		else if (name.equals("5*5"))
			status = blk5;
		else if (name.equals("6*6"))
			status = blk6;
		else
			return;

		// ���� �����ϰ� ����� �ٽ� ���´�
		width = 300 / status;
		startPlaying();

		// �ٽ� �׸���
		frame.repaint();// frame add

	}

	// ���콺�� �������� �̺�Ʈó��
	public void mousePressed(MouseEvent e) {

		int hour, min, sec, secs;
		int x, y;

		boolean paint = false;

		x = e.getX();
		y = e.getY();

		// ���콺�� ������ ó���̸�
		if (start == false) {
			start = true;

			// �ð� ��� ����
			oldTime = (int) System.currentTimeMillis() / 1000;

		}

		// ��� ���ȴ��� Ȯ���Ѵ�
		for (int i = 0; i < status * status; i++) {
			if (ph.CheckPoint(Block[i], x, y)) {

				// �̵�üũ�� �̵�
				paint = ph.CheckMove(i, status, Result);
				break;
			}

		}

		// ������ �� ���� ����� Ŭ�� ���� ���� �ٽ� �׸��� �ʴ´�
		if (paint == true)
			frame.repaint();

		// ������ ������
		if (ph.end_check(status, Result)) {

			// �ð� ���
			secs = ((int) System.currentTimeMillis() / 1000) - oldTime;

			// �ð��� ȯ���Ѵ�
			sec = secs % 60;
			min = secs / 60 % 60;
			hour = secs / 3600;

			timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);

			// �ð��� ����ϰ� â�� ����
			JOptionPane.showMessageDialog(frame, "Clear Time : " + timerBuffer +

			"\nCongratulations!", "Clear",

			JOptionPane.INFORMATION_MESSAGE);//

			startPlaying();
			frame.repaint();
		}
	}

	// ���� �Լ�..
	public static void main(String args[]) {

		PuzzleGame pg = new PuzzleGame();
		pg.setUpGame();
		pg.startPlaying();

	}// end of main

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y,
			int width, int height) {
		return false;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}// end of PuzzleGame

