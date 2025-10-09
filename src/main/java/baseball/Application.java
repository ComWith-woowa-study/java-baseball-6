package baseball;

import baseball.controller.BaseballGameController;
import baseball.generate.RandomNumberGenerator;
import baseball.model.*;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Umpire umpire = new Umpire();
        Computer computer = new Computer(new RandomNumberGenerator(Ball.BALL_SIZE, Ball.MIN, Ball.MAX));

        BaseballGameController gameController = new BaseballGameController(inputView, outputView, computer, umpire);
        gameController.gameStart();
    }
}
