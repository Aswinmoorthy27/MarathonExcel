package Marathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel extends Baseclass{

	public static String[][] ReadExcel() throws IOException {
		XSSFWorkbook Excel = new XSSFWorkbook("./Excel/Salesforce.xlsx");

		XSSFSheet Sheet = Excel.getSheet("Sheet1");

		int Row = Sheet.getLastRowNum();
		int Col = Sheet.getRow(0).getLastCellNum();


		String[][] data = new String[Row][Col];
		for (int i = 1; i <= Row; i++) {
			XSSFRow Rowfor = Sheet.getRow(i);
			for (int j = 0; j < Col; j++) {
				String total = Rowfor.getCell(j).getStringCellValue();
				data[i - 1][j] = total;

			}
		}
		return data;

	}

}
