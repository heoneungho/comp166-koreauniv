# Introduction #

> 많이 알려져있고 심심풀이로 할 수 있는 업다운 게임입니다.<br>
<blockquote>너무 평범함을 피하기 위해 찬스라는 개념을 도입해 신선함을 주고자 만드는 게임입니다.</blockquote>



<h1>Details</h1>

<ul><li>스테이지를 5개로 나눕니다.<br>
</li><li>스테이지 1에서는 1~10, 2에서는 1~50, 3에서는 1~100, 4에서는 1~500, 5에서는 1~1000범위의 숫자 하나를 프로그램이 랜덤으로 정합니다.<br>
</li><li>플레이어가 한 숫자를 입력하면 입력한 숫자보다 처음 정한 숫자가 크면 Up, 작으면 Down을 출력합니다.<br>
</li><li>플레이어가 숫자를 맞출 때까지 혹은 맞출 수 있는 기회를 다 사용할 때까지 계속됩니다.<br>
</li><li>맞춘 경우, 플레이어가 몇 번째에 맞췄는지를 출력합니다.<br>
</li><li>맞추지 못하고 기회를 모두 소진한 경우, 게임오버가 뜨며 처음 정해진 숫자가 무엇인지 출력합니다.<br>
</li><li>평범한 업다운 게임과 다르게 찬스 기회를 한 번 주고, 구현돼 있는 찬스들 중 랜덤으로 하나의 찬스의 힌트를 플레이어에게 제공합니다.</li></ul>



<h1>Chances</h1>

<blockquote>찬스의 종류들<br></blockquote>

<ul><li>정해진 숫자가 짝수인지 알려줍니다.<br>
</li><li>정해진 숫자가 3의 배수인지 알려줍니다.<br>
</li><li>정해진 숫자가 현재 정해진 숫자의 범위의 최댓값(Max)와 최솟값(Min)의 중간값(Mid)에 비해 큰지 작은지를 알려줍니다.<br>
</li></ul><blockquote>(Ex) 현재 알고 있는 범위가 50~100 이라면 정해진 숫자가 75 이하인지 이상인지 알려줍니다. 만약 정해진 숫자가 75라면 같다고 출력하며 게임을 종료합니다.<br>
</blockquote><ul><li>숫자를 맞출 수 있는 기회를 1회 추가합니다.<br>
</li><li>숫자를 맞출 수 있는 기회를 1회 감소시킵니다.<br>
</li><li>꽝<br>
</li><li>정답의 1의 자리를 알려줍니다.<br>
</li><li>정답의 맨 윗자리 숫자를 알려줍니다.<br>
</li><li>정답의 자릿수를 알려줍니다.</li></ul>

<ul><li>이번 스테이지가 클리어됩니다.<br>
</li><li>패배합니다.<br>
<blockquote>- 아래 두개 찬스는 영향도가 높은 만큼 다른 찬스들에 비해 확률을 1/2로 조정했습니다.</blockquote></li></ul>



<h1>Code</h1>

