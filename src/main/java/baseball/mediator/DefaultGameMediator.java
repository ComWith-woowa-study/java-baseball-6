package baseball.mediator;

import baseball.computer.Computer;
import baseball.computer.Score;
import baseball.player.Player;

import java.util.List;

import static baseball.generator.BasicGenerator.SIZE;
import static baseball.player.Player.GO;
import static baseball.player.Player.STOP;

public class DefaultGameMediator {

    private final Computer computer;
    private final Player player;

    public DefaultGameMediator(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void start() {
        computer.generate();
        System.out.println("숫자 야구 게임을 시작합니다!");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> guess = player.getInput();
            Score score = computer.judge(guess);

            if (score.isNothing()) {
                System.out.println("낫싱");
            } else {
                System.out.printf("%d볼 %d스트라이크%n", score.ball(), score.strike());
            }

            if (score.isWin()) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", SIZE);
                System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", GO, STOP);

                if (player.getRestartOrStop()) {
                    computer.generate();
                } else {
                    break;
                }
            }
        }
    }

}