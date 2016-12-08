package ru.stqa.course.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by Maria.Guseva on 25.11.2016.
 */
public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop() {
        driver.quit();
    }

    protected void login(String username, String password) {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        String logged = driver.findElement(By.id("notices")).getText();
        Assert.assertTrue(logged.contains("You are now logged in as admin"));
    }

    protected void logout() {
        driver.get("http://localhost/litecart/admin/logout.php");
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost/litecart/admin/login.php"));
    }

    protected ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows){
        return input -> {Set<String> handles = input.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }
}
