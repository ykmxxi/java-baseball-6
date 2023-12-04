package baseball.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {

    private static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(final String numbers) {
        validate(numbers);
        this.balls = convertToBalls(numbers);
    }

    private void validate(final String numbers) {
        if (getNumbersSizeWithoutDuplication(numbers) != BALLS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private int getNumbersSizeWithoutDuplication(final String numbers) {
        return Arrays.stream(numbers.split(""))
                     .collect(Collectors.toSet())
                     .size();
    }

    private List<Ball> convertToBalls(final String numbers) {
        String[] tokens = numbers.split("");
        return IntStream.range(0, tokens.length)
                        .mapToObj(position -> new Ball(Integer.parseInt(tokens[position]), position))
                        .toList();
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

}
