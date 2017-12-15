package Object;

/**
 * Created by daiwei on 2017/12/15.
 */
public class StudentTest {
    /**
     * 浅层复制：被复制的对象的所有成员属性都有与原来的对象相同的值，
     * 而所有的对其他对象的引用仍然指向原来的对象。换言之，浅层复制仅仅复制所考虑的对象，而不复制它所引用的对象。
     * 修改副本的引用对象，也一并修改了被克隆的对象的引用对象的属性
     * @param args
     */
    public static void main(String[] args) {
        Professor p=new Professor("wangwu",50);
        Student s1=new Student("zhangsan",18,p);
        Student s2=(Student)s1.clone();
        s2.getPro().setName("maer");
        s2.getPro().setAge(40);
        //name=maer,age=40
        System.out.println("name="+s1.getPro().getName()
                +",age="+s1.getPro().getAge());
        System.out.println("name="+s2.getPro().getName()
                +",age="+s2.getPro().getAge());
    }
}
