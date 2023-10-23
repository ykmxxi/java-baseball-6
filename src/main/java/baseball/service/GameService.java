package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.domain.balls.Balls;

public class GameService {

	private static final String END_CONDITION = "3스트라이크";

	public Computer createComputer() {
		return new Computer();
	}

	public String requestJudgment(final Computer computer, final Player player) {
		Referee referee = new Referee();
		Balls computerBalls = computer.getBalls();
		Balls playerBalls = player.getBalls();

		GameResult gameResult = referee.judge(computerBalls, playerBalls);
		return referee.notifyGameResult(gameResult);
	}

	public boolean isEnded(final String gameResultMessage) {
		return gameResultMessage.equals(END_CONDITION);
	}

	public boolean isReplay(final String replayCommandInput) {
		GameCommand.validate(replayCommandInput);
		return replayCommandInput.equals(GameCommand.REPLAY.getCommandValue());
	}

}
