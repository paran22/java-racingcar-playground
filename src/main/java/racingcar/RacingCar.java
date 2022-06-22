package racingcar;

public class RacingCar {

    public static int move(int randomNum, int location) {
        if (randomNum >= 4) {
            location += 1;
        }
        return location;
    }
}
