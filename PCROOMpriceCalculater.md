# Introduction #

이 프로그램은 PC방 사용 상황을 한눈에 들어올 수 있도록 시스템화하여 PC방을 찾는 모든 손님들에게 더욱 빠르고 편리한 서비스를 제공할 수 있도록 도와주는 프로그램이다

# background #

PC방 아르바이트를 할때 요금계산을 컴퓨터가 다 해주니 너무 편했었던 기억이있다.
이번에 JAVA를 배우면서 직접 요금계산 프로그램을 만들어 보고자 한다.

# Details #

사용시간에 따른 요금계산을 해주는 프로그램이다.
프로그램을 시작하면 첫번째로 PC의 갯수를 입력받습니다. 그 후 각 PC에 대해 CPU, MEMORY, 그래픽카드 등 사양을 입력하고, 사용일자를 입력받습니다.
그 후에 이제 각 PC의 사용이 시작될때 마다 자리를 할당하고 사용시간을 계산하게 됩니다.
기본적으로 PC방에서 수입은 추가서비스(라면, 음료수) 등이 큰 비중을 차지하기 때문에 추가서비스도 계산가능하도록 메뉴항목에 추가하였습니다.
아직 GUI를 배우지 않아 구현이 힘들어서 GUI는 사용하지 않도록 하겠습니다.

= code =.

