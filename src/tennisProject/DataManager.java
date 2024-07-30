package tennisProject;

import lombok.Getter;

@Getter
public class DataManager {
	
	private static DataManager instance = new DataManager();
	//TODO 선수 이름
	private int totalSetNumber = 0;

	// point 0 == 0, 1 == 15, 2 == 30, 3 == 40 
	private int[] point = {0, 0};
	private int[] gameScore = {0, 0};
	private int[] setScore = {0, 0};
	
	private boolean isStop = true; // test

	private DataManager() { }
	public static DataManager getInstance() {
		if (instance == null)
			instance = new DataManager();
		return instance;
	}

	public void pointWinner(int teamNumber) {
		//TODO : 듀스 로직
		this.point[teamNumber]++;
		
		if (point[teamNumber] > 4) {
			gameScore[teamNumber]++;
			point = new int[]{0, 0};
		}
		
		if (gameScore[teamNumber] >= 6) {
			setScore[teamNumber]++;
			gameScore = new int[]{0, 0};
		}
		
		if (setScore[teamNumber] > totalSetNumber / 2) {
			System.out.printf("%d팀 승리\n", teamNumber+1); // test 게임종료
			setScore = new int[]{0, 0};
			isStop = false;
		}
	}
	
	public void reset() {
		//TODO
		//System.out.println("reset");
		totalSetNumber = 0;
		setScore = new int[]{0, 0};
		gameScore = new int[]{0, 0};
		point = new int[]{0, 0};
	}
	
	public void setTotalSetNumber(int totalSetNumber) {
		this.totalSetNumber = totalSetNumber;
	}
}
