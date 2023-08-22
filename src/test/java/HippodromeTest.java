import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HippodromeTest {


    List<Horse> horses = new ArrayList<>();
    Hippodrome hippodrome;
    @Mock
    Horse horse1;
    @Mock
    Horse horse2;
    @Mock
    Horse horse3;

    @Test
    public void isListNull() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null), "Horses cannot be null.");
        assertEquals("Horses cannot be null.", thrown.getMessage());
    }

    @Test

    public void isListEmpty() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(horses), "Horses cannot be empty.");
        assertEquals("Horses cannot be empty.", thrown.getMessage());
    }

    @Test
    public void getHorses() {
        for (int i = 0; i < 30; i++) {
            horses.add(mock(Horse.class));
        }
        hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    public void move() {
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (Horse horse : horses) {
            verify(horse).move();
        }
    }

    @Test
    public void getWinner() {
        when(horse1.getDistance()).thenReturn(100.0);
        when(horse2.getDistance()).thenReturn(150.0);
        when(horse3.getDistance()).thenReturn(300.0);

        hippodrome = new Hippodrome(List.of(horse1, horse2, horse3));

        assertEquals(horse3, hippodrome.getWinner());
    }

}

