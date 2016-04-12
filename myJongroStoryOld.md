#summary 2012190731 임채원의 자바 프로젝트 홈페이지입니다.



# 프로젝트 설명 (0.20 기반) #

기본적인 프로젝트의 작동 방법은 수업시간에 했던 DotCom게임처럼 (DotCome게임에서는) 한 턴마다 예상지점에 공격을 했듯, 이 프로젝트는 한 턴 대신 하루동안 자신의 행동력을 최대한 이용해서 카드를 사용합니다. 이를 통해 능력치를 향상시키고 결국 수능에서 좋은 점수를 받는 것을 목표로 합니다.<br>
<br>
다음은 주요 클래스에 대한 설명입니다. <br>
<br>

<b>a) PlayJongro.java</b> <br>

<br>
<pre><code><br>
package myJongroStory020;<br>
<br>
import java.util.Scanner;<br>
<br>
public class PlayJongro {<br>
	<br>
	public static void main(String[] args) {<br>
		<br>
		Status me = new Status();<br>
		Time time = new Time();<br>
		CardData card = new CardData();<br>
		<br>
		Card[] hand = new Card[5];<br>
		for(int i=0; i&lt;5; i++)<br>
			hand[i] = new Card();<br>
		<br>
		Deck deck = new Deck();<br>
		// 기본으로 가지고 있는 카드<br>
		// (언수외 기본 + 운동 기본 + 복권)<br>
//		deck.korBasic.isExist = true;<br>
//		deck.korBasic.isSelected = true;<br>
//		deck.mthBasic.isExist = true;<br>
//		deck.mthBasic.isSelected = true;<br>
//		deck.engBasic.isExist = true;<br>
//		deck.engBasic.isSelected = true;<br>
//		deck.hpBasic.isExist = true;<br>
//		deck.hpBasic.isSelected = true;<br>
//		deck.lottery.isExist = true;<br>
//		deck.lottery.isSelected = true;<br>
		<br>
		// 1등급, 2등급, 3등급 카드 갯수<br>
		int GRADE_1 = 4;<br>
		int GRADE_2 = 4;<br>
		int GRADE_3 = 5;<br>
		<br>
		<br>
		System.out.println("My Jongro Story를 플레이 해주셔서 감사합니다!");<br>
		System.out.println("게임을 시작합니다!");<br>
		System.out.println("자세한 사항은 http://code.google.com/p/comp166-koreauniv/wiki/myJongroStory를 참조하세요.");<br>
		<br>
		// 4월 (4일[月]~30일) <br>
		while(time.month == 4) {<br>
			// 카드를 새로 지급 받는다. takeCard<br>
			for(int i=0; i&lt;5; i++) {<br>
				int randvalue = (int)(Math.random()*100)+1; // 1~50: 1등급, 51~85: 2등급, 86~100: 3등급<br>
				if(randvalue &lt;= 50) {<br>
					int randkind = (int)(Math.random()*GRADE_1)+1;<br>
					hand[i] = cardSelection(1, randkind);<br>
					// 1등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 85) {<br>
					int randkind = (int)(Math.random()*GRADE_2)+1;<br>
					hand[i] = cardSelection(2, randkind);<br>
					// 2등급 카드를 랜덤하게 받는다.<br>
				} else if (randvalue &lt;= 100) {<br>
					int randkind = (int)(Math.random()*GRADE_3)+1;<br>
					hand[i] = cardSelection(3, randkind);<br>
					// 3등급 카드를 랜덤하게 받는다.<br>
				} <br>
			} // for 끝<br>
			<br>
			// 지급된 카드를 보여준다. (반복) showCard<br>
			int selectHand;<br>
			do {<br>
				System.out.println(time.month + "/" + time.day + " 당신의 패입니다.");<br>
				if(!hand[0].isUsed)<br>
					System.out.println("1: " + hand[0].name);<br>
				if(!hand[1].isUsed)<br>
					System.out.println("2: " + hand[1].name);<br>
				if(!hand[2].isUsed)<br>
					System.out.println("3: " + hand[2].name);<br>
				if(!hand[3].isUsed)<br>
					System.out.println("4: " + hand[3].name);<br>
				if(!hand[4].isUsed)<br>
					System.out.println("5: " + hand[4].name);<br>
				System.out.println("0: 집에 간다(턴을 끝낸다)" );<br>
				// 카드를 사용한다. (반복) useCard<br>
				System.out.println("명령을 내려주세요.");<br>
				Scanner sc = new Scanner(System.in);<br>
				selectHand = sc.nextInt();<br>
				switch (selectHand) {<br>
					case 1: useCard(hand[0], me);<br>
							hand[0].isUsed = true;<br>
							break;<br>
					case 2: useCard(hand[1], me);<br>
							hand[1].isUsed = true;<br>
							break;<br>
					case 3: useCard(hand[2], me);<br>
							hand[2].isUsed = true;<br>
							break;<br>
					case 4: useCard(hand[3], me);<br>
							hand[3].isUsed = true;<br>
							break;<br>
					case 5: useCard(hand[4], me);<br>
							hand[4].isUsed = true;<br>
							break;<br>
					case 0: // 턴을 넘긴다.<br>
				} // switch 끝<br>
			} while ( !( selectHand == 0) );<br>
			<br>
			if (time.dow == 7) { // 일요일<br>
				// 새로운 카드를 덱에 추가할 수 있다. buyCard v0.3에 구현<br>
				// 덱의 구성 카드를 바꿀 수 있다. changeCard v0.3에 구현<br>
			me.money += 100000;<br>
			}<br>
			// 마지막 목요일에는 모의고사를 친다. // prepareTest v0.3에 구현<br>
			<br>
			// 하루를 마무리 endTime <br>
			endTime(time);<br>
			<br>
			me.hp = me.hp_MAX; // 행동력 회복<br>
		}<br>
		<br>
		// 5월<br>
		while(time.month == 5) {<br>
		}<br>
		<br>
		// 6월<br>
		while(time.month == 6) {<br>
		}<br>
		<br>
		// 7월<br>
		while(time.month == 7) {<br>
		}<br>
		<br>
		// 8월<br>
		while(time.month == 8) {<br>
		}<br>
		<br>
		// 9월<br>
		while(time.month == 9) {<br>
		}<br>
		<br>
		// 10월<br>
		while(time.month == 10) {<br>
		}<br>
		<br>
		// 11월<br>
		while(time.month == 11) {<br>
		}<br>
		<br>
		// 엔딩<br>
		<br>
	} // main 끝<br>
	<br>
	void takeCard () {   // 카드를 새로 지급 받는다.<br>
		///////// 패에 든 카드는 무슨 변수를 써야하지???<br>
	} // takeCard 끝<br>
	<br>
	static Card cardSelection (int GRADE, int randkind) {<br>
		switch(GRADE) {<br>
			case 1: switch(randkind) {<br>
						case 1: return Deck.korBasic; <br>
						case 2: return Deck.mthBasic; <br>
						case 3: return Deck.engBasic; <br>
						case 4: return Deck.hpBasic;<br>
			} // GRADE == 1 ends<br>
			case 2: switch(randkind) {<br>
						case 1: return Deck.korNormal;<br>
						case 2: return Deck.mthNormal;<br>
						case 3: return Deck.engNormal;<br>
						case 4: return Deck.hpNormal;<br>
			} // GRADE == 2 ends<br>
			case 3: switch(randkind) {<br>
						case 1: return Deck.korMaster;<br>
						case 2: return Deck.mthMaster;<br>
						case 3: return Deck.engMaster;<br>
						case 4: return Deck.hpMaster;<br>
						case 5: return Deck.lottery;<br>
			} // GRADE == 3 ends<br>
		}<br>
		return null;<br>
	}<br>
	<br>
	<br>
	<br>
	void showCard() {   // 지급된 카드를 보여준다.<br>
		<br>
	}<br>
	<br>
	static void useCard(Card hand, Status me) {   // 카드를 사용한다.<br>
		if (hand == Deck.korBasic)<br>
			CardData.korBasic(me);<br>
		if (hand == Deck.mthBasic)<br>
			CardData.mthBasic(me);<br>
		if (hand == Deck.engBasic)<br>
			CardData.engBasic(me);<br>
		if (hand == Deck.hpBasic)<br>
			CardData.hpBasic(me);<br>
<br>
		<br>
		if (hand == Deck.korNormal)<br>
			CardData.korNormal(me);<br>
		if (hand == Deck.mthNormal)<br>
			CardData.mthNormal(me);<br>
		if (hand == Deck.engNormal)<br>
			CardData.engNormal(me);<br>
		if (hand == Deck.hpNormal)<br>
			CardData.hpNormal(me);<br>
		<br>
		<br>
		if (hand == Deck.korMaster)<br>
			CardData.korMaster(me);<br>
		if (hand == Deck.mthMaster)<br>
			CardData.mthMaster(me);<br>
		if (hand == Deck.engMaster)<br>
			CardData.engMaster(me);<br>
		if (hand == Deck.hpMaster)<br>
			CardData.hpMaster(me);<br>
		if (hand == Deck.lottery)<br>
			CardData.lottery(me);<br>
	}<br>
	<br>
	void buyCard() {  // 새로운 카드를 덱에 추가할 수 있다.<br>
		<br>
	}<br>
	<br>
	void changeCard() {   // 덱의 구성 카드를 바꿀 수 있다.<br>
		<br>
	}<br>
	<br>
	void prepareTest() {  // 마지막 목요일에는 모의고사를 친다.<br>
		<br>
	}<br>
	<br>
	static void endTime(Time time) {<br>
		time.day++; <br>
		time.dow++; <br>
		if(time.day == 31) {<br>
			time.month++;<br>
		}<br>
		if(time.dow == 8) {<br>
			time.dow = 1;<br>
		}<br>
	}<br>
	<br>
	<br>
	<br>
} // class 끝<br>
<br>
<br>
<br>
<br>
</code></pre>
<br>
이 클래스는 메인 메소드를 갖고 있습니다. 처음에 게임 소개글이 뜨고, DotCom 게임과 같이 반복문을 통해 플레이어가 한 턴 한 턴을 보낼 수 있게 합니다. <br>

