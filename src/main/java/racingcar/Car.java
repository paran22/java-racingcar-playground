package racingcar;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
        }
        this.name = name;
        this.location = 0;
    }
}
