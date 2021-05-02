import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("유효한 이름들 입력했을 때, Cars객체 정상생성하는지 점검")
	void 이름리스트를_Cars객체로_변환() {
		//Given
		List<String> strings = new ArrayList<>();
		strings.add("BMW");
		strings.add("Audi");

		//When
		Cars cars = new Cars(strings);

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
}
