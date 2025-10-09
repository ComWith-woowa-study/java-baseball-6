package baseball.view;

import baseball.model.Ball;
import baseball.model.Result;

public class OutputView {

    public void printResult(Result result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (result.getBall() > 0) {
            System.out.print(result.getBall() + "볼 ");
        }
        if (result.getStrike() > 0) {
            System.out.print(result.getStrike() + "스트라이크");
        }
        System.out.println();
    }

    public void printWin() {
        System.out.println(Ball.BALL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
