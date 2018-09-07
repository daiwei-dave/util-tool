package Collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by daiwei on 2018/1/14.
 */
public class HashSetTest {


    String a;

    public HashSetTest(String a) {
        this.a = a;
    }


    @Override
    public int hashCode() {

        return 123 * 31 + a.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        HashSetTest test = (HashSetTest) o;
        return test.a.equals(this.a);
    }


    public static void main(String[] args) {

        Set set = new HashSet();

        HashSetTest o1 = new HashSetTest("abc");
        HashSetTest o2 = new HashSetTest("abc");

        set.add(o1);
        set.add(o2);

        System.out.println(o1.equals(o2));
        System.out.println(set.size());

    }


    public static void put(){
        Set<String> stringSet=new HashSet<String>();
        stringSet.add("a");
        stringSet.add("b");
        for (String obj: stringSet) {
            System.out.println(obj);
        }
    }
}
