import java.awt.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

// GUI 메뉴 자체가 교재에 있는 내용으로 구현하기에 부족한 점이 많아 따로 동영상 강의와 주변 지인 중 컴퓨터 프로그램 쪽을 전문으로 다루는 분이 있어 많은 도움을 받았습니다.

public class Server extends JFrame implements ActionListener,
		InternalFrameListener {

	public static Font sans1 = new Font("Sansserif", Font.PLAIN, 12);
	public static Font sans2 = new Font("Sansserif", Font.PLAIN, 11);

	private JMenuBar mnbBar;
	private JMenu mnManage, mnAbout, mnExit;
	private JDesktopPane desktop;
	private JMenuItem it01, it02, it03, it04, it05;

	private boolean isOpenMenu_01 = false; // 고객관리 메뉴
	private boolean isOpenMenu_02 = false; // 계좌 관리 메뉴
	private boolean isOpenMenu_03 = false; // 거래 관리 메뉴

	Server() {
		setTitle("시작하는 화면! " + currentDate());
		makeFrame();
	}

	public String currentDate() {
		String Year, Month, Day;
		String[] week = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		String Str = "";
		// 현재 날짜 얻어오기
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = new java.util.Date();
		String dateStr = formatter.format(today);

		Year = dateStr.substring(0, 4); // 년
		Month = dateStr.substring(5, 7); // 월
		Day = dateStr.substring(8, 10); // 일

		if (Month.substring(0, 1).equals("0"))
			Month = Month.substring(1, 2);
		if (Day.substring(0, 1).equals("0"))
			Day = Day.substring(1, 2);

		String dayofweek = week[today.getDay()];

		Str = "오늘은 " + Year + "년 " + Month + "월 " + Day + "일 " + dayofweek
				+ " 입니다.";
		return Str;
	}

	public void makeFrame() {
		mnbBar = new JMenuBar();
		// 위쪽 메인 메뉴 작성
		mnManage = new JMenu(" 관리");
		mnAbout = new JMenu(" 정 보 ");
		mnExit = new JMenu(" 종 료 ");

		mnManage.setFont(sans1);
		mnAbout.setFont(sans1);
		mnExit.setFont(sans1);
		// 각 메뉴별 세뷰 메뉴 작성
		it01 = new JMenuItem("고객 관리");
		it02 = new JMenuItem("거래 관리");
		it03 = new JMenuItem("정보");
		it04 = new JMenuItem("종 료");

		// 메인 메뉴에세부 메뉴 아이템 추가
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

		// 메뉴바에 메뉴 추가
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
			String[] Data = { "ATM", "컴퓨터교육과 2010190723 류선규", "2011학년도 2학기" };
			String[] title = { "제  목", "학  번", "수강 학기" };
			PopupBox pop = new PopupBox();
			pop.setPopup("류선규", title, Data);
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
