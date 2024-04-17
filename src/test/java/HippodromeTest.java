import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class HippodromeTest {

    @Test
    public void HippodromeConstructorNullException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", e.getMessage());
    }

    @Test
    public void HippodromeConstructorNotEmptyHorses() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(new ArrayList<Horse>()));
        assertEquals("Horses cannot be empty.", e.getMessage());
    }

    @Test
    public void getHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("name " + i, i, i));
            Hippodrome hippo = new Hippodrome(horses);
            assertEquals(horses, hippo.getHorses());
        }
    }

    @Test
    public void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippo = new Hippodrome(horses);

        hippo.move();

        for (Horse key : horses) {
            Mockito.verify(key).move();
        }
    }

    @Test
    public void getWinner() {
    }
}