main(String<a href='.md'>.md</a> args): 이 프로그램을 전반적으로 통제하고있는 메인함수입니다. <br>
void takeCard(): 덱에서 카드를 랜덤하게 패로 옮깁니다. <br>
void showCard(): 패로 들어온 카드를 보여줍니다. <br>
void useCard(): 패에 들어온 카드를 택해서 사용하거나 하루를 넘깁니다. <br>
void buyCard(): <code>v0.3에서 구현예정 새로운 카드를 덱에 추가합니다.</code> <br>
void changeCard(): <code>v0.3에서 구현예정 덱의 카드 구성을 바꿉니다.</code> <br>
void prepareTest(): <code>v0.3에서 구현예정 모의고사를 치룹니다.</code> <br>
void endTime(): 하루가 끝나고 시간 관련 인스턴스 변수들을 다음 날로 처리 해줍니다. <br>
<br>

<b>b) Status.java</b><br>

<pre><code><br>
package myJongroStory020;<br>
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
	public double money = 100000; // 자금<br>
	<br>
}<br>
<br>
</code></pre>

게임 내 주인공 캐릭터의 능력치와 자금 현황을 표기합니다. <br>

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
package myJongroStory020;<br>
<br>
public class CardData {<br>
	// 각 카드의 능력치를 나타내는 class다.<br>
	<br>
	/* 언어, 수리, 외국어 기본적인 능력치를 올려주는 카드들 */<br>
	/* k1~3, m1~3, e1~3 (총 9 종류) */<br>
	<br>
	// k1. 언어 기본<br>
	public static void korBasic (Status me) {<br>
		me.kor += 10;<br>
		me.hp -= 15;<br>
	}<br>
	<br>
	// k2. 언어 보충<br>
	public static void korNormal (Status me) {<br>
		me.kor += (int)(Math.random()*16)+15;<br>
		me.hp -= 30;<br>
	}<br>
	<br>
	// k3. 언어 심화<br>
	public static void korMaster (Status me) {<br>
		me.kor += (int)(Math.random()*51)+50;<br>
		me.hp -= 50;<br>
	}<br>
	<br>
	// m1. 수리 기본<br>
	public static void mthBasic (Status me) {<br>
		me.mth += 10;<br>
		me.hp -= 15;<br>
	}<br>
	<br>
	// m2. 수리 보충<br>
	public static void mthNormal (Status me) {<br>
		me.mth += (int)(Math.random()*16)+15;<br>
		me.hp -= 30;<br>
	}<br>
	<br>
	// m3. 수리 심화<br>
	public static void mthMaster (Status me) {<br>
		me.mth += (int)(Math.random()*51)+50;<br>
		me.hp -= 50;<br>
	}<br>
	<br>
	// e1. 외국어 기본<br>
	public static void engBasic (Status me) {<br>
		me.eng += 10;<br>
		me.hp -= 15;<br>
	}<br>
	<br>
	// e2. 외국어 보충<br>
	public static void engNormal (Status me) {<br>
		me.eng += (int)(Math.random()*16)+15;<br>
		me.hp -= 30;<br>
	}<br>
	<br>
	// e3. 외국어 심화<br>
	public static void engMaster (Status me) {<br>
		me.eng += (int)(Math.random()*51)+50;<br>
		me.hp -= 50;<br>
	}<br>
<br>
	/* 다른 능력치에 관여하는 카드들 */<br>
	/* */<br>
	<br>
	// h1. 운동 기본<br>
	public static void hpBasic (Status me) {<br>
		me.hp -= 30;<br>
		me.hp_MAX += (int)(Math.random()*6);<br>
	}<br>
	<br>
	// h2. 운동 보충<br>
	public static void hpNormal (Status me) {<br>
		me.hp -= 50;<br>
		me.hp_MAX += (int)(Math.random()*6)+10;<br>
	}<br>
	<br>
	// h3. 운동 심화<br>
	public static void hpMaster (Status me) {<br>
		me.hp -= 100;<br>
		me.hp_MAX += (int)(Math.random()*16)+15;<br>
	}<br>
	<br>
	// s1. 복권 구입<br>
	public static void lottery (Status me) {<br>
		me.money -= 5000;<br>
		int randomforlottery = (int)(Math.random()*5);<br>
		switch(randomforlottery) {<br>
			case 0: me.money += 0; break;<br>
			case 1: me.money += 5000; break;<br>
			case 2: me.money += 30000; break;<br>
			case 3: me.money += 100000; break;<br>
			case 4: me.money += 1000000; break;<br>
		} // switch 끝<br>
	}<br>
	<br>
} // end class<br>
<br>
<br>
</code></pre>

