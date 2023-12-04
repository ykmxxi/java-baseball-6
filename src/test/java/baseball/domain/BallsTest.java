package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    @DisplayName("문자열을 3개의 게임 숫자로 생성한다")
    @Test
    void 게임_숫자_3개_생성() {
        // given
        Balls balls = new Balls("123");

        // when
        List<Ball> result = balls.getBalls();

        // then
        assertThat(result).contains(new Ball(1, 0), new Ball(2, 1), new Ball(3, 2));
    }

}
