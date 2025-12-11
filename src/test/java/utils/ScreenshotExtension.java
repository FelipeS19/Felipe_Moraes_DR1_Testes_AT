package utils;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotExtension implements TestWatcher, BeforeEachCallback {

    private WebDriver driver;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Object instance = context.getRequiredTestInstance();

        var field = instance.getClass().getDeclaredField("driver");
        field.setAccessible(true);
        driver = (WebDriver) field.get(instance);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            if (driver == null) return;

            Files.createDirectories(Paths.get("screenshots"));

            String testName = context.getDisplayName().replace("()", "").replace(" ", "_");

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get("screenshots/" + testName + "_FAIL.png"));

            Files.writeString(
                Paths.get("screenshots/" + testName + "_ERROR.txt"),
                cause.toString()
            );

        } catch (Exception ignored) {}
    }
}
