package cse3040hw2;

class Point{
	private double[] ch_d;
	Point(double[] arr){
		ch_d= new double[arr.length];
		ch_d=arr;
	}
	public double ch_getSize() { 
		return this.ch_d.length;
	}
	public double ch_getData(int i) {
		return ch_d[i];
	}
}
class EuclideanDistance{
	public static double getDist(Point ch_p1,Point ch_p2) {
		if(ch_p1==null) return -1;
		if(ch_p2==null) return -1;
		if(ch_p1.ch_getSize()!=ch_p2.ch_getSize()) return -1;
		double ans=0;
		for(int i = 0 ; i<ch_p1.ch_getSize();++i) {
			ans+=Math.pow(ch_p1.ch_getData(i)-ch_p2.ch_getData(i),2);
		}
		return Math.sqrt(ans);
	}
}
class ManhattanDistance{
	public static double getDist(Point ch_p1,Point ch_p2) {
		if(ch_p1==null) return -1;
		if(ch_p2==null) return -1;
		if(ch_p1.ch_getSize()!=ch_p2.ch_getSize()) return -1;
		double ans=0;
		for(int i = 0 ; i<ch_p1.ch_getSize();++i) {
			ans+=Math.abs(ch_p1.ch_getData(i)-ch_p2.ch_getData(i));
		}
		return ans;
	}
}
	
public class Problem09 {
	public static void main(String[] args) {
		Point p1 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p2 = new Point(new double[] { 4.0, 5.0, 6.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
		Point p3 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p4 = new Point(new double[] { 4.0, 5.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4));
	}
}