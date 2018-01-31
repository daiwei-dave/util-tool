package Generic.genericInterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daiwei on 2017/12/28.
 */
public class FruitGeneratorTest {
    @Test
    public void next() throws Exception {
        FruitGenerator generator = new FruitGenerator();
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
    }





    @Test
    public void mytest() throws Exception {
        ArrayList list = new ArrayList();
        System.out.println(list instanceof List);
    }







}