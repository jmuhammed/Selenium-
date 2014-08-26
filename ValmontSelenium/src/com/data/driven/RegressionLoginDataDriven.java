package com.data.driven;

import java.io.FileInputStream;
import java.util.Properties;

import com.valmont.container.DataSourceInterface;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class RegressionLoginDataDriven implements DataSourceInterface {

	Sheet mSheet = null;
	int mSheetCount = 0;
	String[][] credentials;
	Properties prop;


	public String[][] fReadingData() throws Exception {

		FileInputStream fs = new FileInputStream(
				".\\RelatedFiles\\inputdetails.xls");
		
		Workbook Wb = Workbook.getWorkbook(fs);
		mSheetCount = Wb.getNumberOfSheets();
		System.out.println("The Total count of the sheet is: " + mSheetCount);
		
		for (int i = 0; i < mSheetCount; i++) {
			mSheet = Wb.getSheet(0);
			credentials = new String[mSheet.getRows() - 1][mSheet.getColumns()-1];

			System.out.println("The Rows are in the Sheet is: "
					+ mSheet.getRows());
			System.out.println("The Total columns in the Sheet is: "
					+ mSheet.getColumns());
			System.out.println("The Sheet name is: " + mSheet.getName());

			for (int column = 1; column < mSheet.getColumns(); column++)
				for (int row = 1; row < mSheet.getRows(); row++) {

					{

						Cell cell = mSheet.getCell(column, row);
						CellType type = cell.getType();
						System.out.println("Value at ["+column+"]["+row+"]: " + cell.getContents());
						System.out.println("Cell Type at ["+column+"]["+row+"]: " + type);
						if (type == CellType.LABEL || type == CellType.NUMBER) {
							credentials[row - 1][column-1] = cell.getContents();
							System.out.println("Value at ["+column+"]["+row+"]: " + cell.getContents());
							
						}
					}
				}
		}

		return credentials;

	}

	/*public int getRowsSize() {
		return mSheet.getRows();
	}

	public int getColumnsSize() {
		return mSheet.getColumns();
	}
*/
}