```

/********PCinfo*********/
public class PCinfo
{
	private int iId;                                   //pc번호
	private String str_CPU;                            //CPU
	private String str_Memory;                         //메모리
	private String str_HDD;                            //HDD
	private String str_GPCard;                         //Graphic Card
	private long lStart;                               //PC 시작
	private long lStop;                                //PC 종료
	private int iTotal;                                
	private int iPay;
	private String using; 
	private int count;
	private String svcname[] = new String [50];        //이름 문자열 크기
	private int svcTotal; 
	private int sTotal;
	private int siTotal;
	private int svcmoney[] = new int[50];             //서비스 추가물품 값 정수형 크기

	public PCinfo()     //pc정보 초기화
	{
		iId=0;
		str_CPU=" ";
		str_Memory=" ";
		str_HDD=" ";
		str_GPCard=" ";
		lStart=0;
		lStop=0;
		iTotal=0;
		iPay=0;
		using="빈좌석";
		count=0;
		svcTotal=0;
		sTotal=0;
		siTotal=0;
			
	}

	/*pc 정보 입력*/
	public void setPCinfo(int id, String CPU, String Memory, String HDD, String GPCard)  
	{
		iId=id;
		str_CPU=CPU;
		str_Memory=Memory;
		str_HDD=HDD;
		str_GPCard=GPCard;
	}
	
	/*사용중인지 빈좌석인지 출력*/
	public String using()            
	{
		return using;
	}
	public void use(String used)
	{
		using=used;
	}
	
	/*시작 시간*/
	public void start(long time)     
	{
		lStart = time;
	}
	
	/*종료 시간*/
	public int stop(long time)      
	{
		lStop = time;
		iPay = (int)((lStop-lStart)/60000*20);
		iTotal=+iPay;
		return iPay;
	}
	
	/*pc정보 출력*/
	public void printpc()   
	{
		System.out.print("[CPU]"+ str_CPU +" [Memory] "+ str_Memory +" [HDD] "+ str_HDD +" [Graphic] "+str_GPCard);
	}
	public int getTime()   
	{
		int time;
		return time=(int)(lStop-lStart)/60000;
	}
	public int servicenum()
	{
		return count;
	}
	public int Servicetotal()
	{
		return sTotal;
	}

	/*서비스 추가 문자열을svcname[]배열에 넣음*/
	public void servicename(String name) 
	{
		svcname[count] = name;
	}
	public String servicemenu(int i)
	{
		return svcname[i];
	}

	/*시간 합계*/
	public int siTotal()    
	{
		siTotal = sTotal+iTotal;
		return siTotal;
	}
	
	/*서비스 추가 값 합계*/
	public void servicemoney(int money)  
	{
        sTotal += money;
        svcmoney[count]=money;
        count++;
	}
	
	/*추가된 서비스 값들 출력*/
	public void svcprintTotal(long time)   
	{
		lStop = time;
		int iPay=0;
		if(count!=0)
		{
			iPay=(int)((lStop-lStart)/60000*20);
			iTotal=+iPay;
			System.out.print("("+ iTotal +"+");
		}
		for(int i=0 ; i<=count-1 ; i++)
		{
			if(i==count-1)
			{
				System.out.print(svcmoney[i]+")");
			}
			else
			{
				System.out.print(svcmoney[i]+" + ");
			}
		}
	}
	public int getTotal()  
	{
		iTotal=(int)(lStop-lStart)/60000*20;
		if(iTotal<0)
		{
			iTotal=0;
		}
		int money=iTotal+sTotal;
		return money;
	}
	
	
	
}


/***** PCManager*******/

import java.util.Date;          //Date 함수 쓰기 위해 import
import java.io.*;
//import java.util.ArrayList;

public class PCManager {
	public static void main(String[] args)
	{
		
		boolean bFalg = true;
		String str_Date=" ";           //관리 일자 문자열
		String svcname=" ";
		int imenu=0;
		Date d;
		int servicetotal=0;
		int svcmn=0;
		int siTotal = 0;
		String today= " ";
		
		
		DataInputStream dis = new DataInputStream(System.in);    //문자열 입력 받기 위해//
		
		/*관리 일자 입력*/
		try
		{
			System.out.print("1.관리일자를 입력 하세요 : ");
			str_Date=dis.readLine();
		
		}catch(Exception e){
		};
		
	
		/*보유 컴퓨터  대수 입력*/
		try
		{
			System.out.print("보유 컴퓨터 대수를 입력 하세요 :  ");
			imenu=Integer.parseInt(dis.readLine());
		}catch(Exception e){
		}
	
	PCinfo pc[] = new PCinfo[imenu];
	
	for(int id=1; id<pc.length+1 ; id++)
	{
		String str_CPU=" ";
		String str_Memory=" ";
		String str_HDD=" ";
		String str_GPCard=" ";
		
		System.out.println(id + "번 좌석");
		try{
			System.out.print(">>CPU : ");
			str_CPU = dis.readLine();
			System.out.print(">>Memory : ");
			str_Memory = dis.readLine();
			System.out.print(">>HDD : ");
			str_HDD = dis.readLine();
			System.out.print(">>Graphic Card : ");
			str_GPCard = dis.readLine();
		}catch(Exception e){
		}
		pc[id-1]=new PCinfo();
		pc[id-1].setPCinfo(id, str_CPU, str_Memory, str_HDD, str_GPCard);
	}
	/*do while문 (do문 먼저 한번 실행)*/
	do{
		System.out.println("\n======================================\n");
		System.out.println("1.좌석배정");
		System.out.println("2.정산");
		System.out.println("3.추가 서비스");
		System.out.println("4.매출정보");
		System.out.println("5.종료");
		System.out.println("\n======================================\n");
		System.out.print("메뉴의 번호를 선택하세요(1-5) : ");
		
		try
		{
			imenu = Integer.parseInt(dis.readLine());
		}catch(Exception e)
		{
			System.out.println("1-5까지의 숫자로 입력해 주세요");
			continue;
		}
		
		
		switch(imenu)
		{
		/*좌석 배정*/
		case 1:                         
			try {
				System.out.println("[좌석 배정]");
			for(int id=0; id<pc.length; id++) {
				System.out.print("PC "+(id+1)+ " 번 : "+pc[id].using());
				pc[id].printpc();
				System.out.println();
			}
			
			System.out.print(">> 빈좌석 중에서 배정하세요. 좌석번호 : ");
			imenu = Integer.parseInt(dis.readLine());
			System.out.print(imenu+"번 좌석이 배정되었습니다. 그리고 컴퓨터 사용이 시작되었습니다.");
		}catch(Exception e){
			continue;
		}
		d = new Date();
		pc[imenu-1].start(d.getTime());
		pc[imenu-1].use("사용중");
		break;
				
		/*정산*/
		case 2:
			try{
				System.out.print(">> 좌석 번호를 입력하세요 : ");
				imenu = Integer.parseInt(dis.readLine());
			}catch(Exception e){
				continue;
			}
			
			servicetotal = pc[imenu-1].servicenum();
			d = new Date();
			System.out.println("[정산]");
			System.out.println(">> 컴퓨터 사용 요금은  "+pc[imenu-1].stop(d.getTime())+" 원 입니다. (사용시간 : "+ pc[imenu-1].getTime()+"분)");
			System.out.println(">> 추가 서비스 요금은 "+pc[imenu-1].Servicetotal()+" 원 입니다.");
			System.out.print("     추가 서비스 내역은 ");
			pc[imenu-1].use("빈좌석");
			
			for(int i=0; i<servicetotal; i++)               //서비시 내역 출력
			{
				System.out.print("["+pc[imenu-1].servicemenu(i)+"]");
			}
			System.out.println(" 입니다.");
			System.out.println("총 사용금액은  "+pc[imenu-1].siTotal()+"원 입니다.");
			System.out.println("이제 좌석번호 "+ imenu + "번은 빈 좌석입니다.");
			break;	
		
		/*서비스 추가*/
		case 3:
			try{
			System.out.print(">> 좌석 번호를 입력하세요 : ");
			imenu = Integer.parseInt(dis.readLine());
			System.out.print(">> 서비스의 이름을 입력하세요 : ");
			svcname = new String(dis.readLine().getBytes("8859_1"),"KSC5601");  //서비스 이름이 한글일수도 있기  때문에//
			System.out.print(">> 서비스의 금액을 입력하세요 : ");
			svcmn = Integer.parseInt(dis.readLine());
		}catch(Exception e){
			continue;
		}
		pc[imenu-1].servicename(svcname);
		pc[imenu-1].servicemoney(svcmn);
		break;
		
		/*매출 정보*/
		case 4:
			siTotal = 0;
			System.out.println("[매출정보 ]");
			Date t=new Date();
			for(int id=0;id<pc.length; id++){
				pc[id].stop(t.getTime());
				System.out.print("PC "+(id+1)+ " 번 : "+pc[id].getTotal()+"원");
				pc[id].svcprintTotal(t.getTime());
				System.out.println();
				siTotal = siTotal + pc[id].siTotal();
			}
			System.out.println(today+" 현재 총매출액은  "+siTotal+ "원입니다.");
			break;
			
		/*5 입력시 boolean 이 false로 while 문 종료*/
		case 5:       
			bFalg = false;
			break;
		default:
			break;
		}
		
	}while(bFalg);
		
		
	}
	

}

```