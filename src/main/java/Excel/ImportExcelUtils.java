package Excel;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 仅适用于本地测试，不推荐在其他模块使用
 * Created by daiwei on 2017/2/16.
 */
public class ImportExcelUtils {
//    public static List<CouponUser> read(String path) throws IOException, InvalidFormatException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        List<CouponUser> couponUserList = new ArrayList<>();
//        InputStream fileInputStream = new FileInputStream(path);
//        ImportExcel<CouponUser> couponUserImportExcel = new ImportExcel<CouponUser>(path, fileInputStream, 0, 0, CouponUser.class);
//        couponUserList = couponUserImportExcel.getDataList(CouponUser.class);
//        return couponUserList;
//    }
//    public static void main(String[] args) {
//        try {
//      //      List<CouponUser> couponUserList = ImportExcelUtils.read("d:/poi_test.xlsx");
//            List<CouponUser> couponUserList = ImportExcelUtils.read("d:/导入模板新.xlsx");
//            for (int i = 0; i < couponUserList.size(); i++) {
//                System.out.println(couponUserList.get(i).toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
