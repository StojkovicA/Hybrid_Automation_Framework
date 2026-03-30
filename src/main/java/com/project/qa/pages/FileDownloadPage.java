package com.project.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FileDownloadPage extends BasePage{

    private By downloadLinks = By.cssSelector(".example a");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/download");
    }

    public String downloadFirstFile() {
        List<WebElement> links = driver.findElements(downloadLinks);
        // Get the filename from the first link
        String fileName = links.get(0).getText();
        links.get(0).click();
        return fileName;
    }
}
