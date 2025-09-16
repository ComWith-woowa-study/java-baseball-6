package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int BALL_SIZE = 3;
    private final Scanner scanner = new Scanner(System.in);

    public List<Integer> inputNumbers() {
        System.out.println("숫자를 입해주세요 :");
        String userBall = scanner.nextLine();
        if (userBall == null || userBall.isEmpty()) {
            throw new IllegalArgumentException("공이 없습니다.");
        }
        if (userBall.length() != BALL_SIZE) {
            throw new IllegalArgumentException("공의 개수는 정확히 " + BALL_SIZE + "개여야 합니다.");
        }
        return Arrays.stream(userBall.split(""))
                .map(Integer::parseInt)
                .toList();
    }

}
