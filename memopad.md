# Introduction #

메모장을 만들기 위해 필요한 큰 카테고리를 만들고 각각의 카테고리에 적절한 기능을 넣을 것입니다.

# Details #
윈도우 메모장을 참고하면
파일 편집 서식 보기 이라는 큰 카테고리가 있고
파일 안에는 새로만들기, 열기, 저장  등이 있습니다.
일단 큰 카테고리인 파일에서 새로 만들기, 열기 , 저장
그리고 원하는 단어를 입력하면 찾을 수있는 검색기능과 글씨크기를 조절하는 기능을 추가할 것입니다.

import java.awt.**;
import java.awt.event.**;
import java.io.**;**

import javax.swing.Action;
public class Notepad extends Frame implements ActionListener {
> MenuBar mb;
> Menu fileMenu;
> Menu editMenu;
> Menu viewMenu;
> TextArea ta;
> public Notepad() {
> > addWindowListener(new WindowAdapter() {
> > > public void windowClosing(WindowEvent we) {
> > > > System.out.println("메모장종료");
> > > > System.exit(0);  //  프로그램 종료

> > > }

> > });
> > setSize(800, 600);    //  크기 지정


> ta = new TextArea();
> add(ta, BorderLayout.CENTER);
> mb = new MenuBar();           //파일메뉴생성
> fileMenu = new Menu("파일");
> fileMenu.add("새로 만들기");
> fileMenu.add("열기");
> fileMenu.add("저장");
> > fileMenu.addSeparator();

> fileMenu.add("끝내기");
> fileMenu.addActionListener(this);
> mb.add(fileMenu);
> setMenuBar(mb);
> setVisible(true);
public class memopad {
public static void main(String args) {

}
public class Makenewpad(){

}//새로만들기

public class Save(){

}//파일저장

public class Open(){

}//파일열기

public class Search(){
System.out.print("검색하고자 하는 단어를 입력하세요: ");
}//검색기능


검색기능을 편집으로 분류할까 생각중입니다.