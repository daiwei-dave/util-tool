package DesignPatterns.ProxyPatterns.cglib;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-proxy-pattern/
 * Created by daiwei on 2017/12/21.
 */
public class TestCglib {
    public static void main(String[] args) {
        BookProxyLib cglib=new BookProxyLib();
        BookProxyImpl bookCglib = (BookProxyImpl) cglib.getInstance(new BookProxyImpl());
        bookCglib.addBook();

    }
}
