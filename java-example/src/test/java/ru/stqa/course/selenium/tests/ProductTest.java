package ru.stqa.course.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by Maria.Guseva on 30.11.2016.
 */
public class ProductTest extends TestBase{
    //В тестах проверяется только структурная правильность страницы. Соответственно, не нужно проверять:
    //"стили цены на главной странице и на странице товара -- первая цена серая, зачёркнутая, маленькая, вторая цена красная жирная, крупная"

    @Test
    public void test(){
        driver.get("http://localhost/litecart");

        WebElement product = driver.findElement(By.cssSelector("#box-campaigns li"));
        String regular_price = product.findElement(By.cssSelector(".regular-price")).getText();
        String campaign_price = product.findElement(By.cssSelector(".campaign-price")).getText();
        String name = product.findElement(By.cssSelector(".name")).getText();

        product.click();
        String r_price_in = driver.findElement(By.cssSelector(".regular-price")).getText();
        String c_price_in = driver.findElement(By.cssSelector(".campaign-price")).getText();
        String name_in = driver.findElement(By.cssSelector("h1.title")).getText();

        Assert.assertEquals(regular_price, r_price_in);
        Assert.assertEquals(campaign_price, c_price_in);
        Assert.assertEquals(name, name_in);
    }
}
