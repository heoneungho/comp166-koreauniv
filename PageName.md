Introduction

두명의 플레이어가 각자 1부터 100까지의 숫자중에서 하나를 택하여 더 작은 숫자를 택한쪽이 그 숫자만큼의 점수를 얻는다. 총 3번의 시행을 하여 총합이 더 높은쪽이 최종 승자가 되는 게임



Details


public class player1

{
> int sum1;

> Scanner stln = new Scanner(System.in);

> int ax= stdln.nextlnt();

> sum1 = 0;
}

public class player2
{
> int sum2;

> Scanner stln = new Scanner(System.in);

> int ay = stdln.nextlnt();

> sum2 = 0;

}

public class nunchigame
{
> public static void main(String[.md](.md)args)
> {
> > player1 score1 = new player1();


> int m = score1.ax;

> palyer2 socre2 = new player2();

> int n = score2.by;

> int x = 0;

> while(x < 3){

> if( m > n)

> {sum2 = sum2 + n}

> else

> {sum1 = sum1 + m}

> x = x + 1;

}

> if( sum1 > sum2)

> {system.out.print("플레이어 1이 승리했습니다.");}

> else

> {system.out.print("플레이어 2가 승리했습니다.");}

}
}

키보드로 숫자를 입력받는 방법을 정확히 모르겠내요