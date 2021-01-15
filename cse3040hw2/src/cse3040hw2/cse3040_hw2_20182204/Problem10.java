package cse3040hw2;

class Points {
	private double[] ch_arr;

	Points(double[] arr) {
		this.ch_arr = new double[arr.length];
		this.ch_arr = arr;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(getClass() != obj.getClass()) return false;
		double t1=0,t2=0;
		Points objTemp=(Points)obj;
		
		for(int i = 0 ; i<ch_arr.length;++i) {
			t1+=ch_arr[i];
		}
		for(int i = 0 ; i<objTemp.ch_getLength();++i) {
			t2+=objTemp.ch_getData(i);
		}
		return t1==t2;
	}
	public String toString() {
		double ans=0;
		for(int i = 0;i<ch_arr.length;++i) {
			ans+=ch_arr[i];
		}
		return "[sum of points: "+ans+"]";
	}
	public double ch_getData(int i) { 
		return ch_arr[i];
	}
	public int ch_getLength() {
		return ch_arr.length;
	}

}

public class Problem10 {
	public static void main(String[] args) {
		Points p1 = new Points(new double[] { 1.0, 2.0, 3.0 });
		Points p2 = new Points(new double[] { 4.0, 5.0, 6.0 });
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));
		Points p3 = new Points(new double[] { 1.0, 4.0, 7.0 });
		Points p4 = new Points(new double[] { 3.0, 9.0 });
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p3.equals(p4));
		Points p5 = new Points(new double[] { 1.0, 2.0 });
		Points p6 = null;
		System.out.println(p5);
		System.out.println(p6);
		System.out.println(p5.equals(p6));
	}
}