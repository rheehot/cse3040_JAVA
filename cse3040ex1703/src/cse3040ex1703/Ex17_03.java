package cse3040ex1703;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex17_03 {
	public static void main(String[] args) {
	    // Stack�� class�� �ٷ� ���
			Stack<String> st = new Stack<String>();
	    // Queue�� interface�̱⿡ LinkedList �� ���
			Queue<String> q = new LinkedList<String>();
	    
	    // ���ÿ� ������ ����
			st.push("0");
			st.push("1");
			st.push("2");
	        
	    // ť�� ������ ����
			q.offer("0");
			q.offer("1");
			q.offer("2");
	        
			System.out.println("=== Stack ===");
			while(!st.empty()) System.out.println(st.pop());
	        
			System.out.println("=== Queue ===");
			while(!q.isEmpty()) System.out.println(q.poll());
	}
}
