# Introduction #

다중지능검사(multiple intelligence test)


# Details #

인간의 지능은 8개의 다중지능으로 이루어져 있다고 합니다. 이 검사는 각각의 인간이 가지고 있는 지능중 가중 훌륭한 지능을 찾아주는 검사입니다. 검사에 참여하면 검사 항목이 나오고 항목에 따른 점수를 매깁니다. 그러면 자동으로 점수를 합산해줍니다.

# Code #

```

import java.util.Scanner;

public class multiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("안년하세요?");
		System.out.println("이 프로그램은 다중지능을 검사해주는 프로그램입니다.");
		System.out.println("검사에 참여하시겠습니까??");
		System.out.println("Choose True or false");
		
		Scanner keyboard=new Scanner(System.in);

		boolean isTrue=keyboard.nextBoolean();

		if(isTrue=true)
			System.out.println("네, 참여에 응해주셔서 감사합니다.");
		else
			System.out.println("아쉽네요.다음에 만나요.");
	
		System.out.println("지금부터 각 지능에 대한 문항을 제시하겠습니다");
		System.out.println("검사는 음악지능,신체운동지능,논리수학지능,공간지능,언어지능,대인관계지능,자기이해지능,자기이해지능,자연탐구지능에 대하여 실시됩니다.");
		System.out.println("지금바로시작하시겠습니까?");
		System.out.println("Choose True or False");
		
		boolean isTrue2=keyboard.nextBoolean();

		if(isTrue2=true)
			System.out.println("네, 그럼 검사 시작하겠습니다.");
		else
			System.out.println("아쉽네요.다음에 만나요.");
		
		System.out.println("각 문항에 대하여 1점부터 5점까지 점수를 매겨주세요.");
		
		intelligence1 m= new intelligence1();
		intelligence2 p= new intelligence2();
		intelligence3 l= new intelligence3();
		intelligence4 s= new intelligence4();
		intelligence5 a= new intelligence5();
		intelligence6 o= new intelligence6();
		intelligence7 r= new intelligence7();
		intelligence8 n= new intelligence8();
			
		
		m.musical();
		p.physical();
		l.logical();
		s.space();
		a.language();
		o.social();
		r.reflect();
		n.natural();
		
		System.out.println("네, 검사가 끝낫습니다.");
		System.out.println("감사합니다.");
		
					
		
	}
}	
			
		
		
		class intelligence1{
		
			public void musical(){
				
				Scanner keyboard=new Scanner(System.in);
		
		System.out.println("악기연주나 음악감상을 즐긴다.");/*음악지능*/
		int num1=keyboard.nextInt();
		System.out.println("악보를 보면 멜로디를 알 수 있다.");
		int num2=keyboard.nextInt();
		System.out.println("다른 사람의 연주를 들으면 부족한 점을 안다");
		int num3=keyboard.nextInt();
		System.out.println("다름 사람과 노래할 떄 화음을 잫 넣는다.");
		int num4=keyboard.nextInt();
		
		int sum1 = (num1+num2+num3+num4);/*음악지능 점수의 함*/
		System.out.printf("당신의  음악지능 점수는 %d\n", sum1);		
		
			}
		}
		


		class intelligence2{
		
			public void physical(){
			
			Scanner keyboard=new Scanner(System.in);	
			
		System.out.println("운동경기를 보면 선수들의 장단점을 안다.");//신체운동지능
		int num5=keyboard.nextInt();
		System.out.println("몸으로 활동하는 것을 좋아한다.");
		int num6=keyboard.nextInt();
		System.out.println("어떤 운동도 한두번 해보면 잘 하는 편인다.");
		int num7=keyboard.nextInt();
		System.out.println("운동을 잘한다는 말을 자주 듣는다.");
		int num8=keyboard.nextInt();
		
		int sum2 = (num5+num6+num7+num8);//신체운동지능 점수의 합
		System.out.printf("신체운동지능 점수는 %d\n", sum2);
	
			}
		}
		
		class intelligence3{
				
			public void logical(){
			
				Scanner keyboard=new Scanner(System.in);
				
		System.out.println("실험하고 검증하는 것을 좋아한다.");//논리수학지능
		int num9=keyboard.nextInt();
		System.out.println("수학이나 과학 과목을 좋아하낟.");
		int num10=keyboard.nextInt();
		System.out.println("말 속에서 비논리적인 점을 찾아낸다.");
		int num11=keyboard.nextInt();
		System.out.println("두뇌개발용 게임이나 퍼즐 등에 도전하는 것을 좋아한다.");
		int num12=keyboard.nextInt();
		
		int sum3 = (num9+num10+num11+num12);//논리수학지능 점수의 합
		System.out.printf("논리수학지능 점수는 %d\n", sum3);
		
			}
		}
		
		class intelligence4{
		
			public void space(){
			
				Scanner keyboard=new Scanner(System.in);
				
		System.out.println("물건을 만들거나 그림그니는 것을 좋아한다.");//공간지능
		int num13=keyboard.nextInt();
		System.out.println("길이나 넓이를 잘 맞힌다.");
		int num14=keyboard.nextInt();
		System.out.println("다른 사람의 그림을 보고 평가를 할 수 있다.");
		int num15=keyboard.nextInt();
		System.out.println("공간을 꾸밀 때 배치를 잘 한다.");
		int num16=keyboard.nextInt();
		
		int sum4 = (num13+num14+num15+num16);//공간지능 점수의 합
		System.out.printf("공간지능 점수는 %d\n", sum4);		
		
			}
		}
		
		class intelligence5{
		
			public void language(){
			
				Scanner keyboard=new Scanner(System.in);
				
		System.out.println("다른 사람보다 어휘력이 풍부하다.");//언이지능
		int num17=keyboard.nextInt();
		System.out.println("문법적으로 어색한 문장을 잘 찾아낸다.");
		int num18=keyboard.nextInt();
		System.out.println("어렸을 때 꿈은 작가나 아나운서이다.");
		int num19=keyboard.nextInt();
		System.out.println("설득력 있게 글을 쓴다는 말을 듣는다.");
		int num20=keyboard.nextInt();
		
		int sum5 = (num17+num18+num19+num20);//언어지능 점수의 합
		System.out.printf("언어지능 점수는 %d\n", sum5);
		
			}
		}
		
		class intelligence6{
		
			public void social(){
			
				Scanner keyboard=new Scanner(System.in);
				
		System.out.println("사람들의 고민을 해결하길 좋아한다.");//대인관계지능
		int num21=keyboard.nextInt();
		System.out.println("다른 사람이 슬픔에 잠겨있는 모습을 볼때 같이 슬픔을 느낀다.");
		int num22=keyboard.nextInt();
		System.out.println("다정다감하다는 소리르 자주 듣는다.");
		int num23=keyboard.nextInt();
		System.out.println("동료의 기분을 파악하고 대처한다.");
		int num24=keyboard.nextInt();
		
		int sum6 = (num21+num22+num23+num24);//대인관계지능 점수의 합
		System.out.printf("대인관계지능 점수는 %d\n", sum6);
		
			}
		}
		
		class intelligence7{
		
			public void reflect(){
			
				Scanner keyboard=new Scanner(System.in);
				
		System.out.println("자신을 되돌아보고, 계획하는 것을 좋아한다.");//자기이해지능
		int num25=keyboard.nextInt();
		System.out.println("내 컨디션을 잘 알 수 있다.");
		int num26=keyboard.nextInt();
		System.out.println("생각이나 감정을 잘 통제하고 조절한다.");
		int num27=keyboard.nextInt();
		System.out.println("능력,재능의 계발을 위해 노력한다.");
		int num28=keyboard.nextInt();
		
		int sum7 = (num25+num26+num27+num28);//자기이해지능 점수의 합
		System.out.printf("자기이해지능 점수는 %d\n", sum7);
		
			}
		}
		
		class intelligence8{
		
			public void natural(){
			
				Scanner keyboard=new Scanner(System.in);
				
		System.out.println("자동차에 관심이 많다.");//자연탐구지능
		int num29=keyboard.nextInt();
		System.out.println("옷이나 가방을 보면 브랜드를 안다.");
		int num30=keyboard.nextInt();
		System.out.println("동식물에 관해 많은 정보를 안다.");
		int num31=keyboard.nextInt();
		System.out.println("동식물을 좋아하고 잘 돌 본다.");
		int num32=keyboard.nextInt();
		
		int sum8 = (num29+num30+num31+num32);//자연탐구지능 점수의 합
		System.out.printf("자연탐구지능 점수는 %d\n", sum8);
		
			}
		}
		
```