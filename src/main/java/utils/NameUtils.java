package utils;

import java.util.ArrayList;
import java.util.List;

import domain.Car;
import view.Message;

public class NameUtils {

	public static List<String> separateByComma(String inputString) {
		String[] splitNames = inputString.split(",");
		List<String> names = new ArrayList<>();
		for (String name : splitNames) {
			names.add(name.trim());
		}
		return names;
	}

	public static String listCarToStringName(List<Car> cars) {
		StringBuilder sb = new StringBuilder();
		for(Car car : cars){
			sb.append(car.getName()).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(Message.NOTICE_WINNER.showText());
		return sb.toString();
	}
}
