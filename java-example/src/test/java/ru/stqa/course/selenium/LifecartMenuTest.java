package ru.stqa.course.selenium;

/**
 * Created by Maria.Guseva on 24.11.2016.
 */

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LifecartMenuTest extends TestBase{

    @Test
    public void test(){
        login("admin", "admin");

        List<WebElement> menuElementList = driver.findElements(By.cssSelector("#box-apps-menu-wrapper a"));

        ArrayList<String> menuItemList = new ArrayList<>();
        for (WebElement menuElement : menuElementList) {
            menuItemList.add(menuElement.getText());
        }

        for (String menuItem : menuItemList) {
            driver.findElement(By.linkText(menuItem)).click();
            Assert.assertTrue(driver.findElements(By.cssSelector("#content h1") ).size() != 0);

            if (driver.findElements(By.cssSelector("#box-apps-menu-wrapper > ul > li") ).size() != 0) {
                List<WebElement> subMenuElementList = driver.findElements(By.cssSelector(".docs a"));

                ArrayList<String> subMenuItemList = new ArrayList<>();
                for (WebElement subMenuElement : subMenuElementList) {
                    subMenuItemList.add(subMenuElement.getText());
                }

                for (String subMenuItem : subMenuItemList) {
                    driver.findElement(By.linkText(subMenuItem)).click();
                    Assert.assertTrue(driver.findElements(By.cssSelector("#content h1") ).size() != 0);
                }
            }
        }

        logout();
    }
}