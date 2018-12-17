package multithreading.demo.CreateThread;

/**
 * 通过继承Thread实现run方法
 */
public class Actor extends Thread{
	public void run(){
		System.out.println(getName()+"是一个演员！");
		int count=0;
		boolean keepRunning=true;
		while(keepRunning){
			System.out.println(getName()+"登台演出："+ (++count));
			if(count==100){
				keepRunning=false;
			}
			if(count%10==0){
				try {
					//当前线程休眠,其他线程仍将执行
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(getName()+"的演出结束了！");
		
	}
	public static void main(String[] args) {

		//启动线程通过继承Thread
		Thread actor=new Actor();
		actor.setName("Mr. Thread");
		actor.start();

//		//启动线程通过实现Runnable接口
//		Thread actressThread=new Thread(new Actress(),"Ms. Runnable");
//		actressThread.start();
	}
	
}

/**
 * 通过实现Runnable接口实现run方法
 */
class Actress implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"是一个演员！");
		int count = 0;
		boolean keepRunning = true;	
		while(keepRunning){
			System.out.println(Thread.currentThread().getName()+"登台演出："+ (++count));		
			if(count == 100){
				keepRunning = false;
			}			
			if(count%10== 0){	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"的演出结束了！");
	}
	public void sing(){
		System.out.println("haha");
	}
	
}