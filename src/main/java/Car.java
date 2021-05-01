public class Car {

	//최소로 요구되는 연료에 대한 기준을 자동차가 가지는 것이 맞을까?
	private static final int MINIMUM_REQUIRED_FUEL = 4;

	private int fuel;
	private int drivenDistance;

	public Car() {
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
