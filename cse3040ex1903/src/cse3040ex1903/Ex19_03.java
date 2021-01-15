package cse3040ex1903;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex19_03 {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		int[][] board = new int[5][5];
		for(;set.size()<25;) {
			set.add((int)(Math.random()*50)+1+"");
		}
		
		Iterator<String> it = set.iterator();
		for(int i = 0 ;i<board.length;++i) {
			for(int j = 0;j<board[i].length;++j) {
				board[i][j] = Integer.parseInt(it.next());
				System.out.print((board[i][j]<10?"  ":" ")+board[i][j]);
			}
			System.out.println();
		}
	}
}
