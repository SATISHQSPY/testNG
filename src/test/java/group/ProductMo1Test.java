package group;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ObjectREPO.HomePage;
import ObjectREPO.ProductPAGE;
import io.github.bonigarcia.wdm.WebDriverManager;
import uTILITY.ExcelTESTDATA;
import uTILITY.JavaUtility;
import uTILITY.Notepadproperty;

public class ProductMo1Test {
	@Test(groups = "regression")
	public void product() throws Throwable {
		System.out.println("This is the smoke");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Notepadproperty prop = new Notepadproperty();
		driver.get(prop.readDATAFROMProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage homePage = new HomePage(driver);
		homePage.getuNAME().sendKeys(prop.readDATAFROMProperty("username"));
		homePage.getpWD().sendKeys(prop.readDATAFROMProperty("password"));
		homePage.getSubmitBTN().click();
		ExcelTESTDATA excel = new ExcelTESTDATA();
		JavaUtility j = new JavaUtility();
		ProductPAGE productPage = new ProductPAGE(driver);
		productPage.getLnktext().click();
		productPage.getPDpage().click();
		productPage.getPDname().sendKeys(excel.readDATAFROMexcel("sheet1", 1, 0)+j.generateRANDOM());
		productPage.getSbtn().click();
		WebElement aImg = homePage.getAdminImg();
		Actions act = new Actions(driver);
		act.moveToElement(aImg).perform();
		homePage.getSignoutBTN().click();
	}

}
