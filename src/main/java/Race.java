public class Race {
	private static final String POSITION_INDICATOR = "-";

	private Round round;
	private Cars cars;
	private OutputView outputView;

	public Race(int round, Cars cars) {
		this.round = new Round(round);
		this.cars = cars;
		this.outputView = new OutputView();
	}

	public void start() {
		while (round.remainingRound() != 0) {
			cars.move();
			outputView.printMessage(cars.visualizePositions(POSITION_INDICATOR));
			round.oneRoundFinished();
		}
	}

	public Round getRound() {
		return round;
	}
}
