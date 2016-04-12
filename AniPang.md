# Introduction #

자바로 애니팡을 만들었습니다


![http://comp166-koreauniv.googlecode.com/files/ani.jpg](http://comp166-koreauniv.googlecode.com/files/ani.jpg)


# Details #

매소드

1. 기본 세팅 및 게임 방법: 6종류의 동물들(원숭이,고양이,돼지,쥐,토끼,강아지)이 있다. 그리고 7X7 크기의 배열, 즉 게임 판이 주어진다.(각 칸에 동물 한마리씩 들어간다.) 동물들이 임의로 배치 되어 있다. 동물 하나를 선택해서 상하좌우에 있는 동물이랑 자리를 바굴 수 있다. 이때 반드시 바꾼후에 세마리 이상의 종류가 같은 동물끼리 일직선으로 배치 되 있어야 한다. 만약 세마리 이상의 종류가 같은 동물끼리 일직선으로 배열 되 있으면, 그 동물들은 애니팡이 된다.(사라진다) 사라진후 위에서부터 빈공간을 매꾸기위해 빈칸이 있는 열의 동물들이 그만큼 내려온다. 이때 무작위로 동물들을 또 생산 한다. 제한시간은 1분이다. 게임판은 대문자 알파벳으로 구현된다.
원숭이A 토끼:B
고양이:C 강아지:D
돼지:E   쥐:F

2. 처음 렌덤으로 게임판 주기: 멘 처음 게임을 시작할때 동물들을 무작위로  게임 판에 배열 한다. 하지만 이때 같은 종류의 동물들이 세개이상 나란하게 배치되있으면 안된다. 이를 막기 위해 채크를 한다. 이는 게임판이 설정된 이후에 세개이상의 같은 종류의 동물들이 나란하게 배치되 어있는지 검사하여 다시 판을 만든다. 이 과정을 게임판이 완성 될때까지 한다.

3. 게임중 : 게임하는 사람으로부터 동물의 좌표와 옮기고자하는 방향(행쪽,열쪽)을 입력하여 SetAni 로넘긴다. 그 그리고 게임판에서 그 동물을 바꾸어준다. 그 후에 CheckNPang 에서 3개이상연속된 동물이있는지 검사하고 이를 팡한다.

클래스

AniPangTestDire

main 함수가 들어있는 클래스이다. 이클래스에서 게임을 시작한다. 그리고 시간이 다될때까지 게임을 진행 시키는 함수이다.

AniPang

이클래스는 애니팡 게임을 진행할때 필요한 매소드 즉 게임 명령을 하는 클래스이다


setAni(): 동물의 좌표와 이동할 방향을 넘겨주어 바꾸어준다.



CheckNPang(): 3개이상의 동물들이 일렬로 나열되있는지 검사하고 그 동물들을 팡한다.

Organize(): 비어있는공간을 매꾸어주고 랜덤으로 동물들을 생성한다.

# How to Play #

![http://comp166-koreauniv.googlecode.com/files/1.png](http://comp166-koreauniv.googlecode.com/files/1.png)

처음 보드가 주어집니다

![http://comp166-koreauniv.googlecode.com/files/2.png](http://comp166-koreauniv.googlecode.com/files/2.png)

좌표와 그 좌표의 동물을 어디로 이동할지 정합니다.

처음 입력값= (좌표)
두버째입력값=(행쪽으로 이동방향,열쪽으로이동방향)

![http://comp166-koreauniv.googlecode.com/files/3.png](http://comp166-koreauniv.googlecode.com/files/3.png)

마약 제대로 옯겼으면 PANG! 과함께 보드가 갱신되고 점수가 카운트됩니다(점수는 마지막에 한꺼먼에 나옵니다)

![http://comp166-koreauniv.googlecode.com/files/4.png](http://comp166-koreauniv.googlecode.com/files/4.png)

콤보도 가능합니다. 만약 한번의 명령으로 한번 PANG을하고 갱신된 보드에서 또다시 세개이상의 같은 동물들이 일자로 나열되있으면 PANG이 다시한번 됩니다.

![http://comp166-koreauniv.googlecode.com/files/5.png](http://comp166-koreauniv.googlecode.com/files/5.png)

마약 명령을 내렷으나 PANG이 될수 없다면 FAIL을 출력하고 보드에는 변화가 없습니다.

![http://comp166-koreauniv.googlecode.com/files/6.png](http://comp166-koreauniv.googlecode.com/files/6.png)

이와같이 10번을 명령하면 최종 스코어가 나옵니다.


```

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class GameHelper{
			public String getUserInput(String prompt){
				String inputLine=null;
				try{
					BufferedReader is= new BufferedReader(new InputStreamReader(System.in));
					inputLine=is.readLine();
					if(inputLine.length()==0)return null;
				}
				catch(IOException e){}
				return inputLine;
	}
}

class AniPangTestDrive{
	public static void main(String[] args){
		char Board[][] = new char[10][10];
		int i,j = 0;
		boolean flag=true;
	
		while(flag){
			for(i=1;i<=7;i++){
				for(j=1;j<=7;j++){
					Board[i][j]=(char)(Math.random()*7+65);
				}
			}
			for(i=1;i<=7;i++){
				for(j=1;j<=7;j++){
					if(Board[i][j]==Board[i+1][j] && Board[i][j]==Board[i+2][j] && i<=5){
						flag=false;
						break;
					}
					if(Board[i][j]==Board[i][j+1] && Board[i][j]==Board[i][j+2] && j<=5){
						flag=false;
						break;
					}
				}
			}
			if(flag==false)flag=true;
			else flag=false;
		}
		int time=0;
		int Score=0;
		GameHelper helper=new GameHelper();
		for(i=1;i<=7;i++){
			  for(j=1;j<=7;j++){
				  System.out.print(Board[i][j]);
			  }System.out.print('\n');
		    }
		while(time<10){
			  time++;
				AniPang Ani= new AniPang();
				Ani.x=Integer.parseInt(helper.getUserInput("enter info"));
				Ani.y=Integer.parseInt(helper.getUserInput("enter info"));
				Ani.xway=Integer.parseInt(helper.getUserInput("enter info"));
				Ani.yway=Integer.parseInt(helper.getUserInput("enter info"));
				Ani.setAni(Board);
				
		
			int tmp=0;
			tmp=Ani.CheckNPang(Board);
			if(tmp==0){
				Ani.setAni(Board);
				for(i=1;i<=7;i++){
					  for(j=1;j<=7;j++){
						  System.out.print(Board[i][j]);
					  }System.out.print('\n');
				    }
				System.out.print("FAIL!"+'\n');
				continue;
			}
			else {
				Ani.Organize(Board);
				int tmp2=1;
				while(tmp2!=0){
					System.out.print("PANG!"+'\n');
					for(i=1;i<=7;i++){
						  for(j=1;j<=7;j++){
							  System.out.print(Board[i][j]);
						  }System.out.print('\n');
					    }
					tmp2=Ani.CheckNPang(Board);
					tmp+=tmp2;
				}
			}
			Score+=tmp;
	 
		
		
		}
		System.out.print("your score is"+Score);
	}
}

public class AniPang{
	int x,y,xway,yway;

	public int setAni(char arr[][]){
		char temp;
		temp=arr[x][y];
		arr[x][y]=arr[x+xway][y+yway];
		arr[x+xway][y+yway]=temp;
		return 0;
	}
	public int CheckNPang(char arr[][]){
	 	int cnt=0,i,j = 0,flag=0;
	 	char know1=arr[1][y],know2=arr[x][1];
		int Visit1[][] = new int[10][10],Visit2[][] = new int[10][10];
	 	for(i=1;i<=7;i++)
	 		for(j=1;j<=7;j++){
	 			Visit1[i][j]=1;
	 			Visit2[i][j]=1;
	 		}
	 	for(i=1;i<7;i++){
	 		if(arr[i][y]==arr[i+1][y] && arr[i][y]==know1){
	 			know1=arr[i][y];
		 		Visit1[i+1][y]=Visit1[i][y]+1;
		 		if(Visit1[i+1][y]==3)flag=1;
		 	}
	 		else know1=arr[i+1][y];
	 		if(arr[x][i]==arr[x][i+1] && arr[x][i]==know2){
	 			know2=arr[x][i];
		 		Visit2[x][i+1]=Visit2[x][i]+1;
		 		if(Visit2[x][i+1]==3)flag=1;
		 	}
	 		else know2=arr[x][i+1];
	 	}
	 	know1=arr[1][y+yway];
	 	know2=arr[x+xway][1];
	 	for(i=1;i<7;i++){
	 		if(arr[i][y+yway]==arr[i+1][y+yway] && arr[i][y+yway]==know1){
	 			know1=arr[i][y+yway];
		 		Visit1[i+1][y+yway]=Visit1[i][y+yway]+1;
		 		if(Visit1[i+1][y+yway]==3)flag=1;
		 	}
	 		else know1=arr[i+1][y+yway];
	 		if(arr[x+xway][i]==arr[x+xway][i+1] && arr[x+xway][i]==know2){
	 			know2=arr[x+xway][i];
		 		Visit2[x+xway][i+1]=Visit2[x+xway][i]+1;
		 		if(Visit2[x+xway][i+1]==3)flag=1;
		 	}
	 		else know2=arr[x+xway][i+1];
	 	}
	 	if(flag==0)return 0;
	 	for(i=1;i<=7;i++){
	 		for(j=1;j<=7;j++){
	 			if(Visit1[i][j]>=3 && Visit1[i+1][j]<Visit1[i][j]){
	 				int k;
	 				for(k=i-Visit1[i][j]+1;k<=i;k++)arr[k][j]='X';
	 				cnt+=Visit1[i][j];
	 			}
	 			if(Visit2[i][j]>=3 && Visit2[i][j+1]<Visit2[i][j]){
	 				int k;
	 				for(k=j-Visit2[i][j]+1;k<=j;k++)arr[i][k]='X';
	 				cnt+=Visit2[i][j];
	 			}
	 		}
	 	}
	 	return cnt;
	}
	
	public void Organize(char arr[][]){
		int i,j,k;
		for(i=1;i<=7;i++){int cnt=0;
			for(j=7;j>=1;j--){
				if(arr[j][i]=='X'){cnt++;
					for(k=j;k>=1;k--){
						arr[k][i]=arr[k-1][i];
					}
					j++;
				}
			}
			for(j=1;j<=cnt;j++){
				arr[j][i]=(char)(Math.random()*7+65);
			}
		}
	}
}
```