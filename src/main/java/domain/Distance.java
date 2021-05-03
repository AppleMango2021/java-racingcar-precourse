package domain;

public class Distance {

	private static final int MOVING_UNIT = 1; //이동단위
	private static final int DEFAULT_DISTANCE = 0;

	private int distance;

	public Distance() {
		distance = DEFAULT_DISTANCE;
	}

	public int showDistance() {
		return distance;
	}

	public void moveForward() {
		distance += MOVING_UNIT;
	}
}
