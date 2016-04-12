# 차례 #

**1. 프로젝트 개요**

**2. 분석**

**3. 소스 파일**

**4. 실행 화면**

**5. 참고 자료**





# 1. 프로젝트 개요 #


## 게임 규칙: ##

# 가로, 세로 각 행과 열에 있는 숫자의 수만큼 연속해서 칸을 채우면 된다.

# 한 줄에 숫자가 2개 이상인 경우에는 쓰여있는 숫자대로 칸을 칠하고, 첫 번째 숫자에 속해서 칠해진 부분과 그 다음 숫자에 속해서 칠해진 부분 사이에는 한 칸 이상을 공란으로 두어야 한다.


## 게임 기획: ##

# 마우스로 퍼즐을 풀 수 있도록 한다. 왼쪽 마우스 버튼으로는 색칠을 하고, 오른쪽 마우스 버튼으로는 X표시를 한다. 한 번 클릭한 칸을 다시 클릭하면 지워진다.

# 어느 칸을 마우스 커서로 가리키고 있는지 분명하도록, column과 row에서 마우스 커서의 위치를 표시한다.

# 문제를 푸는 동안에는 파란색 원과 빨간색 X표시로 나타내고, 문제를 푼 경우에는 검정색으로 원이 그려진 칸을 까맣게 칠하고 X표시는 제거한다.

# 참고 자료에서 더 나아가 정답 화면을 보거나 나가기, 정보 표시등의 창을 추가한다.




# 2. 분석 #

## 클래스 개요 ##

http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EB%B6%84%EC%84%9D1.PNG

http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EB%B6%84%EC%84%9D2.PNG

http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EB%B6%84%EC%84%9D3.PNG

http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EB%B6%84%EC%84%9D4.PNG

http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EB%B6%84%EC%84%9D5.PNG

http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EB%B6%84%EC%84%9D6.PNG

## 중요 메소드 기능 ##

**public void showLocation(int mouseX, int mouseY)** _마우스 커서의 위치를 표시_

**public void display()** _퍼즐이 풀렸는지 여부를 검사_

### display() 메소드 중 ###
```
0001000000011100001101010000101111111110111111111000011111100001111100000100010000010001000011001100
```
이 데이터 파일을 읽어서 사용자가 마우스로 클릭하여 칸을 채우면 같은지 비교한다. 따라서 두 개의 변수가 필요하게 된다. 하나는 정답 데이터 값을 읽어서 저장해둔 data 변수이고, 다른 하나는 사용자의 입력을 저장한 temp 변수이다.


```
String data; //문제
int[] temp; //사용자가 입력한 답
```
data에 저장되는 문자열은 ‘1’또는 ‘0’ 문자가 100개이다. 따라서 각 문자는 해당 위치의 칸의 상태로, 칠해진 칸은 ‘1’, 비어있는 칸은 ‘0’이 된다. 사용자의 입력을 나타내는 temp에 저장되는 값에는 0과 1, 그리고 2가 있다. 0은 아무것도 표시하지 않은 칸(초기값), 1은 ●표시, 2는 X표시 이다. 따라서 data의 모든 ‘1’인 칸에 해당하는 temp의 값이 1이고, data의 모든 ‘0’인 칸에 해당하는데 temp의 값이 1이 아니면 퍼즐은 풀린다. 이것은 다음과 같이 실행된다.



```
boolean endFlag = true;
for(int j=0; (j<10)&&endFlag; j++)
	for(int i=0; (i<10)&&endFlag; i++)
	{
		if((data.charAt(j*10+i)=='1')&&(temp[j*10+i]!=1))
		     endFlag=false; 
                     //채워야 할 칸을 모두 채웠는지 검사
		else if((data.charAt(j*10+i)!='1')&&(temp[j*10+i]==1))
		     endFlag=false; 
                     //채우지 않아야 할 칸을 채웠는지 검사
         }
```
이것을 실행하고 endFlag의 값이 true이면 퍼즐은 풀린 것이다.