<pre><code><br>
<br>
package upanddown;<br>
<br>
import java.util.Scanner;<br>
<br>
public class MainUpDown extends UpDownGame {<br>
        <br>
        public static void main(String[] args) {<br>
                <br>
                <br>
                Chances ch = new Chances();<br>
                GameHelper helper = new GameHelper();<br>
                Decide dec = new Decide();<br>
                <br>
                <br>
                boolean alive = true;<br>
                <br>
                System.out.println("업다운 게임에 오신걸 환영합니다!");<br>
                System.out.print("게임을 하시려면 1을, 도움말을 보시려면 2를 입력하세요 : ");<br>
                <br>
                int nu = 0;<br>
                Scanner sc = new Scanner(System.in);<br>
                try {<br>
                	nu = sc.nextInt();<br>
                } catch (java.util.InputMismatchException ex) {<br>
                	err = true;<br>
                }<br>
<br>
                while(nu != 1 &amp;&amp; nu != 2 &amp;&amp; !err) {<br>
                        System.out.println("잘못 입력 하셨습니다.");<br>
                        System.out.print("게임을 하시려면 1을, 도움말을 보시려면 2를 입력하세요 : ");<br>
                        try {<br>
                            nu = sc.nextInt();<br>
                        } catch (java.util.InputMismatchException ex) {<br>
                        	err = true;<br>
                        }<br>
<br>
                }<br>
          <br>
                if(nu == 2) {<br>
                  <br>
                  System.out.println("");<br>
                  System.out.println("          =도움말=");<br>
                  System.out.println("-이 게임은 임의로 정해진 숫자를 맞추는 게임입니다.");//도움말 내용<br>
                  System.out.println("-모두 5개의 스테이지로 이루어져 있으며, 각 스테이지마다 맞춰야 하는 숫자의 범위가 다릅니다.");<br>
                  System.out.println("-찬스의 기회가 한 번 주어지며, 찬스는 0을 입력했을 때 여러 찬스들 중 임의로 한가지가 실행됩니다.");<br>
                  System.out.println("-다섯 스테이지를 모두 클리어 할 경우 승리하며, 기회를 모두 사용하고 숫자를 맞추지 못하면 패배합니다.");<br>
                  System.out.println("-이 게임은 생각 1%와 운 99%로 승패가 결정되기 때문에 못깨고 징징대셔도 소용 없습니다.");<br>
                  System.out.println("");<br>
                  System.out.print("--준비가 되셨으면 1을 입력하여 게임을 시작합니다: ");<br>
<br>
                  while(nu != 1 &amp;&amp; !err) {<br>
                	  try{<br>
                		  nu = sc.nextInt();<br>
                	  } catch (java.util.InputMismatchException ex) {<br>
                    	err = true;<br>
                	  }<br>
                  }<br>
                }<br>
                <br>
                if(nu == 1) {<br>
                	<br>
                	System.out.println("");<br>
                	System.out.println("");<br>
                	System.out.println("");<br>
                	System.out.println("게임을 시작합니다.");<br>
                	System.out.println("");<br>
                	System.out.println("");<br>
                	<br>
                	<br>
                  <br>
                	while (alive == true &amp;&amp; !err) {<br>
                		<br>
                		System.out.println("== Stage " + stage + " ==");<br>
<br>
                		<br>
                		switch(stage) {<br>
	                		<br>
	                		case 1 : //스테이지 1<br>
	                			<br>
	                			max = 10;<br>
	                			min = 1;<br>
	                			life = 5;<br>
	                			ans = (int) (Math.random() * 10) + 1;<br>
	                			<br>
                				dec.dec(ch, helper);<br>
                				<br>
                				break;<br>
	                			<br>
	                			<br>
	                		case 2 :<br>
	                			<br>
	                			max = 50;<br>
	                			min = 1;<br>
	                			life = 6;<br>
	                			ans = (int) (Math.random() * 50) + 1;<br>
	                			<br>
                				dec.dec(ch, helper);<br>
	                			<br>
	                			break;<br>
	                			<br>
	                			<br>
	                		case 3 :<br>
	                			<br>
	                			max = 100;<br>
	                			min = 1;<br>
	                			life = 7;<br>
	                			ans = (int) (Math.random() * 100) + 1;<br>
	                			<br>
                				dec.dec(ch, helper);<br>
	                			<br>
	                			break;<br>
	                			<br>
	                			<br>
	                		case 4 :<br>
	                			<br>
	                			max = 500;<br>
	                			min = 1;<br>
	                			life = 8;<br>
	                			ans = (int) (Math.random() * 500) + 1;<br>
	                			<br>
	                			dec.dec(ch, helper);<br>
	                			<br>
	                			break;<br>
	                			<br>
	                			<br>
	                		case 5 :<br>
	                			<br>
	                			max = 1000;<br>
	                			min = 1;<br>
	                			life = 8;<br>
	                			ans = (int) (Math.random() * 1000) + 1;<br>
	                			<br>
	                			dec.dec(ch, helper);<br>
	                			<br>
	                			break;<br>
	<br>
	                			<br>
                		}<br>
	                			<br>
                             		<br>
                		if(clear) {<br>
                			System.out.println("== Stage " + stage + " 클리어!! ==");<br>
                			System.out.println("-시도 횟수 : " + numofguesses + " -남은 기회 : " + life);<br>
                			System.out.println("");<br>
                			stage++;<br>
                			numofguesses = 0;<br>
                			clear = false;<br>
                		} else if (win) {<br>
                			System.out.println("== Stage " + stage + " 클리어!! ==");<br>
                			System.out.println("-시도 횟수 : " + numofguesses + " -남은 기회 : " + life);<br>
                			System.out.println("");<br>
                			<br>
                			System.out.println(" !! 모든 스테이지를 클리어 하셨습니다. !!");<br>
                			System.out.println("!! 당신은 UpDown게임을 정벅하셨습니다. !!");<br>
                			System.out.println("     !! You Win !!");<br>
                			alive = false;<br>
                			//승리로 끝남!<br>
                		} else if(life == 0) { //패배시<br>
                			alive = false;<br>
                			System.out.println("- 정답은 " + ans + "입니다.");<br>
                			System.out.println("- 패배하였습니다.");<br>
                			System.out.println("- Game Over -");<br>
                			System.out.println("");<br>
                			System.out.print("-이어 하시려면 1을, 종료하시려면 아무 숫자나 입력하세요 :");<br>
                			<br>
                			int con = 0;<br>
                			<br>
                			try{<br>
                				con = sc.nextInt();<br>
                			} catch (java.util.InputMismatchException ex) {<br>
                            	err = true;<br>
                			}<br>
                			<br>
                			<br>
                			if(con == 1 &amp;&amp; !err) { //컨티뉴 기능<br>
                				alive = true;<br>
                				if(stage == 1) {<br>
                					life = 5;<br>
                				} else if(stage == 2) {<br>
                					life = 6;<br>
                				} else if(stage == 3) {<br>
                					life = 7;<br>
                				} else if(stage == 4) {<br>
                					life = 8;<br>
                				} else {<br>
                					life = 8;<br>
                				}<br>
                				System.out.println("");<br>
                				numofguesses = 0;<br>
                			} else if(!err) {<br>
                				System.out.println("");<br>
                				System.out.println("=게임을 종료합니다.=");<br>
                			}<br>
                		} <br>
                		<br>
                		if(err) {<br>
                			break;<br>
                		}<br>
                                                <br>
                	} //while문 끝<br>
                	<br>
                  <br>
                } //if문 끝<br>
                <br>
                if(err) {<br>
    				System.out.println("");<br>
                  	System.out.println("숫자를 입력하라니까요 ㅡㅡ");<br>
            		System.out.println("!! 에러로 게임을 종료합니다. !!");<br>
            	}<br>
                <br>
        } //메인 메소드 끝<br>
<br>
} //클래스 끝<br>
<br>
</code></pre>


