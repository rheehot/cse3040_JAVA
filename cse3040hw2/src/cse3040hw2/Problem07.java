package cse3040hw2;

import java.util.Scanner;

interface IntSequenceStr{
	abstract public boolean hasNext();
	abstract public int next();
}

class BinarySequenceStr implements IntSequenceStr{
	private int ch_n;
	private double ch_p;
	BinarySequenceStr(int ch_n){
		this.ch_n=ch_n;
		ch_p=Math.pow(2, 23);
		while(ch_p!=0) {
			if((this.ch_n & (int)ch_p)>0) break;
			ch_p/=2;
		}
	}
	public boolean hasNext() {
		return ch_p>=1;
	}
	public int next() {
		int ch_temp = this.ch_n & (int)ch_p;
		ch_p/=2;
		return ch_temp>0?1:0;
	}
}

public class Problem07 {
	 public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
	 System.out.print("Enter a positive integer: ");
	 String str = in.nextLine();
	 int num = Integer.parseInt(str);
	 in.close();
	 System.out.println("Integer: " + num);
	 IntSequenceStr seq = new BinarySequenceStr(num);
	 System.out.print("Binary number: ");
	 while(seq.hasNext()) System.out.print(seq.next());
	 System.out.println(" ");
	 }
	}