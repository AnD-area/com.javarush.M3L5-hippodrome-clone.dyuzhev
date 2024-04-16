import org.junit.jupiter.api.Test;

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
        assertEquals(actual, "name");
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("name", 5.0, 100.0);
        double actual = horse.getSpeed();
        assertEquals(actual, 5.0);
    }

    @Test
    void getDistance() {
        Horse horse = new Horse("name", 5.0, 100.0);
        double actual = horse.getDistance();
        assertEquals(actual, 100.0);
    }

    @Test
    void move() {

    }
}