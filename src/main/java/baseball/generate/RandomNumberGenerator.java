package baseball.generate;

import baseball.model.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private final int size, min, max;

    public RandomNumberGenerator(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            if (!numbers.contains(randomNumber)) { numbers.add(randomNumber); }
        }
        return numbers;
    }
}
