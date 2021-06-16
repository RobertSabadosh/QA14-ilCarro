package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCarTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.user().isUserLoggedIn()) {
            app.user().logIn();
        }
    }

    @Test
    public void addCarTest() throws InterruptedException {
        app.user().pause(2000);
        app.car().clickOnAddCarTab();

        app.car().fillCarForm(new Car()
                .setCountry("Germany")
                .setAddress("Friedrichstrasse")
                .setDistance("1000"));
    }

    @Test(dataProvider = "validCarFromCSV", dataProviderClass = DataProviders.class)
    public void addCarFromCSVTest(Car car) throws InterruptedException {
        app.user().pause(2000);
        app.car().clickOnAddCarTab();

        app.car().fillCarForm(car);
    }
}
