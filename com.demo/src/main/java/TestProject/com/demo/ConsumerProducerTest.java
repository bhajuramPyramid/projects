package TestProject.com.demo;

import java.util.LinkedList;


/**
 * Hello world!
 *
 */
public class ConsumerProducerTest {
	public static void main(String[] args) throws InterruptedException {

		final PC pc = new PC();

		// create producer thread
		Thread th1 = new Thread(new Runnable() {

			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		// create consumer thread
		Thread th2 = new Thread(new Runnable() {

			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		
		// start both thread
		th1.start();
		th2.start();
		
		// th1 finishes before th2
		th1.join();
		th2.join();

	}

	public static class PC {

		// create a list shared by both producer and consumer
		LinkedList<Integer> list = new LinkedList<Integer>();
		int capacity = 1;
		
		// function called by producer thread
		public void produce() throws InterruptedException {
			int value = 1;
			while(true) {
				synchronized (this) {
					// producer thread will wait while list is full
					while(list.size() == capacity) {
						wait();
					}
					// System.out.println("Producer produced value : " + value);
					
					// to insert the job into list
					System.out.print("p-"+value + " ");
					list.add(value);
					value = value + 2;
					
					// wake up consumer thread
					notify();
					
					Thread.sleep(1000);
				}
			}

		}
		

		public void consume() throws InterruptedException {
			int value = 2;
			while(true) {
				synchronized (this) {
					// consumer thread will wait while thread is empty
					while (list.size() == 0) {
						wait();
					}
					
					// consumer has consume the value 
					// System.out.println("consumer has consume the value : " + list.removeFirst());
					System.out.print("c-"+value + " ");
					list.removeFirst();
					value = value + 2;
					
					// wake up producer thread
					notify();
					
					Thread.sleep(1000);
				}
			}
			
		}

	}
}
