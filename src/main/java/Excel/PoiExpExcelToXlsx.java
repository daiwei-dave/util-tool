package Excel;


import Excel.constant.Consts;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiExpExcelToXlsx {

	/**
	 * POI生成Excel文件对于高版本
	 * @author   daiwei
	 * @param args
	 */
	public static void main(String[] args) {

		String[] title = Consts.COUPON_USER_TITLES;

		//创建Excel工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建一个工作表sheet
		Sheet sheet = workbook.createSheet();
		//创建第一行
		Row row = sheet.createRow(0);
		Cell cell = null;
		//插入第一行数据 id,name,sex
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for (int i = 1; i <= 10; i++) {
			Row nextrow = sheet.createRow(i);
			Cell cell2 = nextrow.createCell(0);
			cell2.setCellValue("12345" + i);
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user" + i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("电器年会");
			cell2 = nextrow.createCell(3);
			cell2.setCellValue("国美电器");
			cell2 = nextrow.createCell(4);
			cell2.setCellValue("未签到");
		}

		File file = new File("d:/poi_test.xlsx");
		try {
			file.createNewFile();

			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
