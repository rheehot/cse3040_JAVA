package cse3040ex1801;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Ex18_01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator<String> it =list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		
		ListIterator<String> it2 = list.listIterator();
		while(it2.hasNext()) {
			System.out.print(it2.next());
		}
		System.out.println();
		while(it2.hasPrevious()) {
			System.out.print(it2.previous());
		}
		
	}
}
