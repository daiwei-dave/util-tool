package reflect.constructor;

/**
 * Created by daiwei on 2018/3/29.
 * @sees https://www.cnblogs.com/ktlshy/p/4716838.html
 */
public class Constructor {
    public static void main(String[] args) throws Exception {
//        createUser1();
        createUser2();
    }

    private static void createUser2()throws Exception {
        Class clazz=Class.forName("reflect.User");
        final java.lang.reflect.Constructor constructor = clazz.getConstructor(new Class[]{});
        Object obj = constructor.newInstance(new Object[]{});
        System.out.println(obj);
    }

    /**
     *指定构造参数的类型
     * @throws Exception
     */
    private static void createUser1() throws Exception {
        Class clazz=Class.forName("reflect.User");
        java.lang.reflect.Constructor constructor = clazz.getConstructor(String.class, String.class, int.class);
        Object obj = constructor.newInstance("daiwei", "123456", 22);
        System.out.println(obj.toString());
    }
}
