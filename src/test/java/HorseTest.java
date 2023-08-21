import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class HorseTest {

     Horse horse;

    @BeforeEach
    public void init() {
        horse = new Horse("Jane", 10, 200);
    }

    @Test
    public void isNullNameException() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10),
                "Name cannot be null.");
        assertEquals("Name cannot be null.", thrown.getMessage());
    }

    @Test
    public void isSpeedIsNegative() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Horse("Jane", -10, 12),
                "Speed cannot be negative.");
        assertEquals("Speed cannot be negative.", thrown.getMessage());
    }

    @Test
    public void isDistanceIsNegative() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () ->new Horse("Jane", 10, -12),
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


}


