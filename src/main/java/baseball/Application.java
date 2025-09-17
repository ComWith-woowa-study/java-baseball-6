package baseball;

import baseball.model.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Computer computer = new Computer();
        Player player = new Player();
        Umpire umpire = new Umpire();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            computer.setComputer();
            Ball computerBall = new Ball(computer.getComputer());
            while (true) {
                List<Integer> user = player.inputNumbers();
                Ball playerBall = new Ball(user);

                Result gameResult = umpire.gameStart(playerBall, computerBall);

                if (gameResult.getStrike() == Ball.BALL_SIZE) {
                    System.out.println(gameResult);
                    System.out.println(Ball.BALL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String userResponse = Console.readLine();
                    if (userResponse.equals("1")) break;
                    if (userResponse.equals("2")) return;
                    throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
                } else System.out.println(gameResult);
            }
        }
    }
}
