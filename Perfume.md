# Introduction #

저는 평상시 향수에 관심이 많은데, 시중에 널려있는 제품들 외에 자신만을 위한 특별한 향수를 온라인 주문을 통해 만드는 프로그램을 만들어 보고자 했습니다.

SeungWon's PERFUME이라는 향수구매 사이트로 들어가면,

1. 이미 회원가입이 되있는 사람의 경우 로그인을 하여 향수를 구매하면되고, 회원가입이 되어있지 않은 경우 회원가입을 할수 있고 또 비회원으로 향수를 구매할 수도 있습니다.

2. 이렇게 로그인을 하거나 고객정보를 입력한 뒤에는, 자신의 취향대로 향수를 만들 수 있습니다. 향수를 만들 때에는 세 가지 정보가 필요한데, 첫째로 향의 종류, 둘째로 향수의 양, 셋째로 향의 강도입니다. 고객이 원하는 대로 선택이 가능하며, 향의 종류는 원하는 만큼 추가로 더 선택하여 blend할 수 있도록 하였습니다.

고객 정보를 만드는 클래스와 향수를 주문하는 클래스를 따로 만들려고 구상했었으나, 하나의 클래스에 넣어도 되겠다고 생각하여 결론적으로 이 프로그램은 Perfume클래스 하나로 구성되어 있습니다.


