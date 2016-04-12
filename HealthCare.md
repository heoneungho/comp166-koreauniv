2011190708 서현아-HealthCare
# Introduction #
가장 큰 idea는 건강과 질병입니다.
여러가지 category로 나눠서 연령대 별로 주의 해야하는 건강에 대해
주기적인 수치로 나타내 꾸준히 파악할 수 있도록 하는게 목적입니다.



# Details #

1) BMI 지수를 통한 비만도 측정
2) 복부비만도 측정
3) 비만 예방책과 BMI에 대한 설명



# Background #
12살 차이나는 동생이 자라는 것을 지켜보면서 얼마나 성장하고 있는지, 앞으로 얼마나 클지 수치로 확인하고 싶은 생각으로 이 프로그램을 구상했습니다. 또한 요즘 건강에
관심이 많은 사람들이 증가하고 있는 만큼 충분히 유용한 프로그램이라고 판단했습니다.

# Code #
클래스 목록 : BMI\_Test, AbdomObesity, Cure

1) public class BMI\_Test
> state : 자신의 키, 몸무게, 주기
> > method (1) 정상체중 출력 : 키를 통해 정상 체중 계산, 출력
> > > (2) 비만도 출력 : BMI지수를 계산하여 출력
> > > (3) 비만 범위 측정 : 비만도를 계산하여 저체중, 정상, 과체중,비만 중 어디에 속하는지 알려줌


2) public static AbdomObesity

> state : 허리둘레, 엉덩이둘레
> > method : 복부비만도 계산하여 출력

3) public class Cure

> method: (1)prescription : 비만을 예방할 수 있는 방법 제시
> > (2)explanation : BMI가 무엇인지에 대한 정보 제공

# Actual Code #
package javaTerm;

import java.awt.**;**

import java.awt.event.**;**

import javax.swing.**;**

public class BMI\_Test extends JFrame implements ActionListener
{

> double height,weight;

> TextField in\_height,in\_weight,reBMI,reWe;

> TextArea ta;

> Button enter,reset;

> String BMI\_Result;


> BMI\_Test(){

> setLayout(new GridLayout(2,1,5,5));

> JPanel p1=new JPanel();


> p1.setBackground(Color.pink);

p1.setLayout(new BorderLayout());

> p1.add(new Label("Input heigh(kg)/weight(cm) and push RESULT button."),"North");


> JPanel p11=new JPanel();

> p11.setBackground(Color.pink);

> p11.add(new Label("Height(cm): "));

> in\_height=new TextField(5);

> p11.add(in\_height);


> p11.add(new Label("Weight(kg): "));

> in\_weight=new TextField(5);

> p11.add(in\_weight);

> p1.add(p11,"Center");



> JPanel p12=new JPanel();

> p12.setBackground(Color.pink);

> JButton enter =new JButton("RESULT");

> JButton reset =new JButton("AGAIN");

> enter.addActionListener(this);

> reset.addActionListener(this);



> p12.add(enter);

> p12.add(reset);

> p1.add(p12,"South");

> add(p1);







JPanel p2=new JPanel();

p2.setLayout(new BorderLayout());

p2.add(new Label("----------- BMI RESULT ------------"),"North");

JPanel p21=new JPanel();

p21.add(new Label("RATE(BMI):"));

reBMI=new TextField(5);

p21.add(reBMI);

p21.add(new Label("NORMAL WEIGHT(kg):"));

reWe=new TextField(5);

p21.add(reWe);

p21.add(new Label("Result of your state is?"));

ta=new TextArea(3,22);

p21.add(ta);



p2.add(p21,"Center");



add(p2);

in\_height.requestFocus();



addWindowListener(new WindowAdapter() {


> public void windowClosing(WindowEvent we) {

System.exit(0);

}

});

}





public void actionPerformed(ActionEvent ae) {

String s=ae.getActionCommand();





if(s=="RESULT"){



height=Double.valueOf(in\_height.getText()).doubleValue();


double N\_weight = (height - 100)**0.9;**


height=height/100;

System.out.println(height);

weight=Double.valueOf(in\_weight.getText()).doubleValue();



double BMI = Math.round(weight/(height **height));**

String re=BMI\_Check(BMI);

reBMI.setText(""+BMI);

reWe.setText(""+N\_weight);

ta.setText(re);

}else{

in\_height.setText("");

in\_weight.setText("");

}

}

public String BMI\_Check(double BMI){

if(BMI<20)

BMI\_Result="Under weight!!";

else if(20<=BMI && BMI<25)

BMI\_Result="You are absolutely normal!";

else if(25<=BMI&& BMI<30)

BMI\_Result="You are overweight!!";

else if(BMI<=30)

BMI\_Result="You are obese!!!!";

return BMI\_Result;
}

public static void main(String[.md](.md) args)

{

BMI\_Test bmi=new BMI\_Test();

bmi.show();

bmi.setSize(400,300);



AbdomObe abdomObe=new AbdomObe();

abdomObe.show();

abdomObe.setSize(400,300);




Cure gui = new Cure();

//gui.show();

//gui.setSize(400,300);

gui.go();

}

}



ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ





