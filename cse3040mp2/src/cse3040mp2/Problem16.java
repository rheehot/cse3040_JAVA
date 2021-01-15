package cse3040mp2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Element implements Comparable<Element>{
	private String name;
	private double val;
	Element(String name, double val){
		this.name=name;
		this.val=val;
	}
	public String getName() {return name;}
	public double getVal() {return val;}
	
	@Override
	public int compareTo(Element o) {
		if(this.val<o.val) return -1;
		if(this.val>o.val)return 1; 
		return this.name.compareTo(o.getName());
	}
	public String toString() {
		return name+" "+val;
	}
}

class ElementReader{
	private static BufferedReader br;
	public static ArrayList<Element> readElements(String path) {
		ArrayList<Element> temp = new ArrayList<>();
		try {
			br=new BufferedReader(new FileReader(path));
		}catch(IOException e) {
			System.out.println("Input file not found.");
			return null;
		}
		
		while(true) {
			try {	
				String line = br.readLine();
				if(line==null) break;
				String buffer[]=line.split(" ");
				temp.add(new Element(buffer[0],Double.parseDouble(buffer[1])));
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
		return temp;
	}
}

public class Problem16 {
	public static void main(String args[]) {
		ArrayList<Element> list = ElementReader.readElements("input.txt");
		if (list == null) {
			System.out.println("Input file not found.");
			return;
		}
		Collections.sort(list);
		Iterator<Element> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
