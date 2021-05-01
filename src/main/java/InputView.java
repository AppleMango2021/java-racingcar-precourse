import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

	private Scanner scanner;
	private OutputView outputView;

	public InputView() {
		this.scanner = new Scanner(System.in);
		this.outputView = new OutputView();
	}

	public List<String> returnStringList() {
		String input = getInputUntilNotNull();
		return NameUtils.separateByComma(input);
	}

	public int returnNumber() {
		String input = "";
		boolean isValidNumber = false;
		while (!isValidNumber) {
			input = getInputUntilNotNull();
			isValidNumber = validateValue(input);
		}
		return Integer.parseInt(input);
	}

	private boolean validateValue(String input) {
		String validPattern = "[1-9][0-9]*";
		return Pattern.matches(validPattern, input) && Integer.parseInt(input) > 0;
	}

	private String getInputUntilNotNull() {
		String input;
		do {
			input = scanner.nextLine();
		} while (isInputNull(input));
		return input;
	}

	private boolean isInputNull(String input) {
		if (input.length() == 0) {
			outputView.printMessage(Message.ERROR_NULL_INPUT);
			return true;
		}
		return false;
	}
}
