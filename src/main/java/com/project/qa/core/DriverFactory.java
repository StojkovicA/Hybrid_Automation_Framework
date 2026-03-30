package com.project.qa.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            // --- Setup Download Folder ---
            String downloadPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "downloads";
            File directory = new File(downloadPath);
            if (!directory.exists()) directory.mkdirs(); // Create folder if it doesn't exist

            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", downloadPath);
            options.setExperimentalOption("prefs", prefs);

            driver.set(new ChromeDriver(options));

            getDriver().manage().window().maximize();
            getDriver().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(ConfigReader.getTimeout()));
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initDriver(); // Auto-initialize if someone forgot
        }
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}

