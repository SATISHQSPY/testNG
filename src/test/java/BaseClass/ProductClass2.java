package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectREPO.ProductPAGE;
import io.github.bonigarcia.wdm.WebDriverManager;
import uTILITY.BaseC;
import uTILITY.ExcelTESTDATA;
import uTILITY.JavaUtility;
import uTILITY.Notepadproperty;

public class ProductClass2 extends BaseC {
		@Test
		public void OnlyProductclass() throws Throwable {
		
		
		ExcelTESTDATA excel = new ExcelTESTDATA();
		JavaUtility j = new JavaUtility();

		ProductPAGE productPage = new ProductPAGE(driver);
		productPage.getLnktext().click();
		productPage.getPDpage().click();
		productPage.getPDname().sendKeys(excel.readDATAFROMexcel("sheet1", 1, 0)+j.generateRANDOM());
		productPage.getSbtn().click();


		}
		}

