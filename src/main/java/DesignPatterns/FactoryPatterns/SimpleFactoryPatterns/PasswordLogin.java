package DesignPatterns.FactoryPatterns.SimpleFactoryPatterns;

import DesignPatterns.FactoryPatterns.SimpleFactoryPatterns.Login;

/**
 * Created by daiwei on 2018/1/24.
 */
public class PasswordLogin implements Login {
    public boolean verify(String name, String password) {
        /**
         * 业务逻辑
         */
        return true;
    }
}
