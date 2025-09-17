package baseball.model;

public class Result {
    private final int strike;
    private final int ball;
    private final int nothing;

    public Result(int strike, int ball, int nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public int getStrike() {
        return strike;
    }
    public int getBall() {
        return ball;
    }
    public int getNothing() {
        return nothing;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 3 && ball == 0) {
            return "3스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
