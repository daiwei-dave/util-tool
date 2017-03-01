package Excel.constant;

/**
 * Created by zhangzhaoyang on 2017/2/11.
 */
public class Consts {

    //投放记录PDF文件名称
    public final static String DISTRIBUTION_FILE_NAME = "年会餐券投放记录";

    //PDF导出投放记录标题
    public final static String[] DISTRIBUTION_RECORD_TITLES = {"券号", "手机号", "姓名", "使用状态"};

    //PDF导出投放记录字段
    public final static String[] DISTRIBUTION_RECORD_COLOMNS = {"serialNo", "phone", "name", "status"};

    //核销记录PDF文件名称
    public final static String CONSUMPTION_FILE_NAME = "年会餐券核销记录";

    //PDF导出核销记录标题
    public final static String[] CONSUMPTION_RECORD_TITLES = {"券号", "手机号", "姓名", "核销时间"};

    //PDF导出核销记录字段
    public final static String[] CONSUMPTION_RECORD_COLOMNS = {"serialNo", "phone", "name", "verifyTime"};

    //餐券用户PDF文件名称
    public final static String COUPON_USER_FILE_NAME = "餐券用户";

    //PDF导出餐券用户标题
    public final static String[] COUPON_USER_TITLES = {"手机号", "姓名", "人员分类", "备注", "签到状态"};

    //PDF导出餐券用户字段
    public final static String[] COUPON_USER_COLOMNS = {"phone", "name", "userGroup", "remark", "status"};

    //核销记录PDF文件名称
    public final static String REPORT_FILE_NAME = "年会餐券平台统计";

    //PDF导出总计标题
    public final static String[] REPORT_TOTAL_RECORD_TITLES = {"建券", "投放张数", "领取张数", "核销张数","过期张数"};

    //PDF导出总计字段
    public final static String[] REPORT_TOTAL_RECORD_COLOMNS = {"category", "distribution", "consumption", "receive","overdue"};

    //PDF导出详细标题
    public final static String[] REPORT_DETAIL_RECORD_TITLES = {"标题", "副标题", "日期", "投放","领取","核销","过期"};

    //PDF导出详细字段
    public final static String[] REPORT_DETAIL_RECORD_COLOMNS = {"title", "subtitle", "validDate","distribution", "consumption", "receive","overdue"};



}
