package cse3040mp2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class chMap extends TreeMap<String, Double>{
	@Override
	public String toString() {
		String result="";
		Iterator<Map.Entry<String, Double>> it = super.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Double> entry = it.next();
			result+=(entry.getKey()+" "+entry.getValue()+"\n");
		}
		return result;
	}
}

class MapManager {	
	public static Map<String, Double> readData(String path){
		Map<String,Double> hm= new chMap();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
		}catch(IOException e) {
			return null;
		}
		
		while(true) {
			try {
				String line = br.readLine();
				if(line == null) break;
				String[] buffer = line.split(" ");
				hm.put(buffer[0],Double.parseDouble(buffer[1]));
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return hm;
	}
}


public class Problem17 {
	public static void main(String args[]) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if (map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
}
