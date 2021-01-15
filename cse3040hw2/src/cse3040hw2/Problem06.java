package cse3040hw2;

interface IntSequence{
	boolean hasNext();
	int next();
}

class FibonacciSequence implements IntSequence{
	private int ch_n;
	private int ch_pn;
	private int ch_ppn;
	public FibonacciSequence() {
		ch_n=-1;
		ch_pn=1;
		ch_ppn=0;
	}
	public boolean hasNext() {
		return (ch_n++)!=20;
	}
	public int next() {
		if(ch_n==0) return 0;
		if(ch_n==1) return 1;
		int ch_ans = ch_pn+ch_ppn;
		ch_ppn=ch_pn;
		ch_pn=ch_ans;
		return ch_ans;
	}
}

public class Problem06 {
	public static void main(String[] args) {
		IntSequence seq = new FibonacciSequence();
		for (int i = 0; i < 20; i++) {
			if (seq.hasNext() == false)
				break;
			System.out.print(seq.next() + " ");
		}
		System.out.println(" ");
	}
}