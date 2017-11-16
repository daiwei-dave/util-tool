package Excel;



import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * POI生成Excel文件
 *Created by daiwei on 2017/2/22.
 */
public class PoiExpExcelToXls {
//	public static void write(String fileName) {
//		String[] title = Consts.COUPON_USER_TITLES;
//		//创建Excel工作簿
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		//创建一个工作表sheet
//		HSSFSheet sheet = workbook.createSheet();
//		//创建第一行
//		HSSFRow row = sheet.createRow(0);
//		HSSFCell cell = null;
//		//插入第一行数据
//		for (int i = 0; i < title.length; i++) {
//			//根据行创建列
//			cell = row.createCell(i);
//			cell.setCellValue(title[i]);
//		}
//
//		//追加数据
//		for (int i = 1; i <= 10; i++) {
//			HSSFRow nextrow = sheet.createRow(i);
//			HSSFCell cell2 = nextrow.createCell(0);
//			cell2.setCellValue("12345" + i);
//			cell2 = nextrow.createCell(1);
//			cell2.setCellValue("user" + i);
//			cell2 = nextrow.createCell(2);
//			cell2.setCellValue("电器年会");
//			cell2 = nextrow.createCell(3);
//			cell2.setCellValue("国美电器");
//			cell2 = nextrow.createCell(4);
//			cell2.setCellValue("未签到");
//		}
//		//创建一个文件
//		File file = new File(fileName);
//		try {
//			file.createNewFile();
//			//将Excel内容存盘，获得输出流
//			FileOutputStream stream = FileUtils.openOutputStream(file);
//			workbook.write(stream);
//			stream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//
//	}
//
//	public static void main(String[] args) {
//		PoiExpExcelToXls.write("d:/poi_test.xls");
//	}

}
