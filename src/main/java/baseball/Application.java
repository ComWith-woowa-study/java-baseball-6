package baseball;

import baseball.computer.Computer;
import baseball.mediator.DefaultGameMediator;
import baseball.player.Player;

public class Application {

    public static void main(String[] args) {

        Player player = new Player();
        Computer computer = new Computer();
        DefaultGameMediator mediator = new DefaultGameMediator(computer, player);

        mediator.start();
    }
}

