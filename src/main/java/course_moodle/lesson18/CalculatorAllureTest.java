package course_moodle.lesson18;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Epic("Тестирование мобильного приложения Калькулятор")
@Feature("Проверка арифметических операций")
public class CalculatorAllureTest {

    private AppiumDriver driver;

    @BeforeClass
    @Step("Инициализация драйвера и запуск приложения")
    @Description("Настройка capabilities и подключение к Appium серверу")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung A7 2018");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        attachScreenshot("Запуск приложения");
    }

    @Test
    @Story("Проверка операции сложения")
    @Description("Тестирование корректности работы операции 5 + 3")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddition() {
        performOperation(5, "+", 3, "8", "Сложение");
    }

    @Test
    @Story("Проверка операции вычитания")
    @Description("Тестирование корректности работы операции 9 - 4")
    @Severity(SeverityLevel.CRITICAL)
    public void testSubtraction() {
        performOperation(9, "-", 4, "5", "Вычитание");
    }

    @Test
    @Story("Проверка операции умножения")
    @Description("Тестирование корректности работы операции 6 × 2")
    @Severity(SeverityLevel.CRITICAL)
    public void testMultiplication() {
        performOperation(6, "×", 2, "12", "Умножение");
    }

    @Test
    @Story("Проверка операции деления")
    @Description("Тестирование корректности работы операции 8 ÷ 2")
    @Severity(SeverityLevel.CRITICAL)
    public void testDivision() {
        performOperation(8, "÷", 2, "4", "Деление");
    }

    @Step("Выполнение операции {operationName}: {num1} {op} {num2} = {expectedResult}")
    private void performOperation(int num1, String op, int num2, String expectedResult, String operationName) {
        clickDigit(num1);
        clickOperation(op);
        clickDigit(num2);
        clickEquals();

        String actualResult = getResult();
        attachScreenshot("Результат операции " + operationName);

        Assert.assertEquals(actualResult, expectedResult,
                String.format("Ошибка в операции %s: %s %s %s должно быть %s, но получилось %s",
                        operationName, num1, op, num2, expectedResult, actualResult));
    }

    private void clickDigit(int number) {
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + number)).click();
    }

    private void clickOperation(String op) {
        String opId = "";
        switch (op) {
            case "+": opId = "op_add"; break;
            case "-": opId = "op_sub"; break;
            case "×": opId = "op_mul"; break;
            case "÷": opId = "op_div"; break;
        }
        driver.findElement(By.id("com.google.android.calculator:id/" + opId)).click();
    }

    private void clickEquals() {
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
    }

    private String getResult() {
        return driver.findElement(By.id("com.google.android.calculator:id/result")).getText();
    }

    @Attachment(value = "{name}", type = "image/png")
    private byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterClass
    @Step("Завершение теста")
    @Description("Закрытие драйвера и освобождение ресурсов")
    public void tearDown() {
        if (driver != null) {
            attachScreenshot("Финальное состояние");
            driver.quit();
        }
    }
}
