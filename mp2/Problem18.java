package cse3040mp18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("serial")
class chMap extends TreeMap<String, Double> {
	@Override
	public String toString() {
		String ans = "";
		Set<Map.Entry<String, Double>> set = super.entrySet();
		List<Map.Entry<String, Double>> list = new ArrayList<>(set);
		Collections.sort(list, new ValueComparator<Map.Entry<String, Double>>());

		Iterator<Map.Entry<String, Double>> it = list.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Double> ent = it.next();
			ans += ent.getKey() + " " + ent.getValue() + "\n";
		}
		return ans;
	}

	@SuppressWarnings("unchecked")
	class ValueComparator<T> implements Comparator<T> {
		@Override
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Object && o2 instanceof Object) {
				Map.Entry<String, Double> e1 = (Map.Entry<String, Double>) o1;
				Map.Entry<String, Double> e2 = (Map.Entry<String, Double>) o2;
				if (e1.getValue() < e2.getValue())
					return -1;
				else if (e1.getValue() > e2.getValue())
					return 1;
				else {
					return e1.getKey().compareTo(e2.getKey());
				}
			}
			return -1;
		}

	}
}

class MapManager {
	@SuppressWarnings("resource")
	public static Map<String, Double> readData(String str) {
		Map<String, Double> map = new chMap();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(str));
		} catch (IOException e) {
			return null;
		}

		try {
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				String buffer[] = line.split(" ");
				map.put(buffer[0], Double.parseDouble(buffer[1]));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return map;

	}
}

public class Problem18 {
	public static void main(String args[]) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if (map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
}