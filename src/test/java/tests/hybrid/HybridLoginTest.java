package tests.hybrid;

import com.project.qa.api.AuthApi;
import com.project.qa.core.DriverFactory;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import java.util.Map;

public class HybridLoginTest extends BaseTest {

    @Test
    public void testLoginViaApiAndVerifyUi() {
        // 1. You MUST open the domain FIRST, otherwise Selenium rejects the cookie
        DriverFactory.getDriver().get("https://the-internet.herokuapp.com/login");

        // 2. Get Cookies via API
        Map<String, String> apiCookies = AuthApi.getLoginCookies("tomsmith", "SuperSecretPassword!");

        // 3. Inject them
        for (Map.Entry<String, String> entry : apiCookies.entrySet()) {
            Cookie seleniumCookie = new Cookie(entry.getKey(), entry.getValue());
            DriverFactory.getDriver().manage().addCookie(seleniumCookie);
            DriverFactory.getDriver().navigate().refresh();
        }

        // 4. Go to the secure page directly
        DriverFactory.getDriver().get("https://the-internet.herokuapp.com/secure");

        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("/secure"),
                "URL did not contain /secure. Current URL: " + DriverFactory.getDriver().getCurrentUrl());
    }
}