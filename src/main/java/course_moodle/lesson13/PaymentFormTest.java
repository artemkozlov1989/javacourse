package course_moodle.lesson13;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentFormTest extends BaseTest {

    @Test
    public void testPaymentForm() {
        // Выбираем «Услуги связи»
        WebElement serviceType = driver.findElement(By.xpath("//input[@value='services']"));
        serviceType.click();

        // Вводим номер телефона
        WebElement phoneInput = driver.findElement(By.id("phoneNumber"));
        phoneInput.sendKeys("297777777");

        // Нажимаем кнопку «Продолжить»
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        // Проверяем, что произошёл переход на следующую страницу (например, по наличию нового элемента)
        WebElement nextPageElement = driver.findElement(By.id("nextPageElement"));
        assertTrue(nextPageElement.isDisplayed(), "Переход на следующую страницу не выполнен");
    }
}

