# Introduction #

같은그림을 맞추는 게임입니다.

# Details #

1.게임을 실행하면 6X6 모양의 정사각형이 나옵니다.

2.그림의 종류는 6종류이며 같은 그림이 6장씩 랜덤으로 배치됩니다.

3.처음 그림은 모두 가려져 있습니다.

4.플레이어가 방향키를 이용하여 그림을 선택하면 그림이 보여집니다.

5.하나의 그림이 보여진 상태에서 다른그림을 선택하면
  1. 짝이 맞을때: 점수가 올라가며 선택한 그림은 사라집니다.
> 2) 짝이 맞지 않을때: 두 그림 모두 가려진 상태로 돌아갑니다.

6. 5번을 반복하여 모든 그림이 사라지면 게임이 종료되며
> 점수와 연속으로 맞춘 그림의 수, 찾을때까지 그림을 선택한 횟수 가 보여집니다

점수계산방식: 연속으로 맞출때마다 10, 20, 30... 점으로 점수가 늘어납니다.

# code #

```
public class  FindPair
{
	public static void main(String[] args) 
	{
		FindPair p = new FindPair();
	}
}


class menu
{
	start();
	load();
	help();
}

class boad
{
	boad();
	pictures();

}

class game
{
	click();
	grade();
	save();
}

class result
{
	score();
}
```