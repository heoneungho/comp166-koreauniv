

# 개요 #

2011년 재수 생활을 기반으로 만든 **본격 재수 시뮬레이션 게임\*입니다.**<br>
아직 얼마나 많은 시스템을 구현 할지는 모르겠지만 기본적인 틀은 <b>'공부'</b>를 해서 갖가지 <b>'능력치'</b>를 얻어서 결국 최종 목표인 수능에서 높은 점수를 받는 게임으로 만들어 나갈 계획입니다. <br>

<i>재수를 하면 인생을 알고, 삼수를 하면 철학을 안다.</i> <br>
<i>- 삼수 10계 중 7 -</i> <br>

<h1>시놉시스</h1>

2010년 11월 18일 채원은 M모 사이트 모의 채점에 들어가서 수험표 뒷면에 적어온 자신의 정답을 적어 옮겼다. <br>

<img src='http://www.youguide.co.kr/data/file/06_5/3553169449_9e77895f_B4EBC7D0C0D4BDC3-B8DEB0A1BDBAC5CDB5F0.jpg' />

믿을 수 없었다. <br>
외고에 들어가기만 하면 소위 말하는 명문대에 무난히 들어갈 수 있다는 얘기는 모두 허구였던 것이다. <br>
원서를 접수할 때까지 채원은 현실도피를 하기 시작했고, 결국 H모 대학에 원서를 냈지만 떨어지고 말았다. <br>
<br>
현역 때는 먼 얘기만 같았던 '재수'라는 단어가 떠올랐다.<br>
"남 얘기가 아니구나." <br>
<br>
문과에서 이과로 전과까지 하면서 채원은 날아오를 준비를 하고 있었다. <br>

<img src='http://www.jongro.co.kr/images/academy/jongro/jongro_pic02_16_on.jpg' />

<b>myJongroStory</b> <br>



<h1>프로젝트 설명 (1.00 기반)</h1>

기본적인 프로젝트의 작동 방법은 수업시간에 했던 DotCom게임처럼 (DotCome게임에서는) 한 턴마다 예상지점에 공격을 했듯, 이 프로젝트는 한 턴 대신 하루동안 자신의 행동력을 최대한 이용해서 카드를 사용합니다. 이를 통해 능력치를 향상시키고 결국 수능에서 좋은 점수를 받는 것을 목표로 합니다.<br>
<br>
다음은 주요 클래스에 대한 설명입니다. <br>
<br>

<b>a) PlayJongro.java</b> <br>

