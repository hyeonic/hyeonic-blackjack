package blackjack.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "\n플레이어의 이름을 입력하세요.";

    private InputView() {
    }

    public static String name() {
        System.out.println(INPUT_NAME_MESSAGE);
        return Console.readLine();
    }
}