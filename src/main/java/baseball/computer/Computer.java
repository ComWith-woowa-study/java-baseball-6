package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Machine {

    public static final int SIZE = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;

    // 선택한 임의의 수 3개
    private final List<Integer> computer = new ArrayList<>();

    @Override
    public List<Integer> generate() {
        computer.clear();
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    @Override
    public Score judge(List<Integer> guess) {

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < SIZE; i++) {
            int g = guess.get(i);
            if (g == computer.get(i)) {
                strike++;

            } else if (computer.contains(g)) {
                ball++;
            }
        }

        return new Score(strike, ball);

    }
}