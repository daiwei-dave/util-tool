package Excel.annotations.test;

import Excel.annotations.ImportExcel;
import Excel.entity.CouponUser;
import Validation.PhoneValidationUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daiwei on 2017/7/27.
 */
public class Test {
    /**
     * excel导入
     * @param path
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static List<CouponUser> read(String path) throws IOException, InvalidFormatException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<CouponUser> couponUserList = new ArrayList<CouponUser>();
        InputStream fileInputStream = new FileInputStream(path);
        ImportExcel<CouponUser> couponUserImportExcel = new ImportExcel<CouponUser>(path, fileInputStream, 0, 0, CouponUser.class);
        couponUserList = couponUserImportExcel.getDataList(CouponUser.class);
        return couponUserList;
    }

    /**
     * Excel导入测试
     * @param args
     */
    public static void main(String[] args) {
        try {
            //      List<CouponUser> couponUserList = ImportExcelUtils.read("d:/poi_test.xlsx");
            List<CouponUser> couponUserList = Test.read("d:/导入模板新.xlsx");
            for (int i = 0; i < couponUserList.size(); i++) {
                couponUserList.get(i).setPhone(PhoneValidationUtils.convertPhone(couponUserList.get(i).getPhone()));
                System.out.println(couponUserList.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
