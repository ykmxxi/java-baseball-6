package baseball.domain;

import java.util.Objects;

public class Ball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 2;

    private final int number;
    private final int position;

    public Ball(final int number, final int position) {
        validate(number, position);
        this.number = number;
        this.position = position;
    }

    private void validate(final int number, final int position) {
        validateNumberRange(number);
        validatePositionRange(position);
    }

    private void validateNumberRange(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositionRange(final int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isStrike(final Ball otherBall) {
        return this.equals(otherBall);
    }

    public boolean isBall(final Ball otherBall) {
        return this.number == otherBall.number && this.position != otherBall.position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball)o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

}
