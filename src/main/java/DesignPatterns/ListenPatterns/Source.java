package DesignPatterns.ListenPatterns;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author daiwei
 * @date 2018/8/20 14:06
 */
public class Source {

    private List<StatusListener> statusListeners = new ArrayList<StatusListener>();
    public void addStatusListener(StatusListener listener) {
        statusListeners.add(listener);
    }

    public void onClick() {
        ChangeEvent event = new ChangeEvent(this);
        event.setStatus("click");
        notifyListener(event);
    }


    public void onMove() {
        ChangeEvent event = new ChangeEvent(this);
        event.setStatus("move");
        notifyListener(event);
    }

    public void onDoubleClick() {
        ChangeEvent event = new ChangeEvent(this);
        event.setStatus("doubleClick");
        notifyListener(event);
    }




    private void notifyListener(ChangeEvent event) {
        Iterator<StatusListener> it = statusListeners.iterator();
        while(it.hasNext()) {
            StatusListener listener = it.next();
            listener.changeStatus(event);
        }
    }

}
