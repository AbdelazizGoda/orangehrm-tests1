package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    WebDriver driver;

    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By adminTab = By.id("menu_admin_viewAdminModule");
    By recordsCount = By.xpath("//div[@id='resultTable_info']");
    By addButton = By.id("btnAdd");
    By userRoleDropdown = By.id("systemUser_userType");
    By employeeNameField = By.id("systemUser_employeeName_empName");
    By usernameField = By.id("systemUser_userName");
    By passwordField = By.id("systemUser_password");
    By confirmPasswordField = By.id("systemUser_confirmPassword");
    By saveButton = By.id("btnSave");
    By searchUsernameField = By.id("searchSystemUser_userName");
    By searchButton = By.id("searchBtn");
    By deleteButton = By.id("btnDelete");

    // Actions
    public void clickAdminTab() {
        driver.findElement(adminTab).click();
    }

    public String getRecordsCount() {
        return driver.findElement(recordsCount).getText();
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void fillUserData(String employeeName, String username, String password) {
        driver.findElement(employeeNameField).sendKeys(employeeName);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void searchUsername(String username) {
        driver.findElement(searchUsernameField).sendKeys(username);
        driver.findElement(searchButton).click();
    }

    public void deleteUser() {
        driver.findElement(deleteButton).click();
    }
}
