package DesignPatterns.ProxyPatterns;

/**
 * 代理类
 * Created by daiwei on 2017/3/31.
 */
public class DBQueryProxy implements IDBQuery{
    private DBQuery real;
    public String request() {
        //在真正需要的时候才能创建真实对象，创建过程可能很慢
        if(real==null){
            real = new DBQuery();
        }//在多线程环境下，这里返回一个虚假类，类似于 Future 模式
        return real.request();
    }

    public String reponse() {
        return null;
    }

}
