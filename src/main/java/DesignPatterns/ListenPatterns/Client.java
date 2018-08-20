package DesignPatterns.ListenPatterns;

/**
 * @author daiwei
 * @date 2018/8/20 14:19
 */
public class Client {
    public static void main(String[] args) {
        Source source = new Source();
        source.addStatusListener(new StatusListener(){
            public void changeStatus(ChangeEvent event) {
                System.out.println(event.getStatus());
            }
        });

        source.onClick();
        source.onDoubleClick();
        source.onMove();
    }
}
