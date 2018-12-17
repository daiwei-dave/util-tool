package multithreading.demo.dynasty;

public class Stage extends Thread{
//	public void run(){
//		System.out.println("欢迎观看隋唐演义");
//		//让观众们安静片刻，等待大戏上演
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println("大幕徐徐拉开");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		System.out.println("话说隋朝末年，隋军与农民起义军杀得昏天黑地...");
//		//创建军队对象
//		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
//		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
//		//使用Runnable接口创建线程
//		Thread  armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty, "隋军");
//		Thread  armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");
//
//		//启动线程，让军队开始作战
//		armyOfSuiDynasty.start();
//
//		armyOfRevolt.start();
//		//舞台线程（即主线程）休眠，若不使用sleep方法，某些线程里的run方法将没时间执行,
//		//调用了sleep方法，则可保证在一个正在执行的线程休眠时另一个线程还会执行
//		try {
//			Thread.sleep(50);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("正当双方激战正酣，半路杀出了个程咬金");
//		//创建关键先生
//		Thread  mrCheng=new KeyPersonThread();
//		//给线程命名
//		mrCheng.setName("程咬金");
//		System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");
//		//停止军队作战
//		//停止线程的方法
//		armyTaskOfSuiDynasty.keepRunning=false;
//		armyTaskOfRevolt.keepRunning=false;
//
//
//		//激战完后休眠
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//关键先生的run方法开始执行，因为armyOfSuiDynasty和armyOfRevolty两个线程都已结束，java虚拟机实际执行的是mrCheng的单线程
//		mrCheng.start();
//		//等待该线程终止。 即只有该线程执行完后才会执行舞台线程（即主线程）后面的程序。
//		try {
//			mrCheng.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
//		System.out.println("谢谢观看隋唐演义，再见！");
//	}
	public static void main(String[] args) {
		new Stage().start();
	}


	/**
	 * 只创建了一个线程对象
	 */
	public void run(){
		System.out.println("欢迎观看隋唐演义");
		//让观众们安静片刻，等待大戏上演
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("大幕徐徐拉开");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("话说隋朝末年，隋军与农民起义军杀得昏天黑地...");


		/**
		 * 只创建了一个对象，当调用synchronized修饰的方法时，会产出互斥，即只有一个线程会执行
		 */
		ArmyRunnable syncThread = new ArmyRunnable();
		Thread armyOfSuiDynasty = new Thread(syncThread, "隋军");
		Thread armyOfRevolt = new Thread(syncThread, "农民起义军");

		//启动线程，让军队开始作战
		armyOfSuiDynasty.start();

		armyOfRevolt.start();
		//舞台线程（即主线程）休眠，若不使用sleep方法，某些线程里的run方法将没时间执行,
		//调用了sleep方法，则可保证在一个正在执行的线程休眠时另一个线程还会执行
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("正当双方激战正酣，半路杀出了个程咬金");
		//创建关键先生
		Thread  mrCheng=new KeyPersonThread();
		//给线程命名
		mrCheng.setName("程咬金");
		System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");
		//停止军队作战
		//停止线程的方法
		syncThread.keepRunning=false;
		//激战完后休眠
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关键先生的run方法开始执行，因为armyOfSuiDynasty和armyOfRevolty两个线程都已结束，java虚拟机实际执行的是mrCheng的单线程
		mrCheng.start();
		//等待该线程终止。 即只有该线程执行完后才会执行舞台线程（即主线程）后面的程序。
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
		System.out.println("谢谢观看隋唐演义，再见！");
	}
}
