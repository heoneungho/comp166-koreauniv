2011190727 김성운

# Introduction #

블랙젯 게임으로 바꿨습니다. Blackjack game = 숫자 21에 가까울 수록 이기는 게임 카드 두장을 미리 받고 User와 Dealer의 21에 가까워지면 이기는 게임입니다. 돈걸어서 딜러가 파산나면 이기는 게임형식으로 진행했습니다.

# Background #

씨언어와 지금 배우고있는 중인 자바를 활용해서 이 프로젝트를 완성해 평가받아야 하기 때문이다.

# Detail #
사실 쉬운 줄 알았는데 입력받는 것이랑 카드 결과랑 돈의 여부를 주고 하는 것 때문에 코딩이 복잡했고 너무 힘들었습니다.

이 게임을 만들기 위한 클래스

BlackJack{} = 블랙잭 게임을 실행시키는 메인 클래스
Card{} = 카드의 문양을 넣는 클래스
Cards{} = 카드 배열 선언(A ~ K), A, J, Q, K의 숫자 값 11이나 10을 설정하는 클래스
CardSet{} = 카드 중복이 되지않게 선언하고 카드갯수 52개와 랜덤으로 뽑는 것을 설정하는 클래스

이 게임을 위한 함수

BlackJack{} 내의 함수
BlackJack() = 블랙잭의 객체 선언과 기본요소 초기화 및 블랙잭 게임을 실행
init() = 초기화시킨다.
callGame() = 게임실행을 불러온다.
startGame() = 게임을 시작시킨다.
showMoney() = 보유한 금액을 보여준다.
showCard() = 보유한 카드를 보여준다.
getValue() = 문자열 카드의 가치를 때때마다 조정시켜주는 함수
getResult() = 유저와 딜러의 승부를 결정해주는 함수
InputMoney() = 보유금액을 확인해주고 걸 수있는 정도의 돈을 유저가 설정할 수 있게 도와주는 함수
InputString() = 가장 중요한 함수. 입력을 받아주는 함수
getMoney() = 돈을 가져온다.
Help() = 도움말을 보여주는 함수
addMoney() = 돈을 더해준다.
minusMoney() = 돈을 빼준다.
addCard() = 카드를 더해준다.
initCard() = 승부마다 카드를 초기화 해준다.

남은 클래스의 함수들은 따로 화면을 보여주며 설명함.


# Using Code #

import java.io.BufferedReader; // 자바의 입출력 받기 위한 것
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector; // Vector 요소의 사용을 위해 가져옴

