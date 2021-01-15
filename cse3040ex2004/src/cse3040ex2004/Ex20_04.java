package cse3040ex2004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ex20_04 {
	public static void main(String[] args) {
		String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};
		TreeMap<String,Integer> map = new TreeMap<>();
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = map.get(data[i]);
				map.put(data[i], Integer.valueOf(value.intValue() + 1));
			} else {
				map.put(data[i], Integer.valueOf(1));
			}
		}
        
		Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
		System.out.println("=== basic sort ===");
		while(it.hasNext()) {
			Map.Entry<String,Integer> entry = it.next();
			int value = entry.getValue().intValue();
			System.out.println(entry.getKey() + ": " + printBar('#', value) + " " + value);
		}
		System.out.println();
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		List<Map.Entry<String,Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new ValueComparator<Map.Entry<String,Integer>>());
		it = list.iterator();
        
        // 차이점이 이렇게 sort를 했다는 차이점이 존재한다.
		System.out.println("=== sort by the value ===");
		while(it.hasNext()) {
			Map.Entry<String,Integer> entry = it.next();
			int value = entry.getValue().intValue();
			System.out.println(entry.getKey() + ": " + printBar('#', value) + " " + value);
		}
	}
    
	// inner class
	@SuppressWarnings("unchecked") // anotation으로 경고가 나오지 말라고 하는 것
	static class ValueComparator<T> implements Comparator<T> {
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry<String,Integer> e1 = (Map.Entry<String, Integer>)o1;
				Map.Entry<String,Integer> e2 = (Map.Entry<String, Integer>)o2;
				int v1 = e1.getValue().intValue();
				int v2 = e2.getValue().intValue();
				return v2 - v1;
			}
			return -1;
		}
	}
    
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		for(int i=0; i<bar.length; i++) bar[i] = ch;
		return new String(bar);
	}
}
