package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BasicGenerator implements Generator {

    public static final int SIZE = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;

    @Override
    public List<Integer> generate() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }
}
