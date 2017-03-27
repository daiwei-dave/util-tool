package Validation;



import Validation.entity.ErrorCode;
import Validation.entity.ResultData;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by daiwei on 2017/2/22.
 */
public class ValidationUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static ResultData validate(Object entity) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(entity);
        if (null != constraintViolations && constraintViolations.size() > 0) {
            for(Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator(); iterator.hasNext();){
                ConstraintViolation violation = iterator.next();
                //只返回第一条错误提示信息
                return ResultData.newResultData(ErrorCode.FAILOR, violation.getMessage());
            }

        }
        return ResultData.newSuccessResultData();
    }

}
