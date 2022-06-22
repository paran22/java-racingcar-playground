package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void carNameLengthTest() {
        assertThatThrownBy(() ->
                new Car("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }
}