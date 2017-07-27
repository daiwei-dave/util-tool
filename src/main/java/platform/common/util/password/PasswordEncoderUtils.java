package platform.common.util.password;

import java.io.UnsupportedEncodingException;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/9
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class PasswordEncoderUtils {
    public static boolean equals(String expected, String actual) {
        byte[] expectedBytes = bytesUtf8(expected);
        byte[] actualBytes = bytesUtf8(actual);
        int expectedLength = expectedBytes == null?-1:expectedBytes.length;
        int actualLength = actualBytes == null?-1:actualBytes.length;
        if(expectedLength != actualLength) {
            return false;
        } else {
            int result = 0;

            for(int i = 0; i < expectedLength; ++i) {
                result |= expectedBytes[i] ^ actualBytes[i];
            }

            return result == 0;
        }
    }

    private static byte[] bytesUtf8(String s) {
        try {
            return s == null?null:s.getBytes("utf-8");
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private PasswordEncoderUtils() {
    }
}