package javaTerm;



import java.awt.**;**

import java.awt.event.**;**

import javax.swing.**;**



public class AbdomObe extends JFrame implements ActionListener{



> double hip, waist;

> TextField in\_hip,in\_waist, reRate,reWe;

> TextArea ta;

> JButton enter,reset,cure;

> String AO\_Result;



> AbdomObe(){

> setLayout(new GridLayout(2,1,5,5));



> JPanel p1=new JPanel();

> p1.setBackground(Color.yellow);

> p1.setLayout(new BorderLayout());

> p1.add(new Label("Input waist/hip(cm) and push RESULT
button!"),"North");



> JPanel p11=new JPanel();

> p11.setBackground(Color.yellow);

> p11.add(new Label("waist(cm): "));

> in\_waist=new TextField(5);

> p11.add(in\_waist);



> Label l=new Label("hip(cm): ");

> p11.add(l);

> in\_hip=new TextField(5);

> p11.add(in\_hip);

> p1.add(p11,"Center");

> JPanel p12=new JPanel();

> p12.setBackground(Color.yellow);

> JButton enter =new JButton("RESULT");

> JButton reset =new JButton("AGAIN");



> enter.addActionListener(this);

> reset.addActionListener(this);





> p12.add(enter);

> p12.add(reset);



> p1.add(p12,"South");

> add(p1);











> JPanel p2=new JPanel();

> p2.setLayout(new BorderLayout());

> p2.add(new Label("----------- Abdomen Obesity ------------"),"North");

> JPanel p21=new JPanel();

> p21.add(new Label("Rate of Ab.Obesity:"));

> reRate=new TextField(5);

> p21.add(reRate);

> p21.add(new Label("The higher the rate the more dangerous you are."));

> p21.add(new Label("ResulT of you state is?"));

> TextArea ta =new TextArea(3,23);

> p21.add(ta);

> p2.add(p21,"Center");



> add(p2);

> in\_waist.requestFocus();



> addWindowListener(new WindowAdapter() {



> public void windowClosing(WindowEvent we) {

> System.exit(0);

> }

> });

> }



> public void actionPerformed(ActionEvent ae) {

> String s=ae.getActionCommand();



> if(s=="RESULT"){





> waist=Double.valueOf(in\_waist.getText()).doubleValue();

> hip=Double.valueOf(in\_hip.getText()).doubleValue();



> double Rate = (hip)/(waist);

> String re=Abdomen\_Check(Rate);



> reRate.setText(""+Rate);

> ta.setText(re);

> }else{

> in\_waist.setText("");

> in\_hip.setText("");

> }

> }



> public String Abdomen\_Check(double Rate){

> if(Rate<0.7)

> AO\_Result="Very Safe!!";

> else if(0.7<=Rate && Rate<0.8)

> AO\_Result="Normal.But little bit dangerous!";

> else if(0.8<=Rate&& Rate<0.9)

> AO\_Result="You are obese!!";

> else if(Rate>=0.9)

> AO\_Result="Very dangerous!!!!";

> return AO\_Result;

> }





> }



ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
ㅡㅡㅡㅡㅡㅡㅡ



package javaTerm;

> import java.awt.**;**

> import java.awt.event.**;**



> import javax.swing.**;**



> public class Cure extends JFrame implements ActionListener{



> JTextArea text;





> public void go() {



> JFrame frame = new JFrame();

> //setLayout(new GridLayout(2,1,5,5));

> JPanel p1 = new JPanel();

> p1.setBackground(Color.orange);



> JButton b1= new JButton("PRESCRIPTION");

> JButton b2= new JButton("EXPLANATION OF BMI");



> b1.addActionListener(this);

> b2.addActionListener(this);



> p1.add(b1);

> p1.add(b2);



> //add(p1);



> JPanel p2 = new JPanel();

> p2.add(new Label("THERE ARE CONTENTS!"),"North");

> text = new JTextArea(10, 20);
> text.setLineWrap(true);



> JScrollPane scroller = new JScrollPane(text);

> scroller.setVerticalScrollBarPolicy
(ScrollPaneConstants.VERTICAL\_SCROLLBAR\_ALWAYS);

> scroller.setHorizontalScrollBarPolicy
(ScrollPaneConstants.HORIZONTAL\_SCROLLBAR\_ALWAYS);



> p2.add(scroller);



> frame.getContentPane().add(BorderLayout.NORTH, p1);

> frame.getContentPane().add(BorderLayout.CENTER, p2);



> frame.setSize(400,500);

> frame.setVisible(true);

> //add(p2);

> }





> public void actionPerformed(ActionEvent ae) {

> String s=ae.getActionCommand();



> if(s=="PRESCRIPTION"){

> text.append("1)Drink a lot of warm water.\n 2)Stretch your body
regularly.\n 3)Stimulate your feet!\n 4)Breath through abodomen. \n5)
Eat more veges than meat.\n\n\n");



> }else{

> text.append("BMI means body mass index.\n Through BMI test you
can \n know your body mass exactly.\n This rate can be the index of
obesity.\n\n");



> }

> }

> }