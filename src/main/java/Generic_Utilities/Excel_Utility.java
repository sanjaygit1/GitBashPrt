package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		/**
		 * This method is used to read data from excel file
		 * @author Shobha
		 */
		// Step1:-get the connection of physical file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelData2pm.xlsx");

		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:-get control of the row
		Row row = sheet.getRow(rowNum);

		// step5:-get control of the cell
		Cell cel = row.getCell(cellNum);

		// //step6:-read cell value
		String excelData = cel.getStringCellValue();
		System.out.println(excelData);
		return excelData;
	}

}
