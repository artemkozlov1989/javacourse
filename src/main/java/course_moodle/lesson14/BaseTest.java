package course_moodle.lesson14;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Автоматическая настройка chromedriver
        WebDriverManager.chromedriver().setup();

        // Инициализируем WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}