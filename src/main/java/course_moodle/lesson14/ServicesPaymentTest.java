package course_moodle.lesson14;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicesPaymentTest extends BaseTest {

    @Test
    public void testServicesPayment() {
        // Выбираем «Услуги связи»
        WebElement serviceType = driver.findElement(By.xpath("//input[@value='services']"));
        serviceType.click();

        // Заполняем поле "Номер телефона"
        WebElement phoneInput = driver.findElement(By.id("phoneNumber"));
        phoneInput.sendKeys("297777777");

        // Заполняем поле "Сумма"
        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("10");

        // Нажимаем кнопку «Продолжить»
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        // Ожидаем появления окна с реквизитами
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentWindow")));

        // Проверяем корректность отображения суммы
        WebElement amountDisplay = paymentWindow.findElement(By.id("amountDisplay"));
        assertEquals("10", amountDisplay.getText(), "Неправильная сумма");

        // Проверяем корректность отображения номера телефона
        WebElement phoneDisplay = paymentWindow.findElement(By.id("phoneDisplay"));
        assertEquals("297777777", phoneDisplay.getText(), "Неправильный номер телефона");

        // Проверяем надписи в незаполненных полях для ввода реквизитов карты
        WebElement cardNumberLabel = paymentWindow.findElement(By.xpath(".//label[contains(text(), 'Номер карты')]"));
        WebElement expiryDateLabel = paymentWindow.findElement(By.xpath(".//label[contains(text(), 'Срок действия')]"));
        WebElement cvvLabel = paymentWindow.findElement(By.xpath(".//label[contains(text(), 'CVV')]"));

        assertEquals("Номер карты", cardNumberLabel.getText(), "Неправильная надпись для номера карты");
        assertEquals("Срок действия", expiryDateLabel.getText(), "Неправильная надпись для срока действия");
        assertEquals("CVV", cvvLabel.getText(), "Неправильная надпись для CVV");

        // Проверяем наличие иконок платёжных систем
        WebElement paymentIcons = paymentWindow.findElement(By.xpath(".//div[@class='payment-icons']"));
        assertTrue(paymentIcons.isDisplayed(), "Иконки платёжных систем не отображаются");
    }
}
