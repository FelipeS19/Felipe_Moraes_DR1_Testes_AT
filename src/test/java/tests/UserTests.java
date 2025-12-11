package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenshotExtension;
import pages.*;

import java.time.Duration;

@ExtendWith(ScreenshotExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTests {

    public WebDriver driver; 
    private HomePage homePage;
    private SignupPage signupPage;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        homePage = new HomePage(driver);
        signupPage = new SignupPage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void testSignupAndLoginValidUser() {
        homePage.goToSignupLogin();

        String email = "user_" + System.currentTimeMillis() + "@mail.com";

        signupPage.signup("Felipe", email);
        signupPage.completeRegistration("senha123");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[contains(text(),'Continue')]")
        ));

        signupPage.removeAds();
        signupPage.jsClick(By.xpath("//a[contains(text(),'Continue')]"));

        Assertions.assertTrue(
            driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed()
        );
    }

    @Test
    public void testLoginInvalidUser() {
        homePage.goToSignupLogin();

        loginPage.login("x" + System.currentTimeMillis() + "@mail.com", "123");

        Assertions.assertTrue(
            loginPage.isErrorMessageDisplayed(),
            "Mensagem de erro não exibida!"
        );
    }
}
