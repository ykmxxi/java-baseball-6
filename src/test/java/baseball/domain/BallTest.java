package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @DisplayName("1개의 게임 숫자는 수와 위치값이 같으면 같은 숫자이다")
    @Test
    void 게임_숫자_1개_생성() {
        // given
        Ball ball = new Ball(1, 0);

        // when & then
        assertThat(ball).isEqualTo(new Ball(1, 0));
    }

    @DisplayName("1개의 게임 숫자 예외 처리: 수가 1 ~ 9 사이의 값이 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 게임_숫자_수_범위_예외_처리(int number) {
        // when & then
        assertThatThrownBy(() -> new Ball(number, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
