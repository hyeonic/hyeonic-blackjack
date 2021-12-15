package blackjack.domain;

import java.util.List;

import blackjack.domain.player.Player;

public class Rule {

    public Player getWinner(List<Player> players) {
        Player winnerPlayer = null;
        int maxWinnerScore = Integer.MIN_VALUE;

        for (Player player : players) {
            int totalScore = player.getCards().getTotalScore();
            if (totalScore > maxWinnerScore) {
                maxWinnerScore = totalScore;
                winnerPlayer = player;
            }
        }

        return winnerPlayer;
    }
}