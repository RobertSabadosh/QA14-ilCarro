package com.ilCarro.qa14.helpers;

import com.ilCarro.qa14.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    EventFiringWebDriver wd;

    UserHelper user;
    CarHelper car;
    HeaderHelper header;
    String browser;

    public static class MyListener extends AbstractWebDriverEventListener {

        Logger logger = LoggerFactory.getLogger(TestBase.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info(by + "found. ");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
        }
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        //System.setProperty("webdriver.chrome.driver","path/chromedriver.exe");
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(wd);
        car = new CarHelper(wd);
        header = new HeaderHelper(wd);

        wd.register(new MyListener());
    }

    public UserHelper user() {
        return user;
    }

    public CarHelper car() {
        return car;
    }

    public HeaderHelper header() {
        return header;
    }

    public void stop() {
        wd.quit();
    }
}
