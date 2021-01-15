package cse3040;

public class Ex1_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = 125;
		for(int i = 1;i<=10;++i) {
			//print 와 println의 차이는 다음줄로 넘어가냐 안가냐 차이
			System.out.print(" "+b++);
		}
	}
}