package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1=new A();
		Class c=a1.getClass();
		System.out.println(c);
		/*
		 * 获取方法 名称和参数列表来决定
		 * getMethod获取的是public的方法
		 * getDelcaredMethod自己声明的方法
		 *
		 * invoke调用方法
		 */
		try {
			Method m=c.getMethod("print", int.class,int.class);
			//Method m=c.getDeclaredMethod("print", int.class,int.class)
			try {
				Object o=m.invoke(a1, 10,20);
				System.out.println("==================");
				Method m1=c.getMethod("print", String.class,String.class);
				o=m1.invoke(a1, "hello","world");
				System.out.println("==================");
				
				Method m2=c.getMethod("print");
				o=m2.invoke(a1);
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class A{
		public void print(int a,int b){
			System.out.println(a+b);
		}
		public void print(){
			System.out.println("helloword");
		}
		public void print(String a,String b){
			System.out.println(a.toUpperCase()+","+b.toLowerCase());
		}
	}

