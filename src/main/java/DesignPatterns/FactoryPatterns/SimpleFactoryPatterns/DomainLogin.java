package DesignPatterns.FactoryPatterns.SimpleFactoryPatterns;

/**
 * Created by daiwei on 2018/1/24.
 */
public class DomainLogin implements Login {
    public boolean verify(String name, String password) {
        /**
         * 业务逻辑
         */
        return true;
    }
}
