package es.ja.cgj.webdriver.utils;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;

public class ExcelReader {
	
	// Define a static logger variable
	static Logger logger = Logger.getLogger(ExcelReader.class);

	public static String[][] getTableArray(String excelFilePath, String sheetName,
			String tableName) {
		
		String[][] tabArray = null;
		
		try {
			Workbook workbook = Workbook.getWorkbook(new File(excelFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1,
					startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			logger.info("startRow=" + startRow + ", endRow=" + endRow + ", "
					+ "startCol=" + startCol + ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			logger.error("Error inesperado", e);
		}

		return (tabArray);
	}
}
