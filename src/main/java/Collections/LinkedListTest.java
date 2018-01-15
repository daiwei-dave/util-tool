package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList底层原理可参考：http://www.cnblogs.com/ITtangtang/p/3948610.html
 * Created by daiwei on 2017/12/28.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("111");
        list.add("222");
    }

    public void iteratorTest(){
        List<String> staff = new LinkedList<String>(); // LinkedList implements List
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        Iterator<String> iter = staff.iterator();
        String first = iter.next(); // visit first element
        String second = iter.next(); // visit second element
        iter.remove(); // remove last visited element
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