<br>
<pre><code><br>
import java.util.Scanner;<br>
<br>
public class PlayJongro {<br>
<br>
	public static void main(String[] args) {<br>
<br>
		Status me = new Status();<br>
		Time time = new Time();<br>
<br>
		Card[] hand;<br>
		hand = new Card[5];<br>
<br>
		hand[0] = new Card();<br>
		hand[1] = new Card();<br>
		hand[2] = new Card();<br>
		hand[3] = new Card();<br>
		hand[4] = new Card();<br>
<br>
		System.out.println("My Jongro Story를 플레이 해주셔서 감사합니다!");<br>
		System.out.println("게임을 시작합니다!");<br>
		System.out<br>
		.println("자세한 사항은 http://code.google.com/p/comp166-koreauniv/wiki/myJongroStory를 참조하세요.");<br>
		try {<br>
			Thread.sleep(1000);<br>
		} catch (InterruptedException e) {<br>
			e.printStackTrace();<br>
		}<br>
		// 4월 (4일[月]~30일)<br>
		while (time.month == 4) {<br>
<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("EBS 반영이 올해는 70%라는 군!");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
				<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			if(time.day == 28) {<br>
				prepareTest(time.month, me);<br>
			}<br>
<br>
			endTime(time); // 하루를 마무리<br>
			<br>
			if(me.aprBasicPMP==true) {<br>
				System.out.println("보통 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강으로 복습을 해볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*4;<br>
				me.mth += (int) Math.random()*4;<br>
				me.eng += (int) Math.random()*4;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
				try {<br>
					Thread.sleep(1000);<br>
				} catch (InterruptedException e) {<br>
					e.printStackTrace();<br>
				}<br>
			}<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
<br>
		// 5월<br>
		while (time.month == 5) {<br>
			<br>
<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("봄에는 식단을 조절해야겠다!");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			if(time.day == 26) {<br>
				prepareTest(time.month, me);<br>
			}<br>
<br>
			endTime(time); // 하루를 마무리<br>
			<br>
			if(me.aprBasicPMP==true) {<br>
				System.out.println("보통 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강으로 복습을 해볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*4;<br>
				me.mth += (int) Math.random()*4;<br>
				me.eng += (int) Math.random()*4;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
			}<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
<br>
		}<br>
<br>
		// 6월<br>
		while (time.month == 6) {<br>
			<br>
<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("여름에는 아이스팩을 사두는 것이 좋을 것 같군!");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			if(time.day == 30) {<br>
				prepareTest(time.month, me);<br>
			}<br>
<br>
			endTime(time); // 하루를 마무리<br>
			<br>
			if(me.aprBasicPMP==true) {<br>
				System.out.println("보통 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강으로 복습을 해볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*4;<br>
				me.mth += (int) Math.random()*4;<br>
				me.eng += (int) Math.random()*4;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
			}<br>
			<br>
			if(me.junPigSave==true) {<br>
				System.out.println("황금돼지저금통이 돈을 낳았다!");<br>
				System.out.println("돈이 " + me.money + "만원에서");<br>
				me.money += (int) Math.random() * 5;<br>
				System.out.println(" " + me.money + "만원이 되었습니다!");<br>
				<br>
				int i = (int) Math.random() * 100;<br>
				if(i &lt;= 4) {<br>
					me.junPigSave = false;<br>
					System.out.println("불행하게도 황금돼지저금통이 더 이상 돈을 낳지 않습니다.");<br>
				}<br>
			}<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
<br>
		// 7월<br>
		while (time.month == 7) {<br>
			<br>
<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("10월에는 신기한 아이템이 생긴다는데?");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			if(time.day == 28) {<br>
				prepareTest(time.month, me);<br>
			}<br>
<br>
			endTime(time); // 하루를 마무리<br>
			<br>
			if(me.junNormalPMP==true) {<br>
				System.out.println("향상된 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강으로 복습을 해볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*10;<br>
				me.mth += (int) Math.random()*10;<br>
				me.eng += (int) Math.random()*10;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
			}<br>
			<br>
			if(me.junPigSave==true) {<br>
				System.out.println("황금돼지저금통이 돈을 낳았다!");<br>
				System.out.println("돈이 " + me.money + "만원에서");<br>
				me.money += (int) Math.random() * 5;<br>
				System.out.println(" " + me.money + "만원이 되었습니다!");<br>
				<br>
				int i = (int) Math.random() * 100;<br>
				if(i &lt;= 4) {<br>
					me.junPigSave = false;<br>
					System.out.println("불행하게도 황금돼지저금통이 더 이상 돈을 낳지 않습니다.");<br>
				}<br>
			}<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
<br>
		System.out.println("8월부터 9월 15일까지는 폭염이 시작됩니다!! 아이스팩을 구입하도록 합시다!");<br>
		<br>
		// 8월<br>
		while (time.month == 8) {<br>
			if(me.augMusicPlayer=true) {<br>
				int i = (int) Math.random() *100;<br>
				if(i &lt;= 5) {<br>
					System.out.println("기분 좋은 노래를 들으니 힘이 더 납니다!");<br>
					System.out.println("추가 행동력을 얻습니다!");<br>
					me.hp += 5;<br>
				}<br>
			}<br>
			<br>
			int summerCounter = (int) Math.random() *100;<br>
			<br>
			if((summerCounter &lt; 30) &amp;&amp; (me.augIcePack==false) ) {<br>
				System.out.println("너무 더워서 공부가 잘 되지 않습니다... 아이스팩을 사줘...");<br>
				me.hp /= 2;<br>
				System.out.println("(행동력을 절반 잃습니다...)");<br>
			}<br>
<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("박진기가 표풀이 특강을 연다는데...?");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			if(time.day == 25) {<br>
				prepareTest(time.month, me);<br>
			}<br>
<br>
			endTime(time); // 하루를 마무리<br>
			<br>
			if(me.junNormalPMP==true) {<br>
				System.out.println("향상된 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강으로 복습을 해볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*10;<br>
				me.mth += (int) Math.random()*10;<br>
				me.eng += (int) Math.random()*10;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
			}<br>
			<br>
			if(me.junPigSave==true) {<br>
				System.out.println("황금돼지저금통이 돈을 낳았다!");<br>
				System.out.println("돈이 " + me.money + "만원에서");<br>
				me.money += (int) Math.random() * 5;<br>
				System.out.println(" " + me.money + "만원이 되었습니다!");<br>
				<br>
				int i = (int) Math.random() * 100;<br>
				if(i &lt;= 4) {<br>
					me.junPigSave = false;<br>
					System.out.println("불행하게도 황금돼지저금통이 더 이상 돈을 낳지 않습니다.");<br>
				}<br>
			}<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
<br>
		// 9월<br>
		while (time.month == 9) {<br>
			<br>
			if(me.augMusicPlayer=true) {<br>
				int i = (int) Math.random() *100;<br>
				if(i &lt;= 5) {<br>
					System.out.println("기분 좋은 노래를 들으니 힘이 더 납니다!");<br>
					System.out.println("추가 행동력을 얻습니다!");<br>
					me.hp += 5;<br>
				}<br>
			}<br>
			<br>
			int summerCounter = (int) Math.random() *100;<br>
			<br>
			if((summerCounter &lt; 30) &amp;&amp; (me.augIcePack==false) &amp;&amp; (time.day &lt;= 15)) {<br>
				System.out.println("너무 더워서 공부가 잘 되지 않습니다... 아이스팩을 사줘...");<br>
				me.hp /= 2;<br>
				System.out.println("(행동력을 절반 잃습니다...)");<br>
			}<br>
			<br>
			<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("올 수능도 예년처럼 나온다는군...");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			if(time.day == 29) {<br>
				prepareTest(time.month, me);<br>
			}<br>
<br>
			endTime(time); // 하루를 마무리<br>
			<br>
			if(me.junNormalPMP==true) {<br>
				System.out.println("향상된 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강으로 복습을 해볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*10;<br>
				me.mth += (int) Math.random()*10;<br>
				me.eng += (int) Math.random()*10;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
			}<br>
			<br>
			if(me.junPigSave==true) {<br>
				System.out.println("황금돼지저금통이 돈을 낳았다!");<br>
				System.out.println("돈이 " + me.money + "만원에서");<br>
				me.money += (int) Math.random() * 5;<br>
				System.out.println(" " + me.money + "만원이 되었습니다!");<br>
				<br>
				int i = (int) Math.random() * 100;<br>
				if(i &lt;= 4) {<br>
					me.junPigSave = false;<br>
					System.out.println("불행하게도 황금돼지저금통이 더 이상 돈을 낳지 않습니다.");<br>
				}<br>
			}<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
<br>
		// 10월<br>
		while (time.month == 10) {<br>
			<br>
			if(me.augMusicPlayer=true) {<br>
				int i = (int) Math.random() *100;<br>
				if(i &lt;= 5) {<br>
					System.out.println("기분 좋은 노래를 들으니 힘이 더 납니다!");<br>
					System.out.println("추가 행동력을 얻습니다!");<br>
					me.hp += 5;<br>
				}<br>
			}<br>
<br>
			int parentCounter = (int) Math.random()*100;<br>
			<br>
			if((me.octParentKnowledge==true) &amp;&amp; (parentCounter &gt;= 5)) {<br>
				System.out.println("채원아... 힘을 내렴!!!");<br>
				System.out.println("오늘은 어떤 공부든 할 수 있을 것같다!");<br>
				me.hp = 999;<br>
			}<br>
			<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("EBS는 언어와 외국어 위주로 보는것이 좋다고 하네...");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			if(time.day == 27) {<br>
				prepareTest(time.month, me);<br>
			}<br>
			<br>
			if(me.junPigSave==true) {<br>
				System.out.println("황금돼지저금통이 돈을 낳았다!");<br>
				System.out.println("돈이 " + me.money + "만원에서");<br>
				me.money += (int) Math.random() * 5;<br>
				System.out.println(" " + me.money + "만원이 되었습니다!");<br>
				<br>
				int i = (int) Math.random() * 100;<br>
				if(i &lt;= 4) {<br>
					me.junPigSave = false;<br>
					System.out.println("불행하게도 황금돼지저금통이 더 이상 돈을 낳지 않습니다.");<br>
				}<br>
			}<br>
			<br>
			if(me.sepMasterPMP==true) {<br>
				System.out.println("최후의 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강을 찍어볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*30;<br>
				me.mth += (int) Math.random()*30;<br>
				me.eng += (int) Math.random()*30;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
			}<br>
<br>
			int godCounter = (int) Math.random()*100;<br>
			<br>
			if((me.octGodKnowledge==true) &amp;&amp; (godCounter &gt;= 5) &amp;&amp; !(time.day == 1)) {<br>
				System.out.println("꿈에서 신이 나와 지식을 나누어 주었다...");<br>
				System.out.println("신: 너에게 하루를 다시 준다면 어떡하겠니?");<br>
				time.day--;<br>
				time.dow--;<br>
				if (time.dow == 0) {<br>
					time.dow = 7;<br>
				}			<br>
			}<br>
			<br>
			endTime(time); // 하루를 마무리<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
<br>
		// 11월<br>
		while ((time.month == 11) &amp;&amp; (time.day &lt; 11)) {<br>
			<br>
			if(me.augMusicPlayer=true) {<br>
				int i = (int) Math.random() *100;<br>
				if(i &lt;= 5) {<br>
					System.out.println("기분 좋은 노래를 들으니 힘이 더 납니다!");<br>
					System.out.println("추가 행동력을 얻습니다!");<br>
					me.hp += 5;<br>
				}<br>
			}<br>
			<br>
			int parentCounter = (int) Math.random()*100;<br>
			<br>
			if((me.octParentKnowledge==true) &amp;&amp; (parentCounter &gt;= 5)) {<br>
				System.out.println("채원아... 힘을 내렴!!!");<br>
				System.out.println("오늘은 어떤 공부든 할 수 있을 것같다!");<br>
				me.hp = 999;<br>
			}<br>
			<br>
			takeCard(hand,me); // 패를 새로 지급 받는다.<br>
<br>
			int selectHand;<br>
<br>
			// 평일 혹은 토요일일 때,<br>
			if (!(time.dow == 7)) {<br>
				do {<br>
					showTime(time); // 시간을 보여준다.<br>
					messageOfHpMoney(me); // 행동력과 돈의 상황을 보여준다. <br>
					showCard(hand, me); // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
					selectHand = ordering(hand, me); // 패 사용에 관련.<br>
				} while (!(selectHand == 0)); // 0(집에 간다)을 선택했을 시에는 하루를 넘긴다.<br>
			}<br>
			// 평일 혹은 토요일일 때, (끝)<br>
<br>
			// 일요일일 때,<br>
			if (time.dow == 7) { <br>
				int sundayChoice = 1;<br>
				while(!(sundayChoice == 0)) {<br>
					System.out<br>
					.println(time.month + "월  " + time.day + "일 일요일 입니다.");<br>
					System.out.println("일요일에는 무엇을 할까요?");<br>
					System.out.println("1. 카드를 강화한다.(아직구현X)");<br>
					System.out.println("2. 아이템을 구입한다.");<br>
					System.out.println("0. 휴식한다. (턴을 끝낸다)");<br>
<br>
					Scanner sc = new Scanner(System.in);<br>
					sundayChoice = sc.nextInt();<br>
<br>
					switch(sundayChoice) {<br>
					case 1: //inhance(); <br>
						break;<br>
					case 2: shop(me, time);<br>
					break;<br>
					case 0: <br>
						break;<br>
					}<br>
				}<br>
				me.money += me.allowance;<br>
				System.out.println("용돈을 " + me.allowance + "원 받았습니다!");<br>
				<br>
				if(me.maySmartPhone==true) {<br>
					if(me.money &gt;= 3) {<br>
						System.out.println("스마트폰을 이용해 입시정보를 얻었습니다!");<br>
						System.out.println("올 수능 날씨는 꽤나 포근하다고 하네?");<br>
						<br>
						me.money -= 3;<br>
						System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
						<br>
						me.kor += (int) Math.random()*4;<br>
						me.mth += (int) Math.random()*4;<br>
						me.eng += (int) Math.random()*4;<br>
						<br>
						System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
					} else {<br>
						System.out.println("요금을 지불하지 않아. 효과를 받지 못합니다.");<br>
					}<br>
				}<br>
			}<br>
			// 일요일일 때, (끝)<br>
<br>
			if(time.day == 10) {<br>
				prepareTest(time.month, me);<br>
			}<br>
<br>
			endTime(time); // 하루를 마무리<br>
			<br>
			if(me.junPigSave==true) {<br>
				System.out.println("황금돼지저금통이 돈을 낳았다!");<br>
				System.out.println("돈이 " + me.money + "만원에서");<br>
				me.money += (int) Math.random() * 5;<br>
				System.out.println(" " + me.money + "만원이 되었습니다!");<br>
				<br>
				int i = (int) Math.random() * 100;<br>
				if(i &lt;= 4) {<br>
					me.junPigSave = false;<br>
					System.out.println("불행하게도 황금돼지저금통이 더 이상 돈을 낳지 않습니다.");<br>
				}<br>
			}<br>
			<br>
			if(me.sepMasterPMP==true) {<br>
				System.out.println("최후의 PMP의 효과가 적용되었습니다!");<br>
				System.out.println("어디 한 번 인강을 찍어볼까?");<br>
				<br>
				System.out.println("언어, 수리, 외국어가 " + me.kor + " " + me.mth + " " + me.eng + "  →  ");<br>
				<br>
				me.kor += (int) Math.random()*30;<br>
				me.mth += (int) Math.random()*30;<br>
				me.eng += (int) Math.random()*30;<br>
				<br>
				System.out.println(me.kor + " " + me.mth + " " + me.eng + " 로 상승했습니다.");<br>
			}<br>
			<br>
			int godCounter = (int) Math.random()*100;<br>
			<br>
			if((me.octGodKnowledge==true) &amp;&amp; (godCounter &gt;= 5) &amp;&amp; !(time.day == 1)) {<br>
				System.out.println("꿈에서 신이 나와 지식을 나누어 주었다...");<br>
				System.out.println("신: 너에게 하루를 다시 준다면 어떡하겠니?");<br>
				time.day--;<br>
				time.dow--;<br>
				if (time.dow == 0) {<br>
					time.dow = 7;<br>
				}			<br>
			}<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
<br>
		System.out.println("게임이 끝났습니다! 수고하셨습니다!");<br>
<br>
	} // main 끝<br>
<br>
	<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
	static void takeCard(Card[] hand, Status me) { // 카드를 새로 지급 받는다.<br>
<br>
		// 1등급, 2등급, 3등급 카드 갯수<br>
		int GRADE_1 = 4;<br>
		int GRADE_2 = 4;<br>
		int GRADE_3 = 6;<br>
<br>
		do  {<br>
			for (int i = 0; i &lt; 3; i++) {<br>
				int randvalue = (int) (Math.random() * 100) + 1; // 1~50: 1등급 (50%)<br>
				// 51~85: 2등급 (35%)<br>
				// 86~100: 3등급 (15%)<br>
<br>
				if (randvalue &lt;= 50) {<br>
					int randkind = (int) (Math.random() * GRADE_1) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 1;<br>
					// 1등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 85) {<br>
					int randkind = (int) (Math.random() * GRADE_2) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 2;<br>
					// 2등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 100) {<br>
					int randkind = (int) (Math.random() * GRADE_3) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 3;<br>
					// 3등급 카드를 랜덤하게 받는다.<br>
				}<br>
			} // for 끝<br>
<br>
			for (int i = 0; i &lt; 3; i++) {<br>
				hand[i].name = nameCard(hand[i]); // 카드에 이름을 삽입해준다. nameCard<br>
			}<br>
<br>
			if(me.fourthSlot == true) {<br>
				int i = 3;<br>
				int randvalue = (int) (Math.random() * 100) + 1; // 1~50: 1등급 (50%)<br>
				// 51~85: 2등급 (35%)<br>
				// 86~100: 3등급 (15%)<br>
<br>
				if (randvalue &lt;= 50) {<br>
					int randkind = (int) (Math.random() * GRADE_1) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 1;<br>
					// 1등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 85) {<br>
					int randkind = (int) (Math.random() * GRADE_2) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 2;<br>
					// 2등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 100) {<br>
					int randkind = (int) (Math.random() * GRADE_3) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 3;<br>
					// 3등급 카드를 랜덤하게 받는다.<br>
				}<br>
<br>
				hand[i].name = nameCard(hand[i]);<br>
			}<br>
<br>
			if(me.fifthSlot == true) {<br>
				int i = 3;<br>
				int randvalue = (int) (Math.random() * 100) + 1; // 1~50: 1등급 (50%)<br>
				// 51~85: 2등급 (35%)<br>
				// 86~100: 3등급 (15%)<br>
<br>
				if (randvalue &lt;= 50) {<br>
					int randkind = (int) (Math.random() * GRADE_1) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 1;<br>
					// 1등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 85) {<br>
					int randkind = (int) (Math.random() * GRADE_2) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 2;<br>
					// 2등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 100) {<br>
					int randkind = (int) (Math.random() * GRADE_3) + 1;<br>
					hand[i].cardnum = randkind;<br>
					hand[i].isUsed = false;<br>
					hand[i].value = 3;<br>
					// 3등급 카드를 랜덤하게 받는다.<br>
				}<br>
<br>
				hand[i].name = nameCard(hand[i]);<br>
			}<br>
		} while ((hand[0].name == null) || (hand[1].name == null)<br>
				|| (hand[2].name == null) || (hand[3].name == null)<br>
				|| (hand[4].name == null)); // 버그 수정용<br>
	} // takeCard 끝<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static void showTime(Time time) {<br>
		if (!(time.dow == 7)) {<br>
			System.out.println("=====================================");<br>
			System.out.print(time.month + "월  " + time.day + "일 ");<br>
			switch (time.dow) {<br>
			case 1:<br>
				System.out.println("월요일입니다.");<br>
				break;<br>
			case 2:<br>
				System.out.println("화요일입니다.");<br>
				break;<br>
			case 3:<br>
				System.out.println("수요일입니다.");<br>
				break;<br>
			case 4:<br>
				System.out.println("목요일입니다.");<br>
				break;<br>
			case 5:<br>
				System.out.println("금요일입니다.");<br>
				break;<br>
			case 6:<br>
				System.out.println("토요일입니다.");<br>
				break;<br>
			}<br>
		}<br>
	}<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static void messageOfHpMoney(Status me) {<br>
		System.out.println("당신의 패입니다.");<br>
		System.out.println("남은 행동력:  " + me.hp + "/" + me.hp_MAX);<br>
		System.out.println("남은 돈:  " + me.money + " 만원");<br>
	}<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static void showCard(Card[] hand, Status me) { // 현재 패를 보여준다. (혹은 집에 가기를 원한다든가...)<br>
		if (!hand[0].isUsed)<br>
			System.out.println("1: " + hand[0].name);<br>
		if (!hand[1].isUsed)<br>
			System.out.println("2: " + hand[1].name);<br>
		if (!hand[2].isUsed)<br>
			System.out.println("3: " + hand[2].name);<br>
		if(me.fourthSlot == true)<br>
			if (!hand[3].isUsed)<br>
				System.out.println("4: " + hand[3].name);<br>
		if(me.fifthSlot == true)<br>
			if (!hand[4].isUsed)<br>
				System.out.println("5: " + hand[4].name);<br>
		System.out.println("0: 집에 간다(턴을 끝낸다)");<br>
	}<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static int ordering (Card[] hand, Status me) {<br>
<br>
		System.out.println("명령을 내려주세요.");<br>
		Scanner sc = new Scanner(System.in);<br>
		int selectHand = sc.nextInt();<br>
		System.out.println("=====================================");<br>
		switch (selectHand) {<br>
		case 1:<br>
			hand[0].isUsed = true;<br>
			useCard(hand[0], me);<br>
			break;<br>
		case 2:<br>
			hand[1].isUsed = true;<br>
			useCard(hand[1], me);<br>
			break;<br>
		case 3:<br>
			hand[2].isUsed = true;<br>
			useCard(hand[2], me);<br>
			break;<br>
		case 4:<br>
			hand[3].isUsed = true;<br>
			useCard(hand[3], me);<br>
			break;<br>
		case 5:<br>
			hand[4].isUsed = true;<br>
			useCard(hand[4], me);<br>
			break;<br>
		case 0: // 턴을 넘긴다.<br>
		} // switch 끝<br>
<br>
		return selectHand;<br>
	}<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	void inhance() {<br>
<br>
	}<br>
<br>
	static void shop(Status me, Time time) {<br>
		System.out.println("상점에 오신 것을 환영합니다!");<br>
		int shopChoice = 0;<br>
		while(!(shopChoice == 9)) {<br>
			System.out.println("현재 " + me.money + "만 원 갖고 있습니다.");<br>
<br>
			if((me.fourthSlot==false) &amp;&amp; (me.fifthSlot==false))<br>
				System.out.println("0. 추가 슬롯 → 10 만 원");<br>
			if((me.fourthSlot==true) &amp;&amp; (me.fifthSlot==false))<br>
				System.out.println("0. 추가 슬롯 → 30 만 원");<br>
			System.out.println("9. 상점을 나간다.");<br>
<br>
<br>
			if(time.month==4) { // 4월의 아이템<br>
				if(me.aprActionJumpingRope==false)<br>
					System.out.println("1. (4월한정) 느낌표 줄넘기(최대 행동력 +10) → 만 원");<br>
				if(me.aprBasicPMP==false)<br>
					System.out.println("2. (4월한정) 보통 PMP(6월까지 매일 능력치 소폭 상승) → 15 만 원");	<br>
				Scanner sc = new Scanner(System.in);<br>
				shopChoice = sc.nextInt();<br>
				System.out.println("===================================");<br>
<br>
				switch(shopChoice) {<br>
				case 0: <br>
					if(me.money &lt; 10) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if ((me.money &lt; 30) &amp;&amp; (me.fourthSlot == true)) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if((me.fourthSlot) == false &amp;&amp; (me.fifthSlot==false)) {<br>
						me.fourthSlot = true;<br>
						me.money -= 10;<br>
						break;<br>
					} else if ((me.fourthSlot) == true &amp;&amp;(me.fifthSlot==false)) {<br>
						me.fifthSlot = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 1:<br>
					if(me.money &lt; 1) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.aprActionJumpingRope == false) {<br>
						me.aprActionJumpingRope = true;<br>
						me.hp_MAX += 10;<br>
						me.money -= 1;<br>
						break;<br>
					}<br>
				case 2:<br>
					if(me.money &lt; 15) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.aprBasicPMP == false) {<br>
						me.aprBasicPMP = true;<br>
						me.money -= 15;<br>
						break;<br>
					}<br>
				default:<br>
					break;<br>
				}<br>
			}<br>
<br>
<br>
			if(time.month==5) { // 5월의 아이템<br>
				if(me.maySmartPhone==false)<br>
					System.out.println("1. (5월한정) 스마트폰 구입(매주 일요일 돈 3 만 원 감소, 능력치 보통 상승) → 30 만 원.");<br>
				if(me.mayFirstPen==false)<br>
					System.out.println("2. (5월한정) 모나미 볼펜 세트(시험을 잘 칠 확률이 높아짐) → 만 원");<br>
				Scanner sc = new Scanner(System.in);<br>
				shopChoice = sc.nextInt();<br>
				System.out.println("===================================");<br>
<br>
				switch(shopChoice) {<br>
				case 0: <br>
					if(me.money &lt; 10) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if ((me.money &lt; 30) &amp;&amp; (me.fourthSlot == true)) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if((me.fourthSlot) == false &amp;&amp; (me.fifthSlot==false)) {<br>
						me.fourthSlot = true;<br>
						me.money -= 10;<br>
						break;<br>
					} else if ((me.fourthSlot) == true &amp;&amp;(me.fifthSlot==false)) {<br>
						me.fifthSlot = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 1:<br>
					if(me.money &lt; 30) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.maySmartPhone == false) {<br>
						me.maySmartPhone = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 2:<br>
					if(me.money &lt; 1) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.mayFirstPen == false) {<br>
						me.mayFirstPen = true;<br>
						me.money -= 1;<br>
						break;<br>
					}<br>
				default:<br>
					break;<br>
				}<br>
			}<br>
<br>
<br>
			if(time.month==6) { // 6월의 아이템<br>
				if(me.junNormalPMP==false)<br>
					System.out.println("1. (6월한정) 향상된 PMP(9월까지 매일 능력치 소폭 상승) → 30 만 원");<br>
				if(me.junPigSave==false)<br>
					System.out.println("2. (6월한정) 황금돼지저금통(매일 소량의 돈 획득, 5% 확률로 파괴 → 30 만 원");<br>
				Scanner sc = new Scanner(System.in);<br>
				shopChoice = sc.nextInt();<br>
				System.out.println("===================================");<br>
				switch(shopChoice) {<br>
				case 0: <br>
					if(me.money &lt; 10) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if ((me.money &lt; 30) &amp;&amp; (me.fourthSlot == true)) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if((me.fourthSlot) == false &amp;&amp; (me.fifthSlot==false)) {<br>
						me.fourthSlot = true;<br>
						me.money -= 10;<br>
						break;<br>
					} else if ((me.fourthSlot) == true &amp;&amp;(me.fifthSlot==false)) {<br>
						me.fifthSlot = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 1:<br>
					if(me.money &lt; 30) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.junNormalPMP == false) {<br>
						me.junNormalPMP = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 2:<br>
					if(me.money &lt; 30) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.junPigSave == false) {<br>
						me.junPigSave = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				default:<br>
					break;<br>
				}<br>
			}<br>
<br>
<br>
			if(time.month==7) { // 7월의 아이템<br>
				if(me.julSecondPen==false)<br>
					System.out.println("1. (7월한정) 하이테크 볼펜 세트(시험을 잘 칠 확률이 높아짐) → 3 만 원.");<br>
				if(me.julCookingSet==false)<br>
					System.out.println("2. (7월한정) 엄마께 조리도구 선물(현 최대 행동력을 두배로) → 50 만 원");<br>
				Scanner sc = new Scanner(System.in);<br>
				shopChoice = sc.nextInt();<br>
				System.out.println("===================================");<br>
				switch(shopChoice) {<br>
				case 0: <br>
					if(me.money &lt; 10) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if ((me.money &lt; 30) &amp;&amp; (me.fourthSlot == true)) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if((me.fourthSlot) == false &amp;&amp; (me.fifthSlot==false)) {<br>
						me.fourthSlot = true;<br>
						me.money -= 10;<br>
						break;<br>
					} else if ((me.fourthSlot) == true &amp;&amp;(me.fifthSlot==false)) {<br>
						me.fifthSlot = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 1:<br>
					if(me.money &lt; 3 ) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.julSecondPen == false) {<br>
						me.julSecondPen = true;<br>
						me.money -= 3;<br>
						break;<br>
					}<br>
				case 2:<br>
					if(me.money &lt; 50) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.julCookingSet == false) {<br>
						me.julCookingSet = true;<br>
						me.money -= 50;<br>
						me.hp_MAX *= 2;<br>
						System.out.println("더욱 맛있는 음식을 먹으며 공부를 한다!");<br>
						break;<br>
					}<br>
				default:<br>
					break;<br>
				}<br>
			}<br>
<br>
<br>
			if(time.month==8) { // 8월의 아이템<br>
				if(me.augMusicPlayer==false)<br>
					System.out.println("1. (8월한정) MP3 플레이어 구입(하루의 시작에 5% 확률로 추가 행동력 지급 → 10 만 원");<br>
				if(me.augIcePack==false)<br>
					System.out.println("2. (8월한정) 아이스팩(폭염에 의한 탈진 방지) → 7 만 원");<br>
				Scanner sc = new Scanner(System.in);<br>
				shopChoice = sc.nextInt();<br>
				System.out.println("===================================");<br>
				switch(shopChoice) {<br>
				case 0: <br>
					if(me.money &lt; 10) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if ((me.money &lt; 30) &amp;&amp; (me.fourthSlot == true)) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if((me.fourthSlot) == false &amp;&amp; (me.fifthSlot==false)) {<br>
						me.fourthSlot = true;<br>
						me.money -= 10;<br>
						break;<br>
					} else if ((me.fourthSlot) == true &amp;&amp;(me.fifthSlot==false)) {<br>
						me.fifthSlot = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 1:<br>
					if(me.money &lt; 10 ) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.augMusicPlayer == false) {<br>
						me.augMusicPlayer = true;<br>
						me.money -= 10;<br>
						break;<br>
					}<br>
				case 2:<br>
					if(me.money &lt; 7) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.augIcePack == false) {<br>
						me.augIcePack = true;<br>
						me.money -= 7;<br>
						break;<br>
					}<br>
				default:<br>
					break;<br>
				}<br>
			}<br>
<br>
<br>
			if(time.month==9) { // 9월의 아이템<br>
				if(me.sepThirdPen==false)<br>
					System.out.println("1. (9월한정) 몽블랑 만년필 세트(시험을 잘 칠 확률이 높아짐) → 30 만 원");<br>
				if(me.sepMasterPMP==false)<br>
					System.out.println("2. (9월한정) 최후의 PMP(11월까지 매일 능력치 소폭 상승) → 50 만 원.");<br>
				Scanner sc = new Scanner(System.in);<br>
				shopChoice = sc.nextInt();<br>
				System.out.println("===================================");<br>
				switch(shopChoice) {<br>
				case 0: <br>
					if(me.money &lt; 10) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if ((me.money &lt; 30) &amp;&amp; (me.fourthSlot == true)) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if((me.fourthSlot) == false &amp;&amp; (me.fifthSlot==false)) {<br>
						me.fourthSlot = true;<br>
						me.money -= 10;<br>
						break;<br>
					} else if ((me.fourthSlot) == true &amp;&amp;(me.fifthSlot==false)) {<br>
						me.fifthSlot = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 1:<br>
					if(me.money &lt; 30 ) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.sepThirdPen == false) {<br>
						me.sepThirdPen = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 2:<br>
					if(me.money &lt; 50) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.sepMasterPMP == false) {<br>
						me.sepMasterPMP = true;<br>
						me.money -= 50;<br>
						break;<br>
					}<br>
				default:<br>
					break;<br>
				}<br>
			}<br>
<br>
<br>
			if(time.month==10) { // 10월의 아이템<br>
				if(me.octGodKnowledge==false)<br>
					System.out.println("1. (10월한정) 신의 가르침(???) → 100 만 원.");<br>
				if(me.octParentKnowledge==false)<br>
					System.out.println("2. (10월한정) 부모님의 가르침(???) → 100 만 원.");<br>
				Scanner sc = new Scanner(System.in);<br>
				shopChoice = sc.nextInt();<br>
				System.out.println("===================================");<br>
				switch(shopChoice) {<br>
				case 0: <br>
					if(me.money &lt; 10) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if ((me.money &lt; 30) &amp;&amp; (me.fourthSlot == true)) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if((me.fourthSlot) == false &amp;&amp; (me.fifthSlot==false)) {<br>
						me.fourthSlot = true;<br>
						me.money -= 10;<br>
						break;<br>
					} else if ((me.fourthSlot) == true &amp;&amp;(me.fifthSlot==false)) {<br>
						me.fifthSlot = true;<br>
						me.money -= 30;<br>
						break;<br>
					}<br>
				case 1:<br>
					if(me.money &lt; 100 ) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.octGodKnowledge == false) {<br>
						me.octGodKnowledge = true;<br>
						me.money -= 100;<br>
						break;<br>
					}<br>
				case 2:<br>
					if(me.money &lt; 100) {<br>
						System.out.println("돈이 부족합니다!");<br>
						break;<br>
					} else if (me.octParentKnowledge == false) {<br>
						me.octParentKnowledge = true;<br>
						me.money -= 100;<br>
						break;<br>
					}<br>
				default:<br>
					break;<br>
				}<br>
			}<br>
<br>
<br>
			if(time.month==11) { // 11월의 아이템<br>
				System.out.println("11월은 한정 아이템이 없습니다.");<br>
				shopChoice = 9;<br>
			}<br>
		}<br>
	}<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static Card cardSelection(int GRADE, int randkind) {<br>
		switch (GRADE) {<br>
		case 1:<br>
			switch (randkind) {<br>
			case 0:<br>
				return NameList.korBasic;<br>
			case 1:<br>
				return NameList.mthBasic;<br>
			case 2:<br>
				return NameList.engBasic;<br>
			case 3:<br>
				return NameList.hpBasic;<br>
			} // GRADE == 1 ends<br>
		case 2:<br>
			switch (randkind) {<br>
			case 0:<br>
				return NameList.korNormal;<br>
			case 1:<br>
				return NameList.mthNormal;<br>
			case 2:<br>
				return NameList.engNormal;<br>
			case 3:<br>
				return NameList.hpNormal;<br>
			} // GRADE == 2 ends<br>
		case 3:<br>
			switch (randkind) {<br>
			case 0:<br>
				return NameList.korMaster;<br>
			case 1:<br>
				return NameList.mthMaster;<br>
			case 2:<br>
				return NameList.engMaster;<br>
			case 3:<br>
				return NameList.hpMaster;<br>
			case 4:<br>
				return NameList.lottery;<br>
			case 5:<br>
				return NameList.albaBasic;<br>
			} // GRADE == 3 ends<br>
		}<br>
		return null;<br>
	}<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static String nameCard(Card hand) { // 카드에 이름을 삽입해준다. <br>
		switch (hand.value) {<br>
		case 1:<br>
			switch (hand.cardnum) {<br>
			case 0:<br>
				return "★☆☆ 언어기본(15)";<br>
			case 1:<br>
				return "★☆☆ 수리기본(15)";<br>
			case 2:<br>
				return "★☆☆ 외국어기본(15)";<br>
			case 3:<br>
				return "★☆☆ 운동기본(30)";<br>
			} // value == 1 ends<br>
<br>
		case 2:<br>
			switch (hand.cardnum) {<br>
			case 0:<br>
				return "★★☆ 언어보충(30)";<br>
			case 1:<br>
				return "★★☆ 수리보충(30)";<br>
			case 2:<br>
				return "★★☆ 외국어보충(30)";<br>
			case 3:<br>
				return "★★☆ 운동보충(50)";<br>
			} // value == 2 ends<br>
<br>
		case 3:<br>
			switch (hand.cardnum) {<br>
			case 0:<br>
				return "★★★ 언어보충(50)";<br>
			case 1:<br>
				return "★★★ 수리보충(50)";<br>
			case 2:<br>
				return "★★★ 외국어보충(50)";<br>
			case 3:<br>
				return "★★★ 운동보충(100)";<br>
			case 4:<br>
				return "★★★ 복권구입(돈 만 원)";<br>
			case 5:<br>
				return "★★★ 알바기본(30)";<br>
			} // value == 3 ends<br>
		}<br>
		return null;<br>
	}<br>
<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static void useCard(Card hand, Status me) { // 카드를 사용한다.<br>
		switch (hand.value) {<br>
		case 1:<br>
			switch (hand.cardnum) {<br>
			case 0:<br>
				CardData.korBasic(me, hand);<br>
				break;<br>
			case 1:<br>
				CardData.mthBasic(me, hand);<br>
				break;<br>
			case 2:<br>
				CardData.engBasic(me, hand);<br>
				break;<br>
			case 3:<br>
				CardData.hpBasic(me, hand);<br>
				break;<br>
			}<br>
			break;<br>
			// value == 1 ends<br>
<br>
		case 2:<br>
			switch (hand.cardnum) {<br>
			case 0:<br>
				CardData.korNormal(me, hand);<br>
				break;<br>
			case 1:<br>
				CardData.mthNormal(me, hand);<br>
				break;<br>
			case 2:<br>
				CardData.engNormal(me, hand);<br>
				break;<br>
			case 3:<br>
				CardData.hpNormal(me, hand);<br>
				break;<br>
			}<br>
			break;<br>
			// value == 2 ends<br>
<br>
		case 3:<br>
			switch (hand.cardnum) {<br>
			case 0:<br>
				CardData.korMaster(me, hand);<br>
				break;<br>
			case 1:<br>
				CardData.mthMaster(me, hand);<br>
				break;<br>
			case 2:<br>
				CardData.engMaster(me, hand);<br>
				break;<br>
			case 3:<br>
				CardData.hpMaster(me, hand);<br>
				break;<br>
			case 4:<br>
				CardData.lottery(me, hand);<br>
				break;<br>
			case 5:<br>
				CardData.albaBasic(me, hand);<br>
				break;<br>
			}<br>
			break;<br>
			// value == 3 ends<br>
		}<br>
	}<br>
<br>
	//------------------------------------------------------------------------------------------<br>
	//------------------------------------------------------------------------------------------<br>
<br>
	static void prepareTest(int month, Status me) { // 마지막 목요일에는 모의고사를 친다.<br>
		int type = (int) (Math.random()*8);<br>
		int [] kor = new int[8];<br>
		int [] mth = new int[8];<br>
		int [] eng = new int[8];<br>
		if(type == 1) { // 물물물<br>
			kor[0]=98; kor[1]=94; kor[2]=86; kor[3]=74; kor[4]=54; kor[5]=44; kor[6]=32; kor[7]=20;<br>
			mth[0]=96; mth[1]=88; mth[2]=82; mth[3]=70; mth[4]=70; mth[5]=50; mth[6]=40; mth[7]=25;<br>
			eng[0]=97; eng[1]=94; eng[2]=88; eng[3]=83; eng[4]=75; eng[5]=55; eng[6]=43; eng[7]=26;<br>
		}<br>
		if(type == 2) { // 불물물<br>
			kor[0]=90; kor[1]=82; kor[2]=72; kor[3]=60; kor[4]=52; kor[5]=40; kor[6]=28; kor[7]=6;<br>
			mth[0]=96; mth[1]=88; mth[2]=82; mth[3]=70; mth[4]=70; mth[5]=50; mth[6]=40; mth[7]=25;<br>
			eng[0]=97; eng[1]=94; eng[2]=88; eng[3]=83; eng[4]=75; eng[5]=55; eng[6]=43; eng[7]=26;<br>
		}<br>
		if(type == 3) { // 물불물<br>
			kor[0]=98; kor[1]=94; kor[2]=86; kor[3]=74; kor[4]=54; kor[5]=44; kor[6]=32; kor[7]=20;<br>
			mth[0]=72; mth[1]=68; mth[2]=54; mth[3]=48; mth[4]=44; mth[5]=30; mth[6]=24; mth[7]=11;<br>
			eng[0]=97; eng[1]=94; eng[2]=88; eng[3]=83; eng[4]=75; eng[5]=55; eng[6]=43; eng[7]=26;<br>
		}<br>
		if(type == 4) { // 물물불<br>
			kor[0]=98; kor[1]=94; kor[2]=86; kor[3]=74; kor[4]=54; kor[5]=44; kor[6]=32; kor[7]=20;<br>
			mth[0]=96; mth[1]=88; mth[2]=82; mth[3]=70; mth[4]=70; mth[5]=50; mth[6]=40; mth[7]=25;<br>
			eng[0]=88; eng[1]=83; eng[2]=75; eng[3]=64; eng[4]=55; eng[5]=42; eng[6]=32; eng[7]=12;<br>
		}<br>
		if(type == 5) { // 불불물<br>
			kor[0]=90; kor[1]=82; kor[2]=72; kor[3]=60; kor[4]=52; kor[5]=40; kor[6]=28; kor[7]=6;<br>
			mth[0]=72; mth[1]=68; mth[2]=54; mth[3]=48; mth[4]=44; mth[5]=30; mth[6]=24; mth[7]=11;<br>
			eng[0]=97; eng[1]=94; eng[2]=88; eng[3]=83; eng[4]=75; eng[5]=55; eng[6]=43; eng[7]=26;<br>
		}<br>
		if(type == 6) { // 불물불<br>
			kor[0]=90; kor[1]=82; kor[2]=72; kor[3]=60; kor[4]=52; kor[5]=40; kor[6]=28; kor[7]=6;<br>
			mth[0]=96; mth[1]=88; mth[2]=82; mth[3]=70; mth[4]=70; mth[5]=50; mth[6]=40; mth[7]=25;<br>
			eng[0]=88; eng[1]=83; eng[2]=75; eng[3]=64; eng[4]=55; eng[5]=42; eng[6]=32; eng[7]=12;<br>
		}<br>
		if(type == 7) { // 물불불<br>
			kor[0]=98; kor[1]=94; kor[2]=86; kor[3]=74; kor[4]=54; kor[5]=44; kor[6]=32; kor[7]=20;<br>
			mth[0]=72; mth[1]=68; mth[2]=54; mth[3]=48; mth[4]=44; mth[5]=30; mth[6]=24; mth[7]=11;<br>
			eng[0]=88; eng[1]=83; eng[2]=75; eng[3]=64; eng[4]=55; eng[5]=42; eng[6]=32; eng[7]=12;<br>
		}<br>
		if(type == 8) { // 불불불<br>
			kor[0]=90; kor[1]=82; kor[2]=72; kor[3]=60; kor[4]=52; kor[5]=40; kor[6]=28; kor[7]=6;<br>
			mth[0]=72; mth[1]=68; mth[2]=54; mth[3]=48; mth[4]=44; mth[5]=30; mth[6]=24; mth[7]=11;<br>
			eng[0]=88; eng[1]=83; eng[2]=75; eng[3]=64; eng[4]=55; eng[5]=42; eng[6]=32; eng[7]=12;<br>
		}<br>
<br>
		int changedKor, changedMth, changedEng;<br>
<br>
		changedKor = me.kor/((month-3)*(month-2));<br>
		changedMth = me.mth/((month-3)*(month-2));<br>
		changedEng = me.eng/((month-3)*(month-2));<br>
		<br>
		if(me.mayFirstPen==true) {<br>
			changedKor += (int) Math.random()*2;<br>
			changedMth += (int) Math.random()*2;<br>
			changedEng += (int) Math.random()*2;<br>
		}<br>
		if(me.julSecondPen==true) {<br>
			changedKor += (int) Math.random()*3;<br>
			changedMth += (int) Math.random()*3;<br>
			changedEng += (int) Math.random()*3;<br>
		}<br>
		if(me.sepThirdPen==true) {<br>
			changedKor += (int) Math.random()*5;<br>
			changedMth += (int) Math.random()*5;<br>
			changedEng += (int) Math.random()*5;<br>
		}<br>
<br>
		int korGrade, mthGrade, engGrade;<br>
		int korCent = 0, mthCent=0, engCent = 0;<br>
<br>
		if(changedKor &gt;= kor[0])<br>
			korGrade = 1;<br>
		else if(changedKor&gt;= kor[1])<br>
			korGrade = 2;<br>
		else if(changedKor&gt;= kor[2])<br>
			korGrade = 3;<br>
		else if(changedKor&gt;= kor[3])<br>
			korGrade = 4;<br>
		else if(changedKor&gt;= kor[4])<br>
			korGrade = 5;<br>
		else if(changedKor&gt;= kor[5])<br>
			korGrade = 6;<br>
		else if(changedKor&gt;= kor[6])<br>
			korGrade = 7;<br>
		else if(changedKor&gt;= kor[7])<br>
			korGrade = 8;<br>
		else <br>
			korGrade = 9;<br>
<br>
		if(changedMth &gt;= mth[0])<br>
			mthGrade = 1;<br>
		else if(changedMth&gt;= mth[1])<br>
			mthGrade = 2;<br>
		else if(changedMth&gt;= mth[2])<br>
			mthGrade = 3;<br>
		else if(changedMth&gt;= mth[3])<br>
			mthGrade = 4;<br>
		else if(changedMth&gt;= mth[4])<br>
			mthGrade = 5;<br>
		else if(changedMth&gt;= mth[5])<br>
			mthGrade = 6;<br>
		else if(changedMth&gt;= mth[6])<br>
			mthGrade = 7;<br>
		else if(changedMth&gt;= mth[7])<br>
			mthGrade = 8;<br>
		else <br>
			mthGrade = 9;<br>
<br>
		if(changedEng &gt;= eng[0])<br>
			engGrade = 1;<br>
		else if(changedEng&gt;= eng[1])<br>
			engGrade = 2;<br>
		else if(changedEng&gt;= eng[2])<br>
			engGrade = 3;<br>
		else if(changedEng&gt;= eng[3])<br>
			engGrade = 4;<br>
		else if(changedEng&gt;= eng[4])<br>
			engGrade = 5;<br>
		else if(changedEng&gt;= eng[5])<br>
			engGrade = 6;<br>
		else if(changedEng&gt;= eng[6])<br>
			engGrade = 7;<br>
		else if(changedEng&gt;= eng[7])<br>
			engGrade = 8;<br>
		else <br>
			engGrade = 9;<br>
<br>
		if(korGrade == 1) {<br>
			korCent = 96 + (int) (changedKor/kor[0])*4 - 4;<br>
			if(korCent&gt;100) korCent = 100;<br>
		} else if (korGrade == 2)<br>
			korCent = 89 + (int) (changedKor/kor[1])*7 - 7;<br>
		else if (korGrade == 3)<br>
			korCent = 77 + (int) (changedKor/kor[2])*12 - 12;<br>
		else if (korGrade == 4)<br>
			korCent = 60 + (int) (changedKor/kor[3])*17 - 17;<br>
		else if (korGrade == 5)<br>
			korCent = 40 + (int) (changedKor/kor[4])*20 - 20;<br>
		else if (korGrade == 6)<br>
			korCent = 23 + (int) (changedKor/kor[5])*17 - 17;<br>
		else if (korGrade == 7) <br>
			korCent = 11 + (int) (changedKor/kor[6])*12 - 12;<br>
		else if (korGrade == 8)<br>
			korCent = 4 + (int) (changedKor/kor[7])*7 - 7;<br>
		else if (korGrade == 9)<br>
			korCent = (int) (changedKor/kor[7])*4 - 4;<br>
<br>
		if(mthGrade == 1) {<br>
			mthCent = 96 + (int) (changedMth/mth[0])*4 - 4;<br>
			if(mthCent&gt;100) mthCent = 100;<br>
		} else if (mthGrade == 2)<br>
			mthCent = 89 + (int) (changedMth/mth[1])*7 - 7;<br>
		else if (mthGrade == 3)<br>
			mthCent = 77 + (int) (changedMth/mth[2])*12 - 12;<br>
		else if (mthGrade == 4)<br>
			mthCent = 60 + (int) (changedMth/mth[3])*17 - 17;<br>
		else if (mthGrade == 5)<br>
			mthCent = 40 + (int) (changedMth/mth[4])*20 - 20;<br>
		else if (mthGrade == 6)<br>
			mthCent = 23 + (int) (changedMth/mth[5])*17 - 17;<br>
		else if (mthGrade == 7) <br>
			mthCent = 11 + (int) (changedMth/mth[6])*12 - 12;<br>
		else if (mthGrade == 8)<br>
			mthCent = 4 + (int) (changedMth/mth[7])*7 - 7;<br>
		else if (mthGrade == 9)<br>
			mthCent = (int) (changedMth/mth[7])*4 - 4;<br>
<br>
		if(engGrade == 1) {<br>
			engCent = 96 + (int) (changedEng/eng[0])*4 - 4;<br>
			if(engCent&gt;100) engCent = 100;<br>
		} else if (engGrade == 2)<br>
			engCent = 89 + (int) (changedEng/eng[1])*7 - 7;<br>
		else if (engGrade == 3)<br>
			engCent = 77 + (int) (changedEng/eng[2])*12 - 12;<br>
		else if (engGrade == 4)<br>
			engCent = 60 + (int) (changedEng/eng[3])*17 - 17;<br>
		else if (engGrade == 5)<br>
			engCent = 40 + (int) (changedEng/eng[4])*20 - 20;<br>
		else if (engGrade == 6)<br>
			engCent = 23 + (int) (changedEng/eng[5])*17 - 17;<br>
		else if (engGrade == 7) <br>
			engCent = 11 + (int) (changedEng/eng[6])*12 - 12;<br>
		else if (engGrade == 8)<br>
			engCent = 4 + (int) (changedEng/eng[7])*7 - 7;<br>
		else if (engGrade == 9)<br>
			engCent = (int) (changedEng/eng[7])*4 - 4;<br>
<br>
		if(!(month==11)) {<br>
			try {<br>
				Thread.sleep(5000);<br>
			} catch (InterruptedException e) {<br>
				e.printStackTrace();<br>
			}<br>
			System.out.println(month + "월의 성적표입니다.");<br>
			System.out.println("언어:  " + korGrade + "등급" + " / 백분위  " + korCent);<br>
			System.out.println("수리:  " + mthGrade + "등급" + " / 백분위  " + mthCent);<br>
			System.out.println("외국어:  " + engGrade + "등급" + " / 백분위  " + engCent);<br>
			<br>
			if(korCent+mthCent+engCent &gt;= 296) {<br>
				System.out.println("매우 우수한 성적이시군요!!");<br>
				System.out.println("보상: 10 만원 + 용돈: 추가 만 원");<br>
				me.money += 10;<br>
				me.allowance++;<br>
			} else if(korCent+mthCent+engCent &gt;= 291) {<br>
				System.out.println("우수한 성적을 받았습니다!");<br>
				System.out.println("보상: 5 만원");<br>
				me.money += 5;<br>
			} else if(korCent+mthCent+engCent &gt;= 288) {<br>
				System.out.println("조금만 더 노력하면 최상위권이 될 것같습니다!");<br>
				System.out.println("보상: 3 만 원");<br>
				me.money += 3;<br>
			} else {<br>
				System.out.println("수고하셨습니다!");<br>
			}<br>
			<br>
		} else {<br>
			try {<br>
				Thread.sleep(5000);<br>
			} catch (InterruptedException e) {<br>
				e.printStackTrace();<br>
			}<br>
			System.out.println("과연 최종 결과는??!?");<br>
			try {<br>
				Thread.sleep(1000);<br>
			} catch (InterruptedException e) {<br>
				e.printStackTrace();<br>
			}<br>
			System.out.println("");<br>
			System.out.println("2012 대학수학능력검정시험 성적표입니다.");<br>
			System.out.println("언어:  " + korGrade + "등급" + " / 백분위  " + korCent);<br>
			System.out.println("수리:  " + mthGrade + "등급" + " / 백분위  " + mthCent);<br>
			System.out.println("외국어:  " + engGrade + "등급" + " / 백분위  " + engCent);<br>
		}<br>
	}<br>
<br>
	static void endTime(Time time) {<br>
		time.day++;<br>
		time.dow++;<br>
		if (time.day == 31) {<br>
			time.month++;<br>
		}<br>
		if (time.dow == 8) {<br>
			time.dow = 1;<br>
		}<br>
		try {<br>
			Thread.sleep(1000);<br>
		} catch (InterruptedException e) {<br>
			e.printStackTrace();<br>
		}<br>
	}<br>
<br>
} // class 끝<br>
<br>
<br>
</code></pre>
<br>
이 클래스는 메인 메소드를 갖고 있습니다. 처음에 게임 소개글이 뜨고, DotCom 게임과 같이 반복문을 통해 플레이어가 한 턴 한 턴을 보낼 수 있게 합니다. <br>

<b>main(String<a href='.md'>.md</a> args)</b>: 이 프로그램을 전반적으로 통제하고있는 메인함수입니다. <br>
<b>static void takeCard(Card<a href='.md'>.md</a> hand, Status me)</b>: 패(hand)에 카드의 랜덤한 값을 옮겨서 패를 배정해줍니다. <br>
<b>static void showTime(Time time)</b>: 시간 정보를 출력해줍니다. <br>
<b>static void messageOfHpMoney(Status me)</b>: 행동력과 돈 정보를 출력해줍니다.<br>
<b>static void showCard(Card<a href='.md'>.md</a> hand, Status me)</b>: 패로 들어온 카드를 보여줍니다. <br>
<b>static int ordering (Card<a href='.md'>.md</a> hand, Status me)</b>: 보여준 카드를 실질적으로 사용하게 도와주는 메소드입니다. useCard가 안에 들어있습니다. 반환하는 int는 턴을 마칠 때까지 카드를 사용하게 할 수 있도록 특정 숫자가 올때까지 반복하기위해 쓰이는 값입니다.<br>
<b>static void shop(Status me, Time time)</b>: 일요일마다 가능한 가게에 관한 메소드들 입니다.<br>
<b>static Card cardSelection(int GRADE, int randkind)</b>: takeCard 메소드에 랜덤한 값을 주는 메소드입니다. <br>
<b>static String nameCard(Card hand)</b>: 카드의 이름을 붙여주는 메소드입니다. <br>
<b>static void useCard(Card hand, Status me)</b>: 패에 들어온 카드를 택해서 사용하거나 하루를 넘깁니다. <br>
<b>static void prepareTest(int month, Status me)</b>: 매달 마지막 목요일에 치르는 모의고사에 관한 메소드입니다. <br>
<b>void endTime()</b>: 하루가 끝나고 시간 관련 인스턴스 변수들을 다음 날로 처리 해줍니다. <br>
<br>

<b>b) Status.java</b><br>

<pre><code><br>
package myJongroStory020;<br>
<br>
<br>
<br>
public class Status {<br>
	String name = "임채원";<br>
	public int kor = 100; // 언어<br>
	public int mth = 100; // 수리<br>
	public int eng = 100; // 외국어<br>
	<br>
	public int hp_MAX = 30; // 행동력 최대치<br>
	public int hp = 30; // 행동력<br>
	<br>
	public int money = 10; // 자금<br>
	public int allowance = 3; // 용돈<br>
	<br>
	<br>
	// 카드 강화 현황<br>
	<br>
	<br>
	// 아이템 구입 현황<br>
	<br>
	public static boolean fourthSlot = false; // 4번째 슬롯<br>
	public static boolean fifthSlot = false; // 5번째 슬롯	<br>
	<br>
	public static boolean aprActionJumpingRope = false;<br>
	public static boolean aprBasicPMP = false; <br>
	<br>
	public static boolean maySmartPhone = false; <br>
	public static boolean mayFirstPen = false; <br>
	<br>
	public static boolean junNormalPMP = false; <br>
	public static boolean junPigSave = false; <br>
	<br>
	public static boolean julSecondPen = false; <br>
	public static boolean julCookingSet = false; <br>
	<br>
	public static boolean augMusicPlayer = false; <br>
	public static boolean augIcePack = false; <br>
	<br>
	public static boolean sepThirdPen = false; <br>
	public static boolean sepMasterPMP = false; <br>
	<br>
	public static boolean octGodKnowledge = false; <br>
	public static boolean octParentKnowledge = false; <br>
	<br>
}<br>
<br>
<br>
</code></pre>

게임 내 주인공 캐릭터의 능력치와 자금 현황을 표기합니다. <br>
첫 정식 버전에서 아이템에 관련된 변수들이 추가되었습니다. <br>

<b>c) Time.java</b> <br>

<pre><code><br>
package myJongroStory020;<br>
<br>
public class Time {<br>
	public int month = 4;<br>
	public int day = 4; // 4월 4일 (월요일)에 시작 11월 10일 (목요일)에 끝	<br>
	public int dow = 1; // 1 -&gt; 월요일, 2 -&gt; 화요일, ..., 7 -&gt; 일요일 (Day of Week)<br>
<br>
}<br>
<br>
</code></pre>

0.10 버전의 Status에 있던 시간 관련 변수들을 따로 보관하게 했습니다. <br>
가독성이 좋아졌습니다. <br>

<b>d) CardData.java</b> <br>

<pre><code><br>
public class CardData {<br>
	// 각 카드의 능력치를 나타내는 class다.<br>
<br>
	/* 언어, 수리, 외국어 기본적인 능력치를 올려주는 카드들 */<br>
	/* k1~3, m1~3, e1~3 (총 9 종류) */<br>
<br>
	// k1. 언어 기본<br>
	public static void korBasic (Status me, Card hand) {<br>
		if(me.hp &lt; 15) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("언어 능력이 " + me.kor + " → ");<br>
			me.kor += 10;<br>
			me.hp -= 15;<br>
			System.out.println(me.kor);<br>
		}<br>
	}<br>
<br>
	// k2. 언어 보충<br>
	public static void korNormal (Status me, Card hand) {<br>
		if(me.hp &lt; 30) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("언어 능력이 " + me.kor + " → ");<br>
			me.kor += (int)(Math.random()*16)+15;<br>
			me.hp -= 30;<br>
			System.out.println(me.kor);<br>
		}<br>
	}<br>
<br>
	// k3. 언어 심화<br>
	public static void korMaster (Status me, Card hand) {<br>
		if(me.hp &lt; 50) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("언어 능력이 " + me.kor + " → ");<br>
			me.kor += (int)(Math.random()*51)+50;<br>
			me.hp -= 50;<br>
			System.out.println(me.kor);<br>
		}<br>
	}<br>
<br>
	// m1. 수리 기본<br>
	public static void mthBasic (Status me, Card hand) {<br>
		if(me.hp &lt; 15) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("수리 능력이 " + me.mth + " → ");<br>
			me.mth += 10;<br>
			me.hp -= 15;<br>
			System.out.println(me.mth);<br>
		}<br>
	}<br>
<br>
	// m2. 수리 보충<br>
	public static void mthNormal (Status me, Card hand) {<br>
		if(me.hp &lt; 30) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("수리 능력이 " + me.mth + " → ");<br>
			me.mth += (int)(Math.random()*16)+15;<br>
			me.hp -= 30;<br>
			System.out.println(me.mth);<br>
		}<br>
	}<br>
<br>
	// m3. 수리 심화<br>
	public static void mthMaster (Status me, Card hand) {<br>
		if(me.hp &lt; 50) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("수리 능력이 " + me.mth + " → ");<br>
			me.mth += (int)(Math.random()*51)+50;<br>
			me.hp -= 50;<br>
			System.out.println(me.mth);<br>
		}<br>
	}<br>
<br>
	// e1. 외국어 기본<br>
	public static void engBasic (Status me, Card hand) {<br>
		if(me.hp &lt; 15) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("외국어 능력이 " + me.eng + " → ");<br>
			me.eng += 10;<br>
			me.hp -= 15;<br>
			System.out.println(me.eng);<br>
		}<br>
	}<br>
<br>
	// e2. 외국어 보충<br>
	public static void engNormal (Status me, Card hand) {<br>
		if(me.hp &lt; 30) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("외국어 능력이 " + me.eng + " → ");<br>
			me.eng += (int)(Math.random()*16)+15;<br>
			me.hp -= 30;<br>
			System.out.println(me.eng);<br>
		}<br>
	}<br>
