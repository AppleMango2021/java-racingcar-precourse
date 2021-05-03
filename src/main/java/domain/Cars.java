package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exception.InvalidInputException;
import view.Message;

public class Cars {

	private final List<Car> cars;

	public Cars(List<String> names) throws InvalidInputException {
		cars = createToCars(names);
	}

	private List<Car> createToCars(List<String> input) throws InvalidInputException {
		List<Car> toBeCars = new ArrayList<>();
		for (String name : input) {
			Car car = new Car(name);
			validateDuplicate(car, toBeCars);
			toBeCars.add(car);
		}
		return toBeCars;
	}

	private void validateDuplicate(Car car, List<Car> toBeCars) throws InvalidInputException {
		if (toBeCars.contains(car)) {
			throw new InvalidInputException(Message.ERROR_DUPLICATE_NAME);
		}
	}

	public String visualizePositions(String indicator) {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car.getName())
				.append(" : ")
				.append(car.distanceToImage(indicator))
				.append(System.lineSeparator());
		}
		return sb.toString();
	}

	public void move() {
		for (Car car : cars) {
			car.run();
		}
	}

	public List<Car> announceWinners() {
		Collections.sort(cars);
		int farthestDistance = cars.get(0).distanceSoFar();

		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			classifyWinners(car, winners, farthestDistance);
		}
		return winners;
	}

	private void classifyWinners(Car car, List<Car> winners, int farthestDistance) {
		if (car.distanceSoFar() == farthestDistance) {
			winners.add(car);
		}
	}
}
