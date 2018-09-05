package DesignPatterns.VisitorPattern;

/**
 * @author daiwei
 * @date 2018/9/5 16:44
 */
public class SubEast2 extends East{
    @Override
    public void goEast(West west) {
        west.goWest2(this);
    }

    public String myName2(){
        return "SubEast2";
    }
}
