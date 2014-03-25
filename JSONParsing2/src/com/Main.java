package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* example
		String name = (String) jsonObject.get("name");
		System.out.println(name);
 
		long age = (Long) jsonObject.get("age");
		System.out.println(age);
	    */
		File folder = new File(".");
		File[] listOfFiles = folder.listFiles();
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isFile()) {
	        	String filename = fileEntry.getName();
	        	if (filename.endsWith(".json") || filename.endsWith(".JSON"))
	            {
	               System.out.println(filename);
	       			parseJsonFile(filename.substring(0, filename.lastIndexOf(".")));
	            }
	        }
	    }
	}
	
	
	private static void parseJsonFile(String jName) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jName+".json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray msg = (JSONArray) jsonObject.get("frames");
			Iterator<JSONObject> iterator = msg.iterator();
			JSONObject joFrame;
			JSONObject joFrameCoord;
			String filename;
			
			//String fileId;
			String prevFilename = "";
			long prevX = -1, prevY = -1, prevW = -1, prevH = -1;			
			int frame = -1;
			
			String result = "Timeline generated from "+jName+":\n[ ";
			while (iterator.hasNext()) {
				joFrame = iterator.next();
				filename = (String) joFrame.get("filename");
				
				joFrameCoord = (JSONObject) joFrame.get("frame");
				long x = (Long) joFrameCoord.get("x");
				long y = (Long) joFrameCoord.get("y");
				long w = (Long) joFrameCoord.get("w");
				long h = (Long) joFrameCoord.get("h");
				
				if(frame>=0) result += ", ";
				if(filename.equals(prevFilename) || x == prevX && y == prevY && w == prevW && h == prevH ){
					
				}else{
					prevFilename = filename;
					prevX = x;
					prevY = y;
					prevW = w;
					prevH = h;
					
					frame++;					
				}
				System.out.println(frame+" "+filename+" "+prevX+":"+x+" "+prevY+":"+y+" "+prevW+":"+w+" "+prevH+":"+h+" ");
				result += frame;
			}
			result += "]";
			System.out.print("result: "+result);
			printToFile(jName, result);
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private static void printToFile(String fileName, String text) {
		PrintWriter out;
		try {
			out = new PrintWriter(fileName+".txt");
			out.println(text);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
