package domain;

public class Round {
	private int round;

	public Round(int round) {
		this.round = round;
	}

	public int remainingRound() {
		return round;
	}

	public int oneRoundFinished() {
		return round -= 1;
	}
}
