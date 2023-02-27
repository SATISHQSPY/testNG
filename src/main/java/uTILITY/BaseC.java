package uTILITY;


import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import ObjectREPO.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseC {
	
public	WebDriver driver;
public static WebDriver driver2;
	HomePage homepage;
@BeforeSuite
public void ConnectDB(){
	System.out.println("Connect_to_DB");
}

@AfterSuite
public void DisconnectDB() {
	System.out.println("dISCONNECT _TO _DB");
}


@BeforeClass
public void launchthebrowser() {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver2=driver;
	System.out.println("Open the browser");
}

@AfterClass
public void Closethebrowser(){
	driver.close();
	System.out.println("Close the browser");
}

@BeforeMethod
public void OpentheApplication() throws Throwable {
	Notepadproperty prop = new Notepadproperty();
	homepage = new HomePage(driver);
	driver.get(prop.readDATAFROMProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	homepage.getuNAME().sendKeys(prop.readDATAFROMProperty("username"));
	homepage.getpWD().sendKeys(prop.readDATAFROMProperty("password"));
	homepage.getSubmitBTN().click();
	System.out.println("LOGIN_THE_APP");
	
}

@AfterMethod
public void ClosetheApp() {
	 WebElement aImg= homepage.getAdminImg();
	Actions act = new Actions(driver);
	act.moveToElement(aImg).perform();
	homepage.getSignoutBTN().click();
	System.out.println("CLOSE_THE_APPLICATION");
	
}
	public static String Screenshot(String name)  {
		TakesScreenshot sh = (TakesScreenshot)BaseC.driver2;
		File src = sh.getScreenshotAs(OutputType.FILE);
		
		String path = "./ScreenShot/"+name+".PNG";
		File dst = new File(path);
		try {
			FileUtils.copyFile(src, dst);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return path;
	}
}

