package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.InputView.input;
import static racingcar.ResultView.printWinner;


public class Main {

    public static void main(String[] args) {
        InputView.Response response = input();
        String[] carNames = response.getCarNames();
        int round = response.getRound();

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        Cars cars = new Cars(carList);
        
        cars.race(round);

        //1. 현재위치가 가장높은녀석들
        //2. 위치가 같다면 이름은 사전순
        printWinner(cars.findWinner());

    }

}
