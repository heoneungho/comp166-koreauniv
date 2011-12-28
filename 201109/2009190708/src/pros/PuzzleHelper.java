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
		// 눌린점이 블록내부에 있는지 검사한다
		if (input[0] <= x && input[1] <= y && x <= input[2] && y <= input[3])
			return true;
		else
			return false;
	}

	public boolean CheckMove(int input, int status, int[] Result) {
		// 블록이 맨윗쪽에 있지 않은 경우
		if (input / status != 0) {
			// 윗쪽의 블록이 비어 있는지 검사한다
			if (Result[input - status] == empty) {

				Result[input - status] = Result[input];

				Result[input] = empty;

				return true;
			}
		}

		// 블록이 맨오른쪽에 있지 않은 경우
		if (input % status != status - 1) {

			// 오른쪽의 블록이 비어 있는지 검사한다
			if (Result[input + 1] == empty) {
				Result[input + 1] = Result[input];
				Result[input] = empty;
				return true;
			}
		}

		// 블록이 맨아랫쪽에 있지 않은 경우
		if (input / status != status - 1) {
			// 아랫쪽의 블록이 비어 있는지 검사한다
			if (Result[input + status] == empty) {

				Result[input + status] = Result[input];

				Result[input] = empty;

				return true;
			}
		}

		// 블록이 맨왼쪽에 있지 않은 경우
		if (input % status != 0) {

			// 왼쪽의 블록이 비어 있는지 검사한다
			if (Result[input - 1] == empty) {

				Result[input - 1] = Result[input];

				Result[input] = empty;

				return true;

			}
		}
		return false;
	}

	// CheckMove설명 : 어떤 임의의 블록이 상하좌우가 다 막혀있는지를 검사하고 막혀있다면, 모든 if문을 들어갈수 없고
	// 따라서 실행이 될수 없다. 그러나, 그렇지 않다면, 사용자의 입력에 따라 행(+-status)열(+-1)로 움직인다

	public void rand_board(int status, int[] Result) {

		// 난수 발생
		Random r = new Random();

		int index, x, y;

		// 결과값 배열에 값을 랜덤하게 채워넣는다
		for (x = 0; x < (status * status) - 1; x++) {
			index = r.nextInt((status * status) - 1);// (status*status)-1범위 내에서
														// 난수 발생

			for (y = 0; y < x; y++)
				if (index == Result[y]) // 똑같은 난수가 발생하지 않게 하기 위하여
					break;
			if (y == x)
				Result[x] = index;
			else
				x--;
		}

		// 마지막 블록은 빈블록이므로 empty로 채운다
		Result[x] = empty;

	}// end of rand_board

	public boolean end_check(int status, int[] Result) {

		// 모든 블록이 제자리에 와있는지 확인한다
		for (int i = 0; i < (status * status) - 1; i++) {
			if (Result[i] != i) // 한개라도 틀리면 false리턴
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