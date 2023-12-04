package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("3개의 게임 숫자 예외 처리: 중복된 숫자가 존재하면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"112", "121", "122"})
    void 게임_숫자_3개_중복_예외_처리(String numbers) {
        // when & then
        assertThatThrownBy(() -> new Balls(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3개의 게임 숫자 예외 처리 통과")
    @ParameterizedTest
    @ValueSource(strings = {"129", "931", "456"})
    void 게임_숫자_3개_예외_처리_통과(String numbers) {
        // when & then
        assertThatCode(() -> new Balls(numbers))
                .doesNotThrowAnyException();
    }

}
