package com.cybertek.bitrix.nazmi;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class assignment5_US1_AC1 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void login(){
        // Login with valid credentials
        // 1.Provide username
        WebElement usernameInputBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInputBox.sendKeys("helpdesk5@cybertekschool.com");

        // 2.Provide password
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        passwordInputBox.sendKeys("UserUser");

        // 3.Click the 'Log In' button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        // 4.Verify the title
        String actualTitle = driver.getTitle();
        String expectedTitle = "(3) Portal";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void setHighPriorityTask(){
        login();
        // 1.Click on the 'Task' button
        WebElement taskButton = driver.findElement(By.xpath("//span[.='Task']/span"));
        taskButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2.Write something in the 'Things to do' box
        WebElement thingsToDoBox = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
        thingsToDoBox.sendKeys("Click on “High Priority” checkbox to set the current task to a top priority task");

        // 3.Click on the High Priority checkbox
        WebElement highPriorityCheckbox = driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']"));
        highPriorityCheckbox.click();

        // 4.Confirm High Priority checkbox is selected
        Assert.assertTrue(highPriorityCheckbox.isSelected(),"highPriorityCheckbox is NOT selected. Verification FAILED!!!");

        // 5.Click on the 'Send' button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        // 6-a.Confirm 'Task has been created' message is displayed
        WebElement taskCreatedMessage = driver.findElement(By.xpath("//div[.='Task has been created']"));
        Assert.assertTrue(taskCreatedMessage.isDisplayed(),"'Task has been created' message is NOT displayed");

        // 6-b.Confirm 'Task has been created' message is displayed.
        String actualValue = taskCreatedMessage.getText();
        String expectedValue = "Task has been created";
        Assert.assertEquals(actualValue,expectedValue);
    }

    @AfterMethod
    public void tearDown(){

        driver.close();
        System.out.println("Have a wonderful day");
    }

}
