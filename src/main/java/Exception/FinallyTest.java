package Exception;

/**
 * @sees https://www.cnblogs.com/lanxuezaipiao/p/3440471.html
 * Created by daiwei on 2017/12/15.
 */
public class FinallyTest {
    /**
     * 最后总结：finally块的语句在try或catch中的return语句执行之后返回之前执行
     * 且finally里的修改语句可能影响也可能不影响try或catch中 return已经确定的返回值，
     * 若finally里也有return语句则覆盖try或catch中的return语句直接返回。
     * @param args
     */
    public static void main(String[] args) {

   //     System.out.println(test1());
   //     System.out.println(test11());
        System.out.println(test2());
    }

    /***
     * finally语句在return语句执行之后return返回之前执行的。
     * 说明return语句已经执行了再去执行finally语句，
     * 不过并没有直接返回，而是等finally语句执行完了再返回结果。
     * @return
     */
    public static int test1() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        }
        catch (Exception e) {

            System.out.println("catch block");
        }
        finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }

        return b;
    }

    /**
     * finally语句在return语句执行之后return返回之前执行的。
     * @return
     */
    public static String test11() {
        try {
            System.out.println("try block");

            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test12() {
        System.out.println("return statement");

        return "after return";
    }

    /**
     * finally块中的return语句会覆盖try块中的return返回。
     * @return
     */
    public static int test2() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return 200;
        }

     //    return b;
    }
}
