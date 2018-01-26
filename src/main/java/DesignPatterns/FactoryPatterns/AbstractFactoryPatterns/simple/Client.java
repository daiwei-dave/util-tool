package DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.simple;

/**
 * Created by daiwei on 2018/1/26.
 */
public class Client {
    public static void main(String[]args){
        ComputerEngineer cf = new ComputerEngineer();
        cf.makeComputer(1,1);
    }
}
