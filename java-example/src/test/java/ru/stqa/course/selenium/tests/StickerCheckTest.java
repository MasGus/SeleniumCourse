package ru.stqa.course.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Maria.Guseva on 25.11.2016.
 */
public class StickerCheckTest extends TestBase{

    @Test
    public void test(){
        driver.get("http://localhost/litecart");

        List<WebElement> webElementList = driver.findElements(By.cssSelector("li.column.product"));
        for (WebElement webElement : webElementList) {
            Assert.assertTrue(webElement.findElements(By.cssSelector("div.sticker") ).size() == 1);
        }
    }
}
