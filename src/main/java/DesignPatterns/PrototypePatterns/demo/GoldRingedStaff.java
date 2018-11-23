package DesignPatterns.PrototypePatterns.demo;

import java.io.Serializable;

/**
 * @author daiwei
 * @date 2018/11/23 14:53
 */
public class GoldRingedStaff implements Serializable {
    private float height = 100.0f;
    private float diameter = 10.0f;
    /**
     * 增长行为，每次调用长度和半径增加一倍
     */
    public void grow(){
        this.diameter *= 2;
        this.height *= 2;
    }
    /**
     * 缩小行为，每次调用长度和半径减少一半
     */
    public void shrink(){
        this.diameter /= 2;
        this.height /= 2;
    }


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }


    @Override
    public String toString() {
        return "GoldRingedStaff{" +
                "height=" + height +
                ", diameter=" + diameter +
                '}';
    }
}
