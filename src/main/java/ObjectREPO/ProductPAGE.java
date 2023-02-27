package ObjectREPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPAGE {
WebDriver driver;
@FindBy(linkText="Products")
private WebElement lnktext;

@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement PDpage;

@FindBy (name = "productname")
private WebElement PDname;

@FindBy (name="sales_start_date")
private WebElement Sale;

@FindBy (name="button")
private WebElement Sbtn;

public ProductPAGE(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public WebElement getLnktext() {
	return lnktext;
}

public WebElement getPDpage() {
	return PDpage;
}

public WebElement getPDname() {
	return PDname;
}

public WebElement getSale() {
	return Sale;
}

public WebElement getSbtn() {
	return Sbtn;
}



}
