import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
                () -> new Hippodrome(new ArrayList<>()));
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
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippo = new Hippodrome(horses);

        hippo.move();

        for (Horse oneHorse : horses) {
            Mockito.verify(oneHorse).move();
        }
    }

    @Test
    public void getWinner() {
        List<Horse> horses = new ArrayList<>();
        Horse horse1 = new Horse("name1", 5, 10);
        Horse horse2 = new Horse("name2", 5, 11);
        Horse horse3 = new Horse("name3", 5, 8);
        Collections.addAll(horses, horse1, horse2, horse3);
        Hippodrome hippo = new Hippodrome(horses);

        assertSame(horse2, hippo.getWinner());
    }
}