# 3.소스 파일 #
## Nemonemo.java ##
```
import javax.swing.*; //스윙 패키지 선언
import java.awt.*; //awt 패키지 선언
import java.awt.event.*;
import java.io.*;

//JFrame으로부터 상속받은 CloseableFrame 상속
public class Nemonemo extends CloseFrame implements ActionListener{
	JPanel contentPane;
	
	//메뉴
	JMenuBar menuBar = new JMenuBar();
	JMenu gameMenu = new JMenu("Game");
	JMenu infoMenu = new JMenu("Info");
	
	//클래스 선언
	Board board;
	Column col;
	Row row;
	
	//마우스 커서의 좌표 설정
	int mouseX = -1;
	int mouseY = -1;
	
	String data = "0001000000011100001101010000101111111110111111111000011111100001111100000100010000010001000011001100"; //강아지 모양 판
	int[] temp; //플레이어가 입력한 답
	
	int columnNums[][]; //해당 열에 연속한 '1'의 개수를 표시
	int numOfColumn[]; //'0'으로 끊어진 연속한 1의 개수가 몇 개인가를 표시
	int rowNums[][]; //해당 행에 연속한 '1'의 개수를 표시
	int numOfRow[]; //'0'으로 끊어진 연속한 1의 개수가 몇 개인가를 표시
	
	boolean endFlag = false; //퍼즐 해결 여부
	
	public static void main(String args[]){ //게임 시작점
	    Nemonemo nemo = new Nemonemo(); //게임 생성
		nemo.addWindowListener(new WindowAdapter(){	
			public void windowCloses(WindowEvent e){
				System.exit(0);
			}
		});
		nemo.setVisible(true);
		nemo.toFront();
	}
	
	public Nemonemo(){
		this.setTitle("Nemonemo Logic"); //게임 창의 타이틀 설정
		this.setSize(341, 390); //게임 크기 설정
			
		temp = new int[100]; //가로 10칸, 세로 10칸 선언
		for(int i=0; i<100; i++){ //입력 전 0으로 초기화
			temp[i] = 0;
		}
		
		columnNums = new int[10][10];
		numOfColumn = new int[10];
		rowNums = new int[10][10];
		numOfRow = new int[10];
			
		contentPane = (JPanel) getContentPane();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null); //null 레이아웃으로 설정
			 
		createMenus(); //메뉴 생성
			
		//column 생성
		col = new Column(this);
		contentPane.add(col);
		col.setFont(new Font("SansSerif", Font.BOLD, 14));
		col.setBounds(120, 0, 201, 120);
		col.repaint();
			
		//row 생성
		row = new Row(this);
		contentPane.add(row);
		row.setFont(new Font("SansSerif", Font.BOLD, 14));
		row.setBounds(0, 120, 120, 201);
			
		//board 생성
		board = new Board(this);
		contentPane.add(board);
		board.setFont(new Font("SansSerif", Font.BOLD, 14));
		board.setBounds(120, 120, 201, 201);
	}
		
	public void createMenus(){
		this.setJMenuBar(menuBar);
		menuBar.add(gameMenu);
		menuBar.add(infoMenu);
			
		//Game 메뉴의 하위메뉴 생성
		JMenuItem answerGame = new JMenuItem("Answer");
		answerGame.addActionListener(this);
		answerGame.setActionCommand("answerGame");
		gameMenu.add(answerGame);
			  
	    JMenuItem exitGame = new JMenuItem("Exit");
	    exitGame.addActionListener(this);
	    exitGame.setActionCommand("exitGame");
		gameMenu.add(exitGame);
			  
		//info 메뉴의 하위메뉴 생성
		JMenuItem aboutGame = new JMenuItem("About Game");
	    aboutGame.addActionListener(this);
		aboutGame.setActionCommand("aboutGame");
		infoMenu.add(aboutGame);
	}

	public void showLocation(int mouseX, int mouseY){ //마우스 커서 위치 표시
		if(mouseX!=this.mouseX){ //마우스 커서의 열 위치
			this.mouseX = mouseX;
			col.repaint();
		}
			
		if(mouseY!=this.mouseY){ //마우스 커서의 행 위치
			this.mouseY = mouseY;
			row.repaint();
		}
	}
		
	public void display(){ //퍼즐 해결 여부
		boolean endFlag = true;
		
		for(int j=0; (j<10)&&endFlag; j++)
			for(int i=0; (i<10)&&endFlag; i++){
				if((data.charAt(j*10+i)=='1')&&(temp[j*10+i]!=1))
					endFlag=false;
				else if((data.charAt(j*10+i)!='1')&&(temp[j*10+i]==1))
					endFlag=false;
			}
		
		if(endFlag){
			this.endFlag = endFlag;
			board.repaint(); //퍼즐이 다 풀렸으면 보드의 칸을 채움
		}
	}
		
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
			
		if(cmd.equals("answerGame")){ //Answer를 선택시 정답 출력
			this.endFlag = true;
			board.repaint();
		}
		else if(cmd.equals("exitGame")) //게임 종료
			this.dispose();
		else if(cmd.equals("aboutGame")) //게임 정보를 출력
				showAboutDialog();
	}
		
		//메뉴에서 About Game 선택 시 출력하는 게임 정보
	public void showAboutDialog() {
		AboutDialog ad = new AboutDialog(this);
		ad.setVisible(true);
	}
}
```


