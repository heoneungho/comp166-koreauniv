2011190711 박명훈
## Introduction ##

# 1. 프로젝트 이름 #
> TheDiary

# 2. 동기 #

제가 시간관리에 관심이 많아서 다이어리를 만들어 볼 생각을 했습니다. 물론 제가 원하던 형태로 만들기에는 많은 어려움이 있습니다만.

# 3. 간단한 설명 #
일정 입력, 일별 일정, 월별 일정, 종료 4개의 메뉴가 있습니다.

1. 일정 입력은 사용자가 월, 일을 입력한 후 일정을 직접 입력하면 됩니다.
만약 해당 날짜에 추가적인 입력을 원할 경우에는 월, 일을 입력하게 되면
추가로 입력할 것인지 초기화 후 입력할 것인지 선택한 후에 추가로 입력을 하면 됩니다. 한 날짜에 여러 개의 일정이 입력되어 있을 경우에는 하나씩 따로 지우는 것은
불가능하고 한 번에 다 지워지게 되어 있습니다.

2. 일별 일정은 입력받은 날짜에 쓰여진 스케줄을 화면에 보여줍니다.

3. 월별 일정도 입력받은 월에 포함된 모든 스케줄을 보여줍니다.

4. 종료는 다이어리를 닫습니다.

# 4. 클래스 목록 #
Diary, DiaryStart, Year, Month, Month1, Month2, Month3, Day, FunctionGui, Schedule

그리고 11학번에 임공빈 학생의 것을 많이 참조했습니다.

# 5. 소스코드 #
```
1.DiaryStart
import java.util.Scanner;
public class Year extends Diary{
        
                Month1 Feb = new Month1();
                Month2 Apr = new Month2();
                Month2 Jun = new Month2();
                Month2 Sep = new Month2();
                Month2 Nov = new Month2();
                Month3 Jan = new Month3();
                Month3 Mar = new Month3();
                Month3 May = new Month3();
                Month3 Jul = new Month3();
                Month3 Aug = new Month3();
                Month3 Oct = new Month3();
                Month3 Dec = new Month3();
                Month[] Month1 = {Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec}; // 월별 검색을 위해 array로 만듬
        
        public Diary go()
        {
                Month[] Months = new Month[12];
                
                Months[0] = Jan;
                Months[1] = Feb;
                Months[2] = Mar;
                Months[3] = Apr;
                Months[4] = May;
                Months[5] = Jun;
                Months[6] = Jul;
                Months[7] = Aug;
                Months[8] = Sep;
                Months[9]= Oct;
                Months[10]= Nov;
                Months[11]= Dec;
                System.out.println("월을 입력하세요");
                Scanner s1 = new Scanner(System.in);
        int num = s1.nextInt();
        Month which = Months[num];
        return which;
        }
}
```

```
2.Diary
public abstract class Diary {
        public abstract Diary go(); 
}
```

