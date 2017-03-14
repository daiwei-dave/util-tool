package annotation.com.dw;

import annotation.Enum.Color;
import annotation.FruitColor;
import annotation.FruitName;
import annotation.FruitProvider;

import java.lang.reflect.Field;


/**
 * 注解使用
 * Created by daiwei on 2017/3/13.
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;


    @FruitColor(fruitColor= Color.RED)
    private String appleColor;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }

    /**
     * 注解处理器
     * Created by daiwei on 2017/3/14.
     */
    public static class AppleInfoUtil {
        public static void getFruitInfo(Class<?> clazz){
            String strFruitName=" 水果名称：";
            String strFruitColor=" 水果颜色：";
            String strFruitProvicer="供应商信息：";

            Field[] fields=clazz.getDeclaredFields();
            for(Field field:fields) {
                if (field.isAnnotationPresent(FruitName.class)){//判断是否存在FruitName注解，有返回 true，否则返回 false。        //获取FruitNamed的注解
                FruitName fruitName=field.getAnnotation(FruitName.class);
                //获取注解的值
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
                }else if (field.isAnnotationPresent(FruitColor.class)){
                    FruitColor fruitColor= field.getAnnotation(FruitColor.class);
                    //获取注解中的某个元素的值
                    strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                    System.out.println(strFruitColor);
                } else if(field.isAnnotationPresent(FruitProvider.class)){
                    FruitProvider fruitProvider=field.getAnnotation(FruitProvider.class);
                    strFruitProvicer=" 供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                    System.out.println(strFruitProvicer);
                }
            }

        }
    }

    /**
     * 输出结果
     * @param args
     */
    public static void main(String[] args) {
        AppleInfoUtil.getFruitInfo(Apple.class);
    }
}
