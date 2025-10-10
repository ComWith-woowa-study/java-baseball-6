package baseball.player;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

import static baseball.computer.Computer.*;

public class Player {
    public static final int GO = 1;
    public static final int STOP = 2;
    private final List<Integer> input = new ArrayList<>();
    public List<Integer> getInput() {
        String line = Console.readLine();
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("입력이 비었습니다!");
        }

        if (line.length() != SIZE) {
            throw new IllegalArgumentException(String.format("정확히 %d자리를 입력해야 합니다!", SIZE));
        }

        input.clear();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            char c = line.charAt(i);

            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException( String.format("공백 없이 %d ~ %d 사이에 존재하는 숫자 중 %d자리를 입력해야 합니다!" , MIN, MAX, SIZE) );
            }

            int number = c - '0';
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException(String.format("%d ~ %d 범위의 숫자만 입력할 수 있습니다!", MIN, MAX));
            }

            if (!set.add(number)) {
                throw new IllegalArgumentException("숫자가 중복되었습니다!");
            }

            input.add(number);

        }

        return input;

    }

    public boolean getRestartOrStop() {
        String restartOrStop = Console.readLine();
        int number = Integer.parseInt(restartOrStop);
        if (restartOrStop.isEmpty()) {
            throw new IllegalArgumentException("게임 재개 여부를 입력해주세요!");
        }

        return switch(number) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalArgumentException(String.format("%d 또는 %d만 입력할 수 있습니다!", GO, STOP));
        };
    }
}
