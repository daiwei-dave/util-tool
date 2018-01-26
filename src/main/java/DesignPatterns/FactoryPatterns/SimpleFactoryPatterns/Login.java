package DesignPatterns.FactoryPatterns.SimpleFactoryPatterns;

/**
 * Created by daiwei on 2018/1/24.
 */
public interface Login {
    //登录验证
    public boolean verify(String name , String password);
}