<br>
	// e3. 외국어 심화<br>
	public static void engMaster (Status me, Card hand) {<br>
		if(me.hp &lt; 50) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("외국어 능력이 " + me.eng + " → ");<br>
			me.eng += (int)(Math.random()*51)+50;<br>
			me.hp -= 50;<br>
			System.out.println(me.eng);<br>
		}<br>
	}<br>
<br>
	/* 다른 능력치에 관여하는 카드들 */<br>
	/* */<br>
<br>
	// h1. 운동 기본<br>
	public static void hpBasic (Status me, Card hand) {<br>
		if(me.hp &lt; 30) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("최대 행동력이 " + me.hp_MAX + " → ");<br>
			me.hp -= 30;<br>
			me.hp_MAX += (int)(Math.random()*6);<br>
			System.out.println(me.hp_MAX);<br>
		}<br>
	}<br>
<br>
	// h2. 운동 보충<br>
	public static void hpNormal (Status me, Card hand) {<br>
		if(me.hp &lt; 50) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("최대 행동력이 " + me.hp_MAX + " → ");<br>
			me.hp -= 50;<br>
			me.hp_MAX += (int)(Math.random()*6)+10;<br>
			System.out.println(me.hp_MAX);<br>
		}<br>
	}<br>
<br>
	// h3. 운동 심화<br>
	public static void hpMaster (Status me, Card hand) {<br>
		if(me.hp &lt; 100) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			System.out.print("최대 행동력이 " + me.hp_MAX + " → ");<br>
			me.hp -= 100;<br>
			me.hp_MAX += (int)(Math.random()*16)+15;<br>
			System.out.println(me.hp_MAX);<br>
		}<br>
	}<br>