```
3. Day
import java.io.*;
import java.util.Scanner;

public class Day extends Diary implements Schedule {
        String[] n = new String[1024]; //충분한 공간확보를 위해 배열의 size를 100으로 지정해줍니다.
        int d = 0;
                
        public Diary go() {
                return null;
        }
        public void GetSchedule() {
                if( n[d]!=null ){  //현재 배열의 값에 일정이 있을 경우
                        System.out.println("이미 일정이 있습니다.\n일정 추가 : 1 / 초기화 후 일정 입력 : 2\n");
                        char c;
                        try {
                                c = (char) System.in.read();
                                if( c == '2'){
                                       for( int m = 0; n[m] != null; m++){
                                    	   n[m] = null;    
                                       }
                                       d = 0;       // n[0]부터 null 값이 아닌 모든 값을 리셋해줍니다.그리고 배열은 다시 n[0]으로 위치시킵니다.                     
                                       System.out.println("새로운 일정을 입력하세요: ");
                                       Scanner  scan  =  new  Scanner (System.in);
                                   n[d] = scan.next();
                                   
                                }
                                else if( c == '1'){
                                d++;
                                System.out.print("추가 일정을 입력하세요: ");
                            Scanner  scan  =  new  Scanner (System.in);
                            n[d] = scan.next(); // 기존 일정을 그대로 두고 다음 스트링인 n[d]에 일정을 입력받습니다.
                                        
                                }
                                else{
                                       System.out.print("잘못된 값이 입력되었습니다.");  //1이나 2가 아닌 값을 받았을 시 error 메세지를 출력합니다.
                                }
                        } catch (IOException e1) {
                                e1.printStackTrace();
                        }       
                }  
                else{                // n[d]가 null일 경우. 즉 일정이 없을 경우.
                   System.out.println("일정을 입력하세요:");
                   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                   try {
                        n[d] = br.readLine();
                } catch (IOException e) {
                        e.printStackTrace();
                }
               
            }
        }
        
        public void PrintSchedule() {
                for(int a = 0; n[a] != null ; a++){   // n[0] 부터 쭉  null이 나오기 전까지 print시켜줍니다.
                System.out.printf("%s",n[a]);
                System.out.println(" ");
                }
        }
}
```

```
4. FunctionGui
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FunctionGui {
        JFrame frame;        //메인 화면
        
        Year A = new Year();  //연도 생성
        public void start(){
                frame = new JFrame("다이어리");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
                
                JButton button1 = new JButton("종료"); // 4개의 버튼을 생성하고 각각의 버튼에 리스너 설정
                button1.addActionListener(new Listener1());
                JButton button2 = new JButton("일정 입력");
                button2.addActionListener(new Listener2());
                JButton button3 = new JButton("월별 일정");
                button3.addActionListener(new Listener3());
                JButton button4 = new JButton("일별 일정");
                button4.addActionListener(new Listener4());
                JPanel panel = new JPanel();
                panel.add(button2);
                panel.add(button1);
                panel.add(button3);
                panel.add(button4);
                frame.getContentPane().add(panel);
                frame.setSize(250,120);
                frame.setVisible(true);
                frame.setLocation(res.width/2, res.height/2);	//화면의 중앙에 배치
                
        }
        class Listener1 implements ActionListener {   //종료 버튼 클릭시
           public void actionPerformed(ActionEvent event){
                frame.setVisible(false);           //프레임 종료
           }
        }
        class Listener2 implements ActionListener {  //일정 입력 버튼 클릭시
           public void actionPerformed(ActionEvent event){ 
        	   	frame.setVisible(false); //메인 프레임 종료, 콘솔 화면
                Month B = (Month) A.go(); 
                Day C = (Day) B.go();
                C.GetSchedule();             //월, 일 입력받고 일정 입력
                                
                frame.setVisible(true);  //메인 프레임 재시작
                }
        }
        class Listener3 implements ActionListener {  //월별 일정 클릭시
            public void actionPerformed(ActionEvent event){
            	frame.setVisible(false);     //메인 프레임 종료, 입력을 위한 콘솔 화면 표시
                System.out.println("보고자 하는 월을 입력하세요");  //일정을 볼 월 입력받기
                Scanner s1 = new Scanner(System.in);
                int b = s1.nextInt();
                Month B = A.Month1[b];             //Year 객체 A 안에 입력받는 월 B
                for(int c = 0; c<31; c++){         //날짜별 일정 찾기
                	for(int d = 0;  B.Day1[c].n[d] != null ; d++){
                		System.out.printf("%d월 %d일의 일정: %s\n", b, c+1, B.Day1[c].n[d]);
                        System.out.println(" ");
                    }  
                }
                frame.setVisible(true);           //메인 프레임 재시작
            }
        }                   
        class Listener4 implements ActionListener {   //일별 일정 클릭시
             public void actionPerformed(ActionEvent event){ 
             	frame.setVisible(false);           //메인 프레임 종료, 입력을 위한 콘솔 화면 표시
                Month B = (Month) A.go();        
                Day C = (Day) B.go();
                C.PrintSchedule();              //월과 일을 입력받아 일정을 표시
                frame.setVisible(true);     //메인 프레임 재시작
             }
        }
    }
```

