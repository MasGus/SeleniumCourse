package ru.stqa.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Maria.Guseva on 20.12.2016.
 */
public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.viewport>ul.items>li.item")
    public List<WebElement> cartItems;

    @FindBy(css = "em")
    public WebElement noItemsText;

    public void removeProductFromCart() {
        WebElement viewport = wait.until(visibilityOfElementLocated(By.cssSelector("div.viewport")));
        wait.until(elementToBeClickable(By.name("remove_cart_item"))).click();
        wait.until(stalenessOf(viewport));
    }

    public String getNoItemsText() {
        return wait.until(visibilityOfElementLocated(By.cssSelector("div#checkout-cart-wrapper em"))).getText();
    }

    public int getCartItemsCount() {
        wait.until(visibilityOfElementLocated(By.cssSelector("div.viewport")));
        return cartItems.size();
    }

}
