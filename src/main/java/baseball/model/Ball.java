package baseball.model;

import java.util.List;

public class Ball {

    public static final int BALL_SIZE = 3;
    public static final int MIN = 1, MAX = 9;
    private final List<Integer> ball;

    public Ball(List<Integer> numbers) {
        if (numbers == null || numbers.size() != BALL_SIZE) {
            throw new IllegalArgumentException("공의 개수는 " + BALL_SIZE + "개여야 합니다.");
        }
        if (!numbers.stream().allMatch(n -> n >= MIN && n <= MAX)){
            throw new IllegalArgumentException("모든 숫자는 " + MIN + "~" + MAX + " 사이여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
        this.ball = List.copyOf(numbers);
    }

    public List<Integer> getBall() {
        return ball;
    }
}
