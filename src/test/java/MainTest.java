import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Disabled
class MainTest {

    @Test
    @Timeout(value =22)
    public void mainExecutionTime()  {
        /* imitation method time execution */
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}