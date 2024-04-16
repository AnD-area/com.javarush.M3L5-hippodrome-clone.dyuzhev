import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    @Test
    public void HorseConstructorNullException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10.0, 100.0));
        assertEquals("Name cannot be null.", e.getMessage());
    }

    @Test
    public void HorseConstructorSpaceSymbolsException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse("\s", 10.0, 100.0));
        assertEquals("Name cannot be blank.", e.getMessage());
    }

    @Test
    public void HorseConstructorSpeedNotNegative() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", -5.0, 100.0));
        assertEquals("Speed cannot be negative.", e.getMessage());
    }

    @Test
    public void HorseConstructorDistanceNotNegative() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", 5.0, -100.0));
        assertEquals("Distance cannot be negative.", e.getMessage());
    }

    @Test
    void getName() {
        Horse horse = new Horse("name", 5.0, 100.0);
        String actual = horse.getName();
        assertEquals("name", actual);
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("name", 5.0, 100.0);
        double actual = horse.getSpeed();
        assertEquals(5.0, actual);
    }

    @Test
    void getDistance() {
        Horse horse = new Horse("name", 5.0, 100.0);
        double actual = horse.getDistance();
        assertEquals(100.0, actual);
    }

    @Test
    void move() {
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            new Horse("name", 5.0, 100.0).move();
            mockedHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }
}