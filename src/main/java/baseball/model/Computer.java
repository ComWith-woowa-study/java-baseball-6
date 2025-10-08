package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public Ball generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Ball.BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Ball.MIN, Ball.MAX);
            if (!numbers.contains(randomNumber)) { numbers.add(randomNumber); }
        }
        return new Ball(numbers);
    }
}
