package tennisProject;

public class DataManager {
	
	private static DataManager instance = new DataManager();

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
				// teamNumber = 이긴팀 0 -1팀승 1 - 2팀승 

				this.point[teamNumber]++; //포인트 땄다

				if (point[teamNumber]>=3) { // 한 놈이 40점 이상일 때 (듀스 검사해야됨)

					if (point[0]==point[1]) {// 같으면 듀스메세지

						point[0] =3;
						point[1] =3;
						System.out.println("\t\t듀스 발생");
					}

					if(Math.abs(point[0]-point[1]) >=2 && point[teamNumber]==4) { //40A 상태에서 2점차이 이상나면 바로 승리
						gameScore[teamNumber]++; 
						point = new int[]{0, 0};
					}else if (point[teamNumber]==5) { // 40A 40 일때 서로 포인트가 달라서 40초기화 안됨=> 한쪽 포인트 5 (40AA느낌)뜨면 승리하고 리셋(출력X)
						System.out.println("\t\t연속 득점 승리!");
						gameScore[teamNumber]++;
						point = new int[]{0, 0};
					}
				}

				if(gameScore[teamNumber]>=6) {
					if (Math.abs(gameScore[0] - gameScore[1]) < 2) {
					}
					else{
						setScore[teamNumber]++;
						gameScore = new int[]{0, 0};
						////승리
					}
				}

				if (setScore[teamNumber] > totalSetNumber / 2) {
					System.out.printf("%d팀 승리\n", teamNumber+1); 
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