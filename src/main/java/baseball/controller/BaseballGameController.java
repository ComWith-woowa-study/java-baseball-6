package baseball.controller;

import baseball.generate.NumberGenerator;
import baseball.generate.RandomNumberGenerator;
import baseball.model.Ball;
import baseball.model.Computer;
import baseball.model.Result;
import baseball.model.Umpire;
import baseball.view.InputView;
import baseball.view.OutputView;


import java.util.List;

public class BaseballGameController {

    private InputView inputView;
    private OutputView outputView;
    private Computer computer;
    private Umpire umpire;

    public BaseballGameController(InputView inputView, OutputView outputView , Computer computer, Umpire umpire) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
        this.umpire = umpire;
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            Ball computeBall = computer.generateNumbers();
            roundGame(computeBall);
            if (!askRestart()){
                break;
            }
        }
    }

    private void roundGame(Ball computeBall) {
        while (true) {
            Ball userBall = inputUserBall();
            Result roundResult = umpire.referee(userBall, computeBall);
            outputView.printResult(roundResult);
            if (roundResult.getStrike() == Ball.BALL_SIZE) {
                outputView.printWin();
                break;
            }
        }
    }

    private boolean askRestart() {
        int num = inputView.inputRestartNumbers();
        return num == 1;
    }

    private Ball inputUserBall() {
        List<Integer> inputNums = inputView.inputNumbers();
        return new Ball(inputNums);
    }
}