<br>
	// s1. 복권 구입<br>
	public static void lottery (Status me, Card hand) {<br>
		if(me.money &lt; 1) {<br>
			System.out.println("돈이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			me.money -= 1;<br>
			int p=0;<br>
			int randomforlottery = (int)(Math.random()*100)+1;<br>
<br>
			if(randomforlottery&lt;=50) // 꽝 50%<br>
				p = 0;<br>
			if( (randomforlottery&gt;=51) &amp;&amp; (randomforlottery&lt;=85) ) // 본전 35%<br>
				p = 1;<br>
			if( (randomforlottery&gt;=86) &amp;&amp; (randomforlottery&lt;=95) ) // 3만원 10%<br>
				p = 2;<br>
			if( (randomforlottery&gt;=96) &amp;&amp; (randomforlottery&lt;=99) ) // 10만원 4%<br>
				p = 3;<br>
			if(randomforlottery == 100) // 100만원 1%<br>
				p = 4;<br>
<br>
			switch(p) {<br>
			case 0: me.money += 0; System.out.println("꽝!"); break;<br>
			case 1: me.money += 1; System.out.println("본전 따셨네요ㅠ"); break;<br>
			case 2: me.money += 3; System.out.println("삼만원 따셨습니다!"); break;<br>
			case 3: me.money += 10; System.out.println("십만원 따셨어요 +_+"); break;<br>
			case 4: me.money += 100; System.out.println("백만원 따셨습니다... 돈 더 필요없어!!"); break;<br>
			} // switch 끝<br>
		}<br>
	}<br>
<br>
	// s2. 아르바이트기본<br>
	public static void albaBasic (Status me, Card hand) {<br>
		if(me.hp &lt; 30) {<br>
			System.out.println("행동력이 부족합니다.");<br>
			hand.isUsed = false;<br>
		} else {<br>
			me.money += 1;<br>
			me.hp -= 30;<br>
			System.out.println("배식 누나를 도와서 만원을 벌었습니다 ^^;;");<br>
		}<br>
<br>
	}<br>
<br>
} // end class<br>
<br>
	<br>
} // end class<br>
<br>
<br>
</code></pre>


