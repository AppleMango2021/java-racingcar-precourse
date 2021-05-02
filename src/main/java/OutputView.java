public class OutputView {

	public OutputView() {
	}

	public void printMessage(Message message) {
		System.out.println(message.showText());
	}

	public void printMessage(String string) {
		System.out.println(string);
	}
}
