public class InvalidInputException extends RuntimeException {

	InvalidInputException() {
		super();
	}

	InvalidInputException(Message message) {
		super(message.showText());
	}
}