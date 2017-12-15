package Object;

/**
 * Created by daiwei on 2017/12/15.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person("zhangsan",18);
        Person p2  = (Person) p1.clone();
        p2.setName("lis");
        p2.setAge(20);
        //修改p2后，没有对p1产生影响。
        System.out.println("name="
                +p1.getName()+",age="+p1.getAge());
        System.out.println("name="
                +p2.getName()+",age="+p2.getAge());

    }
}
