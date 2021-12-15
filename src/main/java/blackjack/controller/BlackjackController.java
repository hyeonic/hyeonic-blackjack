package blackjack.controller;

import blackjack.domain.player.Gamer;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {

    public void run() {
        OutputView.guide();
        Gamer gamer = new Gamer(InputView.name());
    }
}