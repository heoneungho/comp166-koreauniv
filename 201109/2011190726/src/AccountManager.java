import java.util.*;

public class AccountManager {
	static Account[] accounts = new Account[100];
	static int index = 0;

	public static Account checkAccountNumber(String accountNumber) {
		for (int i = 0; i < index; i++) {
			String temp = accounts[i].getAccountNumber();
			if (temp.equals(accountNumber)) {
				Account account = accounts[i];
				return account;
			}
		}
		return null;
	}

	public static Account checkName(String name) {
		for (int j = 0; j < index; j++) {
			String temp2 = accounts[j].getName();
			if (temp2.equals(name)) {
				Account account = accounts[j];
				return account;
			}
		}
		return null;
	}

	// 계좌개설하다.
	public static void createAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accountNumber = scan.nextLine();
		System.out.print("예금주명 : ");
		String name = scan.nextLine();
		System.out.print("비밀번호 : ");
		String password = scan.nextLine();
		System.out.print("잔고 :  ");
		int balance = scan.nextInt();

		accounts[index] = new Account(accountNumber, name, password, balance);
		index++;
	}

	// 입금하다.

	public static void inputAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accountNumber = scan.nextLine();

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.", accountNumber);
			return;
		}

		System.out.print("예금주명 : ");
		String name = scan.nextLine();

		Account checkName = checkName(name);
		if (checkName == null) {
			System.out.printf("%s 님의 계좌가 존재하지 않거나, 잘못입력하셨습니다.", name);
			return;
		}

		System.out.print("입금액 :  ");
		int amount = scan.nextInt();
		account.deposit(amount);
		System.out.printf("%s님 입금액=%d%n", name, amount);
		// System.out.printf("%s님 계좌잔고=%d%n",name, );

	}

	// 출금하다

	public static void outputAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accountNumber = scan.nextLine();

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.", accountNumber);
			return;
		}

		System.out.print("예금주명 : ");
		String name = scan.nextLine();

		Account checkName = checkName(name);
		if (checkName == null) {
			System.out.printf("%s 님의 계좌가 존재하지 않거나, 잘못입력하셨습니다.", name);
			return;
		}

		System.out.print("비밀번호 : ");
		String password = scan.nextLine();

		String temp = account.getPassword();
		if (password.equals(temp)) {
			int balance = account.getBalance();
			System.out.printf("Balance=%d%n", balance);
		} else {
			System.out.printf("%s 비밀번호가 잘못되었습니다.", password);
		}

		System.out.print("출금액 :  ");
		int amount = scan.nextInt();
		account.withdraw(amount);
		System.out.printf("%s님 출금액=%d%n", name, amount);
	}

	// 잔액 조회하다.
	public static void retrieveBalance() {
		Scanner scan = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accountNumber = scan.nextLine(); // 2

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s 계좌번호가 존재하지 않습니다.", accountNumber);
			return;
		}
		System.out.print("비밀번호 : ");
		String password = scan.nextLine();

		String temp = account.getPassword();
		if (password.equals(temp)) {
			int balance = account.getBalance();
			System.out.printf("Balance=%d%n", balance);
		} else {
			System.out.printf("%s 비밀번호가 잘못되었습니다.", password);
		}
	}

	// 계좌이체하다.

	public static void tranceAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accountNumber = scan.nextLine();

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.", accountNumber);
			return;
		}

		System.out.print("예금주명 : ");
		String name = scan.nextLine();

		Account checkName = checkName(name);
		if (checkName == null) {
			System.out.printf("%s 님의 계좌가 존재하지 않거나, 잘못입력하셨습니다.", name);
			return;
		}

		System.out.print("비밀번호 : ");
		String password = scan.nextLine();

		String temp = account.getPassword();
		if (password.equals(temp)) {
			int balance = account.getBalance();
			System.out.printf("Balance=%d%n", balance);
		} else {
			System.out.printf("%s 비밀번호가 잘못되었습니다.", password);
		}

		System.out.print("이체계좌 :  ");
		String tNum = scan.nextLine();

		Account accounts = checkAccountNumber(tNum);
		if (accounts == null) {
			System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.", tNum);
			return;
		}

		System.out.print("이체액 :  ");
		int amount = scan.nextInt();

		account.transferAccount(accounts, amount);
		System.out.printf("%s님 출금액=%d%n", name, amount);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean isExit = false;
		do {
			System.out.println("===== 은행 입출금 관리 시스템 =====");
			System.out.println("1. 계좌개설");
			System.out.println("2. 입금 ");
			System.out.println("3. 출금");
			System.out.println("4. 잔액조회");
			System.out.println("5. 계좌이체");
			System.out.println("6. 종료");
			System.out.print("메뉴를 선택하세요 ");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				// 계좌개설
				createAccount();
				break;
			case 2:
				// 입금
				inputAccount();
				break;
			case 3:
				// 출금
				outputAccount();
				break;
			case 4:
				// 잔액조회
				retrieveBalance();
				break;
			case 5:
				// 계좌이체
				tranceAccount();
				break;
			case 6:
				// 종료
				isExit = true;
				break;
			}
		} while (!isExit);
	}

}