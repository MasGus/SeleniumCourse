package ru.stqa.course.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by Maria.Guseva on 07.12.2016.
 */
public class ShoppingCartTest extends TestBase{

    private final String ADD_BTN_NAME = "add_cart_product";
    private final String DEL_BTN_NAME = "remove_cart_item";

    @Test
    public void test(){
        String selector = "";

        for (int i = 1; i < 4; i++) {
            driver.get("http://localhost/litecart");
            selector = "ul > li:nth-child(" + Integer.toString(i+1) + ")> a.link";
            driver.findElement(By.cssSelector(selector)).click();
            driver.findElement(By.name(ADD_BTN_NAME)).click();
            wait.until(ExpectedConditions.attributeToBe(By.cssSelector("span.quantity"), "textContent", Integer.toString(i)));
        }

        driver.findElement(By.cssSelector("#cart a.link")).click();

        for (int i = 1; i < 3; i++) {
            WebElement table = driver.findElement(By.cssSelector(".dataTable"));
            driver.findElement(By.name(DEL_BTN_NAME)).click();
            wait.until(stalenessOf(table));
        }

        driver.findElement(By.name(DEL_BTN_NAME)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("em"), "There are no items in your cart."));
    }

}
