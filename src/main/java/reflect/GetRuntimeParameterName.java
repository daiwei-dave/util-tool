package reflect;

import org.apache.ibatis.annotations.Param;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @sees 在Java 8中获取参数名称https://www.liaoxuefeng.com/article/00141999088629621039ee8c4614579bfedb78a5030bce3000
 * @sees Java——通过反射获取函数参数名称https://blog.csdn.net/revitalizing/article/details/71036970
 * @author daiwei
 * @date 2018/9/19 15:45
 */
public class GetRuntimeParameterName {
    public void createUser(@Param("name") String name, int age, int version) {
        //
    }

    public static void main(String[] args) throws Exception {
        for (Method m : GetRuntimeParameterName.class.getMethods()) {
            System.out.println("----------------------------------------");
            System.out.println("   method: " + m.getName());
            System.out.println("   return: " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                Annotation[] annotations = p.getAnnotations();
                Param param = p.getAnnotation(Param.class);
                if (param!=null){
                    String value = param.value();
                    System.out.println(value);
                }


                System.out.println(p.getAnnotations());
                System.out.println("parameter: " + p.getType().getName() + ", " + p.getName());
            }
        }
    }
}
