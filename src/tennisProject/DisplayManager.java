package tennisProject;

public class DisplayManager {

	private String[] strPoint = { "0", "15", "30", "40", "40A" };
	DataManager dm = DataManager.getInstance();
	FileManager fm = new FileManager();

	public void dispScoreBoard() {

		int t1Point = dm.getPoint()[0];
		int t2Point = dm.getPoint()[1];

		if (dm.nowTieBreak()) {//타이브레이크 전용 전광판
			String separator1 = " TIE┏─────────────────────────────┓TIE\n";
			String format =         " ┃ %-6s ┃     %-6s ┃     %-6s ┃   %-4s\t ┃ \n"; 
			String header = String.format (" ┃%6s   ┃   %-4s ┃   %-4s ┃   %-4s  ┃  \n", "선수","게임","세트","TIE 포인트");
			String separator2 = " ┠───────────────────────────────┨\n";
			String separator3 = " TIE┗─────────────────────────────┛TIE\n";
			String status1 = String.format
					(format, dm.getPlayers()[0], dm.getGameScore()[0], dm.getSetScore()[0], t1Point);//포인트 날 것 그대로 출력
			String status2 = String.format
					(format, dm.getPlayers()[1], dm.getGameScore()[1], dm.getSetScore()[1], t2Point);
			String scoreboard = separator1 +  header+ separator2 + status1 + status2 + separator3;

			System.out.print(scoreboard);
			fm.log(scoreboard);
		}else {

			String separator1 = " ┏───────────────────────────────┓\n";
			String format =         " ┃ %-6s ┃     %-6s ┃     %-6s ┃   %-4s\t ┃ \n"; 
			String header = String.format (" ┃%6s   ┃   %-4s ┃   %-4s ┃   %-4s  ┃  \n", "선수","게임","세트","포인트");
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
}