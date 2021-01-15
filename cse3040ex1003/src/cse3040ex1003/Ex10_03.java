package cse3040ex1003;

class Employee {
	private String name;
	protected int salary;

	public Employee() {
		this.name = "NoName";
		this.salary = 100000;
	}
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	public int getSalary() {return this.salary;}
	public void setSalary(int salary) {this.salary = salary;}
}

class Manager extends Employee{
	private int bonus = 50000;
	public void setBonus(int bonus) {this.bonus = bonus;}
	public int getSalary() {
		return super.getSalary()+bonus;
	}
}
public class Ex10_03 {
	public static void main(String[] args) {
		Manager m = new Manager();
		System.out.println(m.getName()+" "+m.getSalary());
		Employee e = new Employee();
		System.out.println(e.getName()+" "+e.getSalary());
	}
}