## Board.java ##
```
import java.awt.*; //awt 패키지 선언
import java.awt.event.*;
	
public class Board extends Canvas //Canvas 클래스를 상속
	implements MouseListener, MouseMotionListener{	
	
	Nemonemo parent; //Nemonemo 클래스의 객체를 저장
	boolean drag = false; //마우스 상태 확인
	int startX, startY; //마우스 드래그를 시작한 좌표
	int endX, endY; //마우스 드래그를 끝마친 좌표
	
	Image offScr; //가상화면 선언
	Graphics offG;
	
	public Board(Nemonemo parent){ //Nemonemo 클래스의 객체를 보관하고 리스너를 선언
	    this.parent = parent;
		this.addMouseListener(this); //마우스 리스너 선언
		this.addMouseMotionListener(this);
	}
	
	public void paint (Graphics g){ //화면에 보드의 상태를 출력
	    offScr = createImage(201, 201); //가상화면 생성
		offG = offScr.getGraphics();
		
		for(int j=0; j<10; j++)
			for(int i=0; i<10; i++){
				if(parent.endFlag){ //게임 끝
				    if(parent.data.charAt(j*10+i)=='1'){
				    	offG.fillRect(i*20, j*20, 20, 20); //칸 채우기
					}
				}else{
					if(parent.temp[j*10+i]==1){
						offG.setColor(Color.blue); //게임 진행중 ●표시
						offG.fillOval(i*20, j*20, 20, 20);
					}else if(parent.temp[j*10+i]==2){
						offG.setColor(Color.red); //게임 진행중 X표시
						offG.drawLine(i*20, j*20, i*20+20, j*20+20);
						offG.drawLine(i*20, j*20+20, i*20+20, j*20);
					}
				}
			}
		
		if(drag){ //마우스 드래그
			offG.setColor(Color.yellow);
			if(startX==endX){
				if(startY<endY){
					offG.fillRect(20*startX, 20*startY, 20, 20*(endY-startY+1));
					offG.setColor(Color.red);
					offG.drawString(String.valueOf(endY-startY+1), endX*20+2, (endY+1)*20-2);
				}else{
					offG.fillRect(20*endX, 20*endY, 20, 20*(startY-endY+1));
					offG.setColor(Color.red);
					offG.drawString(String.valueOf(startY-endY+1), endX*20+2, (endY+1)*20-2);
				}
			}
			else if(startY==endY){
				if(startX<endX){
					offG.fillRect(20*startX, 20*startY, 20*(endX-startX+1), 20);
					offG.setColor(Color.red);
					offG.drawString(String.valueOf(endX-startX+1), endX*20+2, (endY+1)*20-2);
				}else{
					offG.fillRect(20*endX, 20*endY, 20*(startX-endX+1), 20);
					offG.setColor(Color.red);
					offG.drawString(String.valueOf(startX-endX+1), endX*20+2, (endY+1)*20-2);	
				}
			}
		}
		
		for(int j=0; j<10; j++)
			for(int i=0; i<10; i++){
				offG.setColor(Color.black);
				offG.drawRect(i*20, j*20, 20, 20);
			}
		
		offG.setColor(Color.black);
		
		for(int i=0; i<=200; i+=20*5){
			offG.drawLine(i-1, 0, i-1, 200);
			offG.drawLine(i+1, 0, i+1, 200);
		}
		
		for(int i=0; i<=200; i+=20*5){
			offG.drawLine(0, i-1, 200, i-1);
			offG.drawLine(0, i+1, 200, i+1);
		}
		
		g.drawImage(offScr, 0, 0, this); //가상 화면을 실제 화면으로 복사
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	@Override
	public void mousePressed(MouseEvent e){ //마우스 버튼을 누른 경우
        int x = e.getX();
		int y = e.getY();
		
		if((x/20)>=10) return;
		if((y/20)>=10) return;
		if(parent.endFlag)return;
		
		startX = x/20;
		startY = y/20;
	}
	
	public void mouseReleased(MouseEvent e){ //마우스 버튼을 놓은 경우
		int x = e.getX();
		int y = e.getY();
		
		if((x/20)>=10) return;
		if((y/20)>=10) return;
		if(parent.endFlag)return;
		
		if((e.getModifiers() & InputEvent.BUTTON3_MASK)!=0){ //마우스 오른쪽
			setTemp(x, y, 2);
		}else{ //마우스 왼쪽
			setTemp(x, y, 1);
		}
		
		parent.display(); //퍼즐 해결 여부
		this.drag = false;
		repaint();
	}
	
	public void mouseMoved(MouseEvent e){ //마우스가 움직인 경우
	    int x = e.getX();
		int y = e.getY();
		
		if((x/20)>=10) return;
		if((y/20)>=10) return;
		
		parent.showLocation(x/20, y/20); //column과 row에 마우스 커서 위치 표시
		repaint();		
	}
	
	public void mouseExited(MouseEvent e){ //마우스가 보드를 벗어난 경우
		parent.showLocation(-1, -1); //마우스 커서의 위치 표시하지 않음
		this.drag = false;
		repaint();	
	}
	
	public void mouseClicked(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e){ //마우스 드래그
		int x = e.getX();
		int y = e.getY();
		
		if((x/20)>=10) return;
		if((y/20)>=10) return;
		
		parent.showLocation(x/20, y/20); //column과 row에 마우스 커서 위치 표시	
		this.drag = true;
		endX = x/20;
		endY = y/20;
		repaint();	
	}
	
	private void setTemp(int x, int y, int value){ //입력을 temp에 저장
		int i;
		
		if(drag){
			if(startX==endX){
				if(startY<endY){
					for(i=startY; i<=endY; i++){
						parent.temp[startX+i*10] = value;
					}
				}else if(startY>endY){
					for(i=endY; i<=startY; i++){
						parent.temp[startX+i*10] = value;
					}
				}else{
					if(parent.temp[startX+startY*10]!=0)
						parent.temp[startX+startY*10] = 0;
					else
						parent.temp[startX+startY*10] = value;
				}
			}else if(startY==endY){
				if(startX<endX){
					for(i=startX; i<=endX; i++){
						parent.temp[i+startY*10] = value;
					}
				}else if(startX>endX){
					for(i=endX; i<=startX; i++){
						parent.temp[i+startY*10] = value;
					}
				}else{
					if(parent.temp[startX+startY*10]!=0)
						parent.temp[startX+startY*10] = 0;
					else
						parent.temp[startX+startY*10] = value;
				}
			}
		}
		else{
			if(parent.temp[x/20+y/20*10]!=0)
				parent.temp[x/20+y/20*10] = 0;
			else
				parent.temp[x/20+y/20*10] = value;
		}
	}

}
```


## Column.java ##
```
import java.awt.*; // awt 패키지 선언

public class Column extends Canvas{ //Canvas 클래스를 상속
	Nemonemo parent; //객체 저장
	
	Image offScr; //가상 화면
	Graphics offG;
	
	public Column(Nemonemo parent){ //모든 열의 연속한 '1'의 개수를 계산
		this.parent = parent; //객체 보관
		getColumn();
	}
	
	public void getColumn(){ //column의 숫자를 생성
		for(int i=0; i<10; i++) {//모든 열에 연속한 1의 개수
			parent.numOfColumn[i] = getNumber(i);
		}
	}
		
	int getNumber(int start){ //해당 열의 연속한 1의 개수
		int count = 0; //연속된 1의 개수
		int pos = 0; //1의 개수 나타난 순서
			
		for(int i = start; i<100; i+=10){ //같은 열에 속한 값 비교
			if(parent.data.charAt(i)=='0' && count>0){ //연속하지 않은 경우
				parent.columnNums[start][pos++] = count;
				count = 0;
			}else if(parent.data.charAt(i)=='1' && count>=0){ //연속한 경우
				count++;
			}
		}
			
		if(count>0)
			parent.columnNums[start][pos++] = count;
		
		if(pos==0)
			parent.columnNums[start][pos++] = 0;
			
		return pos;
	}
		
	public void paint (Graphics g){ //column 출력
		offScr = createImage(201, 121); //가상 화면 생성
		offG = offScr.getGraphics();
		
		if(parent.mouseX!=-1){
			offG.setColor(Color.yellow);
			offG.fillRect(20*parent.mouseX, 0, 19, 120); //열에 마우스 커서 존재
		}
		
		offG.setColor(Color.black);
			
		for(int i=0; i<10; i++){
			offG.drawLine(i*20, 0, i*20, 220);
			for(int j=0; j<parent.numOfColumn[i]; j++){ //숫자 출력
				if(String.valueOf(parent.columnNums[i][j]).length()<2)
					offG.drawString(String.valueOf(parent.columnNums[i][j]), i*20+9, (100-parent.numOfColumn[i]*20+j*20)+39);
				else
					offG.drawString(String.valueOf(parent.columnNums[i][j]), i*20+1, (100-parent.numOfColumn[i]*20+j*20)+39);
			}
		}
				
		for(int i=0; i<=20*10; i+=20*5){
			offG.drawLine(i-1, 0, i-1, 120);
			offG.drawLine(i+1, 0, i+1, 120);
		}
				
		offG.drawLine(200, 0, 200, 120);
		offG.drawLine(0, 120, 200, 120);
				
		g.drawImage(offScr, 0, 0, this);
	}
		
	public void update(Graphics g){
		paint(g);
	}
}
```


## Row.java ##
```
import java.awt.*; //awt 패키지 선언

public class Row extends Canvas{ //Canvas 클래스를 상속
	Nemonemo parent; //객체 저장
	
	Image offScr; //가상 화면
	Graphics offG;
	
	public Row(Nemonemo parent){ //모든 행의 연속한 1의 개수를 계산
		this.parent = parent; //객체 보관
		getRow(); 
	}
	
	public void getRow(){ //row의 숫자를 생성
		for(int i=0; i<10; i++){ //모든 행에 연속한 1의 개수
			parent.numOfRow[i] = getNumber(i);
		}
	}
		
	int getNumber(int start){ //해당하는 행의 연속한 '1'의 개수를 계산
		int count = 0; //연속된 1의 개수
		int pos = 0; //1의 개수 나타난 순서
			
		for(int i=start*10; i<(start+1)*10; i++){ //같은 행에 속한 값 비교
			if(parent.data.charAt(i)=='0' && count>0){ //연속하지 않은 경우
				parent.rowNums[start][pos++] = count;
				count = 0;
			}else if(parent.data.charAt(i)=='1' && count>=0){ //연속한 경우
				count++;
			}
		}
			
		if(count>0)
			parent.rowNums[start][pos++] = count;
		if(pos==0)
			parent.rowNums[start][pos++] = 0;
			
		return pos;
	}
		
	public void paint (Graphics g){ //row 출력
		offScr = createImage(121, 201); //가상 화면 생성
		offG = offScr.getGraphics();
		
		if(parent.mouseY!=-1){
			offG.setColor(Color.yellow);
			offG.fillRect(0, 20*parent.mouseY, 120, 19); //행에 마우스 커서 존재
		}
		
		offG.setColor(Color.black);
			
		for(int i=0; i<10; i++){
			offG.drawLine(0, i*20, 120, i*20);
			for(int j=0; j<parent.numOfRow[i]; j++){ //숫자 출력
				if(String.valueOf(parent.rowNums[i][j]).length()<2)
					offG.drawString(String.valueOf(parent.rowNums[i][j]), (100-parent.numOfRow[i]*20)+j*20+27, i*20+18);
				else
					offG.drawString(String.valueOf(parent.rowNums[i][j]), (100-parent.numOfRow[i]*20)+j*20+21, i*20+18);
			}
		}
				
		for(int i=0; i<=20*10; i+=20*5){
			offG.drawLine(0, i-1, 120, i-1);
			offG.drawLine(0, i+1, 120, i+1);
		}
				
		offG.drawLine(0, 200, 120, 200);
		offG.drawLine(120, 0, 120, 200);
				
		g.drawImage(offScr, 0, 0, this);
	}
		
			
	public void update(Graphics g){
		paint(g);
	}
}
```


## AboutDialog.java ##
```
import javax.swing.*; //스윙 패키지 선언
import java.awt.*;
import java.awt.event.*;

public class AboutDialog extends JDialog //스윙의 JDialog 상속
	implements ActionListener, WindowListener{
	
	JPanel aboutPanel;
	JButton ok;
	JLabel titleLabel, nameLabel;
	
	public AboutDialog(Nemonemo parent){
		super(parent, "Nemonemo Logic", true); //다이얼로그 타이틀
		this.setSize(240, 190); //다이얼로그 크기 설정
		this.addWindowListener(this);
		this.setLayout(new BorderLayout(15, 15));
		this.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		createAboutPanel();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==ok){
			this.dispose();
		}
	}
	
	public void createAboutPanel(){
		aboutPanel = new JPanel();
		aboutPanel.setLayout(null);
		
		//About Game 정보
		titleLabel = new JLabel("Nemonemo Logic 2012/12");
		aboutPanel.add(titleLabel);
		titleLabel.setBounds(40, 30, 200, 25);
		
		nameLabel = new JLabel("made by. Sungmi Kim");
		aboutPanel.add(nameLabel);
		nameLabel.setBounds(50, 60, 200, 25);
		
		//다이얼로그 종료 버튼
		ok = new JButton("Okay");
		ok.addActionListener(this);
		aboutPanel.add(ok);
		ok.setBounds(80, 110, 80, 25);
		
		this.add("Center", aboutPanel);
	}
	
	public void windowClosing(WindowEvent e) {this.dispose();}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
```


## CloseFrame.java ##
```
import javax.swing.*; //스윙 패키지 선언
import java.awt.event.*; //awt 패키지 선언

public class CloseFrame extends JFrame //스윙의 JFrame 상속
	implements WindowListener{
	
	public CloseFrame(){
		this.addWindowListener(this);
	}
	
	public CloseFrame(String title){
		super(title);
		this.addWindowListener(this);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {this.dispose();}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
```


## 소스 압축 ##
http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%86%8C%EC%8A%A4.zip


# 4. 실행 화면 #

### 1) 시작 화면 ###
![http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B41.png](http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B41.png)


### 2) Game메뉴 클릭 ###
![http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B42.png](http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B42.png)


### 3) Game - Answer 클릭 ###
![http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B43.png](http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B43.png)


### 4) Info메뉴 클릭 ###
![http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B44.png](http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B44.png)


### 5) Info - About Game 클릭 ###
![http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B45.png](http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B45.png)


### 6) 게임 실행중 ###
![http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B46.png](http://comp166-koreauniv.googlecode.com/files/2012190714%EA%B9%80%EC%84%B1%EB%AF%B8-%EC%8B%A4%ED%96%89%ED%99%94%EB%A9%B46.png)





# 5. 참고 자료 #
**임동혁 저, 『게임을 만들며 배우는 자바 프로그래밍』, 제우미디어, 2002** _네모네모로직 게임 알고리즘 부분 참조, 메뉴 및 데이터는 배운 것으로 응용해서 추가_

**케이시 시에라, 버트 베이츠 저, 『Head First Java』, 한빛미디어, 2005**