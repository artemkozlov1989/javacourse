package course_moodle.lesson15;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    @FindBy(css = ".basket-item__name")
    private List<WebElement> productNamesInCart;

    @FindBy(css = ".basket-item__price")
    private List<WebElement> productPricesInCart;

    @FindBy(css = ".basket-item__count")
    private List<WebElement> productQuantitiesInCart;

    @FindBy(css = ".basket-total__price")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getProductNames() {
        return productNamesInCart.stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> getProductPrices() {
        return productPricesInCart.stream()
                .map(element -> Double.parseDouble(element.getText().replace("₽", "").replace(" ", "")))
                .toList();
    }

    public List<Integer> getProductQuantities() {
        return productQuantitiesInCart.stream()
                .map(element -> Integer.parseInt(element.getText()))
                .toList();
    }

    public double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().replace("₽", "").replace(" ", ""));
    }
}
