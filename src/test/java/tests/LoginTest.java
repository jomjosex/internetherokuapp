package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ScreenshotUtils;

import java.io.IOException;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/jomjose/Documents/SeleniumProjects/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
        
     // Capture screenshot before signing in
        ScreenshotUtils.captureScreenshot(driver, "beforeSignIn");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws InterruptedException {
        loginPage.enterUsername(username);
        Thread.sleep(3000);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        // Add assertions here to verify the success of the login process
       
        
     // Capture screenshot after signing in
        ScreenshotUtils.captureScreenshot(driver, "afterSignIn");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testData.xlsx", "Sheet1");
        int rowCount = excelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][2]; // Minus header row

        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = excelUtils.getCellData(i, 0); // Username
            data[i - 1][1] = excelUtils.getCellData(i, 1); // Password
        }

        return data;
    }

    
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
