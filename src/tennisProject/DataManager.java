package tennisProject;

public class DataManager {
	
	private static DataManager instance = new DataManager();
	//TODO º±ºˆ ¿Ã∏ß
	private int totalSetNumber = 0;

	// point 0 == 0, 1 == 15, 2 == 30, 3 == 40 
	private int[] point = {0, 0};
	private int[] gameScore = {0, 0};
	private int[] setScore = {0, 0};
	
	private boolean isStop = false; // test
	
	private DataManager() { }
	public static DataManager getInstance() {
		if (instance == null)
			instance = new DataManager();
		return instance;
	}
	
	public void pointWinner(int teamNumber) {
		//TODO : µ‡Ω∫ ∑Œ¡˜
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
			System.out.printf("%d∆¿ Ω¬∏Æ\n", teamNumber+1); // test ∞‘¿”¡æ∑·
			setScore = new int[]{0, 0};
			isStop = true;
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
	
	public int[] getGameScore() {
		return gameScore;
	}
	public int[] getSetScore() {
		return setScore;
	}
	public int[] getPoint() {
		return point;
	}
	public boolean isStop() {
		return isStop;
	}
}
