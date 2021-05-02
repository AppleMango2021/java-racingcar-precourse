import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<String> names) throws InvalidInputException {
		cars = createToCars(names);
	}

	private List<Car> createToCars(List<String> input) throws InvalidInputException {
		List<Car> cars = new ArrayList<>();
		for (String name : input) {
			Car car = new Car(name);
			cars.add(car);
		}
		return cars;
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
		for(Car car : cars){
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
