package cse3040ex1705;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Ex17_05 {
	// Queue의 선언
		static Queue<String> q = new LinkedList<String>();
		static final int MAX_SIZE = 5;

		public static void main(String[] args) {
			System.out.println("input 'help' to display help message.");
			while(true) {
				System.out.print(">>");
				try {
	            //사용자에게 입력을 받음
					Scanner s = new Scanner(System.in);
	                // 사용자에게 받은 입력 마지막에 있는 스페이스바를 없애줌
					String input = s.nextLine().trim();
	                // 사용자 입력이 없다면 재 실행
					if("".equals(input)) continue;
	                // q를 입력시 시스템 종료
					if(input.equalsIgnoreCase("q")) {
						s.close();
						System.exit(0);
	                // help 입력시 내용을 출력
					} else if(input.equalsIgnoreCase("help")) {
						System.out.println(" help – displays help message.");
						System.out.println(" q or Q – exit the program.");
						System.out.println(" history – shows recent commands.");
					}
	                // history 입력시 그동알 쳤던 입력들을 출력
	            	else if(input.equalsIgnoreCase("history")) {
						int i=0;
						save(input);
						LinkedList<String> tmp = (LinkedList<String>)q;
						ListIterator<String> it = tmp.listIterator();
						while(it.hasNext()) System.out.println(++i+"."+it.next());
					} else {
						save(input);
						System.out.println(input);
					}
				} catch(Exception e) { System.out.println("input error."); }
			}
		}
	    
	    // 입력값들을 저장
		public static void save(String input) {
			if(!"".equals(input)) q.offer(input);
			if(q.size() > MAX_SIZE) q.remove();
		}
}
