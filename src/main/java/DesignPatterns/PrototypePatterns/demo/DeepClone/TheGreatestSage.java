package DesignPatterns.PrototypePatterns.demo.DeepClone;

import DesignPatterns.PrototypePatterns.demo.Monkey;

import java.io.IOException;

/**
 * 深克隆
 * @author daiwei
 * @date 2018/11/23 15:01
 */
public class TheGreatestSage {
    private Monkey monkey = new Monkey();

    public void change() throws IOException, ClassNotFoundException{
        Monkey copyMonkey = (Monkey)monkey.deepClone();
        System.out.println("大圣本尊的生日是：" + monkey.getBirthDate());
        System.out.println("克隆的大圣的生日是：" + copyMonkey.getBirthDate());
        System.out.println("大圣本尊跟克隆的大圣是否为同一个对象 " + (monkey == copyMonkey));
        System.out.println("大圣本尊持有的金箍棒 跟 克隆的大圣持有的金箍棒是否为同一个对象？ " + (monkey.getStaff() == copyMonkey.getStaff()));


        //深克隆所引用的GoldRingedStaff为不同的对象
        monkey.getStaff().grow();
        System.out.println("大圣本尊持有的金箍棒  " + monkey.toString());
        System.out.println("大圣本尊持有的金箍棒  " + copyMonkey.toString());
    }

    public static void main(String[]args) throws IOException, ClassNotFoundException{
        TheGreatestSage sage = new TheGreatestSage();
        sage.change();
    }
}
