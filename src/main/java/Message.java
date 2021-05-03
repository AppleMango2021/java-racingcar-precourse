public enum Message {

	REQUEST_INPUT_CARS_NAME("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
	REQUEST_INPUT_TOTAL_ROUND("시도할 횟수는 몇 회인가요?"),

	NOTICE_BEFORE_PRINT_RESULT("실행 결과"),
	NOTICE_WINNER("가 최종 우승했습니다."),

	ERROR_INVALID_NAME_LENGTH("이름은 다섯자 이하로 입력해주세요."),
	ERROR_DUPLICATE_NAME("중복되는 이름이 있습니다. 중복없이 입력해주세요."),
	ERROR_NULL_INPUT("반드시 값을 입력해주세요."),
	ERROR_NON_POSITIVE_NUMBER_VALUE("1 이상의 값을 입력해주세요."),
	ERROR_OVER_NUMBER_RANGE("범위에 맞는 숫자를 입력해주세요.(1이상 99이하)"),
	;

	private String text;

	Message(String text) {
		this.text = text;
	}

	public String showText() {
		return text;
	}
}
