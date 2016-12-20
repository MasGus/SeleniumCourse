package ru.stqa.course.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * Created by Maria.Guseva on 08.12.2016.
 */
public class NewPageTest extends TestBase{

    @Test
    public void test() {
        login("admin","admin");
        driver.findElement(By.linkText("Countries")).click();
        driver.findElement(By.cssSelector("#content div a")).click();

        List<WebElement> links = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
        String mainWindow = driver.getWindowHandle();
        Set<String> existingWindows = driver.getWindowHandles();
        String newWindow = "";
        for (WebElement link : links){
            link.click();
            newWindow = wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }

        logout();
        driver.quit();
    }

}
