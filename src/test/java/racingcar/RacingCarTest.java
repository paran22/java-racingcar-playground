package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    int location = 0;

    @Test
    void moveOneStepWhenRandomNumIsOverFour() {
        int randomNum = 5;
        Assertions.assertThat(RacingCar.move(randomNum, location)).isEqualTo(1);
    }

    @Test
    void stayWhenRandomNumIsUnderThree() {
        int randomNum = 3;
        Assertions.assertThat(RacingCar.move(randomNum, location)).isEqualTo(0);
    }
}