0.20 버전에서 새로 추가된 클래스 입니다. <br>
0.20 버전의 카드 시스템에 사용될 카드들의 효과를 모아 놓은 클래스입니다. <br>
각 메소드들은 하나의 행동을 나타냅니다. 여기 메소드들의 자세한 설명은 <b>공략</b> 부분에 설명하도록 하겠습니다. <br>

<b>e) Card.java</b> <br>

<pre><code><br>
public class Card {<br>
	boolean isUsed = false; // 패에서 쓰인 카드인가?<br>
	int value; // 1등급, 2등급, 3등급 (높을수록좋다)<br>
	int cardnum; // 카드의 번호<br>
	String name = new String();<br>
}<br>
<br>
</code></pre>

카드 한 장 한 장의 정보를 담을 클래스입니다. 카드 자체의 능력을 제외하고는 모든 카드의 정보를 담습니다. <br>
첫 정식 버전에서 덱에서 카드를 넣었다 뺏다하는 기능을 넣지 않기로 했기 때문에 isSelected와 isExist를 삭제해습니다. <br>

<b>f) NameList.java</b> <br>

<pre><code>public class NameList{<br>
	<br>
	// 1등급<br>
	static Card korBasic;<br>
	static Card mthBasic;<br>
	static Card engBasic;<br>
	static Card hpBasic;<br>
	// 4개<br>
	<br>
	<br>
	// 2등급<br>
	static Card korNormal;<br>
	static Card mthNormal;<br>
	static Card engNormal;<br>
	static Card hpNormal;<br>
	// 4개<br>
	<br>
	<br>
	// 3등급<br>
	static Card korMaster;<br>
	static Card mthMaster;<br>
	static Card engMaster;<br>
	static Card hpMaster;<br>
	static Card lottery;<br>
	static Card albaBasic;<br>
	// 6개<br>
}<br>
<br>
</code></pre>

