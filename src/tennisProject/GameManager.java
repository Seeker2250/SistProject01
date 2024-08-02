package tennisProject;

import java.util.Random;
import java.util.Scanner;

public class GameManager {
	DataManager dm = DataManager.getInstance();
	DisplayManager dsm = new DisplayManager();

	public void startGame() {
		initSettings();
		Random rnd = new Random();

		while (!dm.isStop()) {

			System.out.println("> 엔터키를 눌러 게임 진행 <");
			try {
				System.in.read();
				System.in.skip( System.in.available() );
			} catch (Exception e) {
				e.printStackTrace();
			}

			int i = rnd.nextInt(2);
			dsm.dispScoreBoard();
			dm.pointWinner(i);
		}
	}

	private void initSettings() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String regex = "[1-2]";
		String input = null;
		
		do {
			System.out.print("=".repeat(15));
			System.out.print("세트 선택");
			System.out.println("=".repeat(15));
			System.out.println("\t[1] 3set \t[2] 5set ");
			System.out.print("\t\t선택 ? ");
			input = scanner.next();
		} while (!input.matches(regex));
		int setNumber = input.equals("1") ? 3 : 5;
		dm.setTotalSetNumber(setNumber);
		
		do {
			System.out.print("=".repeat(11));
			System.out.print("타이브레이크 적용");
			System.out.println("=".repeat(11));
			System.out.println("\t[1] O \t\t[2] X ");
			System.out.print("\t\t선택 ? ");
			input = scanner.next();
		} while (!input.matches(regex));
		boolean isTieBreak = input.equals("1");
		dm.setTieBreak(isTieBreak);
		
		regex = "[1-5]";
		String[] players = { "김준석", "원충희", "박준용", "최사랑", "이시훈" };
		String selectedPlayer[] = new String[2];
		for (int i = 0; i < selectedPlayer.length; i++) {
			do {
				System.out.print("=".repeat(12));
				System.out.printf("%d번째 선수 선택", i+1);
				System.out.println("=".repeat(12));
				System.out.printf("  [1] %s [2] %s [3] %s \n\t[4] %s [5] %s \n",
						players[0], players[1], players[2], players[3], players[4]);
				System.out.print("\t\t선택 ? ");
				input = scanner.next();
			} while (!input.matches(regex) || players[Integer.parseInt(input)-1].equals(selectedPlayer[0]));
			selectedPlayer[i] = players[Integer.parseInt(input)-1];
		}
		dm.setPlayers(selectedPlayer);
	}
}
