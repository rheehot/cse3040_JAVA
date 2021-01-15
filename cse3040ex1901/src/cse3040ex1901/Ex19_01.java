package cse3040ex1901;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex19_01 {
	public static void main(String[] args) {
		String strArr[] = {"1","1","2","2","3","3","4","4","4"};
		List<String> set = new ArrayList<>();
		for(int i = 0 ; i<strArr.length;++i) {
			set.add(strArr[i]);
		}
		System.out.println(set);
	}
}
