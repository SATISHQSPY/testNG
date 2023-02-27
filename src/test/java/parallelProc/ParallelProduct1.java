package parallelProc;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ObjectREPO.HomePage;
import ObjectREPO.ProductPAGE;
import io.github.bonigarcia.wdm.WebDriverManager;
import uTILITY.ExcelTESTDATA;
import uTILITY.JavaUtility;
import uTILITY.Notepadproperty;

public class ParallelProduct1 {
WebDriver driver;
@Test
public void PP1() throws Throwable {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	Notepadproperty prop = new Notepadproperty();
	driver.get(prop.readDATAFROMProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	HomePage homePage = new HomePage(driver);
	homePage.getuNAME().sendKeys(prop.readDATAFROMProperty("username"));
	homePage.getpWD().sendKeys(prop.readDATAFROMProperty("password"));
	homePage.getSubmitBTN().click();
	ProductPAGE productPAGE = new ProductPAGE(driver);
	productPAGE.getLnktext().click();
	JavaUtility J =new JavaUtility();
	ExcelTESTDATA excelTESTDATA = new ExcelTESTDATA();
	productPAGE.getPDpage().click();
	productPAGE.getPDname().sendKeys(excelTESTDATA.readDATAFROMexcel("Sheet1", 4, 0)+J.generateRANDOM());
	productPAGE.getSbtn().click();
	 WebElement aImg = homePage.getAdminImg();
	 Actions act = new Actions(driver);
	 act.moveToElement(aImg).perform();
	 homePage.getSignoutBTN().click();
}
}