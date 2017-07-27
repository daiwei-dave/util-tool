package platform.common.util.encryption;

/**
 * Created by zhangzhaoyang on 2017/2/22.
 */
    public class AESException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public AESException() {
        }

        public AESException(Throwable t) {
            super(t);
        }

        public AESException(String msg) {
            super(msg);
        }

        public AESException(String msg, Throwable t) {
            super(msg, t);
        }
    }

