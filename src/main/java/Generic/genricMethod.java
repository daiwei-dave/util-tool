package Generic;

/**
 * @Description 泛型方法
 * @Author daiwei
 * @Date 2017/11/14
 * @seehttp://blog.csdn.net/caihuangshi/article/details/51278793
 */
public class genricMethod {
    /**
     * 要定义泛型方法，只需将泛型参数列表置于返回值之前
     * @param t
     * @param <T>
     */
    public static <T> void out(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        out("findingsea");
        out(123);
        out(11.11);
        out(true);
    }
}
