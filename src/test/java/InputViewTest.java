import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import view.InputView;

public class InputViewTest {

	@Test
	@DisplayName("String 입력 점검 : 빈값 아니라 True 리턴")
	void String입력점검_빈값아님(){
		//Given
		InputView inputView = new InputView();

		//When + Then
		assertThat(inputView.hasValidStringInput("BMW, AUDI, Benz")).isTrue();
	}

	@Test
	@DisplayName("String 입력 점검 : 빈값이라 False 리턴")
	void String입력점검_빈값(){
		//Given
		InputView inputView = new InputView();

		//When + Then
		assertThat(inputView.hasValidStringInput("")).isFalse();
	}

	@Test
	@DisplayName("숫자 입력 점검 : 빈값 아니라 True 리턴")
	void 숫자입력점검_빈값아님(){
		//Given
		InputView inputView = new InputView();

		//When + Then
		assertThat(inputView.hasValidNumber("3")).isTrue();
	}

	@Test
	@DisplayName("숫자 입력 점검 : 빈값이라 False 리턴")
	void 숫자입력점검_빈값(){
		//Given
		InputView inputView = new InputView();

		//When + Then
		assertThat(inputView.hasValidNumber("")).isFalse();
	}

	@Test
	@DisplayName("숫자 입력 점검 : 음수라 False 리턴")
	void 숫자입력점검_음수(){
		//Given
		InputView inputView = new InputView();

		//When + Then
		assertThat(inputView.hasValidNumber("-1")).isFalse();
	}

	@Test
	@DisplayName("숫자 입력 점검 : 99초과의 값이라 False 리턴")
	void 숫자입력점검_범위초과(){
		//Given
		InputView inputView = new InputView();

		//When + Then
		assertThat(inputView.hasValidNumber("100")).isFalse();
	}

	@Test
	@DisplayName("숫자 입력 점검 : 숫자가 아니라 False 리턴")
	void 숫자입력점검_알파벳입력함(){
		//Given
		InputView inputView = new InputView();

		//When + Then
		assertThat(inputView.hasValidNumber("a")).isFalse();
	}
}
