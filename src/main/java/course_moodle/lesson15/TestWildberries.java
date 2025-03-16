package course_moodle.lesson15;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestWildberries extends BaseTest {
    @Test
    public void testAddProductsToCart() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        // Добавляем 3 товара в корзину
        int numberOfProducts = 3;
        mainPage.addProductsToCart(numberOfProducts);

        // Получаем названия добавленных товаров
        List<String> productNames = mainPage.getProductNames(numberOfProducts);

        // Переходим в корзину
        mainPage.goToCart();

        CartPage cartPage = new CartPage(getDriver());

        // Проверяем названия товаров в корзине
        List<String> productNamesInCart = cartPage.getProductNames();
        Assert.assertEquals(productNamesInCart, productNames, "Названия товаров не совпадают");

        // Проверяем количество каждого товара
        List<Integer> productQuantities = cartPage.getProductQuantities();
        for (int quantity : productQuantities) {
            Assert.assertEquals(quantity, 1, "Количество товаров не совпадает");
        }

        // Проверяем общую сумму
        List<Double> productPrices = cartPage.getProductPrices();
        double expectedTotalPrice = productPrices.stream().mapToDouble(Double::doubleValue).sum();
        double actualTotalPrice = cartPage.getTotalPrice();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Общая сумма не совпадает");
    }
}
