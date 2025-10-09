package baseball.model;

import baseball.generate.NumberGenerator;
import baseball.generate.RandomNumberGenerator;
import java.util.List;

public class Computer {

    private NumberGenerator numberGenerator;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Ball generateNumbers() {
        List<Integer> randomNumber = numberGenerator.generate();
        return new Ball(randomNumber);
    }
}
