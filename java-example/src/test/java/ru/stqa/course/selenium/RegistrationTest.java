package ru.stqa.course.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Created by Maria.Guseva on 01.12.2016.
 */
public class RegistrationTest extends TestBase{

    @Test
    public void test(){
        int num = new Random(System.currentTimeMillis()).nextInt(100);
        String email = "newaccount" + num + "@mail.ru";

        driver.get("http://localhost/litecart");
        driver.findElement(By.cssSelector("#navigation table a")).click();

        driver.findElement(By.name("firstname")).sendKeys("firstname");
        driver.findElement(By.name("lastname")).sendKeys("lastname");
        driver.findElement(By.name("address1")).sendKeys("address1");
        driver.findElement(By.name("postcode")).sendKeys("123456");
        driver.findElement(By.name("city")).sendKeys("city");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+79219000000");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("confirmed_password")).sendKeys("password");
        driver.findElement(By.name("create_account")).click();

        driver.findElement(By.linkText("Logout")).click();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.linkText("Logout")).click();
    }

}
