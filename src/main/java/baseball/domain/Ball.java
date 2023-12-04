package baseball.domain;

import java.util.Objects;

public class Ball {

    private final int number;
    private final int position;

    public Ball(final int number, final int position) {
        this.number = number;
        this.position = position;
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
