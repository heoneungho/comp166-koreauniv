
```
public class BeerSong  //어디에서든 접근가능한 BeerSong 클래스 선언
{
	public static void main(String[] args) //리턴값이 없는 'args'라는 이름의 String형 배열을 인자값으로 받는 main 메소드선언
        {
		int beerNum = 99;//beerNum이라는 int형 변수 선언과 99값 대입
		String word = "bottles";      // 복수형

		while (beerNum>0)
		{

		if (beerNum ==1) //change String "word" right after changing "beerNum"
			{
				word = "bottle";      // 단수형(한 병인 경우)
			}
			
			System.out.println(beerNum + " " + word + " of beer on the wall");  //출력하고 줄바꿈

			System.out.println(beerNum + " " + word + " of beer.");  //출력하고 줄바꿈

			System.out.println("Take one down."); //출력하고 줄바꿈

			System.out.println("Pass it around");//출력하고 줄바꿈
			
			beerNum = beerNum - 1;
             //변수 beerNum에 저장된 값에서 1을 뺀 값을 beerNum에 대입
			

			/*if(beerNum >0)
			{
				System.out.println(beerNum + " " + word + " of beer on the wall\n"); 
			} 이 if문은 while문의 조건인 'beerNum>0'과 겹친다. if문의 조건을 'beerNum<1'로 수정한다.*/
             if(beerNum<1) 
			{
				System.out.println("No more bottles of beer on the wall"); //출력하고 줄바꿈
			}     

		}      // while 순환문 끝
	}      // main 클래스 끝
}      // 클래스 끝
```