package Collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daiwei on 2017/12/12.
 *
 * @sees https://www.cnblogs.com/xrq730/p/4989451.html
 */
public class ArrayListTest {
    public static void main(String[] args)
    {
//        add();
//        remove();

        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }

        }

    private static void remove() {
        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        list.add("777");
        list.add("888");
        list.remove("333");
    }

    static void add(){
        List<String> list = new ArrayList<String>();
        list.add("000");
        list.add("111");
    }

}
