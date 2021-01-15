package cse3040cs06;

public class Ex06_01 {
	public static void main(String[] args) {
		int n[] = new int[3];
		double d[] = new double[3];
		boolean b[] = new boolean[3];
		String s[] = new String[3];
		
		n[2] = 100;
		d[2] = 1.23;
		b[2] = true;
		s[2] = "Java JaBa";
		
		System.out.println("int\tdouble\tboolean\tString");
		
		for(int i = 0 ; i<3;++i) {
			System.out.println(" "+n[i]+'\t'+d[i]+'\t'+b[i]+'\t'+s[i]);;
		}
		
	}
}
