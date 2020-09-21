package com.cybertek.vytrack.Tests;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.vytrack.Pages.DashboardPage;
import com.cybertek.vytrack.Pages.LoginPage;
import com.cybertek.vytrack.Verifications.VyTrackVerifications;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTestDriver {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethodSergi() {
        driver = WebDriverFactory.getDriver("chrome");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUrl();
        loginPage.loginDriver();
    }

    @Test
    public void loginVerificationSergi() {
        VyTrackVerifications verification = new VyTrackVerifications(driver);
        verification.verifyLogoIsPresent();
        System.out.println("Login test PASS");
    }

    @Test
    //AC#2 Verify that Truck driver should be able to create Vehicle odometer or cancel it
    public void CreateVehicleOdometerAndCancelTalant() throws InterruptedException {
        Thread.sleep(2000);
        //Find "Fleet" Menu and click
        driver.findElement(By.className("unclickable")).click();
        Thread.sleep(3000);
        //Find "Vehicle Odometer" and click
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(3000);
        //Find "Create Vehicle Odometer" and click
        driver.findElement(By.linkText("Create Vehicle Odometer")).click();
        Thread.sleep(3000);
        //Find input "Odometer" and enter 68.000
        driver.findElement(By.name("custom_entity_type[OdometerValue]")).sendKeys("68000");
        //Find input "Driver" and enter name
        driver.findElement(By.name("custom_entity_type[Driver]")).sendKeys("Talant");
        //Find "Cancel" button and click
        driver.findElement(By.linkText("Cancel")).click();
        //Verify Title
        String expectedTitle = "Create Vehicle Odometer";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Verification is PASSED");
        } else {
            System.out.println("Verification is FAILED");
        }
    }

    @Test
    public void odometerPageIsDisplayedVerificationSergi() {
        DashboardPage page = new DashboardPage(driver);
        page.goToOdometerPage();
        VyTrackVerifications verification = new VyTrackVerifications(driver);
        verification.verifyVehicleOdometerPageIsDisplayed();
        System.out.println("Odometer Page Is Displayed test PASS");
    }

    @Test
    //*AC3. Verify that truck driver should be able to delete or edit Vehicle odometer.
    public void edit_delete_button_verification() throws InterruptedException {
        Thread.sleep(2000);
        WebElement fleetModule = driver.findElement(By.linkText("Fleet"));
        fleetModule.click();
        // driver.findElement(By.xpath("//*[@class='dropdown dropdown-level-1']")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        WebElement vehicleOdometerModule = driver.findElement(By.xpath("//span[contains(text(),'Vehicle Odometer')]"));
        vehicleOdometerModule.click();
        Thread.sleep(5000);
        WebElement createVehicle = driver.findElement(By.xpath("//a[@class ='btn main-group btn-primary pull-right ']"));
        createVehicle.click();
        Thread.sleep(4000);
        WebElement clickSaveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickSaveButton.click();
        Thread.sleep(3000);
        WebElement clickDeleteVehicleButton = driver.findElement(By.xpath("//a[@title='Delete Vehicle Odometer']"));
        clickDeleteVehicleButton.click();
        Thread.sleep(3000);
        WebElement deleteVehicle = driver.findElement(By.xpath("//a[.='Yes, Delete']"));
        deleteVehicle.click();
        Thread.sleep(3000);
    }

    @Test
    public void test1_vehicle_odometerPage()throws InterruptedException{
        WebElement fleetModule = driver.findElement(By.linkText("Fleet"));
        fleetModule.click();
        Thread.sleep(1000);
        WebElement vehicleOdometer = driver.findElement(By.xpath("//span[contains(text(),'Vehicle Odometer')]"));
        vehicleOdometer.click();
        Thread.sleep(3000);
        WebElement SelectVehicle = driver.findElement(By.xpath("//tr[6]//td[4]"));
        SelectVehicle.click();
        Thread.sleep(2000);
        WebElement editButton = driver.findElement(By.xpath("//*[@id='container']/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/a"));
        editButton.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
