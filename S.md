피자를 주문하는 프로그램입니다.



1. SIZE
피자의 사이즈를 선택합니다. S -9900원, M -13900원, L -16900원의 가격으로 측정됩니다.

2. NUMOFTOPPINGS
토핑의 갯수를 선택합니다. 0개부터 5개까지 피자 한판에 여러가지 토핑을 원하는 갯수만큼 고를 수 있습니다. 토핑 하나가 추가될 경우 3000원이 추가됩니다.

3. TOPPINGS
원하는 갯수의 토핑을 고릅니다. combination, seafood, bulgogi, potato, sweet\_potato 중 고릅니다.

4. 피자를 또 주문하고싶을 경우 y 그렇지 않을 경우 n을 입력합니다.

<출력화면>

주문한 피자의 수량

피자의 가격

토핑의 갯수 및 가격

피자의 최종가격

출처:http://www.roseindia.net/answers/viewqa/Java-Beginners/8741-Pizza-Order...html

Class Pizza

---

```
public class Pizza {//PizzaOrder클래스를 실행시킬 하위 Pizza클래스

 String size;
 boolean combination;
 boolean seafood;
 boolean bulgogi;
 boolean potato;
 boolean sweet_potato;
 

 enum PizzaSize {
 S(9900), R(13900), F(16900);
 private double cost;

 PizzaSize(double cost) {
 this.cost = cost;
 }

 public double getCost() {
 return cost;
 }
 }

//S.R.F사이즈에 따라 다른 cost값 return

 PizzaSize pizzaSize;

 public int cntNumToppings() {
 int toppings = 0;
 if (combination) {
 toppings += 1;
 }
 if (seafood) {
 toppings += 1;
 }
 if (bulgogi) {
 toppings += 1;
 }
 if (potato) {
 toppings += 1;
 }
 if (sweet_potato) {
 toppings += 1;
 }
 return toppings;
 }

//토핑을 고르면 toppings의 숫자 올려줌

 public String getSize() {
 return size;
 }

 public Pizza(String size, boolean combination, boolean seafood, boolean bulgogi, boolean potato, boolean sweet_potato) {
 this.size = size;
 this.combination = combination;
 this.seafood = seafood;
 this.bulgogi = bulgogi;
 this.potato = potato;
 this.sweet_potato = sweet_potato;
 }

 public double getCost() {
 double cost = 0.0;
 if (getSize().equalsIgnoreCase("s"))
 cost = pizzaSize.S.cost;
 if (getSize().equalsIgnoreCase("r"))
 cost = pizzaSize.R.cost;
 if (getSize().equalsIgnoreCase("f"))
 cost = pizzaSize.F.cost;
 return cost;
 }
}


```






Class PizzaOrder

---

```
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PizzaOrder {

 ArrayList<Pizza> pizzaOrders = new ArrayList<Pizza>();
 static int numOfPizzas;
 boolean combination;
 boolean seafood;
 boolean bulgogi;
 boolean potato;
 boolean sweet_potato;
 String sizeOfPizza = null;
 double total = 0.0;
 Pizza pizza;

 public static void main(String[] args) {//main클래스 선언
 Scanner scan = new Scanner(System.in);
 String orderedToppings = null;
 int toppings = 0;
 String wantMore = "n";
 PizzaOrder order = new PizzaOrder();
 do {
 order.combination = false;
 order.seafood = false;
 order.bulgogi = false;
 order.potato = false;
 order.sweet_potato = false;
 
 System.out.println("원하는 피자의 사이즈를 입력 하세요.(s/r/f) : ");
 order.sizeOfPizza = scan.next();
 System.out.println("원하는 토핑의 가짓수를 입력 하세요.(0 to 5): ");
 toppings = scan.nextInt();
 if (toppings > 0) {
 System.out.println("원하는 토핑의 종류를 입력 하세요.(토핑 하나 당 3000원) combination/seafood/bulgogo/potato/sweet_potato : (각각의 토핑은 / 으로 구분되어야함)");
 orderedToppings = scan.next();
 StringTokenizer token = new StringTokenizer(orderedToppings,"/");
 while (token.hasMoreTokens()) {
 String topping = token.nextToken();
 if (topping.equalsIgnoreCase("combination"))
 order.combination = true;
 if (topping.equalsIgnoreCase("seafood"))
 order.seafood = true;
 if (topping.equalsIgnoreCase("bulgogi"))
 order.bulgogi = true;
 if (topping.equalsIgnoreCase("potato"))
 order.potato = true;
 if (topping.equalsIgnoreCase("sweet_potato"))
 order.sweet_potato = true;

}

 }

 System.out.println("피자를 더 주문 하시겠습니까? y/n : ");
 wantMore = scan.next();
 order.addPizza();
 } while (wantMore.equals("y"));
 order.printPizzaOrder(); //y를 입력하면 printPizzaOrder클래스 다시 실행

 }

 public void printPizzaOrder() {
 for (int i = 0; i < pizzaOrders.size(); i++) {
 Pizza p = pizzaOrders.get(i);
 int temp = p.cntNumToppings();
 System.out.println("---------------------------------------------");
 System.out.println("피자의 사이즈 = " + p.getSize());
 System.out.println("토핑의 가짓수: " + temp);
 if (temp > 0) {
 if (p.combination)
 System.out.println("*combination");
 if (p.seafood)
 System.out.println("*seafood");
 if (p.bulgogi)
 System.out.println("*bulgogi");
  if (p.potato)
 System.out.println("*potato");
 if (p.sweet_potato)
 System.out.println("*sweet_potato");
}
 double crustCost = p.getCost();
 double toppingsCost = 3000*p.cntNumToppings();
 System.out.println("주문한 피자의 수량 : " + getNoOfPizzas());
 System.out.println("피자의 가격: " + crustCost+"원");
 System.out.println("토핑의 가격: " + toppingsCost+"원");
 System.out.println("피자의 최종 가격: " + (crustCost + toppingsCost)+"원");
 }
 
  }

 public void addPizza() {
 numOfPizzas += 1;
 pizza = new Pizza(sizeOfPizza, combination, seafood, bulgogi, potato, sweet_potato);
 pizzaOrders.add(pizza);
 updateTotal(pizza.getCost() + pizza.cntNumToppings());
 }

 public int getNoOfPizzas() {
 return numOfPizzas;
 }

 public void updateTotal(double cost) {
 total += cost;
 }

 public double getTotalCost() {
 return total;
 }

}


```




