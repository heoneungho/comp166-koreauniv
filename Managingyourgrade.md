#성적관리프로그램 by 최우형

# Introduction #
이것은 자신의 학점과 성적을 보다 쉽고 빠르게 한눈에 볼수 있는 프로그램 입니다.

# Details #
제가 늘 성적이 안좋다보니 성적표라도 제대로 보고 싶어서 이 프로그랩을 만들게 되었습니다.

import java.util.**;**

class Datainput
{
> String name;
> int kor, math, eng, sum;
> double ave;
> int rank;

> public Datainput(String name, int kor, int math, int eng, int sum, double ave, int rank)
> {
> > this.name = name;
> > this.kor = kor;
> > this.math = math;
> > this.eng = eng;
> > this.sum = sum;
> > this.ave = ave;
> > this.rank = rank;

> }
}

class sumoutput
{
> public void ranking(Datainput[.md](.md) data)
> {
> > for(int i=0; i<data.length; i++) {
> > > for(int j=0; j<data.length; j++) {
> > > > if(data[i](i.md).sum < data[j](j.md).sum) {
> > > > > data[i](i.md).rank++;

> > > > }

> > > }

> > }

> }

> public void output(Datainput[.md](.md) data)
> {
> > System.out.println("이름\t\t국어\t수학\t영어\t총점\t평균\t등수");
> > System.out.println("------------------------------------------------------" );
> > for(int i=0; i<data.length; i++)
> > {
> > > System.out.println(data[i](i.md).name+"\t\t"+data[i](i.md).kor+"\t"+data[i](i.md).math+"\t"+data[i](i.md).eng+"\t"+data[i](i.md).sum+"\t"+data[i](i.md).ave+"\t"+data[i](i.md).rank);

> > }

> }

}





public class sukcha
{
> public static void main(String[.md](.md) args)
> {
> > Scanner sc = new Scanner(System.in);
> > System.out.println("학생수를 입력하시오");
> > int inw = sc.nextInt();
> > Datainput[.md](.md) data = new Datainput[inw](inw.md);


> for(int i=0; i<data.length; i++)
> {
> > System.out.println("이름을 입력하시오");
> > String name = sc.next();
> > System.out.println("국어 점수를 입력하시오");
> > int kor = sc.nextInt();
> > System.out.println("수학 점수를 입력하시오");
> > int math = sc.nextInt();
> > System.out.println("영어 점수를 입력하시오");
> > int eng = sc.nextInt();
> > int sum = kor+math+eng;
> > double ave = (double)sum/3.0d;
> > int rank = 1;


> data[i](i.md) = new Datainput(name, kor, math, eng, sum, ave, rank);
> }

> sumoutput so = new sumoutput();

> so.ranking(data);
> so.output(data);

> }
}


처음과 발표때까지는 저렇게 짜왔는데 교수님께서 너무 간단하다고 하셔서 조금 수정과 추가를 해보았습니다


package forTest;

import java.util.Scanner;

public class GradeStudy {
> public static void main(String[.md](.md) args) {
> > Scanner in = new Scanner(System.in);
> > Menu menu1 = new Menu();
> > int numb = 100,menu; //numb 는 학생 배열 수
> > boolean end=true;//end 종료를 위한
> > int[.md](.md)[.md](.md) arr = new int[numb](numb.md)[5](5.md);
> > float[.md](.md) avg = new float[numb](numb.md);  //-------배열 선언
> > char[.md](.md) grade = new char[numb](numb.md);  // 각 변수의 형태마다 배열선언
> > String[.md](.md) name = new String[numb+2];
> > int i =0,j=0,a=0,b=0,c=0;   //for 문을 위한 변수
> > //메뉴시작
> > do{
> > menu1.menu();
> > menu = in.nextInt(); //메뉴의 값 받음
> > switch(menu){ //값에 따른 스위치문
> > case 1 :
> > System.out.print("입력할 학생 수 : ");
> > numb = in.nextInt();
> > do{   //---------------------------학생수만큼 입력받기 위한 반복
> > System.out.print("이름 : ");
> > name[i](i.md) = in.next();
> > System.out.print("학번 : ");
> > j=0;    //-------------배열의 초기화
> > arr[i](i.md)[j++] = in.nextInt();   //---------------배열의 증가
> > System.out.print("수학 : ");
> > arr[i](i.md)[j++] = in.nextInt();     //----------증가
> > System.out.print("과학 : ");
> > arr[i](i.md)[j++] = in.nextInt();     //---------증가
> > System.out.print("영어 : ");
> > arr[i](i.md)[j++] = in.nextInt();     //--------증가
> > i++;     //-----------학생 증가
> > }while(i<numb);
> > //학생수 만큼 총점(수학+과학+영어)을 각각 넣음
> > for(a=0;a<numb;a++){
> > > for(b=1;b<4;b++)
> > > > arr[a](a.md)[4](4.md) += arr[a](a.md)[b](b.md);         //총점

> > }//for end
> > //----------------------------------------------------//
> > for(c=0;c<numb;c++){             //각자의 평균과 학점을 처리
> > > avg[c](c.md) = arr[c](c.md)[4](4.md)/3.0f;            //평균

> > int temp = (int)avg[c](c.md)[1](1.md);
> > switch(temp/10){
> > case 10:
> > case 9: grade[c](c.md) = 'A';
> > > break;

> > case 8: grade[c](c.md) = 'B';
> > > break;

> > case 7: grade[c](c.md) = 'C';
> > > break;

> > case 6: grade[c](c.md) = 'D';
> > > break;

> > default : grade[c](c.md) = 'F';
> > > break;

> > }  //switch end
> > }  //for end
> > break;
> > //case1끝
> > case 2 :
> > //-------------출력 부분---------------//
> > System.out.println("---------------------------------");
> > System.out.println("이름 학번 수학 과학 영어 총점 평균 학점");
> > System.out.println("---------------------------------");
> > for(int k=0; k<numb; k++){
> > System.out.print(name[k](k.md)+" ");   //이름
> > for(int p=0; p<5; p++){
> > > System.out.print(arr[k](k.md)[p](p.md)+" "); //학번,수학,과학,영어,총점

> > }//for end
> > System.out.println(avg[k](k.md)+" "+grade[k](k.md));  //평균, 학점
> > }//for end
> > break; //case 2 end

> case 3 :
> > System.out.println("종료");
> > end = false;
> > break;

> default :
> > System.out.println("잘 못 입력");
> > break;
> > }
> > }while(end);

> }
}

////////////////////메뉴부분/////////////////////

package forTest;

public class Menu {
> public void menu(){
> > System.out.println("----------메뉴---------");
> > System.out.println("1.성적입력");
> > System.out.println("2.성적출력");
> > System.out.println("3.종료");
> > System.out.println("-----------------------");

> }
}




Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages