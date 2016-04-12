# Introduction #

전화번호와 메모를 저장하고 찾아볼수 있는 전화번호관리 프로그램입니다.

---

# Details #

어느날 친구와 전화하다가 액정에 생일이 뜬 덕분에 미리 생일 축하한다고 말 했던 경험에

서 착안해 전화번호와 상대의 중요한 기념일을 같은 메모를 기록할 수 있는 프로그램을 만

들 것입니다. 누구나 친한 친구나, 가족들의 생일을 깜빡해서 당황스러웠던 기억들이 있었

을 것입니다. 이 프로그램은 그러한 상황을 방지 해주는데 효과적인 프로그램이 될것입니

다. 또 이 프로그램은 일반 사람들 뿐만 아니라 서비스업종에 종사하는 분들께 더 유용할

수 있는데 고객의 생일과 같은 기념일을 저장할 수 있기 때문입니다. 고객과의 유대와 친밀

성이 생명인 서비스업 종사자들에게는 필수적인 프로그램이 될것입니다. 또 이름 검색을 통

해 정보를 찾을 수 있어 정보 접근을 용이하게 하였습니다.


---



## 기능 ##



### ◎ 상대정보(전화번호,메모)를 저장 가능 ###

### ◎ 전화번호,메모 등의 수정 가능 ###

### ◎ 이름을 통한 전화번호 검색 기능 ###

### ◎ 메모를 통해 부가적인 추가사항 기재 가능 ###

### ◎ 전화번호부 작성 후 저장 기능 ###




---




# 참고 자료 #

1) Head First Java - 케이시 시에라,버트 베이츠 저, 서환수 역, 한빛미디어

2) 난 정말 JAVA를 공부한 적이 없다구요 - 윤성우 저, 오렌지 미디어

3) 성균관대 전전컴에 다니는 친구의 엄청난 도움 (전체적인 틀을 짜줬어요)




---





# 실행 화면 스크린샷 #






## 1.우선 전체 화면입니다. ##
http://comp166-koreauniv.googlecode.com/files/1%EC%A0%84%EC%B2%B4.PNG


## 2."전화번호 추가/변경 및 메모 추가" 버튼을 눌렀을 때 나타나는 화면입니다. ##
http://comp166-koreauniv.googlecode.com/files/2%EC%9D%B4%EB%A6%84%EC%9D%84%20%EC%9E%85%EB%A0%A5%ED%95%98%EC%84%B8%EC%9A%94.PNG

http://comp166-koreauniv.googlecode.com/files/3%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8%EB%A5%BC%20%EC%9E%85%EB%A0%A5%ED%95%98%EC%84%B8%EC%9A%94.PNG

http://comp166-koreauniv.googlecode.com/files/4%EB%A9%94%EB%AA%A8%EB%A5%BC%20%EC%9E%85%EB%A0%A5%ED%95%98%EC%84%B8%EC%9A%94.PNG

http://comp166-koreauniv.googlecode.com/files/5%EC%B6%94%EA%B0%80.PNG


## 3."전화번호 찾기" 버튼을 누르고 '허능호'를 찾기 했을 때 나타나는 화면입니다. ##
http://comp166-koreauniv.googlecode.com/files/6%EC%B0%BE%EA%B8%B0.PNG



## 4."현재상태 저장" 버튼을 누르고 나서 저장된 내용이 메모장에 있나 확인해 본 화면입니다. ##
http://comp166-koreauniv.googlecode.com/files/8%EB%A9%94%EB%AA%A8%EC%9E%A5%20%ED%99%94%EB%A9%B4.PNG



## 5."전화번호 삭제" 버튼을 눌러 이제막 저장했던 '허능호'에 관한 전화번호부를 삭제한 화면입니다. ##
http://comp166-koreauniv.googlecode.com/files/7%EC%82%AD%EC%A0%9C.PNG



## 6.삭제한 이후 메모장에 '허능호'에 관한 내용이 삭제 된것을 확인해 본 화면입니다. ##
http://comp166-koreauniv.googlecode.com/files/10%EC%82%AD%EC%A0%9C%ED%9B%84%EC%9D%98%EB%A9%94%EB%AA%A8%EC%9E%A5.PNG



## 7.메뉴창의 X표를 눌렀을 때 '나가기' 버튼을 누루게 하기 위한 JOptionPane.showMessageDialog 창을 확인해 본 화면입니다. ##
http://comp166-koreauniv.googlecode.com/files/9%20X%ED%91%9C%20%EB%88%8C%EB%A0%80%EC%9D%84%EB%95%8C.PNG



## 8."나가기" 버튼을 눌러 프로그램을 종료합니다. ##


---


# Code #

Element클래스입니다.
```
package Phonenumber;

public class Element { //전화번호부의 요소들(이름,번호,메모)를 위한 클래스입니다.
	private String name;     //name 을 인스턴스 변수로 설정합니다.
	private String number;   //number 을 인스턴스 변수로 설정합니다.
	private String memo;     //memo 를 인스턴스 변수로 설정합니다.
	


	public Element(String name, String number, String memo) {   
		this.name = name;										
		this.number = number;									
		this.memo = memo;
	} //매개변수로 받은 name, number, memo 를 인스턴스 변수로 설정합니다. 일종의 세터입니다.
	  //this는 인스턴스 변수와 매개변수를 차별해주는 용도로 쓰였습니다.

	public String getName() { //이 메소드를 실행시키면 이름을 얻을 수 있습니다. 따라서 게터라고 볼 수 있습니다. 
		return name;
	}

	public String getNumber() { //이 메소드를 실행시키면 전화번호를 얻을 수 있습니다. 따라서 게터라고 볼 수 있습니다.
		return number;
	}

	public String getMemo() { //이 메소드를 실행시키면 메모를 얻을 수 있습니다. 따라서 게터라고 볼 수 있습니다.
		return memo;
	}
	
	public void changeNumber(String number) { //매개변수로 받은 number로 전화번호를 바꿉니다.
		this.number = number;
	}
	
	public void changeMemo(String memo) { //매개변수로 받은 memo로 메모를 바꿉니다.
		this.memo = memo;
	}
}

```

GUI 클래스입니다.
```

package Phonenumber;

import javax.swing.JOptionPane;

public class GUI { //화면의 전체 레이아웃을 설정하는 GUI 클래스입니다.
	private Function theDirectory = null; // Function 클래스의 메소드를 써야하기에 인스턴스 변수로 
										  // Function 를 위한 레퍼런스 변수 하나를 만듭니다.

	/** GUI를 표시하고, 전화번호부 기능을 수행하는 함수 */
	public void processCommands(Function theFunction) { //GUI 를 나타내고, 전화번호부 기능목록의 실행을
														//담당하는 메소드입니다. 따라서 Application 클래스에서
														//이 메소드를 실행해야 합니다. 맨처음 나오는 화면이 
														//이 메소드안에 구현되어 있기 때문입니다.
		
		String[] commands = { "전화번호 추가/변경 \n및 메모 추가", "전화번호 찾기",
				"전화번호 삭제", "현재상태 저장", "나가기" }; // 전화번호부 기능목록을 나타냅닌다.
	
		theDirectory = theFunction; // Function 클래스의 메소드를 써야하기 때문에 매개변수로 넘어온
									// Function 객체와 연결시킵니다.

		int choice; // switch 문을 쓰기위해 choice 변수를 하나 만듭니다.

		do {
			choice = JOptionPane.showOptionDialog(null, "원하는 항목을 클릭하세요!",
					"허능호와 함께하는 전화번호부 입니다.", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, commands,
					commands[commands.length - 1]);
			//JOptionPane.showOptionDialog 매소드로 부모컴포넌트가 다이얼로그가 닫히기 전까지 활성화 될 수 업습니다.
			//표시될 내용으로 "원하는 항목을 클릭하세요!"를 나타냈고, 타이틀로는 "허능호와 함게하는 전호번호부 입니다." 를 출력했습니다.
			//다이어로그의 선택 버튼은 예,아니오,취소가 있는 옵션입니다. 또 질무하는 아이콘(?)이 생기게 하였습니다.
			//commands 들의 스트링 배열을 여기로 가져와서 선택 버튼으로 만듭니다. 그리고 기본으로 선택되어진 값은 맨 마지막 항목 입니다.
			
			if(choice == JOptionPane.CLOSED_OPTION) { // 타이틀에 있는 X 표를 눌렀을 경우
				JOptionPane.showMessageDialog(null,"능호와 함께한 전화번호부였습니다.\n       \"나가기\" 를 눌러주세요!!");
			} // "능호와 함께한 전화번호부였습니다."나가기" 를 눌러주세요!!" 를 showMessageDialog 로 나타내어서 "나가기"버튼을
			  // 누르도록 하였습니다.


			switch (choice) { 
			//매개변수로 받은 Function 클래스의 메소드들이 아래에 있습니다. 여기서 쓸려고 매개변수로 받은 것입니다.
			//위에서 choice 는 선택창을 눌렀을 때 그 선택된 항목의 commands 배열의 index 로 설정했습니다.
			case 0:
				doAddChangeEntry(); // "전화번호 추가/변경 및 메모 추가"를 누르면 실행되는 메소드입니다.
				break;
			case 1:
				doLookupEntry(); // "전화번호 찾기"를 누르면 실행되는 메소드 입니다.
				break;
			case 2:
				doRemoveEntry(); // "전화번호 삭제"를 누르면 실행되는 메소드 입니다.
				break;
			case 3:
				doSave(); // "현재상태 저장"를 누르면 실행되는 메소드 입니다.
				break;
			case 4:
				doSave(); // "나가기" 를 누르면 실행되는 메소드 입니다. 여기서는 나가기 눌러도 자동으로
						  // 저장이 되도록 했습니다. 나가게 하는 것은 아래의 코드에서 구현됩니다.
				break;
			}
		} while (choice <commands.length - 1); //만약 "나가기"를 눌렀다면 choice는 4가 될 것입니다.
											   //commands.length-1은 4이므로 이 반복문 조건을 충족하지
											   //못하게 됩니다. 따라서 다음 실행코드인 System.exit(0);
											   //으로 가게 되고 종료가 될 것입니다. 4가 아니라면 4가 
											   //나올때 까지 계속 반복 될 것입니다.
		System.exit(0); //프로그램을 빠져나옵니다.
	}


	private void doAddChangeEntry() { //전화번호부를 추가하거나 수정하는 메소드 입니다.
		String newName = JOptionPane.showInputDialog("이름을 입력하세요.");
		// JOptionPane.showInputDialog 를 이용해 "이름을 입력하세요."를 출력하고 입력된 값은 
		// newName 안에 저장합니다.
	
		if (newName == null) { //newName 값이 null 이라면 
			return; // 아무것도 없는 값을 리턴합니다.
		}
		String newNumber = JOptionPane.showInputDialog("전화번호를 입력하세요.");
		// JOptionPane.showInputDialog 를 이용해 "전화번호를 입력하세요."를 출력하고 입력된 값은 
		// newNumber 안에 저장합니다.
		
		if (newNumber == null) { //newNumber 값이 null 이라면
			return;  // 아무것도 없는 값을 리턴합니다.
		}
		
		
		String newMemo = JOptionPane.showInputDialog("메모를 입력하세요.");
		// JOptionPane.showInputDialog 를 이용해 "메모를 입력하세요."를 출력하고 입력된 값은 
		// newMemo 안에 저장합니다.
		
		if (newMemo == null) { //newMemo 값이 null 이라면
			return;  // 아무것도 없는 값을 리턴합니다.
		}
		
		String oldNumber = theDirectory.addOrChangeEntry(newName, newNumber, newMemo);
		// addOrChangeEntry 를 실행해서 전화번호부를 추가하거나 바뀐내용으로 설정합니다. 
		// 여기서 반환되는 oldNumber 는 전화번호가 변경되었을 경우 예전의 전화번호입니다. 

		String message = null; //출력화면에 내보일 문장을 저장하는 String 변수입니다.
		
		if (oldNumber == null) { // oldNumber가 없다면 이전에 추가된 적이 없는 전화번호라는 얘기입니다.
			message = newName + " 님이 전화번호부에 추가되었습니다."
					+ "\n전화번호: " + newNumber + "\n메모: " + newMemo; 
			//message 에 위와 같은 내용이 저장됩니다.
			
		} else { //oldNumber가 있다면
			message = newName + " 님의 전화번호가 바뀌었습니다."
					+ "\n예전 전화번호: " + oldNumber + "\n현재 전화번호: "
					+ newNumber + "\n메모: " + newMemo;
		
		} // message 에 위와 같은 내용이 저장됩니다.
		
		JOptionPane.showMessageDialog(null, message);
		//JOptionPane.showMessageDialog을 이용해 message의 문구를 출력합니다.
	}


	private void doLookupEntry() { //저장된 연락처를 보여주는 메소드입니다.

		String theName = JOptionPane.showInputDialog("이름을 입력하세요.");
		// JOptionPane.showInputDialog 를 이용해 "이름을 입력하세요."를 출력하고 입력된 값은 
		// theName 안에 저장합니다.
		
		if (theName == null) { //theName이 없다면
			return;  // 아무것도 없는 값을 리턴합니다.
		}
		
		// theName이 있다면
		String theNumber = theDirectory.lookupEntry(theName);
		// theName 에 해당하는 전화번호를 가져와서 theNumber에 저장합니다.
		
		String theMemo = theDirectory.lookupEntry1(theName);
		// theName 에 해당하는 메모를 가져와서 theMemo에 저장합니다.
		
		String message = null; //출력화면에 내보일 문장을 저장하는 String 변수입니다.
		
		if (theNumber != null) { //theNumber 의 값이 있다면
			message = theName + " 님의 전화번호는 " + theNumber + " 입니다. " + "\n메모 내용은 " + theMemo + " 입니다.";
			//message에 위와 같은 내용을 저장합니다.
			
		} else { //theNumber의 값이 없다면
			message = "현재 입력하신분의 정보가 없습니다.";
			//message에 위와 같은 내용을 저장합니다.
		}
		JOptionPane.showMessageDialog(null, message);
		//JOptionPane.showMessageDialog을 이용해 message의 문구를 출력합니다.
	}


	

	private void doRemoveEntry() { //저장된 전화번호를 삭제하는 메소드입니다.

		String theName = JOptionPane.showInputDialog("이름을 입력하세요.");
		// JOptionPane.showInputDialog 를 이용해 "이름을 입력하세요."를 출력하고 입력된 값은 
		// theName 안에 저장합니다.
		
		if(theName == null){ //theName이 없다면
			return; // 아무것도 없는 값을 리턴합니다.
		}
		
		String theNumber = theDirectory.lookupEntry(theName);
		// theName 에 해당하는 전화번호를 가져와서 theNumber에 저장합니다.
		
		String theMemo = theDirectory.lookupEntry1(theName);
		// theName 에 해당하는 메모를 가져와서 theMemo에 저장합니다.
		
		String message = null; //출력화면에 내보일 문장을 저장하는 String 변수입니다.
		
		if(theNumber != null){ //theNumber 의 값이 있다면
			message = theName + " 님의 " + theNumber + "과 메모 " + theMemo +
			" 가 삭제 되었습니다.";
			//message에 위와 같은 내용을 저장합니다.
			
			theDirectory.removeEntry(theName); //그리고 theName에 해당하는 전호번호부를 삭제합니다.
			
		} else { //theNumber의 값이 없다면
			message = theName + " 님이 전화번호부에 저장되어 있지 않습니다.";
			//message에 위와 같은 내용을 저장합니다.
		}
		
		JOptionPane.showMessageDialog(null, message);
		//JOptionPane.showMessageDialog을 이용해 message의 문구를 출력합니다.
	}

	private void doSave() { //현재상태를 저장하는 메소드입니다.
		theDirectory.save(); //save메소드를 실행해 현재상태를 저장합니다.
	}
}

```

Function 클래스입니다.
```

package Phonenumber;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Function { //전화번호부를 만들기 위한 기능을 담고 있는 클래스입니다.
	private static final int MAX = 100; // 전화번호부를 최대 저장할 수 있는 갯수입니다.
										// 상수이기에 변수를 상수로 바꿔주는 static final 을 이용했습니다.
	private int capacity = MAX; // capacity 에 MAX의 값 100을 넣습니다. 
	private int savenumber = 0; // 현재 저장되어 있는 전화번호의 개수를 저장하기 위한 변수입니다.
	private Element[] theDirectory = new Element[capacity]; // 전화번호를 저장하기 위한 배열을 만들어
															// 그 이름을 theDirectory라고 지정합니다.
	private String txtfile = null; // 전화번호부 파일의 이름을 나타낼때 쓰일것입니다.
	private boolean modified = false; // 전화번호부 수정이 되었다면 true 로 바뀌게 해서 현재상태 저장을 하게
									  // 할 것입니다. 아직은 안된 상태이니 false로 둡니다.


	public void loadData(String txtfile) throws IOException { //'매개변수'의 이름을 가진 파일을 읽어 그 안에
		this.txtfile = txtfile;								  //있는 전화번호부를 읽어 오는 매소드입니다.
		try {
			BufferedReader in = 
					new BufferedReader(new FileReader(txtfile));
			// '매개변수'의 이름을 가진 파일로부터 데이터를 읽어 버퍼에 저장합니다.

			String name, number,memo;
			while ((name = in.readLine()) != null) { // 엔터치기전까지 읽었는데 이름이 있다면 true 입니다.
				if ((number = in.readLine()) == null) { // 그 다음 엔터치기전까지 읽었는데 전화번호 값이
					break; // 중지						// null 이면 break 를 써 while 문을 빠져나옵니다.
				} else { 
					memo=in.readLine(); // 전화번호 값이 있다면 이제 그 다음줄의 memo 의 값도 읽습니다.
				}
				add(name, number,memo); // in.readLine()을 써서 순서대로 읽은 name, number, memo 를
			}							// add 매소드를 써서 전화번호부에 추가시킵니다.
			in.close();
		} catch (FileNotFoundException ex) { // 파일을 찾을 수 없을 때의 실행됩니다.
			return;
		}
	}


	

	public String addOrChangeEntry(String name, String number,String memo) { //전화번호를 추가하거나
																			 //수정할 때 쓰이는 메소드입니다.

		String oldNumber = null; //oldNumber 변수를 만드는 이유는 수정할 때 이전의 전화번호를 저장하기 위해서 입니다.	
		
		int index = find(name); // 밑에 있는 find 매소드의 기능인 해당 name 으로 시작하는 전화번호부 배열의 
								// index 를 가져옵니다. 가져온 index를 index 변수에 저장합니다.
		
		if (index >-1) { // 모든 배열의 index는 0이상 이니깐 이 조건을 만족하면 해당하는 이름의 index를 찾았다는 것을 보여줍니다.
		
			oldNumber = theDirectory[index].getNumber(); // 기존 전화번호를 oldNumber에 저장합니다. 
			theDirectory[index].changeNumber(number); // 매개변수로 받은 전화번호를 새롭게 전화번호부에 저장합니다.
			theDirectory[index].changeMemo(memo); // 매개변수로 받은 메모를 새롭게 전화번호부에 저장합니다.
			
			
		} else { // 해당 이름을 못 찾았다으면 
			add(name, number,memo); // 기존의 전화번호부에 없다는 이야기임으로 add 메소드를 이용해 추가시켜줍니다.
		}
		modified = true; // 수정여부를 true로 고칩니다. 그래야 현재상태저장을 누룰 때 이 바뀐 내용이 저장됩니다.
						 // 이 내용은 밑의 save 메소드에서 알 수 있습니다.
		
		return oldNumber; // 기존 전화번호를 반환합니다. 나중에 '이전 전화번호는 이거였다'라고 보여주기 위함입니다.
	}


	public String lookupEntry(String name) { //매개변수로 받은 이름으로 저장된 전화번호를 보여주는 함수입니다. 
		int index = find(name); // name 으로 검색해 해당 index를 찾아냅니다. 
		if (index >-1) { // 해당 이름을 찾았다면
			return theDirectory[index].getNumber(); // 게터 함수인 getNumber을 통해 전화번호를 반환합니다.
		} else {
			return null; // 해당 이름을 찾지 못했다면 null 을 반환합니다.
		}
	}
	
	public String lookupEntry1(String name) { //매개변수로 받은 이름으로 저장된 메모를 보여주는 함수입니다.
		int index = find(name); // name 으로 검색해 해당 index를 찾아냅니다.
		if(index >-1) { // 해당 이름을 찾았다면
			return theDirectory[index].getMemo(); // 게터 함수인 getMemo를 통해 메모를 반환합니다.
		} else{
			return null; // 해당 이륾을 찾지 못했다면 null 을 반환합니다.
		}
	}


	public void save() { //수정된 전화번호부를 저장하는 메소드입니다.
		if (modified) { // 변경사항이 있다면
			try {
				PrintWriter out = 
						new PrintWriter(new FileWriter(txtfile));
				// 해당 매개변수 파일명의 파일을 열어 스트림을 생성 합니다.

				for (int i = 0; i <savenumber; i++) {
					if(theDirectory[i].getNumber() == null)
						continue;
					out.println(theDirectory[i].getName());
					out.println(theDirectory[i].getNumber());
					out.println(theDirectory[i].getMemo());
				} // 전화번호부에 있는 저장된 내용을 for 문을 이용해 파일에 씁니다.

				out.close(); // 스트림을 닫습니다.
				modified = false; // 수정된 내용의 기록이 끝났으니 수정여부를 false로 다시 바꿔줍니다.
			} catch (Exception ex) {
				System.err.println("저장에 실패하였습니다."); //예외 발생시 "저장에 실패하였습니다"를 출력합니다.
				ex.printStackTrace(); // 예외 발생시 에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력합니다.
				System.exit(1);
			}
		}
	}


	private int find(String name) { //매개변수로 들어온 name 으로 저장된
									//전화번호부 배열(theDirectory)의 index를 반환해주는 매소드입니다.
		
		for (int i = 0; i <savenumber; i++) { 
			if (theDirectory[i].getName().equals(name)) { //전화번호부 배열(theDirectory)의 이름을 
														  //게터로 뽑아내 '매개변수' name 과 같은지를 알아봅니다.
				
				return i; // '매개변수' name과 같다면 같았었던 전화번호부 배열의 index를 반환합니다.
			}
		}
		return -1; // 못찾았음을 나타냅니다.
	}


	private void add(String name, String number, String memo) { //이름과 전화번호, 그리고 메모를 추가하는 메소드입니다.
		if (savenumber >= capacity) { // 현재 저장되어 있는 전화번호의 개수가 최대 저장 개수(100)보다 크면
			reallocate(); // 저장 용량을 늘리기 위해 reallocate 함수를 실행합니다.
		}
		theDirectory[savenumber] = new Element(name, number,memo); // savenumber의 index에 전화번호 요소를 추가합니다.
		savenumber++; // 저장이 되었으니 +1을 해줍니다. 그래야 다음에 저장 될 때 이전의 값과 충돌하지 않습니다.
	}


	private void reallocate() { //용량이 가득찼을 때 저장공간을 늘려주는 메소드입니다.
		capacity *= 2; // 최대 용량을 두배로 늘립니다.
		Element[] newDirectory = new Element[capacity];
		// 임시 전화번호부 배열을 만듭니다. X2 만큼 더 늘어난 배열입니다. 기존의 배열을 여기로 저장할 것입니다.
		System.arraycopy(theDirectory, 0, newDirectory, 0, theDirectory.length);
		// 기존 전화번호부 배열의 내용을 임시 전화번호부 배열에 저장합니다. 
		// 이 매소드의 매개변수를 해석해보면 theDirectory[0]에서 newDirectory[0]으로
		// theDirectory.lengh 개수만큼을 복사해라는 뜻을 가집니다.
		theDirectory = newDirectory;
		// theDirectory 변수가 newDirectory 를 가리키게 함으로써 2배만큼의 저장공간이 늘어나게 됩니다.
	}


	public void removeEntry(String name) { //전화번호부를 삭제하는 함수입니다.
	
		int index = find(name); //name 에 해당하는 배열의 index 를 index에 저장합니다.

		if (index >-1) { //index를 찾았으면
			theDirectory[index].changeNumber(null); //changeNumber매소드를 통해 새로운 전화번호
													// 값을 null로 만듭니다.
			
			modified = true; // null로 수정되었으니 수정여부를 true로 바꿉니다.
		}
	}
}
```

Application 클래스입니다
```

package Phonenumber;


import java.io.IOException;

	public class Application { //실행을 위한 메인 함수가 있는 클래스입니다.

		public static void main(String[] args) {

			Function Function = new Function(); //Function 클래스 안에 있는 데이터를 로드하는 기능을 이용하기 위해서 
												//Function 객체하나를 만듭니다. 이름도 클래스명과 같게 Function 이라 했습니다.
											
			
			try {
					Function.loadData("hnh.txt");   //Function 클래스에 있는 loadData 를 이용해서 hnh.txt에 저장되어
													//있는 전화번호 정보를 가져옵니다.
			
			} catch (IOException e) { 
				e.printStackTrace(); // 예외 발생시 에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력합니다.

			}

			GUI FunctionInterface = new GUI();  // FunctionInterface라는 GUI 객체를 만듭니다.
			FunctionInterface.processCommands(Function);    //FunctionInterface 안의 processCommands 메소드르 실행합니다.
															//이 메소드는 처음 화면의 기본 구성을 나타냅니다.
		}
}
```

---


# 만들고서 느낀점 #
원래 계획은 생일 넣는칸을 따라 만들어 거기에 생일을 입력하고 생일 일주일전이 되면 프로그램 열리는 동시에 생일인 사람의 리스트를 뜨게 할려는 생각을 했었는데 마음대로 안되더라구요. 더 많은 노력을 해야겠다고 생각했습니다. ㅠㅠ


---



# 소스코드(사진,class파일) #
http://comp166-koreauniv.googlecode.com/files/2012190706.zip