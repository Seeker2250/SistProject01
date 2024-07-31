package tennisProject;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		GameManager gm = new GameManager();
		DataManager dm = DataManager.getInstance();
		File file = new File("C:\\Users\\User\\Documents\\tennis.txt");
		if (file.exists()) file.delete();
		while(true) {
			dm.reset();
			gm.startGame();
			try {
				System.out.println("> 엔터치면 진행한다.");
				System.in.read();
				System.in.skip(System.in.available());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
