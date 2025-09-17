package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Player {

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

}
