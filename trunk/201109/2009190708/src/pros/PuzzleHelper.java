package pros;

import pros.PuzzleGame;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import javax.swing.*;

public class PuzzleHelper implements ActionListener, MouseListener,
		ImageObserver {

	int empty = -1;

	public boolean CheckPoint(int[] input, int x, int y) {
		// �������� ��ϳ��ο� �ִ��� �˻��Ѵ�
		if (input[0] <= x && input[1] <= y && x <= input[2] && y <= input[3])
			return true;
		else
			return false;
	}

	public boolean CheckMove(int input, int status, int[] Result) {
		// ����� �����ʿ� ���� ���� ���
		if (input / status != 0) {
			// ������ ����� ��� �ִ��� �˻��Ѵ�
			if (Result[input - status] == empty) {

				Result[input - status] = Result[input];

				Result[input] = empty;

				return true;
			}
		}

		// ����� �ǿ����ʿ� ���� ���� ���
		if (input % status != status - 1) {

			// �������� ����� ��� �ִ��� �˻��Ѵ�
			if (Result[input + 1] == empty) {
				Result[input + 1] = Result[input];
				Result[input] = empty;
				return true;
			}
		}

		// ����� �ǾƷ��ʿ� ���� ���� ���
		if (input / status != status - 1) {
			// �Ʒ����� ����� ��� �ִ��� �˻��Ѵ�
			if (Result[input + status] == empty) {

				Result[input + status] = Result[input];

				Result[input] = empty;

				return true;
			}
		}

		// ����� �ǿ��ʿ� ���� ���� ���
		if (input % status != 0) {

			// ������ ����� ��� �ִ��� �˻��Ѵ�
			if (Result[input - 1] == empty) {

				Result[input - 1] = Result[input];

				Result[input] = empty;

				return true;

			}
		}
		return false;
	}

	// CheckMove���� : � ������ ����� �����¿찡 �� �����ִ����� �˻��ϰ� �����ִٸ�, ��� if���� ���� ����
	// ���� ������ �ɼ� ����. �׷���, �׷��� �ʴٸ�, ������� �Է¿� ���� ��(+-status)��(+-1)�� �����δ�

	public void rand_board(int status, int[] Result) {

		// ���� �߻�
		Random r = new Random();

		int index, x, y;

		// ����� �迭�� ���� �����ϰ� ä���ִ´�
		for (x = 0; x < (status * status) - 1; x++) {
			index = r.nextInt((status * status) - 1);// (status*status)-1���� ������
														// ���� �߻�

			for (y = 0; y < x; y++)
				if (index == Result[y]) // �Ȱ��� ������ �߻����� �ʰ� �ϱ� ���Ͽ�
					break;
			if (y == x)
				Result[x] = index;
			else
				x--;
		}

		// ������ ����� �����̹Ƿ� empty�� ä���
		Result[x] = empty;

	}// end of rand_board

	public boolean end_check(int status, int[] Result) {

		// ��� ����� ���ڸ��� ���ִ��� Ȯ���Ѵ�
		for (int i = 0; i < (status * status) - 1; i++) {
			if (Result[i] != i) // �Ѱ��� Ʋ���� false����
				return false;
		}
		return true;

	}// end of end_check

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y,
			int width, int height) {
		return false;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
	}

}// end of PuzzleHelper