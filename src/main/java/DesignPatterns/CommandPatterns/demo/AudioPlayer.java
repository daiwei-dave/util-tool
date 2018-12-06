package DesignPatterns.CommandPatterns.demo;

/**
 * @author daiwei
 * @date 2018/12/6 15:51
 */
public class AudioPlayer {

    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }
}
