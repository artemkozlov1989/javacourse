package course_moodle.lesson13;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Указываем путь к chromedriver (если он не в PATH)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anduser\\Downloads\\Telegram Desktop\\chrome-win64\\chrome-win64\\chrome.exe");

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
