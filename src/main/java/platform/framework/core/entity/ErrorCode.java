package platform.framework.core.entity;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/8
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class ErrorCode {

  public  static final String SUCCESS = "0";
  public  static final String SUCCESS_MSG = "SUCCESS";
  public  static final String FAILOR = "9999";
  public  static final String FAILOR_MSG = "操作失败";
  public  static final String TIMEOUT = "9988";
  public  static final String TIMEOUT_MSG = "您尚未登录或登录时间过长,请重新登录";
  public  static final String HAS_NO_AUTHOR = "您没有足够的权限执行该操作";
  public  static final String PAGE_FAILOR = "9000";
  public  static final String PAGE_FAILOR_MSG = "分页参数为空";
  public  static final String ADD_FAILOR = "9901";
  public  static final String ADD_FAILOR_MSG = "新增操作失败";
  public  static final String DEL_FAILOR = "9902";
  public  static final String DEL_FAILOR_MSG = "删除操作失败";
  public  static final String QUERY_FAILOR = "9903";
  public  static final String QUERY_FAILOR_MSG = "查询操作失败";
  public  static final String UPDATE_FAILOR = "9904";
  public  static final String UPDATE_FAILOR_MSG = "更新操作失败";
  public  static final String DEL_ID_FAILOR = "9905";
  public  static final String DEL_ID_FAILOR_MSG = "删除ID为空";
  public  static final String VALIDATION_ERROR = "1000";
}
