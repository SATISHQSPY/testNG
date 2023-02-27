package ObjectREPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	@FindBy(name = "user_name")
	private WebElement uNAME;
	
	@FindBy(name = "user_password")
	private WebElement pWD;
	
	@FindBy(id = "submitButton")
	private WebElement submitBTN;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutBTN;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public WebElement getuNAME() {
		return uNAME;
	}

	public WebElement getpWD() {
		return pWD;
	}

	public WebElement getSubmitBTN() {
		return submitBTN;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutBTN() {
		return signoutBTN;
	}
	
}
