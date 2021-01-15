package cse3040ex1704;

import java.util.Stack;

public class Ex17_04 {
	public static Stack<String> back = new Stack<>();
	public static Stack<String> forward = new Stack<>();
	public static void main(String[] args) {
		goURL("1. Google");
		goURL("2. Facebook");
		goURL("3. Naver");
		goURL("4. Daum");
		printStatus();
        goBack();
        
		System.out.println("=== After pushing 'back' ===");
		printStatus();
		goBack();

		System.out.println("=== After pushing 'back' ===");
		printStatus();
		goForward();
        
		System.out.println("=== After pushing 'forward' ===");
		printStatus();
		goURL("www.ABC.co.kr");
		System.out.println("=== After moving to a new URL ===");
		printStatus();
	}

// printStatue는 back과 forward state의 성분을 보는 것이다. 그리고 current page를 보는 것이다.
	public static void printStatus() {
		System.out.println("back:"+back);
		System.out.println("forward:"+forward);
		System.out.println("current page is " + back.peek() + ".");
		System.out.println();
	}
    
    // back에 모든 url을 넣고 forward는 비워준다.
	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty()) forward.clear();
	}
    
    // forward에서 데이터를 빼내고 push에 데이터를 넣는다.
	public static void goForward() {
		if(!forward.empty()) back.push(forward.pop());
	}
    
    // back에서 데이터를 빼내고 push에 데이터를 넣는다.
	public static void goBack() {
		if(!back.empty()) forward.push(back.pop());
	}
}
