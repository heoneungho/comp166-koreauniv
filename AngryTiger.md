# Introduction #

옛날 옛적 고려시대 이야기입니다.
이상한 새가 자꾸 날아들었습니다.
호랑이는 화가 났습니다.
그 새의 이름은 연새였습니다.

깝치는 연새를 가위바위보로 이겨서 무찌르는 게임입니다.

# Background #

이번 고연전을 계기로 호랑이와 독수리를 이용해 angry bird 게임처럼 간단하면서 재미난 게임을 만들어 보려 합니다.

# Details #

화난 호랑이와 깝치는 연새가 가위바위보를 합니다.
호랑이와 연새는 각각 목숨이 어느정도 있습니다.
이길 경우 상대방의 목숨을 하나 가져갑니다.
비길 경우는 목숨의 변화는 없습니다.
질 경우 목숨을 하나 뺏깁니다.

# Using the Code #

Class : player, GameLauncher, AngryTiger

Player class를 만들고 AngryTiger와 StupidEagle 객체를 만듭니다.

life로 Player의 목숨 상태를 나타냅니다.

RockScissorsPaper(RSP, 가위바위보) 함수를 만들어 가위바위보 게임을 표현합니다.

GameLauncher class로 실행파일을 만듭니다.



public class Gamelauncher {

> public static void main (String[.md](.md) args) {

> AngryTiger game = new AngryTiger();

> game.Startgame();

> }

}



public class player {

> int life = 5;

> player AngryTiger = new player(name, life);

> player StupidEagle = new player(name, life);

> public void RSP() {

> //플레이어의 가위바위보 담당.

> int Rock;

> int Scissors;

> int Paper;

> }

}

public class AngryTiger {

> //게임 진행 class

}

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages