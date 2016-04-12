#2012190732 조혜경

# Introduction #

주문자들이 몇 번의 입력과 몇 번의 클릭만으로 주문할 수 있도록 만들어진 프로그램입니다.


# Details #

원래 IQTEST를 하려고 했으나, class가 너무 많이 필요해서 복잡하고 GUI구상이 너무 어

려워져서, class가 한개만 필요한 단순한 GUI프로그램으로 대체하였습니다.

────────────────────────────────────────────────────────────────────────

Question1. 왜 이 프로그램을 만들었는가?

Answer1.

> 제가 평소에 치킨 같은 배달 음식을 시킬 때, 어느 날은 주문이 너무 밀려서 판매자 쪽에서

계속 통화중이여서 전화 연결이 느려지거나, 주문을 못한 적이 많았습니다. 그래서 손쉽게

주문할 수 있고, 판매자 입장에서도 주문자의 전화보다 음식만드는 일에 집중 할 수 있게

일석이조인 것 같아서 만들게 되었습니다.

────────────────────────────────────────────────────────────────────────

Question2. 이 프로그램만이 가지고 있는 기능은 무엇인가?

Answer2.

1)사용자의 이름과 주소를 직접 입력합니다.

2)주문시, 가장 중요한 연락처는 숫자가 아닌 다른 문자는 절대 입력할 수 없으며,

기본적으로 010이 셋팅되어 있습니다.(try-catch 이용)

3)양과 결제 방식을 선택할 수 있습니다.

4)밑반찬은 4개까지 선택가능하며, 그 이상 선택하고 주문시 경고창이 뜹니다.

5)주재료 역시 1개까지 선택가능하며, 그 이상 선택하고 주문시 경고창이 뜹니다.

6)주문 완료시, 내가 선택한 결제 방식 및 가격 그리고 주문 내역을 알 수 있습니다.

7)중요한 밑반찬 및 주재료 선택에는 파란색(B=205)을 넣어서 강조하였습니다.

8)GUI를 이용해서 클릭만으로도 주문이 성립되게 하였습니다.

9)클래스가 1개 밖에 없는데도 불구하고, 코드가 알아보기 쉽습니다.

10)if, if else, else문을 적절히 이용하였습니다.


────────────────────────────────────────────────────────────────────────

Question3. 있었으면 좋았을 법한 기능 혹은 단점은 무엇인가?

Answer3.

1)주문자의 주문내역이 txt파일로 저장되었으면 좋았을 법하다.

2)class를 여러 개로 나눴으면 좋았을 법하다.

3)if문이 너무 많이 사용되었다.

4)비빔밥의 특성상 여러 그릇을 한꺼번에 주문하지 못한다는 점이 아쉽다.

────────────────────────────────────────────────────────────────────────

Question4. 12/4 이후 바뀐 점은?

Answer4.

1)결제 수단을 radiobutton을 이용한 형식으로 바꾸었다.

2)연락처에 숫자 이외의 것에 입력을 못하게 하였다.

3)결제 수단, 가격 및 주문 내역을 소비자가 다시 확인 할 수 있게 하였다.

4)밑반찬 및 주재료가 허용 갯수 초과하여 주문시, 경고창이 뜨게 하였다.

────────────────────────────────────────────────────────────────────────

Question5. 실행화면?

Answer5.

1)초기 화면.

a.이름, 주소는 직접 입력한다.

b.연락처를 입력한다.(반드시 숫자만 허용.)

c.양과 결제방식을 클릭한다.

d.먹고 싶은 밑반찬 및 주메뉴를 고른다.

e.주문 완료를 누른다.

![http://comp166-koreauniv.googlecode.com/files/초기화면2.jpg](http://comp166-koreauniv.googlecode.com/files/초기화면2.jpg)

2)정보 입력.

a.기본 정보를 입력했을 때.

![http://comp166-koreauniv.googlecode.com/files/실행한_화면3.jpg](http://comp166-koreauniv.googlecode.com/files/실행한_화면3.jpg)

3)밑반찬을 4개를 초과하여 선택했을 경우

a.주문 완료를 누른다면 경고창이 뜬다.

