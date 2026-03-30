package com.project.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By heading = By.tagName("h1");

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }
}
