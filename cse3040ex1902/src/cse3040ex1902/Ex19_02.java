package cse3040ex1902;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Ex19_02 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		for(;set.size()<6;) {
			int num=(int)(Math.random()*45)+1;
			set.add(Integer.valueOf(num));
		}
		//List<Integer> list = new LinkedList<>(set);
		//Collections.sort(list);
		//System.out.println(list);
	}
}
