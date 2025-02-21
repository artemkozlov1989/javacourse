package course_moodle.lesson12_testng;
import course_moodle.lesson12_junit_5.FactorialCalculator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculateFactorial(-1);
    }
}
