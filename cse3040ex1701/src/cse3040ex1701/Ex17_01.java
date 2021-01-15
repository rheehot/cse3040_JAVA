package cse3040ex1701;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex17_01 {
	static long add1(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0;i<1000000;++i) list.add(i+"");
		long end = System.currentTimeMillis();
		return end-start;			
	}
	static long add2(List<String> list) {
		long start =System.currentTimeMillis();
		for(int i = 0 ; i<10000;++i) list.add(500,"x");
		long end = System.currentTimeMillis();
		return end-start;
	}
	static long remove1(List<String> list) {
		long start =System.currentTimeMillis();
		for(int i = list.size()-1 ; i>=0;--i) list.remove(i);
		long end = System.currentTimeMillis();
		return end-start;
	}
	static long remove2(List<String> list) {
		long start =System.currentTimeMillis();
		for(int i = 0 ; i<10000;++i) list.remove(i);
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>(2000000);
		LinkedList<String> ll = new LinkedList<>();
		System.out.println("=== sequential add ===");
		System.out.println("ArraList : " + add1(al));
		System.out.println("LinkedList: " + add1(ll));
		System.out.println();
		System.out.println("=== non-sequential add ===");
		System.out.println("ArraList : " + add2(al));
		System.out.println("LinkedList: " + add2(ll));
		System.out.println();
		System.out.println("=== non-sequential delete ===");
		System.out.println("ArraList : " + remove2(al));
		System.out.println("LinkedList: " + remove2(ll));
		System.out.println();
		System.out.println("=== sequential delete ===");
		System.out.println("ArraList : " + remove1(al));
		System.out.println("LinkedList: " + remove1(ll));
	}
}
