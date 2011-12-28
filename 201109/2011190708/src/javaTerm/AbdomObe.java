package javaTerm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AbdomObe extends JFrame implements ActionListener {

	double hip, waist;
	TextField in_hip, in_waist, reRate, reWe;
	TextArea ta;
	JButton enter, reset, cure;
	String AO_Result;

	AbdomObe() {
		setLayout(new GridLayout(2, 1, 5, 5));

		JPanel p1 = new JPanel();
		p1.setBackground(Color.yellow);
		p1.setLayout(new BorderLayout());
		p1.add(new Label("Input waist/hip(cm) and push RESULT button!"),
				"North");

		JPanel p11 = new JPanel();
		p11.setBackground(Color.yellow);
		p11.add(new Label("waist(cm): "));
		in_waist = new TextField(5);
		p11.add(in_waist);

		Label l = new Label("hip(cm): ");
		p11.add(l);
		in_hip = new TextField(5);
		p11.add(in_hip);
		p1.add(p11, "Center");
		JPanel p12 = new JPanel();
		p12.setBackground(Color.yellow);
		JButton enter = new JButton("RESULT");
		JButton reset = new JButton("AGAIN");

		enter.addActionListener(this);
		reset.addActionListener(this);

		p12.add(enter);
		p12.add(reset);

		p1.add(p12, "South");
		add(p1);

		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(new Label("----------- Abdomen Obesity ------------"), "North");
		JPanel p21 = new JPanel();
		p21.add(new Label("Rate of Ab.Obesity:"));
		reRate = new TextField(5);
		p21.add(reRate);
		p21.add(new Label("The higher the rate the more dangerous you are."));
		p21.add(new Label("ResulT of you state is?"));
		TextArea ta = new TextArea(3, 23);
		p21.add(ta);
		p2.add(p21, "Center");

		add(p2);
		in_waist.requestFocus();

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();

		if (s == "RESULT") {

			waist = Double.valueOf(in_waist.getText()).doubleValue();
			hip = Double.valueOf(in_hip.getText()).doubleValue();

			double Rate = (hip) / (waist);
			String re = Abdomen_Check(Rate);

			reRate.setText("" + Rate);
			ta.setText(re);
		} else {
			in_waist.setText("");
			in_hip.setText("");
		}
	}

	public String Abdomen_Check(double Rate) {
		if (Rate < 0.7)
			AO_Result = "Very Safe!!";
		else if (0.7 <= Rate && Rate < 0.8)
			AO_Result = "Normal.But little bit dangerous!";
		else if (0.8 <= Rate && Rate < 0.9)
			AO_Result = "You are obese!!";
		else if (Rate >= 0.9)
			AO_Result = "Very dangerous!!!!";
		return AO_Result;
	}

}
