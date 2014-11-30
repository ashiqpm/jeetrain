package moh.mohart;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.s2n.ddt.util.http.HttpData;
import org.s2n.ddt.util.http.NetSend;

public class GetFromWeb {

	public static void main(String args[]) {
		
		BasicConfigurator.configure();
		
		//System.out.println(GetFromWeb.excutePost("http://www.flickr.com/","sunilvnair"));//"https://sel2in.com/up6.php", "a=b"));
		GetFromWeb.getFromWeb();
	}
	
	
	public static void getFromWeb() {
		try {
			HttpData hDat = new HttpData();
			hDat.setUrl("https://sel2in.com/up6.php");
			String s = NetSend.send(hDat,  "");
			System.out.println("Got " + s + ".");
			hDat.setUrl("https://sel2in.com/up6.php"); //https://in.yahoo.com/");
			s = NetSend.send(hDat,  "", null , "GET");
			System.out.println("Got " + s + ".");
			
			
		} catch(Exception ex) {
			
		}
	}
	
	
	
	//http://www.flickr.com", "ashiqpm"));
	//http://www.mathrubhumi.com/index.php", "")); // 
	//https://sel2in.com/up6.php?a=b
	
	public static String excutePost(String targetURL, String urlParameters) {
	    URL url;
	    HttpURLConnection connection = null;  
	    try {
	      //Create connection
	      url = new URL(targetURL);
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	      connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
	      connection.setRequestProperty("Content-Language", "en-US");  

	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      //Send request
	      DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
	      System.out.println("[Out] " + urlParameters);
	      
	      wr.writeBytes (urlParameters);
	      wr.flush ();
	      wr.close ();

	      //Get Response    
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer(); 
	      
	     
	      
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	      
	      File f = new File("c:\\java\\htmlresp.html");
	      FileWriter fw = new FileWriter(f);
	      //FileOutputStream fs = new FileOutpuStream(f);
	      fw.write(response.toString());
	      fw.close();
	      return response.toString();

	    } catch (Exception e) {

	      e.printStackTrace();
	      return null;

	    } finally {

	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }
	}
	
	
}
