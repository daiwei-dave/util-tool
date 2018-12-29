package cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author daiwei
 * @date 2018/12/29 17:58
 */
public class CacheListener {
    Logger logger = LoggerFactory.getLogger(CacheListener.class);
    private CacheManagerImpl cacheManagerImpl;
    public CacheListener(CacheManagerImpl cacheManagerImpl) {
        this.cacheManagerImpl = cacheManagerImpl;
    }

    public void startListen() {
        new Thread(){
            public void run() {
                while (true) {
                    for(String key : cacheManagerImpl.getAllKeys()) {
                        if (cacheManagerImpl.isTimeOut(key)) {
                            cacheManagerImpl.clearByKey(key);
                            logger.info(key + "缓存被清除");
                        }
                    }
                }
            }
        }.start();

    }


}
