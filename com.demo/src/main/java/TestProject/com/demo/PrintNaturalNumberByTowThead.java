package TestProject.com.demo;

public class PrintNaturalNumberByTowThead {
	public String str = "fdfd";
	public static void main(String[] args) throws InterruptedException {
		Thread th1 = new Thread(new OddPrint());
		Thread th2 = new Thread(new EvenPrint());

		th1.start();
		th2.start();
		
	}

}

class ABC {
	
}

class EvenPrint implements Runnable {

	public void run() {

		for (int i = 1; 1 <= 50; i++) {
			synchronized (this) {
				try {
					if (OddPrint.oddFlag) {
						wait();
					}
					System.out.print(2 * i + " ");
					OddPrint.oddFlag = true;
					notify();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}

	}

}

class OddPrint implements Runnable {
	public static boolean oddFlag = true;

	public void run() {
		for (int i = 1; 1 <= 50; i++) {
			synchronized (this) {
				try {
					if (!oddFlag) {
						wait();
					}
					System.out.print(2 * i - 1 +" ");
					oddFlag = false;
					notify();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			

		}

	}

}
