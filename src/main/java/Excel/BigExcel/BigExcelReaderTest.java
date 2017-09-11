package Excel.BigExcel;


import java.util.Arrays;

/**
 * java解析大数据量的excel
 * @seehttp://blog.csdn.net/zp19890228/article/details/41822617
 * @seehttp://blog.csdn.net/luka2008/article/details/8203915
 */
public class BigExcelReaderTest {
    public static void main(String[] args) throws Exception{
        String filepath = "d:/竞争力模型-样机管理-201731.xlsx";
 //       BigExcelReader reader = new BigExcelReader(filepath) {
        BigExcelReaderUtil reader=new BigExcelReaderUtil(filepath) {
            @Override
            protected void outputRow(String[] datas, int[] rowTypes, int rowIndex) {
                // 此处输出每一行的数据
                System.out.println(Arrays.toString(datas));
                if (rowIndex==10){
                    return;
                }
//                for (int i = 0; i <datas.length ; i++) {
//                    String s=datas[i];
//                }
            }
        };
        // 执行解析
        reader.parse();

    }
}
