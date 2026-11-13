package chapter_13.practice;

public class TimerThread extends Thread{

	//int n = 0;
	
	@Override
	public void run() {
		for(int i = 0; i < 15; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimerThread th = new TimerThread();
		th.start();
	}

}
