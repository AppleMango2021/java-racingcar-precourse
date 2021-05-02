import java.util.Random;

public class Fuel {
	private static final int MAXIMUM_AMOUNT = 9;
	private static final int DEFAULT_AMOUNT = 0;

	private int fuel;

	public Fuel() {
		fuel = DEFAULT_AMOUNT;
	}

	public int remainingFuel() {
		return fuel;
	}

	public void injectFuel() {
		Random random = new Random();
		this.fuel = random.nextInt(MAXIMUM_AMOUNT + 1);
	}
}
