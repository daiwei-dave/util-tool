package multithreading.concurrent.CopyOnWrite;

import java.util.Map;

/**
 * @author daiwei
 * @date 2018/10/26 18:14
 */
public class BlackListService {
    private static CopyOnWriteMap<String, Boolean> blackListMap = new CopyOnWriteMap<String, Boolean>();

    public static boolean isBlackList(String id) {
        return blackListMap.get(id) == null ? false : true;
    }

    public static void addBlackList(String id) {
        blackListMap.put(id, Boolean.TRUE);
    }

    /**
     * 批量添加黑名单
     *
     * @param ids
     */
    public static void addBlackList(Map<String,Boolean> ids) {
        blackListMap.putAll(ids);
    }

    public static void main(String[] args) {
        System.out.println("haah");
    }
}
