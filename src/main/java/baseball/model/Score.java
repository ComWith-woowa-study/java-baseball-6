package baseball.model;

public record Score(int strike, int ball, int size) {

    public boolean isWin() {
        return strike == size;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}

