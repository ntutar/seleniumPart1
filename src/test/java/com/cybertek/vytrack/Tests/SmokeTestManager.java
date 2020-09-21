package com.cybertek.vytrack.Tests;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.vytrack.Pages.LoginPage;
import com.cybertek.vytrack.Verifications.VyTrackVerifications;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTestManager {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethodSergi() {
        driver = WebDriverFactory.getDriver("chrome");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUrl();
        loginPage.loginManager();
    }

    @Test
    public void loginVerificationVesile() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager265");
        Thread.sleep(2000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "FAILED!!!");
        Thread.sleep(5000);
        //  Given I am on Vehicles page as a Truck Driver
        WebElement clickFleet = driver.findElement(By.xpath(" //li[@class='dropdown dropdown-level-1']"));//fleet
        clickFleet.click();
        Thread.sleep(2000);
        WebElement clickVehicles = driver.findElement(By.xpath(" //span[contains(text(),'Vehicles')]"));
        clickVehicles.click();
        Thread.sleep(2000);
        //  When I click on the Grid settings symbol on the right top of the grid
        WebElement gridSettings = driver.findElement(By.xpath("//div[@class='column-manager dropdown']"));
        gridSettings.click();
        Thread.sleep(2000);
        //  And select/deselect the properties of the car as I want it to be displayed
        WebElement selectSetting = driver.findElement(By.xpath("//input[@id='column-c605']"));
        selectSetting.click();
        Thread.sleep(2000);
        Assert.assertTrue(selectSetting.isSelected());
        selectSetting.click();
        Thread.sleep(2000);
        Assert.assertFalse(selectSetting.isSelected());
        gridSettings.click();
        Thread.sleep(2000);
        //Then I should be able to reset the Grid
        WebElement clickReset = driver.findElement(By.xpath("//a[@title='Reset']"));
        clickReset.click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
