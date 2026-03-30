package tests.ui;

import com.project.qa.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.open();

        String option = "Option 1";
        dropdownPage.selectByVisibleText(option);

        Assert.assertEquals(dropdownPage.getSelectedOption(), option, "The selected option is incorrect!");
    }

    @Test
    public void testDropdownOptionsCount() {
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.open();

        List<String> options = dropdownPage.getAllOptions();

        // The first option is usually "Please select an option" which is disabled
        Assert.assertTrue(options.contains("Option 2"), "Option 2 should be present in the dropdown");
        Assert.assertEquals(options.size(), 3, "Dropdown should have 3 items total");
    }
}
