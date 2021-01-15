package cse3040ex1702;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Ex17_02 {
	public static void main(String args[]) {
	    //ArrayList는 따로 공간 할당
			ArrayList<String> al = new ArrayList<>(1000000);
			LinkedList<String> ll = new LinkedList<>();
			add(al);
			add(ll);
	        //Access Time 측정
			System.out.println("=== access time ===");
			System.out.println("ArrayList : " + access(al));
			System.out.println("LinkedList: " + access(ll));
		}
	
	    //List 객체는 superclass이기에 AL, LL 모두 삽입가능
		public static void add(List<String> list) {
			for(int i=0; i<100000; i++) list.add(i+"");
		}
	    //list의 i번째 값을 가져오는 기능만 존재
		public static long access(List<String> list) {
			long start = System.currentTimeMillis();
			for(int i=0; i<10000; i++) list.get(i);
			long end = System.currentTimeMillis();
			return end - start;
		}
}
