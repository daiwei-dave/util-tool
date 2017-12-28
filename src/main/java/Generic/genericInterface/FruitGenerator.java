package Generic.genericInterface;

import java.util.Random;

/**
 *
 * Created by daiwei on 2017/12/28.
 */
public class FruitGenerator implements Generator<String>{
    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
