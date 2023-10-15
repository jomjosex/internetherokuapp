package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Digest_Auth {
	private WebDriver driver;
	
	@FindBy (id="username")
	private WebElement usernameField;
	
	@FindBy (id="password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//form[@action='/digest_auth']//button[@type='submit']")
    private WebElement loginButton;

    public Digest_Auth(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
