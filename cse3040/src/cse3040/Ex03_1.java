package cse3040;

public class Ex03_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		System.out.println("x: "+x);
		
		for(int i = 1;i<=3;++i) {
			System.out.print("x: "+ x++ + " ");
		}
		System.out.println("\nx: "+ x);
	}

}
