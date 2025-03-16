package course_moodle.lesson15;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    @FindBy(css = ".product-card__name")
    private List<WebElement> productNames;

    @FindBy(css = ".product-card__btn-add")
    private List<WebElement> addToCartButtons;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://wildberries.ru");
    }

    public void addProductsToCart(int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            addToCartButtons.get(i).click();
        }
    }

    public List<String> getProductNames(int numberOfProducts) {
        return productNames.subList(0, numberOfProducts).stream()
                .map(WebElement::getText)
                .toList();
    }

    public void goToCart() {
        driver.get("https://www.wildberries.ru/lk/basket");
    }
}