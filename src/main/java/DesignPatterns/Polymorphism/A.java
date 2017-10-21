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
}
class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        //只会调用父类的方法，
        System.out.println(a1.show(b));
        System.out.println(a1.show(c));
    }
}
class C extends B{}
class D extends B{}
