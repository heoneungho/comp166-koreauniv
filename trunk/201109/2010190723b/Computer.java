import java.util.*;
import java.io.*;

public class Computer extends Player {
	Computer(String n) {
		super(n);
	}

	public String selectCard() {
		Random r = new Random();
		int k = r.nextInt(haveCard.size());
		String rt = haveCard.get(k);
		return rt;
	}

}