```
5. Month
public abstract class Month extends Diary {
            
                Day one = new Day();
                Day two = new Day();
                Day three = new Day();
                Day four = new Day();
                Day five = new Day();
                Day six = new Day();
                Day seven = new Day();
                Day eight = new Day();
                Day nine = new Day();
                Day ten = new Day();
                Day eleven = new Day();
                Day twelve = new Day();
                Day thirteen = new Day();
                Day fourteen = new Day();
                Day fifteen = new Day();
                Day sixteen = new Day();
                Day seventeen = new Day();
                Day eighteen = new Day();
                Day ninteen = new Day();
                Day twenty = new Day();
                Day twentyone = new Day();
                Day twentytwo = new Day();
                Day twentythree = new Day();
                Day twentyfour = new Day();
                Day twentyfive = new Day();
                Day twentysix = new Day();
                Day twentyseven = new Day();
                Day twentyeight = new Day();
                Day twentynine = new Day();
                Day thirty = new Day();
                Day thirtyone = new Day();
                Day[] Day1 = {one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,ninteen,twenty,twentyone,twentytwo,twentythree,twentyfour,twentyfive,twentysix,twentyseven,twentyeight,twentynine,thirty,thirtyone};
                //일정 검색을 위해 array로 만듬
                public abstract Diary go();
                
}
```

```
6. Month1
import java.util.Scanner;
public class Month1 extends Month {	//2월
        
        public Diary go()
        {
                Day[] Days;
                Days = new Day[30];
                Days[1] = one;
                Days[2] = two;
                Days[3] = three;
                Days[4] = four;
                Days[5] = five;
                Days[6] = six;
                Days[7] = seven;
                Days[8] = eight;
                Days[9] = nine;
                Days[10] = ten;
                Days[11]= eleven;
                Days[12]= twelve;
                Days[13]= thirteen;
                Days[14]= fourteen;
                Days[15]= fifteen;
                Days[16]= sixteen;
                Days[17]= seventeen;
                Days[18]= eighteen;
                Days[19]= ninteen;
                Days[20]= twenty;
                Days[21]= twentyone;
                Days[22]= twentytwo;
                Days[23]= twentythree;
                Days[24]= twentyfour;
                Days[25]= twentyfive;
                Days[26]= twentysix;
                Days[27]= twentyseven;
                Days[28]= twentyeight;
                Days[29]= twentynine;
                System.out.println("날짜를 입력하세요");
                Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Day a = Days[b];
        return a;
        }
        
        
}
```

```
7. Month2
import java.util.Scanner;
public class Month2 extends Month {	//30일짜리 월들
        
        public Diary go()
        {
                Day[] Days;
                Days = new Day[31];
                Days[1] = one;
                Days[2] = two;
                Days[3] = three;
                Days[4] = four;
                Days[5] = five;
                Days[6] = six;
                Days[7] = seven;
                Days[8] = eight;
                Days[9] = nine;
                Days[10] = ten;
                Days[11]= eleven;
                Days[12]= twelve;
                Days[13]= thirteen;
                Days[14]= fourteen;
                Days[15]= fifteen;
                Days[16]= sixteen;
                Days[17]= seventeen;
                Days[18]= eighteen;
                Days[19]= ninteen;
                Days[20]= twenty;
                Days[21]= twentyone;
                Days[22]= twentytwo;
                Days[23]= twentythree;
                Days[24]= twentyfour;
                Days[25]= twentyfive;
                Days[26]= twentysix;
                Days[27]= twentyseven;
                Days[28]= twentyeight;
                Days[29]= twentynine;
                Days[30]= thirty;
                System.out.println("날짜를 입력하세요");
                Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Day a = Days[b];
        return a;
        }
}
```

