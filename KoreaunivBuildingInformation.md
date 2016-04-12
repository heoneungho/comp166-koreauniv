# Introduction #

고려대학교 건물 정보 및 이동 시간 정보 제공 시스템

# Details #


고려대학교 교내의 이공계 및 인문계 캠퍼스에 있는 건물들에 대한 정보를 제공하고

건물과 건물 사이의 거리 및 이동 시간을 제공한다. (걸음 시간, 버스 시간)

학교 내 이용하지 못한 시설의 서비스를 찾고자 할 때, 혹은 한 건물에서 다른

건물로 이동시에 얼마나 걸리는지를 찾고자 할 때 사용한다.

지하철 어플리케이션과 비슷한 방식으로 출발지점, 도착지점을 지정하고

GUI 방식으로 구현하여 나타낸다.

# Using the Code #

```
import java.io.*;

class time {
	public void walk(String a, String b) {
		//if문을 이용해서 건물 사이의 거리, 시간을 입력합니다.
               만약 학교 건물이 15개이면 15개에서 2개를 뽑는 조합으로 105개의
               거리와 걸음시간, 버스 시간을 입력합니다. //
               
	}
}
class info {
      public void infor(String c) {
          //if 문을 이용해서 건물의 정보를 입력합니다. 이는 아래 main에서 
              건물의 이름을 입력했을 시 그 이름이 if의 조건과 같다면 정보를
              출력해 줍니다. //
}

class around {
       public void arou(String d)  {
         //위와 마찬가지로 if 문을 이용해서 아래 main의 입력값이
            같은 경우를 찾아 건물 주변 정보를 나타냅니다. 지하철, 버스 정류장과의 거리
            지하철에서 찾아가는  법, 정후, 법후의 시설 등을 보여줍니다.
     }
}
class service {
         //우선 교내 주요 서비스 시설을 출력해서 보여준 후 이 중 하나를 
            검색창에 검색하면 관련 서비스 시설에 관한 정보 및 위치 등을
            알려줍니다.

}

public class Mainclass {
	public static void main(String[] ar) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		System.out.println();
		System.out.println("서비스를 시작합니다.");
		System.out.println("1.교내 건물 간 거리 및 이동 시간(걸음 시간&버스 시간");
		System.out.println("2.교내 건물 정보 보기");
		System.out.println("3.건물 주변 정보 보기");
		System.out.println("4.교내 주요 서비스 시설 보기");
		System.out.println("5.종료");
		System.out.println();
		System.out.print("원하는 기능 번호를 입력하세요:");
		String str1 = "";
		String str2 = "";
		time ap = new time();
		
		int input = 0;
		input = Integer.parseInt(in.readLine());
		switch(input) {
			case 1: 
		System.out.print("출발지점:");
			str1 = in.readLine();
		System.out.println();
			System.out.println("출발지점은" +str1+"입니다.");
		System.out.print("도착지점:");
			str2 = in.readLine();
		System.out.println();
			System.out.println("도착지점은"+str2+"입니다.");
			ap.walk(str1, str2);
			break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
		}
		}
	}
}

```

// GUI 방식으로 구현하는 것을 좀 더 공부를 해서 완성시키도록 하겠습니다.

전체적인 개요는 위와 같고 아직 디테일한 코드는 생각중에 있습니다.