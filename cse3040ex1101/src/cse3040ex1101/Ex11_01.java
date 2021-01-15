package cse3040ex1101;

class Employee{
	private String name;
	private int salary;
	public Employee(String name,int salary) {
		this.name=name;
		this.salary = salary;
	}
	public void setName(String name) {this.name=name;}
	public String getName() {return this.name;}
	public int getSalary() {return this.salary;}
}

class Manager extends Employee{
	private int bonus;
	public Manager() {
		super("NoName(Manager)",100000);
		bonus=10000;
	}
	public void setBonus(int bonus) {this.bonus=bonus;}
	public int getSalary() {return super.getSalary()+this.bonus;}
}
public class Ex11_01 {
	public static void main(String[] args) {
		Employee m = new Manager();
		if(m instanceof Manager) {
			Manager mgr=(Manager)m;
			mgr.setBonus(20000);
		}
		System.out.println(m.getName());
		System.out.println(m.getSalary());
	}
}
