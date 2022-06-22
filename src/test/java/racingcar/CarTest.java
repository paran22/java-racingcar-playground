package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    Car sut; // system under test

    @BeforeEach
    void setUp() {
        sut = new Car("car", 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", "abc123", "junnyland"})
    void nameMustBeLessThanFiveLength(String carName) {
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nameMustBeNotNullOrNotEmpty(String carName) {
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "abc", "junn"})
    void shouldReturnInstanceOfCar(String carName) {
        assertThat(new Car(carName)).isInstanceOf(Car.class);
    }

    @Test
    void straight() {
        Car car = sut.move(() -> 5);
        Assertions.assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = sut.move(() -> 3);
        Assertions.assertThat(car.getLocation()).isEqualTo(0);
    }
}