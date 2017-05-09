package com.mkyong.client;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class PPMDemoRESTClient {

	
		
	String baseUrl;
    String username;
    String password;
 
    
     
   public String getDataFromServer(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            //URL url = new URL(baseUrl + path);
        	 URL url = new URL(path);
            URLConnection urlConnection = setUsernamePassword(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
 
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    private URLConnection setUsernamePassword(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        String authString = username + ":" + password;
        String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
        urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
        return urlConnection;
    }
	public static void main(String[] args) throws Exception {
		PPMDemoRESTClient adp = new PPMDemoRESTClient();
		adp.baseUrl = "http://desktop-4peg6ad/ppm/rest/v1";
		adp.username = "admin";
		adp.password = "!Clarity151";
	        
	        String res = adp.getDataFromServer(adp.baseUrl);
		
		}
}
