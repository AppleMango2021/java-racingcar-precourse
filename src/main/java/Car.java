public class Car implements Comparable<Car> {

	private static final int MINIMUM_REQUIRED_FUEL = 4;
	private static final int UPPER_BOUND_NAME_LENGTH = 5;

	private String name;
	private Fuel fuel;
	private Distance drivenDistance;

	public Car(String name) throws InvalidInputException {
		validateNameLength(name);
		this.name = name;
		fuel = new Fuel();
		drivenDistance = new Distance();
	}

	private void validateNameLength(String name) throws InvalidInputException {
		if (name.length() > UPPER_BOUND_NAME_LENGTH) {
			throw new InvalidInputException(Message.ERROR_INVALID_NAME_LENGTH);
		}
	}

	private boolean readyToRun() {
		return fuel.remainingFuel() >= MINIMUM_REQUIRED_FUEL;
	}

	public int distanceSoFar() {
		return drivenDistance.showDistance();
	}

	public void run() {
		fuel.injectFuel();
		if (readyToRun()) {
			drivenDistance.moveForward();
		}
	}

	public String getName() {
		return name;
	}

	public String distanceToImage(String indicator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < drivenDistance.showDistance(); i++) {
			sb.append(indicator);
		}
		return sb.toString();
	}

	@Override
	public int compareTo(Car other) {
		return other.distanceSoFar() - this.distanceSoFar();
	}
}
