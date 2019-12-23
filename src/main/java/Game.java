import java.util.*;

public class Game {
    Map<Integer, Integer> cards;
    int playerOneScore = 0;
    int playerTwoScore = 0;
    int currentCard = 0;
    public int currentPlayer = 1;

    Game (int sizeOfDeck) {
         cards = shuffle(sizeOfDeck);
    }

    public String play() {
        currentCard += 1;

        if(currentCard > cards.size()) {
            if(playerOneScore == playerTwoScore) {
                return "Game Over: Tie, No One Wins!";
            }

            return (playerOneScore > playerTwoScore) ? "Game Over: Player One Wins!" : "Game Over: Player Two Wins!";
        }

        if(currentCard % 2 != 0) {
            currentPlayer = 2;
            return "Player One has "  + (playerOneScore += cards.get(currentCard)) + " points.";
        }

        currentPlayer = 1;
        return "Player Two has "  + (playerTwoScore += cards.get(currentCard)) + " points.";
    }

    public Map<Integer, Integer> shuffle(int sizeOfDeck) {
        Map<Integer, Integer> shuffledDeck = new HashMap<Integer, Integer>();
        Random random = new Random();

        for(int i = 1; i <= sizeOfDeck; i += 1) {
            shuffledDeck.put(i, random.nextInt(sizeOfDeck));
        }

        return shuffledDeck;
    }
}