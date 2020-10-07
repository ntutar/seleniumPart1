package com.cybertek.bitrix.verifications;

import com.cybertek.bitrix.pages.BitrixStreamPage;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BitrixVerifications {

    BitrixStreamPage streamPage = new BitrixStreamPage();

    public void verify_editor_textBar_is_displayed(){
        Driver.pageLoadTimeout();
        boolean elem = Driver.getDriver().findElement(streamPage.editorTextBar).isDisplayed();
        Assert.assertTrue(elem);
    }
}
