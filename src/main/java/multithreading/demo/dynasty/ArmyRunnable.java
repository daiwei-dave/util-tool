package multithreading.demo.dynasty;
/**
 * 军队线程
	模拟作战双方的行为
 * @author daiwei
 *
 */
public class ArmyRunnable implements Runnable{
	// 用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最新的值(即保证了可见性)。
	volatile boolean keepRunning = true;
	private final Object lockObj = new Object();

//	@Override
//	public void run() {
//		while(keepRunning){
//			//发动5连击
//			for(int i=0;i<5;i++){
//				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
//				//暂停当前正在执行的线程对象即ArmyRunnable对象，并执行其他线程,其他线程也有可能是当前线程。
//				Thread.yield();
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
//	}

	/**
	 * 加入同步，synchronized (ArmyRunnable.class)是锁住ArmyRunnable这个类(该类所有的对象同一把锁)
	 * 即使是两个不同对象的线程也会在调用此类时产生线程互斥
	 */
//	@Override
//	public void run() {
//		/**
//		 * 只有一个线程会执行
//		 */
//		synchronized (ArmyRunnable.class){
//			while(keepRunning){
//				//发动5连击
//				for(int i=0;i<5;i++){
//					System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
//				}
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
//	}


	/**
	 * 锁住方法，只用两个线程为一个对象才会互斥
	 */
//	@Override
//	public synchronized void run() {
//		while(keepRunning){
//			//发动5连击
//			for(int i=0;i<5;i++){
//				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
//				//暂停当前正在执行的线程对象即ArmyRunnable对象，并执行其他线程,其他线程也有可能是当前线程。
//				Thread.yield();
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
//	}


	/**
	 * synchronized (this)锁住的是对象，只用两个线程为一个对象才会互斥
	 */
	@Override
	public void run() {
		synchronized (this){
			while(keepRunning){
				//发动5连击
				for(int i=0;i<5;i++){
					System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
	}



}
