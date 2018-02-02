package NIO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daiwei on 2018/2/2.
 */
public class demoTest {
    @Test
    public void client() throws Exception {
        demo.client();
    }

    @Test
    public void server() throws Exception {
        demo.server();
    }

    @Test
    public void method1() throws Exception {
        demo.method1();
    }

    @Test
    public void method2() throws Exception {
        demo.method2();
    }

}