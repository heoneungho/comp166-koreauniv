public class PCinfo {
	private int iId; // pc��ȣ
	private String str_CPU; // CPU
	private String str_Memory; // �޸�
	private String str_HDD; // HDD
	private String str_GPCard; // Graphic Card
	private long lStart; // PC ����
	private long lStop; // PC ����
	private int iTotal;
	private int iPay;
	private String using;
	private int count;
	private String svcname[] = new String[50]; // �̸� ���ڿ� ũ��
	private int svcTotal;
	private int sTotal;
	private int siTotal;
	private int svcmoney[] = new int[50]; // ���� �߰���ǰ �� ������ ũ��

	public PCinfo() // pc���� �ʱ�ȭ
	{
		iId = 0;
		str_CPU = " ";
		str_Memory = " ";
		str_HDD = " ";
		str_GPCard = " ";
		lStart = 0;
		lStop = 0;
		iTotal = 0;
		iPay = 0;
		using = "���¼�";
		count = 0;
		svcTotal = 0;
		sTotal = 0;
		siTotal = 0;

	}

	/* pc ���� �Է� */
	public void setPCinfo(int id, String CPU, String Memory, String HDD,
			String GPCard) {
		iId = id;
		str_CPU = CPU;
		str_Memory = Memory;
		str_HDD = HDD;
		str_GPCard = GPCard;
	}

	/* ��������� ���¼����� ��� */
	public String using() {
		return using;
	}

	public void use(String used) {
		using = used;
	}

	/* ���� �ð� */
	public void start(long time) {
		lStart = time;
	}

	/* ���� �ð� */
	public int stop(long time) {
		lStop = time;
		iPay = (int) ((lStop - lStart) / 60000 * 20);
		iTotal = +iPay;
		return iPay;
	}

	/* pc���� ��� */
	public void printpc() {
		System.out.print("[CPU]" + str_CPU + " [Memory] " + str_Memory
				+ " [HDD] " + str_HDD + " [Graphic] " + str_GPCard);
	}

	public int getTime() {
		int time;
		return time = (int) (lStop - lStart) / 60000;
	}

	public int servicenum() {
		return count;
	}

	public int Servicetotal() {
		return sTotal;
	}

	/* ���� �߰� ���ڿ���svcname[]�迭�� ���� */
	public void servicename(String name) {
		svcname[count] = name;
	}

	public String servicemenu(int i) {
		return svcname[i];
	}

	/* �ð� �հ� */
	public int siTotal() {
		siTotal = sTotal + iTotal;
		return siTotal;
	}

	/* ���� �߰� �� �հ� */
	public void servicemoney(int money) {
		sTotal += money;
		svcmoney[count] = money;
		count++;
	}

	/* �߰��� ���� ���� ��� */
	public void svcprintTotal(long time) {
		lStop = time;
		int iPay = 0;
		if (count != 0) {
			iPay = (int) ((lStop - lStart) / 60000 * 20);
			iTotal = +iPay;
			System.out.print("(" + iTotal + "+");
		}
		for (int i = 0; i <= count - 1; i++) {
			if (i == count - 1) {
				System.out.print(svcmoney[i] + ")");
			} else {
				System.out.print(svcmoney[i] + " + ");
			}
		}
	}

	public int getTotal() {
		iTotal = (int) (lStop - lStart) / 60000 * 20;
		if (iTotal < 0) {
			iTotal = 0;
		}
		int money = iTotal + sTotal;
		return money;
	}

}
