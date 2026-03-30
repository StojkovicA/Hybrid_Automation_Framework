package tests.ui;

import org.testng.annotations.DataProvider;
import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.project.qa.pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"wrongUser", "wrongPass", "Your username is invalid!"},
                {"abc", "123", "Your username is invalid!"},
                {"", "", "Your username is invalid!"}
        };
    }

    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String user, String pass, String expectedMsg) {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(user, pass);
        Assert.assertTrue(loginPage.getFlashMessage().contains(expectedMsg));
    }

}
