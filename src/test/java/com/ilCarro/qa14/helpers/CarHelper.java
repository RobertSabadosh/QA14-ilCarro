package com.ilCarro.qa14.helpers;

import com.ilCarro.qa14.models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarHelper extends HelperBase {

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isFindCarFormPresent() {
        return isElementPresent1(By
                .cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }

    public void clickOnAddCarTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[2]"));
    }

    public void fillCarForm(Car car) {
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistance());
    }
}
