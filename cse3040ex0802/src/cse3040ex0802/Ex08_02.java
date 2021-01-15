package cse3040ex0802;

class Employee{
	private static int LastId=0;
	private int id;
	public Employee() {id=++LastId;}
	public int getId() {return this.id;}
	public static int getLastId() {return LastId;}
}

public class Ex08_02 {
	public static void main(String[] args) {
		Employee m = new Employee();
		Employee n = new Employee();
		
		System.out.println(m.getId());
		System.out.println(n.getId());
		System.out.println(Employee.getLastId());
		System.out.println(Employee.getLastId());
	}
}