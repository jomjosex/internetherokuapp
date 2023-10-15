package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "/Users/jomjose/Documents/SeleniumProjects/ChromeDriver/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
