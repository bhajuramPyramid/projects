package TestProject.com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSFile{

	public static List<Student> getUserList() throws IOException {
		Student student = null;
		int count = 0;
		File excelFile = new File("D:/var/campaigns.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);

		// we create an XSSF Workbook object for our XLSX Excel File
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// we get first sheet
		XSSFSheet sheet = workbook.getSheetAt(0);

		// we iterate on rows
		Iterator<Row> rowIt = sheet.iterator();
		ArrayList<Student> members = new ArrayList<Student>();
		while (rowIt.hasNext()) {
			count++;
			Row row = rowIt.next();
			// iterate on cells for the current row
			Iterator<Cell> cellIterator = row.cellIterator();
			if (count != 1) {
				student = new Student();
				student.setName(cellIterator.next().toString());
				student.setDob(cellIterator.next().toString());
				student.setSubject(cellIterator.next().toString());
				student.setAddress(cellIterator.next().toString());
				members.add(student);
			}
		}
		workbook.close();
		fis.close();
		return members;
	}
}
