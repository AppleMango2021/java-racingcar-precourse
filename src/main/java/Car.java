import java.util.Objects;

public class Car {

	public static final int MINIMUM_REQUIRED_FUEL = 4;
	public static final int UPPER_BOUND_NAME_LENGTH = 5;

	private String name;
	private int fuel;
	private int drivenDistance;

	public Car(String name) throws InvalidInputException {
		validateLength(name);
		this.name = name;
	}

	private void validateLength(String name) throws InvalidInputException {
		if (name.length() > UPPER_BOUND_NAME_LENGTH) {
			throw new InvalidInputException(Message.ERROR_INVALID_NAME_LENGTH);
		}
	}

	public boolean readyToRun() {
		return this.fuel >= MINIMUM_REQUIRED_FUEL;
	}

	public void fillFuel(int fuelAmount) {
		this.fuel = fuelAmount;
	}

	public int distanceSoFar() {
		return this.drivenDistance;
	}

	public void run() {
		//규칙이 변경되면 한 칸 이상씩 움직일 수도 있지 않을까?
		if (readyToRun()) {
			drivenDistance += 1;
		}
	}
}