위의 Card 클래스와 연계되어 있으며 카드들의 종류를 보여줍니다. <br>
첫 정식 버전에서는 덱의 느낌보다는 단순히 가지고 있는 카드의 리스트와 비슷한 느낌을 주어서 클래스 이름을 아예 이름 목록이란 뜻의 NameList라고 바꾸었습니다. <br>

<h1>패치노트</h1>

<b>v 1.00</b>

첫 정식 버전이 나왔습니다. <br>
게임의 방식은 0.20 버전과 크게 다른 것이 없습니다. 전 버전과 다른 점을 나열해 보겠습니다. <br>

<b>★ 게임 외적인 부분</b>

○ ''Deck' 클래스의 이름을 'NameList'로 변경'<br>
○ '값과 상관 없는 숫자를 눌렀을 때 경고나 무시되고 다시 입력을 받는 시스템 도입'<br>
○ '많은 것들을 메소드를 이용해 소스의 양을 줄임'<br>

<b>★ 게임 내적인 부분</b>

○ '사용 가능한 카드의 갯수가 5개에서 3개(아이템을 이용해 5개까지 이용가능)로 변경'<br>
○ '총 16 종류의 아이템 구현'<br>
○ '카드를 덱에서 넣었다 뺏다하고 구입하는 방식에서 기존 카드를 강화시켜가는 방식 채택 (단, 강화시키는 것은 아직 구현하지 못함)'<br>
○ '매달 마지막 목요일에 모의고사를 침'<br>
○ '매주 일요일에는 아이템을 사거나 카드를 강화할 수 있음'<br>
○ '하루가 지나거나 중요한 이벤트를 놓지지 않도록 잠시 시간을 멈추게 하는 메소드를 넣어 좀 더 게임의 가독성을 높임'<br>