0.20 버전에서 새로 추가된 클래스 입니다. <br>
0.20 버전의 카드 시스템에 사용될 카드들의 효과를 모아 놓은 클래스입니다. <br>

<b>e) Card.java</b> <br>

<pre><code><br>
package myJongroStory020;<br>
<br>
class Card {<br>
	boolean isExist = false; // 덱에 있는가?<br>
	boolean isSelected = false; // 패로 나올수 있는가?<br>
	boolean isUsed = false; // 패에서 쓰인 카드인가?<br>
	int value; // 1등급, 2등급, 3등급 (높을수록좋다)<br>
	int cardnum; // 카드의 번호<br>
	String name = new String();<br>
}<br>
<br>
</code></pre>

카드 한 장 한 장의 정보를 담을 클래스입니다. 카드 자체의 능력을 제외하고는 모든 카드의 정보를 담습니다. <br>

<b>f) Deck.java</b> <br>

<pre><code>package myJongroStory020;<br>
<br>
class Deck{<br>
	<br>
	// 1등급<br>
	Card korBasic;<br>
	Card mthBasic;<br>
	Card engBasic;<br>
	Card hpBasic;<br>
	// 4개<br>
	<br>
	<br>
	// 2등급<br>
	Card korNormal;<br>
	Card mthNormal;<br>
	Card engNormal;<br>
	Card hpNormal;<br>
	// 4개<br>
	<br>
	<br>
	// 3등급<br>
	Card korMaster;<br>
	Card mthMaster;<br>
	Card engMaster;<br>
	Card hpMaster;<br>
	Card lottery;<br>
	// 5개<br>
<br>
<br>
	<br>
<br>
}<br>
<br>
</code></pre>

