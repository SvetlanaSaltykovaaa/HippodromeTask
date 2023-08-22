import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class HippodromeTest {


    List<Horse> horses;
    Hippodrome hippodrome;

    @Test
    public void isListNull() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null), "Horses cannot be null.");
        assertEquals("Horses cannot be null.", thrown.getMessage());
    }

    @Test

    public void isListEmpty() {
        horses = new ArrayList<>();
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(horses), "Horses cannot be empty.");
        assertEquals("Horses cannot be empty.", thrown.getMessage());
    }

    @Test
    public void getHorses(){

    }

    @Test
    public void move(){

    }
    @Test
    public void getWinner(){

    }

}