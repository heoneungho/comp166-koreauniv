Introduction¶
성적처리 프로그램 입니다.
gui를 이용하여 간편하게 성적을 입력하고 결과를 알려줄수 있습니다.


Background¶
가슴아프지만 확인할수밖에 없는 성적을
미리 예측하여 어느정도 총점을 예측하여 볼수도 있고
절대 그럴리는 없겠지만 가혹한 현실을 외면하고 싶어서
혹시 전산오류로 총점이 잘못 나온것인지
확인해볼수 있는 프로그램을 만들고 싶었습니다.


Details¶
9가지 과목에 대하여 성적과 1,2,3 학점중에 몇학점 짜리 과목인지를
콤보박스를 이용하여 입력하고 입력완료 버튼을 클릭하면
선택된 성적에 학점을 곱한값들을 더하고 총 학점으로 나누어
텍스트박스에 출력하여
최종적으로 본인의 성적을 알수 있게 됩니다.



Using code¶

import java.io.**;
import java.awt.**;
import javax.swing.**;**

import java.awt.Event.**;**


public class project extends JFrame /**implements ActionLIstener**/{




> public static void main(String args[.md](.md)){

> String[.md](.md) sung =
> > {
> > > "F","D","D+","C","C+","B","B+","A","A+"

> > };

> //첫번째 콤보박스에 넣을 내용입니다
> > String[.md](.md) hakjum =
> > {
> > > "0","1", "2","3"

> > };

> //두번째 콤보박스에 넣을 내용입니다.


> /////////////////////////////
> JPanel jp = new JPanel();
> JPanel jp1 = new JPanel();
> JPanel jp2 = new JPanel();
> JPanel jp3 = new JPanel();
> JPanel jp4 = new JPanel();
> JPanel jp5 = new JPanel();
> JPanel jp6 = new JPanel();
> JPanel jp7 = new JPanel();
> JPanel jp8 = new JPanel();
> JPanel jp9 = new JPanel();
> JPanel jp10 = new JPanel();
> JPanel jp11 = new JPanel();
> JPanel jp12 = new JPanel();


> jp.add(new JLabel("                        성적        학점"));

> jp1.add(new JLabel("  첫번째과목"));

> JComboBox box1 = new JComboBox(sung);
> jp1.add(box1);
> JComboBox box2 = new JComboBox(hakjum);
> jp1.add(box2);

> jp2.add(new JLabel("  두번째과목"));

> JComboBox box3 = new JComboBox(sung);
> jp2.add(box3);
> JComboBox box4 = new JComboBox(hakjum);
> jp2.add(box4);

> jp3.add(new JLabel("  세번째과목"));

> JComboBox box5 = new JComboBox(sung);
> jp3.add(box5);
> JComboBox box6 = new JComboBox(hakjum);
> jp3.add(box6);

> jp4.add(new JLabel("  네번째과목"));

> JComboBox box7 = new JComboBox(sung);
> jp4.add(box7);
> JComboBox box8 = new JComboBox(hakjum);
> jp4.add(box8);

> jp5.add(new JLabel("다섯번째과목"));

> JComboBox box9 = new JComboBox(sung);
> jp5.add(box9);
> JComboBox box10 = new JComboBox(hakjum);
> jp5.add(box10);

> jp6.add(new JLabel("여섯번째과목"));

> JComboBox box11 = new JComboBox(sung);
> jp6.add(box11);
> JComboBox box12 = new JComboBox(hakjum);
> jp6.add(box12);

> jp7.add(new JLabel("일곱번째과목"));

> JComboBox box13 = new JComboBox(sung);
> jp7.add(box13);
> JComboBox box14 = new JComboBox(hakjum);
> jp7.add(box14);

> jp8.add(new JLabel("여덟번째과목"));

> JComboBox box15 = new JComboBox(sung);
> jp8.add(box15);
> JComboBox box16 = new JComboBox(hakjum);
> jp8.add(box16);

> jp9.add(new JLabel("아홉번째과목"));

> JComboBox box17 = new JComboBox(sung);
> jp9.add(box17);
> JComboBox box18 = new JComboBox(hakjum);
> jp9.add(box18);


> ////////////////////
> JFrame f = new JFrame();
> f.setTitle("학점 계산기");
> f.setVisible(true);
> f.setSize(500,800);

> f.getContentPane().setLayout(new GridLayout(20,1));
> f.getContentPane().add(jp);
> f.getContentPane().add(jp1);
> f.getContentPane().add(jp2);
> f.getContentPane().add(jp3);
> f.getContentPane().add(jp4);
> f.getContentPane().add(jp5);
> f.getContentPane().add(jp6);
> f.getContentPane().add(jp7);
> f.getContentPane().add(jp8);
> f.getContentPane().add(jp9);
> f.getContentPane().add(jp10);
> f.getContentPane().add(jp11);
> f.getContentPane().add(jp12);

> f.setDefaultCloseOperation(JFrame.EXIT\_ON\_CLOSE);
> /////////////////////////////////////
> JButton button = new JButton("입력완료");


// ~~~ //~~

double chonghak = 0;
double result = 0;
int isuhak = 0;

chonghak = grade1\*hak1 + grade2\*hak2 + grade3\*hak3 + grade4\*hak4 + grade5\*hak5 + grade6\*hak6 + grade7\*hak7 + grade8\*hak8 + grade9\*hak9;  //성적에 학점수를 곱해 총점을 구합니다
isuhak = hak1+ hak2+ hak3+ hak4+ hak5+ hak6+ hak7+ hak8+ hak9;//총 이수한 학점을 계산합니다
result = chonghak/isuhak;//최종적인 학점을 계산합니다

> text1 = new JTextField(isuhak+"",10);
> text2 = new JTextField(result+"",10); //텍스트박스에 나타냅니다
