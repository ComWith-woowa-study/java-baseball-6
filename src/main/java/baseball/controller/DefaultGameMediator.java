package baseball.controller;

import baseball.model.Computer;
import baseball.model.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            List<Integer> guess = getInput();
            Score score = computer.judge(guess);

            if (score.isNothing()) {
                output.printNothing();
            } else {
                output.printScore(score.ball(), score.strike());
            }

            if (score.isWin()) {
                output.printResult(SIZE, GO, STOP);
                if (getRestartOrStop()) {
                    computer.generate();
                } else {
                    break;
                }
            }
        }
    }

    public List<Integer> getInput() {
        String line = input.readLine();

        if (line.length() != SIZE) {
            throw new IllegalArgumentException(String.format("정확히 %d자리를 입력해야 합니다!", SIZE));
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            char c = line.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException( String.format("공백 없이 %d ~ %d 사이에 존재하는 숫자 중 %d자리를 입력해야 합니다!" , MIN, MAX, SIZE) );
            }

            int number = c - '0';
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException(String.format("%d ~ %d 범위의 숫자만 입력할 수 있습니다!", MIN, MAX));
            }

            if (!set.add(number)) {
                throw new IllegalArgumentException("숫자가 중복되었습니다!");
            }

            list.add(number);
        }
        return list;
    }

    public boolean getRestartOrStop() {
        String restartOrStop = input.readLine();
        int number = Integer.parseInt(restartOrStop);

        if (restartOrStop.isEmpty()) {
            throw new IllegalArgumentException("게임 재개 여부를 입력해주세요!");
        }

        return switch(number) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalArgumentException(String.format("%d 또는 %d만 입력할 수 있습니다!", GO, STOP));
        };
    }
}