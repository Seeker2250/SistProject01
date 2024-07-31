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
			int i = rnd.nextInt(2);
			dm.pointWinner(i);
			dsm.dispScoreBoard();

			System.out.println("> 엔터치면 진행합니다.");
			try {
				System.in.read();
				System.in.skip( System.in.available() );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void initSettings() {
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
	}
}
