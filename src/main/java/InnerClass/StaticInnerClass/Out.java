package InnerClass.StaticInnerClass;

/**
 * 静态内部类
 *
 * <P>
 *    如果用static 将内部内静态化，那么内部类就只能访问外部类的静态成员变量，具有局限性
 * </P>
 *
 * Created by daiwei on 2017/12/18.
 */
public class Out {
    private static int age = 12;

    static class In {
        public void print() {
            System.out.println(age);
        }
    }

    public static void main(String[] args) {
        Out.In in = new Out.In();
        in.print();
    }

}
