import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Car;
import utils.NameUtils;

public class NameUtilsTest {

	@Test
	@DisplayName("자동차 이름 입력시 ','로 구분")
	void 이름목록_생성_성공() {
		//Given + When
		List<String> carList = NameUtils.separateByComma("BMW,Benz,Audi");

		//Then
		assertThat(carList).containsExactly("BMW", "Benz", "Audi");
	}

	@Test
	@DisplayName("자동차 이름 입력시 ':'로 구분")
	void 이름목록_생성_실패() {
		//Given + When
		List<String> carList = NameUtils.separateByComma("BMW:Benz:Audi");

		//Then
		assertThat(carList.contains("BMW")).isEqualTo(false);
		assertThat(carList.size()).isNotEqualTo(3);
	}

	@Test
	@DisplayName("구분 시, 앞뒤 공백 제거하는지 점검")
	void 앞뒤_공백_제거하여_이름목록_생성() {
		//Given + When
		List<String> carList = NameUtils.separateByComma(" BMW , Ben z ,  Audi");

		//Then
		assertThat(carList).containsExactly("BMW", "Ben z", "Audi");
	}

	@Test
	@DisplayName("우승자 목록 전달시, 발표 안내문으로 변환하는지 점검")
	void 우승자목록_발표안내문으로_변환(){
		//Given
		List<Car> winner = new ArrayList<>();
		winner.add(new Car("BMW"));
		winner.add(new Car("Ford"));

		//When
		String result = NameUtils.listCarToStringName(winner);

		//Then
		assertThat(result.length()).isGreaterThan(0);
	}
}
