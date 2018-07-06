package Collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author daiwei
 * @date 2018/7/5 17:04
 */
public class HashMapTestTest {

    @Test
    public void put() {
    }



    @Test
    public void stressHashMapPut() {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        long currentTimeMillis = System.currentTimeMillis();

        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        public void run() {

                            String key = UUID.randomUUID().toString();
                            String value = key;
                            map.put(key, value);

   //                         System.out.println(Thread.currentThread().getName()+": key:"+key+" value:" +map.get(key));
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        try {
            t.join();
            System.out.println(t.getName()+" end,spend time:"+(System.currentTimeMillis()-currentTimeMillis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void stressHashtablePut() {
        final Map<String, String> map = new Hashtable<String, String>(2);
        long currentTimeMillis = System.currentTimeMillis();
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        public void run() {

                            String key = UUID.randomUUID().toString();
                            String value = key;
                            map.put(key, value);

                            //                           System.out.println(Thread.currentThread().getName()+": key:"+key+" value:" +map.get(key));
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        try {
            t.join();
            System.out.println(t.getName()+" end,spend time:"+(System.currentTimeMillis()-currentTimeMillis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}