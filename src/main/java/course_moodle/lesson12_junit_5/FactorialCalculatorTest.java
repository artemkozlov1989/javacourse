package course_moodle.lesson12_junit_5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
    }
}
