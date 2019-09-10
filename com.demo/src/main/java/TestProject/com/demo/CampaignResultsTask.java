package TestProject.com.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class CampaignResultsTask implements Runnable {

	private Student student;
	public CampaignResultsTask() {

	}

	public CampaignResultsTask(Student student) {
		this.student = student;
	}

	public void run() {
		try {

			URL url = new URL("http://localhost:8080/sensei/rest/portal/add/data");// your url i.e fetch data from .
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			byte[] postDataBytes = student.toString().getBytes("UTF-8");
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:/var/campaign_results.txt", true));
			String output;
			Gson g = new Gson();
			while ((output = br.readLine()) != null) {
				Student student = g.fromJson(output, Student.class);
				writer.write(output);
				writer.write("\r\n");
				writer.close();
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}

	}

}
