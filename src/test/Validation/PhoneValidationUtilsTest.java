package Validation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author daiwei
 * @date 2018/10/24 10:00
 */
public class PhoneValidationUtilsTest {

    @Test
    public void convertPhone() {
        String str = "1.8428385811e10";
        String phone = PhoneValidationUtils.convertPhone(str);
        System.out.println(phone);
    }
}