package baseball.computer;

import java.util.List;

public interface Machine {

    // 임의의 수 3개 생성하는 책임
    List<Integer> generate();

    // 추측값을 바탕으로 결과를 판단하는 책임
    Score judge(List<Integer> guess);
}
