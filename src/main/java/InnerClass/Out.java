package InnerClass;

/**
 * Created by daiwei on 2017/12/18.
 */
public class Out {
    private int age = 12;

    class In {
        private int age = 13;
        public void print() {
            int age = 14;
            System.out.println("局部变量：" + age);
            System.out.println("内部类变量：" + this.age);
            System.out.println("外部类变量：" + Out.this.age);
        }
    }

    public static void main(String[] args) {
        Out.In in = new Out().new In();
        in.print();
    }

}
