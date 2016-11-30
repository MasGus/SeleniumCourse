package ru.stqa.course.selenium;

/**
 * Created by Maria.Guseva on 29.11.2016.
 */

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class CountriesAndZonesTest extends TestBase{

//    @Test
//    public void countries(){
//        login("admin", "admin");
//        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
//
//        List<WebElement> countriesList = driver.findElements(By.cssSelector(".dataTable  tr.row"));
//        ArrayList<String> countries = new ArrayList<>();
//        ArrayList<String> countriesWithZones = new ArrayList<>();
//        for (WebElement country : countriesList) {
//            String name = country.findElement(By.cssSelector("a")).getAttribute("textContent");
//            countries.add(name);
//            if(!country.findElement(By.xpath(".//td[6]")).getText().equals("0")){
//                countriesWithZones.add(name);
//            }
//        }
//        ArrayList<String> countriesSorted = countries;
//        Collections.sort(countriesSorted);
//        Assert.assertEquals(countries, countriesSorted);
//
//        ArrayList<String> zones = new ArrayList<>();
//        for (String country : countriesWithZones) {
//            driver.findElement(By.linkText(country)).click();
//            List<WebElement> zonesList =  driver.findElements(By.cssSelector(".dataTable  tr:not(.header) td"));
//            for (int i = 2; i < zonesList.size() - 1; i = i + 4) {
//                zones.add(zonesList.get(i).getAttribute("textContent"));
//            }
//            ArrayList<String> zonesSorted = zones;
//            Collections.sort(zonesSorted);
//            Assert.assertEquals(zones, zonesSorted);
//
//            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
//        }
//
//        logout();
//    }

    @Test
    public void geo_zones(){
        login("admin", "admin");
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        List<WebElement> countriesList = driver.findElements(By.cssSelector(".dataTable  tr.row"));
        ArrayList<String> countries = new ArrayList<>();
        for (WebElement country : countriesList) {
            String name = country.findElement(By.cssSelector("a")).getAttribute("textContent");
            countries.add(name);
        }

        for (String country : countries) {
            ArrayList<String> zones = new ArrayList<>();
            driver.findElement(By.linkText(country)).click();
            List<WebElement> zonesList =  driver.findElements(By.cssSelector(".dataTable  tr:not(.header) td"));
            for (int i = 2; i < zonesList.size() - 1; i = i + 4) {
                zones.add(zonesList.get(i).findElement(By.cssSelector("[selected=selected]")).getAttribute("textContent"));
            }
            ArrayList<String> zonesSorted = zones;
            Collections.sort(zonesSorted);
            Assert.assertEquals(zones, zonesSorted);

            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }

        logout();
    }
}
