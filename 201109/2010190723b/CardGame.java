import java.util.*;
import java.io.*;

public class CardGame {
	Player player;
	Player cpu;
	int card[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int bonus;

	public static void main(String[] args) {
		System.out.println("Let's Start a Card Game ");
		CardGame cg = new CardGame();
		cg.start();
	}

	CardGame() {
		player = new Player("�÷��̾�");
		cpu = new Computer("��ǻ��");
	}

	public void start() {
		mix();
		sendCard();

		for (int i = 0; i < 10; i++) {
			int p = player.sendCard(player.selectCard());
			int c = cpu.sendCard(cpu.selectCard());
			System.out.println("player : " + p + " VS " + c + " cpu");
			if (p > c) {
				System.out.println("����� �̰���ϴ�!    " + (1 + bonus) + "��ȹ��");
				player.catchPoint(1 + bonus);
				bonus = 0;
			} else if (p < c) {
				System.out.println("��ǻ�Ͱ� �̰��! !!!     " + (2 + bonus) + "��ȹ��");
				cpu.catchPoint(2 + bonus);
				bonus = 0;
			} else if (p == c) {
				System.out.println("���º��Դϴ�.");
				bonus += 1;
			}
			System.out.println("p:" + player.showPoint() + " VS c:"
					+ cpu.showPoint() + "\n");
		}
		int p = player.showPoint();
		int c = cpu.showPoint();
		if (p > c)
			System.out.println("\n �̱�̽��ϴ� ^^\n");
		else if (p < c)
			System.out.println("\n ���̽��ϴ� �̤�\n");
		else
			System.out.println("\n �����ϴ� !!! --!\n");
	}

	public void sendCard() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0)
				player.receiveCard(String.valueOf(card[i]));
			else
				cpu.receiveCard(String.valueOf(card[i]));
		}
		System.out.println(player.showMyCard() + " �̷��� ī����� �޾ҽ��ϴ�.\n");
	}

	public void mix() {
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int i1 = r.nextInt(20);
			int i2 = r.nextInt(20);
			int i3 = card[i1];
			card[i1] = card[i2];
			card[i2] = i3;
		}
	}
}