위의 Card 클래스와 연계되어 있으며 카드들의 종류를 보여줍니다. <br>

<h1>패치노트</h1>

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



<h1>프로젝트 설명 (0.10 기반)</h1>

기본적인 프로젝트의 작동 방법은 수업시간에 했던 DotCom게임처럼 (DotCome게임에서는) 한 턴마다 예상지점에 공격을 했듯, 이 프로젝트는 한 턴 대신 하루, 공격 대신에 행동력을 이용해 특정 행동을 하고 행동력을 모두 소모하면 하루를 넘겨 또 다른 하루를 갖는 것입니다. <br>
<br>
다음은 주요 클래스에 대한 설명입니다. <br>
<br>

<b>a) PlayJongro.java</b> <br>

<br>
<pre><code><br>
public class PlayJongro {<br>
	<br>
	static GameMenu gm = new GameMenu();<br>
	<br>
	public static void main(String[] args) {<br>
		System.out.println("My Jongro Story를 플레이 해주셔서 감사합니다!");<br>
		<br>
		gm.setUpGame();<br>
		gm.startPlaying();<br>
		<br>
	}<br>
}<br>
<br>
</code></pre>
<br>
이 클래스는 메인 메소드를 갖고 있습니다. 메인 메소드안에는 DotCom게임과 같이 게임을 초기세팅해주는 setUpGame 메소드와 startPlaying 메소드가 있습니다. 자세한 설명은 GameMenu 클래스에서 하겠습니다. <br>

main(String<a href='.md'>.md</a> args): 이 프로그램을 전반적으로 통제하고있는 메인함수입니다.<br>
<br>

