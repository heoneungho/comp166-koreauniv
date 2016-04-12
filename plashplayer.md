# Introduction #

원래 계획했던 프로그램 대신, 재밌고 신나는 구구단게임을 만들어 보았습니다.
우리 모두 신나고 재밌는 구구단의 세계로 빠져 봅시다~^^

# Details #

import java.io.**;**

class Gugudan

{

private int comnum;

private int result;

public String setComState()

{

comnum = (int)(Math.random()**8 + 1);**

return " **" + comnum + " = ";**

}

public String setResult(int x)

{

result = x **comnum;**

return "정답은 : " + result;

}

public String getTrue(int y)

{

if (result == y)

{

return "정답입니다~ ㅊㅋㅊㅋ";

} else                             //정답시 출력

return "틀렸습니다~ -_-;;";_

};                                 //오답시 출력(+사운드)








public class Gugugame

{

public static void main(String [.md](.md) args) throws Exception{

int b=0,f=0;

String str1,str2;

System.out.print("단을 입력하세요(press 0 to exit) >>");    //0 입력시 게임종료
  1. 단 선택





BufferedReader d = new BufferedReader(new InputStreamReader(System.in));

BufferedReader e = new BufferedReader(new InputStreamReader(System.in));

str1 = d.readLine();

Gugudan g = new Gugudan();



while(!str1.equals("0")){

b = Integer.valueOf(str1).intValue();

System.out.print("입력한 단 : " + b);

System.out.print(g.setComState());

str2 = e.readLine();

f = Integer.valueOf(str2).intValue();

System.out.println(g.setResult(b));

System.out.println(g.getTrue(f));

System.out.println("단을 입력하세요(press 0 to exit)>>");

str1 = d.readLine();

}

System.out.println("재밌었나용?ㅋ");

}                        //게임 종료

}


import javax.sound.midi.**;        //클래스를 하나 더 만들어 소리효과도 추가했습니다**

public class GugugameSound {


> public void play(){

> try {

> Sequencer player = MidiSystem.getSequencer();
> player.open();

> Sequence seq = new Sequence(Sequence.PPQ,4);


> Track track = seq.createTrack();

> ShortMessage a = new ShortMessage();
> a.setMessage(144,1,74,100);
> MidiEvent noteOn = new MidiEvent(a,1);
> track.add(noteOn);


> ShortMessage b = new ShortMessage();
> b.setMessage(128,1,74,100);
> MidiEvent noteOff = new MidiEvent(b,16);
> track.add(noteOff);


> player.setSequence(seq);

> player.start();
> } catch (Exception ex) {
> > ex.printStackTrace();

> }
> }

}