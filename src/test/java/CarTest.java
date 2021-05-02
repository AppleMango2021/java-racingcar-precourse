import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("영어로 이름이 다섯글자가 넘는 경우, 예외반환")
	void 영어이름_다섯글자넘어가면_예외반환() {
		//Given
		String name = "Ferrari";

		//When + Then
		assertThatThrownBy(() -> {
			Car carWithInvalidName = new Car(name);
		})
			.isInstanceOf(InvalidInputException.class);
	}

	@Test
	@DisplayName("한국어로 이름이 다섯글자가 넘는 경우, 예외반환")
	void 한글이름_다섯글자넘어가면_예외반환() {
		//Given
		String name = "현대자동차 등";

		//When + Then
		assertThatThrownBy(() -> {
			Car carWithInvalidName = new Car(name);
		})
			.isInstanceOf(InvalidInputException.class);
	}

	@Test
	@DisplayName("자동차가 전진 또는 멈춤만 수행하는지 점검")
	void 전진_또는_멈춤만_수행() {
		for (int i = 0; i < 100; i++) {
			Car car = new Car("Audi");
			int distanceBeforeRun = car.distanceSoFar();
			car.run();
			int distanceAfterRun = car.distanceSoFar();
			assertThat(distanceAfterRun).isGreaterThanOrEqualTo(distanceBeforeRun);
		}
	}
}
