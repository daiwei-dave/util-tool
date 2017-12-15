package Object;

/**
 * 其实Cloneable接口仅仅是一个标志，而且这个标志也仅仅是针对 Object类中 clone()方法的，
 * 如果 clone 类没有实现 Cloneable 接口，并调用了 Object 的 clone() 方法（也就是调用了 super.Clone() 方法），
 * 那么Object 的 clone() 方法就会抛出 CloneNotSupportedException 异常。
 * Created by daiwei on 2017/12/15.
 */
public class Person implements Cloneable{
    private String name;
    private int age;
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public Object clone(){
        Object o=null;
        try {
            o=super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
