package crossBrowse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectREPO.HomePage;
import ObjectREPO.ProductPAGE;
import io.github.bonigarcia.wdm.WebDriverManager;
import uTILITY.ExcelTESTDATA;
import uTILITY.JavaUtility;
import uTILITY.Notepadproperty;

public class ProductMoo2Test {
@Test
@Parameters("Browser")
public void Pmodule(String browser) throws Throwable {
	WebDriver driver;
	
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
 else 
 {
	 WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	}
Notepadproperty prop = new Notepadproperty();
driver.get(prop.readDATAFROMProperty("url"));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
HomePage homePage = new HomePage(driver);
homePage.getuNAME().sendKeys(prop.readDATAFROMProperty("username"));
homePage.getpWD().sendKeys(prop.readDATAFROMProperty("password"));
homePage.getSubmitBTN().click();

ExcelTESTDATA excelTESTDATA = new ExcelTESTDATA();
JavaUtility J = new JavaUtility();
ProductPAGE productPAGE = new ProductPAGE(driver);
productPAGE.getLnktext().click();
productPAGE.getPDpage().click();
productPAGE.getPDname().sendKeys(excelTESTDATA.readDATAFROMexcel("Sheet1", 3, 0)+J.generateRANDOM());
productPAGE.getSbtn().click();
 WebElement aImg = homePage.getAdminImg();
 Actions act = new Actions(driver);
 act.moveToElement(aImg).perform();
 homePage.getSignoutBTN().click();

}
}
