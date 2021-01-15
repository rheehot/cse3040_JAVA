package cse3040ex2003;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex20_03 {
	static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<>();
    
	public static void main(String[] args) {
		addPhoneNo("friend", "Lee Java", "010-111-1111");
		addPhoneNo("friend", "Kim Java", "010-222-2222");
		addPhoneNo("friend", "Kim Java", "010-333-3333");
		addPhoneNo("work", "Kim Daeri", "010-444-4444");
		addPhoneNo("work", "Kim Daeri", "010-555-5555");
		addPhoneNo("work", "Park Daeri", "010-666-6666");
		addPhoneNo("work", "Lee Guajang", "010-777-7777");
		addPhoneNo("laundary", "010-888-8888");
        // 들어가 있는 정보 모두 출력함
		printList();
	}
    
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap<String,String> group = phoneBook.get(groupName);
        
		// 핸드폰 번호는 모두 다를 가능성이 이름에 비해 많기 때문에 전화번호를 key로 하고 value를 이름으로 작성했다.
        group.put(tel, name); 
	}
    
    // 같은 groupName이 없다면 phoneBook에 삽입한다.
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) phoneBook.put(groupName, new HashMap<String,String>());
	} 
    
    // 매개변수가 2개인 경우의 삽입
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("others", name, tel);
	}
    
    // printList를 통하여 모든 Entry를 출력한다.
	static void printList() {
		Set<Map.Entry<String,HashMap<String,String>>> set = phoneBook.entrySet();
		Iterator<Map.Entry<String,HashMap<String,String>>> it = set.iterator();
        
		while(it.hasNext()) {
        	//3개의 데이터를 가져온다.
			Map.Entry<String,HashMap<String,String>> e = (Map.Entry<String,HashMap<String,String>>)it.next();
            //가져온 데이터들을 또 작게 나눈다.
			Set<Map.Entry<String,String>> subset = e.getValue().entrySet();
			Iterator<Map.Entry<String,String>> subIt = subset.iterator();
			System.out.println(" * " + e.getKey() + "[" + subset.size() + "]");
            
			while(subIt.hasNext()) {
				Map.Entry<String,String> subE = (Map.Entry<String,String>)subIt.next();
				String telNo = subE.getKey();
				String name = subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	}
}
