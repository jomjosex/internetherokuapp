package tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.MultipleWindows;

public class MultipleWindowsTest extends TestBase {
    private MultipleWindows multipleWindows;

    @BeforeMethod
    public void setupMultipleWindows() {
        driver.get("https://the-internet.herokuapp.com");
        multipleWindows = new MultipleWindows(driver);
        multipleWindows.clickMulipleWindows();
    }

    @Test
    public void testMultipleWindows() {
        multipleWindows.clickClickHereButton();

        String mainWindow = driver.getWindowHandle();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindow)) {
                // Switch to the child window
                driver.switchTo().window(handle);

                // Wait for the title to contain "New Window"
                wait.until(ExpectedConditions.titleContains("New Window"));

                // Check the title of the child window
                String actualTitle = driver.getTitle();
                Assert.assertEquals(actualTitle, "New Window", 
                                    "Verify the title of the child window");
            }
        }

        driver.switchTo().window(mainWindow);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "The Internet", 
                            "Verify control is back to the parent window");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
