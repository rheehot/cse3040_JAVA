package cse3040mp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Item{
	private String word;
	private int count;
	Item(String word,int count){
		this.word=word;
		this.count=count;
	}
	public void setWord(String word) {
		this.word=word;
	}
	public void setCount(int count) {
		this.count=count;
	}
	public String getWord() {
		return word;
	}
	public int getCount() {
		return count;
	}
	public String toString() {return word+" "+Integer.toString(count);}
}
class MyFileReader{
	private static BufferedReader br;
	public static boolean readDataFromFile(String str, ArrayList<Item> list) {
		try {
			br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e1) {
			return false;
		}
		
		try {
			while(true) {
				String line = br.readLine();
				boolean flag=true;
				if(line==null) break;
				
				String tmp[]= line.toLowerCase().split(" ");
				for(String data : tmp) {
					flag=true;
					for(int it=0; it<list.size();++it) {
						if(list.get(it).getWord().equals(data)) {
							list.get(it).setCount(list.get(it).getCount()+1);
							flag=false;
							break;
						}
					}
					if(flag) list.add(new Item(data,1));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
}

public class Problem15 {
	public static void main(String[] args) {
		ArrayList<Item> list = new ArrayList<>();
		boolean rv = MyFileReader.readDataFromFile("input_prob15.txt", list);
		if (rv == false) {
			System.out.println("Input file not found.");
			return;
		}
		for (Item it : list)
			System.out.println(it);
	}
}