public class BlackJack {
> private CardSet card = null; // 값들을 초기화 시킨다.

> private User dealer = null;
> private User user = null;

> private int basicMoney = 10000; // 기본 돈을 10000원으로 한 것
> private boolean justTwoCards = false;

> BlackJack() {

> String inputStr = "";
> while(true)	{
> > try	{
> > > inputStr = inputString("도움말을 보시겠습니까??(Y/N)");


> if (inputStr.equals("") | inputStr.equals("Y") || inputStr.equals("y"))|
|:---------------------|
> > Help();

> else if (inputStr.equals("N") || inputStr.equals("n"))
> > init();

> else {
> > System.out.println("Y/N 중에 고르세요(Enter == Continue)");
> > }

> } catch (IOException e) {
> System.out.println("다시입력하세요.");
> continue;
> > }

> }
> }

> private void init() {

> dealer = new User("Dealer", basicMoney **20);	// 딜러의 돈은 유저의 20배
> user = new User("User", basicMoney);**

> System.out.println("Dealer is ready. coin = " + dealer.getMoney());
> System.out.println("Player is ready. coin = " + user.getMoney());

> String inputStr = "";
> while (true) {
> > try {
> > > inputStr = inputString("2장으로 승부를 결정하시겠습니까?? (Y/N)"); // 2장인지 여러 장으로 승부 볼 지 물어본다.


> if (inputStr.equals("") | inputStr.equals("Y") || inputStr.equals("y")) {|
|:---------------------|
> > System.out.println("2장으로 승부를 결정합니다.");
> > justTwoCards = true;
> > break;

> } else if (inputStr.equals("N") || inputStr.equals("n")) {
> > System.out.println("여러 장으로 승부를 결정합니다.");
> > justTwoCards = false;
> > break;

> } else {
> > System.out.println("Y/N 중에 고르세요(Enter == Continue)");

> }
> } catch (IOException e) {
> > System.out.println("다시입력하세요.");
> > continue;

> }
> }
> callGame();
> }

> private void initCard() {
> > dealer.initCard();
> > user.initCard();

> }

> private void callGame() {

> do {
> > startGame();
> > if (user.getMoney() > 0 && dealer.getMoney() > 0) {
> > > String inputStr = "";
> > > while (true) {
> > > > try {
> > > > > inputStr = inputString("계속하시겠습니까? (Y/N)");


> if (inputStr.equals("") | inputStr.equals("Y") || inputStr.equals("y")) {|
|:---------------------|
> > System.out.println("Continue.");
> > break;

> } else if (inputStr.equals("N") || inputStr.equals("n")) {
> > System.out.println("Game End.");
> > System.exit(0);

> } else {
> > System.out.println("Y/N 중에 고르세요(Enter == Continue)");

> }
> } catch (IOException e) {
> > System.out.println("다시 입력하세요.");
> > continue;

> }
> }
> } else {
> > if (user.getMoney() == 0) {
> > > System.out.println("Game Over!");

> > } else {
> > > System.out.println("Player Win!!");

> > }
> > break;

> }
> } while (true);
> }

> private void startGame() {
> > int betting = 0;


> card = new CardSet();

> initCard();

> while (true) {
> > try {


> betting = inputMoney(false);
> user.minusMoney(betting);
> System.out.println("총 배팅액  : " + betting);

> user.addCard(card.getRamdomCard());
> dealer.addCard(card.getRamdomCard());

> showCard(true);

> if (user.getMoney() > 0) {
> > int addMoney = inputMoney(true);
> > if (addMoney > 0) {
> > > betting += addMoney;
> > > user.minusMoney(addMoney);
> > > System.out.println("총 배팅액  : " + betting);

> > }

> }

> do {

> if (!justTwoCards) {
> > String inputStr = "";


> if (getValue(user.getCard()) < 21) {

> if (user.getCard().size() >= 2) {
> > while (true) {
> > > try {
> > > > showCard(false);
> > > > inputStr = inputString("카드를 더 받으시겠습니까? (Y/N)");


> if (inputStr.equals("") | inputStr.equals("Y") | inputStr.equals("y") || inputStr.equals("N")|
|:---------------------|:---------------------|
> > || inputStr.equals("n")) {
> > break;

> } else {
> > System.out.println("Y/N 중에 고르세요(Enter == Continue)");

> }
> } catch (IOException e) {
> > System.out.println("다시 입력하세요.");
> > continue;

> }
> }
> }

> if (inputStr.equals("") | inputStr.equals("Y") || inputStr.equals("y")) {|
|:---------------------|

> while (getValue(dealer.getCard()) < 17) {
> > dealer.addCard(card.getRamdomCard());

> }
> user.addCard(card.getRamdomCard());
> continue;
> } else if (inputStr.equals("N") || inputStr.equals("n")) {
> > break;

> } else {
> > System.out.println("Error!");

> }
> } else {
> > break;

> }

> } else {
> > user.addCard(card.getRamdomCard());
> > dealer.addCard(card.getRamdomCard());
> > break;

> }
> } while (true);

> showCard(getResult(betting));
> showMoney();

> } catch (NumberFormatException e) {
> > System.out.println("숫자만 입력하셔야 합니다.");
> > continue;

> } catch (IOException e) {
> > System.out.println("잘못 입력하셨습니다.");
> > continue;

> }
> // if( dealer.getMoney() <= 0 || user.getMoney() <= 0)
> break;
> }

> }

> private void showMoney() {
> > System.out.println("=================");
> > System.out.println("딜러 잔고 = " + dealer.getMoney());
> > System.out.println("플레이어 잔고  = " + user.getMoney());
> > System.out.println("=================");

> }

> private void showCard(boolean isDealerCardShow) {

> Vector dealerCard = dealer.getCard(); //딜러가 카드를 받을 때 교수님이 말씀하신부분의 오류를 없애줘요
> System.out.print("딜러 카드  : ");
> if (justTwoCards || isDealerCardShow) {
> > for (int i = 0; i < dealerCard.size(); i++) {
> > > System.out.print(((Card) dealerCard.get(i)).getCardName() + " ");

> > }
> > System.out.println("합 = " + getValue(dealer.getCard()));

> } else {
> > System.out.print(((Card) dealerCard.get(0)).getCardName() + "\n");

> }

> Vector userCard = user.getCard();
> System.out.print("유저 카드  : ");
> for (int i = 0; i < userCard.size(); i++) {
> > System.out.print(((Card) userCard.get(i)).getCardName() + " ");

> }
> System.out.println("합  = " + getValue(user.getCard()));
> }

> private int getValue(Vector card) { // Vector는 배열 비슷한 것으로 데이터를 저장하기 위한  것

> int i = 0;
> int value = 0;
> int aceCount = 0;

> for (i = 0; i < card.size(); i++) {
> > value += ((Card) card.get(i)).getCardValue();
> > if (((Card) card.get(i)).getCardValue() == 1) {
> > > aceCount++;

> > }

> }

> for (i = 0; i < aceCount; i++) {
> > if (value <= 11) {
> > > aceCount--;
> > > value += 10;

> > }

> }
> return value;
> }

> private boolean getResult(int bettingMoney) {

> int dealerValue = getValue(dealer.getCard());
> int userValue = getValue(user.getCard());

> if (userValue > 21 || (dealerValue <= 21 && userValue < 21 && dealerValue > userValue)) {

> System.out.println("Dealer Win!");
> dealer.addMoney(bettingMoney);
> if (userValue > 21) {
> > return false;

> } else {
> > return true;

> }
> } else if (userValue > dealerValue || dealerValue > 21) {
> > System.out.println("Player Win!!");


> dealer.minusMoney(bettingMoney);
> user.addMoney(bettingMoney **2);
> return true;
> } else if (userValue == dealerValue) {
> > System.out.println("무승부");
> > user.addMoney(bettingMoney);
> > return true;

> } else {
> > showCard(true);
> > System.out.println("조건이 성립 안 됨.");
> > return true;

> }
> }**

> private int inputMoney(boolean isMore) throws IOException, NumberFormatException {

> int betting = 0;
> BufferedReader br = null;
> do {

> System.out.print((isMore ? "추가 " : "") + "배팅액을 입력하세요 (보유 금액  : " + user.getMoney() + "): ");
> br = new BufferedReader(new InputStreamReader(System.in));
> String tmp = br.readLine().trim();
> betting = Integer.parseInt(tmp.equals("") ? "0" : tmp);

> if (betting < 1) {
> > if (isMore) {
> > > betting = 0;
> > > break;

> > } else {
> > > System.out.println("금액은 1원 이상 가능합니다.");
> > > betting = 0;

> > }

> } else if (user.getMoney() < betting) {
> > System.out.println("보유금액 이상 배팅 불가능합니다.");
> > betting = 0;

> }
> } while (betting <= 0);

> return betting;
> }

> private String inputString(String msg) throws IOException { // 키보드 입출력을 맞는 함수

> String result = "";
> BufferedReader br = null;

> System.out.print(msg + " : ");
> br = new BufferedReader(new InputStreamReader(System.in));
> result = br.readLine().trim();
> if (result.length() > 0) {
> > result = result.substring(0, 1);

> }
> return result;
> }

> private class User {
> > private String userName = "";
> > private int money = 0;
> > private Vector

&lt;Card&gt;

 card = null;


> User(String name, int money) {
> > this.userName = name;
> > this.money = money;
> > card = new Vector

&lt;Card&gt;

();

> }

> public void initCard() {
> > card.clear();

> }

> public void addCard(Card c) {
> > card.add(c);

> }

> public int getMoney() {
> > return money;

> }

> public void addMoney(int money) {
> > this.money += money;

> }

> public void minusMoney(int money) {
> > this.money -= money;

> }

> public Vector getCard() {
> > return card;

> }
> }

> public void Help()	{
> > System.out.println("블랙젝 하는 방법\n	-블랙잭은 핸디와 딜러가 겨루어서 숫자 21에 가까운 사람이 이기는 게임.\n " +
> > > " - 에이스(A)는 임의적으로 숫자 1이나 11로 사용이 가능. \n -J, Q, K 는 숫자 10으로 통일.\n" + "- 블랙잭은 2장의 카드로 21이 되는 것이기 때문에 A 와 10 으로만 가능.\n"
> > > +	"- 딜러는 17이상이 될 때까지 무조건 패를 받아야 함.\n" + "-Player가 블랙잭인 경우에는 딜러의 패에 상관없이 무조건 승리.");

> > new BlackJack();

> }


> public static void main(String[.md](.md) args) {
> > new BlackJack();

> }
}

