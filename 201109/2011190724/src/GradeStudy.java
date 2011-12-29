import java.util.Scanner;

public class GradeStudy {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Menu menu1 = new Menu();
		int numb = 100, menu; // numb 는 학생 배열 수
		boolean end = true;// end 종료를 위한
		int[][] arr = new int[numb][5];
		float[] avg = new float[numb]; // -------배열 선언
		char[] grade = new char[numb]; // 각 변수의 형태마다 배열선언
		String[] name = new String[numb + 2];
		int i = 0, j = 0, a = 0, b = 0, c = 0; // for 문을 위한 변수
		// 메뉴시작
		do {
			menu1.menu();
			menu = in.nextInt(); // 메뉴의 값 받음
			switch (menu) { // 값에 따른 스위치문
			case 1:
				System.out.print("입력할 학생 수 : ");
				numb = in.nextInt();
				do { // ---------------------------학생수만큼 입력받기 위한 반복
					System.out.print("이름 : ");
					name[i] = in.next();
					System.out.print("학번 : ");
					j = 0; // -------------배열의 초기화
					arr[i][j++] = in.nextInt(); // ---------------배열의 증가
					System.out.print("수학 : ");
					arr[i][j++] = in.nextInt(); // ----------증가
					System.out.print("과학 : ");
					arr[i][j++] = in.nextInt(); // ---------증가
					System.out.print("영어 : ");
					arr[i][j++] = in.nextInt(); // --------증가
					i++; // -----------학생 증가
				} while (i < numb);
				// 학생수 만큼 총점(수학+과학+영어)을 각각 넣음
				for (a = 0; a < numb; a++) {
					for (b = 1; b < 4; b++)
						arr[a][4] += arr[a][b]; // 총점
				}// for end
					// ----------------------------------------------------//
				for (c = 0; c < numb; c++) { // 각자의 평균과 학점을 처리
					avg[c] = arr[c][4] / 3.0f; // 평균
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
			// case1끝
			case 2:
				// -------------출력 부분---------------//
				System.out.println("---------------------------------");
				System.out.println("이름 학번 수학 과학 영어 총점 평균 학점");
				System.out.println("---------------------------------");
				for (int k = 0; k < numb; k++) {
					System.out.print(name[k] + " "); // 이름
					for (int p = 0; p < 5; p++) {
						System.out.print(arr[k][p] + " "); // 학번,수학,과학,영어,총점
					}// for end
					System.out.println(avg[k] + " " + grade[k]); // 평균, 학점
				}// for end
				break; // case 2 end
			case 3:
				System.out.println("종료");
				end = false;
				break;
			default:
				System.out.println("잘 못 입력");
				break;
			}
		} while (end);
	}
}