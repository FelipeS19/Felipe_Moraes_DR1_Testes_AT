package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailField = By.xpath("//input[@data-qa='login-email']");
    private By passwordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By errorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        removeAds();
        jsType(emailField, email);
        jsType(passwordField, password);
        jsClick(loginButton);
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorMsg).size() > 0;
    }
}
