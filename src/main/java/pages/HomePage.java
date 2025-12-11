package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToSignupLogin() {
        removeAds();
        waitVisible(signupLoginLink);
        jsClick(signupLoginLink);
    }
}
