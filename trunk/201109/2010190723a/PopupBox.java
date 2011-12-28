import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Ŭ���Ͽ����� �˾�â�� �ߵ��� �ϴ� Ŭ����. ������ �� ���α׷��� �ϼ���Ű�� �Ͽ����Ƿ� ��ü������ ¥�������� DB ������ �Ұ����ϴ� ���� �˰� ������ �ٲٰ� �Ǿ� �ּ������� �ʿ��� �ͺ��� ���� ���� �����ϰ� �ְ� �Ǿ����ϴ�. 
public class PopupBox {
	private Label[] lblStr;
	private Box b;
	private int len;

	PopupBox() {
	}

	public void setPopup(String WindowTitle, String[] title, String[] Data) {
		b = Box.createVerticalBox();
		len = Data.length;
		lblStr = new Label[len];

		for (int i = 0; i < len; i++) {
			lblStr[i] = new Label("");
			lblStr[i].setText(title[i] + " : " + Data[i]);
			b.add(lblStr[i]);
		}
		JOptionPane.showMessageDialog(null, b, WindowTitle,
				JOptionPane.INFORMATION_MESSAGE);
	}
}
