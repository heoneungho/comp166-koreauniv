import java.io.*;

class Gugudan {
	GugugameSound sound = new GugugameSound();
	private int comnum;

	private int result;

	public String setComState()

	{

		comnum = (int) (Math.random() * 8 + 1);

		return " * " + comnum + " = ";

	}

	public String setResult(int x)

	{

		result = x * comnum;

		return "a: " + result;

	}

	public String getTrue(int y)

	{

		if (result == y)

		{

			return "y";

		} else

			sound.play();
		return "-_-;;";

	}

};

public class Gugugame

{

	public static void main(String[] args) throws Exception {

		int b = 0, f = 0;

		String str1, str2;

		System.out.print(" to exit) >>");

		BufferedReader d = new BufferedReader(new InputStreamReader(System.in));

		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));

		str1 = d.readLine();

		Gugudan g = new Gugudan();

		while (!str1.equals("0")) {

			b = Integer.valueOf(str1).intValue();

			System.out.print("a: " + b);

			System.out.print(g.setComState());

			str2 = e.readLine();

			f = Integer.valueOf(str2).intValue();

			System.out.println(g.setResult(b));

			System.out.println(g.getTrue(f));

			System.out.println("to exit)>>");

			str1 = d.readLine();

		}

		System.out.println("b");

	}
}
