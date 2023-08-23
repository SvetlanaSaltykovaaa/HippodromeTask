import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
@Disabled
class MainTest {
    @Test
    @Timeout(value =22)
    public void mainExecutionTime() throws Exception {
        Main.main( new String[] {});
    }


}