```
8. Month3
import java.util.Scanner;
public class Month3 extends Month{	//31일짜리 월들
        
        public Diary go()
        {
                Day[] Days;
                Days = new Day[32];
                Days[1] = one;
                Days[2] = two;
                Days[3] = three;
                Days[4] = four;
                Days[5] = five;
                Days[6] = six;
                Days[7] = seven;
                Days[8] = eight;
                Days[9] = nine;
                Days[10] = ten;
                Days[11]= eleven;
                Days[12]= twelve;
                Days[13]= thirteen;
                Days[14]= fourteen;
                Days[15]= fifteen;
                Days[16]= sixteen;
                Days[17]= seventeen;
                Days[18]= eighteen;
                Days[19]= ninteen;
                Days[20]= twenty;
                Days[21]= twentyone;
                Days[22]= twentytwo;
                Days[23]= twentythree;
                Days[24]= twentyfour;
                Days[25]= twentyfive;
                Days[26]= twentysix;
                Days[27]= twentyseven;
                Days[28]= twentyeight;
                Days[29]= twentynine;
                Days[30]= thirty;
                Days[31]= thirtyone;
                System.out.println("날짜를 입력하세요");
                Scanner s1 = new Scanner(System.in);
        int b = s1.nextInt();
        Day a = Days[b];
        return a;
        }
}
```

```
9. Schedule
public interface Schedule {
        public abstract void GetSchedule();
        public abstract void PrintSchedule();
}
```

```
10. Year
import java.util.Scanner;
public class Year extends Diary{
        
                Month1 Feb = new Month1();
                Month2 Apr = new Month2();
                Month2 Jun = new Month2();
                Month2 Sep = new Month2();
                Month2 Nov = new Month2();
                Month3 Jan = new Month3();
                Month3 Mar = new Month3();
                Month3 May = new Month3();
                Month3 Jul = new Month3();
                Month3 Aug = new Month3();
                Month3 Oct = new Month3();
                Month3 Dec = new Month3();
                Month[] Month1 = {Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec}; // 월별 검색을 위해 array로 만듬
        
        public Diary go()
        {
                Month[] Months = new Month[12];
                
                Months[0] = Jan;
                Months[1] = Feb;
                Months[2] = Mar;
                Months[3] = Apr;
                Months[4] = May;
                Months[5] = Jun;
                Months[6] = Jul;
                Months[7] = Aug;
                Months[8] = Sep;
                Months[9]= Oct;
                Months[10]= Nov;
                Months[11]= Dec;
                System.out.println("월을 입력하세요");
                Scanner s1 = new Scanner(System.in);
        int num = s1.nextInt();
        Month which = Months[num];
        return which;
        }
}
```
소스코드 압축파일입니다.
http://comp166-koreauniv.googlecode.com/files/Diary.zip

# 6. 스크린샷 #
1.초기화면입니다.
![http://comp166-koreauniv.googlecode.com/files/d11.jpg](http://comp166-koreauniv.googlecode.com/files/d11.jpg)
2. 일별 일정을 입력중입니다.
![http://comp166-koreauniv.googlecode.com/files/d22.jpg](http://comp166-koreauniv.googlecode.com/files/d22.jpg)
3. 월별 일정을 확인하고, 일에 일정을 입력하는데 겹치는 경우 초기화하거나 추가 입력을 할 수 있습니다.
![http://comp166-koreauniv.googlecode.com/files/d33.jpg](http://comp166-koreauniv.googlecode.com/files/d33.jpg)
4. 초기화 후 입력하고 일정을 확인합니다.
![http://comp166-koreauniv.googlecode.com/files/d44.jpg](http://comp166-koreauniv.googlecode.com/files/d44.jpg)

마지막 수정 완료 했습니다.