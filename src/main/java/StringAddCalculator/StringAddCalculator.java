package StringAddCalculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern DEFAULT_DELIMITER = Pattern.compile("[,:]");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\n(.*)$");

    public static int splitAndSum(String input) {
        if(input == null || input.trim().isEmpty()) {
            return 0;
        }

        if(!input.startsWith("//")) {
            return sum(input, DEFAULT_DELIMITER.pattern());
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String expression = matcher.group(2);

            return sum(expression, delimiter);
        }

        return 0;
    }

    private static int sum(String expression, String delimiter) {
        return Arrays.stream(expression.split(delimiter))
                .reduce(0, filteredDigit(), Integer::sum);

    }

    private static BiFunction<Integer, String, Integer> filteredDigit(){
        return (accumulated, nextValue) -> {
            if (!nextValue.matches("\\d") || Integer.parseInt(nextValue) < 0) {
                throw new IllegalArgumentException("You must input String only with positive number");
            }
            return accumulated + Integer.parseInt(nextValue);
        };
    }
}
