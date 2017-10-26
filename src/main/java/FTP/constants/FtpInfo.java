package FTP.constants;

/**
 * @Description ftp信息
 * @Author wangjie36@gome.com.cn
 * @Date 2017/8/9
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class FtpInfo {
    //   模型数据存放的文件夹名称
 //   public static final String MODULE_DIRECTORY = "/StoreModel/";

    // 模型数据存放的文件夹名称(测试)
    public static final String MODULE_DIRECTORY = "/StoreModel/tmp/";
    // 竞争力模型-标准值
    public static final String MODULE_STANDARD = "竞争力模型-标准值";


    // 竞争力模型-门店标准值
    public static final String MODULE_STANDARD_STORE = "竞争力模型-门店标准值";

    // 竞争力模型-品牌标准值
    public static final String MODULE_STANDARD_BRAND = "竞争力模型-品牌标准值";

    // 竞争力模型-坪效
    public static final String MODULE_AREAEFFICIENCY = "竞争力模型-坪效";


    // 竞争力模型-人效
    public static final String MODULE_PEOPLE_EFFICIENCY = "竞争力模型-人效";


    // 竞争力模型-商品结构
    public static final String MODULE_COMMONDITY_STRUCTURE = "竞争力模型-商品结构";


    // 竞争力模型-样机管理
    public static final String MODULE_PROTOTYPE_MANAGE = "竞争力模型-样机管理";


    // 竞争力模型-指向性品牌
    public static final String MODULE_DIRECTIVITY_BRAND = "竞争力模型-指向性品牌";


    // 未知异常下载失败
    public static final String DOWNLOAD_FAIL = "下载异常";

    // 未知异常下载失败重试时间.1800000为30分钟
    public static final long SLEEP_TIME = 1800000;


    // 服务启动时的时间
    public static final long currentTimeMillisStart = System.currentTimeMillis();

}
