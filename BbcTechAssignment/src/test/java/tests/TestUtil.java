package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends TestBase{

	public void writeExcel(ArrayList<String> al1, ArrayList<String> al2)
			throws EncryptedDocumentException, IOException, InvalidFormatException {

		String fileName = "/Users/pallavisadhu/Desktop/BbcAssignment/BbcTechAssignment/src/test/java/testdata/bbc.xlsx";
		Row row;
		Cell cell;
		File file = new File(fileName);
		FileInputStream fin = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet("Sheet1");
		int j = 0;
		for (int i = 0; i < al1.size(); i++) {
			row = sheet.createRow(j);
			cell = row.createCell(0);
			cell.setCellValue(al1.get(i));
			cell = row.createCell(1);
			cell.setCellValue(al2.get(i));
			j++;

		}
		fin.close();
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();

	}
	
	public void takeScreenshot() throws IOException {
		Date c = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssZ");
		String sdate = formatter.format(c);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/"+sdate+".png"));
		
	}

}
