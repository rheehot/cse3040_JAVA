package cse3040ex0702;

class Employee{
	private String name;
	private int salary;
	
	public Employee() {
		this.name="Employee";
		this.salary=50000;
	}
	public Employee(String name) {
		this.name = name;
		this.salary=50000;
	}
	public Employee(String name,int salary) {
		this.name = name;
		this.salary=salary;
	}
	
	//instance methods
	public String getName() {
		return this.name;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public int getSalary() {
		return this.salary;
	}
}