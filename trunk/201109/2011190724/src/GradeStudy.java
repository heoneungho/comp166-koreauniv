import java.util.Scanner;

public class GradeStudy {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Menu menu1 = new Menu();
		int numb = 100, menu; // numb �� �л� �迭 ��
		boolean end = true;// end ���Ḧ ����
		int[][] arr = new int[numb][5];
		float[] avg = new float[numb]; // -------�迭 ����
		char[] grade = new char[numb]; // �� ������ ���¸��� �迭����
		String[] name = new String[numb + 2];
		int i = 0, j = 0, a = 0, b = 0, c = 0; // for ���� ���� ����
		// �޴�����
		do {
			menu1.menu();
			menu = in.nextInt(); // �޴��� �� ����
			switch (menu) { // ���� ���� ����ġ��
			case 1:
				System.out.print("�Է��� �л� �� : ");
				numb = in.nextInt();
				do { // ---------------------------�л�����ŭ �Է¹ޱ� ���� �ݺ�
					System.out.print("�̸� : ");
					name[i] = in.next();
					System.out.print("�й� : ");
					j = 0; // -------------�迭�� �ʱ�ȭ
					arr[i][j++] = in.nextInt(); // ---------------�迭�� ����
					System.out.print("���� : ");
					arr[i][j++] = in.nextInt(); // ----------����
					System.out.print("���� : ");
					arr[i][j++] = in.nextInt(); // ---------����
					System.out.print("���� : ");
					arr[i][j++] = in.nextInt(); // --------����
					i++; // -----------�л� ����
				} while (i < numb);
				// �л��� ��ŭ ����(����+����+����)�� ���� ����
				for (a = 0; a < numb; a++) {
					for (b = 1; b < 4; b++)
						arr[a][4] += arr[a][b]; // ����
				}// for end
					// ----------------------------------------------------//
				for (c = 0; c < numb; c++) { // ������ ��հ� ������ ó��
					avg[c] = arr[c][4] / 3.0f; // ���
					int temp = (int) avg[c];
					switch (temp / 10) {
					case 10:
					case 9:
						grade[c] = 'A';
						break;
					case 8:
						grade[c] = 'B';
						break;
					case 7:
						grade[c] = 'C';
						break;
					case 6:
						grade[c] = 'D';
						break;
					default:
						grade[c] = 'F';
						break;
					} // switch end
				} // for end
				break;
			// case1��
			case 2:
				// -------------��� �κ�---------------//
				System.out.println("---------------------------------");
				System.out.println("�̸� �й� ���� ���� ���� ���� ��� ����");
				System.out.println("---------------------------------");
				for (int k = 0; k < numb; k++) {
					System.out.print(name[k] + " "); // �̸�
					for (int p = 0; p < 5; p++) {
						System.out.print(arr[k][p] + " "); // �й�,����,����,����,����
					}// for end
					System.out.println(avg[k] + " " + grade[k]); // ���, ����
				}// for end
				break; // case 2 end
			case 3:
				System.out.println("����");
				end = false;
				break;
			default:
				System.out.println("�� �� �Է�");
				break;
			}
		} while (end);
	}
}