![http://comp166-koreauniv.googlecode.com/files/5개.jpg](http://comp166-koreauniv.googlecode.com/files/5개.jpg)

4)밑반찬은 4개가 되었으나, 주메뉴를 1개 초과하여 선택하였을 경우

a.주문 완료를 누른다면 경고창이 뜬다.

![http://comp166-koreauniv.googlecode.com/files/주재료_2개골랐을_경우5.jpg](http://comp166-koreauniv.googlecode.com/files/주재료_2개골랐을_경우5.jpg)

5)이제 갯수에 맞게 주문을 완료하였다.

a.결제 수단

![http://comp166-koreauniv.googlecode.com/files/현금카드.jpg](http://comp166-koreauniv.googlecode.com/files/현금카드.jpg)

b.결제 금액

![http://comp166-koreauniv.googlecode.com/files/금액7.jpg](http://comp166-koreauniv.googlecode.com/files/금액7.jpg)

c.주문 내역

![http://comp166-koreauniv.googlecode.com/files/주문_내역8.jpg](http://comp166-koreauniv.googlecode.com/files/주문_내역8.jpg)

d.주문 완료

![http://comp166-koreauniv.googlecode.com/files/주문_완료9.jpg](http://comp166-koreauniv.googlecode.com/files/주문_완료9.jpg)

────────────────────────────────────────────────────────────────────────

Question6. 코드 소개?

Answer6.

1)Bibim이라는 클래스와 메소드 하나로 이루어져있는 간단한 코드.

2)import javax.swing.**;을 사용하여, Label, TextField,RadioButton,CheckBox를 사용하였다.**

3)OptionPane를 이용하여, 결과창을 보여주었다.

4)if문을 사용하여 주재료와 밑반찬의 갯수를 제한 하였다.


