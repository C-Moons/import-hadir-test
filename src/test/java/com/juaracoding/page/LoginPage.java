package com.juaracoding.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username = By.id("email");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(), 'Masuk')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String data) {
        waitingElementReady(username).sendKeys(data);
    }

    public void inputPassword(String data) {
        waitingElementReady(password).sendKeys(data);
    }

    public void clickButtonLogin() {
        waitingElementReady(loginButton).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickButtonLogin();
    }
}
