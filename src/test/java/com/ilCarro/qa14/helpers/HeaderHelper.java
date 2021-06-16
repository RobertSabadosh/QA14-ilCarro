package com.ilCarro.qa14.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void isLogoutTabPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void checkSearchPageLounch() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[1]"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }
}
