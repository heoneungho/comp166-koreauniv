import java.util.Date; //Date �Լ� ���� ���� import
import java.io.*;

//import java.util.ArrayList;

public class PCManager {
	public static void main(String[] args) {

		boolean bFalg = true;
		String str_Date = " "; // ���� ���� ���ڿ�
		String svcname = " ";
		int imenu = 0;
		Date d;
		int servicetotal = 0;
		int svcmn = 0;
		int siTotal = 0;
		String today = " ";

		DataInputStream dis = new DataInputStream(System.in); // ���ڿ� �Է� �ޱ� ����//

		/* ���� ���� �Է� */
		try {
			System.out.print("1.�������ڸ� �Է� �ϼ��� : ");
			str_Date = dis.readLine();

		} catch (Exception e) {
		}
		;

		/* ���� ��ǻ�� ��� �Է� */
		try {
			System.out.print("���� ��ǻ�� ����� �Է� �ϼ��� :  ");
			imenu = Integer.parseInt(dis.readLine());
		} catch (Exception e) {
		}

		PCinfo pc[] = new PCinfo[imenu];

		for (int id = 1; id < pc.length + 1; id++) {
			String str_CPU = " ";
			String str_Memory = " ";
			String str_HDD = " ";
			String str_GPCard = " ";

			System.out.println(id + "�� �¼�");
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
		/* do while�� (do�� ���� �ѹ� ����) */
		do {
			System.out.println("\n======================================\n");
			System.out.println("1.�¼�����");
			System.out.println("2.����");
			System.out.println("3.�߰� ����");
			System.out.println("4.��������");
			System.out.println("5.����");
			System.out.println("\n======================================\n");
			System.out.print("�޴��� ��ȣ�� �����ϼ���(1-5) : ");

			try {
				imenu = Integer.parseInt(dis.readLine());
			} catch (Exception e) {
				System.out.println("1-5������ ���ڷ� �Է��� �ּ���");
				continue;
			}

			switch (imenu) {
			/* �¼� ���� */
			case 1:
				try {
					System.out.println("[�¼� ����]");
					for (int id = 0; id < pc.length; id++) {
						System.out.print("PC " + (id + 1) + " �� : "
								+ pc[id].using());
						pc[id].printpc();
						System.out.println();
					}

					System.out.print(">> ���¼� �߿��� �����ϼ���. �¼���ȣ : ");
					imenu = Integer.parseInt(dis.readLine());
					System.out.print(imenu
							+ "�� �¼��� �����Ǿ����ϴ�. �׸��� ��ǻ�� ����� ���۵Ǿ����ϴ�.");
				} catch (Exception e) {
					continue;
				}
				d = new Date();
				pc[imenu - 1].start(d.getTime());
				pc[imenu - 1].use("�����");
				break;

			/* ���� */
			case 2:
				try {
					System.out.print(">> �¼� ��ȣ�� �Է��ϼ��� : ");
					imenu = Integer.parseInt(dis.readLine());
				} catch (Exception e) {
					continue;
				}

				servicetotal = pc[imenu - 1].servicenum();
				d = new Date();
				System.out.println("[����]");
				System.out.println(">> ��ǻ�� ��� �����  "
						+ pc[imenu - 1].stop(d.getTime()) + " �� �Դϴ�. (���ð� : "
						+ pc[imenu - 1].getTime() + "��)");
				System.out.println(">> �߰� ���� ����� "
						+ pc[imenu - 1].Servicetotal() + " �� �Դϴ�.");
				System.out.print("     �߰� ���� ������ ");
				pc[imenu - 1].use("���¼�");

				for (int i = 0; i < servicetotal; i++) // ����� ���� ���
				{
					System.out.print("[" + pc[imenu - 1].servicemenu(i) + "]");
				}
				System.out.println(" �Դϴ�.");
				System.out.println("�� ���ݾ���  " + pc[imenu - 1].siTotal()
						+ "�� �Դϴ�.");
				System.out.println("���� �¼���ȣ " + imenu + "���� �� �¼��Դϴ�.");
				break;

			/* ���� �߰� */
			case 3:
				try {
					System.out.print(">> �¼� ��ȣ�� �Է��ϼ��� : ");
					imenu = Integer.parseInt(dis.readLine());
					System.out.print(">> ������ �̸��� �Է��ϼ��� : ");
					svcname = new String(dis.readLine().getBytes("8859_1"),
							"KSC5601"); // ���� �̸��� �ѱ��ϼ��� �ֱ� ������//
					System.out.print(">> ������ �ݾ��� �Է��ϼ��� : ");
					svcmn = Integer.parseInt(dis.readLine());
				} catch (Exception e) {
					continue;
				}
				pc[imenu - 1].servicename(svcname);
				pc[imenu - 1].servicemoney(svcmn);
				break;

			/* ���� ���� */
			case 4:
				siTotal = 0;
				System.out.println("[�������� ]");
				Date t = new Date();
				for (int id = 0; id < pc.length; id++) {
					pc[id].stop(t.getTime());
					System.out.print("PC " + (id + 1) + " �� : "
							+ pc[id].getTotal() + "��");
					pc[id].svcprintTotal(t.getTime());
					System.out.println();
					siTotal = siTotal + pc[id].siTotal();
				}
				System.out.println(today + " ���� �Ѹ������  " + siTotal + "���Դϴ�.");
				break;

			/* 5 �Է½� boolean �� false�� while �� ���� */
			case 5:
				bFalg = false;
				break;
			default:
				break;
			}

		} while (bFalg);

	}

}