package racingcar;

import java.util.Scanner;

public class InputView {
    public static Response input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.next().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int round = scanner.nextInt();

        return new Response(carNames, round);

    }
    public static class Response {
        String[] carNames;
        int round;

        public Response(String[] carNames, int round) {
            this.carNames = carNames;
            this.round = round;
        }

        public String[] getCarNames() {
            return carNames;
        }

        public int getRound() {
            return round;
        }
    }
}
