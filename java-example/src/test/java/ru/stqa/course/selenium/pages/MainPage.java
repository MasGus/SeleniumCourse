package ru.stqa.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Maria.Guseva on 20.12.2016.
 */
public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart");
    }

    @FindBy(css = "#cart a.link")
    public WebElement checkout;

    @FindBy(css = "span.quantity")
    public WebElement itemsCount;

    public WebElement productWithName(String productName) {
        return wait.until(visibilityOfElementLocated(cssSelector(String.format("a.link[title='%s']", productName))));
    }

}
