package InnerClass;

/**
 * Created by daiwei on 2017/12/13.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test(new Bird() {
            public int fly() {
                return 10000;
            }

            public String getName() {
                return "大雁";
            }
        });

    }


    public void test(Bird bird){
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }
}
