package InnerClass.privateInnerClass;

/**
 * 私有内部类
 *
 * <P>
 *    如果一个内部类只希望被外部类中的方法操作，那么可以使用private声明内部类
 *    也就是说，此时的内部类只有外部类可控制,如同是，我的心脏只能由我的身体控制，其他人无法直接访问它
 * </P>
 *
 * Created by daiwei on 2017/12/18.
 */
public class Out {
    private  int age = 12;

    private class In {
        public void print() {
            System.out.println(age);
        }
    }

    public void outPrint() {
        new In().print();
    }



}
