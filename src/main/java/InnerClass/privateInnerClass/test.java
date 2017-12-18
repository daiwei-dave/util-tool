package InnerClass.privateInnerClass;

/**
 * Created by daiwei on 2017/12/18.
 */
public class test {
    public static void main(String[] args) {
        //此方法无效
//        Out.In in = new Out().new In();
//        in.print();

        Out out = new Out();
        out.outPrint();

    }
}
