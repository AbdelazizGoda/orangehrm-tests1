package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.id("txtUsername");
    By passwordField = By.id("txtPassword");
    By loginButton = By.id("btnLogin");

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
