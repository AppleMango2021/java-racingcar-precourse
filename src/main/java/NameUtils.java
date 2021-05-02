import java.util.ArrayList;
import java.util.List;

public class NameUtils {

	public static List<String> separateByComma(String inputString) {
		String[] splitNames = inputString.split(",");
		List<String> names = new ArrayList<>();
		for (String name : splitNames) {
			names.add(name.trim());
		}
		return names;
	}

	// public static boolean isValidLength(String carName) throws InvalidInputException {
	// 	if (carName.trim().length() > Car.UPPER_BOUND_NAME_LENGTH) {
	// 		throw new InvalidInputException(Message.ERROR_INVALID_NAME_LENGTH);
	// 	}
	// 	return true;
	// }
}
