package domain;

import java.util.List;

import exception.InvalidInputException;
import utils.NameUtils;
import view.InputView;
import view.Message;
import view.OutputView;

public class Contest {

	private Race race;
	private Cars cars;
	private List<Car> winners;
	private InputView inputView;
	private OutputView outputView;

	public Contest() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void open() {
		if (checkCars() && checkNumber()) {
			outputView.printMessage(System.lineSeparator() + Message.NOTICE_BEFORE_PRINT_RESULT.showText());
			race.start();
			winners = cars.announceWinners();
			outputView.printMessage(NameUtils.listCarToStringName(winners));
		}
	}

	private boolean checkNumber() {
		outputView.printMessage(Message.REQUEST_INPUT_TOTAL_ROUND);
		return roundDecided(inputView.returnNumber());
	}

	private boolean checkCars() {
		boolean carsPrepared = false;
		outputView.printMessage(Message.REQUEST_INPUT_CARS_NAME);
		while (!carsPrepared) {
			carsPrepared = carsRegistered(inputView.returnSeparatedString());
		}
		return carsPrepared;
	}

	boolean roundDecided(int number) {
		race = new Race(number, cars);
		return true;
	}

	boolean carsRegistered(List<String> names) {
		try {
			cars = new Cars(names);
		} catch (InvalidInputException e) {
			outputView.printMessage(e.getMessage());
			return false;
		}
		return true;
	}
}
