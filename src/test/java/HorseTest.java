import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    @Test
    public void HorseConstructorNullException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10.0, 100.0));
    }

    @Test
    public void HorseConstructorNullMessageExpression() {
        String exceptionString = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10.0, 100.0)).getMessage();
        assertEquals(exceptionString, "Name cannot be null.");
    }

    @Test
    public void HorseConstructorSpaceSymbolsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse("\s", 10.0, 100.0));
    }

    @Test
    public void HorseConstructorSpaceSymbolsMessage() {
        String exceptionString = assertThrows(IllegalArgumentException.class,
                () -> new Horse("\s", 10.0, 100.0)).getMessage();
        assertEquals(exceptionString, "Name cannot be blank.");
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