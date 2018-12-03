package jvm.classLoader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author daiwei
 * @date 2018/12/3 15:15
 */
public class TestMyClassLoader {
    public static void main(String []args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
        //自定义类加载器的加载路径
        MyClassLoader myClassLoader=new MyClassLoader("D:\\lib");
        //包名+类名
        Class c=myClassLoader.loadClass("jvm.classLoader.Test");

        if(c!=null){
            Object obj=c.newInstance();
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
}
