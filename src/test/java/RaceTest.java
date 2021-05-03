import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Cars;
import domain.Race;

public class RaceTest {

	@Test
	@DisplayName("레이스 시작 전, 참가자동차들 및 라운드 수가 결정되었는지 점검")
	void 레이스_시작전_객체들_점검() {
		//Given
		Cars cars = new Cars(Arrays.asList("BMW", "Audi", "Ford"));

		//When
		Race race = new Race(3, cars);

		//Then
		assertThat(race.getCars()).isNotNull();
		assertThat(race.getRound()).isNotNull();
	}

	@Test
	@DisplayName("레이스 시작 시, 라운드가 감소하는 지 점검")
	void 레이스_시작후_라운드감소하는지_점검() {
		//Given
		Cars cars = new Cars(Arrays.asList("BMW", "Audi", "Ford"));
		Race race = new Race(3, cars);

		//When
		race.start();

		//Then
		assertThat(race.getRound().remainingRound()).isEqualTo(0);
	}
}
