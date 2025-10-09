package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<Integer> inputNumbers() {
        System.out.print("숫자를 입해주세요 : ");
        String userBall = Console.readLine();
        if (userBall == null || userBall.isEmpty()) {
            throw new IllegalArgumentException("공이 없습니다.");
        }
        return Arrays.stream(userBall.split(""))
                .map(Integer::parseInt)
                .toList();
    }
    public int inputRestartNumbers() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userBall = Console.readLine();
        if (userBall == null || userBall.isEmpty()) {
            throw new IllegalArgumentException("1 또는 2를 입력해 합니다.");
        }
        return Integer.parseInt(userBall);
    }
}
