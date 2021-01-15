package cse3040cs04;

public class Ex04_1 {

	public static void main(String[] args) {
		int x = 30, y= 10,z;
		String op;
		
		System.out.println("x: "+x+" y: "+y);
		
		op = "+";
		if(op.equals("+")) z= x+y;
		else z=x-y;
		System.out.println("z: "+z);
		
		op = "-";
		z = (op.equals("+"))? x+y:x-y;
		System.out.println("z: "+z);
	}
}
