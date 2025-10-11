package baseball;

import baseball.model.Computer;
import baseball.generator.BasicGenerator;
import baseball.controller.DefaultGameMediator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Computer computer = new Computer(new BasicGenerator());
        DefaultGameMediator mediator = new DefaultGameMediator(computer, inputView, outputView);

        mediator.start();
    }
}

