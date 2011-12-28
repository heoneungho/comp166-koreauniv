package javaTerm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Cure extends JFrame implements ActionListener {

	JTextArea text;

	public void go() {

		JFrame frame = new JFrame();
		// setLayout(new GridLayout(2,1,5,5));
		JPanel p1 = new JPanel();
		p1.setBackground(Color.orange);

		JButton b1 = new JButton("PRESCRIPTION");
		JButton b2 = new JButton("EXPLANATION OF BMI");

		b1.addActionListener(this);
		b2.addActionListener(this);

		p1.add(b1);
		p1.add(b2);

		// add(p1);

		JPanel p2 = new JPanel();
		p2.add(new Label("THERE ARE CONTENTS!"), "North");
		text = new JTextArea(10, 20);
		text.setLineWrap(true);

		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		p2.add(scroller);

		frame.getContentPane().add(BorderLayout.NORTH, p1);
		frame.getContentPane().add(BorderLayout.CENTER, p2);

		frame.setSize(400, 500);
		frame.setVisible(true);
		// add(p2);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();

		if (s == "PRESCRIPTION") {
			text.append("1)Drink a lot of warm water.\n 2)Stretch your body regularly.\n 3)Stimulate your feet!\n 4)Breath through abodomen. \n5)Eat more veges than meat.\n\n\n");

		} else {
			text.append("BMI means body mass index.\n Through BMI test you can \n know your body mass exactly.\n This rate can be the index of obesity.\n\n");

		}
	}
}