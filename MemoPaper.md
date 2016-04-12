#2011190717 김형준

# Introduction #
2011190717 김형준

고등학교때와 달리 대학교에선 필기할 내용이 상대적으로 많아졌다.
따라서 효율적으로 필기할 수 있는 메모장을 만들고자 한다.

# Background #

평소에 windows에 있는 메모장을 자주 사용하는데 그때마다  중요한 내용을 색을 구분했으면 좋겠다고 생각하였다. 뿐만아니라 메모장을 확대하는 형식이 아니라 좀더 세련된 느낌의 메모장을 만들고 싶어서 이러한 메모장을 생각해보았다.

# Details #
```
a.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;



public class SwingNotepad extends JFrame implements ActionListener {
  // 멤버 변수 정의
  JTextArea ta; // 편집할 수 있는 여러 줄 입력란
  JMenuBar menubar; // 메뉴바
  JMenu fileMenu, editMenu, fontMenu, helpMenu; // 파일 메뉴, 편집 메뉴
  JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem;// 메뉴아이템
  JMenuItem cancelItem, cutItem, copyItem, pasteItem, dateItem, allItem;
  JMenuItem  fontItem;
  JMenuItem  infoItem;

  //  생성자 정의
  public SwingNotepad() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X 클릭 => 종료
    setTitle("2011190717 김형준의 MemoPad");// 제목
    ta = new JTextArea();// ta 생성
    JScrollPane scroll = new JScrollPane(ta);// 스크롤에 ta 를 넣는다.
    add(scroll);// 스크롤을 프레임의 중앙에 붙인다.
    // getContentPane().add(scroll); // JDK 1.4일 경우의 코드
    menubar = new JMenuBar();// 메뉴바 생성
    setJMenuBar(menubar);// 메뉴바를 붙인다.
    fileMenu = new JMenu("File");
    menubar.add(fileMenu);// 메뉴바에 파일 메뉴 붙이기
    newItem = new JMenuItem("New");
    openItem = new JMenuItem("Open");
    saveItem = new JMenuItem("Save");
    saveAsItem = new JMenuItem("Save As");
    exitItem = new JMenuItem("Exit");
    fileMenu.add(newItem);
    fileMenu.add(openItem);
    fileMenu.add(saveItem);
    fileMenu.add(saveAsItem);
    fileMenu.addSeparator();// 구분선 넣기
    fileMenu.add(exitItem);
    newItem.addActionListener(this); // 감지기 붙이기
    openItem.addActionListener(this);
    saveItem.addActionListener(this);
    saveAsItem.addActionListener(this);
    exitItem.addActionListener(this);
    editMenu = new JMenu("Edit");// 편집 메뉴 생성
    menubar.add(editMenu);// 메뉴바에 편집 메뉴 붙이기
    copyItem = new JMenuItem("Copy");
    cutItem = new JMenuItem("Cut");
    pasteItem = new JMenuItem("Paste");
    allItem = new JMenuItem("All");
    dateItem = new JMenuItem("Date");
    cancelItem = new JMenuItem("Cancel");
    editMenu.add(cancelItem);
    editMenu.add(copyItem);
    editMenu.add(cutItem);
    editMenu.add(pasteItem);
    editMenu.add(allItem);
    editMenu.add(dateItem);
    cancelItem.addActionListener(this);
    copyItem.addActionListener(this); // 감지기 붙이기
    cutItem.addActionListener(this);
    pasteItem.addActionListener(this);
    allItem.addActionListener(this);
    dateItem.addActionListener(this);
    fontMenu = new JMenu("Font");
    menubar.add(fontMenu);
    fontItem = new JMenuItem("Font");
    fontMenu.add(fontItem);
    fontItem.addActionListener(this);
    helpMenu = new JMenu("Help");
    menubar.add(helpMenu);
    infoItem = new JMenuItem("Info");
    helpMenu.add(infoItem);
    infoItem.addActionListener(this);
    setBounds(300, 300, 600, 400);// 크기 지정(x 좌표, y 좌표, 가로, 세로)
    setVisible(true);// 보이기
  }// 생성자

  // 이벤트 처리
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == exitItem) {
      System.exit(0); // 프로그램 종료
    }
    if (obj == newItem) {
      ta.setText(""); // ta 를 지운다.
    }
    if (obj == openItem) {
      openFile(); // 파일 열기 메소드 호출
    }// if
    if (obj == saveItem) {
      saveFile(); // 파일 저장 메소드 호출
    }// if
    if (obj == copyItem) { // 복사하기 선택시
      ta.copy();
      copyItem.setEnabled(false);
      cutItem.setEnabled(false);
    }// if
    if (obj == cutItem) {
      ta.cut();
      copyItem.setEnabled(false);
      cutItem.setEnabled(false);
    }// if
    if (obj == pasteItem) {
      ta.paste();
      copyItem.setEnabled(true);
      cutItem.setEnabled(true);
    }// if
    if (obj == allItem) {
      ta.selectAll(); // 모두 선택
    }// if
    if (obj == dateItem) {
      java.util.Date date = new java.util.Date();
      ta.append(date.toLocaleString());// 간단한 날짜/시간 추가
    }// if
  }// actionPerformed

  private void openFile() {  //  파일 열기
    JFileChooser chooser = new JFileChooser();
    int returnVal = chooser.showOpenDialog(this);// 열기 대화상자
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = chooser.getSelectedFile();
      System.out.println(file.getName() + "선택됨");
      // 이 부분은 I/O 공부 후 진행^^
      BufferedReader br = null;
      try {
        br = new BufferedReader(new FileReader(file));
        String text = "";
        while ((text = br.readLine()) != null) {
          ta.append(text + "\r\n");// 줄바꿈( Win : \r\n, Unix : \n )
        }// while
        br.close();
      } catch (Exception e) {
        e.printStackTrace();// 예외 메시지 자세히 출력
      }// catch
    }// if
  }// openFile

  private void saveFile() {  //  파일 저장
    JFileChooser chooser = new JFileChooser();
    int returnVal = chooser.showSaveDialog(this);// 저장 대화상자
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = chooser.getSelectedFile();
      System.out.println(file.getName() + "선택됨");
      BufferedWriter bw = null;
      try {
        bw = new BufferedWriter(new FileWriter(file));
        bw.write(ta.getText());// ta 내용 읽어서 파일에 저장
        bw.flush();// 즉시 저장
        bw.close();// 닫기
      } catch (Exception e) {
        e.printStackTrace();// 예외 메시지 자세히 출력
      }// catch
    }// if
  }// saveFile

  public static void main(String[] args) {
    new SwingNotepad();
  }// main
}// end}
```



# Using the Code #