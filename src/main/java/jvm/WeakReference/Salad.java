package jvm.WeakReference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author daiwei
 * @date 2019/2/26 17:12
 */
public class Salad extends WeakReference<Apple>{
    public Salad(Apple referent) {
        super(referent);
    }


}
