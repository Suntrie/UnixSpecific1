import org.junit.Assert;
import org.junit.Test;

public class UnixSpecificTest {

    private final double MAX_CPU = 10.0;

    @Test
    public void maxCPU() throws Exception {
        UnixSpecific.printAllProcesses().forEach(it -> {
            String trimmed = it.trim();

            Assert.assertFalse(Double.parseDouble(trimmed.split("\\s+")[1]) <= MAX_CPU);

        });
    }

}