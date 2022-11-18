import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Olya", 1);
    Player player2 = new Player(2, "Anya", 2);
    Player player3 = new Player(3, "Kolya", 1);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void ifFirstWin() {
        int expected = 1;
        int actual = game.round("Anya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifSecondWin() {
        int expected = -1;
        int actual = game.round("Olya", "Anya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifEquals() {
        int expected = 0;
        int actual = game.round("Olya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFind() {
        Player expected = null;
        Player actual = game.findByName("Sveta");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifFirstNotRegistered() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Sveta", "Anya");
        });
    }

    @Test
    public void ifSecondNotRegistered() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Anya", "Sveta");
        });
    }
}
