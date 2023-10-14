package Base;

public class Player {
	private int score = 0;
	private int turn;
	
	public Player(int turn) {
		this.turn = turn;
	}
	
	public void setScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getTurn() {
		return turn;
	}
}
