import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("유효한 이름들 입력했을 때, Cars객체 정상생성하는지 점검")
	void 이름리스트를_Cars객체로_변환() {
		//Given + When
		Cars cars = new Cars(Arrays.asList("BMW", "Audi"));

		//Then
		assertThat(cars).isNotNull();
	}

	@Test
	@DisplayName("유효하지 않은 이름을 하나라도 입력했을 때, 예외반환")
	void 유효하지_않은_이름리스트는_예외반환() {
		//Given
		List<String> strings = new ArrayList<>();
		strings.add("Ferrari");
		strings.add("Audi");

		//When + Then
		assertThatThrownBy(() -> {Cars cars = new Cars(strings);})
			.isInstanceOf(InvalidInputException.class);
	}

	@Test
	@DisplayName("주행거리 비교하여 우승자 선정하는지 점검")
	void 우승자_혹은_우승자들_선정(){
		//Given
		Cars cars = new Cars(Arrays.asList("Benz", "Audi", "Ford"));

		//When
		List<Car> winners = cars.announceWinners();

		//Then
		//현재는 race를 시작하기 전이므로 모두 이동거리가 같으며, 따라서 우승자는 총 3명이다.
		assertThat(winners.size()).isGreaterThanOrEqualTo(3);
	}

	@Test
	@DisplayName("중복되는 자동차 이름이 입력되었을 경우, 예외 반환")
	void 자동차이름_중복시_예외반환(){
		//Given
		List<String> strings = new ArrayList<>();
		strings.add("Ford");
		strings.add("Audi");
		strings.add("Audi");

		//When + Then
		assertThatThrownBy(() -> {Cars cars = new Cars(strings);})
			.isInstanceOf(InvalidInputException.class);
	}
}
