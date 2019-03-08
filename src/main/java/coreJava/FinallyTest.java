package coreJava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daiwei
 * @date 2019/3/8 15:57
 */
public class FinallyTest {
    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();
        cats = query(cats);
        System.out.println("----");
        for (String cat : cats) {
            System.out.println(cat);
        }

    }

    public static List<String> query(List<String> cats) {
        int i = 0;
        try {
            System.out.print("try\n");
            cats.add("xiaoMeng");
            return cats;
        } catch (Exception e) {
            System.out.print("catch\n");
        } finally {
            System.out.print("finally\n");
            cats.add("qiaoGeLi");
        }
        System.out.println("finish");
        return null;
    }
}

