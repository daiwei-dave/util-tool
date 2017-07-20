package reflect;
/**
 * @Description 通过反射获取类类型的修饰符
 * @auther diawei
 * @Date 2017年7月20日 下午5:14:19
 */
public class ClassDemo2 {
	public static void main(String[] args) {
		Class c1=int.class;
		Class c2=String.class;
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		Class c3=double.class;
		Class c4=Double.class;
		Class c5=void.class;
		System.out.println(c3.getName());
		System.out.println(c4.getName());
		System.out.println(c5.getName());
	}
}
