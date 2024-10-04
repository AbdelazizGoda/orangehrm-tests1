package com.orangehrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.AdminPage;

public class AdminTest {

    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;

    @BeforeClass
    public void setUp() {
        // Set Chrome options to disable automation features detection
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-debugging-port=0"); // Disable WebSocket connections for DevTools

        // Setup WebDriverManager to automatically manage ChromeDriver version
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Initialize the page objects
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    String username = "Admin";
    String password = "admin123";
    String newUser = "Zizo";

    @Test(priority = 1)
    public void loginTest() {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void addUserTest() {
        adminPage.clickAdminTab();
        String initialRecords = adminPage.getRecordsCount();

        adminPage.clickAddButton();
        adminPage.fillUserData("Linda Anderson", newUser, password);
        adminPage.clickSaveButton();

        String updatedRecords = adminPage.getRecordsCount();
        Assert.assertNotEquals(initialRecords, updatedRecords, "Record count didn't increase!");
    }

    @Test(priority = 3)
    public void deleteUserTest() {
        adminPage.searchUsername(newUser);
        adminPage.deleteUser();
        String updatedRecords = adminPage.getRecordsCount();
        // Assert logic to verify the user is deleted
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
