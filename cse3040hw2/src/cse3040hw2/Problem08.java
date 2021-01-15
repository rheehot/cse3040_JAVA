package cse3040hw2;

interface Shape {
	public abstract double sum();
}

class Circle implements Shape {
	private double ch_r;

	Circle(double ch_r) {
		this.ch_r = ch_r;
	}

	public double sum() {
		return Math.pow(ch_r, 2)* Math.PI;
	}
}

class Square implements Shape {
	private double ch_l;

	Square(double ch_l) {
		this.ch_l = ch_l;
	}

	public double sum() {
		return ch_l*ch_l;
	}
}

class Rectangle implements Shape {
	private double ch_w, ch_h;

	Rectangle(double ch_w, double ch_h) {
		this.ch_w = ch_w;
		this.ch_h = ch_h;
	}

	public double sum() {
		return ch_w * ch_h;
	}
}

public class Problem08 {
	public static double sumArea(Shape[] arr) {
		double ans = 0;
		for (int i = 0; i < arr.length; ++i) {
			ans += arr[i].sum();
		}
		return ans;
	}

	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Square(4.0), new Rectangle(3.0, 4.0), new Square(5.0) };
		System.out.println("Total area of the shapes is: " + sumArea(arr));
	}
}