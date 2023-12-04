package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @DisplayName("1개의 게임 숫자는 수와 위치값이 같으면 같은 숫자이다")
    @Test
    void 게임_숫자_1개_동등성_비교() {
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

    @DisplayName("1개의 게임 숫자 예외 처리: 위치가 0 ~ 2 사이의 값이 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void 게임_숫자_위치_범위_예외_처리(int position) {
        // when & then
        assertThatThrownBy(() -> new Ball(1, position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개의 게임 숫자 예외 처리 통과")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "1:2", "9:0", "9:2"}, delimiter = ':')
    void 게임_숫자_예외_처리_통과(int number, int position) {
        // when & then
        assertThatCode(() -> new Ball(number, position))
                .doesNotThrowAnyException();
    }

    @DisplayName("1개의 게임 숫자 비교: 수와 위치값이 같으면 스트라이크")
    @Test
    void 게임_숫자_비교_스트라이크() {
        // given
        Ball ball = new Ball(1, 0);
        Ball otherBall = new Ball(1, 0);

        // when & then
        assertThat(ball.isStrike(otherBall)).isTrue();
    }

    @DisplayName("1개의 게임 숫자 비교: 같은 수가 다른 자리에 있으면 볼")
    @Test
    void 게임_숫자_비교_볼() {
        // given
        Ball ball = new Ball(1, 0);
        Ball otherBall = new Ball(1, 1);

        // when & then
        assertThat(ball.isBall(otherBall)).isTrue();
    }

}
