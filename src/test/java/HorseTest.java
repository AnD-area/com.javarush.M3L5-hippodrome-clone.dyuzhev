import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    @Test
    public void HorseConstructorNullException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10.0, 100.0));
    }

    @Test
    public void HorseConstructorNullMessageExpression() {
        String message = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10.0, 100.0)).getMessage();
        assertEquals(message, "Name cannot be null.");
    }

    @Test
    public void HorseConstructorSpaceSymbolsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse("\s", 10.0, 100.0));
    }

    @Test
    public void HorseConstructorSpaceSymbolsMessage() {
        String message = assertThrows(IllegalArgumentException.class,
                () -> new Horse("\s", 10.0, 100.0)).getMessage();
        assertEquals(message, "Name cannot be blank.");
    }

    @Test
    public void HorseConstructorSpeedNotNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", -5.0, 100.0));
    }
    @Test
    public void HorseConstructorSpeedNotNegativeMessage() {
        String message = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", -5.0, 100.0)).getMessage();
        assertEquals(message, "Speed cannot be negative.");
    }
    @Test
    public void HorseConstructorDistanceNotNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", 5.0, -100.0));
    }
    @Test
    public void HorseConstructorDistanceNotNegativeMessage() {
        String message = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", 5.0, -100.0)).getMessage();
        assertEquals(message, "Distance cannot be negative.");
    }

    @Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }
}