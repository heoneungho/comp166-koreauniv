import java.util.Date; //Date 함수 쓰기 위해 import
import java.io.*;

//import java.util.ArrayList;

public class PCManager {
	public static void main(String[] args) {

		boolean bFalg = true;
		String str_Date = " "; // 관리 일자 문자열
		String svcname = " ";
		int imenu = 0;
		Date d;
		int servicetotal = 0;
		int svcmn = 0;
		int siTotal = 0;
		String today = " ";

		DataInputStream dis = new DataInputStream(System.in); // 문자열 입력 받기 위해//

		/* 관리 일자 입력 */
		try {
			System.out.print("1.관리일자를 입력 하세요 : ");
			str_Date = dis.readLine();

		} catch (Exception e) {
		}
		;

		/* 보유 컴퓨터 대수 입력 */
		try {
			System.out.print("보유 컴퓨터 대수를 입력 하세요 :  ");
			imenu = Integer.parseInt(dis.readLine());
		} catch (Exception e) {
		}

		PCinfo pc[] = new PCinfo[imenu];

		for (int id = 1; id < pc.length + 1; id++) {
			String str_CPU = " ";
			String str_Memory = " ";
			String str_HDD = " ";
			String str_GPCard = " ";

			System.out.println(id + "번 좌석");
			try {
				System.out.print(">>CPU : ");
				str_CPU = dis.readLine();
				System.out.print(">>Memory : ");
				str_Memory = dis.readLine();
				System.out.print(">>HDD : ");
				str_HDD = dis.readLine();
				System.out.print(">>Graphic Card : ");
				str_GPCard = dis.readLine();
			} catch (Exception e) {
			}
			pc[id - 1] = new PCinfo();
			pc[id - 1].setPCinfo(id, str_CPU, str_Memory, str_HDD, str_GPCard);
		}
		/* do while문 (do문 먼저 한번 실행) */
		do {
			System.out.println("\n======================================\n");
			System.out.println("1.좌석배정");
			System.out.println("2.정산");
			System.out.println("3.추가 서비스");
			System.out.println("4.매출정보");
			System.out.println("5.종료");
			System.out.println("\n======================================\n");
			System.out.print("메뉴의 번호를 선택하세요(1-5) : ");

			try {
				imenu = Integer.parseInt(dis.readLine());
			} catch (Exception e) {
				System.out.println("1-5까지의 숫자로 입력해 주세요");
				continue;
			}

			switch (imenu) {
			/* 좌석 배정 */
			case 1:
				try {
					System.out.println("[좌석 배정]");
					for (int id = 0; id < pc.length; id++) {
						System.out.print("PC " + (id + 1) + " 번 : "
								+ pc[id].using());
						pc[id].printpc();
						System.out.println();
					}

					System.out.print(">> 빈좌석 중에서 배정하세요. 좌석번호 : ");
					imenu = Integer.parseInt(dis.readLine());
					System.out.print(imenu
							+ "번 좌석이 배정되었습니다. 그리고 컴퓨터 사용이 시작되었습니다.");
				} catch (Exception e) {
					continue;
				}
				d = new Date();
				pc[imenu - 1].start(d.getTime());
				pc[imenu - 1].use("사용중");
				break;

			/* 정산 */
			case 2:
				try {
					System.out.print(">> 좌석 번호를 입력하세요 : ");
					imenu = Integer.parseInt(dis.readLine());
				} catch (Exception e) {
					continue;
				}

				servicetotal = pc[imenu - 1].servicenum();
				d = new Date();
				System.out.println("[정산]");
				System.out.println(">> 컴퓨터 사용 요금은  "
						+ pc[imenu - 1].stop(d.getTime()) + " 원 입니다. (사용시간 : "
						+ pc[imenu - 1].getTime() + "분)");
				System.out.println(">> 추가 서비스 요금은 "
						+ pc[imenu - 1].Servicetotal() + " 원 입니다.");
				System.out.print("     추가 서비스 내역은 ");
				pc[imenu - 1].use("빈좌석");

				for (int i = 0; i < servicetotal; i++) // 서비시 내역 출력
				{
					System.out.print("[" + pc[imenu - 1].servicemenu(i) + "]");
				}
				System.out.println(" 입니다.");
				System.out.println("총 사용금액은  " + pc[imenu - 1].siTotal()
						+ "원 입니다.");
				System.out.println("이제 좌석번호 " + imenu + "번은 빈 좌석입니다.");
				break;

			/* 서비스 추가 */
			case 3:
				try {
					System.out.print(">> 좌석 번호를 입력하세요 : ");
					imenu = Integer.parseInt(dis.readLine());
					System.out.print(">> 서비스의 이름을 입력하세요 : ");
					svcname = new String(dis.readLine().getBytes("8859_1"),
							"KSC5601"); // 서비스 이름이 한글일수도 있기 때문에//
					System.out.print(">> 서비스의 금액을 입력하세요 : ");
					svcmn = Integer.parseInt(dis.readLine());
				} catch (Exception e) {
					continue;
				}
				pc[imenu - 1].servicename(svcname);
				pc[imenu - 1].servicemoney(svcmn);
				break;

			/* 매출 정보 */
			case 4:
				siTotal = 0;
				System.out.println("[매출정보 ]");
				Date t = new Date();
				for (int id = 0; id < pc.length; id++) {
					pc[id].stop(t.getTime());
					System.out.print("PC " + (id + 1) + " 번 : "
							+ pc[id].getTotal() + "원");
					pc[id].svcprintTotal(t.getTime());
					System.out.println();
					siTotal = siTotal + pc[id].siTotal();
				}
				System.out.println(today + " 현재 총매출액은  " + siTotal + "원입니다.");
				break;

			/* 5 입력시 boolean 이 false로 while 문 종료 */
			case 5:
				bFalg = false;
				break;
			default:
				break;
			}

		} while (bFalg);

	}

}