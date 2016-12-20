package ru.stqa.course.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.course.selenium.pages.*;

/**
 * Created by Maria.Guseva on 20.12.2016.
 */
public class Application {

    private WebDriver driver;
    private WebDriverWait wait;

    private CartPage cartPage;
    private MainPage mainPage;
    private ProductPage productPage;

    public Application() {
        driver = new ChromeDriver();
        cartPage = new CartPage(driver);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void addProductToCart(String productName) {
        mainPage.open();
        mainPage.productWithName(productName).click();
        productPage.addToCart();
    }

    public void openCart() {
        mainPage.open();
        mainPage.checkout.click();
    }

    public void removeProductFromCart() {
        cartPage.removeProductFromCart();
    }

    public int getCartItemsCount() {
        return cartPage.getCartItemsCount();
    }

    public String getCartPageNoItemsText() {
        return cartPage.getNoItemsText();
    }
}
