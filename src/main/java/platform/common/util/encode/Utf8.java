package platform.common.util.encode;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/9
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Utf8 {
    private static final Charset CHARSET = Charset.forName("UTF-8");

    public Utf8() {
    }

    public static byte[] encode(CharSequence string) {
        try {
            ByteBuffer var3 = CHARSET.newEncoder().encode(CharBuffer.wrap(string));
            byte[] bytesCopy = new byte[var3.limit()];
            System.arraycopy(var3.array(), 0, bytesCopy, 0, var3.limit());
            return bytesCopy;
        } catch (CharacterCodingException var31) {
            throw new IllegalArgumentException("Encoding failed", var31);
        }
    }

    public static String decode(byte[] bytes) {
        try {
            return CHARSET.newDecoder().decode(ByteBuffer.wrap(bytes)).toString();
        } catch (CharacterCodingException var2) {
            throw new IllegalArgumentException("Decoding failed", var2);
        }
    }
}
