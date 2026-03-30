package com.project.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends BasePage{

    private By dropdownElement = By.id("dropdown");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectByVisibleText(String text) {
        logger.info("Selecting option by text: {}", text);
        Select dropdown = new Select(driver.findElement(dropdownElement));
        dropdown.selectByVisibleText(text);
    }

    public String getSelectedOption() {
        Select dropdown = new Select(driver.findElement(dropdownElement));
        return dropdown.getFirstSelectedOption().getText();
    }

    //Method to get all available options (useful for validation)
    public List<String> getAllOptions() {
        Select dropdown = new Select(driver.findElement(dropdownElement));
        return dropdown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
