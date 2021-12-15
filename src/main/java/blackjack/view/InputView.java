package blackjack.view;

import blackjack.domain.player.Name;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GUIDE_MESSAGE = "블랙잭 게임을 시작합니다.";
    private static final String INPUT_NAME_MESSAGE = "\n플레이어의 이름을 입력하세요.";
    private static final String INPUT_IS_TURN_MESSAGE_FORMAT =
        "\n%s님의 차례입니다. 카드를 뽑으시려면 1, 넘어가시려면 0번을 입력해주세요.\n";
    private static final String PROGRESS = "1";
    private static final String SKIP = "0";

    private InputView() {
    }

    public static String name() {
        System.out.println(GUIDE_MESSAGE);
        System.out.println(INPUT_NAME_MESSAGE);
        return Console.readLine();
    }

    public static boolean isTurn(Name name) {
        System.out.printf(INPUT_IS_TURN_MESSAGE_FORMAT, name);
        String input = Console.readLine();

        if (!(input.equals(PROGRESS) || input.equals(SKIP))) {
            throw new IllegalArgumentException();
        }

        return input.equals(PROGRESS);
    }
}