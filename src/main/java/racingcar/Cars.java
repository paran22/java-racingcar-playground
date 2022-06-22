package racingcar;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.ResultView.printResult;

public class Cars {
    private static final Random RANDOM = new Random();

    private List<Car> cars;

    public Cars(Car... cars) {
        this.cars = new ArrayList<>();
        Collections.addAll(this.cars, cars);
    }

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public void race(int round) {
        for (int i = 0; i < round; i++) {
            cars = cars.stream()
                    .map(car -> car.move(() -> RANDOM.nextInt(10)))
                    .collect(Collectors.toList());
            printResult(cars);
        }
    }

    public String findWinner() {
        int maxLocation = cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .orElseThrow(NoSuchElementException::new)
                .getLocation();

        TreeSet<Car> winners = cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Car::name))));

        return winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return Arrays.toString(cars.toArray());
    }


}
