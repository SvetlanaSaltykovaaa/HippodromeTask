import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HorseTest {
    Horse horse;

    @BeforeEach
    public void init() {
        horse = new Horse("Jane", 10, 200);
    }

    @Test
    public void isNullName() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10),
                "Name cannot be null.");
        assertEquals("Name cannot be null.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t\t", "\n\n\n\n"})
    public void isNameBlankSpace(String name) {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, 10, 20),
                "Name cannot be blank.");
        assertEquals("Name cannot be blank.", thrown.getMessage());
    }

    @Test
    public void isSpeedNegative() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Horse("Jane", -10, 12),
                "Speed cannot be negative.");
        assertEquals("Speed cannot be negative.", thrown.getMessage());
    }

    @Test
    public void isDistanceNegative() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Horse("Jane", 10, -12),
                "Distance cannot be negative.");
        assertEquals("Distance cannot be negative.", thrown.getMessage());
    }

    @Test
    public void getName() {
        assertEquals("Jane", horse.getName());
    }

    @Test
    public void getSpeed() {
        assertEquals(10, horse.getSpeed());
    }

    @Test
    public void getDistanceSecParam() {
        Horse secondHorse = new Horse("Jane", 10);
        assertEquals(0, secondHorse.getDistance());
    }

    @Test
    public void getDistanceThirdParam() {
        assertEquals(200, horse.getDistance());
    }

    @Test
/*
    Проверить, что метод вызывает внутри метод getRandomDouble с параметрами 0.2 и 0.9.
    Для этого нужно использовать MockedStatic и его метод verify;
*/
    public void moveInvokeRandom() {
        try (MockedStatic<Horse> horseMockedStatic = mockStatic(Horse.class)) {
            horse.move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    /* Проверить, что метод присваивает дистанции значение высчитанное по формуле:
    distance + speed * getRandomDouble(0.2, 0.9).
    Для этого нужно замокать getRandomDouble,
    чтобы он возвращал определенные значения, которые нужно задать параметризовав тест.
    */
    public void isDistanceGetValue() {
        try (MockedStatic<Horse> horseMockedStatic = mockStatic(Horse.class)) {
            double randomValue = 0.8;
            horseMockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(randomValue);

            double expectedDistance = (horse.getDistance() + horse.getSpeed() * (Horse.getRandomDouble(0.2, 0.9)));
            horse.move();
            assertEquals(expectedDistance, horse.getDistance());
        }
    }


}







