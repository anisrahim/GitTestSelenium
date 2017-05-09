package com.mkyong.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.List;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import jdk.nashorn.internal.parser.JSONParser;

import org.apache.commons.codec.binary.Base64;

public class NetClientGet {

	// http://desktop-4peg6ad/ppm/rest/v1
	public static void main(String[] args) throws IOException {

	  try {

		URL url = new URL("http://desktop-4peg6ad/ppm/rest/v1/projects/5000001");
		System.out.println("Path = "+url.getPath());
		
		  StringBuilder sb = new StringBuilder();
	      
	           // URL url = new URL(baseUrl + path);
	        	
	        	URLConnection urlConnection = url.openConnection();
	            String authString = "arahim" + ":" + "!Clarity151";
	            String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
	            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
	            
	            System.out.println(urlConnection.getContentType());
	            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }
	            
	            System.out.println("Response = "+sb.toString());
	            reader.close();     
	            
	            JSONParser parser = new JSONParser();
	          
	            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(sb.toString());
	            //JSONObject jsonObject =  (JSONObject) parser.parse(sb.toString());
	            
	            System.out.println("agileSync = "+jsonObject.get("agileSync"));

	            System.out.println("businessOwner = "+(jsonObject.get("businessOwner")));  	

	  } catch (Exception e) {
		e.printStackTrace();
	 
	}
}
}