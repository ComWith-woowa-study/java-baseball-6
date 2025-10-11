package baseball.controller;

import baseball.model.Computer;
import baseball.model.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.model.GameConfig.*;

public class DefaultGameMediator {

    private final Computer computer;
    private final InputView input;
    private final OutputView output;

    public DefaultGameMediator(Computer computer, InputView input, OutputView output) {
        this.computer = computer;
        this.input = input;
        this.output = output;
    }

    public void start() {
        computer.generate();
        output.printStart();
        while (true) {
            output.printGuess();
            List<Integer> guess = input.getInput();
            Score score = computer.judge(guess);

            if (score.isNothing()) {
                output.printNothing();
            } else {
                output.printScore(score.ball(), score.strike());
            }

            if (score.isWin()) {
                output.printResult(SIZE, GO, STOP);
                if (input.getRestartOrStop()) {
                    computer.generate();
                } else {
                    break;
                }
            }
        }
    }
}