```


import java.awt.*;//for. frame 이용

import java.awt.event.*; //for. frame, keyevent 이용

import javax.swing.*; //GUI 이용, for. JOptionPane

public class Bibim extends JFrame implements ActionListener, KeyListener {
 //Bibim class 설정 , JFrame 사용을 위한 extends 
 /*1.ActionListener를 통해 버튼에 액션이 일어나면 실행.
   2.KeyListener를 통해 해당 입력 필드에서 엔터 액션이 일어나면 실행.*/

    
        JLabel lab1, lab2, lab3, lab4, lab5, sideItem, mainItem; //JLabel을 위한 변수선언-for.이름, 주소, 연락처 등

        Button button; //for.주문완료 버튼

        JTextField text1, text2, text3; //이름, 주소, 연락처를 입력하기 위한 TextField 변수

        ButtonGroup group1, group2; //양 과 결제수단을 위한 buttongroup.

        JRadioButton small, medium, large, cash, card; //양과 결제 수단을 위한 button선언.

        JCheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10,

                  chk11, chk12, chk13, chk14, chk15, chk16, chk17, chk18;
//메뉴 선택을 위한 checkbox 선언

        Bibim() { //Bibim 메소드

            

                getContentPane().setLayout(null);//보더레이아웃으로 설정


                setBackground(Color.white);//배경색 = white

                

                lab1 = new JLabel("이름: "); //이름:이라는 문구(라벨) 생성

                lab2 = new JLabel("주소: "); //주소:이라는 문구(라벨) 생성

                lab3 = new JLabel("연락처: "); //연락처:이라는 문구(라벨) 생성

                lab4 = new JLabel("양:"); //양:이라는 문구(라벨) 생성
                
                lab5 = new JLabel("결제 수단:"); //결제 수단:이라는 문구(라벨) 생성
                          

                sideItem = new JLabel("밑반찬을 선택하시오.(택4) : "); 
//밑반찬을 선택하시오.(택4):이라는 문구(라벨) 생성
                                                                                                                                                                 
                sideItem.setForeground(new Color(0, 0, 205));
//RGB중 B를 선택하여 파란색이 나옴.


                mainItem = new JLabel("주재료를 선택하시오.(택1): "); 
//주재료를 선택하시오.(택1):이라는 문구(라벨) 생성

                mainItem.setForeground(new Color(0, 0, 205)); 
//RGB중 B를 선택하여 파란색이 나옴.



                text1 = new JTextField(20); //크기를 20으로 설정.

                text2 = new JTextField(20);

                text3 = new JTextField(20);

                text3.setText("010"); //기본적으로 010 세팅.


                small = new JRadioButton("소 (4000원)", true);
 //라디오버튼 생성. 소 (4000원)이라고 적혀있음. true 기에 이미 선택되어 있다.

                medium = new JRadioButton("중 (5000원)", false);
 //라디오버튼 생성. 중 (5000원)이라고 적혀있음. false 기에 선택되어 있지 않다.


                large = new JRadioButton("대 (6000원)", false);  
//라디오버튼 생성. 대 (6000원)이라고 적혀있음. false 기에 선택되어 있지 않다.



                group1 = new ButtonGroup(); //라디오 버튼 그룹1 생성.

                group1.add(small);

                group1.add(medium);

                group1.add(large); //그룹 1에 small, medium, large를 추가함.
                
                
                cash = new JRadioButton("현금 결제", false); /*라디오 버튼 생성. 현금 결제라고 적혀있음. 
false 기에 선택되어 있지 않다. 이건 고객들이 확실하게 고르시라고 일부러 둘다 false처리 하였다.*/

                card = new JRadioButton("카드 결제", false); //라디오버튼 생성. 카드결제라고 적혀있음. 
//false 기에 선택되어 있지 않다.

                group2 = new ButtonGroup(); //라디오 버튼 그룹2 생성.

                group2.add(cash);

                group2.add(card); //그룹 2에 cash, card를 추가.

                chk1 = new JCheckBox("느타리버섯 나물", false);

 //각종 밑반찬 checkbox 생성.

                chk2 = new JCheckBox("호박 나물", false);

                chk3 = new JCheckBox("고사리 나물", false);

                chk4 = new JCheckBox("콩나물 무침", false);

                chk5 = new JCheckBox("시금치 나물", false);

                chk6 = new JCheckBox("채썬 당근", false);

                chk7 = new JCheckBox("달걀후라이", false);

                chk8 = new JCheckBox("상추", false);

                chk9 = new JCheckBox("무채", false);


                chk10 = new JCheckBox("연어", false); 

//각종 주재료 checkbox 생성.

                chk11 = new JCheckBox("불고기", false);

                chk12 = new JCheckBox("치즈날치알", false);

                chk13 = new JCheckBox("참치", false);

                chk14 = new JCheckBox("볶은 김치", false);

                chk15 = new JCheckBox("닭갈비", false);

                chk16 = new JCheckBox("새우", false);

                chk17 = new JCheckBox("제육 볶음", false);

                chk18 = new JCheckBox("낙지", false);


                button = new Button("주문 완료"); //주문 완료 버튼 생성.

                small.addActionListener(this); 

//For, 라디오버튼, 체크박스, 텍스트 필드 후 입력에 대한 처리를 위한 Actionlistener

                medium.addActionListener(this);

                large.addActionListener(this);
                
                cash.addActionListener(this);

                card.addActionListener(this);

                chk1.addActionListener(this);

                chk2.addActionListener(this);

                chk3.addActionListener(this);

                chk4.addActionListener(this);

                chk5.addActionListener(this);

                chk6.addActionListener(this);

                chk7.addActionListener(this);

                chk8.addActionListener(this);

                chk9.addActionListener(this);


                chk10.addActionListener(this);

                chk11.addActionListener(this);

                chk12.addActionListener(this);

                chk13.addActionListener(this);

                chk14.addActionListener(this);

                chk15.addActionListener(this);

                chk16.addActionListener(this);

                chk17.addActionListener(this);

                chk18.addActionListener(this);


                text3.addKeyListener(this);

                button.addActionListener(this);

/*setBounds(x좌표,y좌표,가로,세로)*/
                lab1.setBounds(50, 50, 200, 20); 

//글씨의 위치는 (50,50) 그 모양은 가로=200, 세로=20 (200*20인 직사각형)

                lab2.setBounds(50, 80, 200, 20);

//즉, lab1보다 30정도 아래에 있다.


                lab3.setBounds(50, 110, 200, 20);

               
                text1.setBounds(200, 50, 200, 20);

//x=200, y=500, 200*20인 직사각형

//나머지는 유사함으로 생략하겠다.

                text2.setBounds(200, 80, 200, 20);

                text3.setBounds(200, 110, 200, 20);

                lab4.setBounds(50, 140, 200, 20);
                
                small.setBounds(200, 140, 100, 20);

                medium.setBounds(300, 140, 100, 20);

                large.setBounds(400, 140, 100, 20);
                
                lab5.setBounds(50, 170, 200, 20);
                
                cash.setBounds(200, 170, 100, 20);

                card.setBounds(300, 170, 100, 20);

                sideItem.setBounds(50, 200, 300, 20);

                chk1.setBounds(50, 230, 300, 20);

                chk2.setBounds(50, 260, 300, 20);

                chk3.setBounds(50, 290, 300, 20);

                chk4.setBounds(50, 320, 300, 20);

                chk5.setBounds(50, 350, 300, 20);

                chk6.setBounds(50, 380, 300, 20);

                chk7.setBounds(50, 410, 300, 20);

                chk8.setBounds(50, 440, 300, 20);

                chk9.setBounds(50, 470, 300, 20);


                mainItem.setBounds(350, 200, 300, 20);

                chk10.setBounds(350, 230, 300, 20);

                chk11.setBounds(350, 260, 300, 20);

                chk12.setBounds(350, 290, 300, 20);

                chk13.setBounds(350, 320, 300, 20);

                chk14.setBounds(350, 350, 300, 20);

                chk15.setBounds(350, 380, 300, 20);

                chk16.setBounds(350, 410, 300, 20);

                chk17.setBounds(350, 440, 300, 20);

                chk18.setBounds(350, 470, 300, 20);

                button.setBounds(50, 600, 100, 20);

                add(lab1); //awt의 선언으로 사용된 add(). lab1추가.

                add(lab2); //이하 동일.

                add(lab3);

                add(text1);

                add(text2);

                add(text3);

                add(lab4);
                
                add(small);

                add(medium);

                add(large);
                
                add(lab5);
                
                add(cash);

                add(card);

                add(sideItem);

                add(chk1);

                add(chk2);

                add(chk3);

                add(chk4);

                add(chk5);

                add(chk6);

                add(chk7);

                add(chk8);

                add(chk9);

                add(mainItem);

                add(chk10);

                add(chk11);

                add(chk12);

                add(chk13);

                add(chk14);

                add(chk15);

                add(chk16);

                add(chk17);

                add(chk18);

                add(button);

                text3.selectAll();

  //텍스트필드에 마우스 클릭됬을 때, 글자 고치기 쉽게 하기 위해 모든 글자를 선택

                setVisible(true); //awt, 윈도우 화면에 보여주기 위함.

                

                setSize(700, 700); //700*700 size의 가장 큰 틀 
}

/*KeyListener 클래스의 모든 메소드*/



        public void keyTyped(KeyEvent e) {  //누른 키가 문자키일때,

        }


        public void keyPressed(KeyEvent e) {//키가 눌려졌을 때,

        }


        public void keyReleased(KeyEvent e) { //키를 놓았을 때


                try { 

//연락처(text3)에 숫자 외의 것이 들이가지 않게 하는 try - catch문

                        Integer.parseInt(text3.getText()); 

//int(정수)입력(getText).

                } catch (NumberFormatException fe) { 

//숫자 형식이 아닐때, 0이 나온다.

                        text3.setText("0");

                }



        }


        public void actionPerformed(ActionEvent e) { 

/*ActionLisener 는 버튼이 클릭되었을때 수행하는 이벤트를 포함하고 있다.

ActionListener는 인터페이스이기 때문에 이를 쓰기 위해서는 그가 포함하고 있는 모든


메소드를 Overriding해주어야 하는데, 이때 ActionListener가 포함하고 있는 메소드는

ActionPerformed() 한개 뿐이기에 overriding 한다. */




                           
            if (e.getSource() == button) { //주문 완료 버튼을 눌렀을때의 if문

                                           
                    String item1 = new String();

 //음식 1~16가지 및 card, cash, small, medium, large의 string 선언. 
//나중에 안내창 및 경고문에 뜨게 하기 위함.

                    String item2 = new String();

                    String item3 = new String();

                    String item4 = new String();

                    String item5 = new String();

                    String item6 = new String();

                    String item7 = new String();

                    String item8 = new String();

                    String item9 = new String();

                    String item10 = new String();

                    String item11 = new String();

                    String item12 = new String();

                    String item13 = new String();

                    String item14 = new String();

                    String item15 = new String();

                    String item16 = new String();

                    String item17 = new String();

                    String item18 = new String();

          
                    String Cash = new String();
                    
                    String Card = new String();
                    
                    
                    String Small = new String();

                    String Medium = new String();

                    String Large = new String();

                    

                    int sideItem = 0; 

                    int mainItem = 0;

//밑반찬과 주메뉴의 갯수를 세기 위해 초기화함.
                    

                    if(chk1.isSelected() == true) {

 //느타리버섯 나물을 선택했을 경우, 인스턴스변수 sideItem 이 1 증가.

                        item1 = "느타리버섯 나물,\n";

                        sideItem++;

                    }

                    if(chk2.isSelected() == true) {

 //호박 나물을 선택했을 경우, 인스턴스변수 sideItem 이 1 증가.

                        item2 = "호박 나물,\n";

                        sideItem++;

                    }

                    if(chk3.isSelected() == true) {

 //이하 동일.
                        item3 = "고사리 나물,\n";

                        sideItem++;

                    }

                    if(chk4.isSelected() == true) {

                        item4 = "콩나물 무침,\n";

                        sideItem++;

                    }

                    if(chk5.isSelected() == true) {

                        item5 = "시금치 나물,\n";

                        sideItem++;

                    }

                    if(chk6.isSelected() == true) {

                        item6 = "채썬 당근,\n";

                        sideItem++;

                    }

                    if(chk7.isSelected() == true) {

                        item7 = "달걀후라이,\n";

                        sideItem++;

                    }

                    if(chk8.isSelected() == true) {

                        item8 = "상추,\n";

                        sideItem++;

                    }

                    if(chk9.isSelected() == true) {

                        item9 = "무채,\n";

                        sideItem++;

                    }

                    if(chk10.isSelected() == true) {

                        item10 = "연어\n";

 //연어를 선택했을 경우, 인스턴스변수 mainItem 이 1 증가.

                        mainItem++;

                    }

                    if(chk11.isSelected() == true) {

 //불고기를 선택했을 경우, 인스턴스변수 mainItem 이 1 증가.

                        item11 = "불고기\n";

                        mainItem++;

                    }

                    if(chk12.isSelected() == true) {

//이하 동일.

                        item12 = "치즈 날치알\n";

                        mainItem++;

                    }

                    if(chk13.isSelected() == true) {

                        item13 = "참치\n";

                        mainItem++;

                    }

                    if(chk14.isSelected() == true) {

                        item14 = "볶음김치\n";

                        mainItem++;

                    }

                    if(chk15.isSelected() == true) {

                        item15 = "닭갈비\n";

                        mainItem++;

                    }

                    if(chk16.isSelected() == true) {

                        item16 = "새우\n";

                        mainItem++;

                    }

                    if(chk17.isSelected() == true) {

                        item17 = "제육볶음\n";

                        mainItem++;

                    }

                    if(chk18.isSelected() == true) {

                        item18 = "낙지\n";

                        mainItem++;

                    } 
/*여기 까지, 메뉴 선택에 대한 if문*/

/*이제, cash or card에 대한 if문.*/

                    if(cash.isSelected() == true) {

                        Cash = "현금 결제\n";
                        
                    JOptionPane.showMessageDialog(this, text1.getText()  + "고객님,\n " + Cash + "를 선택하셨습니다.",

                                "결제 방식", JOptionPane.INFORMATION_MESSAGE);

//cash를 선택하였다면, JOptionPane를 이용하여, 
//"XXX고객님, 현금결제를 선택하였습니다."라는 안내문이 출력된다.
                   
                    } 
                    if(card.isSelected() == true) {

                        Card = "카드 결제\n";
                        
                        JOptionPane.showMessageDialog(this, text1.getText()  +"고객님,\n " + Card + "를 선택하셨습니다.",

                                "결제 방식", JOptionPane.INFORMATION_MESSAGE);

//card를 선택하였다면, JOptionPane를 이용하여, 
//"XXX고객님, 카드결제를 선택하였습니다."라는 안내문이 출력된다.

                    
                    }
                   
/*양을 출력하는 if문*/
                    if(small.isSelected() == true) {

                        Small = "소\n";
                        
                        JOptionPane.showMessageDialog(this, text1.getText()  +"고객님,\n " + Small +"를 선택하셨습니다. \n"+"4000원이 결제될 예정입니다.",

                                "결제 금액", JOptionPane.INFORMATION_MESSAGE);

//같은 방식으로 
//소를 선택하였다면, JOptionPane를 이용하여, 
//"XXX고객님, 소를 선택하였습니다. 4000원이 결제될 예정입니다."라는 안내문이 출력된다.

                        
                    }
                        
                       if(medium.isSelected() == true) {

                                    Medium = "중\n";
                                    
                                    JOptionPane.showMessageDialog(this, text1.getText()  +"고객님,\n " + Medium + "을  선택하셨습니다. \n"+"5000원이 결제될 예정입니다.",  
                                            

                                            "결제 금액", JOptionPane.INFORMATION_MESSAGE);
                                    
//이하 동일.                       }
                                  
                     if(large.isSelected() == true) {

                                        Large = "대\n";
                                        
                                        JOptionPane.showMessageDialog(this, text1.getText()  +"고객님,\n " + Large + "를 선택하셨습니다. \n"+"6000원이 결제될 예정입니다.",

                                                "결제 금액", JOptionPane.INFORMATION_MESSAGE);



                    
                    }
                                   
/*갯수세어서, 안내문이 나오는 if문이다.*/
 
                    if(sideItem >= 5) { //sideItem이 5이상이면, 주문 오류!

                    JOptionPane.showMessageDialog(this, text1.getText()  + "고객님, 밑반찬은 4개까지만 골라주세요",

                                 "주문 오류", JOptionPane.INFORMATION_MESSAGE);

                    } else if (mainItem >= 2) { //mainItem이 5이상이면, 주문 오류!

                    JOptionPane.showMessageDialog(this, text1.getText()  + "고객님, 주재료는 1개까지만 골라주세요",

                                 "주문 오류", JOptionPane.INFORMATION_MESSAGE);

                    } else { 

//갯수를 잘 맞게 설정하였다면, 어떤 것을 선택하였는지 안내문과 함께 출력된다.

                 

                    JOptionPane.showMessageDialog(this, item1 + item2 + item3 + item4 + item5 + item6 + item7 + item8 + item9 + "의 밑반찬과 \n\n"

                            + item10 + item11 + item12 + item13 + item14 + item15 + item16 + item17 + item18 + "를 선택하셨습니다. ",

                            "주문 내역", JOptionPane.INFORMATION_MESSAGE);

//주문 완료가 되었다는, 안내문 출력.

                    JOptionPane.showMessageDialog(this, text1.getText() + "고객님, 주문해 주셔서 감사합니다."

                            + "\n\n주문하신 비빔밥이 15분내로 배달 될 예정입니다. \n\n 15분 후에 맛있게 드세요.♡ ",

                            "주문 완료", JOptionPane.INFORMATION_MESSAGE);

                    }

                       }
                       
                    }
                    
            
                       
             

        


   

        public static void main(String[] args) { //메인

                Bibim bibimorder = new Bibim(); //Bibim 메소드 생성

        }


        }


 


```

────────────────────────────────────────────────────────────────────────

Question7. 참고 자료는 무엇인가?

Answer7.

1)기본 소스코드

http://www.roseindia.net/tutorial/java/core/pizzaorderApplication.html

2)<head first java> 및 <나는 자바를 공부한 적이 없어요> 의 책

3)손코딩