package cse3040;

public class Ex01_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 0;
		double d = 0;
		for(int i = 1;i<=100000;++i) {
			f+=100000;
			d+=100000;
		}
		//float�� ���� �����ϱ⿡�� �ʹ� Ŀ�� ����� ������� ����
		System.out.println("float : "+f/100000.0);
		System.out.println("doubel : "+d/100000.0);
	}

}
