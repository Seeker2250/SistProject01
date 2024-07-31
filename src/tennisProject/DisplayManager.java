package tennisProject;

public class DisplayManager {

	private String[] strPoint = { "0", "15", "30", "40", "40A" };
	DataManager dm = DataManager.getInstance();
	FileManager fm = new FileManager();

	public void dispScoreBoard() {

		int t1Point = dm.getPoint()[0];
		int t2Point = dm.getPoint()[1];
		if (t1Point  > 0) {
		}
		String separator1 = " ┏───────────────────────────────┓\n";

		String format =         " ┃ %-6s ┃     %-6s ┃     %-6s ┃   %-4s\t ┃ \n"; 

		String header = String.format (" ┃%6s   ┃   %-4s ┃   %-4s ┃   %-4s  ┃  \n", "팀","게임","세트","포인트");
		String separator2 = " ┠───────────────────────────────┨\n";
		String separator3 = " ┗───────────────────────────────┛\n";
		String status1 = String.format
				(format, dm.getPlayers()[0], dm.getGameScore()[0], dm.getSetScore()[0], strPoint[t1Point]);
		String status2 = String.format
				(format, dm.getPlayers()[1], dm.getGameScore()[1], dm.getSetScore()[1], strPoint[t2Point]);
		String scoreboard = separator1 +  header+ separator2 + status1 + status2 + separator3;

		System.out.print(scoreboard);
		fm.log(scoreboard);
	}
}
