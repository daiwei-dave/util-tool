package annotation;

import java.lang.annotation.*;

/**
 * 水果名称注解
 * Created by daiwei on 2017/3/13.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
