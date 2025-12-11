package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage extends BasePage {

    private By nameField = By.name("name");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    private By step2Loaded = By.id("password");

    private By titleMr = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By addressField = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipField = By.id("zipcode");
    private By mobileField = By.id("mobile_number");

    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void signup(String name, String email) {
        try {
            jsType(nameField, name);
            jsType(emailField, email);

            jsClick(signupButton);

            removeAds();
            Thread.sleep(700);

            wait.until(ExpectedConditions.presenceOfElementLocated(step2Loaded));

            if (driver.findElements(step2Loaded).isEmpty()) {
                driver.navigate().refresh();
                removeAds();
            }

            waitVisible(step2Loaded);

        } catch (Exception e) {
            screenshot("signup_p1falhou");
            throw new RuntimeException("Falha na etapa 1", e);
        }
    }

    public void completeRegistration(String password) {
        try {
            removeAds();

            jsClick(titleMr);
            jsType(passwordField, password);

            new Select(waitVisible(daysDropdown)).selectByValue("10");
            new Select(waitVisible(monthsDropdown)).selectByValue("5");
            new Select(waitVisible(yearsDropdown)).selectByValue("1990");

            jsType(firstNameField, "Felipe");
            jsType(lastNameField, "Sodre");
            jsType(addressField, "Rua Teste 123");

            new Select(waitVisible(countryDropdown)).selectByVisibleText("United States");

            jsType(stateField, "sao Paulo");
            jsType(cityField, "Ibirapuera");
            jsType(zipField, "90001");
            jsType(mobileField, "1234567890");

            jsClick(createAccountButton);

        } catch (Exception e) {
            screenshot("signup_falhou");
            throw new RuntimeException("Falha na etapa 2", e);
        }
    }
}
