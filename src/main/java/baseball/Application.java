package baseball;

import baseball.computer.Computer;
import baseball.generator.BasicGenerator;
import baseball.mediator.DefaultGameMediator;
import baseball.player.Player;

public class Application {

    public static void main(String[] args) {

        Player player = new Player();
        Computer computer = new Computer(new BasicGenerator());
        DefaultGameMediator mediator = new DefaultGameMediator(computer, player);

        mediator.start();
    }
}

