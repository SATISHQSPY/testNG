package BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectREPO.ProductPAGE;
import uTILITY.BaseC;
import uTILITY.ExcelTESTDATA;
import uTILITY.JavaUtility;

public class ExtendBaseCLass extends BaseC {
@Test
public void OnlyProductclass() throws Throwable {


ExcelTESTDATA excel = new ExcelTESTDATA();
JavaUtility j = new JavaUtility();

ProductPAGE productPage = new ProductPAGE(driver);
Assert.assertEquals(false, true);
productPage.getLnktext().click();
productPage.getPDpage().click();
productPage.getPDname().sendKeys(excel.readDATAFROMexcel("sheet1", 1, 0)+j.generateRANDOM());
productPage.getSbtn().click();


}
}
