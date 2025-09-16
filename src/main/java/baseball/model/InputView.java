package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<Integer> inputNumbers() {
        System.out.println("숫자를 입해주세요 :");
        String userBall = scanner.nextLine();
        if (userBall == null || userBall.isEmpty()) {
            throw new IllegalArgumentException("공이 없습니다.");
        }
        return Arrays.stream(userBall.split(""))
                .map(Integer::parseInt)
                .toList();
    }

}
