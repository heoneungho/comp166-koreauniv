import java.util.Scanner;
public class Year extends Diary{
	
		Month1 Feb = new Month1();
		Month2 Apr = new Month2();
		Month2 Jun = new Month2();
		Month2 Sep = new Month2();
		Month2 Nov = new Month2();
		Month3 Jan = new Month3();
		Month3 Mar = new Month3();
		Month3 May = new Month3();
		Month3 Jul = new Month3();
		Month3 Aug = new Month3();
		Month3 Oct = new Month3();
		Month3 Dec = new Month3();
		Month[] Month1 = {Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec};
	
	public Diary go()
	{
		
		Month[] Months = new Month[13];
		
		Months[1] = Jan;
		Months[2] = Feb;
		Months[3] = Mar;
		Months[4] = Apr;
		Months[5] = May;
		Months[6] = Jun;
		Months[7] = Jul;
		Months[8] = Aug;
		Months[9] = Sep;
		Months[10]= Oct;
		Months[11]= Nov;
		Months[12]= Dec;
		System.out.println("달을 입력하세요:");
		Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Month a = Months[b];
        return a;
	}
	
	
	
}
