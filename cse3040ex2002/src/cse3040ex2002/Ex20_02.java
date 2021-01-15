package cse3040ex2002;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex20_02 {
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("Kim Java", Integer.valueOf(90));
		map.put("Kim Java", Integer.valueOf(100));
		map.put("Lee Java", Integer.valueOf(100));
		map.put("Kang Java", Integer.valueOf(80));
		map.put("Ahn Java", Integer.valueOf(90));

		Set<Map.Entry<String,Integer>> set = map.entrySet();
		Iterator<Map.Entry<String,Integer>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String,Integer> e = (Map.Entry<String,Integer>)it.next();
			System.out.println("name: " + e.getKey() + ", score: " + e.getValue());
		}

		Set<String> keys = map.keySet();
		System.out.println("participants: " + keys);
		Collection<Integer> values = map.values();
		Iterator<Integer> it2 = values.iterator();
		int total = 0;

		while(it2.hasNext()) {
			Integer i = (Integer)it2.next();
			total += i.intValue();
		}
		System.out.println("total: " + total);
		System.out.println("average: " + (float)total/set.size());
		System.out.println("max: " + Collections.max(values));
		System.out.println("min: " + Collections.min(values));
	}
}
