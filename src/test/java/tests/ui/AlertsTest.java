package tests.ui;

import com.project.qa.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class AlertsTest extends BaseTest {

    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.open();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getResultText(), "You successfully clicked an alert");
    }

    @Test
    public void testDismissConfirm() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.open();
        alertsPage.triggerConfirm();
        alertsPage.dismissAlert(); // Clicks "Cancel"
        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Cancel");
    }

    @Test
    public void testPrompt() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.open();
        alertsPage.triggerPrompt();
        String myText = "Hello from Serbia!";
        alertsPage.typeInPrompt(myText);
        Assert.assertTrue(alertsPage.getResultText().contains(myText));
    }
}
