package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	public static int res = 3;/*
	1 - 960x640
	2 - 
	3 - 1136x640
	

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
		
		fishDog("dog_fish_spot_sprite");
		 fisherman("fisherman_sprite");
		 picksLeft("picks_left_sprite");
	}
	
	private static void spots(String jName) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jName+".json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray msg = (JSONArray) jsonObject.get("frames");
			Iterator<JSONObject> iterator = msg.iterator();
			JSONObject joFrame;
			JSONObject joFrameCoord;
			JSONObject joSpriteSourceSize;
			String filename;
			while (iterator.hasNext()) {
				joFrame = iterator.next();
				filename = (String) joFrame.get("filename");
				filename = filename.substring(0, filename.length()-4);
				//System.out.print("{ sprite: \"spot_sprite\", x: ");
				System.out.print("\'"+filename+"\': { sprite: \""+jName+"\", x: ");
				
				joFrameCoord = (JSONObject) joFrame.get("frame");
				System.out.print(joFrameCoord.get("x") + ", y: ");
				System.out.print(joFrameCoord.get("y") + ", w: ");
				long w = (Long) joFrameCoord.get("w");
				System.out.print(w + ", h: ");
				long h = (Long) joFrameCoord.get("h");
				System.out.print(h + ", xOffset: ");
				
				joSpriteSourceSize = (JSONObject) joFrame.get("spriteSourceSize");
				long dx = (Long) joSpriteSourceSize.get("x");
				System.out.print(dx + ", yOffset: ");
				long dy = (Long) joSpriteSourceSize.get("y");
				System.out.println(dy + " },");
			}
		
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
	
	private static void picksLeft(String jName) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jName+".json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray msg = (JSONArray) jsonObject.get("frames");
			Iterator<JSONObject> iterator = msg.iterator();
			JSONObject joFrame;
			JSONObject joFrameCoord;
			JSONObject joSpriteSourceSize;
			String filename;
			//String fileId;
			//String prevFileId = "";
			while (iterator.hasNext()) {
				joFrame = iterator.next();
				filename = (String) joFrame.get("filename");
				filename = filename.substring(0, filename.length()-4);
				//fileId = filename.substring(0, 21);//PICKS_LEFT1024_1pick
				
				//prevFileId = fileId;
				//System.out.print("{ sprite: \"picks_left_sprite\", x: ");
				System.out.print("\'"+filename+"\': { sprite: \""+jName+"\", x: ");
				
				joFrameCoord = (JSONObject) joFrame.get("frame");
				long x = (Long) joFrameCoord.get("x");
				x = x / 2;
				long y = (Long) joFrameCoord.get("y");
				y = y / 2;
				System.out.print(x + ", y: ");
				System.out.print(y + ", w: ");
				long w = (Long) joFrameCoord.get("w");
				w = w / 2;
				System.out.print(w + ", h: ");
				long h = (Long) joFrameCoord.get("h");
				h = h / 2;
				System.out.print(h + ", xOffset: ");
				
				joSpriteSourceSize = (JSONObject) joFrame.get("spriteSourceSize");
				long dx = 0;//(Long) joSpriteSourceSize.get("x");
				System.out.print(dx + ", yOffset: ");
				long dy = 0;//(Long) joSpriteSourceSize.get("y");
				System.out.println(dy + " },");
			}
		
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
	
	private static void fisherman(String jName) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jName+".json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray msg = (JSONArray) jsonObject.get("frames");
			Iterator<JSONObject> iterator = msg.iterator();
			JSONObject joFrame;
			JSONObject joFrameCoord;
			JSONObject joSpriteSourceSize;
			JSONObject joSourceSize;
			String filename;
			while (iterator.hasNext()) {
				joFrame = iterator.next();
				filename = (String) joFrame.get("filename");
				filename = filename.substring(0, filename.length()-4);
				//System.out.print("{ sprite: \"fisherman_sprite\", x: ");
				System.out.print("\'"+filename+"\': { sprite: \""+jName+"\", x: ");
				
				joFrameCoord = (JSONObject) joFrame.get("frame");
				System.out.print(joFrameCoord.get("x") + ", y: ");
				System.out.print(joFrameCoord.get("y") + ", w: ");
				long w = (Long) joFrameCoord.get("w");
				System.out.print(w + ", h: ");
				long h = (Long) joFrameCoord.get("h");
				System.out.print(h + ", xOffset: ");
				

				joSourceSize = (JSONObject) joFrame.get("sourceSize");
				long ws = (Long) joSourceSize.get("w");
				long hs = (Long) joSourceSize.get("h");

				long biggestWidth = 188;//379;//188;//401;//TODO
				long biggestHeight = 243;//483;//243;//592;//TODO
				if(res==1){
					biggestWidth = 379;
					biggestHeight = 483;
				}else if(res==3){
					biggestWidth = 379;
					biggestHeight = 483;
					
				}
				joSpriteSourceSize = (JSONObject) joFrame.get("spriteSourceSize");
				long offX = (Long) joSpriteSourceSize.get("x");
				long dx = (biggestWidth-ws) + offX ;//(Long) joSpriteSourceSize.get("x");
				//long newWidth = (biggestWidth - 2 * dx);
				System.out.print(dx + ", yOffset: ");
				long offY = (Long) joSpriteSourceSize.get("y");
				long dy = (biggestHeight-hs) + offY ;//(Long) joSpriteSourceSize.get("y");
				//System.out.println(dy + " },//"+filename);
				System.out.println(dy + " },");
			}
		
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
	
	private static void idleDog(String jName) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("dog_idle_loop_sprite_1024.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray msg = (JSONArray) jsonObject.get("frames");
			Iterator<JSONObject> iterator = msg.iterator();
			JSONObject joFrame;
			JSONObject joFrameCoord;
			JSONObject joSpriteSourceSize;
			String filename;
			while (iterator.hasNext()) {
				joFrame = iterator.next();
				filename = (String) joFrame.get("filename");
				filename = filename.substring(0, filename.length()-4);
				//System.out.print("{ sprite: \"idle_dog_sprite\", x: ");
				System.out.print("\'"+filename+"\': { sprite: \""+jName+"\", x: ");
				
				joFrameCoord = (JSONObject) joFrame.get("frame");
				System.out.print(joFrameCoord.get("x") + ", y: ");
				System.out.print(joFrameCoord.get("y") + ", w: ");
				long w = (Long) joFrameCoord.get("w");
				System.out.print(w + ", h: ");
				long h = (Long) joFrameCoord.get("h");
				System.out.print(h + ", xOffset: ");
				
				joSpriteSourceSize = (JSONObject) joFrame.get("spriteSourceSize");
				long dx = (Long) joSpriteSourceSize.get("x");
				System.out.print(dx + ", yOffset: ");
				long dy = (Long) joSpriteSourceSize.get("y");
				//System.out.println(dy + " },//"+filename);
				System.out.println(dy + " },");
			}
		
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

	private static void fishDog(String jName) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jName+".json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray msg = (JSONArray) jsonObject.get("frames");
			Iterator<JSONObject> iterator = msg.iterator();
			JSONObject joFrame;
			JSONObject joFrameCoord;
			JSONObject joSpriteSourceSize;
			String filename;
			while (iterator.hasNext()) {
				joFrame = iterator.next();
				filename = (String) joFrame.get("filename");
				filename = filename.substring(0, filename.length()-4);
				//System.out.print("{ sprite: \"dog_fish_sprite\", x: ");
				System.out.print("\'"+filename+"\': { sprite: \""+jName+"\", x: ");
				
				joFrameCoord = (JSONObject) joFrame.get("frame");
				System.out.print(joFrameCoord.get("x") + ", y: ");
				System.out.print(joFrameCoord.get("y") + ", w: ");
				long w = (Long) joFrameCoord.get("w");
				System.out.print(w + ", h: ");
				long h = (Long) joFrameCoord.get("h");
				System.out.print(h + ", xOffset: ");
				
				joSpriteSourceSize = (JSONObject) joFrame.get("spriteSourceSize");
				long dx = (Long) joSpriteSourceSize.get("x");
				if(res==1 || res == 3){
					dx = dx - 30;
				}
				System.out.print(dx + ", yOffset: ");
				long dy = (Long) joSpriteSourceSize.get("y");
				//System.out.println(dy + " },//"+filename);
				if(res==1 || res == 3){
					dy = dy - 46;
				}
				System.out.println(dy + " },");
			}
		
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
}