이 코드는 gui를 구현하려고 했으나 중간에 실패한 코드에요 ㅜㅠ
Class Pizza

---

```
public class Pizza {

 String size;
 boolean combination;
 boolean seafood;
 boolean bulgogi;
 boolean potato;
 boolean sweet_potato;
 

 enum PizzaSize {
 S(9900), R(13900), F(16900);
 private double cost;

 PizzaSize(double cost) {
 this.cost = cost;
 }

 public double getCost() {
 return cost;
 }
 }

 PizzaSize pizzaSize;

 public int cntNumToppings() {
 int toppings = 0;
 if (combination) {
 toppings += 1;
 }
 if (seafood) {
 toppings += 1;
 }
 if (bulgogi) {
 toppings += 1;
 }
 if (potato) {
 toppings += 1;
 }
 if (sweet_potato) {
 toppings += 1;
 }
 return toppings;
 }

 public String getSize() {
 return size;
 }

 public Pizza(String size, boolean combination, boolean seafood, boolean bulgogi, boolean potato, boolean sweet_potato) {
 this.size = size;
 this.combination = combination;
 this.seafood = seafood;
 this.bulgogi = bulgogi;
 this.potato = potato;
 this.sweet_potato = sweet_potato;
 }

 public double getCost() {
 double cost = 0.0;
 if (getSize().equalsIgnoreCase("s"))
 cost = pizzaSize.S.cost;
 if (getSize().equalsIgnoreCase("r"))
 cost = pizzaSize.R.cost;
 if (getSize().equalsIgnoreCase("f"))
 cost = pizzaSize.F.cost;
 return cost;
 }
}



```





Class PizzaOrder

---

