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

	// ���°����ϴ�.
	public static void createAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("���¹�ȣ : ");
		String accountNumber = scan.nextLine();
		System.out.print("�����ָ� : ");
		String name = scan.nextLine();
		System.out.print("��й�ȣ : ");
		String password = scan.nextLine();
		System.out.print("�ܰ� :  ");
		int balance = scan.nextInt();

		accounts[index] = new Account(accountNumber, name, password, balance);
		index++;
	}

	// �Ա��ϴ�.

	public static void inputAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("���¹�ȣ : ");
		String accountNumber = scan.nextLine();

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s ���¹�ȣ�� �������� �ʰų�, �߸��Է��ϼ̽��ϴ�.", accountNumber);
			return;
		}

		System.out.print("�����ָ� : ");
		String name = scan.nextLine();

		Account checkName = checkName(name);
		if (checkName == null) {
			System.out.printf("%s ���� ���°� �������� �ʰų�, �߸��Է��ϼ̽��ϴ�.", name);
			return;
		}

		System.out.print("�Աݾ� :  ");
		int amount = scan.nextInt();
		account.deposit(amount);
		System.out.printf("%s�� �Աݾ�=%d%n", name, amount);
		// System.out.printf("%s�� �����ܰ�=%d%n",name, );

	}

	// ����ϴ�

	public static void outputAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("���¹�ȣ : ");
		String accountNumber = scan.nextLine();

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s ���¹�ȣ�� �������� �ʰų�, �߸��Է��ϼ̽��ϴ�.", accountNumber);
			return;
		}

		System.out.print("�����ָ� : ");
		String name = scan.nextLine();

		Account checkName = checkName(name);
		if (checkName == null) {
			System.out.printf("%s ���� ���°� �������� �ʰų�, �߸��Է��ϼ̽��ϴ�.", name);
			return;
		}

		System.out.print("��й�ȣ : ");
		String password = scan.nextLine();

		String temp = account.getPassword();
		if (password.equals(temp)) {
			int balance = account.getBalance();
			System.out.printf("Balance=%d%n", balance);
		} else {
			System.out.printf("%s ��й�ȣ�� �߸��Ǿ����ϴ�.", password);
		}

		System.out.print("��ݾ� :  ");
		int amount = scan.nextInt();
		account.withdraw(amount);
		System.out.printf("%s�� ��ݾ�=%d%n", name, amount);
	}

	// �ܾ� ��ȸ�ϴ�.
	public static void retrieveBalance() {
		Scanner scan = new Scanner(System.in);

		System.out.print("���¹�ȣ : ");
		String accountNumber = scan.nextLine(); // 2

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s ���¹�ȣ�� �������� �ʽ��ϴ�.", accountNumber);
			return;
		}
		System.out.print("��й�ȣ : ");
		String password = scan.nextLine();

		String temp = account.getPassword();
		if (password.equals(temp)) {
			int balance = account.getBalance();
			System.out.printf("Balance=%d%n", balance);
		} else {
			System.out.printf("%s ��й�ȣ�� �߸��Ǿ����ϴ�.", password);
		}
	}

	// ������ü�ϴ�.

	public static void tranceAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.print("���¹�ȣ : ");
		String accountNumber = scan.nextLine();

		Account account = checkAccountNumber(accountNumber);
		if (account == null) {
			System.out.printf("%s ���¹�ȣ�� �������� �ʰų�, �߸��Է��ϼ̽��ϴ�.", accountNumber);
			return;
		}

		System.out.print("�����ָ� : ");
		String name = scan.nextLine();

		Account checkName = checkName(name);
		if (checkName == null) {
			System.out.printf("%s ���� ���°� �������� �ʰų�, �߸��Է��ϼ̽��ϴ�.", name);
			return;
		}

		System.out.print("��й�ȣ : ");
		String password = scan.nextLine();

		String temp = account.getPassword();
		if (password.equals(temp)) {
			int balance = account.getBalance();
			System.out.printf("Balance=%d%n", balance);
		} else {
			System.out.printf("%s ��й�ȣ�� �߸��Ǿ����ϴ�.", password);
		}

		System.out.print("��ü���� :  ");
		String tNum = scan.nextLine();

		Account accounts = checkAccountNumber(tNum);
		if (accounts == null) {
			System.out.printf("%s ���¹�ȣ�� �������� �ʰų�, �߸��Է��ϼ̽��ϴ�.", tNum);
			return;
		}

		System.out.print("��ü�� :  ");
		int amount = scan.nextInt();

		account.transferAccount(accounts, amount);
		System.out.printf("%s�� ��ݾ�=%d%n", name, amount);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean isExit = false;
		do {
			System.out.println("===== ���� ����� ���� �ý��� =====");
			System.out.println("1. ���°���");
			System.out.println("2. �Ա� ");
			System.out.println("3. ���");
			System.out.println("4. �ܾ���ȸ");
			System.out.println("5. ������ü");
			System.out.println("6. ����");
			System.out.print("�޴��� �����ϼ��� ");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				// ���°���
				createAccount();
				break;
			case 2:
				// �Ա�
				inputAccount();
				break;
			case 3:
				// ���
				outputAccount();
				break;
			case 4:
				// �ܾ���ȸ
				retrieveBalance();
				break;
			case 5:
				// ������ü
				tranceAccount();
				break;
			case 6:
				// ����
				isExit = true;
				break;
			}
		} while (!isExit);
	}

}