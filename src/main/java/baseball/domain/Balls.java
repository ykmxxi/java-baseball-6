package baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {

    private final List<Ball> balls;

    public Balls(final String numbers) {
        this.balls = convertToBalls(numbers);
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
