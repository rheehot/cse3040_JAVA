package cse3040ex0801;

class Employee{
	private String name;
	public Employee(String name) {this.name=name;}
	public String getName() {return this.name;}
}
public class Ex08_01 {
	public static void main(String[] args) {
		Employee e[] = new Employee[5];
		e[0] = new Employee("Kim");
		e[1] = new Employee("Lee");
		e[2] = new Employee("Park");
		e[3] = new Employee("Choi");
		e[4] = new Employee("Chung");
		
		for(int i = 0 ; i<5;++i) {
			System.out.println(e[i].getName());
		}
	}
}
