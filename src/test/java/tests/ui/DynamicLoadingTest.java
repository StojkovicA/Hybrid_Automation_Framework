package tests.ui;

import com.project.qa.pages.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void testDynamicLoading() {
        DynamicLoadingPage page = new DynamicLoadingPage();
        page.open();
        page.clickStart();

        String result = page.getLoadedText();
        Assert.assertEquals(result, "Hello World!");
    }
}
