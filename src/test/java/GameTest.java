import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void gameClassShouldExist() {
        try {
            Class.forName("Game");
        } catch (ClassNotFoundException e) {
            fail("should have a class called Game");
        }
    }

}