package course_moodle.lesson13;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentLogosTest extends BaseTest {

    @Test
    public void testPaymentLogos() {
        // Находим все логотипы платёжных систем
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='payment-logos']/img"));

        // Проверяем, что логотипы отображаются
        assertTrue(logos.size() > 0, "Логотипы платёжных систем не найдены");
    }
}