<b>b) GameMenu.java</b> <br>
<br>
<pre><code><br>
import java.util.Scanner;<br>
<br>
public class GameMenu {<br>
	<br>
	Status me = new Status();<br>
	<br>
	public void gameOfDay() {<br>
		<br>
		if(me.dow == 1) {<br>
		<br>
			System.out.println("★왠지 언어를 공부하고 싶은 월요일입니다!★");<br>
			System.out.println();<br>
			System.out.println("오늘은 무엇을 할까...? (남은 행동력: " + me.hp + ")" );<br>
			System.out.println("§ 1. 언어 수업을 듣는다. (행동력 10 소모) ");<br>
			System.out.println("§ 2. 매점을 간다. (돈 2000 소모) ");<br>
			System.out.println("§ 3. 자습을 한다. (행동력 20 소모) ");<br>
			System.out.println("§ 9. 집에 간다. (하루가 지남. 행동력 회복) ");<br>
			<br>
			Scanner sc = new Scanner(System.in);<br>
			int value = sc.nextInt();<br>
			<br>
			switch (value) {<br>
				case 1: me.kor += 10; break;<br>
				<br>
				case 2: me.money -= 2000; break;<br>
				<br>
				case 3: <br>
							System.out.println("어떤 과목 자습을 할까요?");<br>
							System.out.println("1. 언어");<br>
							System.out.println("2. 수리");<br>
							System.out.println("3. 외국어");<br>
							value = sc.nextInt();<br>
							<br>
							switch (value) {<br>
								case 1: me.kor += 15; break;<br>
								case 2: me.mth += 15; break;<br>
								case 3: me.eng += 15; break;<br>
							} break;<br>
							<br>
				case 9: me.hp = me.hp_MAX;<br>
						 me.month++; me.day++; me.dow++;<br>
			}<br>
			<br>
		} // 우선 월요일까지만 구현<br>
<br>
	public void setUpGame() { // 아직 미구현<br>
                                     <br>
		<br>
	}<br>
<br>
	public void startPlaying() { // 아직 미구현<br>
	<br>
		<br>
	}<br>
	<br>
} // 클래스 끝<br>
<br>
</code></pre>
이 클래스는 전반적인 게임을 실행시키는 것을 목적으로 갖고 있습니다.<br>
<br>
gameOfDay(): 각 날마다 플레이어에게 선택지를 출력해서 보여주고 플레이어에게 선택지를 입력받아서 행동력이나 돈을 소모해서 어떠한 행동을 하게 만들어주는 메소드입니다.<br>

setUpGame(): 기본적으로 게임을 초기화 세팅시켜주는 메소드입니다. DotCom게임을 기반으로 생각해서 일단 넣었으나 제작과정에서 초기화 세팅이 필요없다고 생각되면 삭제할 생각입니다.<br>

startPlaying(): DotCom게임의 반복문(while)을 사용해서 계속 게임을 진행했듯, 이 게임도 날짜가 10월10일이 될 때까지 계속 gameOfDay 메소드를 반복시켜 게임을 진행시킬 예정입니다. 그 반복문이 들어있는 메소드입니다.<br>

<b>c) Status.java</b><br>

<pre><code>public class Status {<br>
	String name = "임채원";<br>
	int kor = 100; // 언어<br>
	int mth = 100; // 수리<br>
	int eng = 100; // 외국어<br>
	<br>
	int hp_MAX = 30; // 행동력 최대치<br>
	int hp = 30; // 행동력<br>
	<br>
	double money = 100000; // 자금<br>
	<br>
	int month = 4;<br>
	int day = 4; // 4월 4일 (월요일)에 시작 11월 10일 (목요일)에 끝	<br>
	int dow = 1; // 1 -&gt; 월요일, 2 -&gt; 화요일, ..., 7 -&gt; 일요일 (Day of Week)<br>
}<br>
</code></pre>

게임 내 주인공 캐릭터의 능력치를 표기합니다. 능력치 뿐만 아니라 날짜 개념, 자금 현황까지 나타내주고 있습니다. 그런데 아직 개발단계라서 날짜 개념을 능력치에 넣을지 분리 시켜서 기록할지 고민하고 있는데 굳이 분리 시키지 않아도 아무런 문제가 없고 인스턴스 변수의 통제를 쉽게하기 위해 그냥 같은 클래스 안에다가 넣었습니다.<br>




<h1>Details</h1>

Add your content here.  Format your content with:<br>
<ul><li>Text in <b>bold</b> or <i>italic</i>
</li><li>Headings, paragraphs, and lists<br>
</li><li>Automatic links to other wiki pages