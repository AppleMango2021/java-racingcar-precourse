package exception;

import view.Message;

public class InvalidInputException extends RuntimeException {

	InvalidInputException() {
		super();
	}

	public InvalidInputException(Message message) {
		super(message.showText());
	}
}