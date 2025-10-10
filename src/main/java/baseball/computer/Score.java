package baseball.computer;

import static baseball.computer.Computer.SIZE;

public record Score(int strike, int ball) {

    public boolean isWin() {
        return strike == SIZE;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}

