package DesignPatterns.FactoryPatterns.SimpleFactoryPatterns;

import DesignPatterns.FactoryPatterns.SimpleFactoryPatterns.Login;
import DesignPatterns.FactoryPatterns.SimpleFactoryPatterns.LoginManager;

/**
 * Created by daiwei on 2018/1/24.
 */
public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String loginType = "password";
        String name = "name";
        String password = "password";
        Login login = LoginManager.factory(loginType);
        boolean bool = login.verify(name, password);
        if (bool) {
            /**
             * 业务逻辑
             */
        } else {
            /**
             * 业务逻辑
             */
        }
    }
}
