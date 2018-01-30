package Collections;


import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 参考：http://www.cnblogs.com/CarpenterLee/p/5541111.html
 * Created by daiwei on 2018/1/14.
 */
public class LinkedHashSetTest {
    public static void put(){
        Set<String> stringSet=new LinkedHashSet<String>();
        stringSet.add("a");
        stringSet.add("b");
        for (String obj: stringSet) {
            System.out.println(obj);
        }
    }
}
