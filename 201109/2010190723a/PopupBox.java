import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 클릭하였을씨 팝업창이 뜨도록 하는 클래스. 원래는 이 프로그램을 완성시키려 하였으므로 구체적으로 짜보았으나 DB 구현이 불가능하단 것을 알고 방향을 바꾸게 되어 최소한으로 필요한 것보다 많은 양을 포함하고 있게 되었습니다. 
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
