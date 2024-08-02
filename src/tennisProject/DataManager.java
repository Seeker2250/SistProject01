package tennisProject;

public class DataManager {

	private static DataManager instance = new DataManager();

	private int totalSetNumber = 0;
	private String[] players = new String[2];

	private int[] point = {0, 0};
	private int[] gameScore = {0, 0};
	private int[] setScore = {0, 0};

	private boolean isStop = false;
	private boolean isTieBreak = false;
	private boolean nowTieBreak = false;

	private DataManager() { }

	public static DataManager getInstance() {
		if (instance == null)
			instance = new DataManager();
		return instance;
	}

	public void pointWinner(int teamNumber) {

		this.point[teamNumber]++; 
		// Point score 로직
		if (point[teamNumber]>=3 && !nowTieBreak) {

			if (point[0] == point[1]) {
				point[0] =3;
				point[1] =3;
				System.out.println("\t\t듀스 발생");
			}

			if(Math.abs(point[0] - point[1]) >= 2 && point[teamNumber] == 4) {
				
				gameScore[teamNumber]++; 
				point = new int[]{0, 0};
				
			}else if (point[teamNumber]==5) {
				
				System.out.println("\t\t연속 득점 승리!");
				gameScore[teamNumber]++;
				point = new int[]{0, 0};
				
			}
		}

		// Game score 로직
		if (isTieBreak && gameScore[teamNumber] == 6 && (gameScore[0] == gameScore[1])) {
			
			nowTieBreak = true;
			tieBreakGame(teamNumber);

		}else if(gameScore[teamNumber] >= 6) {

			if (Math.abs(gameScore[0] - gameScore[1]) < 2) {
			}
			else{
				setScore[teamNumber]++;
				gameScore = new int[]{0, 0};
			}
		}
		
		// 승리팀 결정
		if (setScore[teamNumber] > totalSetNumber / 2) {
			
			System.out.println("*".repeat(50));
			System.out.printf("\t\t%s 승리\n", players[teamNumber]); 
			System.out.println("*".repeat(50));
			setScore = new int[]{0, 0};
			isStop = true;
		}
	}
	
	private void tieBreakGame(int teamNumber) {

		System.out.println("\t타이 진행중");

		if (point[teamNumber]>=6 && point[0]==point[1] ) {
			System.out.println("\t타이 포인트 듀스");
		}

		if (point[teamNumber]>=7 &&Math.abs(point[0]-point[1]) >=2 ) {
			setScore[teamNumber]++; 
			point = new int[]{0, 0};
			gameScore = new int[]{0, 0};
			System.out.println("타이브레이크 승리!!");
			nowTieBreak = false;
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
	public void setTieBreak(boolean isTieBreak) { this.isTieBreak = isTieBreak;	}
	public void setPlayers(String[] players) { this.players = players; }
	public String[] getPlayers() { return players; }
	public int[] getGameScore() { return gameScore;	}
	public int[] getSetScore() { return setScore; }
	public int[] getPoint() { return point;	}
	public boolean isStop() { return isStop; }
	public boolean nowTieBreak() { return nowTieBreak; }
}
