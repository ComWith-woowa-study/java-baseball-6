package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        String input = Console.readLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비었습니다!");
        }

        return input.trim();
    }
}
