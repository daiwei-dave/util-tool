package InnerClass.MethodInnerClass;

/**
 * 方法内部类
 *
 * <p>
 *     即在方法中包含一个Class
 * </p>
 *
 * Created by daiwei on 2017/12/18.
 */
public class Out {
    private int age = 12;

    public void Print(final int x) {
        class In {
            public void inPrint() {
                System.out.println(x);
                System.out.println(age);
            }
        }
        new In().inPrint();
    }

    public static void main(String[] args) {
        Out out = new Out();
        out.Print(3);
    }

}