<pre><code><br>
package upanddown;<br>
<br>
import java.util.Scanner;<br>
<br>
public class GameHelper extends UpDownGame {<br>
        <br>
    public int getInput() {<br>
    	<br>
        int Input = 0;<br>
        Scanner sc = new Scanner(System.in);<br>
        try {<br>
        	<br>
            System.out.println("  =숫자를 입력하세요.=  ");<br>
            System.out.println("-찬스를 사용하시려면 0을 입력하세요.-");<br>
            Input = sc.nextInt();<br>
        	<br>
        } catch (java.util.InputMismatchException ex) {<br>
        	err = true;<br>
        }<br>
<br>
        return Input;<br>
        <br>
    } //함수 끝<br>
        <br>
} //클래스 끝<br>
<br>
</code></pre>


<pre><code><br>
<br>
package upanddown;<br>
<br>
public class UpDownGame {<br>
	<br>
	public static int guess = 0;<br>
	public static int ans = 0;<br>
	public static int life = 0;<br>
	public static int max = 0;<br>
	public static int min = 0;<br>
	public static int numofguesses = 0;<br>
	public static boolean clear = false;<br>
	public static boolean win = false;<br>
	public static boolean chv = true;<br>
	public static int stage = 1; //라운드는 1부터<br>
	public static boolean err = false;<br>
	<br>
<br>
}<br>
<br>
<br>
</code></pre>


