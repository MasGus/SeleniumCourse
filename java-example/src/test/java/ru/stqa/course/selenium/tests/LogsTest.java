package ru.stqa.course.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Maria.Guseva on 19.12.2016.
 */
public class LogsTest extends TestBase{

    @Test
    public void test(){
        String link = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";
        login("admin", "admin");

        driver.get(link);

        int productNum = driver.findElements(By.cssSelector(".row td:nth-child(3)>a")).size();
        List<WebElement> products;
        ArrayList<LogEntry> logs = new ArrayList<>();

        for (int i = 1; i < productNum; i++){
            products = driver.findElements(By.cssSelector(".row td:nth-child(3)>a"));
            products.get(i).click();
            logs.addAll(driver.manage().logs().get("browser").getAll());
            driver.get(link);
        }

        assertTrue(logs.size() == 0);

        logout();
    }
}