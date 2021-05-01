import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	@DisplayName("이름 다섯자 초과인 경우 false 리턴")
	void 이름길이_다섯글자_초과인_경우_false리턴() {
		//Given + When
		String carName = "Ferrari";

		//Then
		assertThat(NameUtils.isValidLength(carName)).isFalse();
	}
}
