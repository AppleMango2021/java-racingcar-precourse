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

	public List<String> returnSeparatedString() {
		String input = "";
		boolean stopReceivingInput = false;
		while (!stopReceivingInput) {
			input = scanner.nextLine();
			stopReceivingInput = hasValidStringInput(input);
		}
		return NameUtils.separateByComma(input);
	}

	boolean hasValidStringInput(String input) {
		boolean stopReceivingInput = false;
		try {
			stopReceivingInput = checkNotNull(input);
		} catch (InvalidInputException e) {
			outputView.printMessage(e.getMessage());
		}
		return stopReceivingInput;
	}

	private boolean checkNotNull(String input) throws InvalidInputException {
		if (input == null || input.length() == 0) {
			throw new InvalidInputException(Message.ERROR_NULL_INPUT);
		}
		return true;
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

	boolean hasValidNumber(String input) {
		boolean stopReceivingInput = false;
		try {
			stopReceivingInput = (checkNotNull(input) && checkValidNumberRange(input));
		} catch (InvalidInputException e) {
			outputView.printMessage(e.getMessage());
		}
		return stopReceivingInput;
	}

	private boolean checkValidNumberRange(String input) throws InvalidInputException {
		String validPattern = "[1-9][0-9]{0,1}";
		if (!Pattern.matches(validPattern, input)) {
			throw new InvalidInputException(Message.ERROR_OVER_NUMBER_RANGE);
		}

		if (Integer.parseInt(input) < 1) {
			throw new InvalidInputException(Message.ERROR_NON_POSITIVE_NUMBER_VALUE);
		}
		return true;
	}
}
