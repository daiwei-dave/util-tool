package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java 正则表达式使用
 * @author daiwei
 * @date 2018/9/28 11:09
 */
public class RegularExpression {


    public static void main(String[] args) {


        checkPunctuation();


    }


    /**
     * java判断标点符号问题
     * @sees https://www.xuebuyuan.com/1911739.html
     */
    private static void checkPunctuation() {
        Pattern patPunc = Pattern
                .compile("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
        String str = "ab,c";


        Matcher matcher = patPunc.matcher(str);

        System.out.println(matcher.find());
    }
}
