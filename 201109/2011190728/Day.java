
import java.io.*;
import java.util.Scanner;


public class Day extends Diary implements Memo {

	String[] i = new String[100];
	int d = 0;
	
	
	public Diary go() {
		return null;
	}
	public void GetMemo() {
		if( i[d]!=null ){
			System.out.println("이미 일정이 있습니다. 일정추가-1 / 일정 모두 삭제 및 수정-2 : ");
			char c;
			try {
				c = (char) System.in.read();
				if( c == '2'){
					   for( int q = 0; i[q] != null; q++){
					   i[q] = null;	   
					   }
					   d = 0;				
					   System.out.print("새로운 일정을 입력하세요: ");
					   Scanner  scan  =  new  Scanner (System.in);
				       i[d] = scan.next();
			           
				}
				else if( c == '1'){
				d++;
				System.out.print("추가 일정을 입력하세요: ");
			    Scanner  scan  =  new  Scanner (System.in);
			    i[d] = scan.next();
					
				}
				else{
				       System.out.print(" Error ! ");
				}
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}	
		}  
		else{
		   System.out.print("일정을 입력하세요: ");
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   try {
			i[d] = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	       
		}
		}
		
	       		
	

	public void PrintMemo() {
		for(int a=0; i[a] != null ; a++){
		System.out.printf("%s",i[a]);
		System.out.println(" ");
		}
	}
	
	
	

}
