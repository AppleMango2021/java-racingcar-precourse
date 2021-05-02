import java.util.ArrayList;
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
}
