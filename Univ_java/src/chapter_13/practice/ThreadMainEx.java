package chapter_13.practice;

public class ThreadMainEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("Current thread name = " + name);
		System.out.println("Current thread id = " + id);
		System.out.println("Current thread priority value = " + priority);
		System.out.println("Current thread state = " + s);
	}

}
