package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars sut; // system under test

    @BeforeEach
    void setUp() {
        sut = new Cars(
                new Car("car1"),
                new Car("car2"),
                new Car("car3"),
                new Car("car4"),
                new Car("car5")
        );
    }

    @Test
    void raceResultTest() {
        int round = 5;
        sut.race(round);
        Assertions.assertThat(sut.findWinner()).isNotEmpty();
    }
}