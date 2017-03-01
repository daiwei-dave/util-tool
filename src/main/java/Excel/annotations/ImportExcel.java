package Excel.annotations;



import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 导入Excel文件（支持“XLS”和“XLSX”格式）
 * 
 * @version 2013-03-10
 */
public class ImportExcel<T> {
	private static Logger log = LoggerFactory.getLogger(ImportExcel.class);
	/**
	 * file
	 */
	private File file;

	/**
	 * 工作薄对象
	 */
	protected Workbook workbook;

	/**
	 * 工作表对象
	 */
	private Sheet sheet;
	/**
	 * header行数
	 */
	private int headerNum = 1;
	/**
	 * 数据行数
	 */
	private int dataNum;

	/**
	 * 注解列表（Object[]{ ExcelField, Field/Method }）
	 */
	// List<Object[]> headerList = new ArrayList();

	List<ExcelField> headerList = new ArrayList<>();

	/**
	 * 
	 * @param file
	 * @param headerNum
	 * @param cls
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(File file, int headerNum, Class<?> cls)
			throws InvalidFormatException, IOException {
		this(file.getName(), new FileInputStream(file), headerNum, 0, cls);
		this.file = file;
	}

	/**
	 * 构造函数
	 * 
	 * @param fileName
	 *            导入文件对象
	 * @param headerNum
	 *            标题行号，数据行号=标题行号+1
	 * @param sheetIndex
	 *            工作表编号
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(String fileName, InputStream is, int headerNum,
			int sheetIndex, Class<?> cls) throws InvalidFormatException,
			IOException {
		super();
		checkParam(fileName, is, sheetIndex);
		this.sheet = this.workbook.getSheetAt(sheetIndex);
		this.headerNum = headerNum;
		initExcelHeaderCell(cls);
		log.debug("Initialize success.");
	}



	private void initExcelHeaderCell(Class<?> cls) {
		// Get annotation field
		Field[] fs = cls.getDeclaredFields();
		for (Field f : fs) {
			ExcelField ef = f.getAnnotation(ExcelField.class);
			if (ef != null) {
				headerList.add(ef);
			}
		}
		Collections.sort(headerList, new Comparator<ExcelField>() {
			/**
			 * 排序
			 */
			public int compare(ExcelField ef1, ExcelField ef2) {
				return ef1.sort() - ef2.sort();
			};
		});

	}

	private void checkParam(String fileName, InputStream is, int sheetIndex) {
		try {
			if (StringUtils.isBlank(fileName)) {
				throw new RuntimeException("common.message.upload_file_error");
			} else if (fileName.toLowerCase().endsWith("xls")) {
				this.workbook = new HSSFWorkbook(is);
			} else if (fileName.toLowerCase().endsWith("xlsx")) {
				this.workbook = new XSSFWorkbook(is);
			} else {
				throw new RuntimeException("common.message.upload_file_error");
			}
			if (this.workbook.getNumberOfSheets() < sheetIndex) {
				throw new RuntimeException("common.message.upload_file_error");
			}
		} catch (Exception e) {
			IOUtils.closeQuietly(is);
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 获取行对象
	 * 
	 * @param rownum
	 * @return
	 */
	public Row getRow(int rownum) {
		return this.sheet.getRow(rownum);
	}

	/**
	 * 获取数据行号
	 * 
	 * @return
	 */
	public int getDataRowNum() {
		return dataNum + headerNum + 1;
	}

	/**
	 * 获取最后一个数据行号
	 * 
	 * @return
	 */
//	public int getLastDataRowNum() {
//		if (dataNum == Constant.ZERO) {
//			return this.sheet.getLastRowNum() + headerNum + 1;
//		} else {
//			return this.sheet.getLastRowNum() + headerNum;
//		}
//
//	}
	public int getLastDataRowNum() {
		return this.sheet.getLastRowNum()+headerNum;
	}

	/**
	 * 获取
	 * 
	 * @return
	 */
	public String getTargetCellValue(int row, int column) {
		Row targetRow = sheet.getRow(column);
		return getCellValue(targetRow, column, true) + "";
	}

	/**
	 * 获取最后一个列号
	 * 
	 * @return
	 */
	public int getLastCellNum() {
		return this.getRow(headerNum).getLastCellNum();
	}

	/**
	 * 获取单元格值
	 * 
	 * @param row
	 *            获取的行
	 * @param column
	 *            获取单元格列号
	 * @param string
	 * @return 单元格值
	 */
	public Object getCellValue(Row row, int column, boolean string) {
		Object val = "";
		try {
			Cell cell = row.getCell(column);
			if (cell != null) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					val = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					val = cell.getNumericCellValue();
					if (string && val != null) {
						String str = val.toString();
						str = str.replace(".0", "");
						val = str;
					}
				} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					val = cell.getCellFormula();
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					val = cell.getBooleanCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
					val = cell.getErrorCellValue();
				}
			}
		} catch (Exception e) {
			return val;
		}
		return val;
	}

	/**
	 * 获取导入数据列表
	 * 
	 * @param cls
	 *            导入对象类型
	 * @param groups
	 *            导入分组
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	public List<T> getDataList(Class<T> cls, int... groups)
			throws InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		List<T> dataList = new ArrayList<>();
		if (CollectionUtils.isEmpty(headerList)) {
			return dataList;
		}
		validateImportFileFormat();
		// log.debug("Import column count:"+annotationList.size());
		//备注：改成i <= this.getLastDataRowNum()才能读取到最后一行
		// Get excel data
		for (int i = this.getDataRowNum(); i <= this.getLastDataRowNum(); i++) {
			T model = OrmUtil.createModel(cls);
			int column = 0;
			StringBuilder builder = new StringBuilder();
			for (ExcelField field : headerList) {
				Row row = this.getRow(i);
				// Get param type and type cast
				String valType = field.dataType();
				Object val = this.getCellValue(row, column++,
						isClassType(String.class, valType));
				if (val == null || StringUtils.isEmpty(val.toString())) {
					continue;
				}
				try {
					val = OrmUtil.convertValue(val, valType);
				} catch (Exception ex) {
					ex.printStackTrace();
					String msg = "Get cell value [rows:" + i + ",column"
							+ column + ":'" + field.title() + "'] error: "
							+ ex.getMessage();
					throw new RuntimeException(msg);
				}
				if (val == null) {
					val = "";
				}
				PropertyUtils.setProperty(model, field.property(), val);
				builder.append(val).append(", ");
			}
			dataList.add(model);
			log.debug("Read success: [" + i + "] " + builder.toString());
		}
		try {
			if (file != null && file.exists()) {
				file.delete();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return dataList;
	}

	// 不同国际化导出导入，title不会匹配，不同语言条件的导入导出也不会匹配
	private void validateImportFileFormat() {
		Row row = this.getRow(this.headerNum);
		int column = 0;
		for (ExcelField cell : headerList) {
			String headTitle = cell.title();
			Object val = this.getCellValue(row, column++, true);
			if (val == null || !val.toString().equals(headTitle)) {
				String temp = "common.message.upload_file_title_error";
				throw new RuntimeException(String.format(temp, val, headTitle));
			}
		}
		Object val = this.getCellValue(row, column++, true);
		if (val != null && StringUtils.isNotEmpty(val.toString())) {
			String temp = "common.message.upload_file_title_error";
			throw new RuntimeException(String.format(temp, val, ""));
		}
	}

	/**
     * 是否为class类型
     * 
     * @param clazz
     * @param className
     * @return
     */
    public static boolean isClassType(Class<?> clazz, String className) {
        if (clazz == null) {
            return false;
        }
        return clazz.getName().equals(className);
    }
}
