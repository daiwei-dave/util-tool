package DesignPatterns.ProxyPatterns.LazyLoading;

/**
 * Created by daiwei on 2017/3/31.
 */
public class DBQuery implements IDBQuery{
    public DBQuery() {
        try {
            Thread.sleep(1000);//假设数据库连接等耗时操作
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public String request() {
        return "request string";
    }
}
