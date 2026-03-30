package com.project.qa.pages;

import org.openqa.selenium.By;

public class AlertsPage extends BasePage{

    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void triggerAlert() {
        click(jsAlertButton);
    }

    public void triggerConfirm() {
        click(jsConfirmButton);
    }

    public void triggerPrompt() {
        click(jsPromptButton);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void typeInPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public String getResultText() {
        return getText(resultText);
    }
}
