package com.janitri.tests;

import com.janitri.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Test
    public void testLoginButtonEnabledByDefault() {
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), 
            "Login button should be enabled by default");
        
        loginPage.clickLoginButton();
        
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg.isEmpty(),
            "Error message should be displayed for empty fields");
    }

    @Test
    public void testPasswordMaskedButton() {
        loginPage.enterPassword("TestPassword123");
        
        Assert.assertEquals(loginPage.getPasswordInputType(), "password",
            "Password should be masked by default");
        
        loginPage.togglePasswordVisibility();
        
        Assert.assertEquals(loginPage.getPasswordInputType(), "text",
            "Password should be visible after toggling");
        
        loginPage.togglePasswordVisibility();
        
        Assert.assertEquals(loginPage.getPasswordInputType(), "password",
            "Password should be masked after toggling again");
    }

    @Test

    public void testInvalidLoginShowErrorMsg() {
        loginPage.enterUserId("invalid@email.com");
        loginPage.enterPassword("wrongpassword");
        
        loginPage.clickLoginButton();
        
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg.isEmpty(),
            "Error message should be displayed for invalid credentials");
    }

    @Test
    public void testPageElementsPresence() {
        Assert.assertTrue(loginPage.areAllElementsPresent(),
            "All login page elements should be present");
    }
}
