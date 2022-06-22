package racingcar;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> cars) {
        System.out.println("실행결과");
        for (Car car : cars) {
            StringBuilder result = new StringBuilder();
            result.append(car.getName());
            result.append(" : ");

            for (int i = 0; i < car.getLocation(); i++) {
                result.append("-");
            }
            System.out.println(result.toString());
        }
        System.out.println("");
    }

    public static void printWinner(String winner) {
        System.out.println(winner + "가 최종우승했습니다.");
    }
}
