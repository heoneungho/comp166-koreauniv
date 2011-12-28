package javaTerm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BMI_Test extends JFrame implements ActionListener {
	double height, weight;
	TextField in_height, in_weight, reBMI, reWe;
	TextArea ta;
	Button enter, reset;
	String BMI_Result;

	BMI_Test() {
		setLayout(new GridLayout(2, 1, 5, 5));
		JPanel p1 = new JPanel();

		p1.setBackground(Color.pink);
		p1.setLayout(new BorderLayout());
		p1.add(new Label("Input heigh(kg)/weight(cm) and push RESULT button."),
				"North");

		JPanel p11 = new JPanel();
		p11.setBackground(Color.pink);
		p11.add(new Label("Height(cm): "));
		in_height = new TextField(5);
		p11.add(in_height);

		p11.add(new Label("Weight(kg): "));
		in_weight = new TextField(5);
		p11.add(in_weight);
		p1.add(p11, "Center");

		JPanel p12 = new JPanel();
		p12.setBackground(Color.pink);
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
		p2.add(new Label("----------- BMI RESULT ------------"), "North");
		JPanel p21 = new JPanel();
		p21.add(new Label("RATE(BMI):"));
		reBMI = new TextField(5);
		p21.add(reBMI);
		p21.add(new Label("NORMAL WEIGHT(kg):"));
		reWe = new TextField(5);
		p21.add(reWe);
		p21.add(new Label("Result of your state is?"));
		ta = new TextArea(3, 22);
		p21.add(ta);

		p2.add(p21, "Center");

		add(p2);
		in_height.requestFocus();

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();

		if (s == "RESULT") {

			height = Double.valueOf(in_height.getText()).doubleValue();

			double N_weight = (height - 100) * 0.9;

			height = height / 100;
			System.out.println(height);
			weight = Double.valueOf(in_weight.getText()).doubleValue();

			double BMI = Math.round(weight / (height * height));
			String re = BMI_Check(BMI);
			reBMI.setText("" + BMI);
			reWe.setText("" + N_weight);
			ta.setText(re);
		} else {
			in_height.setText("");
			in_weight.setText("");
		}
	}

	public String BMI_Check(double BMI) {
		if (BMI < 20)
			BMI_Result = "Under weight!!";
		else if (20 <= BMI && BMI < 25)
			BMI_Result = "You are absolutely normal!";
		else if (25 <= BMI && BMI < 30)
			BMI_Result = "You are overweight!!";
		else if (BMI <= 30)
			BMI_Result = "You are obese!!!!";
		return BMI_Result;
	}

	public static void main(String[] args) {
		BMI_Test bmi = new BMI_Test();
		bmi.show();
		bmi.setSize(400, 300);

		AbdomObe abdomObe = new AbdomObe();
		abdomObe.show();
		abdomObe.setSize(400, 300);

		Cure gui = new Cure();
		// gui.show();
		// gui.setSize(400,300);
		gui.go();
	}
}
