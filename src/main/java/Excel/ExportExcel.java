package Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by daiwei on 2017/6/26.
 */
public class ExportExcel {
    /**
     * @Description 将成员变量类型为float、double、Float、Double的，保留3位小数
     * 参考自：http://blog.csdn.net/WSKinght/article/details/43054343
     * @author wangjie
     * @date 2017/6/22
     * @params
     */
//    public void format3Decimal() {
//        //设定格式
//        final DecimalFormat df = new DecimalFormat(".000");
//        //获取实体类的所有属性，返回Field数组
//        Field[] fields = this.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            //不进行java语法检查
//            field.setAccessible(true);
//            String name = field.getName();    //获取属性的名字
//            name = name.substring(0, 1).toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
//            String type = field.getGenericType().toString();    //获取属性的类型
//            if (!type.equals("float") && !type.equals("double") &&
//                    !type.equals("class java.lang.Float") && !type.equals("class java.lang.Double")) {
//                continue;
//            }
//
//            try {
//                //获取类的方法
//                Method get = this.getClass().getMethod("get" + name);
//                if (type.equals("float")) {
//                    //通过方法名和参数类型获取方法
//                    Method set = this.getClass().getMethod("set" + name, float.class);
//                    //调用get方法获得返回值
//                    float value = (float) get.invoke(this);
//                    //调用set方法设置值
//                    set.invoke(this, Float.valueOf(df.format(value)));
//                } else if (type.equals("class java.lang.Float")) {
//                    Method set = this.getClass().getMethod("set" + name, java.lang.Float.class);
//                    float value = (float) get.invoke(this);
//                    set.invoke(this, Float.valueOf(df.format(value)));
//                } else if (type.equals("double")) {
//                    Method set = this.getClass().getMethod("set" + name, double.class);
//                    double value = (double) get.invoke(this);
//                    set.invoke(this, Double.valueOf(df.format(value)));
//                } else if (type.equals("class java.lang.Double")) {
//                    Method set = this.getClass().getMethod("set" + name, java.lang.Double.class);
//                    double value = (double) get.invoke(this);
//                    set.invoke(this, Double.valueOf(df.format(value)));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }


    /**
     * 将map中的数据存于list集合中
     * @param potAlumDtoMap
     * @return
     */
//    private List<Map<String, Object>> createList(Map<String, PotAlumIndicateInfoDto> potAlumDtoMap) {
//        if (null == potAlumDtoMap) {
//            return null;
//        }
//        String[] keys = {"id", "noiseRatio", "noiseRatioWeight", "fillQuant", "fillQuantWeight",
//                "elecLevel", "elecLevelWeight", "alumLevelUpper", "alumLevelStandard", "alumLevelFloor",
//                "alumLevelAvgThisWeek", "alumLevelWeight", "electrolyteInoutDay", "elecInoutDayWeight", "fireEye",
//                "fireEyeWeight", "totalWeight", "elecEffPreWeek", "elecEffCurMonth", "elecEffCurYear",
//                "aluminum", "aluminumDate", "columnCathode", "avgVolPreWeek", "aluminumHint", "aluminumAmend", "aluminaSet"};
//        String[] excelHeader = {"槽号", "噪声值(mv)", "噪声值权重", "氧化铝下料量(kg)", "氧化铝下料量权重",
//                "电解质水平(cm)", "电解质水平权重", "铝水平上限", "铝水平基准值", "铝水平下限",
//                "本周平均铝水平", "铝水平权重", "电解质进出天数", "电解质进出权重", "火眼个数",
//                "火眼个数权重", "总权重", "上周电流效率", "本月电流效率", "年度累计电流效率",
//                "在产铝量", "在产铝盘存日期", "全槽炉底压降", "上周平均电压", "出铝指示量", "修正值", "氟化铝设定值"};
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("fileName", "出铝指示" + new Date().getTime());
//        model.put("sheetName", "表一");
//        model.put("title", "出铝指示");
//        model.put("keys", keys);
//        model.put("excelHeader", excelHeader);
//        list.add(model);
//
//        for (PotAlumIndicateInfoDto potAlumIndicateInfoDto : potAlumDtoMap.values()) {
//
//            potAlumIndicateInfoDto.format3Decimal();
//
//            Map<String, Object> map = new LinkedHashMap<String, Object>();
//            if (potAlumIndicateInfoDto.getId() == null) {
//                map.put("id", "平均值");
//            } else {
//                map.put("id", potAlumIndicateInfoDto.getId());
//            }
//            map.put("noiseRatio", potAlumIndicateInfoDto.getNoiseRatio());
//            map.put("noiseRatioWeight", potAlumIndicateInfoDto.getNoiseRatioWeight());
//            map.put("fillQuant", potAlumIndicateInfoDto.getFillQuant());
//            map.put("fillQuantWeight", potAlumIndicateInfoDto.getFillQuantWeight());
//
//
//            map.put("elecLevel", potAlumIndicateInfoDto.getElecLevel());
//            map.put("elecLevelWeight", potAlumIndicateInfoDto.getElecLevelWeight());
//            map.put("alumLevelUpper", potAlumIndicateInfoDto.getAlumLevelUpper());
//            map.put("alumLevelStandard", potAlumIndicateInfoDto.getAlumLevelStandard());
//            map.put("alumLevelFloor", potAlumIndicateInfoDto.getAlumLevelFloor());
//
//
//            map.put("alumLevelAvgThisWeek", potAlumIndicateInfoDto.getAlumLevelAvgThisWeek());
//            map.put("alumLevelWeight", potAlumIndicateInfoDto.getAlumLevelWeight());
//            map.put("electrolyteInoutDay", potAlumIndicateInfoDto.getElectrolyteInoutDay());
//            map.put("elecInoutDayWeight", potAlumIndicateInfoDto.getElecInoutDayWeight());
//            map.put("fireEye", potAlumIndicateInfoDto.getFireEye());
//
//
//            map.put("fireEyeWeight", potAlumIndicateInfoDto.getFireEyeWeight());
//            map.put("totalWeight", potAlumIndicateInfoDto.getTotalWeight());
//            map.put("elecEffPreWeek", potAlumIndicateInfoDto.getElecEffPreWeek());
//            map.put("elecEffCurMonth", potAlumIndicateInfoDto.getElecEffCurMonth());
//            map.put("elecEffCurYear", potAlumIndicateInfoDto.getElecEffCurYear());
//
//
//            map.put("aluminum", potAlumIndicateInfoDto.getAluminum());
//            map.put("aluminumDate", potAlumIndicateInfoDto.getAluminumDate());
//            map.put("columnCathode", potAlumIndicateInfoDto.getColumnCathode());
//            map.put("avgVolPreWeek", potAlumIndicateInfoDto.getAvgVolPreWeek());
//            map.put("aluminumHint", potAlumIndicateInfoDto.getAluminumHint());
//            map.put("aluminumAmend", potAlumIndicateInfoDto.getAluminumAmend());
//            map.put("aluminaSet", potAlumIndicateInfoDto.getAluminaSet());
//
//
//            list.add(map);
//        }
//        return list;
//    }

    /**
     * 导出excel
     * @param response
     * @param list
     * @return
     * @throws IOException
     */
//    private boolean exportExcel(HttpServletResponse response, List<Map<String, Object>> list) throws IOException {
//        //将文件名进行编码
//        String fileName = URLEncoder.encode(list.get(0).get("fileName").toString());
//        String[] excelHeader = (String[]) list.get(0).get("excelHeader");
//        String[] keys = (String[]) list.get(0).get("keys");
//        String title = list.get(0).get("title").toString();
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            //设置excel表样式
//            ExcelUtils.createWorkBoot(title, excelHeader, list, keys).write(baos);
//        } catch (IOException e) {
//            logger.error("获取智能应用-出铝指示-将workbook中信息写入输出流时失败，导出excel失败：{}", e);
//            return false;
//        }
//        byte[] content = baos.toByteArray();
//        InputStream is = new ByteArrayInputStream(content);
//        //刷新
//        response.reset();
//        //设置ContentType为导出excel
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            //设置Header
//            response.setHeader("Content-Disposition", "attachment;filename="
//                    + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
//            //获得servlet输出流
//            ServletOutputStream sos = response.getOutputStream();
//            bis = new BufferedInputStream(is);
//            bos = new BufferedOutputStream(sos);
//            //对字节进行读写
//            byte[] buff = new byte[2048];
//            int byteRead = 0;
//            while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, byteRead);
//            }
//        } catch (IOException e) {
//            logger.error("获取智能应用-出铝指示-创建excel文件时失败：{}", e);
//            return false;
//        } finally {
//            if (bos != null)
//                bos.close();
//            if (bis != null)
//                bis.close();
//            if (is != null)
//                is.close();
//            if (baos != null)
//                baos.close();
//        }
//        return true;
//    }



}


