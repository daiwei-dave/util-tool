package DesignPatterns.VisitorPattern;

/**
 * @author daiwei
 * @date 2018/9/5 16:46
 */
public class SubEast1 extends East{
    @Override
    public void goEast(West west) {
        west.goWest1(this);
    }

    public String myName1(){
        return "SubEast1";
    }

}
