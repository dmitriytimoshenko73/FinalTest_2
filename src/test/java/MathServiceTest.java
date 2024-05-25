import org.example.MathService;
import org.example.NotFoundAnswerException;
import org.example.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {
    private static MathService mathService;

    @BeforeAll
    static void init() {
        mathService = new MathService();
    }


    @ParameterizedTest(name = "[{index}] args: a={0}, b={1}, c={2}, expected res = {3}, {4}")
    @CsvSource(value = {
            "1, -5, 4, 4.0, 1.0",
            "1, -4, -5, 5.0, -1.0",
            "1, 0, 0, 0.0, 0.0",
            "1, -6, 9, 3.0, 3.0"
    })
    void equationValidTest(int a, int b, int c, Double x1, Double x2) throws  NotFoundAnswerException {

        Pair res = mathService.getAnswer(a, b, c);
        assertTrue(res.first.equals(x1) && res.second.equals(x2),
                String.format("ожидаемый результат: (%.2f, %.2f), фактический результат: %s", x1, x2, res.toString()));
    }


    @ParameterizedTest(name = "[{index}] args: a={0}, b={1}, c={2}")
    @CsvSource(value = {
            "3, -4, 2",
            "1, -5, 9",
            "4, 0, 8"})
    void equationValidExceptionTest(int a, int b, int c) {
        NotFoundAnswerException thrown = assertThrows(NotFoundAnswerException.class, () -> {
            mathService.getAnswer(a, b, c);
        });
        assertEquals("Корни не могут быть найдены", thrown.getMessage());
    }


    @ParameterizedTest(name = "[{index}] args: a={0}, b={1}, c={2}")
    @CsvSource(value = {
            "0, 0, 0",
            "0, 0, 1"
    })
    void equationInvalidTest(int a, int b, int c)  {
        assertThrows(ArithmeticException.class, () -> {
            mathService.getAnswer(a, b, c);
        });
    }

}
