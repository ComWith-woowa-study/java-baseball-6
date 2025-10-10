package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.GameConfig.*;

public class BasicGenerator implements Generator {

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
