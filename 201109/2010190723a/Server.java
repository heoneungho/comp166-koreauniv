import java.awt.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

// GUI �޴� ��ü�� ���翡 �ִ� �������� �����ϱ⿡ ������ ���� ���� ���� ������ ���ǿ� �ֺ� ���� �� ��ǻ�� ���α׷� ���� �������� �ٷ�� ���� �־� ���� ������ �޾ҽ��ϴ�.

public class Server extends JFrame implements ActionListener,
		InternalFrameListener {

	public static Font sans1 = new Font("Sansserif", Font.PLAIN, 12);
	public static Font sans2 = new Font("Sansserif", Font.PLAIN, 11);

	private JMenuBar mnbBar;
	private JMenu mnManage, mnAbout, mnExit;
	private JDesktopPane desktop;
	private JMenuItem it01, it02, it03, it04, it05;

	private boolean isOpenMenu_01 = false; // ������ �޴�
	private boolean isOpenMenu_02 = false; // ���� ���� �޴�
	private boolean isOpenMenu_03 = false; // �ŷ� ���� �޴�

	Server() {
		setTitle("�����ϴ� ȭ��! " + currentDate());
		makeFrame();
	}

	public String currentDate() {
		String Year, Month, Day;
		String[] week = { "�Ͽ���", "������", "ȭ����", "������", "�����", "�ݿ���", "�����" };
		String Str = "";
		// ���� ��¥ ������
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = new java.util.Date();
		String dateStr = formatter.format(today);

		Year = dateStr.substring(0, 4); // ��
		Month = dateStr.substring(5, 7); // ��
		Day = dateStr.substring(8, 10); // ��

		if (Month.substring(0, 1).equals("0"))
			Month = Month.substring(1, 2);
		if (Day.substring(0, 1).equals("0"))
			Day = Day.substring(1, 2);

		String dayofweek = week[today.getDay()];

		Str = "������ " + Year + "�� " + Month + "�� " + Day + "�� " + dayofweek
				+ " �Դϴ�.";
		return Str;
	}

	public void makeFrame() {
		mnbBar = new JMenuBar();
		// ���� ���� �޴� �ۼ�
		mnManage = new JMenu(" ����");
		mnAbout = new JMenu(" �� �� ");
		mnExit = new JMenu(" �� �� ");

		mnManage.setFont(sans1);
		mnAbout.setFont(sans1);
		mnExit.setFont(sans1);
		// �� �޴��� ���� �޴� �ۼ�
		it01 = new JMenuItem("�� ����");
		it02 = new JMenuItem("�ŷ� ����");
		it03 = new JMenuItem("����");
		it04 = new JMenuItem("�� ��");

		// ���� �޴������� �޴� ������ �߰�
		mnManage.add(it01);
		mnManage.add(it02);
		mnAbout.add(it03);
		mnExit.add(it04);

		it01.setFont(sans1);
		it02.setFont(sans1);
		it03.setFont(sans1);
		it04.setFont(sans1);

		it01.addActionListener(this);
		it02.addActionListener(this);
		it03.addActionListener(this);
		it04.addActionListener(this);

		// �޴��ٿ� �޴� �߰�
		mnbBar.add(mnManage);
		mnbBar.add(mnAbout);
		mnbBar.add(mnExit);

		setJMenuBar(mnbBar);

		desktop = new JDesktopPane();

		setContentPane(desktop);
		getContentPane().setBackground(new Color(128, 128, 128));
		desktop.putClientProperty("JDesktopPane.dragMode", "outline");

		Dimension dim = getToolkit().getScreenSize();
		setSize(700, 500);
		setSize(dim.width, dim.height);
		setSize(700, 500);
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		Object ob = ae.getSource();
		if (ob == it01) {

		} else if (ob == it02) {

		} else if (ob == it03) {
			String[] Data = { "ATM", "��ǻ�ͱ����� 2010190723 ������", "2011�г⵵ 2�б�" };
			String[] title = { "��  ��", "��  ��", "���� �б�" };
			PopupBox pop = new PopupBox();
			pop.setPopup("������", title, Data);
		} else if (ob == it04) {

			System.exit(0);
		}

	}

	public static void main(String args[]) {
		Server sv = new Server();

		sv.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

}
