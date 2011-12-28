import java.util.*;
import java.io.*;

public class Player {
	String name;
	Vector<String> haveCard = new Vector<String>();
	int catchPoint;

	Player(String n) {
		name = n;
	}

	public String showMyCard() {
		String show = "";
		for (int i = 0; i < haveCard.size(); i++)
			show += (String) haveCard.get(i) + ", ";
		return show;
	}

	public String selectCard() {
		String input = null;
		String rt = null;
		boolean turn = true;
		while (turn) {
			String show = "";
			for (int i = 0; i < haveCard.size(); i++)
				show += (String) haveCard.get(i) + ", ";
			System.out.println(show + " 어떤카드를 내시겠습니까?");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				input = br.readLine();
			} catch (Exception e) {
				System.out.println(e);
			}

			for (int i = 0; i < haveCard.size(); i++) {
				String hc = (String) haveCard.get(i);
				if (hc.equals(input))
					rt = hc;
			}
			if (rt != null)
				turn = false;
			else
				System.out.println("가지고 있지 않으신 카드입니다. 다시 선택하세요");
		}
		return rt;
	}

	public int sendCard(String s) {
		String rt = null;
		int index = 0;
		for (int i = 0; i < haveCard.size(); i++) {
			String hc = (String) haveCard.get(i);
			if (hc.equals(s)) {
				rt = hc;
				index = i;
			}
		}
		haveCard.remove(index);
		return Integer.parseInt(rt);
	}

	public void receiveCard(String r) {
		haveCard.addElement(r);
	}

	public void catchPoint(int k) {
		catchPoint += k;
	}

	public void reset() {
		haveCard.removeAllElements();
		catchPoint = 0;
	}

	public int showPoint() {
		return catchPoint;
	}

}
