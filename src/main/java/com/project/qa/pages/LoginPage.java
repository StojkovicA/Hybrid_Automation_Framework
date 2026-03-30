package com.project.qa.pages;

import com.project.qa.core.ConfigReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");


    public void open(){
        driver.get(ConfigReader.getBaseUrl() + "/login");
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public String getFlashMessage() {
        return getText(flashMessage);
    }
}
