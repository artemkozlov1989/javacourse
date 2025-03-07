package course_moodle.lesson14;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentBlockTest extends BaseTest {

    @Test
    public void testEmptyFieldsLabels() {
        // Находим блок «Онлайн пополнение без комиссии»
        WebElement paymentBlock = driver.findElement(By.xpath("//div[@class='payment-block']"));

        // Проверяем надписи в незаполненных полях
        List<WebElement> inputLabels = paymentBlock.findElements(By.xpath(".//label"));
        assertEquals("Номер телефона", inputLabels.get(0).getText(), "Неправильная надпись для номера телефона");
        assertEquals("Сумма", inputLabels.get(1).getText(), "Неправильная надпись для суммы");
    }
}
