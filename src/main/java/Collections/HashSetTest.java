package Collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by daiwei on 2018/1/14.
 */
public class HashSetTest {
    public static void put(){
        Set<String> stringSet=new HashSet<String>();
        stringSet.add("a");
        stringSet.add("b");
        for (String obj: stringSet) {
            System.out.println(obj);
        }
    }
}
