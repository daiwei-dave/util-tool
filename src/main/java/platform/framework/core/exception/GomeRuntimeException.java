package platform.framework.core.exception;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/8
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class GomeRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -227961057827878851L;
    protected String code;

    public GomeRuntimeException() {
    }

    public GomeRuntimeException(String code) {
        super(code);
        this.setCode(code);
    }

    public GomeRuntimeException(Throwable t) {
        super(t);
    }

    public GomeRuntimeException(String code, Throwable t) {
        super(t);
        this.setCode(code);
    }

    public GomeRuntimeException(String code, String msg) {
        super(msg);
        this.setCode(code);
    }

    public GomeRuntimeException(String code, String msg, Throwable t) {
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
