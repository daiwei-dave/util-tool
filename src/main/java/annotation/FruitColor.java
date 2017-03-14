package annotation;

import annotation.Enum.Color;

import java.lang.annotation.*;

/**
 * 水果颜色注解
 * Created by daiwei on 2017/3/13.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}
