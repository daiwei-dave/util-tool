package DesignPatterns.AdaperPatterns.ClassAdapter;


/**
 * 类适配器
 * @author daiwei
 * @date 2018/11/26 13:49
 */
public class Client {
    public static void main(String[] args) {
        Adapter adapter=new Adapter();
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }
}
