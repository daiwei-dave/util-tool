package InnerClass.AnonymousClass;

/**
 *
 * Created by daiwei on 2017/12/13.
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * 1.不使用匿名内部类来实现抽象方法
         */
//        Person p = new Child();
//        p.eat();
        /**
         *2. 使用匿名内部类
         * 可以减少创建类的实例
         */
//        Person p = new Person() {
//            public void eat() {
//                System.out.println("eat something");
//            }
//        };
//        p.eat();


        /**
         * 3. 在接口上使用匿名内部类
         * 可以减少创建类的实例
         */
//        Action action  = new Action() {
//            public void eat() {
//                System.out.println("eat something");
//            }
//        };
//        action.eat();


        /**
         * 4. Thread类的匿名内部类实现
         * 线程一启动就调用Thread里默认自定义的run方法
         */
//        Thread t = new Thread() {
//            public void run() {
//                for (int i = 1; i <= 5; i++) {
//                    System.out.print(i + " ");
//                }
//            }
//        };
//        t.start();

        /**
         * 5. Runnable接口的匿名内部类实现
         * 线程一启动就调用Thread里默认自定义的run方法
         */
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();



    }

}
abstract class Person {
    public abstract void eat();
}



interface Action {
    public void eat();
}

class Child extends Person {
    public void eat() {
        System.out.println("eat something");
    }
}