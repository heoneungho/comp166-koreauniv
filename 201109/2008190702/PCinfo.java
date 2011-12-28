public class PCinfo {
	private int iId; // pc번호
	private String str_CPU; // CPU
	private String str_Memory; // 메모리
	private String str_HDD; // HDD
	private String str_GPCard; // Graphic Card
	private long lStart; // PC 시작
	private long lStop; // PC 종료
	private int iTotal;
	private int iPay;
	private String using;
	private int count;
	private String svcname[] = new String[50]; // 이름 문자열 크기
	private int svcTotal;
	private int sTotal;
	private int siTotal;
	private int svcmoney[] = new int[50]; // 서비스 추가물품 값 정수형 크기

	public PCinfo() // pc정보 초기화
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
		using = "빈좌석";
		count = 0;
		svcTotal = 0;
		sTotal = 0;
		siTotal = 0;

	}

	/* pc 정보 입력 */
	public void setPCinfo(int id, String CPU, String Memory, String HDD,
			String GPCard) {
		iId = id;
		str_CPU = CPU;
		str_Memory = Memory;
		str_HDD = HDD;
		str_GPCard = GPCard;
	}

	/* 사용중인지 빈좌석인지 출력 */
	public String using() {
		return using;
	}

	public void use(String used) {
		using = used;
	}

	/* 시작 시간 */
	public void start(long time) {
		lStart = time;
	}

	/* 종료 시간 */
	public int stop(long time) {
		lStop = time;
		iPay = (int) ((lStop - lStart) / 60000 * 20);
		iTotal = +iPay;
		return iPay;
	}

	/* pc정보 출력 */
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

	/* 서비스 추가 문자열을svcname[]배열에 넣음 */
	public void servicename(String name) {
		svcname[count] = name;
	}

	public String servicemenu(int i) {
		return svcname[i];
	}

	/* 시간 합계 */
	public int siTotal() {
		siTotal = sTotal + iTotal;
		return siTotal;
	}

	/* 서비스 추가 값 합계 */
	public void servicemoney(int money) {
		sTotal += money;
		svcmoney[count] = money;
		count++;
	}

	/* 추가된 서비스 값들 출력 */
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
