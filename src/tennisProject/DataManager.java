package tennisProject;

public class DataManager {

	private static DataManager instance = new DataManager();

	private int totalSetNumber = 0;

	private int[] point = {0, 0};
	private int[] gameScore = {0, 0};
	private int[] setScore = {0, 0};

	private boolean isStop = false;

	private DataManager() { }

	public static DataManager getInstance() {
		if (instance == null)
			instance = new DataManager();
		return instance;
	}

	public void pointWinner(int teamNumber) {

		this.point[teamNumber]++; 
		// Point score 로직
		if (point[teamNumber]>=3) {

			if (point[0]==point[1]) {
				point[0] =3;
				point[1] =3;
				System.out.println("\t\t듀스 발생");
			}

			if(Math.abs(point[0]-point[1]) >=2 && point[teamNumber]==4) {
				gameScore[teamNumber]++; 
				point = new int[]{0, 0};
			}else if (point[teamNumber]==5) {
				System.out.println("\t\t연속 득점 승리!");
				gameScore[teamNumber]++;
				point = new int[]{0, 0};
			}
		}
		// Game score 로직
		if(gameScore[teamNumber]>=6) {
			if (Math.abs(gameScore[0] - gameScore[1]) < 2) {
			}
			else{
				setScore[teamNumber]++;
				gameScore = new int[]{0, 0};
				////승리
			}
		}
		// 승리팀 결정
		if (setScore[teamNumber] > totalSetNumber / 2) {
			System.out.println("*".repeat(50));
			System.out.printf("\t\t%d팀 승리\n", teamNumber+1); 
			System.out.println("*".repeat(50));
			setScore = new int[]{0, 0};
			isStop = true;
		}
	}

	public void reset() {
		totalSetNumber = 0;
		setScore = new int[]{0, 0};
		gameScore = new int[]{0, 0};
		point = new int[]{0, 0};
		isStop = false;
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
