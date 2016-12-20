package ru.stqa.course.selenium.tests;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Maria.Guseva on 01.12.2016.
 */
public class ProductAdditionTest extends TestBase{

    private final String NAME = "New little duck";
    private final String IMAGE_PATH = System.getProperty("user.dir") + "/src/test/resources/duck.jpg";

    @Test
    public void test(){
        login("admin", "admin");
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.linkText("Add New Product")).click();

        generalTabFiiling();
        informationTabFiiling();
        pricesTabFiiling();

        driver.findElement(By.name("save")).click();

        driver.findElement(By.linkText(NAME));
    }

    private void generalTabFiiling(){
        driver.findElement(By.cssSelector("[href='#tab-general']")).click();

        driver.findElement(By.cssSelector("[name=status][value='1']")).click();

        driver.findElement(By.name("name[en]")).sendKeys(NAME);

        driver.findElement(By.name("code")).sendKeys("123");

        WebElement category = driver.findElement(By.cssSelector("[data-name=Subcategory]"));
        if(!category.isSelected()){
            category.click();
        }

        Select defaultCategory = new Select(driver.findElement(By.name("default_category_id")));
        WebElement selectedCategory = defaultCategory.getFirstSelectedOption();
        Assert.assertEquals(category.getAttribute("data-name"), selectedCategory.getText());

        driver.findElement(By.name("product_groups[]")).click();

        driver.findElement(By.name("quantity")).sendKeys("123");

        driver.findElement(By.name("new_images[]")).sendKeys(IMAGE_PATH);

        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date dateFrom = new Date();
        Date dateTo = DateUtils.addMonths(new Date(), 1);
        String dateFromString = dateFormat.format(dateFrom);
        String dateToString = dateFormat.format(dateTo);
        driver.findElement(By.name("date_valid_from")).sendKeys(dateFromString);
        driver.findElement(By.name("date_valid_to")).sendKeys(dateToString);
    }

    private void informationTabFiiling(){
        driver.findElement(By.cssSelector("[href='#tab-information']")).click();

        new Select(driver.findElement(By.name("manufacturer_id"))).selectByIndex(1);
        new Select(driver.findElement(By.name("supplier_id"))).selectByIndex(0);
        driver.findElement(By.name("keywords")).sendKeys("Keywords");
        driver.findElement(By.name("short_description[en]")).sendKeys("Short Description");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Description");
        driver.findElement(By.name("head_title[en]")).sendKeys("Head Title");
        driver.findElement(By.name("meta_description[en]")).sendKeys("Meta Description");
    }

    private void pricesTabFiiling(){
        driver.findElement(By.cssSelector("[href='#tab-prices']")).click();

        driver.findElement(By.name("purchase_price")).sendKeys("123");
        new Select(driver.findElement(By.name("purchase_price_currency_code"))).selectByIndex(1);
        new Select(driver.findElement(By.name("tax_class_id"))).selectByIndex(0);
        driver.findElement(By.name("prices[USD]")).sendKeys("123");
        driver.findElement(By.name("prices[EUR]")).sendKeys("123");
    }
}