# Details #
```
package test;
	
import java.io.*;  
import javax.swing.JOptionPane;  

   public class Perfume {
      public static void main(String[] args) throws IOException {  
         int maincontrol=0;  // 로그인화면에서 향수만들기 화면으로 넘어가도록 변수 maincontrol을 만들고, while문을 써 main method를 구현했습니다.
	     
         JOptionPane.showMessageDialog(null, "Welcome"+"\n\n **SeungWon's PERFUME**"); //GUI 사용 출력 형태입니다. 
	 JOptionPane.showMessageDialog(null, "당신만을 위한 특별한 향수를 만들어 보아요^0^");  
 
         while(maincontrol==0){
	    int customer=(Integer.parseInt(JOptionPane.showInputDialog( "\n(0) \t 로그인\n" +"\n(1) \t 회원가입\n"
     		+"(2)\t 비회원으로 만들기 \n")));
	 
            switch(customer){
	 // switch문을 활용하여 고객이 로그인을 원하는지 회원가입 혹은 비회원으로 구매를 원하는지 입력 받도록 하였습니다.
               case 0:  String id=JOptionPane.showInputDialog("id:");
	 	        String password=JOptionPane.showInputDialog("password:");
	                maincontrol=1;
	 	        break;
	       case 1:  String idmake=JOptionPane.showInputDialog("id:");
		        String passwordmake=JOptionPane.showInputDialog("password:");			
		        String name=JOptionPane.showInputDialog("이름:");	
		        int sex = (Integer.parseInt(JOptionPane.showInputDialog( "성별:" +"\n(1) \t male \n" +"(2)\t female \n"))); 
			int age = (Integer.parseInt(JOptionPane.showInputDialog( "나이:" +"\n (1)\t 10~20 \n" +"(2)\t 20~30 \n " +"(3)\t 30~40 \n " +"(4)\t 40~50 \n " +"(5)\t 50~60 \n ")));
			String address=JOptionPane.showInputDialog("주소:");
			String email=JOptionPane.showInputDialog("email:");
			maincontrol=1;
			break;
	 
               case 2:  JOptionPane.showMessageDialog(null, "향수 만드는 데 필요한 고객 사항을 알려주세요~");
	                String nameput=JOptionPane.showInputDialog("이름:");
	 	        int sexput = (Integer.parseInt(JOptionPane.showInputDialog( "성별:" +"\n(1) \t male \n" +"(2)\t female \n"))); 
	 	        int ageput = (Integer.parseInt(JOptionPane.showInputDialog( "나이:" +"\n (1)\t 10~20 \n" +"(2)\t 20~30 \n " +"(3)\t 30~40 \n " +"(4)\t 40~50 \n " +"(5)\t 50~60 \n ")));
	 	        maincontrol=1;
	 	        break;
	     } //switch문 끝
        } //while문 끝
	     while(maincontrol==1){  
	          int menu=(Integer.parseInt(JOptionPane.showInputDialog( "\n(1) \t향수 만들기 \n" +"(0)\tExit \n")));  
	          switch(menu){  
	          		case 0: System.exit(menu);  
	          		case 1: makeaperfume();  
	          		        maincontrol=1;  
	          		        break;  
	        		} //여기서도 swich문을 사용하여 고객이 향수를 구매하는 화면으로 넘어가기를 원하는지, 그냥 끝내기를 원하는지 입력받도록 하였습니다.
	        	}
        }  

public static int[] makeaperfume(){  
          int a=0, b=0, c=0, d=0, e=0, f=0, g=0;
	  String itemname = null;  
	  int quantity=0;  
	  int k =0;   // if문과 switch문에서 쓰일 변수를 지정해줍니다.

	  while(k==0){  
	      int value=(Integer.parseInt(JOptionPane.showInputDialog(  
	     "나에게 어울리는 향이 무엇인지 곰곰이 생각하여 골라주세요^^\n\n" 
	     +"(1)   시프레 - 시원한 식물향이 나는 지중해 느낌의 향 \n\n" 
	     +"(2)   시트러스 - 레몬이나 오렌지 등 감귤류의 톡 쏘는 상쾌한 향 \n\n" 
	     +"(3)   플로랄 - 꽃 향, 주로 여성향수 로 사요 \n\n" 
	     +"(4)   우디 -나무 향, 주로 남성 향수로 사용 \n\n" 
	     +"(5)   오리엔탈 - 동양에서 가져온 무거우며 달콯한 향  \n\n" 
	     +" (6)   머스크 - 사향노루의 페로몬, 주로 남성 향수로 사용 \n\n" 
	     +"(7)   푸제르  - 부드럽고 감미로운 허브 향 \n\n" 
	     +"\n" 
	     +"(0)\t Return to Main Menu"))); //향의 종류를 고르는 GUI화면입니다.
	   
             int count[]=new int[7];  
	     
             if(a==0 && b==0 && c==0 && d==0 && e==0 && f==0 && g==0 ) {
	   
	    switch(value){   
	        
	    case 1:     itemname="시프레";  
	            
	              quantity =(Integer.parseInt(JOptionPane.showInputDialog(   
	            	       "원하시는 양을 골라주세요^^\n\n"  
	            	     +"(1)   30ml \n\n" 
	            	     +"(2)   50ml \n\n" 
	            	     +"(3)   100ml \n\n" 
	            	    
	            	     +"\n" 
	            	     +"(0)\t Return to Main Menu")));   
	              			
                             a++;  
	                     k=1;  
	                     break;  
//향을 고른 후에는 향수의 양을 고르고, 변수를 증가시켜 다음 향을 골라서 blend시킬 때 이 화면이 또 실행되지 않게합니다.
	     case 2:       
	                 itemname="시트러스";  
	                 
	                 quantity =(Integer.parseInt(JOptionPane.showInputDialog(   
	              	       "원하시는 양을 골라주세요^^\n\n"  
	              	     +"(1)   30ml \n\n" 
	              	     +"(2)   50ml \n\n" 
	              	     +"(3)   100ml \n\n" 
	              	    
	              	     +"\n" 
	              	     +"(0)\t Return to Main Menu")));   
	                 
	                     b++;
	                     k=1;  
	                     break;  
	     case 3:  
	                     itemname="플로랄";  
	                     
	                    quantity =(Integer.parseInt(JOptionPane.showInputDialog(   
	                 	       "원하시는 양을 골라주세요^^\n\n"  
	                 	     +"(1)   30ml \n\n" 
	                 	     +"(2)   50ml \n\n" 
	                 	     +"(3)   100ml \n\n" 
	                 	    
	                 	     +"\n" 
	                 	     +"(0)\t Return to Main Menu")));   
	                      
	                    	c++;  
	                    	k=1;
	                        break;  
	    case 4:   
	                itemname="우디";  
	                 
	                 quantity =(Integer.parseInt(JOptionPane.showInputDialog(   
	              	       "원하시는 양을 골라주세요^^\n\n"  
	              	     +"(1)   30ml \n\n" 
	              	     +"(2)   50ml \n\n" 
	              	     +"(3)   100ml \n\n" 
	              	    
	              	     +"\n" 
	              	     +"(0)\t Return to Main Menu")));   
	                  
	                 
	                     d++;  
	                     k=1;
	                     break;  
	    case 5:  
	                    itemname="오리엔탈";  
	                      
	                    quantity =(Integer.parseInt(JOptionPane.showInputDialog(   
	                 	       "원하시는 양을 골라주세요^^\n\n"  
	                 	     +"(1)   30ml \n\n" 
	                 	     +"(2)   50ml \n\n" 
	                 	     +"(3)   100ml \n\n" 
	                 	    
	                 	     +"\n" 
	                 	     +"(0)\t Return to Main Menu")));   
	                      
	               
	                              e++;  
	                              k=1;
	                              break;  
	     case 6:  
	                             itemname="머스크";  
	                            
	                             quantity =(Integer.parseInt(JOptionPane.showInputDialog(   
	                          	       "원하시는 양을 골라주세요^^\n\n"  
	                          	     +"(1)   30ml \n\n" 
	                          	     +"(2)   50ml \n\n" 
	                          	     +"(3)   100ml \n\n" 
	                          	    
	                          	     +"\n" 
	                          	     +"(0)\t Return to Main Menu")));   
	                               
	                             f++; 
	                             k=1;  
	                             break;  
	     case 7:  
	                         itemname="푸제르";  
	                         
	                         quantity =(Integer.parseInt(JOptionPane.showInputDialog(   
	                      	       "원하시는 양을 골라주세요^^\n\n"  
	                      	     +"(1)   30ml \n\n" 
	                      	     +"(2)   50ml \n\n" 
	                      	     +"(3)   100ml \n\n" 
	                      	    
	                      	     +"\n" 
	                      	     +"(0)\t Return to Main Menu")));   
	                          
	                        
	                         g++;  
	                         k=1;  
	                         break;  
	   
	     case 0:                     k=1;  
	                                 break;  
	     default:  
	            k=0;  
	            break;  
	     }     //switch문 끝
	     }// if문 끝
	     
             int record=JOptionPane.showConfirmDialog(null, " Blend할 다른 향을 고르시겠습니까?");  
//여기서 추가로 blend할 향을 받습니다. 만약 yes를 선택하면 다시 위로 돌아갑니다.
	         if(record==JOptionPane.YES_OPTION)
	         { k=0; } 
	            
	         else if(record==JOptionPane.NO_OPTION)  
	             {k=1;  
	             int kind =(Integer.parseInt(JOptionPane.showInputDialog(   
               	       "향의 강도를 골라주세요^^\n\n"  
               	     +"(1) Perfume: 향이 가장 진한 향수, 향의 지속시간이 길고 그윽한 향을 오랫동안 즐길 수 있습니다. \n\n" 
               	     +"(2) Eau de Perfume: 향은 진하지만 지속 시간은 Perfume보다 짧습니다. \n\n" 
              	     +"(3) Eau de Tolette: 가장 흔하게 쓰이는 향수로서 지속시간이 짧으며 부담이없고 은은하게 사용가능 합니다. \n\n" 
              
              	     +"(4) Eau de Cologne: 매우 가벼운 향이며 지속시간이 매우 짧아 순간적인 기분 전환에 제일 좋습니다. \n\n"
               	    
               	     +"\n" 
               	    +"(0)\t Return to Main Menu")));   
                   	             JOptionPane.showMessageDialog(null,"구매해주셔서 감사합니다, 당신을 위한 special한 향수로 보답하겠습니다. ");  
	             }   //향의 종류를 다 선택한 후에 향의 강도를 선택하고, 프로그램이종료됩니다.

	        else System.exit(k);  
	        }  
	 return new int[7];  
	 }  //while문 끝
	 } //makeaperfume method 끝

```

