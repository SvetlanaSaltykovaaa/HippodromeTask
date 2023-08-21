import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    public Horse horse;

    @BeforeEach
    public void init() {
        horse = new Horse("Jane", 10.6, 200.0);
    }

    @Test
    public void getNameTest() {
        String expectedHorseName = "Jane";
        String horseName = horse.getName();
        assertEquals(expectedHorseName, horseName);
    }

    @Test
    public void getSpeedTest() {
        Double expectedSpeed = 10.6;
        Double horseSpeed = horse.getSpeed();
        assertEquals(expectedSpeed, horseSpeed);
    }

    @Test
        public void getDistanceSecParam() {
        Horse secHorse = new Horse("Jane", 10.6);
        Double expectedDistance = 0.0;
        Double horseDistance = secHorse.getDistance();
        assertEquals(expectedDistance, horseDistance);
    }

    @Test
    public void getDistanceThirdParam() {
        Double expectedDistance = 200.0;
        Double horseDistance = horse.getDistance();
        assertEquals(expectedDistance, horseDistance);
    }


}