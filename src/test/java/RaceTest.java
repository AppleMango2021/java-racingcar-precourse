import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

	@Test
	@DisplayName("레이스 시작 시, 라운드가 감소하는 지 점검")
	 void test(){
		//Given
		Cars cars = new Cars(Arrays.asList("BMW", "Audi", "Ford"));
		Race race = new Race(3, cars);

		//When
		race.start();

		//Then
		assertThat(race.getRound().remainingRound()).isEqualTo(0);
	 }

}
