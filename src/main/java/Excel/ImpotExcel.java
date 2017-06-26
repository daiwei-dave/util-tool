package Excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Description excel导入
 * @author daiwei
 * @date 2017/6/22
 * @params
 * 参考： http://blog.csdn.net/zhengxiangwen/article/details/68484857
 */
public class ImpotExcel {

    //1.controller

    /**
     * @Description 单槽数据导入excel
     * @author daiwei
     * @date 2017/6/22
     * @params
     */
//    @RequestMapping(value = "/importProcePotExcel", method = RequestMethod.POST)
//    public ResultData importProcePotExcel(@RequestParam(value="uploadFile") MultipartFile file) {
//        //获取文件名
//        String fileName=file.getOriginalFilename();
//        //批量导入
//        return intlAlumHintFacade.importProcePotExcel(fileName,file);
//    }


    //2.service

    /**
     *
     * @param fileName 文件名
     * @param file  文件
     * @return
     */
//    public ResultData importProcePotExcel(String fileName, MultipartFile file) {
//        //判断文件是否为空
//        if (file == null) {
//            logger.error("文件不能为空");
//            return ResultData.newResultData(ErrorCode.FAILOR, "文件不能为空");
//        }
//        //验证文件名是否合格
//        if (!ExcelImportUtils.validateExcel(fileName)) {
//            logger.error("文件必须是excel格式！");
//            return ResultData.newResultData(ErrorCode.FAILOR, "文件必须是excel格式！");
//        }
//        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
//        long size = file.getSize();
//        if (StringUtils.isEmpty(fileName) || size == 0) {
//            logger.error("文件不能为空！");
//            return ResultData.newResultData(ErrorCode.FAILOR, "文件不能为空！");
//        }
//
//        //初始化输入流
//        InputStream is = null;
//        try {
//            //根据版本选择创建Workbook的方式
//            Workbook wb = null;
//
//            //根据文件名判断文件是2003版本还是2007版本
//            if (ExcelImportUtils.isExcel2007(fileName)) {
//                wb = new XSSFWorkbook(file.getInputStream());
//            } else {
//                wb = new HSSFWorkbook(file.getInputStream());
//            }
//            //根据excel里面的内容读取知识库信息
//            List<ProcePotInput> procePotInputList = readExcelValue(wb);
//            return ResultData.newResultData(ErrorCode.SUCCESS, "导入成功", procePotInputList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    is = null;
//                    e.printStackTrace();
//                }
//            }
//        }
//        return ResultData.newResultData(ErrorCode.FAILOR, "导入出错！请检查数据格式！");
//    }


    /**
     * 读取excel数据
     * @param wb
     * @param tempFile
     * @return 读取的结果
     */
//    private List<ProcePotInput> readExcelValue(Workbook wb, File tempFile) {
//        //错误信息接收器
//        String errorMsg = "";
//        //得到第一个shell
//        Sheet sheet = wb.getSheetAt(0);
//        //得到Excel的行数
//        int totalRows = sheet.getLastRowNum();
//        //总列数
//        int totalCells = 0;
//        //得到Excel的列数(前提是有行数)，从第二行算起
//        if (totalRows >= 2 && sheet.getRow(1) != null) {
//            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
//        }
//        List<ProcePotInput> ProcePotInputList = new ArrayList<ProcePotInput>();
//        ProcePotInput procePotInput;
//        String br = "<br/>";
//        //循环Excel行数,从第二行开始。标题不入库
//        for (int r = 1; r <= totalRows; r++) {
//            String rowMessage = "";
//            Row row = sheet.getRow(r);
//            if (row == null) {
//                errorMsg += br + "第" + (r + 1) + "行数据有问题，请仔细检查！";
//                continue;
//            }
//            procePotInput = new ProcePotInput();
//            String alumPotId = "";
//            String recDate = "";
//            //循环Excel的列
//            for (int c = 0; c < totalCells; c++) {
//                Cell cell = row.getCell(c);
//                if (null != cell) {
//                    //设置类型这样就可以读取numeric cell
//                    cell.setCellType(Cell.CELL_TYPE_STRING);
//
//                    if (StringUtils.isEmpty(cell.getStringCellValue())) {
//                        continue;
//                    }
//
//                    if (c == 0) {
//                        alumPotId = cell.getStringCellValue();
//                        procePotInput.setAlumPotId(alumPotId);
//                    } else if (c == 1) {
//                        recDate = cell.getStringCellValue();
//                        procePotInput.setRecDate(recDate);
//                    } else if (c == 2) {
//                        Float columnCathodeDrop = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setColumnCathodeDrop(columnCathodeDrop);
//                    } else if (c == 3) {
//                        Float alumWip = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setAlumWip(alumWip);
//                    } else if (c == 4) {
//                        Float electrolyteInoutS1 = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setElectrolyteInoutS1(electrolyteInoutS1);
//                    } else if (c == 5) {
//                        Float electrolyteInoutS2 = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setElectrolyteInoutS2(electrolyteInoutS2);
//                    } else if (c == 6) {
//                        Float electrolyteInoutS3 = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setElectrolyteInoutS3(electrolyteInoutS3);
//                    } else if (c == 7) {
//                        Float fireEyeS1 = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setFireEyeS1(fireEyeS1);
//                    } else if (c == 8) {
//                        Float fireEyeS2 = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setFireEyeS2(fireEyeS2);
//                    } else if (c == 9) {
//                        Float fireEyeS3 = Float.valueOf(cell.getStringCellValue());
//                        procePotInput.setFireEyeS3(fireEyeS3);
//                    }
//                }
//            }
//            //删除上传的临时文件
//            if (tempFile.exists()) {
//                tempFile.delete();
//            }
//            ProcePotInputList.add(procePotInput);
//        }
//        //删除上传的临时文件
//        if (tempFile.exists()) {
//            tempFile.delete();
//        }
//        //全部验证通过才导入到数据库
//        if (StringUtils.isEmpty(errorMsg)) {
//            for (ProcePotInput potInput : ProcePotInputList) {
//                //        this.saveUserKnowledge(userKnowledgeBase, userName);
//            }
//            errorMsg = "导入成功，共" + ProcePotInputList.size() + "条数据！";
//        }
//        return ProcePotInputList;
//    }

    //3.工具类
    /**
     * 判断excel的版本
     */
//    public class ExcelImportUtils {
//        // @描述：是否是2003的excel，返回true是2003
//        public static boolean isExcel2003(String filePath)  {
//            return filePath.matches("^.+\\.(?i)(xls)$");
//        }
//        //@描述：是否是2007的excel，返回true是2007
//        public static boolean isExcel2007(String filePath)  {
//            return filePath.matches("^.+\\.(?i)(xlsx)$");
//        }
//
//        /**
//         * 验证EXCEL文件
//         * @param filePath
//         * @return
//         */
//        public static boolean validateExcel(String filePath){
//            if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){
//                return false;
//            }
//            return true;
//        }
//    }

}
