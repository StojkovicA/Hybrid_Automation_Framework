package tests;

import com.project.qa.core.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverFactory.quitDriver();
    }

}
