package com.janitri.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "formEmail")
    private WebElement userIdInput;

    @FindBy(id = "formPassword")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit'].login-button")
    private WebElement loginButton;

    @FindBy(css = ".passowrd-visible")
    private WebElement passwordToggleIcon;

    @FindBy(css = ".invalid-credential-div p.normal-text")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        driver.get("https://dev-dash.janitri.in/");
    }

    public void enterUserId(String userId) {
        userIdInput.clear();
        userIdInput.sendKeys(userId);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void togglePasswordVisibility() {
        passwordToggleIcon.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getPasswordInputType() {
        return passwordInput.getAttribute("type");
    }

    public boolean areAllElementsPresent() {
        return userIdInput.isDisplayed() &&
               passwordInput.isDisplayed() &&
               loginButton.isDisplayed() &&
               passwordToggleIcon.isDisplayed();
    }
}
