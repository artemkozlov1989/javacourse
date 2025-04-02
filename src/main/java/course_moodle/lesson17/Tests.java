import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Tests {

    private AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung A7 2018");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testAddition() {
        clickDigit(5);
        clickOperation("+");
        clickDigit(3);
        clickEquals();
        String result = getResult();
        Assert.assertEquals(result, "8", "5 + 3 should be 8");
    }

    @Test
    public void testSubtraction() {
        clickDigit(9);
        clickOperation("-");
        clickDigit(4);
        clickEquals();
        String result = getResult();
        Assert.assertEquals(result, "5", "9 - 4 should be 5");
    }

    @Test
    public void testMultiplication() {
        clickDigit(6);
        clickOperation("×");
        clickDigit(2);
        clickEquals();
        String result = getResult();
        Assert.assertEquals(result, "12", "6 * 2 should be 12");
    }

    @Test
    public void testDivision() {
        clickDigit(8);
        clickOperation("÷");
        clickDigit(2);
        clickEquals();
        String result = getResult();
        Assert.assertEquals(result, "4", "8 / 2 should be 4");
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

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}