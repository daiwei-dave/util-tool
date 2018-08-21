package DesignPatterns.TemplatePatterns.theory;

/**
 * @author daiwei
 * @date 2018/8/21 15:06
 */
public class ConcreteTemplate extends AbstractTemplate{
    @Override
    protected void abstractMethod() {
        //业务相关的代码
    }


    //重写父类的方法
    @Override
    public void hookMethod() {
        //业务相关的代码
    }
}
