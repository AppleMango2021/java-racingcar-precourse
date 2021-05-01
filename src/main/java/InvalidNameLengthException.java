public class InvalidNameLengthException extends RuntimeException {

	InvalidNameLengthException() {
		super(Message.ERROR_INVALID_NAME_LENGTH.showText());
	}
}
