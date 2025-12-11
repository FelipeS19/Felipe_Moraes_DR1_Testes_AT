package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void jsClick(By locator) {
        WebElement el = waitVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", el);
    }

    public void jsType(By locator, String value) {
        WebElement el = waitVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", el, value);
    }

    public void removeAds() {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('iframe, .adsbygoogle, [id*=\"google_ads\"]').forEach(e => e.remove());"
            );
        } catch (Exception ignored) {}
    }
public void screenshot(String name) {
    try {
        String folder = System.getProperty("user.dir") + File.separator + "screenshots";

        Files.createDirectories(Paths.get(folder));

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = folder + File.separator + name + ".png";

        Files.copy(src.toPath(), Paths.get(path));

        System.out.println("Screenshot salvo em: " + path);

    } catch (Exception e) {
        System.out.println(" Erro ao salvar screenshot: " + e.getMessage());
    }
}
}
