#2011190721 오세원

# Introduction #

어지럽게 얽혀있는 박스 사이에 있는 특정한 박스를 탈출 시키는 게임입니다.

# Details #

class game:게임을 시작하고 장소를 정하고 등등 메인문이 들어갈 클래스입니다.
class rule:게임의 규칙을 정해줍니다.
class box: 박스를 설정해줍니다.
class stage:게임이 펼쳐질 장소를 설정해줍니다.


public class game{
public static void main (String[.md](.md) args) {

> Gamestart game = new game();

> int current;

> game.stage(); //스테이지를 고름.
> game.start(); //게임을 시작함.

> for{ ; 게임이 종료될때까지(어떻게 해야할지 몰라여 ; }
> {
> > if(reset)
> > > game.reset();

> > if(pause)
> > > game.pause();

> > if(start)
> > > game.start();

> > if(stop)
> > > game.stop();

> > if(next)
> > {
> > > current++;
> > > next = false;

> > }

> }

> public void start(){

> }
> public void stage() {



> system.out.println("난이도를선택해주세요");

> 선택방법 미정;

> call.Stage[current](current.md);

> }
> public void reset(){
> > call.Stage[current](current.md);
> > reset = false;

> }
> public void pause(){

> 박스를 움직이지 못하게끔..
> }
> public void start(){
> > if(pause){
> > > 다시시작
> > > pause=false;

> > }
> > else
> > > 스테이지를 고르게끔..

> }
> public void stop(){
> > 게임을 끝냄.

> }


> }
}

public class rule{

> boolean reset = false;
> boolean pause = false;
> boolean start = false;
> boolean stop = false;
> boolean next = false;



}

public class box{

> Box Hbox = new Box();
> Box Vbox = new Box();
> Box Tbox = new Box();
> // Hbox 는 상하 Vbox는 좌우로만 움직일수 있고 Tbox는 탈출시켜야하는 목표박스, 좌우로만 움직일수 있다.
}

public class stage{

> Stage[.md](.md) stage = new Stage[30](30.md);

> Stage[0](0.md) =
> Stage[1](1.md) =

..//이런식으로 스테이지를 꾸민다.


}