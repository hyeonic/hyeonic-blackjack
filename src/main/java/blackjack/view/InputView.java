package blackjack.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String name() {
        return Console.readLine();
    }
}