package Object;

/**
 * Created by daiwei on 2017/12/15.
 */
public class Student implements Cloneable{

    private String name;
    private int age;
    private Professor pro;
    public Student(){}
    public Student(String name,int age,Professor pro){
        this.name=name;
        this.age=age;
        this.pro=pro;
    }
    public Object clone(){
        Object o=null;
        try {
            //Object中的clone()识别出你要复制的是哪一个对象。
            o=super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
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
    public Professor getPro() {
        return pro;
    }
    public void setPro(Professor pro) {
        this.pro = pro;
    }
}


class Professor{
    private String name;
    private int age;
    public Professor(){}
    public Professor(String name,int age){
        this.name=name;
        this.age=age;
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
