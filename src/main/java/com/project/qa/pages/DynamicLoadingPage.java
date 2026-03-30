package com.project.qa.pages;

import org.openqa.selenium.By;

public class DynamicLoadingPage extends BasePage{

    private By startButton = By.cssSelector("#start button");
    private By finishText = By.id("finish");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void clickStart() {
        click(startButton);
    }

    public String getLoadedText() {
        return getText(finishText); // Your BasePage getText already has the wait!
    }
}
