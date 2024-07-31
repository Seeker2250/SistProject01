package tennisProject;

import java.io.IOException;
import java.util.Random;

public class GameManager {
	DataManager dm = DataManager.getInstance();
	DisplayManager dsm = new DisplayManager();
	
	public void startGame() {
		dm.setTotalSetNumber(3); // test 
		Random rnd = new Random();
		
		while (!dm.isStop()) { // test
			int i = rnd.nextInt(2);
			dm.pointWinner(i);
			dsm.dispScoreBoard();
			
			System.out.println("> 엔터치면 진행한다.");
			try {
				System.in.read();
				System.in.skip( System.in.available() );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