/**
 * @Description
 * @Author wangjie
 * @Date 2017/6/20
 */
//public class ExcelUtils {
//    private static final Logger LOG = LoggerFactory.getLogger(ExcelUtils.class);
//
//    /**
//     * 创建一个excel文件
//     */
//    public static Workbook createWorkBoot(String title,
//                                          String[] excelHeader, List<Map<String, Object>> list, String[] keys) {
//        Workbook workbook = new HSSFWorkbook();
//        //设置sheet的名字
//        Sheet sheet = workbook.createSheet(list.get(0).get("sheetName").toString());
//        /*设置表格宽度*/
//        for (int i = 0; i < keys.length; i++) {
//            sheet.setColumnWidth(i, 35 * 150);
//        }
//
//        /*font样式设置字体大小,是否加粗*/
//        Font titleFont = createFont(workbook, (short) 20, true);
//        Font headerFont = createFont(workbook, (short) 12, true);
//        Font bodyFont = createFont(workbook, (short) 12, false);
//
//
//        /*cell通用样式*/
//        CellStyle titleStyle = createStyle(workbook, titleFont);
//        CellStyle headerStyle = createStyle(workbook, headerFont);
//        CellStyle bodyStyle = createStyle(workbook, bodyFont);
//
//        // excel中当前行索引
//        int index = 0;
//        /*合并标题的单元格设置标题信息及样式 */
//        sheet.addMergedRegion(new CellRangeAddress(index, index, index,
//                excelHeader.length - 1));
//        Row titleRow = sheet.createRow(index++);
//        Cell titleCell = titleRow.createCell(0);
//        titleCell.setCellValue(title);
//        titleCell.setCellStyle(titleStyle);
//
//        /*设置表格头信息及样式*/
//        Row headerRow = sheet.createRow(index++);
//        for (int i = 0; i < excelHeader.length; i++) {
//            Cell headerCell = headerRow.createCell(i);
//            headerCell.setCellValue(excelHeader[i]);
//            headerCell.setCellStyle(headerStyle);
//        }
//
//        /*设置每行每 列的值及样式
//         *Row为行,cell为方格
//         *创建i*j个方格并设置对应的属性值*/
//        for (int i = 1; i < list.size(); i++) {
//            Row bodyRow = sheet.createRow(index++);
//            for (int j = 0; j < keys.length; j++) {
//                Cell bodyCell = bodyRow.createCell(j);
//                bodyCell.setCellValue(list.get(i).get(keys[j]) == null ?
//                        " " : list.get(i).get(keys[j]).toString());
//                bodyCell.setCellStyle(bodyStyle);
//            }
//        }
//        return workbook;
//    }
//
//    /**
//     * 设置字体大小，颜色，样式，是否加粗
//     */
//    private static Font createFont(Workbook workbook,
//                                   short fontHeightInPoints, boolean isBlod) {
//        Font font = workbook.createFont();
//        //字体大小
//        font.setFontHeightInPoints(fontHeightInPoints);
//        //字体颜色
//        font.setColor(IndexedColors.BLACK.getIndex());
//        //字体样式
//        font.setFontName("宋体");
//        //是否加粗
//        //    font.setBold(isBlod);
//        return font;
//    }
//
//    /**
//     * 设置字体居中显示，背景色，边框
//     */
//    private static CellStyle createStyle(Workbook workbook, Font font) {
//        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFont(font);
//        //居中
//        //    cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        //背景颜色
//        cellStyle.setFillForegroundColor(IndexedColors.WHITE.index);
//        cellStyle.setFillBackgroundColor(IndexedColors.WHITE.index);
//        //    cellStyle.setFillPattern(FillPatternType.FINE_DOTS);
//        //边框
////        cellStyle.setBorderBottom(BorderStyle.THIN);
////        cellStyle.setBorderLeft(BorderStyle.THIN);
////        cellStyle.setBorderRight(BorderStyle.THIN);
////        cellStyle.setBorderTop(BorderStyle.THIN);
//        return cellStyle;
//    }



//}

