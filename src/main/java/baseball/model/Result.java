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

    public int getStrike() {return strike;}
    public int getBall() {return ball;}
    public int getNothing() {return nothing;}
}
