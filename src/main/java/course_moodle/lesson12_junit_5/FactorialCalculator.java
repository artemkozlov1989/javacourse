package course_moodle.lesson12_junit_5;

public class FactorialCalculator {
    /**
     * Вычисляет факториал числа.
     *
     * @param n Число, для которого вычисляется факториал.
     * @return Факториал числа.
     * @throws IllegalArgumentException Если число отрицательное.
     */
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