```
package pizza;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class PizzaOrder {

 ArrayList<Pizza> pizzaOrders = new ArrayList<Pizza>();
 static int numOfPizzas;
 boolean combination;
 boolean seafood;
 boolean bulgogi;
 boolean potato;
 boolean sweet_potato;
 String sizeOfPizza = null;
 double total = 0.0;
 Pizza pizza;

 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 String orderedToppings = null;
 int toppings = 0;
 String wantMore = "n";
 PizzaOrder order = new PizzaOrder();
 do {
 order.combination = false;
 order.seafood = false;
 order.bulgogi = false;
 order.potato = false;
 order.sweet_potato = false;
 
int maincontrol;
JOptionPane.showMessageDialog(null,"원하는 피자의 사이즈를 입력 하세요.(s/r/f) : ");
int size=(Integer.parseInt(JOptionPane.showInputDialog( "\n(1)\t S \n"

	 +"(2)\t R \n"  

	+"(3)\tF \n"
+"(0) exit"))); 
 switch(size){  

	    

	 case 0: System.exit(size);  

	    

	 case 1: 
		JOptionPane.showMessageDialog(null,"S사이즈를 주문하셨습니다");
maincontrol = 0; 

	     break;  
	    


	 case 2:  
		JOptionPane.showMessageDialog(null,"R사이즈를 주문하셨습니다");
	     

	         maincontrol=0;  

	       break;  

	   case 3:
		JOptionPane.showMessageDialog(null,"F사이즈를 주문하셨습니다");
		maincontrol=0;
		break;

	    

	

	    

	 
	 }  
 
 
 
 int asl;
 JOptionPane.showMessageDialog(null," 원하는 토핑의 가짓수를 입력 하세요.(1 to 5):");
 int toppingnumber=(Integer.parseInt(JOptionPane.showInputDialog( "\n(1)\t1 \n"

 	 +"(2)\t2 \n"  

 	+"(3)\t3 \n"
 +"(4)\t4 \n"
 +"(5)\t5 \n"
 +"(0) exit"))); 
  switch(toppingnumber){  

 	    

 	 case 0: System.exit(toppingnumber);  

 	    

 	 case 1: 
 		JOptionPane.showMessageDialog(null,"1개의 토핑을 넣으셨습니다");
 asl = 0; 

 	     break;  
 	    


 	 case 2:  
 		JOptionPane.showMessageDialog(null,"2개의 토핑을 넣으셨습니다");
 	     

 	         asl=0;  

 	       break;  

 	   case 3: 
 		JOptionPane.showMessageDialog(null,"3개의 토핑을 넣으셨습니다");
 		asl=0;
 		break;
 	 case 4: 
 		JOptionPane.showMessageDialog(null,"4개의 토핑을 넣으셨습니다");
 		asl=0;
 		break;
  case 5: 
 		JOptionPane.showMessageDialog(null,"5개의 토핑을 넣으셨습니다");
 		asl=0;
 		break;
 	    

 	

 	    

 	 
 	 }  
 
 if (toppingnumber > 0) {
	 int aaa;
 
 JOptionPane.showMessageDialog(null," 원하는 토핑의 종류를 입력 하세요. combination/seafood/bulgogi/potato/sweet_potato : (각각의 토핑은 / 으로 구분되어야함)");
 int topping=(Integer.parseInt(JOptionPane.showInputDialog( "\n(1)\t combination \n"

 	 +"(2)\t seafood \n"  

 	+"(3)\t bulgogi \n"
 +"(4)\t potato\n"
 +"(5)\t sweet_potato \n"
 +"(0) exit"))); 
  switch(topping){  

 	    

 	 case 0: System.exit(topping);  

 	    

 	 case 1: 
 		JOptionPane.showMessageDialog(null,"combination");
 aaa = 0; 

 	     break;  
 	    


 	 case 2:  
 		JOptionPane.showMessageDialog(null,"seafood");
 	     

 	         aaa=0;  

 	       break;  

 	   case 3: 
 		JOptionPane.showMessageDialog(null,"bulgogi");
 		aaa=0;
 		break;
 	 case 4: 
 		JOptionPane.showMessageDialog(null,"potato");
 		aaa=0;
 		break;
  case 5: 
 		JOptionPane.showMessageDialog(null,"sweet_potato");
 		aaa=0;
 		break;
  }

 }

 JOptionPane.showMessageDialog(null,"피자를 더 주문 하시겠습니까? y/n : ");
 wantMore = scan.next();
 order.addPizza();
 } while (wantMore.equals("y"));
 order.printPizzaOrder();

 }

 public void printPizzaOrder() {
 for (int i = 0; i < pizzaOrders.size(); i++) {
 Pizza p = pizzaOrders.get(i);
 int temp = p.cntNumToppings();
 JOptionPane.showMessageDialog(null,"---------------------------------------------");
 JOptionPane.showMessageDialog(null,"피자의 사이즈 = " + p.getSize());
 JOptionPane.showMessageDialog(null,"토핑의 가짓수: " + temp);
 if (temp > 0) {
 if (p.combination)
 JOptionPane.showMessageDialog(null,"*combination");
 if (p.seafood)
 JOptionPane.showMessageDialog(null,"*seafood");
 if (p.bulgogi)
 JOptionPane.showMessageDialog(null,"*bulgogi");
  if (p.potato)
 JOptionPane.showMessageDialog(null,"*potato");
 if (p.sweet_potato)
 JOptionPane.showMessageDialog(null,"*sweet_potato");
}
 double crustCost = p.getCost();
 double toppingsCost = 3000 * p.cntNumToppings();
 JOptionPane.showMessageDialog(null,"주문한 피자의 수량 : " + getNoOfPizzas());
 JOptionPane.showMessageDialog(null,"피자의 가격: 원" + crustCost);
 JOptionPane.showMessageDialog(null,"토핑의 가격: 원" + toppingsCost);
 JOptionPane.showMessageDialog(null,"피자의 최종 가격: 원" + (crustCost + toppingsCost));
 }
 }

 public void addPizza() {
 numOfPizzas += 1;
 pizza = new Pizza(sizeOfPizza, combination, seafood, bulgogi, potato, sweet_potato);
 pizzaOrders.add(pizza);
 updateTotal(pizza.getCost() + pizza.cntNumToppings());
 }

 public int getNoOfPizzas() {
 return numOfPizzas;
 }

 public void updateTotal(double cost) {
 total += cost;
 }

 public double getTotalCost() {
 return total;
 }

}

```