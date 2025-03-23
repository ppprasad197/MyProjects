//14.Write a java program to accept to details of n Number of Players from user(Player code,name,runs,innings-played and number of times not out).The program should contain following menus:
//-Display average runs of a single player.
//-Display average runs of all players.(Use array of object,Method overloading)

package InterviewPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Players {

	private int jerseyNumber;
	private String name;
	private int runs;
	private int innings;
	private int notOut;

	public Players() {
		super();
	}

	public Players(int jerseyNumber, String name, int runs, int innings, int notOut) {
		super();
		this.jerseyNumber = jerseyNumber;
		this.name = name;
		this.runs = runs;
		this.innings = innings;
		this.notOut = notOut;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getInnings() {
		return innings;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public int getNotOut() {
		return notOut;
	}

	public void setNotOut(int notOut) {
		this.notOut = notOut;
	}

	@Override
	public String toString() {
		return "Players [jerseyNumber=" + jerseyNumber + ", name=" + name + ", runs=" + runs + ", innings=" + innings
				+ ", notOut=" + notOut + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("How many players you wants to add : ");
		int numberOfPlayers = sc.nextInt();

		List<Players> playersDetails = new ArrayList<>();

		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Enter player jersey number : ");
			int jerseyNumber = sc.nextInt();

			System.out.println("Enter player name : ");
			String name = sc.next();

			System.out.println("Enter runs scored : ");
			int runs = sc.nextInt();

			System.out.println("Enter number of innings : ");
			int innings = sc.nextInt();

			System.out.println("Enter number of time not out : ");
			int notout = sc.nextInt();

			playersDetails.add(new Players(jerseyNumber, name, runs, innings, notout));
		}

		for (Players player : playersDetails) {
			float average = player.getRuns() / (player.getInnings() - player.getNotOut());
			System.out.println(player + " Average is " + average);
		}

		int sumOfRuns = 0;
		int numberOfInnings = 0;
		int numberOfNotOut = 0;

		for (Players players : playersDetails) {

			sumOfRuns = sumOfRuns + players.getRuns();
			numberOfInnings = numberOfInnings + players.getInnings();
			numberOfNotOut = numberOfNotOut + players.getNotOut();

		}

		float averageOfTeam = sumOfRuns / (numberOfInnings - numberOfNotOut);
		System.out.println("Average of whole team is : " + averageOfTeam);

	}

}