<pre><code><br>
package upanddown;<br>
<br>
public class Chances extends UpDownGame {<br>
        <br>
        int ranch = (int) (Math.random() * 20) + 1;<br>
 <br>
        public void pch() {<br>
                <br>
            switch(ranch) {<br>
            <br>
            case 1:<br>
            case 11:<br>
                    System.out.println("  --짝/홀 찬스--  ");<br>
                    <br>
                    if((ans % 2) == 0) {<br>
                    	System.out.println("==답은 '짝수' 입니다.==");<br>
                    } else {<br>
                    	System.out.println("==답은 '홀수' 입니다.==");<br>
                    }<br>
                    break;<br>
<br>
            <br>
            case 2:<br>
            case 12:<br>
                    System.out.println("  --3의 배수 찬스--  ");<br>
                    <br>
                    if((ans % 3) == 0) {<br>
                    	System.out.println("==답은 '3의 배수' 입니다.==");<br>
                    } else {<br>
                    	System.out.println("==답은 3의 배수가 아닙니다.==");<br>
                    }<br>
                    <br>
                    break;<br>
            <br>
            <br>
            case 3:<br>
            case 13:<br>
                    System.out.println("  --기회 추가--  ");<br>
                    System.out.println("==기회가 '1회 추가' 되었습니다!==");<br>
                    <br>
                    life++;<br>
                    <br>
                    break;<br>
                    <br>
            case 4:<br>
            case 14:<br>
            		System.out.println("  --기회 감소--  ");<br>
            		System.out.println("==기회가 '1회 감소' 되었습니다 호갱님^^==");<br>
                    <br>
                    life--;<br>
                    <br>
                    break;<br>
                    <br>
            case 5:<br>
            case 15:<br>
            		int mid = (int) (max + min) / 2;<br>
            	<br>
            		<br>
            		System.out.println("  --반띵 찬스!!--  ");<br>
                    <br>
            		if (ans &gt; mid) {<br>
            		min = mid;<br>
                    	System.out.println("==답은 " + min + " 보다 크고, " + max + " 보다 작습니다.==");<br>
                    } else if(ans &lt; mid) {<br>
                    	max = mid;<br>
                    	System.out.println("==답은 " + min + " 보다 크고, " + max + " 보다 작습니다.==");<br>
                    } else {<br>
                    	clear = true;<br>
                    } <br>
                    <br>
                    break;<br>
                    <br>
            case 6:<br>
            case 16:<br>
                    System.out.println("==  아쉽지만 꽝이네요.  ==");<br>
                    break;<br>
                    <br>
            case 7:<br>
            case 17:<br>
            		int one = 0;<br>
            	<br>
            		if(ans &lt; 10) {<br>
            			one = (int) ans;<br>
            		} else if(ans &lt; 100) {<br>
            			one = (int) ans % 10;<br>
            		} else if(ans &lt; 1000) {<br>
            			one = (int) (ans % 100) % 10;<br>
            		} else {<br>
            			one = 0;<br>
            		}<br>
            		<br>
            		System.out.println("  --일의 자리 찬스--  ");<br>
            		System.out.println("==정답의 일의 자리는 '" + one + "'입니다.==");<br>
            		<br>
            		break;<br>
            		<br>
            case 8:<br>
            case 18:<br>
            		int fin = 0;<br>
            		<br>
            		if(ans &lt; 10) {<br>
            			fin = (int) ans;<br>
            		} else if(ans &lt; 100) {<br>
            			fin = (int) ans / 10;<br>
            		} else if(ans &lt; 1000) {<br>
            			fin = (int) ans / 100;<br>
            		} else {<br>
            			fin = 1;<br>
            		}<br>
            		<br>
            		System.out.println("  --윗 자리 찬스--");<br>
            		System.out.println("==정답의 가장 윗자리 숫자는 '" + fin + "' 입니다.==");<br>
            		<br>
            		break;<br>
            		<br>
            case 9:<br>
            case 19:<br>
            		System.out.println("  --몇 자리 찬스--  ");<br>
            	<br>
            		if(ans &lt; 10) {<br>
            			System.out.println("==정답은 '한 자리 수'입니다.==");<br>
            		} else if(ans &lt; 100) {<br>
            			System.out.println("==정답은 '두 자리 수'입니다.==");<br>
            		} else if(ans &lt; 1000) {<br>
            			System.out.println("==정답은 '세 자리 수'입니다.==");<br>
            		} else {<br>
            			System.out.println("==!!정답은 '네자리 수'입니다.=!!==");<br>
            		}<br>
            		<br>
            		break;<br>
            		<br>
            case 10:<br>
            		System.out.println("  --!!클리어 찬스!!--");<br>
            		System.out.println("==이번 스테이지가 클리어 됩니다.==");<br>
            		<br>
            		clear = true;<br>
            		<br>
            		break;<br>
            		<br>
            case 20:<br>
            		System.out.println("  --패배 찬스--  ");<br>
            		System.out.println("==그냥 아무 이유없이 패배합니다.==");<br>
            		<br>
            		life = 0;<br>
            		<br>
            		break;<br>
<br>
                    <br>
<br>
            } //스위치문 끝<br>
                <br>
        } //함수 <br>
        <br>
} //클래스 끝<br>
<br>
</code></pre>


