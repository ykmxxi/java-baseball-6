package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @DisplayName("1개의 게임 숫자는 수와 위치값이 같으면 같은 숫자이다")
    @Test
    void 게임_숫자_1개_생성() {
        // given
        Ball ball = new Ball(1, 0);

        // when & then
        assertThat(ball).isEqualTo(new Ball(1, 0));
    }

}
