2011190726 박재성

# Introduction #

> 대학생들은 현금보다는 체크카드를 많이 사용한다. 이 때, 계좌를 만들고 입금,출금,계좌이체 및 잔고 확인을 할 수 있는 모바일 전자은행계좌 프로그램을 만들고자 한다.
# Details #

> -이 프로그램은 모바일 전자은행계좌 어플리케이션의 일부로써 Account, AccountManager 등의 클래스(class)안에 입금(deposit), 잔고조회(getBalance),출금(withdraw),계좌이체(transferAccount),계좌개설(createAccount) 등의 메소드(method)를 만들어 보았습니다.


```
public class Account {

           private String accountNumber;
           private String name;
           private String password;
           private int balance;
           private static int totalBalance;   //클래스 변수

         //static 변수 초기화
         static {
          System.out.println("call static initialize block");
          totalBalance=0;   //Account.totalBalance=0;
         }
         
           //Default Constructor method
         public Account( ) {
         
         }

            //매개변수 Constructor method
         public Account(String accountNumber, String name,
          String password, int balance) {
          System.out.println("call Constructor!!");
          this.accountNumber=accountNumber;
          this.name=name;
          this.password=password;
          this.balance=balance;
          totalBalance+=balance; 
          //totalBalance=totalBalance+balance;
         }


         //입금하다. : deposit
         public void deposit(int amount) {  //입금액
          if(amount<0) {
           System.out.println("입금액을 정확히 입력하세요");
           return;
          }
          balance+=amount;   //balance=balance+amount;
          totalBalance+=amount;
          //totalBalance=totalBalance+amount ;
         }

         //잔고를 조회하다. getBalance
         public int getBalance( ) {
          return balance;
         }

         //출금하다. withdraw
         public void withdraw(int amount) {
          if( amount<0 ) {
           System.out.println("금액을 정확히 입력하세요");
           return;
          }

          if( amount>balance ) {
           System.out.println("잔고를 초과하셨습니다.");
           return;
          }

          balance-=amount;    //balance=balance-amount;
          totalBalance-=amount;
          //totalBalance=totalBalance-amount ;
         }

         //계좌의 모든 정보를 조회하다.( getAccountInfo )
         public String getAccountInfo( ) {
          return "AccountNumber="+accountNumber
           +", Name="+name
           +", Password="+password
           +", Balance="+balance;
         }

         /*public String toString() {
          return "AccountNumber="+accountNumber
          +", Name="+name
          +", Password="+password
          +", Balance="+balance;  }*/
         

         //계좌이체하다.
         public void transferAccount(Account account, int amount) {
          this.withdraw(amount);
          account.deposit(amount); 
         }

         //은행 총잔고를 구한다.
         public static int getTotalBalance( ) {
          return totalBalance;   //Account.totalBalance;
         }

         //계좌번호를 구한다.
         public String getAccountNumber( ) {
          return accountNumber;
         }
         
         //예금주명을 조회하다.
         public String getName() {
          return name;
         }
         
         public void setName() {
          this.name=name;
         }
         
      }



package Account;


    import java.util.*;

    public class  AccountManager {
     static Account[] accounts=new Account[100];
     static int index=0;

   
     //계좌개설하다.
     public static void createAccount() {
      Scanner scan=new Scanner(System.in);

      System.out.print("계좌번호 : ");
      String accountNumber=scan.nextLine( );
      System.out.print("예금주명 : ");
      String name=scan.nextLine( );
      System.out.print("비밀번호 : ");
      String password=scan.nextLine( );
      System.out.print("잔고 :  ");
      int balance=scan.nextInt( );
     
      /*
      Account account=new Account(accountNumber,
       name, password, balance);
      accounts[index]=account;
      */

      accounts[index]=
        new Account(accountNumber, name, password, balance);
      index++;
     }

     // 입금하다.
     
     public static void inputAccount() {
      Scanner scan=new Scanner(System.in);

      System.out.print("계좌번호 : ");
      String accountNumber=scan.nextLine( );
     
      Account account=checkAccountNumber(accountNumber); 
      if(account==null) {
       System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.",accountNumber);
       return;
      }
     
      System.out.print("예금주명 : ");
      String name=scan.nextLine( );
     
      Account checkName=checkName(name); 
      if(checkName==null) {
       System.out.printf("%s 님의 계좌가 존재하지 않거나, 잘못입력하셨습니다.",name);
       return;
      }
       
      System.out.print("입금액 :  ");
      int amount=scan.nextInt( );
      account.deposit(amount);
      System.out.printf("%s님 입금액=%d%n",name, amount);
      //System.out.printf("%s님 계좌잔고=%d%n",name, );
      
     }
     
     // 출금하다
     
     public static void outputAccount() {
      Scanner scan=new Scanner(System.in);

      System.out.print("계좌번호 : ");
      String accountNumber=scan.nextLine( );
     
      Account account=checkAccountNumber(accountNumber); 
      if(account==null) {
       System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.",accountNumber);
       return;
      }
     
      System.out.print("예금주명 : ");
      String name=scan.nextLine( );
     
      Account checkName=checkName(name); 
      if(checkName==null) {
       System.out.printf("%s 님의 계좌가 존재하지 않거나, 잘못입력하셨습니다.",name);
       return;
      }
     
      System.out.print("비밀번호 : ");
      String password=scan.nextLine( );

      String temp=account.getPassword( );
      if(password.equals(temp)) {
       int balance=account.getBalance( );
       System.out.printf("Balance=%d%n", balance);
      }
      else {
       System.out.printf("%s 비밀번호가 잘못되었습니다.",password);
      }
        
      System.out.print("출금액 :  ");
      int amount=scan.nextInt( );
      account.withdraw(amount);
      System.out.printf("%s님 출금액=%d%n",name, amount);
     }
     

     //잔액 조회하다.
     public static void retrieveBalance( ) {
      Scanner scan=new Scanner(System.in);

      System.out.print("계좌번호 : ");
      String accountNumber=scan.nextLine( ); //2

     
           
     // 계좌이체하다.
     
     public static void tranceAccount() {
      Scanner scan=new Scanner(System.in);

      System.out.print("계좌번호 : ");
      String accountNumber=scan.nextLine( );
     
      Account account=checkAccountNumber(accountNumber); 
      if(account==null) {
       System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.",accountNumber);
       return;
      }
     
      System.out.print("예금주명 : ");
      String name=scan.nextLine( );
     
      Account checkName=checkName(name); 
      if(checkName==null) {
       System.out.printf("%s 님의 계좌가 존재하지 않거나, 잘못입력하셨습니다.",name);
       return;
      }
     
      System.out.print("비밀번호 : ");
      String password=scan.nextLine( );

      String temp=account.getPassword( );
      if(password.equals(temp)) {
       int balance=account.getBalance( );
       System.out.printf("Balance=%d%n", balance);
      }
      else {
       System.out.printf("%s 비밀번호가 잘못되었습니다.",password);
      }
     
      System.out.print("이체계좌 :  ");
      String tNum=scan.nextLine( );
     
      Account accounts=checkAccountNumber(tNum); 
      if(accounts==null) {
       System.out.printf("%s 계좌번호가 존재하지 않거나, 잘못입력하셨습니다.",tNum);
       return;
      }
     
       
      System.out.print("이체액 :  ");
      int amount=scan.nextInt( );
     
      account.transferAccount(accounts, amount);
      System.out.printf("%s님 출금액=%d%n",name, amount);
     }


     
     //main
     public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      boolean isExit=false;
      do
      {
       System.out.println("===== 은행 입출금 관리 시스템 =====");
       System.out.println("1. 계좌개설");
       System.out.println("2. 입금 ");
       System.out.println("3. 출금");
       System.out.println("4. 잔액조회");
       System.out.println("5. 계좌이체");
       System.out.println("6. 종료");
       System.out.print("메뉴를 선택하세요 ");
       int menu=scan.nextInt( );
       switch(menu) {
        case 1:
         //계좌개설
         createAccount( );
         break;
        case 2:
         //입금
         inputAccount( );
         break;
        case 3:
         //출금
         outputAccount();
         break;
        case 4:
         //잔액조회
         retrieveBalance( );
         break;
        case 5:
         //계좌이체
         tranceAccount();
         break;
        case 6:
         //종료
         isExit=true;
         break;
       }
      }
      while ( !isExit );
     }
     
     }

```
> 조언부탁드려요 ㅜㅜ