package platform.framework.core.exception;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/8
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class GomeBusinessException extends Exception {
    private static final long serialVersionUID = 1L;
    protected String code;

    public GomeBusinessException() {
    }

    public GomeBusinessException(String code) {
        super(code);
        this.setCode(code);
    }

    public GomeBusinessException(Throwable t) {
        super(t);
    }

    public GomeBusinessException(String code, Throwable t) {
        super(t);
        this.setCode(code);
    }

    public GomeBusinessException(String code, String msg) {
        super(msg);
        this.setCode(code);
    }

    public GomeBusinessException(String code, String msg, Throwable t) {
        super(msg, t);
        this.setCode(code);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
