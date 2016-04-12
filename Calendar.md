Introduction
11월달의 달력을 만들어서 요일과 일을 적고 그 날의 스케쥴을 적고 수정할 수 있도록 한다.




Details
스케쥴의 입력뿐만아니라 수정까지 가능하고 또 주단위와 월단위로 스케쥴을 정리할수 있는 프로그램을 만들 예정입니다
11월달의 달력을 만들고 각각의 일에 메모를 할수있도록

클래스목록:Day , Week , Time, PlanForTime, PlanForDay, PlanForWeek

> class Day {
String name;
> > public static void main(String[.md](.md) args) {
DayOfNovember [.md](.md) day = new DayOfNovember[30](30.md);
int z = 0;

while(z < 30) {
day[z](z.md) = new DayOfNovember();
day[z](z.md) = z+1;
z++;

> }
> }
}
class Week {
> > String name;
public static void main(String [.md](.md) args) {
WeekOfNovember [.md](.md) week = new WeekOfNovember[5](5.md);
week[0](0.md).name = "첫번째주“;
week[1](1.md).name = "두번째주“;
week[2](2.md).name = "세번째주“;
week[3](3.md).name = "네번째주“;
week[4](4.md).name = "다섯번째주“;

<week[0](0.md)에는 1~5일, week[1](1.md)에는 6~12, week[2](2.md)에는 13~19,
week[3](3.md)에는 20~26, week[4](4.md)에는 27~30일이 속해있음 > 아직 코드못짰어요.


}
}
class Time {
TimeOfDay [.md](.md) time = new TimeOfDay[4](4.md);
time[0](0.md).



class PlanForDay {
각day에 대해 new DayOfNovember선언

그것을 이용하여 day의 내용(plan)을 적는다

}

class PlanForWeek{

각 week에 대해 new WeekOfNovember선언

그것을 이용하여 week의 내용(plan)을 적는다

}

밑에 두 개의 class는 아직 어떻게 짜야할지 잘 모르겠어요 .. ㅠㅠ
