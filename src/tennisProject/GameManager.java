package tennisProject;

import java.util.Random;

public class GameManager {
	DataManager dm = DataManager.getInstance();
	DisplayManager dsm = new DisplayManager();
	
	public void startGame() {
		//TODO : ��Ʈ ����, ���� ����, ���� ���� ���� , ��������
		dm.setTotalSetNumber(3); // test 
		Random rnd = new Random();
		
		while (!dm.isStop()) { // test
			int i = rnd.nextInt(2);
			dsm.dispScoreBoard();
			dm.pointWinner(i);
		}
	}

}