<실행화면>
**Seungwon's Perfume 사이트로 들어가는 화면입니다.
http://comp166-koreauniv.googlecode.com/files/zz.PNG** login, 회원가입, 비회원 구매를 선택하는 화면입니다.
http://comp166-koreauniv.googlecode.com/files/zzz.PNG
**회원가입을 선택했을 경우, 다음과 같이 id와 성별등을 입력하는 화면이 나옵니다.
http://comp166-koreauniv.googlecode.com/files/zzzz.PNG
http://comp166-koreauniv.googlecode.com/files/zzzzz.PNG** 향수 제작 단계 화면입니다.
http://comp166-koreauniv.googlecode.com/files/zzzzzz.PNG
**원하는 향을 고르는 화면입니다.
http://comp166-koreauniv.googlecode.com/files/zsdf.PNG** 향수의 양을 고르는 화면입니다.
http://comp166-koreauniv.googlecode.com/files/sdsf.PNG
**다른 향을 blend할지 묻는 화면입니다.
http://comp166-koreauniv.googlecode.com/files/dsfasdf.PNG** 향의 강도를 고르는 화면입니다.
http://comp166-koreauniv.googlecode.com/files/sdfggg.PNG
**종료화면입니다.
http://comp166-koreauniv.googlecode.com/files/qqqqqq.PNG**

<압축파일>http://comp166-koreauniv.googlecode.com/files/2012190718_Perfume.zip