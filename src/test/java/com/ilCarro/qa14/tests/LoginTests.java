package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.user().isSignUpButtonPresent()) {
            app.user().logout();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() throws InterruptedException {

        app.user().clickOnLoginTab();

        app.user().fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("Hummels098765"));

        app.user().submit();

        app.header().isLogoutTabPresent();
    }

    @Test(enabled = false, dataProvider = "loginPositiveTestFromCSV", dataProviderClass = DataProviders.class)
    public void loginRegisteredUserPositiveFromCSVTest(User user) throws InterruptedException {

        app.user().clickOnLoginTab();

        app.user().fillLoginForm(user);

        app.user().submit();

        app.header().isLogoutTabPresent();
    }

    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {

        app.user().clickOnLoginTab();

        app.user().fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("hummels098765"));

        app.user().submit();
        app.user().isLogInFormPresent();
    }

    @Test(enabled = false, dataProvider = "loginNegativeTestFromCSV", dataProviderClass = DataProviders.class)
    //@Test(dataProvider = "loginNegativeTestFromCSV", dataProviderClass = DataProviders.class)
    public void loginRegisteredUserWithWrongPasswordNegativeFromCSVTest(User user) {

        app.user().clickOnLoginTab();

        app.user().fillLoginForm(user);

        app.user().submit();

        app.user().isLogInFormPresent();
    }
}
