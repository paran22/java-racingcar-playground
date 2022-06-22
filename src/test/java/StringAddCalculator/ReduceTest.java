package StringAddCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;

public class ReduceTest {


    @Test
    void reduceTest(){
        String input = "1,2,3,4";
        Integer reduce = Arrays.stream(input.split(","))
                .reduce(0, filteredDigit(), Integer::sum);

        Assertions.assertThat(reduce).isEqualTo(10);
    }

    //  BiFunction<T, U, R>
    //  <T> the type of the first argument to the function
    //  <U> the type of the second argument to the function
    //  <R> the type of the result of the function
   private BiFunction<Integer, String, Integer> filteredDigit(){
        return (accumulated, nextValue) -> {
            if (!nextValue.matches("\\d") || Integer.parseInt(nextValue) < 0) {
                throw new IllegalArgumentException("You must input String only with positive number");
            }
            return accumulated + Integer.parseInt(nextValue);
        };
    }

}
