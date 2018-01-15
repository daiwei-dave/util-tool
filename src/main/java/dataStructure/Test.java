package dataStructure;

/**
 * Created by daiwei on 2017/11/12.
 */
public class Test {
    public static void main(String[] args) {
   //     test01();
        test02();

    }

    /**
     * Integer的值若在-128到127之间，则会return IntegerCache.cache[i + (-IntegerCache.low)];
     * 即直接引用常量池中的Integer对象，即是同一个实例
     * Integer的值若不在-128到127之间，就会调用源码中的return new Integer(i);会创建不同的实例
     */
    private static void test02() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

    private static void test01() {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
    }


    /**
     *
     */
    public static void test03() {
        String a = new String("aw");
        String b = new String("aw");
        String c= "aa";
        String d= "aa";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(a==b);//false
        System.out.println(c==d);//true
    }




}
