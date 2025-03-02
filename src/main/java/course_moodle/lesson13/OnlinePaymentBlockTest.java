package course_moodle.lesson13;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinePaymentBlockTest extends BaseTest {

    @Test
    public void testBlockTitle() {
        // Находим заголовок блока
        WebElement titleElement = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));

        // Проверяем текст заголовка
        assertEquals("Онлайн пополнение без комиссии", titleElement.getText());
    }
}