package blackjack.view;

public class OutputView {

    public static final String GUIDE_MESSAGE = "블랙잭 게임을 시작합니다.";

    private OutputView() {
    }

    public static void guide() {
        System.out.println(GUIDE_MESSAGE);
    }
}