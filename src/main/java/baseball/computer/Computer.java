package baseball.computer;

import baseball.generator.Generator;

import java.util.ArrayList;
import java.util.List;

import static baseball.generator.BasicGenerator.SIZE;

public class Computer {

    private final Generator generator;
    private List<Integer> computer = new ArrayList<>();

    public Computer(Generator generator) {
        this.generator = generator;
    }

    public List<Integer> generate() {
        this.computer = new ArrayList<>(generator.generate());
        return List.copyOf(computer);
    }

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

        return new Score(strike, ball, SIZE);

    }
}