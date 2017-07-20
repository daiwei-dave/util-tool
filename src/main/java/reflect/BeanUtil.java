package reflect;

import Validation.entity.CouponUser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description 通过反射调用get和set方法
 * @auther diawei
 * @Date 2017年7月20日 下午5:14:19
 */
public class BeanUtil {
	/**
	 * 根据标准javaBean对象的属性名获取其属性值
	 *
	 * @param obj
	 * @param propertyName
	 * @return
	 */
	public static Object getValueByPropertyName(Object obj, String propertyName) {
		// 1.根据属性名称就可以获取其get方法
		String getMethodName = "get"
				+ propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);
		String setMethodName = "set"
				+ propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);
		//2.获取方法对象
		Class c = obj.getClass();
		try {
			//get方法都是public的且无参数
			Method get= c.getMethod(getMethodName);
			//3 通过方法的反射操作方法
			Object value = get.invoke(obj);
			System.out.println(value);
			//set方法
			Method set = c.getMethod(setMethodName, String.class);
			set.invoke(obj,"username2");
			return get.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据标准javaBean对象获取其属性值
	 * @param obj 对象的实例
	 * @return
	 */
	public static Object getValueByPropertyName(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();    //获取属性的名字
			name = name.substring(0, 1).toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
			String type = field.getGenericType().toString(); //获取属性的类型

			// 1.根据属性名称就可以获取其get方法
			String getMethodName = "get" + name;
			String setMethodName = "set" + name;
			//2.获取方法对象
			Class c = obj.getClass();
			try {
				//get方法都是public的且无参数
				Method get = c.getMethod(getMethodName);
				//3 通过方法的反射操作方法
				Object value = get.invoke(obj);
				System.out.println(value);
				//type为String类型
				if (type.equals("class java.lang.String")){
					//set方法
					Method set = c.getMethod(setMethodName, String.class);
					set.invoke(obj, "daiwei");
					System.out.println(get.invoke(obj));
				}
				//type为String类型
				if (type.equals("int")){
					//set方法
					Method set = c.getMethod(setMethodName, int.class);
					set.invoke(obj, 250);
					System.out.println(get.invoke(obj));
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("检查数据类型");
				return null;
			}
		}
		return obj;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User("zhangsan", "123456", 30);
		CouponUser couponUser=new CouponUser("123456","daiwei");
//		System.out.println(BeanUtil.getValueByPropertyName(u1, "username"));
//       System.out.println(BeanUtil.getValueByPropertyName(u1, "userpass"));
	//	System.out.println(BeanUtil.getValueByPropertyName(u1).toString());
		System.out.println(BeanUtil.getValueByPropertyName(couponUser).toString());
	}
}
