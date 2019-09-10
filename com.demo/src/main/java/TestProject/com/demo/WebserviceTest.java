package TestProject.com.demo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebserviceTest {

	public static void main(String[] args) throws IOException {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		List<Student> memberList = ReadXLSFile.getUserList();

		for (Student student: memberList) {
			Runnable worker = new CampaignResultsTask();
			executor.execute(worker);
		}
		
		executor.shutdown();
	}

}
