package multithreading;

/**
 * 线程阻塞例子,另一个线程始终无法执行
 * @sees http://www.iteye.com/magazines/131-Java-Concurrency#576
 * Created by daiwei on 2017/7/21.
 */
public class DeadLock {
    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            System.out.format("%s"
                            + "  start bowBack to %s!%n",
                    this.name,bower.getName());
            bower.bowBack(this);
            System.out.format("%s"
                            + "  end bowBack to %s!%n",
                    this.name,bower.getName());
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }
}



