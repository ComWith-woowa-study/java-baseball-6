package baseball.view;

public class OutputView {

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다!");
    }

    public void printGuess() {
        System.out.println("숫자를 입력해주세요: ");
    }

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printScore(int ball, int strike) {
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }

    public void printResult(int size, int go, int stop) {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", size);
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", go, stop);
    }
}
