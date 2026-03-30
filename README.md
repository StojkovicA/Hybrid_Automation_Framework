Hybrid Test Automation Framework

A robust, scalable automation framework built with Java and Selenium, integrating RestAssured for hybrid API-UI testing. This project demonstrates modern automation patterns, thread-safe parallel execution, and advanced web element handling.

Key Technical Features

Thread-Safe Parallel Execution: Implemented using ThreadLocal<WebDriver> within a custom DriverFactory, allowing multiple tests to run simultaneously without session interference.

Hybrid Testing Logic: Features a specialized "Hybrid Login" that bypasses UI authentication by fetching session cookies via RestAssured and injecting them into the Selenium browser instance.

Dynamic Synchronization: Uses Explicit Waits and a centralized BasePage to handle AJAX, loading bars, and flaky DOM elements.

Infrastructure Management:

Automated Driver Management: Powered by WebDriverManager.

Configuration Logic: Environment-based setup using .properties files.

Custom Capabilities: Configured Chrome to handle dynamic file downloads directly into the project's target folder.

Tech Stack

Language: Java 20

UI Engine: Selenium WebDriver 4.18.1

API Client: RestAssured 5.4.0

Test Runner: TestNG (Parallel Mode)

Build Tool: Maven

Design Pattern: Page Object Model (POM)

Project Structure

src/main/java
└── com.project.qa
├── api        # API Clients (RestAssured logic)
├── core       # DriverFactory, ConfigReader, Listeners
└── pages      # Page Object Classes (UI Locators & Actions)

src/test/java
└── tests
├── api        # Pure API functional tests
├── hybrid     # UI + API integration tests
└── ui         # UI functional tests (Alerts, Downloads, POM)

Test Coverage Highlights

Dynamic Loading: Handling elements that appear after a delay using explicit synchronization.

JavaScript Alerts: Managing browser-level pop-ups (Accept/Dismiss/Prompt).

File Download: Verifying physical file existence on the OS after a browser action.

Drop-downs: Using the Selenium Select API for standard HTML elements.

Authentication: Multi-flow login verification (UI-based, API-based, and Cookie Injection).

How to Run

Prerequisites
JDK 20 or higher

Maven installed

Chrome Browser

Run via Command Line (Best for CI/CD)
Bash
mvn clean test -DsuiteXmlFile=testng.xml
Run via IDE
Right-click testng.xml in the root directory.

Select Run '...\testng.xml'.

Reporting & Logging

Console Logging: Integrated with Log4j2 for real-time execution tracking.

Listeners: Custom TestNG listeners capture logic for failed tests (ready for screenshot integration).