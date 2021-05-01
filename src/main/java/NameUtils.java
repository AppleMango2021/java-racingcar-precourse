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

	public static void checkLengthOfName(String carName) {
		if (carName.trim().length() > 5) {
			throw new InvalidNameLengthException();
		}
	}
}
