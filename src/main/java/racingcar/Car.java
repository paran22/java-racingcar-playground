package racingcar;

import java.util.Random;
import java.util.function.Supplier;

public class Car {
    private final String name;
    private final int location;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int location) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
        }
        this.name = name;
        this.location = location;
    }

    public Car move(Supplier<Integer> condition) {
        if (condition.get() >= 4) {
            return new Car(name, this.location + 1);
        }
        return this;
    }

    public String name() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("Car (name = %s, location = %s)\n", name, location);
    }
}
