package DesignPatterns.ProxyPatterns;

/**
 * @sees https://www.ibm.com/developerworks/cn/java/j-lo-proxy-pattern/
 * Created by daiwei on 2017/3/31.
 */
public class Main {
    public static void main(String[] args) {
        //使用代理实列就不用加载DBQuery了
        IDBQuery q = new DBQueryProxy();
        //用到时再加载DBQuery
        System.out.println(q.request());

    }
}
