부탁해 정공형
# Introduction #

간단한 행맨 게임을 해봅시다.
시간때우기에 전혀 좋지 않습니다.(차라리 공부를 하겠음 ㅡㅡ)

# Details #

자세한 코드 개요

Class
```
public class Hangman{

String input=JOptionPane.showInputDialog("Hangman에 오신걸 환영함!\n문제로 낼 단어를 입력하세요:"); //단어를 입력받음 
String word=input.toLowerCase();
int leng=word.length();
String []c=new String[leng]; //단어의 길이만큼 배열 만듬 
String []in=new String[25]; //입력받을 수 있는 총 알파벳 수 만큼 배열을 만듬 
int count=6;
int z=0; //입력받은 알파벳이 저장된 수 
int j=0; //입력받은 문자가 문자열과 일치하는 게 있을때 증가
int k=0; //입력 받은 문자가 문자열과 일치하는게 없을때 

String letter=" "; //입력 받은 문자 
String str1=""; //correct or incorrect
String str2="\n ___  ";
String str3="\n | |";
String str4="\n | ";
String str5="\n | ";
String str6="\n | ";
String str7="\n"; 
String str8="\n"; //이겼을 때나 졌을 때의 메시지를 출력하는 부분 
String str=""; 

//단어 문자열 모두 더하는 함수 
public String strsum()
{String strs=str1+str2+str3+str4+str5+str6+str7+str8;
return strs;} 

//문자열 '_' 로 초기화함 
public void arr()
{
for(int i=0;i<leng;i++)
{c[i]="_ "; 
str7+=c[i];}
} 

//출력하는 함수 
public void shows()
{JOptionPane.showMessageDialog(null,strsum()+"\n");}

//letter입력받는 함수
public void inletter()
{ 
letter=JOptionPane.showInputDialog("너는"+(count)+"개의 목숨이 남았다!.\n다시 뽑아라(1개의 알파벳만 입력하시오.)");
letter=letter.toLowerCase();
this.errors(letter); //errors를 호출하여 검사 
}

//입력받은 문자열이 알파벳인지 검사하는 함수 

public void errors(String st) 
{ 
int alphabet=(int)st.charAt(0); //입력받은 문자를 int형으로 바꿈
if(alphabet>=97 & alphabet<=122) //알파벳이 아니면 에러 출력하고 다시 입력하게 함 
{ 
alread(st); //이미 입력된 것이니 검사하는 함수 호출 
in[z]=st; //입력받은 모든 알파벳을 저장 
z++;
} //저장된 횟수 증가 
else 
{ 
letter=JOptionPane.showInputDialog("오류! 알파벳만사용하시오!");
this.errors(letter.toLowerCase()); //입력받은 문자를 다시 검사 
} 
}


//이미 입력된 것인지 구분하는 함수
public void alread(String s)
{ 
for(int i=0; i<z; i++) //저장된 횟수 만큼 검사 
{ 
if(in[i].equals(s)) //이미 입력했던 알파벳과 새로 입력한 알파벳이 같으면 다시 입력하게함 
{ 
	JOptionPane.showMessageDialog(null,""+s.toUpperCase()+"은(는) 이미 쓴것이니. 다른 알파벳을 적어라!");
	inletter(); //다시 입력 받음 
break;
} 
}
}

//문자열에 해당 알파벳이 있는지 확인 하는 함수 

public void compar(){

while(count>0) 
{ 
shows();
inletter();

for(int i=0; i<leng; i++)
{ 
if(word.substring(i,i+1).equals(letter.toLowerCase()))
{ c[i]=letter+" "; j++;}
else k++;
}


if(j>0) //입력받은 문자가 문자 열과 하나이상 일치함
{str1="맞았어!!";} 
else if(k==leng) //입력받은 문자가 문자열과 일치하는게 없음
{str1="틀렸어 ㅠㅠㅠㅠㅠㅠ";
this.pic(); 
} 
str7="\n"; //문자열 초기화 
for(int i=0;i<leng;i++)
{ str7+=c[i];}

str="";
for(int i=0;i<leng;i++)
{ str+=c[i].trim();}

if(str.equals(word)) //단어를 6번의 기회안에 맞추었을때 
{ str8="\n승리 !!!"; 
break;}
else
{ if(count<1) //단어를 6번의 기화안에 못 맞추었을때 
{str8="\n잘가시게 친구 ........\n당신은 졌습니다.- 정답은  "+'"'+word+'"'+"!";
break;}
else 
k=0; j=0;
} 
} 
this.shows();
}


//행맨 그림 추가함수 
public int pic()
{ count--;
switch(count)
{
case 0:str6=str6+"\\"; 
break;
case 1:str6=str6+"/"; 
break;
case 2:str5=str5+"\\"; 
break;
case 3:str5=str5+"|"; 
break;
case 4:str5=str5+"/"; 
break;
case 5:str4=str4+"0"; 
break;
}
return count; 
}
public static void main(String [] args)
{ Hangman hang=new Hangman();
hang.arr();
hang.compar();
} 
} 
```