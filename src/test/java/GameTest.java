import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game instance;

    @BeforeEach
    public void beforeEach() {
        instance = new Game(52);
    }

    @Test
    public void gameClassShouldExist() {
        try {
            Class.forName("Game");
        } catch (ClassNotFoundException e) {
            fail("should have a class called Game");
        }
    }

    @Nested
    @DisplayName("play()")
    class playTest{
        @Test
        public void handlesPlayerRotationForTwoPlayers() {
            String playerOne = instance.play();
            String playerTwo = instance.play();
            assertEquals(true, playerOne.contains("Player One"));
            assertEquals(true, playerTwo.contains("Player Two"));
            assertEquals(true, playerOne.contains("Player One"));
            assertEquals(true, playerTwo.contains("Player Two"));
        }

        @Test
        public void announcesTheEndGame() {
            instance = new Game(2);
            String playerOne = instance.play();
            String playerTwo = instance.play();
            String noMoreCards = instance.play();
            assertEquals(true, playerOne.contains("Player One"));
            assertEquals(true, playerTwo.contains("Player Two"));
            assertEquals(true, noMoreCards.contains("Wins!"));
        }
    }

    @Nested
    @DisplayName("shuffle()")
    class shuffleTest{
        @Test
        public void ensureThatDeckIsShuffled() {
            int sizeOfDeck = 100;
            int result = 0;
            Map<Integer, Integer> cards = instance.shuffle(sizeOfDeck);

            for(int i = 1; i < sizeOfDeck; i += 1) {
                int delta = Math.abs(cards.get(i) - cards.get(i + 1));
                result += delta;
            }

            assertNotEquals(sizeOfDeck - 1, result);
        }
    }
}