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

	public List<String> returnCarNames() {
		String input = "";
		boolean stopReceivingInput = false;

		while (!stopReceivingInput) {
			input = scanner.nextLine();
			stopReceivingInput = hasValidNames(input);
		}
		return NameUtils.separateByComma(input);
	}

	private boolean hasValidNames(String input) {
		boolean stopReceivingInput = false;
		try {
			stopReceivingInput = checkNamingRules(input);
		} catch (InvalidInputException e) {
			outputView.printMessage(e.getMessage());
		}
		return stopReceivingInput;
	}

	private boolean checkNamingRules(String input) throws InvalidInputException {
		checkNotNull(input);
		List<String> names = NameUtils.separateByComma(input);
		for (String name : names) {
			NameUtils.isValidLength(name);
		}
		return true;
	}

	private void checkNotNull(String input) throws InvalidInputException {
		if (input == null || input.length() == 0) {
			throw new InvalidInputException(Message.ERROR_NULL_INPUT);
		}
	}

	public int returnNumber() {
		String input = "";
		boolean stopReceivingInput = false;

		while (!stopReceivingInput) {
			input = scanner.nextLine();
			stopReceivingInput = hasValidNumber(input);
		}
		return Integer.parseInt(input);
	}

	private boolean hasValidNumber(String input) {
		boolean stopReceivingInput = false;
		try {
			stopReceivingInput = checkRoundRules(input);
		} catch (InvalidInputException e) {
			outputView.printMessage(e.getMessage());
		}
		return stopReceivingInput;
	}

	private boolean checkRoundRules(String input) {
		checkNotNull(input);
		checkValidNumberRange(input);

		return true;
	}

	private void checkValidNumberRange(String input) throws InvalidInputException {
		String validPattern = "[1-9][0-9]*";
		if (Integer.parseInt(input) < 1) {
			throw new InvalidInputException(Message.ERROR_NON_POSITIVE_NUMBER_VALUE);
		}
		if (!Pattern.matches(validPattern, input)) {
			throw new InvalidInputException(Message.ERROR_OVER_NUMBER_RANGE);
		}
	}
}
