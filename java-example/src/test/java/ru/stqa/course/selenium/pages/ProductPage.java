package ru.stqa.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Maria.Guseva on 20.12.2016.
 */
public class ProductPage extends Page {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "add_cart_product")
    public WebElement addToCartButton;

    @FindBy(css = "span.quantity")
    public WebElement itemsCount;

    public void addToCart() {
        int i = Integer.parseInt(itemsCount.getText());
        addToCartButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(itemsCount, Integer.toString(i + 1)));
    }

}
