package uTILITY;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTESTDATA {
public String readDATAFROMexcel(String sheetName,int rowNUM,int cellNUM) throws Throwable {
	FileInputStream fileInputStream = new FileInputStream("./DATA/pMODULE.xlsx");
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row rw = sheet.getRow(rowNUM);
	Cell cell = rw.getCell(cellNUM);
	return cell.getStringCellValue();
}
}
