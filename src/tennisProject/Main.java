package tennisProject;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		GameManager gm = new GameManager();
		DataManager dm = DataManager.getInstance();
		
		String currentDirectory = System.getProperty("user.dir");
		File file = new File(currentDirectory +"\\log_tennis.txt");
		if (file.exists()) file.delete();
		
		while(true) {
			dm.reset();
			gm.startGame();
			try {
				System.out.println("> 다시 게임을 시작하려면 엔터");
				System.in.read();
				System.in.skip(System.in.available());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
