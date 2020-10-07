package com.cybertek.bitrix.sergi;

import com.cybertek.bitrix.Pages.BitrixLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void Verify_editor_textBar_is_displayed(){
        Driver.getDriver().get(ConfigurationReader.getProperty("BitrixUrl"));

        BitrixLoginPage loginBitrix = new BitrixLoginPage();
        loginBitrix.login();

        Driver.closeDriver();


    }

}
