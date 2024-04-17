import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    @Test
    public void HorseConstructorNullException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10, 100));
        assertEquals("Name cannot be null.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "", "\n", "\t", "\f", "\r"})
    public void HorseConstructorSpaceSymbolsException(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, 10, 100));
        assertEquals("Name cannot be blank.", e.getMessage());
    }

    @Test
    public void HorseConstructorSpeedNotNegative() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", -5, 100));
        assertEquals("Speed cannot be negative.", e.getMessage());
    }

    @Test
    public void HorseConstructorDistanceNotNegative() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", 5, -100));
        assertEquals("Distance cannot be negative.", e.getMessage());
    }

    @Test
    public void getName() {
        Horse horse = new Horse("name", 5, 100);

        assertEquals("name", horse.getName());
    }

    @Test
    public void getSpeed() {
        Horse horse = new Horse("name", 5, 100);

        assertEquals(5.0, horse.getSpeed());
    }

    @Test
    public void getDistance() {
        Horse horse = new Horse("name", 5, 100);

        assertEquals(100, horse.getDistance());
    }

    @Test
    public void zeroDistance() {
        Horse horse = new Horse("name", 5);

        assertEquals(0, horse.getDistance());
    }

    @Test
    public void move() {
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            new Horse("name", 5, 100).move();
            mockedHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

//    @ParameterizedTest
//    @ValueSource(doubles = {0.3, 0.5, 0.7, 0.8})
//    void moveGetRandomDoubleMock(double arg) {
//        try (MockedStatic<Horse> horseMock = Mockito.mockStatic(Horse.class)) {
//            horseMock.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(arg);
//            Horse horse = new Horse("name", 3);
//            horse.move();
//            assertEquals(horse.getSpeed()*arg, horse.getDistance());
//        }
//    }
}