import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("자동차의 연료량이 4 이상인지 점검")
	void 자동차연료량_4이상인_경우에만_이동가능() {
		//Given
		Car carWithEnoughFuel = new Car();
		Car carLackOfFuel = new Car();

		//When
		carWithEnoughFuel.fillFuel(4);
		carLackOfFuel.fillFuel(3);

		//Then
		assertThat(carWithEnoughFuel.readyToRun()).isEqualTo(true);
		assertThat(carLackOfFuel.readyToRun()).isEqualTo(false);
	}

	@Test
	@DisplayName("이동가능한 경우, 한 칸 이동했는지 점검")
	void 이동가능_경우에만_이동거리_한칸증가() {
		//Given
		Car carCanMove = new Car();

		//When
		int beforeRun = carCanMove.distanceSoFar();
		carCanMove.fillFuel(5);
		carCanMove.run();

		//Then
		int afterRun = carCanMove.distanceSoFar();
		assertThat(afterRun).isEqualTo(beforeRun + 1);
	}

	@Test
	@DisplayName("이동불가능한 경우, 이동거리가 변하지 않았음을 점검")
	void 이동불가능_경우_이동거리_기존유지() {
		//Given
		Car carCannotMove = new Car();

		//When
		int beforeRun = carCannotMove.distanceSoFar();
		carCannotMove.fillFuel(3);
		carCannotMove.run();

		//Then
		int afterRun = carCannotMove.distanceSoFar();
		assertThat(afterRun).isEqualTo(beforeRun);
	}
}
