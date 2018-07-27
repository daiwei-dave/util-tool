package encryption;


import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author daiwei
 * @date 2018/7/27 11:04
 */
public class EmojiCharacter {



    private final static Logger logger = LoggerFactory.getLogger(EmojiCharacter.class);
    /**
     * 将系统表情转化为字符串
     *
     * @param s
     * @return
     */
    public static String convertEmojiCharacter(String s) {
        logger.info("转换含有表情的字符开始！");
        if (StringUtils.isBlank(s)) {
            return null;
        }
        int length = s.length();
        String context = "";
        //循环遍历字符串，将字符串拆分为一个一个字符
        for (int i = 0; i < length; i++) {
            char codePoint = s.charAt(i);
            //判断字符是否是emoji表情的字符
            if (isEmojiCharacter(codePoint)) {

                String codePointStr = String.valueOf(codePoint);
                String escapeCsv = StringEscapeUtils.escapeJson(codePointStr);
                context = context + escapeCsv;
                continue;
            }
            context = context + codePoint;
        }

        System.out.println(context);
        logger.info("转换含有表情的字符结束[结果为]{}",context);
        return context;
    }




    /**
     * 是否包含表情
     *
     * @param codePoint
     * @return 如果不包含 返回false,包含 则返回true
     */

    private static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }


    public static void main(String[] args) {

        String param="haha\uD83D\uDE0D";
        String result = convertEmojiCharacter(param);
        String unescapeCsv = StringEscapeUtils.unescapeJson(result);
        System.out.println(unescapeCsv);


    }



}
