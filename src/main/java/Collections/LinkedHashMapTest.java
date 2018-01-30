package Collections;



import java.util.LinkedHashMap;
import java.util.Map;


/**
 *
 * Created by daiwei on 2018/1/14.
 * http://www.cnblogs.com/xrq730/p/5052323.html
 */
public class LinkedHashMapTest {
    public static void put(){
        Map<String,Object> stringObjectMap=new LinkedHashMap();
    }

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap =
                new LinkedHashMap<String, String>();
        linkedHashMap.put("111", "111");
        linkedHashMap.put("222", "222");
        linkedHashMap.get("111");
    }
}
