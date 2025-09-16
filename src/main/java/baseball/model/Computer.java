package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computer = new ArrayList<>();

    public void setComputer() {
        computer.clear();
        while (computer.size() < Ball.BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Ball.MIN, Ball.MAX);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }
    }
    public List<Integer> getComputer() {
        return List.copyOf(computer);
    }
}
