package cse3040cs06;

public class Ex06_07 {
	public static void main(String[] args) {
		int a[][] = {{10,11,12},{20,21,22},{30,31,32},{40,41,42}};
		int i,j,hab;
		
		System.out.println("a.length: "+a.length);
		System.out.println("a[0].length: "+a[0].length);
	
		for(i=0;i<a.length;++i) {
			hab=0;
			for(j=0;j<a[0].length;++j) {
				System.out.print(a[i][j]+" ");
				hab+=a[i][j];
			}
			System.out.println(" "+hab);
		}
	}
}