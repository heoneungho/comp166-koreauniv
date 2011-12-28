public class Account {

	private String accountNumber;
	private String name;
	private String password;
	private int balance;
	private static int totalBalance; // 클래스 변수

	// static 변수 초기화
	static {
		System.out.println("call static initialize block");
		totalBalance = 0; // Account.totalBalance=0;
	}

	public Account() {

	}

	// 매개변수 Constructor method
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

	// 입금하다. : deposit
	public void deposit(int amount) { // 입금액
		if (amount < 0) {
			System.out.println("입금액을 정확히 입력하세요");
			return;
		}
		balance += amount; // balance=balance+amount;
		totalBalance += amount;
		// totalBalance=totalBalance+amount ;
	}

	// 잔고를 조회하다. getBalance
	public int getBalance() {
		return balance;
	}

	// 출금하다. withdraw
	public void withdraw(int amount) {
		if (amount < 0) {
			System.out.println("금액을 정확히 입력하세요");
			return;
		}

		if (amount > balance) {
			System.out.println("잔고를 초과하셨습니다.");
			return;
		}

		balance -= amount; // balance=balance-amount;
		totalBalance -= amount;
		// totalBalance=totalBalance-amount ;
	}

	// 계좌의 모든 정보를 조회하다.( getAccountInfo )
	public String getAccountInfo() {
		return "AccountNumber=" + accountNumber + ", Name=" + name
				+ ", Password=" + password + ", Balance=" + balance;
	}

	/*
	 * public String toString() { return "AccountNumber="+accountNumber
	 * +", Name="+name +", Password="+password +", Balance="+balance; }
	 */

	// 비밀번호를 변경하다. (setPassword)
	public void setPassword(String password) {
		this.password = password;
	}

	// 계좌이체하다.
	public void transferAccount(Account account, int amount) {
		this.withdraw(amount);
		account.deposit(amount);
	}

	// 은행 총잔고를 구한다.
	public static int getTotalBalance() {
		return totalBalance; // Account.totalBalance;
	}

	// 계좌번호를 구한다.
	public String getAccountNumber() {
		return accountNumber;
	}

	// 예금주명을 조회하다.
	public String getName() {
		return name;
	}

	public void setName() {
		this.name = name;
	}

	// 비밀번호 조회
	public String getPassword() {
		return password;
	}
}