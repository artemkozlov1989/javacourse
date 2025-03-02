package course_moodle.lesson13;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoreDetailsLinkTest extends BaseTest {

    @Test
    public void testMoreDetailsLink() {
        // Находим ссылку «Подробнее о сервисе»
        WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));

        // Кликаем по ссылке
        link.click();

        // Проверяем, что страница загрузилась (например, по заголовку)
        WebElement pageTitle = driver.findElement(By.tagName("h1"));
        assertTrue(pageTitle.isDisplayed(), "Страница не загрузилась");
    }
}

