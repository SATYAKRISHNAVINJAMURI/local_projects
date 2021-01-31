package threads;
class ThreadDemo2 extends Thread {
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
class ThreadDemo1 extends Thread{
	@Override
	public void run(){
		for(int i=10;i<20;i++){
			System.out.println(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class ThreadDemo{
	public static void main(String[]args) throws InterruptedException{
		ThreadDemo1  one = new ThreadDemo1();
		ThreadDemo2 two = new ThreadDemo2();
		one.start();
		Thread.sleep(10000);
		two.start();
		
		
	}
}