<b>★ 알려진 버그</b>

○ '카드 중에서 복권구입이 어떤 컴퓨터에서는(제작자의 집 컴퓨터) 작동하지 않고, 어떤 컴퓨터에서는(라이시움) 작동함' <br>
○ '의도하지 않은 숫자를 넣으면 알아서 검열해주지만, 의도하지 않은 숫자가 아닌 문자를 넣으면 예외 오류가 뜸' <br>

<b>v 0.20</b>

0.10 버전을 구현하려고 했으나, 게임이 단순히 능력치만 올리는 루즈한 게임이 될 것으로 예상되어 게임의 큰 틀은 유지하되, 진행 방법을 조금 더 흥미롭게 하기 위해서 하루하루 행동력을 이용하는 방법을 바꿈. <br>
(일주일 모두 거의 똑같은 패턴의 방법을 바꾸고 마치 카드놀이를 하듯 할 수 있는 행동을 랜덤하게 설정하고 고를 수 있는 것도 제한적으로 하려고 함) <br>
<br>
○ '0.10 버전에서 구현하려고 했던 것들을 다시 새로운 시스템에 맞춰 구현' <br>
○ 'GameMenu 클래스의 필요성이 사려져서 삭제' <br>
○ 'Time 클래스 추가 (Status의 시간 관련 변수를 따로 처리)' <br>
○ 'CardData 클래스 추가 (새로운 카드 시스템 관련 클래스)' <br>
○ 'Card 클래스 추가' <br>
○ 'Deck 클래스 추가' <br>

<b>v 0.10</b>

가장 초기버전인 0.10 버전에서는 <br>
<br>
○ '하루하루 행동력 최대로 올린 다음 하루를 시작' <br>
○ '행동을 하면 행동력을 감소' <br>
○ '특정 행동을 하면 특정 능력치가 증가 혹은 감소' <br>
○ '11월 10일이 되면 게임을 종료' <br>
○ GUI 기반이 아닌 단순히 입력을 통해 옛날의 머드게임과 같은 버전을 먼저 만드는 것을 목표로 함 <br>
<br>
을 구현 시키는 것이 목표입니다. <br>

Download <br>
<a href='http://comp166-koreauniv.googlecode.com/files/2012190731.zip'>http://comp166-koreauniv.googlecode.com/files/2012190731.zip</a><br>