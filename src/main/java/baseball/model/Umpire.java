package baseball.model;

public class Umpire {

    public Result gameStart(Ball user, Ball computer) {

        int strike = 0;
        int ball = 0;

        for (int i=0; Ball.BALL_SIZE > i; i++) {
            if (user.getBallIndex(i).equals(computer.getBallIndex(i))){
                strike++;
            } else if (computer.getBall().contains(user.getBallIndex(i))) {
                ball++;
            }
        }
        int nothing = (strike == 0 && ball == 0) ? 1 : 0;
        return new Result(strike, ball, nothing);
    }
}