<pre><code><br>
package upanddown;<br>
<br>
public class Decide extends UpDownGame{<br>
	<br>
	public void dec(Chances ch, GameHelper helper) {<br>
		<br>
		while(life &gt; 0 &amp;&amp; !clear &amp;&amp; !win) {<br>
		<br>
			do {<br>
				<br>
				System.out.println("-life: " + life);<br>
				System.out.println("-" + min + "에서 " + max + " 사이의 숫자를 맞춰야 합니다.");<br>
				System.out.println("");<br>
			<br>
				guess = helper.getInput();<br>
				System.out.println("");	<br>
			<br>
				if(guess == 0 || guess == 9998/*치트키*/) {<br>
					break;<br>
				}<br>
			<br>
			} while(guess &gt; max || guess &lt; min);<br>
			<br>
			<br>
			if(!err) {<br>
				<br>
				if(guess == ans) {<br>
					if(stage == 5) {<br>
						win = true;<br>
					} else {<br>
						clear = true;<br>
					}<br>
					life--;<br>
				} else if(guess == 0 &amp;&amp; chv) {<br>
					//찬스 사용!!<br>
					ch.pch();<br>
					chv = false;<br>
					System.out.println("");<br>
					numofguesses--;<br>
				} else if(guess == 0) {<br>
					System.out.println("!! 찬스 기회를 모두 사용하여 사용 하실 수 없습니다. !!");<br>
					numofguesses--;<br>
				} else if(guess &lt; ans) {<br>
					System.out.println("== Up!! ==");<br>
					min = guess;<br>
					life--;<br>
				} else if(guess == 9998) { //치트키<br>
					System.out.println(ans);<br>
					numofguesses--;<br>
				} else{<br>
					System.out.println("== Down!! ==");<br>
					max = guess;<br>
					life--;<br>
				}<br>
			<br>
			} else if(err) {<br>
				break;<br>
			}<br>
			<br>
			guess = 0;<br>
			numofguesses++;<br>
		<br>
		}<br>
<br>
	}<br>
	<br>
}<br>
<br>
<br>
</code></pre>


일단 완성. 수정할 부분 있으면 차후 수정하겠습니다.<br>
<br>
컨티뉴 부분 추가, 찬스 대폭추가<br>
<br>
폭풍같은 가독성 상승을 위한 Decide 클래스 추가<br>
<br>
버그 수정<br>
<br>
-기말고사 답안지에 썼던 것처럼 상속 관계 이용해서 변수들의 가독성을 높였습니다.<br>
+ 자잘한 것들 살짝 수정<br>
<br>
-try catch 구문으로 숫자 입력받을 때 숫자 아닌거 들어오면 게임을 종료하도록 설정.<br>
<br>
boolean == true, false라고 되어있던거 가독성 좋게 수정<br>
<br>
<br>
<h1>ScreenShots</h1>

1. 실행 초기화면<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up1.png'>

2. 도움말 이후 시작화면<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up2.png'>

3. 게임 진행 화면 & 한 스테이지 클리어 화면<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up3.png'>

4. 찬스 사용 화면<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up4.png'>

5. 찬스 사용 이후 또 사용하려는 화면<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up5.png'>

6. 범위 밖 숫자 입력시<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up6.png'>

7. 숫자 아닌거 입력시 종료<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up7.png'>

8. 패배 장면<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up8.png'>

9. 모든 스테이지 클리어 = win 장면<br>
<img src='http://comp166-koreauniv.googlecode.com/files/up9.png'>


<h1>Downloads</h1>

<a href='http://comp166-koreauniv.googlecode.com/files/UpDownGame.zip'>http://comp166-koreauniv.googlecode.com/files/UpDownGame.zip</a>