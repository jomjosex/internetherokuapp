package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindows {
	private WebDriver driver;
	
	@FindBy (xpath= "//a[@href=\"/windows\"]")
	private WebElement multipleWindows;
	
	@FindBy (xpath= "//a[@href=\"/windows/new\"]")
	private WebElement clickHereButton;
	
	public MultipleWindows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickMulipleWindows()
	{
		multipleWindows.click();
	}
	
	public void clickClickHereButton()
	{
		clickHereButton.click();
	}

}
