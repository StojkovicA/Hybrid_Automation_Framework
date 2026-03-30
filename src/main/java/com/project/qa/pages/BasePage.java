package com.project.qa.pages;

import com.project.qa.core.ConfigReader;
import com.project.qa.core.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getTimeout())
        );
    }

    protected void click(By locator) {
        logger.info("Clicking on: {}", locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        logger.info("Typing '{}' into: {}", locator, text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        logger.info("Getting text from: {}", locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
}
