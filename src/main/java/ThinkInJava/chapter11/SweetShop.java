package ThinkInJava.chapter11;

/**
 * <P>
 *     new是在编译时就要检查.class类型和路径
 *class.forName("xxxx").newInstance() 是在运行时找到该路径的类进行实列化 相当于先检查路径然后再实列化。
 * </P>
 * Created by daiwei on 2018/1/4.
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("ThinkInJava.chapter11.Gum");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(
                "After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}