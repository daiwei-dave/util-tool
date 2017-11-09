package reflect;

/**
 * @Description 通过反射获取类类型的几种方法，并进行实例化
 * @auther diawei
 * @Date 2017年7月20日 下午5:14:19
 */
public class ClassDemo1 {
	public static void main(String[] args) {
		Foo foo1=new Foo();
		Class c1=Foo.class;
		Class c2=foo1.getClass();
		System.out.println(c1 == c2);
		Class c3=null;
		try {
			c3=Class.forName("reflect.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c2==c3);
		try {
			//将类进行实例化
			Foo foo=(Foo)c1.newInstance();
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class Foo{
	void print(){
		System.out.println("foo");
	}
}