public class Card {
> final static String CARD\_SPADE = "Spade";
> final static String CARD\_DIAMOND = "Diamond";
> final static String CARD\_HART = "Hart";
> final static String CARD\_CLOVER = "Clover";

> private String cardName = " ";
> private int cardValue = 0;
> private boolean used = false;

> Card(String type, String name, int value) {
> > this.cardName = type + " " + name;
> > this.cardValue = value;

> }

> public String getCardName() {
> > return cardName;

> }

> public int getCardValue() {
> > return cardValue;

> }

> public boolean getUsed() {
> > return used;

> }

> public void setUsed(boolean tf) {
> > this.used = tf;

> }
> }

import java.util.HashMap;
import java.util.Random;


public class CardSet {
> private Random rn = new Random();

> private int availCount = 52;

> private HashMap<String, Cards> hm = new HashMap<String, Cards>();

> CardSet() {
> > hm.put(Card.CARD\_SPADE, new Cards(Card.CARD\_SPADE));
> > hm.put(Card.CARD\_DIAMOND, new Cards(Card.CARD\_DIAMOND));
> > hm.put(Card.CARD\_HART, new Cards(Card.CARD\_HART));
> > hm.put(Card.CARD\_CLOVER, new Cards(Card.CARD\_CLOVER));

> }

> public Cards getCards(String type) {
> > return hm.get(type);

> }

> public Card getRamdomCard() {
> > Cards cards = null;
> > Card card = null;


> if (getAvailCount() == 0) {
> > return null;

> }

> while (card == null) {

> switch (rn.nextInt(4)) {
> case 0:
> > cards = hm.get(Card.CARD\_SPADE);
> > break;

> case 1:
> > cards = hm.get(Card.CARD\_DIAMOND);
> > break;

> case 2:
> > cards = hm.get(Card.CARD\_HART);
> > break;

> case 3:
> > cards = hm.get(Card.CARD\_CLOVER);
> > break;

> }

> if (cards.getAvailCount() == 0)
> > continue;

> else {
> > card = cards.getRandomCard();
> > if (card != null)
> > > availCount--;

> > return card;

> }
> }
> return null;
> }

> public int getAvailCount() {
> > return availCount;

> }
}

import java.util.Random; // 랜덤으로 가져오는 유틸

public class Cards {
> private Card c[.md](.md) = new Card[13](13.md);
> private int availCount = 13;
> private Random rn = new Random();

> Cards(String type) {	// A, J, Q, K를 숫자로 바꿔주는 함

> int i = 0;
> int value = 1;
> String name = "";

> for (i = 0; i < 13; i++, value++) {

> name = Integer.toString(i + 1);

> if (name.equals("1"))
> > name = "A";

> else if (name.equals("11"))
> > name = "J";

> else if (name.equals("12"))
> > name = "Q";

> else if (name.equals("13"))
> > name = "K";


> c[i](i.md) = new Card(type, name, value > 10 ? 10 : value);
> }
> }

> public Card getRandomCard() { //카드 랜덤

> Card result = c[rn.nextInt(13)];


> if (!result.getUsed()) {
> > availCount--;
> > return result;

> }

> return null;
> }

> public int getAvailCount() {
> > return availCount;

> }
}


# Help #

채정민 교수님 도와주실 거라 믿습니다..........

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages