package DesignPatterns.Polymorphism;

/**
 * A中的方法为重载
 * Created by daiwei on 2017/10/21.
 */
public class A {
    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return ("A and A");
    }
    public static void main(String[] args) {
        A a1 = new A();
        //new 的是b对象,但a2已声明是A类型
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        /**
         * 因为new 的是A对象只会调用父类的方法，无论是b还是c都可以上溯到A类型。
         * 因为d对象已经能绑定到A中的方法了，顾无需再上溯造型
         */
        System.out.println(a1.show(b));
        System.out.println(a1.show(c));
        System.out.println(a1.show(d));
        /**
         * 因为new 的是b对象，故方法会执行b中重写的方法，
         * 只有在子类没有此方法而父类有时才会调用父类的方法
         * a2.show(b)和a2.show(c)因为a2已声明是A类型，即只会执行A类型的相关方法，
         * 而不会去执行A中没有的方法。
         */
        System.out.println(a2.show(b));
        System.out.println(a2.show(c));
        System.out.println(a2.show(d));
        /**
         * 因为b中没有引用父类对象故b上溯到b,c上溯到b
         */
        System.out.println(b.show(b));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }
}
class C extends B{}
class D extends B{}
class B extends A {
    /**
     * 此方法并没有重写父类方法
     * @param obj
     * @return
     */
    public String show(B obj) {
        return ("B and B");
    }

    @Override
    public String show(A obj) {
        return ("B and A");
    }
}

