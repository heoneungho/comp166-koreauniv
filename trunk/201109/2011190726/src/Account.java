public class Account {

	private String accountNumber;
	private String name;
	private String password;
	private int balance;
	private static int totalBalance; // Ŭ���� ����

	// static ���� �ʱ�ȭ
	static {
		System.out.println("call static initialize block");
		totalBalance = 0; // Account.totalBalance=0;
	}

	public Account() {

	}

	// �Ű����� Constructor method
	public Account(String accountNumber, String name, String password,
			int balance) {
		System.out.println("call Constructor!!");
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
		totalBalance += balance;
		// totalBalance=totalBalance+balance;
	}

	// �Ա��ϴ�. : deposit
	public void deposit(int amount) { // �Աݾ�
		if (amount < 0) {
			System.out.println("�Աݾ��� ��Ȯ�� �Է��ϼ���");
			return;
		}
		balance += amount; // balance=balance+amount;
		totalBalance += amount;
		// totalBalance=totalBalance+amount ;
	}

	// �ܰ� ��ȸ�ϴ�. getBalance
	public int getBalance() {
		return balance;
	}

	// ����ϴ�. withdraw
	public void withdraw(int amount) {
		if (amount < 0) {
			System.out.println("�ݾ��� ��Ȯ�� �Է��ϼ���");
			return;
		}

		if (amount > balance) {
			System.out.println("�ܰ� �ʰ��ϼ̽��ϴ�.");
			return;
		}

		balance -= amount; // balance=balance-amount;
		totalBalance -= amount;
		// totalBalance=totalBalance-amount ;
	}

	// ������ ��� ������ ��ȸ�ϴ�.( getAccountInfo )
	public String getAccountInfo() {
		return "AccountNumber=" + accountNumber + ", Name=" + name
				+ ", Password=" + password + ", Balance=" + balance;
	}

	/*
	 * public String toString() { return "AccountNumber="+accountNumber
	 * +", Name="+name +", Password="+password +", Balance="+balance; }
	 */

	// ��й�ȣ�� �����ϴ�. (setPassword)
	public void setPassword(String password) {
		this.password = password;
	}

	// ������ü�ϴ�.
	public void transferAccount(Account account, int amount) {
		this.withdraw(amount);
		account.deposit(amount);
	}

	// ���� ���ܰ� ���Ѵ�.
	public static int getTotalBalance() {
		return totalBalance; // Account.totalBalance;
	}

	// ���¹�ȣ�� ���Ѵ�.
	public String getAccountNumber() {
		return accountNumber;
	}

	// �����ָ��� ��ȸ�ϴ�.
	public String getName() {
		return name;
	}

	public void setName() {
		this.name = name;
	}

	// ��й�ȣ ��ȸ
	public String getPassword() {
		return password;
	}
}