package tennisProject;

public class DisplayManager {
	
	private String[] strPoint = { "0", "15", "30", "40", "40A"};
	DataManager dm = DataManager.getInstance();
	FileManager fm = new FileManager();
	
	public void dispScoreBoard() {
		
		int t1Point = dm.getPoint()[0];
		int t2Point = dm.getPoint()[1];
		//TODO : 출력 편집
		String status = String.format("[1팀] 포인트:%s, 게임:%d, 세트:%d "
				+ "[2팀] 포인트:%s, 게임:%d, 세트:%d\n", strPoint[t1Point],
				dm.getGameScore()[0],
				dm.getSetScore()[0],
				strPoint[t2Point],
				dm.getGameScore()[1],
				dm.getSetScore()[1]);
		
		System.out.print(status);
		fm.log(status);
	}
}
