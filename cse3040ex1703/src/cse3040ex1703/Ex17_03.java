package cse3040ex1703;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex17_03 {
	public static void main(String[] args) {
	    // Stack은 class라서 바로 사용
			Stack<String> st = new Stack<String>();
	    // Queue는 interface이기에 LinkedList 를 사용
			Queue<String> q = new LinkedList<String>();
	    
	    // 스택에 데이터 삽입
			st.push("0");
			st.push("1");
			st.push("2");
	        
	    // 큐에 데이터 삽입
			q.offer("0");
			q.offer("1");
			q.offer("2");
	        
			System.out.println("=== Stack ===");
			while(!st.empty()) System.out.println(st.pop());
	        
			System.out.println("=== Queue ===");
			while(!q.isEmpty()) System.out.println(q.poll());
	}
}
