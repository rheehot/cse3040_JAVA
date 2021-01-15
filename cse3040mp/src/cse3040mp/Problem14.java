package cse3040mp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;


class Fruit{
	private String name;
	private double price;
	Fruit(String name,double price){
		this.name=name;
		this.price=price;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
}
class FruitBox<T extends Fruit> extends Fruit{
	private HashMap<String, Double> map;
	FruitBox(){
		super("",0);
		map = new HashMap<String, Double>();
	}
	public void add(T data) {
		map.put(data.getName(), data.getPrice());
		System.out.println(data.getName()+" "+ data.getPrice());
	}
	public int getNumItems() {
		return map.size();
	}
	public String getMaxItem() {
		String ans="";
		double maxVal=0;
		for(Entry<String,Double> entry : map.entrySet()) {
			if(entry.getValue()>maxVal) {
				ans=entry.getKey();
				maxVal=entry.getValue();
			}
		}
		return ans;
	}
	public double getMaxPrice() {
		double maxVal=0;
		for(Entry<String,Double> entry : map.entrySet()) {
			if(entry.getValue()>maxVal) {
				maxVal=entry.getValue();
			}
		}
		return maxVal;
	}
	public String getMinItem() {
		String ans="";
		double minVal=-1;
		for(Entry<String,Double> entry : map.entrySet()) {
			if(entry.getValue()<minVal || minVal==-1) {
				ans=entry.getKey();
				minVal=entry.getValue();
			}
		}
		return ans;
	}
	public double getMinPrice() {
		double minVal=-1;
		for(Entry<String,Double> entry : map.entrySet()) {
			if(entry.getValue()<minVal || minVal==-1) {
				minVal=entry.getValue();
			}
		}
		return minVal;
	}
	public double getAvgPrice() {
		double avg=0;
		for(Entry<String,Double> entry : map.entrySet()) {
			avg+=entry.getValue();
		}
		return avg/getNumItems();
	}
}

class ItemReader extends FruitBox<Fruit>{
	private static BufferedReader br;
	public static boolean fileToBox(String file,FruitBox<Fruit> box) {
		try {
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e) {
			System.out.println("Input file not found.");
			return false;
		}
		
		while(true) {
			try {
				String line = br.readLine();
				if(line==null) break;
				String[] tmp=line.split(" ");
				box.add(new Fruit(tmp[0],Double.parseDouble(tmp[1])));
			}catch(Exception e) {
				e.printStackTrace();
				break;
			}
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

public class Problem14 {
	public static void main(String[] args) {
		FruitBox<Fruit> box = new FruitBox<>();
		boolean rv = ItemReader.fileToBox("input_prob14.txt", box);
		if (rv == false)
			return;
		box.add(new Fruit("orange", 9.99));
		System.out.println("----------------");
		System.out.println(" Summary");
		System.out.println("----------------");
		System.out.println("number of items: " + box.getNumItems());
		System.out.println("most expensive item: " + box.getMaxItem() + " (" + box.getMaxPrice() + ")");
		System.out.println("cheapest item: " + box.getMinItem() + " (" + box.getMinPrice() + ")");
		System.out.printf("average price of items: %.2f", box.getAvgPrice());
	}
}