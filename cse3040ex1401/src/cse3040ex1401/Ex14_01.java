package cse3040ex1401;

class A { public String toString() { return "Class A Object";}}
class B { public String toString() { return "Class B Object";}}
class C { public String toString() { return "Class C Object";}}

class Box<T>{
	T item;
	void setItem(T item) {this.item = item;}
	public T getItem() {return item;}
}


public class Ex14_01 {
	public static void main(String[] args) {
		//Box<A>[] boxarray = new Box<A>[5];
		
		Box<A> boxa=new Box<A>();
		boxa.setItem(new A());
		Box<B> boxb = new Box<B>();
		boxb.setItem(new B());
		Box<C> boxc = new Box<C>();
		boxc.setItem(new C());
		System.out.println(boxa.getItem());
		System.out.println(boxb.getItem());
		System.out.println(boxc.getItem());
	}
}
