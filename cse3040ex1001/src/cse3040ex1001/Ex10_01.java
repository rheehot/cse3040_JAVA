package cse3040ex1001;

interface Person{
	String getName();
	default int getId() {return 0;}
}
interface Identified{
	String getName();
	default int getId() {return 0;}
}
class Employee implements Person, Identified{
	private String name;
	public Employee(String name) {this.name=name;}
	public String getName() {return this.name;}
	public int getId() {return 2;}
	
}
public class Ex10_01 {
	public static void main(String[] args) {
		Employee m = new Employee("Peter");
		System.out.println(m.getId());
	}
}
