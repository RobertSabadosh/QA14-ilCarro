package com.ilCarro.qa14.helpers;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public boolean isElementPresent(By by) {
        return wd.findElements(by).size() > 0;
    }

    public boolean isElementPresent1(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            /*wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);*/
            wd.findElement(locator).sendKeys(Keys
                    .chord(Keys.CONTROL, "a") + Keys.DELETE + text);
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void jumpToFooter() {
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
